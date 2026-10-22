package com.bytedance.ee.bear.profile;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ HalfProfileActivity a;

    public d(HalfProfileActivity r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r5, MotionEvent r6, float r7, float r8) {
        Intrinsics.checkNotNullParameter(r6, "e2");
        if (r8 != 0.0f) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L8;
        return false;
    L8:
        float r10 = r6.getRawY();
        if (r5 == null) goto L11;
        float r11 = r5.getRawY();
    L13:
        if ((r10 - r11) <= 0.0f) goto L17;
        j r12 = this.a.j;
        if (r12 == null) goto L20;
        r12.j(0.0f, 100);
    L20:
        return true;
    L17:
        HalfProfileActivity r13 = this.a;
        j r14 = r13.j;
        if (r14 == null) goto L20;
        r14.j(r13.f, 100);
        goto L20
    L11:
        r11 = 0.0f;
        goto L13
    L5:
        r9 = false;
        goto L6
    }
}
