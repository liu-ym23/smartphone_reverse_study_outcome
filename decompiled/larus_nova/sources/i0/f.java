package i0;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class f implements m, j0.a.InterfaceC6374a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f487746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieDrawable f487748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0.j f487749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0.a<?, PointF> f487750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o0.a f487751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s f487752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f487753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f487754i;

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        this.f487754i = false;
        this.f487748c.invalidateSelf();
    }

    @Override // i0.m
    public final Path getPath() {
        if (this.f487754i == true) goto L5;
        this.f487746a.reset();
        PointF r100 = this.f487749d.g();
        float r101 = r100.x / 2.0f;
        float r102 = r100.y / 2.0f;
        float r110 = r101 * 0.55228f;
        float r103 = 0.55228f * r102;
        this.f487746a.reset();
        if (this.f487751f.f521572d == false) goto L9;
        float r111 = -r102;
        this.f487746a.moveTo(0.0f, r111);
        float r104 = 0.0f - r110;
        float r105 = -r101;
        float r210 = 0.0f - r103;
        this.f487746a.cubicTo(r104, r111, r105, r210, r105, 0.0f);
        float r106 = r103 + 0.0f;
        this.f487746a.cubicTo(r105, r106, r104, r102, 0.0f, r102);
        float r112 = r110 + 0.0f;
        this.f487746a.cubicTo(r112, r102, r101, r106, r101, 0.0f);
        this.f487746a.cubicTo(r101, r210, r112, r111, 0.0f, r111);
    L10:
        PointF r107 = this.f487750e.g();
        this.f487746a.offset(r107.x, r107.y);
        this.f487746a.close();
        if (r0.c.a.f535397a == false) goto L15;
        b r108 = this.f487753h;
        if (r108 == null) goto L15;
        r108.a(this.f487746a);
    L16:
        this.f487754i = true;
        return this.f487746a;
    L15:
        u0.f.b(this.f487746a, this.f487752g);
        goto L16
    L9:
        float r113 = -r102;
        this.f487746a.moveTo(0.0f, r113);
        float r114 = r110 + 0.0f;
        float r115 = 0.0f - r103;
        this.f487746a.cubicTo(r114, r113, r101, r115, r101, 0.0f);
        float r109 = r103 + 0.0f;
        this.f487746a.cubicTo(r101, r109, r114, r102, 0.0f, r102);
        float r116 = 0.0f - r110;
        float r117 = -r101;
        this.f487746a.cubicTo(r116, r102, r117, r109, r117, 0.0f);
        this.f487746a.cubicTo(r117, r115, r116, r113, 0.0f, r113);
        goto L10
    L5:
        return this.f487746a;
    }

    @Override // i0.c
    public final String getName() {
        return this.f487747b;
    }

    @Override // i0.c
    public final void b(List<c> r100, List<c> r101) {
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) r100).size()) goto L16;
        c r103 = (c) ListProtector.get(r100, r102);
        if ((r103 instanceof s) == false) goto L15;
        s r104 = (s) r103;
        if (r104.getType() != ShapeTrimPath.Type.Simultaneously) goto L15;
        if (r0.c.a.f535397a == false) goto L14;
        b r105 = this.f487753h;
        if (r105 == null) goto L14;
        ((ArrayList) r105.f487737a).add(r104);
        r104.e(this);
    L14:
        this.f487752g = r104;
        r104.e(this);
    L15:
        r102 = r102 + 1;
        goto L4
    }

    @Override // m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
        if (r100 != com.airbnb.lottie.k.f24792g) goto L6;
        this.f487749d.k(r101);
        return;
    L6:
        if (r100 != com.airbnb.lottie.k.f24795j) goto L10;
        this.f487750e.k(r101);
        return;
    }

    public f(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101, o0.a r102) {
        this.f487746a = new Path();
        if (r0.c.a.f535397a == false) goto L5;
        this.f487753h = new b();
    L5:
        this.f487747b = r102.f521569a;
        this.f487748c = r100;
        j0.a<?, ?> r103 = r102.f521571c.a();
        this.f487749d = (j0.j) r103;
        j0.a<PointF, PointF> r104 = r102.f521570b.a();
        this.f487750e = r104;
        this.f487751f = r102;
        r101.e(r103);
        r101.e(r104);
        r103.a(this);
        r104.a(this);
    }

    @Override // m0.f
    public final void f(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
        u0.e.d(r100, r101, r102, r103, this);
    }
}
