package gh;

/* JADX INFO: loaded from: classes43.dex */
public final class i implements am3.c<d> {
    public i() {
    }

    public static d a(am3.g r100) throws Exception {
        d r101 = new d();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.promotion = g.a(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final d decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
