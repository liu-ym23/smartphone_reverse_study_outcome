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

/* JADX INFO: loaded from: classes16.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<ImageHeaderParser.ImageType> f224973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Queue<BitmapFactory.Options> f224974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C3235a f224975c = null;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode.a$a, reason: collision with other inner class name */
    public class C3235a extends a {
        public C3235a() {
        }
    }

    public class b extends a {
    }

    public class c extends a {
    }

    public a() {
    }

    static {
        f224973a = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
        int r100 = f.f532111a;
        f224974b = new ArrayDeque(0);
        f224975c = new C3235a();
    }

    public static void c(BitmapFactory.Options r100) {
        r100.inTempStorage = null;
        r100.inDither = false;
        r100.inScaled = false;
        r100.inSampleSize = 1;
        r100.inPreferredConfig = null;
        r100.inJustDecodeBounds = false;
        r100.outWidth = 0;
        r100.outHeight = 0;
        r100.outMimeType = null;
        r100.inBitmap = null;
        r100.inMutable = true;
        Queue<BitmapFactory.Options> r101 = f224974b;
        monitor-enter(r101);
        ((ArrayDeque) r101).offer(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static Bitmap a(d r100, RecyclableBufferedInputStream r101, BitmapFactory.Options r102) {
        if (r102.inJustDecodeBounds == false) goto L5;
        r100.mark(5242880);
    L8:
        Bitmap r103 = BitmapFactory.decodeStream(r100, null, r102);
    L13:
        e = move-exception;
        tt5.a.e("Downsampler", "Exception loading inDecodeBounds=" + r102.inJustDecodeBounds + " sample=" + r102.inSampleSize, e, false);
    L15:
        return r103;
    L10:
        if (r102.inJustDecodeBounds == false) goto L15;
        r100.reset();     // Catch: IOException -> L13
        goto L15
    L5:
        monitor-enter(r101);
        r101.f224970c = r101.f224968a.length;     // Catch: Throwable -> L16
        monitor-exit(r101);
    L16:
        th = move-exception;
        throw th;
    }

    public static Bitmap b(d r100, RecyclableBufferedInputStream r101, BitmapFactory.Options r102, com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b r103, int r104, int r110, int r111, DecodeFormat r112) {
        if (r112 != DecodeFormat.ALWAYS_ARGB_8888) goto L5;
    L29:
        Bitmap.Config r113 = Bitmap.Config.ARGB_8888;
    L30:
        r102.inSampleSize = r111;
        r102.inPreferredConfig = r113;
        double r105 = r111;
        r102.inBitmap = r103.getDirty((int) Math.ceil(((double) r104) / r105), (int) Math.ceil(((double) r110) / r105), r113);
        return a(r100, r101, r102);
    L5:
        if (r112 == DecodeFormat.PREFER_ARGB_8888) goto L29;
        r100.mark(1024);
        boolean r114 = new ImageHeaderParser(r100).getType().hasAlpha();     // Catch: Throwable -> L12 IOException -> L14
        r100.reset();     // Catch: IOException -> L10
    L34:
    L21:
        if (r114 == false) goto L23;
        r113 = Bitmap.Config.ARGB_8888;
        goto L30
    L23:
        r113 = Bitmap.Config.RGB_565;
    L10:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);
        goto L21
    L12:
        th = move-exception;
        r100.reset();     // Catch: IOException -> L26
    L28:
        throw th;
    L26:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);
    L14:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot determine whether the image has alpha or not from header for format " + r112, e);     // Catch: Throwable -> L12
        r100.reset();     // Catch: IOException -> L18
    L20:
        r114 = false;
    L18:
        e = move-exception;
        tt5.a.l("Downsampler", "Cannot reset the input stream", e);
        goto L20
    }
}
