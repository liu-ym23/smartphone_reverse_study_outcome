package com.bytedance.ee.bear.middleground.comment.input;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k0 implements View.OnTouchListener {
    public final /* synthetic */ BaseInputComment a;

    public k0(BaseInputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        int r0 = r6.getAction();
        boolean r2 = true;
        if (r0 == 0) goto L19;
        if (r0 != 1) goto L6;
        r5.getParent().requestDisallowInterceptTouchEvent(false);
    L22:
        return false;
    L6:
        if (r0 != 2) goto L22;
        Object r1 = r5.getTag();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Float");
        float r3 = ((Float) r1).floatValue();
        float r7 = Math.abs(r6.getY() - r3);
        if (this.a.e().canScrollVertically(1) == false) goto L11;
    L12:
        ViewParent r8 = r5.getParent();
        if (r7 > 5.0f) goto L16;
        r2 = false;
    L16:
        r8.requestDisallowInterceptTouchEvent(r2);
        goto L22
    L11:
        if (this.a.e().canScrollVertically(-1) == false) goto L22;
    L19:
        if (this.a.e().hasFocus() == true) goto L21;
        BaseInputComment.u(this.a);
        tt5.a.h(this.a.L(), "input onTouch");
    L21:
        r5.setTag(Float.valueOf(r6.getY()));
        r5.getParent().requestDisallowInterceptTouchEvent(true);
        goto L22
    }
}
