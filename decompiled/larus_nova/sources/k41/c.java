package k41;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.revlink.impl.pk.mixer.mapping.LayoutMode;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f501738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Float f501739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutMode[] f501740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f501741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Matrix f501742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Matrix f501743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f501744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a<T> f501745h;

    public final b<T> a() {
        Float r100 = this.f501739b;
        if (r100 == null) goto L29;
        float r101 = r100.floatValue();
        boolean r102 = false;
        if (r101 < (this.f501745h.a() / this.f501745h.c())) goto L15;
        float r103 = this.f501745h.c();
        float r104 = r101 * r103;
        float r105 = this.f501745h.a();
        float r106 = this.f501745h.c();
        if (ArraysKt.contains(this.f501740c, LayoutMode.CenterHorizontal) == false) goto L9;
    L10:
        r102 = true;
    L11:
        if (r102 == false) goto L13;
        float r107 = (r104 - r105) / 2.0f;
    L14:
        float r108 = 0.0f;
    L24:
        RectF r109 = new RectF(r107 / r104, r108 / r103, (r107 + r105) / r104, (r108 + r106) / r103);
        Matrix r110 = b(new RectF(0.0f, 0.0f, r105, r106), new RectF(0.0f, 0.0f, 1.0f, 1.0f));
        r110.postScale(r109.width(), r109.height());
        r110.postTranslate(r109.left, r109.top);
        Matrix r111 = b(new RectF(0.0f, 0.0f, r105, r106), new RectF(0.0f, 0.0f, 1.0f, 1.0f));
        if (this.f501738a == false) goto L27;
        this.f501742e = r110;
        this.f501743f = r111;
        this.f501744g = r109;
        goto L29
    L27:
        this.f501742e = r110;
        this.f501743f = r110;
        this.f501744g = null;
        goto L29
    L13:
        r107 = 0.0f;
        goto L14
    L9:
        if (ArraysKt.contains(this.f501740c, LayoutMode.Center) == false) goto L11;
    L15:
        float r112 = this.f501745h.a();
        float r113 = r112 / r101;
        if (ArraysKt.contains(this.f501740c, LayoutMode.Center) == false) goto L18;
    L19:
        r102 = true;
    L20:
        if (r102 == false) goto L22;
        float r114 = (r113 - this.f501745h.c()) / 2.0f;
    L23:
        r105 = this.f501745h.a();
        r106 = this.f501745h.c();
        r108 = r114;
        r107 = 0.0f;
        r103 = r113;
        r104 = r112;
        goto L24
    L22:
        r114 = this.f501741d * r113;
        goto L23
    L18:
        if (ArraysKt.contains(this.f501740c, LayoutMode.CenterVertical) == false) goto L20;
    L29:
        return new b(this.f501745h, this.f501744g, this.f501742e, this.f501743f);
    }

    public c(a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        this.f501745h = r100;
        this.f501740c = new LayoutMode[0];
        this.f501742e = new Matrix();
        this.f501743f = new Matrix();
    }

    public static Matrix b(RectF r100, RectF r101) {
        Matrix r102 = new Matrix();
        r102.postTranslate(r101.left - r100.left, r101.top - r100.top);
        r102.postScale(r101.width() / r100.width(), r101.height() / r100.height(), r101.left, r101.top);
        return r102;
    }
}
