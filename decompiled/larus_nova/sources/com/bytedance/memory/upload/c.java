package com.bytedance.memory.upload;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.util.MultiProcessSharedPreferences;
import com.bytedance.apm.util.m;
import com.bytedance.memory.heap.HeapDump;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import r17.e;
import r17.g;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<String> f265535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ArrayList<String> f265536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<String> f265537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f265538d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f265539e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f265540f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile MultiProcessSharedPreferences f265541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f265542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ThreadLocal<Boolean> f265543i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final NetworkChangeReceiver f265544j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f265545k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f265546l;

    /* JADX INFO: loaded from: classes21.dex */
    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c() {
    }

    static {
        f265535a = new ArrayList();
        f265536b = new ArrayList();
        f265537c = new ArrayList();
        f265538d = "upload_when_not_wifi";
        f265539e = "hprof_force_upload";
        f265540f = "hprof_shrink_deep";
        f265542h = 1;
        f265543i = new ThreadLocal();
        f265544j = new NetworkChangeReceiver();
        f265546l = false;
    }

    public static void a() {
        if (f265541g != null) goto L5;
        StringBuilder r100 = new StringBuilder();
        s17.c.b().getClass();
        r100.append(s17.c.f540158h);
        r100.append("_upload_dump_cost");
        f265545k = r100.toString();
        f265541g = MultiProcessSharedPreferences.c(q17.a.e().getContext());
    L5:
        f265541g.edit().remove(f265545k).commit();
    }

    public static int c() {
        if (f265541g != null) goto L6;
        StringBuilder r100 = new StringBuilder();
        s17.c.b().getClass();
        r100.append(s17.c.f540158h);
        r100.append("_upload_dump_cost");
        f265545k = r100.toString();
        f265541g = MultiProcessSharedPreferences.c(q17.a.e().getContext());
    L6:
        return f265541g.getInt(f265545k, 0);
    }

    public static synchronized void e() {
        monitor-enter(c.class);
    L71:
        th = move-exception;
        throw th;
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L10;
        r17.b.f535670b.a(new a(), "uploadCheck-MNA");     // Catch: Throwable -> L71
        monitor-exit(c.class);
        return;
    L10:
        if (f265546l == false) goto L12;
    L68:
        x17.a.f562123j.c("exception_uploadCheck_running");     // Catch: Throwable -> L71
        monitor-exit(c.class);
        return;
    L12:
        if (c() > 0) goto L68;
        f265546l = true;     // Catch: Throwable -> L71
        q17.a.e().f().getDumpAndShrinkConfig();     // Catch: Throwable -> L71
        if (com.bytedance.memory.heap.a.b().c().isEmpty() == false) goto L25;
        if (s17.c.b().c() == true) goto L25;
        if (s17.c.b().f540159a.exists() == false) goto L21;
        PolarisFileWrapper r100 = s17.c.b().f540159a;     // Catch: Throwable -> L71
        HeapDump.b r101 = HeapDump.newBuilder();     // Catch: Throwable -> L71
        r101.getClass();     // Catch: Throwable -> L71
        g.a(r100, "heapDumpFile");     // Catch: Throwable -> L71
        r101.f265486b = r100;     // Catch: Throwable -> L71
        r100.length();     // Catch: Throwable -> L71
        r101.f265485a = e.f535675a;     // Catch: Throwable -> L71
        g.a(r101.f265486b, "heapDumpFile");     // Catch: Throwable -> L71
        HeapDump r102 = new HeapDump(r101, null);     // Catch: Throwable -> L71
        x17.a r103 = x17.a.f562123j;     // Catch: Throwable -> L71
        r103.c("uploadcheck_saveHeap_begin");     // Catch: Throwable -> L71
        com.bytedance.memory.heap.a.b().e(r102);     // Catch: Throwable -> L71
        r103.c("uploadcheck_saveHeap_end");     // Catch: Throwable -> L71
        goto L25
    L21:
        f265546l = false;     // Catch: Throwable -> L71
        monitor-exit(c.class);
        return;
    L25:
        if (m.c(q17.a.e().getContext()) == false) goto L27;
    L31:
        PolarisFileWrapper r104 = s17.c.b().f540159a;     // Catch: Throwable -> L71
        if (r104.exists() == false) goto L39;
        if (r104.lastModified() >= (System.currentTimeMillis() - 604800000)) goto L39;
        x17.a.f562123j.c("error_expired_heap_hprof");     // Catch: Throwable -> L71
        com.bytedance.memory.heap.a.b().a();     // Catch: Throwable -> L71
        f265546l = false;     // Catch: Throwable -> L71
        monitor-exit(c.class);
        return;
    L39:
        if (TextUtils.isEmpty(com.bytedance.memory.heap.a.b().c()) == true) goto L48;
        PolarisFileWrapper r105 = new PolarisFileWrapper(com.bytedance.memory.heap.a.b().c());     // Catch: Throwable -> L71
        if (r105.exists() == false) goto L48;
        if (r105.lastModified() >= (System.currentTimeMillis() - 604800000)) goto L48;
        x17.a.f562123j.c("error_expired_zip_hprof");     // Catch: Throwable -> L71
        com.bytedance.memory.heap.a.b().a();     // Catch: Throwable -> L71
        f265546l = false;     // Catch: Throwable -> L71
        monitor-exit(c.class);
        return;
    L48:
        if (t17.a.b(f265539e) == false) goto L75;
    L65:
        com.bytedance.memory.heap.a.b().j();     // Catch: Throwable -> L71
        f265546l = false;     // Catch: Throwable -> L71
        monitor-exit(c.class);
        return;
    L75:
        List<String> r106 = f265535a;     // Catch: Exception -> L63 Throwable -> L71
        if (r106 == null) goto L65;
        if (r106.size() <= 0) goto L65;
        Iterator<String> r107 = f265535a.iterator();     // Catch: Exception -> L63 Throwable -> L71
    L55:
        if (r107.hasNext() == false) goto L65;
        ff7.b r108 = com.bytedance.apm.d.f190522j.doGet(String.format(r107.next(), new Object[]{Integer.valueOf(com.bytedance.apm.d.d().optInt("aid", 0))}), null);     // Catch: Exception -> L63 Throwable -> L71
        if (r108 == null) goto L55;
        boolean r109 = new JSONObject(new String(r108.f476669c)).optBoolean("should_upload");     // Catch: Exception -> L63 Throwable -> L71
        r17.c.b("uploadCheck with api: shouldUpload " + r109, new Object[0]);     // Catch: Exception -> L63 Throwable -> L71
        if (r109 == true) goto L65;
        x17.a.f562123j.c("error_forbid_upload");     // Catch: Exception -> L63 Throwable -> L71
        f265546l = false;     // Catch: Exception -> L63 Throwable -> L71
        monitor-exit(c.class);
        return;
    L63:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L71
        goto L65
    L27:
        if (t17.a.b(f265538d) == true) goto L31;
        r17.c.b("not wifi, not upload", new Object[0]);     // Catch: Throwable -> L71
        f265544j.registerReceiver(q17.a.e().getContext());     // Catch: Throwable -> L71
        f265546l = false;     // Catch: Throwable -> L71
        monitor-exit(c.class);
    }

    public static void f() {
        x17.a r100 = x17.a.f562123j;
        r100.c("uploadFile");
        String r101 = com.bytedance.memory.heap.a.b().c();
        String r102 = com.bytedance.memory.heap.a.b().d().getString("updateVersionCode", "");
        int r103 = com.bytedance.memory.heap.a.b().d().getInt("hprof_type", 1);
        com.bytedance.memory.heap.a.b().getClass();
        if (com.bytedance.memory.heap.a.b().f265498c == null) goto L5;
        long r104 = com.bytedance.memory.heap.a.b().f265498c.currentTime;
    L6:
        long r105 = r104;
        ArrayList<String> r106 = f265536b;
        monitor-enter(c.class);
    L31:
        th = move-exception;
        throw th;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L14;
        r100.c("uploadFile_error_uploadingOrEmpty");     // Catch: Throwable -> L31
        monitor-exit(c.class);     // Catch: Throwable -> L31
        return;
    L14:
        if (m.c(q17.a.e().getContext()) == false) goto L16;
    L20:
        monitor-exit(c.class);     // Catch: Throwable -> L31
        if (Boolean.TRUE.equals(f265543i.get()) == true) goto L24;
        b(r101, r102, r103, r105, r106);     // Catch: Throwable -> L27
    L33:
        return;
    L24:
        d(r101, r106, r102, r103, r105);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L16:
        if (t17.a.b(f265538d) == true) goto L20;
        r100.c("error_not_wifi_in_upload");     // Catch: Throwable -> L31
        f265544j.registerReceiver(q17.a.e().getContext());     // Catch: Throwable -> L31
        r17.c.b("not wifi, not upload", new Object[0]);     // Catch: Throwable -> L31
        monitor-exit(c.class);     // Catch: Throwable -> L31
        return;
    L5:
        r104 = System.currentTimeMillis();
        goto L6
    }

    public static void b(String r110, String r111, int r112, long r113, List r210) {
        r17.c.b("MemoryNetApi uploadFile begin", new Object[0]);     // Catch: Throwable -> L71
        x17.a.f562123j.c("uploadFile_begin");     // Catch: Throwable -> L71
        JSONObject r100 = com.bytedance.apm.d.d();     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r111) == true) goto L79;
        r100.put("update_version_code", r111);     // Catch: Throwable -> L71
    L79:
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper(new PolarisFileWrapper(s17.c.b().f540162d, "info.txt")));     // Catch: Throwable -> L22
        String r102 = r101.readLine().trim();     // Catch: Throwable -> L75
        String r103 = r101.readLine().trim();     // Catch: Throwable -> L75
        if (TextUtils.isEmpty(r102) == false) goto L13;
    L15:
        long r104 = Long.parseLong(r101.readLine().trim());     // Catch: Throwable -> L75
        if (r104 <= 0) goto L19;
    L81:
        r101.close();     // Catch: Throwable -> L74
    L23:
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L71
        r105.put("event_type", UploadTypeInf.MEMORY_OBJ_MONITOR);     // Catch: Throwable -> L71
        r105.put("hprof_type", r112);     // Catch: Throwable -> L71
        r105.put("timestamp", r104);     // Catch: Throwable -> L71
        r105.put("scene", "uploadFile");     // Catch: Throwable -> L71
        boolean r106 = true;
        ArrayList r107 = new ArrayList(1);     // Catch: Throwable -> L71
        PolarisFileWrapper r108 = new PolarisFileWrapper(r110);     // Catch: Throwable -> L71
        r107.add(r108);     // Catch: Throwable -> L71
        x17.a r109 = x17.a.f562123j;     // Catch: Throwable -> L71
        r109.f562128e = r108.length();     // Catch: Throwable -> L71
        r109.c("findFastestUrls");     // Catch: Throwable -> L71
        List<String> r114 = d.b(r210);     // Catch: Throwable -> L71
        if (r114 != null) goto L26;
    L69:
        r109.c("error_dumpcollect_url_null");     // Catch: Throwable -> L71
        return;
    L26:
        if (r114.size() <= 0) goto L69;
        Iterator<String> r115 = r114.iterator();     // Catch: Throwable -> L71
        int r116 = 0;
    L29:
        if (r115.hasNext() == false) goto L66;
        String r117 = r115.next();     // Catch: Throwable -> L71
        int r118 = r116 + 1;     // Catch: Throwable -> L71
        x17.a r119 = x17.a.f562123j;     // Catch: Throwable -> L71
        r119.f562126c = r117;     // Catch: Throwable -> L71
        r119.f562127d = r118;     // Catch: Throwable -> L71
        r119.c("upload_dump");     // Catch: Throwable -> L71
        PthreadTimer r120 = new PthreadTimer("MemoryWidgetHeartbeat", true);     // Catch: Throwable -> L71
        f265542h = 1;     // Catch: Throwable -> L71
        r120.schedule(new b(), 1000, 1000);     // Catch: Throwable -> L71
        MomDumpPartUploader r121 = new MomDumpPartUploader(r117, r108, r100, r105);     // Catch: Throwable -> L40
        MomDumpPartUploader.d r122 = r121.j();     // Catch: Throwable -> L40
        MomDumpPartUploader.State r123 = r122.f265530a;     // Catch: Throwable -> L40
        MomDumpPartUploader.State r124 = MomDumpPartUploader.State.SUCCESS;     // Catch: Throwable -> L40
        if (r123 != r124) goto L34;
    L43:
        boolean r125 = true;
    L44:
        if (r125 == true) goto L52;
        boolean r126 = r121.l();     // Catch: Throwable -> L40
        if (r126 == true) goto L49;
        r124 = MomDumpPartUploader.State.FAILED;     // Catch: Throwable -> L40
    L49:
        r122 = new MomDumpPartUploader.d(r124, "", "uploadSingleFile", r126);     // Catch: Throwable -> L40
    L52:
        r120.cancel();     // Catch: Throwable -> L71
        a();     // Catch: Throwable -> L71
        MomDumpPartUploader.State r127 = r122.f265530a;     // Catch: Throwable -> L71
        if (r127 != MomDumpPartUploader.State.SUCCESS) goto L55;
    L62:
        boolean r128 = true;
    L63:
        if (r128 == true) goto L64;
        x17.a.f562123j.c("uploadFile_error");     // Catch: Throwable -> L71
        r17.c.b("MemoryNetApi uploadFile failed, state=" + r122.f265530a + ", message:" + r122.f265532c, new Object[0]);     // Catch: Throwable -> L71
        r116 = r118;
        goto L29
    L64:
        r17.c.b("MemoryNetApi uploadFile succeed, state=%s, tosUrl=%s", new Object[]{r127.name(), r122.f265531b});     // Catch: Throwable -> L71
        x17.a.f562123j.c("upload_dump_success");     // Catch: Throwable -> L71
        y17.a.b().f565661a = false;     // Catch: Throwable -> L71
        com.bytedance.memory.heap.a.b().a();     // Catch: Throwable -> L71
    L67:
        if (r106 == true) goto L87;
        x17.a.f562123j.c("error_uploadfile_failed");     // Catch: Throwable -> L71
        com.bytedance.memory.heap.a.b().a();     // Catch: Throwable -> L71
        return;
    L87:
        return;
    L55:
        if (r127 == MomDumpPartUploader.State.TCC_DROP) goto L62;
        if (r127 == MomDumpPartUploader.State.FILE_TOO_SMALL) goto L59;
    L61:
        r128 = false;
        goto L63
    L59:
        if (r122.f265533d == false) goto L61;
    L34:
        if (r123 == MomDumpPartUploader.State.TCC_DROP) goto L43;
        if (r123 == MomDumpPartUploader.State.FILE_TOO_SMALL) goto L38;
    L42:
        r125 = false;
        goto L44
    L38:
        if (r122.f265533d == false) goto L42;
    L40:
        th = move-exception;
        r122 = new MomDumpPartUploader.d(MomDumpPartUploader.State.FAILED, "", th.getMessage(), false);     // Catch: Throwable -> L71
        HashMap<String, Object> r129 = new HashMap();     // Catch: Throwable -> L71
        r129.put("http_error_message", th.getMessage());     // Catch: Throwable -> L71
        x17.a.f562123j.b("error_uploadfile_exception_inner", r129);     // Catch: Throwable -> L71
        goto L52
    L66:
        r106 = false;
        goto L67
    L13:
        if (TextUtils.isEmpty(r103) == true) goto L15;
        r100.put("app_version", r102);     // Catch: Throwable -> L75
        r100.put("update_version_code", r103);     // Catch: Throwable -> L75
    L19:
        r104 = r113;
    L22:
        r104 = r113;
    L71:
        th = move-exception;
        th.toString();
        EnsureManager.ensureNotReachHere(th);
        r17.c.b("http_error_message " + th.getMessage(), new Object[0]);
        HashMap<String, Object> r130 = new HashMap();
        r130.put("http_error_message", th.getMessage());
        x17.a.f562123j.b("error_uploadfile_exception", r130);
    }

    public static void d(String r100, ArrayList<String> r101, String r102, int r103, long r110) {
        Context r104 = q17.a.e().getContext();     // Catch: Throwable -> L4
    L6:
        if (r104 != null) goto L9;
        r17.c.b("MemoryNetApi startUploadInBackgroundProcess but context is null, fallback to current process upload", new Object[0]);
        b(r100, r102, r103, r110, r101);
        return;
    L9:
        Context r105 = r104.getApplicationContext();
        int r106 = MemoryUploadService.f265503a;
        Intent r107 = new Intent(r105, MemoryUploadService.class);
        r107.putExtra("extra_upload_file_path", r100);
        r107.putStringArrayListExtra("extra_upload_urls", r101);
        r107.putExtra("extra_update_version_code", r102);
        r107.putExtra("extra_hprof_type", r103);
        r107.putExtra("extra_crash_time", r110);
        r104.startService(r107);     // Catch: Throwable -> L12
        r17.c.b("MemoryNetApi start upload service in independent process", new Object[0]);     // Catch: Throwable -> L12
        return;
    L12:
        r17.c.b("MemoryNetApi start upload service failed, fallback to current process upload", new Object[0]);
        b(r100, r102, r103, r110, r101);
        return;
    L4:
        r104 = com.bytedance.apm.d.getContext();
        goto L6
    }
}
