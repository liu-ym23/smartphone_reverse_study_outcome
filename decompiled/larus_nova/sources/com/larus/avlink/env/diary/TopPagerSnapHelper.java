package com.larus.avlink.env.diary;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/env/diary/TopPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "<init>", "()V", "verticalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "attachToRecyclerView", "", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "createScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "distanceToStart", "helper", "findStartView", "getVerticalHelper", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopPagerSnapHelper extends PagerSnapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OrientationHelper f291880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f291881b;

    public TopPagerSnapHelper() {
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final void attachToRecyclerView(RecyclerView r100) {
        this.f291881b = r100;
        super.attachToRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final RecyclerView.SmoothScroller createScroller(final RecyclerView.LayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return null;
    L5:
        RecyclerView r101 = this.f291881b;
        if (r101 != null) goto L8;
        return null;
    L8:
        final Context r102 = r101.getContext();
        return new AnonymousClass1(this, r100, r102);
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final View findSnapView(RecyclerView.LayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        if (r100.canScrollVertically() == false) goto L7;
        return a(r100, getVerticalHelper(r100));
    L7:
        return super.findSnapView(r100);
    }

    public final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager r100) {
        OrientationHelper r101 = this.f291880a;
        if (r101 != null) goto L5;
    L8:
        OrientationHelper r102 = OrientationHelper.createVerticalHelper(r100);
        this.f291880a = r102;
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        if (Intrinsics.areEqual(r101.getLayoutManager(), r100) == false) goto L8;
        return r101;
    }

    public final View a(RecyclerView.LayoutManager r100, OrientationHelper r101) {
        int r102 = r100.getChildCount();
        View r103 = null;
        if (r102 != 0) goto L5;
        return null;
    L5:
        int r104 = 0;
        View r105 = r100.getChildAt(0);
        if (r105 != null) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == true) goto L19;
        View r107 = r100.getChildAt(r102 - 1);
        if (r107 == null) goto L19;
        if (r100.getPosition(r107) != (r100.getItemCount() - 1)) goto L19;
        if (r101.getDecoratedEnd(r107) > r101.getEndAfterPadding()) goto L19;
        return r107;
    L19:
        int r108 = Integer.MAX_VALUE;
    L20:
        if (r104 >= r102) goto L28;
        View r109 = r100.getChildAt(r104);
        if (r109 == null) goto L27;
        int r110 = Math.abs(r101.getDecoratedStart(r109) - r101.getStartAfterPadding());
        if (r110 >= r108) goto L27;
        r103 = r109;
        r108 = r110;
    L27:
        r104 = r104 + 1;
        goto L20
    L28:
        return r103;
    L8:
        if (r100.getPosition(r105) != 0) goto L10;
        r106 = true;
        goto L11
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        int[] r102 = new int[2];
        if (r100.canScrollVertically() == false) goto L5;
        OrientationHelper r103 = getVerticalHelper(r100);
        r102[1] = r103.getDecoratedStart(r101) - r103.getStartAfterPadding();
    L6:
        r102[0] = 0;
        return r102;
    L5:
        r102[1] = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final int findTargetSnapPosition(RecyclerView.LayoutManager r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        int r103 = r100.getItemCount();
        if (r103 != 0) goto L5;
        return -1;
    L5:
        View r104 = a(r100, getVerticalHelper(r100));
        if (r104 != null) goto L8;
        return -1;
    L8:
        int r105 = r100.getPosition(r104);
        if (r105 != (-1)) goto L11;
        return -1;
    L11:
        if (r102 <= 0) goto L13;
        r105 = r105 + 1;
    L15:
        if (r105 >= 0) goto L17;
        r105 = 0;
    L17:
        if (r105 >= r103) goto L19;
        return r105;
    L19:
        return r103 - 1;
    L13:
        if (r102 >= 0) goto L15;
        r105 = r105 - 1;
        goto L15
    }
}
