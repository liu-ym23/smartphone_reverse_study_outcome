package si2;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x1 implements am3.c<t> {
    public x1() {
    }

    public final Object decode(am3.g r7) throws Exception {
        t r0 = new t();
        r0.ecomLinkmicRoomIds = new ArrayList();
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.msgType = r7.i();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.toast = am3.h.c(r7);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.ecomLinkmicRoomIds.add(Long.valueOf(r7.j()));
        goto L3
    L11:
        am3.h.e(r7);
        goto L3
    L15:
        r7.d(r1);
        return r0;
    }
}
