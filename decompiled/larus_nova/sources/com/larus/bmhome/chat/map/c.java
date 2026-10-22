package com.larus.bmhome.chat.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f306881a = 0;

    static {
    }

    public static Bitmap a(Bitmap r100, float r101) {
        if (r100 == null) goto L14;
    L8:
        e = move-exception;
        FLogger.f375446a.e("MapImageLoader", "[roundBitmap] error:" + e.getMessage());
        return null;
    L4:
        if (r100.isRecycled() == true) goto L15;
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L8
        Canvas r103 = new Canvas(r102);     // Catch: Exception -> L8
        Paint r104 = new Paint();     // Catch: Exception -> L8
        r104.setAntiAlias(true);     // Catch: Exception -> L8
        Rect r105 = new Rect(0, 0, r100.getWidth(), r100.getHeight());     // Catch: Exception -> L8
        RectF r106 = new RectF(r105);     // Catch: Exception -> L8
        r103.drawARGB(0, 0, 0, 0);     // Catch: Exception -> L8
        r103.drawRoundRect(r106, r101, r101, r104);     // Catch: Exception -> L8
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));     // Catch: Exception -> L8
        r103.drawBitmap(r100, r105, r105, r104);     // Catch: Exception -> L8
        return r102;
    L15:
        return null;
    L14:
        return null;
    }
}
