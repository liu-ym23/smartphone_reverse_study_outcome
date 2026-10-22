package com.ss.android.ugc.aweme.editSticker.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"lib-api_release"}, k = 2, mv = {1, 4, 1})
public final class CoverPublishModelKt {
    public static final Bitmap a(Bitmap r110, Bitmap r111) {
        Paint r100 = new Paint(2);
        Paint r101 = new Paint();
        r101.setColor(-16777216);
        Bitmap r102 = Bitmap.createBitmap(r111.getWidth(), r111.getHeight(), r111.getConfig());
        Canvas r103 = new Canvas(r102);
        Rect r104 = new Rect(0, 0, r111.getWidth(), r111.getHeight());
        r103.drawRect(r104, r101);
        if (r110.getHeight() >= r111.getHeight()) goto L5;
        int r105 = (r111.getHeight() - ((int) ((r110.getHeight() / r110.getWidth()) * r111.getWidth()))) / 2;
        r103.drawBitmap(r110, new Rect(0, 0, r110.getWidth(), r110.getHeight()), new Rect(0, r105, r111.getWidth(), r111.getHeight() - r105), r100);
    L5:
        r103.drawBitmap(r111, r104, r104, r100);
        return r102;
    }
}
