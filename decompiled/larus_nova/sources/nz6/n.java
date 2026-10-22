package nz6;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.content.ShapeTrimPath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class n implements oz6.a.InterfaceC7134a, j, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f521516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f521517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f521518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LottieDrawable f521519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final oz6.a<?, PointF> f521520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final oz6.j f521521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final oz6.c f521522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r f521523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f521524i;

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        this.f521524i = false;
        this.f521519d.invalidateSelf();
    }

    @Override // qz6.f
    public final <T> void f(T r100, xz6.c<T> r101) {
    }

    @Override // nz6.l
    public final Path getPath() {
        if (this.f521524i == true) goto L5;
        this.f521516a.reset();
        PointF r100 = this.f521521f.e();
        float r101 = r100.x / 2.0f;
        float r102 = r100.y / 2.0f;
        oz6.c r103 = this.f521522g;
        if (r103 != null) goto L9;
        float r104 = 0.0f;
    L10:
        float r105 = Math.min(r101, r102);
        if (r104 <= r105) goto L13;
        r104 = r105;
    L13:
        PointF r106 = this.f521520e.e();
        this.f521516a.moveTo(r106.x + r101, (r106.y - r102) + r104);
        this.f521516a.lineTo(r106.x + r101, (r106.y + r102) - r104);
        if (r104 <= 0.0f) goto L16;
        RectF r107 = this.f521517b;
        float r110 = r106.x + r101;
        float r111 = r104 * 2.0f;
        float r112 = r106.y + r102;
        r107.set(r110 - r111, r112 - r111, r110, r112);
        this.f521516a.arcTo(this.f521517b, 0.0f, 90.0f, false);
    L16:
        this.f521516a.lineTo((r106.x - r101) + r104, r106.y + r102);
        if (r104 <= 0.0f) goto L19;
        RectF r108 = this.f521517b;
        float r109 = r106.x - r101;
        float r113 = r106.y + r102;
        float r114 = r104 * 2.0f;
        r108.set(r109, r113 - r114, r114 + r109, r113);
        this.f521516a.arcTo(this.f521517b, 90.0f, 90.0f, false);
    L19:
        this.f521516a.lineTo(r106.x - r101, (r106.y - r102) + r104);
        if (r104 <= 0.0f) goto L22;
        RectF r115 = this.f521517b;
        float r116 = r106.x - r101;
        float r117 = r106.y - r102;
        float r118 = r104 * 2.0f;
        r115.set(r116, r117, r116 + r118, r118 + r117);
        this.f521516a.arcTo(this.f521517b, 180.0f, 90.0f, false);
    L22:
        this.f521516a.lineTo((r106.x + r101) - r104, r106.y - r102);
        if (r104 <= 0.0f) goto L25;
        RectF r119 = this.f521517b;
        float r120 = r106.x + r101;
        float r121 = r104 * 2.0f;
        float r122 = r106.y - r102;
        r119.set(r120 - r121, r122, r120, r121 + r122);
        this.f521516a.arcTo(this.f521517b, 270.0f, 90.0f, false);
    L25:
        this.f521516a.close();
        wz6.h.b(this.f521516a, this.f521523h);
        this.f521524i = true;
        return this.f521516a;
    L9:
        r104 = r103.e().floatValue();
        goto L10
    L5:
        return this.f521516a;
    }

    @Override // nz6.b
    public final String getName() {
        return this.f521518c;
    }

    @Override // nz6.b
    public final void b(List<b> r100, List<b> r101) {
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) r100).size()) goto L11;
        b r103 = (b) ListProtector.get(r100, r102);
        if ((r103 instanceof r) == false) goto L10;
        r r104 = (r) r103;
        if (r104.getType() != ShapeTrimPath.Type.Simultaneously) goto L10;
        this.f521523h = r104;
        r104.e(this);
    L10:
        r102 = r102 + 1;
        goto L4
    }

    public n(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101, sz6.e r102) {
        this.f521516a = new Path();
        this.f521517b = new RectF();
        this.f521518c = r102.f543961a;
        this.f521519d = r100;
        oz6.a<PointF, PointF> r103 = r102.f543962b.a();
        this.f521520e = r103;
        oz6.a<?, ?> r104 = r102.f543963c.a();
        this.f521521f = (oz6.j) r104;
        oz6.a<?, ?> r105 = r102.f543964d.a();
        this.f521522g = (oz6.c) r105;
        r101.e(r103);
        r101.e(r104);
        r101.e(r105);
        r103.a(this);
        r104.a(this);
        r105.a(this);
    }

    @Override // qz6.f
    public final void g(qz6.e r100, int r101, List<qz6.e> r102, qz6.e r103) {
        wz6.f.d(r100, r101, r102, r103, this);
    }
}
