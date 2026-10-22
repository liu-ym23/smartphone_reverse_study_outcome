package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterViewItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "leftSpace", "", "topSpace", "rightSpace", "bottomSpace", "space", "<init>", "(IIIII)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterViewItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f460945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f460946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f460947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f460948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f460949e;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.Adapter r105 = r102.getAdapter();
        int r106 = 0;
        if (r105 == null) goto L5;
        int r107 = r105.getItemCount();
    L6:
        if (r104 >= r107) goto L15;
        r100.top = this.f460946b;
        r100.bottom = this.f460948d;
        if (r104 != 0) goto L10;
        int r108 = this.f460945a;
    L11:
        r100.left = r108;
        if (r104 != (r107 - 1)) goto L14;
        r106 = this.f460947c;
    L14:
        r100.right = r106;
        return;
    L10:
        r108 = this.f460949e;
        goto L11
    L15:
        super.getItemOffsets(r100, r101, r102, r103);
        return;
    L5:
        r107 = 0;
        goto L6
    }

    public FilterViewItemDecoration(int r100, int r101, int r102, int r103, int r104) {
        this.f460945a = r100;
        this.f460946b = r101;
        this.f460947c = r102;
        this.f460948d = r103;
        this.f460949e = r104;
    }
}
