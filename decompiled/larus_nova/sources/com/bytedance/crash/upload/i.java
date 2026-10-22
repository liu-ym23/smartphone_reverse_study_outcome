package com.bytedance.crash.upload;

import android.os.FileObserver;
import android.text.TextUtils;
import com.apm.lite.runtime.ConfigManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.crash.NativeCrashSummary;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xg4.w;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static i f203371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f203372h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, h> f203373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f203374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f203375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f203376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f203377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PolarisFileWrapper f203378f;

    public class a extends FileObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f203379a;

        /* JADX INFO: renamed from: com.bytedance.crash.upload.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes15.dex */
        public class RunnableC2956a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f203380a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f203380a.f203379a.q();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC2956a(a r100) {
                this.f203380a = r100;
            }
        }

        public a(i r100, String r101) {
            this.f203379a = r100;
            super(r101, 1032);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int r100, String r101) {
            p.d("disaster: FileObserver event=" + r100);
            if ((r100 & 8) != 0) goto L7;
            if ((r100 & 1024) != 0) goto L7;
            return;
        L7:
            if (this.f203379a.f203376d == false) goto L10;
            p.d("disaster: current process updating file");
            this.f203379a.f203376d = false;
            return;
        L10:
            wh4.b.postDelayed(new RunnableC2956a(this), 100);
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f203381a;

        public b(String r100) {
            this.f203381a = r100;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            return r101.endsWith(this.f203381a);
        }
    }

    public static i e() {
        monitor-enter(i.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f203371g != null) goto L7;
        f203371g = new i();     // Catch: Throwable -> L10
    L7:
        monitor-exit(i.class);     // Catch: Throwable -> L10
        return f203371g;
    }

    public static void l() {
        if (a(ConfigManager.JAVA_URL_SUFFIX) == false) goto L5;
        xg4.p.f563719k = true;
        com.bytedance.crash.crash.d.f203131g = true;
        gh4.a.f481274a = true;
        bh4.a.f19026a = true;
    L6:
        fh4.f.f477014h = a(ConfigManager.EXCEPTION_URL_SUFFIX);
        NativeBridge.V(a(ConfigManager.NATIVE_URL_SUFFIX) ? 1 : 0);
        return;
    L5:
        xg4.p.f563719k = false;
        gh4.a.f481274a = false;
        bh4.a.f19026a = false;
        com.bytedance.crash.crash.d.f203131g = false;
        goto L6
    }

    public final int k() {
        this.f203378f.createNewFile();     // Catch: Throwable -> L4
        return NativeBridge.p(this.f203378f.getAbsolutePath());
    L4:
        return -1;
    }

    public final void q() {
    L29:
        this.f203373a.clear();
        l();
        u(null);
        return;
    L3:
        if (this.f203374b.exists() == true) goto L5;
    L27:
        this.f203373a.clear();     // Catch: Throwable -> L29
        l();     // Catch: Throwable -> L29
        return;
    L5:
        if (this.f203374b.length() == 0) goto L27;
        p.d("disaster: readFromFile");     // Catch: Throwable -> L29
        String r100 = "";
        int r101 = 0;
        int r102 = 0;
    L9:
        boolean r103 = true;
        r102 = r102 + 1;
        int r104 = k();     // Catch: Throwable -> L15
        if (r104 <= 0) goto L17;
        p.d("disaster: read got flock");     // Catch: Throwable -> L15
        r100 = com.bytedance.crash.util.h.c(this.f203374b);     // Catch: Throwable -> L15
        if (r104 <= 0) goto L16;
        NativeBridge.g0(r104);     // Catch: Throwable -> L15
    L16:
        p.d("disaster: read unlock flock");     // Catch: Throwable -> L15
        goto L19
    L17:
        p.d("disaster:read did not got flock, sleep 500ms and retry");     // Catch: Throwable -> L15
        Thread.sleep(50);     // Catch: Throwable -> L15
    L20:
        if (r103 == false) goto L23;
        if (r102 < 10) goto L9;
    L23:
        JSONArray r105 = new JSONArray(r100);     // Catch: Throwable -> L29
        p.d("Disaster:syncNetworkStateFromFile mJsonArray=" + r105.toString());     // Catch: Throwable -> L29
    L25:
        if (r101 >= r105.length()) goto L38;
        JSONObject r106 = JSONArrayProtectorUtils.getJSONObject(r105, r101);     // Catch: Throwable -> L29
        String r107 = r106.keys().next();     // Catch: Throwable -> L29
        this.f203373a.put(r107, new h(JSONObjectProtectorUtils.getJSONObject(r106, r107)));     // Catch: Throwable -> L29
        l();     // Catch: Throwable -> L29
        r101 = r101 + 1;     // Catch: Throwable -> L29
        goto L25
    L38:
        return;
    L19:
        r103 = false;
        goto L20
    }

    public final void r() {
        ConcurrentHashMap<String, h> r100 = this.f203373a;
        monitor-enter(r100);
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L21
        Iterator<Map.Entry<String, h>> r102 = this.f203373a.entrySet().iterator();     // Catch: Throwable -> L18
    L8:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, h> r103 = r102.next();     // Catch: Throwable -> L18
        if (r103 == null) goto L8;
        r101.put(r103.getValue().a());     // Catch: Throwable -> L18
        goto L8
    L14:
        if (r101.length() > 0) goto L16;
        this.f203373a.clear();     // Catch: Throwable -> L18
        l();     // Catch: Throwable -> L18
        u(null);     // Catch: Throwable -> L18
        p.d("Disaster:syncNetworkStateToFile delete strategy file");     // Catch: Throwable -> L18
    L19:
        monitor-exit(r100);     // Catch: Throwable -> L21
        return;
    L16:
        u(r101);     // Catch: Throwable -> L18
        p.d("Disaster:syncNetworkStateToFile mJsonArray=" + r101.toString());     // Catch: Throwable -> L18
    L18:
        this.f203373a.clear();     // Catch: Throwable -> L21
        l();     // Catch: Throwable -> L21
        u(null);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public i() {
        p.d("Disaster:init");
        PolarisFileWrapper r100 = new PolarisFileWrapper(com.bytedance.crash.i.d(), "network_disaster");
        com.bytedance.crash.util.g.c(r100);
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "networkStatef");
        this.f203374b = r101;
        this.f203373a = new ConcurrentHashMap();
        this.f203375c = false;
        this.f203376d = false;
        this.f203377e = new a(this, r101.getAbsolutePath());     // Catch: Throwable -> L6
    L4:
        this.f203378f = new PolarisFileWrapper(r100, "disasterLock");
    }

    public static boolean a(String r100) {
        i r101 = e();
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.f203373a.size() <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return false;
    L11:
        if (f203372h == true) goto L29;
        String r103 = null;
        if (TextUtils.isEmpty(null) == false) goto L17;
        r103 = com.bytedance.crash.monitor.j.f203315a.a();     // Catch: Throwable -> L24
    L17:
        int r104 = r101.g(f(r103, r100));     // Catch: Throwable -> L24
        if (r104 != 4) goto L21;
    L22:
        return true;
    L21:
        if (r104 == 5) goto L22;
        return false;
    L30:
        return false;
    L29:
        return false;
    L8:
        r102 = false;
        goto L9
    }

    public static long b(URL r100) {
        i r101 = e();
        long r102 = 0;
        if (r101 != null) goto L6;
        return 0;
    L6:
        if (r101.f203373a.size() <= 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        return 0;
    L11:
        if (f203372h == true) goto L31;
        p.d("Disaster:checkPermission url=" + r100);
        String r104 = null;
        if (TextUtils.isEmpty(null) == false) goto L18;
        r104 = h(r100);     // Catch: Throwable -> L26
    L18:
        if (TextUtils.isEmpty(r104) == false) goto L20;
        p.d("Disaster:checkPermission aid==null");     // Catch: Throwable -> L26
        return -1;
    L20:
        h r105 = r101.f203373a.get(f(r104, r100.getPath()));     // Catch: Throwable -> L26
        if (r105 != null) goto L23;
        p.d("Disaster:checkPermission normal");     // Catch: Throwable -> L26
        return 0;
    L23:
        r102 = r101.i(r105);     // Catch: Throwable -> L26
    L24:
        p.d("Disaster:checkPermission return timeout=" + r102);
        return r102;
    L31:
        return 0;
    L8:
        r103 = false;
        goto L9
    }

    public static void c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        boolean r101 = zg4.i.f572087c;     // Catch: Throwable -> L18
        zg4.g r102 = zg4.g.f572072l;     // Catch: Throwable -> L18
        if (new URL(r102.f572074b).getPath().equals(r100) == false) goto L9;
        d(CrashType.JAVA);     // Catch: Throwable -> L18
        d(CrashType.ANR);     // Catch: Throwable -> L18
        return;
    L9:
        if (new URL(r102.f572075c).getPath().equals(r100) == false) goto L15;
        oh4.a.a();     // Catch: Throwable -> L18
        PolarisFileWrapper r103 = zg4.f.f572067e.f572069b;     // Catch: Throwable -> L18
        if (r103 == null) goto L13;
        com.bytedance.crash.util.h.b(r103);     // Catch: Throwable -> L18
    L13:
        d(CrashType.LAUNCH);     // Catch: Throwable -> L18
        return;
    L15:
        if (new URL(r102.f572080h).getPath().equals(r100) == false) goto L22;
        d(CrashType.NATIVE);     // Catch: Throwable -> L18
        return;
    L22:
        return;
    }

    public static void d(CrashType r100) {
        if (r100 != CrashType.JAVA) goto L14;
        List<File> r101 = j(com.bytedance.crash.crash.e.f203135c);
        if (r101 == null) goto L29;
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((ArrayList) r101).iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        File r104 = (File) r103.next();
        if (new PolarisFileWrapper(r104, EventVerify.TYPE_LAUNCH).exists() == true) goto L8;
        r102.add(r104);
    L12:
        r101 = r102;
    L29:
        if (r101 != null) goto L31;
        return;
    L31:
        if (r101.size() <= 0) goto L57;
        Iterator<File> r105 = r101.iterator();
    L35:
        if (r105.hasNext() == false) goto L58;
        File r106 = r105.next();
        if (r106.isFile() == true) goto L35;
        com.bytedance.crash.util.h.b(r106);
        goto L35
    L58:
        return;
    L57:
        return;
    L14:
        if (r100 != CrashType.LAUNCH) goto L24;
        r101 = j(com.bytedance.crash.crash.e.f203135c);
        if (r101 == null) goto L29;
        r102 = new ArrayList();
        Iterator r107 = ((ArrayList) r101).iterator();
    L19:
        if (r107.hasNext() == false) goto L12;
        File r108 = (File) r107.next();
        if (new PolarisFileWrapper(r108, EventVerify.TYPE_LAUNCH).exists() == false) goto L19;
        r102.add(r108);
        goto L19
    L24:
        if (r100 != CrashType.NATIVE) goto L27;
        r101 = j(NativeCrashSummary.FILE_NAME);
        goto L29
    L27:
        if (r100 != CrashType.ANR) goto L40;
        r101 = j(w.f563732g);
        goto L29
    }

    public static String h(URL r110) {
        String r100 = "";
        String r111 = r110.getQuery();     // Catch: Throwable -> L23
        if (r111 == null) goto L21;
        if (r111.contains("&") == false) goto L21;
        if (r111.contains(ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L21;
        String[] r112 = r111.split("&");     // Catch: Throwable -> L23
        int r101 = r112.length;     // Catch: Throwable -> L23
        int r102 = 0;
    L10:
        if (r102 >= r101) goto L21;
        String[] r103 = r112[r102].split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L23
        if (r103 == null) goto L20;
        if (r103.length < 2) goto L20;
        if (URLDecoder.decode(r103[0], "UTF-8").equals("aid") == false) goto L20;
        r100 = URLDecoder.decode(r103[1], "UTF-8");     // Catch: UnsupportedEncodingException -> L22 Throwable -> L23
        p.d("getQueryParams value = " + r100);     // Catch: UnsupportedEncodingException -> L22 Throwable -> L23
    L20:
        r102 = r102 + 1;
    L21:
        return r100;
    }

    public static List<File> j(String r100) {
        com.bytedance.crash.crash.c r101 = com.bytedance.crash.crash.c.f203123d;
        if (r101 == null) goto L5;
        PolarisFileWrapper r102 = r101.f203124a;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        File[] r103 = r102.listFiles();
        if (r103 != null) goto L11;
        return null;
    L11:
        ArrayList r104 = new ArrayList();
        int r105 = r103.length;
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L17;
        File r107 = r103[r106];
        if (r107.listFiles(new b(r100)) == null) goto L15;
        r104.add(r107);
        r106 = r106 + 1;
        goto L12
    L15:
        return null;
    L17:
        return r104;
    L5:
        r102 = null;
        goto L6
    }

    public final int g(String r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L16
        return -1;
    L8:
        h r101 = this.f203373a.get(r100);     // Catch: Throwable -> L16
        if (r101 != null) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L16
        return 0;
    L13:
        int r102 = r101.f203365e;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r102;
    }

    public final long i(h r110) {
        long r100 = System.currentTimeMillis();
        long r101 = r110.f203364d;
        int r102 = r110.f203365e;
        if (r102 != 1) goto L6;
        long r103 = r110.f203368h;
    L26:
        if (r103 != 0) goto L29;
        return 0;
    L29:
        if (r100 >= r101) goto L49;
        monitor-enter(this);
        Iterator<Map.Entry<String, h>> r111 = this.f203373a.entrySet().iterator();     // Catch: Throwable -> L43
    L33:
        if (r111.hasNext() == false) goto L45;
        Map.Entry<String, h> r104 = r111.next();     // Catch: Throwable -> L43
        if (r104 == null) goto L33;
        h r105 = r104.getValue();     // Catch: Throwable -> L43
        r105.f203364d = r100;     // Catch: Throwable -> L43
        if (com.bytedance.crash.util.c.f203410d != null) goto L41;
        com.bytedance.crash.util.c.f203410d = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss.SSS", Locale.getDefault());     // Catch: Throwable -> L53
    L41:
        com.bytedance.crash.util.c.f203410d.format(new Date(r105.f203364d));     // Catch: Throwable -> L53
        goto L33
    L45:
        monitor-exit(this);     // Catch: Throwable -> L43
        r();
        r101 = r100;
    L43:
        th = move-exception;
        throw th;
    L49:
        long r106 = r100 - r101;
        if (r106 < r103) goto L52;
        return 0;
    L52:
        return r103 - r106;
    L6:
        if (r102 != 3) goto L8;
    L12:
        int r107 = 0;
        if (r102 == 1) goto L17;
        if (r102 == 0) goto L17;
        int r112 = r110.f203367g;
    L18:
        if (r112 <= 0) goto L22;
        r107 = r112;
    L22:
        if (r107 > 6) goto L24;
        r103 = ((r107 * 5) * 60) * 1000;
        goto L26
    L24:
        r103 = 1800000;
    L17:
        r112 = 0;
        goto L18
    L8:
        if (r102 == 4) goto L12;
        if (r102 == 5) goto L12;
        r103 = 0;
        goto L26
    }

    public final void n(String r100) {
        monitor-enter(this);
        if (this.f203373a.containsKey(r100) == false) goto L14;
        this.f203373a.remove(r100);     // Catch: Throwable -> L11
        l();     // Catch: Throwable -> L11
        r();     // Catch: Throwable -> L11
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void u(JSONArray r100) {
        p.d("disaster: writeToFile");
        boolean r101 = true;
        int r102 = 0;
    L3:
        if (r101 == false) goto L24;
        if (r102 >= 20) goto L24;
        r102 = r102 + 1;
        int r103 = k();     // Catch: Throwable -> L13
        if (r103 == (-1)) goto L9;
        p.d("disaster:write got flock");     // Catch: Throwable -> L13
        this.f203376d = true;     // Catch: Throwable -> L13
        com.bytedance.crash.util.h.g(this.f203374b, r100);     // Catch: Throwable -> L13
        if (r103 <= 0) goto L14;
        NativeBridge.g0(r103);     // Catch: Throwable -> L13
    L14:
        p.d("disaster:write unlock flock");     // Catch: Throwable -> L13
        int r104 = 0;
        boolean r105 = true;
    L16:
        if (this.f203376d == false) goto L18;
        p.d("disaster:waiting 20ms");     // Catch: Throwable -> L13
        Thread.sleep(20);     // Catch: Throwable -> L13
        r104 = r104 + 1;     // Catch: Throwable -> L13
    L20:
        if (r105 == false) goto L23;
        if (r104 < 50) goto L16;
    L18:
        p.d("disaster: breakout");     // Catch: Throwable -> L13
        r105 = false;
        goto L20
    L9:
        p.d("disaster:write did not got flock, sleep 50ms and retry");     // Catch: Throwable -> L13
        Thread.sleep(50);     // Catch: Throwable -> L13
        r101 = true;
    L23:
        r101 = false;
    L24:
        this.f203376d = false;
    }

    public static String f(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L7;
        return r100 + "_" + r101;
    }

    public static void s(URL r100, k r101) {
        i r102 = e();
        if (r102 != null) goto L6;
        return;
    L6:
        if (f203372h == false) goto L8;
        return;
    L8:
        if (r100 == null) goto L15;
        r100.toString();
        boolean r103 = zg4.i.f572087c;
        String r104 = h(r100);     // Catch: Throwable -> L17
        String r105 = r100.getPath();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r104) == false) goto L13;
        return;
    L13:
        r102.t(r104, r105, r101);     // Catch: Throwable -> L17
        return;
    L20:
        return;
    L15:
        boolean r106 = zg4.i.f572087c;
    }

    public final void p(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L37:
        boolean r102 = zg4.i.f572087c;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L37;
        p.d("Disaster:syncNetworkStateByNet path=" + r101);
        String r103 = zg4.g.f572072l.f572083k;
        JSONObject r104 = new JSONObject();
        r104.put("aid", CastIntegerProtector.valueOf(r100));     // Catch: JSONException -> L20
        r104.put("os", "Android");     // Catch: JSONException -> L20
        r104.put("path", r101);     // Catch: JSONException -> L20
        String r105 = r104.toString();     // Catch: JSONException -> L20
    L17:
        th = move-exception;
        boolean r106 = zg4.i.f572087c;     // Catch: JSONException -> L20
        k r107 = new k(th);     // Catch: JSONException -> L20
    L21:
        p.d("Disaster:syncNetworkStateByNet rsp=" + r107.toString());
        t(r100, r101, r107);
        if (this.f203375c == false) goto L24;
    L25:
        this.f203375c = false;
        monitor-enter(this);     // Catch: Throwable -> L39
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L28:
        if (this.f203373a.size() <= 0) goto L30;
        this.f203373a.clear();     // Catch: Throwable -> L32
        l();     // Catch: Throwable -> L32
        r();     // Catch: Throwable -> L32
    L30:
        monitor-exit(this);     // Catch: Throwable -> L32
    L35:
        p.d("disaster:syncNetworkStateByNet, quota path error");
        return;
    L24:
        if (r107.f203383a != 0) goto L25;
        return;
    L10:
        if (TextUtils.isEmpty(r105) == false) goto L12;
    L15:
        r107 = new k(201);     // Catch: Throwable -> L17
    L41:
    L12:
        if (TextUtils.isEmpty(r103) == true) goto L15;
        r107 = CrashUploader.a(r103, r105.getBytes(), CrashUploader.CompressType.GZIP, false);     // Catch: Throwable -> L17
    L20:
        r107 = new k(207);
        goto L21
    }

    public final int t(String r110, String r210, k r211) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L69:
        boolean r100 = zg4.i.f572087c;
        return -1;
    L5:
        if (TextUtils.isEmpty(r210) == true) goto L69;
        String r101 = f(r110, r210);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r110) == true) goto L68;
        if (TextUtils.isEmpty(r210) == true) goto L68;
        zg4.g r102 = zg4.g.f572072l;     // Catch: Throwable -> L71
        if (r210.equals(new URL(r102.f572082j).getPath()) == false) goto L14;
        return 0;
    L14:
        r211.toString();     // Catch: Throwable -> L71
        boolean r103 = zg4.i.f572087c;     // Catch: Throwable -> L71
        int r104 = g(r101);     // Catch: Throwable -> L71
        int r105 = r211.f203384b;     // Catch: Throwable -> L71
        JSONObject r106 = r211.f203385c;     // Catch: Throwable -> L71
        boolean r107 = r210.equals(new URL(r102.f572083k).getPath());     // Catch: Throwable -> L71
        int r111 = 3;
        if (r105 != 200) goto L54;
        if (r106 != null) goto L19;
        o(r110, r210, 0, 0, 0);     // Catch: Throwable -> L71
        return 0;
    L19:
        String r108 = r106.optString("message");     // Catch: Throwable -> L71
        String r109 = r106.optString("redirect");     // Catch: Throwable -> L71
        long r112 = r106.optLong("delay");     // Catch: Throwable -> L71
        String r113 = r106.optString("Alog_quota");     // Catch: Throwable -> L71
        String r114 = r106.optString("quota_status");     // Catch: Throwable -> L71
        if (r107 == true) goto L26;
        if (TextUtils.isEmpty(r114) == true) goto L26;
        r108 = r114;
    L26:
        if (TextUtils.isEmpty(r108) == false) goto L28;
    L43:
        int r115 = 0;
    L44:
        TextUtils.isEmpty(r109);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r113) == false) goto L47;
        int r116 = 0;
        boolean r117 = false;
    L52:
        r111 = r115;
        boolean r118 = r117;
        int r119 = r116;
        boolean r120 = r118;
    L60:
        if (r111 != (-2)) goto L64;
        if (r107 == false) goto L63;
        this.f203375c = true;     // Catch: Throwable -> L71
    L63:
        return r104;
    L64:
        o(r110, r210, r111, r112, r119);     // Catch: Throwable -> L71
        if (r120 == false) goto L67;
        o(r110, new URL(r102.f572081i).getPath(), r119, r112, r119);     // Catch: Throwable -> L71
    L67:
        return r111;
    L47:
        if ("long escape".equals(r113) == false) goto L49;
        r116 = 3;
    L50:
        r117 = true;
        goto L52
    L49:
        r116 = 0;
        goto L50
    L28:
        if ("success".equals(r108) == true) goto L43;
        if ("long escape".equals(r108) == false) goto L34;
        r115 = 3;
        goto L44
    L34:
        if ("ignore data".equals(r108) == false) goto L37;
    L42:
        r115 = -2;
        goto L44
    L37:
        if ("drop data".equals(r108) == false) goto L40;
        r115 = 4;
        goto L44
    L40:
        if ("drop all data".equals(r108) == false) goto L42;
        r115 = 5;
        goto L44
    L54:
        if (500 <= r105) goto L56;
    L58:
        r111 = -2;
    L59:
        r112 = 0;
        r120 = false;
        r119 = 0;
        goto L60
    L56:
        if (r105 > 600) goto L58;
    L68:
        return -1;
    }

    public static void m(String r100, String r101, boolean r102, int r103) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (r100.equals(AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_ON) == true) goto L22;
        String r104 = f(r100, r101);     // Catch: Throwable -> L17
        com.bytedance.crash.i.getContext();     // Catch: Throwable -> L17
        String r105 = com.bytedance.crash.util.b.a();     // Catch: Throwable -> L17
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L17
        com.bytedance.crash.util.j.h(r106, "path", r104);     // Catch: Throwable -> L17
        if (r102 == false) goto L14;
        com.bytedance.crash.util.j.h(r106, "state", "exit");     // Catch: Throwable -> L17
    L15:
        com.bytedance.crash.util.j.h(r106, BdpAppEventConstant.PARAMS_STRATEGY_NAME, String.valueOf(r103));     // Catch: Throwable -> L17
        com.bytedance.crash.util.j.h(r106, "pname", r105);     // Catch: Throwable -> L17
        p.d("disaster:reportEvent aid=" + r100 + " path=" + r101 + " isRestore" + r102 + " strategy=" + r103);     // Catch: Throwable -> L17
        return;
    L14:
        com.bytedance.crash.util.j.h(r106, "state", "enter");     // Catch: Throwable -> L17
        goto L15
    L22:
        return;
    }

    public final void o(String r100, String r101, int r102, long r103, int r110) {
        String r104 = f(r100, r101);
        if (TextUtils.isEmpty(r104) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        if (r102 == 0) goto L9;
        h r105 = this.f203373a.get(r104);     // Catch: Throwable -> L50
        if (r105 != null) goto L14;
        m(r100, r101, false, r102);     // Catch: Throwable -> L50
        r105 = new h(r100, r101);     // Catch: Throwable -> L50
    L14:
        if (r102 == 1) goto L21;
        if (r102 == 0) goto L21;
        if (r102 == r105.f203365e) goto L20;
        r105.f203367g = 1;     // Catch: Throwable -> L50
    L22:
        r105.f203365e = r102;     // Catch: Throwable -> L50
        r105.f203366f = r110;     // Catch: Throwable -> L50
        if (r102 != 1) goto L26;
        r105.f203368h = r103;     // Catch: Throwable -> L50
    L26:
        if (r102 != 5) goto L42;
        p.d("disaster: clearCacheLog");     // Catch: Throwable -> L50
        int r106 = 0;
    L29:
        r106 = r106 + 1;
        int r107 = k();     // Catch: Throwable -> L35
        if (r107 <= 0) goto L36;
        p.d("disaster: got flock");     // Catch: Throwable -> L35
        c(r101);     // Catch: Throwable -> L35
        if (r107 <= 0) goto L38;
        NativeBridge.g0(r107);     // Catch: Throwable -> L35
        goto L38
    L36:
        p.d("disaster: did not got flock, sleep 500ms and retry");     // Catch: Throwable -> L35
        Thread.sleep(50);     // Catch: Throwable -> L35
        boolean r108 = true;
    L39:
        if (r108 == false) goto L42;
        if (r106 < 10) goto L29;
    L38:
        r108 = false;
    L42:
        r105.f203364d = System.currentTimeMillis();     // Catch: Throwable -> L50
        if (com.bytedance.crash.util.c.f203410d != null) goto L46;
        com.bytedance.crash.util.c.f203410d = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss.SSS", Locale.getDefault());     // Catch: Throwable -> L53
    L46:
        com.bytedance.crash.util.c.f203410d.format(new Date(r105.f203364d));     // Catch: Throwable -> L53
    L47:
        this.f203373a.put(r104, r105);     // Catch: Throwable -> L50
        l();     // Catch: Throwable -> L50
        r();     // Catch: Throwable -> L50
    L48:
        monitor-exit(this);     // Catch: Throwable -> L50
        return;
    L20:
        r105.f203367g++;     // Catch: Throwable -> L50
    L21:
        r105.f203367g = 0;     // Catch: Throwable -> L50
        goto L22
    L9:
        if (this.f203373a.containsKey(r104) == false) goto L48;
        n(r104);     // Catch: Throwable -> L50
        m(r100, r101, true, -1);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    }
}
