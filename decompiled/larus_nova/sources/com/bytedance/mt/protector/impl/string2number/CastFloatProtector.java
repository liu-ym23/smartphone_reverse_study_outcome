package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import u27.a;

/* JADX INFO: loaded from: classes3.dex */
public class CastFloatProtector extends a<Float> {
    public CastFloatProtector() {
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static float parseFloat(String r100) {
        if (c.b() == false) goto L13;
        return Float.parseFloat(r100);
    L6:
        th = move-exception;
        Float r101 = (Float) a.tryProtect(th, Float.class);
        if (r101 != null) goto L10;
        throw th;
    L10:
        return r101.floatValue();
    L13:
        return Float.parseFloat(r100);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Float valueOf(String r100) {
        if (c.b() == false) goto L12;
        return Float.valueOf(r100);
    L6:
        th = move-exception;
        Float r101 = (Float) a.tryProtect(th, Float.class);
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw th;
    L12:
        return Float.valueOf(r100);
    }
}
