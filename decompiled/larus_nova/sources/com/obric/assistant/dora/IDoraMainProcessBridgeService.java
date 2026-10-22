package com.obric.assistant.dora;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IDoraMainProcessBridgeService extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IDoraMainProcessBridgeService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.assistant.dora.IDoraMainProcessBridgeService
        public void checkBindAndConnectIfNecessaryAsync(DoraDeviceInfo r100, String r101, IDoraMainProcessConnectCallback r102) throws RemoteException {
        }

        @Override // com.obric.assistant.dora.IDoraMainProcessBridgeService
        public DoraMainProcessStateSnapshot getStateSnapshot() throws RemoteException {
            return null;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static abstract class Stub extends Binder implements IDoraMainProcessBridgeService {
        private static final String DESCRIPTOR = "com.obric.assistant.dora.IDoraMainProcessBridgeService";
        static final int TRANSACTION_checkBindAndConnectIfNecessaryAsync = 2;
        static final int TRANSACTION_getStateSnapshot = 1;

        /* JADX INFO: loaded from: classes33.dex */
        public static class Proxy implements IDoraMainProcessBridgeService {
            public static IDoraMainProcessBridgeService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.assistant.dora.IDoraMainProcessBridgeService
            public DoraMainProcessStateSnapshot getStateSnapshot() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraMainProcessBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                DoraMainProcessStateSnapshot r102 = DoraMainProcessStateSnapshot.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DoraMainProcessStateSnapshot r103 = Stub.getDefaultImpl().getStateSnapshot();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
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

            @Override // com.obric.assistant.dora.IDoraMainProcessBridgeService
            public void checkBindAndConnectIfNecessaryAsync(DoraDeviceInfo r100, String r101, IDoraMainProcessConnectCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L21
            L7:
                r103.writeString(r101);     // Catch: Throwable -> L21
                if (r102 == null) goto L10;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L21
            L11:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraMainProcessBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().checkBindAndConnectIfNecessaryAsync(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L10:
                r105 = null;
                goto L11
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_assistant_dora_IDoraMainProcessBridgeService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IDoraMainProcessBridgeService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDoraMainProcessBridgeService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDoraMainProcessBridgeService) == false) goto L12;
            return (IDoraMainProcessBridgeService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IDoraMainProcessBridgeService r100) {
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
            DoraMainProcessStateSnapshot r104 = getStateSnapshot();
            r102.writeNoException();
            if (r104 == null) goto L21;
            r102.writeInt(1);
            r104.writeToParcel(r102, 1);
        L22:
            return true;
        L21:
            r102.writeInt(0);
            goto L22
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L15;
            DoraDeviceInfo r105 = DoraDeviceInfo.CREATOR.createFromParcel(r101);
        L16:
            checkBindAndConnectIfNecessaryAsync(r105, r101.readString(), IDoraMainProcessConnectCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L15:
            r105 = null;
            goto L16
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void checkBindAndConnectIfNecessaryAsync(DoraDeviceInfo r100, String r101, IDoraMainProcessConnectCallback r102) throws RemoteException;

    DoraMainProcessStateSnapshot getStateSnapshot() throws RemoteException;
}
