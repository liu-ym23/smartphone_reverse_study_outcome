package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl;

import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f271628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f271629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g f271630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<xk7.c> f271631d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f271632e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f271633f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CopyOnWriteArrayList<zk7.d> f271634g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f271635h = null;

    public static final class a implements xk7.a {
        public a() {
        }

        @Override // xk7.a
        public final void a(ILuckyDogCommonSettingsService.Channel r100) {
            com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCommonSettingsManager", "handleSettingsByKey(), " + r100 + " settings request finish");
            h r101 = b.f271628a;
            b.a(r100);
            xk7.e r102 = b.b(r100);
            if (r102 == null) goto L6;
            r102.f564227g.remove(this);
            return;
        }
    }

    public b() {
    }

    public final synchronized void f() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (f271629b != null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCommonSettingsManager", "start init dynamic settings");     // Catch: Throwable -> L8
        f271629b = new f();     // Catch: Throwable -> L8
        d(ILuckyDogCommonSettingsService.Channel.DYNAMIC);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized void g() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (f271630c != null) goto L11;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCommonSettingsManager", "start init polling settings");     // Catch: Throwable -> L13
        f271630c = new g();     // Catch: Throwable -> L13
        g r100 = f271630c;     // Catch: Throwable -> L13
        if (r100 == null) goto L8;
        d r101 = d.f271636a;     // Catch: Throwable -> L13
        r100.f564224d.add(r101);     // Catch: Throwable -> L13
    L8:
        g r102 = f271630c;     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        e r103 = new e();     // Catch: Throwable -> L13
        r102.f564225e.add(r103);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }

    static {
        f271635h = new b();
        f271631d = new CopyOnWriteArrayList();
        f271632e = new AtomicBoolean(false);
        f271633f = new AtomicBoolean(false);
        f271634g = new CopyOnWriteArrayList();
    }

    public final void e() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCommonSettingsManager", "start init common settings");
        PThreadScheduledThreadPoolExecutor r100 = yk7.f.f568242a;
        PThreadScheduledThreadPoolExecutor r101 = new PThreadScheduledThreadPoolExecutor(1, new DefaultThreadFactory("ThreadPoolUtils"));
        r101.setMaximumPoolSize(3);
        r101.setThreadFactory(yk7.e.f568241a);
        r101.setKeepAliveTime(60, TimeUnit.SECONDS);
        r101.allowCoreThreadTimeOut(true);
        yk7.f.f568242a = r101;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f271628a != null) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCommonSettingsManager", "start init static settings");     // Catch: Throwable -> L10
        h r102 = new h();     // Catch: Throwable -> L10
        f271628a = r102;     // Catch: Throwable -> L10
        c r103 = new c();     // Catch: Throwable -> L10
        r102.f564227g.add(r103);     // Catch: Throwable -> L10
        d(ILuckyDogCommonSettingsService.Channel.STATIC);     // Catch: Throwable -> L10
    L7:
        monitor-exit(this);
        f();
        g();
    }

    public static void a(ILuckyDogCommonSettingsService.Channel r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCommonSettingsManager", "callbackSettingsByKey(), channel = " + r100);
        CopyOnWriteArrayList<zk7.d> r101 = f271634g;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L25;
        Iterator<zk7.d> r103 = r101.iterator();
    L12:
        if (r103.hasNext() == false) goto L34;
        zk7.d r104 = r103.next();
        if (r104.f572661a != r100) goto L12;
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<String> r106 = r104.f572662b.iterator();
    L18:
        if (r106.hasNext() == false) goto L24;
        String r107 = r106.next();
        xk7.e r108 = b(r104.f572661a);
        if (r108 == null) goto L22;
        Object r109 = r108.j(r107);
    L23:
        r105.put(r107, r109);
        goto L18
    L22:
        r109 = null;
        goto L23
    L24:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCommonSettingsManager", "callbackSettingsByKey(), callback key = " + r104.f572662b);
        f271634g.remove(r104);
        goto L12
    L34:
        return;
    L25:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static xk7.e b(ILuckyDogCommonSettingsService.Channel r100) {
        int r101 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.a.f271627a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return f271630c;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return f271629b;
    L13:
        return f271628a;
    }

    public static int c(ILuckyDogCommonSettingsService.Channel r100) {
        xk7.e r101 = b(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.i(r101.f564223c);
    }

    public static void d(ILuckyDogCommonSettingsService.Channel r100) {
        if (c(r100) <= 0) goto L5;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCommonSettingsManager", "handleSettingsByKey(), " + r100 + " settings has local data");
        a(r100);
        return;
    L5:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogCommonSettingsManager", "handleSettingsByKey(), " + r100 + " settings has no local data");
        xk7.e r101 = b(r100);
        if (r101 == null) goto L10;
        r101.f564227g.add(new a());
        return;
    }
}
