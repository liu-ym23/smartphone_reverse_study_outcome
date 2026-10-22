package xg4;

import android.app.ActivityManager;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import androidx.core.app.NotificationCompat;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f563666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f563667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f563668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f563669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f563670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f563671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f563672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f563673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f563674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f563675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f563676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f563677m;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f563678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f563679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f563680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f563681d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f563682e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f563683f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f563684g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f563685h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f563686i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public double f563687j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public double f563688k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public double f563689l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public double f563690m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public double f563691n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public double f563692o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final ArrayList<c> f563693p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public double f563694q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public double f563695r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public double f563696s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public double f563697t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public double f563698u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final ArrayList<Double> f563699v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ j f563700w;

        public final c a() {
            Iterator<c> r100 = this.f563693p.iterator();
        L4:
            if (r100.hasNext() == false) goto L8;
            c r101 = r100.next();
            if (r101.f563709g != this.f563700w.f563668d) goto L4;
            return r101;
        L8:
            return null;
        }

        public final JSONObject b() {
            JSONObject r100 = new JSONObject();
            Iterator<c> r101 = this.f563693p.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            c r102 = r101.next();
            com.bytedance.crash.util.j.h(r100, String.valueOf(r102.f563709g), com.bytedance.crash.util.j.h(com.bytedance.crash.util.j.h(new JSONObject(), "process_name", r102.f563703a), "cpu", Double.valueOf(r102.f563704b)));
            goto L4
        L6:
            return r100;
        }

        public final void c() {
            int r100 = this.f563679b + 1;
        L4:
            if (r100 >= this.f563680c) goto L21;
            int r101 = this.f563678a.indexOf("\n", r100);
            if (r101 < 0) goto L32;
            if ((r101 - r100) > 4) goto L10;
        L22:
            c r102 = d(this.f563678a, r100, r101);     // Catch: Throwable -> L13
        L14:
            if (r102 == null) goto L4;
            if (r102.f563704b < 1.0d) goto L33;
            this.f563693p.add(r102);
        L20:
            r100 = r101 + 1;
            goto L4
        L33:
            return;
        L13:
            r102 = null;
            goto L14
        L10:
            if (this.f563678a.charAt(r100 + 2) == ' ') goto L20;
        L32:
            return;
        }

        public final void e() {
            Iterator<c> r100 = this.f563693p.iterator();
        L4:
            if (r100.hasNext() == false) goto L23;
            c r101 = r100.next();
            String r102 = r101.f563703a;
            double r103 = r101.f563704b;
            if (r102.contains("kworker") == true) goto L7;
            if (r102.contains("kswapd") == true) goto L10;
            if (r102.contains("mmcqd") == true) goto L13;
            if (r102.contains("system_server") == true) goto L16;
            if (r102.contains("lmkd") == true) goto L19;
            if (r102.contains("dex2oat") == false) goto L4;
            this.f563699v.add(Double.valueOf(r103));
            goto L4
        L19:
            this.f563698u += r103;
            goto L4
        L16:
            this.f563697t += r103;
            goto L4
        L13:
            this.f563695r += r103;
            goto L4
        L10:
            this.f563694q += r103;
            goto L4
        L7:
            this.f563696s += r103;
            goto L4
        }

        public final void g(JSONObject r100) {
            r100.put("kswapd", this.f563694q);     // Catch: Throwable -> L10
            r100.put("mmcqd", this.f563695r);     // Catch: Throwable -> L10
            r100.put("kwork", this.f563696s);     // Catch: Throwable -> L10
            r100.put("system_server", this.f563697t);     // Catch: Throwable -> L10
            r100.put("lmkd", this.f563698u);     // Catch: Throwable -> L10
            if (this.f563699v.isEmpty() == true) goto L14;
            JSONArray r101 = new JSONArray();     // Catch: Throwable -> L10
            Iterator<Double> r102 = this.f563699v.iterator();     // Catch: Throwable -> L10
        L6:
            if (r102.hasNext() == false) goto L8;
            r101.put(r102.next());     // Catch: Throwable -> L10
            goto L6
        L8:
            r100.put("dex2oat", r101);     // Catch: Throwable -> L10
            return;
        L14:
            return;
        }

        public final void f(JSONObject r100, boolean r101) {
            if (r101 == false) goto L4;
            String r102 = "user";
        L37:
            r100.put(r102, this.f563688k);     // Catch: Throwable -> L36
            if (r101 == false) goto L8;
            String r103 = NotificationCompat.CATEGORY_SYSTEM;
        L9:
            r100.put(r103, this.f563689l);     // Catch: Throwable -> L36
            if (r101 == false) goto L12;
            String r104 = "iowait";
        L13:
            r100.put(r104, this.f563690m);     // Catch: Throwable -> L36
            if (r101 == false) goto L16;
            String r105 = "irq";
        L17:
            r100.put(r105, this.f563691n);     // Catch: Throwable -> L36
            if (r101 == false) goto L20;
            String r106 = "softirq";
        L21:
            r100.put(r106, this.f563692o);     // Catch: Throwable -> L36
            c r107 = a();     // Catch: Throwable -> L36
            if (r107 == null) goto L31;
            if (r101 == false) goto L25;
            String r108 = "minor";
        L26:
            r100.put(r108, r107.f563707e);     // Catch: Throwable -> L36
            if (r101 == false) goto L29;
            String r109 = "major";
        L30:
            r100.put(r109, r107.f563708f);     // Catch: Throwable -> L36
            goto L31
        L29:
            r109 = "major2";
            goto L30
        L25:
            r108 = "minor2";
        L31:
            if (r101 == false) goto L33;
            String r110 = "before_cpu_list";
        L34:
            r100.put(r110, b());     // Catch: Throwable -> L36
            return;
        L33:
            r110 = "after_cpu_list";
            goto L34
        L20:
            r106 = "softirq2";
            goto L21
        L16:
            r105 = "irq2";
            goto L17
        L12:
            r104 = "iowait2";
            goto L13
        L8:
            r103 = "sys2";
        L39:
            return;
        L4:
            r102 = "user2";
            goto L37
        }

        public a(j r110, String r111, int[] r112) {
            this.f563700w = r110;
            this.f563693p = new ArrayList();
            this.f563699v = new ArrayList();
            this.f563678a = r111;
            boolean r113 = false;
            int r100 = r112[0];
            int r101 = r112[1];
            this.f563679b = r101;
            this.f563680c = r112[2];
            this.f563681d = r112[3];
            b r114 = new b(r111.substring(r100, r101));
            String r115 = r114.a("CPU usage from ", "ms");
            if (r115 == null) goto L20;
            String r102 = r114.a(" to ", "ms");
            if (r102 == null) goto L20;
            String r103 = r114.a(" ", " ");
            if (r103 == null) goto L20;
            String r104 = r114.a("(", " t");
            if (r104 == null) goto L20;
            if (r114.a("o ", ")") == null) goto L20;
            this.f563682e = CastLongProtector.parseLong(r115);     // Catch: Throwable -> L19
            this.f563683f = CastLongProtector.parseLong(r102);     // Catch: Throwable -> L19
            this.f563685h = "ago".equals(r103);     // Catch: Throwable -> L19
            this.f563684g = r104;     // Catch: Throwable -> L19
            boolean r116 = true;
        L21:
            if (r116 == false) goto L66;
            b r117 = new b(this.f563678a.substring(this.f563680c, this.f563681d));
            String r118 = r117.a(null, "% TOTAL:");
            if (r118 == null) goto L63;
            String r105 = r117.a(" ", "% user");
            if (r105 == null) goto L28;
            r117.f563702b += 2;
        L28:
            String r106 = r117.a(" ", "% kernel");
            if (r106 == null) goto L31;
            r117.f563702b += 2;
        L31:
            String r107 = r117.a(" ", "% iowait");
            if (r107 == null) goto L34;
            r117.f563702b += 2;
        L34:
            String r108 = r117.a(" ", "% irq");
            if (r108 == null) goto L37;
            r117.f563702b += 2;
        L37:
            String r109 = r117.a(" ", "% softirq");
            if (r109 != null) goto L68;
            r117.f563702b += 2;
        L68:
            this.f563687j = CastDoubleProtector.parseDouble(r118);     // Catch: Throwable -> L62
            double r119 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (r105 != null) goto L43;
            double r120 = 0.0d;
        L44:
            this.f563688k = r120;     // Catch: Throwable -> L62
            if (r106 != null) goto L47;
            double r121 = 0.0d;
        L48:
            this.f563689l = r121;     // Catch: Throwable -> L62
            if (r107 != null) goto L51;
            double r122 = 0.0d;
        L52:
            this.f563690m = r122;     // Catch: Throwable -> L62
            if (r108 != null) goto L55;
            double r123 = 0.0d;
        L56:
            this.f563691n = r123;     // Catch: Throwable -> L62
            if (r109 == null) goto L60;
            r119 = CastDoubleProtector.parseDouble(r109);     // Catch: Throwable -> L62
        L60:
            this.f563692o = r119;     // Catch: Throwable -> L62
            boolean r124 = true;
        L64:
            if (r124 == false) goto L66;
            r113 = true;
            goto L66
        L55:
            r123 = CastDoubleProtector.parseDouble(r108);     // Catch: Throwable -> L62
            goto L56
        L51:
            r122 = CastDoubleProtector.parseDouble(r107);     // Catch: Throwable -> L62
            goto L52
        L47:
            r121 = CastDoubleProtector.parseDouble(r106);     // Catch: Throwable -> L62
            goto L48
        L43:
            r120 = CastDoubleProtector.parseDouble(r105);     // Catch: Throwable -> L62
        L63:
            r124 = false;
        L66:
            this.f563686i = r113;
            return;
        L20:
            r116 = false;
            goto L21
        }

        public final c d(String r100, int r101, int r102) {
            int r103 = r101 + 2;
            int r104 = r100.indexOf(37, r103);
            c r105 = null;
            if (r104 < 0) goto L36;
            if (r104 > r102) goto L36;
            double r106 = CastDoubleProtector.parseDouble(r100.substring(r103, r104));
            int r107 = r104 + 2;
            int r108 = r100.indexOf(47, r107);
            if (r108 < 0) goto L36;
            if (r108 > r102) goto L36;
            int r109 = CastIntegerProtector.parseInt(r100.substring(r107, r108));
            int r110 = r108 + 1;
            int r111 = r100.indexOf(": ", r110);
            if (r111 < 0) goto L36;
            if (r111 > r102) goto L36;
            r105 = new c(r109, r100.substring(r110, r111), r106);
            if (r109 != this.f563700w.f563668d) goto L36;
            int r112 = r111 + 2;
            int r113 = r100.indexOf("% user + ", r112);
            if (r113 < 0) goto L36;
            if (r113 > r102) goto L36;
            r105.f563705c = CastDoubleProtector.parseDouble(r100.substring(r112, r113));
            int r114 = r113 + 9;
            int r115 = r100.indexOf("% kernel", r114);
            if (r115 < 0) goto L36;
            if (r115 > r102) goto L36;
            r105.f563706d = CastDoubleProtector.parseDouble(r100.substring(r114, r115));
            int r116 = r100.indexOf("faults: ", r115);
            if (r116 < 0) goto L36;
            if (r116 > r102) goto L36;
            int r117 = r116 + 8;
            int r118 = r100.indexOf(" minor", r117);
            if (r118 <= 0) goto L32;
            if (r118 >= r102) goto L32;
            r105.f563707e = CastLongProtector.parseLong(r100.substring(r117, r118));
            r117 = r118 + 7;
        L32:
            int r119 = r100.indexOf(" major", r117);
            if (r119 <= 0) goto L36;
            if (r119 >= r102) goto L36;
            r105.f563708f = CastLongProtector.parseLong(r100.substring(r117, r119));
        L36:
            return r105;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f563701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f563702b;

        public b(String r100) {
            this.f563701a = r100;
            this.f563702b = 0;
        }

        public final String a(String r100, String r101) {
            int r102 = this.f563702b;
            if (r100 == null) goto L8;
            int r103 = this.f563701a.indexOf(r100, r102);
            if (r103 >= 0) goto L7;
            return null;
        L7:
            this.f563702b = r103 + r100.length();
        L8:
            int r104 = this.f563701a.indexOf(r101, this.f563702b);
            if (r104 >= 0) goto L12;
            this.f563702b = r102;
            return null;
        L12:
            String r105 = this.f563701a.substring(this.f563702b, r104);
            this.f563702b = r104 + r101.length();
            return r105;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f563703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f563704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f563705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f563706d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f563707e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f563708f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f563709g;

        public c(int r100, String r101, double r102) {
            this.f563709g = r100;
            this.f563703a = r101;
            this.f563704b = r102;
        }
    }

    public final String e() {
        String r100 = this.f563670f;
        if (r100 != null) goto L5;
        return "invalid";
    L5:
        if (r100.equals("Input dispatching timed out") == false) goto L43;
        String r101 = this.f563669e.toLowerCase();
        if (r101.contains("no window has focus but there is a focused application") == false) goto L9;
        return "no focused window";
    L9:
        if (r101.contains("does not have a focused window") == false) goto L12;
        return "no focused window";
    L12:
        if (r101.contains("waiting to send non-key event because the touched window has not finished") == false) goto L16;
        return "non-key event not finished";
    L16:
        if (r101.contains("waiting to send key event because the focused window has not finished") == false) goto L20;
        return "key event not finished";
    L20:
        if (r101.contains("window is paused") == false) goto L23;
        return "window is paused";
    L23:
        if (r101.contains("window’s input channel is not registered") == false) goto L27;
        return "input channel not registered";
    L27:
        if (r101.contains("window’s input connection is") == false) goto L31;
        return "window being removed";
    L31:
        if (r101.contains("window’s input channel is full") == false) goto L35;
        return "input channel is full";
    L35:
        if (r101.contains("is not responding. waited") == false) goto L44;
        return "activity is not responding";
    L44:
        return "invalid";
    L43:
        return "invalid";
    }

    public j() {
        this.f563674j = new float[]{-1.0f, -1.0f, -1.0f};
        this.f563665a = null;
        this.f563666b = false;
        g(null);
    }

    public j(File r110) {
        this.f563674j = new float[]{-1.0f, -1.0f, -1.0f};
        String r100 = com.bytedance.crash.util.g.f(new PolarisFileWrapper(r110, "anr_info.txt"));
        if (r100 != null) goto L5;
    L82:
        this.f563665a = r100;
        this.f563666b = !new PolarisFileWrapper(r110, "from_external_flag").exists();
        return;
    L5:
        if (r100.isEmpty() == true) goto L82;
        String r101 = "unknown";
        if (r100.equals("silent anr no anr info") == false) goto L10;
        this.f563670f = "silent anr";
    L60:
        if (TextUtils.isEmpty(this.f563671g) == true) goto L65;
        if ("null".equals(this.f563671g) == true) goto L65;
        String r102 = this.f563671g;
    L81:
        this.f563671g = r102;
    L65:
        if (TextUtils.isEmpty(this.f563669e) == false) goto L67;
    L80:
        r102 = r101;
        goto L81
    L67:
        if ("null".equals(this.f563669e) == true) goto L80;
        if (this.f563669e.contains("executing service") == false) goto L76;
        String r103 = this.f563669e;
        String r104 = r103.substring(r103.indexOf("service ") + 8).trim();
        String[] r105 = r104.split(HTTP.URL_DEFAULT);
        if (r105.length <= 1) goto L74;
        r104 = r105[r105.length - 1];
    L74:
        r101 = r104;
        goto L80
    L76:
        if (this.f563669e.contains("Broadcast of Intent") == false) goto L80;
        String r106 = this.f563669e;
        r104 = r106.substring(r106.indexOf("{") + 1, this.f563669e.indexOf(com.alipay.sdk.m.u.i.f25855d)).trim();
        String[] r107 = r104.split(HTTP.URL_DEFAULT);
        if (r107.length <= 1) goto L74;
        r104 = r107[r107.length - 1];
        goto L74
    L10:
        if (r100.equals("close anr_info report") == false) goto L12;
        this.f563670f = "Not report anrInfo";
        goto L60
    L12:
        int r108 = g(r100);
        if (r108 >= 0) goto L16;
        com.bytedance.crash.util.p.c("Anr Info Parse Error:" + r108);
    L16:
        if (TextUtils.isEmpty(this.f563669e) == false) goto L18;
    L57:
        String r109 = "unknown";
    L58:
        this.f563670f = r109;
        goto L60
    L18:
        if ("null".equals(this.f563669e) == true) goto L57;
        if (this.f563669e.startsWith("ANR ") == false) goto L56;
        r109 = "Input dispatching timed out";
        if (this.f563669e.startsWith("Input dispatching timed out", 4) == false) goto L39;
        String r111 = this.f563669e;
        if (r111.contains("Waiting to send non-key event") == false) goto L30;
        if (r111.contains("finished processing certain input events that were delivered") == false) goto L30;
        r109 = "Input dispatching timed out (Waiting to send non-key event because the touched window has not finished processing certain input events that were delivered to it over xxms ago.  Wait queue length: xx.  Wait queue head age: xxms.)";
    L30:
        if (r111.contains("Application does not have a focused window") == false) goto L33;
        r109 = "Input dispatching timed out (Application does not have a focused window)";
        goto L58
    L33:
        if (r111.contains("Waiting because no window has focus but there is a focused") == false) goto L36;
        r109 = "Input dispatching timed out (Waiting because no window has focus but there is a focused application that may eventually add a window when it finishes starting up.)";
        goto L58
    L36:
        if (r111.contains("window's input channel is full.") == false) goto L58;
        r109 = "Input dispatching timed out (Waiting because the touched window input channel is full.Outbound queue length: XXX.Wait queue length: XX.)";
        goto L58
    L39:
        if (this.f563669e.startsWith("executing service", 4) == false) goto L42;
        r109 = "executing service";
        goto L58
    L42:
        if (this.f563669e.startsWith("Broadcast of Intent", 4) == false) goto L44;
        r109 = "Broadcast of Intent";
        goto L58
    L44:
        r109 = "keyDispatchingTimedOut";
        if (this.f563669e.startsWith("keyDispatchingTimedOut", 4) == true) goto L58;
        r109 = "not then call Service.startForeground";
        if (this.f563669e.contains("not then call Service.startForeground") == true) goto L58;
        String r112 = this.f563669e.substring(4);
        if (r112 != null) goto L85;
        r112 = null;
    L53:
        r109 = r112;
        goto L58
    L85:
        r112 = r112.replaceAll("\\d+", "xxx");     // Catch: Throwable -> L84
        goto L53
    L56:
        r109 = this.f563669e;
        goto L58
    }

    public static String a(float r110) {
        if (r110 >= 0.0f) goto L7;
        return "invalid";
    L7:
        if (r110 <= 100.0f) goto L11;
        return "> 100";
    L11:
        return new String[]{"0~10", "10~20", "20~30", "30~40", "40~50", "50~60", "60~70", "70~80", "80~90", "90~100"}[((int) r110) / 10];
    }

    public static String c(float r210) {
        if (r210 >= 0.0f) goto L6;
        return "invalid";
    L6:
        float[] r100 = {2000.0f, 3000.0f, 4000.0f, 5000.0f, 10000.0f, 20000.0f, 30000.0f, 40000.0f, 50000.0f, 60000.0f, 70000.0f, 80000.0f, 90000.0f, 100000.0f, 150000.0f, 200000.0f, 300000.0f, 400000.0f, 500000.0f};
        String[] r101 = {"0~2k", "2k~3k", "3k~4k", "4k~5k", "5k~1w", "1w~2w", "2w~3w", "3w~4w", "4w~5w", "5w~6w", "7w~8w", "8w~9w", "9w~10w", "10w~15w", "15w~20w", "20w~30w", "30w~40w", "40w~50w", "> 50w"};
        int r102 = 0;
    L7:
        if (r102 >= 19) goto L14;
        if (r210 <= r100[r102]) goto L11;
        r102 = r102 + 1;
        goto L7
    L11:
        return r101[r102];
    L14:
        return r101[18];
    }

    public static String d(ActivityManager.ProcessErrorStateInfo r100) {
        return "|------------- processErrorStateInfo--------------|\ncondition: " + r100.condition + "\nprocessName: " + r100.processName + "\npid: " + r100.pid + "\nuid: " + r100.uid + "\ntag: " + r100.tag + "\nshortMsg : " + r100.shortMsg + "\nlongMsg : " + r100.longMsg + "\n-----------------------end----------------------------";
    }

    public final int g(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return -1;
    L5:
        if (r110.startsWith("|------------- processErrorStateInfo--------------|\n") == true) goto L7;
        return -1;
    L7:
        if (r110.endsWith("-----------------------end----------------------------") == false) goto L123;
        b r100 = new b(r110);     // Catch: Throwable -> L100
        r100.f563702b = 52;     // Catch: Throwable -> L100
        if (r100.a("condition: ", "\n") != null) goto L13;
        return -2;
    L13:
        String r101 = r100.a("processName: ", "\n");     // Catch: Throwable -> L100
        if (r101 != null) goto L17;
        return -3;
    L17:
        this.f563667c = r101;     // Catch: Throwable -> L100
        String r102 = r100.a("pid: ", "\n");     // Catch: Throwable -> L100
        if (r102 != null) goto L107;
        return -4;
    L107:
        this.f563668d = CastIntegerProtector.parseInt(r102);     // Catch: Throwable -> L98
        if (r100.a("uid: ", "\n") != null) goto L26;
        return -6;
    L26:
        String r103 = r100.a("tag: ", "\n");     // Catch: Throwable -> L100
        if (r103 != null) goto L30;
        return -7;
    L30:
        this.f563671g = r103;     // Catch: Throwable -> L100
        int r104 = r110.indexOf("shortMsg : ", r100.f563702b);     // Catch: Throwable -> L100
        if (r104 >= 0) goto L34;
        return -8;
    L34:
        int r105 = r104 + 11;     // Catch: Throwable -> L100
        int r106 = r110.indexOf(10, r105);     // Catch: Throwable -> L100
        if (r106 >= 0) goto L38;
        return -9;
    L38:
        int r107 = r110.indexOf("longMsg : ", r106);     // Catch: Throwable -> L100
        if (r107 >= 0) goto L42;
        return -10;
    L42:
        this.f563672h = r107 + 10;     // Catch: Throwable -> L100
        this.f563669e = r110.substring(r105, r107 - 1);     // Catch: Throwable -> L100
        int r108 = r110.length() - 54;     // Catch: Throwable -> L100
        this.f563673i = r108;     // Catch: Throwable -> L100
        if (r108 == 0) goto L83;
        int r109 = this.f563672h;     // Catch: Throwable -> L100
    L46:
        if (r109 >= this.f563673i) goto L73;
        int r111 = r110.indexOf("\n", r109);     // Catch: Throwable -> L100
        if (r111 < 0) goto L73;
        int[] r112 = new int[4];     // Catch: Throwable -> L100
    L50:
        int r113 = r110.indexOf("\n", r109);     // Catch: Throwable -> L100
        if (r113 < 0) goto L61;
        if (r110.startsWith("CPU usage from", r109) == true) goto L54;
        r109 = r113 + 1;     // Catch: Throwable -> L100
        goto L50
    L54:
        r112[0] = r109;     // Catch: Throwable -> L100
        r112[1] = r113;     // Catch: Throwable -> L100
        int r114 = r110.indexOf("% TOTAL: ", r113 + 1);     // Catch: Throwable -> L100
        if (r114 <= 0) goto L61;
        int r115 = r110.lastIndexOf(10, r114) + 1;     // Catch: Throwable -> L100
        int r116 = r110.indexOf(10, r114);     // Catch: Throwable -> L100
        if (r115 <= 0) goto L61;
        if (r116 <= 0) goto L61;
        r112[2] = r115;     // Catch: Throwable -> L100
        r112[3] = r116;     // Catch: Throwable -> L100
    L62:
        if (r112 != null) goto L63;
        r109 = r111 + 1;     // Catch: Throwable -> L100
        goto L46
    L63:
        a r117 = new a(this, r110, r112);     // Catch: Throwable -> L100
        if (r117.f563686i == true) goto L66;
    L71:
        r109 = r112[3] + 1;     // Catch: Throwable -> L100
        goto L46
    L66:
        if (this.f563675k != null) goto L69;
        this.f563675k = r117;     // Catch: Throwable -> L100
        r117.c();     // Catch: Throwable -> L100
        goto L71
    L69:
        if (this.f563676l != null) goto L71;
        this.f563676l = r117;     // Catch: Throwable -> L100
        r117.c();     // Catch: Throwable -> L100
    L61:
        r112 = null;
    L73:
        a r118 = this.f563675k;     // Catch: Throwable -> L100
        this.f563677m = r118;     // Catch: Throwable -> L100
        if (this.f563676l != null) goto L76;
    L80:
        a r119 = this.f563677m;     // Catch: Throwable -> L100
        if (r119 == null) goto L83;
        r119.e();     // Catch: Throwable -> L100
        goto L83
    L76:
        if (r118.f563685h == false) goto L80;
        long r120 = Math.abs(r118.f563682e + r118.f563683f);     // Catch: Throwable -> L100
        a r121 = this.f563676l;     // Catch: Throwable -> L100
        if (r120 <= Math.abs(r121.f563682e + r121.f563683f)) goto L80;
        this.f563677m = this.f563676l;     // Catch: Throwable -> L100
    L83:
        String r122 = r100.a("Load: ", "\n");     // Catch: Throwable -> L100
        if (r122 == null) goto L97;
        String[] r123 = r122.split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L100
        if (this.f563674j.length != r123.length) goto L97;
        int r124 = 0;
    L88:
        if (r124 >= r123.length) goto L97;
        float[] r125 = this.f563674j;     // Catch: Throwable -> L100
        Float r126 = CastFloatProtector.valueOf(r123[r124].trim());     // Catch: Exception -> L93 Throwable -> L100
    L95:
        r125[r124] = r126.floatValue();     // Catch: Throwable -> L100
        r124 = r124 + 1;
        goto L88
    L94:
        r126 = Float.valueOf(-1.0f);     // Catch: Throwable -> L100
    L97:
        return 0;
    L98:
        return -5;
    L100:
        th = move-exception;
        ch4.c.b("NPTH_ANR_ERROR", th);
        return -11;
    L123:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [xg4.j] */
    /* JADX WARN: Type inference failed for: r1v4, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v3, types: [xg4.j$a] */
    /* JADX WARN: Type inference failed for: r7v4, types: [xg4.j$a] */
    /* JADX WARN: Type inference failed for: r7v5, types: [xg4.j$a] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h(JSONObject r110) {
        a r100 = this.f563677m;
        if (r100 != null) goto L78;
    L19:
        long r101 = 0;
    L20:
        long r102 = r110.optLong("crash_time");
        if (r101 > 0) goto L23;
    L25:
        com.bytedance.crash.util.j.h(r110, "anr_info", this.f563665a);
        ?? r103 = com.bytedance.crash.util.j.e(r110, "anr_atribute");
        ?? r104 = new JSONObject();
        c r105 = null;
        i(r104);     // Catch: Throwable -> L43
        ?? r106 = this.f563675k;     // Catch: Throwable -> L43
        if (r106 == 0) goto L29;
        r106.f(r104, true);     // Catch: Throwable -> L43
    L29:
        ?? r107 = this.f563676l;     // Catch: Throwable -> L43
        if (r107 == 0) goto L32;
        r107.f(r104, false);     // Catch: Throwable -> L43
    L32:
        ?? r108 = this.f563677m;     // Catch: Throwable -> L43
        if (r108 == 0) goto L40;
        r108.g(r104);     // Catch: Throwable -> L43
        a r109 = this.f563677m;     // Catch: Throwable -> L43
        if (r109.f563693p.size() == 0) goto L37;
        c r111 = (c) ListProtector.get(r109.f563693p, 0);     // Catch: Throwable -> L43
    L38:
        if (r111 == null) goto L40;
        r104.put("top_cpu_process_name", r111.f563703a);     // Catch: Throwable -> L43
        ?? r112 = this.f563667c.equals(r111.f563703a);     // Catch: Throwable -> L43
    L41:
        r104.put("top_cpu_process_is_anrapp", r112);     // Catch: Throwable -> L43
        r104.put("process_name", this.f563667c);     // Catch: Throwable -> L43
        r103.put("cpu", r104);     // Catch: Throwable -> L43
    L45:
        JSONObject r113 = com.bytedance.crash.util.j.e(r110, "features_str");
        JSONObject r114 = com.bytedance.crash.util.j.e(r110, "features_num");
        a r115 = this.f563677m;
        if (r115 == null) goto L62;
        com.bytedance.crash.util.j.h(r114, "cpu_total", Double.valueOf(r115.f563687j));
        com.bytedance.crash.util.j.h(r114, "cpu_user", Double.valueOf(r115.f563688k));
        com.bytedance.crash.util.j.h(r114, "cpu_kernel", Double.valueOf(r115.f563689l));
        com.bytedance.crash.util.j.h(r114, "cpu_iowait", Double.valueOf(r115.f563690m));
        com.bytedance.crash.util.j.h(r114, "cpu_irq", Double.valueOf(r115.f563691n));
        com.bytedance.crash.util.j.h(r114, "cpu_softirq", Double.valueOf(r115.f563692o));
        if (r115.f563693p.size() == 0) goto L50;
        r105 = (c) ListProtector.get(r115.f563693p, 0);
    L50:
        if (r105 == null) goto L52;
        com.bytedance.crash.util.j.h(r113, "top_cpu_process_name", r105.f563703a);
    L52:
        c r116 = r115.a();
        if (r116 == null) goto L71;
        com.bytedance.crash.util.j.h(r114, "cpu_app_total", Double.valueOf(r116.f563704b));
        com.bytedance.crash.util.j.h(r114, "cpu_app_user", Double.valueOf(r116.f563705c));
        com.bytedance.crash.util.j.h(r114, "cpu_app_kernel", Double.valueOf(r116.f563706d));
        com.bytedance.crash.util.j.h(r114, "minor_rate", Long.valueOf(r116.f563707e));
        com.bytedance.crash.util.j.h(r114, "major_rate", Long.valueOf(r116.f563708f));
    L71:
        r114.put("cpu_kswapd", r115.f563694q);     // Catch: Throwable -> L61
        r114.put("cpu_mmcqd", r115.f563695r);     // Catch: Throwable -> L61
        r114.put("cpu_kwork", r115.f563696s);     // Catch: Throwable -> L61
        r114.put("cpu_system_server", r115.f563697t);     // Catch: Throwable -> L61
        r114.put("cpu_lmkd", r115.f563698u);     // Catch: Throwable -> L61
        Iterator<Double> r117 = r115.f563699v.iterator();     // Catch: Throwable -> L61
        float r118 = 0.0f;
    L57:
        if (r117.hasNext() == false) goto L59;
        r118 = (float) (((double) r118) + r117.next().doubleValue());     // Catch: Throwable -> L61
        goto L57
    L59:
        r114.put("cpu_dex2oat", r118);     // Catch: Throwable -> L61
    L62:
        JSONObject r119 = r110.optJSONObject("app_memory_info");
        if (r119 == null) goto L67;
        long r120 = r119.optLong("max_memory");
        long r121 = r119.optLong("free_memory");
        long r122 = r119.optLong("total_memory");
        if (r120 <= 0) goto L67;
        com.bytedance.crash.util.j.h(r114, "java_heap_usage", Long.valueOf(((r122 - r121) * 100) / r120));
    L67:
        JSONObject r123 = r110.optJSONObject("memory_info");
        if (r123 == null) goto L81;
        com.bytedance.crash.util.j.h(r114, "total_pss", Long.valueOf(r123.optLong("totalPss") / 1048576));
        return;
    L81:
        return;
    L37:
        r111 = null;
    L40:
        r112 = -1;
    L43:
        th = move-exception;
        com.bytedance.crash.util.p.d(th);
        goto L45
    L23:
        if (r101 >= r102) goto L25;
        com.bytedance.crash.util.j.h(r110, "crash_time", Long.valueOf(r101));
        goto L25
    L78:
        String r124 = r100.f563684g;     // Catch: Throwable -> L18
        if (com.bytedance.crash.util.c.f203408b != null) goto L7;
        com.bytedance.crash.util.c.f203408b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());     // Catch: Throwable -> L18
    L7:
        Date r125 = com.bytedance.crash.util.c.f203408b.parse(r124);     // Catch: Throwable -> L18
        if (r125 == null) goto L11;
        r101 = r125.getTime();     // Catch: Throwable -> L18
    L76:
        if (r100.f563685h == false) goto L16;
        r101 = r101 + r100.f563682e;     // Catch: Throwable -> L17
    L75:
        goto L20
    L16:
        r101 = r101 - r100.f563682e;
        goto L75
    L11:
        r101 = 0;
        goto L76
    }

    public final void i(JSONObject r100) {
        int r101 = this.f563672h;
    L4:
        if (r101 >= this.f563673i) goto L11;
        int r102 = this.f563665a.indexOf("\n", r101);
        if (r102 < 0) goto L11;
        if (this.f563665a.startsWith("Load: ", r101) == true) goto L9;
        r101 = r102 + 1;
        goto L4
    L9:
        String r103 = this.f563665a.substring(r101 + 6, r102);
    L12:
        if (r103 == null) goto L24;
        String[] r104 = r103.split(" / ");
        if (r104.length == 3) goto L19;
        return;
    L19:
        double r105 = CastDoubleProtector.parseDouble(r104[0].trim());     // Catch: Throwable -> L18
        double r106 = CastDoubleProtector.parseDouble(r104[1].trim());     // Catch: Throwable -> L18
        double r107 = CastDoubleProtector.parseDouble(r104[2].trim());     // Catch: Throwable -> L18
        JSONArray r108 = new JSONArray();     // Catch: Throwable -> L18
        r108.put(r105);     // Catch: Throwable -> L18
        r108.put(r106);     // Catch: Throwable -> L18
        r108.put(r107);     // Catch: Throwable -> L18
        r100.put("load", r108);     // Catch: Throwable -> L18
        return;
    L26:
        return;
    L24:
        return;
    L11:
        r103 = null;
        goto L12
    }

    public static boolean b(String r100, String r101) {
        if (r100 == null) goto L5;
        if (r101 == null) goto L5;
        return r100.equals(r101);
    L5:
        if (r100 != null) goto L8;
        if (r101 != null) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean f(ActivityManager.ProcessErrorStateInfo r100, ActivityManager.ProcessErrorStateInfo r101) {
        if (r100.condition == r101.condition) goto L5;
    L17:
        return false;
    L5:
        if (r100.pid != r101.pid) goto L17;
        if (r100.uid != r101.uid) goto L17;
        if (b(r100.processName, r101.processName) == false) goto L17;
        if (b(r100.tag, r101.tag) == false) goto L17;
        if (b(r100.shortMsg, r101.shortMsg) == false) goto L17;
        if (b(r100.longMsg, r101.longMsg) == false) goto L17;
        return true;
    }
}
