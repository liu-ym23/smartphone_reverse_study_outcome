package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes41.dex */
public class dj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile dj f463338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f382a;

    public interface a {
        void a();
    }

    private boolean a() {
        Context r100 = this.f381a;     // Catch: Exception -> L9
        if ((r100 instanceof Application) == false) goto L5;
        Application r101 = (Application) r100;     // Catch: Exception -> L9
    L6:
        r101.registerActivityLifecycleCallbacks(new dd(this.f381a, String.valueOf(System.currentTimeMillis() / 1000)));     // Catch: Exception -> L9
        return true;
    L5:
        r101 = (Application) r100.getApplicationContext();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return false;
    }

    private void b() {
        ad r100 = ad.a(this.f381a);
        com.xiaomi.push.service.ah r101 = com.xiaomi.push.service.ah.a(this.f381a);
        SharedPreferences r102 = this.f381a.getSharedPreferences("mipush_extra", 0);
        long r103 = System.currentTimeMillis();
        long r104 = r102.getLong("first_try_ts", r103);
        if (r104 != r103) goto L6;
        r102.edit().putLong("first_try_ts", r103).commit();
    L6:
        if (Math.abs(r103 - r104) >= 172800000) goto L8;
        return;
    L8:
        a(r101, r100, false);
        if (r101.a(gj.aI.a(), true) == false) goto L12;
        int r105 = a(r101.a(gj.aJ.a(), 86400));
        r100.a(new dl(this.f381a, r105), r105, 0);
    L12:
        if (j.m9295a(this.f381a) == false) goto L17;
        a r106 = this.f382a;
        if (r106 == null) goto L17;
        r106.a();
    L17:
        if (r101.a(gj.f463727ap.a(), false) == false) goto L19;
        a();
    L19:
        a(r101, r100, true);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8938a() {
        ad.a(this.f381a).a(new AnonymousClass1(this));
    }

    private dj(Context r100) {
        this.f381a = r100;
    }

    public static dj a(Context r100) {
        if (f463338a != null) goto L15;
        monitor-enter(dj.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463338a != null) goto L9;
        f463338a = new dj(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(dj.class);     // Catch: Throwable -> L11
    L15:
        return f463338a;
    }

    public static int a(int r100) {
        return Math.max(60, r100);
    }

    public static /* synthetic */ void a(dj r100) {
        r100.b();
    }

    private void a(com.xiaomi.push.service.ah r100, ad r101, boolean r102) {
        if (r100.a(gj.f463711a.a(), true) == false) goto L9;
        dm r103 = new dm(this.f381a);
        if (r102 == false) goto L7;
        r101.a(r103, a(r100.a(gj.f463738b.a(), 86400)));
        return;
    L7:
        r101.m8798a(r103);
        return;
    }
}
