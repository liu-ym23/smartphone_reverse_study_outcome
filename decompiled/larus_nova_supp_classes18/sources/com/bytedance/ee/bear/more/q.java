package com.bytedance.ee.bear.more;

import com.bytedance.ee.bear.domain.BearUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q {
    public static String a(oj5.c r2) {
        if ((r2 instanceof oj5.f) == false) goto L7;
        return ((oj5.f) r2).O;
    L7:
        if ((r2 instanceof oj5.a) == false) goto L18;
        oj5.a r3 = (oj5.a) r2;
        String r0 = r3.E;
        if (r0 == null) goto L11;
        BearUrl r1 = s45.p.a().Z(r0);
    L12:
        if (r1 == null) goto L16;
        String r4 = r1.b;
        if (r4 == null) goto L16;
        return r4;
    L16:
        return r3.c;
    L11:
        r1 = null;
        goto L12
    L18:
        return r2.getToken();
    }

    public static boolean b(oj5.c r2) {
        if (r2.o() == true) goto L5;
        return false;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.workspace.phoenix", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static int getType(oj5.c r2) {
        if ((r2 instanceof oj5.f) == false) goto L7;
        return sbb.e.n.b;
    L7:
        if ((r2 instanceof oj5.a) == false) goto L19;
        oj5.a r3 = (oj5.a) r2;
        String r0 = r3.E;
        if (r0 == null) goto L11;
        BearUrl r1 = s45.p.a().Z(r0);
    L12:
        if (r1 == null) goto L17;
        String r4 = r1.a;
        if (r4 == null) goto L17;
        return sbb.e.g(r4);
    L17:
        return r3.getType();
    L11:
        r1 = null;
        goto L12
    L19:
        return r2.getType();
    }
}
