package x30;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes45.dex */
public final class a {
    public static boolean a(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (r100.length() >= r101.length()) goto L9;
        return false;
    L9:
        if (r100.endsWith(r101) == true) goto L12;
        return false;
    L12:
        if (r101.equals(r100) == false) goto L14;
    L15:
        return true;
    L14:
        if (r100.endsWith(".".concat(r101)) == true) goto L15;
        return false;
    }
}
