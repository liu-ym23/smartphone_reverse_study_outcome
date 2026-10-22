package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import u27.a;
import u27.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class CastLongProtector extends a<Long> {
    public CastLongProtector() {
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseLong(String r2) {
        if (c.b() == false) goto L13;
        return Long.parseLong(r2);
    L6:
        th = move-exception;
        Long r0 = (Long) a.tryProtect(th, Long.class);
        if (r0 != null) goto L10;
        throw th;
    L10:
        return r0.longValue();
    L13:
        return Long.parseLong(r2);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseUnsignedLong(String r28) {
        if (c.b() == true) goto L61;
        int r1 = r28.length();
        int r2 = r1 + 0;
        if (r2 == 0) goto L60;
        int r3 = 10;
        long r4 = 10;
        long r6 = Long.MIN_VALUE;
        int r8 = 0;
        if (r4 < 0) goto L17;
        long r17 = (Long.MAX_VALUE / r4) << 1;
        if ((((-1) - (r17 * r4)) ^ Long.MIN_VALUE) < (r4 ^ Long.MIN_VALUE)) goto L23;
        int r10 = 1;
    L24:
        long r18 = r17 + ((long) r10);
    L26:
        if (r28.charAt(0) != '+') goto L29;
        if (r2 <= 1) goto L29;
        r8 = 1;
    L29:
        long r11 = 0;
    L30:
        if (r8 >= r1) goto L58;
        int r5 = Character.digit(r28.charAt(r8), r3);
        if (r5 == (-1)) goto L57;
        if (r11 < 0) goto L55;
        if (r11 > r18) goto L55;
        if (r11 != r18) goto L53;
        if (r4 < 0) goto L40;
        long r22 = (-1) - (((Long.MAX_VALUE / r4) << 1) * r4);
        if ((r22 ^ r6) < (r4 ^ r6)) goto L46;
        long r24 = r4;
    L47:
        long r23 = r22 - r24;
    L48:
        long r7 = r23;
    L50:
        if (r5 > ((int) r7)) goto L55;
    L46:
        r24 = 0;
        goto L47
    L40:
        if (Long.MAX_VALUE >= (r4 ^ r6)) goto L42;
        r7 = -1;
        goto L50
    L42:
        r23 = (-1) - r4;
    L53:
        r11 = (r11 * r4) + ((long) r5);
        r8 = r8 + 1;
        r3 = 10;
        r6 = Long.MIN_VALUE;
    L55:
        throw new NumberFormatException("Too large for unsigned long: ".concat(r28));
    L57:
        throw new NumberFormatException(r28);
    L58:
        return r11;
    L23:
        r10 = 0;
        goto L24
    L17:
        if (Long.MAX_VALUE >= (r4 ^ Long.MIN_VALUE)) goto L19;
        r18 = 0;
        goto L26
    L19:
        r18 = 1;
        goto L26
    L60:
        throw new NumberFormatException("empty string");
    L61:
        return d.a(r28);
    L6:
        th = move-exception;
        Long r0 = (Long) a.tryProtect(th, Long.class);
        if (r0 != null) goto L10;
        throw th;
    L10:
        return r0.longValue();
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Long valueOf(String r1) {
        if (c.b() == false) goto L12;
        return Long.valueOf(r1);
    L6:
        th = move-exception;
        Long r0 = (Long) a.tryProtect(th, Long.class);
        if (r0 == null) goto L10;
        return r0;
    L10:
        throw th;
    L12:
        return Long.valueOf(r1);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseLong(String r1, int r2) {
        if (c.b() == false) goto L13;
        return Long.parseLong(r1, r2);
    L6:
        th = move-exception;
        Long r3 = (Long) a.tryProtect(th, Long.class);
        if (r3 != null) goto L10;
        throw th;
    L10:
        return r3.longValue();
    L13:
        return Long.parseLong(r1, r2);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseUnsignedLong(String r28, int r29) {
        if (c.b() == true) goto L66;
        int r2 = r28.length();
        int r3 = r2 + 0;
        if (r3 == 0) goto L65;
        if (r29 < 2) goto L63;
        if (r29 > 36) goto L63;
        long r4 = r29;
        long r6 = Long.MIN_VALUE;
        int r8 = 0;
        if (r4 < 0) goto L21;
        long r17 = (Long.MAX_VALUE / r4) << 1;
        if ((((-1) - (r17 * r4)) ^ Long.MIN_VALUE) < (r4 ^ Long.MIN_VALUE)) goto L27;
        int r9 = 1;
    L28:
        long r18 = r17 + ((long) r9);
    L30:
        if (r28.charAt(0) != '+') goto L33;
        if (r3 <= 1) goto L33;
        r8 = 1;
    L33:
        long r10 = 0;
    L34:
        if (r8 >= r2) goto L61;
        int r5 = Character.digit(r28.charAt(r8), r29);
        if (r5 == (-1)) goto L60;
        if (r10 < 0) goto L58;
        if (r10 > r18) goto L58;
        if (r10 != r18) goto L56;
        if (r4 < 0) goto L44;
        long r21 = (-1) - (((Long.MAX_VALUE / r4) << 1) * r4);
        if ((r21 ^ r6) < (r4 ^ r6)) goto L50;
        long r23 = r4;
    L51:
        long r7 = r21 - r23;
    L53:
        if (r5 > ((int) r7)) goto L58;
    L50:
        r23 = 0;
        goto L51
    L44:
        if (Long.MAX_VALUE >= (r4 ^ r6)) goto L46;
        r7 = -1;
        goto L53
    L46:
        r7 = (-1) - r4;
    L56:
        r10 = (r10 * r4) + ((long) r5);
        r8 = r8 + 1;
        r6 = Long.MIN_VALUE;
    L58:
        throw new NumberFormatException("Too large for unsigned long: ".concat(r28));
    L60:
        throw new NumberFormatException(r28);
    L61:
        return r10;
    L27:
        r9 = 0;
        goto L28
    L21:
        if (Long.MAX_VALUE >= (r4 ^ Long.MIN_VALUE)) goto L23;
        r18 = 0;
        goto L30
    L23:
        r18 = 1;
    L63:
        throw new NumberFormatException("illegal radix: ".concat(String.valueOf(r29)));
    L65:
        throw new NumberFormatException("empty string");
    L66:
        return u27.c.a(r28, r29);
    L6:
        th = move-exception;
        Long r0 = (Long) a.tryProtect(th, Long.class);
        if (r0 != null) goto L10;
        throw th;
    L10:
        return r0.longValue();
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Long valueOf(String r1, int r2) {
        if (c.b() == false) goto L12;
        return Long.valueOf(r1, r2);
    L6:
        th = move-exception;
        Long r3 = (Long) a.tryProtect(th, Long.class);
        if (r3 == null) goto L10;
        return r3;
    L10:
        throw th;
    L12:
        return Long.valueOf(r1, r2);
    }
}
