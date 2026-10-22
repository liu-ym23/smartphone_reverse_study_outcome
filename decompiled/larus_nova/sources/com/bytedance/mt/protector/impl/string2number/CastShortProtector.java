package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import u27.a;

/* JADX INFO: loaded from: classes21.dex */
public class CastShortProtector extends a<Short> {
    public CastShortProtector() {
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static short parseShort(String r100) {
        if (c.b() == false) goto L13;
        return Short.parseShort(r100);
    L6:
        th = move-exception;
        Short r101 = (Short) a.tryProtect(th, Short.class);
        if (r101 != null) goto L10;
        throw th;
    L10:
        return r101.shortValue();
    L13:
        return Short.parseShort(r100);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Short valueOf(String r100) {
        if (c.b() == false) goto L12;
        return Short.valueOf(r100);
    L6:
        th = move-exception;
        Short r101 = (Short) a.tryProtect(th, Short.class);
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw th;
    L12:
        return Short.valueOf(r100);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static short parseShort(String r100, int r101) {
        if (c.b() == false) goto L13;
        return Short.parseShort(r100, r101);
    L6:
        th = move-exception;
        Short r102 = (Short) a.tryProtect(th, Short.class);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return r102.shortValue();
    L13:
        return Short.parseShort(r100, r101);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Short valueOf(String r100, int r101) {
        if (c.b() == false) goto L12;
        return Short.valueOf(r100, r101);
    L6:
        th = move-exception;
        Short r102 = (Short) a.tryProtect(th, Short.class);
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw th;
    L12:
        return Short.valueOf(r100, r101);
    }
}
