package com.larus.dora.impl.onboarding.othersmart;

import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g0 implements Function1<TextView, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraExternalSmartOnboardingWakeupFragment f337145a;

    public g0(DoraExternalSmartOnboardingWakeupFragment r100) {
        this.f337145a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        DoraExternalSmartOnboardingWakeupFragment r101 = this.f337145a;
        int r102 = DoraExternalSmartOnboardingWakeupFragment.f337079s;
        r101.fa0();
        return Unit.INSTANCE;
    }
}
