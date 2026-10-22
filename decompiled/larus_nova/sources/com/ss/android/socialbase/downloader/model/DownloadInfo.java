package com.ss.android.socialbase.downloader.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = null;
    private static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    private static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
    private static boolean OPTIMIZE_MONITOR_LOAD = false;
    private static final int RESERVE_STATUS_NEVER = 0;
    private static final int RESERVE_STATUS_NOW = 2;
    private static final int RESERVE_STATUS_ONCE = 1;
    private static final String TAG = "DownloadInfo";
    private List<String> accessHttpHeaderKeys;
    private boolean addListenerToSameTask;
    private boolean addTTNetCommonParam;
    private AtomicLong allConnectTime;
    private int appVersionCode;
    private AsyncHandleStatus asyncHandleStatus;
    private boolean autoResumed;
    private AtomicLong backCurBytes;
    private int backUpUrlRetryCount;
    private boolean backUpUrlUsed;
    private List<String> backUpUrls;
    private String backUpUrlsStr;
    private int bindValueCount;
    private ByteInvalidRetryStatus byteInvalidRetryStatus;
    private long cacheLifeTimeMax;
    private String callStack;
    private List<String> cdnUrls;
    private String cdnUrlsStr;
    private int chunkCount;
    private int concurrentConnCount;
    private String contentEncoding;
    private int curBackUpUrlIndex;
    private AtomicLong curBytes;
    private int curNetworkRetryCount;
    private int curRetryTime;
    private JSONObject dbJsonData;
    private String dbJsonDataString;
    private boolean deleteCacheIfCheckFailed;
    private long downloadFinishTimeStamp;
    private long downloadStartTimeStamp;
    private long downloadTime;
    private String eTag;
    private EnqueueType enqueueType;
    private boolean expiredHttpCheck;
    private boolean expiredRedownload;
    private String extra;
    private List<HttpHeader> extraHeaders;
    private int[] extraMonitorStatus;
    private BaseException failedException;
    private boolean fastDownload;
    private boolean fastDownloadCommonThreadPool;
    private String filePackageName;
    private List<String> forbiddenBackupUrls;
    private boolean force;
    private boolean forceWifiBound;
    private boolean handleRequest;
    private boolean hasDoInstallation;
    private Map<String, String> httpHeaders;
    private String httpRequestHeader;
    private String httpResponseHeader;
    private int httpStatusCode;
    private String httpStatusMessage;
    private boolean httpsToHttpRetryUsed;
    private String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f449579id;
    private boolean ignoreDataVerify;
    private Boolean ignoreInterceptor;
    private long installedTimeStamp;
    private int interceptFlag;
    private Boolean isAutoInstallWithoutNotification;
    private boolean isCacheExistsInDownloading;
    private boolean isFirstDownload;
    private boolean isFirstSuccess;
    private boolean isForbiddenRetryed;
    private long lastNotifyProgressTime;
    private int mDBInitStatus;
    private boolean mDownloadFromReserveWifi;
    private int mTaskSleepTime;
    private int maxBytes;
    private int maxProgressCount;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private String f449580md5;
    private long md5Time;
    private String mimeType;
    private int minProgressTimeMsInterval;
    private String monitorScene;
    private String name;
    private boolean needCurrentProcess;
    private boolean needDefaultHttpServiceBackUp;
    private boolean needHttpsToHttpRetry;
    private boolean needIndependentProcess;
    private boolean needPostProgress;
    private boolean needSDKMonitor;
    private String networkQuality;
    private int notificationVisibility;
    private boolean onlyWifi;
    private boolean openLimitSpeed;
    private String[] outIp;
    private int[] outSize;
    private SoftReference<PackageInfo> packageInfoRef;
    private String packageName;
    private JSONObject pcdnStats;
    private List<String> pcdnUrls;
    private String pcdnUrlsStr;
    private long racingTaskExcessBytes;
    private long realBackDownloadTime;
    private long realDownloadTime;
    private long realStartDownloadTime;
    private String requestLog;
    private boolean resumeFileDownload;
    private int retryCount;
    private String savePath;
    private boolean showNotification;
    private boolean showNotificationForAutoResumed;
    private boolean showNotificationForNetworkResumed;
    private JSONObject spData;
    private long startDownloadTime;
    private AtomicInteger status;
    private int statusAtDbInit;
    private boolean successByCache;
    private boolean supportPartial;
    private ConcurrentHashMap<String, Object> tempCacheData;
    private String tempPath;
    private long throttleNetSpeed;
    private int throttleSmoothness;
    private String title;
    private long totalBytes;
    private boolean ttnetByPassProxy;
    private long ttnetProtectTimeout;
    private String url;
    private long verifyCurBytes;
    private long xTotalBytes;

    public static class Builder {
        private List<String> accessHttpHeaderKeys;
        private boolean addListenerToSameTask;
        private boolean addTTNetCommonParam;
        protected int appVersionCode;
        private boolean autoInstall;
        private boolean autoResumed;
        protected int backUpUrlRetryCount;
        private List<String> backUpUrls;
        protected long cacheLifeTimeMax;
        protected String callStack;
        protected List<String> cdnUrls;
        private int concurrentConnCount;
        private boolean deleteCacheIfCheckFailed;
        private boolean distinctDirectory;
        private JSONObject downloadSetting;
        private long endOffset;
        private EnqueueType enqueueType;
        private int executorGroup;
        private long expectFileLength;
        private boolean expiredHttpCheck;
        private boolean expiredRedownload;
        protected String extra;
        private List<HttpHeader> extraHeaders;
        private int[] extraMonitorStatus;
        private boolean fastDownload;
        private boolean fastDownloadCommonThreadPool;
        protected boolean force;
        private boolean forceWifiBound;
        private boolean handleRequest;
        protected String iconUrl;
        private boolean ignoreDataVerify;
        private boolean ignoreInterceptor;
        private int maxBytes;
        private int maxProgressCount;

        /* JADX INFO: renamed from: md5, reason: collision with root package name */
        protected String f449581md5;
        protected String mimeType;
        private int minProgressTimeMsInterval;
        protected String monitorScene;
        protected String name;
        protected boolean needCurrentProcess;
        protected boolean needDefaultHttpServiceBackUp;
        protected boolean needHttpsToHttpRetry;
        protected boolean needIndependentProcess;
        private boolean needPostProgress;
        private boolean needSDKMonitor;
        protected boolean onlyWifi;
        private boolean openLimitSpeed;
        private String[] outIp;
        private int[] outSize;
        protected String packageName;
        protected List<String> pcdnUrls;
        private boolean resumeFileDownload;
        protected int retryCount;
        protected String savePath;
        protected boolean showNotification;
        private boolean showNotificationForAutoResumed;
        private long startOffset;
        private String taskKey;
        protected String tempPath;
        private long throttleNetSpeed;
        private int throttleSmoothness;
        protected String title;
        private boolean ttnetByPassProxy;
        private long ttnetProtectTimeout;
        protected String url;

        public Builder fastDownload() {
            this.fastDownload = true;
            return this;
        }

        public Builder fastDownloadCommonThreadPool() {
            this.fastDownloadCommonThreadPool = true;
            return this;
        }

        public Builder handleRequest() {
            this.handleRequest = true;
            return this;
        }

        public Builder resumeFileDownload() {
            this.resumeFileDownload = true;
            return this;
        }

        public DownloadInfo build() {
            return new DownloadInfo(this, null);
        }

        public Builder() {
            this.needPostProgress = true;
            this.autoInstall = true;
            this.needDefaultHttpServiceBackUp = true;
            this.enqueueType = EnqueueType.ENQUEUE_NONE;
            this.startOffset = 0;
            this.endOffset = -1;
            this.needSDKMonitor = true;
        }

        public Builder(String r100) {
            this.needPostProgress = true;
            this.autoInstall = true;
            this.needDefaultHttpServiceBackUp = true;
            this.enqueueType = EnqueueType.ENQUEUE_NONE;
            this.startOffset = 0;
            this.endOffset = -1;
            this.needSDKMonitor = true;
            this.url = r100;
        }

        public static /* synthetic */ boolean access$000(Builder r100) {
            return r100.fastDownload;
        }

        public static /* synthetic */ boolean access$100(Builder r100) {
            return r100.fastDownloadCommonThreadPool;
        }

        public static /* synthetic */ String[] access$1000(Builder r100) {
            return r100.outIp;
        }

        public static /* synthetic */ int[] access$1100(Builder r100) {
            return r100.outSize;
        }

        public static /* synthetic */ boolean access$1200(Builder r100) {
            return r100.needPostProgress;
        }

        public static /* synthetic */ int access$1300(Builder r100) {
            return r100.maxProgressCount;
        }

        public static /* synthetic */ int access$1400(Builder r100) {
            return r100.minProgressTimeMsInterval;
        }

        public static /* synthetic */ boolean access$1500(Builder r100) {
            return r100.autoResumed;
        }

        public static /* synthetic */ boolean access$1600(Builder r100) {
            return r100.showNotificationForAutoResumed;
        }

        public static /* synthetic */ EnqueueType access$1700(Builder r100) {
            return r100.enqueueType;
        }

        public static /* synthetic */ boolean access$1800(Builder r100) {
            return r100.ignoreDataVerify;
        }

        public static /* synthetic */ boolean access$1900(Builder r100) {
            return r100.addListenerToSameTask;
        }

        public static /* synthetic */ boolean access$200(Builder r100) {
            return r100.resumeFileDownload;
        }

        public static /* synthetic */ long access$2000(Builder r100) {
            return r100.throttleNetSpeed;
        }

        public static /* synthetic */ int access$2100(Builder r100) {
            return r100.throttleSmoothness;
        }

        public static /* synthetic */ boolean access$2200(Builder r100) {
            return r100.forceWifiBound;
        }

        public static /* synthetic */ boolean access$2300(Builder r100) {
            return r100.openLimitSpeed;
        }

        public static /* synthetic */ JSONObject access$2400(Builder r100) {
            return r100.downloadSetting;
        }

        public static /* synthetic */ long access$2500(Builder r100) {
            return r100.expectFileLength;
        }

        public static /* synthetic */ int access$2600(Builder r100) {
            return r100.executorGroup;
        }

        public static /* synthetic */ boolean access$2700(Builder r100) {
            return r100.autoInstall;
        }

        public static /* synthetic */ boolean access$2800(Builder r100) {
            return r100.needSDKMonitor;
        }

        public static /* synthetic */ int[] access$2900(Builder r100) {
            return r100.extraMonitorStatus;
        }

        public static /* synthetic */ boolean access$300(Builder r100) {
            return r100.handleRequest;
        }

        public static /* synthetic */ boolean access$3000(Builder r100) {
            return r100.expiredRedownload;
        }

        public static /* synthetic */ boolean access$3100(Builder r100) {
            return r100.expiredHttpCheck;
        }

        public static /* synthetic */ boolean access$3200(Builder r100) {
            return r100.deleteCacheIfCheckFailed;
        }

        public static /* synthetic */ long access$3300(Builder r100) {
            return r100.ttnetProtectTimeout;
        }

        public static /* synthetic */ boolean access$3400(Builder r100) {
            return r100.addTTNetCommonParam;
        }

        public static /* synthetic */ boolean access$3500(Builder r100) {
            return r100.ttnetByPassProxy;
        }

        public static /* synthetic */ boolean access$3600(Builder r100) {
            return r100.ignoreInterceptor;
        }

        public static /* synthetic */ List access$3700(Builder r100) {
            return r100.accessHttpHeaderKeys;
        }

        public static /* synthetic */ long access$3800(Builder r100) {
            return r100.startOffset;
        }

        public static /* synthetic */ long access$3900(Builder r100) {
            return r100.endOffset;
        }

        public static /* synthetic */ List access$400(Builder r100) {
            return r100.backUpUrls;
        }

        public static /* synthetic */ int access$500(Builder r100) {
            return r100.concurrentConnCount;
        }

        public static /* synthetic */ String access$600(Builder r100) {
            return r100.taskKey;
        }

        public static /* synthetic */ boolean access$700(Builder r100) {
            return r100.distinctDirectory;
        }

        public static /* synthetic */ List access$800(Builder r100) {
            return r100.extraHeaders;
        }

        public static /* synthetic */ int access$900(Builder r100) {
            return r100.maxBytes;
        }

        public Builder accessHttpHeaderKeys(List<String> r100) {
            this.accessHttpHeaderKeys = r100;
            return this;
        }

        public Builder addListenerToSameTask(boolean r100) {
            this.addListenerToSameTask = r100;
            return this;
        }

        public Builder addTTNetCommonParam(boolean r100) {
            this.addTTNetCommonParam = r100;
            return this;
        }

        public Builder appVersionCode(int r100) {
            this.appVersionCode = r100;
            return this;
        }

        public Builder autoResumed(boolean r100) {
            this.autoResumed = r100;
            return this;
        }

        public Builder backUpUrlRetryCount(int r100) {
            this.backUpUrlRetryCount = r100;
            return this;
        }

        public Builder backUpUrls(List<String> r100) {
            this.backUpUrls = r100;
            return this;
        }

        public Builder cacheLifeTimeMax(long r100) {
            this.cacheLifeTimeMax = r100;
            return this;
        }

        public Builder callStack(String r100) {
            this.callStack = r100;
            return this;
        }

        public Builder cdnUrls(List<String> r100) {
            this.cdnUrls = r100;
            return this;
        }

        public Builder concurrentConnCount(int r100) {
            this.concurrentConnCount = r100;
            return this;
        }

        public Builder deleteCacheIfCheckFailed(boolean r100) {
            this.deleteCacheIfCheckFailed = r100;
            return this;
        }

        public Builder distinctDirectory(boolean r100) {
            this.distinctDirectory = r100;
            return this;
        }

        public Builder downloadSetting(JSONObject r100) {
            this.downloadSetting = r100;
            return this;
        }

        public Builder endOffset(long r100) {
            this.endOffset = r100;
            return this;
        }

        public Builder enqueueType(EnqueueType r100) {
            this.enqueueType = r100;
            return this;
        }

        public Builder executorGroup(int r100) {
            this.executorGroup = r100;
            return this;
        }

        public Builder expectFileLength(long r100) {
            this.expectFileLength = r100;
            return this;
        }

        public Builder expiredHttpCheck(boolean r100) {
            this.expiredHttpCheck = r100;
            return this;
        }

        public Builder expiredRedownload(boolean r100) {
            this.expiredRedownload = r100;
            return this;
        }

        public Builder extra(String r100) {
            this.extra = r100;
            return this;
        }

        public Builder extraHeaders(List<HttpHeader> r100) {
            this.extraHeaders = r100;
            return this;
        }

        public Builder extraMonitorStatus(int[] r100) {
            this.extraMonitorStatus = r100;
            return this;
        }

        public Builder force(boolean r100) {
            this.force = r100;
            return this;
        }

        public Builder forceWifiBound(boolean r100) {
            this.forceWifiBound = r100;
            return this;
        }

        public Builder iconUrl(String r100) {
            this.iconUrl = r100;
            return this;
        }

        public Builder ignoreDataVerify(boolean r100) {
            this.ignoreDataVerify = r100;
            return this;
        }

        public Builder ignoreInterceptor(boolean r100) {
            this.ignoreInterceptor = r100;
            return this;
        }

        public Builder isOpenLimitSpeed(boolean r100) {
            this.openLimitSpeed = r100;
            return this;
        }

        public Builder maxBytes(int r100) {
            this.maxBytes = r100;
            return this;
        }

        public Builder maxProgressCount(int r100) {
            this.maxProgressCount = r100;
            return this;
        }

        public Builder md5(String r100) {
            this.f449581md5 = r100;
            return this;
        }

        public Builder mimeType(String r100) {
            this.mimeType = r100;
            return this;
        }

        public Builder minProgressTimeMsInterval(int r100) {
            this.minProgressTimeMsInterval = r100;
            return this;
        }

        public Builder monitorScene(String r100) {
            this.monitorScene = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder needCurrentProcess(boolean r100) {
            this.needCurrentProcess = r100;
            return this;
        }

        public Builder needDefaultHttpServiceBackUp(boolean r100) {
            this.needDefaultHttpServiceBackUp = r100;
            return this;
        }

        public Builder needHttpsToHttpRetry(boolean r100) {
            this.needHttpsToHttpRetry = r100;
            return this;
        }

        public Builder needIndependentProcess(boolean r100) {
            this.needIndependentProcess = r100;
            return this;
        }

        public Builder needPostProgress(boolean r100) {
            this.needPostProgress = r100;
            return this;
        }

        public Builder needSDKMonitor(boolean r100) {
            this.needSDKMonitor = r100;
            return this;
        }

        public Builder onlyWifi(boolean r100) {
            this.onlyWifi = r100;
            return this;
        }

        public Builder outIp(String[] r100) {
            this.outIp = r100;
            return this;
        }

        public Builder outSize(int[] r100) {
            this.outSize = r100;
            return this;
        }

        public Builder packageName(String r100) {
            this.packageName = r100;
            return this;
        }

        public Builder pcdnUrls(List<String> r100) {
            this.pcdnUrls = r100;
            return this;
        }

        public Builder retryCount(int r100) {
            this.retryCount = r100;
            return this;
        }

        public Builder savePath(String r100) {
            this.savePath = r100;
            return this;
        }

        public Builder setAutoInstall(boolean r100) {
            this.autoInstall = r100;
            return this;
        }

        public Builder showNotification(boolean r100) {
            this.showNotification = r100;
            return this;
        }

        public Builder showNotificationForAutoResumed(boolean r100) {
            this.showNotificationForAutoResumed = r100;
            return this;
        }

        public Builder startOffset(long r100) {
            if (r100 <= 0) goto L5;
            this.startOffset = r100;
        L5:
            return this;
        }

        public Builder taskKey(String r100) {
            this.taskKey = r100;
            return this;
        }

        public Builder tempPath(String r100) {
            this.tempPath = r100;
            return this;
        }

        public Builder throttleNetSpeed(long r100) {
            this.throttleNetSpeed = r100;
            return this;
        }

        public Builder throttleSmoothness(int r100) {
            this.throttleSmoothness = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder ttnetByPassProxy(boolean r100) {
            this.ttnetByPassProxy = r100;
            return this;
        }

        public Builder ttnetProtectTimeout(long r100) {
            this.ttnetProtectTimeout = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static class RawBuilder extends Builder {
        public long backCurBytes;
        public String backUpUrlsStr;
        public String cdnUrlsStr;
        public int chunkCount;
        public long curBytes;
        public int curRetryTime;
        public String dbJsonDataString;
        public long downloadFinishTimeStamp;
        public long downloadStartTimeStamp;
        public long downloadTime;
        public String etag;
        public boolean hasDoInstallation;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public int f449582id;
        public long installedTimeStamp;
        public boolean isFirstDownload;
        public boolean isFirstSuccess;
        public int notificationVisibility;
        public String pcdnUrlsStr;
        public long realBackDownloadTime;
        public long realDownloadTime;
        public int status;
        public long totalBytes;

        @Override // com.ss.android.socialbase.downloader.model.DownloadInfo.Builder
        public DownloadInfo build() {
            return new DownloadInfo(this, null);
        }

        public RawBuilder() {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setDeleteCacheIfCheckFailed() {
        this.deleteCacheIfCheckFailed = true;
    }

    public void setForbiddenRetryed() {
        this.isForbiddenRetryed = true;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    private void ensureDBJsonData() {
        if (this.dbJsonData != null) goto L18;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (this.dbJsonData == null) goto L20;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L20:
    L12:
        this.dbJsonData = new JSONObject();     // Catch: Throwable -> L15
        goto L13
    L8:
        if (TextUtils.isEmpty(this.dbJsonDataString) == true) goto L10;
        this.dbJsonData = new JSONObject(this.dbJsonDataString);     // Catch: Throwable -> L12
        this.dbJsonDataString = null;     // Catch: Throwable -> L12
    L19:
    L10:
        this.dbJsonData = new JSONObject();     // Catch: Throwable -> L12
        goto L19
    }

    private void ensureSpData() {
        if (this.spData != null) goto L18;
        Context r100 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r100 == null) goto L13;
        String r101 = r100.getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).getString(Long.toString(getId()), "");
        if (TextUtils.isEmpty(r101) == true) goto L13;
        this.spData = new JSONObject(r101);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L13:
        if (this.spData != null) goto L19;
        this.spData = new JSONObject();
        return;
    L19:
        return;
    }

    private void ensureTempCacheData() {
        if (this.tempCacheData != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.tempCacheData != null) goto L8;
        this.tempCacheData = new ConcurrentHashMap();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    private void parseMonitorSetting() {
        if (OPTIMIZE_MONITOR_LOAD == true) goto L5;
    L7:
        unsafeEnsureDBJsonData();
        int r100 = 0;
        this.needSDKMonitor = this.dbJsonData.optBoolean(DbJsonConstants.NEED_SDK_MONITOR, false);
        this.monitorScene = this.dbJsonData.optString("monitor_scene", "");
        JSONArray r101 = this.dbJsonData.optJSONArray(DbJsonConstants.EXTRA_MONITOR_STATUS);
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.length() <= 0) goto L17;
        this.extraMonitorStatus = new int[r101.length()];
    L13:
        if (r100 >= r101.length()) goto L18;
        this.extraMonitorStatus[r100] = r101.optInt(r100);
        r100 = r100 + 1;
        goto L13
    L18:
        return;
    L17:
        return;
    L5:
        if (TextUtils.isEmpty(this.monitorScene) == true) goto L7;
    }

    public boolean canNotifyProgress() {
        if (this.lastNotifyProgressTime != 0) goto L5;
    L8:
        return true;
    L5:
        if ((SystemClock.uptimeMillis() - this.lastNotifyProgressTime) > 20) goto L8;
        return false;
    }

    public boolean canReplaceHttpForRetry() {
        if (TextUtils.isEmpty(this.url) == false) goto L5;
    L11:
        return false;
    L5:
        if (this.url.startsWith("https") == false) goto L11;
        if (this.needHttpsToHttpRetry == false) goto L11;
        if (this.httpsToHttpRetryUsed == true) goto L11;
        return true;
    }

    public boolean canShowNotification() {
        boolean r100 = this.autoResumed;
        if (r100 == false) goto L5;
    L6:
        if (r100 == true) goto L8;
    L12:
        return false;
    L8:
        if (this.showNotificationForAutoResumed == false) goto L10;
    L11:
        return true;
    L10:
        if (this.showNotificationForNetworkResumed == false) goto L12;
    L5:
        if (this.showNotification == true) goto L11;
        goto L6
    }

    public int checkMd5Status() {
        return DownloadUtils.checkMd5Status(new DownloadFile(getSavePath(), getName()), this.f449580md5);
    }

    public void erase() {
        setCurBytes(0, true);
        setBackCurBytes(0);
        this.totalBytes = 0;
        this.chunkCount = 1;
        this.downloadTime = 0;
        this.realStartDownloadTime = 0;
        this.realDownloadTime = 0;
        this.realBackDownloadTime = 0;
        this.curRetryTime = 0;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.backUpUrlUsed = false;
        this.httpsToHttpRetryUsed = false;
        this.eTag = null;
        this.failedException = null;
        this.tempCacheData = null;
        this.packageInfoRef = null;
    }

    public long getBackCurBytes() {
        AtomicLong r100 = this.backCurBytes;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.get();
    }

    public String getBackUpUrl() {
        if (this.backUpUrlUsed == false) goto L15;
        List<String> r100 = this.backUpUrls;
        if (r100 == null) goto L15;
        if (r100.size() <= 0) goto L15;
        int r101 = this.curBackUpUrlIndex;
        if (r101 < 0) goto L15;
        if (r101 >= this.backUpUrls.size()) goto L15;
        String r102 = (String) ListProtector.get(this.backUpUrls, this.curBackUpUrlIndex);
        if (TextUtils.isEmpty(r102) == true) goto L15;
        return r102;
    L15:
        return "";
    }

    public String getBackUpUrlsStr() {
        if (this.backUpUrlsStr != null) goto L6;
        this.backUpUrlsStr = DownloadUtils.listToJsonString(this.backUpUrls);
    L6:
        return this.backUpUrlsStr;
    }

    public String getCdnUrlsStr() {
        if (this.cdnUrlsStr != null) goto L6;
        this.cdnUrlsStr = DownloadUtils.listToJsonString(this.cdnUrls);
    L6:
        return this.cdnUrlsStr;
    }

    public String getConnectionUrl() {
        String r100 = this.url;
        if (getStatus() != 8) goto L12;
        List<String> r101 = this.forbiddenBackupUrls;
        if (r101 == null) goto L12;
        if (r101.isEmpty() == true) goto L12;
        if (this.backUpUrlUsed == true) goto L12;
        return (String) ListProtector.get(this.forbiddenBackupUrls, 0);
    L12:
        if (this.backUpUrlUsed == false) goto L25;
        List<String> r102 = this.backUpUrls;
        if (r102 == null) goto L25;
        if (r102.size() <= 0) goto L25;
        int r103 = this.curBackUpUrlIndex;
        if (r103 < 0) goto L25;
        if (r103 >= this.backUpUrls.size()) goto L25;
        String r104 = (String) ListProtector.get(this.backUpUrls, this.curBackUpUrlIndex);
        if (TextUtils.isEmpty(r104) == false) goto L36;
        return r100;
    L36:
        return r104;
    L25:
        if (TextUtils.isEmpty(this.url) == false) goto L27;
        return r100;
    L27:
        if (this.url.startsWith("https") == true) goto L29;
        return r100;
    L29:
        if (this.needHttpsToHttpRetry == true) goto L31;
        return r100;
    L31:
        if (this.httpsToHttpRetryUsed == true) goto L33;
        return r100;
    L33:
        return this.url.replaceFirst("https", "http");
    }

    public long getCurBytes() {
        AtomicLong r100 = this.curBytes;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.get();
    }

    public int getCurRetryTimeInTotal() {
        int r100 = this.curRetryTime;
        if (this.backUpUrlUsed == false) goto L8;
        int r101 = r100 + this.retryCount;
        int r102 = this.curBackUpUrlIndex;
        if (r102 > 0) goto L7;
        return r101;
    L7:
        return r101 + (r102 * this.backUpUrlRetryCount);
    L8:
        return r100;
    }

    public String getDBJsonDataString() {
        String r100 = this.dbJsonDataString;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ensureDBJsonData();
        JSONObject r101 = this.dbJsonData;
        monitor-enter(r101);
        String r102 = this.dbJsonData.toString();     // Catch: Throwable -> L10
        this.dbJsonDataString = r102;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    public int getDownloadProcess() {
        if (this.totalBytes > 0) goto L7;
        return 0;
    L7:
        if (getCurBytes() <= this.totalBytes) goto L11;
        return 100;
    L11:
        return (int) ((getCurBytes() * 100) / this.totalBytes);
    }

    public int getId() {
        if (this.f449579id != 0) goto L6;
        this.f449579id = ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(this);
    L6:
        return this.f449579id;
    }

    public int getMinProgressTimeMsInterval() {
        int r100 = this.minProgressTimeMsInterval;
        if (r100 >= 1000) goto L6;
        return 1000;
    L6:
        return r100;
    }

    public PackageInfo getPackageInfo() {
        SoftReference<PackageInfo> r100 = this.packageInfoRef;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.get();
    }

    public String getPcdnUrlsStr() {
        if (this.pcdnUrlsStr != null) goto L6;
        this.pcdnUrlsStr = DownloadUtils.listToJsonString(this.pcdnUrls);
    L6:
        return this.pcdnUrlsStr;
    }

    public long getRealBackDownloadTime() {
        return TimeUnit.NANOSECONDS.toMillis(this.realBackDownloadTime);
    }

    public long getRealDownloadTime() {
        return TimeUnit.NANOSECONDS.toMillis(this.realDownloadTime);
    }

    public int getRealStatus() {
        AtomicInteger r100 = this.status;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.get();
    }

    public int getStatus() {
        AtomicInteger r100 = this.status;
        if (r100 == null) goto L8;
        int r101 = r100.get();
        if (r101 != (-5)) goto L10;
        return -2;
    L10:
        return r101;
    L8:
        return 0;
    }

    public String getTargetFilePath() {
        return DownloadUtils.getTargetFilePath(this.savePath, this.name);
    }

    public String getTempFilePath() {
        return DownloadUtils.getTempFilePath(this.savePath, this.tempPath, this.name);
    }

    public String getTempName() {
        return DownloadUtils.getTempFileName(this.name);
    }

    public String getTempPath() {
        return DownloadUtils.getTempFileSavePath(this.savePath, this.tempPath);
    }

    public String getTitle() {
        if (TextUtils.isEmpty(this.title) == false) goto L7;
        return this.name;
    L7:
        return this.title;
    }

    public int getTotalRetryCount() {
        int r100 = this.retryCount;
        List<String> r101 = this.backUpUrls;
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return r100;
    L7:
        return r100 + (this.backUpUrlRetryCount * this.backUpUrls.size());
    }

    public boolean hasNextBackupUrl() {
        List<String> r100 = this.backUpUrls;
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if (r100.size() <= 0) goto L13;
        if (this.backUpUrlUsed == false) goto L15;
        int r101 = this.curBackUpUrlIndex;
        if (r101 < 0) goto L13;
        if (r101 >= (this.backUpUrls.size() - 1)) goto L13;
        return true;
    L15:
        return true;
    }

    public boolean isAutoInstallWithoutNotification() {
        if (this.isAutoInstallWithoutNotification != null) goto L11;
        if (TextUtils.isEmpty(this.extra) == false) goto L12;
        this.isAutoInstallWithoutNotification = Boolean.FALSE;
        goto L11
    L12:
        this.isAutoInstallWithoutNotification = Boolean.valueOf(new JSONObject(this.extra).optBoolean(DownloadConstants.AUTO_INSTALL_WITHOUT_NOTIFICATION, false));     // Catch: JSONException -> L8
    L8:
        this.isAutoInstallWithoutNotification = Boolean.FALSE;
    L11:
        return this.isAutoInstallWithoutNotification.booleanValue();
    }

    public boolean isChunked() {
        return DownloadUtils.isChunkedTask(this.totalBytes);
    }

    public boolean isEntityInvalid() {
        if (TextUtils.isEmpty(this.url) == false) goto L5;
    L10:
        return true;
    L5:
        if (TextUtils.isEmpty(this.name) == true) goto L10;
        if (TextUtils.isEmpty(this.savePath) == true) goto L10;
        return false;
    }

    public boolean isFirstDownload() {
        if (this.isFirstDownload == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(getTempPath()) == false) goto L8;
    L12:
        return false;
    L8:
        if (TextUtils.isEmpty(getTempName()) == true) goto L12;
        return !new PolarisFileWrapper(getTempPath(), getTempName()).exists();
    }

    public boolean isIgnoreInterceptor() {
        if (this.ignoreInterceptor != null) goto L9;
        ensureDBJsonData();
        boolean r100 = false;
        if (this.dbJsonData.optInt("ignore_intercept", 0) != 1) goto L7;
        r100 = true;
    L7:
        this.ignoreInterceptor = Boolean.valueOf(r100);
    L9:
        return this.ignoreInterceptor.booleanValue();
    }

    public boolean isPauseByNotification() {
        if (TextUtils.isEmpty(this.extra) == true) goto L12;
        return new JSONObject(this.extra).optBoolean(DownloadConstants.PAUSE_BY_NOTIFICATION);
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L12:
        return false;
    }

    public boolean isPauseReserveWithWifiValid() {
        if (this.mDownloadFromReserveWifi == true) goto L5;
        return true;
    L5:
        if (isPauseReserveOnWifi() == true) goto L7;
    L9:
        return false;
    L7:
        if (DownloadUtils.isWifi(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()) == false) goto L9;
        return true;
    }

    public boolean isWaitingWifiStatus() {
        BaseException r100 = this.failedException;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getErrorCode() != 1013) goto L7;
        return true;
    }

    public void reset() {
        setCurBytes(0, true);
        setBackCurBytes(0);
        this.totalBytes = 0;
        this.chunkCount = 1;
        this.downloadTime = 0;
        this.realStartDownloadTime = 0;
        this.realDownloadTime = 0;
        this.realBackDownloadTime = 0;
    }

    public void resetCacheLifeTimeMax() {
        this.cacheLifeTimeMax = 0;
    }

    public void resetRealStartDownloadTime() {
        this.realStartDownloadTime = 0;
    }

    public String toDetailString() {
        return "DownloadInfo{id=" + this.f449579id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "', tempPath='" + this.tempPath + "', onlyWifi=" + this.onlyWifi + ", extra='" + this.extra + "', extraHeaders=" + this.extraHeaders + ", maxBytes=" + this.maxBytes + ", outIp=" + Arrays.toString(this.outIp) + ", outSize=" + Arrays.toString(this.outSize) + ", retryCount=" + this.retryCount + ", backUpUrlRetryCount=" + this.backUpUrlRetryCount + ", force=" + this.force + ", needPostProgress=" + this.needPostProgress + ", maxProgressCount=" + this.maxProgressCount + ", minProgressTimeMsInterval=" + this.minProgressTimeMsInterval + ", backUpUrls=" + this.backUpUrls + ", showNotification=" + this.showNotification + ", mimeType='" + this.mimeType + "', needHttpsToHttpRetry=" + this.needHttpsToHttpRetry + ", cacheLifeTimeMax=" + this.cacheLifeTimeMax + ", pcdnUrls=" + this.pcdnUrls + ", cdnUrls=" + this.cdnUrls + ", pcdnUrlsStr='" + this.pcdnUrlsStr + "', cdnUrlsStr='" + this.cdnUrlsStr + "', packageName='" + this.packageName + "', filePackageName='" + this.filePackageName + "', md5='" + this.f449580md5 + "', allConnectTime=" + this.allConnectTime + ", needDefaultHttpServiceBackUp=" + this.needDefaultHttpServiceBackUp + ", eTag='" + this.eTag + "', curRetryTime=" + this.curRetryTime + ", asyncHandleStatus=" + this.asyncHandleStatus + ", ignoreDataVerify=" + this.ignoreDataVerify + ", needIndependentProcess=" + this.needIndependentProcess + ", needCurrentProcess=" + this.needCurrentProcess + ", supportPartial=" + this.supportPartial + ", iconUrl='" + this.iconUrl + "', curNetworkRetryCount=" + this.curNetworkRetryCount + ", needSDKMonitor=" + this.needSDKMonitor + ", monitorScene='" + this.monitorScene + "', extraMonitorStatus=" + Arrays.toString(this.extraMonitorStatus) + ", expiredRedownload=" + this.expiredRedownload + ", expiredHttpCheck=" + this.expiredHttpCheck + ", deleteCacheIfCheckFailed=" + this.deleteCacheIfCheckFailed + ", successByCache=" + this.successByCache + ", ignoreInterceptor=" + this.ignoreInterceptor + ", interceptFlag=" + this.interceptFlag + ", downloadStartTimeStamp=" + this.downloadStartTimeStamp + ", downloadFinishTimeStamp=" + this.downloadFinishTimeStamp + ", installedTimeStamp=" + this.installedTimeStamp + ", hasDoInstallation=" + this.hasDoInstallation + ", networkQuality='" + this.networkQuality + "', curBackUpUrlIndex=" + this.curBackUpUrlIndex + ", notificationVisibility=" + this.notificationVisibility + ", chunkCount=" + this.chunkCount + ", curBytes=" + this.curBytes + ", totalBytes=" + this.totalBytes + ", xTotalBytes=" + this.xTotalBytes + ", status=" + this.status + ", isFirstDownload=" + this.isFirstDownload + ", isFirstSuccess=" + this.isFirstSuccess + ", downloadTime=" + this.downloadTime + ", realDownloadTime=" + this.realDownloadTime + ", backUpUrlUsed=" + this.backUpUrlUsed + ", httpsToHttpRetryUsed=" + this.httpsToHttpRetryUsed + ", startDownloadTime=" + this.startDownloadTime + ", realStartDownloadTime=" + this.realStartDownloadTime + ", bindValueCount=" + this.bindValueCount + ", autoResumed=" + this.autoResumed + ", showNotificationForAutoResumed=" + this.showNotificationForAutoResumed + ", showNotificationForNetworkResumed=" + this.showNotificationForNetworkResumed + ", forbiddenBackupUrls=" + this.forbiddenBackupUrls + ", byteInvalidRetryStatus=" + this.byteInvalidRetryStatus + ", enqueueType=" + this.enqueueType + ", httpStatusCode=" + this.httpStatusCode + ", httpStatusMessage='" + this.httpStatusMessage + "', lastNotifyProgressTime=" + this.lastNotifyProgressTime + ", isForbiddenRetryed=" + this.isForbiddenRetryed + ", appVersionCode=" + this.appVersionCode + ", throttleNetSpeed=" + this.throttleNetSpeed + ", throttleSmoothness=" + this.throttleSmoothness + ", openLimitSpeed=" + this.openLimitSpeed + ", isCacheExistsInDownloading=" + this.isCacheExistsInDownloading + ", contentEncoding='" + this.contentEncoding + "', addListenerToSameTask=" + this.addListenerToSameTask + ", backUpUrlsStr='" + this.backUpUrlsStr + "', failedException=" + this.failedException + ", pcdnStats=" + this.pcdnStats + ", spData=" + this.spData + ", dbJsonData=" + this.dbJsonData + ", dbJsonDataString='" + this.dbJsonDataString + "', tempCacheData=" + this.tempCacheData + ", statusAtDbInit=" + this.statusAtDbInit + ", mDownloadFromReserveWifi=" + this.mDownloadFromReserveWifi + ", packageInfoRef=" + this.packageInfoRef + ", ttnetProtectTimeout=" + this.ttnetProtectTimeout + ", addTTNetCommonParam=" + this.addTTNetCommonParam + ", ttnetByPassProxy=" + this.ttnetByPassProxy + ", accessHttpHeaderKeys=" + this.accessHttpHeaderKeys + ", httpHeaders=" + this.httpHeaders + ", isAutoInstallWithoutNotification=" + this.isAutoInstallWithoutNotification + ", callStack=" + this.callStack + '}';
    }

    public String toString() {
        return "DownloadInfo{id=" + this.f449579id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "'}";
    }

    public boolean trySwitchToNextBackupUrl() {
        if (this.backUpUrlUsed == false) goto L5;
        this.curBackUpUrlIndex++;
    L5:
        List<String> r100 = this.backUpUrls;
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (r100.size() == 0) goto L19;
        if (this.curBackUpUrlIndex < 0) goto L19;
    L13:
        if (this.curBackUpUrlIndex >= this.backUpUrls.size()) goto L19;
        if (TextUtils.isEmpty((String) ListProtector.get(this.backUpUrls, this.curBackUpUrlIndex)) == false) goto L16;
        this.curBackUpUrlIndex++;
        goto L13
    L16:
        this.backUpUrlUsed = true;
        return true;
    }

    public void unsafeEnsureDBJsonData() {
        if (this.dbJsonData == null) goto L14;
        return;
    L14:
    L10:
        this.dbJsonData = new JSONObject();
    L11:
        this.dbJsonDataString = null;
        return;
    L6:
        if (TextUtils.isEmpty(this.dbJsonDataString) == true) goto L8;
        this.dbJsonData = new JSONObject(this.dbJsonDataString);     // Catch: Throwable -> L10
    L13:
        goto L11
    L8:
        this.dbJsonData = new JSONObject();     // Catch: Throwable -> L10
        goto L13
    }

    public void updateDownloadTime() {
        if (this.startDownloadTime != 0) goto L5;
        return;
    L5:
        long r100 = SystemClock.uptimeMillis() - this.startDownloadTime;
        if (this.downloadTime >= 0) goto L9;
        this.downloadTime = 0;
    L9:
        if (r100 <= 0) goto L12;
        this.downloadTime = r100;
        return;
    }

    public void updateRealStartDownloadTime() {
        if (this.realStartDownloadTime != 0) goto L6;
        this.realStartDownloadTime = System.nanoTime();
        return;
    }

    public void updateSpData() {
        if (this.spData != null) goto L5;
        return;
    L5:
        Context r100 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r100 == null) goto L9;
        r100.getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).edit().putString(Integer.toString(getId()), this.spData.toString()).apply();
        return;
    }

    public DownloadInfo() {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0;
        this.downloadFinishTimeStamp = 0;
        this.installedTimeStamp = 0;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
    }

    private int getReserveWifiStatus() {
        ensureSpData();
        return this.spData.optInt("pause_reserve_on_wifi", 0);
    L8:
        return 0;
    }

    public boolean cacheExpierd() {
        if (isDownloaded() == true) goto L7;
        return true;
    L7:
        return DownloadUtils.cacheExpired(this);
    }

    public boolean canReStartAsyncTask() {
        if (getStatus() != (-3)) goto L5;
    L7:
        return false;
    L5:
        if (this.asyncHandleStatus != AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L7;
        return true;
    }

    public boolean canSkipStatusHandler() {
        if (getStatus() == 8) goto L12;
        AsyncHandleStatus r100 = this.asyncHandleStatus;
        if (r100 == AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L12;
        if (r100 == AsyncHandleStatus.ASYNC_HANDLE_RESTART) goto L12;
        if (this.byteInvalidRetryStatus == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) goto L12;
        return false;
    L12:
        return true;
    }

    public void changeSkipStatus() {
        if (getStatus() == 8) goto L8;
        AsyncHandleStatus r100 = this.asyncHandleStatus;
        if (r100 == AsyncHandleStatus.ASYNC_HANDLE_WAITING) goto L8;
        if (r100 == AsyncHandleStatus.ASYNC_HANDLE_RESTART) goto L8;
    L10:
        if (this.byteInvalidRetryStatus != ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) goto L13;
        setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        return;
    L13:
        return;
    L8:
        setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING);
        goto L10
    }

    public boolean checkMd5Valid() {
        return DownloadUtils.checkMd5Valid(getSavePath(), getName(), this.f449580md5);
    }

    public long getAllConnectTime() {
        ensureDBJsonData();
        if (this.allConnectTime != null) goto L6;
        this.allConnectTime = new AtomicLong(this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_ALL_CONNECT_TIME));
    L6:
        return this.allConnectTime.get();
    }

    public long getCacheExpiredTime() {
        ensureSpData();
        return this.spData.optLong(SpJsonConstants.CACHE_CONTROL_EXPIRED_TIME, -1);
    L8:
        return -1;
    }

    public long getDownloadPrepareTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_DOWNLOAD_PREPARE_TIME);
    }

    public String getDownloadSettingString() {
        ensureDBJsonData();
        return this.dbJsonData.optString(DbJsonConstants.DOWNLOAD_SETTING);
    }

    public double getDownloadSpeed() {
        double r100 = getCurBytes() / 1048576.0d;
        double r101 = getRealDownloadTime() / 1000.0d;
        if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L7:
        return -1.0d;
    L5:
        if (r101 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        return r100 / r101;
    }

    public long getEndOffset() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_END_OFFSET, -1);
    }

    public int getExecutorGroup() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("executor_group", 2);
    }

    public long getExpectFileLength() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_EXPECT_FILE_LENGTH);
    }

    public int getFailedResumeCount() {
        ensureSpData();
        return this.spData.optInt("failed_resume_count", 0);
    }

    public long getFirstSpeedTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_FIRST_SPEED_TIME);
    }

    public String getInstallBizParamsJson() {
        ensureSpData();
        return this.spData.optString(SpJsonConstants.KEY_INSTALL_BIZ_PARAMS_JSON);
    }

    public String getInstallBizType() {
        ensureSpData();
        return this.spData.optString(SpJsonConstants.KEY_INSTALL_BIZ_TYPE);
    }

    public String getInstallCertId() {
        ensureSpData();
        return this.spData.optString(SpJsonConstants.KEY_INSTALL_CERT_ID);
    }

    public long getLastDownloadTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_LAST_START_DOWNLOAD_TIME, 0);
    }

    public long getLastFailedResumeTime() {
        ensureSpData();
        return this.spData.optLong(SpJsonConstants.KEY_LAST_FAILED_RESUME_TIME, 0);
    }

    public String getLastModified() {
        ensureSpData();
        return this.spData.optString("last-modified", null);
    L8:
        return null;
    }

    public long getLastUninstallResumeTime() {
        ensureSpData();
        return this.spData.optLong(SpJsonConstants.KEY_LAST_UNINSTALL_RESUME_TIME, 0);
    }

    public int getLinkMode() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("link_mode");
    }

    public PackageInfo getPackageInfoWithCache() {
        ensureDBJsonData();
        String r100 = this.dbJsonData.optString(DbJsonConstants.DBJSON_KEY_APP_PACKAGE_INFO);
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return null;
    L10:
        String[] r101 = r100.split(",");     // Catch: Throwable -> L7
        PackageInfo r102 = new PackageInfo();     // Catch: Throwable -> L7
        r102.packageName = r101[0];     // Catch: Throwable -> L7
        r102.versionName = r101[1];     // Catch: Throwable -> L7
        r102.versionCode = CastIntegerProtector.parseInt(r101[2]);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public int getPausedResumeCount() {
        ensureSpData();
        return this.spData.optInt(DownloadConstants.KEY_PAUSED_RESUME_COUNT, 0);
    }

    public String getRedirectPartialUrlResults() {
        ensureDBJsonData();
        return this.dbJsonData.optString(DbJsonConstants.DBJSON_KEY_REDIRECT_PARTIAL_URL_RESULTS);
    }

    public int getRetryScheduleCount() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("retry_schedule_count", 0);
    }

    public long getStartOffset() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_START_OFFSET);
    }

    public int getTTMd5CheckStatus() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.DBJSON_KEY_TTMD5_CHECK_STATUS, -1);
    }

    public String getTaskKey() {
        ensureDBJsonData();
        return this.dbJsonData.optString(DbJsonConstants.DBJSON_KEY_TASK_KEY);
    }

    public ConcurrentHashMap<String, Object> getTempCacheData() {
        ensureTempCacheData();
        return this.tempCacheData;
    }

    public int getUninstallResumeCount() {
        ensureSpData();
        return this.spData.optInt(SpJsonConstants.KEY_UNINSTALL_RESUME_COUNT, 0);
    }

    public boolean hasPauseReservedOnWifi() {
        if ((getReserveWifiStatus() & 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isAutoInstall() {
        ensureDBJsonData();
        if (this.dbJsonData.optInt("auto_install", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isCanResumeFromBreakPointStatus() {
        int r100 = getStatus();
        if (r100 != 4) goto L5;
        return true;
    L5:
        if (r100 != 3) goto L7;
        return true;
    L7:
        if (r100 != (-1)) goto L9;
        return true;
    L9:
        if (r100 != 5) goto L11;
        return true;
    L11:
        if (r100 == 8) goto L24;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L16;
    L18:
        return false;
    L16:
        if (getCurBytes() <= 0) goto L18;
        return true;
    L24:
        return true;
    }

    public boolean isDownloadOverStatus() {
        return DownloadStatus.isDownloadOver(getStatus());
    }

    public boolean isDownloadWithWifiValid() {
        if (isOnlyWifi() == true) goto L5;
    L8:
        return true;
    L5:
        if (DownloadUtils.isWifi(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()) == true) goto L8;
        return false;
    }

    public boolean isDownloaded() {
        return DownloadUtils.isFileDownloaded(this);
    }

    public boolean isDownloadingStatus() {
        return DownloadStatus.isDownloading(getStatus());
    }

    public boolean isFileDataExists() {
        if (isEntityInvalid() == false) goto L5;
        return false;
    L5:
        PolarisFileWrapper r100 = new PolarisFileWrapper(getTempPath(), getTempName());
        boolean r101 = r100.exists();
        boolean r102 = r100.isDirectory();
        if (r101 == false) goto L11;
        if (r102 == true) goto L11;
        return true;
    L11:
        return false;
    }

    public boolean isFileDataValid() {
        if (isEntityInvalid() == false) goto L5;
        return false;
    L5:
        PolarisFileWrapper r100 = new PolarisFileWrapper(getTempPath(), getTempName());
        boolean r101 = r100.exists();
        boolean r102 = r100.isDirectory();
        if (Logger.debugScene(this) == false) goto L8;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Temp file:" + r100 + "IsExists:" + r101 + " isDirectory: " + r102);
    L8:
        if (r101 == false) goto L30;
        if (r102 == true) goto L30;
        long r103 = r100.length();
        long r104 = getCurBytes();
        if (r104 <= 0) goto L28;
        long r110 = this.totalBytes;
        if (r110 <= 0) goto L28;
        if (this.chunkCount <= 0) goto L28;
        if (r103 < r104) goto L28;
        if (r103 > r110) goto L28;
        if (Logger.debugScene(this) == false) goto L31;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Valid, FileLength+" + r103 + " curBytes:" + r104);
        return true;
    L31:
        return true;
    L28:
        if (Logger.debugScene(this) == false) goto L30;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Invalid, Cur = " + r104 + ",totalBytes =" + this.totalBytes + ",fileLength=" + r103 + ", chunkCount:" + this.chunkCount);
    L30:
        return false;
    }

    public boolean isFileDataValidOptimize() {
        if (isEntityInvalid() == false) goto L5;
        return false;
    L5:
        PolarisFileWrapper r100 = new PolarisFileWrapper(getTempPath(), getTempName());
        boolean r101 = r100.exists();
        if (r101 == false) goto L8;
        boolean r102 = r100.isDirectory();
        if (r102 == true) goto L14;
        long r103 = getCurBytes();
        if (r103 <= 0) goto L39;
        if (this.totalBytes <= 0) goto L39;
        if (this.chunkCount <= 0) goto L39;
        long r104 = r100.length();
        if (r104 < r103) goto L35;
        if (r104 > this.totalBytes) goto L35;
        if (Logger.debugScene(this) == false) goto L42;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Valid, FileLength+" + r104 + " curBytes:" + r103);
        return true;
    L42:
        return true;
    L35:
        if (Logger.debugScene(this) == false) goto L37;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Invalid, Cur = " + r103 + ",totalBytes =" + this.totalBytes + ",fileLength=" + r104 + ", chunkCount:" + this.chunkCount);
    L37:
        return false;
    L39:
        if (Logger.debugScene(this) == false) goto L41;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Invalid, Cur = " + r103 + ",totalBytes =" + this.totalBytes + ", chunkCount:" + this.chunkCount);
    L41:
        return false;
    L14:
        if (Logger.debugScene(this) == false) goto L16;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Temp file:" + r100 + "IsDirectory:" + r102);
    L16:
        return false;
    L8:
        if (Logger.debugScene(this) == false) goto L10;
        Logger.taskDebug(TAG, this, "isFileDataValid", "Temp file:" + r100 + "IsExists:" + r101);
    L10:
        return false;
    }

    public boolean isNewTask() {
        if (getStatus() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPauseReserveOnWifi() {
        if ((getReserveWifiStatus() & 2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSavePathRedirected() {
        ensureDBJsonData();
        return this.dbJsonData.optBoolean(DbJsonConstants.DBJSON_KEY_IS_SAVE_PATH_REDIRECTED, false);
    }

    public void setLastNotifyProgressTime() {
        this.lastNotifyProgressTime = SystemClock.uptimeMillis();
    }

    public void startPauseReserveOnWifi() {
        ensureSpData();
        this.spData.put("pause_reserve_on_wifi", 3);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public boolean statusInPause() {
        if (getRealStatus() != (-2)) goto L5;
    L8:
        return true;
    L5:
        if (getRealStatus() == (-5)) goto L8;
        return false;
    }

    public void stopPauseReserveOnWifi() {
        ensureSpData();
        this.spData.put("pause_reserve_on_wifi", 1);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public void updateStartDownloadTime() {
        this.startDownloadTime = SystemClock.uptimeMillis();
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_LAST_START_DOWNLOAD_TIME, Long.valueOf(System.currentTimeMillis()));
    }

    public List<String> getAccessHttpHeaderKeys() {
        return this.accessHttpHeaderKeys;
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public AsyncHandleStatus getAsyncHandleStatus() {
        return this.asyncHandleStatus;
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public List<String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public ByteInvalidRetryStatus getByteInvalidRetryStatus() {
        return this.byteInvalidRetryStatus;
    }

    public long getCacheLifeTimeMax() {
        return this.cacheLifeTimeMax;
    }

    public String getCallStack() {
        return this.callStack;
    }

    public List<String> getCdnUrls() {
        return this.cdnUrls;
    }

    public int getChunkCount() {
        return this.chunkCount;
    }

    public int getConcurrentConnCount() {
        return this.concurrentConnCount;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public int getCurBackUpUrlIndex() {
        return this.curBackUpUrlIndex;
    }

    public int getCurNetworkRetryCount() {
        return this.curNetworkRetryCount;
    }

    public int getCurRetryTime() {
        return this.curRetryTime;
    }

    public int getDBInitStatus() {
        return this.mDBInitStatus;
    }

    public long getDownloadFinishTimeStamp() {
        return this.downloadFinishTimeStamp;
    }

    public long getDownloadStartTimeStamp() {
        return this.downloadStartTimeStamp;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public EnqueueType getEnqueueType() {
        return this.enqueueType;
    }

    public String getExtra() {
        return this.extra;
    }

    public List<HttpHeader> getExtraHeaders() {
        return this.extraHeaders;
    }

    public int[] getExtraMonitorStatus() {
        return this.extraMonitorStatus;
    }

    public BaseException getFailedException() {
        return this.failedException;
    }

    public String getFilePackageName() {
        return this.filePackageName;
    }

    public List<String> getForbiddenBackupUrls() {
        return this.forbiddenBackupUrls;
    }

    public Map<String, String> getHttpHeaders() {
        return this.httpHeaders;
    }

    public String getHttpRequestHeader() {
        return this.httpRequestHeader;
    }

    public String getHttpResponseHeader() {
        return this.httpResponseHeader;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public String getHttpStatusMessage() {
        return this.httpStatusMessage;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getInstalledTimeStamp() {
        return this.installedTimeStamp;
    }

    public int getInterceptFlag() {
        return this.interceptFlag;
    }

    public boolean getIsFirstDownload() {
        return this.isFirstDownload;
    }

    public int getMaxBytes() {
        return this.maxBytes;
    }

    public int getMaxProgressCount() {
        return this.maxProgressCount;
    }

    public String getMd5() {
        return this.f449580md5;
    }

    public long getMd5Time() {
        return this.md5Time;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getMonitorScene() {
        return this.monitorScene;
    }

    public String getName() {
        return this.name;
    }

    public String getNetworkQuality() {
        return this.networkQuality;
    }

    public int getNotificationVisibility() {
        return this.notificationVisibility;
    }

    public boolean getOpenLimitSpeed() {
        return this.openLimitSpeed;
    }

    public String[] getOutIp() {
        return this.outIp;
    }

    public int[] getOutSize() {
        return this.outSize;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public JSONObject getPcdnStats() {
        return this.pcdnStats;
    }

    public List<String> getPcdnUrls() {
        return this.pcdnUrls;
    }

    public long getRacingTaskExcessBytes() {
        return this.racingTaskExcessBytes;
    }

    public int getRawId() {
        return this.f449579id;
    }

    public long getRawRealBackDownloadTime() {
        return this.realBackDownloadTime;
    }

    public long getRawRealDownloadTime() {
        return this.realDownloadTime;
    }

    public String getRawTempPath() {
        return this.tempPath;
    }

    public String getRawTitle() {
        return this.title;
    }

    public String getRequestLog() {
        return this.requestLog;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public int getStatusAtDbInit() {
        return this.statusAtDbInit;
    }

    public int getTaskSleepTime() {
        return this.mTaskSleepTime;
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public int getThrottleSmoothness() {
        return this.throttleSmoothness;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public long getTtnetProtectTimeout() {
        return this.ttnetProtectTimeout;
    }

    public String getUrl() {
        return this.url;
    }

    public long getVerifyCurBytes() {
        return this.verifyCurBytes;
    }

    public long getXTotalBytes() {
        return this.xTotalBytes;
    }

    public String geteTag() {
        return this.eTag;
    }

    public boolean isAddListenerToSameTask() {
        return this.addListenerToSameTask;
    }

    public boolean isAddTTNetCommonParam() {
        return this.addTTNetCommonParam;
    }

    public boolean isAutoResumed() {
        return this.autoResumed;
    }

    public boolean isBackUpUrlUsed() {
        return this.backUpUrlUsed;
    }

    public boolean isCacheExistsInDownloading() {
        return this.isCacheExistsInDownloading;
    }

    public boolean isDeleteCacheIfCheckFailed() {
        return this.deleteCacheIfCheckFailed;
    }

    public boolean isDownloadFromReserveWifi() {
        return this.mDownloadFromReserveWifi;
    }

    public boolean isExpiredHttpCheck() {
        return this.expiredHttpCheck;
    }

    public boolean isExpiredRedownload() {
        return this.expiredRedownload;
    }

    public boolean isFastDownload() {
        return this.fastDownload;
    }

    public boolean isFastDownloadCommonThreadPool() {
        return this.fastDownloadCommonThreadPool;
    }

    public boolean isFirstSuccess() {
        return this.isFirstSuccess;
    }

    public boolean isForbiddenRetryed() {
        return this.isForbiddenRetryed;
    }

    public boolean isForce() {
        return this.force;
    }

    public boolean isForceWifiBound() {
        return this.forceWifiBound;
    }

    public boolean isHandleRequest() {
        return this.handleRequest;
    }

    public boolean isHasDoInstallation() {
        return this.hasDoInstallation;
    }

    public boolean isHttpsToHttpRetryUsed() {
        return this.httpsToHttpRetryUsed;
    }

    public boolean isIgnoreDataVerify() {
        return this.ignoreDataVerify;
    }

    public boolean isNeedCurrentProcess() {
        return this.needCurrentProcess;
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

    public boolean isNeedPostProgress() {
        return this.needPostProgress;
    }

    public boolean isNeedSDKMonitor() {
        return this.needSDKMonitor;
    }

    public boolean isOnlyWifi() {
        return this.onlyWifi;
    }

    public boolean isResumeFileDownload() {
        return this.resumeFileDownload;
    }

    public boolean isShowNotification() {
        return this.showNotification;
    }

    public boolean isShowNotificationForAutoResumed() {
        return this.showNotificationForAutoResumed;
    }

    public boolean isShowNotificationForNetworkResumed() {
        return this.showNotificationForNetworkResumed;
    }

    public boolean isSuccessByCache() {
        return this.successByCache;
    }

    public boolean isSupportPartial() {
        return this.supportPartial;
    }

    public boolean isTTNetByPassProxy() {
        return this.ttnetByPassProxy;
    }

    private DownloadInfo(Builder r100) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        int r101 = 0;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0;
        this.downloadFinishTimeStamp = 0;
        this.installedTimeStamp = 0;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
        if (r100 != null) goto L5;
        return;
    L5:
        this.status = new AtomicInteger(0);
        this.curBytes = new AtomicLong(0);
        this.monitorScene = r100.monitorScene;
        this.fastDownload = Builder.access$000(r100);
        this.fastDownloadCommonThreadPool = Builder.access$100(r100);
        this.resumeFileDownload = Builder.access$200(r100);
        this.name = r100.name;
        this.url = r100.url;
        String r102 = r100.savePath;
        if (TextUtils.isEmpty(r102) == true) goto L49;
    L11:
        this.savePath = r102;
        this.handleRequest = Builder.access$300(r100);
        this.backUpUrls = Builder.access$400(r100);
        this.concurrentConnCount = Builder.access$500(r100);
        if (Builder.access$000(r100) == false) goto L15;
        this.tempPath = DownloadDirUtils.getDownloadFastTempPath();
        return;
    L15:
        this.backCurBytes = new AtomicLong(0);
        this.tempPath = r100.tempPath;
        unsafeEnsureDBJsonData();
        unsafePutToDBJsonData(DbJsonConstants.DBJSON_KEY_TASK_KEY, Builder.access$600(r100));
        if (TextUtils.isEmpty(this.tempPath) == false) goto L21;
        if (DownloadDirUtils.isSavePathSecurity(r102) == true) goto L21;
        this.tempPath = DownloadDirUtils.getDownloadTempPath();
    L21:
        if (Builder.access$700(r100) == true) goto L23;
    L25:
        this.extra = r100.extra;
        this.onlyWifi = r100.onlyWifi;
        this.extraHeaders = Builder.access$800(r100);
        this.maxBytes = Builder.access$900(r100);
        this.retryCount = r100.retryCount;
        this.backUpUrlRetryCount = r100.backUpUrlRetryCount;
        this.force = r100.force;
        this.outIp = Builder.access$1000(r100);
        this.outSize = Builder.access$1100(r100);
        this.needPostProgress = Builder.access$1200(r100);
        this.maxProgressCount = Builder.access$1300(r100);
        this.minProgressTimeMsInterval = Builder.access$1400(r100);
        this.showNotification = r100.showNotification;
        this.mimeType = r100.mimeType;
        this.needHttpsToHttpRetry = r100.needHttpsToHttpRetry;
        this.autoResumed = Builder.access$1500(r100);
        this.showNotificationForAutoResumed = Builder.access$1600(r100);
        this.needDefaultHttpServiceBackUp = r100.needDefaultHttpServiceBackUp;
        this.packageName = r100.packageName;
        this.f449580md5 = r100.f449581md5;
        this.needIndependentProcess = r100.needIndependentProcess;
        this.needCurrentProcess = r100.needCurrentProcess;
        this.enqueueType = Builder.access$1700(r100);
        this.ignoreDataVerify = Builder.access$1800(r100);
        this.addListenerToSameTask = Builder.access$1900(r100);
        this.iconUrl = r100.iconUrl;
        this.throttleNetSpeed = Builder.access$2000(r100);
        this.throttleSmoothness = Builder.access$2100(r100);
        this.forceWifiBound = Builder.access$2200(r100);
        this.openLimitSpeed = Builder.access$2300(r100);
        this.title = r100.title;
        this.callStack = r100.callStack;
        JSONObject r103 = Builder.access$2400(r100);
        if (r103 == null) goto L28;
        DownloadSetting.addTaskDownloadSetting(getId(), r100.monitorScene, r103);
        unsafePutToDBJsonData(DbJsonConstants.DOWNLOAD_SETTING, r103.toString());
    L28:
        unsafePutToDBJsonData(DbJsonConstants.DBJSON_KEY_EXPECT_FILE_LENGTH, Long.valueOf(Builder.access$2500(r100)));
        unsafePutToDBJsonData("executor_group", Integer.valueOf(Builder.access$2600(r100)));
        unsafePutToDBJsonData("auto_install", Integer.valueOf(Builder.access$2700(r100) ? 1 : 0));
        this.needSDKMonitor = Builder.access$2800(r100);
        this.extraMonitorStatus = Builder.access$2900(r100);
        this.expiredRedownload = Builder.access$3000(r100);
        this.expiredHttpCheck = Builder.access$3100(r100);
        this.deleteCacheIfCheckFailed = Builder.access$3200(r100);
        this.ttnetProtectTimeout = Builder.access$3300(r100);
        this.addTTNetCommonParam = Builder.access$3400(r100);
        this.ttnetByPassProxy = Builder.access$3500(r100);
        Boolean r104 = Boolean.valueOf(Builder.access$3600(r100));
        this.ignoreInterceptor = r104;
        if (r104.booleanValue() == false) goto L31;
    L32:
        this.interceptFlag = 0;
    L33:
        this.accessHttpHeaderKeys = Builder.access$3700(r100);
        this.pcdnUrls = r100.pcdnUrls;
        this.cdnUrls = r100.cdnUrls;
        this.cacheLifeTimeMax = r100.cacheLifeTimeMax;
        unsafePutToDBJsonData("ignore_intercept", Integer.valueOf(Builder.access$3600(r100) ? 1 : 0));
        unsafePutToDBJsonData(DbJsonConstants.DBJSON_KEY_START_OFFSET, Long.valueOf(Builder.access$3800(r100)));
        unsafePutToDBJsonData(DbJsonConstants.DBJSON_KEY_END_OFFSET, Long.valueOf(Builder.access$3900(r100)));
        if (OPTIMIZE_MONITOR_LOAD == false) goto L36;
        return;
    L36:
        unsafePutToDBJsonData(DbJsonConstants.NEED_SDK_MONITOR, Boolean.valueOf(this.needSDKMonitor));
        unsafePutToDBJsonData("monitor_scene", this.monitorScene);
        JSONArray r105 = new JSONArray();     // Catch: Throwable -> L46
        int[] r106 = this.extraMonitorStatus;     // Catch: Throwable -> L46
        if (r106 != null) goto L40;
    L44:
        unsafePutToDBJsonData(DbJsonConstants.EXTRA_MONITOR_STATUS, r105);     // Catch: Throwable -> L46
        return;
    L40:
        if (r106.length <= 0) goto L44;
    L41:
        int[] r107 = this.extraMonitorStatus;     // Catch: Throwable -> L46
        if (r101 >= r107.length) goto L44;
        r105.put(r107[r101]);     // Catch: Throwable -> L46
        r101 = r101 + 1;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        if (((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getDownloadInterceptor() != null) goto L33;
    L23:
        if (((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getDownloadInfo(getId()) != null) goto L25;
        this.savePath = DownloadUtils.generateDistinctDirectory(this.savePath, this.url);
        this.tempPath = DownloadUtils.generateDistinctDirectory(this.tempPath, this.url);
        goto L25
    L49:
        r102 = DownloadDirUtils.getDownloadPath();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    private void convertEnqueueType(int r100) {
        EnqueueType r101 = EnqueueType.ENQUEUE_HEAD;
        if (r100 != r101.ordinal()) goto L5;
        this.enqueueType = r101;
        return;
    L5:
        EnqueueType r102 = EnqueueType.ENQUEUE_TAIL;
        if (r100 != r102.ordinal()) goto L8;
        this.enqueueType = r102;
        return;
    L8:
        EnqueueType r103 = EnqueueType.NEW_ENQUEUE_NORMAL;
        if (r100 != r103.ordinal()) goto L11;
        this.enqueueType = r103;
        return;
    L11:
        EnqueueType r104 = EnqueueType.NEW_ENQUEUE_IMMEDIATE;
        if (r100 != r104.ordinal()) goto L14;
        this.enqueueType = r104;
        return;
    L14:
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
    }

    private void mergeAuxiliaryJSONObject(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ensureDBJsonData();
        JSONObject r101 = this.dbJsonData;
        monitor-enter(r101);
        Iterator<String> r102 = r100.keys();     // Catch: Throwable -> L15 Exception -> L24
    L8:
        if (r102.hasNext() == false) goto L18;
        String r103 = r102.next();     // Catch: Throwable -> L15 Exception -> L24
        Object r104 = r100.opt(r103);     // Catch: Throwable -> L15 Exception -> L24
        if (this.dbJsonData.has(r103) == true) goto L8;
        if (r104 == null) goto L8;
        this.dbJsonData.put(r103, r104);     // Catch: Throwable -> L15 Exception -> L24
    L15:
        th = move-exception;
        throw th;
    L18:
        this.dbJsonDataString = null;     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        parseMonitorSetting();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    private void refreshBackupUrls(boolean r100) {
        List<String> r101 = this.forbiddenBackupUrls;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() <= r100) goto L16;
        List<String> r102 = this.backUpUrls;
        if (r102 != null) goto L9;
        this.backUpUrls = new ArrayList();
    L10:
        this.backUpUrlUsed = false;
        this.curBackUpUrlIndex = 0;
        ?? r103 = r100;
    L12:
        if (r103 >= this.forbiddenBackupUrls.size()) goto L17;
        this.backUpUrls.add((String) ListProtector.get(this.forbiddenBackupUrls, r103));
        r103 = r103 + 1;
        goto L12
    L17:
        return;
    L9:
        r102.clear();
        goto L10
    }

    public static void setOptimizeMonitorLoad(boolean r100) {
        OPTIMIZE_MONITOR_LOAD = r100;
    }

    public void bindValue(SQLiteStatement r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        this.bindValueCount = 0;
        r110.clearBindings();
        int r100 = this.bindValueCount + 1;
        this.bindValueCount = r100;
        r110.bindLong(r100, this.f449579id);
        int r101 = this.bindValueCount + 1;
        this.bindValueCount = r101;
        String r102 = this.url;
        String r103 = "";
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r110.bindString(r101, r102);
        int r104 = this.bindValueCount + 1;
        this.bindValueCount = r104;
        String r105 = this.savePath;
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        r110.bindString(r104, r105);
        int r106 = this.bindValueCount + 1;
        this.bindValueCount = r106;
        String r107 = this.tempPath;
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        r110.bindString(r106, r107);
        int r108 = this.bindValueCount + 1;
        this.bindValueCount = r108;
        String r109 = this.name;
        if (r109 != null) goto L16;
        r109 = "";
    L16:
        r110.bindString(r108, r109);
        int r111 = this.bindValueCount + 1;
        this.bindValueCount = r111;
        r110.bindLong(r111, this.chunkCount);
        int r112 = this.bindValueCount + 1;
        this.bindValueCount = r112;
        r110.bindLong(r112, getStatus());
        int r113 = this.bindValueCount + 1;
        this.bindValueCount = r113;
        r110.bindLong(r113, getCurBytes());
        int r114 = this.bindValueCount + 1;
        this.bindValueCount = r114;
        r110.bindLong(r114, this.totalBytes);
        int r115 = this.bindValueCount + 1;
        this.bindValueCount = r115;
        String r116 = this.eTag;
        if (r116 != null) goto L19;
        r116 = "";
    L19:
        r110.bindString(r115, r116);
        int r117 = this.bindValueCount + 1;
        this.bindValueCount = r117;
        long r118 = 1;
        if (this.onlyWifi == false) goto L22;
        long r119 = 1;
    L23:
        r110.bindLong(r117, r119);
        int r120 = this.bindValueCount + 1;
        this.bindValueCount = r120;
        if (this.force == false) goto L26;
        long r121 = 1;
    L27:
        r110.bindLong(r120, r121);
        int r122 = this.bindValueCount + 1;
        this.bindValueCount = r122;
        r110.bindLong(r122, this.retryCount);
        int r123 = this.bindValueCount + 1;
        this.bindValueCount = r123;
        String r124 = this.extra;
        if (r124 != null) goto L30;
        r124 = "";
    L30:
        r110.bindString(r123, r124);
        int r125 = this.bindValueCount + 1;
        this.bindValueCount = r125;
        String r126 = this.mimeType;
        if (r126 != null) goto L33;
        r126 = "";
    L33:
        r110.bindString(r125, r126);
        int r127 = this.bindValueCount + 1;
        this.bindValueCount = r127;
        String r128 = this.title;
        if (r128 != null) goto L36;
        r128 = "";
    L36:
        r110.bindString(r127, r128);
        int r129 = this.bindValueCount + 1;
        this.bindValueCount = r129;
        if (this.showNotification == false) goto L39;
        long r130 = 1;
    L40:
        r110.bindLong(r129, r130);
        int r131 = this.bindValueCount + 1;
        this.bindValueCount = r131;
        r110.bindLong(r131, this.notificationVisibility);
        int r132 = this.bindValueCount + 1;
        this.bindValueCount = r132;
        if (this.isFirstDownload == false) goto L43;
        long r133 = 1;
    L44:
        r110.bindLong(r132, r133);
        int r134 = this.bindValueCount + 1;
        this.bindValueCount = r134;
        if (this.isFirstSuccess == false) goto L47;
        long r135 = 1;
    L48:
        r110.bindLong(r134, r135);
        int r136 = this.bindValueCount + 1;
        this.bindValueCount = r136;
        if (this.needHttpsToHttpRetry == false) goto L51;
        long r137 = 1;
    L52:
        r110.bindLong(r136, r137);
        int r138 = this.bindValueCount + 1;
        this.bindValueCount = r138;
        r110.bindLong(r138, this.downloadTime);
        int r139 = this.bindValueCount + 1;
        this.bindValueCount = r139;
        String r140 = this.packageName;
        if (r140 != null) goto L55;
        r140 = "";
    L55:
        r110.bindString(r139, r140);
        int r141 = this.bindValueCount + 1;
        this.bindValueCount = r141;
        String r142 = this.f449580md5;
        if (r142 != null) goto L58;
        r142 = "";
    L58:
        r110.bindString(r141, r142);
        int r143 = this.bindValueCount + 1;
        this.bindValueCount = r143;
        r110.bindLong(r143, 0);
        int r144 = this.bindValueCount + 1;
        this.bindValueCount = r144;
        r110.bindLong(r144, this.curRetryTime);
        int r145 = this.bindValueCount + 1;
        this.bindValueCount = r145;
        r110.bindLong(r145, 0);
        int r146 = this.bindValueCount + 1;
        this.bindValueCount = r146;
        if (this.needDefaultHttpServiceBackUp == false) goto L61;
        long r147 = 1;
    L62:
        r110.bindLong(r146, r147);
        int r148 = this.bindValueCount + 1;
        this.bindValueCount = r148;
        r110.bindLong(r148, 0);
        int r149 = this.bindValueCount + 1;
        this.bindValueCount = r149;
        r110.bindString(r149, "");
        int r150 = this.bindValueCount + 1;
        this.bindValueCount = r150;
        r110.bindLong(r150, 0);
        int r151 = this.bindValueCount + 1;
        this.bindValueCount = r151;
        r110.bindString(r151, getBackUpUrlsStr());
        int r152 = this.bindValueCount + 1;
        this.bindValueCount = r152;
        r110.bindLong(r152, this.backUpUrlRetryCount);
        int r153 = this.bindValueCount + 1;
        this.bindValueCount = r153;
        r110.bindLong(r153, this.realDownloadTime);
        int r154 = this.bindValueCount + 1;
        this.bindValueCount = r154;
        r110.bindLong(r154, 0);
        int r155 = this.bindValueCount + 1;
        this.bindValueCount = r155;
        if (this.needIndependentProcess == false) goto L65;
        long r156 = 1;
    L66:
        r110.bindLong(r155, r156);
        int r157 = this.bindValueCount + 1;
        this.bindValueCount = r157;
        r110.bindString(r157, getDBJsonDataString());
        int r158 = this.bindValueCount + 1;
        this.bindValueCount = r158;
        String r159 = this.iconUrl;
        if (r159 != null) goto L69;
        r159 = "";
    L69:
        r110.bindString(r158, r159);
        int r160 = this.bindValueCount + 1;
        this.bindValueCount = r160;
        r110.bindLong(r160, this.appVersionCode);
        int r161 = this.bindValueCount + 1;
        this.bindValueCount = r161;
        r110.bindString(r161, "");
        int r162 = this.bindValueCount + 1;
        this.bindValueCount = r162;
        r110.bindLong(r162, this.downloadStartTimeStamp);
        int r163 = this.bindValueCount + 1;
        this.bindValueCount = r163;
        r110.bindLong(r163, this.downloadFinishTimeStamp);
        int r164 = this.bindValueCount + 1;
        this.bindValueCount = r164;
        r110.bindLong(r164, this.installedTimeStamp);
        int r165 = this.bindValueCount + 1;
        this.bindValueCount = r165;
        if (this.hasDoInstallation == true) goto L73;
        r118 = 0;
    L73:
        r110.bindLong(r165, r118);
        int r166 = this.bindValueCount + 1;
        this.bindValueCount = r166;
        r110.bindLong(r166, this.cacheLifeTimeMax);
        int r167 = this.bindValueCount + 1;
        this.bindValueCount = r167;
        r110.bindString(r167, getPcdnUrlsStr());
        int r168 = this.bindValueCount + 1;
        this.bindValueCount = r168;
        r110.bindString(r168, getCdnUrlsStr());
        int r169 = this.bindValueCount + 1;
        this.bindValueCount = r169;
        r110.bindLong(r169, getBackCurBytes());
        int r170 = this.bindValueCount + 1;
        this.bindValueCount = r170;
        r110.bindLong(r170, this.realBackDownloadTime);
        int r171 = this.bindValueCount + 1;
        this.bindValueCount = r171;
        String r172 = this.monitorScene;
        if (r172 == null) goto L77;
        r103 = r172;
    L77:
        r110.bindString(r171, r103);
        return;
    L65:
        r156 = 0;
        goto L66
    L61:
        r147 = 0;
        goto L62
    L51:
        r137 = 0;
        goto L52
    L47:
        r135 = 0;
        goto L48
    L43:
        r133 = 0;
        goto L44
    L39:
        r130 = 0;
        goto L40
    L26:
        r121 = 0;
        goto L27
    L22:
        r119 = 0;
        goto L23
    }

    public boolean equalsTask(DownloadInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = this.url;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.equals(r100.getUrl()) == false) goto L16;
        String r102 = this.savePath;
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r102.equals(r100.getSavePath()) == false) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    public int getAntiHijackErrorCode(int r100) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.DBJSON_KEY_ANTI_HIJACK_ERROR_CODE, r100);
    }

    public int getDBJsonInt(String r100) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(r100);
    }

    public String getDBJsonString(String r100) {
        ensureDBJsonData();
        return this.dbJsonData.optString(r100);
    }

    public long getMinByteIntervalForPostToMainThread(long r100) {
        int r101 = this.maxProgressCount;
        if (r101 > 0) goto L5;
        r101 = 100;
    L5:
        long r102 = r100 / ((long) (r101 + 1));
        if (r102 > 0) goto L9;
        return 1048576;
    L9:
        return r102;
    }

    public int getSpIntVal(String r100) {
        ensureSpData();
        return this.spData.optInt(r100, 0);
    }

    public long getSpLongVal(String r100) {
        ensureSpData();
        return this.spData.optLong(r100, 0);
    }

    public String getSpStringVal(String r100) {
        ensureSpData();
        return this.spData.optString(r100, null);
    }

    public void increaseAllConnectTime(long r100) {
        if (r100 <= 0) goto L6;
        getAllConnectTime();
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_ALL_CONNECT_TIME, Long.valueOf(this.allConnectTime.addAndGet(r100)));
        return;
    }

    public void increaseCurBytes(long r100) {
        this.curBytes.addAndGet(r100);
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        if (AppStatusManager.getInstance().isAppBackground() == false) goto L9;
        this.backCurBytes.addAndGet(r100);
        return;
    }

    public void increaseDownloadPrepareTime(long r100) {
        if (this.fastDownload == false) goto L5;
        return;
    L5:
        long r101 = System.currentTimeMillis() - r100;
        if (r101 <= 0) goto L9;
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_DOWNLOAD_PREPARE_TIME, Long.valueOf(getDownloadPrepareTime() + r101));
        return;
    }

    public void readFromParcel(Parcel r100) {
        this.f449579id = r100.readInt();
        this.name = r100.readString();
        this.title = r100.readString();
        this.url = r100.readString();
        this.savePath = r100.readString();
        this.tempPath = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.onlyWifi = r102;
        this.extra = r100.readString();
        this.extraHeaders = r100.createTypedArrayList(HttpHeader.CREATOR);
        this.maxBytes = r100.readInt();
        this.outIp = r100.createStringArray();
        this.outSize = r100.createIntArray();
        this.retryCount = r100.readInt();
        this.backUpUrlRetryCount = r100.readInt();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.force = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.needPostProgress = r104;
        this.maxProgressCount = r100.readInt();
        this.minProgressTimeMsInterval = r100.readInt();
        this.backUpUrls = r100.createStringArrayList();
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.showNotification = r105;
        this.mimeType = r100.readString();
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.needHttpsToHttpRetry = r106;
        this.packageName = r100.readString();
        this.f449580md5 = r100.readString();
        if (r100.readByte() == 0) goto L25;
        boolean r107 = true;
    L26:
        this.needDefaultHttpServiceBackUp = r107;
        this.eTag = r100.readString();
        this.curRetryTime = r100.readInt();
        this.networkQuality = r100.readString();
        this.curBackUpUrlIndex = r100.readInt();
        this.notificationVisibility = r100.readInt();
        this.chunkCount = r100.readInt();
        setCurBytes(r100.readLong());
        setBackCurBytes(r100.readLong());
        this.totalBytes = r100.readLong();
        setStatus(r100.readInt());
        this.downloadTime = r100.readLong();
        this.realDownloadTime = r100.readLong();
        this.realBackDownloadTime = r100.readLong();
        if (r100.readByte() == 0) goto L29;
        boolean r108 = true;
    L30:
        this.backUpUrlUsed = r108;
        if (r100.readByte() == 0) goto L33;
        boolean r109 = true;
    L34:
        this.httpsToHttpRetryUsed = r109;
        if (r100.readByte() == 0) goto L37;
        boolean r110 = true;
    L38:
        this.autoResumed = r110;
        if (r100.readByte() == 0) goto L41;
        boolean r111 = true;
    L42:
        this.showNotificationForAutoResumed = r111;
        if (r100.readByte() == 0) goto L45;
        boolean r112 = true;
    L46:
        this.showNotificationForNetworkResumed = r112;
        this.forbiddenBackupUrls = r100.createStringArrayList();
        if (r100.readByte() == 0) goto L49;
        boolean r113 = true;
    L50:
        this.needIndependentProcess = r113;
        convertEnqueueType(r100.readInt());
        this.httpStatusCode = r100.readInt();
        this.httpStatusMessage = r100.readString();
        if (r100.readByte() == 0) goto L53;
        boolean r114 = true;
    L54:
        this.isForbiddenRetryed = r114;
        if (r100.readByte() == 0) goto L57;
        boolean r115 = true;
    L58:
        this.addListenerToSameTask = r115;
        this.failedException = (BaseException) r100.readParcelable(BaseException.class.getClassLoader());
        this.dbJsonDataString = r100.readString();
        if (r100.readByte() == 0) goto L61;
        boolean r116 = true;
    L62:
        this.supportPartial = r116;
        this.iconUrl = r100.readString();
        this.appVersionCode = r100.readInt();
        if (r100.readByte() == 0) goto L65;
        boolean r117 = true;
    L66:
        this.expiredRedownload = r117;
        if (r100.readByte() == 0) goto L69;
        boolean r118 = true;
    L70:
        this.deleteCacheIfCheckFailed = r118;
        if (r100.readByte() == 0) goto L73;
        boolean r119 = true;
    L74:
        this.successByCache = r119;
        if (r100.readByte() == 0) goto L77;
        boolean r120 = true;
    L78:
        this.expiredHttpCheck = r120;
        this.xTotalBytes = r100.readLong();
        this.interceptFlag = r100.readInt();
        this.accessHttpHeaderKeys = r100.createStringArrayList();
        this.httpHeaders = r100.readHashMap(getClass().getClassLoader());
        this.downloadStartTimeStamp = r100.readLong();
        this.downloadFinishTimeStamp = r100.readLong();
        this.installedTimeStamp = r100.readLong();
        if (r100.readByte() == 0) goto L81;
        boolean r121 = true;
    L82:
        this.hasDoInstallation = r121;
        if (r100.readByte() == 0) goto L85;
        boolean r122 = true;
    L86:
        this.isCacheExistsInDownloading = r122;
        this.cacheLifeTimeMax = r100.readLong();
        this.pcdnUrls = r100.createStringArrayList();
        this.cdnUrls = r100.createStringArrayList();
        this.contentEncoding = r100.readString();
        if (r100.readByte() == 0) goto L89;
        boolean r123 = true;
    L90:
        this.fastDownload = r123;
        if (r100.readByte() == 0) goto L93;
        boolean r124 = true;
    L94:
        this.handleRequest = r124;
        this.md5Time = r100.readLong();
        this.httpRequestHeader = r100.readString();
        this.httpResponseHeader = r100.readString();
        this.requestLog = r100.readString();
        this.verifyCurBytes = r100.readLong();
        if (r100.readByte() == 0) goto L97;
        boolean r125 = true;
    L98:
        this.needCurrentProcess = r125;
        this.monitorScene = r100.readString();
        this.callStack = r100.readString();
        if (r100.readByte() == 0) goto L101;
        boolean r126 = true;
    L102:
        this.resumeFileDownload = r126;
        this.concurrentConnCount = r100.readInt();
        this.racingTaskExcessBytes = r100.readLong();
        if (r100.readByte() != 0) goto L106;
        r101 = false;
    L106:
        this.fastDownloadCommonThreadPool = r101;
        parseMonitorSetting();
        return;
    L101:
        r126 = false;
        goto L102
    L97:
        r125 = false;
        goto L98
    L93:
        r124 = false;
        goto L94
    L89:
        r123 = false;
        goto L90
    L85:
        r122 = false;
        goto L86
    L81:
        r121 = false;
        goto L82
    L77:
        r120 = false;
        goto L78
    L73:
        r119 = false;
        goto L74
    L69:
        r118 = false;
        goto L70
    L65:
        r117 = false;
        goto L66
    L61:
        r116 = false;
        goto L62
    L57:
        r115 = false;
        goto L58
    L53:
        r114 = false;
        goto L54
    L49:
        r113 = false;
        goto L50
    L45:
        r112 = false;
        goto L46
    L41:
        r111 = false;
        goto L42
    L37:
        r110 = false;
        goto L38
    L33:
        r109 = false;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public void resetDataForEtagEndure(String r100) {
        setCurBytes(0, true);
        setBackCurBytes(0);
        setTotalBytes(0);
        seteTag(r100);
        setChunkCount(1);
        setLastModified(null);
        this.downloadTime = 0;
        this.realStartDownloadTime = 0;
        this.realDownloadTime = 0;
        this.realBackDownloadTime = 0;
    }

    public void setAddListenerToSameTask(boolean r100) {
        this.addListenerToSameTask = r100;
    }

    public void setAntiHijackErrorCode(int r100) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_ANTI_HIJACK_ERROR_CODE, Integer.valueOf(r100));
    }

    public void setAppVersionCode(int r100) {
        this.appVersionCode = r100;
    }

    public void setAsyncHandleStatus(AsyncHandleStatus r100) {
        this.asyncHandleStatus = r100;
    }

    public void setAutoResumed(boolean r100) {
        this.autoResumed = r100;
    }

    public void setBackCurBytes(long r100) {
        AtomicLong r101 = this.backCurBytes;
        if (r101 == null) goto L5;
        r101.set(r100);
        return;
    L5:
        this.backCurBytes = new AtomicLong(r100);
    }

    public void setBackUpUrlRetryCount(int r100) {
        this.backUpUrlRetryCount = r100;
    }

    public void setBackUpUrlsStr(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (getStatus() == (-3)) goto L10;
        this.backUpUrlsStr = r100;
        this.backUpUrls = DownloadUtils.jsonStringTolist(r100);
        return;
    }

    public void setByteInvalidRetryStatus(ByteInvalidRetryStatus r100) {
        this.byteInvalidRetryStatus = r100;
    }

    public void setCacheExistsInDownloading(boolean r100) {
        this.isCacheExistsInDownloading = r100;
    }

    public void setCacheExpiredTime(long r100) {
        ensureSpData();
        this.spData.put(SpJsonConstants.CACHE_CONTROL_EXPIRED_TIME, r100);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public void setCacheLifeTimeMax(long r100) {
        this.cacheLifeTimeMax = r100;
    }

    public void setCdnUrlsStr(String r100) {
        this.cdnUrlsStr = r100;
    }

    public void setChunkCount(int r100) {
        this.chunkCount = r100;
    }

    public void setContentEncoding(String r100) {
        this.contentEncoding = r100;
    }

    public void setCurBytes(long r100) {
        AtomicLong r101 = this.curBytes;
        if (r101 == null) goto L5;
        r101.set(r100);
        return;
    L5:
        this.curBytes = new AtomicLong(r100);
    }

    public void setCurNetworkRetryCount(int r100) {
        this.curNetworkRetryCount = r100;
    }

    public void setCurRetryTime(int r100) {
        this.curRetryTime = r100;
    }

    public void setDBInitStatus(int r100) {
        this.mDBInitStatus = r100;
    }

    public void setDbJsonDataString(String r100) {
        this.dbJsonDataString = r100;
    }

    public void setDownloadFinishTimeStamp(long r100) {
        this.downloadFinishTimeStamp = r100;
    }

    public void setDownloadFromReserveWifi(boolean r100) {
        this.mDownloadFromReserveWifi = r100;
    }

    public void setDownloadStartTimeStamp(long r100) {
        this.downloadStartTimeStamp = r100;
    }

    public void setDownloadTime(long r100) {
        this.downloadTime = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setFailedException(BaseException r100) {
        this.failedException = r100;
    }

    public void setFailedResumeCount(int r100) {
        ensureSpData();
        this.spData.put("failed_resume_count", r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setFilePackageName(String r100) {
        this.filePackageName = r100;
    }

    public void setFirstDownload(boolean r100) {
        this.isFirstDownload = r100;
    }

    public void setFirstSpeedTime(long r100) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_FIRST_SPEED_TIME, Long.valueOf(r100));
    }

    public void setFirstSuccess(boolean r100) {
        this.isFirstSuccess = r100;
    }

    public void setForce(boolean r100) {
        this.force = r100;
    }

    public void setHasDoInstallation(boolean r100) {
        this.hasDoInstallation = r100;
    }

    public void setHttpHeaders(Map<String, String> r100) {
        this.httpHeaders = r100;
    }

    public void setHttpRequestHeader(String r100) {
        this.httpRequestHeader = r100;
    }

    public void setHttpResponseHeader(String r100) {
        this.httpResponseHeader = r100;
    }

    public void setHttpStatusCode(int r100) {
        this.httpStatusCode = r100;
    }

    public void setHttpStatusMessage(String r100) {
        this.httpStatusMessage = r100;
    }

    public void setHttpsToHttpRetryUsed(boolean r100) {
        this.httpsToHttpRetryUsed = r100;
    }

    public void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public void setId(int r100) {
        this.f449579id = r100;
    }

    public void setIgnoreDataVerify(boolean r100) {
        this.ignoreDataVerify = r100;
    }

    public void setInstallBizParamsJson(String r100) {
        ensureSpData();
        this.spData.put(SpJsonConstants.KEY_INSTALL_BIZ_PARAMS_JSON, r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.taskError(TAG, this.f449579id, "setInstallBizParamsJson", "Error:" + e);
    }

    public void setInstallBizType(String r100) {
        ensureSpData();
        this.spData.put(SpJsonConstants.KEY_INSTALL_BIZ_TYPE, r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.taskError(TAG, this.f449579id, "setInstallBizType", "Error:" + e);
    }

    public void setInstallCertId(String r100) {
        ensureSpData();
        this.spData.put(SpJsonConstants.KEY_INSTALL_CERT_ID, r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.taskError(TAG, this.f449579id, "setInstallCertId", "Error:" + e);
    }

    public void setInstalledTimeStamp(long r100) {
        this.installedTimeStamp = r100;
    }

    public void setInterceptFlag(int r100) {
        this.interceptFlag = r100;
    }

    public void setLastFailedResumeTime(long r100) {
        ensureSpData();
        this.spData.put(SpJsonConstants.KEY_LAST_FAILED_RESUME_TIME, r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setLastModified(String r100) {
        ensureSpData();
        this.spData.put("last-modified", r100);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    }

    public void setLastUninstallResumeTime(long r100) {
        ensureSpData();
        this.spData.put(SpJsonConstants.KEY_LAST_UNINSTALL_RESUME_TIME, r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setLinkMode(int r100) {
        safePutToDBJsonData("link_mode", Integer.valueOf(r100));
    }

    public void setMd5(String r100) {
        this.f449580md5 = r100;
    }

    public void setMd5Time(long r100) {
        this.md5Time = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setMonitorScene(String r100) {
        this.monitorScene = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setNeedDefaultHttpServiceBackUp(boolean r100) {
        this.needDefaultHttpServiceBackUp = r100;
    }

    public void setNeedHttpsToHttpRetry(boolean r100) {
        this.needHttpsToHttpRetry = r100;
    }

    public void setNeedIndependentProcess(boolean r100) {
        this.needIndependentProcess = r100;
    }

    public void setNetworkQuality(String r100) {
        this.networkQuality = r100;
    }

    public void setNotificationVisibility(int r100) {
        this.notificationVisibility = r100;
    }

    public void setOnlyWifi(boolean r100) {
        this.onlyWifi = r100;
    }

    public void setOpenLimitSpeed(boolean r100) {
        this.openLimitSpeed = r100;
    }

    public void setPackageInfo(PackageInfo r100) {
        this.packageInfoRef = new SoftReference(r100);
    }

    public void setPackageInfoToCache(PackageInfo r100) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_APP_PACKAGE_INFO, r100.packageName + "," + r100.versionName + "," + r100.versionCode);
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setPauseByNotification(boolean r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (TextUtils.isEmpty(this.extra) == false) goto L5;
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L8
    L6:
        r101.put(DownloadConstants.PAUSE_BY_NOTIFICATION, r100);     // Catch: JSONException -> L8
        this.extra = r101.toString();     // Catch: JSONException -> L8
        return;
    L5:
        r101 = new JSONObject(this.extra);     // Catch: JSONException -> L8
        goto L6
    }

    public void setPausedResumeCount(int r100) {
        ensureSpData();
        this.spData.put(DownloadConstants.KEY_PAUSED_RESUME_COUNT, r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setPcdnStats(JSONObject r100) {
        this.pcdnStats = r100;
    }

    public void setPcdnUrlsStr(String r100) {
        this.pcdnUrlsStr = r100;
    }

    public void setRacingTaskExcessBytes(long r100) {
        this.racingTaskExcessBytes = r100;
    }

    public void setRealBackDownloadTime(long r100) {
        this.realBackDownloadTime = r100;
    }

    public void setRealDownloadTime(long r100) {
        this.realDownloadTime = r100;
    }

    public void setRedirectPartialUrlResults(String r100) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_REDIRECT_PARTIAL_URL_RESULTS, r100);
    }

    public void setRequestLog(String r100) {
        this.requestLog = r100;
    }

    public void setRetryCount(int r100) {
        this.retryCount = r100;
    }

    public void setRetryScheduleCount(int r100) {
        safePutToDBJsonData("retry_schedule_count", Integer.valueOf(r100));
    }

    public void setSavePath(String r100) {
        this.savePath = r100;
    }

    public void setSavePathRedirected(boolean r100) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_IS_SAVE_PATH_REDIRECTED, Boolean.valueOf(r100));
    }

    public void setShowNotification(boolean r100) {
        this.showNotification = r100;
    }

    public void setShowNotificationForAutoResumed(boolean r100) {
        this.showNotificationForAutoResumed = r100;
    }

    public void setShowNotificationForNetworkResumed(boolean r100) {
        this.showNotificationForNetworkResumed = r100;
    }

    public void setStatus(int r100) {
        AtomicInteger r101 = this.status;
        if (r101 == null) goto L5;
        r101.set(r100);
        return;
    L5:
        this.status = new AtomicInteger(r100);
    }

    public void setStatusAtDbInit(int r100) {
        this.statusAtDbInit = r100;
    }

    public void setSuccessByCache(boolean r100) {
        this.successByCache = r100;
    }

    public void setSupportPartial(boolean r100) {
        this.supportPartial = r100;
    }

    public void setTTMd5CheckStatus(int r100) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_TTMD5_CHECK_STATUS, Integer.valueOf(r100));
    }

    public void setTaskSleepTime(int r100) {
        this.mTaskSleepTime = r100;
    }

    public void setTempPath(String r100) {
        this.tempPath = r100;
    }

    public void setThrottleNetSpeed(long r100) {
        setThrottleNetSpeed(r100, -1);
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setTotalBytes(long r100) {
        this.totalBytes = r100;
    }

    public void setUninstallResumeCount(int r100) {
        ensureSpData();
        this.spData.put(SpJsonConstants.KEY_UNINSTALL_RESUME_COUNT, r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setVerifyCurBytes(long r100) {
        this.verifyCurBytes = r100;
    }

    public void setXTotalBytes(long r100) {
        this.xTotalBytes = r100;
    }

    public void seteTag(String r100) {
        this.eTag = r100;
    }

    public void updateCurRetryTime(int r100) {
        if (this.backUpUrlUsed == false) goto L5;
        int r101 = this.backUpUrlRetryCount;
    L6:
        int r102 = r101 - r100;
        this.curRetryTime = r102;
        if (r102 >= 0) goto L10;
        this.curRetryTime = 0;
        return;
    L10:
        return;
    L5:
        r101 = this.retryCount;
        goto L6
    }

    public void updateRealDownloadTime(boolean r100) {
        long r101 = System.nanoTime();
        long r102 = this.realStartDownloadTime;
        if (r102 > 0) goto L7;
        if (r100 == false) goto L19;
        this.realStartDownloadTime = r101;
        return;
    L19:
        return;
    L7:
        long r103 = r101 - r102;
        if (r100 == false) goto L10;
        this.realStartDownloadTime = r101;
    L12:
        if (r103 <= 0) goto L20;
        this.realDownloadTime += r103;
        if (this.fastDownload == false) goto L16;
        return;
    L16:
        if (AppStatusManager.getInstance().isAppBackground() == false) goto L22;
        this.realBackDownloadTime += r103;
        return;
    L22:
        return;
    L20:
        return;
    L10:
        this.realStartDownloadTime = 0;
        goto L12
    }

    private DownloadInfo(RawBuilder r100) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0;
        this.downloadFinishTimeStamp = 0;
        this.installedTimeStamp = 0;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
        this.f449579id = r100.f449582id;
        this.name = r100.name;
        this.title = r100.title;
        this.url = r100.url;
        this.savePath = r100.savePath;
        this.tempPath = r100.tempPath;
        this.chunkCount = r100.chunkCount;
        setStatus(r100.status);
        setCurBytes(r100.curBytes);
        setBackCurBytes(r100.backCurBytes);
        this.totalBytes = r100.totalBytes;
        this.eTag = r100.etag;
        this.onlyWifi = r100.onlyWifi;
        this.force = r100.force;
        this.retryCount = r100.retryCount;
        this.extra = r100.extra;
        this.mimeType = r100.mimeType;
        this.showNotification = r100.showNotification;
        this.notificationVisibility = r100.notificationVisibility;
        this.isFirstDownload = r100.isFirstDownload;
        this.isFirstSuccess = r100.isFirstSuccess;
        this.needHttpsToHttpRetry = r100.needHttpsToHttpRetry;
        this.downloadTime = r100.downloadTime;
        this.packageName = r100.packageName;
        this.f449580md5 = r100.f449581md5;
        this.curRetryTime = r100.curRetryTime;
        this.needDefaultHttpServiceBackUp = r100.needDefaultHttpServiceBackUp;
        this.backUpUrlsStr = r100.backUpUrlsStr;
        this.backUpUrlRetryCount = r100.backUpUrlRetryCount;
        this.realDownloadTime = r100.realDownloadTime;
        this.realBackDownloadTime = r100.realBackDownloadTime;
        this.needIndependentProcess = r100.needIndependentProcess;
        this.needCurrentProcess = r100.needCurrentProcess;
        this.dbJsonDataString = r100.dbJsonDataString;
        this.iconUrl = r100.iconUrl;
        this.appVersionCode = r100.appVersionCode;
        this.downloadStartTimeStamp = r100.downloadStartTimeStamp;
        this.downloadFinishTimeStamp = r100.downloadFinishTimeStamp;
        this.installedTimeStamp = r100.installedTimeStamp;
        this.hasDoInstallation = r100.hasDoInstallation;
        this.pcdnUrlsStr = r100.pcdnUrlsStr;
        this.cdnUrlsStr = r100.cdnUrlsStr;
        this.cacheLifeTimeMax = r100.cacheLifeTimeMax;
        this.monitorScene = r100.monitorScene;
        parseMonitorSetting();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public DownloadInfo(Parcel r100) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0;
        this.downloadFinishTimeStamp = 0;
        this.installedTimeStamp = 0;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
        readFromParcel(r100);
    }

    public DownloadInfo(Cursor r100) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0;
        this.downloadFinishTimeStamp = 0;
        this.installedTimeStamp = 0;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
    }

    public /* synthetic */ DownloadInfo(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    private void unsafePutToDBJsonData(String r100, Object r101) {
        this.dbJsonData.put(r100, r101);     // Catch: Exception -> L4
        return;
    }

    public void copyFromCacheData(DownloadInfo r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        setChunkCount(r100.getChunkCount());
        setTotalBytes(r100.getTotalBytes());
        setCurBytes(r100.getCurBytes(), true);
        setBackCurBytes(r100.getBackCurBytes());
        this.realDownloadTime = r100.realDownloadTime;
        this.realBackDownloadTime = r100.realBackDownloadTime;
        if (r100.canSkipStatusHandler() == false) goto L7;
    L9:
        this.curRetryTime = r100.getCurRetryTime();
    L10:
        seteTag(r100.geteTag());
        setMimeType(r100.getMimeType());
        if (r101 == false) goto L13;
        setStatus(r100.getStatus());
    L13:
        this.isFirstDownload = r100.getIsFirstDownload();
        this.isFirstSuccess = r100.isFirstSuccess();
        this.downloadStartTimeStamp = r100.getDownloadStartTimeStamp();
        this.downloadFinishTimeStamp = r100.getDownloadFinishTimeStamp();
        this.installedTimeStamp = r100.getInstalledTimeStamp();
        this.hasDoInstallation = r100.hasDoInstallation;
        mergeAuxiliaryJSONObject(r100.dbJsonData);
        return;
    L7:
        if (canSkipStatusHandler() == true) goto L9;
        this.curRetryTime = 0;
        this.isForbiddenRetryed = false;
        this.backUpUrlUsed = false;
        this.curBackUpUrlIndex = 0;
        this.httpsToHttpRetryUsed = false;
        goto L10
    }

    public void safePutToDBJsonData(String r100, Object r101) {
        ensureDBJsonData();
        JSONObject r102 = this.dbJsonData;
        monitor-enter(r102);
        this.dbJsonData.put(r100, r101);     // Catch: Throwable -> L6 Exception -> L14
    L6:
        th = move-exception;
        throw th;
    L9:
        this.dbJsonDataString = null;     // Catch: Throwable -> L6
        monitor-exit(r102);     // Catch: Throwable -> L6
    }

    public void setCurBytes(long r100, boolean r101) {
        if (r101 == false) goto L5;
        setCurBytes(r100);
        return;
    L5:
        if (r100 <= getCurBytes()) goto L9;
        setCurBytes(r100);
        return;
    }

    public void setForbiddenBackupUrls(List<String> r100, boolean r101) {
        this.forbiddenBackupUrls = r100;
        refreshBackupUrls(r101);
    }

    public void setSpValue(String r100, String r101) {
        ensureSpData();
        this.spData.put(r100, r101);     // Catch: Exception -> L5
        updateSpData();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void setThrottleNetSpeed(long r100, int r101) {
        this.throttleNetSpeed = r100;
        this.throttleSmoothness = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f449579id);
        r100.writeString(this.name);
        r100.writeString(this.title);
        r100.writeString(this.url);
        r100.writeString(this.savePath);
        r100.writeString(this.tempPath);
        r100.writeByte(this.onlyWifi ? 1 : 0);
        r100.writeString(this.extra);
        r100.writeTypedList(this.extraHeaders);
        r100.writeInt(this.maxBytes);
        r100.writeStringArray(this.outIp);
        r100.writeIntArray(this.outSize);
        r100.writeInt(this.retryCount);
        r100.writeInt(this.backUpUrlRetryCount);
        r100.writeByte(this.force ? 1 : 0);
        r100.writeByte(this.needPostProgress ? 1 : 0);
        r100.writeInt(this.maxProgressCount);
        r100.writeInt(this.minProgressTimeMsInterval);
        r100.writeStringList(this.backUpUrls);
        r100.writeByte(this.showNotification ? 1 : 0);
        r100.writeString(this.mimeType);
        r100.writeByte(this.needHttpsToHttpRetry ? 1 : 0);
        r100.writeString(this.packageName);
        r100.writeString(this.f449580md5);
        r100.writeByte(this.needDefaultHttpServiceBackUp ? 1 : 0);
        r100.writeString(this.eTag);
        r100.writeInt(this.curRetryTime);
        r100.writeString(this.networkQuality);
        r100.writeInt(this.curBackUpUrlIndex);
        r100.writeInt(this.notificationVisibility);
        r100.writeInt(this.chunkCount);
        r100.writeLong(getCurBytes());
        r100.writeLong(getBackCurBytes());
        r100.writeLong(this.totalBytes);
        r100.writeInt(getRealStatus());
        r100.writeLong(this.downloadTime);
        r100.writeLong(this.realDownloadTime);
        r100.writeLong(this.realBackDownloadTime);
        r100.writeByte(this.backUpUrlUsed ? 1 : 0);
        r100.writeByte(this.httpsToHttpRetryUsed ? 1 : 0);
        r100.writeByte(this.autoResumed ? 1 : 0);
        r100.writeByte(this.showNotificationForAutoResumed ? 1 : 0);
        r100.writeByte(this.showNotificationForNetworkResumed ? 1 : 0);
        r100.writeStringList(this.forbiddenBackupUrls);
        r100.writeByte(this.needIndependentProcess ? 1 : 0);
        r100.writeInt(this.enqueueType.ordinal());
        r100.writeInt(this.httpStatusCode);
        r100.writeString(this.httpStatusMessage);
        r100.writeByte(this.isForbiddenRetryed ? 1 : 0);
        r100.writeByte(this.addListenerToSameTask ? 1 : 0);
        r100.writeParcelable(this.failedException, r101);
        r100.writeString(getDBJsonDataString());
        r100.writeByte(this.supportPartial ? 1 : 0);
        r100.writeString(this.iconUrl);
        r100.writeInt(this.appVersionCode);
        r100.writeByte(this.expiredRedownload ? 1 : 0);
        r100.writeByte(this.deleteCacheIfCheckFailed ? 1 : 0);
        r100.writeByte(this.successByCache ? 1 : 0);
        r100.writeByte(this.expiredHttpCheck ? 1 : 0);
        r100.writeLong(this.xTotalBytes);
        r100.writeInt(this.interceptFlag);
        r100.writeStringList(this.accessHttpHeaderKeys);
        r100.writeMap(this.httpHeaders);
        r100.writeLong(this.downloadStartTimeStamp);
        r100.writeLong(this.downloadFinishTimeStamp);
        r100.writeLong(this.installedTimeStamp);
        r100.writeByte(this.hasDoInstallation ? 1 : 0);
        r100.writeByte(this.isCacheExistsInDownloading ? 1 : 0);
        r100.writeLong(this.cacheLifeTimeMax);
        r100.writeStringList(this.pcdnUrls);
        r100.writeStringList(this.cdnUrls);
        r100.writeString(this.contentEncoding);
        r100.writeByte(this.fastDownload ? 1 : 0);
        r100.writeByte(this.handleRequest ? 1 : 0);
        r100.writeLong(this.md5Time);
        r100.writeString(this.httpRequestHeader);
        r100.writeString(this.httpResponseHeader);
        r100.writeString(this.requestLog);
        r100.writeLong(this.verifyCurBytes);
        r100.writeByte(this.needCurrentProcess ? 1 : 0);
        r100.writeString(this.monitorScene);
        r100.writeString(this.callStack);
        r100.writeByte(this.resumeFileDownload ? 1 : 0);
        r100.writeInt(this.concurrentConnCount);
        r100.writeLong(this.racingTaskExcessBytes);
        r100.writeByte(this.fastDownloadCommonThreadPool ? 1 : 0);
    }

    public /* synthetic */ DownloadInfo(RawBuilder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
