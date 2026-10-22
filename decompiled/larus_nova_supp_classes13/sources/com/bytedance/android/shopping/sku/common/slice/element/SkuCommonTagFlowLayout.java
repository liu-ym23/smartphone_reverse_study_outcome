package com.bytedance.android.shopping.sku.common.slice.element;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/slice/element/SkuCommonTagFlowLayout;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuCommonTagFlowLayout extends ViewGroup {
    public int a;

    public SkuCommonTagFlowLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SkuCommonTagFlowLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return new ViewGroup.MarginLayoutParams(r2);
    }

    @Override // android.view.View
    public final void onMeasure(int r16, int r17) {
        super.onMeasure(r16, r17);
        int r7 = View.MeasureSpec.getSize(r16);
        int r8 = getChildCount();
        int r0 = getPaddingStart() + getPaddingEnd();
        int r10 = r0;
        int r11 = getPaddingTop() + getPaddingBottom();
        int r12 = 0;
    L3:
        if (r12 >= r8) goto L16;
        View r13 = getChildAt(r12);
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        SliceRender.o.getClass();
        if (SliceRender.d() == false) goto L9;
        int r5 = 0;
    L10:
        measureChildWithMargins(r13, r16, 0, r17, r5);
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        int r1 = r15.leftMargin + r15.rightMargin;
        int r2 = r15.topMargin + r15.bottomMargin;
        int r3 = r1;
        int r4 = r2;
    L12:
        int r6 = r13.getMeasuredWidth() + r3;
        int r9 = r13.getMeasuredHeight() + r4;
        Pair r18 = TuplesKt.to(Integer.valueOf(r6), Integer.valueOf(r9));
        int r19 = ((Number) r18.getFirst()).intValue();
        int r20 = ((Number) r18.getSecond()).intValue();
        int r21 = r19 + r10;
        if (r21 > r7) goto L16;
        this.a = r12;
        r11 = Math.max(r11, r20);
        r12 = r12 + 1;
        r10 = r21;
        goto L3
    L9:
        r5 = getMeasuredHeight();
        goto L10
    L11:
        measureChild(r13, r16, r17);
        r3 = 0;
        r4 = 0;
    L16:
        setMeasuredDimension(r10, r11);
    }

    public SkuCommonTagFlowLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ SkuCommonTagFlowLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = getPaddingStart();
        int r9 = this.a;
        if (r9 < 0) goto L11;
        int r10 = 0;
    L5:
        View r11 = getChildAt(r10);
        if (r11 == null) goto L9;
        int r12 = getPaddingTop();
        int r0 = r11.getMeasuredWidth() + r8;
        r11.layout(r8, r12, r0, r11.getMeasuredHeight() + r12);
        r8 = r0;
    L9:
        if (r10 == r9) goto L13;
        r10 = r10 + 1;
        goto L5
    L13:
        return;
    }
}
