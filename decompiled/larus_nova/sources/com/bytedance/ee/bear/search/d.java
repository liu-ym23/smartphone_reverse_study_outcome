package com.bytedance.ee.bear.search;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

/* JADX INFO: loaded from: classes18.dex */
public final class d {
    public static Bitmap a(Context r100, int r101) {
        Drawable r102 = AppCompatResources.getDrawable(r100, r101);
        if ((r102 instanceof BitmapDrawable) == false) goto L7;
        return ((BitmapDrawable) r102).getBitmap();
    L7:
        if ((r102 instanceof VectorDrawable) == false) goto L9;
    L13:
        int r103 = (int) h18.d.b(r100, 24);
        Bitmap r104 = Bitmap.createBitmap(r103, r103, Bitmap.Config.ARGB_8888);
        Canvas r105 = new Canvas(r104);
        r102.setBounds(0, 0, r105.getWidth(), r105.getHeight());
        r102.draw(r105);
        return r104;
    L9:
        if ((r102 instanceof VectorDrawableCompat) == true) goto L13;
        tt5.a.d("SearchUtil", "get bitmap from drawable fail:" + r102);
        return null;
    }
}
