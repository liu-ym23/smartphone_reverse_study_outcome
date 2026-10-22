package com.bytedance.ee.bear.document.ai.myai;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f218865a;

    public final boolean a() {
        long r100 = SystemClock.uptimeMillis();
        if ((r100 - this.f218865a) <= 1000) goto L6;
        this.f218865a = r100;
        return false;
    L6:
        return true;
    }

    public a() {
    }
}
