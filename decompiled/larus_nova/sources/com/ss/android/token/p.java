package com.ss.android.token;

import android.content.Context;
import com.bytedance.sdk.account.settings.AccountHostSettingsManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f449777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f449778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f449779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Set<String> f449780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static List<g0> f449781e;

    /* JADX INFO: loaded from: classes38.dex */
    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            TTTokenMonitor.i();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public p() {
    }

    static {
        f449780d = Collections.synchronizedSet(new HashSet());
        f449781e = new ArrayList();
    }

    public static boolean f() {
        if (f449777a == false) goto L5;
    L8:
        return true;
    L5:
        if (f449778b == true) goto L8;
        return false;
    }

    public static synchronized void h() {
        monitor-enter(p.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (f449778b == true) goto L15;
        TokenFactory.j().B();     // Catch: Throwable -> L17
        Set<String> r100 = f449780d;     // Catch: Throwable -> L17
        if (r100 != null) goto L9;
    L14:
        f449778b = true;     // Catch: Throwable -> L17
        TTTokenMonitor.i();     // Catch: Throwable -> L17
        tb7.a.d("TTTokenManager", "TTTokenManager initialize finish");     // Catch: Throwable -> L17
        goto L15
    L9:
        if (r100.isEmpty() == true) goto L14;
        TokenFactory r101 = TokenFactory.j();     // Catch: Throwable -> L17
        Set<String> r102 = f449780d;     // Catch: Throwable -> L17
        if (r101.f449668h == null) goto L13;
        r101.f449668h.b(r102);     // Catch: Throwable -> L17
    L13:
        f449780d.clear();     // Catch: Throwable -> L17
        f449780d = null;     // Catch: Throwable -> L17
    L15:
        monitor-exit(p.class);
    }

    public static e b() {
        if (f() == false) goto L8;
        TokenFactory r100 = TokenFactory.j();
        if (r100.f449668h != null) goto L7;
        return null;
    L7:
        return r100.f449668h.f449774h;
    L8:
        return null;
    }

    public static String d() {
        if (f() == false) goto L5;
        e0 r100 = TokenFactory.j().o();
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.f449725a;
    L5:
        r100 = null;
        goto L6
    }

    public static void c(b r100) {
        TokenFactory r101 = TokenFactory.j();
        if (r101.f449668h != null) goto L5;
        r100.onError("not init TTTokenConfig");
        return;
    L5:
        a0 r102 = new a0(r101, r100);
        if (com.ss.android.account.k.f406318b != null) goto L8;
    L11:
        tb7.a.d("TokenFactory", "TTAccountConfig or TTTokenConfig is null, wait for init finish");
        TokenFactory.b(new b0(r102));
        return;
    L8:
        if (r101.f449668h == null) goto L11;
        r102.run();
    }

    public static void e(Context r100, n r101) {
        if (AccountHostSettingsManager.f269319d.a() > 0) goto L5;
        com.bytedance.android.sdk.bdticketguard.init.i.b();
        TokenFactory.r(r100, r101);
        h();
        f449779c = true;
        return;
    L5:
        if (f449778b == false) goto L8;
        return;
    L8:
        monitor-enter(p.class);
    L16:
        th = move-exception;
        throw th;
    L10:
        if (f449778b == false) goto L13;
        monitor-exit(p.class);     // Catch: Throwable -> L16
        return;
    L13:
        g(r100, r101);     // Catch: Throwable -> L16
        com.bytedance.android.sdk.bdticketguard.init.i.b();     // Catch: Throwable -> L16
        TokenFactory.r(r100, r101);     // Catch: Throwable -> L16
        f449778b = true;     // Catch: Throwable -> L16
        f449779c = true;     // Catch: Throwable -> L16
        TokenFactory.j().f449670j.postDelayed(new a(), 5000);     // Catch: Throwable -> L16
        monitor-exit(p.class);     // Catch: Throwable -> L16
    }

    public static void g(Context r110, n r111) {
        if (f449777a == false) goto L6;
        return;
    L6:
        monitor-enter(p.class);
    L25:
        th = move-exception;
        throw th;
    L8:
        if (f449777a == false) goto L12;
        monitor-exit(p.class);     // Catch: Throwable -> L25
        return;
    L12:
        if (com.bytedance.android.sdk.bdticketguard.init.j.a(com.bytedance.android.sdk.bdticketguard.init.i.f163785a.f163790e) == true) goto L14;
        com.bytedance.android.sdk.bdticketguard.init.i.f163785a = com.bytedance.android.sdk.bdticketguard.init.i.a.a(com.bytedance.android.sdk.bdticketguard.init.i.f163785a, 0, 0, 0, System.currentTimeMillis(), 0, 111);     // Catch: Throwable -> L25
    L14:
        TokenFactory.A(r110, r111);     // Catch: Throwable -> L25
        com.bytedance.sdk.account.utils.c.b();     // Catch: Throwable -> L25
        TokenFactory.j().u();     // Catch: Throwable -> L25
        tb7.a.d("TokenFactory", "preInit() finish, decision=" + AccountHostSettingsManager.f269319d.a());     // Catch: Throwable -> L25
        TokenFactory.j().B();     // Catch: Throwable -> L25
        Set<String> r112 = f449780d;     // Catch: Throwable -> L25
        if (r112 != null) goto L17;
    L22:
        f449777a = true;     // Catch: Throwable -> L25
        monitor-exit(p.class);     // Catch: Throwable -> L25
        return;
    L17:
        if (r112.isEmpty() == true) goto L22;
        TokenFactory r113 = TokenFactory.j();     // Catch: Throwable -> L25
        Set<String> r114 = f449780d;     // Catch: Throwable -> L25
        if (r113.f449668h == null) goto L21;
        r113.f449668h.b(r114);     // Catch: Throwable -> L25
    L21:
        f449780d.clear();     // Catch: Throwable -> L25
        f449780d = null;     // Catch: Throwable -> L25
        goto L22
    }

    public static f a(String r100, String r101, List<o> r102, boolean r103) {
        if (f() == false) goto L23;
        if (r103 == false) goto L6;
        f r104 = TokenFactory.j().c(r100, r101, r102, false);
    L8:
        if (f449781e == null) goto L22;
        if (r104 != null) goto L12;
        r104 = new f();
    L12:
        if (r104.f449733a != null) goto L14;
        r104.f449733a = new HashMap();
    L14:
        Map<String, String> r105 = r104.f449733a;
        Iterator r106 = ((ArrayList) f449781e).iterator();
    L16:
        if (r106.hasNext() == false) goto L22;
        g0 r107 = (g0) r106.next();
        if (r107 == null) goto L16;
        Map<String, String> r108 = r107.a(r100);
        if (r108 == null) goto L16;
        ((HashMap) r105).putAll(r108);
    L22:
        return r104;
    L6:
        r104 = TokenFactory.j().c(r100, r101, r102, true);
        goto L8
    L23:
        return null;
    }
}
