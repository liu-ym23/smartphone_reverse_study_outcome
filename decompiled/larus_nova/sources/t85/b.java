package t85;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static String a(Throwable r100) {
        String r101 = "";
        if (r100 == null) goto L7;
        String r102 = r100.toString();
        if (r100.getCause() == null) goto L9;
        r101 = r100.getCause().toString();
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return r102;
    L11:
        Object[] r103 = new Object[2];
        r103[0] = r102;
        if (TextUtils.isEmpty(r101) == true) goto L26;
        int r104 = r101.indexOf("CronetError");
        if (r104 < 0) goto L20;
        int r105 = r101.indexOf("url=");
        if (r105 <= 0) goto L26;
        if (r105 <= r104) goto L26;
        r101 = r101.substring(r104, r105);
        goto L26
    L20:
        int r106 = r101.indexOf("ReqwestError");
        if (r106 < 0) goto L26;
        int r107 = r101.indexOf("https://");
        if (r107 <= 0) goto L26;
        if (r107 <= r106) goto L26;
        r101 = r101.substring(r106, r107);
    L26:
        r103[1] = r101;
        return String.format("%s. cause: %s", r103);
    L7:
        r102 = "";
        goto L9
    }
}
