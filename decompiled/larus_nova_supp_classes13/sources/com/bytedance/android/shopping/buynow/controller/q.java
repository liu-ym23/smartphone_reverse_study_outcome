package com.bytedance.android.shopping.buynow.controller;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.bytedance.android.shopping.anchorv4.helper.a0;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q {
    public boolean a;
    public boolean b;
    public Handler c;
    public final Window d;
    public final float e;
    public final View f;
    public final View g;
    public final boolean h;
    public final long i;
    public final Function0<Unit> j;

    public static final class a implements Runnable {
        public final /* synthetic */ q a;

        public a(q r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void a() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (this.a == false) goto L15;
        View r0 = this.f;
        if (r0 == null) goto L9;
        r0.setVisibility(4);
    L9:
        this.b = false;
        this.a = false;
        View r1 = this.g;
        if (r1 == null) goto L12;
        r1.setVisibility(0);
    L12:
        Handler r2 = new Handler(Looper.getMainLooper());
        this.c = r2;
        r2.postDelayed(new a(this), this.i);
        return;
    }

    public final void b() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (this.b == true) goto L24;
        View r1 = this.g;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
    L9:
        View r2 = this.f;
        if (r2 == null) goto L12;
        r2.setVisibility(0);
    L12:
        this.b = true;
        Window r3 = this.d;
        if (r3 == null) goto L15;
        r3.addFlags(2);
    L15:
        float r4 = ul.g.a(this.e);
        Window r5 = this.d;
        if (r5 == null) goto L18;
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, r4});
        r6.setDuration(390);
        r6.setInterpolator(new DecelerateInterpolator());
        r6.addUpdateListener(new r(r5));
        r6.start();
    L18:
        TranslateAnimation r7 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r7.setDuration(390);
        r7.setInterpolator(new a0());
        View r8 = this.f;
        if (r8 == null) goto L21;
        r8.startAnimation(r7);
    L21:
        this.j.invoke();
        return;
    }

    public q(Window r2, View r3, View r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "panelShowCallback");
        this.d = r2;
        this.e = 0.8f;
        this.f = r3;
        this.g = r4;
        this.h = false;
        this.i = 1500;
        this.j = r5;
        this.a = true;
        this.b = true;
    }
}
