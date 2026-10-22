package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ge;
import com.xiaomi.push.go;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f463070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f178a;

    private j(Context r100) {
        this.f178a = r100.getApplicationContext();
    }

    private static j a(Context r100) {
        if (f463070a != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463070a != null) goto L9;
        f463070a = new j(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f463070a;
    }

    public static void a(Context r100, ha r101) {
        a(r100).a(r101, 0, true);
    }

    private void a(ha r110, int r111, boolean r112) {
        if (com.xiaomi.push.j.m9295a(this.f178a) == false) goto L5;
        return;
    L5:
        if (com.xiaomi.push.j.m9294a() == false) goto L15;
        if (r110 != null) goto L8;
        return;
    L8:
        if (r110.f770a == ge.f463650e) goto L10;
        return;
    L10:
        if (r110.m9197a() == null) goto L18;
        if (r112 == false) goto L19;
        com.xiaomi.channel.commonutils.logger.b.m8718a("click to start activity result:" + String.valueOf(r111));
        hd r100 = new hd(r110.m9197a().m9163a(), false);
        r100.c(go.f463806ae.f650a);
        r100.b(r110.m9198a());
        r100.d(r110.f777b);
        HashMap r113 = new HashMap();
        r100.f789a = r113;
        r113.put("result", String.valueOf(r111));
        u.a(this.f178a).a(r100, ge.f463654i, false, false, null, true, r110.f777b, r110.f773a, true, false);
        return;
    L19:
        return;
    L18:
        return;
    }

    public static void b(Context r100, ha r101, boolean r102) {
        a(r100).a(r101, 2, r102);
    }

    public static void c(Context r100, ha r101, boolean r102) {
        a(r100).a(r101, 3, r102);
    }

    public static void d(Context r100, ha r101, boolean r102) {
        a(r100).a(r101, 4, r102);
    }

    public static void e(Context r100, ha r101, boolean r102) {
        b r103 = b.m8743a(r100);
        if (TextUtils.isEmpty(r103.m8751c()) == false) goto L5;
    L11:
        a(r100).a(r101, 6, r102);
        return;
    L5:
        if (TextUtils.isEmpty(r103.d()) == true) goto L11;
        if (r103.m8755f() == false) goto L10;
        a(r100).a(r101, 7, r102);
        return;
    L10:
        a(r100).a(r101, 5, r102);
    }

    public static void a(Context r100, ha r101, boolean r102) {
        a(r100).a(r101, 1, r102);
    }
}
