package com.bytedance.android.shopping.deepfeed;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/MotionEvent;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class DeepFeedProductFragment$initView$1$1 extends FunctionReferenceImpl implements Function1<MotionEvent, Unit> {
    public DeepFeedProductFragment$initView$1$1(com.bytedance.android.shopping.deepfeed.event.a r8) {
        super(1, r8, com.bytedance.android.shopping.deepfeed.event.a.class, "onTouchEvent", "onTouchEvent(Landroid/view/MotionEvent;)V", 0);
    }

    public final void invoke(MotionEvent r14) {
        Intrinsics.checkNotNullParameter(r14, "p1");
        com.bytedance.android.shopping.deepfeed.event.a r0 = (com.bytedance.android.shopping.deepfeed.event.a) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r14, "event");
        com.bytedance.android.shopping.deepfeed.event.a.d r1 = r0.c;
        if (r1 != null) goto L5;
    L9:
        int r2 = r14.getActionMasked();
        if (r2 == 0) goto L22;
        if (r2 != 1) goto L13;
        r0.d(r14);
        return;
    L13:
        if (r2 != 2) goto L15;
        VelocityTracker r3 = r0.d;
        if (r3 == null) goto L36;
        r3.addMovement(r14);
        return;
    L36:
        return;
    L15:
        if (r2 != 3) goto L39;
        r0.d(r14);
        return;
    L39:
        return;
    L22:
        com.bytedance.android.shopping.deepfeed.event.a.e r4 = r0.f;
        if (r4 != null) goto L25;
    L26:
        r0.f = null;
    L27:
        r0.a(null);
        r0.b();
        VelocityTracker r5 = r0.d;
        if (r5 == null) goto L30;
        r5.recycle();
    L30:
        r0.d = null;
        r0.c = null;
        com.bytedance.android.shopping.deepfeed.event.a.c r6 = (com.bytedance.android.shopping.deepfeed.event.a.c) r0.m.invoke(Float.valueOf(r14.getX()), Float.valueOf(r14.getY()));
        if (r6 == null) goto L40;
        long r7 = r0.a + 1;
        r0.a = r7;
        r0.c = new com.bytedance.android.shopping.deepfeed.event.a.d(r7, r6.a, r6.b, r6.c, System.currentTimeMillis(), r14.getX(), r14.getY());
        VelocityTracker r8 = VelocityTracker.obtain();
        r8.addMovement(r14);
        Unit r15 = Unit.INSTANCE;
        r0.d = r8;
        return;
    L40:
        return;
    L25:
        if (r4.g == true) goto L27;
    L5:
        if (r1.m == true) goto L9;
        if (r14.getActionMasked() == 0) goto L9;
        r1.i = r14.getX();
        r1.j = r14.getY();
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((MotionEvent) r1);
        return Unit.INSTANCE;
    }
}
