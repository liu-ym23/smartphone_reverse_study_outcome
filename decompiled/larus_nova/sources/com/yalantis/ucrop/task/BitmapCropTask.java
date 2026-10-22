package com.yalantis.ucrop.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import sqc.a;
import tqc.b;
import tqc.c;
import vqc.d;
import vqc.e;

/* JADX INFO: loaded from: classes41.dex */
public class BitmapCropTask extends PthreadAsyncTask<Void, Void, Throwable> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f464425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f464426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f464427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f464428k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f464429l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f464430m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f464431n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Bitmap.CompressFormat f464432o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f464433p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f464434q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f464435r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f464436s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f464437t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f464438u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f464439v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f464440w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f464441x;

    public static native boolean cropCImg(String r100, String r101, int r102, int r103, int r104, int r105, float r106, float r107, int r108, int r109, int r110, int r111) throws IOException, OutOfMemoryError;

    static {
        Intrinsics.checkNotNullParameter("ucrop", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> ucrop");
        com.bytedance.librarian.a.c("ucrop");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> ucrop");
    }

    public final void a(float r310) throws IOException {
        ExifInterface r100 = new ExifInterface(this.f464434q);
        this.f464440w = Math.round((this.f464426i.left - this.f464427j.left) / this.f464428k);
        this.f464441x = Math.round((this.f464426i.top - this.f464427j.top) / this.f464428k);
        this.f464438u = Math.round(this.f464426i.width() / this.f464428k);
        int r101 = Math.round(this.f464426i.height() / this.f464428k);
        this.f464439v = r101;
        boolean r102 = true;
        int r103 = Math.round(Math.max(this.f464438u, r101) / 1000.0f) + 1;
        int r104 = 0;
        if (this.f464430m > 0) goto L5;
    L6:
        float r105 = r103;
        if (Math.abs(this.f464426i.left - this.f464427j.left) <= r105) goto L9;
    L19:
        if (r102 == false) goto L37;
        String r106 = this.f464434q;
        String r107 = this.f464435r;
        int r108 = this.f464440w;
        int r109 = this.f464441x;
        int r110 = this.f464438u;
        int r111 = this.f464439v;
        float r112 = this.f464429l;
        int r113 = this.f464432o.ordinal();
        int r114 = this.f464433p;
        b r115 = this.f464436s;
        if (cropCImg(r106, r107, r108, r109, r110, r111, r112, r310, r113, r114, r115.f547260b, r115.f547261c) == true) goto L23;
        return;
    L23:
        if (this.f464432o.equals(Bitmap.CompressFormat.JPEG) == false) goto L45;
        int r116 = this.f464438u;
        int r117 = this.f464439v;
        String r118 = this.f464435r;
        byte[] r119 = e.f556791b;
        String[] r120 = {ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE};
        ExifInterface r121 = new ExifInterface(r118);     // Catch: IOException -> L34
    L27:
        if (r104 >= 22) goto L32;
        String r122 = r120[r104];     // Catch: IOException -> L34
        String r123 = r100.getAttribute(r122);     // Catch: IOException -> L34
        if (TextUtils.isEmpty(r123) == true) goto L31;
        r121.setAttribute(r122, r123);     // Catch: IOException -> L34
    L31:
        r104 = r104 + 1;     // Catch: IOException -> L34
        goto L27
    L32:
        r121.setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(r116));     // Catch: IOException -> L34
        r121.setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(r117));     // Catch: IOException -> L34
        r121.setAttribute(ExifInterface.TAG_ORIENTATION, "0");     // Catch: IOException -> L34
        r121.saveAttributes();     // Catch: IOException -> L34
        return;
    L34:
        e = move-exception;
        e.getMessage();
        return;
    L45:
        return;
    L37:
        d.b(this.f464434q, this.f464435r);
        return;
    L9:
        if (Math.abs(this.f464426i.top - this.f464427j.top) > r105) goto L19;
        if (Math.abs(this.f464426i.bottom - this.f464427j.bottom) > r105) goto L19;
        if (Math.abs(this.f464426i.right - this.f464427j.right) > r105) goto L19;
        if (this.f464429l != 0.0f) goto L19;
        r102 = false;
        goto L19
    L5:
        if (this.f464431n > 0) goto L19;
        goto L6
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] r100) {
        Void[] r101 = (Void[]) r100;
        Bitmap r102 = this.f464425h;
        if (r102 != null) goto L6;
        return new NullPointerException("ViewBitmap is null");
    L6:
        if (r102.isRecycled() == false) goto L9;
        return new NullPointerException("ViewBitmap is recycled");
    L9:
        if (this.f464427j.isEmpty() == true) goto L42;
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        boolean r104 = true;
        r103.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.f464434q, r103);
        int r105 = this.f464436s.f547260b;
        if (r105 != 90) goto L14;
    L17:
        if (r104 == false) goto L19;
        int r106 = r103.outHeight;
    L20:
        float r107 = r106 / this.f464425h.getWidth();
        if (r104 == false) goto L23;
        int r108 = r103.outWidth;
    L24:
        this.f464428k /= Math.min(r107, r108 / this.f464425h.getHeight());
        if (this.f464430m > 0) goto L27;
    L33:
        float r109 = 1.0f;
    L38:
        a(r109);     // Catch: Throwable -> L36
        this.f464425h = null;     // Catch: Throwable -> L36
        return null;
    L36:
        th = move-exception;
        return th;
    L27:
        if (this.f464431n <= 0) goto L33;
        float r110 = this.f464426i.width() / this.f464428k;
        float r111 = this.f464426i.height() / this.f464428k;
        float r112 = this.f464430m;
        if (r110 <= r112) goto L31;
    L32:
        r109 = Math.min(r112 / r110, this.f464431n / r111);
        this.f464428k /= r109;
        goto L38
    L31:
        if (r111 <= this.f464431n) goto L33;
    L23:
        r108 = r103.outHeight;
        goto L24
    L19:
        r106 = r103.outWidth;
        goto L20
    L14:
        if (r105 == 270) goto L17;
        r104 = false;
        goto L17
    L42:
        return new NullPointerException("CurrentImageRect is empty");
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object r100) {
        Throwable r101 = (Throwable) r100;
        a r102 = this.f464437t;
        if (r102 == null) goto L8;
        if (r101 != null) goto L6;
        Uri r103 = Uri.fromFile(new PolarisFileWrapper(this.f464435r));
        this.f464437t.a(r103, this.f464440w, this.f464441x, this.f464438u, this.f464439v);
        return;
    L6:
        r102.b(r101);
        return;
    }

    public BitmapCropTask(Bitmap r100, c r101, tqc.a r102, a r103) {
        this.f464425h = r100;
        this.f464426i = r101.f547262a;
        this.f464427j = r101.f547263b;
        this.f464428k = r101.f547264c;
        this.f464429l = r101.f547265d;
        this.f464430m = r102.f547252a;
        this.f464431n = r102.f547253b;
        this.f464432o = r102.f547254c;
        this.f464433p = r102.f547255d;
        this.f464434q = r102.f547256e;
        this.f464435r = r102.f547257f;
        this.f464436s = r102.f547258g;
        this.f464437t = r103;
    }
}
