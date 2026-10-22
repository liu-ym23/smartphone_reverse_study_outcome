package com.bytedance.ug.sdk.luckycat.impl.popup.roundLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import tj7.a;

/* JADX INFO: loaded from: classes22.dex */
public class RoundFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f271424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f271425b;

    public RoundFrameLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        a r101 = this.f271424a;
        if (r101.f546432g > 0.0f) goto L5;
    L7:
        super.draw(r100);
        a r102 = this.f271424a;
        int r103 = this.f271425b;
        if (r102.f546432g <= 0.0f) goto L16;
        r102.f546426a.reset();
        r102.f546428c.reset();
        r102.f546426a.setAntiAlias(true);
        r102.f546426a.setStyle(Paint.Style.FILL);
        r102.f546426a.setXfermode(r102.f546430e);
        r102.f546428c.addRoundRect(r102.f546427b, r102.f546431f, Path.Direction.CCW);
        if (Build.VERSION.SDK_INT < 23) goto L13;
        r102.f546429d.reset();
        r102.f546429d.addRect(r102.f546427b, Path.Direction.CCW);
        r102.f546429d.op(r102.f546428c, Path.Op.DIFFERENCE);
        r100.drawPath(r102.f546429d, r102.f546426a);
    L14:
        r102.f546426a.setXfermode(null);
        r100.restore();
        return;
    L13:
        r100.save();
        r100.clipPath(r102.f546428c, Region.Op.DIFFERENCE);
        r100.drawPath(r102.f546428c, r102.f546426a);
        r100.drawColor(r103);
        goto L14
    L16:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        r100.saveLayer(r101.f546427b, null, 31);
        goto L7
    }

    public void setMaskColor(int r100) {
        this.f271425b = r100;
    }

    public RoundFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, -1);
    }

    public RoundFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a r103 = new a();
        this.f271424a = r103;
        this.f271425b = 0;
        r103.f546433h = this;
        r103.f546431f = new float[8];
        r103.f546426a = new Paint();
        r103.f546427b = new RectF();
        r103.f546428c = new Path();
        r103.f546429d = new Path();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        PorterDuff.Mode r104 = PorterDuff.Mode.DST_OUT;
    L6:
        r103.f546430e = new PorterDuffXfermode(r104);
        r103.a(5.0f, "");
        return;
    L5:
        r104 = PorterDuff.Mode.DST_IN;
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a r104 = this.f271424a;
        RectF r105 = r104.f546427b;
        if (r105 != null) goto L5;
        return;
    L5:
        if (r104.f546432g <= 0.0f) goto L9;
        r105.set(0.0f, 0.0f, r100, r101);
        return;
    }
}
