package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class d {
    public static Bitmap a(Drawable r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BitmapDrawable) == false) goto L10;
        BitmapDrawable r103 = (BitmapDrawable) r100;
        if (r101 != r103.getBitmap().getWidth()) goto L13;
        if (r102 != r103.getBitmap().getHeight()) goto L13;
        return r103.getBitmap();
    L13:
        return Bitmap.createScaledBitmap(r103.getBitmap(), r101, r102, true);
    L10:
        Rect r104 = new Rect(r100.getBounds());
        Bitmap r105 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r101, 1), RangesKt.coerceAtLeast(r102, 1), Bitmap.Config.ARGB_8888);
        r100.setBounds(0, 0, r101, r102);
        r100.draw(new Canvas(r105));
        r100.setBounds(r104);
        return r105;
    }
}
