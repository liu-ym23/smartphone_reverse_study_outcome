package com.obric.assistant.login;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class e implements t {
    public e() {
    }

    @Override // com.obric.assistant.login.t
    public final boolean a(ObricLoginType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != ObricLoginType.NONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.login.t
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "businessScene");
        FLogger.f375446a.i("ObricLoginConsistencyStrategy", "NoneAccountConsistencyStrategy ignore O account consistency recover");
    }
}
