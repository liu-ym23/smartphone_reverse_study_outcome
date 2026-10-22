package com.bytedance.ee.bear.document.ai.citation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/MaxHeightRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "maxHeight", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "onMeasure", "", "widthSpec", "heightSpec", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MaxHeightRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f218753a;

    public MaxHeightRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MaxHeightRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getMaxHeight() {
        return this.f218753a;
    }

    public final void setMaxHeight(int r100) {
        this.f218753a = r100;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f218753a <= 0) goto L14;
        int r102 = View.MeasureSpec.getSize(r101);
        int r103 = View.MeasureSpec.getMode(r101);
        if (r103 == Integer.MIN_VALUE) goto L12;
        if (r103 != 0) goto L8;
        int r104 = View.MeasureSpec.makeMeasureSpec(this.f218753a, Integer.MIN_VALUE);
    L13:
        super.onMeasure(r100, r104);
        return;
    L8:
        if (r103 == 1073741824) goto L10;
        r104 = View.MeasureSpec.makeMeasureSpec(this.f218753a, Integer.MIN_VALUE);
        goto L13
    L10:
        r104 = View.MeasureSpec.makeMeasureSpec(Math.min(r102, this.f218753a), 1073741824);
        goto L13
    L12:
        r104 = View.MeasureSpec.makeMeasureSpec(Math.min(r102, this.f218753a), Integer.MIN_VALUE);
        goto L13
    L14:
        super.onMeasure(r100, r101);
    }

    public MaxHeightRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f218753a = -1;
    }

    public /* synthetic */ MaxHeightRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
