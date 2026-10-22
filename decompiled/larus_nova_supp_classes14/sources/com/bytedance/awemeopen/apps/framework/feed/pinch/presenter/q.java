package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q extends com.bytedance.awemeopen.apps.framework.feed.pinch.utils.e {
    public final /* synthetic */ u a;

    public q(u r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return false;
    L6:
        return this.a.a.onFling(r2, r3, r4, r5);
    L7:
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r5, MotionEvent r6, float r7, float r8) {
        if (this.a.g == true) goto L11;
        if (r6 != null) goto L6;
    L8:
        boolean r9 = false;
    L9:
        if (r9 == false) goto L11;
        u.a(this.a);
        goto L11
    L6:
        if (r6.getPointerCount() != 2) goto L8;
        r9 = true;
    L11:
        if (r6 == null) goto L13;
        int r10 = r6.getPointerCount();
    L14:
        if (r10 <= 2) goto L16;
        return false;
    L16:
        u r11 = this.a;
        if (r11.g == true) goto L22;
        if (r11.u == true) goto L22;
        return false;
    L22:
        if (r11.u == false) goto L31;
        if (r6 != null) goto L25;
    L27:
        boolean r12 = false;
    L28:
        if (r12 == false) goto L31;
        return false;
    L25:
        if (r6.getPointerCount() != 2) goto L27;
        r12 = true;
    L31:
        if (Math.abs(r7) <= 400.0f) goto L33;
    L63:
        return false;
    L33:
        if (Math.abs(r8) > 400.0f) goto L63;
        u r13 = this.a;
        View r14 = r13.c;
        float r1 = 0.0f;
        if (r14 == null) goto L38;
        float r15 = r14.getTranslationX();
    L39:
        r13.j = r15 - r7;
        u r16 = this.a;
        View r17 = r16.c;
        if (r17 == null) goto L42;
        float r18 = r17.getTranslationY();
    L43:
        r16.k = r18 - r8;
        this.a.getClass();
        this.a.getClass();
        View r19 = this.a.c;
        if (r19 == null) goto L46;
        float r20 = r19.getTranslationX();
    L47:
        View r21 = this.a.c;
        if (r21 == null) goto L51;
        r1 = r21.getTranslationY();
    L51:
        if (Math.abs(this.a.j - r20) < 4.0f) goto L53;
    L55:
        u r22 = this.a;
        View r23 = r22.c;
        if (r23 == null) goto L59;
        r23.setTranslationX(r22.j);
    L59:
        if (r23 == null) goto L62;
        r23.setTranslationY(r22.k);
    L62:
        return true;
    L53:
        if (Math.abs(this.a.k - r1) >= 4.0f) goto L55;
        return false;
    L46:
        r20 = 0.0f;
        goto L47
    L42:
        r18 = 0.0f;
        goto L43
    L38:
        r15 = 0.0f;
        goto L39
    L13:
        r10 = 0;
        goto L14
    }
}
