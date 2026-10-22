package com.bytedance.ee.bear.document.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.larus.nova.R;
import xo5.a;

/* JADX INFO: loaded from: classes16.dex */
public class DragButton extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f222486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f222487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f222488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f222489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile float f222490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f222491f;

    public DragButton(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        r100.save();
        r100.translate(getPaddingLeft(), getPaddingTop());
        this.f222486a.reset();
        double r101 = Math.sqrt(Math.pow(((double) this.f222489d) / 2.0d, 2.0d) + Math.pow(this.f222490e, AudioStats.AUDIO_AMPLITUDE_NONE));
        double r102 = ((double) (this.f222488c * this.f222490e)) / r101;
        float r103 = (float) (((((double) this.f222489d) / 2.0d) * r102) / r101);
        float r104 = (float) ((((double) this.f222490e) * r102) / r101);
        this.f222486a.moveTo(r103, r104);
        this.f222486a.lineTo(this.f222489d / 2, this.f222490e);
        this.f222486a.lineTo(this.f222489d - r103, r104 + 0.0f);
        this.f222486a.lineTo(this.f222489d, this.f222488c);
        this.f222486a.lineTo(this.f222489d / 2, this.f222490e + this.f222488c);
        this.f222486a.lineTo(0.0f, this.f222488c);
        this.f222486a.close();
        r100.drawPath(this.f222486a, this.f222487b);
        this.f222486a.reset();
        this.f222486a.moveTo(r103, r104);
        Path r105 = this.f222486a;
        int r106 = this.f222488c;
        r105.quadTo((-r106) / 2.0f, r106 / 2.0f, 0.0f, r106);
        this.f222486a.close();
        r100.drawPath(this.f222486a, this.f222487b);
        this.f222486a.reset();
        this.f222486a.moveTo(this.f222489d - r103, r104);
        Path r107 = this.f222486a;
        int r108 = this.f222489d;
        int r109 = this.f222488c;
        r107.quadTo(r108 + (r109 / 2.0f), r109 / 2.0f, r108, r109);
        this.f222486a.close();
        r100.drawPath(this.f222486a, this.f222487b);
        r100.restore();
    }

    public void setDragOffset(float r100) {
        if (r100 <= 1.0f) goto L5;
        r100 = 1.0f;
    L5:
        this.f222490e = (1.0f - r100) * this.f222491f;
        postInvalidate();
    }

    public DragButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public DragButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f222488c = a.a(6.0f);
        float r103 = a.a(3.5f);
        this.f222491f = r103;
        this.f222490e = r103;
        this.f222486a = new Path();
        this.f222487b = new Paint();
        new RectF();
        this.f222487b.setColor(getResources().getColor(R.color.lkui_N300));
        this.f222487b.setAntiAlias(true);
        this.f222487b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f222489d = (r100 - getPaddingLeft()) - getPaddingRight();
        getPaddingBottom();
        getPaddingTop();
    }
}
