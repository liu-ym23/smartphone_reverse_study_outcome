package com.bytedance.android.shopping.product.flow.banner;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yg3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OverScrollPagerSnapHelper extends PagerSnapHelper {
    public e a;
    public final int b;

    public OverScrollPagerSnapHelper() {
        Resources r1 = Resources.getSystem();
        this.b = MathKt.roundToInt(TypedValue.applyDimension(1, 60, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
    }

    public final void a(RecyclerView.LayoutManager r3) {
        View r0 = r3.findViewByPosition(r3.getItemCount() - 1);
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r3.getWidth() - r3.getDecoratedLeft(r0)) <= this.b) goto L11;
        e r4 = this.a;
        if (r4 == null) goto L12;
        r4.g();
        return;
    L12:
        return;
    }

    public final View findSnapView(RecyclerView.LayoutManager r4) {
        Intrinsics.checkNotNullParameter(r4, "layoutManager");
        a(r4);
        int r0 = r4.getItemCount() - 1;
        View r1 = super.findSnapView(r4);
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r4.getPosition(r1) == r0) goto L9;
        return r1;
    L9:
        return r4.findViewByPosition(r0 - 1);
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        a(r2);
        int r5 = super.findTargetSnapPosition(r2, r3, r4);
        if (r5 == (r2.getItemCount() - 1)) goto L5;
        return r5;
    L5:
        return r5 - 1;
    }
}
