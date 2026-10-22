package i0;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class s implements c, j0.a.InterfaceC6374a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j0.a.InterfaceC6374a> f487840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShapeTrimPath.Type f487841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0.c f487842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0.c f487843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j0.c f487844e;

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        int r100 = 0;
    L4:
        if (r100 >= ((ArrayList) this.f487840a).size()) goto L6;
        ((j0.a.InterfaceC6374a) ListProtector.get(this.f487840a, r100)).a();
        r100 = r100 + 1;
        goto L4
    }

    @Override // i0.c
    public final void b(List<c> r100, List<c> r101) {
    }

    public ShapeTrimPath.Type getType() {
        return this.f487841b;
    }

    public final void e(j0.a.InterfaceC6374a r100) {
        ((ArrayList) this.f487840a).add(r100);
    }

    public s(com.airbnb.lottie.model.layer.a r100, ShapeTrimPath r101) {
        this.f487840a = new ArrayList();
        r101.getClass();
        this.f487841b = r101.getType();
        j0.a<Float, Float> r102 = r101.f24848b.a();
        this.f487842c = (j0.c) r102;
        j0.a<Float, Float> r103 = r101.f24849c.a();
        this.f487843d = (j0.c) r103;
        j0.a<Float, Float> r104 = r101.f24850d.a();
        this.f487844e = (j0.c) r104;
        r100.e(r102);
        r100.e(r103);
        r100.e(r104);
        r102.a(this);
        r103.a(this);
        r104.a(this);
    }
}
