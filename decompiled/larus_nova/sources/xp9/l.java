package xp9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements com.larus.business.markdown.api.depend.c {
    public l() {
    }

    @Override // com.larus.business.markdown.api.depend.c
    public final void ensureNotReachHere(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "msg");
        com.larus.platform.service.g.f365738a.ensureNotReachHere(r100, r101);
    }
}
