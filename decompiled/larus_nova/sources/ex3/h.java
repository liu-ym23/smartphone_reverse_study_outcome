package ex3;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static boolean a(int r100) {
        if (r100 > 0) goto L6;
        return false;
    L6:
        if (r100 < 10000) goto L9;
        return true;
    L9:
        if (new SecureRandom().nextInt(10000) >= r100) goto L12;
        return true;
    L12:
        return false;
    }
}
