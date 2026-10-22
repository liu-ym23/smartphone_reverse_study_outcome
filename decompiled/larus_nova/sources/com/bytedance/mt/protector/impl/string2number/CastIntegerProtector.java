package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import org.bouncycastle.asn1.cmc.BodyPartID;
import u27.a;
import u27.b;

/* JADX INFO: loaded from: classes.dex */
public class CastIntegerProtector extends a<Integer> {
    public CastIntegerProtector() {
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseInt(String r100) {
        if (c.b() == false) goto L13;
        return Integer.parseInt(r100);
    L6:
        th = move-exception;
        Integer r101 = (Integer) a.tryProtect(th, Integer.class);
        if (r101 != null) goto L10;
        throw th;
    L10:
        return r101.intValue();
    L13:
        return Integer.parseInt(r100);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseUnsignedInt(String r100) {
        if (c.b() == false) goto L23;
    L9:
        th = move-exception;
        Integer r101 = (Integer) a.tryProtect(th, Integer.class);
        if (r101 != null) goto L20;
        throw th;
    L20:
        return r101.intValue();
    L5:
        if (r100.length() > 1) goto L7;
    L11:
        long r102 = Long.parseLong(r100, 10);     // Catch: Throwable -> L9
        if ((BodyPartID.bodyIdMax & r102) != r102) goto L16;
        return (int) r102;
    L16:
        throw new NumberFormatException("Input " + r100 + " in base 10 is not in the range of an unsigned integer");     // Catch: Throwable -> L9
    L7:
        if (r100.charAt(0) != '+') goto L11;
        r100 = r100.substring(1);     // Catch: Throwable -> L9
        goto L11
    L23:
        if (r100.length() > 1) goto L25;
    L27:
        long r103 = Long.parseLong(r100, 10);
        if ((BodyPartID.bodyIdMax & r103) != r103) goto L32;
        return (int) r103;
    L32:
        throw new NumberFormatException("Input " + r100 + " in base 10 is not in the range of an unsigned integer");
    L25:
        if (r100.charAt(0) != '+') goto L27;
        r100 = r100.substring(1);
        goto L27
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Integer valueOf(String r100) {
        if (c.b() == false) goto L12;
        return Integer.valueOf(r100);
    L6:
        th = move-exception;
        Integer r101 = (Integer) a.tryProtect(th, Integer.class);
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw th;
    L12:
        return Integer.valueOf(r100);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseInt(String r100, int r101) {
        if (c.b() == false) goto L13;
        return Integer.parseInt(r100, r101);
    L6:
        th = move-exception;
        Integer r102 = (Integer) a.tryProtect(th, Integer.class);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return r102.intValue();
    L13:
        return Integer.parseInt(r100, r101);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseUnsignedInt(String r100, int r101) {
        if (c.b() == false) goto L13;
        return b.a(r100, r101);
    L6:
        th = move-exception;
        Integer r102 = (Integer) a.tryProtect(th, Integer.class);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return r102.intValue();
    L13:
        if (r100.length() > 1) goto L15;
    L17:
        long r103 = Long.parseLong(r100, r101);
        if ((BodyPartID.bodyIdMax & r103) != r103) goto L22;
        return (int) r103;
    L22:
        throw new NumberFormatException("Input " + r100 + " in base " + r101 + " is not in the range of an unsigned integer");
    L15:
        if (r100.charAt(0) != '+') goto L17;
        r100 = r100.substring(1);
        goto L17
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Integer valueOf(String r100, int r101) {
        if (c.b() == false) goto L12;
        return Integer.valueOf(r100, r101);
    L6:
        th = move-exception;
        Integer r102 = (Integer) a.tryProtect(th, Integer.class);
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw th;
    L12:
        return Integer.valueOf(r100, r101);
    }
}
