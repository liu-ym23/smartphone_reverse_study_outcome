package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes34.dex */
public class ClipImageView extends ImageView {
    private boolean mClip;
    private Paint mPaint;
    private Path mPath;
    private float[] mRadius;
    private RectF mRectF;

    public boolean isClip() {
        return this.mClip;
    }

    public ClipImageView(Context r100) {
        super(r100);
        this.mClip = true;
        init(r100);
    }

    public void init(Context r100) {
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        if (this.mClip == false) goto L10;
        this.mPath.reset();
        this.mRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        float[] r101 = this.mRadius;
        if (r101 == null) goto L7;
        this.mPath.addRoundRect(this.mRectF, r101, Path.Direction.CW);
    L7:
        r100.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        r100.clipPath(this.mPath);
        Paint r102 = this.mPaint;
        if (r102 == null) goto L10;
        r100.drawPath(this.mPath, r102);
    L10:
        super.onDraw(r100);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        Paint r101 = new Paint(1);
        this.mPaint = r101;
        r101.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(r100);
    }

    public void setClip(boolean r100) {
        this.mClip = r100;
    }

    public void setRadius(float[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length != 8) goto L9;
        this.mRadius = r100;
        return;
    }

    public void setRoundRadius(int r100) {
        if (r100 <= 0) goto L5;
        float r101 = r100;
        setRadius(new float[]{r101, r101, r101, r101, r101, r101, r101, r101});
        return;
    }

    public ClipImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mClip = true;
        init(r100);
    }

    public ClipImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mClip = true;
        init(r100);
    }
}
