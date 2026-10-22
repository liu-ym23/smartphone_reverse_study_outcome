package f2a;

import com.larus.utils.logger.LogLevel;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f475231a;

    public final c a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        return new c(this.f475231a, LogLevel.ERROR, r100);
    }

    public final c b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        return new c(this.f475231a, LogLevel.INFO, r100);
    }

    public final c c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "what");
        return new c(this.f475231a, LogLevel.WARN, r100);
    }

    public d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "subModule");
        this.f475231a = new h(r100 + '-' + r101);
    }
}
