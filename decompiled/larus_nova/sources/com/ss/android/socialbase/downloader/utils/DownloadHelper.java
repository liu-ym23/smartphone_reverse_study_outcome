package com.ss.android.socialbase.downloader.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.BuildConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadInnerConstants;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadHelper {
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    private static final String DEFAULT_SECURITY_VALUE = "StaticResource/file/Downloader";
    public static final String ETAG = "Etag";
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final String GZIP = "gzip";
    public static final String IDENTITY = "identity";
    public static final String IF_MATCH = "If-Match";
    public static final String IF_MODIFIED_SINCE = "if-modified-since";
    public static final String IF_NONE_MATCH = "If-None-Match";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String LAST_MODIFIED_CASE = "Last-Modified";
    private static final long ONE_KB = 1024;
    private static final long ONE_MB = 1048576;
    private static final String SECURITY_ARGUS_KEY = "x-security-argus";
    private static final String TAG = null;
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String TTNET_PROTO_TYPE = "x-ttnet-http-proto-type";
    public static final String VALUE_CHUNKED = "chunked";
    public static final String X_CACHE = "X-Cache";
    public static final String X_CONTENT_LENGTH = "X-Content-Length";
    private static volatile boolean mSleepDownloadingTask;
    private static volatile String sAid;
    private static volatile String sChannel;
    private static volatile String sFullSecurityValue;
    private static Boolean sIsDownloaderProcess;
    private static Boolean sIsMainProcess;
    private static volatile SparseArray<List<ITempFileSaveCompleteCallback>> saveTempFileListeners;
    private static volatile SparseArray<Boolean> saveTempFileStatusMap;

    /* JADX INFO: loaded from: classes38.dex */
    public static class SceneLruLimitInfo {
        public int curCount;
        public int limit;

        public SceneLruLimitInfo(int r100, int r101) {
            this.curCount = r100;
            this.limit = r101;
        }
    }

    public DownloadHelper() {
    }

    public static int convertToBytes(double r100) {
        return (int) ((r100 * 1000.0d) / 8.0d);
    }

    public static boolean isResponseDataFromBegin(int r100) {
        if (r100 != 200) goto L5;
    L9:
        return true;
    L5:
        if (r100 == 201) goto L9;
        if (r100 == 0) goto L9;
        return false;
    }

    static {
        TAG = "DownloadHelper";
        saveTempFileStatusMap = new SparseArray();
        saveTempFileListeners = new SparseArray();
        mSleepDownloadingTask = false;
    }

    private static String getSecurityValue() {
        if (sFullSecurityValue == null) goto L7;
        return sFullSecurityValue;
    L7:
        if (TextUtils.isEmpty(sAid) == false) goto L9;
        return DEFAULT_SECURITY_VALUE;
    L9:
        if (TextUtils.isEmpty(sChannel) == true) goto L14;
        sFullSecurityValue = "StaticResource/file/Downloader aid/" + sAid + HTTP.URL_DEFAULT + sChannel + "/Android";
        return sFullSecurityValue;
    L14:
        return DEFAULT_SECURITY_VALUE;
    }

    public static boolean isDownloaderProcess() {
        Boolean r100 = sIsDownloaderProcess;
        if (r100 == null) goto L7;
        return r100.booleanValue();
    L7:
        if (DownloadComponentManager.getAppContext() != null) goto L10;
        return false;
    L10:
        String r101 = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());
        if (r101 != null) goto L13;
    L15:
        sIsDownloaderProcess = Boolean.FALSE;
    L17:
        return sIsDownloaderProcess.booleanValue();
    L13:
        if (r101.equals(DownloadComponentManager.getAppContext().getPackageName() + ":downloader") == false) goto L15;
        sIsDownloaderProcess = Boolean.TRUE;
        goto L17
    }

    public static boolean isMainProcess() {
        Boolean r100 = sIsMainProcess;
        if (r100 == null) goto L7;
        return r100.booleanValue();
    L7:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FORCE_INDEPENDENT_PROCESS) <= 0) goto L11;
        Boolean r101 = Boolean.FALSE;
        sIsMainProcess = r101;
        return r101.booleanValue();
    L11:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FORCE_MAIN_PROCESS) <= 0) goto L14;
        Boolean r102 = Boolean.TRUE;
        sIsMainProcess = r102;
        return r102.booleanValue();
    L14:
        boolean r103 = true;
        if (DownloadComponentManager.getAppContext() != null) goto L17;
        return true;
    L17:
        String r104 = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());
        if (r104 != null) goto L20;
    L22:
        if (r104 != null) goto L24;
    L26:
        r103 = false;
    L27:
        sIsMainProcess = Boolean.valueOf(r103);
    L29:
        return sIsMainProcess.booleanValue();
    L24:
        if (r104.equals(DownloadComponentManager.getAppContext().getPackageName()) == false) goto L26;
    L20:
        if (r104.contains(":") == false) goto L22;
        sIsMainProcess = Boolean.FALSE;
        goto L29
    }

    public static Map<String, SceneLruLimitInfo> getDbInitSceneLruLimitMap() {
        Set<String> r100 = parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.LRU_DB_INIT_MONITOR_SCENE_LIMIT_LIST));
        if (r100 != null) goto L5;
    L30:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L30;
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.iterator();     // Catch: Throwable -> L24
    L10:
        if (r102.hasNext() == false) goto L27;
        String[] r103 = r102.next().split(":");     // Catch: Throwable -> L24
        if (r103 == null) goto L10;
        if (r103.length <= 0) goto L10;
        String r104 = r103[0];     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r104) == true) goto L10;
        int r105 = CastIntegerProtector.parseInt(r103[1]);     // Catch: Throwable -> L24
        if (r105 <= 0) goto L10;
        r101.put(r104, new SceneLruLimitInfo(0, r105));     // Catch: Throwable -> L24
    L27:
        if (r101.isEmpty() == false) goto L29;
        return null;
    L29:
        return r101;
    L24:
        th = move-exception;
        Logger.globalError(TAG, "getDbInitSceneLruLimitSet", "Error" + th);
        goto L27
    }

    public static Set<String> getDbInitSceneSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.DB_INIT_MONITOR_SCENE_LIST));
    }

    public static Set<String> getSkipDbInitExpectMimeTypeSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.SKIP_DB_INIT_EXPECT_MIME_TYPE));
    }

    public static Set<String> getSkipDbInitSceneSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.SKIP_DB_INIT_MONITOR_SCENE_LIST));
    }

    public static boolean needNotifyDownloaderProcess() {
        if (isDownloaderProcess() == false) goto L5;
    L9:
        return false;
    L5:
        if (DownloadComponentManager.isDownloadInMultiProcess() == false) goto L9;
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L9;
        return true;
    }

    public static void updateCacheSetting() {
        String[] r100 = {DownloadSettingKeys.KEY_LRU_DOWNLOAD_INFO_CACHE_ENABLE, DownloadSettingKeys.OPTIMIZE_DOWNLOAD_CACHE};     // Catch: Throwable -> L26
        int r101 = 0;
        SharedPreferences r102 = DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_SETTING_CACHE, 0);     // Catch: Throwable -> L26
        JSONObject r103 = DownloadSetting.getGlobalSettings();     // Catch: Throwable -> L26
        if (r103.optInt(DownloadSettingKeys.ENABLE_SETTING_CACHE) > 0) goto L14;
    L5:
        if (r101 >= 2) goto L11;
        if (r102.contains(r100[r101]) == true) goto L8;
        r101 = r101 + 1;     // Catch: Throwable -> L26
        goto L5
    L8:
        r102.edit().clear().apply();     // Catch: Throwable -> L26
    L11:
        if (Logger.debug() == false) goto L35;
        Logger.globalDebug(TAG, "updateCacheSetting", "Disable cache setting");     // Catch: Throwable -> L26
        return;
    L35:
        return;
    L14:
        SharedPreferences.Editor r104 = r102.edit();     // Catch: Throwable -> L26
        int r105 = 0;
        boolean r106 = false;
    L15:
        if (r105 >= 2) goto L23;
        String r107 = r100[r105];     // Catch: Throwable -> L26
        int r110 = r103.optInt(r107, 0);     // Catch: Throwable -> L26
        if (r102.getInt(r107, 0) == r110) goto L22;
        r104.putInt(r107, r110);     // Catch: Throwable -> L26
        if (Logger.debug() == false) goto L21;
        Logger.globalDebug(TAG, "updateCacheSetting", "Key:" + r107 + " Value:" + r110);     // Catch: Throwable -> L26
    L21:
        r106 = true;
    L22:
        r105 = r105 + 1;     // Catch: Throwable -> L26
        goto L15
    L23:
        if (r106 == false) goto L36;
        r104.apply();     // Catch: Throwable -> L26
        return;
    L36:
        return;
    L26:
        th = move-exception;
        Logger.globalError(TAG, "updateCacheSetting", "Error:" + th);
    }

    public static void checkWorkerThread(String r100) {
        if (Logger.debug() == true) goto L5;
        return;
    L5:
        if (DownloadUtils.isMainThread() == false) goto L11;
        Logger.globalError(TAG, "checkWorkerThread", "This method:" + r100 + " cannot be executed on the main thread");
        IDownloadThreadCheckListener r101 = DownloadComponentManager.getDownloadThreadCheckListener();
        if (r101 == null) goto L12;
        r101.onError(r100);
        return;
    L12:
        return;
    }

    public static ListenerType convertListenerType(int r100) {
        ListenerType r101 = ListenerType.MAIN;
        ListenerType r102 = ListenerType.SUB;
        if (r100 == r102.ordinal()) goto L8;
        r102 = ListenerType.NOTIFICATION;
        if (r100 == r102.ordinal()) goto L8;
        return r101;
    L8:
        return r102;
    }

    public static void deleteDir(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
        return;
    L8:
        if (r101.isDirectory() == false) goto L31;
        File[] r102 = r101.listFiles();
        if (r102 != null) goto L13;
    L24:
        r101.delete();
        return;
    L13:
        if (r102.length == 0) goto L24;
        int r103 = r102.length;
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L24;
        File r105 = r102[r104];
        if (r105.isFile() == false) goto L20;
        r105.delete();
    L23:
        r104 = r104 + 1;
        goto L15
    L20:
        if (r105.isDirectory() == false) goto L23;
        deleteDir(r105.getAbsolutePath());
        return;
    }

    public static int getCacheSettingInt(String r100) {
        int r101 = 0;
        r101 = DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_SETTING_CACHE, 0).getInt(r100, 0);     // Catch: Throwable -> L7
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug(TAG, "getCacheSettingInt", "Key:" + r100 + " Value:" + r101);     // Catch: Throwable -> L7
    L9:
        return r101;
    L7:
        th = move-exception;
        Logger.globalError(TAG, "getCacheSettingInt", "Error:" + th);
        goto L9
    }

    public static long getCurByte(DownloadInfo r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        boolean r101 = r100.isFileDataValid();
        if (Logger.debugScene(r100) == false) goto L8;
        Logger.taskDebug(TAG, r100, "getCurByte", "ResumeAvailable:" + r101);
    L8:
        if (r101 == true) goto L10;
        return 0;
    L10:
        return r100.getCurBytes();
    }

    public static long getFirstOffset(DownloadInfo r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getCurBytes();
    }

    public static boolean isCdnCacheHit(List<Pair<String, String>> r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<Pair<String, String>> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L14;
        Pair<String, String> r102 = r101.next();
        if (TextUtils.isEmpty((CharSequence) r102.second) == true) goto L7;
        if (((String) r102.second).toLowerCase().contains(BaseHttpRequestInfo.KEY_HIT) == false) goto L7;
        return true;
    L14:
        return false;
    }

    public static boolean isChunkedTask(IDownloadHeadHttpConnection r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (VALUE_CHUNKED.equals(r100.getResponseHeaderField("Transfer-Encoding")) == false) goto L8;
    L9:
        return true;
    L8:
        if (DownloadUtils.getContentLength(r100) == (-1)) goto L9;
        return false;
    }

    public static boolean isConnectionException(Throwable r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = DownloadUtils.getThrowableMsg(r100);
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        if (r101.contains("Exception in connect") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isForbiddenException(Throwable r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = DownloadUtils.getThrowableMsg(r100);
        if ((r100 instanceof DownloadHttpException) == false) goto L15;
        if (((DownloadHttpException) r100).getHttpStatusCode() != 403) goto L10;
    L13:
        return true;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (r101.contains(DocViewModel.CHAT_DRAFT_APP_ID) == true) goto L13;
    L15:
        if (TextUtils.isEmpty(r101) == false) goto L17;
        return false;
    L17:
        if (r101.contains("Forbidden") == false) goto L21;
        return true;
    L21:
        return false;
    }

    public static boolean isHttpDataDirtyError(BaseException r100) {
        if (r100 != null) goto L4;
    L12:
        return false;
    L4:
        if (r100.getErrorCode() != 1051) goto L6;
    L11:
        return true;
    L6:
        if (r100.getErrorCode() == 1027) goto L11;
        if (r100.getErrorCode() == 1026) goto L11;
        if (r100.getErrorCode() != 1044) goto L12;
        goto L11
    }

    public static boolean isHttpsError(BaseException r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getErrorCode() != 1011) goto L8;
    L11:
        return true;
    L8:
        if (r100.getCause() != null) goto L10;
        return false;
    L10:
        if ((r100.getCause() instanceof SSLHandshakeException) == true) goto L11;
        return false;
    }

    public static boolean isInterceptError(Throwable r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r100 instanceof BaseException) == false) goto L8;
        if (((BaseException) r100).getErrorCode() != 1083) goto L8;
        return true;
    }

    public static boolean isNetNotAvailableException(Throwable r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = DownloadUtils.getThrowableMsg(r100);
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        if (r101.contains("network not available") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isResponseCode412Error(Throwable r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (DownloadComponentManager.getTTNetHandler().getResponseCode(r100) != 412) goto L8;
        return true;
    L8:
        String r101 = DownloadUtils.getThrowableMsg(r100);
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return false;
    L11:
        if (r101.contains("Precondition Failed") == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isResponseCode416Error(Throwable r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (DownloadComponentManager.getTTNetHandler().getResponseCode(r100) != 416) goto L8;
        return true;
    L8:
        String r101 = DownloadUtils.getThrowableMsg(r100);
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return false;
    L11:
        if (r101.contains("Requested Range Not Satisfiable") == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isResponseCodeError(BaseException r100) {
        if ((r100 instanceof DownloadHttpException) == false) goto L9;
        DownloadHttpException r101 = (DownloadHttpException) r100;
        if (r101.getHttpStatusCode() != 412) goto L7;
    L8:
        return true;
    L7:
        if (r101.getHttpStatusCode() == 416) goto L8;
    L9:
        return false;
    }

    public static boolean isTimeOutException(Throwable r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = DownloadUtils.getThrowableMsg(r100);
        if ((r100 instanceof SocketTimeoutException) == false) goto L8;
    L13:
        return true;
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return false;
    L10:
        if (r101.contains("time out") == true) goto L13;
        if (r101.contains("Time-out") == true) goto L13;
        return false;
    }

    public static HashMap<String, Integer> jsonObjectToHashMap(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap<String, Integer> r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        if (r103 == null) goto L7;
        r101.put(r103, Integer.valueOf(r100.optInt(r103, 0)));
        goto L7
    L12:
        if (r101.isEmpty() == false) goto L15;
        return null;
    L15:
        return r101;
    }

    public static Map<Integer, DownloadInfo> listConvertToMap(List<DownloadInfo> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        Iterator<DownloadInfo> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        DownloadInfo r103 = r102.next();
        if (r103.getId() == 0) goto L7;
        r101.put(Integer.valueOf(r103.getId()), r103);
        goto L7
    L11:
        return r101;
    }

    public static long parseContentRangeOfInstanceLength(String r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        String[] r101 = r100.split(HTTP.URL_DEFAULT);
        if (r101.length >= 2) goto L13;
    L12:
        return -1;
    L13:
        return CastLongProtector.parseLong(r101[1]);
    L10:
        e = move-exception;
        Logger.globalError(TAG, "parseContentRangeOfInstanceLength", "Exception:" + e);
        goto L12
    }

    public static DownloadInfo parseDownloadInfo(Cursor r100) {
        if (r100 == null) goto L4;
        DownloadInfo.RawBuilder r101 = new DownloadInfo.RawBuilder();
        int r102 = r100.getColumnIndex(DBDefinition.ID);     // Catch: Exception -> L174
        if (r102 == (-1)) goto L9;
        r101.f449582id = r100.getInt(r102);     // Catch: Exception -> L174
    L9:
        int r103 = r100.getColumnIndex("name");     // Catch: Exception -> L174
        if (r103 == (-1)) goto L12;
        r101.name(r100.getString(r103));     // Catch: Exception -> L174
    L12:
        int r104 = r100.getColumnIndex("title");     // Catch: Exception -> L174
        if (r104 == (-1)) goto L15;
        r101.title(r100.getString(r104));     // Catch: Exception -> L174
    L15:
        int r105 = r100.getColumnIndex("url");     // Catch: Exception -> L174
        if (r105 == (-1)) goto L18;
        r101.url(r100.getString(r105));     // Catch: Exception -> L174
    L18:
        int r106 = r100.getColumnIndex(DBDefinition.SAVE_PATH);     // Catch: Exception -> L174
        if (r106 == (-1)) goto L21;
        r101.savePath(r100.getString(r106));     // Catch: Exception -> L174
    L21:
        int r107 = r100.getColumnIndex(DBDefinition.TEMP_PATH);     // Catch: Exception -> L174
        if (r107 == (-1)) goto L24;
        r101.tempPath(r100.getString(r107));     // Catch: Exception -> L174
    L24:
        int r108 = r100.getColumnIndex(DBDefinition.CHUNK_COUNT);     // Catch: Exception -> L174
        if (r108 == (-1)) goto L27;
        r101.chunkCount = r100.getInt(r108);     // Catch: Exception -> L174
    L27:
        int r109 = r100.getColumnIndex("status");     // Catch: Exception -> L174
        boolean r110 = false;
        if (r109 == (-1)) goto L30;
        r101.status = r100.getInt(r109);     // Catch: Exception -> L174
    L31:
        int r111 = r100.getColumnIndex(DBDefinition.CUR_BYTES);     // Catch: Exception -> L174
        if (r111 == (-1)) goto L34;
        r101.curBytes = r100.getLong(r111);     // Catch: Exception -> L174
    L35:
        int r112 = r100.getColumnIndex(DBDefinition.BACK_CUR_BYTES);     // Catch: Exception -> L174
        if (r112 == (-1)) goto L38;
        r101.backCurBytes = r100.getLong(r112);     // Catch: Exception -> L174
    L39:
        int r113 = r100.getColumnIndex(DBDefinition.TOTAL_BYTES);     // Catch: Exception -> L174
        if (r113 == (-1)) goto L42;
        r101.totalBytes = r100.getLong(r113);     // Catch: Exception -> L174
    L42:
        int r114 = r100.getColumnIndex(DBDefinition.ETAG);     // Catch: Exception -> L174
        if (r114 == (-1)) goto L45;
        r101.etag = r100.getString(r114);     // Catch: Exception -> L174
    L45:
        int r115 = r100.getColumnIndex(DBDefinition.ONLY_WIFI);     // Catch: Exception -> L174
        if (r115 != (-1)) goto L48;
    L52:
        int r116 = r100.getColumnIndex("force");     // Catch: Exception -> L174
        if (r116 != (-1)) goto L55;
    L59:
        int r117 = r100.getColumnIndex(DBDefinition.RETRY_COUNT);     // Catch: Exception -> L174
        if (r117 == (-1)) goto L62;
        r101.retryCount(r100.getInt(r117));     // Catch: Exception -> L174
    L62:
        int r118 = r100.getColumnIndex("extra");     // Catch: Exception -> L174
        if (r118 == (-1)) goto L65;
        r101.extra(r100.getString(r118));     // Catch: Exception -> L174
    L65:
        int r119 = r100.getColumnIndex(DBDefinition.MIME_TYPE);     // Catch: Exception -> L174
        if (r119 == (-1)) goto L68;
        r101.mimeType(r100.getString(r119));     // Catch: Exception -> L174
    L68:
        int r120 = r100.getColumnIndex(DBDefinition.NOTIFICATION_ENABLE);     // Catch: Exception -> L174
        if (r120 != (-1)) goto L71;
    L75:
        int r121 = r100.getColumnIndex(DBDefinition.NOTIFICATION_VISIBILITY);     // Catch: Exception -> L174
        if (r121 == (-1)) goto L78;
        r101.notificationVisibility = r100.getInt(r121);     // Catch: Exception -> L174
    L78:
        int r122 = r100.getColumnIndex(DBDefinition.FIRST_DOWNLOAD);     // Catch: Exception -> L174
        if (r122 != (-1)) goto L81;
    L85:
        int r123 = r100.getColumnIndex(DBDefinition.FIRST_SUCCESS);     // Catch: Exception -> L174
        if (r123 != (-1)) goto L88;
    L92:
        int r124 = r100.getColumnIndex(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY);     // Catch: Exception -> L174
        if (r124 != (-1)) goto L95;
    L99:
        int r125 = r100.getColumnIndex(DBDefinition.DOWNLOAD_TIME);     // Catch: Exception -> L174
        if (r125 == (-1)) goto L102;
        r101.downloadTime = r100.getLong(r125);     // Catch: Exception -> L174
    L102:
        int r126 = r100.getColumnIndex("packageName");     // Catch: Exception -> L174
        if (r126 == (-1)) goto L105;
        r101.packageName(r100.getString(r126));     // Catch: Exception -> L174
    L105:
        int r127 = r100.getColumnIndex("md5");     // Catch: Exception -> L174
        if (r127 == (-1)) goto L108;
        r101.md5(r100.getString(r127));     // Catch: Exception -> L174
    L108:
        int r128 = r100.getColumnIndex(DBDefinition.CUR_RETRY_TIME);     // Catch: Exception -> L174
        if (r128 == (-1)) goto L111;
        r101.curRetryTime = r100.getInt(r128);     // Catch: Exception -> L174
    L111:
        int r129 = r100.getColumnIndex(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP);     // Catch: Exception -> L174
        if (r129 != (-1)) goto L114;
    L118:
        int r130 = r100.getColumnIndex(DBDefinition.BACKUP_URLS_STR);     // Catch: Exception -> L174
        if (r130 == (-1)) goto L121;
        r101.backUpUrlsStr = r100.getString(r130);     // Catch: Exception -> L174
    L121:
        int r131 = r100.getColumnIndex(DBDefinition.BACKUP_URL_RETRY_COUNT);     // Catch: Exception -> L174
        if (r131 == (-1)) goto L124;
        r101.backUpUrlRetryCount(r100.getInt(r131));     // Catch: Exception -> L174
    L124:
        int r132 = r100.getColumnIndex(DBDefinition.REAL_DOWNLOAD_TIME);     // Catch: Exception -> L174
        if (r132 == (-1)) goto L127;
        r101.realDownloadTime = r100.getLong(r132);     // Catch: Exception -> L174
    L127:
        int r133 = r100.getColumnIndex(DBDefinition.REAL_BACK_DOWNLOAD_TIME);     // Catch: Exception -> L174
        if (r133 == (-1)) goto L130;
        r101.realBackDownloadTime = r100.getLong(r133);     // Catch: Exception -> L174
    L130:
        int r134 = r100.getColumnIndex(DBDefinition.INDEPENDENT_PROCESS);     // Catch: Exception -> L174
        if (r134 != (-1)) goto L133;
    L137:
        int r135 = r100.getColumnIndex(DBDefinition.AUXILIARY_JSONOBJECT_STRING);     // Catch: Exception -> L174
        if (r135 == (-1)) goto L140;
        r101.dbJsonDataString = r100.getString(r135);     // Catch: Exception -> L174
    L140:
        int r136 = r100.getColumnIndex("iconUrl");     // Catch: Exception -> L174
        if (r136 == (-1)) goto L143;
        r101.iconUrl(r100.getString(r136));     // Catch: Exception -> L174
    L143:
        int r137 = r100.getColumnIndex(DBDefinition.APP_VERSION_CODE);     // Catch: Exception -> L174
        if (r137 == (-1)) goto L146;
        r101.appVersionCode(r100.getInt(r137));     // Catch: Exception -> L174
    L146:
        int r138 = r100.getColumnIndex(DBDefinition.DOWNLOAD_START_TIMESTAMP);     // Catch: Exception -> L174
        if (r138 == (-1)) goto L149;
        r101.downloadStartTimeStamp = r100.getLong(r138);     // Catch: Exception -> L174
    L149:
        int r139 = r100.getColumnIndex(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP);     // Catch: Exception -> L174
        if (r139 == (-1)) goto L152;
        r101.downloadFinishTimeStamp = r100.getLong(r139);     // Catch: Exception -> L174
    L152:
        int r140 = r100.getColumnIndex(DBDefinition.INSTALLED_TIMESTAMP);     // Catch: Exception -> L174
        if (r140 == (-1)) goto L155;
        r101.installedTimeStamp = r100.getLong(r140);     // Catch: Exception -> L174
    L155:
        int r141 = r100.getColumnIndex(DBDefinition.CACHE_LIFE_TIME_MAX);     // Catch: Exception -> L174
        if (r141 == (-1)) goto L158;
        r101.cacheLifeTimeMax(r100.getLong(r141));     // Catch: Exception -> L174
    L158:
        int r142 = r100.getColumnIndex(DBDefinition.HAS_DO_INSTALLATION);     // Catch: Exception -> L174
        if (r142 != (-1)) goto L161;
    L164:
        int r143 = r100.getColumnIndex(DBDefinition.PCDN_URLS_STR);     // Catch: Exception -> L174
        if (r143 == (-1)) goto L167;
        r101.pcdnUrlsStr = r100.getString(r143);     // Catch: Exception -> L174
    L167:
        int r144 = r100.getColumnIndex(DBDefinition.CDN_URLS_STR);     // Catch: Exception -> L174
        if (r144 == (-1)) goto L170;
        r101.cdnUrlsStr = r100.getString(r144);     // Catch: Exception -> L174
    L170:
        int r145 = r100.getColumnIndex(DBDefinition.MONITOR_SCENE);     // Catch: Exception -> L174
        if (r145 == (-1)) goto L177;
        r101.monitorScene(r100.getString(r145));     // Catch: Exception -> L174
    L177:
        return r101.build();
    L161:
        if (r100.getInt(r142) != 1) goto L163;
        r110 = true;
    L163:
        r101.hasDoInstallation = r110;     // Catch: Exception -> L174
        goto L164
    L133:
        if (r100.getInt(r134) != 1) goto L135;
        boolean r146 = true;
    L136:
        r101.needIndependentProcess(r146);     // Catch: Exception -> L174
        goto L137
    L135:
        r146 = false;
        goto L136
    L114:
        if (r100.getInt(r129) != 1) goto L116;
        boolean r147 = true;
    L117:
        r101.needDefaultHttpServiceBackUp(r147);     // Catch: Exception -> L174
        goto L118
    L116:
        r147 = false;
        goto L117
    L95:
        if (r100.getInt(r124) != 1) goto L97;
        boolean r148 = true;
    L98:
        r101.needHttpsToHttpRetry(r148);     // Catch: Exception -> L174
        goto L99
    L97:
        r148 = false;
        goto L98
    L88:
        if (r100.getInt(r123) != 1) goto L90;
        boolean r149 = true;
    L91:
        r101.isFirstSuccess = r149;     // Catch: Exception -> L174
        goto L92
    L90:
        r149 = false;
        goto L91
    L81:
        if (r100.getInt(r122) != 1) goto L83;
        boolean r150 = true;
    L84:
        r101.isFirstDownload = r150;     // Catch: Exception -> L174
        goto L85
    L83:
        r150 = false;
        goto L84
    L71:
        if (r100.getInt(r120) == 0) goto L73;
        boolean r151 = true;
    L74:
        r101.showNotification(r151);     // Catch: Exception -> L174
        goto L75
    L73:
        r151 = false;
        goto L74
    L55:
        if (r100.getInt(r116) == 0) goto L57;
        boolean r152 = true;
    L58:
        r101.force(r152);     // Catch: Exception -> L174
        goto L59
    L57:
        r152 = false;
        goto L58
    L48:
        if (r100.getInt(r115) == 0) goto L50;
        boolean r153 = true;
    L51:
        r101.onlyWifi(r153);     // Catch: Exception -> L174
        goto L52
    L50:
        r153 = false;
        goto L51
    L38:
        r101.backCurBytes = 0;     // Catch: Exception -> L174
        goto L39
    L34:
        r101.curBytes = 0;     // Catch: Exception -> L174
        goto L35
    L30:
        r101.status = 0;     // Catch: Exception -> L174
    L174:
        e = move-exception;
        e.printStackTrace();
        goto L177
    L4:
        return new DownloadInfo();
    }

    private static Set<String> parseJSONArrayToSet(JSONArray r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() <= 0) goto L19;
        HashSet r101 = new HashSet();
        int r102 = 0;
    L16:
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r101;
    L8:
        if (r102 >= r100.length()) goto L13;
        r101.add(JSONArrayProtectorUtils.getString(r100, r102));     // Catch: JSONException -> L11
        r102 = r102 + 1;
        goto L16
    L19:
        return null;
    }

    public static long parserMaxAge(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return 0;
    L13:
        Matcher r101 = PatternProtector.compile("max-age=([0-9]+)").matcher(r100);     // Catch: Throwable -> L10
        if (r101.find() == false) goto L15;
        return CastLongProtector.parseLong(r101.group(1));
    L15:
        return 0;
    L10:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static List<Integer> setConvertToList(Set<Integer> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        Iterator<Integer> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.add(r102.next());
        goto L7
    L9:
        return r101;
    }

    public static void setSleepDownloadingTask(boolean r100) {
        mSleepDownloadingTask = r100;
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "setSleepDownloadingTask", "SleepDownloadingTask:" + mSleepDownloadingTask);
        return;
    }

    public static <K> HashMap<Integer, K> sparseArrayToHashMap(SparseArray<K> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap<Integer, K> r101 = new HashMap();
        int r102 = r100.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        int r104 = r100.keyAt(r103);
        K r105 = r100.valueAt(r103);
        r101.put(Integer.valueOf(r104), r105);
        r103 = r103 + 1;
        goto L6
    L8:
        return r101;
    }

    public static ContentValues toContentValues(DownloadInfo r100) {
        ContentValues r101 = new ContentValues();
        r101.put(DBDefinition.ID, Integer.valueOf(r100.getRawId()));
        r101.put("url", r100.getUrl());
        r101.put(DBDefinition.SAVE_PATH, r100.getSavePath());
        r101.put(DBDefinition.TEMP_PATH, r100.getRawTempPath());
        r101.put("name", r100.getName());
        r101.put(DBDefinition.CHUNK_COUNT, Integer.valueOf(r100.getChunkCount()));
        r101.put("status", Integer.valueOf(r100.getStatus()));
        r101.put(DBDefinition.CUR_BYTES, Long.valueOf(r100.getCurBytes()));
        r101.put(DBDefinition.BACK_CUR_BYTES, Long.valueOf(r100.getBackCurBytes()));
        r101.put(DBDefinition.TOTAL_BYTES, Long.valueOf(r100.getTotalBytes()));
        r101.put(DBDefinition.ETAG, r100.geteTag());
        r101.put(DBDefinition.ONLY_WIFI, Integer.valueOf(r100.isOnlyWifi() ? 1 : 0));
        r101.put("force", Integer.valueOf(r100.isForce() ? 1 : 0));
        r101.put(DBDefinition.RETRY_COUNT, Integer.valueOf(r100.getRetryCount()));
        r101.put("extra", r100.getExtra());
        r101.put(DBDefinition.MIME_TYPE, r100.getMimeType());
        r101.put("title", r100.getRawTitle());
        r101.put(DBDefinition.NOTIFICATION_ENABLE, Integer.valueOf(r100.isShowNotification() ? 1 : 0));
        r101.put(DBDefinition.NOTIFICATION_VISIBILITY, Integer.valueOf(r100.getNotificationVisibility()));
        r101.put(DBDefinition.FIRST_DOWNLOAD, Integer.valueOf(r100.getIsFirstDownload() ? 1 : 0));
        r101.put(DBDefinition.FIRST_SUCCESS, Integer.valueOf(r100.isFirstSuccess() ? 1 : 0));
        r101.put(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY, Integer.valueOf(r100.isNeedHttpsToHttpRetry() ? 1 : 0));
        r101.put(DBDefinition.DOWNLOAD_TIME, Long.valueOf(r100.getDownloadTime()));
        r101.put("packageName", r100.getPackageName());
        r101.put("md5", r100.getMd5());
        r101.put(DBDefinition.CUR_RETRY_TIME, Integer.valueOf(r100.getCurRetryTime()));
        r101.put(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP, Integer.valueOf(r100.isNeedDefaultHttpServiceBackUp() ? 1 : 0));
        r101.put(DBDefinition.CHUNK_RUNNABLE_REUSE, 0);
        r101.put(DBDefinition.CHUNK_DOWNGRADE_RETRY, 0);
        r101.put(DBDefinition.BACKUP_URLS_STR, r100.getBackUpUrlsStr());
        r101.put(DBDefinition.BACKUP_URL_RETRY_COUNT, Integer.valueOf(r100.getBackUpUrlRetryCount()));
        r101.put(DBDefinition.REAL_DOWNLOAD_TIME, Long.valueOf(r100.getRawRealDownloadTime()));
        r101.put(DBDefinition.REAL_BACK_DOWNLOAD_TIME, Long.valueOf(r100.getRawRealBackDownloadTime()));
        r101.put(DBDefinition.INDEPENDENT_PROCESS, Integer.valueOf(r100.isNeedIndependentProcess() ? 1 : 0));
        r101.put(DBDefinition.AUXILIARY_JSONOBJECT_STRING, r100.getDBJsonDataString());
        r101.put("iconUrl", r100.getIconUrl());
        r101.put(DBDefinition.APP_VERSION_CODE, Integer.valueOf(r100.getAppVersionCode()));
        r101.put(DBDefinition.TASK_ID, null);
        r101.put(DBDefinition.DOWNLOAD_START_TIMESTAMP, Long.valueOf(r100.getDownloadStartTimeStamp()));
        r101.put(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP, Long.valueOf(r100.getDownloadFinishTimeStamp()));
        r101.put(DBDefinition.INSTALLED_TIMESTAMP, Long.valueOf(r100.getInstalledTimeStamp()));
        r101.put(DBDefinition.HAS_DO_INSTALLATION, Integer.valueOf(r100.isHasDoInstallation() ? 1 : 0));
        r101.put(DBDefinition.CACHE_LIFE_TIME_MAX, Long.valueOf(r100.getCacheLifeTimeMax()));
        r101.put(DBDefinition.PCDN_URLS_STR, r100.getPcdnUrlsStr());
        r101.put(DBDefinition.CDN_URLS_STR, r100.getCdnUrlsStr());
        r101.put(DBDefinition.MONITOR_SCENE, r100.getMonitorScene());
        return r101;
    }

    public static void trySleepDownloadingTask(DownloadInfo r100) {
        if (mSleepDownloadingTask == false) goto L38;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getTaskSleepTime() > 0) goto L40;
        int r101 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.DOWNLOADING_TASK_ANR_SLEEP_TIME_S);     // Catch: Throwable -> L29
        if (r101 > 0) goto L11;
        return;
    L11:
        JSONArray r102 = DownloadSetting.obtainGlobal().optJSONArray(DownloadSettingKeys.DOWNLOADING_TASK_ANR_SLEEP_PROHIBIT_SCENE_LIST);     // Catch: Throwable -> L29
        if (r102 != null) goto L14;
    L24:
        r100.setTaskSleepTime(r101);     // Catch: Throwable -> L29
        if (Logger.debugScene(r100.getMonitorScene()) == false) goto L27;
        Logger.taskDebug(TAG, r100.getId(), "trySleepDownloadingTask", "Sleep:" + r101);     // Catch: Throwable -> L29
    L27:
        Thread.sleep(r101 * 1000);     // Catch: Throwable -> L29
        return;
    L14:
        if (r102.length() <= 0) goto L24;
        int r103 = 0;
    L17:
        if (r103 >= r102.length()) goto L24;
        String r104 = r102.optString(r103);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r104) == true) goto L23;
        if (r104.equalsIgnoreCase(r100.getMonitorScene()) == false) goto L23;
        return;
    L23:
        r103 = r103 + 1;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Logger.taskError(TAG, r100.getId(), "trySleepDownloadingTask", "Error:" + th);
        return;
    L40:
        return;
    }

    public static boolean canAcceptPartial(int r100, String r101) {
        if (r100 < 400) goto L6;
        return false;
    L6:
        if (r100 == 206) goto L10;
        if (r100 == 1) goto L10;
        if (HTTP.CONTENT_RANGE_BYTES.equals(r101) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean checkPermission(Context r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        if (r100.checkCallingOrSelfPermission(r101) != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean copyFile(File r100, File r101) throws BaseException {
        return copyFile(r100, r101, true);
    }

    public static <K, V> void copyMap(Map<K, V> r100, Map<K, V> r101) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L17;
        Iterator<Map.Entry<K, V>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<K, V> r103 = r102.next();
        if (r103.getKey() == null) goto L7;
        r101.put(r103.getKey(), r103.getValue());
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public static String getFixLengthString(String r100, int r101) {
        if (r101 != 0) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return r100;
    L8:
        if (r100.length() > r101) goto L11;
        return r100;
    L11:
        return r100.substring(0, r101);
    }

    public static DownloadTTNetException getTTNetException(Throwable r100, String r101) {
        DownloadTTNetException r102 = DownloadComponentManager.getTTNetHandler().translateTTNetException(r100, null);
        if (r102 != null) goto L5;
        r102 = DownloadComponentManager.getTTNetHandler().translateTTNetException(r100.getCause(), null);
    L5:
        if (r102 == null) goto L8;
        String r103 = DownloadUtils.getErrorMsgWithTagPrefix(r102, r101);
        return new DownloadTTNetException(r102.getErrorCode(), r103).setRequestLog(r102.getRequestLog()).setRemoteIp(r102.getRemoteIp());
    L8:
        return null;
    }

    public static void injectRemoteIp(IDownloadHttpConnection r100, BaseException r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof AbsDownloadHttpConnection) == false) goto L15;
        if (r101 != null) goto L7;
        return;
    L7:
        if ((r101 instanceof DownloadTTNetException) == false) goto L17;
        String r102 = ((AbsDownloadHttpConnection) r100).getHostIp();
        if (TextUtils.isEmpty(r102) == true) goto L12;
        ((DownloadTTNetException) r101).setRemoteIp(r102);
    L12:
        ((DownloadTTNetException) r101).parseRemoteIp();
        return;
    L17:
        return;
    }

    public static <K, V> void mapConvertToList(Map<K, V> r100, List<V> r101) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L17;
        Iterator<Map.Entry<K, V>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<K, V> r103 = r102.next();
        if (r103.getKey() == null) goto L7;
        r101.add(r103.getValue());
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public static boolean moveFile(DownloadFile r100, DownloadFile r101) throws BaseException {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "moveFile", "DownloadFile Src:" + r100.getPath() + " Dest:" + r101.getPath());
    L6:
        if (DownloadFileUtils.isScopedStorage() == true) goto L8;
    L12:
        boolean r102 = r100.renameTo(r101);
    L13:
        if (r102 == true) goto L22;
        r102 = copyFile(r100, r101, true);
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    L16:
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug(TAG, "moveFile", "Copy DownloadFile Src:" + r100.getPath() + " Dest:" + r101.getPath());     // Catch: Throwable -> L20
    L18:
        r100.delete();     // Catch: Throwable -> L20
    L22:
        return r102;
    L8:
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r100.getAbsolutePath()) == true) goto L12;
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r101.getAbsolutePath()) == false) goto L12;
        r102 = false;
        goto L13
    }

    public static void parseException(Throwable r100, String r101) throws BaseException {
        if (TextUtils.isEmpty(r101) == true) goto L5;
        String r102 = r101;
    L7:
        if ((r100 instanceof BaseException) == false) goto L9;
        BaseException r103 = (BaseException) r100;
        r103.setErrorMsg(r102 + "-" + r103.getErrorMessage());
        throw r103;
    L9:
        if ((r100 instanceof SSLHandshakeException) == true) goto L41;
        if (isTimeOutException(r100) == true) goto L39;
        if (isResponseCode412Error(r100) == true) goto L37;
        if (isResponseCode416Error(r100) == true) goto L35;
        if (isForbiddenException(r100) == true) goto L33;
        if (isNetNotAvailableException(r100) == true) goto L31;
        if (isConnectionException(r100) == true) goto L29;
        if ((r100 instanceof IOException) == false) goto L27;
        parseTTNetException(r100, r101);
        parseIOException((IOException) r100, r101);
        return;
    L27:
        throw new BaseException(1000, DownloadUtils.getErrorMsgWithTagPrefix(r100, r102));
    L29:
        throw new BaseException(1041, DownloadUtils.getErrorMsgWithTagPrefix(r100, r102));
    L31:
        throw new BaseException(1049, DownloadUtils.getErrorMsgWithTagPrefix(r100, r102));
    L33:
        throw new BaseException(1047, DownloadUtils.getErrorMsgWithTagPrefix(r100, r102));
    L35:
        throw new DownloadHttpException(1004, 416, DownloadUtils.getErrorMsgWithTagPrefix(r100, r102));
    L37:
        throw new DownloadHttpException(1004, 412, DownloadUtils.getErrorMsgWithTagPrefix(r100, r102));
    L39:
        throw new BaseException(1048, DownloadUtils.getErrorMsgWithTagPrefix(r100, r102));
    L41:
        throw new BaseException(1011, DownloadUtils.getErrorMsgWithTagPrefix(r100, r102));
    L5:
        r102 = "";
        goto L7
    }

    public static void parseIOException(IOException r100, String r101) throws BaseException {
        if (r101 != null) goto L4;
        r101 = "";
    L4:
        String r102 = DownloadUtils.getErrorMsgWithTagPrefix(r100, r101);
        if ((r100 instanceof ConnectException) == true) goto L73;
        if ((r100 instanceof UnknownHostException) == true) goto L71;
        if ((r100 instanceof NoRouteToHostException) == true) goto L69;
        if ((r100 instanceof UnknownServiceException) == true) goto L67;
        if ((r100 instanceof PortUnreachableException) == true) goto L65;
        if ((r100 instanceof SocketTimeoutException) == true) goto L63;
        if ((r100 instanceof SocketException) == true) goto L61;
        if ((r100 instanceof HttpRetryException) == true) goto L59;
        if ((r100 instanceof ProtocolException) == true) goto L57;
        if ((r100 instanceof MalformedURLException) == true) goto L55;
        if ((r100 instanceof FileNotFoundException) == true) goto L53;
        if ((r100 instanceof InterruptedIOException) == true) goto L51;
        if ((r100 instanceof UnsupportedEncodingException) == true) goto L49;
        if ((r100 instanceof EOFException) == true) goto L47;
        if ((r100 instanceof StreamResetException) == true) goto L45;
        if ((r100 instanceof SSLException) == true) goto L43;
        if (DownloadUtils.isInsufficientSpaceError(r100) == false) goto L41;
        throw new BaseException(1006, r102);
    L41:
        throw new BaseException(1023, r102);
    L43:
        throw new BaseException(1011, r102);
    L45:
        throw new BaseException(1067, r102);
    L47:
        throw new BaseException(1066, r102);
    L49:
        throw new BaseException(1065, r102);
    L51:
        throw new BaseException(1064, r102);
    L53:
        throw new BaseException(1063, r102);
    L55:
        throw new BaseException(1062, r102);
    L57:
        throw new BaseException(1061, r102);
    L59:
        throw new BaseException(1060, r102);
    L61:
        throw new BaseException(1059, r102);
    L63:
        throw new BaseException(1048, r102);
    L65:
        throw new BaseException(1058, r102);
    L67:
        throw new BaseException(1057, r102);
    L69:
        throw new BaseException(1056, r102);
    L71:
        throw new BaseException(1055, r102);
    L73:
        throw new BaseException(1041, r102);
    }

    private static void parseTTNetException(Throwable r100, String r101) throws DownloadTTNetException {
        DownloadTTNetException r102 = getTTNetException(r100, r101);
        if (r102 != null) goto L5;
        return;
    L5:
        throw r102;
    }

    public static void removeHeaderKey(List<HttpHeader> r100, String r101) {
        if (r100 == null) goto L24;
        if (r101 == null) goto L25;
        Iterator<HttpHeader> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L26;
        HttpHeader r103 = r102.next();
        if (r103 == null) goto L7;
        if (TextUtils.isEmpty(r103.getName()) == true) goto L7;
        if (r103.getName().contains(r101) == false) goto L7;
        r102.remove();
        return;
    L26:
        return;
    L25:
        return;
    }

    public static void setAppInfo(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        sAid = r100;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        sChannel = r101;
        return;
    }

    public static <K> void sparseArrayPutAll(SparseArray<K> r100, Map<Integer, K> r101) {
        if (r101 == null) goto L11;
        if (r100 == null) goto L17;
        Iterator<Map.Entry<Integer, K>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<Integer, K> r103 = r102.next();
        if (r103.getKey() == null) goto L7;
        r100.put(r103.getKey().intValue(), r103.getValue());
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public static void addTTNetParam(DownloadSetting r100, List<HttpHeader> r101, DownloadInfo r102) {
        long r103 = r102.getThrottleNetSpeed();
        if (r103 <= 0) goto L5;
        r101.add(new HttpHeader(DownloadConstants.EXTRA_THROTTLE_NET_SPEED, String.valueOf(r103)));
    L5:
        long r104 = r102.getTtnetProtectTimeout();
        if (r104 <= 300) goto L9;
        r101.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_PROTECT_TIMEOUT, String.valueOf(r104)));
    L9:
        if (r102.isAddTTNetCommonParam() == false) goto L12;
        r101.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_TTNET_COMMON_PARAMS, "true"));
    L12:
        if (r102.isTTNetByPassProxy() == false) goto L15;
        r101.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_TTNET_BYPASS_PROXY, "true"));
    L15:
        if (r100.optInt(DownloadSettingKeys.ENABLE_DOWNLOAD_NETWORK_TAG, 0) <= 0) goto L17;
        r101.add(new HttpHeader(DownloadInnerConstants.TTNET_BIZ_ID_HEADER_NAME, "dl"));
        r101.add(new HttpHeader(DownloadInnerConstants.TTNET_BIZ_VERSION_HEADER_NAME, BuildConfig.DL_VERSION_NAME));
    L17:
        int r105 = r100.optInt(DownloadSettingKeys.TTNET_ERROR_PROTO_TYPE, 0);
        if (r105 <= 0) goto L21;
        r101.add(new HttpHeader(TTNET_PROTO_TYPE, String.valueOf(r105)));
    L21:
        if (r100.optInt(DownloadSettingKeys.FIX_VULNERABILITY_CSRF, 1) <= 0) goto L24;
        r101.add(new HttpHeader(SECURITY_ARGUS_KEY, getSecurityValue()));
    L24:
        if (r102.getConcurrentConnCount() > 1) goto L26;
        return;
    L26:
        if (r102.getConcurrentConnCount() > 8) goto L30;
        r101.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_CONCURRENT_CONN_COUNT, String.valueOf(r102.getConcurrentConnCount())));
        return;
    }

    public static boolean copyFile(DownloadFile r100, DownloadFile r101, boolean r102) throws BaseException {
        if (r100 == null) goto L42;
        if (r101 == null) goto L42;
    L40:
        e = move-exception;
        throw e;
    L37:
        th = move-exception;
        parseException(th, "CopyFile");
        return false;
    L6:
        if (r100.exists() == false) goto L42;
        if (r100.isDirectory() == true) goto L42;
        if (r100.getAbsolutePath().equals(r101.getAbsolutePath()) == true) goto L42;
        if (r101.isTypeFile() == false) goto L25;
        File r103 = r101.getParentFile();     // Catch: Throwable -> L37 BaseException -> L40
        if (r103 == null) goto L25;
        if (r103.mkdirs() == true) goto L25;
        if (r103.isDirectory() == true) goto L25;
        throw new BaseException(1053, "Destination '" + r103 + "' directory cannot be created");     // Catch: Throwable -> L37 BaseException -> L40
    L25:
        if (Logger.debug() == false) goto L28;
        Logger.globalDebug(TAG, "copyFile", "SrcFile:" + r100.getPath() + " DestFile:" + r101.getPath());     // Catch: Throwable -> L37 BaseException -> L40
    L28:
        if (r101.exists() == true) goto L30;
    L34:
        doCopyFile(r100, r101, r102);     // Catch: Throwable -> L37 BaseException -> L40
        return true;
    L30:
        if (r101.canWrite() == true) goto L34;
        throw new IOException("Destination '" + r101.getAbsolutePath() + "' exists but is read-only");     // Catch: Throwable -> L37 BaseException -> L40
    L42:
        return false;
    }

    public static void copyFileFromExistFileWithSameName(DownloadInfo r100, String r101, String r102) throws BaseException {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (r102.equals(r100.getName()) == true) goto L28;
        DownloadFile r103 = new DownloadFile(r100.getSavePath(), r102);
        DownloadFile r104 = new DownloadFile(r100.getSavePath(), r100.getName());
        if (Logger.debugScene(r100) == false) goto L14;
        Logger.taskDebug(TAG, r100, "copyFileFromExistFileWithSameName", "ExistFile:" + r103.getPath() + " targetFile:" + r104.getPath());
    L14:
        if (r104.exists() == false) goto L21;
        if (r104.canWrite() == true) goto L21;
        throw new BaseException(1001, "targetPath file exists but read-only");
    L21:
        if ((!copyFile(r103, r104, true)) == true) goto L24;
        return;
    L24:
        throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", new Object[]{r100.getSavePath(), r102, r100.getSavePath(), r100.getName()}));
    }

    public static void copyFileToExternal(Context r100, String r101, Uri r102) {
        ContentResolver r103 = r100.getContentResolver();
        Closeable r104 = null;
        OutputStream r105 = null;
        r105 = null;
        r105 = null;
        r104 = null;
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r101));     // Catch: Throwable -> L17 IOException -> L19
        if (r102 != null) goto L31;
    L10:
        if (r105 == null) goto L16;
        byte[] r107 = new byte[DownloadComponentManager.getWriteBufferSize()];     // Catch: Throwable -> L6 IOException -> L8
    L12:
        int r108 = r106.read(r107);     // Catch: Throwable -> L6 IOException -> L8
        if (r108 == (-1)) goto L16;
        r105.write(r107, 0, r108);     // Catch: Throwable -> L6 IOException -> L8
        goto L12
    L8:
        e = e;
        Closeable r109 = r105;
        r104 = r106;
    L27:
        Logger.globalError(TAG, "copyFileToExternal", "Error:" + e);     // Catch: Throwable -> L24
        DownloadUtils.safeClose(new Closeable[]{r104});
        DownloadUtils.safeClose(new Closeable[]{r109});
        return;
    L24:
        th = th;
    L25:
        DownloadUtils.safeClose(new Closeable[]{r104});
        DownloadUtils.safeClose(new Closeable[]{r109});
        throw th;
    L6:
        th = th;
        r109 = r105;
        r104 = r106;
    L16:
        DownloadUtils.safeClose(new Closeable[]{r106});
        DownloadUtils.safeClose(new Closeable[]{r105});
        return;
    L31:
        r105 = ContentResolverWrapper.openOutputStream(r103, r102);     // Catch: Throwable -> L6 IOException -> L8
        goto L10
    L19:
        e = e;
        r109 = null;
    L17:
        th = th;
        r109 = null;
        goto L25
    }

    private static void doCopyFile(DownloadFile r110, DownloadFile r111, boolean r112) throws IOException {
        if (r111.exists() == false) goto L10;
        if (r111.isDirectory() == false) goto L10;
        throw new IOException("Destination '" + r111 + "' exists but is a directory");
    L10:
        if (DownloadFileUtils.isExternalDownloadEnabled() == false) goto L16;
        if (r111.getFileType() <= 1) goto L16;
        copyFileToExternal(DownloadComponentManager.getAppContext(), r110.getPath(), UriProtector.parse(r111.getRealPath()));
        return;
    L16:
        if (Build.VERSION.SDK_INT >= 29) goto L18;
    L25:
        FileInputStream r100 = r110.obtainInputStream();
        FileChannel r101 = r100.getChannel();     // Catch: Throwable -> L88
        FileOutputStream r102 = r111.obtainOutputStream();     // Catch: Throwable -> L76
        FileChannel r113 = r102.getChannel();     // Catch: Throwable -> L64
        long r114 = r101.size();     // Catch: Throwable -> L52
        long r115 = 0;
    L31:
        if (r115 >= r114) goto L41;
        long r103 = r114 - r115;     // Catch: Throwable -> L52
        if (r103 <= FILE_COPY_BUFFER_SIZE) goto L35;
        long r104 = 31457280;
    L36:
        long r105 = r113.transferFrom(r101, r115, r104);     // Catch: Throwable -> L52
    L38:
        if (r105 == 0) goto L41;
        r115 = r115 + r105;
        goto L31
    L35:
        r104 = r103;
    L41:
        if (r113 == null) goto L43;
        r113.close();     // Catch: Throwable -> L64
    L43:
        r102.close();     // Catch: Throwable -> L76
        r101.close();     // Catch: Throwable -> L88
        r100.close();
        long r106 = r110.length();
        long r107 = r111.length();
        if (r106 != r107) goto L51;
        if (r112 == false) goto L122;
        r111.setLastModified(r110.lastModified());
        return;
    L122:
        return;
    L51:
        throw new IOException("Failed to copy full contents from '" + r110 + "' to '" + r111 + "' Expected length: " + r106 + " Actual: " + r107);
    L52:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        if (r113 == null) goto L123;
        r113.close();     // Catch: Throwable -> L60
    L124:
        throw th;     // Catch: Throwable -> L64
    L60:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L64
        throw th;     // Catch: Throwable -> L64
    L123:
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        if (r102 == null) goto L125;
        r102.close();     // Catch: Throwable -> L72
    L126:
        throw th;     // Catch: Throwable -> L76
    L72:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L76
        throw th;     // Catch: Throwable -> L76
    L125:
        throw th;     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        throw th;     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        if (r101 == null) goto L127;
        r101.close();     // Catch: Throwable -> L84
    L128:
        throw th;     // Catch: Throwable -> L88
    L84:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L88
        throw th;     // Catch: Throwable -> L88
    L127:
        throw th;     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        throw th;     // Catch: Throwable -> L91
    L91:
        th = move-exception;
        if (r100 == null) goto L129;
        r100.close();     // Catch: Throwable -> L96
        throw th;
    L96:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L129:
        throw th;
    L18:
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r111.getPath()) == false) goto L25;
        Uri r108 = DownloadFileUtils.getUriFromFilePath(r111.getPath());
        if (r108 == null) goto L24;
        copyFileToExternal(DownloadComponentManager.getAppContext(), r110.getPath(), r108);
        return;
    L24:
        throw new IOException("Destination " + r111 + "exists but contentUri is null");
    }

    private static void handleTempSaveCallback(int r100, boolean r101, BaseException r102) {
        SparseArray<Boolean> r103 = saveTempFileStatusMap;
        monitor-enter(r103);
        List<ITempFileSaveCompleteCallback> r104 = saveTempFileListeners.get(r100);     // Catch: Throwable -> L20
        if (r104 == null) goto L15;
        Iterator<ITempFileSaveCompleteCallback> r105 = r104.iterator();     // Catch: Throwable -> L20
    L8:
        if (r105.hasNext() == false) goto L15;
        ITempFileSaveCompleteCallback r106 = r105.next();     // Catch: Throwable -> L20
        if (r106 == null) goto L8;
        if (r101 == true) goto L12;
        r106.onFailed(r102);     // Catch: Throwable -> L20
        goto L8
    L12:
        r106.onSuccess();     // Catch: Throwable -> L20
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.taskDebug(TAG, r100, "handleTempSaveCallback", "Run");     // Catch: Throwable -> L20
    L17:
        saveTempFileStatusMap.remove(r100);     // Catch: Throwable -> L20
        monitor-exit(r103);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void saveFileAsTargetName(DownloadInfo r210, IDownloadMonitorDepend r211, ITempFileSaveCompleteCallback r212) {
        if (Logger.debugScene(r210) == false) goto L111;
        Logger.taskDebug(TAG, r210, "saveFileAsTargetName", "TargetName: " + r210.getTargetFilePath());
    L111:
        SparseArray<Boolean> r100 = saveTempFileStatusMap;     // Catch: Throwable -> L101
        monitor-enter(r100);     // Catch: Throwable -> L101
        Boolean r101 = saveTempFileStatusMap.get(r210.getId());     // Catch: Throwable -> L98
        Boolean r102 = Boolean.TRUE;     // Catch: Throwable -> L98
        if (r101 != r102) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L24;
        if (Logger.debugScene(r210) == false) goto L16;
        Logger.taskDebug(TAG, r210, "saveFileAsTargetName", "Has another same task is saving temp file");     // Catch: Throwable -> L98
    L16:
        if (r212 == null) goto L21;
        List<ITempFileSaveCompleteCallback> r104 = saveTempFileListeners.get(r210.getId());     // Catch: Throwable -> L98
        if (r104 != null) goto L20;
        r104 = new ArrayList();     // Catch: Throwable -> L98
        saveTempFileListeners.put(r210.getId(), r104);     // Catch: Throwable -> L98
    L20:
        r104.add(r212);     // Catch: Throwable -> L98
        r212.onSameTaskSave();     // Catch: Throwable -> L98
    L21:
        monitor-exit(r100);     // Catch: Throwable -> L98
        return;
    L24:
        if (Logger.debugScene(r210) == false) goto L26;
        Logger.taskDebug(TAG, r210, "saveFileAsTargetName", "SaveTempFileStatusMap put id:" + r210.getId());     // Catch: Throwable -> L98
    L26:
        saveTempFileStatusMap.put(r210.getId(), r102);     // Catch: Throwable -> L98
        monitor-exit(r100);     // Catch: Throwable -> L98
        DownloadFile r105 = new DownloadFile(r210.getTempPath(), r210.getTempName());     // Catch: Throwable -> L101
        DownloadFile r106 = new DownloadFile(r210.getSavePath(), r210.getName());     // Catch: Throwable -> L101
        if (r210.isForce() == true) goto L65;
        if (DownloadFileUtils.existsAndNotEmpty(r106) == false) goto L65;
        if (DownloadUtils.checkFileLength(r210, r106) == false) goto L65;
        if (Logger.debugScene(r210) == false) goto L37;
        Logger.taskDebug(TAG, r210, "saveFileAsTargetName", "TargetFile exist");     // Catch: Throwable -> L101
    L37:
        long r110 = SystemClock.uptimeMillis();     // Catch: Throwable -> L101
        int r107 = DownloadUtils.checkMd5Status(r106, r210.getMd5());     // Catch: Throwable -> L101
        r210.setMd5Time(SystemClock.uptimeMillis() - r110);     // Catch: Throwable -> L101
        if (DownloadUtils.isMd5Valid(r107) == false) goto L48;
        if (Logger.debugScene(r210) == false) goto L42;
        Logger.taskDebug(TAG, r210, "saveFileAsTargetName", "TempFile not exist , targetFile exists and md5 check valid");     // Catch: Throwable -> L101
    L42:
        r210.setTTMd5CheckStatus(r107);     // Catch: Throwable -> L101
        if (r212 == null) goto L45;
        r212.onSuccess();     // Catch: Throwable -> L101
    L45:
        handleTempSaveCallback(r210.getId(), true, null);     // Catch: Throwable -> L101
    L46:
        boolean r108 = false;
    L63:
        boolean r109 = r108;
    L72:
        if (r109 == false) goto L112;
        int r111 = DownloadSetting.obtain(r210.getId()).optInt(DownloadSettingKeys.DOWNLOAD_FINISH_CHECK_TTMD5, 2);     // Catch: BaseException -> L86 Throwable -> L101
        if (r111 <= 0) goto L85;
        long r112 = SystemClock.uptimeMillis();     // Catch: BaseException -> L86 Throwable -> L101
        int r113 = DownloadUtils.checkMd5Status(r105, r210.getMd5());     // Catch: BaseException -> L86 Throwable -> L101
        r210.setMd5Time(SystemClock.uptimeMillis() - r112);     // Catch: BaseException -> L86 Throwable -> L101
        r210.setTTMd5CheckStatus(r113);     // Catch: BaseException -> L86 Throwable -> L101
        if (r111 < 2) goto L85;
        if (DownloadUtils.isMd5Valid(r113) == true) goto L85;
        BaseException r114 = new BaseException(1034, DownloadUtils.getMd5StatusMsg(r113));     // Catch: BaseException -> L86 Throwable -> L101
        if (r212 == null) goto L82;
        r212.onFailed(r114);     // Catch: BaseException -> L86 Throwable -> L101
    L82:
        handleTempSaveCallback(r210.getId(), false, r114);     // Catch: BaseException -> L86 Throwable -> L101
        DownloadUtils.deleteAllDownloadFiles(r210, DownloadDirUtils.isSavePathSecurity(r210.getSavePath()));     // Catch: BaseException -> L86 Throwable -> L101
        return;
    L85:
        boolean r115 = !moveFile(r105, r106);
        BaseException r116 = null;
    L88:
        if (r115 == false) goto L94;
        if (r116 != null) goto L91;
        r116 = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", new Object[]{r210.getTempPath(), r210.getTempName(), r210.getSavePath(), r210.getName()}));     // Catch: Throwable -> L101
    L91:
        if (r212 == null) goto L93;
        r212.onFailed(r116);     // Catch: Throwable -> L101
    L93:
        handleTempSaveCallback(r210.getId(), false, r116);     // Catch: Throwable -> L101
        return;
    L94:
        if (r212 == null) goto L96;
        r212.onSuccess();     // Catch: Throwable -> L101
    L96:
        handleTempSaveCallback(r210.getId(), true, null);     // Catch: Throwable -> L101
        return;
    L86:
        e = move-exception;
        r116 = e;
        r115 = true;
        goto L88
    L112:
        return;
    L48:
        if (r105.exists() == true) goto L53;
        BaseException r117 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", new Object[]{r210.getTempPath(), r210.getTempName(), r210.getSavePath(), r210.getName(), DownloadUtils.getMd5StatusMsg(r107)}));     // Catch: Throwable -> L101
        if (r212 == null) goto L52;
        r212.onFailed(r117);     // Catch: Throwable -> L101
    L52:
        handleTempSaveCallback(r210.getId(), false, r117);     // Catch: Throwable -> L101
        r108 = false;
    L55:
        if (r106.delete() == true) goto L63;
        if (r108 == true) goto L59;
        if (r211 == null) goto L63;
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r211, r210, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), r210.getStatus());     // Catch: Throwable -> L101
        goto L63
    L59:
        BaseException r118 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + DownloadUtils.getMd5StatusMsg(r107));     // Catch: Throwable -> L101
        if (r212 == null) goto L62;
        r212.onFailed(r118);     // Catch: Throwable -> L101
    L62:
        handleTempSaveCallback(r210.getId(), false, r118);     // Catch: Throwable -> L101
        goto L46
    L53:
        r108 = true;
    L65:
        if (r105.exists() == true) goto L71;
        BaseException r119 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", new Object[]{r210.getTempPath(), r210.getTempName(), r210.getSavePath(), r210.getName()}));     // Catch: Throwable -> L101
        if (r212 == null) goto L69;
        r212.onFailed(r119);     // Catch: Throwable -> L101
    L69:
        handleTempSaveCallback(r210.getId(), false, r119);     // Catch: Throwable -> L101
        r109 = false;
        goto L72
    L71:
        r109 = true;
        goto L72
    L11:
        r103 = false;
    L98:
        th = move-exception;
        throw th;     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        BaseException r120 = new BaseException(1038, DownloadUtils.getErrorMsgWithTagPrefix(th, "saveFileAsTargetName") + " " + Log.getStackTraceString(th));
        if (Logger.debugScene(r210) == false) goto L105;
        Logger.taskDebug(TAG, r210, "saveFileAsTargetName", "Error: " + r120);
    L105:
        if (r212 == null) goto L107;
        r212.onFailed(r120);
    L107:
        handleTempSaveCallback(r210.getId(), false, r120);
    }

    public static boolean copyFile(File r100, File r101, boolean r102) throws BaseException {
        return copyFile(new DownloadFile(r100), new DownloadFile(r101), r102);
    }

    public static List<HttpHeader> addRangeHeader(List<HttpHeader> r100, String r101, long r102, long r103) {
        ArrayList r104 = new ArrayList();
        if (r100 == null) goto L19;
        if (r100.size() <= 0) goto L19;
        Iterator<HttpHeader> r105 = r100.iterator();
    L8:
        if (r105.hasNext() == false) goto L19;
        HttpHeader r106 = r105.next();
        if (r106 == null) goto L8;
        if ("Accept-Encoding".equalsIgnoreCase(r106.getName()) == false) goto L17;
        if (GZIP.equalsIgnoreCase(r106.getValue()) == true) goto L8;
    L17:
        r104.add(r106);
    L19:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        r104.add(new HttpHeader(IF_MATCH, r101));
    L21:
        r104.add(new HttpHeader("Accept-Encoding", IDENTITY));
        if (r103 > 0) goto L24;
        String r107 = String.format(Locale.US, "bytes=%d-", new Object[]{Long.valueOf(r102)});
    L25:
        r104.add(new HttpHeader("Range", r107));
        if (Logger.debug() == false) goto L28;
        Logger.globalDebug(TAG, "addRangeHeader", "CurrentOffset:" + r102 + " EndOffset:" + r103 + ", range = " + r107);
    L28:
        return r104;
    L24:
        r107 = String.format(Locale.US, "bytes=%d-%d", new Object[]{Long.valueOf(r102), Long.valueOf(r103)});
        goto L25
    }

    public static RandomAccessOutputStream createOutputStream(DownloadInfo r100, String r101, String r110, int r111, boolean r112) throws BaseException {
        if (TextUtils.isEmpty(r101) == true) goto L60;
        if (TextUtils.isEmpty(r110) == true) goto L60;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, r110);
        boolean r103 = false;
        if (r102.exists() == false) goto L14;
        if (r102.isDirectory() == false) goto L14;
        throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", new Object[]{r101, Boolean.valueOf(r102.isDirectory())})));
    L14:
        if (r102.exists() == true) goto L58;
        PolarisFileWrapper r113 = new PolarisFileWrapper(r101);     // Catch: IOException -> L54
        if (r113.exists() == false) goto L20;
        if (r113.isDirectory() == false) goto L20;
    L45:
        r102.createNewFile();     // Catch: IOException -> L54
    L20:
        if (r113.exists() == false) goto L22;
        r113.delete();     // Catch: IOException -> L54
        if (r113.mkdirs() == true) goto L53;
        if (r113.exists() == true) goto L53;
        throw new BaseException(1031, "download savePath is not directory:path=" + r101);     // Catch: IOException -> L54
    L53:
        throw new BaseException(1031, "download savePath is not directory:" + r101);     // Catch: IOException -> L54
    L22:
        if (r113.mkdirs() == true) goto L45;
        if (r113.exists() == true) goto L45;
        if (DownloadSetting.obtain(r100).optInt(DownloadSettingKeys.OPT_MKDIR_FAILED, 0) != 1) goto L44;
        int r104 = 0;
    L29:
        if (r103 == true) goto L36;
        int r105 = r104 + 1;
        if (r104 >= 3) goto L36;
        Thread.sleep(10);     // Catch: InterruptedException -> L35 IOException -> L54
        r103 = r113.mkdirs();     // Catch: IOException -> L54
        r104 = r105;
    L36:
        if (r103 == true) goto L45;
        if (DownloadUtils.getAvailableSpaceBytes(r100.getSavePath()) >= 16384) goto L42;
        throw new BaseException(1006, "download savePath directory can not created:" + r101);     // Catch: IOException -> L54
    L42:
        throw new BaseException(1030, "download savePath directory can not created:" + r101);     // Catch: IOException -> L54
    L44:
        throw new BaseException(1030, "download savePath directory can not created:" + r101);     // Catch: IOException -> L54
    L54:
        e = move-exception;
        throw new BaseException(1036, e);
    L58:
        return new RandomAccessOutputStream(r102, r111, r112);
    L60:
        throw new BaseException(1021, new IOException("path must be not empty"));
    }

    public static boolean hitSkipDbInitScene(Set<String> r100, Set<String> r101, Set<String> r102, String r103, String r104) {
        if (r100 != null) goto L5;
    L9:
        if (r101 != null) goto L11;
    L16:
        return false;
    L11:
        if (r101.contains(r103) == true) goto L16;
        if (r102 != null) goto L14;
        return true;
    L14:
        if (r102.contains(r104) == true) goto L16;
        return true;
    L5:
        if (TextUtils.isEmpty(r104) == true) goto L9;
        if (r100.contains(r104) == false) goto L9;
        return true;
    }
}
