package com.obric.assistant.onelogin;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class n implements com.ss.android.token.e {
    public n() {
    }

    @Override // com.ss.android.token.e
    public final void a(com.ss.android.token.d r100) {
        Intrinsics.checkNotNullParameter(r100, "logoutContent");
        FLogger.f375446a.i("ObricOneLoginImpl", "afterPassportLogout, logoutContent = " + r100);
    }

    @Override // com.ss.android.token.e
    public final void b(com.ss.android.token.d r100, Object r101, com.bytedance.sdk.account.impl.e r102) {
        Intrinsics.checkNotNullParameter(r100, "logoutContent");
        FLogger.f375446a.i("ObricOneLoginImpl", "beforePassportLogout, logoutContent = " + r100);
        r102.a(null, r101);
    }
}
