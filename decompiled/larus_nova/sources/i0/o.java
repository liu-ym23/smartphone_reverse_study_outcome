package i0;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class o implements j0.a.InterfaceC6374a, k, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f487811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f487812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f487813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LottieDrawable f487814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0.a<?, PointF> f487815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0.j f487816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j0.c f487817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s f487818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f487819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f487820j;

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        this.f487820j = false;
        this.f487814d.invalidateSelf();
    }

    @Override // m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
    }

    @Override // i0.m
    public final Path getPath() {
        if (this.f487820j == true) goto L5;
        this.f487811a.reset();
        PointF r100 = this.f487816f.g();
        float r101 = r100.x / 2.0f;
        float r102 = r100.y / 2.0f;
        j0.c r103 = this.f487817g;
        if (r103 != null) goto L9;
        float r104 = 0.0f;
    L10:
        float r105 = Math.min(r101, r102);
        if (r104 <= r105) goto L13;
        r104 = r105;
    L13:
        PointF r106 = this.f487815e.g();
        this.f487811a.moveTo(r106.x + r101, (r106.y - r102) + r104);
        this.f487811a.lineTo(r106.x + r101, (r106.y + r102) - r104);
        if (r104 <= 0.0f) goto L16;
        RectF r107 = this.f487812b;
        float r110 = r106.x + r101;
        float r111 = r104 * 2.0f;
        float r112 = r106.y + r102;
        r107.set(r110 - r111, r112 - r111, r110, r112);
        this.f487811a.arcTo(this.f487812b, 0.0f, 90.0f, false);
    L16:
        this.f487811a.lineTo((r106.x - r101) + r104, r106.y + r102);
        if (r104 <= 0.0f) goto L19;
        RectF r108 = this.f487812b;
        float r109 = r106.x - r101;
        float r113 = r106.y + r102;
        float r114 = r104 * 2.0f;
        r108.set(r109, r113 - r114, r114 + r109, r113);
        this.f487811a.arcTo(this.f487812b, 90.0f, 90.0f, false);
    L19:
        this.f487811a.lineTo(r106.x - r101, (r106.y - r102) + r104);
        if (r104 <= 0.0f) goto L22;
        RectF r115 = this.f487812b;
        float r116 = r106.x - r101;
        float r117 = r106.y - r102;
        float r118 = r104 * 2.0f;
        r115.set(r116, r117, r116 + r118, r118 + r117);
        this.f487811a.arcTo(this.f487812b, 180.0f, 90.0f, false);
    L22:
        this.f487811a.lineTo((r106.x + r101) - r104, r106.y - r102);
        if (r104 <= 0.0f) goto L25;
        RectF r119 = this.f487812b;
        float r120 = r106.x + r101;
        float r121 = r104 * 2.0f;
        float r122 = r106.y - r102;
        r119.set(r120 - r121, r122, r120, r121 + r122);
        this.f487811a.arcTo(this.f487812b, 270.0f, 90.0f, false);
    L25:
        this.f487811a.close();
        if (r0.c.a.f535397a == false) goto L30;
        b r123 = this.f487819i;
        if (r123 == null) goto L30;
        r123.a(this.f487811a);
    L31:
        this.f487820j = true;
        return this.f487811a;
    L30:
        u0.f.b(this.f487811a, this.f487818h);
        goto L31
    L9:
        r104 = r103.g().floatValue();
        goto L10
    L5:
        return this.f487811a;
    }

    @Override // i0.c
    public final String getName() {
        return this.f487813c;
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
        b r105 = this.f487819i;
        if (r105 == null) goto L14;
        ((ArrayList) r105.f487737a).add(r104);
        r104.e(this);
    L14:
        this.f487818h = r104;
        r104.e(this);
    L15:
        r102 = r102 + 1;
        goto L4
    }

    public o(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101, o0.e r102) {
        this.f487811a = new Path();
        this.f487812b = new RectF();
        if (r0.c.a.f535397a == false) goto L5;
        this.f487819i = new b();
    L5:
        this.f487813c = r102.f521582a;
        this.f487814d = r100;
        j0.a<PointF, PointF> r103 = r102.f521583b.a();
        this.f487815e = r103;
        j0.a<?, ?> r104 = r102.f521584c.a();
        this.f487816f = (j0.j) r104;
        j0.a<?, ?> r105 = r102.f521585d.a();
        this.f487817g = (j0.c) r105;
        r101.e(r103);
        r101.e(r104);
        r101.e(r105);
        r103.a(this);
        r104.a(this);
        r105.a(this);
    }

    @Override // m0.f
    public final void f(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
        u0.e.d(r100, r101, r102, r103, this);
    }
}
