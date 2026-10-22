package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import v19.c;

/* JADX INFO: loaded from: classes41.dex */
public class HorizontalProgressWheelView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f464525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f464526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f464527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f464528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f464529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f464530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f464531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f464532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f464533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f464534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f464535k;

    public interface a {
        void a();

        void b(float r100);

        void c();
    }

    public HorizontalProgressWheelView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        r110.getClipBounds(this.f464525a);
        int r100 = this.f464525a.width();
        int r101 = this.f464530f;
        int r102 = this.f464532h;
        int r103 = r100 / (r101 + r102);
        float r104 = this.f464534j % (r102 + r101);
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L12;
        int r106 = r103 / 4;
        if (r105 >= r106) goto L8;
        this.f464528d.setAlpha((int) ((r105 / r106) * 255.0f));
    L11:
        float r107 = -r104;
        Rect r108 = this.f464525a;
        float r109 = (r108.left + r107) + ((this.f464530f + this.f464532h) * r105);
        float r111 = r108.centerY() - (this.f464531g / 4.0f);
        Rect r112 = this.f464525a;
        r110.drawLine(r109, r111, (r107 + r112.left) + ((this.f464530f + this.f464532h) * r105), r112.centerY() + (this.f464531g / 4.0f), this.f464528d);
        r105 = r105 + 1;
        goto L3
    L8:
        if (r105 <= ((r103 * 3) / 4)) goto L10;
        this.f464528d.setAlpha((int) (((r103 - r105) / r106) * 255.0f));
        goto L11
    L10:
        this.f464528d.setAlpha(255);
        goto L11
    L12:
        r110.drawLine(this.f464525a.centerX(), this.f464525a.centerY() - (this.f464531g / 2.0f), this.f464525a.centerX(), (this.f464531g / 2.0f) + this.f464525a.centerY(), this.f464529e);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L21;
        if (r101 != 1) goto L6;
        a r102 = this.f464526b;
        if (r102 == null) goto L22;
        this.f464533i = false;
        r102.c();
    L22:
        return true;
    L6:
        if (r101 != 2) goto L22;
        float r103 = r100.getX() - this.f464527c;
        if (r103 == 0.0f) goto L22;
        if (this.f464533i == true) goto L15;
        this.f464533i = true;
        a r104 = this.f464526b;
        if (r104 == null) goto L15;
        r104.a();
    L15:
        this.f464534j -= r103;
        postInvalidate();
        this.f464527c = r100.getX();
        a r105 = this.f464526b;
        if (r105 == null) goto L22;
        r105.b(-r103);
        goto L22
    L21:
        this.f464527c = r100.getX();
        goto L22
    }

    public void setMiddleLineColor(int r100) {
        this.f464535k = r100;
        this.f464529e.setColor(r100);
        invalidate();
    }

    public void setScrollingListener(a r100) {
        this.f464526b = r100;
    }

    public HorizontalProgressWheelView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public HorizontalProgressWheelView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f464525a = new Rect();
        this.f464535k = ContextCompat.getColor(getContext(), c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50));
        this.f464530f = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.f464531g = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.f464532h = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint r103 = new Paint(1);
        this.f464528d = r103;
        r103.setStyle(Paint.Style.STROKE);
        this.f464528d.setStrokeWidth(this.f464530f);
        this.f464528d.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint r104 = new Paint(this.f464528d);
        this.f464529e = r104;
        r104.setColor(this.f464535k);
        this.f464529e.setStrokeCap(Paint.Cap.ROUND);
        this.f464529e.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }
}
