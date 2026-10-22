package rlc;

import java.io.File;

/* JADX INFO: loaded from: classes36.dex */
public final class b {
    public static String a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L14;
        String r102 = File.separator;
        if (r100.endsWith(r102) == false) goto L13;
        return r100;
    L13:
        return r100 + r102;
    L14:
        return r100;
    L4:
        if (r100.isEmpty() == true) goto L7;
        r101 = false;
        goto L8
    }
}
