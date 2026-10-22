package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ECShopRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "lm", "", "setLayoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "getLayoutManager", "Lcom/bytedance/android/window/shop/widget/WindowTypeSeparatedAdapter;", "getAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopRecyclerView extends RecyclerView {
    public static final /* synthetic */ int d = 0;
    public final int[] a;
    public final int[] b;
    public final int[] c;

    /* JADX INFO: renamed from: getAdapter, reason: collision with other method in class */
    public WindowTypeSeparatedAdapter m964getAdapter() {
        RecyclerView.Adapter r0 = super.getAdapter();
        if ((r0 instanceof WindowTypeSeparatedAdapter) == true) goto L6;
        r0 = null;
    L6:
        return (WindowTypeSeparatedAdapter) r0;
    }

    /* JADX INFO: renamed from: getLayoutManager, reason: collision with other method in class */
    public StaggeredGridLayoutManager m965getLayoutManager() {
        RecyclerView.LayoutManager r0 = super.getLayoutManager();
        if ((r0 instanceof StaggeredGridLayoutManager) == true) goto L6;
        r0 = null;
    L6:
        return (StaggeredGridLayoutManager) r0;
    }

    public final int r() {
        StaggeredGridLayoutManager r0 = m965getLayoutManager();
        if (r0 == null) goto L8;
        int[] r1 = r0.findFirstCompletelyVisibleItemPositions(this.a);
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1[0];
    L8:
        return 0;
    }

    public final int t() {
        StaggeredGridLayoutManager r0 = m965getLayoutManager();
        if (r0 == null) goto L8;
        int[] r1 = r0.findLastVisibleItemPositions(this.c);
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1[0];
    L8:
        return 0;
    }

    public /* bridge */ /* synthetic */ RecyclerView.Adapter getAdapter() {
        return m964getAdapter();
    }

    public /* bridge */ /* synthetic */ RecyclerView.LayoutManager getLayoutManager() {
        return m965getLayoutManager();
    }

    public void setAdapter(RecyclerView.Adapter<?> r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof WindowTypeSeparatedAdapter) == false) goto L9;
        super.setAdapter(r4);
        return;
    L9:
        throw new IllegalArgumentException("adapter is " + r4.getClass() + ", but " + WindowTypeSeparatedAdapter.class + " is required");
    }

    public void setLayoutManager(RecyclerView.LayoutManager r4) {
        if ((r4 instanceof StaggeredGridLayoutManager) == false) goto L7;
        super.setLayoutManager(r4);
        return;
    L7:
        throw new IllegalArgumentException("ls " + r4 + " is not allowed, you must use a " + StaggeredGridLayoutManager.class);
    }

    public ECShopRecyclerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new int[2];
        this.b = new int[2];
        this.c = new int[2];
    }
}
