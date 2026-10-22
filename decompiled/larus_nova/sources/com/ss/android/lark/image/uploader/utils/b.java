package com.ss.android.lark.image.uploader.utils;

import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import com.larksuite.tool.image.JPEGTool;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes36.dex */
public final class b {
    public static void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static int b(String r100) {
        return new ExifInterface(r100).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
    L4:
        e = move-exception;
        int r101 = c.f426438a;
        c.c("ImageReader", "orientation not found, " + e.getMessage());
        return -1;
    }

    public static ImageInfo c(InputStream r100) {
        BitmapFactory.Options r101 = new BitmapFactory.Options();
        r101.inJustDecodeBounds = true;
        r101.inSampleSize = 1;
        BitmapFactory.decodeStream(r100, null, r101);
        a(r100);
        HashMap<String, ImageUtils.ImageType> r102 = ImageInfo.f426420j;
        ImageInfo.a r103 = new ImageInfo.a();
        r103.f426430a = r101.outWidth;
        r103.f426431b = r101.outHeight;
        r103.f426434e = r101.outMimeType;
        return new ImageInfo(r103);
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00e7: MOVE (r4 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]) (LINE:50331879), block:B:50:0x00e7 */
    public static ImageInfo d(String r110, boolean r111, boolean r210) {
        Closeable r100 = null;
        VFSFiles r101 = VFSFiles.f444819b;     // Catch: Throwable -> L42 IOException -> L44
        VFSPath r102 = r101.z(r110);     // Catch: Throwable -> L42 IOException -> L44
        long r103 = com.suite.lark.component.storage.ext.b.e(r102);     // Catch: Throwable -> L42 IOException -> L44
        Intrinsics.checkNotNullParameter(r102, "<this>");     // Catch: Throwable -> L42 IOException -> L44
        r101.getClass();     // Catch: Throwable -> L42 IOException -> L44
        InputStream r104 = VFSFiles.a(r102).l(r102);     // Catch: Throwable -> L42 IOException -> L44
        ImageInfo r112 = c(r104);     // Catch: IOException -> L9 Throwable -> L49
        String r105 = r101.r(r102, r210).getAbsolutePath();     // Catch: IOException -> L9 Throwable -> L49
        if (r112.f426421a > 0) goto L7;
    L11:
        boolean r113 = false;
    L12:
        if (r113 == false) goto L40;
        int r106 = b(r105);     // Catch: IOException -> L9 Throwable -> L49
        if (r106 < 0) goto L16;
        boolean r107 = true;
    L17:
        if (r111 == true) goto L19;
        int r108 = -1;
    L24:
        d r114 = d.f426439a;     // Catch: IOException -> L9 Throwable -> L49
        int r115 = r112.f426421a;     // Catch: IOException -> L9 Throwable -> L49
        int r116 = r112.f426422b;     // Catch: IOException -> L9 Throwable -> L49
        switch(r106) {
            case 3: goto L29;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L27;
            default: goto L26;
        };     // Catch: IOException -> L9 Throwable -> L49
    L26:
        char r117 = 0;
    L30:
        if (r117 == 'Z') goto L34;
        if (r117 == 270) goto L34;
        boolean r118 = false;
    L35:
        if (r118 == false) goto L37;
        r116 = r115;
        r115 = r116;
    L37:
        Pair r119 = new Pair(Integer.valueOf(r115), Integer.valueOf(r116));     // Catch: IOException -> L9 Throwable -> L49
        int r120 = ((Integer) r119.getFirst()).intValue();     // Catch: IOException -> L9 Throwable -> L49
        int r121 = ((Integer) r119.getSecond()).intValue();     // Catch: IOException -> L9 Throwable -> L49
        ImageInfo.a r122 = ImageInfo.a(r112);     // Catch: IOException -> L9 Throwable -> L49
        r122.f426430a = r120;     // Catch: IOException -> L9 Throwable -> L49
        r122.f426431b = r121;     // Catch: IOException -> L9 Throwable -> L49
        r122.f426435f = r106;     // Catch: IOException -> L9 Throwable -> L49
        r122.f426436g = r107;     // Catch: IOException -> L9 Throwable -> L49
        r122.f426432c = r103;     // Catch: IOException -> L9 Throwable -> L49
        r122.f426433d = r108;     // Catch: IOException -> L9 Throwable -> L49
        r122.f426437h = ImageUtils.e(r102.toFile());     // Catch: IOException -> L9 Throwable -> L49
        ImageInfo r109 = new ImageInfo(r122);     // Catch: IOException -> L9 Throwable -> L49
        a(r104);
        return r109;
    L34:
        r118 = true;
        goto L35
    L27:
        r117 = 270;
        goto L30
    L28:
        r117 = Matrix.MATRIX_TYPE_ZERO;
        goto L30
    L29:
        r117 = 180;
        goto L30
    L19:
        if (ykb.b.f568292a.c() == true) goto L21;
        boolean r123 = true;
    L22:
        r108 = JPEGTool.a(r105, r123);     // Catch: IOException -> L9 Throwable -> L49
        goto L24
    L21:
        r123 = false;
        goto L22
    L16:
        r107 = false;
        goto L17
    L40:
        int r124 = c.f426438a;     // Catch: IOException -> L9 Throwable -> L49
        c.c("ImageReader", "decode image file fail, invalid size, ".concat(r110));     // Catch: IOException -> L9 Throwable -> L49
    L47:
        a(r104);
        return null;
    L7:
        if (r112.f426422b <= 0) goto L11;
        r113 = true;
    L9:
        e = e;
    L46:
        int r125 = c.f426438a;     // Catch: Throwable -> L49
        c.b("ImageReader", "read image info fail", e, true);     // Catch: Throwable -> L49
        e.printStackTrace();     // Catch: Throwable -> L49
        goto L47
    L49:
        th = th;
        r100 = r9;
    L51:
        a(r100);
        throw th;
    L44:
        e = e;
        r104 = null;
    L42:
        th = th;
        goto L51
    }
}
