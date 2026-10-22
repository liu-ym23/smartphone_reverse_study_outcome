package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCdnListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DownloadTask {
    private static final int CALL_STACK_START_INDEX = 2;
    private static final String TAG = "DownloadTask";
    private boolean autoRemoveCallback;
    private boolean autoSetHashCodeForSameTask;
    private IDownloadCdnListener cdnListener;
    private IDownloadDepend depend;
    private IDownloadDiskSpaceHandler diskSpaceHandler;
    private final List<IDownloadCompleteHandler> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.Builder downloadInfoBuilder;
    private IDownloadFileUriProvider fileUriProvider;
    private IDownloadForbiddenHandler forbiddenHandler;
    private int hashCodeForSameTask;
    private IDownloadInterceptor interceptor;
    private int mPriority;
    private JSONObject mReplaceSetting;
    private final Map<Integer, IDownloadListener> mainThreadListeners;
    private IDownloadMonitorDepend monitorDepend;
    private boolean needDelayForCacheSync;
    private INotificationClickCallback notificationClickCallback;
    private IDownloadNotificationEventListener notificationEventListener;
    private final Map<Integer, IDownloadListener> notificationListeners;
    private final Map<Integer, ListenerType> singleListenerHashCodeMap;
    private final Map<ListenerType, IDownloadListener> singleListenerMap;
    private final Map<Integer, IDownloadListener> subThreadListeners;
    private DownloadThreadInfo threadInfo;
    private DownloadTimingInfo timingInfo;

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        monitor-enter(this);
        IDownloadListener r100 = getSingleDownloadListener(ListenerType.MAIN);     // Catch: Throwable -> L11
        if (r100 != null) goto L6;
        r100 = getSingleDownloadListener(ListenerType.SUB);     // Catch: Throwable -> L11
    L6:
        if (r100 == null) goto L8;
        this.hashCodeForSameTask = r100.hashCode();     // Catch: Throwable -> L11
    L8:
        int r101 = this.hashCodeForSameTask;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    public DownloadTask headConnectionAvailable(boolean r100) {
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean r100) {
        return this;
    }

    public DownloadTask needRetryDelay(boolean r100) {
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean r100) {
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean r100) {
        return this;
    }

    public DownloadTask newSaveTempFileEnable(boolean r100) {
        return this;
    }

    public DownloadTask retryDelayTimeArray(String r100) {
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(IRetryDelayTimeCalculator r100) {
        return this;
    }

    private void handleBuildParams() {
    L104:
        th = move-exception;
        Logger.globalError(TAG, "beforeBuild", "Error:" + th);
        return;
    L4:
        if (TextUtils.isEmpty(this.downloadInfoBuilder.monitorScene) == false) goto L6;
        return;
    L6:
        JSONObject r100 = DownloadSetting.getGlobalTaskSettings();     // Catch: Throwable -> L104
        if (r100 != null) goto L9;
        return;
    L9:
        JSONObject r101 = r100.optJSONObject(this.downloadInfoBuilder.monitorScene);     // Catch: Throwable -> L104
        if (r101 != null) goto L12;
        return;
    L12:
        JSONObject r102 = r101.optJSONObject(DownloadSettingKeys.REPLACE_DOWNLOAD_TASK_PARAM);     // Catch: Throwable -> L104
        this.mReplaceSetting = r102;     // Catch: Throwable -> L104
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.has(DownloadSettingKeys.DownloadTaskParam.IGNORE_INTERCEPTOR) == false) goto L23;
        DownloadInfo.Builder r103 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.IGNORE_INTERCEPTOR) <= 0) goto L20;
        boolean r104 = true;
    L21:
        r103.ignoreInterceptor(r104);     // Catch: Throwable -> L104
        goto L23
    L20:
        r104 = false;
    L23:
        if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.INNER_SAVE_PATH) == false) goto L26;
        this.downloadInfoBuilder.savePath(DownloadDirUtils.getDownloadPath());     // Catch: Throwable -> L104
    L26:
        if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.AUTO_REMOVE_CALLBACK) == false) goto L33;
        if (this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.AUTO_REMOVE_CALLBACK) <= 0) goto L30;
        boolean r105 = true;
    L31:
        this.autoRemoveCallback = r105;     // Catch: Throwable -> L104
        goto L33
    L30:
        r105 = false;
    L33:
        if (this.mReplaceSetting.has("extra") == false) goto L36;
        this.downloadInfoBuilder.extra(this.mReplaceSetting.optString("extra"));     // Catch: Throwable -> L104
    L36:
        if (this.mReplaceSetting.has("only_wifi") == false) goto L43;
        DownloadInfo.Builder r106 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("only_wifi") <= 0) goto L40;
        boolean r107 = true;
    L41:
        r106.onlyWifi(r107);     // Catch: Throwable -> L104
        goto L43
    L40:
        r107 = false;
    L43:
        if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.EXTRA_HEADERS) == false) goto L52;
        JSONObject r108 = this.mReplaceSetting.optJSONObject(DownloadSettingKeys.DownloadTaskParam.EXTRA_HEADERS);     // Catch: Throwable -> L104
        if (r108 == null) goto L52;
        ArrayList r109 = new ArrayList();     // Catch: Throwable -> L104
        Iterator<String> r110 = r108.keys();     // Catch: Throwable -> L104
    L48:
        if (r110.hasNext() == false) goto L50;
        String r111 = r110.next();     // Catch: Throwable -> L104
        r109.add(new HttpHeader(r111, r108.optString(r111)));     // Catch: Throwable -> L104
        goto L48
    L50:
        this.downloadInfoBuilder.extraHeaders(r109);     // Catch: Throwable -> L104
    L52:
        if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.MAX_BYTES) == false) goto L55;
        this.downloadInfoBuilder.maxBytes(this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.MAX_BYTES));     // Catch: Throwable -> L104
    L55:
        if (this.mReplaceSetting.has("retry_count") == false) goto L58;
        this.downloadInfoBuilder.retryCount(this.mReplaceSetting.optInt("retry_count"));     // Catch: Throwable -> L104
    L58:
        if (this.mReplaceSetting.has("force") == false) goto L65;
        DownloadInfo.Builder r112 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("force") <= 0) goto L62;
        boolean r113 = true;
    L63:
        r112.force(r113);     // Catch: Throwable -> L104
        goto L65
    L62:
        r113 = false;
    L65:
        if (this.mReplaceSetting.has("show_notification") == false) goto L72;
        DownloadInfo.Builder r114 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("show_notification") <= 0) goto L69;
        boolean r115 = true;
    L70:
        r114.showNotification(r115);     // Catch: Throwable -> L104
        goto L72
    L69:
        r115 = false;
    L72:
        if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.SHOW_NOTIFICATION_FOR_AUTO_RESUMED) == false) goto L79;
        DownloadInfo.Builder r116 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.SHOW_NOTIFICATION_FOR_AUTO_RESUMED) <= 0) goto L76;
        boolean r117 = true;
    L77:
        r116.showNotificationForAutoResumed(r117);     // Catch: Throwable -> L104
        goto L79
    L76:
        r117 = false;
    L79:
        if (this.mReplaceSetting.has("executor_group") == false) goto L82;
        this.downloadInfoBuilder.executorGroup(this.mReplaceSetting.optInt("executor_group"));     // Catch: Throwable -> L104
    L82:
        if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.TTNET_PROTECT_TIMEOUT) == false) goto L85;
        this.downloadInfoBuilder.ttnetProtectTimeout(this.mReplaceSetting.optLong(DownloadSettingKeys.DownloadTaskParam.TTNET_PROTECT_TIMEOUT));     // Catch: Throwable -> L104
    L85:
        if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.ADD_TTNET_COMMON_PARAM) == false) goto L92;
        DownloadInfo.Builder r118 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.ADD_TTNET_COMMON_PARAM) <= 0) goto L89;
        boolean r119 = true;
    L90:
        r118.addTTNetCommonParam(r119);     // Catch: Throwable -> L104
        goto L92
    L89:
        r119 = false;
    L92:
        if (this.mReplaceSetting.has("distinct_directory") == false) goto L99;
        DownloadInfo.Builder r120 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("distinct_directory") <= 0) goto L96;
        boolean r121 = true;
    L97:
        r120.distinctDirectory(r121);     // Catch: Throwable -> L104
        goto L99
    L96:
        r121 = false;
    L99:
        if (this.mReplaceSetting.has("fast_download") == true) goto L101;
        return;
    L101:
        if (this.mReplaceSetting.optInt("fast_download") <= 0) goto L111;
        this.downloadInfoBuilder.fastDownload();     // Catch: Throwable -> L104
        return;
    }

    public void addListenerToDownloadingSameTask() {
        DownloadInfo r100 = this.downloadInfo;
        if (r100 != null) goto L5;
    L10:
        addListenerToDownloadingSameTask(ListenerType.MAIN);
        addListenerToDownloadingSameTask(ListenerType.SUB);
        ((IDownloadMonitorHelperService) DownloadServiceManager.getService(IDownloadMonitorHelperService.class)).monitorSendWithTaskMonitor(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
        return;
    L5:
        if (Logger.debugScene(r100) == false) goto L8;
        Logger.taskDebug(TAG, this.downloadInfo, "addListenerToDownloadingSameTask", "Same task just tryDownloading, so add listener in last task instead of tryDownload");
    L8:
        if (this.downloadInfo.isAddListenerToSameTask() == true) goto L10;
        this.downloadInfo.setAddListenerToSameTask(true);
        goto L10
    }

    public DownloadInfo buildDownloadInfo() {
        return this.downloadInfoBuilder.build();
    }

    public boolean canShowNotification() {
        DownloadInfo r100 = this.downloadInfo;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.canShowNotification();
    }

    public DownloadTask fastDownload() {
        this.downloadInfoBuilder.fastDownload();
        return this;
    }

    public DownloadTask fastDownloadCommonThreadPool() {
        this.downloadInfoBuilder.fastDownloadCommonThreadPool();
        return this;
    }

    public int getDownloadId() {
        DownloadInfo r100 = this.downloadInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getId();
    }

    public DownloadTask handleRequest() {
        this.downloadInfoBuilder.handleRequest();
        return this;
    }

    public DownloadTask resumeFileDownload() {
        this.downloadInfoBuilder.resumeFileDownload();
        return this;
    }

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new ConcurrentHashMap();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new CopyOnWriteArrayList();
        this.autoRemoveCallback = false;
        this.timingInfo = new DownloadTimingInfo();
        this.threadInfo = new DownloadThreadInfo();
        this.autoSetHashCodeForSameTask = true;
        this.mPriority = 0;
        this.downloadInfoBuilder = new DownloadInfo.Builder();
        this.mainThreadListeners = new ConcurrentHashMap();
        this.subThreadListeners = new ConcurrentHashMap();
        this.notificationListeners = new ConcurrentHashMap();
    }

    private int downloadImpl() {
        long r100 = System.currentTimeMillis();
        handleBuildParams();
        this.downloadInfo = this.downloadInfoBuilder.build();
        DownloadTimingInfo r101 = this.timingInfo;
        r101.callDownloadTime = r100;
        r101.buildDownloadInfoTime = System.currentTimeMillis();
        IDownloadProcessDispatcherService r102 = (IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class);
        if (r102.getDownloadInfo(this.downloadInfo.getId()) != null) goto L5;
        ((IDownloadMonitorHelperService) DownloadServiceManager.getService(IDownloadMonitorHelperService.class)).monitorSend(this, null, 0);
    L5:
        r102.tryDownload(this);
        DownloadInfo r103 = this.downloadInfo;
        if (r103 != null) goto L9;
        return 0;
    L9:
        return r103.getId();
    }

    public DownloadTask callStack() {
        int r100 = 2;
        int r101 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.MONITOR_BIZ_STACK_ROW_COUNT, 2);
        if (r101 > 0) goto L5;
    L23:
        return this;
    L5:
        if (this.downloadInfoBuilder.callStack != null) goto L23;
        StackTraceElement[] r102 = new Throwable().getStackTrace();     // Catch: Throwable -> L21
        if (r102 != null) goto L10;
        return this;
    L10:
        int r103 = r101 + 2;     // Catch: Throwable -> L21
        if (r103 <= r102.length) goto L13;
        r103 = r102.length;     // Catch: Throwable -> L21
    L13:
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L21
    L14:
        if (r100 >= r103) goto L17;
        r104.append(r102[r100]);     // Catch: Throwable -> L21
        r100 = r100 + 1;     // Catch: Throwable -> L21
        goto L14
    L17:
        if (r104.length() > 0) goto L19;
        return this;
    L19:
        this.downloadInfoBuilder.callStack(r104.toString());     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Logger.globalError(TAG, "callStack", "Error:" + th);
        goto L23
    }

    public int download() {
        callStack();
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_ANR_REMOVE_REPORT_IDLE_STATUS) <= 0) goto L5;
        long r100 = System.currentTimeMillis();
        handleBuildParams();
        this.downloadInfo = this.downloadInfoBuilder.build();
        DownloadTimingInfo r101 = this.timingInfo;
        r101.callDownloadTime = r100;
        r101.buildDownloadInfoTime = System.currentTimeMillis();
        int r102 = this.downloadInfo.getId();
        ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).tryDownload(this);
        return r102;
    L5:
        return downloadImpl();
    }

    public IDownloadCdnListener getCdnListener() {
        return this.cdnListener;
    }

    public IDownloadDepend getDepend() {
        return this.depend;
    }

    public IDownloadDiskSpaceHandler getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public IDownloadForbiddenHandler getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public IDownloadMonitorDepend getMonitorDepend() {
        return this.monitorDepend;
    }

    public INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public IDownloadNotificationEventListener getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public int getTaskPriority() {
        return this.mPriority;
    }

    public DownloadThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    public DownloadTimingInfo getTimingInfo() {
        return this.timingInfo;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public DownloadTask(DownloadInfo r100) {
        this();
        this.downloadInfo = r100;
    }

    private void addListenerToDownloadingSameTask(ListenerType r100) {
        Map<Integer, IDownloadListener> r101 = getDownloadListeners(r100);
        if (r101 != null) goto L6;
        Logger.taskError(TAG, getDownloadId(), "addListenerToDownloadingSameTask", "ListenerType is null");
        return;
    L6:
        Iterator<IDownloadListener> r102 = r101.values().iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        IDownloadListener r103 = r102.next();
        if (r103 == null) goto L8;
        ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).addDownloadListener(getDownloadId(), r103, r100, false);
        goto L8
    }

    private int[] setToInt(Set<Integer> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L14;
        Object[] r101 = r100.toArray();
        int[] r102 = new int[r101.length];
        int r103 = 0;
    L8:
        if (r103 >= r101.length) goto L10;
        r102[r103] = ((Integer) r101[r103]).intValue();
        r103 = r103 + 1;
        goto L8
    L10:
        return r102;
    L14:
        return null;
    }

    public DownloadTask accessHttpHeaderKeys(List<String> r100) {
        this.downloadInfoBuilder.accessHttpHeaderKeys(r100);
        return this;
    }

    public DownloadTask addDownloadCompleteHandler(IDownloadCompleteHandler r100) {
        List<IDownloadCompleteHandler> r101 = this.downloadCompleteHandlers;
        monitor-enter(r101);
        if (r100 != null) goto L16;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return this;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.downloadCompleteHandlers.contains(r100) == true) goto L11;
        this.downloadCompleteHandlers.add(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        return this;
    }

    public DownloadTask addListenerToSameTask(boolean r100) {
        this.downloadInfoBuilder.addListenerToSameTask(r100);
        return this;
    }

    public DownloadTask addTTNetCommonParam(boolean r100) {
        this.downloadInfoBuilder.addTTNetCommonParam(r100);
        return this;
    }

    public void asyncDownload(final IDownloadStartCallback r100) {
        callStack();
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).submitSingleTask(new AnonymousClass1(this, r100));
    }

    public DownloadTask autoRemoveCallback(boolean r100) {
        this.autoRemoveCallback = r100;
        return this;
    }

    public DownloadTask autoResumed(boolean r100) {
        this.downloadInfoBuilder.autoResumed(r100);
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean r100) {
        this.autoSetHashCodeForSameTask = r100;
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int r100) {
        this.downloadInfoBuilder.backUpUrlRetryCount(r100);
        return this;
    }

    public DownloadTask backUpUrls(List<String> r100) {
        this.downloadInfoBuilder.backUpUrls(r100);
        return this;
    }

    public DownloadTask cdnListener(IDownloadCdnListener r100) {
        this.cdnListener = r100;
        return this;
    }

    public DownloadTask cdnUrls(List<String> r100) {
        this.downloadInfoBuilder.cdnUrls(r100);
        return this;
    }

    public DownloadTask concurrentConnCount(int r100) {
        this.downloadInfoBuilder.concurrentConnCount(r100);
        return this;
    }

    public void copyInterfaceFromNewTask(DownloadTask r100) {
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(r100.singleListenerMap);
        Map<Integer, IDownloadListener> r101 = this.mainThreadListeners;
        monitor-enter(r101);
        this.mainThreadListeners.clear();     // Catch: Throwable -> L28
        addAll(r100.mainThreadListeners, this.mainThreadListeners);     // Catch: Throwable -> L28
        monitor-exit(r101);     // Catch: Throwable -> L28
        Map<Integer, IDownloadListener> r102 = this.subThreadListeners;
        monitor-enter(r102);
        this.subThreadListeners.clear();     // Catch: Throwable -> L25
        addAll(r100.subThreadListeners, this.subThreadListeners);     // Catch: Throwable -> L25
        monitor-exit(r102);     // Catch: Throwable -> L25
        Map<Integer, IDownloadListener> r103 = this.notificationListeners;
        monitor-enter(r103);
        this.notificationListeners.clear();     // Catch: Throwable -> L22
        addAll(r100.notificationListeners, this.notificationListeners);     // Catch: Throwable -> L22
        monitor-exit(r103);     // Catch: Throwable -> L22
        this.notificationEventListener = r100.notificationEventListener;
        this.interceptor = r100.interceptor;
        this.depend = r100.depend;
        this.monitorDepend = r100.monitorDepend;
        this.forbiddenHandler = r100.forbiddenHandler;
        this.diskSpaceHandler = r100.diskSpaceHandler;
        this.notificationClickCallback = r100.notificationClickCallback;
        this.fileUriProvider = r100.fileUriProvider;
        List<IDownloadCompleteHandler> r104 = this.downloadCompleteHandlers;
        monitor-enter(r104);
        this.downloadCompleteHandlers.clear();     // Catch: Throwable -> L19
        this.downloadCompleteHandlers.addAll(r100.downloadCompleteHandlers);     // Catch: Throwable -> L19
        monitor-exit(r104);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    L25:
        th = move-exception;
        throw th;
    L28:
        th = move-exception;
        throw th;
    }

    public void copyListenerFromPendingTask(DownloadTask r100) {
        Iterator<Map.Entry<ListenerType, IDownloadListener>> r101 = r100.singleListenerMap.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L48;
        Map.Entry<ListenerType, IDownloadListener> r102 = r101.next();
        if (r102 == null) goto L4;
        if (this.singleListenerMap.containsKey(r102.getKey()) == true) goto L4;
        this.singleListenerMap.put(r102.getKey(), r102.getValue());
        goto L4
    L48:
    L41:
        th = move-exception;
        th.printStackTrace();
        return;
    L12:
        if (r100.mainThreadListeners.size() == 0) goto L22;
        Map<Integer, IDownloadListener> r103 = this.mainThreadListeners;     // Catch: Throwable -> L41
        monitor-enter(r103);     // Catch: Throwable -> L41
        removeAll(this.mainThreadListeners, r100.mainThreadListeners);     // Catch: Throwable -> L18
        addAll(r100.mainThreadListeners, this.mainThreadListeners);     // Catch: Throwable -> L18
        monitor-exit(r103);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L22:
        if (r100.subThreadListeners.size() == 0) goto L32;
        Map<Integer, IDownloadListener> r104 = this.subThreadListeners;     // Catch: Throwable -> L41
        monitor-enter(r104);     // Catch: Throwable -> L41
        removeAll(this.subThreadListeners, r100.subThreadListeners);     // Catch: Throwable -> L28
        addAll(r100.subThreadListeners, this.subThreadListeners);     // Catch: Throwable -> L28
        monitor-exit(r104);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L32:
        if (r100.notificationListeners.size() == 0) goto L57;
        Map<Integer, IDownloadListener> r105 = this.notificationListeners;     // Catch: Throwable -> L41
        monitor-enter(r105);     // Catch: Throwable -> L41
        removeAll(this.notificationListeners, r100.notificationListeners);     // Catch: Throwable -> L38
        addAll(r100.notificationListeners, this.notificationListeners);     // Catch: Throwable -> L38
        monitor-exit(r105);     // Catch: Throwable -> L38
    L58:
        return;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean r100) {
        this.downloadInfoBuilder.deleteCacheIfCheckFailed(r100);
        return this;
    }

    public DownloadTask depend(IDownloadDepend r100) {
        this.depend = r100;
        return this;
    }

    public DownloadTask diskSpaceHandler(IDownloadDiskSpaceHandler r100) {
        this.diskSpaceHandler = r100;
        return this;
    }

    public DownloadTask distinctDirectory(boolean r100) {
        this.downloadInfoBuilder.distinctDirectory(r100);
        return this;
    }

    public DownloadTask downloadSetting(JSONObject r100) {
        this.downloadInfoBuilder.downloadSetting(r100);
        return this;
    }

    public DownloadTask endOffset(long r100) {
        this.downloadInfoBuilder.endOffset(r100);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType r100) {
        this.downloadInfoBuilder.enqueueType(r100);
        return this;
    }

    public DownloadTask executorGroup(int r100) {
        this.downloadInfoBuilder.executorGroup(r100);
        return this;
    }

    public DownloadTask expectFileLength(long r100) {
        this.downloadInfoBuilder.expectFileLength(r100);
        return this;
    }

    public DownloadTask expiredHttpCheck(boolean r100) {
        this.downloadInfoBuilder.expiredHttpCheck(r100);
        return this;
    }

    public DownloadTask expiredRedownload(boolean r100) {
        this.downloadInfoBuilder.expiredRedownload(r100);
        return this;
    }

    public DownloadTask extra(String r100) {
        this.downloadInfoBuilder.extra(r100);
        return this;
    }

    public DownloadTask extraHeaders(List<HttpHeader> r100) {
        this.downloadInfoBuilder.extraHeaders(r100);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] r100) {
        this.downloadInfoBuilder.extraMonitorStatus(r100);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider r100) {
        this.fileUriProvider = r100;
        return this;
    }

    public DownloadTask forbiddenHandler(IDownloadForbiddenHandler r100) {
        this.forbiddenHandler = r100;
        return this;
    }

    public DownloadTask force(boolean r100) {
        this.downloadInfoBuilder.force(r100);
        return this;
    }

    public DownloadTask forceWifiBound(boolean r100) {
        this.downloadInfoBuilder.forceWifiBound(r100);
        return this;
    }

    public IDownloadCompleteHandler getDownloadCompleteHandlerByIndex(int r100) {
        List<IDownloadCompleteHandler> r101 = this.downloadCompleteHandlers;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r100 >= this.downloadCompleteHandlers.size()) goto L9;
        IDownloadCompleteHandler r102 = this.downloadCompleteHandlers.get(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return null;
    }

    public int[] getDownloadListenerHashCodeLists(ListenerType r100) {
        if (r100 != ListenerType.MAIN) goto L7;
        return setToInt(this.mainThreadListeners.keySet());
    L7:
        if (r100 != ListenerType.SUB) goto L11;
        return setToInt(this.subThreadListeners.keySet());
    L11:
        if (r100 == ListenerType.NOTIFICATION) goto L13;
        return null;
    L13:
        return setToInt(this.notificationListeners.keySet());
    }

    public Map<Integer, IDownloadListener> getDownloadListeners(ListenerType r100) {
        if (r100 != ListenerType.MAIN) goto L7;
        return this.mainThreadListeners;
    L7:
        if (r100 != ListenerType.SUB) goto L11;
        return this.subThreadListeners;
    L11:
        if (r100 == ListenerType.NOTIFICATION) goto L13;
        return null;
    L13:
        return this.notificationListeners;
    }

    public IDownloadListener getSingleDownloadListener(ListenerType r100) {
        return this.singleListenerMap.get(r100);
    }

    public DownloadTask hashCodeForSameTask(int r100) {
        this.hashCodeForSameTask = r100;
        return this;
    }

    public DownloadTask iconUrl(String r100) {
        this.downloadInfoBuilder.iconUrl(r100);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean r100) {
        this.downloadInfoBuilder.ignoreDataVerify(r100);
        return this;
    }

    public DownloadTask ignoreInterceptor(boolean r100) {
        this.downloadInfoBuilder.ignoreInterceptor(r100);
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor r100) {
        this.interceptor = r100;
        return this;
    }

    public DownloadTask isOpenLimitSpeed(boolean r100) {
        this.downloadInfoBuilder.isOpenLimitSpeed(r100);
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener r100) {
        if (r100 != null) goto L5;
        return this;
    L5:
        return mainThreadListenerWithHashCode(r100.hashCode(), r100);
    }

    public DownloadTask maxBytes(int r100) {
        this.downloadInfoBuilder.maxBytes(r100);
        return this;
    }

    public DownloadTask maxProgressCount(int r100) {
        this.downloadInfoBuilder.maxProgressCount(r100);
        return this;
    }

    public DownloadTask md5(String r100) {
        this.downloadInfoBuilder.md5(r100);
        return this;
    }

    public DownloadTask mimeType(String r100) {
        this.downloadInfoBuilder.mimeType(r100);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int r100) {
        this.downloadInfoBuilder.minProgressTimeMsInterval(r100);
        return this;
    }

    public DownloadTask monitorDepend(IDownloadMonitorDepend r100) {
        this.monitorDepend = r100;
        return this;
    }

    public DownloadTask monitorScene(String r100) {
        this.downloadInfoBuilder.monitorScene(r100);
        return this;
    }

    public DownloadTask name(String r100) {
        this.downloadInfoBuilder.name(r100);
        return this;
    }

    public DownloadTask needCurrentProcess(boolean r100) {
        this.downloadInfoBuilder.needCurrentProcess(r100);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean r100) {
        this.downloadInfoBuilder.needDefaultHttpServiceBackUp(r100);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean r100) {
        this.downloadInfoBuilder.needHttpsToHttpRetry(r100);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean r100) {
        this.downloadInfoBuilder.needIndependentProcess(r100);
        return this;
    }

    public DownloadTask needPostProgress(boolean r100) {
        this.downloadInfoBuilder.needPostProgress(r100);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean r100) {
        this.downloadInfoBuilder.needSDKMonitor(r100);
        return this;
    }

    public DownloadTask notificationClickCallback(INotificationClickCallback r100) {
        this.notificationClickCallback = r100;
        return this;
    }

    public DownloadTask notificationEventListener(IDownloadNotificationEventListener r100) {
        this.notificationEventListener = r100;
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener r100) {
        if (r100 != null) goto L5;
        return this;
    L5:
        return notificationListenerWithHashCode(r100.hashCode(), r100);
    }

    public DownloadTask onlyWifi(boolean r100) {
        this.downloadInfoBuilder.onlyWifi(r100);
        return this;
    }

    public DownloadTask outIp(String[] r100) {
        this.downloadInfoBuilder.outIp(r100);
        return this;
    }

    public DownloadTask outSize(int[] r100) {
        this.downloadInfoBuilder.outSize(r100);
        return this;
    }

    public DownloadTask packageName(String r100) {
        this.downloadInfoBuilder.packageName(r100);
        return this;
    }

    public DownloadTask pcdnUrls(List<String> r100) {
        this.downloadInfoBuilder.pcdnUrls(r100);
        return this;
    }

    public DownloadTask retryCount(int r100) {
        this.downloadInfoBuilder.retryCount(r100);
        return this;
    }

    public DownloadTask savePath(String r100) {
        this.downloadInfoBuilder.savePath(r100);
        return this;
    }

    public DownloadTask setAutoInstall(boolean r100) {
        this.downloadInfoBuilder.setAutoInstall(r100);
        return this;
    }

    public DownloadTask setCacheLifeTimeMax(long r100) {
        this.downloadInfoBuilder.cacheLifeTimeMax(r100);
        return this;
    }

    public DownloadTask setDownloadCompleteHandlers(List<IDownloadCompleteHandler> r100) {
        if (r100 != null) goto L4;
    L9:
        return this;
    L4:
        if (r100.isEmpty() == true) goto L9;
        Iterator<IDownloadCompleteHandler> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        addDownloadCompleteHandler(r101.next());
        goto L7
    }

    public void setNeedDelayForCacheSync(boolean r100) {
        this.needDelayForCacheSync = r100;
    }

    public void setNotificationEventListener(IDownloadNotificationEventListener r100) {
        this.notificationEventListener = r100;
    }

    public DownloadTask setTaskPriority(int r100) {
        this.mPriority = r100;
        return this;
    }

    public DownloadTask showNotification(boolean r100) {
        this.downloadInfoBuilder.showNotification(r100);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean r100) {
        this.downloadInfoBuilder.showNotificationForAutoResumed(r100);
        return this;
    }

    public DownloadTask startOffset(long r100) {
        this.downloadInfoBuilder.startOffset(r100);
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener r100) {
        if (r100 != null) goto L5;
        return this;
    L5:
        return subThreadListenerWithHashCode(r100.hashCode(), r100);
    }

    public DownloadTask taskKey(String r100) {
        this.downloadInfoBuilder.taskKey(r100);
        return this;
    }

    public DownloadTask tempPath(String r100) {
        this.downloadInfoBuilder.tempPath(r100);
        return this;
    }

    public DownloadTask throttleNetSpeed(long r100) {
        this.downloadInfoBuilder.throttleNetSpeed(r100);
        return this;
    }

    public DownloadTask throttleSmoothness(int r100) {
        this.downloadInfoBuilder.throttleSmoothness(r100);
        return this;
    }

    public DownloadTask title(String r100) {
        this.downloadInfoBuilder.title(r100);
        return this;
    }

    public DownloadTask ttnetByPassProxy(boolean r100) {
        this.downloadInfoBuilder.ttnetByPassProxy(r100);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long r100) {
        this.downloadInfoBuilder.ttnetProtectTimeout(r100);
        return this;
    }

    public DownloadTask url(String r100) {
        this.downloadInfoBuilder.url(r100);
        return this;
    }

    private void addAll(Map<Integer, IDownloadListener> r100, Map<Integer, IDownloadListener> r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L11;
        Iterator<Map.Entry<Integer, IDownloadListener>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<Integer, IDownloadListener> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private void copyListeners(Map<Integer, IDownloadListener> r100, Map<Integer, IDownloadListener> r101) {
        r100.clear();
        Iterator<Map.Entry<Integer, IDownloadListener>> r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<Integer, IDownloadListener> r103 = r102.next();
        if (r103.getValue() == null) goto L4;
        r100.put(r103.getKey(), r103.getValue());
        goto L4
    }

    private void removeAll(Map<Integer, IDownloadListener> r100, Map<Integer, IDownloadListener> r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L11;
        Iterator<Map.Entry<Integer, IDownloadListener>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        r100.remove(r102.next().getKey());
        goto L7
    L12:
        return;
    L11:
        return;
    }

    public IDownloadListener getDownloadListenerByHashCode(ListenerType r100, int r101) {
        if (r100 != ListenerType.MAIN) goto L7;
        return this.mainThreadListeners.get(Integer.valueOf(r101));
    L7:
        if (r100 != ListenerType.SUB) goto L11;
        return this.subThreadListeners.get(Integer.valueOf(r101));
    L11:
        if (r100 == ListenerType.NOTIFICATION) goto L13;
        return null;
    L13:
        return this.notificationListeners.get(Integer.valueOf(r101));
    }

    public DownloadTask mainThreadListenerWithHashCode(int r100, IDownloadListener r101) {
        if (r101 == null) goto L18;
        Map<Integer, IDownloadListener> r102 = this.mainThreadListeners;
        monitor-enter(r102);
        this.mainThreadListeners.put(Integer.valueOf(r100), r101);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        Map<ListenerType, IDownloadListener> r103 = this.singleListenerMap;
        ListenerType r104 = ListenerType.MAIN;
        r103.put(r104, r101);
        Map<Integer, ListenerType> r105 = this.singleListenerHashCodeMap;
        monitor-enter(r105);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r100), r104);     // Catch: Throwable -> L12
        monitor-exit(r105);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public DownloadTask notificationListenerWithHashCode(int r100, IDownloadListener r101) {
        if (r101 == null) goto L18;
        Map<Integer, IDownloadListener> r102 = this.notificationListeners;
        monitor-enter(r102);
        this.notificationListeners.put(Integer.valueOf(r100), r101);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        Map<ListenerType, IDownloadListener> r103 = this.singleListenerMap;
        ListenerType r104 = ListenerType.NOTIFICATION;
        r103.put(r104, r101);
        Map<Integer, ListenerType> r105 = this.singleListenerHashCodeMap;
        monitor-enter(r105);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r100), r104);     // Catch: Throwable -> L12
        monitor-exit(r105);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public void removeCallback(ListenerType r100, IDownloadListener r101) {
        if (this.autoRemoveCallback == true) goto L5;
        return;
    L5:
        if (r100 != ListenerType.NONE) goto L8;
        return;
    L8:
        if (Logger.debugScene(this.downloadInfo) == false) goto L11;
        Logger.taskDebug(TAG, this.downloadInfo, "removeCallback", "ListenerType:" + r100 + " listener:" + r101);
    L11:
        if (r101 != null) goto L13;
        int r102 = 0;
    L14:
        removeDownloadListener(r102, r101, r100, false);
        return;
    L13:
        r102 = r101.hashCode();
        goto L14
    }

    public void setDownloadListeners(Map<Integer, IDownloadListener> r100, ListenerType r101) {
        if (r100 != null) goto L43;
        return;
    L43:
    L34:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r101 != ListenerType.MAIN) goto L15;
        Map<Integer, IDownloadListener> r102 = this.mainThreadListeners;     // Catch: Throwable -> L34
        monitor-enter(r102);     // Catch: Throwable -> L34
        copyListeners(this.mainThreadListeners, r100);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
    L44:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L15:
        if (r101 != ListenerType.SUB) goto L25;
        Map<Integer, IDownloadListener> r103 = this.subThreadListeners;     // Catch: Throwable -> L34
        monitor-enter(r103);     // Catch: Throwable -> L34
        copyListeners(this.subThreadListeners, r100);     // Catch: Throwable -> L21
        monitor-exit(r103);     // Catch: Throwable -> L21
    L45:
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L25:
        if (r101 != ListenerType.NOTIFICATION) goto L46;
        Map<Integer, IDownloadListener> r104 = this.notificationListeners;     // Catch: Throwable -> L34
        monitor-enter(r104);     // Catch: Throwable -> L34
        copyListeners(this.notificationListeners, r100);     // Catch: Throwable -> L31
        monitor-exit(r104);     // Catch: Throwable -> L31
    L47:
        return;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    }

    public DownloadTask subThreadListenerWithHashCode(int r100, IDownloadListener r101) {
        if (r101 == null) goto L18;
        Map<Integer, IDownloadListener> r102 = this.subThreadListeners;
        monitor-enter(r102);
        this.subThreadListeners.put(Integer.valueOf(r100), r101);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        Map<ListenerType, IDownloadListener> r103 = this.singleListenerMap;
        ListenerType r104 = ListenerType.SUB;
        r103.put(r104, r101);
        Map<Integer, ListenerType> r105 = this.singleListenerHashCodeMap;
        monitor-enter(r105);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r100), r104);     // Catch: Throwable -> L12
        monitor-exit(r105);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public void addDownloadListener(int r100, IDownloadListener r101, ListenerType r102, boolean r103) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r103 == false) goto L15;
        Map<ListenerType, IDownloadListener> r104 = this.singleListenerMap;
        if (r104 == null) goto L15;
        r104.put(r102, r101);
        Map<Integer, ListenerType> r105 = this.singleListenerHashCodeMap;
        monitor-enter(r105);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r100), r102);     // Catch: Throwable -> L12
        monitor-exit(r105);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        Map<Integer, IDownloadListener> r106 = getDownloadListeners(r102);
        if (r106 != null) goto L18;
        return;
    L18:
        monitor-enter(r106);
        r106.put(Integer.valueOf(r100), r101);     // Catch: Throwable -> L22
        monitor-exit(r106);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public void removeDownloadListener(int r100, IDownloadListener r101, ListenerType r102, boolean r103) {
        Map<Integer, IDownloadListener> r104 = getDownloadListeners(r102);
        if (r104 != null) goto L9;
        if (r103 == true) goto L6;
        return;
    L6:
        if (this.singleListenerMap.containsKey(r102) == false) goto L44;
        this.singleListenerMap.remove(r102);
        return;
    L44:
        return;
    L9:
        monitor-enter(r104);
        if (r103 == true) goto L12;
        r104.remove(Integer.valueOf(r100));     // Catch: Throwable -> L34
        Map<Integer, ListenerType> r105 = this.singleListenerHashCodeMap;     // Catch: Throwable -> L34
        monitor-enter(r105);     // Catch: Throwable -> L34
        ListenerType r106 = this.singleListenerHashCodeMap.get(Integer.valueOf(r100));     // Catch: Throwable -> L31
        if (r106 != null) goto L26;
    L28:
        monitor-exit(r105);     // Catch: Throwable -> L31
    L29:
        monitor-exit(r104);     // Catch: Throwable -> L34
        return;
    L26:
        if (this.singleListenerMap.containsKey(r106) == false) goto L28;
        this.singleListenerMap.remove(r106);     // Catch: Throwable -> L31
        this.singleListenerHashCodeMap.remove(Integer.valueOf(r100));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L12:
        if (this.singleListenerMap.containsKey(r102) == false) goto L14;
        r101 = this.singleListenerMap.get(r102);     // Catch: Throwable -> L34
        this.singleListenerMap.remove(r102);     // Catch: Throwable -> L34
    L14:
        if (r101 == null) goto L29;
        Iterator<Map.Entry<Integer, IDownloadListener>> r107 = r104.entrySet().iterator();     // Catch: Throwable -> L34
    L17:
        if (r107.hasNext() == false) goto L29;
        if (r107.next().getValue() != r101) goto L17;
        r107.remove();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }
}
