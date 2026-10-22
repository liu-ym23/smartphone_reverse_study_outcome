package oz6;

import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends f<Integer> {
    public b(List<xz6.a<Integer>> r100) {
        super(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oz6.a
    public final Object f(xz6.a r100, float r101) {
        T r102 = r100.f565527b;
        if (r102 == 0) goto L14;
        if (r100.f565528c == 0) goto L14;
        int r103 = ((Integer) r102).intValue();
        int r104 = ((Integer) r100.f565528c).intValue();
        xz6.c<A> r105 = this.f527200e;
        if (r105 == 0) goto L12;
        r100.f565531f.floatValue();
        Integer r106 = Integer.valueOf(r103);
        Integer r107 = Integer.valueOf(r104);
        d();
        Integer r108 = (Integer) r105.a(r106, r107);
        if (r108 == null) goto L12;
        return r108;
    L12:
        return Integer.valueOf(wz6.c.c(r101, r103, r104));
    L14:
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
