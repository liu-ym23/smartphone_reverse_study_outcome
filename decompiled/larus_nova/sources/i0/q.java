package i0;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class q implements m, j0.a.InterfaceC6374a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f487830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LottieDrawable f487831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0.l f487832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f487833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f487834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f487835f;

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        this.f487833d = false;
        this.f487831b.invalidateSelf();
    }

    @Override // i0.m
    public final Path getPath() {
        if (this.f487833d == true) goto L5;
        this.f487830a.reset();
        this.f487830a.set(this.f487832c.g());
        this.f487830a.setFillType(Path.FillType.EVEN_ODD);
        if (r0.c.a.f535397a == false) goto L11;
        b r100 = this.f487835f;
        if (r100 == null) goto L11;
        r100.a(this.f487830a);
    L12:
        this.f487833d = true;
        return this.f487830a;
    L11:
        u0.f.b(this.f487830a, this.f487834e);
        goto L12
    L5:
        return this.f487830a;
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
        b r105 = this.f487835f;
        if (r105 == null) goto L14;
        ((ArrayList) r105.f487737a).add(r104);
        r104.e(this);
    L14:
        this.f487834e = r104;
        r104.e(this);
    L15:
        r102 = r102 + 1;
        goto L4
    }

    public q(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101, o0.j r102) {
        this.f487830a = new Path();
        if (r0.c.a.f535397a == false) goto L5;
        this.f487835f = new b();
    L5:
        r102.getClass();
        this.f487831b = r100;
        j0.a<o0.g, Path> r103 = r102.f521602c.a();
        this.f487832c = (j0.l) r103;
        r101.e(r103);
        r103.a(this);
    }
}
