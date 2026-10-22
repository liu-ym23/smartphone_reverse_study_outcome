package com.ss.android.lark.widget.dialog.loadingdialog.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import gcc.a;
import j08.b;

/* JADX INFO: loaded from: classes38.dex */
public class AnnularView extends View implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f445808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f445809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f445810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f445811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f445812e;

    public AnnularView(Context r100) {
        super(r100);
        this.f445811d = 100;
        this.f445812e = 0;
        a(r100);
    }

    public final void a(Context r100) {
        Paint r101 = new Paint(1);
        this.f445808a = r101;
        r101.setStyle(Paint.Style.STROKE);
        this.f445808a.setStrokeWidth(UIUtils.dp2px(getContext(), 3.0f));
        this.f445808a.setColor(-1);
        Paint r102 = new Paint(1);
        this.f445809b = r102;
        r102.setStyle(Paint.Style.STROKE);
        this.f445809b.setStrokeWidth(UIUtils.dp2px(getContext(), 3.0f));
        this.f445809b.setColor(b.b(r100.getResources().getColor(R.color.lkui_N500), 0.26f));
        this.f445810c = new RectF();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        float r100 = (this.f445812e * 360.0f) / this.f445811d;
        r110.drawArc(this.f445810c, 270.0f, r100, false, this.f445808a);
        r110.drawArc(this.f445810c, r100 + 270.0f, 360.0f - r100, false, this.f445809b);
    }

    @Override // gcc.a
    public void setMax(int r100) {
        this.f445811d = r100;
    }

    public void setProgress(int r100) {
        this.f445812e = r100;
        invalidate();
    }

    public AnnularView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f445811d = 100;
        this.f445812e = 0;
        a(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = UIUtils.dp2px(getContext(), 40.0f);
        setMeasuredDimension(r102, r102);
    }

    public AnnularView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f445811d = 100;
        this.f445812e = 0;
        a(r100);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = UIUtils.dp2px(getContext(), 4.0f);
        float r105 = r104;
        this.f445810c.set(r105, r105, r100 - r104, r101 - r104);
    }
}
