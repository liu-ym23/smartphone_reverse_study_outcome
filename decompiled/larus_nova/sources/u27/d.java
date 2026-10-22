package u27;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ long a(String r210) {
        int r100 = r210.length();
        int r101 = r100 + 0;
        if (r101 == 0) goto L50;
        int r102 = 10;
        long r103 = 10;
        long r104 = Long.MIN_VALUE;
        int r105 = 0;
        if (r103 < 0) goto L7;
        long r110 = (Long.MAX_VALUE / r103) << 1;
        if ((((-1) - (r110 * r103)) ^ Long.MIN_VALUE) < (r103 ^ Long.MIN_VALUE)) goto L13;
        int r106 = 1;
    L14:
        long r111 = r110 + ((long) r106);
    L16:
        if (r210.charAt(0) != '+') goto L19;
        if (r101 <= 1) goto L19;
        r105 = 1;
    L19:
        long r107 = 0;
    L20:
        if (r105 >= r100) goto L48;
        int r108 = Character.digit(r210.charAt(r105), r102);
        if (r108 == (-1)) goto L47;
        if (r107 < 0) goto L45;
        if (r107 > r111) goto L45;
        if (r107 != r111) goto L43;
        if (r103 < 0) goto L30;
        long r211 = (-1) - (((Long.MAX_VALUE / r103) << 1) * r103);
        if ((r211 ^ r104) < (r103 ^ r104)) goto L37;
        long r212 = r103;
    L38:
        long r213 = r211 - r212;
    L33:
        long r109 = r213;
    L40:
        if (r108 > ((int) r109)) goto L45;
    L37:
        r212 = 0;
        goto L38
    L30:
        if (Long.MAX_VALUE >= (r103 ^ r104)) goto L32;
        r109 = -1;
        goto L40
    L32:
        r213 = (-1) - r103;
    L43:
        r107 = (r107 * r103) + ((long) r108);
        r105 = r105 + 1;
        r102 = 10;
        r104 = Long.MIN_VALUE;
    L45:
        throw new NumberFormatException("Too large for unsigned long: ".concat(r210));
    L47:
        throw new NumberFormatException(r210);
    L48:
        return r107;
    L13:
        r106 = 0;
        goto L14
    L7:
        if (Long.MAX_VALUE >= (r103 ^ Long.MIN_VALUE)) goto L9;
        r111 = 0;
        goto L16
    L9:
        r111 = 1;
        goto L16
    L50:
        throw new NumberFormatException("empty string");
    }
}
