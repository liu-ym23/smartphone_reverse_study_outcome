package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public final class XferRoundFilter {
    private XferRoundFilter() {
    }

    public static boolean canUseXferRoundFilter() {
        return true;
    }

    public static void xferRoundBitmap(Bitmap r100, Bitmap r101, boolean r102) {
        Preconditions.checkNotNull(r101);
        Preconditions.checkNotNull(r100);
        r100.setHasAlpha(true);
        if (r102 == false) goto L5;
        Paint r103 = new Paint(1);
        Paint r104 = new Paint(1);
    L6:
        r103.setColor(-16777216);
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Canvas r105 = new Canvas(r100);
        float r106 = r101.getWidth() / 2.0f;
        float r107 = r101.getHeight() / 2.0f;
        r105.drawCircle(r106, r107, Math.min(r106, r107), r103);
        r105.drawBitmap(r101, 0.0f, 0.0f, r104);
        return;
    L5:
        r103 = new Paint();
        r104 = new Paint();
        goto L6
    }
}
