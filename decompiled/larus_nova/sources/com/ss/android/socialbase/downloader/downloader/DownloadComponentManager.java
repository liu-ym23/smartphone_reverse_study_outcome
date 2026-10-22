package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.RouteInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.GlobalListenerAdaptor;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.impls.NewDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadThreadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.service.IDownloadMultiProcService;
import com.ss.android.socialbase.downloader.service.IDownloadNetworkService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadComponentManager {
    public static final int NET_LIB_DEFAULT = 0;
    public static final int NET_LIB_HOST = 1;
    public static final int NET_LIB_NO_BACKUP = 2;
    public static final String SINGLE_THREAD_NAME = "DTP-Single";
    private static final String TAG = "DownloadComponentManager";
    private static volatile ExecutorService apkInstallThreadExecutor;
    private static volatile Context appContext;
    private static volatile ExecutorService chunkDownloadExecutor;
    private static volatile ExecutorService cpuThreadExecutor;
    private static volatile ExecutorService customThreadExecutor;
    private static volatile ExecutorService dbThreadExecutor;
    private static volatile IDownloadDns defaultDownloadDns;
    private static volatile IDownloadHttpService defaultHttpService;
    private static volatile IDownloadCache downloadCache;
    private static final List<IDownloadCacheSyncStatusListener> downloadCacheSyncStatusListeners = null;
    private static final List<IDownloadCompleteHandler> downloadCompleteHandlers = null;
    private static volatile IDownloadDBListener downloadDBListener;
    private static volatile IDownloadDns downloadDns;
    private static volatile AbsDownloadEngine downloadEngine;
    private static InnerEventListener downloadEventListener;
    private static volatile boolean downloadInMultiProcess;
    private static volatile IDownloadInterceptor downloadInterceptor;
    private static volatile IDownloadLaunchHandler downloadLaunchHandler;
    private static volatile IDownloadMemoryInfoListener downloadMemoryInfoListener;
    private static volatile IDownloadMonitorListener downloadMonitorListener;
    private static volatile IDownloadNetworkHandler downloadNetworkHandler;
    private static volatile DownloadReceiver downloadReceiver;
    private static volatile IDownloadServiceHandler downloadServiceHandler;
    private static volatile IDownloadSettings downloadSettings;
    private static volatile IDownloadStatusListener downloadStatusListener;
    private static final List<IDownloadTaskExecuteListener> downloadTaskExecuteListeners = null;
    private static volatile ExecutorService fastThreadExecutor;
    private static final int fixedCPUPoolSize = 0;
    private static final int fixedDBPoolSize = 0;
    private static final int fixedIOPoolSize = 0;
    private static final int fixedMIXPoolSize = 0;
    private static volatile ExecutorService globalThrottleDownloadExecutor;
    private static volatile boolean hasInit;
    private static volatile IDownloadHttpService httpService;
    private static boolean httpServiceInit;
    private static volatile ITTNetHandler iTTNetHandler;
    private static volatile IDownloadServiceHandler independentDownloadServiceHandler;
    private static volatile IndependentHolderCreator independentHolderCreator;
    private static volatile ExecutorService ioThreadExecutor;
    private static boolean isReceiverRegistered;
    private static volatile IndependentHolderCreator mNormalDBIndependentHolderCreator;
    private static volatile ExecutorService mixApkDownloadExecutor;
    private static volatile ExecutorService mixDefaultDownloadExecutor;
    private static volatile ExecutorService mixFrequentDownloadExecutor;
    private static volatile IMonitorConfig monitorConfig;
    private static boolean needAutoRefreshUnSuccessTask;
    private static volatile INotificationClickCallback notificationClickCallback;
    private static volatile ExecutorService okHttpDispatcherExecutor;
    private static volatile List<ProcessCallback> processCallbacks;
    private static IReserveWifiStatusListener reserveWifiStatusListener;
    private static volatile OkHttpClient sOkHttpClient;
    private static volatile ScheduledExecutorService scheduledExecutor;
    private static volatile ExecutorService segmentThreadExecutor;
    private static volatile ExecutorService singleThreadExecutor;
    private static volatile IDownloadThreadCheckListener threadCheckListener;
    private static int writeBufferSize;

    public interface IndependentHolderCreator {

        /* JADX INFO: loaded from: classes6.dex */
        public interface OnMainProcessRebindErrorListener {
            void onRebindError();
        }

        ISqlDownloadCache createCache(OnMainProcessRebindErrorListener r100);

        IDownloadProxy createProxy();

        IDownloadServiceHandler createServiceHandler();
    }

    /* JADX INFO: loaded from: classes38.dex */
    public static class TargetInfo {
        final String host;
        final InetAddress target;

        public TargetInfo(InetAddress r100, String r101) {
            this.target = r100;
            this.host = r101;
        }
    }

    public static void enableLruCache() {
        DownloadUtils.setEnableLruCache(true);
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "enableLruCache", "Run");
        return;
    }

    public static void setNotAutoRebootService(boolean r100) {
    }

    static {
        processCallbacks = new CopyOnWriteArrayList();
        downloadInMultiProcess = false;
        sOkHttpClient = null;
        downloadCompleteHandlers = new ArrayList();
        isReceiverRegistered = false;
        int r100 = Runtime.getRuntime().availableProcessors() + 1;
        fixedCPUPoolSize = r100;
        fixedIOPoolSize = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        fixedMIXPoolSize = r100;
        fixedDBPoolSize = r100;
        writeBufferSize = DownloadConstants.TTNET_DEFAULT_BUFFER_SIZE;
        downloadCacheSyncStatusListeners = new ArrayList();
        downloadTaskExecuteListeners = new ArrayList();
        needAutoRefreshUnSuccessTask = true;
        hasInit = false;
        IDownloadMultiProcService r101 = (IDownloadMultiProcService) DownloadServiceManager.getService(IDownloadMultiProcService.class);
        if (r101 == null) goto L6;
        r101.registerIndependentServiceCreator();
        return;
    }

    public static OkHttpClient.Builder createDownloadClientBuilder() {
        OkHttpClient.Builder r100 = new OkHttpClient.Builder();
        int r101 = DownloadSetting.getGlobalSettings().optInt("connect_timeout", 30000);
        int r102 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.IO_TIMEOUT, 30000);
        long r103 = r101;
        TimeUnit r104 = TimeUnit.MILLISECONDS;
        long r105 = r102;
        r100.connectTimeout(r103, r104).readTimeout(r105, r104).writeTimeout(r105, r104).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (okHttpDispatcherExecutor == null) goto L5;
        r100.dispatcher(new Dispatcher(okHttpDispatcherExecutor));
    L5:
        return r100;
    }

    public static void ensureOPPO() {
        if (TextUtils.isEmpty(DownloadConstants.LOWER_OPPO) == false) goto L6;
        DownloadConstants.LOWER_OPPO = AppConstants.CHANNEL_OPPO;
        DownloadConstants.UPPER_OPPO = DownloadConstants.LOWER_OPPO.toUpperCase();
        return;
    }

    public static ExecutorService getApkInstallThreadExecutor() {
        if (apkInstallThreadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (apkInstallThreadExecutor == null) goto L9;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
        goto L24
    L9:
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r100 = 15;
    L12:
        PThreadPoolExecutor r101 = new PThreadPoolExecutor(2, 2, r100, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-apk-install", true));     // Catch: Throwable -> L20
        r101.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        apkInstallThreadExecutor = r101;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r100 = 60;
    L24:
        return apkInstallThreadExecutor;
    }

    public static synchronized Context getAppContext() {
        monitor-enter(DownloadComponentManager.class);
        Context r100 = appContext;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static ExecutorService getCPUThreadExecutor() {
        if (cpuThreadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (cpuThreadExecutor != null) goto L18;
        int r100 = fixedCPUPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r101 = 8;
        int r102 = r100 / 2;     // Catch: Throwable -> L20
    L12:
        PThreadPoolExecutor r103 = new PThreadPoolExecutor(r102, r100, r101, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-cpu-fixed", true));     // Catch: Throwable -> L20
        r103.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        cpuThreadExecutor = r103;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r101 = 15;
        r102 = r100;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return cpuThreadExecutor;
    }

    public static ExecutorService getChunkDownloadThreadExecutorService() {
        if (chunkDownloadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (chunkDownloadExecutor != null) goto L18;
        int r100 = fixedIOPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r101 = 8;
        int r102 = r100 / 2;     // Catch: Throwable -> L20
    L12:
        PThreadPoolExecutor r103 = new PThreadPoolExecutor(r102, r100, r101, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-chunk-fixed", true));     // Catch: Throwable -> L20
        r103.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        chunkDownloadExecutor = r103;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r101 = 15;
        r102 = r100;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return chunkDownloadExecutor;
    }

    public static ExecutorService getDBThreadExecutorService() {
        if (dbThreadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (dbThreadExecutor != null) goto L18;
        int r100 = fixedDBPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r101 = 8;
        int r102 = r100 / 2;     // Catch: Throwable -> L20
    L12:
        PThreadPoolExecutor r103 = new PThreadPoolExecutor(r102, r100, r101, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-db-fixed", true));     // Catch: Throwable -> L20
        r103.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        dbThreadExecutor = r103;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r101 = 15;
        r102 = r100;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return dbThreadExecutor;
    }

    public static IDownloadDns getDefaultDownloadDns() {
        if (defaultDownloadDns != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (defaultDownloadDns != null) goto L9;
        defaultDownloadDns = new AnonymousClass4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return defaultDownloadDns;
    }

    public static IDownloadHttpService getDefaultHttpService() {
        if (defaultHttpService != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (defaultHttpService != null) goto L9;
        defaultHttpService = new DefaultDownloadHttpService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return defaultHttpService;
    }

    public static IDownloadCache getDownloadCache() {
        if (downloadCache != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (downloadCache != null) goto L9;
        downloadCache = new DefaultDownloadCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return downloadCache;
    }

    public static AbsDownloadEngine getDownloadEngine() {
        if (downloadEngine != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (downloadEngine != null) goto L9;
        setDownloadEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return downloadEngine;
    }

    public static synchronized IDownloadLaunchHandler getDownloadLaunchHandler() {
        monitor-enter(DownloadComponentManager.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (DownloadUtils.ENABLE_APP_DOWNLOADER == true) goto L9;
        monitor-exit(DownloadComponentManager.class);
        return null;
    L9:
        IDownloadLaunchHandler r100 = downloadLaunchHandler;     // Catch: Throwable -> L12
        monitor-exit(DownloadComponentManager.class);
        return r100;
    }

    public static IDownloadServiceHandler getDownloadServiceHandler() {
        if (downloadServiceHandler != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (downloadServiceHandler != null) goto L9;
        downloadServiceHandler = new DefaultDownloadServiceHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return downloadServiceHandler;
    }

    public static JSONObject getDownloadSetting() {
        if (downloadSettings == null) goto L5;
        JSONObject r100 = downloadSettings.get();
    L6:
        if (r100 == null) goto L8;
        return r100;
    L8:
        return DownloadConstants.EMPTY_JSON;
    L5:
        r100 = null;
        goto L6
    }

    public static InnerEventListener getEventListener() {
        if (downloadEventListener != null) goto L6;
        downloadEventListener = new AnonymousClass5();
    L6:
        return downloadEventListener;
    }

    public static ExecutorService getFastThreadExecutor() {
        if (fastThreadExecutor != null) goto L23;
        monitor-enter(DownloadComponentManager.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (fastThreadExecutor != null) goto L17;
        int r100 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.FAST_DOWNLOAD_THREAD_POOL_SIZE_LIMIT);     // Catch: Throwable -> L19
        if (r100 > 0) goto L11;
        int r101 = 20;
    L13:
        if (isGlobalThreadPoolOptEnabled() == false) goto L15;
        long r102 = 15;
    L16:
        fastThreadExecutor = new PThreadPoolExecutor(0, r101, r102, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("DownloadThreadPool-Fast", true));     // Catch: Throwable -> L19
        goto L17
    L15:
        r102 = 60;
        goto L16
    L11:
        r101 = r100;
    L17:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L19
    L23:
        return fastThreadExecutor;
    }

    public static ExecutorService getGlobalThrottleThreadExecutor() {
        if (globalThrottleDownloadExecutor != null) goto L25;
        monitor-enter(DownloadComponentManager.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (globalThrottleDownloadExecutor != null) goto L19;
        int r100 = fixedMIXPoolSize;     // Catch: Throwable -> L21
        int r101 = r100 * 2;     // Catch: Throwable -> L21
        if (isThrottleThreadPoolOptEnabled() == false) goto L11;
        int r102 = r100;
        long r103 = 8;
    L12:
        PThreadPoolExecutor r104 = new PThreadPoolExecutor(r102, r100 * 2, r103, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-global-throttle", true));     // Catch: Throwable -> L21
        if (isThrottleThreadPoolOptEnabled() == true) goto L28;
    L18:
        globalThrottleDownloadExecutor = r104;     // Catch: Throwable -> L21
        goto L19
    L28:
        r104.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    L11:
        r102 = r101;
        r103 = 15;
    L19:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L21
    L25:
        return globalThrottleDownloadExecutor;
    }

    public static ExecutorService getIOThreadExecutor() {
        if (ioThreadExecutor == null) goto L6;
        return ioThreadExecutor;
    L6:
        return getCPUThreadExecutor();
    }

    public static IDownloadServiceHandler getIndependentDownloadServiceHandler() {
        if (independentDownloadServiceHandler != null) goto L20;
        monitor-enter(DownloadComponentManager.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (independentDownloadServiceHandler == null) goto L9;
    L14:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L16
        goto L20
    L9:
        if (independentHolderCreator == null) goto L11;
        independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();     // Catch: Throwable -> L16
        goto L14
    L11:
        IDownloadServiceHandler r100 = getDownloadServiceHandler();     // Catch: Throwable -> L16
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L16
        return r100;
    L20:
        return independentDownloadServiceHandler;
    }

    public static ExecutorService getMixApkThreadExecutor() {
        if (mixApkDownloadExecutor == null) goto L6;
        return mixApkDownloadExecutor;
    L6:
        return getMixDefaultThreadExecutor();
    }

    public static ExecutorService getMixDefaultThreadExecutor() {
        if (mixDefaultDownloadExecutor != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (mixDefaultDownloadExecutor != null) goto L18;
        int r100 = fixedMIXPoolSize;     // Catch: Throwable -> L20
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r101 = 8;
        int r102 = r100 / 2;     // Catch: Throwable -> L20
    L12:
        PThreadPoolExecutor r103 = new PThreadPoolExecutor(r102, r100, r101, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-mix-fixed", true));     // Catch: Throwable -> L20
        r103.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L15
    L17:
        mixDefaultDownloadExecutor = r103;     // Catch: Throwable -> L20
        goto L18
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L17
    L11:
        r101 = 15;
        r102 = r100;
    L18:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
    L24:
        return mixDefaultDownloadExecutor;
    }

    public static ExecutorService getMixFrequentThreadExecutor() {
        if (mixFrequentDownloadExecutor == null) goto L6;
        return mixFrequentDownloadExecutor;
    L6:
        return getMixDefaultThreadExecutor();
    }

    public static synchronized IMonitorConfig getMonitorConfig() {
        monitor-enter(DownloadComponentManager.class);
        IMonitorConfig r100 = monitorConfig;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static ScheduledExecutorService getScheduledExecutorService() {
        if (scheduledExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (scheduledExecutor != null) goto L9;
        scheduledExecutor = new PThreadScheduledThreadPoolExecutor(4, new DefaultThreadFactory("DownloadThreadPool-Schedule", true));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return scheduledExecutor;
    }

    public static ExecutorService getSegmentDownloadThreadExecutorService() {
        if (segmentThreadExecutor != null) goto L20;
        monitor-enter(DownloadComponentManager.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (segmentThreadExecutor != null) goto L14;
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-segment-fixed", true));     // Catch: Throwable -> L16
        r100.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L13:
        segmentThreadExecutor = r100;     // Catch: Throwable -> L16
        goto L14
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L14:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L16
    L20:
        return segmentThreadExecutor;
    }

    public static ExecutorService getSingleThreadExecutorService() {
        if (singleThreadExecutor != null) goto L25;
        monitor-enter(DownloadComponentManager.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (singleThreadExecutor == null) goto L9;
    L19:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L21
        goto L25
    L9:
        if (isGlobalThreadPoolOptEnabled() == false) goto L11;
        long r100 = 30;
    L12:
        PThreadPoolExecutor r101 = new PThreadPoolExecutor(1, 1, r100, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory(SINGLE_THREAD_NAME, true));     // Catch: Throwable -> L21
        if (isGlobalThreadPoolOptEnabled() == true) goto L26;
    L18:
        singleThreadExecutor = r101;     // Catch: Throwable -> L21
        goto L19
    L26:
        r101.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L18
    L11:
        r100 = 60;
    L25:
        return singleThreadExecutor;
    }

    public static ITTNetHandler getTTNetHandler() {
        if (iTTNetHandler != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (iTTNetHandler != null) goto L9;
        iTTNetHandler = new ITTNetHandler.DefaultTTNetHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return iTTNetHandler;
    }

    public static synchronized boolean isDownloadInMultiProcess() {
        monitor-enter(DownloadComponentManager.class);
        boolean r100 = downloadInMultiProcess;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean isHttpServiceInit() {
        monitor-enter(DownloadComponentManager.class);
        boolean r100 = httpServiceInit;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private static synchronized void registerDownloadReceiver() {
        monitor-enter(DownloadComponentManager.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (downloadReceiver != null) goto L8;
        downloadReceiver = new DownloadReceiver();     // Catch: Throwable -> L17
    L8:
        if (isReceiverRegistered == false) goto L20;
        monitor-exit(DownloadComponentManager.class);
        return;
    L20:
        IntentFilter r100 = new IntentFilter();     // Catch: Throwable -> L13
        r100.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L13
        r100.addAction("android.intent.action.MEDIA_MOUNTED");     // Catch: Throwable -> L13
        r100.addAction("android.intent.action.MEDIA_UNMOUNTED");     // Catch: Throwable -> L13
        r100.addAction("android.intent.action.MEDIA_REMOVED");     // Catch: Throwable -> L13
        r100.addAction("android.intent.action.MEDIA_BAD_REMOVAL");     // Catch: Throwable -> L13
        r100.addAction("android.intent.action.MEDIA_EJECT");     // Catch: Throwable -> L13
        INVOKEVIRTUAL_com_ss_android_socialbase_downloader_downloader_DownloadComponentManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(appContext, downloadReceiver, r100);     // Catch: Throwable -> L13
        isReceiverRegistered = true;     // Catch: Throwable -> L13
    L15:
        monitor-exit(DownloadComponentManager.class);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
        goto L15
    }

    public static synchronized void setDownloadInMultiProcess() {
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (downloadInMultiProcess == false) goto L7;
    L18:
        monitor-exit(DownloadComponentManager.class);
        return;
    L7:
        if (supportMultiProc() == false) goto L18;
        Intent r100 = new Intent(getAppContext(), DownloadHandleService.class);     // Catch: Throwable -> L14
        r100.setAction(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY);     // Catch: Throwable -> L14
        getAppContext().startService(r100);     // Catch: Throwable -> L14
        if (DownloadHelper.isDownloaderProcess() == true) goto L12;
        submitIOTask(new AnonymousClass2());     // Catch: Throwable -> L14
    L12:
        downloadInMultiProcess = true;     // Catch: Throwable -> L14
    L16:
        monitor-exit(DownloadComponentManager.class);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L16
    }

    public static boolean supportMultiProc() {
        if (independentHolderCreator == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static synchronized void unRegisterDownloadReceiver() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.ss.android.socialbase.downloader.downloader.DownloadComponentManager> r0 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.class
            monitor-enter(r0)
            boolean r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isReceiverRegistered     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r1 == 0) goto L20
            com.ss.android.socialbase.downloader.downloader.DownloadReceiver r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadReceiver     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r1 == 0) goto L20
            android.content.Context r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.appContext     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r1 == 0) goto L20
            android.content.Context r1 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.appContext     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            com.ss.android.socialbase.downloader.downloader.DownloadReceiver r2 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadReceiver     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            INVOKEVIRTUAL_com_ss_android_socialbase_downloader_downloader_DownloadComponentManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r1, r2)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r1 = 0
            com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isReceiverRegistered = r1     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            goto L20
        L1a:
            r1 = move-exception
            goto L22
        L1c:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L1a
        L20:
            monitor-exit(r0)
            return
        L22:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.unRegisterDownloadReceiver():void");
    }

    public static void initDownloadCacheImmediately() {
        getDownloadCache().initImmediately();
    }

    public static boolean isEnableLruCache() {
        return DownloadUtils.isEnableLruCache();
    }

    public static boolean isGlobalThreadPoolOptEnabled() {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_GLOBAL_THREAD_POOL_OPT, 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isThrottleThreadPoolOptEnabled() {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_THROTTLE_THREAD_POOL_OPT, 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    private static void setDownloadEngine() {
        if (DownloadHelper.getCacheSettingInt(DownloadSettingKeys.OPTIMIZE_DOWNLOAD_CACHE) <= 0) goto L5;
        downloadEngine = new NewDownloadEngine();
        return;
    L5:
        downloadEngine = new DefaultDownloadEngine();
    }

    private static void setLoggerReport() {
        JSONObject r100 = getDownloadSetting();     // Catch: Throwable -> L37
        int r101 = r100.optInt(DownloadSettingKeys.DOWNLOADER_ALOG_LEVEL);     // Catch: Throwable -> L37
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "setLoggerReport", "ALogLevel:" + r101);     // Catch: Throwable -> L37
    L6:
        if (r101 > 0) goto L8;
        return;
    L8:
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L37
        JSONArray r103 = r100.optJSONArray(DownloadSettingKeys.DOWNLOADER_ALOG_TASK_SCENE_LIST);     // Catch: Throwable -> L37
        int r104 = 0;
        if (r103 != null) goto L11;
    L19:
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L37
        if (r100.optInt(DownloadSettingKeys.DOWNLOADER_LOGGER_GLOBAL_REPORT) <= 0) goto L22;
        boolean r106 = true;
    L23:
        JSONArray r107 = r100.optJSONArray(DownloadSettingKeys.DOWNLOADER_LOGGER_TASK_REPORT_SCENE_LIST);     // Catch: Throwable -> L37
        if (r107 != null) goto L26;
    L33:
        Logger.setLogReportParams(r101, r106, r105, r102);     // Catch: Throwable -> L37
        if (Logger.alog() == false) goto L48;
        Logger.globalDebug(TAG, "setLoggerReport", "Setting: " + getDownloadSetting());     // Catch: Throwable -> L37
        return;
    L48:
        return;
    L26:
        if (r107.length() <= 0) goto L33;
    L28:
        if (r104 >= r107.length()) goto L33;
        String r108 = r107.optString(r104);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r108) == true) goto L32;
        r105.add(r108);     // Catch: Throwable -> L37
    L32:
        r104 = r104 + 1;     // Catch: Throwable -> L37
        goto L28
    L22:
        r106 = false;
        goto L23
    L11:
        if (r103.length() <= 0) goto L19;
        int r109 = 0;
    L14:
        if (r109 >= r103.length()) goto L19;
        String r110 = r103.optString(r109);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r110) == true) goto L18;
        r102.add(r110);     // Catch: Throwable -> L37
    L18:
        r109 = r109 + 1;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Logger.globalError(TAG, "setLoggerReport", "Error:" + th);
    }

    private DownloadComponentManager() {
    }

    public static /* synthetic */ void access$100() {
        registerDownloadReceiver();
    }

    public static ExecutorService getCustomThreadExecutor() {
        return customThreadExecutor;
    }

    public static List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return downloadCompleteHandlers;
    }

    public static IDownloadDBListener getDownloadDBListener() {
        return downloadDBListener;
    }

    public static IDownloadDns getDownloadDns() {
        return downloadDns;
    }

    public static IDownloadInterceptor getDownloadInterceptor() {
        return downloadInterceptor;
    }

    public static IDownloadMemoryInfoListener getDownloadMemoryInfoListener() {
        return downloadMemoryInfoListener;
    }

    public static IDownloadMonitorListener getDownloadMonitorListener() {
        return downloadMonitorListener;
    }

    public static IDownloadStatusListener getDownloadStatusListener() {
        return downloadStatusListener;
    }

    public static IDownloadThreadCheckListener getDownloadThreadCheckListener() {
        return threadCheckListener;
    }

    public static IDownloadHttpService getHttpService() {
        return httpService;
    }

    public static IndependentHolderCreator getIndependentHolderCreator() {
        return independentHolderCreator;
    }

    public static IndependentHolderCreator getNormalDBIndependentHolderCreator() {
        return mNormalDBIndependentHolderCreator;
    }

    public static INotificationClickCallback getNotificationClickCallback() {
        return notificationClickCallback;
    }

    public static List<ProcessCallback> getProcessCallbacks() {
        return processCallbacks;
    }

    public static IReserveWifiStatusListener getReserveWifiStatusListener() {
        return reserveWifiStatusListener;
    }

    public static int getWriteBufferSize() {
        return writeBufferSize;
    }

    public static boolean isInit() {
        return hasInit;
    }

    public static boolean needAutoRefreshUnSuccessTask() {
        return needAutoRefreshUnSuccessTask;
    }

    public static /* synthetic */ void access$000(boolean r100) {
        registerIndependentService(r100);
    }

    public static void addDownloadCompleteHandler(IDownloadCompleteHandler r100) {
        List<IDownloadCompleteHandler> r101 = downloadCompleteHandlers;
        monitor-enter(r101);
        if (r100 != null) goto L16;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r101.contains(r100) == true) goto L11;
        r101.add(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public static void addProcessCallback(ProcessCallback r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        processCallbacks.add(r100);
    }

    private static OkHttpClient buildBoundClient(final Network r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return createDownloadClientBuilder().connectionPool(new ConnectionPool(0, 1, TimeUnit.MILLISECONDS)).socketFactory(r100.getSocketFactory()).dns(new AnonymousClass3(r100)).build();
    L7:
        th = move-exception;
        Logger.e("buildBoundClient failed: " + th);
        return null;
    }

    public static synchronized void coverComponent(DownloaderBuilder r100) {
        monitor-enter(DownloadComponentManager.class);
        setDownloadBuilder(r100);     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static Network getActiveWifiNetwork(ConnectivityManager r100) {
        Network r101 = r100.getActiveNetwork();     // Catch: Throwable -> L10
        if (r101 == null) goto L15;
        NetworkCapabilities r102 = r100.getNetworkCapabilities(r101);     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        if (r102.hasTransport(1) == true) goto L18;
        return null;
    L18:
        return r101;
    L16:
        return null;
    L15:
        return null;
    L10:
        th = move-exception;
        Logger.e(TAG, "forceWifi get active wifi network error", th);
        return null;
    }

    public static int getDownloadId(DownloadInfo r100) {
        return ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(r100);
    }

    private static OkHttpClient getWifiBoundClient(String r110) {
    L33:
        th = move-exception;
        Logger.e("error: " + th);
    L35:
        return null;
    L4:
        if (Build.VERSION.SDK_INT >= 23) goto L6;
    L32:
        return null;
    L6:
        if (getAppContext() == null) goto L32;
        ConnectivityManager r100 = (ConnectivityManager) getAppContext().getSystemService("connectivity");     // Catch: Throwable -> L33
        if (r100 != null) goto L11;
        return null;
    L11:
        TargetInfo r111 = parseTargetInfo(r110);     // Catch: Throwable -> L33
        Network[] r101 = r100.getAllNetworks();     // Catch: Throwable -> L33
        Network r102 = getActiveWifiNetwork(r100);     // Catch: Throwable -> L33
        if (r101 == null) goto L24;
        int r103 = r101.length;     // Catch: Throwable -> L33
        int r104 = 0;
        Network r105 = null;
    L14:
        if (r104 >= r103) goto L25;
        Network r106 = r101[r104];     // Catch: Throwable -> L33
        NetworkCapabilities r107 = r100.getNetworkCapabilities(r106);     // Catch: Throwable -> L33
        LinkProperties r108 = r100.getLinkProperties(r106);     // Catch: Throwable -> L33
        if (isWifiCandidate(r107, r108) == false) goto L23;
        if (r105 != null) goto L20;
        r105 = r106;
    L20:
        OkHttpClient r109 = selectWifiByRoute(r111.target, r106, r108);     // Catch: Throwable -> L33
        if (r109 == null) goto L23;
        return r109;
    L23:
        r104 = r104 + 1;     // Catch: Throwable -> L33
    L25:
        if (r102 == null) goto L29;
        OkHttpClient r112 = buildBoundClient(r102);     // Catch: Throwable -> L33
        if (r112 == null) goto L29;
        return r112;
    L29:
        if (r105 == null) goto L35;
        return buildBoundClient(r105);
    L24:
        r105 = null;
        goto L25
    }

    public static synchronized void initComponent(DownloaderBuilder r100) {
        monitor-enter(DownloadComponentManager.class);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (hasInit == false) goto L9;
        Logger.globalError(TAG, "initComponent", "Component has init");     // Catch: Throwable -> L33
        monitor-exit(DownloadComponentManager.class);
        return;
    L9:
        boolean r101 = downloadInMultiProcess;     // Catch: Throwable -> L33
        setDownloadBuilder(r100);     // Catch: Throwable -> L33
        setLoggerReport();     // Catch: Throwable -> L33
        if (downloadCache != null) goto L13;
        downloadCache = new DefaultDownloadCache();     // Catch: Throwable -> L33
    L13:
        if (downloadServiceHandler != null) goto L16;
        downloadServiceHandler = new DefaultDownloadServiceHandler();     // Catch: Throwable -> L33
    L16:
        if (independentDownloadServiceHandler != null) goto L21;
        if (independentHolderCreator == null) goto L21;
        independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();     // Catch: Throwable -> L33
    L21:
        if (downloadEngine != null) goto L24;
        setDownloadEngine();     // Catch: Throwable -> L33
    L24:
        if (downloadInMultiProcess == false) goto L29;
        if (r101 == true) goto L29;
        if (DownloadHelper.isDownloaderProcess() == true) goto L29;
        boolean r102 = true;
    L30:
        registerAsync(r102);     // Catch: Throwable -> L33
        ensureOPPO();     // Catch: Throwable -> L33
        hasInit = true;     // Catch: Throwable -> L33
        monitor-exit(DownloadComponentManager.class);
        return;
    L29:
        r102 = false;
        goto L30
    }

    public static boolean isCommonOkhttpClient(OkHttpClient r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        OkHttpClient r101 = sOkHttpClient;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r100 != r101) goto L11;
        return true;
    L11:
        return false;
    }

    private static void needAutoRefreshUnSuccessTask(boolean r100) {
        needAutoRefreshUnSuccessTask = r100;
    }

    public static void onDownloadCacheSyncCallback(DownloadCacheSyncStatus r100) {
        List<IDownloadCacheSyncStatusListener> r101 = downloadCacheSyncStatusListeners;
        monitor-enter(r101);
        Iterator<IDownloadCacheSyncStatusListener> r102 = r101.iterator();     // Catch: Throwable -> L20
    L6:
        if (r102.hasNext() == false) goto L16;
        IDownloadCacheSyncStatusListener r103 = r102.next();     // Catch: Throwable -> L20
        if (r103 == null) goto L6;
        if (r100 == DownloadCacheSyncStatus.SYNC_START) goto L11;
        if (r100 != DownloadCacheSyncStatus.SYNC_SUCCESS) goto L6;
        r103.onSuccess();     // Catch: Throwable -> L20
        goto L6
    L11:
        r103.onStart();     // Catch: Throwable -> L20
        goto L6
    L16:
        if (r100 != DownloadCacheSyncStatus.SYNC_SUCCESS) goto L18;
        downloadCacheSyncStatusListeners.clear();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private static TargetInfo parseTargetInfo(String r100) {
        InetAddress r101 = null;
        String r102 = URI.create(r100).getHost();     // Catch: Throwable -> L21
        if (r102 == null) goto L25;
    L19:
        th = th;
    L23:
        Logger.e(TAG, "forceWifi parse url error", th);
        goto L25
    L6:
        if (r102.isEmpty() == true) goto L25;
        if (r102.startsWith("[") == true) goto L10;
    L14:
        String r103 = r102;
    L16:
        if (Patterns.IP_ADDRESS.matcher(r103).matches() == false) goto L25;
        r101 = InetAddress.getByName(r103);     // Catch: Throwable -> L19
        r102 = r103;
        goto L25
    L10:
        if (r102.endsWith("]") == false) goto L14;
        if (r102.length() <= 2) goto L14;
        r103 = r102.substring(1, r102.length() - 1);     // Catch: Throwable -> L19
    L25:
        return new TargetInfo(r101, r102);
    L21:
        th = th;
        r102 = null;
        goto L23
    }

    private static void registerAsync(final boolean r100) {
        submitIOTask(new AnonymousClass1(r100));
    }

    public static void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100) {
        List<IDownloadCacheSyncStatusListener> r101 = downloadCacheSyncStatusListeners;
        monitor-enter(r101);
        if (r100 != null) goto L16;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r101.contains(r100) == true) goto L11;
        r101.add(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public static void registerDownloadTaskExecuteListener(IDownloadTaskExecuteListener r100) {
        List<IDownloadTaskExecuteListener> r101 = downloadTaskExecuteListeners;
        monitor-enter(r101);
        if (r100 != null) goto L16;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r101.contains(r100) == true) goto L11;
        r101.add(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    private static void registerIndependentService(boolean r100) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (DownloadUtils.optimizeMultiProcess() == true) goto L8;
        DownloadProxy.get(true).startService();
        return;
    }

    public static void releaseOkHttpClient(OkHttpClient r100) {
        if (r100 != null) goto L11;
        return;
    L11:
        r100.dispatcher().cancelAll();     // Catch: Throwable -> L8
        r100.connectionPool().evictAll();     // Catch: Throwable -> L8
        if (okHttpDispatcherExecutor != null) goto L13;
        r100.dispatcher().executorService().shutdown();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    L8:
        th = move-exception;
        Logger.e(TAG, "releaseOkHttpClient error", th);
    }

    public static void removeDownloadCompleteHandler(IDownloadCompleteHandler r100) {
        List<IDownloadCompleteHandler> r101 = downloadCompleteHandlers;
        monitor-enter(r101);
        if (r100 != null) goto L16;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r101.contains(r100) == false) goto L11;
        r101.remove(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public static synchronized void setAppContext(Context r100) {
        monitor-enter(DownloadComponentManager.class);
        if (r100 != null) goto L16;
    L14:
        monitor-exit(DownloadComponentManager.class);
        return;
    L16:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (appContext != null) goto L14;
        appContext = r100.getApplicationContext();     // Catch: Throwable -> L11
        AppStatusManager.getInstance().init(appContext);     // Catch: Throwable -> L11
        if (Logger.debug() == false) goto L14;
        Logger.globalDebug(TAG, "setAppContext", "Context:" + r100);     // Catch: Throwable -> L11
        goto L14
    }

    private static void setCPUThreadExecutor(ExecutorService r100) {
        if (r100 == null) goto L5;
        cpuThreadExecutor = r100;
        return;
    }

    public static void setChunkDownloadExecutor(ExecutorService r100) {
        if (r100 == null) goto L5;
        chunkDownloadExecutor = r100;
        return;
    }

    public static void setCustomThreadExecutor(ExecutorService r100) {
        if (r100 == null) goto L5;
        customThreadExecutor = r100;
        return;
    }

    private static void setDBThreadExecutor(ExecutorService r100) {
        if (r100 == null) goto L5;
        dbThreadExecutor = r100;
        return;
    }

    private static void setDownloadBuilder(DownloaderBuilder r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getContext() == null) goto L7;
        setAppContext(r100.getContext());
    L7:
        if (r100.getIdGenerator() == null) goto L10;
        setIdGenerator(r100.getIdGenerator());
    L10:
        if (r100.getNotificationClickCallback() == null) goto L13;
        setNotificationClickCallback(r100.getNotificationClickCallback());
    L13:
        if (r100.getHttpService() == null) goto L16;
        setHttpService(r100.getHttpService());
    L16:
        if (r100.getDownloadLaunchHandler() == null) goto L19;
        setDownloadLaunchHandler(r100.getDownloadLaunchHandler());
    L19:
        if (r100.getCPUThreadExecutor() == null) goto L22;
        setCPUThreadExecutor(r100.getCPUThreadExecutor());
    L22:
        if (r100.getIOThreadExecutor() == null) goto L25;
        setIOThreadExecutor(r100.getIOThreadExecutor());
    L25:
        if (r100.getMixDefaultDownloadExecutor() == null) goto L28;
        setMixDefaultDownloadExecutor(r100.getMixDefaultDownloadExecutor());
    L28:
        if (r100.getMixFrequentDownloadExecutor() == null) goto L31;
        setMixFrequentDownloadExecutor(r100.getMixFrequentDownloadExecutor());
    L31:
        if (r100.getMixApkDownloadExecutor() == null) goto L34;
        setMixApkDownloadExecutor(r100.getMixApkDownloadExecutor());
    L34:
        if (r100.getDBThreadExecutor() == null) goto L37;
        setDBThreadExecutor(r100.getDBThreadExecutor());
    L37:
        if (r100.getChunkThreadExecutor() == null) goto L40;
        setChunkDownloadExecutor(r100.getChunkThreadExecutor());
    L40:
        if (r100.getOkHttpDispatcherExecutor() == null) goto L43;
        setOkHttpDispatcherExecutor(r100.getOkHttpDispatcherExecutor());
    L43:
        if (r100.getCustomThreadExecutor() == null) goto L46;
        setCustomThreadExecutor(r100.getCustomThreadExecutor());
    L46:
        if (r100.getDownloadCompleteHandlers().isEmpty() == true) goto L49;
        setDownloadCompleteHandlers(r100.getDownloadCompleteHandlers());
    L49:
        if (r100.getMonitorConfig() == null) goto L52;
        monitorConfig = r100.getMonitorConfig();
    L52:
        if (r100.getWriteBufferSize() <= 1024) goto L55;
        writeBufferSize = r100.getWriteBufferSize();
    L55:
        if (r100.isDownloadInMultiProcess() == false) goto L58;
        downloadInMultiProcess = true;
    L58:
        if (r100.getTTNetHandler() == null) goto L64;
        iTTNetHandler = r100.getTTNetHandler();
        if (iTTNetHandler.isTTNetEnable() == false) goto L62;
        setHttpService(iTTNetHandler.getTTNetDownloadHttpService());
        goto L64
    L62:
        setHttpService(getDefaultHttpService());
    L64:
        if (r100.getDownloadSetting() == null) goto L67;
        setDownloadSetting(r100.getDownloadSetting());
    L67:
        if (r100.getDownloadDns() == null) goto L70;
        downloadDns = r100.getDownloadDns();
    L70:
        if (r100.getDownloadInterceptor() == null) goto L72;
        setDownloadInterceptor(r100.getDownloadInterceptor());
    L72:
        needAutoRefreshUnSuccessTask(r100.needAutoRefreshUnSuccessTask());
        if (r100.getDownloadMonitorListener() == null) goto L77;
        setDownloadMonitorListener(r100.getDownloadMonitorListener());
        return;
    }

    private static void setDownloadCompleteHandlers(List<IDownloadCompleteHandler> r100) {
        List<IDownloadCompleteHandler> r101 = downloadCompleteHandlers;
        if (r101.isEmpty() == false) goto L11;
        monitor-enter(r101);
        r101.addAll(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void setDownloadDBListener(IDownloadDBListener r100) {
        downloadDBListener = r100;
    }

    public static void setDownloadEventListener(InnerEventListener r100) {
        downloadEventListener = GlobalListenerAdaptor.addListener(r100);
    }

    public static void setDownloadInterceptor(IDownloadInterceptor r100) {
        if (r100 == null) goto L5;
        downloadInterceptor = GlobalListenerAdaptor.addListener(r100);
        return;
    }

    public static synchronized void setDownloadLaunchHandler(IDownloadLaunchHandler r100) {
        monitor-enter(DownloadComponentManager.class);
        if (r100 != null) goto L14;
    L12:
        monitor-exit(DownloadComponentManager.class);
        return;
    L14:
        downloadLaunchHandler = r100;     // Catch: Throwable -> L9
        if ((downloadCache instanceof DefaultDownloadCache) == false) goto L12;
        ((DefaultDownloadCache) downloadCache).resumeUnCompleteTaskMayDelayed();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public static void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r100) {
        downloadMemoryInfoListener = r100;
    }

    public static void setDownloadMonitorListener(IDownloadMonitorListener r100) {
        if (r100 == null) goto L5;
        downloadMonitorListener = r100;
        return;
    }

    public static void setDownloadNetworkHandler(IDownloadNetworkHandler r100) {
        downloadNetworkHandler = r100;
    }

    public static void setDownloadSetting(IDownloadSettings r100) {
        downloadSettings = r100;
        DownloadSetting.init();
        Logger.alogE(TAG, "Run setDownloadSetting");
    }

    public static void setDownloadStatusListener(IDownloadStatusListener r100) {
        downloadStatusListener = r100;
    }

    public static void setDownloadThreadCheckListener(IDownloadThreadCheckListener r100) {
        if (r100 == null) goto L5;
        threadCheckListener = r100;
        return;
    }

    public static void setHttpService(IDownloadHttpService r100) {
        if (r100 == null) goto L5;
        httpService = r100;
    L5:
        if (httpService == null) goto L7;
        boolean r101 = true;
    L8:
        httpServiceInit = r101;
        return;
    L7:
        r101 = false;
        goto L8
    }

    private static void setIOThreadExecutor(ExecutorService r100) {
        if (r100 == null) goto L5;
        ioThreadExecutor = r100;
        return;
    }

    private static void setIdGenerator(IDownloadIdGenerator r100) {
        if (r100 == null) goto L5;
        ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).setDownloadIdGenerator(r100);
        return;
    }

    public static void setIndependentServiceCreator(IndependentHolderCreator r100) {
        if (DownloadUtils.optimizeMultiProcess() == false) goto L9;
        if (DownloadUtils.isMultiProcessNormalDBMode() == false) goto L13;
        mNormalDBIndependentHolderCreator = r100;
        return;
    L13:
        return;
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "setIndependentServiceCreator", "Creator: " + r100);
    L11:
        independentHolderCreator = r100;
    }

    private static void setMixApkDownloadExecutor(ExecutorService r100) {
        if (r100 == null) goto L5;
        mixApkDownloadExecutor = r100;
        return;
    }

    private static void setMixDefaultDownloadExecutor(ExecutorService r100) {
        if (r100 == null) goto L5;
        mixDefaultDownloadExecutor = r100;
        return;
    }

    private static void setMixFrequentDownloadExecutor(ExecutorService r100) {
        if (r100 == null) goto L5;
        mixFrequentDownloadExecutor = r100;
        return;
    }

    public static void setNotificationClickCallback(INotificationClickCallback r100) {
        if (r100 == null) goto L5;
        notificationClickCallback = GlobalListenerAdaptor.addListener(r100);
        return;
    }

    public static void setOkHttpDispatcherExecutor(ExecutorService r100) {
        if (r100 == null) goto L5;
        okHttpDispatcherExecutor = r100;
        return;
    }

    public static void setReserveWifiStatusListener(IReserveWifiStatusListener r100) {
        reserveWifiStatusListener = GlobalListenerAdaptor.addListener(r100);
    }

    public static void submitCPUTask(Runnable r100) {
        submitCPUTask(r100, false);
    }

    public static void submitDBTask(Runnable r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (DownloadUtils.isMainThread() == true) goto L7;
        r100.run();
        return;
    L7:
        getDBThreadExecutorService().execute(r100);
    }

    public static void submitIOTask(Runnable r100) {
        submitIOTask(r100, false);
    }

    public static void submitSingleTask(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        getSingleThreadExecutorService().execute(r100);
    }

    public static void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100) {
        List<IDownloadCacheSyncStatusListener> r101 = downloadCacheSyncStatusListeners;
        monitor-enter(r101);
        if (r100 != null) goto L16;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r101.contains(r100) == false) goto L11;
        r101.remove(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public static void unRegisterDownloadTaskExecuteListener(IDownloadTaskExecuteListener r100) {
        List<IDownloadTaskExecuteListener> r101 = downloadTaskExecuteListeners;
        monitor-enter(r101);
        if (r100 != null) goto L16;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r101.contains(r100) == false) goto L11;
        r101.remove(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_android_socialbase_downloader_downloader_DownloadComponentManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static long clearAllDownloadCache(boolean r110, Set<String> r111) {
        long r100 = 0;
        IDownloadCache r101 = getDownloadCache();     // Catch: Throwable -> L34
        boolean r102 = r101.ensureDownloadCacheSyncSuccess();     // Catch: Throwable -> L34
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "DownloadCache sync:" + r102);     // Catch: Throwable -> L34
    L6:
        List<DownloadInfo> r103 = r101.getAllDownloadInfo();     // Catch: Throwable -> L34
        if (r103 == null) goto L9;
        AbsDownloadEngine r104 = getDownloadEngine();     // Catch: Throwable -> L34
        Iterator<DownloadInfo> r105 = r103.iterator();     // Catch: Throwable -> L34
        long r106 = 0;
    L44:
        if (r105.hasNext() == false) goto L40;
        DownloadInfo r107 = r105.next();     // Catch: Throwable -> L32
        if (r104.isDownloading(r107.getId()) == true) goto L44;
        if (DownloadDirUtils.isSavePathSecurity(r107.getSavePath()) == false) goto L44;
        if (r111 == null) goto L27;
        if (TextUtils.isEmpty(r107.getMonitorScene()) == true) goto L27;
        if (r111.contains(r107.getMonitorScene()) == true) goto L44;
    L27:
        if (r107.getCurBytes() <= 0) goto L29;
        r106 = r106 + r107.getCurBytes();     // Catch: Throwable -> L32
    L29:
        if (r110 == false) goto L44;
        r101.removeDownloadTaskData(r107.getId());     // Catch: Throwable -> L32
        DownloadUtils.clearDownloadFile(r107.getSavePath(), r107.getTempPath(), r107.getName());     // Catch: Throwable -> L32
    L40:
        if (Logger.debug() == false) goto L42;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "ClearSize:" + r106 + " clear:" + r110);
    L42:
        return r106;
    L32:
        th = th;
        r100 = r106;
    L35:
        th.printStackTrace();
        if (Logger.debug() == false) goto L38;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "Error:" + th);
    L38:
        r106 = r100;
        goto L40
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "clearAllDownloadCache", "DownloadInfos is null");     // Catch: Throwable -> L34
    L11:
        return 0;
    L34:
        th = th;
        goto L35
    }

    public static IDownloadHeadHttpConnection downloadWithHeadConnection(String r100, List<HttpHeader> r101) throws Exception {
        return ((IDownloadNetworkService) DownloadServiceManager.getService(IDownloadNetworkService.class)).downloadWithConnection(true, 0, r100, r101);
    }

    public static OkHttpClient getDownloadClient(boolean r100, String r101) {
        if (r100 == false) goto L7;
        OkHttpClient r102 = getWifiBoundClient(r101);
        if (r102 == null) goto L7;
        return r102;
    L7:
        if (sOkHttpClient != null) goto L19;
        monitor-enter(DownloadComponentManager.class);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (sOkHttpClient != null) goto L13;
        sOkHttpClient = createDownloadClientBuilder().build();     // Catch: Throwable -> L15
    L13:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L15
    L19:
        return sOkHttpClient;
    }

    public static int getDownloadId(String r100, String r101) {
        return ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(r100, r101);
    }

    private static String handleConnection(String r100, List<HttpHeader> r101) {
        if (downloadNetworkHandler != null) goto L5;
        return r100;
    L5:
        String r102 = downloadNetworkHandler.handle(r100, r101);
        if (TextUtils.isEmpty(r102) == true) goto L8;
        return r102;
    L8:
        return r100;
    }

    private static boolean isWifiCandidate(NetworkCapabilities r100, LinkProperties r101) {
        if (r100 != null) goto L4;
    L11:
        return false;
    L4:
        if (r100.hasTransport(1) == false) goto L11;
        if (r101 == null) goto L11;
        if (r101.getLinkAddresses() == null) goto L11;
        if (r101.getLinkAddresses().isEmpty() == true) goto L11;
        return true;
    }

    public static void onDownloadTaskFinish(DownloadTask r100, int r101) {
        List<IDownloadTaskExecuteListener> r102 = downloadTaskExecuteListeners;
        monitor-enter(r102);
        Iterator<IDownloadTaskExecuteListener> r103 = r102.iterator();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L10;
        IDownloadTaskExecuteListener r104 = r103.next();     // Catch: Throwable -> L12
        if (r104 == null) goto L6;
        r104.onFinish(r100, r101);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void onDownloadTaskStart(DownloadTask r100, int r101) {
        List<IDownloadTaskExecuteListener> r102 = downloadTaskExecuteListeners;
        monitor-enter(r102);
        Iterator<IDownloadTaskExecuteListener> r103 = r102.iterator();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L10;
        IDownloadTaskExecuteListener r104 = r103.next();     // Catch: Throwable -> L12
        if (r104 == null) goto L6;
        r104.onStart(r100, r101);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void submitCPUTask(Runnable r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == true) goto L6;
    L8:
        getCPUThreadExecutor().execute(r100);
        return;
    L6:
        if (DownloadUtils.isMainThread() == true) goto L8;
        r100.run();
    }

    public static void submitIOTask(Runnable r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == true) goto L6;
    L8:
        getIOThreadExecutor().execute(r100);
        return;
    L6:
        if (DownloadUtils.isMainThread() == true) goto L8;
        r100.run();
    }

    public static void updateCurrentDownloadThreadInfo(DownloadTask r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getDownloadInfo().isFastDownload() == true) goto L15;
        if (r101 == false) goto L8;
        Map<String, DownloadThreadInfo.ThreadExecutorInfo> r102 = r100.getThreadInfo().beforeDownloadThreadExecutors;
    L10:
        if (r102.isEmpty() == true) goto L12;
        return;
    L12:
        r102.put("cpu", DownloadThreadInfo.parse(cpuThreadExecutor));
        r102.put(MonitorConstants.IO, DownloadThreadInfo.parse(ioThreadExecutor));
        r102.put(MonitorConstants.MIX_DEFAULT, DownloadThreadInfo.parse(mixDefaultDownloadExecutor));
        r102.put(MonitorConstants.MIX_APK, DownloadThreadInfo.parse(mixApkDownloadExecutor));
        r102.put("db", DownloadThreadInfo.parse(dbThreadExecutor));
        r102.put(MonitorConstants.CHUNK, DownloadThreadInfo.parse(chunkDownloadExecutor));
        r102.put(MonitorConstants.SEGMENT, DownloadThreadInfo.parse(segmentThreadExecutor));
        r102.put(MonitorConstants.OKHTTP, DownloadThreadInfo.parse(okHttpDispatcherExecutor));
        r102.put(MonitorConstants.SCHEDULE, DownloadThreadInfo.parse(scheduledExecutor));
        r102.put("single", DownloadThreadInfo.parse(singleThreadExecutor));
        r102.put("custom", DownloadThreadInfo.parse(customThreadExecutor));
        return;
    L8:
        r102 = r100.getThreadInfo().afterDownloadThreadExecutors;
        goto L10
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_android_socialbase_downloader_downloader_DownloadComponentManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    private static OkHttpClient selectWifiByRoute(InetAddress r100, Network r101, LinkProperties r102) {
        if (r100 == null) goto L21;
        if (r102 == null) goto L21;
        Iterator<RouteInfo> r103 = r102.getRoutes().iterator();
    L8:
        if (r103.hasNext() == false) goto L21;
        RouteInfo r104 = r103.next();
        if (r104 == null) goto L8;
    L19:
        th = move-exception;
        Logger.e(TAG, "forceWifi select wifi network error", th);
        goto L8
    L12:
        if (r104.matches(r100) == false) goto L8;
        if (r104.getDestination() == null) goto L8;
        if (r104.getDestination().getPrefixLength() <= 0) goto L8;
        return buildBoundClient(r101);
    L21:
        return null;
    }

    public static Future submitScheduleTask(Runnable r100, long r101, TimeUnit r102) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return getScheduledExecutorService().schedule(r100, r101, r102);
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean r100, int r101, String r102, List<HttpHeader> r103) throws Exception {
        return ((IDownloadNetworkService) DownloadServiceManager.getService(IDownloadNetworkService.class)).downloadWithConnection(r100, r101, handleConnection(r102, r103), r103);
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean r110, int r111, String r112, String r113, List<HttpHeader> r114, int r115, boolean r116, DownloadInfo r117) throws Exception {
        return ((IDownloadNetworkService) DownloadServiceManager.getService(IDownloadNetworkService.class)).downloadWithConnection(r110, r111, handleConnection(r112, r114), r113, r114, r115, r116, r117);
    }
}
