package com.ss.android.token;

import android.content.Context;
import com.bytedance.android.sdk.bdticketguard.init.i;
import com.bytedance.android.sdk.bdticketguard.init.j;
import com.bytedance.sdk.account.settings.AccountHostSettingsManager;
import com.ss.android.account.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class p {
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static Set<String> d;
    public static List<g0> e;

    public p() {
    }

    static {
        d = Collections.synchronizedSet(new HashSet());
        e = new ArrayList();
    }

    public static boolean f() {
        if (a == false) goto L5;
    L8:
        return true;
    L5:
        if (b == true) goto L8;
        return false;
    }

    public static synchronized void h() {
        monitor-enter(p.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (b == true) goto L15;
        TokenFactory.j().B();     // Catch: Throwable -> L17
        Set<String> r1 = d;     // Catch: Throwable -> L17
        if (r1 != null) goto L9;
    L14:
        b = true;     // Catch: Throwable -> L17
        TTTokenMonitor.i();     // Catch: Throwable -> L17
        a.d("TTTokenManager", "TTTokenManager initialize finish");     // Catch: Throwable -> L17
        goto L15
    L9:
        if (r1.isEmpty() == true) goto L14;
        TokenFactory r2 = TokenFactory.j();     // Catch: Throwable -> L17
        Set<String> r3 = d;     // Catch: Throwable -> L17
        if (r2.h == null) goto L13;
        r2.h.b(r3);     // Catch: Throwable -> L17
    L13:
        d.clear();     // Catch: Throwable -> L17
        d = null;     // Catch: Throwable -> L17
    L15:
        monitor-exit(p.class);
    }

    public static e b() {
        if (f() == false) goto L8;
        TokenFactory r0 = TokenFactory.j();
        if (r0.h != null) goto L7;
        return null;
    L7:
        return r0.h.h;
    L8:
        return null;
    }

    public static String d() {
        if (f() == false) goto L5;
        e0 r0 = TokenFactory.j().o();
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.a;
    L5:
        r0 = null;
        goto L6
    }

    public static void c(b r2) {
        TokenFactory r0 = TokenFactory.j();
        if (r0.h != null) goto L5;
        r2.onError("not init TTTokenConfig");
        return;
    L5:
        a0 r1 = new a0(r0, r2);
        if (k.b != null) goto L8;
    L11:
        a.d("TokenFactory", "TTAccountConfig or TTTokenConfig is null, wait for init finish");
        TokenFactory.b(new b0(r1));
        return;
    L8:
        if (r0.h == null) goto L11;
        r1.run();
    }

    public static void e(Context r3, n r4) {
        if (AccountHostSettingsManager.d.a() > 0) goto L5;
        i.b();
        TokenFactory.r(r3, r4);
        h();
        c = true;
        return;
    L5:
        if (b == false) goto L8;
        return;
    L8:
        monitor-enter(p.class);
    L16:
        th = move-exception;
        throw th;
    L10:
        if (b == false) goto L13;
        monitor-exit(p.class);     // Catch: Throwable -> L16
        return;
    L13:
        g(r3, r4);     // Catch: Throwable -> L16
        i.b();     // Catch: Throwable -> L16
        TokenFactory.r(r3, r4);     // Catch: Throwable -> L16
        b = true;     // Catch: Throwable -> L16
        c = true;     // Catch: Throwable -> L16
        TokenFactory.j().j.postDelayed(new a(), 5000);     // Catch: Throwable -> L16
        monitor-exit(p.class);     // Catch: Throwable -> L16
    }

    public static void g(Context r14, n r15) {
        if (a == false) goto L6;
        return;
    L6:
        monitor-enter(p.class);
    L25:
        th = move-exception;
        throw th;
    L8:
        if (a == false) goto L12;
        monitor-exit(p.class);     // Catch: Throwable -> L25
        return;
    L12:
        if (j.a(i.a.e) == true) goto L14;
        i.a = i.a.a(i.a, 0, 0, 0, System.currentTimeMillis(), 0, 111);     // Catch: Throwable -> L25
    L14:
        TokenFactory.A(r14, r15);     // Catch: Throwable -> L25
        com.bytedance.sdk.account.utils.c.b();     // Catch: Throwable -> L25
        TokenFactory.j().u();     // Catch: Throwable -> L25
        a.d("TokenFactory", "preInit() finish, decision=" + AccountHostSettingsManager.d.a());     // Catch: Throwable -> L25
        TokenFactory.j().B();     // Catch: Throwable -> L25
        Set<String> r16 = d;     // Catch: Throwable -> L25
        if (r16 != null) goto L17;
    L22:
        a = true;     // Catch: Throwable -> L25
        monitor-exit(p.class);     // Catch: Throwable -> L25
        return;
    L17:
        if (r16.isEmpty() == true) goto L22;
        TokenFactory r17 = TokenFactory.j();     // Catch: Throwable -> L25
        Set<String> r18 = d;     // Catch: Throwable -> L25
        if (r17.h == null) goto L21;
        r17.h.b(r18);     // Catch: Throwable -> L25
    L21:
        d.clear();     // Catch: Throwable -> L25
        d = null;     // Catch: Throwable -> L25
        goto L22
    }

    public static f a(String r2, String r3, List<o> r4, boolean r5) {
        if (f() == false) goto L23;
        if (r5 == false) goto L6;
        f r6 = TokenFactory.j().c(r2, r3, r4, false);
    L8:
        if (e == null) goto L22;
        if (r6 != null) goto L12;
        r6 = new f();
    L12:
        if (r6.a != null) goto L14;
        r6.a = new HashMap();
    L14:
        Map r7 = r6.a;
        Iterator r8 = ((ArrayList) e).iterator();
    L16:
        if (r8.hasNext() == false) goto L22;
        g0 r0 = (g0) r8.next();
        if (r0 == null) goto L16;
        Map r1 = r0.a(r2);
        if (r1 == null) goto L16;
        ((HashMap) r7).putAll(r1);
    L22:
        return r6;
    L6:
        r6 = TokenFactory.j().c(r2, r3, r4, true);
        goto L8
    L23:
        return null;
    }
}
