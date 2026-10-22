package com.google.common.base;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class a {
    public static String a(String r100) {
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L23;
        char r103 = r100.charAt(r102);
        if (r103 < 'A') goto L8;
        if (r103 > 'Z') goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L10;
        r102 = r102 + 1;
        goto L3
    L10:
        char[] r105 = r100.toCharArray();
    L11:
        if (r102 >= r101) goto L21;
        char r106 = r105[r102];
        if (r106 < 'A') goto L16;
        if (r106 > 'Z') goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        r105[r102] = (char) (r106 ^ ' ');
    L19:
        r102 = r102 + 1;
    L16:
        r107 = false;
        goto L17
    L21:
        return String.valueOf(r105);
    L8:
        r104 = false;
        goto L9
    L23:
        return r100;
    }

    public static String b(String r100) {
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L23;
        char r103 = r100.charAt(r102);
        if (r103 < 'a') goto L8;
        if (r103 > 'z') goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L10;
        r102 = r102 + 1;
        goto L3
    L10:
        char[] r105 = r100.toCharArray();
    L11:
        if (r102 >= r101) goto L21;
        char r106 = r105[r102];
        if (r106 < 'a') goto L16;
        if (r106 > 'z') goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        r105[r102] = (char) (r106 ^ ' ');
    L19:
        r102 = r102 + 1;
    L16:
        r107 = false;
        goto L17
    L21:
        return String.valueOf(r105);
    L8:
        r104 = false;
        goto L9
    L23:
        return r100;
    }
}
