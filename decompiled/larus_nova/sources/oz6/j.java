package oz6;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class j extends f<PointF> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PointF f527220g;

    public j(List<xz6.a<PointF>> r100) {
        super(r100);
        this.f527220g = new PointF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oz6.a
    public final Object f(xz6.a r100, float r101) {
        T r102 = r100.f565527b;
        if (r102 == 0) goto L14;
        T r103 = r100.f565528c;
        if (r103 == 0) goto L14;
        PointF r104 = (PointF) r102;
        PointF r105 = (PointF) r103;
        xz6.c<A> r106 = this.f527200e;
        if (r106 == 0) goto L11;
        r100.f565531f.floatValue();
        d();
        PointF r107 = (PointF) r106.a(r104, r105);
        if (r107 == null) goto L11;
        return r107;
    L11:
        PointF r108 = this.f527220g;
        float r109 = r104.x;
        float r110 = r109 + ((r105.x - r109) * r101);
        float r111 = r104.y;
        r108.set(r110, r111 + (r101 * (r105.y - r111)));
        return this.f527220g;
    L14:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
