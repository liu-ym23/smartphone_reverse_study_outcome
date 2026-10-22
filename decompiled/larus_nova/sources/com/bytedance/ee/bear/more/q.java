package com.bytedance.ee.bear.more;

import com.bytedance.ee.bear.domain.BearUrl;

/* JADX INFO: loaded from: classes18.dex */
public final class q {
    public static String a(oj5.c r100) {
        if ((r100 instanceof oj5.f) == false) goto L7;
        return ((oj5.f) r100).O;
    L7:
        if ((r100 instanceof oj5.a) == false) goto L18;
        oj5.a r101 = (oj5.a) r100;
        String r102 = r101.E;
        if (r102 == null) goto L11;
        BearUrl r103 = s45.p.a().Z(r102);
    L12:
        if (r103 == null) goto L16;
        String r104 = r103.f222561b;
        if (r104 == null) goto L16;
        return r104;
    L16:
        return r101.f523532c;
    L11:
        r103 = null;
        goto L12
    L18:
        return r100.getToken();
    }

    public static boolean b(oj5.c r100) {
        if (r100.o() == true) goto L5;
        return false;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.workspace.phoenix", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static int getType(oj5.c r100) {
        if ((r100 instanceof oj5.f) == false) goto L7;
        return sbb.e.f541303n.f541317b;
    L7:
        if ((r100 instanceof oj5.a) == false) goto L19;
        oj5.a r101 = (oj5.a) r100;
        String r102 = r101.E;
        if (r102 == null) goto L11;
        BearUrl r103 = s45.p.a().Z(r102);
    L12:
        if (r103 == null) goto L17;
        String r104 = r103.f222560a;
        if (r104 == null) goto L17;
        return sbb.e.g(r104);
    L17:
        return r101.getType();
    L11:
        r103 = null;
        goto L12
    L19:
        return r100.getType();
    }
}
