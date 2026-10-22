package u27;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ long a(String r210, int r211) {
        int r100 = r210.length();
        int r101 = r100 + 0;
        if (r101 == 0) goto L55;
        if (r211 < 2) goto L53;
        if (r211 > 36) goto L53;
        long r102 = r211;
        long r103 = Long.MIN_VALUE;
        int r110 = 0;
        if (r102 < 0) goto L11;
        long r111 = (Long.MAX_VALUE / r102) << 1;
        if ((((-1) - (r111 * r102)) ^ Long.MIN_VALUE) < (r102 ^ Long.MIN_VALUE)) goto L17;
        int r112 = 1;
    L18:
        long r113 = r111 + ((long) r112);
    L20:
        if (r210.charAt(0) != '+') goto L23;
        if (r101 <= 1) goto L23;
        r110 = 1;
    L23:
        long r114 = 0;
    L24:
        if (r110 >= r100) goto L51;
        int r104 = Character.digit(r210.charAt(r110), r211);
        if (r104 == (-1)) goto L50;
        if (r114 < 0) goto L48;
        if (r114 > r113) goto L48;
        if (r114 != r113) goto L46;
        if (r102 < 0) goto L34;
        long r212 = (-1) - (((Long.MAX_VALUE / r102) << 1) * r102);
        if ((r212 ^ r103) < (r102 ^ r103)) goto L40;
        long r213 = r102;
    L41:
        long r105 = r212 - r213;
    L43:
        if (r104 > ((int) r105)) goto L48;
    L40:
        r213 = 0;
        goto L41
    L34:
        if (Long.MAX_VALUE >= (r102 ^ r103)) goto L36;
        r105 = -1;
        goto L43
    L36:
        r105 = (-1) - r102;
    L46:
        r114 = (r114 * r102) + ((long) r104);
        r110 = r110 + 1;
        r103 = Long.MIN_VALUE;
    L48:
        throw new NumberFormatException("Too large for unsigned long: ".concat(r210.toString()));
    L50:
        throw new NumberFormatException(r210.toString());
    L51:
        return r114;
    L17:
        r112 = 0;
        goto L18
    L11:
        if (Long.MAX_VALUE >= (r102 ^ Long.MIN_VALUE)) goto L13;
        r113 = 0;
        goto L20
    L13:
        r113 = 1;
    L53:
        throw new NumberFormatException("illegal radix: ".concat(String.valueOf(r211)));
    L55:
        throw new NumberFormatException("empty string");
    }
}
