package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.store.tabkit.DeviceUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/PadAdapterFrameLayout;", "Landroid/widget/FrameLayout;", "", "a", "Z", "getEnablePadAdapter", "()Z", "setEnablePadAdapter", "(Z)V", "enablePadAdapter", "", "b", "F", "getRatio", "()F", "setRatio", "(F)V", "ratio", "get_enablePadAdapter", "_enablePadAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PadAdapterFrameLayout extends FrameLayout {
    public boolean a;
    public float b;

    public PadAdapterFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PadAdapterFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final boolean get_enablePadAdapter() {
        if (((Boolean) DeviceUtil.a.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.a == false) goto L7;
        return true;
    }

    public final boolean getEnablePadAdapter() {
        return this.a;
    }

    public final float getRatio() {
        return this.b;
    }

    public final void setEnablePadAdapter(boolean r1) {
        this.a = r1;
    }

    public final void setRatio(float r1) {
        this.b = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        if (get_enablePadAdapter() == false) goto L9;
        int r0 = View.MeasureSpec.getSize(r6);
        int r1 = View.MeasureSpec.getSize(r7);
        float r3 = r1;
        float r2 = r0 / r3;
        float r4 = this.b;
        if (r2 <= r4) goto L7;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (r3 * r4), View.MeasureSpec.getMode(r6)), r7);
    L8:
        setMeasuredDimension(r0, r1);
        return;
    L7:
        super.onMeasure(r6, r7);
        goto L8
    L9:
        super.onMeasure(r6, r7);
    }

    public PadAdapterFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
        this.b = 0.47368422f;
        setBackgroundColor(-1);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r3, int r4, ViewGroup.LayoutParams r5) {
        if ((r5 instanceof FrameLayout.LayoutParams) == true) goto L5;
        ViewGroup.LayoutParams r0 = null;
    L6:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 == null) goto L9;
        r1.gravity = 17;
    L9:
        super.addView(r3, r4, r5);
        return;
    L5:
        r0 = r5;
        goto L6
    }

    public /* synthetic */ PadAdapterFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
