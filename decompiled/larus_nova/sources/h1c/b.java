package h1c;

/* JADX INFO: loaded from: classes37.dex */
public final class b extends g1c.a<Integer> implements a {
    public b() {
        super(2);
    }

    @Override // g1c.a, g1c.b
    public final boolean a() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h1c.a
    public final boolean d() {
        Integer r100 = (Integer) this.f479633c;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        if (r101 != 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h1c.a
    public final boolean isInterrupted() {
        Integer r100 = (Integer) this.f479633c;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L7:
        if (r101 < ((Number) this.f479631a).intValue()) goto L10;
        return true;
    L10:
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    @Override // g1c.b
    public final boolean isValid() {
        if (isInterrupted() == false) goto L5;
    L8:
        return true;
    L5:
        if (d() == true) goto L8;
        return false;
    }

    @Override // g1c.b
    public final Class<k1c.b<Integer>> b() {
        return m1c.b.class;
    }
}
