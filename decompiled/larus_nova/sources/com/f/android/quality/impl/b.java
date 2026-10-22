package com.f.android.quality.impl;

import android.os.SystemClock;
import com.f.android.quality.base.QualityLogger;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f274085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f274086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f274087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f274088d;

    public b() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        this.f274086b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (this.f274088d == false) goto L6;
        long r100 = this.f274086b - this.f274085a;     // Catch: Throwable -> L14
    L11:
        this.f274087c = r100;     // Catch: Throwable -> L14
        this.f274088d = false;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        Lazy r101 = QualityLogger.f274059a;     // Catch: Throwable -> L14
        rt7.a r102 = com.f.android.quality.base.a.f274060a;     // Catch: Throwable -> L14
        rt7.b r103 = com.f.android.quality.base.a.f274061b;     // Catch: Throwable -> L14
        if (r103 != null) goto L10;
        r103 = (rt7.b) QualityLogger.f274059a.getValue();     // Catch: Throwable -> L14
    L10:
        r103.w("duration calculate has wrong, startTime should greater than 0, you should call start at first");     // Catch: Throwable -> L14
        r100 = 0;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.f274088d = true;     // Catch: Throwable -> L7
        this.f274085a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        this.f274087c = 0;     // Catch: Throwable -> L7
        this.f274086b = 0;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
