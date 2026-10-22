package com.larus.dora.impl.onboarding.lite;

import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class q0 implements Function1<TextView, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraLiteOnboardingWakeupFragment f336991a;

    public q0(DoraLiteOnboardingWakeupFragment r100) {
        this.f336991a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        DoraLiteOnboardingWakeupFragment r101 = this.f336991a;
        int r102 = DoraLiteOnboardingWakeupFragment.f336916s;
        r101.ea0();
        return Unit.INSTANCE;
    }
}
