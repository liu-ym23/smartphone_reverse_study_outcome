package yga;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c implements kaa.a {
    public c() {
    }

    @Override // kaa.a
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.d(r100, r101);
    }

    @Override // kaa.a
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i(r100, r101);
    }

    @Override // kaa.a
    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.v(r100, r101);
    }

    @Override // kaa.a
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.e(r100, r101, r102);
    }

    @Override // kaa.a
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.w(r100, r101, r102);
    }
}
