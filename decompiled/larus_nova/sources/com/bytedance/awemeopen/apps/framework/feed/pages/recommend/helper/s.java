package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes14.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f195098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f195099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f195100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f195101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f195102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f195103f;

    public interface a {
        void a();
    }

    public final void c() {
        this.f195099b.removeCallbacks(this.f195103f);
        this.f195101d = this.f195100c - SystemClock.elapsedRealtime();
    }

    public final void a() {
        long r100 = SystemClock.elapsedRealtime();
        long r101 = this.f195101d;
        this.f195100c = r100 + r101;
        this.f195099b.postDelayed(this.f195103f, r101);
    }

    public final void b() {
        long r100 = SystemClock.elapsedRealtime();
        long r101 = this.f195098a;
        this.f195100c = r100 + r101;
        this.f195099b.postDelayed(this.f195103f, r101);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.r] */
    public s(long r100) {
        this.f195098a = r100;
        this.f195099b = new Handler(Looper.getMainLooper());
        this.f195103f = new r(this);
    }
}
