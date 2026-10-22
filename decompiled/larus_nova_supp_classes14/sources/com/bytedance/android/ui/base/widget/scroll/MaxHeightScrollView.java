package com.bytedance.android.ui.base.widget.scroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ui/base/widget/scroll/MaxHeightScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeight", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MaxHeightScrollView extends NestedScrollView {
    private float maxHeight;

    public MaxHeightScrollView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public MaxHeightScrollView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public void onMeasure(int r3, int r4) {
        float r0 = this.maxHeight;
        if (r0 <= 0.0f) goto L5;
        super.onMeasure(r3, View.MeasureSpec.makeMeasureSpec((int) r0, Integer.MIN_VALUE));
        return;
    L5:
        super.onMeasure(r3, r4);
    }

    public MaxHeightScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.maxHeight = -1.0f;
        if (r3 == null) goto L6;
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130972696, 2130973937});
        this.maxHeight = r5.getDimension(1, this.maxHeight);
        r5.recycle();
        return;
    }

    public /* synthetic */ MaxHeightScrollView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
