package com.bytedance.android.shopping.feed.adapter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.feed.widget.BaseCardDetailView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/adapter/IgnorePosPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IgnorePosPagerSnapHelper extends PagerSnapHelper {
    public final List<Integer> a;
    public final Lazy b;
    public double c;

    public IgnorePosPagerSnapHelper() {
        this.a = new ArrayList();
        this.b = LazyKt.lazy(IgnorePosPagerSnapHelper$ecInflowHolderPosOpt$2.INSTANCE);
    }

    public final View findSnapView(RecyclerView.LayoutManager r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        if (r2.canScrollVertically() == false) goto L6;
        return b(r2, OrientationHelper.createVerticalHelper(r2));
    L6:
        if (r2.canScrollHorizontally() == true) goto L11;
        return null;
    L11:
        return b(r2, OrientationHelper.createHorizontalHelper(r2));
    }

    public static int a(View r1, OrientationHelper r2) {
        return (r2.getDecoratedStart(r1) + (r2.getDecoratedMeasurement(r1) / 2)) - (r2.getStartAfterPadding() + (r2.getTotalSpace() / 2));
    }

    public final View b(RecyclerView.LayoutManager r9, OrientationHelper r10) {
        int r0 = r9.getChildCount();
        View r1 = null;
        if (r0 != 0) goto L6;
    L22:
        return r1;
    L6:
        if (r9.getClipToPadding() == false) goto L8;
        int r2 = r10.getStartAfterPadding() + (r10.getTotalSpace() / 2);
    L9:
        int r3 = Integer.MAX_VALUE;
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L22;
        View r5 = r9.getChildAt(r4);
        if (r5 == null) goto L14;
        int r6 = r9.getPosition(r5);
    L15:
        List<Integer> r7 = this.a;
        ArrayList r8 = (ArrayList) r7;
        if (r8.contains(Integer.valueOf(r6)) == true) goto L21;
        if (r5 == null) goto L21;
        int r11 = Math.abs((r10.getDecoratedStart(r5) + (r10.getDecoratedMeasurement(r5) / 2)) - r2);
        if (r11 >= r3) goto L21;
        r1 = r5;
        r3 = r11;
    L21:
        r4 = r4 + 1;
        goto L10
    L14:
        r6 = -1;
        goto L15
    L8:
        r2 = r10.getEnd() / 2;
        goto L9
    }

    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "layoutManager");
        Intrinsics.checkNotNullParameter(r9, "targetView");
        if (((Number) this.b.getValue()).intValue() != 1) goto L14;
        int[] r0 = new int[2];
        r0[0] = 0;
        if ((r9 instanceof BaseCardDetailView) == false) goto L12;
        OrientationHelper r10 = OrientationHelper.createVerticalHelper(r8);
        if (this.c != 0.0d) goto L11;
        Context r2 = r9.getContext();
        if (r2 == null) goto L11;
        this.c = (((double) k1.j(r2)) * 0.05d) + ((double) k1.q());
    L11:
        r0[1] = (r10.getDecoratedStart(r9) - r10.getStartAfterPadding()) - ((int) this.c);
        return r0;
    L12:
        r0[1] = a(r9, OrientationHelper.createVerticalHelper(r8));
        return r0;
    L14:
        return super.calculateDistanceToFinalSnap(r8, r9);
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        int r0 = super.findTargetSnapPosition(r3, r4, r5);
        if (r3.canScrollHorizontally() == false) goto L6;
        if (r4 > 0) goto L7;
    L8:
        boolean r6 = false;
    L9:
        List<Integer> r7 = this.a;
        ArrayList r8 = (ArrayList) r7;
        if (r8.contains(Integer.valueOf(r0)) == false) goto L15;
        if (r6 == false) goto L14;
        return r0 + 1;
    L14:
        return r0 - 1;
    L15:
        return r0;
    L7:
        r6 = true;
        goto L9
    L6:
        if (r5 <= 0) goto L8;
        goto L7
    }
}
