package si2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class x1 implements am3.c<t> {
    public x1() {
    }

    @Override // am3.c
    public final t decode(am3.g r100) throws Exception {
        t r101 = new t();
        r101.ecomLinkmicRoomIds = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.msgType = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.toast = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.ecomLinkmicRoomIds.add(Long.valueOf(r100.j()));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }
}
