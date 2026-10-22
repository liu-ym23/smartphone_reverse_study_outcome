package dua;

import java.net.URLEncoder;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static String a(String r100, String r101) {
        if (r101 != null) goto L6;
        return URLEncoder.encode(r100, "ISO-8859-1");
    L6:
        if (r101.equals("null_encoding") == false) goto L9;
        return r100;
    L9:
        return URLEncoder.encode(r100, r101);
    L10:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
