package mg9;

import com.larus.common.apphost.AppHost;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f513817a = false;

    static {
        f513817a = AppHost.f326268a.isTestChannel();
    }

    public static void a(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f513817a == true) goto L13;
        return;
    L13:
        FLogger r102 = FLogger.f375446a;     // Catch: Exception -> L10
        String r103 = "instruction_log_".concat(r100);     // Catch: Exception -> L10
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
}
