package n4a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes32.dex */
public final class w4 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f517858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f517859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f517860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f517861d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f517862e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f517863f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f517864g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f517865h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f517866i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f517867j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f517868k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f517869l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f517870m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f517871n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f517872o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f517873p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f517874q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f517875r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f517876s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f517877t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f517878u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f517879v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f517880w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f517881x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f517882y;

        public a() {
        }
    }

    public static String a() {
        String r100 = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L8
        String r101 = "1";
        if (v4.a() == true) goto L6;
        r101 = "0";
    L6:
        int r102 = r100.length();     // Catch: Throwable -> L8
        return r100.substring(0, r102 - 2) + r101 + r100.substring(r102 - 1);
    L8:
        th = move-exception;
        n.a(th, "CI", "TS");
        return null;
    }

    public static String b(Context r100, String r101, String r102) {
        return b5.a(v4.f(r100) + ":" + r101.substring(0, r101.length() - 3) + ":" + r102);
    L5:
        th = move-exception;
        n.a(th, "CI", "Sco");
        return null;
    }

    public static void c(ByteArrayOutputStream r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        f5.f(r100, (byte) 0, new byte[0]);
        return;
    L5:
        if (r101.getBytes().length <= 255) goto L7;
        byte r102 = -1;
    L8:
        f5.f(r100, r102, f5.j(r101));
        return;
    L7:
        r102 = (byte) r101.getBytes().length;
        goto L8
    }

    public static byte[] e(a r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        c(r101, r100.f517858a);     // Catch: Throwable -> L13
        c(r101, r100.f517859b);     // Catch: Throwable -> L13
        c(r101, r100.f517860c);     // Catch: Throwable -> L13
        c(r101, r100.f517861d);     // Catch: Throwable -> L13
        c(r101, r100.f517862e);     // Catch: Throwable -> L13
        c(r101, r100.f517863f);     // Catch: Throwable -> L13
        c(r101, r100.f517864g);     // Catch: Throwable -> L13
        c(r101, r100.f517865h);     // Catch: Throwable -> L13
        c(r101, r100.f517866i);     // Catch: Throwable -> L13
        c(r101, r100.f517867j);     // Catch: Throwable -> L13
        c(r101, r100.f517868k);     // Catch: Throwable -> L13
        c(r101, r100.f517869l);     // Catch: Throwable -> L13
        c(r101, r100.f517870m);     // Catch: Throwable -> L13
        c(r101, r100.f517871n);     // Catch: Throwable -> L13
        c(r101, r100.f517872o);     // Catch: Throwable -> L13
        c(r101, r100.f517873p);     // Catch: Throwable -> L13
        c(r101, r100.f517874q);     // Catch: Throwable -> L13
        c(r101, r100.f517875r);     // Catch: Throwable -> L13
        c(r101, r100.f517876s);     // Catch: Throwable -> L13
        c(r101, r100.f517877t);     // Catch: Throwable -> L13
        c(r101, null);     // Catch: Throwable -> L13
        c(r101, null);     // Catch: Throwable -> L13
        c(r101, r100.f517878u);     // Catch: Throwable -> L13
        c(r101, r100.f517879v);     // Catch: Throwable -> L13
        c(r101, r100.f517880w);     // Catch: Throwable -> L13
        c(r101, r100.f517881x);     // Catch: Throwable -> L13
        c(r101, r100.f517882y);     // Catch: Throwable -> L13
        byte[] r102 = r101.toByteArray();     // Catch: Throwable -> L13
        new String(r102);     // Catch: Throwable -> L13
        byte[] r103 = f5.n(r102);     // Catch: Throwable -> L13
        PublicKey r104 = f5.q();     // Catch: Throwable -> L13
        if (r103.length <= 117) goto L7;
        byte[] r105 = new byte[117];     // Catch: Throwable -> L13
        System.arraycopy(r103, 0, r105, 0, 117);     // Catch: Throwable -> L13
        byte[] r106 = y4.b(r105, r104);     // Catch: Throwable -> L13
        byte[] r107 = new byte[(r103.length + 128) - 117];     // Catch: Throwable -> L13
        System.arraycopy(r106, 0, r107, 0, 128);     // Catch: Throwable -> L13
        System.arraycopy(r103, 117, r107, 128, r103.length - 117);     // Catch: Throwable -> L13
    L31:
        r101.close();     // Catch: Throwable -> L10
    L12:
        return r107;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    L7:
        r107 = y4.b(r103, r104);     // Catch: Throwable -> L13
    L13:
        th = th;
    L40:
        n.a(th, "CI", "gzx");     // Catch: Throwable -> L24
        if (r101 != null) goto L36;
    L23:
        return null;
    L36:
        r101.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
    L24:
        th = move-exception;
        if (r101 != null) goto L33;
    L30:
        throw th;
    L33:
        r101.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = th;
        r101 = null;
        goto L40
    }

    public static a d(Context r110, boolean r111, boolean r112) {
        a r100 = new a();
        r100.f517858a = "";
        r100.f517859b = "";
        String r101 = x4.q(r110);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.f517860c = r101;
        r100.f517861d = v4.d(r110);
        r100.f517862e = Build.MODEL;
        r100.f517863f = Build.MANUFACTURER;
        r100.f517864g = Build.DEVICE;
        r100.f517865h = v4.b(r110);
        r100.f517866i = v4.e(r110);
        r100.f517867j = String.valueOf(Build.VERSION.SDK_INT);
        r100.f517868k = "";
        String r102 = x4.f517938o;     // Catch: Throwable -> L109
        if (r102 != null) goto L9;
    L11:
        DisplayMetrics r103 = new DisplayMetrics();     // Catch: Throwable -> L109
        WindowManager r104 = (WindowManager) r110.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L109
        if (r104 != null) goto L14;
        String r105 = "";
    L21:
        r100.f517869l = r105;
        StringBuilder r106 = new StringBuilder();
        r106.append(x4.r(r110));
        r100.f517870m = r106.toString();
        StringBuilder r107 = new StringBuilder();
        int r108 = x4.d(r110);     // Catch: Throwable -> L24
    L25:
        r107.append(r108);
        r100.f517871n = r107.toString();
        String r109 = x4.b(r110);     // Catch: Throwable -> L28
    L29:
        r100.f517872o = r109;
        if (x4.f517937n == false) goto L114;
    L44:
        String r113 = x4.f517936m;
    L45:
        r100.f517873p = r113;
        r100.f517874q = "";
        r100.f517875r = "";
        int r114 = 0;
        if (r111 == false) goto L48;
        r100.f517876s = "";
        r100.f517877t = "";
    L49:
        r100.f517878u = x4.f517927d;
        String r115 = x4.j(r110);
        if (TextUtils.isEmpty(r115) == true) goto L52;
        r100.f517879v = r115;
    L53:
        r100.f517880w = "aid=";
        if (r112 == false) goto L58;
        if (c.f517196b == false) goto L58;
    L59:
        String r116 = x4.p(r110);
        if (TextUtils.isEmpty(r116) == true) goto L63;
        r100.f517880w += "|oaid=" + r116;
    L63:
        if (TextUtils.isEmpty("") == true) goto L66;
        r100.f517880w += "|multiImeis=";
    L66:
        if (TextUtils.isEmpty("") == true) goto L68;
        r100.f517880w += "|meid=";
    L68:
        r100.f517880w += "|serial=";
        if (TextUtils.isEmpty("") == false) goto L78;
        if (x4.f517928e == null) goto L78;
        String r117 = i.f517363b;     // Catch: Throwable -> L77
        String r118 = null;
    L80:
        if (TextUtils.isEmpty(r118) == true) goto L82;
        r100.f517880w += "|adiuExtras=" + r118;
    L82:
        StringBuilder r119 = new StringBuilder();
        r119.append(r100.f517880w);
        r119.append("|storage=");
        long r120 = x4.f517940q;
        if (r120 == 0) goto L110;
    L87:
        r119.append(r120);
        r119.append("|ram=");
        int r121 = x4.f517941r;
        if (r121 == 0) goto L90;
        r114 = r121;
    L94:
        r119.append(r114);
        r119.append("|arch=");
        if (TextUtils.isEmpty(x4.f517942s) == true) goto L97;
        String r122 = x4.f517942s;
    L98:
        r119.append(r122);
        r100.f517880w = r119.toString();
        String r123 = m.a().b();
        if (TextUtils.isEmpty(r123) == true) goto L101;
        r100.f517881x = r123;
    L102:
        if (r111 == false) goto L106;
        b.a();
        if (TextUtils.isEmpty("") == true) goto L106;
        r100.f517882y = "";
    L106:
        return r100;
    L101:
        r100.f517881x = "";
        goto L102
    L97:
        r122 = System.getProperty("os.arch");
        x4.f517942s = r122;
        goto L98
    L90:
        ActivityManager r124 = (ActivityManager) r110.getSystemService("activity");
        if (r124 == null) goto L94;
        ActivityManager.MemoryInfo r125 = new ActivityManager.MemoryInfo();
        r124.getMemoryInfo(r125);
        r114 = ((int) (r125.totalMem / 1024)) / 1024;
        x4.f517941r = r114;
        goto L94
    L110:
        StatFs r126 = new StatFs(Environment.getRootDirectory().getAbsolutePath());     // Catch: Throwable -> L107
        StatFs r127 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L107
        x4.f517940q = ((r126.getBlockCountLong() * r126.getBlockSizeLong()) / 1048576) + ((r127.getBlockCountLong() * r127.getBlockSizeLong()) / 1048576);     // Catch: Throwable -> L107
    L86:
        r120 = x4.f517940q;
    L78:
        r118 = "";
    L58:
        if (c.f517197c == false) goto L63;
    L52:
        r100.f517879v = "";
        goto L53
    L48:
        String[] r128 = {"", ""};
        r100.f517876s = r128[0];
        r100.f517877t = r128[1];
        goto L49
    L114:
        x4.i(r110);     // Catch: Throwable -> L108
        TelephonyManager r129 = (TelephonyManager) r110.getSystemService("phone");     // Catch: Throwable -> L108
        if (r129 == null) goto L42;
        String r130 = r129.getNetworkOperator();     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r130) == false) goto L38;
    L41:
        x4.f517937n = true;     // Catch: Throwable -> L108
        goto L42
    L38:
        if (r130.length() < 3) goto L41;
        x4.f517936m = r130.substring(3);     // Catch: Throwable -> L108
        x4.f517937n = true;     // Catch: Throwable -> L108
    L42:
        r113 = x4.f517936m;     // Catch: Throwable -> L108
    L28:
        r109 = "";
    L24:
        r108 = -1;
        goto L25
    L14:
        r104.getDefaultDisplay().getMetrics(r103);     // Catch: Throwable -> L109
        int r131 = r103.widthPixels;     // Catch: Throwable -> L109
        int r132 = r103.heightPixels;     // Catch: Throwable -> L109
        if (r132 <= r131) goto L18;
        StringBuilder r133 = new StringBuilder();     // Catch: Throwable -> L109
        r133.append(r131);     // Catch: Throwable -> L109
        r133.append("*");     // Catch: Throwable -> L109
        r133.append(r132);     // Catch: Throwable -> L109
    L19:
        x4.f517938o = r133.toString();     // Catch: Throwable -> L109
        goto L20
    L18:
        r133 = new StringBuilder();     // Catch: Throwable -> L109
        r133.append(r132);     // Catch: Throwable -> L109
        r133.append("*");     // Catch: Throwable -> L109
        r133.append(r131);     // Catch: Throwable -> L109
        goto L19
    L9:
        if ("".equals(r102) == true) goto L11;
        r105 = x4.f517938o;     // Catch: Throwable -> L109
    L20:
        r105 = x4.f517938o;
        goto L21
    }
}
