package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/OneRowLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OneRowLinearLayout extends LinearLayout {
    public OneRowLinearLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OneRowLinearLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r9, int r10) {
        if (View.MeasureSpec.getMode(r9) != 1073741824) goto L26;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r9), 0), r10);
        int r11 = View.MeasureSpec.getSize(r9);
        Iterator r12 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r0 = 0;
        int r3 = 0;
    L6:
        if (r12.hasNext() == false) goto L25;
        Object r4 = r12.next();
        int r5 = r0 + 1;
        if (r0 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        View r6 = (View) r4;
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r1 = null;
    L13:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        int r7 = r6.getMeasuredWidth();
        if (r2 == null) goto L16;
        int r8 = r2.leftMargin;
    L17:
        int r13 = r7 + r8;
        if (r2 == null) goto L20;
        int r14 = r2.rightMargin;
    L21:
        r3 = r3 + (r13 + r14);
        if (r3 <= r11) goto L24;
        r6.measure(View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
    L24:
        r0 = r5;
        goto L6
    L20:
        r14 = 0;
        goto L21
    L16:
        r8 = 0;
        goto L17
    L25:
        setMeasuredDimension(r11, getMeasuredHeight());
        return;
    L26:
        super.onMeasure(r9, r10);
    }

    public OneRowLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(0);
    }

    public /* synthetic */ OneRowLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
