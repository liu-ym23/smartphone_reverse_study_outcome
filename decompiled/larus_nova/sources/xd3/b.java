package xd3;

import kotlin.jvm.internal.Intrinsics;
import yd3.s;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final boolean a(s r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$lessOneDay");
        Long r101 = r100.a();
        if (r101 == null) goto L10;
        long r102 = r101.longValue() - (System.currentTimeMillis() / ((long) 1000));
        if (r102 <= 86400) goto L7;
        return false;
    L7:
        if (r102 <= 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
