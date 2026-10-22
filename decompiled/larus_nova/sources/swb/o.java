package swb;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class o {
    public static void a(String r100, Throwable r101) {
        String r102 = "ReportCrashUtils_" + r100;
        int r103 = com.ss.android.lark.officesdk.utils.di.j.f437226a;
        Intrinsics.checkNotNullParameter(r102, "tag");
        Intrinsics.checkNotNullParameter(r102, "tag");
        DependencyContainer r104 = DependencyContainer.f433166a;
        ntb.n r105 = (ntb.n) DependencyContainer.a(ntb.n.class, null);
        if (r105 == null) goto L6;
        r105.g(r102, "", r101, true);
        return;
    }
}
