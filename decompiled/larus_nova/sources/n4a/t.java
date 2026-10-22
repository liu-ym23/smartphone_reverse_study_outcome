package n4a;

import android.content.Context;
import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes32.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f517739a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<h1> f517740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<h1> f517741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f517742d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f517743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f517744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f517745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static e5 f517746h;

    static {
        f517742d = new String[10];
    }

    public t() {
    }

    public static void a(Context r110) {
        Vector<e5> r100 = p.f517579b;
        Looper r101 = Looper.getMainLooper();     // Catch: Throwable -> L11
        monitor-enter(r101);     // Catch: Throwable -> L11
        Vector<e5> r102 = p.f517579b;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
    L13:
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.size() == 0) goto L173;
        String[] r103 = f517742d;
        int r104 = 0;
        String r105 = null;
        PolarisFileWrapper r106 = new PolarisFileWrapper("/data/anr/traces.txt");     // Catch: Throwable -> L68 FileNotFoundException -> L90
        if (r106.exists() == false) goto L116;
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r106);     // Catch: Throwable -> L68 FileNotFoundException -> L90
    L151:
        int r108 = r107.available();     // Catch: Throwable -> L65 FileNotFoundException -> L67
        if (r108 <= 1024000) goto L25;
        r107.skip(r108 - 1024000);     // Catch: Throwable -> L65 FileNotFoundException -> L67
    L25:
        i0 r109 = new i0(r107, h0.f517308p);     // Catch: Throwable -> L65 FileNotFoundException -> L67
        boolean r111 = false;
    L147:
        String r112 = r109.a().trim();     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        if (r112.contains("pid") == false) goto L34;
    L30:
        if (r112.startsWith("\"main\"") == true) goto L32;
        r112 = r109.a();     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        goto L30
    L32:
        r111 = true;
    L34:
        if (r112.equals("") == false) goto L37;
        if (r111 == true) goto L129;
    L37:
        if (r111 == false) goto L147;
        if (f517743e <= 9) goto L41;
        f517743e = 0;     // Catch: Throwable -> L43
    L41:
        int r113 = f517743e;     // Catch: Throwable -> L43
        r103[r113] = r112;     // Catch: Throwable -> L43
        f517743e = r113 + 1;     // Catch: Throwable -> L43
    L45:
        int r114 = f517745g;     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        if (r114 == 5) goto L129;
        if (f517744f == false) goto L50;
        f517745g = r114 + 1;     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        goto L147
    L50:
        Iterator<e5> r115 = r102.iterator();     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
    L52:
        if (r115.hasNext() == false) goto L147;
        e5 r116 = r115.next();     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        boolean r117 = p.b(r116.d(), r112);     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        f517744f = r117;     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        if (r117 == false) goto L52;
        f517746h = r116;     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
    L43:
        th = move-exception;
        r.f(th, "alg", "aDa");     // Catch: Throwable -> L58 FileNotFoundException -> L60 EOFException -> L124
        goto L45
    L58:
        th = th;
    L127:
        r.f(th, "alg", "getA");     // Catch: Throwable -> L78
        if (r109 != null) goto L145;
    L76:
        if (r107 == null) goto L102;
    L137:
        r107.close();     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        r.f(th, "alg", "getA");
    L102:
        if (f517744f == false) goto L116;
        StringBuilder r118 = new StringBuilder();
        int r119 = f517743e;     // Catch: Throwable -> L113
    L106:
        if (r119 >= 10) goto L109;
        if (r119 > 9) goto L109;
        r118.append(r103[r119]);     // Catch: Throwable -> L113
        r119 = r119 + 1;     // Catch: Throwable -> L113
    L109:
        if (r104 >= f517743e) goto L115;
        r118.append(r103[r104]);     // Catch: Throwable -> L113
        r104 = r104 + 1;
    L115:
        r105 = r118.toString();
    L113:
        th = move-exception;
        r.f(th, "alg", "gLI");
        goto L115
    L145:
        r109.close();     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        r.f(th, "alg", "getA");
    L78:
        th = move-exception;
        if (r109 != null) goto L133;
    L84:
        if (r107 == null) goto L168;
        r107.close();     // Catch: Throwable -> L87
        throw th;
    L87:
        th = move-exception;
        r.f(th, "alg", "getA");
        throw th;
    L168:
        throw th;
    L133:
        r109.close();     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        r.f(th, "alg", "getA");
    L129:
        r109.close();     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        r.f(th, "alg", "getA");
    L91:
        if (r109 != null) goto L125;
    L96:
        if (r107 == null) goto L102;
    L125:
        r109.close();     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        r.f(th, "alg", "getA");
        goto L96
    L67:
        r109 = null;
    L65:
        th = th;
        r109 = null;
    L116:
        if (r105 != null) goto L118;
        return;
    L118:
        if ("".equals(r105) == false) goto L120;
        return;
    L120:
        if (f517746h == null) goto L174;
        b(r110, f517746h, 2, "ANR", r105);
        return;
    L174:
        return;
    L90:
        r109 = null;
        r107 = null;
    L68:
        th = th;
        r109 = null;
        r107 = null;
        goto L127
    L173:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        r102 = p.f517579b;
        goto L13
    }

    public static void c(Context r100) {
        WeakReference<h1> r101 = f517740b;
        if (r101 != null) goto L5;
    L6:
        f517740b = new WeakReference(new g1(r100, BaseConstants.Time.HOUR, "hKey", new i1(r100)));
    L7:
        h1 r102 = f517740b.get();
        Vector<e5> r103 = p.f517579b;
        k1.f517430d.b(new s(r100, "d", r102));
        return;
    L5:
        if (r101.get() != null) goto L7;
        goto L6
    }

    public static void d(Context r100) {
        WeakReference<h1> r101 = f517741c;
        if (r101 != null) goto L5;
    L6:
        f517741c = new WeakReference(new g1(r100, BaseConstants.Time.HOUR, "gKey", new i1(r100)));
    L7:
        h1 r102 = f517741c.get();
        Vector<e5> r103 = p.f517579b;
        k1.f517430d.b(new s(r100, "b", r102));
        return;
    L5:
        if (r101.get() != null) goto L7;
        goto L6
    }

    public static void b(Context r100, e5 r101, int r102, String r103, String r110) {
        String r104 = f5.b(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss:SSS");
        StringBuilder r105 = new StringBuilder();
        r105.append("\"sim\":\"");     // Catch: Throwable -> L21
        r105.append("");     // Catch: Throwable -> L21
        r105.append("\",\"sdkversion\":\"");     // Catch: Throwable -> L21
        r105.append(r101.b());     // Catch: Throwable -> L21
        r105.append("\",\"product\":\"");     // Catch: Throwable -> L21
        r105.append(r101.a());     // Catch: Throwable -> L21
        r105.append("\",\"ed\":\"");     // Catch: Throwable -> L21
        r105.append(r101.c());     // Catch: Throwable -> L21
        r105.append("\",\"nt\":\"");     // Catch: Throwable -> L21
        int r106 = -1;
        int r107 = x4.d(r100);     // Catch: Throwable -> L7
    L9:
        r105.append(r107);     // Catch: Throwable -> L21
        r105.append("\",\"np\":\"");     // Catch: Throwable -> L21
        String r108 = x4.b(r100);     // Catch: Throwable -> L12
    L14:
        r105.append(r108);     // Catch: Throwable -> L21
        r105.append("\",\"mnc\":\"");     // Catch: Throwable -> L21
        r105.append("");     // Catch: Throwable -> L21
        r105.append("\",\"ant\":\"");     // Catch: Throwable -> L21
        r106 = x4.c(r100);     // Catch: Throwable -> L17
    L19:
        r105.append(r106);     // Catch: Throwable -> L21
        r105.append("\"");     // Catch: Throwable -> L21
    L23:
        String r109 = r105.toString();
        v4.h(r100);     // Catch: Throwable -> L26
    L28:
        StringBuffer r111 = new StringBuffer();
        r111.append(r109);
        r111.append(",\"timestamp\":\"");
        r111.append(r104);
        r111.append("\",\"et\":\"");
        r111.append(r102);
        r111.append("\",\"classname\":\"");
        r111.append(r103);
        r111.append("\",\"detail\":\"");
        r111.append(r110);
        r111.append("\"");
        String r112 = r111.toString();
        if (r112 != null) goto L31;
        return;
    L31:
        if ("".equals(r112) == true) goto L77;
        String r113 = null;
        if (r110 != null) goto L63;
        byte[] r114 = null;
    L59:
        r113 = f5.s(r114);     // Catch: Throwable -> L42
    L45:
        if (r102 != 1) goto L49;
        Vector<e5> r115 = p.f517579b;
        String r116 = "b";
    L47:
        String r117 = r116;
        n0 r118 = t0.a();
        t0.b(r100, r118, r117, 1000, 4096000, "1");
        if (r118.f517549e != null) goto L69;
        r118.f517549e = new b0(new c0(new e0(new f0())));
    L69:
        o0.a(r113, f5.j(r112.replaceAll("\n", "<br/>")), r118);     // Catch: Throwable -> L58
        return;
    L78:
        return;
    L49:
        if (r102 != 2) goto L51;
        Vector<e5> r119 = p.f517579b;
        r116 = "d";
        goto L47
    L51:
        if (r102 != 0) goto L76;
        Vector<e5> r120 = p.f517579b;
        r116 = "c";
        goto L47
    L76:
        return;
    L42:
        th = move-exception;
        n.a(th, "ut", "csb2h");
        goto L45
    L63:
        MessageDigest r121 = MessageDigest.getInstance(f5.o("ETUQ1"));     // Catch: Throwable -> L38
        r121.update(f5.j(r110));     // Catch: Throwable -> L38
        r114 = r121.digest();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.printStackTrace();
        r114 = new byte[0];
        goto L59
    L77:
        return;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L28
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L19
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        r108 = "";
        goto L14
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        r107 = -1;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    }
}
