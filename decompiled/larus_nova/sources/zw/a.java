package zw;

import java.io.IOException;
import java.io.StringReader;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static String a(String[] r100, String r101) throws IOException {
        b r102 = new b(new StringReader(r101));
        r102.f573778b = true;
        r102.f(r100, 0);
        int r103 = r102.f573785i;
        if (r103 == (-1)) goto L12;
        int r104 = r102.f573786j;
        if (r104 == (-1)) goto L14;
        if (r104 >= r103) goto L8;
        return "";
    L8:
        if (r104 < r101.length()) goto L11;
        return "";
    L11:
        return r101.substring(r102.f573785i, r102.f573786j);
    L14:
        return "";
    L12:
        return "";
    }
}
