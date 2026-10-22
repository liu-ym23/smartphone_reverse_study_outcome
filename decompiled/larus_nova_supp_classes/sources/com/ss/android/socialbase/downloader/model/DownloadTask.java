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
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        IDownloadListener r0 = getSingleDownloadListener(ListenerType.MAIN);     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
        r0 = getSingleDownloadListener(ListenerType.SUB);     // Catch: Throwable -> L11
    L6:
        if (r0 == null) goto L8;
        this.hashCodeForSameTask = r0.hashCode();     // Catch: Throwable -> L11
    L8:
        int r1 = this.hashCodeForSameTask;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public DownloadTask headConnectionAvailable(boolean r1) {
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean r1) {
        return this;
    }

    public DownloadTask needRetryDelay(boolean r1) {
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean r1) {
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean r1) {
        return this;
    }

    public DownloadTask newSaveTempFileEnable(boolean r1) {
        return this;
    }

    public DownloadTask retryDelayTimeArray(String r1) {
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(IRetryDelayTimeCalculator r1) {
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
        JSONObject r0 = DownloadSetting.getGlobalTaskSettings();     // Catch: Throwable -> L104
        if (r0 != null) goto L9;
        return;
    L9:
        JSONObject r1 = r0.optJSONObject(this.downloadInfoBuilder.monitorScene);     // Catch: Throwable -> L104
        if (r1 != null) goto L12;
        return;
    L12:
        JSONObject r2 = r1.optJSONObject("replace_download_task_param");     // Catch: Throwable -> L104
        this.mReplaceSetting = r2;     // Catch: Throwable -> L104
        if (r2 != null) goto L16;
        return;
    L16:
        if (r2.has("ignore_interceptor") == false) goto L23;
        DownloadInfo.Builder r3 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("ignore_interceptor") <= 0) goto L20;
        boolean r4 = true;
    L21:
        r3.ignoreInterceptor(r4);     // Catch: Throwable -> L104
        goto L23
    L20:
        r4 = false;
    L23:
        if (this.mReplaceSetting.has("inner_save_path") == false) goto L26;
        this.downloadInfoBuilder.savePath(DownloadDirUtils.getDownloadPath());     // Catch: Throwable -> L104
    L26:
        if (this.mReplaceSetting.has("auto_remove_callback") == false) goto L33;
        if (this.mReplaceSetting.optInt("auto_remove_callback") <= 0) goto L30;
        boolean r5 = true;
    L31:
        this.autoRemoveCallback = r5;     // Catch: Throwable -> L104
        goto L33
    L30:
        r5 = false;
    L33:
        if (this.mReplaceSetting.has("extra") == false) goto L36;
        this.downloadInfoBuilder.extra(this.mReplaceSetting.optString("extra"));     // Catch: Throwable -> L104
    L36:
        if (this.mReplaceSetting.has("only_wifi") == false) goto L43;
        DownloadInfo.Builder r6 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("only_wifi") <= 0) goto L40;
        boolean r7 = true;
    L41:
        r6.onlyWifi(r7);     // Catch: Throwable -> L104
        goto L43
    L40:
        r7 = false;
    L43:
        if (this.mReplaceSetting.has("extra_headers") == false) goto L52;
        JSONObject r8 = this.mReplaceSetting.optJSONObject("extra_headers");     // Catch: Throwable -> L104
        if (r8 == null) goto L52;
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L104
        Iterator<String> r11 = r8.keys();     // Catch: Throwable -> L104
    L48:
        if (r11.hasNext() == false) goto L50;
        String r12 = r11.next();     // Catch: Throwable -> L104
        r9.add(new HttpHeader(r12, r8.optString(r12)));     // Catch: Throwable -> L104
        goto L48
    L50:
        this.downloadInfoBuilder.extraHeaders(r9);     // Catch: Throwable -> L104
    L52:
        if (this.mReplaceSetting.has("max_bytes") == false) goto L55;
        this.downloadInfoBuilder.maxBytes(this.mReplaceSetting.optInt("max_bytes"));     // Catch: Throwable -> L104
    L55:
        if (this.mReplaceSetting.has("retry_count") == false) goto L58;
        this.downloadInfoBuilder.retryCount(this.mReplaceSetting.optInt("retry_count"));     // Catch: Throwable -> L104
    L58:
        if (this.mReplaceSetting.has("force") == false) goto L65;
        DownloadInfo.Builder r10 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("force") <= 0) goto L62;
        boolean r13 = true;
    L63:
        r10.force(r13);     // Catch: Throwable -> L104
        goto L65
    L62:
        r13 = false;
    L65:
        if (this.mReplaceSetting.has("show_notification") == false) goto L72;
        DownloadInfo.Builder r14 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("show_notification") <= 0) goto L69;
        boolean r15 = true;
    L70:
        r14.showNotification(r15);     // Catch: Throwable -> L104
        goto L72
    L69:
        r15 = false;
    L72:
        if (this.mReplaceSetting.has("show_notification_for_auto_resumed") == false) goto L79;
        DownloadInfo.Builder r16 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("show_notification_for_auto_resumed") <= 0) goto L76;
        boolean r17 = true;
    L77:
        r16.showNotificationForAutoResumed(r17);     // Catch: Throwable -> L104
        goto L79
    L76:
        r17 = false;
    L79:
        if (this.mReplaceSetting.has("executor_group") == false) goto L82;
        this.downloadInfoBuilder.executorGroup(this.mReplaceSetting.optInt("executor_group"));     // Catch: Throwable -> L104
    L82:
        if (this.mReplaceSetting.has("ttnet_protect_timeout") == false) goto L85;
        this.downloadInfoBuilder.ttnetProtectTimeout(this.mReplaceSetting.optLong("ttnet_protect_timeout"));     // Catch: Throwable -> L104
    L85:
        if (this.mReplaceSetting.has("add_ttnet_common_param") == false) goto L92;
        DownloadInfo.Builder r18 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("add_ttnet_common_param") <= 0) goto L89;
        boolean r19 = true;
    L90:
        r18.addTTNetCommonParam(r19);     // Catch: Throwable -> L104
        goto L92
    L89:
        r19 = false;
    L92:
        if (this.mReplaceSetting.has("distinct_directory") == false) goto L99;
        DownloadInfo.Builder r20 = this.downloadInfoBuilder;     // Catch: Throwable -> L104
        if (this.mReplaceSetting.optInt("distinct_directory") <= 0) goto L96;
        boolean r21 = true;
    L97:
        r20.distinctDirectory(r21);     // Catch: Throwable -> L104
        goto L99
    L96:
        r21 = false;
    L99:
        if (this.mReplaceSetting.has("fast_download") == true) goto L101;
        return;
    L101:
        if (this.mReplaceSetting.optInt("fast_download") <= 0) goto L111;
        this.downloadInfoBuilder.fastDownload();     // Catch: Throwable -> L104
        return;
    }

    public void addListenerToDownloadingSameTask() {
        DownloadInfo r0 = this.downloadInfo;
        if (r0 != null) goto L5;
    L10:
        addListenerToDownloadingSameTask(ListenerType.MAIN);
        addListenerToDownloadingSameTask(ListenerType.SUB);
        ((IDownloadMonitorHelperService) DownloadServiceManager.getService(IDownloadMonitorHelperService.class)).monitorSendWithTaskMonitor(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
        return;
    L5:
        if (Logger.debugScene(r0) == false) goto L8;
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
        DownloadInfo r0 = this.downloadInfo;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.canShowNotification();
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
        DownloadInfo r0 = this.downloadInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getId();
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
        long r0 = System.currentTimeMillis();
        handleBuildParams();
        this.downloadInfo = this.downloadInfoBuilder.build();
        DownloadTimingInfo r2 = this.timingInfo;
        r2.callDownloadTime = r0;
        r2.buildDownloadInfoTime = System.currentTimeMillis();
        IDownloadProcessDispatcherService r1 = (IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class);
        if (r1.getDownloadInfo(this.downloadInfo.getId()) != null) goto L5;
        ((IDownloadMonitorHelperService) DownloadServiceManager.getService(IDownloadMonitorHelperService.class)).monitorSend(this, null, 0);
    L5:
        r1.tryDownload(this);
        DownloadInfo r3 = this.downloadInfo;
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.getId();
    }

    public DownloadTask callStack() {
        int r2 = 2;
        int r0 = DownloadSetting.obtainGlobal().optInt("monitor_biz_stack_row_count", 2);
        if (r0 > 0) goto L5;
    L23:
        return this;
    L5:
        if (this.downloadInfoBuilder.callStack != null) goto L23;
        StackTraceElement[] r1 = new Throwable().getStackTrace();     // Catch: Throwable -> L21
        if (r1 != null) goto L10;
        return this;
    L10:
        int r3 = r0 + 2;     // Catch: Throwable -> L21
        if (r3 <= r1.length) goto L13;
        r3 = r1.length;     // Catch: Throwable -> L21
    L13:
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L21
    L14:
        if (r2 >= r3) goto L17;
        r4.append(r1[r2]);     // Catch: Throwable -> L21
        r2 = r2 + 1;     // Catch: Throwable -> L21
        goto L14
    L17:
        if (r4.length() > 0) goto L19;
        return this;
    L19:
        this.downloadInfoBuilder.callStack(r4.toString());     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Logger.globalError(TAG, "callStack", "Error:" + th);
        goto L23
    }

    public int download() {
        callStack();
        if (DownloadSetting.obtainGlobal().optInt("fix_anr_remove_report_idle_status") <= 0) goto L5;
        long r0 = System.currentTimeMillis();
        handleBuildParams();
        this.downloadInfo = this.downloadInfoBuilder.build();
        DownloadTimingInfo r2 = this.timingInfo;
        r2.callDownloadTime = r0;
        r2.buildDownloadInfoTime = System.currentTimeMillis();
        int r1 = this.downloadInfo.getId();
        ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).tryDownload(this);
        return r1;
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

    public DownloadTask(DownloadInfo r1) {
        this();
        this.downloadInfo = r1;
    }

    private void addListenerToDownloadingSameTask(ListenerType r6) {
        Map<Integer, IDownloadListener> r0 = getDownloadListeners(r6);
        if (r0 != null) goto L6;
        Logger.taskError(TAG, getDownloadId(), "addListenerToDownloadingSameTask", "ListenerType is null");
        return;
    L6:
        Iterator<IDownloadListener> r1 = r0.values().iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        IDownloadListener r2 = r1.next();
        if (r2 == null) goto L8;
        ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).addDownloadListener(getDownloadId(), r2, r6, false);
        goto L8
    }

    private int[] setToInt(Set<Integer> r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.isEmpty() == true) goto L14;
        Object[] r5 = r4.toArray();
        int[] r0 = new int[r5.length];
        int r1 = 0;
    L8:
        if (r1 >= r5.length) goto L10;
        r0[r1] = ((Integer) r5[r1]).intValue();
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L14:
        return null;
    }

    public DownloadTask accessHttpHeaderKeys(List<String> r2) {
        this.downloadInfoBuilder.accessHttpHeaderKeys(r2);
        return this;
    }

    public DownloadTask addDownloadCompleteHandler(IDownloadCompleteHandler r3) {
        List<IDownloadCompleteHandler> r0 = this.downloadCompleteHandlers;
        monitor-enter(r0);
        if (r3 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return this;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.downloadCompleteHandlers.contains(r3) == true) goto L11;
        this.downloadCompleteHandlers.add(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return this;
    }

    public DownloadTask addListenerToSameTask(boolean r2) {
        this.downloadInfoBuilder.addListenerToSameTask(r2);
        return this;
    }

    public DownloadTask addTTNetCommonParam(boolean r2) {
        this.downloadInfoBuilder.addTTNetCommonParam(r2);
        return this;
    }

    public void asyncDownload(IDownloadStartCallback r3) {
        callStack();
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).submitSingleTask(new 1(this, r3));
    }

    public DownloadTask autoRemoveCallback(boolean r1) {
        this.autoRemoveCallback = r1;
        return this;
    }

    public DownloadTask autoResumed(boolean r2) {
        this.downloadInfoBuilder.autoResumed(r2);
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean r1) {
        this.autoSetHashCodeForSameTask = r1;
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int r2) {
        this.downloadInfoBuilder.backUpUrlRetryCount(r2);
        return this;
    }

    public DownloadTask backUpUrls(List<String> r2) {
        this.downloadInfoBuilder.backUpUrls(r2);
        return this;
    }

    public DownloadTask cdnListener(IDownloadCdnListener r1) {
        this.cdnListener = r1;
        return this;
    }

    public DownloadTask cdnUrls(List<String> r2) {
        this.downloadInfoBuilder.cdnUrls(r2);
        return this;
    }

    public DownloadTask concurrentConnCount(int r2) {
        this.downloadInfoBuilder.concurrentConnCount(r2);
        return this;
    }

    public void copyInterfaceFromNewTask(DownloadTask r4) {
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(r4.singleListenerMap);
        Map<Integer, IDownloadListener> r0 = this.mainThreadListeners;
        monitor-enter(r0);
        this.mainThreadListeners.clear();     // Catch: Throwable -> L28
        addAll(r4.mainThreadListeners, this.mainThreadListeners);     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        Map<Integer, IDownloadListener> r1 = this.subThreadListeners;
        monitor-enter(r1);
        this.subThreadListeners.clear();     // Catch: Throwable -> L25
        addAll(r4.subThreadListeners, this.subThreadListeners);     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        Map<Integer, IDownloadListener> r2 = this.notificationListeners;
        monitor-enter(r2);
        this.notificationListeners.clear();     // Catch: Throwable -> L22
        addAll(r4.notificationListeners, this.notificationListeners);     // Catch: Throwable -> L22
        monitor-exit(r2);     // Catch: Throwable -> L22
        this.notificationEventListener = r4.notificationEventListener;
        this.interceptor = r4.interceptor;
        this.depend = r4.depend;
        this.monitorDepend = r4.monitorDepend;
        this.forbiddenHandler = r4.forbiddenHandler;
        this.diskSpaceHandler = r4.diskSpaceHandler;
        this.notificationClickCallback = r4.notificationClickCallback;
        this.fileUriProvider = r4.fileUriProvider;
        List<IDownloadCompleteHandler> r3 = this.downloadCompleteHandlers;
        monitor-enter(r3);
        this.downloadCompleteHandlers.clear();     // Catch: Throwable -> L19
        this.downloadCompleteHandlers.addAll(r4.downloadCompleteHandlers);     // Catch: Throwable -> L19
        monitor-exit(r3);     // Catch: Throwable -> L19
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

    public void copyListenerFromPendingTask(DownloadTask r5) {
        Iterator<Map.Entry<ListenerType, IDownloadListener>> r0 = r5.singleListenerMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L48;
        Map.Entry<ListenerType, IDownloadListener> r1 = r0.next();
        if (r1 == null) goto L4;
        if (this.singleListenerMap.containsKey(r1.getKey()) == true) goto L4;
        this.singleListenerMap.put(r1.getKey(), r1.getValue());
        goto L4
    L48:
    L41:
        th = move-exception;
        th.printStackTrace();
        return;
    L12:
        if (r5.mainThreadListeners.size() == 0) goto L22;
        Map<Integer, IDownloadListener> r2 = this.mainThreadListeners;     // Catch: Throwable -> L41
        monitor-enter(r2);     // Catch: Throwable -> L41
        removeAll(this.mainThreadListeners, r5.mainThreadListeners);     // Catch: Throwable -> L18
        addAll(r5.mainThreadListeners, this.mainThreadListeners);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L22:
        if (r5.subThreadListeners.size() == 0) goto L32;
        Map<Integer, IDownloadListener> r3 = this.subThreadListeners;     // Catch: Throwable -> L41
        monitor-enter(r3);     // Catch: Throwable -> L41
        removeAll(this.subThreadListeners, r5.subThreadListeners);     // Catch: Throwable -> L28
        addAll(r5.subThreadListeners, this.subThreadListeners);     // Catch: Throwable -> L28
        monitor-exit(r3);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L32:
        if (r5.notificationListeners.size() == 0) goto L57;
        Map<Integer, IDownloadListener> r4 = this.notificationListeners;     // Catch: Throwable -> L41
        monitor-enter(r4);     // Catch: Throwable -> L41
        removeAll(this.notificationListeners, r5.notificationListeners);     // Catch: Throwable -> L38
        addAll(r5.notificationListeners, this.notificationListeners);     // Catch: Throwable -> L38
        monitor-exit(r4);     // Catch: Throwable -> L38
    L58:
        return;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean r2) {
        this.downloadInfoBuilder.deleteCacheIfCheckFailed(r2);
        return this;
    }

    public DownloadTask depend(IDownloadDepend r1) {
        this.depend = r1;
        return this;
    }

    public DownloadTask diskSpaceHandler(IDownloadDiskSpaceHandler r1) {
        this.diskSpaceHandler = r1;
        return this;
    }

    public DownloadTask distinctDirectory(boolean r2) {
        this.downloadInfoBuilder.distinctDirectory(r2);
        return this;
    }

    public DownloadTask downloadSetting(JSONObject r2) {
        this.downloadInfoBuilder.downloadSetting(r2);
        return this;
    }

    public DownloadTask endOffset(long r2) {
        this.downloadInfoBuilder.endOffset(r2);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType r2) {
        this.downloadInfoBuilder.enqueueType(r2);
        return this;
    }

    public DownloadTask executorGroup(int r2) {
        this.downloadInfoBuilder.executorGroup(r2);
        return this;
    }

    public DownloadTask expectFileLength(long r2) {
        this.downloadInfoBuilder.expectFileLength(r2);
        return this;
    }

    public DownloadTask expiredHttpCheck(boolean r2) {
        this.downloadInfoBuilder.expiredHttpCheck(r2);
        return this;
    }

    public DownloadTask expiredRedownload(boolean r2) {
        this.downloadInfoBuilder.expiredRedownload(r2);
        return this;
    }

    public DownloadTask extra(String r2) {
        this.downloadInfoBuilder.extra(r2);
        return this;
    }

    public DownloadTask extraHeaders(List<HttpHeader> r2) {
        this.downloadInfoBuilder.extraHeaders(r2);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] r2) {
        this.downloadInfoBuilder.extraMonitorStatus(r2);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider r1) {
        this.fileUriProvider = r1;
        return this;
    }

    public DownloadTask forbiddenHandler(IDownloadForbiddenHandler r1) {
        this.forbiddenHandler = r1;
        return this;
    }

    public DownloadTask force(boolean r2) {
        this.downloadInfoBuilder.force(r2);
        return this;
    }

    public DownloadTask forceWifiBound(boolean r2) {
        this.downloadInfoBuilder.forceWifiBound(r2);
        return this;
    }

    public IDownloadCompleteHandler getDownloadCompleteHandlerByIndex(int r3) {
        List<IDownloadCompleteHandler> r0 = this.downloadCompleteHandlers;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r3 >= this.downloadCompleteHandlers.size()) goto L9;
        IDownloadCompleteHandler r4 = this.downloadCompleteHandlers.get(r3);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r4;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    }

    public int[] getDownloadListenerHashCodeLists(ListenerType r2) {
        if (r2 != ListenerType.MAIN) goto L7;
        return setToInt(this.mainThreadListeners.keySet());
    L7:
        if (r2 != ListenerType.SUB) goto L11;
        return setToInt(this.subThreadListeners.keySet());
    L11:
        if (r2 == ListenerType.NOTIFICATION) goto L13;
        return null;
    L13:
        return setToInt(this.notificationListeners.keySet());
    }

    public Map<Integer, IDownloadListener> getDownloadListeners(ListenerType r2) {
        if (r2 != ListenerType.MAIN) goto L7;
        return this.mainThreadListeners;
    L7:
        if (r2 != ListenerType.SUB) goto L11;
        return this.subThreadListeners;
    L11:
        if (r2 == ListenerType.NOTIFICATION) goto L13;
        return null;
    L13:
        return this.notificationListeners;
    }

    public IDownloadListener getSingleDownloadListener(ListenerType r2) {
        return this.singleListenerMap.get(r2);
    }

    public DownloadTask hashCodeForSameTask(int r1) {
        this.hashCodeForSameTask = r1;
        return this;
    }

    public DownloadTask iconUrl(String r2) {
        this.downloadInfoBuilder.iconUrl(r2);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean r2) {
        this.downloadInfoBuilder.ignoreDataVerify(r2);
        return this;
    }

    public DownloadTask ignoreInterceptor(boolean r2) {
        this.downloadInfoBuilder.ignoreInterceptor(r2);
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor r1) {
        this.interceptor = r1;
        return this;
    }

    public DownloadTask isOpenLimitSpeed(boolean r2) {
        this.downloadInfoBuilder.isOpenLimitSpeed(r2);
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        return mainThreadListenerWithHashCode(r2.hashCode(), r2);
    }

    public DownloadTask maxBytes(int r2) {
        this.downloadInfoBuilder.maxBytes(r2);
        return this;
    }

    public DownloadTask maxProgressCount(int r2) {
        this.downloadInfoBuilder.maxProgressCount(r2);
        return this;
    }

    public DownloadTask md5(String r2) {
        this.downloadInfoBuilder.md5(r2);
        return this;
    }

    public DownloadTask mimeType(String r2) {
        this.downloadInfoBuilder.mimeType(r2);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int r2) {
        this.downloadInfoBuilder.minProgressTimeMsInterval(r2);
        return this;
    }

    public DownloadTask monitorDepend(IDownloadMonitorDepend r1) {
        this.monitorDepend = r1;
        return this;
    }

    public DownloadTask monitorScene(String r2) {
        this.downloadInfoBuilder.monitorScene(r2);
        return this;
    }

    public DownloadTask name(String r2) {
        this.downloadInfoBuilder.name(r2);
        return this;
    }

    public DownloadTask needCurrentProcess(boolean r2) {
        this.downloadInfoBuilder.needCurrentProcess(r2);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean r2) {
        this.downloadInfoBuilder.needDefaultHttpServiceBackUp(r2);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean r2) {
        this.downloadInfoBuilder.needHttpsToHttpRetry(r2);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean r2) {
        this.downloadInfoBuilder.needIndependentProcess(r2);
        return this;
    }

    public DownloadTask needPostProgress(boolean r2) {
        this.downloadInfoBuilder.needPostProgress(r2);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean r2) {
        this.downloadInfoBuilder.needSDKMonitor(r2);
        return this;
    }

    public DownloadTask notificationClickCallback(INotificationClickCallback r1) {
        this.notificationClickCallback = r1;
        return this;
    }

    public DownloadTask notificationEventListener(IDownloadNotificationEventListener r1) {
        this.notificationEventListener = r1;
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        return notificationListenerWithHashCode(r2.hashCode(), r2);
    }

    public DownloadTask onlyWifi(boolean r2) {
        this.downloadInfoBuilder.onlyWifi(r2);
        return this;
    }

    public DownloadTask outIp(String[] r2) {
        this.downloadInfoBuilder.outIp(r2);
        return this;
    }

    public DownloadTask outSize(int[] r2) {
        this.downloadInfoBuilder.outSize(r2);
        return this;
    }

    public DownloadTask packageName(String r2) {
        this.downloadInfoBuilder.packageName(r2);
        return this;
    }

    public DownloadTask pcdnUrls(List<String> r2) {
        this.downloadInfoBuilder.pcdnUrls(r2);
        return this;
    }

    public DownloadTask retryCount(int r2) {
        this.downloadInfoBuilder.retryCount(r2);
        return this;
    }

    public DownloadTask savePath(String r2) {
        this.downloadInfoBuilder.savePath(r2);
        return this;
    }

    public DownloadTask setAutoInstall(boolean r2) {
        this.downloadInfoBuilder.setAutoInstall(r2);
        return this;
    }

    public DownloadTask setCacheLifeTimeMax(long r2) {
        this.downloadInfoBuilder.cacheLifeTimeMax(r2);
        return this;
    }

    public DownloadTask setDownloadCompleteHandlers(List<IDownloadCompleteHandler> r2) {
        if (r2 != null) goto L4;
    L9:
        return this;
    L4:
        if (r2.isEmpty() == true) goto L9;
        Iterator<IDownloadCompleteHandler> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        addDownloadCompleteHandler(r3.next());
        goto L7
    }

    public void setNeedDelayForCacheSync(boolean r1) {
        this.needDelayForCacheSync = r1;
    }

    public void setNotificationEventListener(IDownloadNotificationEventListener r1) {
        this.notificationEventListener = r1;
    }

    public DownloadTask setTaskPriority(int r1) {
        this.mPriority = r1;
        return this;
    }

    public DownloadTask showNotification(boolean r2) {
        this.downloadInfoBuilder.showNotification(r2);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean r2) {
        this.downloadInfoBuilder.showNotificationForAutoResumed(r2);
        return this;
    }

    public DownloadTask startOffset(long r2) {
        this.downloadInfoBuilder.startOffset(r2);
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        return subThreadListenerWithHashCode(r2.hashCode(), r2);
    }

    public DownloadTask taskKey(String r2) {
        this.downloadInfoBuilder.taskKey(r2);
        return this;
    }

    public DownloadTask tempPath(String r2) {
        this.downloadInfoBuilder.tempPath(r2);
        return this;
    }

    public DownloadTask throttleNetSpeed(long r2) {
        this.downloadInfoBuilder.throttleNetSpeed(r2);
        return this;
    }

    public DownloadTask throttleSmoothness(int r2) {
        this.downloadInfoBuilder.throttleSmoothness(r2);
        return this;
    }

    public DownloadTask title(String r2) {
        this.downloadInfoBuilder.title(r2);
        return this;
    }

    public DownloadTask ttnetByPassProxy(boolean r2) {
        this.downloadInfoBuilder.ttnetByPassProxy(r2);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long r2) {
        this.downloadInfoBuilder.ttnetProtectTimeout(r2);
        return this;
    }

    public DownloadTask url(String r2) {
        this.downloadInfoBuilder.url(r2);
        return this;
    }

    private void addAll(Map<Integer, IDownloadListener> r3, Map<Integer, IDownloadListener> r4) {
        if (r3 == null) goto L9;
        if (r4 == null) goto L11;
        Iterator<Map.Entry<Integer, IDownloadListener>> r5 = r3.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        Map.Entry<Integer, IDownloadListener> r0 = r5.next();
        r4.put(r0.getKey(), r0.getValue());
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private void copyListeners(Map<Integer, IDownloadListener> r3, Map<Integer, IDownloadListener> r4) {
        r3.clear();
        Iterator<Map.Entry<Integer, IDownloadListener>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry<Integer, IDownloadListener> r0 = r5.next();
        if (r0.getValue() == null) goto L4;
        r3.put(r0.getKey(), r0.getValue());
        goto L4
    }

    private void removeAll(Map<Integer, IDownloadListener> r2, Map<Integer, IDownloadListener> r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L11;
        Iterator<Map.Entry<Integer, IDownloadListener>> r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        r2.remove(r4.next().getKey());
        goto L7
    L12:
        return;
    L11:
        return;
    }

    public IDownloadListener getDownloadListenerByHashCode(ListenerType r2, int r3) {
        if (r2 != ListenerType.MAIN) goto L7;
        return this.mainThreadListeners.get(Integer.valueOf(r3));
    L7:
        if (r2 != ListenerType.SUB) goto L11;
        return this.subThreadListeners.get(Integer.valueOf(r3));
    L11:
        if (r2 == ListenerType.NOTIFICATION) goto L13;
        return null;
    L13:
        return this.notificationListeners.get(Integer.valueOf(r3));
    }

    public DownloadTask mainThreadListenerWithHashCode(int r4, IDownloadListener r5) {
        if (r5 == null) goto L18;
        Map<Integer, IDownloadListener> r0 = this.mainThreadListeners;
        monitor-enter(r0);
        this.mainThreadListeners.put(Integer.valueOf(r4), r5);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Map<ListenerType, IDownloadListener> r1 = this.singleListenerMap;
        ListenerType r2 = ListenerType.MAIN;
        r1.put(r2, r5);
        Map<Integer, ListenerType> r6 = this.singleListenerHashCodeMap;
        monitor-enter(r6);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r4), r2);     // Catch: Throwable -> L12
        monitor-exit(r6);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public DownloadTask notificationListenerWithHashCode(int r4, IDownloadListener r5) {
        if (r5 == null) goto L18;
        Map<Integer, IDownloadListener> r0 = this.notificationListeners;
        monitor-enter(r0);
        this.notificationListeners.put(Integer.valueOf(r4), r5);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Map<ListenerType, IDownloadListener> r1 = this.singleListenerMap;
        ListenerType r2 = ListenerType.NOTIFICATION;
        r1.put(r2, r5);
        Map<Integer, ListenerType> r6 = this.singleListenerHashCodeMap;
        monitor-enter(r6);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r4), r2);     // Catch: Throwable -> L12
        monitor-exit(r6);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public void removeCallback(ListenerType r5, IDownloadListener r6) {
        if (this.autoRemoveCallback == true) goto L5;
        return;
    L5:
        if (r5 != ListenerType.NONE) goto L8;
        return;
    L8:
        if (Logger.debugScene(this.downloadInfo) == false) goto L11;
        Logger.taskDebug(TAG, this.downloadInfo, "removeCallback", "ListenerType:" + r5 + " listener:" + r6);
    L11:
        if (r6 != null) goto L13;
        int r1 = 0;
    L14:
        removeDownloadListener(r1, r6, r5, false);
        return;
    L13:
        r1 = r6.hashCode();
        goto L14
    }

    public void setDownloadListeners(Map<Integer, IDownloadListener> r2, ListenerType r3) {
        if (r2 != null) goto L43;
        return;
    L43:
    L34:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r3 != ListenerType.MAIN) goto L15;
        Map<Integer, IDownloadListener> r4 = this.mainThreadListeners;     // Catch: Throwable -> L34
        monitor-enter(r4);     // Catch: Throwable -> L34
        copyListeners(this.mainThreadListeners, r2);     // Catch: Throwable -> L11
        monitor-exit(r4);     // Catch: Throwable -> L11
    L44:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L15:
        if (r3 != ListenerType.SUB) goto L25;
        Map<Integer, IDownloadListener> r5 = this.subThreadListeners;     // Catch: Throwable -> L34
        monitor-enter(r5);     // Catch: Throwable -> L34
        copyListeners(this.subThreadListeners, r2);     // Catch: Throwable -> L21
        monitor-exit(r5);     // Catch: Throwable -> L21
    L45:
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L25:
        if (r3 != ListenerType.NOTIFICATION) goto L46;
        Map<Integer, IDownloadListener> r6 = this.notificationListeners;     // Catch: Throwable -> L34
        monitor-enter(r6);     // Catch: Throwable -> L34
        copyListeners(this.notificationListeners, r2);     // Catch: Throwable -> L31
        monitor-exit(r6);     // Catch: Throwable -> L31
    L47:
        return;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    }

    public DownloadTask subThreadListenerWithHashCode(int r4, IDownloadListener r5) {
        if (r5 == null) goto L18;
        Map<Integer, IDownloadListener> r0 = this.subThreadListeners;
        monitor-enter(r0);
        this.subThreadListeners.put(Integer.valueOf(r4), r5);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Map<ListenerType, IDownloadListener> r1 = this.singleListenerMap;
        ListenerType r2 = ListenerType.SUB;
        r1.put(r2, r5);
        Map<Integer, ListenerType> r6 = this.singleListenerHashCodeMap;
        monitor-enter(r6);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r4), r2);     // Catch: Throwable -> L12
        monitor-exit(r6);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public void addDownloadListener(int r3, IDownloadListener r4, ListenerType r5, boolean r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r6 == false) goto L15;
        Map<ListenerType, IDownloadListener> r7 = this.singleListenerMap;
        if (r7 == null) goto L15;
        r7.put(r5, r4);
        Map<Integer, ListenerType> r8 = this.singleListenerHashCodeMap;
        monitor-enter(r8);
        this.singleListenerHashCodeMap.put(Integer.valueOf(r3), r5);     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        Map<Integer, IDownloadListener> r9 = getDownloadListeners(r5);
        if (r9 != null) goto L18;
        return;
    L18:
        monitor-enter(r9);
        r9.put(Integer.valueOf(r3), r4);     // Catch: Throwable -> L22
        monitor-exit(r9);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public void removeDownloadListener(int r2, IDownloadListener r3, ListenerType r4, boolean r5) {
        Map<Integer, IDownloadListener> r0 = getDownloadListeners(r4);
        if (r0 != null) goto L9;
        if (r5 == true) goto L6;
        return;
    L6:
        if (this.singleListenerMap.containsKey(r4) == false) goto L44;
        this.singleListenerMap.remove(r4);
        return;
    L44:
        return;
    L9:
        monitor-enter(r0);
        if (r5 == true) goto L12;
        r0.remove(Integer.valueOf(r2));     // Catch: Throwable -> L34
        Map<Integer, ListenerType> r6 = this.singleListenerHashCodeMap;     // Catch: Throwable -> L34
        monitor-enter(r6);     // Catch: Throwable -> L34
        ListenerType r7 = this.singleListenerHashCodeMap.get(Integer.valueOf(r2));     // Catch: Throwable -> L31
        if (r7 != null) goto L26;
    L28:
        monitor-exit(r6);     // Catch: Throwable -> L31
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L26:
        if (this.singleListenerMap.containsKey(r7) == false) goto L28;
        this.singleListenerMap.remove(r7);     // Catch: Throwable -> L31
        this.singleListenerHashCodeMap.remove(Integer.valueOf(r2));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L12:
        if (this.singleListenerMap.containsKey(r4) == false) goto L14;
        r3 = this.singleListenerMap.get(r4);     // Catch: Throwable -> L34
        this.singleListenerMap.remove(r4);     // Catch: Throwable -> L34
    L14:
        if (r3 == null) goto L29;
        Iterator<Map.Entry<Integer, IDownloadListener>> r8 = r0.entrySet().iterator();     // Catch: Throwable -> L34
    L17:
        if (r8.hasNext() == false) goto L29;
        if (r8.next().getValue() != r3) goto L17;
        r8.remove();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }
}
