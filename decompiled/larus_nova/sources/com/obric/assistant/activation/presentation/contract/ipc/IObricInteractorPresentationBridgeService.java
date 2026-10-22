package com.obric.assistant.activation.presentation.contract.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public interface IObricInteractorPresentationBridgeService extends IInterface {

    public static class Default implements IObricInteractorPresentationBridgeService {
        public Default() {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void acknowledgeChildSurfaceLinked(int r100) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void acknowledgeGesture(int r100) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void confirmListeningStarted() throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void registerMain(IObricMainPresentationBridgeCallback r100) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void releaseChildSurfaceLink(int r100) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void unregisterMain(IObricMainPresentationBridgeCallback r100) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
        public void updateListeningState(ObricListeningPresentationState r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IObricInteractorPresentationBridgeService {
        private static final String DESCRIPTOR = "com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService";
        static final int TRANSACTION_acknowledgeChildSurfaceLinked = 6;
        static final int TRANSACTION_acknowledgeGesture = 3;
        static final int TRANSACTION_confirmListeningStarted = 4;
        static final int TRANSACTION_registerMain = 1;
        static final int TRANSACTION_releaseChildSurfaceLink = 7;
        static final int TRANSACTION_unregisterMain = 2;
        static final int TRANSACTION_updateListeningState = 5;

        public static class Proxy implements IObricInteractorPresentationBridgeService {
            public static IObricInteractorPresentationBridgeService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void confirmListeningStarted() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().confirmListeningStarted();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void acknowledgeChildSurfaceLinked(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().acknowledgeChildSurfaceLinked(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void acknowledgeGesture(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().acknowledgeGesture(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void registerMain(IObricMainPresentationBridgeCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerMain(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void releaseChildSurfaceLink(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().releaseChildSurfaceLink(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void unregisterMain(IObricMainPresentationBridgeCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterMain(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService
            public void updateListeningState(ObricListeningPresentationState r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateListeningState(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorPresentationBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r100 = SystemClock.uptimeMillis();
                boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
                long r102 = SystemClock.uptimeMillis() - r100;
                if (r102 < 100) goto L11;
                BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r101;
            L12:
                th = move-exception;
                long r103 = SystemClock.uptimeMillis() - r100;
                if (r103 < 100) goto L22;
                if (r110 != null) goto L17;
                String r104 = "";
            L18:
                BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r104 = r110.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r110.transact(r111, r112, r113, r114);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IObricInteractorPresentationBridgeService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IObricInteractorPresentationBridgeService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IObricInteractorPresentationBridgeService) == false) goto L12;
            return (IObricInteractorPresentationBridgeService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IObricInteractorPresentationBridgeService r100) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r100 == null) goto L7;
            Proxy.sDefaultImpl = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 == 1598968902) goto L25;
            switch(r100) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            releaseChildSurfaceLink(r101.readInt());
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            acknowledgeChildSurfaceLinked(r101.readInt());
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L14;
            ObricListeningPresentationState r104 = ObricListeningPresentationState.CREATOR.createFromParcel(r101);
        L15:
            updateListeningState(r104);
            return true;
        L14:
            r104 = null;
            goto L15
        L17:
            r101.enforceInterface(DESCRIPTOR);
            confirmListeningStarted();
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            acknowledgeGesture(r101.readInt());
            return true;
        L21:
            r101.enforceInterface(DESCRIPTOR);
            unregisterMain(IObricMainPresentationBridgeCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L23:
            r101.enforceInterface(DESCRIPTOR);
            registerMain(IObricMainPresentationBridgeCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L25:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void acknowledgeChildSurfaceLinked(int r100) throws RemoteException;

    void acknowledgeGesture(int r100) throws RemoteException;

    void confirmListeningStarted() throws RemoteException;

    void registerMain(IObricMainPresentationBridgeCallback r100) throws RemoteException;

    void releaseChildSurfaceLink(int r100) throws RemoteException;

    void unregisterMain(IObricMainPresentationBridgeCallback r100) throws RemoteException;

    void updateListeningState(ObricListeningPresentationState r100) throws RemoteException;
}
