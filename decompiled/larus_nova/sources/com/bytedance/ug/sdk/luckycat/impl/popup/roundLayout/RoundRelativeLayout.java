package com.bytedance.ug.sdk.luckycat.impl.popup.roundLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes22.dex */
public class RoundRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f271426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f271427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f271428c;

    public RoundRelativeLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        r100.save();
        this.f271426a.reset();
        Path r101 = this.f271426a;
        RectF r102 = this.f271427b;
        float r103 = this.f271428c;
        r101.addRoundRect(r102, r103, r103, Path.Direction.CW);
        r100.clipPath(this.f271426a);
        super.draw(r100);
        r100.restore();
    }

    public RoundRelativeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public RoundRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f271428c = 200.0f;
        this.f271426a = new Path();
        Paint r103 = new Paint(1);
        this.f271427b = new RectF();
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f271427b.set(0.0f, 0.0f, r100, r101);
    }
}
