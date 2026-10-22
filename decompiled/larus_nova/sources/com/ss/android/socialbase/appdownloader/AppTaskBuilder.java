package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventListener;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadCdnListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class AppTaskBuilder {
    private int antiHijackErrorCode;
    private IAppDownloadEventListener appDownloadEventListener;
    private boolean autoInstall;
    private boolean autoInstallWithNotification;
    private boolean autoInstallWithoutNotification;
    private boolean autoResumed;
    private int backUpUrlRetryCount;
    private List<String> backUpUrls;
    private Object bpeaToken;
    private long cacheLifeTimeMax;
    private IDownloadCdnListener cdnListener;
    private List<String> cdnUrls;
    private Context context;
    private IDownloadDepend depend;
    private IDownloadDiskSpaceHandler diskSpaceHandler;
    private boolean distinctDirectory;
    private List<IDownloadCompleteHandler> downloadCompleteHandlers;
    private JSONObject downloadSetting;
    private EnqueueType enqueueType;
    private int executorGroup;
    private long expectFileLength;
    private String extra;
    private int[] extraMonitorStatus;
    private IDownloadFileUriProvider fileUriProvider;
    private boolean force;
    private List<HttpHeader> headers;
    private String iconUrl;
    private boolean ignoreInterceptor;
    private String mExternalSavePath;
    private boolean mHandleRequest;
    private String mInstallBizParamsJson;
    private String mInstallBizType;
    private String mInstallCertId;
    private IDownloadListener mSubThreadListener;
    private IDownloadListener mainThreadListener;
    private int maxProgressCount;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private String f449570md5;
    private String mimeType;
    private int minProgressTimeMsInterval;
    private IDownloadMonitorDepend monitorDepend;
    private String monitorScene;
    private String name;
    private boolean needDefaultHttpServiceBackUp;
    private boolean needHttpsToHttpRetry;
    private boolean needIndependentProcess;
    private boolean needSDKMonitor;
    private boolean needWifi;
    private INotificationClickCallback notificationClickCallback;
    private AbsNotificationItem notificationItem;
    private IDownloadListener notificationListener;
    private String packageName;
    private List<String> pcdnUrls;
    private int retryCount;
    private String saveName;
    private String savePath;
    private boolean showNotification;
    private boolean showNotificationForAutoResumed;
    private String taskKey;
    private int taskPriority;
    private long throttleNetSpeed;
    private int throttleSmoothness;
    private String url;

    public AppTaskBuilder handleRequest() {
        this.mHandleRequest = true;
        return this;
    }

    public AppTaskBuilder headConnectionAvailable(boolean r100) {
        return this;
    }

    public AppTaskBuilder needChunkDowngradeRetry(boolean r100) {
        return this;
    }

    public AppTaskBuilder needRetryDelay(boolean r100) {
        return this;
    }

    public AppTaskBuilder needReuseChunkRunnable(boolean r100) {
        return this;
    }

    public AppTaskBuilder needReuseFirstConnection(boolean r100) {
        return this;
    }

    public AppTaskBuilder retryDelayTimeArray(String r100) {
        return this;
    }

    public AppTaskBuilder retryDelayTimeCalculator(IRetryDelayTimeCalculator r100) {
        return this;
    }

    public String toString() {
        return "AppTaskBuilder{context=" + this.context + ", url='" + this.url + "', backUpUrls=" + this.backUpUrls + ", name='" + this.name + "', taskPriority=" + this.taskPriority + ", saveName='" + this.saveName + "', savePath='" + this.savePath + "', headers=" + this.headers + ", showNotification=" + this.showNotification + ", autoInstallWithoutNotification=" + this.autoInstallWithoutNotification + ", autoInstallWithNotification=" + this.autoInstallWithNotification + ", needWifi=" + this.needWifi + ", mainThreadListener=" + this.mainThreadListener + ", notificationListener=" + this.notificationListener + ", extra='" + this.extra + "', mimeType='" + this.mimeType + "', needHttpsToHttpRetry=" + this.needHttpsToHttpRetry + ", notificationItem=" + this.notificationItem + ", autoResumed=" + this.autoResumed + ", showNotificationForAutoResumed=" + this.showNotificationForAutoResumed + ", packageName='" + this.packageName + "', md5='" + this.f449570md5 + "', expectFileLength=" + this.expectFileLength + ", force=" + this.force + ", retryCount=" + this.retryCount + ", backUpUrlRetryCount=" + this.backUpUrlRetryCount + ", needDefaultHttpServiceBackUp=" + this.needDefaultHttpServiceBackUp + ", needIndependentProcess=" + this.needIndependentProcess + ", enqueueType=" + this.enqueueType + ", minProgressTimeMsInterval=" + this.minProgressTimeMsInterval + ", maxProgressCount=" + this.maxProgressCount + ", monitorDepend=" + this.monitorDepend + ", depend=" + this.depend + ", appDownloadEventListener=" + this.appDownloadEventListener + ", fileUriProvider=" + this.fileUriProvider + ", diskSpaceHandler=" + this.diskSpaceHandler + ", notificationClickCallback=" + this.notificationClickCallback + ", cdnListener=" + this.cdnListener + ", downloadSetting=" + this.downloadSetting + ", iconUrl='" + this.iconUrl + "', downloadCompleteHandlers=" + this.downloadCompleteHandlers + ", executorGroup=" + this.executorGroup + ", throttleNetSpeed=" + this.throttleNetSpeed + ", throttleSmoothness=" + this.throttleSmoothness + ", antiHijackErrorCode=" + this.antiHijackErrorCode + ", distinctDirectory=" + this.distinctDirectory + ", autoInstall=" + this.autoInstall + ", ignoreInterceptor=" + this.ignoreInterceptor + ", bpeaToken=" + this.bpeaToken + ", needSDKMonitor=" + this.needSDKMonitor + ", monitorScene='" + this.monitorScene + "', cacheLifeTimeMax=" + this.cacheLifeTimeMax + ", extraMonitorStatus=" + Arrays.toString(this.extraMonitorStatus) + ", taskKey='" + this.taskKey + "', pcdnUrls=" + this.pcdnUrls + ", cdnUrls=" + this.cdnUrls + ", mExternalSavePath='" + this.mExternalSavePath + "', mInstallBizType=" + this.mInstallBizType + ", mInstallCertId='" + this.mInstallCertId + "', mInstallBizParamsJson='" + this.mInstallBizParamsJson + "'}";
    }

    public int getAntiHijackErrorCode() {
        return this.antiHijackErrorCode;
    }

    public IAppDownloadEventListener getAppDownloadEventListener() {
        return this.appDownloadEventListener;
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public List<String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public Object getBpeaToken() {
        return this.bpeaToken;
    }

    public long getCacheLifeTimeMax() {
        return this.cacheLifeTimeMax;
    }

    public IDownloadCdnListener getCdnListener() {
        return this.cdnListener;
    }

    public List<String> getCdnUrls() {
        return this.cdnUrls;
    }

    public Context getContext() {
        return this.context;
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

    public JSONObject getDownloadSetting() {
        return this.downloadSetting;
    }

    public EnqueueType getEnqueueType() {
        return this.enqueueType;
    }

    public int getExecutorGroup() {
        return this.executorGroup;
    }

    public long getExpectFileLength() {
        return this.expectFileLength;
    }

    public String getExternalSavePath() {
        return this.mExternalSavePath;
    }

    public String getExtra() {
        return this.extra;
    }

    public int[] getExtraMonitorStatus() {
        return this.extraMonitorStatus;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public List<HttpHeader> getHeaders() {
        return this.headers;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getInstallBizParamsJson() {
        return this.mInstallBizParamsJson;
    }

    public String getInstallBizType() {
        return this.mInstallBizType;
    }

    public String getInstallCertId() {
        return this.mInstallCertId;
    }

    public IDownloadListener getMainThreadListener() {
        return this.mainThreadListener;
    }

    public int getMaxProgressCount() {
        return this.maxProgressCount;
    }

    public String getMd5() {
        return this.f449570md5;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getMinProgressTimeMsInterval() {
        return this.minProgressTimeMsInterval;
    }

    public IDownloadMonitorDepend getMonitorDepend() {
        return this.monitorDepend;
    }

    public String getMonitorScene() {
        return this.monitorScene;
    }

    public String getName() {
        return this.name;
    }

    public INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public AbsNotificationItem getNotificationItem() {
        return this.notificationItem;
    }

    public IDownloadListener getNotificationListener() {
        return this.notificationListener;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public List<String> getPcdnUrls() {
        return this.pcdnUrls;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public String getSaveName() {
        return this.saveName;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public IDownloadListener getSubThreadListener() {
        return this.mSubThreadListener;
    }

    public String getTaskKey() {
        return this.taskKey;
    }

    public int getTaskPriority() {
        return this.taskPriority;
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public int getThrottleSmoothness() {
        return this.throttleSmoothness;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isAutoInstall() {
        return this.autoInstall;
    }

    public boolean isAutoInstallWithNotification() {
        return this.autoInstallWithNotification;
    }

    public boolean isAutoInstallWithoutNotification() {
        return this.autoInstallWithoutNotification;
    }

    public boolean isAutoResumed() {
        return this.autoResumed;
    }

    public boolean isDistinctDirectory() {
        return this.distinctDirectory;
    }

    public boolean isForce() {
        return this.force;
    }

    public boolean isHandleRequest() {
        return this.mHandleRequest;
    }

    public boolean isIgnoreInterceptor() {
        return this.ignoreInterceptor;
    }

    public boolean isNeedDefaultHttpServiceBackUp() {
        return this.needDefaultHttpServiceBackUp;
    }

    public boolean isNeedHttpsToHttpRetry() {
        return this.needHttpsToHttpRetry;
    }

    public boolean isNeedIndependentProcess() {
        return this.needIndependentProcess;
    }

    public boolean isNeedSDKMonitor() {
        return this.needSDKMonitor;
    }

    public boolean isNeedWifi() {
        return this.needWifi;
    }

    public boolean isShowNotification() {
        return this.showNotification;
    }

    public boolean isShowNotificationForAutoResumed() {
        return this.showNotificationForAutoResumed;
    }

    public AppTaskBuilder addDownloadCompleteHandler(IDownloadCompleteHandler r100) {
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

    public AppTaskBuilder appDownloadEventListener(IAppDownloadEventListener r100) {
        this.appDownloadEventListener = r100;
        return this;
    }

    public AppTaskBuilder autoInstall(boolean r100) {
        this.autoInstall = r100;
        return this;
    }

    public AppTaskBuilder autoInstallWithNotification(boolean r100) {
        this.autoInstallWithNotification = r100;
        return this;
    }

    public AppTaskBuilder autoInstallWithoutNotification(boolean r100) {
        this.autoInstallWithoutNotification = r100;
        return this;
    }

    public AppTaskBuilder autoResumed(boolean r100) {
        this.autoResumed = r100;
        return this;
    }

    public AppTaskBuilder backUpUrlRetryCount(int r100) {
        this.backUpUrlRetryCount = r100;
        return this;
    }

    public AppTaskBuilder backUpUrls(List<String> r100) {
        this.backUpUrls = r100;
        return this;
    }

    public AppTaskBuilder cdnListener(IDownloadCdnListener r100) {
        this.cdnListener = r100;
        return this;
    }

    public AppTaskBuilder cdnUrls(List<String> r100) {
        this.cdnUrls = r100;
        return this;
    }

    public AppTaskBuilder depend(IDownloadDepend r100) {
        this.depend = r100;
        return this;
    }

    public AppTaskBuilder diskSpaceHandler(IDownloadDiskSpaceHandler r100) {
        this.diskSpaceHandler = r100;
        return this;
    }

    public AppTaskBuilder distinctDirectory(boolean r100) {
        this.distinctDirectory = r100;
        return this;
    }

    public AppTaskBuilder downloadSetting(JSONObject r100) {
        this.downloadSetting = r100;
        return this;
    }

    public AppTaskBuilder enqueueType(EnqueueType r100) {
        this.enqueueType = r100;
        return this;
    }

    public AppTaskBuilder executorGroup(int r100) {
        this.executorGroup = r100;
        return this;
    }

    public AppTaskBuilder expectFileLength(long r100) {
        this.expectFileLength = r100;
        return this;
    }

    public AppTaskBuilder externalSavePath(String r100) {
        this.mExternalSavePath = r100;
        return this;
    }

    public AppTaskBuilder extra(String r100) {
        this.extra = r100;
        return this;
    }

    public AppTaskBuilder extraMonitorStatus(int[] r100) {
        this.extraMonitorStatus = r100;
        return this;
    }

    public AppTaskBuilder fileUriProvider(IDownloadFileUriProvider r100) {
        this.fileUriProvider = r100;
        return this;
    }

    public AppTaskBuilder force(boolean r100) {
        this.force = r100;
        return this;
    }

    public AppTaskBuilder headers(List<HttpHeader> r100) {
        this.headers = r100;
        return this;
    }

    public AppTaskBuilder iconUrl(String r100) {
        this.iconUrl = r100;
        return this;
    }

    public AppTaskBuilder ignoreInterceptor(boolean r100) {
        this.ignoreInterceptor = r100;
        return this;
    }

    public AppTaskBuilder installBizParamsJson(String r100) {
        this.mInstallBizParamsJson = r100;
        return this;
    }

    public AppTaskBuilder installBizType(String r100) {
        this.mInstallBizType = r100;
        return this;
    }

    public AppTaskBuilder installCertId(String r100) {
        this.mInstallCertId = r100;
        return this;
    }

    public AppTaskBuilder mainThreadListener(IDownloadListener r100) {
        this.mainThreadListener = r100;
        return this;
    }

    public AppTaskBuilder maxProgressCount(int r100) {
        this.maxProgressCount = r100;
        return this;
    }

    public AppTaskBuilder md5(String r100) {
        this.f449570md5 = r100;
        return this;
    }

    public AppTaskBuilder mimeType(String r100) {
        this.mimeType = r100;
        return this;
    }

    public AppTaskBuilder minProgressTimeMsInterval(int r100) {
        this.minProgressTimeMsInterval = r100;
        return this;
    }

    public AppTaskBuilder monitorDepend(IDownloadMonitorDepend r100) {
        this.monitorDepend = r100;
        return this;
    }

    public AppTaskBuilder monitorScene(String r100) {
        this.monitorScene = r100;
        return this;
    }

    public AppTaskBuilder name(String r100) {
        this.name = r100;
        return this;
    }

    public AppTaskBuilder needDefaultHttpServiceBackUp(boolean r100) {
        this.needDefaultHttpServiceBackUp = r100;
        return this;
    }

    public AppTaskBuilder needHttpsToHttpRetry(boolean r100) {
        this.needHttpsToHttpRetry = r100;
        return this;
    }

    public AppTaskBuilder needIndependentProcess(boolean r100) {
        this.needIndependentProcess = r100;
        return this;
    }

    public AppTaskBuilder needSDKMonitor(boolean r100) {
        this.needSDKMonitor = r100;
        return this;
    }

    public AppTaskBuilder needWifi(boolean r100) {
        this.needWifi = r100;
        return this;
    }

    public AppTaskBuilder notificationClickCallback(INotificationClickCallback r100) {
        this.notificationClickCallback = r100;
        return this;
    }

    public AppTaskBuilder notificationItem(AbsNotificationItem r100) {
        this.notificationItem = r100;
        return this;
    }

    public AppTaskBuilder notificationListener(IDownloadListener r100) {
        this.notificationListener = r100;
        return this;
    }

    public AppTaskBuilder packageName(String r100) {
        this.packageName = r100;
        return this;
    }

    public AppTaskBuilder pcdnUrls(List<String> r100) {
        this.pcdnUrls = r100;
        return this;
    }

    public AppTaskBuilder retryCount(int r100) {
        this.retryCount = r100;
        return this;
    }

    public AppTaskBuilder saveName(String r100) {
        this.saveName = r100;
        return this;
    }

    public AppTaskBuilder savePath(String r100) {
        this.savePath = r100;
        return this;
    }

    public void setAntiHijackErrorCode(int r100) {
        this.antiHijackErrorCode = r100;
    }

    public AppTaskBuilder setCacheLifeTimeMax(long r100) {
        this.cacheLifeTimeMax = r100;
        return this;
    }

    public AppTaskBuilder showNotification(boolean r100) {
        this.showNotification = r100;
        return this;
    }

    public AppTaskBuilder showNotificationForAutoResumed(boolean r100) {
        this.showNotificationForAutoResumed = r100;
        return this;
    }

    public AppTaskBuilder subThreadListener(IDownloadListener r100) {
        this.mSubThreadListener = r100;
        return this;
    }

    public AppTaskBuilder taskKey(String r100) {
        this.taskKey = r100;
        return this;
    }

    public AppTaskBuilder taskPriority(int r100) {
        this.taskPriority = r100;
        return this;
    }

    public AppTaskBuilder throttleNetSpeed(long r100) {
        this.throttleNetSpeed = r100;
        return this;
    }

    public AppTaskBuilder throttleSmoothness(int r100) {
        this.throttleSmoothness = r100;
        return this;
    }

    public AppTaskBuilder(Context r100, String r101) {
        this(r100, r101, null);
    }

    public AppTaskBuilder(Context r100, String r101, Object r102) {
        this.taskPriority = 0;
        this.showNotification = true;
        this.autoInstallWithoutNotification = false;
        this.autoInstallWithNotification = true;
        this.needWifi = false;
        this.mimeType = "application/vnd.android.package-archive";
        this.retryCount = 5;
        this.needDefaultHttpServiceBackUp = true;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.minProgressTimeMsInterval = 150;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoInstall = true;
        this.ignoreInterceptor = false;
        this.needSDKMonitor = true;
        this.context = r100.getApplicationContext();
        this.url = r101;
        this.bpeaToken = r102;
    }
}
