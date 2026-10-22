package h9b;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static String a(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r101 = new StringBuilder();
        char[] r102 = r100.toCharArray();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L12;
        char r105 = r102[r104];
        if (Character.isDigit(r105) == false) goto L10;
        r101.append(r105);
    L10:
        r104 = r104 + 1;
        goto L6
    L12:
        return r101.toString();
    }

    public static boolean b(String r100, CharSequence r101) {
        if (r101 != null) goto L4;
    L8:
        return false;
    L4:
        if (r101.length() <= 0) goto L8;
        if (Pattern.matches(r100, r101) == false) goto L8;
        return true;
    }
}
