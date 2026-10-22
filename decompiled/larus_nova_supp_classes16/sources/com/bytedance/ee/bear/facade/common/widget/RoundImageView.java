package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RoundImageView extends AppCompatImageView {
    public Paint a;
    public int b;
    public float c;

    public RoundImageView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r7) {
        Paint r0 = new Paint();
        this.a = r0;
        r0.setDither(true);
        this.a.setAntiAlias(true);
        if (getDrawable() != null) goto L5;
        return;
    L5:
        Drawable r1 = getDrawable();
    L11:
        e = move-exception;
        tt5.a.f("BitmapUtils", e, false);
        Bitmap r2 = null;
    L13:
        Shader.TileMode r3 = Shader.TileMode.CLAMP;
        BitmapShader r4 = new BitmapShader(r2, r3, r3);
        this.c = (this.b * 2.0f) / Math.min(r2.getHeight(), r2.getWidth());
        Matrix r5 = new Matrix();
        float r6 = this.c;
        r5.setScale(r6, r6);
        r4.setLocalMatrix(r5);
        this.a.setShader(r4);
        int r8 = this.b;
        r7.drawCircle(r8, r8, r8, this.a);
        return;
    L7:
        if ((r1 instanceof BitmapDrawable) == false) goto L9;
        r2 = ((BitmapDrawable) r1).getBitmap();     // Catch: Exception -> L11
    L15:
        goto L13
    L9:
        int r9 = r1.getIntrinsicWidth();     // Catch: Exception -> L11
        int r10 = r1.getIntrinsicHeight();     // Catch: Exception -> L11
        Bitmap r11 = Bitmap.createBitmap(r9, r10, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L11
        Canvas r12 = new Canvas(r11);     // Catch: Exception -> L11
        r1.setBounds(0, 0, r9, r10);     // Catch: Exception -> L11
        r1.draw(r12);     // Catch: Exception -> L11
        r2 = r11;
        goto L15
    }

    public RoundImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r1, int r2) {
        super/*android.widget.ImageView*/.onMeasure(r1, r2);
        this.b = Math.min(getMeasuredWidth(), getMeasuredHeight()) / 2;
    }

    public RoundImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
