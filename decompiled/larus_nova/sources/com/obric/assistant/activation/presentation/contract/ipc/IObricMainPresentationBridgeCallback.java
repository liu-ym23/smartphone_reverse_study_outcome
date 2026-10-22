package com.obric.assistant.activation.presentation.contract.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.SurfaceControl;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public interface IObricMainPresentationBridgeCallback extends IInterface {

    public static class Default implements IObricMainPresentationBridgeCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
        public void onChildFirstFrameReady(int r100, String r101, long r102) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
        public void onChildPresentationTimeout(long r100) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
        public void onChildSurfaceChanged(int r100, int r101, int r102, SurfaceControl r103) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
        public void onChildSurfaceDestroyed(int r100) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
        public void onFallbackStateChanged(boolean r100, ObricListeningPresentationState r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IObricMainPresentationBridgeCallback {
        private static final String DESCRIPTOR = "com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback";
        static final int TRANSACTION_onChildFirstFrameReady = 4;
        static final int TRANSACTION_onChildPresentationTimeout = 5;
        static final int TRANSACTION_onChildSurfaceChanged = 2;
        static final int TRANSACTION_onChildSurfaceDestroyed = 3;
        static final int TRANSACTION_onFallbackStateChanged = 1;

        public static class Proxy implements IObricMainPresentationBridgeCallback {
            public static IObricMainPresentationBridgeCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
            public void onChildPresentationTimeout(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeLong(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onChildPresentationTimeout(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
            public void onChildSurfaceDestroyed(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onChildSurfaceDestroyed(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
            public void onFallbackStateChanged(boolean r100, ObricListeningPresentationState r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r102.writeInt(r103);     // Catch: Throwable -> L20
                if (r101 == null) goto L10;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L12:
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1) == false) goto L14;
            L18:
                r102.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().onFallbackStateChanged(r100, r101);     // Catch: Throwable -> L20
                r102.recycle();
                return;
            L10:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L12
            L6:
                r103 = 0;
            L20:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
            public void onChildFirstFrameReady(int r100, String r101, long r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r103.writeInt(r100);     // Catch: Throwable -> L12
                r103.writeString(r101);     // Catch: Throwable -> L12
                r103.writeLong(r102);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, null, 1) == false) goto L6;
            L10:
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onChildFirstFrameReady(r100, r101, r102);     // Catch: Throwable -> L12
                r103.recycle();
                return;
            L12:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback
            public void onChildSurfaceChanged(int r100, int r101, int r102, SurfaceControl r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r104.writeInt(r100);     // Catch: Throwable -> L16
                r104.writeInt(r101);     // Catch: Throwable -> L16
                r104.writeInt(r102);     // Catch: Throwable -> L16
                if (r103 == null) goto L6;
                r104.writeInt(1);     // Catch: Throwable -> L16
                r103.writeToParcel(r104, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r104, null, 1) == false) goto L10;
            L14:
                r104.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onChildSurfaceChanged(r100, r101, r102, r103);     // Catch: Throwable -> L16
                r104.recycle();
                return;
            L6:
                r104.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IObricMainPresentationBridgeCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IObricMainPresentationBridgeCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IObricMainPresentationBridgeCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IObricMainPresentationBridgeCallback) == false) goto L12;
            return (IObricMainPresentationBridgeCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IObricMainPresentationBridgeCallback r100) {
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
            ObricListeningPresentationState r104 = null;
            SurfaceControl r105 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L32;
            boolean r106 = true;
        L34:
            if (r101.readInt() == 0) goto L36;
            r104 = ObricListeningPresentationState.CREATOR.createFromParcel(r101);
        L36:
            onFallbackStateChanged(r106, r104);
            return true;
        L32:
            r106 = false;
            goto L34
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            int r107 = r101.readInt();
            int r108 = r101.readInt();
            int r109 = r101.readInt();
            if (r101.readInt() == 0) goto L27;
            r105 = (SurfaceControl) SurfaceControl.CREATOR.createFromParcel(r101);
        L27:
            onChildSurfaceChanged(r107, r108, r109, r105);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            onChildSurfaceDestroyed(r101.readInt());
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            onChildFirstFrameReady(r101.readInt(), r101.readString(), r101.readLong());
            return true;
        L11:
            if (r100 != 5) goto L13;
            r101.enforceInterface(DESCRIPTOR);
            onChildPresentationTimeout(r101.readLong());
            return true;
        L13:
            if (r100 != 1598968902) goto L15;
            r102.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onChildFirstFrameReady(int r100, String r101, long r102) throws RemoteException;

    void onChildPresentationTimeout(long r100) throws RemoteException;

    void onChildSurfaceChanged(int r100, int r101, int r102, SurfaceControl r103) throws RemoteException;

    void onChildSurfaceDestroyed(int r100) throws RemoteException;

    void onFallbackStateChanged(boolean r100, ObricListeningPresentationState r101) throws RemoteException;
}
