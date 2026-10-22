package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes34.dex */
public class Group extends ConstraintHelper {
    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void q() {
        ConstraintLayout.LayoutParams r100 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r100.f400436q0.Q(0);
        r100.f400436q0.N(0);
    }

    public Group(Context r100) {
        super(r100);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void j(ConstraintLayout r100) {
        i(r100);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void n(AttributeSet r100) {
        super.n(r100);
        this.f400381e = false;
    }

    @Override // android.view.View
    public void setElevation(float r100) {
        super.setElevation(r100);
        h();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        h();
    }

    public Group(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public Group(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
