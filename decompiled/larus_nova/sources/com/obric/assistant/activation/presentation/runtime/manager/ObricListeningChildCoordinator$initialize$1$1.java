package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.RemoteException;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningChildCoordinator$initialize$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ObricListeningChildCoordinator$initialize$1$1(Object r100) {
        super(0, r100, ObricListeningChildCoordinator.class, "onChildWindowTimeout", "onChildWindowTimeout()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ObricListeningChildCoordinator r100 = (ObricListeningChildCoordinator) this.receiver;
        ObricListeningChildCoordinator r101 = ObricListeningChildCoordinator.f385289a;
        r100.getClass();
        if (ObricListeningChildCoordinator.f385305q == true) goto L5;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_window_timeout_ignored: reason=child_not_owned");
        return;
    L5:
        long r102 = ObricListeningChildCoordinator.f385312x.f385263a;
        IObricMainPresentationBridgeCallback r103 = ObricListeningChildCoordinator.f385297i;
        if (r103 != null) goto L13;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_window_timeout_notify_ignored: reason=callback_unavailable revision=" + r102);
    L11:
        ObricListeningChildCoordinator.d();
        return;
    L13:
        r103.onChildPresentationTimeout(r102);     // Catch: RemoteException -> L9
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_window_timeout_notified: revision=" + r102);     // Catch: RemoteException -> L9
    L9:
        FLogger.f375446a.w("ObricListeningChildCoordinator", "child_window_timeout_notify_failed: reason=remote_exception revision=" + r102);
        ObricListeningChildCoordinator.a(r103.asBinder());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
