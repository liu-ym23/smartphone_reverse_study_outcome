package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes42.dex */
public class CharSequenceUtils {
    public static boolean regionMatches(CharSequence r100, boolean r101, int r102, CharSequence r110, int r111, int r112) {
        if ((r100 instanceof String) == true) goto L5;
    L8:
        int r103 = r100.length() - r102;
        int r104 = r110.length() - r111;
        if (r102 < 0) goto L31;
        if (r111 < 0) goto L31;
        if (r112 < 0) goto L31;
        if (r103 < r112) goto L31;
        if (r104 < r112) goto L31;
    L16:
        int r105 = r112 - 1;
        if (r112 <= 0) goto L29;
        int r113 = r102 + 1;
        char r106 = r100.charAt(r102);
        int r107 = r111 + 1;
        char r114 = r110.charAt(r111);
        if (r106 == r114) goto L28;
        if (r101 == false) goto L22;
        if (Character.toUpperCase(r106) == Character.toUpperCase(r114)) goto L28;
        if (Character.toLowerCase(r106) == Character.toLowerCase(r114)) goto L28;
        return false;
    L22:
        return false;
    L28:
        r102 = r113;
        r112 = r105;
        r111 = r107;
        goto L16
    L29:
        return true;
    L31:
        return false;
    L5:
        if ((r110 instanceof String) == false) goto L8;
        return ((String) r100).regionMatches(r101, r102, (String) r110, r111, r112);
    }
}
