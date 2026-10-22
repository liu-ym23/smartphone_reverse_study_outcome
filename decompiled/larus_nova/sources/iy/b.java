package iy;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f496463a = false;

    static {
        f496463a = ((Boolean) vm2.d.f555816e.getValue(null, vm2.d.f555776a[3])).booleanValue();
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (f496463a == true) goto L7;
        ALogger.e("AnchorModeLinkDynamicWidget", r100);
        return;
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (f496463a == true) goto L7;
        ALogger.i("AnchorModeLinkDynamicWidget", r100);
        return;
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f496463a == true) goto L7;
        ALogger.d(r100, r101);
        return;
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f496463a == true) goto L7;
        ALogger.e(r100, r101);
        return;
    }

    public static void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f496463a == true) goto L7;
        ALogger.i(r100, r101);
        return;
    }
}
