package kq7;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (r100.startsWith("webx_") == true) goto L9;
        "webx_".concat(r100);
        return;
    }
}
