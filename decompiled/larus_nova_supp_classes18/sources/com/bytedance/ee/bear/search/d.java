package com.bytedance.ee.bear.search;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static Bitmap a(Context r4, int r5) {
        Drawable r6 = AppCompatResources.getDrawable(r4, r5);
        if ((r6 instanceof BitmapDrawable) == false) goto L7;
        return ((BitmapDrawable) r6).getBitmap();
    L7:
        if ((r6 instanceof VectorDrawable) == false) goto L9;
    L13:
        int r7 = (int) h18.d.b(r4, 24);
        Bitmap r8 = Bitmap.createBitmap(r7, r7, Bitmap.Config.ARGB_8888);
        Canvas r0 = new Canvas(r8);
        r6.setBounds(0, 0, r0.getWidth(), r0.getHeight());
        r6.draw(r0);
        return r8;
    L9:
        if ((r6 instanceof VectorDrawableCompat) == true) goto L13;
        tt5.a.d("SearchUtil", "get bitmap from drawable fail:" + r6);
        return null;
    }
}
