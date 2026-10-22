package i36;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends b {
    public d() {
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c(r100, Long.valueOf(System.currentTimeMillis()));
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d(r100, Long.valueOf(System.currentTimeMillis()));
    }

    public final long e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "start");
        Intrinsics.checkNotNullParameter(r101, "end");
        long r102 = b(r100);
        long r103 = b(r101);
        if (r102 != (-1)) goto L5;
    L8:
        return 0;
    L5:
        if (r103 == (-1)) goto L8;
        return r103 - r102;
    }
}
