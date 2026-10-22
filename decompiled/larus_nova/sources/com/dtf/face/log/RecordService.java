package com.dtf.face.log;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import baseverify.d;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.api.IDTCrashCallback;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.config.AndroidDocConfig;
import com.dtf.face.config.Protocol;
import com.dtf.face.config.ProtocolContent;
import com.dtf.face.network.APICallback;
import com.dtf.face.utils.ClientConfigUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import hs7.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import ts7.c;
import ws7.f;
import ws7.i;

/* JADX INFO: loaded from: classes3.dex */
public class RecordService {
    public static String FILE_LOG_SUBPATH = null;
    public static String FILE_LOG_SUBPATH_CLOSE = null;
    public static String LOG_UPLOAD_COUNT_PATH = null;
    private static final int MAX_RECORD_COUNT = 10;
    public static boolean NEED_FILE_LOG;
    private static RecordService s_instance;
    private String bisToken;
    private Context ctx;
    private String currentLogFileName;
    private final Handler handler;
    private String initUUID;
    private boolean isInited;
    private boolean isZimEnd;
    private String logFilePath;
    private long logUploadInterval;
    private int logUploadRepeats;
    private Map<String, List<String>> logsMap;
    private String netType;
    private String ocrUUID;
    private String osVersion;
    private String phoneLanguage;
    private String phoneType;
    private String publicParam;
    private final Runnable rLogUpload;
    private String screenMetrix;
    private String sessionId;
    private String verifyUUID;
    private String zimId;

    public void resetUUID() {
        this.initUUID = null;
        this.verifyUUID = null;
        this.ocrUUID = null;
    }

    public void zimEnd() {
        flush(true);
        this.isZimEnd = true;
    }

    static {
        s_instance = new RecordService();
        NEED_FILE_LOG = false;
        FILE_LOG_SUBPATH = "/dtf_log/";
        FILE_LOG_SUBPATH_CLOSE = "/dtf_log_close/";
        LOG_UPLOAD_COUNT_PATH = "/dtf_log_count/";
    }

    private int getLogUploadTryCount() {
        File[] r100 = new PolarisFileWrapper(this.ctx.getCacheDir(), LOG_UPLOAD_COUNT_PATH).listFiles(new AnonymousClass2(this));
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length;
    }

    private void limitLogFileSize() {
        if (TextUtils.isEmpty(this.logFilePath) == true) goto L19;
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.logFilePath);
        if (r100.exists() == false) goto L24;
        ArrayList r101 = new ArrayList();
        String[] r102 = r100.list();
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r104 >= r103) goto L10;
        String r106 = r102[r104];
        r105 = (int) (((long) r105) + new PolarisFileWrapper(this.logFilePath, r106).length());
        r101.add(r106);
        r104 = r104 + 1;
        goto L7
    L10:
        if (r105 < 1048576) goto L25;
        Collections.sort(r101);
        Iterator r107 = r101.iterator();
    L13:
        if (r107.hasNext() == false) goto L27;
        String r108 = (String) r107.next();
        PolarisFileWrapper r109 = new PolarisFileWrapper(this.logFilePath, r108);
        if (r109.exists() == false) goto L18;
        int r110 = (int) (((long) r105) - r109.length());
        f.f(r109);
        r105 = r110;
    L18:
        if (r105 >= 524288) goto L13;
        return;
    L27:
        return;
    L25:
        return;
    L24:
        return;
    }

    private void logUploadCountIncrement() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.ctx.getCacheDir(), LOG_UPLOAD_COUNT_PATH);
        if (r100.exists() == true) goto L5;
        r100.mkdir();
    L5:
        new PolarisFileWrapper(r100.getAbsolutePath() + "/count_" + System.currentTimeMillis()).mkdir();
    }

    public String getSessionId() {
        if (TextUtils.isEmpty(this.sessionId) == false) goto L6;
        this.sessionId = UUID.randomUUID().toString().replace("-", "");
    L6:
        return this.sessionId;
    }

    public void initLogEnv() {
        final PolarisFileWrapper r100 = new PolarisFileWrapper(this.ctx.getCacheDir(), FILE_LOG_SUBPATH_CLOSE);
        final PolarisFileWrapper r101 = new PolarisFileWrapper(this.ctx.getCacheDir(), FILE_LOG_SUBPATH);
        if (NEED_FILE_LOG == false) goto L15;
        if (r101.exists() == true) goto L7;
    L8:
        c.d(new AnonymousClass4(this, r100, r101));
    L9:
        final PolarisFileWrapper r102 = new PolarisFileWrapper(this.ctx.getCacheDir(), LOG_UPLOAD_COUNT_PATH);
        if (r102.exists() == true) goto L12;
    L19:
        Pair r103 = new Pair(0, 0L);
        AndroidClientConfig r104 = a.h().c();
        if (r104 == null) goto L38;
        JSONObject r105 = r104.clientExtParams;
        if (r105 == null) goto L38;
        if (r105.containsKey("LOG_UPLOAD_TIMER") == false) goto L38;
        String r106 = r105.getString("LOG_UPLOAD_TIMER");
        if (TextUtils.isEmpty(r106) == true) goto L38;
        JSONObject r107 = JSON.parseObject(r106);     // Catch: Throwable -> L36
        if (r107 == null) goto L38;
        int r108 = r107.getInteger("repeats").intValue();     // Catch: Throwable -> L36
        long r109 = r107.getInteger(VideoThumbInfo.KEY_INTERVAL).intValue();     // Catch: Throwable -> L36
        if (r108 <= 0) goto L38;
        if (r109 <= 0) goto L38;
        r103 = new Pair(Integer.valueOf(r108), Long.valueOf(r109));     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        getInstance().recordEvent(4, "errMsg", new String[]{Log.getStackTraceString(th)});
    L38:
        this.logUploadRepeats = ((Integer) r103.first).intValue();
        long r110 = ((Long) r103.second).longValue() * 1000;
        this.logUploadInterval = r110;
        if (this.logUploadRepeats > 0) goto L41;
        return;
    L41:
        if (r110 <= 0) goto L47;
        this.handler.postDelayed(this.rLogUpload, r110);
        return;
    L47:
        return;
    L12:
        if (r102.isDirectory() == false) goto L19;
        c.d(new AnonymousClass5(this, r102));
        goto L19
    L7:
        if (r100.exists() == false) goto L9;
    L15:
        if (r100.exists() == true) goto L17;
    L18:
        c.d(new AnonymousClass6(this, r101, r100));
        goto L19
    L17:
        if (r101.exists() == false) goto L19;
        goto L18
    }

    public void initNeedFileLog() {
        c.d(new AnonymousClass3(this));
    }

    public void uploadHistoryFileLog() {
        c.d(new AnonymousClass8(this));
    }

    public RecordService() {
        this.publicParam = "JTdCJTdE";
        this.bisToken = "";
        this.isZimEnd = true;
        this.logsMap = new ConcurrentHashMap();
        this.currentLogFileName = "";
        this.isInited = false;
        this.logUploadInterval = 0;
        this.logUploadRepeats = 0;
        this.handler = new Handler(Looper.getMainLooper());
        this.rLogUpload = new AnonymousClass1(this);
    }

    public void reportLogs() {
        if (getLogUploadTryCount() >= 3) goto L6;
        uploadHistoryFileLog();
    L6:
        if (this.zimId != null) goto L9;
        tryUpload(this.logsMap.get(this.currentLogFileName), this.currentLogFileName, !NEED_FILE_LOG, false, null);
        return;
    }

    public void resetLogFilePath() {
        if (a.h().S.equals("ant") == false) goto L5;
        FILE_LOG_SUBPATH = "/dtf_log/";
        FILE_LOG_SUBPATH_CLOSE = "/dtf_log_close/";
        LOG_UPLOAD_COUNT_PATH = "/dtf_log_count/";
        return;
    L5:
        FILE_LOG_SUBPATH = "/aliyun_log/";
        FILE_LOG_SUBPATH_CLOSE = "/aliyun_log_close/";
        LOG_UPLOAD_COUNT_PATH = "/aliyun_log_count/";
    }

    public static RecordService getInstance() {
        return s_instance;
    }

    public static /* synthetic */ int access$000(RecordService r100) {
        return r100.logUploadRepeats;
    }

    public static /* synthetic */ int access$010(RecordService r100) {
        int r101 = r100.logUploadRepeats;
        r100.logUploadRepeats = r101 - 1;
        return r101;
    }

    public static /* synthetic */ Runnable access$100(RecordService r100) {
        return r100.rLogUpload;
    }

    public static /* synthetic */ long access$200(RecordService r100) {
        return r100.logUploadInterval;
    }

    public static /* synthetic */ Handler access$300(RecordService r100) {
        return r100.handler;
    }

    public static /* synthetic */ Context access$400(RecordService r100) {
        return r100.ctx;
    }

    public static /* synthetic */ String access$500(RecordService r100) {
        return r100.logFilePath;
    }

    public static /* synthetic */ void access$600(RecordService r100) {
        r100.limitLogFileSize();
    }

    public static /* synthetic */ void access$700(RecordService r100) {
        r100.logUploadCountIncrement();
    }

    public static /* synthetic */ String access$800(RecordService r100) {
        return r100.currentLogFileName;
    }

    public static /* synthetic */ Map access$900(RecordService r100) {
        return r100.logsMap;
    }

    public static String getStackTraceString(Throwable r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        int r101 = 0;
        Throwable r102 = r100;
    L6:
        if (r102 == null) goto L10;
        if (r101 >= 10) goto L10;
        r102 = r102.getCause();
        r101 = r101 + 1;
    L10:
        StringWriter r103 = new StringWriter();
        PrintWriter r104 = new PrintWriter(r103);
        r100.printStackTrace(r104);
        r104.flush();
        return r103.toString();
    }

    private void initPublicParam(String r100) {
        if (r100 == null) goto L4;
        JSONObject r101 = new JSONObject();
        r101.put2("packageName", r100);
        r101.put2("processId", String.valueOf(Process.myPid()));
        this.publicParam = i.a(r101.toJSONString());
    L5:
        this.phoneType = Build.FINGERPRINT;
        this.osVersion = String.valueOf(Build.VERSION.SDK_INT);
        Context r102 = this.ctx;
        String r103 = "";
        if (r102 != null) goto L8;
        String r104 = "";
    L9:
        this.screenMetrix = r104;
        Locale r105 = Locale.getDefault();
        if (r105 == null) goto L12;
        r103 = r105.getDisplayLanguage();
    L12:
        this.phoneLanguage = r103;
        return;
    L8:
        Resources r106 = r102.getResources();
        DisplayMetrics r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics());
        r104 = r107.widthPixels + "*" + r107.heightPixels;
        goto L9
    L4:
        this.publicParam = "JTdCJTdE";
        goto L5
    }

    private void saveLog(final String r100) {
        if (this.logsMap.containsKey(this.currentLogFileName) == false) goto L7;
        List<String> r101 = this.logsMap.get(this.currentLogFileName);
        if (r101 == null) goto L9;
        r101.add(r100);
    L9:
        if (NEED_FILE_LOG == false) goto L18;
        final PolarisFileWrapper r102 = new PolarisFileWrapper(this.logFilePath, this.currentLogFileName);
        monitor-enter(RecordService.class);
        c.d(new AnonymousClass9(this, r102, r100));     // Catch: Throwable -> L15
        monitor-exit(RecordService.class);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        return;
    L7:
        CopyOnWriteArrayList r103 = new CopyOnWriteArrayList();
        r103.add(r100);
        this.logsMap.put(this.currentLogFileName, r103);
        goto L9
    }

    private void uploadFileLogs(String r110) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.logFilePath, r110);
        ArrayList r101 = new ArrayList();
        if (r100.exists() == false) goto L33;
        PolarisFileReaderWrapper r102 = null;
        BufferedReader r103 = null;
        BufferedReader r104 = null;
        PolarisFileReaderWrapper r105 = null;
        PolarisFileReaderWrapper r106 = new PolarisFileReaderWrapper(r100);     // Catch: Throwable -> L21 Exception -> L28
        BufferedReader r107 = new BufferedReader(r106);     // Catch: Throwable -> L17 Exception -> L19
    L50:
        String r108 = r107.readLine();     // Catch: Throwable -> L14 Exception -> L16
        if (r108 == null) goto L12;
        r101.add(r108);     // Catch: Throwable -> L14 Exception -> L16
    L12:
        r106.close();     // Catch: Exception -> L43
        r107.close();     // Catch: Exception -> L43
    L16:
        r103 = r107;
    L14:
        th = th;
        r104 = r107;
    L18:
        BufferedReader r109 = r104;
        r102 = r106;
    L23:
        if (r102 != null) goto L44;
    L25:
        if (r109 == null) goto L27;
        r109.close();     // Catch: Exception -> L42
    L27:
        throw th;
    L44:
        r102.close();     // Catch: Exception -> L42
    L17:
        th = th;
    L20:
        BufferedReader r111 = r103;
        r105 = r106;
    L29:
        if (r105 == null) goto L31;
        r105.close();     // Catch: Exception -> L43
    L31:
        if (r111 == null) goto L33;
        r111.close();     // Catch: Exception -> L43
        goto L33
    L28:
        r111 = null;
    L21:
        th = th;
        r109 = null;
    L33:
        int r112 = 0;
    L35:
        if (r112 >= r101.size()) goto L41;
        int r113 = r112 + 10;
        if (r113 >= r101.size()) goto L39;
        List<String> r114 = r101.subList(r112, r113);
    L40:
        tryUpload(r114, r110, true, true, null);
        r112 = r113;
        goto L35
    L39:
        r114 = r101.subList(r112, r101.size());
        goto L40
    }

    public void flush(boolean r100) {
        monitor-enter(RecordService.class);
        if (r100 == true) goto L12;
    L6:
        tryUpload(this.logsMap.get(this.currentLogFileName), this.currentLogFileName, true, false, null);     // Catch: Throwable -> L9
        monitor-exit(RecordService.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        resetUUID();     // Catch: Throwable -> L9
        this.handler.removeCallbacks(this.rLogUpload);     // Catch: Throwable -> L9
        this.logUploadRepeats = 0;     // Catch: Throwable -> L9
        goto L6
    }

    public void recordEventCustomZimId(String r100) {
        recordEventEx(4, r100, "customZimId", new String[0]);
    }

    public void recordException(Throwable r100) {
        RecordService r101 = getInstance();
        String[] r102 = new String[4];
        r102[0] = com.bytedance.android.ec.core.event.a.KEY_EXCEPTION;
        r102[1] = getStackTraceString(r100);
        r102[2] = "errMsg";
        if (r100 != null) goto L5;
    L7:
        String r103 = "Null";
    L8:
        r102[3] = r103;
        r101.recordEvent(4, "FaceVerify", r102);
        return;
    L5:
        if (TextUtils.isEmpty(r100.getMessage()) == true) goto L7;
        r103 = r100.getMessage();
        goto L8
    }

    public void reportCrash(IDTCrashCallback r100) {
        monitor-enter(RecordService.class);
        tryUpload(this.logsMap.get(this.currentLogFileName), this.currentLogFileName, true, false, r100);     // Catch: Throwable -> L7
        monitor-exit(RecordService.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setInitUUID(String r100) {
        this.initUUID = r100;
    }

    public void setOcrUUID(String r100) {
        if (this.ocrUUID != null) goto L5;
        this.ocrUUID = r100;
        return;
    L5:
        this.ocrUUID += "#";
        this.ocrUUID += r100;
    }

    public void setVerifyUUID(String r100) {
        this.verifyUUID = r100;
    }

    public static /* synthetic */ void access$1000(RecordService r100, String r101) {
        r100.uploadFileLogs(r101);
    }

    public static /* synthetic */ String access$502(RecordService r100, String r101) {
        r100.logFilePath = r101;
        return r101;
    }

    public void init(Context r100, String r101) {
        this.ctx = r100;
        this.zimId = r101;
        this.sessionId = getSessionId();
        StringBuilder r102 = new StringBuilder();
        String r103 = "None";
        if (r100 == null) goto L33;
        ConnectivityManager r104 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r104 == null) goto L33;
        NetworkInfo r105 = r104.getActiveNetworkInfo();
        if (r105 == null) goto L33;
        if (r105.isAvailable() == false) goto L33;
        NetworkInfo r106 = r104.getNetworkInfo(1);
        if (r106 == null) goto L22;
        NetworkInfo.State r107 = r106.getState();
        if (r107 == null) goto L22;
        if (r107 != NetworkInfo.State.CONNECTED) goto L20;
    L21:
        r103 = "WIFI";
        goto L33
    L20:
        if (r107 == NetworkInfo.State.CONNECTING) goto L21;
    L22:
        TelephonyManager r108 = (TelephonyManager) r100.getSystemService("phone");
        if (r108 != null) goto L47;
    L27:
        int r109 = 0;
    L28:
        switch(r109) {
            case 1: goto L32;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L32;
            case 8: goto L31;
            case 9: goto L31;
            case 10: goto L31;
            case 11: goto L32;
            case 12: goto L31;
            case 13: goto L30;
            case 14: goto L31;
            case 15: goto L31;
            default: goto L29;
        };
    L29:
        r103 = "Mobile";
        goto L33
    L30:
        r103 = "4G";
        goto L33
    L31:
        r103 = "3G";
        goto L33
    L32:
        r103 = "2G";
        goto L33
    L47:
        r109 = r108.getNetworkType();     // Catch: Throwable -> L26
    L33:
        r102.append(r103);
        r102.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        String r110 = "";
        if (r100 == null) goto L39;
        TelephonyManager r111 = (TelephonyManager) r100.getSystemService("phone");
        if (r111 == null) goto L39;
        r110 = r111.getSimOperatorName();     // Catch: Exception -> L44
    L39:
        r102.append(r110);
        this.netType = r102.toString();
        if (r101 == null) goto L42;
        this.isZimEnd = false;
    L42:
        resetUUID();
    }

    public void initSDK(Context r100, String r101) {
        this.ctx = r100;
        initPublicParam(r101);
        initNeedFileLog();
        this.currentLogFileName = Long.toString(System.currentTimeMillis());
        init(r100, null);
        this.isInited = true;
    }

    public void recordDTEvent(String r100, String... r101) {
        recordEvent(4, r100, r101);
    }

    public void recordEvent(int r100, String r101, String... r102) {
        monitor-enter(RecordService.class);
        recordEventEx(r100, null, r101, r102);     // Catch: Throwable -> L8
        monitor-exit(RecordService.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void recordEventEx(int r100, String r101, String r102, String... r110) {
        if (r100 >= ClientConfigUtil.d()) goto L5;
        return;
    L5:
        EventRecord r103 = new EventRecord();
        r103.setLogLevel(String.valueOf(r100));
        r103.setActionName(r102);
        r103.setSessionId(this.sessionId);
        r103.setPhoneType(this.phoneType);
        r103.setOsVersion(this.osVersion);
        r103.setNetType(this.netType);
        r103.setLanguage(this.phoneLanguage);
        r103.setScreenMetrix(this.screenMetrix);
        if (r101 != null) goto L10;
        r101 = this.zimId;
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        r101 = this.sessionId;
    L12:
        r103.setExtParam1(r101);
        r103.setExtParma2("0");
        r103.setExtParam3("0");
        HashMap r104 = new HashMap();
        if (r110 != null) goto L15;
    L30:
        r104.put("logType", "BI_C_V1");
        r104.put("publicParam", this.publicParam);
        r104.put("zimId", r101);
        r104.put("uiVersion", "992");
        r104.put("uploadLog", "true");
        r104.put("productName", "faceverfy");
        r104.put("logPlanId", "DTF_FACE_LOGPLAN_V1");
        r104.put("logModelVersion", "V1.0");
        r104.put("zid", UserProfileEvent.POSITION_NONE);
        if (TextUtils.isEmpty(this.bisToken) == false) goto L48;
        AndroidClientConfig r105 = a.h().c();
        Protocol r111 = a.h().f486994f;
        if (r111 == null) goto L37;
        ProtocolContent r112 = r111.protocolContent;
        if (r112 == null) goto L37;
        AndroidDocConfig r113 = r112.docConfig;
    L38:
        if (r105 == null) goto L43;
        String r106 = r105.token;
        if (r106 == null) goto L43;
        this.bisToken = r106;
    L43:
        if (TextUtils.isEmpty(this.bisToken) == false) goto L48;
        if (r113 == null) goto L48;
        String r107 = r113.token;
        if (r107 == null) goto L48;
        this.bisToken = r107;
    L37:
        r113 = null;
    L48:
        r104.put("bistoken", this.bisToken);
        r104.put("bioType", "facedetect");
        r104.put("keepUploadPage", "1");
        r104.put("sceneId", "DtfID+Dtf+certify+face");
        StringBuilder r108 = new StringBuilder();
        Iterator r109 = r104.entrySet().iterator();
    L50:
        if (r109.hasNext() == false) goto L52;
        Map.Entry r114 = (Map.Entry) r109.next();
        String r115 = (String) r114.getKey();
        String r116 = (String) r114.getValue();
        r108.append(r115);
        r108.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r108.append(r116);
        r108.append("^");
        goto L50
    L52:
        String r117 = r108.toString();
        if (r117.endsWith("^") == false) goto L55;
        r117 = r117.substring(0, r117.length() - 1);
    L55:
        r103.setExtParam4(r117);
        saveLog(r103.toString());
        tryUpload(this.logsMap.get(this.currentLogFileName), this.currentLogFileName, this.isZimEnd, false, null);
        return;
    L15:
        if ((r110.length % 2) != 0) goto L30;
        JSONObject r118 = new JSONObject();
        int r119 = 0;
    L18:
        if (r119 >= (r110.length - 1)) goto L20;
        r118.put2(r110[r119], r110[r119 + 1]);
        r119 = r119 + 2;
        goto L18
    L20:
        String r120 = this.initUUID;
        if (r120 == null) goto L23;
        r118.put2("initTraceID", r120);
    L23:
        String r121 = this.ocrUUID;
        if (r121 == null) goto L26;
        r118.put2("ocrTraceID", r121);
    L26:
        String r122 = this.verifyUUID;
        if (r122 == null) goto L29;
        r118.put2("verifyTraceID", r122);
    L29:
        r104.put("extParam", i.a(r118.toJSONString()));
        goto L30
    }

    private void tryUpload(List<String> r100, String r101, boolean r102, boolean r103, final IDTCrashCallback r104) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() >= 10) goto L8;
        if (r102 == true) goto L8;
        return;
    L8:
        if (r100.size() > 0) goto L10;
        return;
    L10:
        Map<String, Object> r105 = d.a(r100, r101, new AnonymousClass7(this, r104));
        ls7.a.f().c(r105, (APICallback) ((HashMap) r105).get("callback"));
        if (r103 == true) goto L13;
        this.currentLogFileName = Long.toString(System.currentTimeMillis());
    L13:
        this.logsMap.remove(r101);
    }
}
