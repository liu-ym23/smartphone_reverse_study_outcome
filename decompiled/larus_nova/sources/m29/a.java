package m29;

import com.larus.common.apphost.AppHost;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f511679a = false;

    static {
        f511679a = AppHost.f326268a.isDebug();
    }

    public static void a(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f511679a == true) goto L13;
        return;
    L13:
        FLogger r102 = FLogger.f375446a;     // Catch: Exception -> L10
        String r103 = "community_log_" + r100;     // Catch: Exception -> L10
        String r104 = (String) r101.invoke();     // Catch: Exception -> L10
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r102.d(r103, r104);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        g.f365738a.ensureNotReachHere(e);
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.e("community_log_".concat(r100), r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i("community_log_".concat(r100), r101);
    }
}
