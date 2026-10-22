package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends com.bytedance.android.ecom.arch.slice.render.elements.scroll.c {
    public final TextView Y3;
    public View Z3;

    public g(SlcTemplateContext r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        ((BaseSlcViewManager) this).j3 = true;
        ((BaseSlcViewManager) this).k3 = true;
        TextView r5 = new TextView(getContext());
        r5.setLayoutParams(new ViewGroup.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.a(18)));
        r5.setTextSize(12.0f);
        r5.setGravity(17);
        r5.setTextColor(com.bytedance.android.shopping.extensions.k.o("#5C5D65"));
        Unit r0 = Unit.INSTANCE;
        this.Y3 = r5;
    }

    public final void v0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCtx");
        TextView r5 = this.Y3;
        if (r5 == null) goto L12;
        com.bytedance.android.ecom.arch.slice.render.elements.scroll.a r0 = getView().getContentView();
        if (r5.getParent() == null) goto L11;
        ViewParent r1 = r5.getParent();
        if (r1 == null) goto L10;
        ((ViewGroup) r1).removeView(r5);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L11:
        r0.addView(r5);
    L12:
        BaseSlcViewManager r6 = M("discount_calculator_info_group");
        Object r2 = null;
        if (r6 == null) goto L15;
        View r7 = r6.getView();
    L16:
        this.Z3 = r7;
        if (r7 == null) goto L35;
        BaseSlcViewManager r8 = SlcViewExtensionsKt.g(r7);
        if (r8 == null) goto L21;
        Object r9 = r8.o("desc");
    L23:
        if ((r9 instanceof String) == false) goto L26;
        r2 = r9;
    L26:
        String r3 = (String) r2;
        if (r3 == null) goto L31;
        TextView r10 = this.Y3;
        if (r10 == null) goto L40;
        r10.setText(r3);
        r10.setVisibility(0);
        return;
    L40:
        return;
    L31:
        TextView r11 = this.Y3;
        if (r11 == null) goto L34;
        r11.setVisibility(4);
    L34:
        Unit r12 = Unit.INSTANCE;
        return;
    L21:
        r9 = null;
        goto L23
    L35:
        TextView r13 = this.Y3;
        if (r13 == null) goto L38;
        r13.setVisibility(4);
    L38:
        Unit r14 = Unit.INSTANCE;
        return;
    L15:
        r7 = null;
        goto L16
    }

    public final Map<String, Object> z0(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCtx");
        TextView r0 = this.Y3;
        if (r0 == null) goto L5;
        getView().getContentView().removeView(r0);
        r0.setVisibility(4);
    L5:
        return r3;
    }

    public final void v(int r7, int r8, int r9, int r10) {
        super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager*/.v(r7, r8, r9, r10);
        TextView r11 = this.Y3;
        if (r11 == null) goto L17;
        r11.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(com.bytedance.android.shopping.extensions.b.a(18), 1073741824));
        View r12 = this.Z3;
        if (r12 == null) goto L18;
        TextView r13 = this.Y3;
        Integer r0 = null;
        if (r13 == null) goto L9;
        Integer r14 = Integer.valueOf(r13.getMeasuredWidth());
    L10:
        TextView r1 = this.Y3;
        if (r1 == null) goto L13;
        r0 = Integer.valueOf(r1.getMeasuredHeight());
    L13:
        if (r14 == null) goto L19;
        if (r0 == null) goto L20;
        int[] r2 = new int[2];
        int[] r3 = new int[2];
        getView().getLocationOnScreen(r2);
        r12.getLocationOnScreen(r3);
        int r4 = r2[0];
        int r5 = r2[1];
        int r15 = r3[0];
        int r6 = r3[1];
        int r16 = (((r15 - r4) + (r12.getWidth() / 2)) + getView().getScrollX()) - (r14.intValue() / 2);
        int r17 = ((r6 - r5) + r12.getHeight()) + com.bytedance.android.shopping.extensions.b.a(12);
        r11.layout(r16, r17, r14.intValue() + r16, r0.intValue() + r17);
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r14 = null;
        goto L10
    L18:
        return;
    }
}
