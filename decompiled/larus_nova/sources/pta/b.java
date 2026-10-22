package pta;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return true;
    L6:
        if (r100.equalsIgnoreCase("unknown") == false) goto L9;
        return true;
    L9:
        if (r100.equalsIgnoreCase("None") == false) goto L11;
        return true;
    L11:
        int r101 = 0;
    L13:
        if (r101 >= r100.length()) goto L21;
        if (r100.charAt(r101) != '0') goto L16;
        r101 = r101 + 1;
        goto L13
    L16:
        return false;
    L21:
        return true;
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.length();
        if (r101 >= 13) goto L8;
    L30:
        return false;
    L8:
        if (r101 > 160) goto L30;
        int r102 = 0;
    L11:
        if (r102 >= r101) goto L28;
        char r103 = r100.charAt(r102);
        if (r103 < '0') goto L17;
        if (r103 > '9') goto L17;
    L27:
        r102 = r102 + 1;
    L17:
        if (r103 < 'a') goto L21;
        if (r103 <= 'f') goto L27;
    L21:
        if (r103 < 'A') goto L25;
        if (r103 <= 'F') goto L27;
    L25:
        if (r103 == '-') goto L27;
        return false;
    L28:
        return true;
    }
}
