package com.bytedance.android.shopping.store.arch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002RT\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/store/arch/FoldAdaptedFrameLayout;", "Landroid/widget/FrameLayout;", "", "enabled", "", "setAdaptedEnabled", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "d", "Lkotlin/jvm/functions/Function2;", "getOnTabSizeChangeListener", "()Lkotlin/jvm/functions/Function2;", "setOnTabSizeChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "onTabSizeChangeListener", "get_adapt", "()Z", "_adapt", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class FoldAdaptedFrameLayout extends FrameLayout {
    public boolean a;
    public int b;
    public int c;
    public Function2<? super Integer, ? super Integer, Unit> d;

    public FoldAdaptedFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FoldAdaptedFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final boolean get_adapt() {
        if (ECStoreFoldPhoneHelper.d() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a == false) goto L7;
        return true;
    }

    public final Function2<Integer, Integer, Unit> getOnTabSizeChangeListener() {
        return this.d;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r4) {
        if (get_adapt() == false) goto L6;
        if (r4 == null) goto L6;
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 1));
    L6:
        super.addView(r4);
    }

    public final void setAdaptedEnabled(boolean r2) {
        if (r2 == this.a) goto L6;
        this.a = r2;
        requestLayout();
        return;
    }

    public final void setOnTabSizeChangeListener(Function2<? super Integer, ? super Integer, Unit> r1) {
        this.d = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r7, int r8) {
        if (get_adapt() == false) goto L17;
        int r0 = View.MeasureSpec.getSize(r7);
        if ((r0 / View.MeasureSpec.getSize(r8)) <= 0.75d) goto L7;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r0, ExtensionsKt.a(390)), 1073741824), r8);
    L9:
        if (this.b == getMeasuredWidth()) goto L11;
    L12:
        this.b = getMeasuredWidth();
        this.c = getMeasuredHeight();
        Function2<? super Integer, ? super Integer, Unit> r9 = this.d;
        if (r9 == null) goto L15;
        Unit r10 = (Unit) r9.invoke(Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()));
    L15:
        getMeasuredWidth();
        getMeasuredHeight();
    L16:
        setMeasuredDimension(r0, getMeasuredHeight());
        return;
    L11:
        if (this.c == getMeasuredHeight()) goto L16;
    L7:
        super.onMeasure(r7, r8);
        goto L9
    L17:
        super.onMeasure(r7, r8);
    }

    public FoldAdaptedFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r4, int r5, ViewGroup.LayoutParams r6) {
        if (get_adapt() == false) goto L13;
        if (r4 == null) goto L7;
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    L7:
        if ((r6 instanceof FrameLayout.LayoutParams) == true) goto L9;
        ViewGroup.LayoutParams r0 = null;
    L10:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 == null) goto L13;
        r1.gravity = 1;
        goto L13
    L9:
        r0 = r6;
    L13:
        super.addView(r4, r5, r6);
    }

    public /* synthetic */ FoldAdaptedFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
