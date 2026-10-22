package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import u27.a;
import u27.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class CastIntegerProtector extends a<Integer> {
    public CastIntegerProtector() {
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseInt(String r1) {
        if (c.b() == false) goto L13;
        return Integer.parseInt(r1);
    L6:
        th = move-exception;
        Integer r0 = (Integer) a.tryProtect(th, Integer.class);
        if (r0 != null) goto L10;
        throw th;
    L10:
        return r0.intValue();
    L13:
        return Integer.parseInt(r1);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseUnsignedInt(String r9) {
        if (c.b() == false) goto L23;
    L9:
        th = move-exception;
        Integer r0 = (Integer) a.tryProtect(th, Integer.class);
        if (r0 != null) goto L20;
        throw th;
    L20:
        return r0.intValue();
    L5:
        if (r9.length() > 1) goto L7;
    L11:
        long r3 = Long.parseLong(r9, 10);     // Catch: Throwable -> L9
        if ((4294967295L & r3) != r3) goto L16;
        return (int) r3;
    L16:
        throw new NumberFormatException("Input " + r9 + " in base 10 is not in the range of an unsigned integer");     // Catch: Throwable -> L9
    L7:
        if (r9.charAt(0) != '+') goto L11;
        r9 = r9.substring(1);     // Catch: Throwable -> L9
        goto L11
    L23:
        if (r9.length() > 1) goto L25;
    L27:
        long r4 = Long.parseLong(r9, 10);
        if ((4294967295L & r4) != r4) goto L32;
        return (int) r4;
    L32:
        throw new NumberFormatException("Input " + r9 + " in base 10 is not in the range of an unsigned integer");
    L25:
        if (r9.charAt(0) != '+') goto L27;
        r9 = r9.substring(1);
        goto L27
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Integer valueOf(String r1) {
        if (c.b() == false) goto L12;
        return Integer.valueOf(r1);
    L6:
        th = move-exception;
        Integer r0 = (Integer) a.tryProtect(th, Integer.class);
        if (r0 == null) goto L10;
        return r0;
    L10:
        throw th;
    L12:
        return Integer.valueOf(r1);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseInt(String r1, int r2) {
        if (c.b() == false) goto L13;
        return Integer.parseInt(r1, r2);
    L6:
        th = move-exception;
        Integer r3 = (Integer) a.tryProtect(th, Integer.class);
        if (r3 != null) goto L10;
        throw th;
    L10:
        return r3.intValue();
    L13:
        return Integer.parseInt(r1, r2);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static int parseUnsignedInt(String r5, int r6) {
        if (c.b() == false) goto L13;
        return b.a(r5, r6);
    L6:
        th = move-exception;
        Integer r7 = (Integer) a.tryProtect(th, Integer.class);
        if (r7 != null) goto L10;
        throw th;
    L10:
        return r7.intValue();
    L13:
        if (r5.length() > 1) goto L15;
    L17:
        long r0 = Long.parseLong(r5, r6);
        if ((4294967295L & r0) != r0) goto L22;
        return (int) r0;
    L22:
        throw new NumberFormatException("Input " + r5 + " in base " + r6 + " is not in the range of an unsigned integer");
    L15:
        if (r5.charAt(0) != '+') goto L17;
        r5 = r5.substring(1);
        goto L17
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Integer valueOf(String r1, int r2) {
        if (c.b() == false) goto L12;
        return Integer.valueOf(r1, r2);
    L6:
        th = move-exception;
        Integer r3 = (Integer) a.tryProtect(th, Integer.class);
        if (r3 == null) goto L10;
        return r3;
    L10:
        throw th;
    L12:
        return Integer.valueOf(r1, r2);
    }
}
