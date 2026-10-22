package com.loc;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URL;
import n4a.l0;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f379954a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f379955b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f379956c;

    public c() {
        i.x();
    }

    public static void c() {
        if (f379956c != null) goto L6;
        f379956c = new c();
        return;
    }

    public static boolean d(bo r100) throws l {
        e(r100);
        String r101 = r100.e();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return false;
    L7:
        String r102 = new URL(r101).getHost();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r100.j()) == true) goto L10;
        r102 = r100.j();     // Catch: Throwable -> L12
    L10:
        return i.B(r102);
    L12:
        return true;
    }

    public static void e(bo r100) throws l {
        if (r100.c() == null) goto L8;
        if ("".equals(r100.c()) == true) goto L8;
        return;
    L8:
        throw new l("request url is empty");
    }

    public static l0 a(bo r110) throws l {
        boolean r100 = r110.f379931h;
        e(r110);
        if (r100 == false) goto L5;
        bo.c r101 = bo.c.f379951b;
    L6:
        r110.b(r101);
        int r102 = 5000;
        boolean r103 = false;
        long r104 = 0;
        l0 r105 = null;
        if (d(r110) == false) goto L57;
        e(r110);
        if (d(r110) == false) goto L21;
        if (r110.c().equals(r110.e()) == false) goto L16;
    L20:
        boolean r106 = false;
    L100:
        long r107 = SystemClock.elapsedRealtime();     // Catch: l -> L46
        bo.a r108 = r110.f379932i;     // Catch: l -> L44
        bo.a r111 = bo.a.f379937d;     // Catch: l -> L44
        if (r108 != r111) goto L27;
        bo.b r109 = bo.b.f379945e;     // Catch: l -> L44
    L98:
        e(r110);     // Catch: Throwable -> L41
        int r112 = r110.f379924a;     // Catch: Throwable -> L41
        int r113 = i.f380108o;     // Catch: Throwable -> L41
        bo.a r114 = r110.f379932i;     // Catch: Throwable -> L41
        if (r114 == r111) goto L42;
        if (r114 == bo.a.f379938e) goto L42;
        if (r112 < r113) goto L42;
        if (r106 == false) goto L42;
        r112 = r113;
    L42:
        r105 = b(r110, r109, r112);     // Catch: l -> L44
    L58:
        if (r105 == null) goto L104;
        byte[] r115 = r105.f517453a;
        if (r115 == null) goto L104;
        if (r115.length <= 0) goto L104;
        return r105;
    L104:
        bo.a r116 = r110.f379932i;     // Catch: l -> L91
        bo.a r117 = bo.a.f379937d;     // Catch: l -> L91
        if (r116 != r117) goto L68;
        if (r103 == false) goto L67;
        bo.b r118 = bo.b.f379946f;     // Catch: l -> L91
    L95:
        e(r110);     // Catch: Throwable -> L93
        if (r107 == 0) goto L75;
        r104 = SystemClock.elapsedRealtime() - r107;     // Catch: Throwable -> L93
    L75:
        int r119 = r110.f379924a;     // Catch: Throwable -> L93
        bo.a r120 = r110.f379932i;     // Catch: Throwable -> L93
        if (r120 != r117) goto L78;
    L88:
        r102 = r119;
        goto L89
    L78:
        if (r120 == bo.a.f379938e) goto L88;
        long r121 = r119;
        if (r104 >= r121) goto L86;
        long r122 = r121 - r104;     // Catch: Throwable -> L93
        if (r122 < 1000) goto L86;
        r102 = (int) r122;     // Catch: Throwable -> L93
    L86:
        r102 = Math.min(1000, r119);     // Catch: Throwable -> L93
    L89:
        return b(r110, r118, r102);
    L67:
        r118 = bo.b.f379947g;     // Catch: l -> L91
        goto L95
    L68:
        if (r103 == false) goto L70;
        r118 = bo.b.f379943c;     // Catch: l -> L91
        goto L95
    L70:
        r118 = bo.b.f379944d;     // Catch: l -> L91
    L91:
        e = move-exception;
        throw e;
    L41:
        r112 = 5000;
        goto L42
    L27:
        if (r108 == bo.a.f379938e) goto L31;
        if (r106 == false) goto L31;
        r109 = bo.b.f379941a;     // Catch: l -> L44
    L31:
        r109 = bo.b.f379942b;     // Catch: l -> L44
    L44:
        e = e;
    L49:
        if (e.f() == 21) goto L51;
    L54:
        if (r106 == false) goto L56;
        r103 = true;
        goto L58
    L56:
        throw e;
    L51:
        if (r110.f379932i != bo.a.f379935b) goto L54;
        throw e;
    L46:
        e = e;
        r107 = 0;
        goto L49
    L16:
        if (r110.f379932i == bo.a.f379938e) goto L20;
        if (i.f380112s == false) goto L20;
    L21:
        r106 = true;
        goto L100
    L57:
        r107 = 0;
        goto L58
    L5:
        r101 = bo.c.f379950a;
        goto L6
    }

    public static l0 b(bo r100, bo.b r101, int r102) throws l {
        e(r100);     // Catch: Throwable -> L4 l -> L7
        r100.f379933j = r101;     // Catch: Throwable -> L4 l -> L7
        r100.f379927d = r102;     // Catch: Throwable -> L4 l -> L7
        return new d().d(r100);
    L7:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw new l("未知的错误");
    }
}
