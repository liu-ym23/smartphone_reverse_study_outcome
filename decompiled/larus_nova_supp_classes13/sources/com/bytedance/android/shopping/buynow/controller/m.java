package com.bytedance.android.shopping.buynow.controller;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m {
    public float a;
    public float b;
    public final int c;
    public int d;
    public final int e;
    public final RecyclerView f;

    public m(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.f = r2;
        this.c = -1;
        this.d = -1;
        this.e = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
    }

    public final Boolean b(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "ev");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L32
        int r2 = r9.getActionMasked();     // Catch: Throwable -> L32
        if (r2 != 0) goto L6;
        this.a = r9.getX();     // Catch: Throwable -> L32
        this.b = r9.getY();     // Catch: Throwable -> L32
        this.d = r9.getPointerId(0);     // Catch: Throwable -> L32
    L30:
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L37;
        ECExceptionMonitor.e(r11);
    L37:
        return null;
    L6:
        if (r2 != 1) goto L8;
    L28:
        this.d = this.c;     // Catch: Throwable -> L32
        goto L30
    L8:
        if (r2 != 2) goto L10;
        int r3 = this.d;     // Catch: Throwable -> L32
        if (r3 != this.c) goto L15;
        return null;
    L15:
        int r4 = r9.findPointerIndex(r3);     // Catch: Throwable -> L32
        if (r4 == (-1)) goto L27;
        if (r4 < 0) goto L27;
        if (r4 >= r9.getPointerCount()) goto L27;
        float r5 = r9.getX(r4);     // Catch: Throwable -> L32
        float r12 = r9.getY(r4);     // Catch: Throwable -> L32
        float r6 = r5 - this.a;     // Catch: Throwable -> L32
        float r7 = r12 - this.b;     // Catch: Throwable -> L32
        float r8 = Math.abs(r6);     // Catch: Throwable -> L32
        Math.abs(r7);     // Catch: Throwable -> L32
        if (a(this.f, false, (int) r6, (int) r5, (int) r12) == false) goto L30;
        if (r8 <= this.e) goto L30;
        this.a = r5;     // Catch: Throwable -> L32
        this.b = r12;     // Catch: Throwable -> L32
        return Boolean.FALSE;
    L27:
        return null;
    L10:
        if (r2 == 3) goto L28;
    L32:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    }

    public static boolean a(View r9, boolean r10, int r11, int r12, int r13) {
        if ((r9 instanceof ViewGroup) == false) goto L18;
        int r0 = r9.getScrollX();
        int r2 = r9.getScrollY();
        ViewGroup r3 = (ViewGroup) r9;
        int r4 = r3.getChildCount() - 1;
    L5:
        if (r4 < 0) goto L18;
        View r5 = r3.getChildAt(r4);
        int r6 = r12 + r0;
        if (r6 < r5.getLeft()) goto L17;
        if (r6 >= r5.getRight()) goto L17;
        int r7 = r13 + r2;
        if (r7 < r5.getTop()) goto L17;
        if (r7 >= r5.getBottom()) goto L17;
        if (a(r5, true, r11, r6 - r5.getLeft(), r7 - r5.getTop()) == false) goto L17;
        return true;
    L17:
        r4 = r4 - 1;
    L18:
        if (r10 == true) goto L20;
    L22:
        return false;
    L20:
        if (r9.canScrollHorizontally(-r11) == false) goto L22;
        return true;
    }
}
