package com.obric.oui.popover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.layout.OUIFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/SingleChildFrameLayout;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class SingleChildFrameLayout extends OUIFrameLayout {
    public SingleChildFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public SingleChildFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0, 12);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        View r102 = getChildAt(0);
        if (r102 != null) goto L5;
        return;
    L5:
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        int r105 = View.MeasureSpec.getMode(r101);
        int r106 = View.MeasureSpec.getSize(r101);
        int r107 = (r102.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
        int r108 = (r102.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom();
        if (r103 != Integer.MIN_VALUE) goto L9;
        if (r105 != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(r107, r108);
        return;
    L9:
        if (r103 != Integer.MIN_VALUE) goto L11;
        setMeasuredDimension(r107, r106);
        return;
    L11:
        if (r105 != Integer.MIN_VALUE) goto L13;
        setMeasuredDimension(r104, r108);
        return;
    L13:
        setMeasuredDimension(r104, r106);
    }
}
