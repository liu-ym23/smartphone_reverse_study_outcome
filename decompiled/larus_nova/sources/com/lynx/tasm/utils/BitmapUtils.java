package com.lynx.tasm.utils;

import android.graphics.Bitmap;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes32.dex */
public class BitmapUtils {
    public BitmapUtils() {
    }

    public static String bitmapToBase64WithQuality(Bitmap r100, int r101) {
        return bitmapToBase64(r100, Bitmap.CompressFormat.JPEG, r101, 2);
    }

    public static String bitmapToFormattedBase64(Bitmap r100, int r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        if (r102 > 600) goto L10;
        if (r103 > 600) goto L10;
        Bitmap r104 = r100;
    L11:
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();
        r104.compress(Bitmap.CompressFormat.JPEG, Math.max(r101, 30), r105);
        byte[] r106 = r105.toByteArray();
        r105.close();     // Catch: Exception -> L14
    L16:
        if (r104 == r100) goto L19;
        r104.recycle();
    L19:
        return "data:image/jpeg;base64," + Base64.encodeToString(r106, 2);
    L14:
        e = move-exception;
        e.printStackTrace();
    L10:
        float r107 = 600;
        float r108 = r102;
        float r109 = r103;
        float r110 = Math.min(r107 / r108, r107 / r109);
        r104 = Bitmap.createScaledBitmap(r100, Math.round(r108 * r110), Math.round(r109 * r110), true);
        goto L11
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0033: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:67108915), block:B:20:0x0033 */
    public static String bitmapToBase64(Bitmap r100, Bitmap.CompressFormat r101, int r102, int r103) {
        ByteArrayOutputStream r104 = null;
        if (r100 != null) goto L44;
        String r105 = null;
    L28:
        if (r104 == null) goto L34;
        r104.flush();     // Catch: IOException -> L31
        r104.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L34:
        return r105;
    L44:
        ByteArrayOutputStream r106 = new ByteArrayOutputStream();     // Catch: Throwable -> L9 IOException -> L11
        r100.compress(r101, r102, r106);     // Catch: IOException -> L7 Throwable -> L19
        r106.flush();     // Catch: IOException -> L7 Throwable -> L19
        r106.close();     // Catch: IOException -> L7 Throwable -> L19
        r105 = Base64.encodeToString(r106.toByteArray(), r103);     // Catch: IOException -> L7 Throwable -> L19
        r104 = r106;
    L7:
        e = e;
    L13:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r106 == null) goto L46;
        r106.flush();     // Catch: IOException -> L17
        r106.close();     // Catch: IOException -> L17
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    L46:
        return null;
    L11:
        e = e;
        r106 = null;
    L9:
        th = th;
    L21:
        if (r104 != null) goto L36;
    L26:
        throw th;
    L36:
        r104.flush();     // Catch: IOException -> L24
        r104.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r104 = r1;
        goto L21
    }
}
