package kka;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f503830a = 0;

    static {
        new a();
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter("", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        String r101 = c("", r100);
        Intrinsics.checkNotNullParameter("MATRIX_PUSH", "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        String r102 = c(r100, r101);
        Intrinsics.checkNotNullParameter("MATRIX_PUSH", "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
    }

    @JvmStatic
    public static final String c(String r100, String r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        return r101;
    L11:
        return r100 + "-->" + r101;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }
}
