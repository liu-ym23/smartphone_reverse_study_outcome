package com.bytedance.ee.bear.edit.component.toolbar2.insertblock;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnTouchListener {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public final /* synthetic */ View f;
    public final /* synthetic */ e g;

    public final String toString() {
        return "$classname{orgY=" + this.a + ", offsetY=" + this.b + ", orgDeltaY=" + this.c + ", deltaY=" + this.d + '}';
    }

    public d(e r1, View r2) {
        this.g = r1;
        this.f = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r21, MotionEvent r22) {
        int r1 = r22.getAction();
        if (r1 != 0) goto L5;
        this.a = r22.getRawY();
        this.c = this.g.b.getHeight();
        this.e = 0.0f;
        return true;
    L5:
        if (r1 == 1) goto L16;
        if (r1 != 2) goto L8;
        tt5.a.h("DragPopupWindow", "on  move event.getY():" + r22.getY());
        float r2 = this.a - r22.getRawY();
        this.b = r2;
        this.e += Math.abs(r2);
        e r3 = this.g;
        if (r3.f == false) goto L13;
    L14:
        float r4 = this.c + this.b;
        this.d = r4;
        r3.a(r4);
        return true;
    L13:
        if (this.b < 0.0f) goto L14;
        return true;
    L8:
        if (r1 == 3) goto L18;
        return true;
    L18:
        final e r5 = this.g;
        if (this.b >= 0.0f) goto L21;
        boolean r6 = true;
    L22:
        int r8 = r5.b.getLayoutParams().height;
        int r9 = r5.b.getLayoutParams().height;
        int r10 = 0;
    L23:
        float[] r11 = r5.a;
        if (r10 >= r11.length) goto L29;
        if (r9 < r11[r10]) goto L30;
        r10 = r10 + 1;
    L30:
        if (r10 != (-1)) goto L32;
        float r7 = (int) r11[r11.length - 1];
        r8 = r8;
    L47:
        tt5.a.h("DragPopupWindow", "position:" + r10);
        tt5.a.h("DragPopupWindow", "targetHeight:" + r7);
        int r12 = 0;
    L48:
        float[] r13 = r5.a;
        if (r12 >= r13.length) goto L54;
        if (r7 <= r13[r12]) goto L54;
        r12 = r12 + 1;
    L54:
        ValueAnimator r14 = r5.c;
        if (r14 == null) goto L57;
        r14.cancel();
    L57:
        float r16 = Math.abs(r8 - r7) / r5.d;
        ValueAnimator r17 = ValueAnimator.ofInt(new int[]{r8, (int) r7});
        r5.c = r17;
        r17.setDuration((long) r16);
        r5.c.addUpdateListener(new c(r5));
        r5.c.start();
        this.d = 0.0f;
        this.c = 0.0f;
        this.b = 0.0f;
        this.a = 0.0f;
        return true;
    L32:
        if (r10 != 0) goto L34;
        r8 = r8;
    L46:
        r7 = 0.0f;
        goto L47
    L34:
        float r18 = r11[r10];
        float r19 = r11[r10 - 1];
        float r110 = r18 - r19;
        if (r9 >= ((0.1f * r110) + r19)) goto L38;
        r7 = r19;
    L45:
        if (r7 > r11[0]) goto L47;
    L38:
        boolean r111 = r6;
        if (r9 > (((double) r19) + (((double) r110) * 0.9d))) goto L43;
        if (r111 == false) goto L43;
        r18 = r19;
    L43:
        r7 = r18;
        goto L45
    L29:
        r10 = -1;
        goto L30
    L21:
        r6 = false;
        goto L22
    L16:
        if (Math.abs(this.e) >= 30.0f) goto L18;
        this.f.performClick();
        return true;
    }
}
