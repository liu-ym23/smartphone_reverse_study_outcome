package com.bytedance.ee.bear.drive.core.thumbnail;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0014\u0010\u0011\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailLinearSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "maxJump", "", "attachToRecyclerView", "", "createSnapScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findTargetSnapPosition", "velocityX", "velocityY", "dp", "Landroid/content/Context;", "value", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailLinearSnapHelper extends LinearSnapHelper {
    public RecyclerView a;
    public int b;

    public static final class a {
    }

    static {
    }

    public ThumbnailLinearSnapHelper() {
        this.b = 20;
    }

    public final void attachToRecyclerView(RecyclerView r4) {
        super/*androidx.recyclerview.widget.SnapHelper*/.attachToRecyclerView(r4);
        this.a = r4;
        if (r4 == null) goto L9;
        Context r5 = r4.getContext();
        if (r5 == null) goto L10;
        Resources r0 = r5.getResources();
        int r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).widthPixels;
        Resources r6 = r5.getResources();
        this.b = RangesKt.coerceAtLeast(r1 / ((int) ((20 * WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density) + 0.5f)), 1);
        return;
    L10:
        return;
    }

    public final LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager r3) {
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        RecyclerView r0 = this.a;
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L8;
        return null;
    L8:
        final Context r4 = r0.getContext();
        return new AnonymousClass1(this, r4);
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        View r0 = findSnapView(r3);
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r1 = r3.getPosition(r0);
        int r6 = super.findTargetSnapPosition(r3, r4, r5);
        if (r6 != (-1)) goto L8;
        return r1;
    L8:
        int r7 = r6 - r1;
        if (r7 <= 0) goto L11;
        int r8 = Math.min(r7, this.b);
    L15:
        return r1 + r8;
    L11:
        if (r7 >= 0) goto L13;
        r8 = Math.max(r7, -this.b);
        goto L15
    L13:
        r8 = 0;
        goto L15
    }
}
