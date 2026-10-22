package gh;

/* JADX INFO: loaded from: classes43.dex */
public final class j implements am3.c<e> {
    public j() {
    }

    @Override // am3.c
    public final e decode(am3.g r100) throws Exception {
        e r101 = new e();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.msgType = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.shopPopControl = h.a(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.shopPopData = i.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }
}
