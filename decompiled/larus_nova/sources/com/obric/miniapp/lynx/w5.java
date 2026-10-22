package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class w5 extends com.lynx.tasm.behavior.ui.view.a {
    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public w5(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = View.MeasureSpec.getMode(r101);
        int r105 = View.MeasureSpec.getSize(r101);
        int r106 = RangesKt.coerceAtLeast(getSuggestedMinimumWidth(), 0);
        int r107 = RangesKt.coerceAtLeast(getSuggestedMinimumHeight(), 0);
        if (r102 == Integer.MIN_VALUE) goto L6;
        if (r102 == 1073741824) goto L7;
        r103 = r106;
    L7:
        if (r104 == Integer.MIN_VALUE) goto L10;
        if (r104 == 1073741824) goto L11;
        r105 = r107;
    L11:
        setMeasuredDimension(r103, r105);
        return;
    L10:
        r105 = RangesKt.coerceAtMost(r107, r105);
        goto L11
    L6:
        r103 = RangesKt.coerceAtMost(r106, r103);
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L8;
        View r107 = getChildAt(r106);
        if (r107 == null) goto L7;
        r107.layout(0, 0, 0, 0);
    L7:
        r106 = r106 + 1;
        goto L3
    }
}
