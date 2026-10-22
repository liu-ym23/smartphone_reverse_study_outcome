package com.obric.assistant.login;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements v {
    public f() {
    }

    @Override // com.obric.assistant.login.v
    public final boolean a(ObricLoginType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != ObricLoginType.NONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.login.v
    public final void b(n38.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        FLogger.f375446a.i("ObricLoginDoubaoAccountEventStrategy", "NoneDoubaoAccountEventStrategy ignore doubao account online");
    }

    @Override // com.obric.assistant.login.v
    public final void c(n38.a r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "previousContext");
        FLogger.f375446a.i("ObricLoginDoubaoAccountEventStrategy", "NoneDoubaoAccountEventStrategy ignore doubao account offline");
    }
}
