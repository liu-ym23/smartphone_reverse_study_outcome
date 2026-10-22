package com.ss.android.ugc.tools.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes40.dex */
public final class a {
    public static Bitmap a(Bitmap r100, Bitmap r101) {
        if (r100 != null) goto L4;
    L13:
        return r101;
    L4:
        if (r100.isRecycled() == true) goto L13;
        if (r101 != null) goto L8;
    L12:
        return r100;
    L8:
        if (r101.isRecycled() == true) goto L12;
        Paint r102 = new Paint(2);
        Bitmap r103 = r100.copy(Bitmap.Config.ARGB_8888, true);
        Canvas r104 = new Canvas(r103);
        Rect r105 = new Rect(0, 0, r100.getWidth(), r100.getHeight());
        r104.drawBitmap(r101, new Rect(0, 0, r101.getWidth(), r101.getHeight()), r105, r102);
        return r103;
    }
}
