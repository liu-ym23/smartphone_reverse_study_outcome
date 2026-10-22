package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.RemoteException;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningChildCoordinator$initialize$1$4 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public ObricListeningChildCoordinator$initialize$1$4(Object r100) {
        super(1, r100, ObricListeningChildCoordinator.class, "onChildSurfaceDestroyed", "onChildSurfaceDestroyed(I)V", 0);
    }

    public final void invoke(int r100) {
        ObricListeningChildCoordinator r101 = (ObricListeningChildCoordinator) this.receiver;
        ObricListeningChildCoordinator r102 = ObricListeningChildCoordinator.f385289a;
        r101.getClass();
        IObricMainPresentationBridgeCallback r103 = ObricListeningChildCoordinator.f385297i;
        if (r103 != null) goto L9;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_surface_destroyed_ignored: reason=callback_unavailable");
        return;
    L9:
        r103.onChildSurfaceDestroyed(r100);     // Catch: RemoteException -> L7
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_surface_destroyed_finished: generation=" + r100);     // Catch: RemoteException -> L7
        return;
    L7:
        FLogger.f375446a.w("ObricListeningChildCoordinator", "child_surface_destroyed_failed: reason=remote_exception");
        ObricListeningChildCoordinator.a(r103.asBinder());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}
