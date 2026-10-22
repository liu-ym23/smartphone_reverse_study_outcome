package com.bytedance.creativex.mediaimport.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.creativex.mediaimport.view.internal.base.v0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ti4.y;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0001H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/creativex/mediaimport/widget/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/bytedance/creativex/mediaimport/view/internal/IPositionMappedItemDecoration;", "spanCount", "", "spacing", "includeEdge", "", "bottomSpacing", "<init>", "(IIZI)V", "positionMapping", "Lcom/bytedance/creativex/mediaimport/view/internal/IPositionMappedItemDecoration$IPositionMapping;", "getPositionMapping", "()Lcom/bytedance/creativex/mediaimport/view/internal/IPositionMappedItemDecoration$IPositionMapping;", "setPositionMapping", "(Lcom/bytedance/creativex/mediaimport/view/internal/IPositionMappedItemDecoration$IPositionMapping;)V", "asRawItemDecoration", "updateSpacing", "", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f204165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f204166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f204167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f204168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y.a f204169e;

    @Override // ti4.c
    public final RecyclerView.ItemDecoration a() {
        return this;
    }

    @Override // ti4.y
    public final void d(v0 r100) {
        this.f204169e = r100;
    }

    @Override // ti4.c
    public final void g(int r100) {
        this.f204166b = r100;
    }

    public GridSpacingItemDecoration(int r100, int r101, boolean r102, int r103) {
        this.f204165a = r100;
        this.f204166b = r101;
        this.f204167c = r102;
        this.f204168d = r103;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r102.getChildAdapterPosition(r101);
        y.a r105 = this.f204169e;
        if (r105 == null) goto L5;
        r104 = r105.a(r104);
    L5:
        int r106 = this.f204165a;
        int r107 = r104 % r106;
        if (this.f204167c == false) goto L11;
        int r108 = this.f204166b;
        r100.left = r108 - ((r107 * r108) / r106);
        r100.right = ((r107 + 1) * r108) / r106;
        if (r104 >= r106) goto L10;
        r100.top = r108;
    L10:
        r100.bottom = r108;
    L15:
        if (this.f204168d <= 0) goto L26;
        RecyclerView.Adapter r109 = r102.getAdapter();
        if (r109 == null) goto L27;
        int r110 = r109.getItemCount();
        int r111 = this.f204165a;
        int r112 = r110 % r111;
        if (r112 == 0) goto L23;
        r111 = r112;
    L23:
        if (((r110 - r104) - 1) >= r111) goto L28;
        r100.bottom = this.f204168d;
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L11:
        int r113 = this.f204166b;
        r100.left = (r107 * r113) / r106;
        r100.right = r113 - (((r107 + 1) * r113) / r106);
        if (r104 < r106) goto L15;
        r100.top = r113;
        goto L15
    }
}
