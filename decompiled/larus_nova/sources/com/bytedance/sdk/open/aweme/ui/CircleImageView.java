package com.bytedance.sdk.open.aweme.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes22.dex */
public class CircleImageView extends ImageView {
    private static final Bitmap.Config BITMAP_CONFIG = null;
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private int boarder;
    private Paint paint;

    static {
        BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    }

    public CircleImageView(Context r100) {
        this(r100, null, 0);
    }

    public CircleImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CircleImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.boarder = 0;
        this.paint = new Paint();
    }

    private Bitmap dealRawBitmap(Bitmap r110) {
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        int r102 = Math.min(r100, r101);
        return scaleBitmap(Bitmap.createBitmap(r110, (r100 - r102) / 2, (r101 - r102) / 2, r102, r102, null, false));
    }

    private Bitmap getBitmapFromDrawable(Drawable r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof BitmapDrawable) == true) goto L8;
    L15:
        return null;
    L10:
        if ((r100 instanceof ColorDrawable) == false) goto L12;
        Bitmap.Config r101 = BITMAP_CONFIG;     // Catch: Exception -> L15
        int r102 = 2;
        int r103 = 2;
    L13:
        Bitmap r104 = Bitmap.createBitmap(r102, r103, r101);     // Catch: Exception -> L15
        Canvas r105 = new Canvas(r104);     // Catch: Exception -> L15
        r100.setBounds(0, 0, r105.getWidth(), r105.getHeight());     // Catch: Exception -> L15
        r100.draw(r105);     // Catch: Exception -> L15
        return r104;
    L12:
        r102 = getWidth();     // Catch: Exception -> L15
        int r106 = getHeight();     // Catch: Exception -> L15
        r103 = r106;
        r101 = BITMAP_CONFIG;     // Catch: Exception -> L15
        goto L13
    L8:
        return ((BitmapDrawable) r100).getBitmap();
    }

    private Bitmap scaleBitmap(Bitmap r100) {
        float r101 = (getWidth() - (this.boarder * 2)) / r100.getWidth();
        Matrix r102 = new Matrix();
        r102.postScale(r101, r101);
        return Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r102, true);
    }

    private Bitmap toRoundCorner(Bitmap r100) {
        Bitmap r101 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r102 = new Canvas(r101);
        Rect r103 = new Rect(0, 0, r100.getWidth(), r100.getHeight());
        this.paint.setAntiAlias(true);
        r102.drawARGB(0, 0, 0, 0);
        this.paint.setColor(-12434878);
        float r104 = r100.getWidth() / 2;
        r102.drawCircle(r104, r104, r104, this.paint);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r102.drawBitmap(r100, r103, r103, this.paint);
        return r101;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        Bitmap r101 = getBitmapFromDrawable(getDrawable());
        if (r101 == null) goto L7;
        Bitmap r102 = toRoundCorner(dealRawBitmap(r101));
        int r103 = r102.getWidth() / 2;
        this.paint.reset();
        int r104 = this.boarder;
        r100.drawBitmap(r102, null, new Rect(r104, r104, getWidth() - this.boarder, getHeight() - this.boarder), this.paint);
        if (this.boarder <= 0) goto L9;
        Paint r105 = new Paint();
        r105.setColor(-1);
        r105.setStyle(Paint.Style.STROKE);
        r105.setStrokeWidth(this.boarder);
        r100.drawCircle(getWidth() / 2.0f, getHeight() / 2, r103 + (this.boarder / 2), r105);
        return;
    L9:
        return;
    L7:
        super.onDraw(r100);
    }

    public void setBoarder(int r100) {
        this.boarder = r100;
    }
}
