package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/LivePromotionListFooterView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListFooterView extends ConstraintLayout {
    public RecyclerView a;

    public final RecyclerView getRecyclerView() {
        return this.a;
    }

    public LivePromotionListFooterView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final void setRecyclerView(RecyclerView r1) {
        this.a = r1;
    }

    public LivePromotionListFooterView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r9, int r10) {
        super.onMeasure(r9, r10);
        RecyclerView r11 = this.a;
        if (r11 != null) goto L5;
        return;
    L5:
        PagedListAdapter r0 = r11.getAdapter();
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = View.MeasureSpec.getSize(getMeasuredHeight());
        if (r11.getHeight() > 0) goto L11;
    L13:
        boolean r2 = false;
    L14:
        Integer r4 = null;
        if (r2 == false) goto L17;
        RecyclerView r3 = r11;
    L18:
        if (r3 == null) goto L53;
        RecyclerView.ViewHolder r5 = r3.findViewHolderForLayoutPosition(r0.getItemCount() - 2);
        if (r5 == null) goto L54;
        View r6 = r5.itemView;
        if (r6 == null) goto L56;
        int r7 = r11.getHeight() - Math.max(r6.getBottom(), getTop());
        if (r1 < r7) goto L27;
        return;
    L27:
        if ((r0 instanceof PagedListAdapter) == true) goto L29;
        PagedListAdapter r8 = null;
    L30:
        PagedListAdapter r12 = r8;
        if (r12 == null) goto L33;
        PagedList r13 = r12.getCurrentList();
    L34:
        int r14 = r0.getItemCount() - 2;
        if (r13 == null) goto L37;
        Integer r15 = Integer.valueOf(r13.getPositionOffset());
    L38:
        if (r13 == null) goto L42;
        PagedList.Config r16 = r13.getConfig();
        if (r16 == null) goto L42;
        r4 = Integer.valueOf(r16.pageSize);
    L42:
        int r17 = View.MeasureSpec.getSize(r6.getMeasuredHeight());
        if (r13 == null) goto L51;
        if (r15 == null) goto L51;
        if (r4 == null) goto L51;
        if ((r14 + r15.intValue()) < r4.intValue()) goto L51;
        if ((r17 * r4.intValue()) < r11.getHeight()) goto L51;
        return;
    L51:
        super.onMeasure(r9, View.MeasureSpec.makeMeasureSpec(r7, 1073741824));
        return;
    L37:
        r15 = null;
        goto L38
    L33:
        r13 = null;
        goto L34
    L29:
        r8 = r0;
        goto L30
    L56:
        return;
    L54:
        return;
    L53:
        return;
    L17:
        r3 = null;
        goto L18
    L11:
        if (r0.getItemCount() < 2) goto L13;
        r2 = true;
        goto L14
    }

    public LivePromotionListFooterView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }
}
