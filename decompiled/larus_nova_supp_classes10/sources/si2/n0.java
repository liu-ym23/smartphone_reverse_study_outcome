package si2;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n0 implements am3.c<c> {
    public n0() {
    }

    public final Object decode(am3.g r6) throws Exception {
        c r0 = new c();
        r0.categoryInfo = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.categoryInfo.add(m0.a(r6));
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.updateTimeStamp = r6.j();
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.updateToast = am3.h.c(r6);
        goto L3
    L11:
        am3.h.e(r6);
        goto L3
    L15:
        r6.d(r1);
        return r0;
    }
}
