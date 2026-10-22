package jy0;

import com.bytedance.android.live.revenue.core.util.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ((a) f.a(a.class)).k(r100, r101);
    }

    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ((a) f.a(a.class)).j(r100, r101);
    }

    public static final void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102 == null) goto L6;
        ((a) f.a(a.class)).M3(r100, r101, r102);
        return;
    L6:
        ((a) f.a(a.class)).M3(r100, r101, null);
    }

    public static final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102 == null) goto L6;
        ((a) f.a(a.class)).d5(r100, r101, r102);
        return;
    L6:
        ((a) f.a(a.class)).d5(r100, r101, null);
    }

    public static /* synthetic */ void c(String r100, String r101, Throwable r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        b(r100, r101, r102);
    }

    public static /* synthetic */ void f(String r100, String r101, Throwable r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        e(r100, r101, r102);
    }
}
