package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h6 extends FrameLayout {
    public h6(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        View r102 = getChildAt(0);
        if (r102 != null) goto L5;
        return;
    L5:
        measureChildWithMargins(r102, r100, 0, r101, 0);
        int r103 = (r102.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
        int r104 = (r102.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom();
        if (r103 <= getMeasuredWidth()) goto L8;
    L9:
        setMeasuredDimension(Math.max(getMeasuredWidth(), r103), Math.max(getMeasuredHeight(), r104));
        return;
    L8:
        if (r104 > getMeasuredHeight()) goto L9;
    }
}
