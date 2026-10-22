package r84;

import com.bytedance.bdnavigationsdk.contants.Constants;
import com.bytedance.bdnavigationsdk.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f536505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f536506b = null;

    public a() {
    }

    static {
        int r100 = b.f536507a;
        e r101 = c.f536508a;
        if (r101 != null) goto L5;
        r101 = c.f536509b;
    L5:
        f536505a = r101;
        f536506b = Constants.BDNavigationSDK.getValue();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        f536505a.d(c(null), r100, null);
    }

    public static String c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        return r100;
    L10:
        return f536506b;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static void b(String r100, Throwable r101, int r102) {
        if ((r102 & 4) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "msg");
        f536505a.e(c(null), r100, r101);
    }

    public static void d(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r100 = null;
    L5:
        Intrinsics.checkNotNullParameter(r101, "msg");
        f536505a.i(c(r100), r101, null);
    }
}
