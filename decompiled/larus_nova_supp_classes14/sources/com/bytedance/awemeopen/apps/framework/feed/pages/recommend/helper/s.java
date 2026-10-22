package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s {
    public final long a;
    public final Handler b;
    public long c;
    public long d;
    public a e;
    public final r f;

    public interface a {
        void a();
    }

    public final void c() {
        this.b.removeCallbacks(this.f);
        this.d = this.c - SystemClock.elapsedRealtime();
    }

    public final void a() {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = this.d;
        this.c = r0 + r2;
        this.b.postDelayed(this.f, r2);
    }

    public final void b() {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = this.a;
        this.c = r0 + r2;
        this.b.postDelayed(this.f, r2);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.r] */
    public s(long r1) {
        this.a = r1;
        this.b = new Handler(Looper.getMainLooper());
        this.f = new r(this);
    }
}
