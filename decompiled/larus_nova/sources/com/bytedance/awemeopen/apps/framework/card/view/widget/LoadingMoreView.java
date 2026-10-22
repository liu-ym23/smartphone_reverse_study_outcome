package com.bytedance.awemeopen.apps.framework.card.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import y54.a;

/* JADX INFO: loaded from: classes14.dex */
public class LoadingMoreView extends View {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f193917j = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f193918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f193919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f193920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f193921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f193922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f193923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f193924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f193925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f193926i;

    static {
        f193917j = n0.a(a.a(), 2.0f);
    }

    public LoadingMoreView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        this.f193919b.reset();
        float r101 = 0.0f;
        if (this.f193924g == 0.0f) goto L9;
        Path r102 = this.f193919b;
        float r103 = this.f193920c >> 1;
        float r104 = f193917j;
        r102.moveTo(r103, r104);
        float r105 = (this.f193920c >> 1) - (this.f193922e * this.f193924g);
        if (r105 < 0.0f) goto L8;
        r101 = r105;
    L8:
        this.f193919b.lineTo(r101, this.f193921d >> 1);
        this.f193919b.lineTo(this.f193920c >> 1, this.f193921d - r104);
    L10:
        r100.drawPath(this.f193919b, this.f193918a);
        super.onDraw(r100);
        return;
    L9:
        Path r106 = this.f193919b;
        float r107 = this.f193920c * 0.5f;
        float r108 = f193917j;
        r106.moveTo(r107, r108);
        this.f193919b.lineTo(this.f193920c * 0.5f, this.f193921d - r108);
        goto L10
    }

    public void setMoveSpace(float r100) {
        float r101 = (Math.abs(r100) * 2.0f) / this.f193925h;
        this.f193924g = r101;
        float r102 = this.f193926i;
        if (r101 < r102) goto L5;
        this.f193924g = r102;
    L5:
        invalidate();
    }

    public LoadingMoreView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f193920c = View.MeasureSpec.getSize(r100);
        this.f193921d = View.MeasureSpec.getSize(r101);
        this.f193922e = this.f193920c >> this.f193923f;
    }

    public LoadingMoreView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193920c = -1;
        this.f193921d = -1;
        this.f193922e = -1;
        this.f193923f = 1;
        int r103 = a.a().getResources().getColor(R.color.aos_text_quaternary);
        this.f193924g = 0.0f;
        this.f193926i = 0.8f;
        Paint r104 = new Paint();
        this.f193918a = r104;
        r104.setColor(r103);
        r104.setStyle(Paint.Style.STROKE);
        r104.setAntiAlias(true);
        r104.setStrokeWidth(5.0f);
        r104.setStrokeCap(Paint.Cap.ROUND);
        this.f193919b = new Path();
        Resources r105 = r100.getResources();
        this.f193925h = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).widthPixels;
    }
}
