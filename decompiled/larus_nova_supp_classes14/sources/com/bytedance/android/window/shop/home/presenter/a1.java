package com.bytedance.android.window.shop.home.presenter;

import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a1 {
    public float a;
    public boolean b;
    public Pair<Boolean, Boolean> c;
    public final LottieAnimationView d;

    public static final class a implements Runnable {
        public final /* synthetic */ a1 a;

        public a(a1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a1 r0 = this.a;     // Catch: Throwable -> L6
            r0.b = true;     // Catch: Throwable -> L6
            Pair<Boolean, Boolean> r1 = r0.c;     // Catch: Throwable -> L6
            r0.c = null;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r0.a(((Boolean) r1.getFirst()).booleanValue(), ((Boolean) r1.getSecond()).booleanValue());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public a1(LottieAnimationView r1) {
        this.d = r1;
        this.a = -1.0f;
    }

    public final void a(boolean r10, boolean r11) {
        if (this.b == true) goto L13;
        Pair<Boolean, Boolean> r0 = this.c;
        if (r0 != null) goto L7;
    L8:
        this.c = new Pair(Boolean.valueOf(r10), Boolean.valueOf(r11));
    L9:
        LottieAnimationView r12 = this.d;
        if (r12 == null) goto L32;
        r12.post(new a(this));
        return;
    L32:
        return;
    L7:
        if (((Boolean) r0.getFirst()).booleanValue() == r10) goto L9;
    L13:
        if (r10 == false) goto L15;
        float r3 = 1.0f;
    L17:
        if (this.a != r3) goto L19;
        return;
    L19:
        this.a = r3;
        if (r10 == false) goto L28;
        if (r11 == false) goto L25;
        LottieAnimationView r13 = this.d;
        if (r13 == null) goto L33;
        r13.playAnimation();
        return;
    L33:
        return;
    L25:
        LottieAnimationView r14 = this.d;
        if (r14 == null) goto L35;
        r14.setProgress(r3);
        this.d.postDelayed(new z0(this, r3, 500, 5), 500);
        return;
    L35:
        return;
    L28:
        LottieAnimationView r15 = this.d;
        if (r15 == null) goto L37;
        r15.setProgress(r3);
        this.d.postDelayed(new z0(this, r3, 500, 5), 500);
        return;
    L37:
        return;
    L15:
        r3 = 0.0f;
        goto L17
    }
}
