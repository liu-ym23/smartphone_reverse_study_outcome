package com.larus.voicecall.impl.component.net;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements a {
    @Override // com.larus.voicecall.impl.component.net.a
    public final String getLogTag() {
        return "NormalNetViewState";
    }

    public e() {
    }

    @Override // com.larus.voicecall.impl.component.net.a
    public final void a(int r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "transitionTo");
        if (r100 != 4) goto L6;
        r101.invoke(new f());
        return;
    L6:
        if (r100 < 5) goto L10;
        r101.invoke(new p());
        return;
    }
}
