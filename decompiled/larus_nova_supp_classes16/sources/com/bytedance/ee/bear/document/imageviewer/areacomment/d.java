package com.bytedance.ee.bear.document.imageviewer.areacomment;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.document.comment.q2;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Runnable {
    public final /* synthetic */ q2 a;
    public final /* synthetic */ c b;

    public d(q2 r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        tt5.a.h("AreaCommentRender", "handleInputHeightChangeEvent: start height = " + this.a.a + ", mode = " + this.b.n);
        c r0 = this.b;
        if (r0.n == IImageViewer.ImageCommentMode.EXIT) goto L6;
        return;
    L6:
        if (this.a.a != 0) goto L8;
    L71:
        this.b.h();
        return;
    L8:
        if (((com.bytedance.ee.bear.document.comment.d) r0.h).b() == false) goto L71;
        ViewGroup r1 = this.b.c.getContainerView();
        if (r1 != null) goto L12;
        return;
    L12:
        c r2 = this.b;
        boolean r3 = r2.e;
        int r4 = 0;
        Integer r5 = null;
        boolean r6 = true;
        if (r3 == false) goto L43;
        if (r3 == true) goto L16;
        boolean r7 = false;
    L18:
        if (r7 == false) goto L40;
        c r8 = this.b;
        int r9 = this.a.a;
        r8.getClass();
        int[] r10 = new int[2];
        r1.getLocationOnScreen(r10);
        int r11 = RangesKt.coerceAtLeast(r9 - r10[1], 0);
        tt5.a.b("AreaCommentRender", "handleInputHeightChangeEvent: visibleHeight = " + r11 + ", location[1] = " + r10[1]);
        r1.setPadding(0, 0, 0, 0);
        r8.t = true;
        ValueAnimator r12 = r8.r;
        if (r12 == null) goto L22;
        r12.cancel();
    L22:
        Integer r13 = Integer.valueOf(r1.getHeight());
        if (r13.intValue() > 0) goto L26;
        r6 = false;
    L26:
        if (r6 == false) goto L28;
        r5 = r13;
    L28:
        if (r5 == null) goto L30;
        r4 = r5.intValue();
    L34:
        if (r8.m.m == false) goto L39;
        ViewGroup.LayoutParams r14 = r1.getLayoutParams();
        if (r14 == null) goto L38;
        r14.height = r11;
        r1.setLayoutParams(r14);
        r1.requestLayout();
    L38:
        r8.m.d();
        return;
    L39:
        r8.a(r4, r11, r1);
        return;
    L30:
        ViewGroup.LayoutParams r16 = r1.getLayoutParams();
        if (r16 == null) goto L34;
        r4 = r16.height;
        goto L34
    L40:
        c r17 = this.b;
        int r18 = this.a.a;
        r17.getClass();
        int[] r19 = new int[2];
        r1.getLocationOnScreen(r19);
        int r20 = r1.getHeight();
        int r21 = RangesKt.coerceAtLeast(r18 - r19[1], 0);
        int r110 = r20 - r21;
        tt5.a.b("AreaCommentRender", "handleInputHeightChangeEvent: visibleHeight = " + r21 + ", location[1] = " + r19[1] + ", originalHeight = " + r20 + ", paddingBottom = " + r110);
        r1.setPadding(0, 0, 0, r110);
        a r22 = r17.m;
        if (r22.m == false) goto L75;
        r22.d();
        return;
    L75:
        return;
    L16:
        r7 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.comment_voice_input_upgrade");
        goto L18
    L43:
        int r23 = this.a.a;
        ViewParent r24 = r1.getParent();
        if ((r24 instanceof ViewGroup) == false) goto L46;
        ViewGroup r26 = (ViewGroup) r24;
    L47:
        if (r26 == null) goto L49;
        int r27 = r26.getPaddingTop();
    L50:
        int r28 = RangesKt.coerceAtLeast(r23 - r27, 0);
        tt5.a.b("AreaCommentRender", "handleInputHeightChangeEvent: visibleHeight = " + r28 + ", parentPaddingTop = " + r27);
        ValueAnimator r29 = r2.r;
        if (r29 == null) goto L53;
        r29.cancel();
    L53:
        Integer r30 = Integer.valueOf(r1.getHeight());
        if (r30.intValue() > 0) goto L57;
        r6 = false;
    L57:
        if (r6 == false) goto L59;
        r5 = r30;
    L59:
        if (r5 == null) goto L61;
        r4 = r5.intValue();
    L65:
        if (r2.m.m == false) goto L70;
        ViewGroup.LayoutParams r31 = r1.getLayoutParams();
        if (r31 == null) goto L69;
        r31.height = r28;
        r1.setLayoutParams(r31);
        r1.requestLayout();
    L69:
        r2.m.d();
        return;
    L70:
        r2.a(r4, r28, r1);
        return;
    L61:
        ViewGroup.LayoutParams r32 = r1.getLayoutParams();
        if (r32 == null) goto L65;
        r4 = r32.height;
        goto L65
    L49:
        r27 = 0;
        goto L50
    L46:
        r26 = null;
        goto L47
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
