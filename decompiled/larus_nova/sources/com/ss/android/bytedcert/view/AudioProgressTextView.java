package com.ss.android.bytedcert.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes34.dex */
public class AudioProgressTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f407707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f407708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f407709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f407710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f407711e;

    private Paint getNewPaint() {
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        r100.setDither(true);
        r100.setTextSize(getTextSize());
        return r100;
    }

    public AudioProgressTextView(Context r100) {
        super(r100);
        this.f407710d = new Rect();
        this.f407711e = new Rect();
        this.f407709c = getNewPaint();
        this.f407708b = getNewPaint();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        int r101 = getWidth();
        int r102 = getCompoundPaddingLeft();
        int r103 = getCompoundPaddingRight();
        float r104 = this.f407707a;
        if (r104 > 0.0f) goto L6;
        x(r100, this.f407708b, r102, r101 - r103);
        return;
    L6:
        int r105 = (int) (((r101 - r102) - r103) * r104);
        x(r100, this.f407709c, r102, r105);
        x(r100, this.f407708b, r105 + r102, r101 - r103);
    }

    public void setProgress(float r100) {
        if (r100 < 1.0f) goto L5;
        r100 = 0.0f;
    L5:
        this.f407707a = r100;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int r100) {
        this.f407708b.setColor(r100);
        super.setTextColor(r100);
    }

    public AudioProgressTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f407710d = new Rect();
        this.f407711e = new Rect();
        this.f407709c = getNewPaint();
        this.f407708b = getNewPaint();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextSize(int r100, float r101) {
        Resources r102 = getResources();
        float r103 = TypedValue.applyDimension(r100, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        this.f407709c.setTextSize(r103);
        this.f407708b.setTextSize(r103);
        requestLayout();
        invalidate();
    }

    public AudioProgressTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f407710d = new Rect();
        this.f407711e = new Rect();
        this.f407709c = getNewPaint();
        this.f407708b = getNewPaint();
    }

    public final void x(Canvas r100, Paint r101, int r102, int r103) {
        r100.save();
        this.f407710d.set(r102, getCompoundPaddingTop(), r103, getBottom() - getCompoundPaddingBottom());
        r100.clipRect(this.f407710d);
        r101.getTextBounds(getText().toString(), 0, getText().toString().length(), this.f407711e);
        int r104 = (getWidth() - this.f407711e.width()) / 2;
        Paint.FontMetricsInt r105 = r101.getFontMetricsInt();
        int r106 = r105.bottom;
        r100.drawText(getText().toString(), r104, (getHeight() / 2) + (((r106 - r105.top) / 2) - r106), r101);
        r100.restore();
    }
}
