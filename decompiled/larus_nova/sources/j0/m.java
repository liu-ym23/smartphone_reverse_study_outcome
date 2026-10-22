package j0;

import android.graphics.PointF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes28.dex */
public final class m extends a<PointF, PointF> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PointF f496775k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a<Float, Float> f496776l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a<Float, Float> f496777m;

    @Override // j0.a
    public final PointF g() {
        return this.f496775k;
    }

    @Override // j0.a
    public final void j(float r100) {
        this.f496776l.j(r100);
        this.f496777m.j(r100);
        this.f496775k.set(this.f496776l.g().floatValue(), this.f496777m.g().floatValue());
        int r101 = 0;
    L4:
        if (r101 >= ((ArrayList) this.f496745a).size()) goto L6;
        ((a.InterfaceC6374a) ListProtector.get(this.f496745a, r101)).a();
        r101 = r101 + 1;
        goto L4
    }

    public m(c r100, c r101) {
        super(Collections.emptyList());
        this.f496775k = new PointF();
        this.f496776l = r100;
        this.f496777m = r101;
        j(this.f496749e);
    }

    @Override // j0.a
    public final PointF h(v0.a<PointF> r100, float r101) {
        return this.f496775k;
    }
}
