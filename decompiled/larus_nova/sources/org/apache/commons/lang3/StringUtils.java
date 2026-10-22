package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes42.dex */
public class StringUtils {
    public static boolean isEmpty(CharSequence r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static boolean containsAny(CharSequence r110, char... r111) {
        if (isEmpty(r110) == false) goto L5;
    L23:
        return false;
    L5:
        if (ArrayUtils.isEmpty(r111) == true) goto L23;
        int r100 = r110.length();
        int r101 = r111.length;
        int r102 = r100 - 1;
        int r103 = r101 - 1;
        int r104 = 0;
    L8:
        if (r104 >= r100) goto L23;
        char r105 = r110.charAt(r104);
        int r106 = 0;
    L10:
        if (r106 >= r101) goto L22;
        if (r111[r106] != r105) goto L21;
        if (Character.isHighSurrogate(r105) == false) goto L20;
        if (r106 == r103) goto L16;
        if (r104 >= r102) goto L21;
        if (r111[r106 + 1] != r110.charAt(r104 + 1)) goto L21;
    L16:
        return true;
    L20:
        return true;
    L21:
        r106 = r106 + 1;
        goto L10
    L22:
        r104 = r104 + 1;
        goto L8
    }

    public static boolean containsNone(CharSequence r110, char... r111) {
        if (r110 == null) goto L22;
        if (r111 == null) goto L22;
        int r100 = r110.length();
        int r101 = r100 - 1;
        int r102 = r111.length;
        int r103 = r102 - 1;
        int r104 = 0;
    L7:
        if (r104 >= r100) goto L22;
        char r105 = r110.charAt(r104);
        int r106 = 0;
    L9:
        if (r106 >= r102) goto L21;
        if (r111[r106] != r105) goto L20;
        if (Character.isHighSurrogate(r105) == false) goto L19;
        if (r106 == r103) goto L15;
        if (r104 >= r101) goto L20;
        if (r111[r106 + 1] != r110.charAt(r104 + 1)) goto L20;
    L15:
        return false;
    L19:
        return false;
    L20:
        r106 = r106 + 1;
        goto L9
    L21:
        r104 = r104 + 1;
    L22:
        return true;
    }

    public static boolean equals(CharSequence r100, CharSequence r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L20;
        if (r101 == null) goto L20;
        if (r100.length() == r101.length()) goto L13;
        return false;
    L13:
        if ((r100 instanceof String) == false) goto L19;
        if ((r101 instanceof String) == false) goto L19;
        return r100.equals(r101);
    L19:
        return CharSequenceUtils.regionMatches(r100, false, 0, r101, 0, r100.length());
    L20:
        return false;
    }

    public static boolean equalsIgnoreCase(CharSequence r100, CharSequence r110) {
        if (r100 == null) goto L13;
        if (r110 == null) goto L13;
        if (r100 != r110) goto L9;
        return true;
    L9:
        if (r100.length() == r110.length()) goto L12;
        return false;
    L12:
        return CharSequenceUtils.regionMatches(r100, true, 0, r110, 0, r100.length());
    L13:
        if (r100 == r110) goto L17;
        return false;
    L17:
        return true;
    }

    public static String replace(String r100, String r101, String r102) {
        return replace(r100, r101, r102, -1);
    }

    public static String replace(String r100, String r101, String r102, int r103) {
        return replace(r100, r101, r102, r103, false);
    }

    private static String replace(String r100, String r101, String r102, int r110, boolean r111) {
        if (isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (isEmpty(r101) == true) goto L35;
        if (r102 == null) goto L36;
        if (r110 == 0) goto L37;
        if (r111 == false) goto L11;
        String r112 = r100.toLowerCase();
        r101 = r101.toLowerCase();
    L12:
        int r103 = 0;
        int r104 = r112.indexOf(r101, 0);
        if (r104 != (-1)) goto L15;
        return r100;
    L15:
        int r105 = r101.length();
        int r106 = r102.length() - r105;
        if (r106 >= 0) goto L18;
        r106 = 0;
    L18:
        if (r110 >= 0) goto L20;
        int r107 = 16;
    L24:
        StringBuilder r108 = new StringBuilder(r100.length() + (r106 * r107));
    L25:
        if (r104 == (-1)) goto L30;
        r108.append(r100, r103, r104);
        r108.append(r102);
        r103 = r104 + r105;
        r110 = r110 - 1;
        if (r110 == 0) goto L30;
        r104 = r112.indexOf(r101, r103);
    L30:
        r108.append(r100, r103, r100.length());
        return r108.toString();
    L20:
        r107 = 64;
        if (r110 > 64) goto L24;
        r107 = r110;
        goto L24
    L11:
        r112 = r100;
        goto L12
    L37:
        return r100;
    L36:
        return r100;
    L35:
        return r100;
    }
}
