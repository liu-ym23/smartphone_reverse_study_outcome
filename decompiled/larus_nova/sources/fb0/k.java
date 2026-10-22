package fb0;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public abstract class k extends fb0.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap<a, Bitmap> f476241l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f476242m = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f476243j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f476244k;

    public static class a implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f476245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap.Config f476246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f476247c;

        public a() {
        }

        public final int hashCode() {
            int r100 = this.f476246b.hashCode() ^ this.f476247c;
            if (this.f476245a == false) goto L6;
            return r100;
        L6:
            return -r100;
        }

        public final a a() {
            return (a) super.clone();
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return a();
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            return false;
        L5:
            a r101 = (a) r100;
            if (this.f476245a == r101.f476245a) goto L8;
            return false;
        L8:
            if (this.f476246b == r101.f476246b) goto L10;
            return false;
        L10:
            if (this.f476247c != r101.f476247c) goto L15;
            return true;
        L15:
            return false;
        }
    }

    public k() {
        super(0);
        this.f476243j = true;
    }

    @Override // fb0.a
    public final int b() {
        return 3553;
    }

    @Override // fb0.j
    public final boolean isOpaque() {
        return false;
    }

    static {
        f476241l = new HashMap();
        f476242m = new a();
    }

    @Override // fb0.a
    public final int a() {
        if (this.f476203c != (-1)) goto L6;
        g();
    L6:
        return this.f476204d;
    }

    @Override // fb0.a
    public final int c() {
        if (this.f476203c != (-1)) goto L6;
        g();
    L6:
        return this.f476203c;
    }

    public final Bitmap g() {
        if (this.f476244k != null) goto L8;
        Bitmap r100 = ((b) this).f476208n;
        this.f476244k = r100;
        int r101 = r100.getWidth() + (0 * 2);
        int r102 = this.f476244k.getHeight() + (0 * 2);
        if (this.f476203c != (-1)) goto L8;
        f(r101, r102);
    L8:
        return this.f476244k;
    }

    @Override // fb0.a
    public final void e() {
        super.e();
        if (this.f476244k == null) goto L6;
        this.f476244k = null;
        return;
    }

    @Override // fb0.a
    public final boolean d(e r210) {
        if (this.f476202b != 1) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L27;
        Bitmap r101 = g();
        if (r101 != null) goto L10;
    L25:
        this.f476202b = -1;
    L35:
        if (this.f476202b != 1) goto L37;
        boolean r102 = true;
    L38:
        if (r102 == true) goto L40;
    L42:
        return false;
    L40:
        if (this.f476243j == false) goto L42;
        return true;
    L37:
        r102 = false;
        goto L38
    L10:
        if (r101.isRecycled() == true) goto L25;
        int r110 = r101.getWidth();     // Catch: Throwable -> L22
        int r111 = r101.getHeight();     // Catch: Throwable -> L22
        int r112 = this.f476205e;     // Catch: Throwable -> L22
        int r113 = this.f476206f;     // Catch: Throwable -> L22
        r210.getClass();     // Catch: Throwable -> L22
        f r103 = e.B;     // Catch: Throwable -> L22
        GLES20.glGenTextures(1, r103.f476238a, 0);     // Catch: Throwable -> L22
        this.f476201a = r103.f476238a[0];     // Catch: Throwable -> L22
        r210.d(this);     // Catch: Throwable -> L22
        if (r110 != r112) goto L15;
        if (r111 != r113) goto L15;
        GLES20.glBindTexture(3553, this.f476201a);     // Catch: Throwable -> L22
        GLUtils.texImage2D(3553, 0, r101, 0);     // Catch: Throwable -> L22
    L21:
        this.f476244k = null;
        this.f476207g = r210;
        this.f476202b = 1;
        this.f476243j = true;
    L15:
        int r211 = GLUtils.getInternalFormat(r101);     // Catch: Throwable -> L22
        int r212 = GLUtils.getType(r101);     // Catch: Throwable -> L22
        Bitmap.Config r104 = r101.getConfig();     // Catch: Throwable -> L22
        GLES20.glBindTexture(3553, this.f476201a);     // Catch: Throwable -> L22
        GLES20.glTexImage2D(3553, 0, r211, this.f476205e, this.f476206f, 0, r211, r212, null);     // Catch: Throwable -> L22
        r210.e(this, 0, 0, r101, r211, r212);     // Catch: Throwable -> L22
        if ((0 + r110) >= r112) goto L19;
        int r105 = 0 + r110;     // Catch: Throwable -> L22
        r210.e(this, r105, 0, h(true, r104, r113), r211, r212);     // Catch: Throwable -> L22
    L19:
        if ((0 + r111) >= r113) goto L21;
        int r106 = 0 + r111;     // Catch: Throwable -> L22
        r210.e(this, 0, r106, h(false, r104, r112), r211, r212);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.f476244k = null;
        throw th;
    L27:
        if (this.f476243j == true) goto L35;
        Bitmap r107 = g();
        if (r107 == null) goto L35;
        if (r107.isRecycled() == true) goto L35;
        r210.e(this, 0, 0, r107, GLUtils.getInternalFormat(r107), GLUtils.getType(r107));
        this.f476244k = null;
        this.f476243j = true;
        goto L35
    L5:
        r100 = false;
        goto L6
    }

    public static Bitmap h(boolean r100, Bitmap.Config r101, int r102) {
        a r103 = f476242m;
        r103.f476245a = r100;
        r103.f476246b = r101;
        r103.f476247c = r102;
        HashMap<a, Bitmap> r104 = f476241l;
        Bitmap r105 = r104.get(r103);
        if (r105 == null) goto L5;
        return r105;
    L5:
        if (r100 == false) goto L7;
        Bitmap r106 = Bitmap.createBitmap(1, r102, r101);
    L8:
        Bitmap r107 = r106;
        r104.put(r103.a(), r107);
        return r107;
    L7:
        r106 = Bitmap.createBitmap(r102, 1, r101);
        goto L8
    }
}
