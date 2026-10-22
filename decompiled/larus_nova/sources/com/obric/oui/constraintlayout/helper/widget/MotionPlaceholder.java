package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.obric.oui.constraintlayout.core.widgets.h;
import com.obric.oui.constraintlayout.core.widgets.i;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import ula.a;

/* JADX INFO: loaded from: classes34.dex */
public class MotionPlaceholder extends VirtualLayout {
    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void s(a r100, SparseArray r101) {
    }

    public MotionPlaceholder(Context r100) {
        super(r100);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void n(AttributeSet r100) {
        super.n(r100);
        this.f400380d = new h();
        t();
    }

    public MotionPlaceholder(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onMeasure(int r100, int r101) {
        u(null, r100, r101);
    }

    public MotionPlaceholder(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout
    public final void u(i r100, int r101, int r102) {
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r101);
        int r105 = View.MeasureSpec.getMode(r102);
        int r106 = View.MeasureSpec.getSize(r102);
        if (r100 == null) goto L5;
        r100.U(r103, r104, r105, r106);
        setMeasuredDimension(r100.G0, r100.H0);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }
}
