package dt8;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f470008a = 0;

    static {
        AppHost.f326268a.isDebugChannel();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter("CustomActionBarSpringReportStrategy", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        FLogger.f375446a.i("actionbar_log_CustomActionBarSpringReportStrategy", r100);
    }
}
