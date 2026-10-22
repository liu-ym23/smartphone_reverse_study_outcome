package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class a0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricInteractorPresentationBridgeService f385374a;

    public /* synthetic */ a0(IObricInteractorPresentationBridgeService r100) {
        this.f385374a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        IObricInteractorPresentationBridgeService r100 = this.f385374a;
        IObricInteractorPresentationBridgeService r101 = ObricListeningMainProcessManager.f385334e;
        if (r101 != null) goto L6;
        FLogger.f375446a.i("ObricListeningMainPM", "ignore bridge detach without current, expected=" + r100.asBinder().hashCode());
        return Unit.INSTANCE;
    L6:
        if (r101.asBinder() == r100.asBinder()) goto L8;
        FLogger.f375446a.i("ObricListeningMainPM", "ignore stale bridge detach, expected=" + r100.asBinder().hashCode() + ", current=" + r101.asBinder().hashCode());
        return Unit.INSTANCE;
    L8:
        ObricListeningMainProcessManager r102 = ObricListeningMainProcessManager.f385330a;
        Function1 r103 = new l1();
        r102.getClass();
        ObricListeningMainProcessManager.n("unregisterMain", r101, false, r103);
        ObricListeningMainProcessManager.f385334e = null;
        ObricListeningMainProcessManager.f385349t.set(null);
        ObricListeningMainProcessManager.f();
        FLogger.f375446a.i("ObricListeningMainPM", "interactor bridge detached");
        return Unit.INSTANCE;
    }
}
