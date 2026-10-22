package com.bytedance.apm;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import as3.b;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.util.g;
import com.bytedance.crash.util.a;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.larus.network.NetQualityManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import ss3.e;
import ss3.f;
import ss3.i;
import vr3.j;
import vr3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ApmAgent {
    private static final long CHECK_DISK_INTERVAL_MS = 3600000;
    private static final long CHILD_PROC_MAP_FILE_SIZE = 262144;
    public static boolean FAST_MODE = false;
    private static final String KEY_DEBUG_UUID = "_debug_uuid";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final long MAIN_PROC_MAP_FILE_SIZE = 2097152;
    private static final long MAX_LOGS_SIZE = 1073741824;
    public static final String MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE = "nothing to do, implementation code has been removed in version 5+";
    private static final long REMAINING_ROM_THRESHOLD = 1073741824;
    public static final String TAG_DEPRECATED = "Deprecated";
    private static final int WEED_OUT_FILE_NUM = 60;
    static AtomicLong atomicLong = null;
    public static boolean sDeepCopy = false;
    private static long sLastCheckDiskTime = -1;
    private static MappedByteBuffer sMappedByteBuffer;
    private static File sProcessLogsFolder;

    public ApmAgent() {
    }

    public static void addBlockFilter(Map<String, String> r0) {
    }

    public static void addFpsFilter(Map<String, String> r0) {
    }

    public static void monitorCommonLog(String r0, JSONObject r1) {
        com_bytedance_apm_ApmAgent_com_larus_home_impl_utils_CommonHook_monitorCommonLog(r0, r1);
    }

    public static void monitorEvent(String r0, JSONObject r1, JSONObject r2, JSONObject r3) {
        com_bytedance_apm_ApmAgent_com_larus_home_impl_utils_CommonHook_monitorEvent(r0, r1, r2, r3);
    }

    public static void monitorImageSample(String r0, int r1, String r2, long r3, JSONObject r5) {
    }

    public static void reportLegacyMonitorLog(Context r0, long r1, long r3, boolean r5) {
    }

    static {
        atomicLong = new AtomicLong(0);
    }

    private static JSONObject getCapacity() {
        JSONObject r0 = new JSONObject();
        r0.put("battery_percent", ykc.c.b(d.getContext()));     // Catch: JSONException -> L9
        JSONObject r1 = b.a.a.f();     // Catch: JSONException -> L9
        if (r1.length() != 0) goto L7;
        r0.put("more", "no-more-info");     // Catch: JSONException -> L9
    L12:
    L11:
        return r0;
    L7:
        r0.put("more", r1);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private static JSONObject getGalvanicNow() {
        JSONObject r0 = new JSONObject();
        r0.put("battery_current", ykc.c.c(d.getContext()));     // Catch: JSONException -> L5
        r0.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static boolean isConfigReady() {
        return ApmDelegate.g.a.f;
    }

    private static void reportFeedbackInfo() {
        i r0 = i.a.a;     // Catch: JSONException -> L21
        if (r0.c == false) goto L5;
    L7:
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L21
        JSONObject r2 = f.a().b(true);     // Catch: JSONException -> L21
        r2.put("crash_section", d.i(System.currentTimeMillis()));     // Catch: JSONException -> L21
        r2.put("crash_type", "feedback");     // Catch: JSONException -> L21
        JSONObject r3 = com.bytedance.monitor.collector.c.e().b();     // Catch: JSONException -> L21
        Callable r5 = a.a;     // Catch: JSONException -> L21
        if (r5 != null) goto L27;
    L12:
        JSONArray r6 = null;
    L13:
        r3.put("activity_track", r6);     // Catch: JSONException -> L21
        e.b().getClass();     // Catch: JSONException -> L21
        r3.put("cpu_info", e.a());     // Catch: JSONException -> L21
        r3.put("memory_info", getMemInfo(ss3.c.a(d.getContext())));     // Catch: JSONException -> L21
        r3.put("temperature", i.a.a.d);     // Catch: JSONException -> L21
        String r4 = MethodCollector.getInstance().getEvilMethod(0, SystemClock.uptimeMillis());     // Catch: JSONException -> L21
        if (TextUtils.isEmpty(r4) == true) goto L16;
        r3.put("evil_method", r4);     // Catch: JSONException -> L21
        r2.put("with_evil_method", "true");     // Catch: JSONException -> L21
    L16:
        com.bytedance.monitor.collector.c r7 = com.bytedance.monitor.collector.c.e();     // Catch: JSONException -> L21
        SystemClock.uptimeMillis();     // Catch: JSONException -> L21
        r7.getClass();     // Catch: JSONException -> L21
        if (TextUtils.isEmpty(null) == false) goto L20;
        r3.put("battery", getCapacity());     // Catch: JSONException -> L21
        r3.put("battery_current", getGalvanicNow());     // Catch: JSONException -> L21
        r1.put("custom", r3);     // Catch: JSONException -> L21
        r1.put("filters", r2);     // Catch: JSONException -> L21
        r1.put("stack", "at feedback.*(a.java:-1)");     // Catch: JSONException -> L21
        r1.put("event_type", "serious_lag");     // Catch: JSONException -> L21
        js3.c r8 = new js3.c("serious_block_monitor", r1);     // Catch: JSONException -> L21
        r8.c = true;     // Catch: JSONException -> L21
        is3.a.h().b(r8);     // Catch: JSONException -> L21
        return;
    L20:
        throw null;
    L27:
        r6 = (JSONArray) r5.call();     // Catch: Throwable -> L24
    L5:
        if (d.getContext() == null) goto L7;
        r0.b();     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    }

    private static void weedOutOldestLogFiles() {
        if (d.k() == true) goto L6;
        return;
    L6:
        if (sProcessLogsFolder.exists() == true) goto L8;
        return;
    L8:
        File[] r0 = sProcessLogsFolder.listFiles();
        Arrays.sort(r0, new a0());
        int r2 = 60;
        if (r0.length > 60) goto L12;
        r2 = r0.length;
    L12:
        int r1 = 0;
    L13:
        if (r1 >= r2) goto L15;
        r0[r1].delete();
        r1 = r1 + 1;
        goto L13
    }

    public static void addBatteryDataListener(i0 r2) {
        j r0 = j.b.a;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r0.n != null) goto L8;
        r0.n = new ArrayList();
    L8:
        ((ArrayList) r0.n).add(r2);
    }

    private static void addDebugMessage(JSONObject r6) {
        if (r6 != null) goto L7;
        return;
    L7:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
        r0.put(KEY_DEBUG_UUID, d.h() + "_" + atomicLong.getAndAdd(1));     // Catch: Exception -> L6
        r6.put(KEY_SELF_DEBUG_MESSAGE, r0);     // Catch: Exception -> L6
        return;
    }

    public static void configSceneMinDuration(HashMap<String, Long> r1) {
        k.a.a.k.putAll(r1);
    }

    private static JSONObject getExtraLog(JSONObject r3) {
        if (r3 != null) goto L5;
        r3 = new JSONObject();
    L5:
        if (r3.isNull("timestamp") == true) goto L11;
    L10:
        return r3;
    L11:
        r3.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static boolean getLogTypeSwitch(String r1) {
        return ApmDelegate.g.a.b(r1);
    }

    private static JSONObject getMemInfo(ts3.b r4) throws JSONException {
        JSONObject r0 = new JSONObject();
        r0.put("javaTotalMemory", r4.a);
        r0.put("javaFreeMemory", r4.b);
        r0.put("javaUsedMemory", r4.c);
        r0.put("pssDalvik", r4.d);
        r0.put("pssNative", r4.e);
        r0.put("pssTotal", r4.f);
        r0.put("graphics", r4.g);
        r0.put("vmSize", r4.h);
        return r0;
    }

    public static boolean getMetricsSwitch(String r2) {
        ApmDelegate r0 = ApmDelegate.g.a;
        if (r0.f == false) goto L8;
        SlardarConfigManagerImpl r1 = r0.e;
        if (r1 == null) goto L8;
        return r1.getMetricTypeSwitch(r2);
    L8:
        return false;
    }

    public static boolean getServiceSwitch(String r2) {
        ApmDelegate r0 = ApmDelegate.g.a;
        if (r0.f == false) goto L8;
        SlardarConfigManagerImpl r1 = r0.e;
        if (r1 == null) goto L8;
        return r1.getServiceSwitch(r2);
    L8:
        return false;
    }

    public static void monitorEvent(com.bytedance.apm.config.d r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (jt3.a.g(r5.a, Boolean.TRUE) == false) goto L8;
        notifyNotSampled(r5.a, null);
        return;
    L8:
        JSONObject r0 = getExtraLog(r5.e);
        addDebugMessage(r0);
        bt3.b.d.a.e(new a(r5, r0));
        if (d.c == false) goto L12;
        JSONObject r1 = optDeepCopyJson(r5.c, true);
        JSONObject r3 = optDeepCopyJson(r5.d, true);
        JSONObject r2 = optDeepCopyJson(r0, true);
        bt3.c.a().b(new b(r5, r1, r3, r2));
        return;
    }

    private static JSONObject optShallowCopyJson(JSONObject r1) {
        if (FAST_MODE == false) goto L6;
        return com.bytedance.apm.util.j.g(r1);
    L6:
        return preProcessExtJson2(r1);
    }

    private static JSONObject preProcessExtJson(JSONObject r5) {
        JSONObject r1 = null;
        if (r5 != null) goto L19;
    L12:
        if (r1 != null) goto L15;
        r1 = new JSONObject();     // Catch: Exception -> L18
    L15:
        if (r1.isNull("timestamp") == false) goto L17;
        r1.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L18
    L18:
        return r5;
    L17:
        return r1;
    L19:
        Iterator<String> r2 = r5.keys();     // Catch: Exception -> L18
        if (r2 == null) goto L12;
        r1 = new JSONObject();     // Catch: Exception -> L18
    L10:
        if (r2.hasNext() == false) goto L12;
        String r3 = r2.next();     // Catch: Exception -> L18
        r1.put(r3, r5.opt(r3));     // Catch: Exception -> L18
        goto L10
    }

    private static JSONObject preProcessExtJson2(JSONObject r3) {
        if (r3 != null) goto L6;
        r3 = new JSONObject();     // Catch: Exception -> L9
    L8:
        return r3;
    L6:
        if (r3.isNull("timestamp") == false) goto L8;
        r3.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        goto L8
    }

    public static int reportThreadCount(String r1) {
        return ss3.j.j(r1, true);
    L5:
        return 0;
    }

    public static void setReportMode(com.bytedance.apm.config.c r0) {
        ApmDelegate.g.a.getClass();
    }

    public static void startBatteryCollect(String r3) {
        if (d.getContext() == null) goto L17;
        Object r0 = vr3.b.C;
        vr3.b r1 = vr3.b.e.a;
        if (((ConcurrentHashMap) r1.g).isEmpty() == true) goto L18;
        if (r3 == null) goto L19;
        List r2 = r1.n;
        if (r2 != null) goto L11;
    L15:
        bt3.b.d.a.b(new vr3.c(r1, r3));
        return;
    L11:
        if (((ArrayList) r2).isEmpty() == true) goto L15;
        if (((ArrayList) r1.n).contains(r3) == false) goto L15;
        return;
    L19:
        return;
    L18:
        return;
    }

    public static void startCollectCurrent(String r2) {
        if (d.getContext() == null) goto L6;
        bt3.b.d.a.e(new u(r2));
        return;
    }

    public static void startCpuMonitor(String r2) {
        if (d.getContext() == null) goto L6;
        bt3.b.d.a.e(new x(r2));
        return;
    }

    public static void startScene(String r1) {
        f.a().a.add(r1);
        ou3.a.a().a.add(r1);
    }

    public static void startTrafficStats(String r4) {
        String r0 = ws3.k.x;
        ws3.k r1 = ws3.k.a.a;
        monitor-enter(r1);
        bt3.b.d.a.e(new ws3.i(r1, r4, false));     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void stopBatteryCollect(String r3) {
        if (d.getContext() == null) goto L17;
        Object r0 = vr3.b.C;
        vr3.b r1 = vr3.b.e.a;
        if (((ConcurrentHashMap) r1.g).isEmpty() == true) goto L18;
        if (r3 == null) goto L19;
        List r2 = r1.n;
        if (r2 != null) goto L11;
    L15:
        bt3.b.d.a.b(new vr3.d(r1, r3));
        return;
    L11:
        if (((ArrayList) r2).isEmpty() == true) goto L15;
        if (((ArrayList) r1.n).contains(r3) == false) goto L15;
        return;
    L19:
        return;
    L18:
        return;
    }

    public static void stopCollectCurrent(String r2) {
        if (d.getContext() == null) goto L6;
        bt3.b.d.a.e(new w(r2));
        return;
    }

    public static void stopCpuMonitor(String r2) {
        if (d.getContext() == null) goto L6;
        bt3.b.d.a.e(new y(r2));
        return;
    }

    public static void stopScene(String r1) {
        f.a().a.remove(r1);
        ou3.a.a().a.remove(r1);
    }

    public static void stopTrafficStats(String r3) {
        String r0 = ws3.k.x;
        ws3.k r1 = ws3.k.a.a;
        monitor-enter(r1);
        bt3.b.d.a.e(new ws3.j(r1, r3));     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ JSONObject access$000(JSONObject r0, boolean r1) {
        return optDeepCopyJson(r0, r1);
    }

    public static void addPerfTag(String r1, String r2) {
        f.a().b.put(r1, r2);
        ou3.a.a().b.put(r1, r2);
    }

    public static void com_bytedance_apm_ApmAgent__monitorCommonLog$___twin___(String r1, JSONObject r2) {
        monitorCommonLog(r1, r2, false);
    }

    public static void com_bytedance_apm_ApmAgent_com_larus_home_impl_utils_CommonHook_monitorCommonLog(String r2, JSONObject r3) {
        if (r3 != null) goto L7;
    L4:
        com_bytedance_apm_ApmAgent__monitorCommonLog$___twin___(r2, r3);
        return;
    L7:
        NetQualityManager.NetworkStatus r1 = NetQualityManager.a;     // Catch: JSONException -> L6
        r3.put("network_quality", NetQualityManager.a.getValue());     // Catch: JSONException -> L6
        goto L4
    }

    public static void monitorExceptionLog(String r2, JSONObject r3) {
        JSONObject r4 = preProcessExtJson2(r3);
        bt3.b.d.a.e(new j(r2, r4));
        if (d.c == false) goto L6;
        bt3.c.a().b(new l(r2, r4));
        return;
    }

    public static void monitorPageLoad(JSONObject r2, JSONObject r3) {
        monitorPerformance("page_load", "page_load", r2, r3, null);     // Catch: Exception -> L5
        return;
    }

    private static void notifyNotSampled(String r1, JSONObject r2) {
        if (d.j() == false) goto L8;
        if (r2 != null) goto L6;
        r2 = new JSONObject();
    L6:
        ls3.a.a(r1, r2, false);
        return;
    }

    private static JSONObject optDeepCopyJson(JSONObject r1, boolean r2) {
        if (FAST_MODE == true) goto L8;
        if (r1 != null) goto L12;
        return null;
    L12:
        return new JSONObject(r1.toString());
    L17:
        return r1;
    L8:
        if (r2 == true) goto L10;
        return r1;
    L10:
        return com.bytedance.apm.util.j.g(r1);
    }

    public static void removePerfTag(String r1, String r2) {
        f.a().b.remove(r1, r2);
        ou3.a.a().b.remove(r1, r2);
    }

    public static void startTrafficStats(String r3, boolean r4) {
        String r0 = ws3.k.x;
        ws3.k r1 = ws3.k.a.a;
        monitor-enter(r1);
        bt3.b.d.a.e(new ws3.i(r1, r3, r4));     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void storeLogBypass(String r18, String r19) {
        monitor-enter(ApmAgent.class);     // Catch: Throwable -> L40
        String r0 = d.c();     // Catch: Throwable -> L36
        long r2 = ThreadMethodProxy.currentThread().getId();     // Catch: Throwable -> L36
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L36
        String r6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));     // Catch: Throwable -> L36
        StringBuffer r7 = new StringBuffer();     // Catch: Throwable -> L36
        r7.append(r18);     // Catch: Throwable -> L36
        r7.append("#");     // Catch: Throwable -> L36
        r7.append(r2);     // Catch: Throwable -> L36
        r7.append("#");     // Catch: Throwable -> L36
        r7.append(r4);     // Catch: Throwable -> L36
        r7.append("#");     // Catch: Throwable -> L36
        r7.append(r6);     // Catch: Throwable -> L36
        r7.append("\n");     // Catch: Throwable -> L36
        r7.append(r19);     // Catch: Throwable -> L36
        r7.append("\n");     // Catch: Throwable -> L36
        byte[] r3 = r7.toString().getBytes("UTF-8");     // Catch: Throwable -> L36
        String r5 = d.getContext().getExternalFilesDir(null).getAbsolutePath();     // Catch: Throwable -> L36
        if (sMappedByteBuffer != null) goto L18;
        PolarisFileWrapper r8 = new PolarisFileWrapper(r5 + "/logs");     // Catch: Throwable -> L36
        sProcessLogsFolder = new PolarisFileWrapper(r5 + "/logs/proc: " + r0);     // Catch: Throwable -> L36
        PolarisFileWrapper r9 = new PolarisFileWrapper(r5 + "/logs/proc: " + r0 + "/" + r6);     // Catch: Throwable -> L36
        if (r8.exists() == true) goto L10;
        r8.mkdirs();     // Catch: Throwable -> L36
    L10:
        if (sProcessLogsFolder.exists() == true) goto L12;
        sProcessLogsFolder.mkdirs();     // Catch: Throwable -> L36
    L12:
        r9.createNewFile();     // Catch: Throwable -> L36
        FileChannel r12 = new RandomAccessFile(r9, "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r13 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (d.k() == false) goto L15;
        long r16 = 2097152;
    L16:
        sMappedByteBuffer = r12.map(r13, 0, r16);     // Catch: Throwable -> L36
        goto L18
    L15:
        r16 = 262144;
    L18:
        if (sMappedByteBuffer.remaining() >= r3.length) goto L24;
        sMappedByteBuffer.force();     // Catch: Throwable -> L36
        FileChannel r11 = new RandomAccessFile(new PolarisFileWrapper(r5 + "/logs/proc: " + r0 + "/" + r6), "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r14 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (d.k() == false) goto L22;
        long r15 = 2097152;
    L23:
        sMappedByteBuffer = r11.map(r14, 0, r15);     // Catch: Throwable -> L36
        goto L24
    L22:
        r15 = 262144;
    L24:
        sMappedByteBuffer.put(r3);     // Catch: Throwable -> L36
        if (sLastCheckDiskTime == (-1)) goto L29;
        if ((System.currentTimeMillis() - sLastCheckDiskTime) > CHECK_DISK_INTERVAL_MS) goto L29;
    L34:
        monitor-exit(ApmAgent.class);     // Catch: Throwable -> L36
        goto L45
    L39:
        return;
    L29:
        if (g.e(sProcessLogsFolder) <= 1073741824) goto L31;
    L32:
        weedOutOldestLogFiles();     // Catch: Throwable -> L36
    L33:
        sLastCheckDiskTime = System.currentTimeMillis();     // Catch: Throwable -> L36
        goto L34
    L31:
        if (g.c(d.getContext()).getFreeSpace() >= 1073741824) goto L33;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    }

    public static void uploadMappingFile(String r9, ff7.e r10) {
        String r2 = d.g.optString("aid");
        String r3 = d.g.optString("update_version_code");
        String r4 = d.g.optString("channel");
        String r5 = d.g.optString("release_build");
        String r7 = d.g.optString("device_id");
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L13:
        if (r10 == null) goto L16;
        r10.onFail("Missing required parameters");
        return;
    L16:
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (TextUtils.isEmpty(r4) == true) goto L13;
        if (TextUtils.isEmpty(r5) == true) goto L13;
        xs3.a.d(r2, r3, r4, r5, r9, r7, r10);
    }

    public static void feedbackReport(long r8, long r10, boolean r12) {
        bt3.b.d.a.e(new z(r8, r10, r12));
    }

    public static void monitorCommonLog(String r2, JSONObject r3, boolean r4) {
        if (jt3.a.g(r2, Boolean.FALSE) == false) goto L6;
        notifyNotSampled(r2, r3);
        return;
    L6:
        JSONObject r5 = preProcessExtJson2(r3);
        addDebugMessage(r5);
        bt3.b.d.a.e(new m(r2, r5));
        if (d.c == false) goto L10;
        JSONObject r6 = optDeepCopyJson(r5, true);
        bt3.c.a().b(new n(r2, r6, r4));
        return;
    }

    public static void monitorDirectOnTimer(String r2, String r3, float r4) {
        bt3.b.d.a.e(new s(r2, r3, r4));
        if (d.c == false) goto L6;
        bt3.c.a().b(new t(r2, r3, r4));
        return;
    }

    public static void monitorDuration(String r8, JSONObject r9, JSONObject r10) {
        if (jt3.a.g(r8, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r8, r9);
        return;
    L6:
        JSONObject r11 = preProcessExtJson2(r10);
        addDebugMessage(r11);
        if (sDeepCopy == false) goto L19;
        if (r9 == null) goto L12;
        Iterator<String> r0 = r9.keys();
        if (r0 == null) goto L12;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L24
    L15:
        if (r0.hasNext() == false) goto L18;
        String r2 = r0.next();     // Catch: Exception -> L24
        r1.put(r2, r9.opt(r2));     // Catch: Exception -> L24
    L18:
        JSONObject r4 = r1;
    L20:
        jt3.a.d(new lt3.a(r8, 0, r4, null, null, r11));
        if (d.c == false) goto L29;
        bt3.c.a().b(new f(r8, optDeepCopyJson(r9, true), optDeepCopyJson(r11, true)));
        return;
    L29:
        return;
    L12:
        r4 = null;
    L19:
        r4 = r9;
        goto L20
    }

    public static void monitorStatusRate(String r2, int r3, JSONObject r4) {
        if (jt3.a.g(r2, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r2, r4);
        return;
    L6:
        JSONObject r5 = preProcessExtJson2(r4);
        addDebugMessage(r5);
        jt3.a.e(r2, r3, null, null, r5);
        if (d.c == false) goto L10;
        JSONObject r6 = optDeepCopyJson(r5, true);
        bt3.c.a().b(new e(r2, r3, r6));
        return;
    }

    public static void monitorUIAction(String r1, String r2, JSONObject r3) {
        monitorUIAction(r1, r2, r3, null);
    }

    public static void activeUploadAlog(long r7, long r9, String r11, IALogActiveUploadObserver r12) {
        activeUploadAlog(XmlPullParser.NO_NAMESPACE, r7, r9, r11, r12);
    }

    public static void com_bytedance_apm_ApmAgent__monitorEvent$___twin___(String r4, JSONObject r5, JSONObject r6, JSONObject r7) {
        if (jt3.a.g(r4, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r4, r5);
        return;
    L6:
        JSONObject r8 = preProcessExtJson2(r7);
        addDebugMessage(r8);
        jt3.a.e(r4, 0, optDeepCopyJson(r5, true), optDeepCopyJson(r6, true), r8);
        if (d.c == false) goto L10;
        JSONObject r9 = optDeepCopyJson(r5, true);
        JSONObject r10 = optDeepCopyJson(r6, true);
        JSONObject r11 = optDeepCopyJson(r8, true);
        bt3.c.a().b(new h0(r4, r9, r10, r11));
        return;
    }

    public static void com_bytedance_apm_ApmAgent_com_larus_home_impl_utils_CommonHook_monitorEvent(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        if (r3 != null) goto L7;
    L4:
        com_bytedance_apm_ApmAgent__monitorEvent$___twin___(r2, r3, r4, r5);
        return;
    L7:
        NetQualityManager.NetworkStatus r1 = NetQualityManager.a;     // Catch: JSONException -> L6
        r3.put("network_quality", NetQualityManager.a.getValue());     // Catch: JSONException -> L6
        goto L4
    }

    public static void monitorDuration(String r1, JSONObject r2, JSONObject r3, long r4) {
        if (jt3.a.g(r1, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r1, r2);
        return;
    L6:
        if (r3 != null) goto L15;
    L11:
        JSONObject r5 = optShallowCopyJson(r3);
        addDebugMessage(r5);
        bt3.b.d.a.e(new g(r1, r2, r5));
        if (d.c == false) goto L17;
        JSONObject r6 = optDeepCopyJson(r2, true);
        JSONObject r7 = optDeepCopyJson(r5, true);
        bt3.c.a().b(new h(r1, r6, r7));
        return;
    L17:
        return;
    L15:
        r3.put("timestamp", r4);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void monitorPerformance(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        monitorPerformance(r1, XmlPullParser.NO_NAMESPACE, r2, r3, r4);
    }

    public static void monitorStatusAndDuration(String r9, int r10, JSONObject r11, JSONObject r12) {
        if (jt3.a.g(r9, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r9, r11);
        return;
    L6:
        JSONObject r0 = optShallowCopyJson(r12);
        addDebugMessage(r0);
        jt3.a.d(new lt3.a(r9, r10, optDeepCopyJson(r11, true), null, null, optDeepCopyJson(r0, false)));
        if (d.c == false) goto L10;
        JSONObject r13 = optDeepCopyJson(r11, true);
        JSONObject r14 = optDeepCopyJson(r12, true);
        bt3.c.a().b(new i(r9, r10, r13, r14));
        return;
    }

    public static void monitorUIAction(String r2, String r3, JSONObject r4, JSONObject r5) {
        if (sDeepCopy == false) goto L5;
        JSONObject r6 = preProcessExtJson(r5);     // Catch: Exception -> L10
    L6:
        bt3.b.d.a.e(new o(r2, r3, r4, r6));     // Catch: Exception -> L10
        if (d.c == false) goto L13;
        bt3.c.a().b(new p(r2, r3, r4, r6));     // Catch: Exception -> L10
        return;
    L13:
        return;
    L5:
        r6 = preProcessExtJson2(r5);     // Catch: Exception -> L10
    }

    public static void activeUploadAlog(String r8, long r9, long r11, String r13, IALogActiveUploadObserver r14) {
        activeUploadAlog(r8, r9, r11, r13, r14, null);
    }

    public static void monitorPerformance(String r8, String r9, JSONObject r10, JSONObject r11, JSONObject r12) {
        if (sDeepCopy == false) goto L5;
        JSONObject r13 = preProcessExtJson(r12);     // Catch: Exception -> L10
    L6:
        bt3.b.d.a.e(new q(r8, r9, r10, r11, r13));     // Catch: Exception -> L10
        if (d.c == false) goto L13;
        bt3.c.a().b(new r(r8, r9, r10, r11, r13));     // Catch: Exception -> L10
        return;
    L13:
        return;
    L5:
        r13 = preProcessExtJson2(r12);     // Catch: Exception -> L10
    }

    public static void monitorStatusAndEvent(String r8, int r9, JSONObject r10, JSONObject r11, JSONObject r12) {
        if (jt3.a.g(r8, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r8, r10);
        return;
    L6:
        JSONObject r13 = optShallowCopyJson(r12);
        addDebugMessage(r13);
        bt3.b.d.a.e(new c(r8, r9, r10, r11, r13));
        if (d.c == false) goto L10;
        JSONObject r4 = optDeepCopyJson(r10, true);
        JSONObject r5 = optDeepCopyJson(r11, true);
        JSONObject r6 = optDeepCopyJson(r13, true);
        bt3.c.a().b(new d(r8, r9, r4, r5, r6));
        return;
    }

    public static void activeUploadAlog(String r11, long r12, long r14, String r16, IALogActiveUploadObserver r17, tr3.f r18) {
        if (ApmDelegate.g.a.l == false) goto L5;
        bt3.b.d.a.j(new com.bytedance.apm.internal.e(r11, r12, r14, r16, r17, r18));
        return;
    L5:
        if (r18 == null) goto L9;
        r18.a(false, tr3.c.a(false, 9, null, null));
        return;
    }

    public static void trafficStats(long r16, String r18, String r19, String r20, JSONObject r21, JSONObject r22) {
        ws3.d r4 = ws3.d.b.a;
        if (r4.a == false) goto L39;
        bt3.b.d.a.e(new ws3.c(r19, r16, r18));
        boolean r5 = r4.b;
        String r14 = XmlPullParser.NO_NAMESPACE;
        if (r5 == false) goto L23;
        if (r16 <= r4.m) goto L23;
        Object[] r6 = new Object[6];
        r6[0] = Long.valueOf(r16);
        r6[1] = r18;
        r6[2] = r19;
        if (r20 != null) goto L12;
        String r7 = XmlPullParser.NO_NAMESPACE;
    L13:
        r6[3] = r7;
        if (r21 != null) goto L16;
        String r8 = XmlPullParser.NO_NAMESPACE;
    L17:
        r6[4] = r8;
        if (r22 != null) goto L20;
        String r9 = XmlPullParser.NO_NAMESPACE;
    L21:
        r6[5] = r9;
        String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s", r6);
        goto L23
    L20:
        r9 = r22.toString();
        goto L21
    L16:
        r8 = r21.toString();
        goto L17
    L12:
        r7 = r20;
    L23:
        if (d.j() == false) goto L37;
        Object[] r10 = new Object[6];
        r10[0] = Long.valueOf(r16);
        r10[1] = r18;
        r10[2] = r19;
        if (r20 != null) goto L27;
        String r2 = XmlPullParser.NO_NAMESPACE;
    L28:
        r10[3] = r2;
        if (r21 != null) goto L31;
        String r3 = XmlPullParser.NO_NAMESPACE;
    L32:
        r10[4] = r3;
        if (r22 == null) goto L36;
        r14 = r22.toString();
    L36:
        r10[5] = r14;
        String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s", r10);
        goto L37
    L31:
        r3 = r21.toString();
        goto L32
    L27:
        r2 = r20;
    L37:
        r4.j += r16;
        return;
    }

    public static void uploadMappingFile(String r8, String r9, String r10, String r11, String r12, ff7.e r13) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
    L13:
        if (r13 == null) goto L16;
        r13.onFail("Missing required parameters");
        return;
    L16:
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        if (TextUtils.isEmpty(r11) == true) goto L13;
        if (TextUtils.isEmpty(r12) == true) goto L13;
        uploadMappingFileInternal(r8, r9, r10, r11, r12, null, r13);
    }

    public static void monitorApiError(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = optShallowCopyJson(r21);
        bt3.b.d.a.e(new b0(r13, r15, r17, r18, r19, r20, r10));
        if (d.c == false) goto L6;
        bt3.c.a().b(new c0(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void monitorSLA(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        JSONObject r10 = optShallowCopyJson(r21);
        bt3.b.d.a.e(new k(r13, r15, r17, r18, r19, r20, r10));
        if (d.c == false) goto L6;
        bt3.c.a().b(new v(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void uploadMappingFile(String r8, String r9, String r10, String r11, String r12, ff7.e r13, String r14) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
    L15:
        if (r13 == null) goto L18;
        r13.onFail("Missing required parameters");
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        if (TextUtils.isEmpty(r11) == true) goto L15;
        if (TextUtils.isEmpty(r12) == true) goto L15;
        if (TextUtils.isEmpty(r14) == true) goto L15;
        xs3.a.b(r14);
        bt3.b.d.a.j(new xs3.b(r9, r10, r11, r12, r8, r13));
    }

    private static void uploadMappingFileInternal(String r7, String r8, String r9, String r10, String r11, String r12, ff7.e r13) {
        List r0 = fs3.a.b;
        if (com.bytedance.apm.util.k.b(r0) == false) goto L13;
        if (r13 == null) goto L15;
        r13.onFail("need host");
        return;
    L15:
        return;
    L13:
        xs3.a.b(new URL((String) ListProtector.get(r0, 0)).getHost());     // Catch: MalformedURLException -> L9
        xs3.a.d(r8, r9, r10, r11, r7, r12, r13);     // Catch: MalformedURLException -> L9
        return;
    L10:
        if (r13 == null) goto L16;
        r13.onFail("MalformedURLException");
        return;
    }

    public static void uploadMappingFile(String r1, String r2, String r3, String r4, String r5, String r6, ff7.e r7) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L15:
        if (r7 == null) goto L18;
        r7.onFail("Missing required parameters");
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        if (TextUtils.isEmpty(r4) == true) goto L15;
        if (TextUtils.isEmpty(r5) == true) goto L15;
        if (TextUtils.isEmpty(r6) == true) goto L15;
        uploadMappingFileInternal(r1, r2, r3, r4, r5, r6, r7);
    }

    public static void monitorSLA(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21, HttpRequestInfo r22) {
        JSONObject r10 = optShallowCopyJson(r21);
        Map r1 = ht3.a.a;
        if (r10 == null) goto L6;
        if (r22 == null) goto L6;
        r10.put("requestHeader", ((BaseHttpRequestInfo) r22).requestHeaders);     // Catch: Throwable -> L10
        r10.put("responseHeader", ((BaseHttpRequestInfo) r22).responseHeaders);     // Catch: Throwable -> L10
    L6:
        bt3.b.d.a.e(new d0(r13, r15, r17, r18, r19, r20, r10));
        if (d.c == false) goto L13;
        bt3.c.a().b(new e0(r13, r15, r17, r18, r19, r20, r10));
        return;
    }

    public static void uploadMappingFile(String r7, String r8, String r9, String r10, String r11, ff7.e r12, String r13, String r14) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L17:
        if (r12 == null) goto L20;
        r12.onFail("Missing required parameters");
        return;
    L20:
        return;
    L5:
        if (TextUtils.isEmpty(r9) == true) goto L17;
        if (TextUtils.isEmpty(r10) == true) goto L17;
        if (TextUtils.isEmpty(r11) == true) goto L17;
        if (TextUtils.isEmpty(r14) == true) goto L17;
        if (TextUtils.isEmpty(r13) == true) goto L17;
        xs3.a.b(r13);
        xs3.a.d(r8, r9, r10, r11, r7, r14, r12);
    }

    public static void monitorApiError(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21, HttpRequestInfo r22, Throwable r23) {
        JSONObject r10 = optShallowCopyJson(r21);
        Map r1 = ht3.a.a;
        if (r10 == null) goto L6;
        if (r23 == null) goto L6;
        r10.put("substatus", ht3.a.a(r23));     // Catch: Throwable -> L13
    L6:
        if (r10 == null) goto L9;
        if (r22 == null) goto L9;
        r10.put("requestHeader", ((BaseHttpRequestInfo) r22).requestHeaders);     // Catch: Throwable -> L14
        r10.put("responseHeader", ((BaseHttpRequestInfo) r22).responseHeaders);     // Catch: Throwable -> L14
    L9:
        bt3.b.d.a.e(new f0(r13, r15, r17, r18, r19, r20, r10));
        if (d.c == false) goto L19;
        bt3.c.a().b(new g0(r13, r15, r17, r18, r19, r20, r10));
        return;
    }
}
