package com.larus.voicecall.impl.component.net;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class p implements a {
    @Override // com.larus.voicecall.impl.component.net.a
    public final String getLogTag() {
        return "VeryPoorNetViewState";
    }

    public p() {
    }

    @Override // com.larus.voicecall.impl.component.net.a
    public final void a(int r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "transitionTo");
        if (r100 > 3) goto L6;
        r101.invoke(new e());
        return;
    }
}
