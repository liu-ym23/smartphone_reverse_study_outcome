package p9a;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f528329a;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        e r102 = f528329a;
        if (r102 == null) goto L6;
        r102.i("card_".concat(r100), r101);
        return;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        e r102 = f528329a;
        if (r102 == null) goto L6;
        r102.w("card_".concat(r100), r101);
        return;
    }

    public static void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        e r103 = f528329a;
        if (r103 == null) goto L6;
        r103.w("card_".concat(r100), r101, r102);
        return;
    }
}
