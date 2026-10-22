package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.ListRecyclerView;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.ContextsKt;
import dd5.w0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OptimizedListRecyclerView extends ListRecyclerView {
    public OptimizedListRecyclerView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r1) {
        super/*android.view.ViewGroup*/.onConfigurationChanged(r1);
        if ((getLayoutManager() instanceof GridLayoutManager) == true) goto L5;
        return;
    L5:
        if (getAdapter() == null) goto L9;
        requestLayout();
        getAdapter().notifyDataSetChanged();
        return;
    }

    public OptimizedListRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r4, int r5) {
        super/*androidx.recyclerview.widget.RecyclerView*/.onMeasure(r4, r5);
        if ((getLayoutManager() instanceof GridLayoutManager) == false) goto L24;
        Context r6 = getContext();
        int r7 = w0.a;
        int r8 = w0.a(ContextsKt.findActivity(r6));
        if (getMeasuredWidth() == 0) goto L18;
        int r9 = getMeasuredWidth();
        Intrinsics.checkNotNullParameter(r6, "context");
        int r0 = 2;
        if (ku5.c.k(r6) == false) goto L11;
        int r10 = r9 - n.d(32);
        int r11 = (r10 - n.d(12)) / 2;
        int r1 = n.d(232);
        int r2 = n.d(138);
        if (r11 < r2) goto L11;
    L12:
        if (r11 < r2) goto L16;
        if (r11 > r1) goto L16;
        r8 = r0;
    L16:
        r0 = r0 + 1;
        r11 = r10 / r0;
    L11:
        r8 = 2;
    L18:
        if (getLayoutManager().getSpanCount() == r8) goto L25;
        tt5.a.h("OptimizedListRecyclerView", "update recycleView column when window size change column " + r8 + ", currentWidth is " + getMeasuredWidth());
        getLayoutManager().setSpanCount(r8);
        return;
    L25:
        return;
    }

    public OptimizedListRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
