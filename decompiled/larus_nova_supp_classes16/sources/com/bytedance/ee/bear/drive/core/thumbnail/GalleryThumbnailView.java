package com.bytedance.ee.bear.drive.core.thumbnail;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/GalleryThumbnailView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fling", "", "velocityX", "velocityY", "solveVelocity", "velocity", "scrollTo", "", "x", "y", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryThumbnailView extends RecyclerView {

    public static final class a {
    }

    static {
    }

    public GalleryThumbnailView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GalleryThumbnailView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final boolean fling(int r3, int r4) {
        if (r3 <= 0) goto L5;
        int r5 = RangesKt.coerceAtMost(r3, 6000);
    L6:
        if (r4 <= 0) goto L8;
        int r6 = RangesKt.coerceAtMost(r4, 6000);
    L10:
        return super.fling(r5, r6);
    L8:
        r6 = RangesKt.coerceAtLeast(r4, -6000);
        goto L10
    L5:
        r5 = RangesKt.coerceAtLeast(r3, -6000);
        goto L6
    }

    public final void scrollTo(int r11, int r12) {
        if (getLayoutManager() != null) goto L6;
        return;
    L6:
        if ((getLayoutManager() instanceof ThumbnailTrackerLayoutManager) == false) goto L61;
        ThumbnailTrackerLayoutManager r13 = getLayoutManager();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.core.thumbnail.ThumbnailTrackerLayoutManager");
        ThumbnailTrackerLayoutManager r14 = r13;
        RecyclerView.Recycler r0 = r14.l;
        if (r0 == null) goto L65;
        RecyclerView.State r1 = r14.m;
        if (r1 != null) goto L14;
        return;
    L14:
        if (r14.g != null) goto L17;
        return;
    L17:
        if (r14.getChildCount() == 0) goto L68;
        int r2 = r14.t().getStartAfterPadding();
        int r3 = r14.t().getEndAfterPadding();
        Rect r6 = null;
        if (r11 >= 0) goto L36;
        View r4 = r14.getChildAt(r14.getChildCount() - 1);
        if (r4 == null) goto L24;
        int r8 = r14.getPosition(r4) + 1;
        int r5 = r14.getDecoratedRight(r4);
    L26:
        if (r8 >= r1.getItemCount()) goto L50;
        if (r5 >= r3) goto L50;
        if (r14.getChildCount() <= 1) goto L50;
        View r7 = r0.getViewForPosition(r8);
        r14.addView(r7);
        List<ThumbnailTrackerLayoutManager.c> r9 = r14.s().c;
        ArrayList r10 = (ArrayList) r9;
        r10.add(new ThumbnailTrackerLayoutManager.c(0));
        r14.measureChildWithMargins(r7, 0, 0);
        int r16 = r14.getDecoratedMeasuredWidth(r7);
        int r17 = r14.getDecoratedMeasuredHeight(r7);
        int r18 = r14.getChildCount() - 1;
        ThumbnailTrackerLayoutManager.c r19 = (ThumbnailTrackerLayoutManager.c) r14.u(r14.s().c, r18);
        ThumbnailTrackerLayoutManager.c r20 = (ThumbnailTrackerLayoutManager.c) r14.u(r14.s().c, r18 - 1);
        if (r20 == null) goto L33;
        r6 = r20.a;
    L33:
        if (r6 == null) goto L51;
        if (r19 == null) goto L51;
        int r21 = r6.right;
        Rect r22 = new Rect(r21, 0, r16 + r21, r17);
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r19.a = r22;
    L51:
        int r23 = r14.getChildCount();
        int r24 = 0;
    L52:
        if (r24 >= r23) goto L69;
        View r26 = r14.getChildAt(r24);
        if (r26 == null) goto L60;
        ThumbnailTrackerLayoutManager.c r27 = (ThumbnailTrackerLayoutManager.c) r14.u(r14.s().c, r24);
        if (r27 != null) goto L59;
        r27 = new ThumbnailTrackerLayoutManager.c(0);
        ListProtector.set(r14.s().c, r24, r27);
    L59:
        Rect r28 = r27.b;
        Rect r29 = r27.a;
        r28.set(r29.left + r11, 0, r29.right + r11, r17);
        Rect r30 = r27.b;
        r14.layoutDecorated(r26, r30.left, r30.top, r30.right, r30.bottom);
        r14.x(r24);
    L60:
        r24 = r24 + 1;
        goto L52
    L69:
        return;
    L50:
        r17 = 154;
        goto L51
    L24:
        r5 = 0;
        r8 = 0;
        goto L26
    L36:
        View r31 = r14.getChildAt(0);
        if (r31 == null) goto L39;
        int r32 = r14.getPosition(r31) - 1;
        int r33 = r14.getDecoratedLeft(r31);
    L40:
        if (r32 < 0) goto L50;
        if (r33 <= r2) goto L50;
        if (r14.getChildCount() <= 1) goto L50;
        View r34 = r0.getViewForPosition(r32);
        r14.addView(r34, 0);
        ListProtector.add(r14.s().c, 0, new ThumbnailTrackerLayoutManager.c(0));
        r14.measureChildWithMargins(r34, 0, 0);
        int r36 = r14.getDecoratedMeasuredWidth(r34);
        r17 = r14.getDecoratedMeasuredHeight(r34);
        ThumbnailTrackerLayoutManager.c r37 = (ThumbnailTrackerLayoutManager.c) r14.u(r14.s().c, 0);
        ThumbnailTrackerLayoutManager.c r38 = (ThumbnailTrackerLayoutManager.c) r14.u(r14.s().c, 1);
        if (r38 == null) goto L47;
        r6 = r38.a;
    L47:
        if (r6 == null) goto L51;
        if (r37 == null) goto L51;
        int r39 = r6.left;
        Rect r40 = new Rect(r39 - r36, 0, r39, r17);
        Intrinsics.checkNotNullParameter(r40, "<set-?>");
        r37.a = r40;
        goto L51
    L39:
        r33 = 0;
        r32 = 0;
        goto L40
    L68:
        return;
    L65:
        return;
    }

    public GalleryThumbnailView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ GalleryThumbnailView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
