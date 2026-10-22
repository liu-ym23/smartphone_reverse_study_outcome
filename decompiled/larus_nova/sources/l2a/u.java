package l2a;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f507187a = false;

    static {
        f507187a = AppHost.f326268a.isDebug();
    }

    public static void a(com.larus.video.impl.sdk.g r100) {
        Intrinsics.checkNotNullParameter("TTVideoControllerImpl", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (f507187a == true) goto L13;
        return;
    L13:
        FLogger r101 = FLogger.f375446a;     // Catch: Exception -> L10
        String r102 = (String) r100.invoke();     // Catch: Exception -> L10
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r101.d("video_common_log_TTVideoControllerImpl", r102);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i("video_common_log_".concat(r100), r101);
    }
}
