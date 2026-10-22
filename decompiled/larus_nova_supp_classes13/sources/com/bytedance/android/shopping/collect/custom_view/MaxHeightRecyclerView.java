package com.bytedance.android.shopping.collect.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dR*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/collect/custom_view/MaxHeightRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "value", "a", "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", "b", "getScrollDy", "setScrollDy", "scrollDy", "", "c", "Z", "getParentIsTop", "()Z", "setParentIsTop", "(Z)V", "parentIsTop", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MaxHeightRecyclerView extends RecyclerView {
    public int a;
    public int b;
    public boolean c;

    public MaxHeightRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MaxHeightRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int getMaxHeight() {
        return this.a;
    }

    public final boolean getParentIsTop() {
        return this.c;
    }

    public final int getScrollDy() {
        return this.b;
    }

    public final void setMaxHeight(int r2) {
        if (this.a == r2) goto L5;
        requestLayout();
    L5:
        this.a = r2;
    }

    public final void setParentIsTop(boolean r1) {
        this.c = r1;
    }

    public final void setScrollDy(int r1) {
        this.b = r1;
    }

    public final void onMeasure(int r2, int r3) {
        int r0 = this.a;
        if (r0 <= 0) goto L5;
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE));
        return;
    L5:
        super.onMeasure(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MaxHeightRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = true;
        setTag("MaxHeightYataRecyclerView");
        addOnScrollListener(new AnonymousClass1(this));
    }

    public /* synthetic */ MaxHeightRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
