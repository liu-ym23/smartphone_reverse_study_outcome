package com.bytedance.ee.bear.document.ai.citation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/MaxHeightRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "maxHeight", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "onMeasure", "", "widthSpec", "heightSpec", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MaxHeightRecyclerView extends RecyclerView {
    public int a;

    public MaxHeightRecyclerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MaxHeightRecyclerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int getMaxHeight() {
        return this.a;
    }

    public final void setMaxHeight(int r1) {
        this.a = r1;
        requestLayout();
    }

    public final void onMeasure(int r4, int r5) {
        if (this.a <= 0) goto L14;
        int r0 = View.MeasureSpec.getSize(r5);
        int r6 = View.MeasureSpec.getMode(r5);
        if (r6 == Integer.MIN_VALUE) goto L12;
        if (r6 != 0) goto L8;
        int r7 = View.MeasureSpec.makeMeasureSpec(this.a, ShareItemModel.SRC_TINT_UNDEFINED);
    L13:
        super.onMeasure(r4, r7);
        return;
    L8:
        if (r6 == 1073741824) goto L10;
        r7 = View.MeasureSpec.makeMeasureSpec(this.a, ShareItemModel.SRC_TINT_UNDEFINED);
        goto L13
    L10:
        r7 = View.MeasureSpec.makeMeasureSpec(Math.min(r0, this.a), 1073741824);
        goto L13
    L12:
        r7 = View.MeasureSpec.makeMeasureSpec(Math.min(r0, this.a), ShareItemModel.SRC_TINT_UNDEFINED);
        goto L13
    L14:
        super.onMeasure(r4, r5);
    }

    public MaxHeightRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = -1;
    }

    public /* synthetic */ MaxHeightRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
