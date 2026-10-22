package com.ss.android.socialbase.downloader.service;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceLoader;
import com.ss.android.socialbase.downloader.logger.Logger;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadServiceManager {
    private static final String DOWNLOAD_SERVICE_LOADER = "com.ss.android.socialbase.downloader.service.DownloadServiceLoader";
    private static final ConcurrentHashMap<Class, Object> SERVICES = null;
    private static final String TAG = null;
    private static String defaultLoadMsg;
    private static volatile boolean isLoadService;

    public DownloadServiceManager() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static void setServiceLoaded() {
        isLoadService = true;
    }

    static {
        TAG = "DownloadServiceManager";
        SERVICES = new ConcurrentHashMap();
        defaultLoadMsg = null;
        isLoadService = false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_socialbase_downloader_service_DownloadServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static <T> T getService(Class<T> r100) {
        if (isLoadService == true) goto L6;
        loadDefaultService(DOWNLOAD_SERVICE_LOADER);
    L6:
        return (T) SERVICES.get(r100);
    }

    private static void loadDefaultService(String r100) {
        monitor-enter(DownloadServiceManager.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isLoadService == false) goto L9;
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L16
        return;
    L9:
        if (runLoad(r100) == false) goto L13;
        isLoadService = true;     // Catch: Throwable -> L16
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L16
        return;
    L13:
        registerService(IDownloadMonitorHelperService.class, new IDownloadMonitorHelperService.DefaultDownloadMonitorHelperService());     // Catch: Throwable -> L16
        registerService(IDownloadIdGeneratorService.class, new IDownloadIdGeneratorService.DefaultDownloadIdGeneratorService());     // Catch: Throwable -> L16
        registerService(IDownloadComponentManagerService.class, new IDownloadComponentManagerService.DefaultDownloadComponentManagerService());     // Catch: Throwable -> L16
        registerService(IDownloadProcessDispatcherService.class, new IDownloadProcessDispatcherService.DefaultDownloadProcessDispatcherService());     // Catch: Throwable -> L16
        registerService(IDownloadNetTrafficManagerService.class, new IDownloadNetTrafficManagerService.DefaultDownloadNetTrafficManagerService());     // Catch: Throwable -> L16
        registerService(IDownloadNotificationManagerService.class, new IDownloadNotificationManagerService.DefaultDownloadNotificationManagerService());     // Catch: Throwable -> L16
        registerService(IDownloadNetworkService.class, new IDownloadNetworkService.DefaultDownloadNetworkService());     // Catch: Throwable -> L16
        registerService(IDownloadRetrySchedulerService.class, new IDownloadRetrySchedulerService.DefaultDownloadRetrySchedulerService());     // Catch: Throwable -> L16
        registerService(IDownloadMultiProcService.class, new IDownloadMultiProcService.DefaultDownloadMultiProcService());     // Catch: Throwable -> L16
        registerService(IDownloadGlobalThrottleService.class, new IDownloadGlobalThrottleService.DefaultDownloadGlobalThrottleService());     // Catch: Throwable -> L16
        Logger.globalError(TAG, "loadDefaultService", "Run");     // Catch: Throwable -> L16
        isLoadService = true;     // Catch: Throwable -> L16
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L16
    }

    public static void loadService(IDownloadServiceLoader r100) {
        if (r100 == null) goto L9;
        r100.load();
        String r101 = defaultLoadMsg;
        if (r101 != null) goto L6;
        boolean r102 = true;
    L7:
        r100.defaultLoadCallback(r102, r101);
        return;
    L6:
        r102 = false;
        goto L7
    }

    public static boolean runLoad(String r100) {
        Class r101 = INVOKESTATIC_com_ss_android_socialbase_downloader_service_DownloadServiceManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Throwable -> L8
        r101.getMethod("load", new Class[0]).invoke(r101.newInstance(), new Object[0]);     // Catch: Throwable -> L8
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "runLoad", "Run load :" + r100 + " success");     // Catch: Throwable -> L8
        return true;
    L13:
        return true;
    L8:
        th = move-exception;
        defaultLoadMsg = th.toString();
        Logger.globalError(TAG, "runLoad", "Run load :" + r100 + "fail, " + th.toString());
        th.printStackTrace();
        return false;
    }

    public static <T> void registerService(Class<T> r100, T r101) {
        SERVICES.put(r100, r101);
    }
}
