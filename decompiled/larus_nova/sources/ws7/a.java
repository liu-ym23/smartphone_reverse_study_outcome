package ws7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static Bitmap a(is7.b r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        new YuvImage(r110.f495625a.array(), 17, r110.f495632h, r110.f495633i, null).compressToJpeg(new Rect(0, 0, r110.f495632h, r110.f495633i), 100, r100);     // Catch: Throwable -> L17
        byte[] r101 = r100.toByteArray();     // Catch: Throwable -> L17
        Bitmap r102 = BitmapFactory.decodeByteArray(r101, 0, r101.length);     // Catch: Throwable -> L17
        if (r102 != null) goto L10;
        i.j(r100);
        return null;
    L10:
        Matrix r111 = new Matrix();     // Catch: Throwable -> L17
        r111.setRotate(r110.f495634j);     // Catch: Throwable -> L17
        Bitmap r112 = Bitmap.createBitmap(r102, 0, 0, r102.getWidth(), r102.getHeight(), r111, false);     // Catch: Throwable -> L17
        if (r102 != r112) goto L13;
    L15:
        i.j(r100);
        return r112;
    L13:
        if (r102.isRecycled() == true) goto L15;
        r102.recycle();     // Catch: Throwable -> L17
    L17:
        i.j(r100);
        return null;
    }

    public static ArrayList<ByteBuffer> b(List<is7.b> r100) {
        if (r100 == null) goto L4;
        ArrayList<ByteBuffer> r101 = new ArrayList();
        Iterator<is7.b> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        r101.add(r102.next().f495625a);     // Catch: Throwable -> L11
        goto L7
    L12:
        return r101;
    L4:
        return new ArrayList();
    }
}
