package gt8;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f482623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f482624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f482625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f482626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f482627e;

    public static final class a implements z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f482628a;

        @Override // gt8.z.a
        public final void a() {
            this.f482628a.f482627e = true;
        }

        public a(l r100) {
            this.f482628a = r100;
        }
    }

    public static final class b {
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f482629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f482630b;

        public c() {
        }
    }

    static {
    }

    public final Matrix a() {
        if (this.f482624b == null) goto L5;
        this.f482625c.reset();
        c r100 = this.f482626d;
        boolean r101 = true;
        if (r100.f482629a != 0.0f) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
    L17:
        r101 = false;
    L19:
        if (r101 == false) goto L21;
    L22:
        float r103 = this.f482624b.f482676a.width() / this.f482623a.getWidth();
        float r104 = this.f482624b.f482676a.height() / this.f482623a.getHeight();
        FLogger.f375446a.i("DrawHelper", "scaleX = " + r103 + " ， scaleY = " + r104);
        c r105 = this.f482626d;
        r105.f482629a = r103;
        r105.f482630b = r104;
        this.f482627e = false;
    L23:
        z r106 = this.f482624b;
        float r107 = 2;
        float r108 = r106.f482678c.x - (r106.f482676a.width() / r107);
        z r109 = this.f482624b;
        float r110 = r109.f482678c.y - (r109.f482676a.height() / r107);
        FLogger r111 = FLogger.f375446a;
        r111.i("DrawHelper", "size width = " + this.f482624b.f482676a.width() + " , height = " + this.f482624b.f482676a.height());
        r111.i("DrawHelper", "dx = " + r108 + " , dy = " + r110 + "centerX = " + this.f482624b.f482678c.x);
        Matrix r112 = this.f482625c;
        c r113 = this.f482626d;
        r112.postScale(r113.f482629a, r113.f482630b);
        this.f482625c.postTranslate(r108, r110);
        Matrix r114 = this.f482625c;
        z r115 = this.f482624b;
        float r116 = r115.f482677b;
        PointF r117 = r115.f482678c;
        r114.postRotate(r116, r117.x, r117.y);
        return this.f482625c;
    L21:
        if (this.f482627e == false) goto L23;
    L12:
        if (r100.f482630b != 0.0f) goto L14;
        boolean r118 = true;
    L15:
        if (r118 == false) goto L17;
    L14:
        r118 = false;
        goto L15
    L9:
        r102 = false;
        goto L10
    L5:
        return this.f482625c;
    }

    public l(Bitmap r100, z r101) {
        Intrinsics.checkNotNullParameter(r100, "drawBitmap");
        this.f482623a = r100;
        this.f482624b = r101;
        this.f482625c = new Matrix();
        this.f482626d = new c();
        this.f482627e = true;
        if (r101 == null) goto L6;
        r101.f482680e = new a(this);
        return;
    }
}
