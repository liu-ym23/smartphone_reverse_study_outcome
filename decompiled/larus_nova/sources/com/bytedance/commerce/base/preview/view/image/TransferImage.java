package com.bytedance.commerce.base.preview.view.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes15.dex */
public class TransferImage extends PhotoView {
    public int T;
    public long U;
    public Paint V;
    public Matrix W;

    public interface a {
    }

    public float[] getAfterTransferSize() {
        float[] r100 = {0.0f, 0.0f};
        Drawable r101 = getDrawable();
        if (r101 != null) goto L5;
        return r100;
    L5:
        float r102 = Math.min(getWidth() / r101.getIntrinsicWidth(), getHeight() / r101.getIntrinsicHeight());
        r100[0] = r101.getIntrinsicWidth() * r102;
        r100[1] = r101.getIntrinsicHeight() * r102;
        return r100;
    }

    public void setOnTransferListener(a r100) {
    }

    public long getDuration() {
        return this.U;
    }

    public int getState() {
        return this.T;
    }

    public TransferImage(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        if (getDrawable() != null) goto L6;
        return;
    L6:
        if (this.T == 0) goto L9;
        super.onDraw(r100);
        return;
    L9:
        r100.drawPaint(this.V);
        super.onDraw(r100);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    public void setDuration(long r100) {
        this.U = r100;
    }

    public void setState(int r100) {
        this.T = r100;
    }

    public TransferImage(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public TransferImage(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.T = 0;
        this.U = 300;
        this.W = new Matrix();
        Paint r103 = new Paint();
        this.V = r103;
        r103.setAlpha(0);
    }
}
