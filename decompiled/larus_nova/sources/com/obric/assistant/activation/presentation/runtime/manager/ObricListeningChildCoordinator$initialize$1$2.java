package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.RemoteException;
import android.view.SurfaceControl;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningChildCoordinator$initialize$1$2 extends FunctionReferenceImpl implements Function4<SurfaceControl, Integer, Integer, Integer, Unit> {
    public ObricListeningChildCoordinator$initialize$1$2(Object r100) {
        super(4, r100, ObricListeningChildCoordinator.class, "onChildSurfaceAvailable", "onChildSurfaceAvailable(Landroid/view/SurfaceControl;III)V", 0);
    }

    public final void invoke(SurfaceControl r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ObricListeningChildCoordinator r104 = (ObricListeningChildCoordinator) this.receiver;
        ObricListeningChildCoordinator r105 = ObricListeningChildCoordinator.f385289a;
        r104.getClass();
        if (ObricListeningChildCoordinator.f385305q == true) goto L5;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_surface_available_ignored: reason=child_not_owned");
        return;
    L5:
        IObricMainPresentationBridgeCallback r106 = ObricListeningChildCoordinator.f385297i;
        if (r106 != null) goto L12;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_surface_available_ignored: reason=callback_unavailable");
        return;
    L12:
        r106.onChildSurfaceChanged(r101, r102, r103, r100);     // Catch: RemoteException -> L10
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_surface_available_finished: generation=" + r101);     // Catch: RemoteException -> L10
        return;
    L10:
        FLogger.f375446a.w("ObricListeningChildCoordinator", "child_surface_available_failed: reason=remote_exception");
        ObricListeningChildCoordinator.a(r106.asBinder());
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(SurfaceControl r100, Integer r101, Integer r102, Integer r103) {
        invoke(r100, r101.intValue(), r102.intValue(), r103.intValue());
        return Unit.INSTANCE;
    }
}
