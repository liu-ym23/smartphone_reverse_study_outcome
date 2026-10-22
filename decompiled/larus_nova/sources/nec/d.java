package nec;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class d {
    public static boolean a(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r100.charAt(r100.length() - 1) != '\n') goto L9;
        return true;
    L9:
        return false;
    }

    public static void b(StringBuilder r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (a(r100) == true) goto L9;
        r100.append("\n");
        return;
    }
}
