package oz6;

import android.graphics.PointF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes21.dex */
public final class m extends a<PointF, PointF> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PointF f527223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a<Float, Float> f527224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a<Float, Float> f527225i;

    @Override // oz6.a
    public final PointF e() {
        return this.f527223g;
    }

    @Override // oz6.a
    public final void h(float r100) {
        this.f527224h.h(r100);
        this.f527225i.h(r100);
        this.f527223g.set(this.f527224h.e().floatValue(), this.f527225i.e().floatValue());
        int r101 = 0;
    L4:
        if (r101 >= ((ArrayList) this.f527196a).size()) goto L6;
        ((a.InterfaceC7134a) ListProtector.get(this.f527196a, r101)).a();
        r101 = r101 + 1;
        goto L4
    }

    public m(c r100, c r101) {
        super(Collections.emptyList());
        this.f527223g = new PointF();
        this.f527224h = r100;
        this.f527225i = r101;
        h(this.f527199d);
    }

    @Override // oz6.a
    public final PointF f(xz6.a<PointF> r100, float r101) {
        return this.f527223g;
    }
}
