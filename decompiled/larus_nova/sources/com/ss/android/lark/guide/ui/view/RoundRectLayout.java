package com.ss.android.lark.guide.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class RoundRectLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f425816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f425817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f425818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f425819d;

    public float getCornerRadius() {
        return this.f425816a;
    }

    public RoundRectLayout(Context r100) {
        super(r100);
        this.f425818c = new Path();
    }

    public final void a(AttributeSet r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.cornerRadius, R.attr.fillColor, R.attr.leftBottomRound, R.attr.leftTopRound, R.attr.rightBottomRound, R.attr.rightTopRound, R.attr.round, R.attr.roundCorner}, 0, 0);
        this.f425816a = r101.getDimension(0, 0.0f);
        this.f425817b = r101.getColor(1, 0);
        r101.recycle();
        setFillColor(this.f425817b);
        setPadding(10, 10, 10, 10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        int r101 = r100.save();
        setLayerType(1, null);
        r100.clipPath(this.f425818c);
        super.dispatchDraw(r100);
        r100.restoreToCount(r101);
    }

    public void setCornerRadius(float r100) {
        this.f425816a = r100;
    }

    public void setFillColor(int r100) {
        this.f425817b = r100;
    }

    public RoundRectLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f425818c = new Path();
        a(r101);
    }

    public RoundRectLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f425818c = new Path();
        a(r101);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f425819d = new RectF(0.0f, 0.0f, r100 * 1.0f, r101 * 1.0f);
        this.f425818c.reset();
        Path r104 = this.f425818c;
        RectF r105 = this.f425819d;
        float r106 = this.f425816a;
        r104.addRoundRect(r105, r106, r106, Path.Direction.CW);
        this.f425818c.close();
        GradientDrawable r107 = new GradientDrawable();
        r107.setCornerRadius(this.f425816a);
        r107.setColor(this.f425817b);
        setBackground(r107);
    }
}
