package com.bytedance.ug.sdk.luckydog.base.container;

import android.os.Vibrator;
import rk7.m;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f271727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vibrator f271728b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f271729a = null;

        static {
            f271729a = new d();
        }
    }

    public final synchronized void b() {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("VibrateManager", "stopVibrate() on call; mIsVibrate = " + this.f271727a);     // Catch: Throwable -> L10
        Vibrator r100 = this.f271728b;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        r100.cancel();     // Catch: Throwable -> L10
    L7:
        this.f271727a = false;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public d() {
    }

    public final synchronized boolean a(long r100) {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("VibrateManager", "startVibrate() on call; durationMs = " + r100 + "; mIsVibrate = " + this.f271727a);     // Catch: Throwable -> L10
        if (this.f271728b != null) goto L7;
        sl7.b r101 = sl7.b.a.f542478a;     // Catch: Throwable -> L10
        this.f271728b = (Vibrator) m.g().getSystemService("vibrator");     // Catch: Throwable -> L10
    L7:
        this.f271728b.cancel();     // Catch: Throwable -> L10
        this.f271728b.vibrate(r100);     // Catch: Throwable -> L10
        this.f271727a = true;     // Catch: Throwable -> L10
        boolean r102 = this.f271727a;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }
}
