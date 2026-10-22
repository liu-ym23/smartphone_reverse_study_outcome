package com.ss.android.socialbase.downloader.monitor;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCdnListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IMonitorConfig;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadCdnStats;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadThreadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDefaultDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadMonitorHelper {
    private static final String DEFAULT_MONITOR_SCENE = "default";

    /* JADX INFO: loaded from: classes38.dex */
    public static class DownloadMonitorInfo {
        boolean addListenerToSameTask;
        long allConnectTime;
        AsyncHandleStatus asyncHandleStatus;
        long backCurBytes;
        boolean backUpUrlUsed;
        List<String> backUpUrls;
        ByteInvalidRetryStatus byteInvalidRetryStatus;
        String callStack;
        String contentEncoding;
        int curBackUpUrlIndex;
        long curBytes;
        int curNetworkRetryCount;
        long curRetryTime;
        long curRetryTimeInTotal;
        double downloadSpeed;
        DownloadThreadInfo downloadThreadInfo;
        long downloadTime;
        DownloadTimingInfo downloadTimingInfo;
        int enqueueType;
        String eventPage;
        BaseException exception;
        String extra;
        boolean fastDownload;
        long firstSpeedTime;
        List<String> forbiddenBackupUrls;
        boolean force;
        String httpRequestHeader;
        String httpResponseHeader;
        boolean httpsToHttpRetryUsed;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        int f449584id;
        boolean isCacheExistsInDownloading;

        /* JADX INFO: renamed from: md5, reason: collision with root package name */
        String f449585md5;
        long md5Time;
        String mimeType;
        int monitorStatus;
        String name;
        boolean needDefaultHttpServiceBackUp;
        boolean needHttpsToHttpRetry;
        boolean needIndependentProcess;
        String networkQuality;
        boolean onlyWifi;
        JSONObject pcdnStats;
        long realBackDownloadTime;
        long realDownloadTime;
        String requestLog;
        int retryCount;
        String savePath;
        int sleepTime;
        long throttleNetSpeed;
        long totalBytes;
        String url;

        private DownloadMonitorInfo() {
            this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
            this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        }

        public /* synthetic */ DownloadMonitorInfo(AnonymousClass1 r100) {
            this();
        }
    }

    public DownloadMonitorHelper() {
    }

    public static void monitorSqliteMalformed() {
        IDownloadMonitorListener r100 = DownloadComponentManager.getDownloadMonitorListener();
        if (r100 != null) goto L10;
        return;
    L10:
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L7
        r101.put("info_type", MonitorConstants.InfoType.SQLITE_MALFORMED);     // Catch: Throwable -> L7
        r101.put(MonitorConstants.IS_MALFORMED, 1);     // Catch: Throwable -> L7
        r100.monitorEvent(MonitorConstants.DOWNLOAD_OTHER_INFO, r101, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static /* synthetic */ JSONObject access$100(DownloadMonitorInfo r100) {
        return parseMonitorJson(r100);
    }

    public static void monitorDownloadDB(DownloadDBInitInfo r100) {
        IDownloadMonitorListener r101 = DownloadComponentManager.getDownloadMonitorListener();
        if (r101 != null) goto L10;
        return;
    L10:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L7
        r102.put(MonitorConstants.DB_INIT_DURATION, r100.initDuration);     // Catch: Throwable -> L7
        r102.put(MonitorConstants.DB_INIT_DISK_CACHE_COUNT, r100.diskCacheCount);     // Catch: Throwable -> L7
        r102.put(MonitorConstants.DB_INIT_MEMORY_CACHE_COUNT, r100.memoryCacheCount);     // Catch: Throwable -> L7
        r102.put(MonitorConstants.DB_INIT_CPU_DURATION, r100.initCpuDuration);     // Catch: Throwable -> L7
        r101.monitorEvent(MonitorConstants.DOWNLOAD_DB, r102, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorDownloadDiskCache(JSONObject r100) {
        IDownloadMonitorListener r101 = DownloadComponentManager.getDownloadMonitorListener();
        if (r101 != null) goto L10;
        return;
    L10:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L7
        r102.put(MonitorConstants.DISK_DATA, r100.toString());     // Catch: Throwable -> L7
        r101.monitorEvent(MonitorConstants.DOWNLOAD_DISK_CACHE, r102, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorDownloadOtherError(Throwable r100) {
        IDownloadMonitorListener r101 = DownloadComponentManager.getDownloadMonitorListener();
        if (r101 != null) goto L10;
        return;
    L10:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L7
        r102.put("error_code", 1091);     // Catch: Throwable -> L7
        r102.put("error_msg", r100.toString());     // Catch: Throwable -> L7
        r102.put("download_status", -1);     // Catch: Throwable -> L7
        r102.put("error_stack", Log.getStackTraceString(r100));     // Catch: Throwable -> L7
        r101.monitorEvent("download_failed", r102, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorLru(boolean r100) {
        IDownloadMonitorListener r101 = DownloadComponentManager.getDownloadMonitorListener();
        if (r101 != null) goto L14;
        return;
    L14:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L11
        r102.put("info_type", MonitorConstants.InfoType.LRU_CACHE);     // Catch: Throwable -> L11
        if (r100 == false) goto L8;
        int r103 = 1;
    L9:
        r102.put(MonitorConstants.ENABLE_LRU, r103);     // Catch: Throwable -> L11
        r101.monitorEvent(MonitorConstants.DOWNLOAD_OTHER_INFO, r102, null, null);     // Catch: Throwable -> L11
        return;
    L8:
        r103 = 0;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    private static JSONObject parseMonitorJson(DownloadMonitorInfo r110) {
        JSONObject r100 = null;
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L129
        IMonitorConfig r102 = DownloadComponentManager.getMonitorConfig();     // Catch: JSONException -> L127
        int r103 = 0;
        String r104 = "";
        if (r102 == null) goto L8;
        String r105 = r102.getDeviceId();     // Catch: JSONException -> L127
        String r106 = DownloadUtils.parseDevicePostfix(r105);     // Catch: JSONException -> L127
        String r107 = r102.getAppId();     // Catch: JSONException -> L127
        int r108 = r102.getUpdateVersion();     // Catch: JSONException -> L127
    L9:
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r110.eventPage);     // Catch: JSONException -> L127
        r101.put("app_id", r107);     // Catch: JSONException -> L127
        r101.put("device_id", r105);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_DEVICE_ID_POSTFIX, r106);     // Catch: JSONException -> L127
        r101.put("update_version", r108);     // Catch: JSONException -> L127
        r101.put("download_status", r110.monitorStatus);     // Catch: JSONException -> L127
        r101.put(DownloadSettingKeys.SETTING_TAG, DownloadSetting.obtain(r110.f449584id).optString(DownloadSettingKeys.SETTING_TAG));     // Catch: JSONException -> L127
        r101.put("download_id", r110.f449584id);     // Catch: JSONException -> L127
        r101.put("name", r110.name);     // Catch: JSONException -> L127
        r101.put("url", r110.url);     // Catch: JSONException -> L127
        r101.put("save_path", r110.savePath);     // Catch: JSONException -> L127
        r101.put("download_time", r110.downloadTime);     // Catch: JSONException -> L127
        r101.put("cur_bytes", r110.curBytes);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_BACKGROUND_DOWNLOAD_BYTES, r110.backCurBytes);     // Catch: JSONException -> L127
        r101.put("total_bytes", r110.totalBytes);     // Catch: JSONException -> L127
        r101.put("network_quality", r110.networkQuality);     // Catch: JSONException -> L127
        int r109 = 1;
        if (r110.onlyWifi == false) goto L12;
        int r111 = 1;
    L13:
        r101.put("only_wifi", r111);     // Catch: JSONException -> L127
        if (r110.needHttpsToHttpRetry == false) goto L16;
        int r112 = 1;
    L17:
        r101.put("need_https_degrade", r112);     // Catch: JSONException -> L127
        if (r110.httpsToHttpRetryUsed == false) goto L20;
        int r113 = 1;
    L21:
        r101.put("https_degrade_retry_used", r113);     // Catch: JSONException -> L127
        String r114 = r110.f449585md5;     // Catch: JSONException -> L127
        if (r114 != null) goto L24;
        r114 = "";
    L24:
        r101.put("md5", r114);     // Catch: JSONException -> L127
        if (r110.force == false) goto L27;
        int r115 = 1;
    L28:
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, r115);     // Catch: JSONException -> L127
        r101.put("retry_count", r110.retryCount);     // Catch: JSONException -> L127
        if (r110.needDefaultHttpServiceBackUp == false) goto L31;
        int r116 = 1;
    L32:
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_DEFAULT_HTTP_SERVICE_BACKUP, r116);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_BYTE_ERROR_RETRY_STATUS, r110.byteInvalidRetryStatus.ordinal());     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_HANDLER_STATUS, r110.asyncHandleStatus.ordinal());     // Catch: JSONException -> L127
        if (r110.needIndependentProcess == false) goto L35;
        int r117 = 1;
    L36:
        r101.put("need_independent_process", r117);     // Catch: JSONException -> L127
        String r118 = r110.extra;     // Catch: JSONException -> L127
        if (r118 != null) goto L40;
        r118 = "";
    L40:
        r101.put("extra", r118);     // Catch: JSONException -> L127
        if (r110.addListenerToSameTask == false) goto L43;
        int r119 = 1;
    L44:
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_ADD_LISTENER_TO_SAME_TASK, r119);     // Catch: JSONException -> L127
        List<String> r120 = r110.backUpUrls;     // Catch: JSONException -> L127
        if (r120 == null) goto L47;
        int r121 = r120.size();     // Catch: JSONException -> L127
    L48:
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, r121);     // Catch: JSONException -> L127
        List<String> r122 = r110.backUpUrls;     // Catch: JSONException -> L127
        if (r122 == null) goto L51;
        String r123 = r122.toString();     // Catch: JSONException -> L127
    L52:
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL, r123);     // Catch: JSONException -> L127
        if (r110.backUpUrls == null) goto L55;
        int r124 = r110.curBackUpUrlIndex;     // Catch: JSONException -> L127
    L56:
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, r124);     // Catch: JSONException -> L127
        List<String> r125 = r110.forbiddenBackupUrls;     // Catch: JSONException -> L127
        if (r125 == null) goto L59;
        String r126 = r125.toString();     // Catch: JSONException -> L127
    L60:
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_URLS, r126);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_NETWORK_RETRY_COUNT, r110.curNetworkRetryCount);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_CACHE_EXISTS_IN_DOWNLOADING, r110.isCacheExistsInDownloading);     // Catch: JSONException -> L127
        r101.put("content_type", r110.mimeType);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_CONTENT_ENCODING, r110.contentEncoding);     // Catch: JSONException -> L127
        if (r110.fastDownload == false) goto L63;
        int r127 = 1;
    L64:
        r101.put("fast_download", r127);     // Catch: JSONException -> L127
        String r128 = r110.requestLog;     // Catch: JSONException -> L127
        if (r128 != null) goto L67;
        r128 = "";
    L67:
        r101.put("request_log", r128);     // Catch: JSONException -> L127
        String r129 = r110.httpRequestHeader;     // Catch: JSONException -> L127
        if (r129 != null) goto L70;
        r129 = "";
    L70:
        r101.put(MonitorConstants.REQUEST_HEADER, r129);     // Catch: JSONException -> L127
        String r130 = r110.httpResponseHeader;     // Catch: JSONException -> L127
        if (r130 != null) goto L73;
        r130 = "";
    L73:
        r101.put(MonitorConstants.RESPONSE_HEADER, r130);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.ENQUEUE_TYPE, r110.enqueueType);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_TASK_SLEEP_TIME, r110.sleepTime);     // Catch: JSONException -> L127
        String r131 = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());     // Catch: JSONException -> L127
        if (r131 != null) goto L76;
        r131 = "";
    L76:
        r101.put("process_name", r131);     // Catch: JSONException -> L127
        String r132 = r110.callStack;     // Catch: JSONException -> L127
        if (r132 != null) goto L79;
        r132 = "";
    L79:
        r101.put(MonitorConstants.CALL_STACK, r132);     // Catch: JSONException -> L127
        JSONObject r133 = r110.pcdnStats;     // Catch: JSONException -> L127
        if (r133 == null) goto L82;
        r101.put(MonitorConstants.EXTRA_PCDN_LOG, r133);     // Catch: JSONException -> L127
    L82:
        DownloadTimingInfo r134 = r110.downloadTimingInfo;     // Catch: JSONException -> L127
        if (r134 == null) goto L85;
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_ORIGIN_TIMING_INFO, r134.obtainOriginStats());     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_TIMING_INFO, r110.downloadTimingInfo.obtainDurationStats());     // Catch: JSONException -> L127
    L85:
        DownloadThreadInfo r135 = r110.downloadThreadInfo;     // Catch: JSONException -> L127
        if (r135 == null) goto L88;
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_THREAD_INFO, r135.obtainStats());     // Catch: JSONException -> L127
    L88:
        int r136 = r110.monitorStatus;     // Catch: JSONException -> L127
        if (r136 != (-3)) goto L91;
    L95:
        r101.put("all_connect_time", r110.allConnectTime);     // Catch: JSONException -> L127
        r101.put("first_speed_time", r110.firstSpeedTime);     // Catch: JSONException -> L127
        r101.put("real_download_time", r110.realDownloadTime);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_BACKGROUND_DOWNLOAD_TIME, r110.realBackDownloadTime);     // Catch: JSONException -> L127
        if (r110.backUpUrlUsed == true) goto L99;
        r109 = 0;
    L99:
        r101.put("backup_url_used", r109);     // Catch: JSONException -> L127
        r101.put("cur_retry_time", r110.curRetryTime);     // Catch: JSONException -> L127
        r101.put("cur_retry_time_in_total", r110.curRetryTimeInTotal);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_DOWNLOAD_MD5_TIME, r110.md5Time);     // Catch: JSONException -> L127
        r101.put(MonitorConstants.EXTRA_DEVICE_AVAILABLE_SPACE, ((DownloadUtils.getAvailableSpaceBytes(r110.savePath) / 1024) / 1024) / 100);     // Catch: Throwable -> L102
    L134:
    L117:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L127
    L119:
        BaseException r137 = r110.exception;     // Catch: JSONException -> L127
        if (r137 == null) goto L122;
        r103 = r137.getErrorCode();     // Catch: JSONException -> L127
    L122:
        r101.put("error_code", r103);     // Catch: JSONException -> L127
        BaseException r138 = r110.exception;     // Catch: JSONException -> L127
        if (r138 == null) goto L125;
        r104 = r138.getErrorMessage();     // Catch: JSONException -> L127
    L125:
        r101.put("error_msg", r104);     // Catch: JSONException -> L127
        return r101;
    L105:
        if (TextUtils.isEmpty(r110.url) == true) goto L114;
        Uri r139 = UriProtector.parse(r110.url);     // Catch: Throwable -> L117
        String r140 = r139.getHost();     // Catch: Throwable -> L117
        String r141 = r139.getPath();     // Catch: Throwable -> L117
        String r142 = r139.getLastPathSegment();     // Catch: Throwable -> L117
        if (TextUtils.isEmpty(r141) == false) goto L109;
    L115:
        r101.put(MonitorConstants.URL_HOST, r140);     // Catch: Throwable -> L117
        r101.put("url_path", r141);     // Catch: Throwable -> L117
        r101.put(MonitorConstants.URL_LAST_PATH_SEGMENT, r142);     // Catch: Throwable -> L117
    L109:
        if (TextUtils.isEmpty(r142) == true) goto L115;
        r141 = r141.substring(0, r141.length() - r142.length());     // Catch: Throwable -> L112
    L112:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L117
        goto L115
    L114:
        r142 = "";
        r140 = r142;
        r141 = r140;
        goto L115
    L102:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L127
        goto L134
    L91:
        if (r136 == (-4)) goto L95;
        if (r136 == (-1)) goto L95;
        if (r136 != (-2)) goto L134;
    L63:
        r127 = 0;
        goto L64
    L59:
        r126 = "";
        goto L60
    L55:
        r124 = -1;
        goto L56
    L51:
        r123 = "";
        goto L52
    L47:
        r121 = 0;
        goto L48
    L43:
        r119 = 0;
        goto L44
    L35:
        r117 = 0;
        goto L36
    L31:
        r116 = 0;
        goto L32
    L27:
        r115 = 0;
        goto L28
    L20:
        r113 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r111 = 0;
        goto L13
    L8:
        r105 = "";
        r106 = r105;
        r107 = r106;
        r108 = 0;
    L127:
        e = e;
        r100 = r101;
    L130:
        monitorDownloadOtherError(e);
        e.printStackTrace();
        return r100;
    L129:
        e = e;
        goto L130
    }

    public static /* synthetic */ void access$200(DownloadMonitorInfo r100, JSONObject r101) throws JSONException {
        putMonitorJsonStatus(r100, r101);
    }

    private static boolean isMonitorStatus(int[] r100, int r101) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (r100.length <= 0) goto L14;
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L14;
        if (r101 == r100[r102]) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        return true;
    }

    public static void monitorDBOptAnr(Throwable r100, int r101) {
        IDownloadMonitorListener r102 = DownloadComponentManager.getDownloadMonitorListener();
        if (r102 != null) goto L23;
        return;
    L23:
        StackTraceElement[] r103 = r100.getStackTrace();     // Catch: Throwable -> L20
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.length <= 0) goto L26;
        StringBuffer r104 = new StringBuffer();     // Catch: Throwable -> L20
        if (r101 < r103.length) goto L14;
        r101 = r103.length;     // Catch: Throwable -> L20
    L14:
        int r105 = 0;
    L15:
        if (r105 >= r101) goto L17;
        r104.append(r103[r105]);     // Catch: Throwable -> L20
        r105 = r105 + 1;     // Catch: Throwable -> L20
        goto L15
    L17:
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L20
        r106.put("info_type", MonitorConstants.InfoType.DB_OPT_ANR);     // Catch: Throwable -> L20
        r106.put(MonitorConstants.DB_OPT_ERROR_STACK, r104.toString());     // Catch: Throwable -> L20
        r102.monitorEvent(MonitorConstants.DOWNLOAD_OTHER_INFO, r106, null, null);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorSegmentsError(DownloadInfo r100, List<Segment> r101) {
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L6
        r102.put(DBDefinition.SEGMENT_TABLE_NAME, Segment.toString(r101));     // Catch: Throwable -> L6
        r102.put("cur_bytes", r100.getCurBytes());     // Catch: Throwable -> L6
        r102.put("total_bytes", r100.getTotalBytes());     // Catch: Throwable -> L6
        InnerEventListener r103 = DownloadComponentManager.getEventListener();     // Catch: Throwable -> L6
        if (r103 == null) goto L11;
        r103.onEvent(r100.getId(), "segments_error", r102);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private static void putMonitorJsonStatus(DownloadMonitorInfo r100, JSONObject r101) throws JSONException {
        int r102 = r100.monitorStatus;
        if (r102 != (-5)) goto L5;
        String r103 = "download_uncomplete";
    L26:
        r101.put("status", r103);
        return;
    L5:
        if (r102 != (-4)) goto L7;
        r103 = "download_cancel";
        goto L26
    L7:
        if (r102 != (-3)) goto L9;
        double r104 = r100.downloadSpeed;
        if (r104 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L23;
        r101.put("download_speed", r104);
    L23:
        r101.put(MonitorConstants.THROTTLE_SPEED, r100.throttleNetSpeed);
        r103 = "download_success";
        goto L26
    L9:
        if (r102 == (-2)) goto L19;
        if (r102 != 0) goto L12;
        r103 = "download_create";
        goto L26
    L12:
        if (r102 != 2) goto L14;
        r103 = "download_start";
        goto L26
    L14:
        if (r102 == 6) goto L16;
        r103 = "";
        goto L26
    L16:
        r103 = "download_first_start";
        goto L26
    L19:
        r103 = "download_pause";
        goto L26
    }

    public static void monitorDownloadApp(DownloadInfo r100, String r101, int r102) {
        IDownloadMonitorListener r103 = DownloadComponentManager.getDownloadMonitorListener();
        if (r103 != null) goto L10;
        return;
    L10:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L7
        r104.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r100.getMonitorScene());     // Catch: Throwable -> L7
        r104.put("url", r100.getUrl());     // Catch: Throwable -> L7
        r104.put("total_bytes", r100.getTotalBytes());     // Catch: Throwable -> L7
        r104.put("cur_bytes", r100.getCurBytes());     // Catch: Throwable -> L7
        r104.put("save_path", r100.getSavePath());     // Catch: Throwable -> L7
        r104.put(MonitorConstants.APP_INSTALL_STATUS, r101);     // Catch: Throwable -> L7
        r104.put(MonitorConstants.APP_INSTALL_RESULT_CODE, r102);     // Catch: Throwable -> L7
        r103.monitorEvent(MonitorConstants.DOWNLOAD_INSTALL_APP, r104, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorSend(DownloadTask r100, BaseException r101, int r102) {
        if (r100 != null) goto L27;
        return;
    L27:
        DownloadInfo r103 = r100.getDownloadInfo();     // Catch: Throwable -> L24
        if (r103 != null) goto L7;
        return;
    L7:
        IDownloadMonitorDepend r104 = r100.getMonitorDepend();     // Catch: Throwable -> L24
        boolean r105 = DownloadStatus.isMonitorStatus(r102);     // Catch: Throwable -> L24
        if (r105 == true) goto L15;
        r105 = isMonitorStatus(r103.getExtraMonitorStatus(), r102);     // Catch: Throwable -> L24
        if (r105 == true) goto L15;
        if (r104 == null) goto L15;
        if ((r104 instanceof AbsDownloadMonitorDepend) == false) goto L15;
        r105 = isMonitorStatus(((AbsDownloadMonitorDepend) r104).getAdditionalMonitorStatus(), r102);     // Catch: Throwable -> L24
    L15:
        if (r105 == false) goto L31;
        IDownloadDepend r106 = r100.getDepend();     // Catch: Throwable -> L20
        if (r106 == null) goto L22;
        r106.monitorLogSend(r103, r101, r102);     // Catch: Throwable -> L20
    L22:
        monitorSendWithTaskMonitor(r104, r103, r101, r102);     // Catch: Throwable -> L24
        monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), r100, r103, r101, r102);     // Catch: Throwable -> L24
        return;
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
        goto L22
    L31:
        return;
    L24:
        th = move-exception;
        monitorDownloadOtherError(th);
        th.printStackTrace();
    }

    public static void monitorDownloadCDN(String r100, IDownloadHttpConnection r101, Throwable r102, IDownloadCdnListener r103) {
        if (r103 == null) goto L44;
        if (r100 == null) goto L46;
        DownloadCdnStats r104 = new DownloadCdnStats();
        boolean r105 = false;
        boolean r106 = true;
        if (r101 != null) goto L8;
    L18:
        if (r102 != null) goto L20;
        r106 = r105;
    L33:
        if (r106 == false) goto L45;
        r104.host = UriProtector.parse(r100).getHost();     // Catch: Throwable -> L37
    L35:
        r103.onCollectStats(r104);
        return;
    L45:
        return;
    L20:
        if (r104.responseCode > 0) goto L42;
        r104.responseCode = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getTTNetHandler().getResponseCode(r102);
    L42:
        DownloadHelper.parseException(r102, "monitor_cdn");     // Catch: BaseException -> L24 DownloadTTNetException -> L26
    L31:
        r104.errorMsg = r102.toString();
        goto L33
    L26:
        e = move-exception;
        if (r104.f449578ip != null) goto L30;
        r104.f449578ip = e.getRemoteIp();
    L30:
        r104.errorCode = e.getErrorCode();
    L24:
        e = move-exception;
        r104.errorCode = e.getErrorCode();
        goto L31
    L8:
        if ((r101 instanceof AbsDownloadHttpConnection) == false) goto L18;
        AbsDownloadHttpConnection r107 = (AbsDownloadHttpConnection) r101;
    L15:
        th = move-exception;
        th.printStackTrace();
    L17:
        r105 = true;
        goto L18
    L11:
        if (r107.isOkhttp() == true) goto L13;
        r105 = true;
    L13:
        r104.isTTNet = r105;     // Catch: Throwable -> L15
        r104.responseCode = r107.getResponseCode();     // Catch: Throwable -> L15
        r104.f449578ip = r107.getHostIp();     // Catch: Throwable -> L15
        r104.cacheHit = DownloadHelper.isCdnCacheHit(r107.getResponseHeaders());     // Catch: Throwable -> L15
        goto L17
    L46:
        return;
    }

    public static void monitorSendWithTaskMonitor(final IDownloadMonitorDepend r100, DownloadInfo r101, BaseException r102, int r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r104 = r100.getEventPage();
        if (TextUtils.isEmpty(r104) == false) goto L7;
        r104 = "default";
    L7:
        final DownloadMonitorInfo r105 = translateDownloadMonitorInfo(r104, r101, null, r102, r103);
        DownloadComponentManager.submitCPUTask(new AnonymousClass1(r105, r100));
    }

    public static void monitorSendWithGlobalSdkMonitor(final IDownloadMonitorListener r100, DownloadTask r101, DownloadInfo r102, BaseException r103, int r104) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r102.isNeedSDKMonitor() == false) goto L9;
        final DownloadMonitorInfo r105 = translateDownloadMonitorInfo(r102.getMonitorScene(), r102, r101, r103, r104);
        DownloadComponentManager.submitCPUTask(new AnonymousClass2(r105, r100));
        return;
    }

    private static DownloadMonitorInfo translateDownloadMonitorInfo(String r100, DownloadInfo r101, DownloadTask r102, BaseException r103, int r104) {
        DownloadMonitorInfo r105 = new DownloadMonitorInfo(null);
        r105.monitorStatus = r104;
        r105.exception = r103;
        r105.eventPage = r100;
        if (r101 == null) goto L15;
        r105.f449584id = r101.getId();
        r105.name = r101.getName();
        r105.url = r101.getUrl();
        r105.savePath = r101.getSavePath();
        r105.downloadTime = r101.getDownloadTime();
        r105.curBytes = r101.getCurBytes();
        r105.backCurBytes = r101.getBackCurBytes();
        r105.totalBytes = r101.getTotalBytes();
        r105.networkQuality = r101.getNetworkQuality();
        r105.onlyWifi = r101.isOnlyWifi();
        r105.needHttpsToHttpRetry = r101.isNeedHttpsToHttpRetry();
        r105.httpsToHttpRetryUsed = r101.isHttpsToHttpRetryUsed();
        r105.f449585md5 = r101.getMd5();
        r105.force = r101.isForce();
        r105.retryCount = r101.getRetryCount();
        r105.needDefaultHttpServiceBackUp = r101.isNeedDefaultHttpServiceBackUp();
        r105.byteInvalidRetryStatus = r101.getByteInvalidRetryStatus();
        r105.asyncHandleStatus = r101.getAsyncHandleStatus();
        r105.needIndependentProcess = r101.isNeedIndependentProcess();
        r105.extra = r101.getExtra();
        r105.addListenerToSameTask = r101.isAddListenerToSameTask();
        r105.backUpUrls = r101.getBackUpUrls();
        r105.curBackUpUrlIndex = r101.getCurBackUpUrlIndex();
        r105.forbiddenBackupUrls = r101.getForbiddenBackupUrls();
        r105.curNetworkRetryCount = r101.getCurNetworkRetryCount();
        r105.isCacheExistsInDownloading = r101.isCacheExistsInDownloading();
        r105.mimeType = r101.getMimeType();
        r105.contentEncoding = r101.getContentEncoding();
        r105.fastDownload = r101.isFastDownload();
        r105.pcdnStats = r101.getPcdnStats();
        r105.throttleNetSpeed = r101.getThrottleNetSpeed();
        r105.httpRequestHeader = r101.getHttpRequestHeader();
        r105.httpResponseHeader = r101.getHttpResponseHeader();
        r105.requestLog = r101.getRequestLog();
        r105.enqueueType = r101.getEnqueueType().ordinal();
        r105.sleepTime = r101.getTaskSleepTime();
        r105.callStack = r101.getCallStack();
        if (r104 != (-3)) goto L7;
    L12:
        r105.allConnectTime = r101.getAllConnectTime();
        r105.firstSpeedTime = r101.getFirstSpeedTime();
        r105.realDownloadTime = r101.getRealDownloadTime();
        r105.realBackDownloadTime = r101.getRealBackDownloadTime();
        r105.backUpUrlUsed = r101.isBackUpUrlUsed();
        r105.curRetryTime = r101.getCurRetryTime();
        r105.curRetryTimeInTotal = r101.getCurRetryTimeInTotal();
        r105.md5Time = r101.getMd5Time();
    L13:
        if (r104 != (-3)) goto L15;
        r105.downloadSpeed = r101.getDownloadSpeed();
        goto L15
    L7:
        if (r104 == (-4)) goto L12;
        if (r104 == (-1)) goto L12;
        if (r104 != (-2)) goto L13;
    L15:
        if (r102 == null) goto L17;
        r105.downloadTimingInfo = r102.getTimingInfo().copy();
        r105.downloadThreadInfo = r102.getThreadInfo().copy();
    L17:
        return r105;
    }

    public static void monitorDownloadConnect(IDownloadHeadHttpConnection r110, String r111, String r112, long r113, String r114, int r115, IOException r210, DownloadInfo r211) {
        if (r211 != null) goto L5;
        return;
    L5:
        DownloadSetting r100 = DownloadSetting.obtain(r211.getId());
        int r101 = r100.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT, 0);
        if (r101 > 0) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r111) == false) goto L11;
        return;
    L11:
        int r102 = -1;
        if (r110 != null) goto L76;
    L21:
        String r103 = null;
    L23:
        if (r102 < 200) goto L26;
        if (r102 >= 400) goto L26;
    L41:
        String r104 = null;
    L42:
        Uri r105 = UriProtector.parse(r111);     // Catch: Throwable -> L66
        String r106 = r105.getHost();     // Catch: Throwable -> L66
        String r116 = r105.getPath();     // Catch: Throwable -> L66
        String r107 = r105.getLastPathSegment();     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r116) == false) goto L45;
    L47:
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L66
        r108.put(DownloadSettingKeys.SETTING_TAG, r100.optString(DownloadSettingKeys.SETTING_TAG));     // Catch: JSONException -> L53 Throwable -> L66
        r108.put(MonitorConstants.URL_HOST, r106);     // Catch: JSONException -> L53 Throwable -> L66
        r108.putOpt("host_ip", r112);     // Catch: JSONException -> L53 Throwable -> L66
        r108.putOpt(MonitorConstants.HOST_REAL_IP, r103);     // Catch: JSONException -> L53 Throwable -> L66
        r108.put("url_path", r116);     // Catch: JSONException -> L53 Throwable -> L66
        r108.put(MonitorConstants.URL_LAST_PATH_SEGMENT, r107);     // Catch: JSONException -> L53 Throwable -> L66
        r108.put(MonitorConstants.NET_LIB, r115);     // Catch: JSONException -> L53 Throwable -> L66
        r108.put(MonitorConstants.CONNECT_TYPE, r114);     // Catch: JSONException -> L53 Throwable -> L66
        r108.put("status_code", r102);     // Catch: JSONException -> L53 Throwable -> L66
        if (r104 == null) goto L51;
        r108.put("error_msg", DownloadHelper.getFixLengthString(r104, r100.optInt("exception_msg_length", 500)));     // Catch: JSONException -> L53 Throwable -> L66
    L51:
        r108.put(MonitorConstants.CONNECT_TIME, r113);     // Catch: JSONException -> L53 Throwable -> L66
        r108.put("pkg_name", r211.getPackageName());     // Catch: JSONException -> L53 Throwable -> L66
        r108.put("name", r211.getTitle());     // Catch: JSONException -> L53 Throwable -> L66
    L56:
        if (r101 == 1) goto L58;
        if (r101 == 3) goto L58;
    L62:
        if (r101 == 2) goto L64;
        if (r101 == 3) goto L64;
        return;
    L64:
        DownloadComponentManager.getEventListener().onEvent(r211.getId(), MonitorConstants.DOWNLOAD_CONNECT, r108);     // Catch: Throwable -> L66
        return;
    L58:
        IDownloadMonitorListener r109 = DownloadComponentManager.getDownloadMonitorListener();     // Catch: Throwable -> L66
        if (r109 == null) goto L62;
        r109.monitorEvent(MonitorConstants.DOWNLOAD_CONNECT, r108, null, null);     // Catch: Throwable -> L66
    L53:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L56
    L45:
        if (TextUtils.isEmpty(r107) == true) goto L47;
        r116 = r116.substring(0, r116.length() - r107.length());     // Catch: Throwable -> L69
    L26:
        if (r211.getCurRetryTime() == 0) goto L31;
        int r117 = r211.getHttpStatusCode();     // Catch: Throwable -> L66
        if (r117 < 200) goto L30;
        if (r117 < 400) goto L31;
        return;
    L30:
        return;
    L31:
        if (r210 == null) goto L41;
        if (DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) == false) goto L35;
    L78:
        DownloadHelper.parseException(r210, "");     // Catch: BaseException -> L39 Throwable -> L66
    L39:
        e = move-exception;
        r102 = e.getErrorCode();     // Catch: Throwable -> L66
        r104 = e.getErrorMessage();     // Catch: Throwable -> L66
        goto L42
    L35:
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK) == true) goto L78;
        r102 = 1049;
        goto L41
    L76:
        r102 = r110.getResponseCode();     // Catch: Throwable -> L15
    L19:
        if ((r110 instanceof AbsDownloadHttpConnection) == false) goto L21;
        r103 = ((AbsDownloadHttpConnection) r110).getHostIp();     // Catch: Throwable -> L66
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorSegmentIO(DownloadSetting r210, DownloadInfo r211, String r212, String r213, String r214, boolean r215, IDownloadHttpConnection r216, BaseException r310, long r311, long r312) {
        monitorIO(MonitorConstants.SEGMENT_IO, r210.optInt(DownloadSettingKeys.MONITOR_SEGMENT_IO), r210, r211, r212, r213, r214, r216, r215, false, r310, r311, r312, false, -1, -1, -1, null);
    }

    public static void monitorDownloadIO(DownloadSetting r210, DownloadInfo r211, String r212, IDownloadHttpConnection r213, boolean r214, boolean r215, BaseException r216, long r310, long r311, boolean r312, long r313, long r314, long r315, JSONObject r410) {
        monitorIO(MonitorConstants.DOWNLOAD_IO, r210.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_IO), r210, r211, r212, null, null, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.ss.android.socialbase.downloader.monitor.InnerEventListener] */
    /* JADX WARN: Type inference failed for: r11v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener] */
    private static void monitorIO(String r110, int r210, DownloadSetting r211, DownloadInfo r212, String r213, String r214, String r215, IDownloadHttpConnection r216, boolean r217, boolean r218, BaseException r219, long r310, long r311, boolean r312, long r313, long r314, long r315, JSONObject r410) {
        if (r210 > 0) goto L5;
        return;
    L5:
        if (r311 <= 0) goto L80;
        Uri r100 = UriProtector.parse(r213);     // Catch: Throwable -> L71
        String r101 = r100.getHost();     // Catch: Throwable -> L71
        String r102 = r100.getPath();     // Catch: Throwable -> L71
        String r103 = r100.getLastPathSegment();     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r102) == false) goto L10;
    L14:
        if (r217 == false) goto L17;
        int r111 = 1;
    L16:
        String r112 = null;
    L28:
        ?? r113 = new JSONObject();     // Catch: Throwable -> L71
        String r114 = "";
        ?? r115 = -1;
        if (r216 != null) goto L31;
        String r104 = "";
        int r116 = -1;
        ?? r117 = -1;
    L49:
        double r105 = r310 / 1048576.0d;     // Catch: Throwable -> L71
        double r106 = r311;
        double r107 = r106 / TimeUnit.SECONDS.toNanos(1);     // Catch: Throwable -> L71
        r113.put(DownloadSettingKeys.SETTING_TAG, r211.optString(DownloadSettingKeys.SETTING_TAG));     // Catch: Throwable -> L71
        r113.put(MonitorConstants.URL_HOST, r101);     // Catch: Throwable -> L71
        r113.putOpt("host_ip", r214);     // Catch: Throwable -> L71
        r113.putOpt(MonitorConstants.HOST_REAL_IP, r215);     // Catch: Throwable -> L71
        r113.put("url_path", r102);     // Catch: Throwable -> L71
        r113.put(MonitorConstants.URL_LAST_PATH_SEGMENT, r103);     // Catch: Throwable -> L71
        r113.put(MonitorConstants.NET_LIB, r116);     // Catch: Throwable -> L71
        r113.put("hit_cdn_cache", r117);     // Catch: Throwable -> L71
        r113.put("status_code", r111);     // Catch: Throwable -> L71
        r113.put("request_log", r104);     // Catch: Throwable -> L71
        if (r112 == null) goto L52;
        r113.put("error_msg", DownloadHelper.getFixLengthString(r112, r211.optInt("exception_msg_length", 500)));     // Catch: Throwable -> L71
    L52:
        r113.put(MonitorConstants.DOWNLOAD_SEC, r107);     // Catch: Throwable -> L71
        r113.put(MonitorConstants.DOWNLOAD_MB, r105);     // Catch: Throwable -> L71
        if (r107 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L55;
        r113.put("download_speed", r105 / r107);     // Catch: Throwable -> L71
    L55:
        if (r312 == false) goto L57;
        r113.put(MonitorConstants.RW_READ_TIME, r313 / r106);     // Catch: Throwable -> L71
        r113.put(MonitorConstants.RW_WRITE_TIME, r314 / r106);     // Catch: Throwable -> L71
        r113.put(MonitorConstants.RW_SYNC_TIME, r315 / r106);     // Catch: Throwable -> L71
    L57:
        r113.put("pkg_name", r212.getPackageName());     // Catch: Throwable -> L71
        r113.put("name", r212.getTitle());     // Catch: Throwable -> L71
        if (r210 == 1) goto L62;
        if (r210 == 3) goto L62;
        int r108 = 2;
        String r109 = r110;
    L67:
        if (r210 == r108) goto L69;
        if (r210 == 3) goto L69;
        return;
    L69:
        DownloadComponentManager.getEventListener().onEvent(r212.getId(), r109, r113);     // Catch: Throwable -> L71
        return;
    L62:
        ?? r118 = DownloadComponentManager.getDownloadMonitorListener();     // Catch: Throwable -> L71
        if (r118 == 0) goto L65;
        r109 = r110;
        r118.monitorEvent(r109, r113, null, null);     // Catch: Throwable -> L71
    L66:
        r108 = 2;
        goto L67
    L65:
        r109 = r110;
        goto L66
    L31:
        if ((r216 instanceof IDefaultDownloadHttpConnection) == false) goto L33;
        r116 = 0;
    L34:
        String r119 = r216.getResponseHeaderField(DownloadHelper.X_CACHE);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r119) == true) goto L38;
        r115 = r119.toLowerCase().contains(BaseHttpRequestInfo.KEY_HIT);     // Catch: Throwable -> L71
    L38:
        if (r211.optInt(DownloadSettingKeys.MONITOR_SLA, 1) != 1) goto L45;
        if (r217 == true) goto L45;
        if (r218 == true) goto L45;
        if ((r216 instanceof AbsDownloadHttpConnection) == false) goto L45;
        ((AbsDownloadHttpConnection) r216).monitorNetworkInfo(r113, true);     // Catch: Throwable -> L71
    L45:
        if ((r216 instanceof AbsDownloadHttpConnection) == false) goto L47;
        r114 = ((AbsDownloadHttpConnection) r216).getRequestLog();     // Catch: Throwable -> L71
    L47:
        r104 = r114;
        r117 = r115;
        goto L49
    L33:
        r116 = 1;
        goto L34
    L17:
        if (r218 == false) goto L19;
        r111 = 2;
        goto L16
    L19:
        if (r219 != null) goto L21;
        r111 = 0;
        goto L16
    L21:
        if (DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) == false) goto L23;
    L25:
        r111 = r219.getErrorCode();     // Catch: Throwable -> L71
    L26:
        r112 = r219.getErrorMessage();     // Catch: Throwable -> L71
        goto L28
    L23:
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK) == true) goto L25;
        r111 = 1049;
        goto L26
    L10:
        if (TextUtils.isEmpty(r103) == true) goto L14;
        r102 = r102.substring(0, r102.length() - r103.length());     // Catch: Throwable -> L13
    L71:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
