package com.bytedance.android.shopping.mall.homepage.card.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/product/RemoveUnFullDisplayLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RemoveUnFullDisplayLinearLayout extends LinearLayout {
    public RemoveUnFullDisplayLinearLayout(Context r1) {
        super(r1);
    }

    public RemoveUnFullDisplayLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r7, int r8) {
        super.onMeasure(r7, r8);
        if (getChildCount() <= 1) goto L14;
        int r0 = View.MeasureSpec.getSize(r7);
        int r1 = b0.b(this).size();
        int r2 = 0;
        int r3 = 0;
        int r4 = -1;
    L5:
        if (r2 >= r1) goto L12;
        View r5 = getChildAt(r2);
        if (r5 == null) goto L11;
        measureChild(r5, r7, r8);
        r3 = r3 + r5.getMeasuredWidth();
        if (r3 <= r0) goto L11;
        r4 = r2;
    L11:
        r2 = r2 + 1;
        goto L5
    L12:
        if (r4 <= 0) goto L14;
        removeViews(r4, getChildCount() - r4);
    L14:
        super.onMeasure(r7, r8);
    }

    public RemoveUnFullDisplayLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
