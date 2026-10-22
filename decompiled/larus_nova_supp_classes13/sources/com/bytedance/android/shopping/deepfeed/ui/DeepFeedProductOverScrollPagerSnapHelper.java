package com.bytedance.android.shopping.deepfeed.ui;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductOverScrollPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductOverScrollPagerSnapHelper extends PagerSnapHelper {
    public e a;
    public final int b;
    public boolean c;
    public boolean d;
    public boolean e;

    public DeepFeedProductOverScrollPagerSnapHelper() {
        Resources r1 = Resources.getSystem();
        this.b = MathKt.roundToInt(TypedValue.applyDimension(1, 35, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
    }

    public final void a(RecyclerView.LayoutManager r3) {
        View r0 = r3.findViewByPosition(r3.getItemCount() - 2);
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r3.getWidth() - r3.getDecoratedLeft(r0)) > this.b) goto L7;
        return;
    L7:
        if (this.e == true) goto L14;
        this.e = true;
        e r4 = this.a;
        if (r4 == null) goto L15;
        r4.g();
        return;
    L15:
        return;
    }

    public final View findSnapView(RecyclerView.LayoutManager r4) {
        Intrinsics.checkNotNullParameter(r4, "layoutManager");
        if (this.c == false) goto L5;
    L9:
        a(r4);
        if (this.e == true) goto L12;
        int r0 = r4.getItemCount() - 2;
        View r1 = super.findSnapView(r4);
        if (r1 != null) goto L18;
        return null;
    L18:
        if (r4.getPosition(r1) == r0) goto L20;
        return r1;
    L20:
        return r4.findViewByPosition(r0 - 1);
    L12:
        return r4.findViewByPosition(r4.getItemCount() - 1);
    L5:
        if (this.d == true) goto L9;
        return super.findSnapView(r4);
    }

    public final int findTargetSnapPosition(RecyclerView.LayoutManager r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        if (this.c == false) goto L5;
    L9:
        a(r2);
        if (this.e == true) goto L12;
        int r5 = super.findTargetSnapPosition(r2, r3, r4);
        if (r5 == (r2.getItemCount() - 2)) goto L16;
        return r5;
    L16:
        return r5 - 1;
    L12:
        return r2.getItemCount() - 1;
    L5:
        if (this.d == true) goto L9;
        return super.findTargetSnapPosition(r2, r3, r4);
    }
}
