package com.bytedance.timonbase.apicache;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static final String a(a r100) {
        StringBuilder r101 = new StringBuilder();
        Object[] r102 = r100.f270797e;
        if (r102 == null) goto L19;
        int r103 = 0;
        if (r102.length != 0) goto L7;
        boolean r104 = true;
    L9:
        if ((!r104) == false) goto L19;
        int r105 = r102.length;
    L11:
        if (r103 >= r105) goto L19;
        Object r106 = r102[r103];
        if ((r106 instanceof String) == false) goto L15;
    L16:
        r101.append("-" + r106);
    L17:
        r103 = r103 + 1;
        goto L11
    L15:
        if ((r106 instanceof Number) == false) goto L17;
    L7:
        r104 = false;
    L19:
        return r100.f270794b + '-' + r100.f270795c + r101;
    }
}
