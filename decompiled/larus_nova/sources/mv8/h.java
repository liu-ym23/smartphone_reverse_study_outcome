package mv8;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements zc.a {
    public h() {
    }

    @Override // zc.a
    public final boolean isReady() {
        return FLogger.f375446a.a();
    }

    @Override // zc.f
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.d(r100, r101);
    }

    @Override // zc.f
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.e(r100, r101);
    }

    @Override // zc.f
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i(r100, r101);
    }
}
