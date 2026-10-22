package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/ECMaxSizeLinearLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "value", "a", "I", "getMMaxWidth", "()I", "setMMaxWidth", "(I)V", "mMaxWidth", "b", "getMMaxHeight", "setMMaxHeight", "mMaxHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECMaxSizeLinearLayout extends LinearLayoutCompat {
    public int a;
    public int b;

    public ECMaxSizeLinearLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECMaxSizeLinearLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int getMMaxHeight() {
        return this.b;
    }

    public final int getMMaxWidth() {
        return this.a;
    }

    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMMaxHeight(int r1) {
        this.b = r1;
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMMaxWidth(int r1) {
        this.a = r1;
        requestLayout();
    }

    public final void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getSize(r4);
        int r1 = View.MeasureSpec.getSize(r5);
        int r2 = this.a;
        if (r2 <= 0) goto L6;
        if (r2 >= r0) goto L6;
        int r6 = View.MeasureSpec.getMode(r4);
        r4 = View.MeasureSpec.makeMeasureSpec(this.a, r6);
    L6:
        int r3 = this.b;
        if (r3 <= 0) goto L10;
        if (r3 >= r1) goto L10;
        int r7 = View.MeasureSpec.getMode(r5);
        r5 = View.MeasureSpec.makeMeasureSpec(this.b, r7);
    L10:
        super.onMeasure(r4, r5);
    }

    public ECMaxSizeLinearLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130972696, 2130972706}, r5, 0);
        setMMaxWidth(r6.getDimensionPixelSize(1, 0));
        setMMaxHeight(r6.getDimensionPixelSize(0, 0));
        r6.recycle();
    }

    public /* synthetic */ ECMaxSizeLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
