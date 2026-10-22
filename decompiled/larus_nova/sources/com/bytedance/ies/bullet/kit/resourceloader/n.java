package com.bytedance.ies.bullet.kit.resourceloader;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes19.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f246869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f246870b;

    public n() {
        long r100 = SystemClock.uptimeMillis();
        this.f246869a = r100;
        this.f246870b = r100;
    }

    public final long a() {
        long r100 = SystemClock.uptimeMillis();
        long r101 = r100 - this.f246870b;
        this.f246870b = r100;
        return r101;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.f246869a;
    }
}
