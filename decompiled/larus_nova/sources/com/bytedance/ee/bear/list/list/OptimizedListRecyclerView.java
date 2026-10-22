package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.ListRecyclerView;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoRef;
import dd5.w0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class OptimizedListRecyclerView extends ListRecyclerView {
    public OptimizedListRecyclerView(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if ((getLayoutManager() instanceof GridLayoutManager) == true) goto L5;
        return;
    L5:
        if (getAdapter() == null) goto L9;
        requestLayout();
        getAdapter().notifyDataSetChanged();
        return;
    }

    public OptimizedListRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if ((getLayoutManager() instanceof GridLayoutManager) == false) goto L24;
        Context r102 = getContext();
        int r103 = w0.f468013a;
        int r104 = w0.a(ContextsKt.findActivity(r102));
        if (getMeasuredWidth() == 0) goto L18;
        int r105 = getMeasuredWidth();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r106 = 2;
        if (ku5.c.k(r102) == false) goto L11;
        int r107 = r105 - n.d(32);
        int r108 = (r107 - n.d(12)) / 2;
        int r109 = n.d(VideoRef.VALUE_VIDEO_REF_CATEGORY);
        int r110 = n.d(138);
        if (r108 < r110) goto L11;
    L12:
        if (r108 < r110) goto L16;
        if (r108 > r109) goto L16;
        r104 = r106;
    L16:
        r106 = r106 + 1;
        r108 = r107 / r106;
    L11:
        r104 = 2;
    L18:
        if (((GridLayoutManager) getLayoutManager()).getSpanCount() == r104) goto L25;
        tt5.a.h("OptimizedListRecyclerView", "update recycleView column when window size change column " + r104 + ", currentWidth is " + getMeasuredWidth());
        ((GridLayoutManager) getLayoutManager()).setSpanCount(r104);
        return;
    L25:
        return;
    }

    public OptimizedListRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
