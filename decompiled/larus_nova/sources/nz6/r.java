package nz6;

import com.bytedance.lottie.model.content.ShapeTrimPath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class r implements b, oz6.a.InterfaceC7134a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<oz6.a.InterfaceC7134a> f521543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShapeTrimPath.Type f521544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oz6.c f521545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oz6.c f521546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final oz6.c f521547e;

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        int r100 = 0;
    L4:
        if (r100 >= ((ArrayList) this.f521543a).size()) goto L6;
        ((oz6.a.InterfaceC7134a) ListProtector.get(this.f521543a, r100)).a();
        r100 = r100 + 1;
        goto L4
    }

    @Override // nz6.b
    public final void b(List<b> r100, List<b> r101) {
    }

    public ShapeTrimPath.Type getType() {
        return this.f521544b;
    }

    public final void e(oz6.a.InterfaceC7134a r100) {
        ((ArrayList) this.f521543a).add(r100);
    }

    public r(com.bytedance.lottie.model.layer.a r100, ShapeTrimPath r101) {
        this.f521543a = new ArrayList();
        r101.getClass();
        this.f521544b = r101.getType();
        oz6.a<Float, Float> r102 = r101.f264486b.a();
        this.f521545c = (oz6.c) r102;
        oz6.a<Float, Float> r103 = r101.f264487c.a();
        this.f521546d = (oz6.c) r103;
        oz6.a<Float, Float> r104 = r101.f264488d.a();
        this.f521547e = (oz6.c) r104;
        r100.e(r102);
        r100.e(r103);
        r100.e(r104);
        r102.a(this);
        r103.a(this);
        r104.a(this);
    }
}
