package com.larus.init.task.experiment;

import com.larus.platform.api.b;
import com.larus.platform.api.c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.larus.platform.api.b
    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        FlowClientExperimentSettingsRuntime r101 = FlowClientExperimentSettingsRuntime.f351218a;
        String r102 = r100.f364876b;
        r101.getClass();
        if (StringsKt.isBlank(r102) == false) goto L5;
        r102 = "anonymous";
    L5:
        FlowClientExperimentSettingsRuntime.i(r102, "onUserDidOnline");
    }

    @Override // com.larus.platform.api.b
    public final void b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        FlowClientExperimentSettingsRuntime.f351218a.getClass();
        StringsKt.isBlank("anonymous");
        FlowClientExperimentSettingsRuntime.i("anonymous", "onUserDidOffline");
    }
}
