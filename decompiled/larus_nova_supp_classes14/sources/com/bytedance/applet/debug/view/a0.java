package com.bytedance.applet.debug.view;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a0 implements View.OnTouchListener {
    public final /* synthetic */ x a;

    public a0(x r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "motionEvent");
        int r12 = r11.getAction();
        if (r12 != 0) goto L5;
        x r13 = this.a;
        r13.t = true;
        r13.n = r11.getRawX();
        this.a.o = r11.getRawY();
        this.a.r = System.currentTimeMillis();
        final x r14 = this.a;
        r14.m.postDelayed(new y(r14), r14.w);
        final x r15 = this.a;
        if (r15.u == false) goto L48;
        r15.u = false;
        r15.m.postDelayed(new z(r15), r15.x);
    L48:
        return false;
    L5:
        if (r12 == 1) goto L24;
        if (r12 != 2) goto L48;
        x r16 = this.a;
        float r0 = r11.getRawX();
        float r2 = r11.getRawY();
        WindowManager.LayoutParams r3 = r16.i;
        int r4 = r3.x;
        float r5 = r16.p;
        if (r5 >= 0.0f) goto L11;
        int r1 = 0;
    L12:
        r3.x = r4 + r1;
        int r6 = r3.y;
        float r7 = r16.q;
        if (r7 >= 0.0f) goto L15;
        int r8 = 0;
    L16:
        r3.y = r6 + r8;
        WindowManager r9 = r16.j;
        if (r9 == null) goto L19;
        r9.updateViewLayout(r16.b, r3);
    L19:
        this.a.p = r11.getRawX();
        this.a.q = r11.getRawY();
        x r17 = this.a;
        float r18 = Math.abs(r17.n - r17.p);
        x r19 = this.a;
        if (r18 <= r19.k) goto L22;
    L23:
        this.a.t = false;
        goto L48
    L22:
        if (Math.abs(r19.o - r19.q) <= this.a.k) goto L48;
    L15:
        r8 = (int) (r2 - r7);
        goto L16
    L11:
        r1 = (int) (r0 - r5);
        goto L12
    L24:
        x r110 = this.a;
        r110.t = false;
        r110.p = r11.getRawX();
        this.a.q = r11.getRawY();
        this.a.s = System.currentTimeMillis();
        x r111 = this.a;
        float r112 = Math.abs(r111.n - r111.p);
        x r113 = this.a;
        if (r112 >= r113.k) goto L31;
        float r114 = Math.abs(r113.o - r113.q);
        x r115 = this.a;
        if (r114 >= r115.k) goto L31;
        if ((r115.s - r115.r) >= r115.y) goto L31;
        r115.v++;
    L31:
        final x r20 = this.a;
        if (r20.l == 0) goto L44;
        final int r21 = r20.i.x;
        int r116 = r20.d;
        int r117 = (r20.g - r20.b.getMeasuredWidth()) - r20.d;
        if (r20.i.x <= ((r20.g - r20.b.getMeasuredWidth()) / 2)) goto L36;
        final int r22 = r117;
    L37:
        final int r23 = r20.i.y;
        int r118 = r20.e;
        int r119 = ((r20.f - r20.h) - r20.b.getMeasuredHeight()) - r20.e;
        int r24 = r20.i.y;
        if (r24 <= r119) goto L40;
        final int r25 = r119;
    L43:
        ValueAnimator r120 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r120.setDuration(300);
        r120.addUpdateListener(new w(r20, r21, r22, r23, r25));
        r120.setInterpolator(new AccelerateDecelerateInterpolator());
        r120.start();
        goto L44
    L40:
        if (r24 >= r118) goto L42;
        r25 = r118;
        goto L43
    L42:
        r25 = r24;
        goto L43
    L36:
        r22 = r116;
    L44:
        x r121 = this.a;
        r121.p = -1.0f;
        r121.q = -1.0f;
        goto L48
    }
}
