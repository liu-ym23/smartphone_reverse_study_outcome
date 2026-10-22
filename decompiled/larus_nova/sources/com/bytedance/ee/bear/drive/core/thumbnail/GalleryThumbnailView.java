package com.bytedance.ee.bear.drive.core.thumbnail;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/GalleryThumbnailView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fling", "", "velocityX", "velocityY", "solveVelocity", "velocity", "scrollTo", "", "x", "y", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryThumbnailView extends RecyclerView {

    public static final class a {
    }

    static {
    }

    public GalleryThumbnailView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GalleryThumbnailView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int r100, int r101) {
        if (r100 <= 0) goto L5;
        int r102 = RangesKt.coerceAtMost(r100, 6000);
    L6:
        if (r101 <= 0) goto L8;
        int r103 = RangesKt.coerceAtMost(r101, 6000);
    L10:
        return super.fling(r102, r103);
    L8:
        r103 = RangesKt.coerceAtLeast(r101, -6000);
        goto L10
    L5:
        r102 = RangesKt.coerceAtLeast(r100, -6000);
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void scrollTo(int r110, int r111) {
        if (getLayoutManager() != null) goto L6;
        return;
    L6:
        if ((getLayoutManager() instanceof ThumbnailTrackerLayoutManager) == false) goto L61;
        RecyclerView.LayoutManager r112 = getLayoutManager();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.core.thumbnail.ThumbnailTrackerLayoutManager");
        ThumbnailTrackerLayoutManager r113 = (ThumbnailTrackerLayoutManager) r112;
        RecyclerView.Recycler r100 = r113.f224340l;
        if (r100 == null) goto L65;
        RecyclerView.State r101 = r113.f224341m;
        if (r101 != null) goto L14;
        return;
    L14:
        if (r113.f224335g != null) goto L17;
        return;
    L17:
        if (r113.getChildCount() == 0) goto L68;
        int r102 = r113.t().getStartAfterPadding();
        int r103 = r113.t().getEndAfterPadding();
        Rect r104 = null;
        if (r110 >= 0) goto L36;
        View r105 = r113.getChildAt(r113.getChildCount() - 1);
        if (r105 == null) goto L24;
        int r106 = r113.getPosition(r105) + 1;
        int r107 = r113.getDecoratedRight(r105);
    L26:
        if (r106 >= r101.getItemCount()) goto L50;
        if (r107 >= r103) goto L50;
        if (r113.getChildCount() <= 1) goto L50;
        View r108 = r100.getViewForPosition(r106);
        r113.addView(r108);
        List<ThumbnailTrackerLayoutManager.c> r109 = r113.s().f224354c;
        ArrayList r114 = (ArrayList) r109;
        r114.add(new ThumbnailTrackerLayoutManager.c(0));
        r113.measureChildWithMargins(r108, 0, 0);
        int r115 = r113.getDecoratedMeasuredWidth(r108);
        int r116 = r113.getDecoratedMeasuredHeight(r108);
        int r117 = r113.getChildCount() - 1;
        ThumbnailTrackerLayoutManager.c r118 = (ThumbnailTrackerLayoutManager.c) r113.u(r113.s().f224354c, r117);
        ThumbnailTrackerLayoutManager.c r119 = (ThumbnailTrackerLayoutManager.c) r113.u(r113.s().f224354c, r117 - 1);
        if (r119 == null) goto L33;
        r104 = r119.f224350a;
    L33:
        if (r104 == null) goto L51;
        if (r118 == null) goto L51;
        int r120 = r104.right;
        Rect r121 = new Rect(r120, 0, r115 + r120, r116);
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        r118.f224350a = r121;
    L51:
        int r122 = r113.getChildCount();
        int r123 = 0;
    L52:
        if (r123 >= r122) goto L69;
        View r124 = r113.getChildAt(r123);
        if (r124 == null) goto L60;
        ThumbnailTrackerLayoutManager.c r125 = (ThumbnailTrackerLayoutManager.c) r113.u(r113.s().f224354c, r123);
        if (r125 != null) goto L59;
        r125 = new ThumbnailTrackerLayoutManager.c(0);
        ListProtector.set(r113.s().f224354c, r123, r125);
    L59:
        Rect r126 = r125.f224351b;
        Rect r127 = r125.f224350a;
        r126.set(r127.left + r110, 0, r127.right + r110, r116);
        Rect r128 = r125.f224351b;
        r113.layoutDecorated(r124, r128.left, r128.top, r128.right, r128.bottom);
        r113.x(r123);
    L60:
        r123 = r123 + 1;
        goto L52
    L69:
        return;
    L50:
        r116 = 154;
        goto L51
    L24:
        r107 = 0;
        r106 = 0;
        goto L26
    L36:
        View r129 = r113.getChildAt(0);
        if (r129 == null) goto L39;
        int r130 = r113.getPosition(r129) - 1;
        int r131 = r113.getDecoratedLeft(r129);
    L40:
        if (r130 < 0) goto L50;
        if (r131 <= r102) goto L50;
        if (r113.getChildCount() <= 1) goto L50;
        View r132 = r100.getViewForPosition(r130);
        r113.addView(r132, 0);
        ListProtector.add(r113.s().f224354c, 0, new ThumbnailTrackerLayoutManager.c(0));
        r113.measureChildWithMargins(r132, 0, 0);
        int r133 = r113.getDecoratedMeasuredWidth(r132);
        r116 = r113.getDecoratedMeasuredHeight(r132);
        ThumbnailTrackerLayoutManager.c r134 = (ThumbnailTrackerLayoutManager.c) r113.u(r113.s().f224354c, 0);
        ThumbnailTrackerLayoutManager.c r135 = (ThumbnailTrackerLayoutManager.c) r113.u(r113.s().f224354c, 1);
        if (r135 == null) goto L47;
        r104 = r135.f224350a;
    L47:
        if (r104 == null) goto L51;
        if (r134 == null) goto L51;
        int r136 = r104.left;
        Rect r137 = new Rect(r136 - r133, 0, r136, r116);
        Intrinsics.checkNotNullParameter(r137, "<set-?>");
        r134.f224350a = r137;
        goto L51
    L39:
        r131 = 0;
        r130 = 0;
        goto L40
    L68:
        return;
    L65:
        return;
    }

    public GalleryThumbnailView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ GalleryThumbnailView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
