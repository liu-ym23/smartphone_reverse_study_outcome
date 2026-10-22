package com.ss.android.lark.widget.dialog.loadingdialog.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import gcc.a;

/* JADX INFO: loaded from: classes38.dex */
public class PieView extends View implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f445822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f445823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f445824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f445825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f445826e;

    public final void a() {
        Paint r100 = new Paint(1);
        this.f445822a = r100;
        r100.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f445822a.setStrokeWidth(UIUtils.dp2px(getContext(), 0.1f));
        this.f445822a.setColor(-1);
        Paint r101 = new Paint(1);
        this.f445823b = r101;
        r101.setStyle(Paint.Style.STROKE);
        this.f445823b.setStrokeWidth(UIUtils.dp2px(getContext(), 2.0f));
        this.f445823b.setColor(-1);
        this.f445824c = new RectF();
    }

    public PieView(Context r100) {
        super(r100);
        this.f445825d = 100;
        this.f445826e = 0;
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawArc(this.f445824c, 270.0f, (this.f445826e * 360.0f) / this.f445825d, true, this.f445822a);
        r100.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - UIUtils.dp2px(getContext(), 4.0f), this.f445823b);
    }

    @Override // gcc.a
    public void setMax(int r100) {
        this.f445825d = r100;
    }

    public void setProgress(int r100) {
        this.f445826e = r100;
        invalidate();
    }

    public PieView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f445825d = 100;
        this.f445826e = 0;
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = UIUtils.dp2px(getContext(), 40.0f);
        setMeasuredDimension(r102, r102);
    }

    public PieView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f445825d = 100;
        this.f445826e = 0;
        a();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = UIUtils.dp2px(getContext(), 4.0f);
        float r105 = r104;
        this.f445824c.set(r105, r105, r100 - r104, r101 - r104);
    }
}
