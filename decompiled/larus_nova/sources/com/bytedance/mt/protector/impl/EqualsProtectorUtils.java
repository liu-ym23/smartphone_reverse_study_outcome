package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes21.dex */
public class EqualsProtectorUtils {
    public EqualsProtectorUtils() {
    }

    @ProtectorMethod(exceptions = {NullPointerException.class})
    public static boolean equals(Object r110, Object r111) {
        if (c.b() == false) goto L24;
        if (r110 != null) goto L24;
        com.bytedance.mt.protector.a r112 = c.f265673e;
        if (r112 == null) goto L22;
        ProtectorType r100 = ProtectorType.EQUALS;
        NullPointerException r101 = new NullPointerException("equals NPE");
        if (r101.getStackTrace() != null) goto L10;
    L21:
        r112.b(r100, r101);
        goto L22
    L10:
        if (r101.getStackTrace().length == 0) goto L21;
        StackTraceElement[] r102 = r101.getStackTrace();
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L20;
        StackTraceElement r106 = r102[r105];
        if (r106 == null) goto L19;
        if (equals(r106.getClassName(), EqualsProtectorUtils.class.getName()) == true) goto L19;
        r103.add(r106);
    L19:
        r105 = r105 + 1;
        goto L13
    L20:
        r101.setStackTrace((StackTraceElement[]) r103.toArray(new StackTraceElement[0]));
    L22:
        return false;
    L24:
        return r110.equals(r111);
    }
}
