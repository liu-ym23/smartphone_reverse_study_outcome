package com.larus.dora.impl.dynamic.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0010J\u0016\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"H\u0016R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/CenterSelectedRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "", "isAutoCenterEnabled", "()Z", "setAutoCenterEnabled", "(Z)V", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "centerSnapHelper", "Landroidx/recyclerview/widget/LinearSnapHelper;", "maxDeviation", "isCorrecting", "scrollToSelectedItem", "", "smoothScroll", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CenterSelectedRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f335459a;

    public CenterSelectedRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CenterSelectedRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LinearLayoutManager getLinearLayoutManager() {
        RecyclerView.LayoutManager r100 = getLayoutManager();
        if ((r100 instanceof LinearLayoutManager) == true) goto L7;
        return null;
    L7:
        return (LinearLayoutManager) r100;
    }

    public final int getSelectedIndex() {
        return this.f335459a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter<?> r100) {
        super.setAdapter(r100);
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.getItemCount();
    L6:
        int r103 = -1;
        if (r102 != 0) goto L9;
        setSelectedIndex(-1);
        return;
    L9:
        int r104 = this.f335459a;
        if (r100 == null) goto L12;
        r101 = r100.getItemCount();
    L12:
        if (r104 < r101) goto L18;
        if (r100 == null) goto L15;
        r103 = r100.getItemCount() - 1;
    L15:
        setSelectedIndex(r103);
        return;
    L18:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void setAutoCenterEnabled(boolean r100) {
        if (r100 == false) goto L11;
        int r101 = this.f335459a;
        if (r101 == (-1)) goto L12;
        if (r101 != (-1)) goto L7;
        return;
    L7:
        if (getAdapter() == null) goto L14;
        scrollToPosition(this.f335459a);
        return;
    L14:
        return;
    L12:
        return;
    }

    public final void setSelectedIndex(int r100) {
        if (this.f335459a == r100) goto L17;
        if (r100 < 0) goto L18;
        RecyclerView.Adapter r101 = getAdapter();
        if (r101 == null) goto L8;
        int r102 = r101.getItemCount();
    L9:
        if (r100 >= r102) goto L19;
        this.f335459a = r100;
        if (r100 != (-1)) goto L13;
        return;
    L13:
        if (getAdapter() == null) goto L21;
        smoothScrollToPosition(this.f335459a);
        return;
    L21:
        return;
    L19:
        return;
    L8:
        r102 = 0;
        goto L9
    L18:
        return;
    }

    public CenterSelectedRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f335459a = -1;
        LinearSnapHelper r103 = new LinearSnapHelper();
        c7.b(10);
        r103.attachToRecyclerView(this);
    }

    public /* synthetic */ CenterSelectedRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
