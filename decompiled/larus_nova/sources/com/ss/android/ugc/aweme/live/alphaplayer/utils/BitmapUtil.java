package com.ss.android.ugc.aweme.live.alphaplayer.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;

/* JADX INFO: loaded from: classes40.dex */
public class BitmapUtil {
    public static Bitmap a(MaskSrc r100) {
        if (TextUtils.isEmpty(r100.f451157c) == false) goto L6;
        return null;
    L6:
        TextPaint r101 = new TextPaint();
        r101.setAntiAlias(true);
        r101.setTextAlign(Paint.Align.CENTER);
        r101.setStyle(Paint.Style.FILL);
        if (r100.f451160f == false) goto L10;
        r101.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
    L10:
        if (r100.f451159e > 0) goto L12;
        r100.f451159e = 36;
    L12:
        r101.setTextSize(r100.f451159e * 0.6f);
        if (TextUtils.isEmpty(r100.f451158d) == false) goto L15;
        r100.f451158d = "#FF000000";
    L15:
        r101.setColor(ColorProtector.parseColor(r100.f451158d));
        Rect r102 = new Rect();
        String r103 = r100.f451157c;
        r101.getTextBounds(r103, 0, r103.length(), r102);
        int r104 = r102.width();
        int r105 = r102.height();
        r102.set(0, 0, r104, r105);
        Bitmap r106 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);
        Canvas r107 = new Canvas(r106);
        r106.eraseColor(0);
        Paint.FontMetricsInt r108 = r101.getFontMetricsInt();
        int r109 = r102.centerY();
        int r110 = r108.bottom;
        r107.drawText(r100.f451157c, r102.centerX(), (r109 + ((r110 - r108.top) / 2)) - r110, r101);
        return r106;
    }
}
