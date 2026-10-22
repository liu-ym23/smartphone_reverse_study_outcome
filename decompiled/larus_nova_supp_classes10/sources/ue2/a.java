package ue2;

import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(long r6) {
        TimeUnit r0 = TimeUnit.MILLISECONDS;
        long r1 = r0.toMinutes(r6);
        long r7 = r0.toSeconds(r6) % ((long) 60);
        long r3 = 10;
        if (r1 >= r3) goto L5;
        String r2 = BDLocationException.ERROR_TIMEOUT + r1;
    L7:
        if (r7 >= r3) goto L9;
        String r8 = BDLocationException.ERROR_TIMEOUT + r7;
    L11:
        return (r2 + ":") + r8;
    L9:
        r8 = String.valueOf(r7);
        goto L11
    L5:
        r2 = String.valueOf(r1);
        goto L7
    }
}
