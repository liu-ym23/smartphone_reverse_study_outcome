package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public class Guideline extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f400466a;

    @Override // android.view.View
    public final void draw(Canvas r100) {
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
    }

    public Guideline(Context r100) {
        super(r100);
        this.f400466a = true;
        super.setVisibility(8);
    }

    public void setFilterRedundantCalls(boolean r100) {
        this.f400466a = r100;
    }

    public void setGuidelineBegin(int r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f400466a == true) goto L5;
    L7:
        r101.f400403a = r100;
        setLayoutParams(r101);
        return;
    L5:
        if (r101.f400403a != r100) goto L7;
    }

    public void setGuidelineEnd(int r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f400466a == true) goto L5;
    L7:
        r101.f400405b = r100;
        setLayoutParams(r101);
        return;
    L5:
        if (r101.f400405b != r100) goto L7;
    }

    public void setGuidelinePercent(float r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (this.f400466a == true) goto L5;
    L7:
        r101.f400407c = r100;
        setLayoutParams(r101);
        return;
    L5:
        if (r101.f400407c != r100) goto L7;
    }

    public Guideline(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f400466a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(0, 0);
    }

    public Guideline(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f400466a = true;
        super.setVisibility(8);
    }
}
