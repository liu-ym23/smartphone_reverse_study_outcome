package hs7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.dtf.toyger.base.face.ToygerFaceAttr;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f487062i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f487063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f487064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f487065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f487066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f487067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<ToygerFaceAttr> f487068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f487069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ToygerFaceAttr f487070h;

    static {
        f487062i = new d();
    }

    public final void b() {
        ArrayList<ToygerFaceAttr> r100 = this.f487068f;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f487068f = new ArrayList();
        this.f487069g = null;
        this.f487070h = null;
    }

    public final String c() {
        StringBuilder r100 = new StringBuilder("[");
        if (this.f487068f == null) goto L11;
        int r101 = 0;
    L6:
        if (r101 >= this.f487068f.size()) goto L11;
        ToygerFaceAttr r102 = (ToygerFaceAttr) ListProtector.get(this.f487068f, r101);
        if (r101 == 0) goto L10;
        r100.append(",");
    L10:
        r100.append(r102.toString());
        r101 = r101 + 1;
    L11:
        r100.append("]");
        return r100.toString();
    }

    public d() {
        this.f487067e = null;
    }

    public final synchronized Bitmap a(byte[] r210, int r211, int r212, int r213) {
        monitor-enter(this);
        Bitmap r100 = this.f487067e;     // Catch: Throwable -> L39
        if (r100 == null) goto L8;
        monitor-exit(this);
        return r100;
    L8:
        if (r210 == null) goto L36;
        if (r211 == 0) goto L36;
        if (r212 == 0) goto L36;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L42 Throwable -> L39
        new YuvImage(r210, 17, r211, r212, null).compressToJpeg(new Rect(0, 0, r211, r212), 100, r101);     // Catch: Exception -> L42 Throwable -> L39
        byte[] r102 = r101.toByteArray();     // Catch: Exception -> L42 Throwable -> L39
        BitmapFactory.Options r103 = new BitmapFactory.Options();     // Catch: Exception -> L42 Throwable -> L39
        r103.inJustDecodeBounds = true;     // Catch: Exception -> L42 Throwable -> L39
        BitmapFactory.decodeByteArray(r102, 0, r102.length, r103);     // Catch: Exception -> L42 Throwable -> L39
        int r104 = r103.outWidth;     // Catch: Exception -> L42 Throwable -> L39
        int r105 = r104 / 2;     // Catch: Exception -> L42 Throwable -> L39
        int r106 = r103.outHeight;     // Catch: Exception -> L42 Throwable -> L39
        int r107 = r106 / 2;     // Catch: Exception -> L42 Throwable -> L39
        if (r106 > r107) goto L17;
        if (r104 > r105) goto L17;
        int r110 = 1;
    L23:
        r103.inSampleSize = r110;     // Catch: Exception -> L42 Throwable -> L39
        r103.inJustDecodeBounds = false;     // Catch: Exception -> L42 Throwable -> L39
        r103.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Exception -> L42 Throwable -> L39
        r103.inPurgeable = true;     // Catch: Exception -> L42 Throwable -> L39
        r103.inInputShareable = true;     // Catch: Exception -> L42 Throwable -> L39
        Bitmap r108 = BitmapFactory.decodeByteArray(r102, 0, r102.length, r103);     // Catch: Exception -> L42 Throwable -> L39
        if (r108 == null) goto L33;
        Matrix r111 = new Matrix();     // Catch: Exception -> L42 Throwable -> L39
        r111.setRotate(r213);     // Catch: Exception -> L42 Throwable -> L39
        Bitmap r109 = Bitmap.createBitmap(r108, 0, 0, r108.getWidth(), r108.getHeight(), r111, false);     // Catch: Exception -> L42 Throwable -> L39
        Matrix r112 = new Matrix();     // Catch: Exception -> L42 Throwable -> L39
        r112.setValues(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f});     // Catch: Exception -> L42 Throwable -> L39
        Bitmap r113 = Bitmap.createBitmap(r109, 0, 0, r109.getWidth(), r109.getHeight(), r112, true);     // Catch: Exception -> L42 Throwable -> L39
        if (r109 == r113) goto L28;
        r109.recycle();     // Catch: Exception -> L42 Throwable -> L39
    L28:
        if (r108 != r113) goto L30;
    L32:
        this.f487067e = r113;     // Catch: Exception -> L42 Throwable -> L39
        goto L33
    L30:
        if (r108.isRecycled() == true) goto L32;
        r108.recycle();     // Catch: Exception -> L42 Throwable -> L39
    L17:
        int r114 = r106 / 2;     // Catch: Exception -> L42 Throwable -> L39
        int r115 = r104 / 2;     // Catch: Exception -> L42 Throwable -> L39
        r110 = 1;
    L19:
        if ((r114 / r110) < r107) goto L23;
        if ((r115 / r110) < r105) goto L23;
        r110 = r110 * 2;     // Catch: Exception -> L42 Throwable -> L39
    L33:
        Bitmap r116 = this.f487067e;     // Catch: Throwable -> L39
        monitor-exit(this);
        return r116;
    L36:
        monitor-exit(this);
        return null;
    L39:
        th = move-exception;
        throw th;
    }
}
