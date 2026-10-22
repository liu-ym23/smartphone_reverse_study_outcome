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
public interface IDoraPrivateProtocolService extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IDoraPrivateProtocolService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
        public int getConnectionState() throws RemoteException {
            return 0;
        }

        @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
        public DoraDeviceInfo getCurrentDeviceInfo() throws RemoteException {
            return null;
        }

        @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
        public void registerCallback(IDoraPrivateProtocolCallback r100) throws RemoteException {
        }

        @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
        public void registerCallbackWithExtra(IDoraPrivateProtocolCallback r100, String r101) throws RemoteException {
        }

        @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
        public void syncBatteryChanged(DoraDeviceInfo r100) throws RemoteException {
        }

        @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
        public void syncChargeStateChanged(DoraDeviceInfo r100) throws RemoteException {
        }

        @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
        public void syncConnectionState(int r100, DoraDeviceInfo r101) throws RemoteException {
        }

        @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
        public void unregisterCallback(IDoraPrivateProtocolCallback r100) throws RemoteException {
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static abstract class Stub extends Binder implements IDoraPrivateProtocolService {
        private static final String DESCRIPTOR = "com.obric.assistant.dora.IDoraPrivateProtocolService";
        static final int TRANSACTION_getConnectionState = 3;
        static final int TRANSACTION_getCurrentDeviceInfo = 4;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerCallbackWithExtra = 8;
        static final int TRANSACTION_syncBatteryChanged = 6;
        static final int TRANSACTION_syncChargeStateChanged = 7;
        static final int TRANSACTION_syncConnectionState = 5;
        static final int TRANSACTION_unregisterCallback = 2;

        public static class Proxy implements IDoraPrivateProtocolService {
            public static IDoraPrivateProtocolService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
            public int getConnectionState() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getConnectionState();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
            public DoraDeviceInfo getCurrentDeviceInfo() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                DoraDeviceInfo r102 = DoraDeviceInfo.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DoraDeviceInfo r103 = Stub.getDefaultImpl().getCurrentDeviceInfo();     // Catch: Throwable -> L17
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

            @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
            public void registerCallback(IDoraPrivateProtocolCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallback(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
            public void syncBatteryChanged(DoraDeviceInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().syncBatteryChanged(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
            public void syncChargeStateChanged(DoraDeviceInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().syncChargeStateChanged(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
            public void unregisterCallback(IDoraPrivateProtocolCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCallback(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
            public void registerCallbackWithExtra(IDoraPrivateProtocolCallback r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r104 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L17
                r102.writeString(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallbackWithExtra(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = null;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.assistant.dora.IDoraPrivateProtocolService
            public void syncConnectionState(int r100, DoraDeviceInfo r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().syncConnectionState(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_assistant_dora_IDoraPrivateProtocolService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IDoraPrivateProtocolService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDoraPrivateProtocolService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDoraPrivateProtocolService) == false) goto L12;
            return (IDoraPrivateProtocolService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IDoraPrivateProtocolService r100) {
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
            if (r100 == 1598968902) goto L36;
            DoraDeviceInfo r104 = null;
            switch(r100) {
                case 1: goto L34;
                case 2: goto L32;
                case 3: goto L30;
                case 4: goto L25;
                case 5: goto L20;
                case 6: goto L15;
                case 7: goto L10;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            registerCallbackWithExtra(IDoraPrivateProtocolCallback.Stub.asInterface(r101.readStrongBinder()), r101.readString());
            r102.writeNoException();
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L13;
            r104 = DoraDeviceInfo.CREATOR.createFromParcel(r101);
        L13:
            syncChargeStateChanged(r104);
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L18;
            r104 = DoraDeviceInfo.CREATOR.createFromParcel(r101);
        L18:
            syncBatteryChanged(r104);
            r102.writeNoException();
            return true;
        L20:
            r101.enforceInterface(DESCRIPTOR);
            int r105 = r101.readInt();
            if (r101.readInt() == 0) goto L23;
            r104 = DoraDeviceInfo.CREATOR.createFromParcel(r101);
        L23:
            syncConnectionState(r105, r104);
            r102.writeNoException();
            return true;
        L25:
            r101.enforceInterface(DESCRIPTOR);
            DoraDeviceInfo r106 = getCurrentDeviceInfo();
            r102.writeNoException();
            if (r106 == null) goto L28;
            r102.writeInt(1);
            r106.writeToParcel(r102, 1);
        L29:
            return true;
        L28:
            r102.writeInt(0);
            goto L29
        L30:
            r101.enforceInterface(DESCRIPTOR);
            int r107 = getConnectionState();
            r102.writeNoException();
            r102.writeInt(r107);
            return true;
        L32:
            r101.enforceInterface(DESCRIPTOR);
            unregisterCallback(IDoraPrivateProtocolCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L34:
            r101.enforceInterface(DESCRIPTOR);
            registerCallback(IDoraPrivateProtocolCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L36:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getConnectionState() throws RemoteException;

    DoraDeviceInfo getCurrentDeviceInfo() throws RemoteException;

    void registerCallback(IDoraPrivateProtocolCallback r100) throws RemoteException;

    void registerCallbackWithExtra(IDoraPrivateProtocolCallback r100, String r101) throws RemoteException;

    void syncBatteryChanged(DoraDeviceInfo r100) throws RemoteException;

    void syncChargeStateChanged(DoraDeviceInfo r100) throws RemoteException;

    void syncConnectionState(int r100, DoraDeviceInfo r101) throws RemoteException;

    void unregisterCallback(IDoraPrivateProtocolCallback r100) throws RemoteException;
}
