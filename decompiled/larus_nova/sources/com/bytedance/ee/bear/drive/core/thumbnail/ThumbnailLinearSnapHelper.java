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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0014\u0010\u0011\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/ThumbnailLinearSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "maxJump", "", "attachToRecyclerView", "", "createSnapScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findTargetSnapPosition", "velocityX", "velocityY", "dp", "Landroid/content/Context;", "value", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailLinearSnapHelper extends LinearSnapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f224325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f224326b;

    public static final class a {
    }

    static {
    }

    public ThumbnailLinearSnapHelper() {
        this.f224326b = 20;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final void attachToRecyclerView(RecyclerView r100) {
        super.attachToRecyclerView(r100);
        this.f224325a = r100;
        if (r100 == null) goto L9;
        Context r101 = r100.getContext();
        if (r101 == null) goto L10;
        Resources r102 = r101.getResources();
        int r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).widthPixels;
        Resources r104 = r101.getResources();
        this.f224326b = RangesKt.coerceAtLeast(r103 / ((int) ((20 * WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density) + 0.5f)), 1);
        return;
    L10:
        return;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        RecyclerView r101 = this.f224325a;
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L8;
        return null;
    L8:
        final Context r102 = r101.getContext();
        return new AnonymousClass1(this, r102);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final int findTargetSnapPosition(RecyclerView.LayoutManager r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        View r103 = findSnapView(r100);
        if (r103 != null) goto L5;
        return -1;
    L5:
        int r104 = r100.getPosition(r103);
        int r105 = super.findTargetSnapPosition(r100, r101, r102);
        if (r105 != (-1)) goto L8;
        return r104;
    L8:
        int r106 = r105 - r104;
        if (r106 <= 0) goto L11;
        int r107 = Math.min(r106, this.f224326b);
    L15:
        return r104 + r107;
    L11:
        if (r106 >= 0) goto L13;
        r107 = Math.max(r106, -this.f224326b);
        goto L15
    L13:
        r107 = 0;
        goto L15
    }
}
