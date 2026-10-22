package r84;

import com.bytedance.bdnavigationsdk.contants.Constants;
import com.bytedance.bdnavigationsdk.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final e a = null;
    public static final String b = null;

    public a() {
    }

    static {
        int r0 = b.a;
        e r1 = c.a;
        if (r1 != null) goto L5;
        r1 = c.b;
    L5:
        a = r1;
        b = Constants.BDNavigationSDK.getValue();
    }

    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        a.d(c(null), r3, null);
    }

    public static String c(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return r1;
    L10:
        return b;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void b(String r1, Throwable r2, int r3) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        Intrinsics.checkNotNullParameter(r1, "msg");
        a.e(c(null), r1, r2);
    }

    public static void d(String r1, String r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        Intrinsics.checkNotNullParameter(r2, "msg");
        a.i(c(r1), r2, null);
    }
}
