package com.larus.audio.call;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class o extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f289268g;

    @Override // com.larus.audio.call.p
    public final void c(long r100) {
    }

    @Override // com.larus.audio.call.p
    public final void b() {
        this.f289268g.invoke();
    }

    public o(long r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onFinish");
        super(r100, r100);
        this.f289268g = r101;
    }
}
