package com.larksuite.component.universe_design.dialog.frame;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import h18.d;

/* JADX INFO: loaded from: classes24.dex */
public class MaxWidthLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f284962a;

    public MaxWidthLinearLayout(Context r100) {
        super(r100);
        this.f284962a = Math.round(d.b(getContext(), 450));
    }

    public MaxWidthLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f284962a = Math.round(d.b(getContext(), 450));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getMode(r100);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(r102, this.f284962a), r103), r101);
    }

    public MaxWidthLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f284962a = Math.round(d.b(getContext(), 450));
    }
}
