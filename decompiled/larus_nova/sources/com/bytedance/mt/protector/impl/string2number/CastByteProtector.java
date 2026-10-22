package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import u27.a;

/* JADX INFO: loaded from: classes21.dex */
public class CastByteProtector extends a<Byte> {
    public CastByteProtector() {
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static byte parseByte(String r100) {
        if (c.b() == false) goto L13;
        return Byte.parseByte(r100);
    L6:
        th = move-exception;
        Byte r101 = (Byte) a.tryProtect(th, Byte.class);
        if (r101 != null) goto L10;
        throw th;
    L10:
        return r101.byteValue();
    L13:
        return Byte.parseByte(r100);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Byte valueOf(String r100) {
        if (c.b() == false) goto L12;
        return Byte.valueOf(r100);
    L6:
        th = move-exception;
        Byte r101 = (Byte) a.tryProtect(th, Byte.class);
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw th;
    L12:
        return Byte.valueOf(r100);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static byte parseByte(String r100, int r101) {
        if (c.b() == false) goto L13;
        return Byte.parseByte(r100, r101);
    L6:
        th = move-exception;
        Byte r102 = (Byte) a.tryProtect(th, Byte.class);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return r102.byteValue();
    L13:
        return Byte.parseByte(r100, r101);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Byte valueOf(String r100, int r101) {
        if (c.b() == false) goto L12;
        return Byte.valueOf(r100, r101);
    L6:
        th = move-exception;
        Byte r102 = (Byte) a.tryProtect(th, Byte.class);
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw th;
    L12:
        return Byte.valueOf(r100, r101);
    }
}
