package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import u27.a;

/* JADX INFO: loaded from: classes3.dex */
public class CastDoubleProtector extends a<Double> {
    public CastDoubleProtector() {
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static double parseDouble(String r100) {
        if (c.b() == false) goto L13;
        return Double.parseDouble(r100);
    L6:
        th = move-exception;
        Double r101 = (Double) a.tryProtect(th, Double.class);
        if (r101 != null) goto L10;
        throw th;
    L10:
        return r101.doubleValue();
    L13:
        return Double.parseDouble(r100);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Double valueOf(String r100) {
        if (c.b() == false) goto L12;
        return Double.valueOf(r100);
    L6:
        th = move-exception;
        Double r101 = (Double) a.tryProtect(th, Double.class);
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw th;
    L12:
        return Double.valueOf(r100);
    }
}
