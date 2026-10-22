package x8;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.ss.android.agilelogger.ALog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements d {
    public c() {
    }

    @Override // x8.d
    public final void e(String r100, Throwable r101) {
        HybridLogger r102 = HybridLogger.f246343a;
        String r103 = "unknown";
        if (r100 != null) goto L5;
        String r104 = "unknown";
    L6:
        if (r101 == null) goto L12;
        String r105 = r101.getMessage();
        if (r105 == null) goto L12;
        r103 = r105;
    L12:
        if (HybridLogger.c(r104, r103, LogLevel.E) == false) goto L14;
        return;
    L14:
        ALog.e(r100, r101);
        return;
    L5:
        r104 = r100;
        goto L6
    }

    @Override // x8.d
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HybridLogger r102 = HybridLogger.f246343a;
        if (HybridLogger.c(r100, r101, LogLevel.I) == false) goto L5;
        return;
    L5:
        ALog.i(r100, r101);
    }

    @Override // x8.d
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        HybridLogger r102 = HybridLogger.f246343a;
        if (HybridLogger.c(r100, r101, LogLevel.E) == false) goto L5;
        return;
    L5:
        ALog.e(r100, r101);
    }
}
