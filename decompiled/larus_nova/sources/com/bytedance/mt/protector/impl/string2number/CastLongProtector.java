package com.bytedance.mt.protector.impl.string2number;

import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.impl.ProtectorMethod;
import u27.a;
import u27.d;

/* JADX INFO: loaded from: classes.dex */
public class CastLongProtector extends a<Long> {
    public CastLongProtector() {
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseLong(String r100) {
        if (c.b() == false) goto L13;
        return Long.parseLong(r100);
    L6:
        th = move-exception;
        Long r101 = (Long) a.tryProtect(th, Long.class);
        if (r101 != null) goto L10;
        throw th;
    L10:
        return r101.longValue();
    L13:
        return Long.parseLong(r100);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseUnsignedLong(String r210) {
        if (c.b() == true) goto L61;
        int r100 = r210.length();
        int r101 = r100 + 0;
        if (r101 == 0) goto L60;
        int r102 = 10;
        long r103 = 10;
        long r104 = Long.MIN_VALUE;
        int r105 = 0;
        if (r103 < 0) goto L17;
        long r110 = (Long.MAX_VALUE / r103) << 1;
        if ((((-1) - (r110 * r103)) ^ Long.MIN_VALUE) < (r103 ^ Long.MIN_VALUE)) goto L23;
        int r111 = 1;
    L24:
        long r112 = r110 + ((long) r111);
    L26:
        if (r210.charAt(0) != '+') goto L29;
        if (r101 <= 1) goto L29;
        r105 = 1;
    L29:
        long r113 = 0;
    L30:
        if (r105 >= r100) goto L58;
        int r106 = Character.digit(r210.charAt(r105), r102);
        if (r106 == (-1)) goto L57;
        if (r113 < 0) goto L55;
        if (r113 > r112) goto L55;
        if (r113 != r112) goto L53;
        if (r103 < 0) goto L40;
        long r211 = (-1) - (((Long.MAX_VALUE / r103) << 1) * r103);
        if ((r211 ^ r104) < (r103 ^ r104)) goto L46;
        long r212 = r103;
    L47:
        long r213 = r211 - r212;
    L48:
        long r107 = r213;
    L50:
        if (r106 > ((int) r107)) goto L55;
    L46:
        r212 = 0;
        goto L47
    L40:
        if (Long.MAX_VALUE >= (r103 ^ r104)) goto L42;
        r107 = -1;
        goto L50
    L42:
        r213 = (-1) - r103;
    L53:
        r113 = (r113 * r103) + ((long) r106);
        r105 = r105 + 1;
        r102 = 10;
        r104 = Long.MIN_VALUE;
    L55:
        throw new NumberFormatException("Too large for unsigned long: ".concat(r210));
    L57:
        throw new NumberFormatException(r210);
    L58:
        return r113;
    L23:
        r111 = 0;
        goto L24
    L17:
        if (Long.MAX_VALUE >= (r103 ^ Long.MIN_VALUE)) goto L19;
        r112 = 0;
        goto L26
    L19:
        r112 = 1;
        goto L26
    L60:
        throw new NumberFormatException("empty string");
    L61:
        return d.a(r210);
    L6:
        th = move-exception;
        Long r108 = (Long) a.tryProtect(th, Long.class);
        if (r108 != null) goto L10;
        throw th;
    L10:
        return r108.longValue();
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Long valueOf(String r100) {
        if (c.b() == false) goto L12;
        return Long.valueOf(r100);
    L6:
        th = move-exception;
        Long r101 = (Long) a.tryProtect(th, Long.class);
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw th;
    L12:
        return Long.valueOf(r100);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseLong(String r100, int r101) {
        if (c.b() == false) goto L13;
        return Long.parseLong(r100, r101);
    L6:
        th = move-exception;
        Long r102 = (Long) a.tryProtect(th, Long.class);
        if (r102 != null) goto L10;
        throw th;
    L10:
        return r102.longValue();
    L13:
        return Long.parseLong(r100, r101);
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static long parseUnsignedLong(String r210, int r211) {
        if (c.b() == true) goto L66;
        int r100 = r210.length();
        int r101 = r100 + 0;
        if (r101 == 0) goto L65;
        if (r211 < 2) goto L63;
        if (r211 > 36) goto L63;
        long r102 = r211;
        long r103 = Long.MIN_VALUE;
        int r104 = 0;
        if (r102 < 0) goto L21;
        long r110 = (Long.MAX_VALUE / r102) << 1;
        if ((((-1) - (r110 * r102)) ^ Long.MIN_VALUE) < (r102 ^ Long.MIN_VALUE)) goto L27;
        int r105 = 1;
    L28:
        long r111 = r110 + ((long) r105);
    L30:
        if (r210.charAt(0) != '+') goto L33;
        if (r101 <= 1) goto L33;
        r104 = 1;
    L33:
        long r106 = 0;
    L34:
        if (r104 >= r100) goto L61;
        int r107 = Character.digit(r210.charAt(r104), r211);
        if (r107 == (-1)) goto L60;
        if (r106 < 0) goto L58;
        if (r106 > r111) goto L58;
        if (r106 != r111) goto L56;
        if (r102 < 0) goto L44;
        long r212 = (-1) - (((Long.MAX_VALUE / r102) << 1) * r102);
        if ((r212 ^ r103) < (r102 ^ r103)) goto L50;
        long r213 = r102;
    L51:
        long r108 = r212 - r213;
    L53:
        if (r107 > ((int) r108)) goto L58;
    L50:
        r213 = 0;
        goto L51
    L44:
        if (Long.MAX_VALUE >= (r102 ^ r103)) goto L46;
        r108 = -1;
        goto L53
    L46:
        r108 = (-1) - r102;
    L56:
        r106 = (r106 * r102) + ((long) r107);
        r104 = r104 + 1;
        r103 = Long.MIN_VALUE;
    L58:
        throw new NumberFormatException("Too large for unsigned long: ".concat(r210));
    L60:
        throw new NumberFormatException(r210);
    L61:
        return r106;
    L27:
        r105 = 0;
        goto L28
    L21:
        if (Long.MAX_VALUE >= (r102 ^ Long.MIN_VALUE)) goto L23;
        r111 = 0;
        goto L30
    L23:
        r111 = 1;
    L63:
        throw new NumberFormatException("illegal radix: ".concat(String.valueOf(r211)));
    L65:
        throw new NumberFormatException("empty string");
    L66:
        return u27.c.a(r210, r211);
    L6:
        th = move-exception;
        Long r109 = (Long) a.tryProtect(th, Long.class);
        if (r109 != null) goto L10;
        throw th;
    L10:
        return r109.longValue();
    }

    @ProtectorMethod(exceptions = {NumberFormatException.class})
    public static Long valueOf(String r100, int r101) {
        if (c.b() == false) goto L12;
        return Long.valueOf(r100, r101);
    L6:
        th = move-exception;
        Long r102 = (Long) a.tryProtect(th, Long.class);
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw th;
    L12:
        return Long.valueOf(r100, r101);
    }
}
