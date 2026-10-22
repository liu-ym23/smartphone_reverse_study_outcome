package oh4;

import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.AppInfo;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.p;
import com.bytedance.crash.util.q;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fh4.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f523270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f523271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f523272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PolarisFileWrapper f523273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public uh4.a f523274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f523275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f523276g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f523277a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f523277a;     // Catch: Throwable -> L20
            File r101 = r100.f523270a;     // Catch: Throwable -> L20
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100.f523271b == null) goto L33;
            File[] r102 = r101.listFiles();     // Catch: Throwable -> L20
            if (r102 == null) goto L34;
            if (r102.length < 15) goto L36;
            Arrays.sort(r102, new oh4.c());     // Catch: Throwable -> L25
            int r103 = 0;
        L14:
            if (r103 >= (r102.length - 15)) goto L38;
            File r104 = r102[r103];     // Catch: Throwable -> L25
            if (r100.f523271b.equals(r104.getAbsolutePath()) == true) goto L19;
            h.b(r104);     // Catch: Throwable -> L25
        L19:
            r103 = r103 + 1;
            goto L14
        L38:
            return;
        L37:
            return;
        L36:
            return;
        L34:
            return;
        L33:
            return;
        L20:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L35;
            throw th;
        }

        public a(b r100) {
            this.f523277a = r100;
        }
    }

    /* JADX INFO: renamed from: oh4.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static abstract class AbstractC7056b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.crash.monitor.a f523278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final File f523279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f523280c;

        /* JADX INFO: renamed from: oh4.b$b$a */
        /* JADX INFO: loaded from: classes15.dex */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f523281a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ File f523282b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f523283c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AbstractC7056b f523284d;

            @Override // java.lang.Runnable
            public final void run() {
                this.f523284d.g(this.f523281a, this.f523282b, this.f523283c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(AbstractC7056b r100, g r101, File r102, c r103) {
                this.f523284d = r100;
                this.f523281a = r101;
                this.f523282b = r102;
                this.f523283c = r103;
            }
        }

        public static String d(long r100) {
            if (r100 > 350) goto L6;
            return "~350MB";
        L6:
            if (r100 <= 350) goto L11;
            if (r100 > 450) goto L11;
            return "350MB~450MB";
        L11:
            if (r100 <= 450) goto L16;
            if (r100 > 550) goto L16;
            return "450MB~550MB";
        L16:
            if (r100 <= 550) goto L21;
            if (r100 > 650) goto L21;
            return "550MB~650MB";
        L21:
            if (r100 <= 650) goto L26;
            if (r100 > 750) goto L26;
            return "650MB~750MB";
        L26:
            if (r100 <= 750) goto L31;
            if (r100 > 850) goto L31;
            return "750MB~850MB";
        L31:
            if (r100 <= 850) goto L36;
            if (r100 > 950) goto L36;
            return "850MB~950MB";
        L36:
            if (r100 <= 950) goto L41;
            if (r100 > 1050) goto L41;
            return "950MB~1050MB";
        L41:
            if (r100 <= 1050) goto L46;
            if (r100 > 1250) goto L46;
            return "1050MB~1250MB";
        L46:
            if (r100 <= 1250) goto L51;
            if (r100 > 1450) goto L51;
            return "1250MB~1450MB";
        L51:
            if (r100 <= 1450) goto L56;
            if (r100 > 1650) goto L56;
            return "1450MB~1650MB";
        L56:
            if (r100 <= 1650) goto L61;
            if (r100 > 1850) goto L61;
            return "1650MB~1850MB";
        L61:
            if (r100 > 1850) goto L63;
        L65:
            return ">2.3G";
        L63:
            if (r100 > 2050) goto L65;
            return "1850MB~2050MB";
        }

        public abstract boolean i(File r100, c r101);

        public final void k() {
            File[] r100 = this.f523279b.listFiles();
            if (r100 != null) goto L5;
            return;
        L5:
            int r101 = r100.length;
            int r102 = 0;
            int r103 = 0;
        L6:
            if (r102 >= r101) goto L37;
            File r104 = r100[r102];
            if (this.f523280c.equals(r104.getAbsolutePath()) == true) goto L36;
            if (r104.isFile() == true) goto L36;
            String[] r105 = r104.list();
            if (r105 != null) goto L15;
        L18:
            boolean r106 = true;
        L19:
            if (r106 == true) goto L35;
            int r107 = r103 + 1;
            if (r103 < 10) goto L23;
            r103 = r107;
            goto L35
        L23:
            c r108 = new c();
            HashMap r109 = new HashMap();
            if (i(r104, r108) == false) goto L27;
            h(r109, r108);     // Catch: Throwable -> L29
            NativeBridge.M(r104.getAbsolutePath());     // Catch: Throwable -> L29
            f(r104, r109, r108);     // Catch: Throwable -> L29
        L31:
            h.b(r104);
            r103 = r107;
            goto L36
        L27:
            h.b(r104);     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            p.c("upload exception:" + th);     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            h.b(r104);
            throw th;
        L35:
            h.b(r104);
            goto L36
        L15:
            if (r105.length == 0) goto L18;
            r106 = false;
        L36:
            r102 = r102 + 1;
            goto L6
        }

        public static String a(String r100) {
            StringBuilder r101 = new StringBuilder();
            if (r100.length() >= 16) goto L6;
            r101.append(r100);     // Catch: Throwable -> L11
        L12:
            goto L10
        L6:
            r101.append(r100.charAt(6));     // Catch: Throwable -> L11
            r101.append(r100.charAt(7));     // Catch: Throwable -> L11
            r101.append(r100.charAt(4));     // Catch: Throwable -> L11
            r101.append(r100.charAt(5));     // Catch: Throwable -> L11
            r101.append(r100.charAt(2));     // Catch: Throwable -> L11
            r101.append(r100.charAt(3));     // Catch: Throwable -> L11
            r101.append(r100.charAt(0));     // Catch: Throwable -> L11
            r101.append(r100.charAt(1));     // Catch: Throwable -> L11
            r101.append(r100.charAt(10));     // Catch: Throwable -> L11
            r101.append(r100.charAt(11));     // Catch: Throwable -> L11
            r101.append(r100.charAt(8));     // Catch: Throwable -> L11
            r101.append(r100.charAt(9));     // Catch: Throwable -> L11
            r101.append(r100.charAt(14));     // Catch: Throwable -> L11
            r101.append(r100.charAt(15));     // Catch: Throwable -> L11
            r101.append(r100.charAt(12));     // Catch: Throwable -> L11
            r101.append(r100.charAt(13));     // Catch: Throwable -> L11
            if (r100.length() < 32) goto L12;
            r101.append(r100, 16, 32);     // Catch: Throwable -> L11
            r101.append('0');     // Catch: Throwable -> L11
        L10:
            return r101.toString().toUpperCase();
        }

        public static String e(long r110) {
            Long[] r100 = {0L, 1L, 16L, 128L, 512L, 1024L};
            if (r110 >= 1024) goto L5;
            r100 = new Long[]{0L, 16L, 64L, 128L, 256L, 512L, 1024L};
            String r101 = "KB";
            long r102 = r110;
        L6:
            q r103 = new q(r101);
            r103.c(r100);
            return r103.a(r102);
        L5:
            r102 = r110 / 1024;
            r101 = "MB";
            goto L6
        }

        public AbstractC7056b(com.bytedance.crash.monitor.a r100, PolarisFileWrapper r101) {
            this.f523278a = r100;
            this.f523279b = r101;
            this.f523280c = r101.getAbsolutePath() + HTTP.URL_DEFAULT + com.bytedance.crash.crash.c.a();
        }

        public static String c(String r100, String r101) {
            if (r100 != null) goto L5;
            return "other";
        L5:
            if (r101 != null) goto L7;
        L8:
            r101 = "B";
        L10:
            if (r101.equals("GB") == false) goto L12;
            return "1GB+";
        L12:
            if (r101.equals("MB") == true) goto L33;
            return "0~1MB";
        L33:
            int r102 = CastIntegerProtector.parseInt(r100.substring(0, r100.indexOf(46)));     // Catch: Throwable -> L30
            if (r102 >= 200) goto L21;
            return "0~200MB";
        L21:
            if (r102 >= 500) goto L25;
            return "200~500MB";
        L25:
            if (r102 >= 800) goto L28;
            return "500~800MB";
        L28:
            return "800~1024MB(1G)";
        L30:
            return "other";
        L7:
            if (r101.length() != 0) goto L10;
            goto L8
        }

        public void h(Map<String, String> r100, c r101) {
            HashMap r102 = (HashMap) r100;
            r102.putAll(r101.f523292h);
        }

        public static int b(JSONArray r100, int r101, String r102) {
        L3:
            if (r101 >= r100.length()) goto L10;
            String r103 = r100.optString(r101, null);
            if (r103 == null) goto L9;
            if (r103.startsWith(r102) == false) goto L9;
            return r101;
        L9:
            r101 = r101 + 1;
            goto L3
        L10:
            return -1;
        }

        public static void j(File r100, JSONObject r101, JSONObject r102) {
            PolarisFileWrapper r103 = new PolarisFileWrapper(r100, "summary.json");
            PolarisFileWrapper r104 = new PolarisFileWrapper(r100, "crash_time");
            String r105 = com.bytedance.crash.util.g.f(r103);
            String r106 = com.bytedance.crash.util.g.f(r104);
            JSONObject r107 = r102.optJSONObject("filters");
            if (r105 != null) goto L9;
        L5:
            if (r106 == null) goto L11;
            long r108 = CastLongProtector.parseLong(r106) * 1000;     // Catch: Throwable -> L8
            r102.put("crash_time", r108);     // Catch: Throwable -> L8
            r102.put("timestamp", r108);     // Catch: Throwable -> L8
            return;
        L12:
            return;
        L11:
            return;
        L9:
            JSONObject r109 = new JSONObject(r105);     // Catch: Throwable -> L8
            j.d(r101, r109.optJSONObject("header"));     // Catch: Throwable -> L8
            j.d(r107, r109.optJSONObject("filters"));     // Catch: Throwable -> L8
            r102.put("app_start_time", r101.opt("app_start_time"));     // Catch: Throwable -> L8
            goto L5
        }

        public final void f(File r110, Map<String, String> r111, c r112) {
            com.bytedance.crash.monitor.a r100 = this.f523278a;
            if (r100 == null) goto L12;
            r100.e();
            if (r112.f523289e != 0) goto L7;
            r112.f523289e = Process.myPid();
        L7:
            g r101 = new g(r112.f523285a, r112.f523286b, r112.f523288d, r111, r112.f523287c, "1", (int) r112.f523289e);
            if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L10;
            g(r101, r110, r112);
            return;
        L10:
            wh4.b.post(new a(this, r101, r110, r112));
            return;
        }

        public final void g(g r100, File r101, c r102) {
            JSONObject r103 = Header.b(this.f523278a, System.currentTimeMillis(), CrashType.NATIVE_CUSTOMIZE, (int) r102.f523289e).f203195a;     // Catch: Exception -> L7
            JSONObject r104 = new JSONObject();     // Catch: Exception -> L7
            JSONArray r105 = new JSONArray();     // Catch: Exception -> L7
            JSONObject r106 = r100.e(this.f523278a);     // Catch: Exception -> L7
            r105.put(r106);     // Catch: Exception -> L7
            r104.put("data", r105);     // Catch: Exception -> L7
            r104.put("crash_lib_uuid", r102.f523291g);     // Catch: Exception -> L7
            j.d(r104, r102.f523293i);     // Catch: Exception -> L7
            r104.put("header", r103);     // Catch: Exception -> L7
            j(r101, r103, r106);     // Catch: Exception -> L7
            String r107 = n.d(zg4.g.f572072l.f572078f, r103);     // Catch: Exception -> L7
            String r108 = r104.toString();     // Catch: Exception -> L7
            ArrayList r109 = new ArrayList();     // Catch: Exception -> L7
            r109.add(new File[]{r101}[0]);     // Catch: Exception -> L7
            if (CrashUploader.g("ensure_zip", r107, r108, r109).a() == false) goto L10;
            p.a("ResourceMonitorUploader: upload success");     // Catch: Exception -> L7
            h.b(r101);     // Catch: Exception -> L7
            return;
        L10:
            return;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f523285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f523286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f523287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f523288d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f523289e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f523290f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final JSONArray f523291g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, String> f523292h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final JSONObject f523293i;

        public c() {
            this.f523285a = "";
            this.f523286b = null;
            this.f523287c = null;
            this.f523288d = null;
            this.f523289e = 0;
            this.f523290f = 0;
            this.f523291g = new JSONArray();
            this.f523292h = new HashMap();
            this.f523293i = new JSONObject();
        }
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public b() {
        this.f523275f = false;
        this.f523276g = false;
    }

    public final void c(d r110) {
        monitor-enter(this);
    L117:
        th = move-exception;
        throw th;
    L6:
        if (this.f523276g == false) goto L9;
        monitor-exit(this);
    L79:
        boolean r100 = false;
    L80:
        if (r100 == false) goto L131;
        uh4.a r101 = this.f523274e;
        if (r101.f550090a.exists() == false) goto L88;
        if (r101.f550090a.delete() == true) goto L86;
        p.e("delete guard file faild!");
        goto L88
    L86:
        p.e("delete guard file success");
    L88:
        if (r110.f523299f == 4) goto L115;
        wh4.b.post(new a(this));
        com.bytedance.crash.monitor.a r102 = com.bytedance.crash.monitor.j.f203315a;
        if (r102 == null) goto L115;
        if (this.f523271b == null) goto L115;
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.f523271b, "summary.json");
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        JSONObject r106 = new JSONObject();
        if (r102.i() != 0) goto L98;
    L100:
        r105.put("channel", r102.b());     // Catch: Throwable -> L110
        r105.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L110
        String r107 = Build.VERSION.RELEASE;     // Catch: Throwable -> L110
        if (r107.contains(".") == true) goto L104;
        r107 = r107.concat(".0");     // Catch: Throwable -> L110
    L104:
        r105.put("os_version", r107);     // Catch: Throwable -> L110
        String r108 = zg4.h.f572084a;     // Catch: Throwable -> L110
        r105.put(AppInfo.KEY_NPTH_VERSION_NAME, r108);     // Catch: Throwable -> L110
        r105.put("sdk_version", 4020259);     // Catch: Throwable -> L110
        r105.put("app_start_time", i.b());     // Catch: Throwable -> L110
        if (NativeBridge.G() == false) goto L107;
        String r109 = "true";
    L108:
        r106.put("is_64_runtime", r109);     // Catch: Throwable -> L110
        r106.put("sdk_version", r108);     // Catch: Throwable -> L110
        r104.put("header", r105);     // Catch: Throwable -> L110
        r104.put("filters", r106);     // Catch: Throwable -> L110
        goto L112
    L107:
        r109 = "false";
        goto L108
    L98:
        if (TextUtils.isEmpty(r102.j()) == true) goto L100;
        r105.put("version_code", r102.i());     // Catch: Throwable -> L110
        r105.put("update_version_code", r102.f());     // Catch: Throwable -> L110
        r105.put("version_name", r102.j());     // Catch: Throwable -> L110
        r105.put("app_version", r102.j());     // Catch: Throwable -> L110
        r105.put("manifest_version_code", r102.m());     // Catch: Throwable -> L110
    L112:
        if (r104.length() <= 0) goto L115;
        h.h(r103, r104.toString(), false);     // Catch: Exception -> L120
    L115:
        a();
        return;
    L131:
        return;
    L9:
        r100 = true;
        this.f523276g = true;     // Catch: Throwable -> L117
        int r111 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L117
        if (r111 >= r110.f523294a) goto L13;
    L77:
        p.c("Unsupported API!!!");     // Catch: Throwable -> L117
        monitor-exit(this);
        goto L79
    L13:
        if (r111 > r110.f523295b) goto L77;
        this.f523272c = i.c();     // Catch: Throwable -> L117
        File r112 = r110.b();     // Catch: Throwable -> L117
        this.f523270a = r112;     // Catch: Throwable -> L117
        if (r112 != null) goto L18;
    L74:
        p.c("cannot create " + this.f523270a);     // Catch: Throwable -> L117
        monitor-exit(this);
        goto L79
    L18:
        if (r112.exists() == false) goto L20;
    L22:
        this.f523271b = this.f523270a.getAbsolutePath() + HTTP.URL_DEFAULT + com.bytedance.crash.crash.c.a();     // Catch: Throwable -> L117
        String r113 = this.f523270a.getAbsolutePath();     // Catch: Throwable -> L117
        if (r110.f523296c != null) goto L42;
        int r114 = r110.f523299f;     // Catch: Throwable -> L117
        if (r114 == 0) goto L40;
        if (r114 != 1) goto L28;
        String r115 = "heap_track.guard";
    L41:
        r110.f523296c = r115;     // Catch: Throwable -> L117
        goto L42
    L28:
        if (r114 != 2) goto L30;
        r115 = "fd_track.guard";
        goto L41
    L30:
        if (r114 == 3) goto L37;
        if (r114 != 4) goto L33;
        r115 = "tls_monitor.guard";
        goto L41
    L33:
        if (r114 == 5) goto L35;
        r115 = "unknown";
        goto L41
    L35:
        r115 = "ref_monitor.guard";
        goto L41
    L37:
        r115 = "vm_monitor.guard";
        goto L41
    L40:
        r115 = "gwp_asan.guard";
    L42:
        uh4.a r116 = new uh4.a(r113, r110.f523296c);     // Catch: Throwable -> L117
        this.f523274e = r116;     // Catch: Throwable -> L117
        if (r116.a() == true) goto L47;
        monitor-exit(this);
        goto L79
    L47:
        if (b() == true) goto L50;
        monitor-exit(this);
        goto L79
    L50:
        d(r110);     // Catch: Throwable -> L117
        p.e("loadLibrary...");     // Catch: Throwable -> L117
        if (this.f523275f == true) goto L54;
        com.bytedance.librarian.a.e(r110.a(), true, i.getContext());     // Catch: Throwable -> L121
        this.f523275f = true;     // Catch: Throwable -> L121
    L54:
        if (this.f523275f == true) goto L126;
        p.e("loadLibrary() failed!");     // Catch: Throwable -> L117
        monitor-exit(this);
        goto L79
    L126:
    L70:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L117
    L72:
        monitor-exit(this);
        goto L79
    L59:
        if (this.f523272c == null) goto L72;
        int r117 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L70
        int r118 = r110.f523299f;     // Catch: Throwable -> L70
        String r119 = "lib" + r110.a() + ".so";     // Catch: Throwable -> L70
        com.bytedance.crash.monitor.a r120 = com.bytedance.crash.monitor.j.f203315a;     // Catch: Throwable -> L70
        if (r120 == null) goto L63;
        String r121 = String.valueOf(r120.i());     // Catch: Throwable -> L70
    L64:
        if (NativeResourceMonitor.a(r117, r118, r119, r121, this.f523271b, this.f523272c) == 0) goto L68;
        r100 = false;
    L68:
        monitor-exit(this);
        goto L80
    L63:
        r121 = "unknown";
        goto L64
    L20:
        if (this.f523270a.mkdir() == true) goto L22;
        goto L22
    }

    public final void d(d r100) {
        String r101 = this.f523272c;     // Catch: Throwable -> L29
        if (r100.f523298e != null) goto L24;
        int r102 = r100.f523299f;     // Catch: Throwable -> L29
        if (r102 != 0) goto L7;
        String r103 = "xasan.config";
    L23:
        r100.f523298e = r103;     // Catch: Throwable -> L29
        goto L24
    L7:
        if (r102 != 1) goto L9;
        r103 = "heap_track.config";
        goto L23
    L9:
        if (r102 != 2) goto L11;
        r103 = "fd_track.config";
        goto L23
    L11:
        if (r102 != 3) goto L13;
        r103 = "vmm.config";
        goto L23
    L13:
        if (r102 != 4) goto L15;
        r103 = "tls_monitor.config";
        goto L23
    L15:
        if (r102 == 5) goto L17;
        r103 = "unknown";
        goto L23
    L17:
        r103 = "ref_monitor.config";
    L24:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101, r100.f523298e);     // Catch: Throwable -> L29
        this.f523273d = r104;     // Catch: Throwable -> L29
        if (r104.exists() == true) goto L27;
        this.f523273d.createNewFile();     // Catch: Throwable -> L29
    L27:
        p.c("write Config");     // Catch: Throwable -> L29
        h.h(this.f523273d, r100.toString(), false);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        th.printStackTrace();
    }
}
