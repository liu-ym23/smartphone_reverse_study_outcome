package nz6;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.content.ShapeTrimPath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements l, oz6.a.InterfaceC7134a, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f521453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f521454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieDrawable f521455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oz6.j f521456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final oz6.a<?, PointF> f521457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final sz6.a f521458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f521459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f521460h;

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        this.f521460h = false;
        this.f521455c.invalidateSelf();
    }

    @Override // nz6.l
    public final Path getPath() {
        if (this.f521460h == true) goto L5;
        this.f521453a.reset();
        PointF r100 = this.f521456d.e();
        float r101 = r100.x / 2.0f;
        float r102 = r100.y / 2.0f;
        float r110 = r101 * 0.55228f;
        float r103 = 0.55228f * r102;
        this.f521453a.reset();
        if (this.f521458f.f543951d == false) goto L9;
        float r111 = -r102;
        this.f521453a.moveTo(0.0f, r111);
        float r104 = 0.0f - r110;
        float r105 = -r101;
        float r210 = 0.0f - r103;
        this.f521453a.cubicTo(r104, r111, r105, r210, r105, 0.0f);
        float r106 = r103 + 0.0f;
        this.f521453a.cubicTo(r105, r106, r104, r102, 0.0f, r102);
        float r112 = r110 + 0.0f;
        this.f521453a.cubicTo(r112, r102, r101, r106, r101, 0.0f);
        this.f521453a.cubicTo(r101, r210, r112, r111, 0.0f, r111);
    L10:
        PointF r107 = this.f521457e.e();
        this.f521453a.offset(r107.x, r107.y);
        this.f521453a.close();
        wz6.h.b(this.f521453a, this.f521459g);
        this.f521460h = true;
        return this.f521453a;
    L9:
        float r113 = -r102;
        this.f521453a.moveTo(0.0f, r113);
        float r114 = r110 + 0.0f;
        float r115 = 0.0f - r103;
        this.f521453a.cubicTo(r114, r113, r101, r115, r101, 0.0f);
        float r108 = r103 + 0.0f;
        this.f521453a.cubicTo(r101, r108, r114, r102, 0.0f, r102);
        float r116 = 0.0f - r110;
        float r117 = -r101;
        this.f521453a.cubicTo(r116, r102, r117, r108, r117, 0.0f);
        this.f521453a.cubicTo(r117, r115, r116, r113, 0.0f, r113);
        goto L10
    L5:
        return this.f521453a;
    }

    @Override // nz6.b
    public final String getName() {
        return this.f521454b;
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
        this.f521459g = r104;
        r104.e(this);
    L10:
        r102 = r102 + 1;
        goto L4
    }

    @Override // qz6.f
    public final <T> void f(T r100, xz6.c<T> r101) {
        if (r100 != com.bytedance.lottie.n.f264559g) goto L6;
        this.f521456d.i(r101);
        return;
    L6:
        if (r100 != com.bytedance.lottie.n.f264560h) goto L10;
        this.f521457e.i(r101);
        return;
    }

    public e(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101, sz6.a r102) {
        this.f521453a = new Path();
        this.f521454b = r102.f543948a;
        this.f521455c = r100;
        oz6.a<?, ?> r103 = r102.f543950c.a();
        this.f521456d = (oz6.j) r103;
        oz6.a<PointF, PointF> r104 = r102.f543949b.a();
        this.f521457e = r104;
        this.f521458f = r102;
        r101.e(r103);
        r101.e(r104);
        r103.a(this);
        r104.a(this);
    }

    @Override // qz6.f
    public final void g(qz6.e r100, int r101, List<qz6.e> r102, qz6.e r103) {
        wz6.f.d(r100, r101, r102, r103, this);
    }
}
