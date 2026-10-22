package xd3;

import kotlin.jvm.internal.Intrinsics;
import yd3.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final boolean a(s r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$lessOneDay");
        Long r8 = r7.a();
        if (r8 == null) goto L10;
        long r1 = r8.longValue() - (System.currentTimeMillis() / ((long) 1000));
        if (r1 <= 86400) goto L7;
        return false;
    L7:
        if (r1 <= 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
