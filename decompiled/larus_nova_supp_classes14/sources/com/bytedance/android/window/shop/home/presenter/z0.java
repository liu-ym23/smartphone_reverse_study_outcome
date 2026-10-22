package com.bytedance.android.window.shop.home.presenter;

import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z0 implements Runnable {
    public final /* synthetic */ a1 a;
    public final /* synthetic */ float b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;

    public z0(a1 r1, float r2, long r3, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float r0 = this.a.d.getProgress();     // Catch: Throwable -> L10
        float r3 = this.b;     // Catch: Throwable -> L10
        if (r0 == r3) goto L13;
        a1 r2 = this.a;     // Catch: Throwable -> L10
        long r7 = this.c;     // Catch: Throwable -> L10
        int r6 = this.d - 1;     // Catch: Throwable -> L10
        LottieAnimationView r1 = r2.d;     // Catch: Throwable -> L10
        if (r1 == null) goto L17;
        if (r6 <= 0) goto L18;
        r1.setProgress(r3);     // Catch: Throwable -> L10
        r2.d.postDelayed(new z0(r2, r3, r7, r6), r7);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
