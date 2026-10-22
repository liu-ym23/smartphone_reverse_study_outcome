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
public class BarView extends View implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f445815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f445816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f445817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f445818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f445819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f445820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f445821g;

    public final void a() {
        Paint r100 = new Paint(1);
        this.f445815a = r100;
        r100.setStyle(Paint.Style.STROKE);
        this.f445815a.setStrokeWidth(UIUtils.dp2px(getContext(), 2.0f));
        this.f445815a.setColor(-1);
        Paint r101 = new Paint(1);
        this.f445816b = r101;
        r101.setStyle(Paint.Style.FILL);
        this.f445816b.setColor(-1);
        this.f445821g = UIUtils.dp2px(getContext(), 5.0f);
        float r102 = this.f445821g;
        this.f445818d = new RectF(r102, r102, ((getWidth() - this.f445821g) * this.f445820f) / this.f445819e, getHeight() - this.f445821g);
        this.f445817c = new RectF();
    }

    public BarView(Context r100) {
        super(r100);
        this.f445819e = 100;
        this.f445820f = 0;
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        RectF r101 = this.f445817c;
        r100.drawRoundRect(r101, r101.height() / 2.0f, this.f445817c.height() / 2.0f, this.f445815a);
        RectF r102 = this.f445818d;
        r100.drawRoundRect(r102, r102.height() / 2.0f, this.f445818d.height() / 2.0f, this.f445816b);
    }

    @Override // gcc.a
    public void setMax(int r100) {
        this.f445819e = r100;
    }

    public void setProgress(int r100) {
        this.f445820f = r100;
        RectF r101 = this.f445818d;
        float r102 = this.f445821g;
        r101.set(r102, r102, ((getWidth() - this.f445821g) * this.f445820f) / this.f445819e, getHeight() - this.f445821g);
        invalidate();
    }

    public BarView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f445819e = 100;
        this.f445820f = 0;
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(UIUtils.dp2px(getContext(), 100.0f), UIUtils.dp2px(getContext(), 20.0f));
    }

    public BarView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f445819e = 100;
        this.f445820f = 0;
        a();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = UIUtils.dp2px(getContext(), 2.0f);
        float r105 = r104;
        this.f445817c.set(r105, r105, r100 - r104, r101 - r104);
    }
}
