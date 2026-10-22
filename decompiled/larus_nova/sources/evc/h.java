package evc;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes42.dex */
public final class h {
    public static String a(HttpUrl r100) {
        String r101 = r100.encodedPath();
        String r102 = r100.encodedQuery();
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r101 + '?' + r102;
    }
}
