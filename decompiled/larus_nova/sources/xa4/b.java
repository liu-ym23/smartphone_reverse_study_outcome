package xa4;

import java.util.Random;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    public static String a() {
        Random r100 = new Random();
        StringBuffer r101 = new StringBuffer();
        int r102 = 0;
    L4:
        if (r102 >= 16) goto L7;
        r101.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(r100.nextInt(62)));
        r102 = r102 + 1;
        goto L4
    L7:
        return r101.toString();
    }
}
