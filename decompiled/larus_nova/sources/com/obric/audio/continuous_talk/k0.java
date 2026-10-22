package com.obric.audio.continuous_talk;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class k0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hia.a f395184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObricContinuousTalkUIComponent f395185b;

    public /* synthetic */ k0(hia.a r100, ObricContinuousTalkUIComponent r101) {
        this.f395184a = r100;
        this.f395185b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        hia.a r101 = this.f395184a;
        final ObricContinuousTalkUIComponent r102 = this.f395185b;
        int r103 = ObricContinuousTalkUIComponent.M;
        Intrinsics.checkNotNullParameter((hia.a.d) r100, "it");
        hia.c.a(r101);
        if (r102.f395121n != r101) goto L5;
        r102.f395121n = null;
        r102.F = ContinuousTalkStatus.STOPPED;
        com.larus.utils.t0.e(new m0(r102));
    L7:
        return Unit.INSTANCE;
    L5:
        FLogger.f375446a.i("ObricContinuousTalkUIComponent", "skip clearing replaced session after stopAsync");
        goto L7
    }
}
