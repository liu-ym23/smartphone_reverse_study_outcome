package gh;

/* JADX INFO: loaded from: classes43.dex */
public final class h implements am3.c<c> {
    public h() {
    }

    public static c a(am3.g r100) throws Exception {
        c r101 = new c();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.action = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.uri = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final c decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
