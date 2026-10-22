package com.larus.dora.impl.device.settings.lab.env;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class l implements r49.a {
    public /* synthetic */ l() {
    }

    public final void a(long r100, Function0 r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        BuildersKt.launch$default(DoraEnvObserveManager.f334596d, null, null, new DoraEnvObserveManager$mTemporaryOverrideController$2$2$1(r100, r110, null), 3, null);
    }
}
