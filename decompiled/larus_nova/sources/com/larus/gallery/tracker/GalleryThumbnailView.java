package com.larus.gallery.tracker;

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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/gallery/tracker/GalleryThumbnailView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fling", "", "velocityX", "velocityY", "solveVelocity", "velocity", "scrollTo", "", "x", "y", "Companion", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        if ((getLayoutManager() instanceof ThumbnailTrackerLayoutManager) == false) goto L59;
        RecyclerView.LayoutManager r112 = getLayoutManager();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.larus.gallery.tracker.ThumbnailTrackerLayoutManager");
        ThumbnailTrackerLayoutManager r113 = (ThumbnailTrackerLayoutManager) r112;
        if (r113.f344021m != null) goto L11;
        return;
    L11:
        if (r113.f344022n != null) goto L14;
        return;
    L14:
        if (r113.f344016h != null) goto L17;
        return;
    L17:
        if (r113.getChildCount() == 0) goto L66;
        int r100 = r113.t().getStartAfterPadding();
        int r101 = r113.t().getEndAfterPadding();
        Rect r102 = null;
        if (r110 >= 0) goto L35;
        View r103 = r113.getChildAt(r113.getChildCount() - 1);
        if (r103 == null) goto L24;
        int r104 = r113.getPosition(r103) + 1;
        int r105 = r113.getDecoratedRight(r103);
    L25:
        RecyclerView.State r106 = r113.f344022n;
        Intrinsics.checkNotNull(r106);
        if (r104 >= r106.getItemCount()) goto L48;
        if (r105 >= r101) goto L48;
        if (r113.getChildCount() <= 1) goto L48;
        RecyclerView.Recycler r107 = r113.f344021m;
        Intrinsics.checkNotNull(r107);
        View r108 = r107.getViewForPosition(r104);
        r113.addView(r108);
        List<ThumbnailTrackerLayoutManager.c> r109 = r113.s().f344035c;
        ArrayList r114 = (ArrayList) r109;
        r114.add(new ThumbnailTrackerLayoutManager.c(0));
        r113.measureChildWithMargins(r108, 0, 0);
        int r115 = r113.getDecoratedMeasuredWidth(r108);
        int r116 = r113.getDecoratedMeasuredHeight(r108);
        int r117 = r113.getChildCount() - 1;
        ThumbnailTrackerLayoutManager.c r118 = (ThumbnailTrackerLayoutManager.c) r113.u(r113.s().f344035c, r117);
        ThumbnailTrackerLayoutManager.c r119 = (ThumbnailTrackerLayoutManager.c) r113.u(r113.s().f344035c, r117 - 1);
        if (r119 == null) goto L33;
        r102 = r119.f344031a;
    L33:
        if (r102 == null) goto L49;
        Intrinsics.checkNotNull(r118);
        int r120 = r102.right;
        Rect r121 = new Rect(r120, 0, r115 + r120, r116);
        r118.getClass();
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        r118.f344031a = r121;
    L49:
        int r122 = r113.getChildCount();
        int r123 = 0;
    L50:
        if (r123 >= r122) goto L67;
        View r124 = r113.getChildAt(r123);
        if (r124 == null) goto L58;
        ThumbnailTrackerLayoutManager.c r125 = (ThumbnailTrackerLayoutManager.c) r113.u(r113.s().f344035c, r123);
        if (r125 != null) goto L57;
        r125 = new ThumbnailTrackerLayoutManager.c(0);
        ListProtector.set(r113.s().f344035c, r123, r125);
    L57:
        Rect r126 = r125.f344032b;
        Rect r127 = r125.f344031a;
        r126.set(r127.left + r110, 0, r127.right + r110, r116);
        Rect r128 = r125.f344032b;
        r113.layoutDecorated(r124, r128.left, r128.top, r128.right, r128.bottom);
        r113.x(r123);
    L58:
        r123 = r123 + 1;
        goto L50
    L67:
        return;
    L48:
        r116 = 154;
        goto L49
    L24:
        r105 = 0;
        r104 = 0;
        goto L25
    L35:
        View r129 = r113.getChildAt(0);
        if (r129 == null) goto L38;
        int r130 = r113.getPosition(r129) - 1;
        int r131 = r113.getDecoratedLeft(r129);
    L39:
        if (r130 < 0) goto L48;
        if (r131 <= r100) goto L48;
        if (r113.getChildCount() <= 1) goto L48;
        RecyclerView.Recycler r132 = r113.f344021m;
        Intrinsics.checkNotNull(r132);
        View r133 = r132.getViewForPosition(r130);
        r113.addView(r133, 0);
        ListProtector.add(r113.s().f344035c, 0, new ThumbnailTrackerLayoutManager.c(0));
        r113.measureChildWithMargins(r133, 0, 0);
        int r134 = r113.getDecoratedMeasuredWidth(r133);
        r116 = r113.getDecoratedMeasuredHeight(r133);
        ThumbnailTrackerLayoutManager.c r135 = (ThumbnailTrackerLayoutManager.c) r113.u(r113.s().f344035c, 0);
        ThumbnailTrackerLayoutManager.c r136 = (ThumbnailTrackerLayoutManager.c) r113.u(r113.s().f344035c, 1);
        if (r136 == null) goto L46;
        r102 = r136.f344031a;
    L46:
        if (r102 == null) goto L49;
        Intrinsics.checkNotNull(r135);
        int r137 = r102.left;
        Rect r138 = new Rect(r137 - r134, 0, r137, r116);
        r135.getClass();
        Intrinsics.checkNotNullParameter(r138, "<set-?>");
        r135.f344031a = r138;
        goto L49
    L38:
        r131 = 0;
        r130 = 0;
        goto L39
    L66:
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
