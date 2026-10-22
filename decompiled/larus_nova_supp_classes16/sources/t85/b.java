package t85;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static String a(Throwable r3) {
        String r0 = "";
        if (r3 == null) goto L7;
        String r1 = r3.toString();
        if (r3.getCause() == null) goto L9;
        r0 = r3.getCause().toString();
    L9:
        if (TextUtils.isEmpty(r0) == false) goto L11;
        return r1;
    L11:
        Object[] r4 = new Object[2];
        r4[0] = r1;
        if (TextUtils.isEmpty(r0) == true) goto L26;
        int r2 = r0.indexOf("CronetError");
        if (r2 < 0) goto L20;
        int r5 = r0.indexOf("url=");
        if (r5 <= 0) goto L26;
        if (r5 <= r2) goto L26;
        r0 = r0.substring(r2, r5);
        goto L26
    L20:
        int r6 = r0.indexOf("ReqwestError");
        if (r6 < 0) goto L26;
        int r7 = r0.indexOf("https://");
        if (r7 <= 0) goto L26;
        if (r7 <= r6) goto L26;
        r0 = r0.substring(r6, r7);
    L26:
        r4[1] = r0;
        return String.format("%s. cause: %s", r4);
    L7:
        r1 = "";
        goto L9
    }
}
