package com.ss.android.bytedcert.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.larus.nova.R;
import com.ss.android.cert.manager.utils.CertLog;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class RectInsideBgView extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f407768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f407769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f407770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f407771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f407772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f407773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f407774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f407775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f407776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f407777j;

    public RectInsideBgView(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        getDrawingRect(this.f407770c);
        this.f407772e.setAntiAlias(true);
        this.f407772e.setStyle(Paint.Style.FILL);
        r110.drawRect(this.f407770c, this.f407772e);
        this.f407769b = this.f407770c.centerX();
        this.f407777j = i.c(this.f407768a, this.f407769b, this.f407770c.centerY(), getWidth(), getHeight(), true);
        this.f407771d.setStyle(Paint.Style.FILL);
        this.f407771d.setAlpha(0);
        r110.drawRoundRect(this.f407777j, i.b(this.f407768a, 16.0f), i.b(this.f407768a, 16.0f), this.f407771d);
        CertLog.d("getCenterRect", "test 3");
        int r100 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        this.f407776i.left = this.f407777j.left - i.b(this.f407768a, 0.8f);
        this.f407776i.right = this.f407777j.right + i.b(this.f407768a, 0.8f);
        this.f407776i.top = this.f407777j.top + i.b(this.f407768a, 0.8f);
        this.f407776i.bottom = this.f407777j.bottom - i.b(this.f407768a, 0.8f);
        r110.drawRoundRect(this.f407776i, i.b(this.f407768a, 16.0f), i.b(this.f407768a, 16.0f), this.f407773f);
        RectF r101 = this.f407776i;
        float r102 = r101.right;
        float r103 = r101.left;
        RectF r104 = this.f407775h;
        float r105 = (r102 - r103) / 6.0f;
        r104.bottom = r101.bottom - r105;
        r104.top = r101.top + r105;
        r104.left = r103;
        r104.right = r102;
        r110.drawRect(r104, this.f407774g);
        RectF r106 = this.f407775h;
        RectF r107 = this.f407776i;
        r106.bottom = r107.bottom;
        r106.top = r107.top;
        r106.left = r107.left + r105;
        r106.right = r107.right - r105;
        r110.drawRect(r106, this.f407774g);
        r110.restoreToCount(r100);
    }

    public RectInsideBgView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        CertLog.d("RectInsideBgView", "width " + r102 + " height " + r103);
        if (r102 <= r103) goto L5;
        r103 = r102;
    L7:
        setMeasuredDimension(r102, r103);
        return;
    L5:
        if (r102 >= r103) goto L7;
        r102 = r103;
        goto L7
    }

    public RectInsideBgView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f407771d = r103;
        Paint r104 = new Paint();
        this.f407772e = r104;
        Paint r105 = new Paint();
        this.f407773f = r105;
        Paint r106 = new Paint();
        this.f407774g = r106;
        this.f407775h = new RectF();
        this.f407776i = new RectF();
        this.f407768a = r100;
        this.f407770c = new Rect();
        r103.setAntiAlias(true);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r104.setAntiAlias(true);
        r104.setColor(getResources().getColor(R.color.byted_transparent));
        r105.setColor(-1);
        r105.setStrokeWidth(i.b(r100, 2.0f));
        r105.setStyle(Paint.Style.STROKE);
        r106.setStrokeWidth(i.b(r100, 3.0f));
        r106.setStyle(Paint.Style.STROKE);
        r106.setAntiAlias(true);
        r106.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }
}
