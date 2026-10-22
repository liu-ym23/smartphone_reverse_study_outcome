package oz6;

import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class k extends f<xz6.d> {
    public k(List<xz6.a<xz6.d>> r100) {
        super(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oz6.a
    public final Object f(xz6.a r100, float r101) {
        T r102 = r100.f565527b;
        if (r102 == 0) goto L27;
        T r103 = r100.f565528c;
        if (r103 == 0) goto L27;
        xz6.d r104 = (xz6.d) r102;
        xz6.d r105 = (xz6.d) r103;
        xz6.c<A> r106 = this.f527200e;
        if (r106 == 0) goto L11;
        r100.f565531f.floatValue();
        d();
        xz6.d r107 = (xz6.d) r106.a(r104, r105);
        if (r107 == null) goto L11;
        return r107;
    L11:
        float r108 = r104.f565540a;
        float r109 = r108 + ((r105.f565540a - r108) * r101);
        float r110 = r104.f565541b;
        float r111 = r110 + (r101 * (r105.f565541b - r110));
        Object[] r112 = xz6.d.a.f565542b.f561955a;
        Object r113 = r112[0];
        if (r113 == null) goto L14;
        r112[0] = null;
    L21:
        xz6.d r114 = (xz6.d) r113;
        if (r114 == null) goto L28;
        r114.f565540a = r109;
        r114.f565541b = r111;
        return r114;
    L28:
        return new xz6.d(r109, r111);
    L14:
        r113 = r112[1];
        if (r113 == null) goto L17;
        r112[1] = null;
        goto L21
    L17:
        r113 = r112[2];
        if (r113 == null) goto L20;
        r112[2] = null;
        goto L21
    L20:
        r113 = null;
    L27:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
