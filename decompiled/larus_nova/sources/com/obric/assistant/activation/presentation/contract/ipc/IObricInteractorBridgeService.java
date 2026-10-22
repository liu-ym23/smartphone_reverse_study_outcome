package com.obric.assistant.activation.presentation.contract.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public interface IObricInteractorBridgeService extends IInterface {

    public static class Default implements IObricInteractorBridgeService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
        public IInteractionSessionProxy getInteractionSessionProxy() throws RemoteException {
            return null;
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
        public void registerPresentationBridge(IBinder r100) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
        public void unregisterPresentationBridge(IBinder r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IObricInteractorBridgeService {
        private static final String DESCRIPTOR = "com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService";
        static final int TRANSACTION_getInteractionSessionProxy = 1;
        static final int TRANSACTION_registerPresentationBridge = 2;
        static final int TRANSACTION_unregisterPresentationBridge = 3;

        public static class Proxy implements IObricInteractorBridgeService {
            public static IObricInteractorBridgeService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
            public IInteractionSessionProxy getInteractionSessionProxy() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IInteractionSessionProxy r102 = IInteractionSessionProxy.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IInteractionSessionProxy r103 = Stub.getDefaultImpl().getInteractionSessionProxy();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
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

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
            public void registerPresentationBridge(IBinder r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStrongBinder(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().registerPresentationBridge(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService
            public void unregisterPresentationBridge(IBinder r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStrongBinder(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterPresentationBridge(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricInteractorBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IObricInteractorBridgeService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IObricInteractorBridgeService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IObricInteractorBridgeService) == false) goto L12;
            return (IObricInteractorBridgeService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IObricInteractorBridgeService r100) {
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
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            IInteractionSessionProxy r104 = getInteractionSessionProxy();
            r102.writeNoException();
            if (r104 == null) goto L21;
            IBinder r105 = r104.asBinder();
        L22:
            r102.writeStrongBinder(r105);
            return true;
        L21:
            r105 = null;
            goto L22
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            registerPresentationBridge(r101.readStrongBinder());
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            unregisterPresentationBridge(r101.readStrongBinder());
            r102.writeNoException();
            return true;
        L9:
            if (r100 != 1598968902) goto L11;
            r102.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    IInteractionSessionProxy getInteractionSessionProxy() throws RemoteException;

    void registerPresentationBridge(IBinder r100) throws RemoteException;

    void unregisterPresentationBridge(IBinder r100) throws RemoteException;
}
