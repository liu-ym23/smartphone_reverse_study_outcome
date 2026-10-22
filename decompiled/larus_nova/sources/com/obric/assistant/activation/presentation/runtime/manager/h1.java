package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class h1 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f385397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f385398b;

    public /* synthetic */ h1(String r100, boolean r101) {
        this.f385397a = r100;
        this.f385398b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        final String r100 = this.f385397a;
        boolean r101 = this.f385398b;
        AssistantStartupTelemetry r102 = AssistantStartupTelemetry.f392915a;
        if (Intrinsics.areEqual(r102.h(), r100) == true) goto L15;
        ObricListeningMainProcessManager.b r103 = ObricListeningMainProcessManager.f385350u;
        if (r103 == null) goto L7;
        String r104 = r103.f385358b;
    L9:
        if (Intrinsics.areEqual(r104, r100) == false) goto L12;
        ObricListeningMainProcessManager.f385350u = null;
    L12:
        if (Intrinsics.areEqual(ObricListeningMainProcessManager.f385351v, r100) == false) goto L14;
        ObricListeningMainProcessManager.f385351v = null;
    L14:
        FLogger.f375446a.g("ObricListeningMainPM", new j0(r100));
        return Unit.INSTANCE;
    L7:
        r104 = null;
        goto L9
    L15:
        if (r101 == false) goto L17;
        ObricListeningMainProcessManager.f385351v = r100;
    L17:
        ObricListeningMainProcessManager.b r105 = ObricListeningMainProcessManager.f385350u;
        if (r105 != null) goto L21;
        return Unit.INSTANCE;
    L21:
        if (Intrinsics.areEqual(r105.f385358b, r100) == true) goto L24;
        return Unit.INSTANCE;
    L24:
        if (Intrinsics.areEqual(r102.i("window_content_ready"), r100) == true) goto L27;
        if (r101 == true) goto L27;
        ObricListeningMainProcessManager.f385350u = null;
        FLogger.f375446a.g("ObricListeningMainPM", new k0(r100));
        return Unit.INSTANCE;
    L27:
        ObricListeningMainProcessManager.f385330a.getClass();
        ObricListeningMainProcessManager.a(r105, r101);
        return Unit.INSTANCE;
    }
}
