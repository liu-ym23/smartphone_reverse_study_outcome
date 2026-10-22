package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class p0 implements Function0 {
    public /* synthetic */ p0() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ObricListeningMainProcessManager r100 = ObricListeningMainProcessManager.f385330a;
        Function0 r101 = new s0();
        r100.getClass();
        if (ObricListeningMainProcessManager.c("listening-start confirmation", r101) == false) goto L6;
        return Unit.INSTANCE;
    L6:
        if (ObricListeningMainProcessManager.f385335f == true) goto L8;
    L16:
        FLogger.f375446a.i("ObricListeningMainPM", "ignore listening-start confirmation, owned=" + ObricListeningMainProcessManager.f385335f + ", finishing=" + ObricListeningMainProcessManager.f385345p + ", confirmed=" + ObricListeningMainProcessManager.f385337h);
        return Unit.INSTANCE;
    L8:
        if (ObricListeningMainProcessManager.f385345p == true) goto L16;
        if (ObricListeningMainProcessManager.f385337h == true) goto L16;
        ObricListeningMainProcessManager.f385337h = true;
        FLogger.f375446a.i("ObricListeningMainPM", "confirm real listening started");
        IObricInteractorPresentationBridgeService r102 = ObricListeningMainProcessManager.f385334e;
        if (r102 == null) goto L19;
        ObricListeningMainProcessManager.n("confirmListeningStarted", r102, true, new t0());
    L19:
        return Unit.INSTANCE;
    }
}
