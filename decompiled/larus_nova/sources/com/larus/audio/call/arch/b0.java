package com.larus.audio.call.arch;

import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class b0 implements Function1 {
    public /* synthetic */ b0() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        long r102 = SystemClock.elapsedRealtime();
        r101.V2();
        long r103 = SystemClock.elapsedRealtime() - r102;
        com.larus.audio.call.util.e.f289645a.i("LLMPluginContainer", "onAfterStart " + r101.T2() + " cost: " + r103);
        return Unit.INSTANCE;
    }
}
