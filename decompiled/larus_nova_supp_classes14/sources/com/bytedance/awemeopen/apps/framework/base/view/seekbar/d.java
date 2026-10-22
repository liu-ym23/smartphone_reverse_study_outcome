package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static Bitmap a(Drawable r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((r4 instanceof BitmapDrawable) == false) goto L10;
        BitmapDrawable r7 = (BitmapDrawable) r4;
        if (r5 != r7.getBitmap().getWidth()) goto L13;
        if (r6 != r7.getBitmap().getHeight()) goto L13;
        return r7.getBitmap();
    L13:
        return Bitmap.createScaledBitmap(r7.getBitmap(), r5, r6, true);
    L10:
        Rect r0 = new Rect(r4.getBounds());
        Bitmap r1 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r5, 1), RangesKt.coerceAtLeast(r6, 1), Bitmap.Config.ARGB_8888);
        r4.setBounds(0, 0, r5, r6);
        r4.draw(new Canvas(r1));
        r4.setBounds(r0);
        return r1;
    }
}
