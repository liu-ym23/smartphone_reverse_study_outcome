package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;
import q95.d;
import q95.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a {
    public static final Set<ImageHeaderParser.ImageType> a = null;
    public static final Queue<BitmapFactory.Options> b = null;
    public static final C0179a c = null;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a$a, reason: collision with other inner class name */
    public class C0179a extends a {
        public C0179a() {
        }
    }

    public class b extends a {
    }

    public class c extends a {
    }

    public a() {
    }

    static {
        a = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
        int r0 = f.a;
        b = new ArrayDeque(0);
        c = new C0179a();
    }

    public static void c(BitmapFactory.Options r3) {
        r3.inTempStorage = null;
        r3.inDither = false;
        r3.inScaled = false;
        r3.inSampleSize = 1;
        r3.inPreferredConfig = null;
        r3.inJustDecodeBounds = false;
        r3.outWidth = 0;
        r3.outHeight = 0;
        r3.outMimeType = null;
        r3.inBitmap = null;
        r3.inMutable = true;
        Queue<BitmapFactory.Options> r0 = b;
        monitor-enter(r0);
        ((ArrayDeque) r0).offer(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static Bitmap a(d r3, RecyclableBufferedInputStream r4, BitmapFactory.Options r5) {
        if (r5.inJustDecodeBounds == false) goto L5;
        r3.mark(5242880);
    L8:
        Bitmap r6 = BitmapFactory.decodeStream(r3, null, r5);
    L13:
        e = move-exception;
        tt5.a.e("Downsampler", "Exception loading inDecodeBounds=" + r5.inJustDecodeBounds + " sample=" + r5.inSampleSize, e, false);
    L15:
        return r6;
    L10:
        if (r5.inJustDecodeBounds == false) goto L15;
        r3.reset();     // Catch: IOException -> L13
        goto L15
    L5:
        monitor-enter(r4);
        r4.c = r4.a.length;     // Catch: Throwable -> L16
        monitor-exit(r4);
    L16:
        th = move-exception;
        throw th;
    }

    public static Bitmap b(d r5, RecyclableBufferedInputStream r6, BitmapFactory.Options r7, com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b r8, int r9, int r10, int r11, DecodeFormat r12) {
        if (r12 != DecodeFormat.ALWAYS_ARGB_8888) goto L5;
    L29:
        Bitmap.Config r13 = Bitmap.Config.ARGB_8888;
    L30:
        r7.inSampleSize = r11;
        r7.inPreferredConfig = r13;
        double r2 = r11;
        r7.inBitmap = r8.getDirty((int) Math.ceil(((double) r9) / r2), (int) Math.ceil(((double) r10) / r2), r13);
        return a(r5, r6, r7);
    L5:
        if (r12 == DecodeFormat.PREFER_ARGB_8888) goto L29;
        r5.mark(1024);
        boolean r14 = new ImageHeaderParser(r5).getType().hasAlpha();     // Catch: Throwable -> L12 IOException -> L14
        r5.reset();     // Catch: IOException -> L10
    L34:
    L21:
        if (r14 == false) goto L23;
        r13 = Bitmap.Config.ARGB_8888;
        goto L30
    L23:
        r13 = Bitmap.Config.RGB_565;
    L10:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);
        goto L21
    L12:
        th = move-exception;
        r5.reset();     // Catch: IOException -> L26
    L28:
        throw th;
    L26:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);
    L14:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot determine whether the image has alpha or not from header for format " + r12, e);     // Catch: Throwable -> L12
        r5.reset();     // Catch: IOException -> L18
    L20:
        r14 = false;
    L18:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);
        goto L20
    }
}
