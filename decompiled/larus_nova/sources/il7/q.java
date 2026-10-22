package il7;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes22.dex */
public final class q {
    public static String a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty("aid") == false) goto L7;
        return r100;
    L7:
        return r100.replaceAll("(aid=[^&]*)", "aid=" + r101);
    }
}
