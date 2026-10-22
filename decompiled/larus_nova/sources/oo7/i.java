package oo7;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public final class i {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    public static byte[] a(Bitmap r110, int r111) {
        ?? r100 = 0;
        if (r110 == 0) goto L58;
        ?? r101 = r110.isRecycled();
        if (r101 != 0) goto L58;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L39 Exception -> L41
        int r103 = 100;
        r110.compress(Bitmap.CompressFormat.PNG, 100, r102);     // Catch: Exception -> L37 Throwable -> L50
        int r112 = r111 * 1024;     // Catch: Exception -> L37 Throwable -> L50
        if (r102.toByteArray().length > r112) goto L16;
        byte[] r113 = r102.toByteArray();     // Catch: Exception -> L37 Throwable -> L50
        r102.close();     // Catch: IOException -> L13
    L15:
        return r113;
    L13:
        e = move-exception;
        k.b(e.toString());
        goto L15
    L16:
        r102.reset();     // Catch: Exception -> L37 Throwable -> L50
        r110.compress(Bitmap.CompressFormat.PNG, 50, r102);     // Catch: Exception -> L37 Throwable -> L50
        if (r102.toByteArray().length > r112) goto L27;
    L18:
        r102.reset();     // Catch: Exception -> L37 Throwable -> L50
        r103 = r103 - 10;     // Catch: Exception -> L37 Throwable -> L50
        r110.compress(Bitmap.CompressFormat.PNG, r103, r102);     // Catch: Exception -> L37 Throwable -> L50
        if (r102.toByteArray().length > r112) goto L18;
        byte[] r114 = r102.toByteArray();     // Catch: Exception -> L37 Throwable -> L50
        r102.close();     // Catch: IOException -> L23
    L25:
        return r114;
    L23:
        e = move-exception;
        k.b(e.toString());
        goto L25
    L27:
        float r104 = (float) Math.sqrt(r112 / r102.toByteArray().length);     // Catch: Exception -> L37 Throwable -> L50
        Matrix r105 = new Matrix();     // Catch: Exception -> L37 Throwable -> L50
        r105.setScale(r104, r104);     // Catch: Exception -> L37 Throwable -> L50
        Bitmap r115 = Bitmap.createBitmap(r110, 0, 0, r110.getWidth(), r110.getHeight(), r105, true);     // Catch: Exception -> L37 Throwable -> L50
        r102.reset();     // Catch: Exception -> L37 Throwable -> L50
        r115.compress(Bitmap.CompressFormat.PNG, 50, r102);     // Catch: Exception -> L37 Throwable -> L50
        Bitmap r106 = r115;
    L29:
        if (r102.toByteArray().length <= r112) goto L31;
        r105.setScale(0.9f, 0.9f);     // Catch: Exception -> L37 Throwable -> L50
        r106 = Bitmap.createBitmap(r106, 0, 0, r106.getWidth(), r106.getHeight(), r105, true);     // Catch: Exception -> L37 Throwable -> L50
        r102.reset();     // Catch: Exception -> L37 Throwable -> L50
        r106.compress(Bitmap.CompressFormat.PNG, 50, r102);     // Catch: Exception -> L37 Throwable -> L50
        goto L29
    L31:
        byte[] r116 = r102.toByteArray();     // Catch: Exception -> L37 Throwable -> L50
        r102.close();     // Catch: IOException -> L34
    L36:
        return r116;
    L34:
        e = move-exception;
        k.b(e.toString());
    L37:
        e = e;
    L43:
        k.f(e);     // Catch: Throwable -> L50
        if (r102 != null) goto L59;
    L49:
        return null;
    L59:
        r102.close();     // Catch: IOException -> L47
    L47:
        e = move-exception;
        k.b(e.toString());
        goto L49
    L41:
        e = e;
        r102 = null;
    L39:
        th = th;
    L52:
        if (r100 != 0) goto L67;
    L57:
        throw th;
    L67:
        r100.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        k.b(e.toString());
    L50:
        th = th;
        r100 = r101;
    L58:
        return null;
    }
}
