package com.lynx.canvas.capi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public class LoaderServiceHelper {
    public LoaderServiceHelper() {
    }

    public static BitmapDecodeResult decodeImageSync(byte[] r100) {
        Bitmap r101 = BitmapFactory.decodeByteArray(r100, 0, r100.length);
        if (r101 == null) goto L6;
        ByteBuffer r102 = ByteBuffer.allocateDirect(r101.getByteCount());
        r101.copyPixelsToBuffer(r102);
        return new BitmapDecodeResult(r102, r101.getWidth(), r101.getHeight());
    L6:
        return null;
    }

    public static byte[] encodeBitmapSync(ByteBuffer r100, int r101, int r102, int r103, float r104) {
        if (r103 != 0) goto L6;
        Bitmap.CompressFormat r105 = Bitmap.CompressFormat.PNG;
    L8:
        Bitmap r106 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        r106.copyPixelsFromBuffer(r100);
        ByteArrayOutputStream r107 = new ByteArrayOutputStream(((r101 * r102) / 4) + 256);
        if (r106.compress(r105, Math.round(r104 * 100.0f), r107) == true) goto L11;
    L12:
        return null;
    L11:
        return r107.toByteArray();
    L6:
        if (r103 != 1) goto L12;
        r105 = Bitmap.CompressFormat.JPEG;
        goto L8
    }
}
