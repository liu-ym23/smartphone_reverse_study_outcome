package com.bytedance.android.shopping.slice.elements.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.slice.PdpPageConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PDPOverLayVG extends SlcRoundFrameLayout {
    public com.bytedance.android.ecom.arch.slice.render.context.b c;
    public final Lazy d;
    public final Lazy e;
    public f f;

    private final int getDp16() {
        return ((Number) this.d.getValue()).intValue();
    }

    private final int getDp24() {
        return ((Number) this.e.getValue()).intValue();
    }

    public final com.bytedance.android.ecom.arch.slice.render.context.b getSlcDisplayMetrics() {
        return this.c;
    }

    public PDPOverLayVG(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.c = (com.bytedance.android.ecom.arch.slice.render.context.b) PdpPageConfig.a.getValue();
        this.d = LazyKt.lazy(new PDPOverLayVG$dp16$2(this));
        this.e = LazyKt.lazy(new PDPOverLayVG$dp24$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.FrameLayout*/.dispatchHoverEvent(r1);
    }

    public final void setSlcDisplayMetrics(com.bytedance.android.ecom.arch.slice.render.context.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        super/*android.widget.FrameLayout*/.onLayout(r5, r6, r7, r8, r9);
        if (getChildCount() != 2) goto L14;
        View r0 = getChildAt(0);
        boolean r1 = true;
        View r2 = getChildAt(1);
        int r10 = r8 - r6;
        int r11 = r9 - r7;
        if (((r0.getMeasuredWidth() + (r2.getMeasuredWidth() - getDp24())) + getDp16()) > r10) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L12;
        r2.layout(r10 - r2.getMeasuredWidth(), 0, r10, r11);
        f r12 = this.f;
        if (r12 == null) goto L15;
        r12.a(r1);
        return;
    L15:
        return;
    L12:
        int r13 = (r0.getMeasuredWidth() + getDp16()) - getDp24();
        r2.layout(r13, 0, r2.getMeasuredWidth() + r13, r11);
        return;
    }
}
