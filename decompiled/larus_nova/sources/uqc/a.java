package uqc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import com.yalantis.ucrop.view.TransformImageView;
import java.io.IOException;
import java.io.InputStream;
import sqc.b;
import vqc.e;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends PthreadAsyncTask<Void, Void, C7921a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f551359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Uri f551360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Uri f551361j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f551362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f551363l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f551364m;

    /* JADX INFO: renamed from: uqc.a$a, reason: collision with other inner class name */
    public static class C7921a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f551365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final tqc.b f551366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Exception f551367c;

        public C7921a(Exception r100) {
            this.f551367c = r100;
        }

        public C7921a(Bitmap r100, tqc.b r101) {
            this.f551365a = r100;
            this.f551366b = r101;
        }
    }

    public final void b() throws NullPointerException, IOException, IllegalStateException, IllegalArgumentException {
        String r100 = this.f551360i.getScheme();
        if ("http".equals(r100) == false) goto L5;
        return;
    L5:
        if ("https".equals(r100) == false) goto L8;
        return;
    L8:
        if ("content".equals(r100) == false) goto L18;
        a(this.f551360i, this.f551361j);     // Catch: IllegalStateException -> L11 Throwable -> L13 NullPointerException -> L15
        return;
    L13:
        e = move-exception;
        throw e;
    L18:
        if ("file".equals(r100) == false) goto L21;
        return;
    L21:
        throw new IllegalArgumentException("Invalid Uri scheme" + r100);
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] r110) {
        Void[] r111 = (Void[]) r110;
        if (this.f551360i == null) goto L120;
        b();     // Catch: IllegalArgumentException -> L86 Throwable -> L88 IOException -> L90 NullPointerException -> L92
        BitmapFactory.Options r112 = new BitmapFactory.Options();
        r112.inJustDecodeBounds = true;
        int r100 = this.f551362k;
        int r101 = this.f551363l;
        int r102 = r112.outHeight;
        int r103 = r112.outWidth;
        if (r102 > r101) goto L11;
        if (r103 > r100) goto L11;
        int r104 = 1;
    L17:
        r112.inSampleSize = r104;
        int r105 = 0;
        r112.inJustDecodeBounds = false;
        Bitmap r113 = null;
        boolean r106 = false;
    L18:
        int r107 = -1;
        if (r106 == true) goto L48;
        InputStream r108 = ContentResolverWrapper.openInputStream(this.f551359h.getContentResolver(), this.f551360i);     // Catch: IllegalStateException -> L43 IOException -> L45 OutOfMemoryError -> L47
        r113 = BitmapFactory.decodeStream(r108, null, r112);     // Catch: Throwable -> L40
        if (r112.outWidth == (-1)) goto L38;
        if (r112.outHeight == (-1)) goto L38;
        vqc.a.a(r108);     // Catch: IllegalStateException -> L43 IOException -> L45 OutOfMemoryError -> L47
        if (r113 == null) goto L29;
        int r109 = r113.getByteCount();     // Catch: IllegalStateException -> L43 IOException -> L45 OutOfMemoryError -> L47
    L31:
        if (r109 <= 104857600) goto L34;
        r112.inSampleSize *= 2;     // Catch: IllegalStateException -> L43 IOException -> L45 OutOfMemoryError -> L47
        boolean r114 = true;
    L35:
        if (r114 == true) goto L18;
        r106 = true;
        goto L18
    L34:
        r114 = false;
        goto L35
    L29:
        r109 = 0;
    L38:
        C7921a r115 = new C7921a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f551360i + "]"));     // Catch: Throwable -> L40
        vqc.a.a(r108);     // Catch: IllegalStateException -> L43 IOException -> L45 OutOfMemoryError -> L47
        return r115;
    L40:
        th = move-exception;
        vqc.a.a(r108);     // Catch: IllegalStateException -> L43 IOException -> L45 OutOfMemoryError -> L47
        throw th;     // Catch: IllegalStateException -> L43 IOException -> L45 OutOfMemoryError -> L47
    L45:
        e = move-exception;
        C7921a r116 = new C7921a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f551360i + "]", e));
    L95:
        return r116;
    L43:
        e = move-exception;
        r116 = new C7921a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f551360i + "]", e));
    L47:
        r112.inSampleSize *= 2;
        goto L18
    L48:
        if (r113 == null) goto L122;
        Context r117 = this.f551359h;
        Uri r118 = this.f551360i;
        InputStream r119 = ContentResolverWrapper.openInputStream(r117.getContentResolver(), r118);     // Catch: IOException -> L57
        if (r119 != null) goto L54;
        int r120 = 0;
    L59:
        switch(r120) {
            case 3: goto L63;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L62;
            case 7: goto L61;
            case 8: goto L61;
            default: goto L64;
        };
    L61:
        r105 = 270;
        goto L64
    L62:
        r105 = 90;
        goto L64
    L63:
        r105 = 180;
    L64:
        if (r120 != 2) goto L66;
    L72:
        tqc.b r121 = new tqc.b(r120, r105, r107);
        Matrix r122 = new Matrix();
        if (r105 == 0) goto L75;
        r122.preRotate(r105);
    L75:
        if (r107 == 1) goto L78;
        r122.postScale(r107, 1.0f);
    L78:
        if (r122.isIdentity() == false) goto L102;
        r116 = new C7921a(r113, r121);
        goto L95
    L102:
        Bitmap r123 = Bitmap.createBitmap(r113, 0, 0, r113.getWidth(), r113.getHeight(), r122, true);     // Catch: OutOfMemoryError -> L96
        if (r113.sameAs(r123) == true) goto L83;
        r113 = r123;
    L83:
        r116 = new C7921a(r113, r121);
        goto L95
    L66:
        if (r120 == 7) goto L72;
        if (r120 == 4) goto L72;
        if (r120 == 5) goto L72;
        r107 = 1;
        goto L72
    L54:
        r120 = new e(r119).a();     // Catch: IOException -> L57
        vqc.a.a(r119);     // Catch: IOException -> L97
    L58:
        r118.toString();
    L57:
        r120 = 0;
        goto L58
    L122:
        return new C7921a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f551360i + "]"));
    L11:
        r104 = 1;
    L13:
        if ((r102 / r104) > r101) goto L85;
        if ((r103 / r104) <= r100) goto L17;
    L85:
        r104 = r104 * 2;
    L88:
        e = move-exception;
        r116 = new C7921a(e);
        goto L95
    L120:
        return new C7921a(new NullPointerException("Input Uri cannot be null"));
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object r100) {
        C7921a r101 = (C7921a) r100;
        Exception r102 = r101.f551367c;
        if (r102 != null) goto L9;
        b r103 = this.f551364m;
        Bitmap r104 = r101.f551365a;
        tqc.b r105 = r101.f551366b;
        String r106 = this.f551360i.getPath();
        Uri r107 = this.f551361j;
        if (r107 != null) goto L7;
        String r108 = null;
    L8:
        TransformImageView r109 = ((TransformImageView.a) r103).f464515a;
        r109.f464512m = r106;
        r109.f464513n = r108;
        r109.f464514o = r105;
        r109.f464509j = true;
        r109.setImageBitmap(r104);
        return;
    L7:
        r108 = r107.getPath();
        goto L8
    L9:
        TransformImageView.b r110 = ((TransformImageView.a) this.f551364m).f464515a.f464506g;
        if (r110 == null) goto L14;
        r110.b(r102);
        return;
    }

    public final void a(Uri r100, Uri r101) throws NullPointerException, IOException, IllegalStateException {
        if (r101 == null) goto L34;
        PolarisFileOutputStreamWrapper r102 = null;
        InputStream r103 = ContentResolverWrapper.openInputStream(this.f551359h.getContentResolver(), r100);     // Catch: Throwable -> L22 Exception -> L24
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r101.getPath()));     // Catch: Exception -> L20 Throwable -> L30
        if (r103 == null) goto L19;
        byte[] r105 = new byte[1024];     // Catch: Throwable -> L14 Exception -> L16
    L9:
        int r106 = r103.read(r105);     // Catch: Throwable -> L14 Exception -> L16
        if (r106 <= 0) goto L13;
        r104.write(r105, 0, r106);     // Catch: Throwable -> L14 Exception -> L16
        goto L9
    L13:
        vqc.a.a(r104);
    L28:
        vqc.a.a(r103);
        this.f551360i = this.f551361j;
        return;
    L19:
        throw new NullPointerException("InputStream for given input Uri is null");     // Catch: Throwable -> L14 Exception -> L16
    L16:
        e = e;
        r102 = r104;
    L26:
        e.printStackTrace();     // Catch: Throwable -> L30
        vqc.a.a(r102);
    L14:
        th = th;
        r102 = r104;
    L31:
        vqc.a.a(r102);
        vqc.a.a(r103);
        this.f551360i = this.f551361j;
        throw th;
    L20:
        e = e;
    L30:
        th = th;
        goto L31
    L24:
        e = e;
        r103 = null;
    L22:
        th = th;
        r103 = null;
        goto L31
    L34:
        throw new NullPointerException("Output Uri is null - cannot copy image");
    }

    public a(Context r100, Uri r101, Uri r102, int r103, int r104, TransformImageView.a r105) {
        this.f551359h = r100;
        this.f551360i = r101;
        this.f551361j = r102;
        this.f551362k = r103;
        this.f551363l = r104;
        this.f551364m = r105;
    }
}
