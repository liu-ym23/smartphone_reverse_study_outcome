package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.AttributionSource;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface ICaeBluetooth extends IInterface {

    public static class Default implements ICaeBluetooth {
        public Default() {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToDatabase(String r100, BluetoothDevice r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void addDeviceToStaticExtDatabase(String r100, BluetoothDevice r101) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public BdimPredictEvent getBdimEvent(BluetoothDevice r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public int getProductId(BluetoothDevice r100) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void registerEventCallback(ICaeBluetoothEventCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromDatabase(String r100, BluetoothDevice r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void removeDeviceFromStaticExtDatabase(String r100, BluetoothDevice r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void requestLeConnectionPriority(int r100, AttributionSource r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setHARStatusChanged(int r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setLocationState(String r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void setModelPredictType(BluetoothDevice r100, String r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
        public void unregisterEventCallback(ICaeBluetoothEventCallback r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeBluetooth {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.ICaeBluetooth";
        static final int TRANSACTION_addDeviceToDatabase = 3;
        static final int TRANSACTION_addDeviceToStaticExtDatabase = 6;
        static final int TRANSACTION_getBdimEvent = 10;
        static final int TRANSACTION_getProductId = 8;
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_removeDeviceFromDatabase = 4;
        static final int TRANSACTION_removeDeviceFromStaticExtDatabase = 7;
        static final int TRANSACTION_requestLeConnectionPriority = 5;
        static final int TRANSACTION_setHARStatusChanged = 11;
        static final int TRANSACTION_setLocationState = 12;
        static final int TRANSACTION_setModelPredictType = 9;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements ICaeBluetooth {
            public static ICaeBluetooth sDefaultImpl;
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public BdimPredictEvent getBdimEvent(BluetoothDevice r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L21
                if (r102.readInt() == 0) goto L18;
                BdimPredictEvent r103 = BdimPredictEvent.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L21
            L19:
                r102.recycle();
                r101.recycle();
                return r103;
            L18:
                r103 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                BdimPredictEvent r104 = Stub.getDefaultImpl().getBdimEvent(r100);     // Catch: Throwable -> L21
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public int getProductId(BluetoothDevice r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                int r103 = r102.readInt();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r104 = Stub.getDefaultImpl().getProductId(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void registerEventCallback(ICaeBluetoothEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerEventCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setHARStatusChanged(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHARStatusChanged(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setLocationState(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setLocationState(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void unregisterEventCallback(ICaeBluetoothEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterEventCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToDatabase(String r100, BluetoothDevice r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDeviceToDatabase(r100, r101);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void addDeviceToStaticExtDatabase(String r100, BluetoothDevice r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDeviceToStaticExtDatabase(r100, r101);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromDatabase(String r100, BluetoothDevice r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDeviceFromDatabase(r100, r101);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void removeDeviceFromStaticExtDatabase(String r100, BluetoothDevice r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDeviceFromStaticExtDatabase(r100, r101);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void requestLeConnectionPriority(int r100, AttributionSource r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestLeConnectionPriority(r100, r101);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.bluetooth.ICaeBluetooth
            public void setModelPredictType(BluetoothDevice r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L7:
                r102.writeString(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setModelPredictType(r100, r101);     // Catch: Throwable -> L17
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
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_bluetooth_ICaeBluetooth$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICaeBluetooth getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeBluetooth asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICaeBluetooth) == false) goto L12;
            return (ICaeBluetooth) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICaeBluetooth r100) {
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
            if (r100 == 1598968902) goto L59;
            BluetoothDevice r104 = null;
            BluetoothDevice r105 = null;
            BluetoothDevice r106 = null;
            BluetoothDevice r107 = null;
            BluetoothDevice r108 = null;
            BluetoothDevice r109 = null;
            AttributionSource r110 = null;
            BluetoothDevice r111 = null;
            switch(r100) {
                case 1: goto L57;
                case 2: goto L55;
                case 3: goto L50;
                case 4: goto L45;
                case 5: goto L40;
                case 6: goto L35;
                case 7: goto L30;
                case 8: goto L25;
                case 9: goto L20;
                case 10: goto L12;
                case 11: goto L10;
                case 12: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            setLocationState(r101.readString());
            r102.writeNoException();
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            setHARStatusChanged(r101.readInt());
            r102.writeNoException();
            return true;
        L12:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L15;
            r105 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r101);
        L15:
            BdimPredictEvent r112 = getBdimEvent(r105);
            r102.writeNoException();
            if (r112 == null) goto L18;
            r102.writeInt(1);
            r112.writeToParcel(r102, 1);
        L19:
            return true;
        L18:
            r102.writeInt(0);
            goto L19
        L20:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L23;
            r106 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r101);
        L23:
            setModelPredictType(r106, r101.readString());
            r102.writeNoException();
            return true;
        L25:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L28;
            r107 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r101);
        L28:
            int r113 = getProductId(r107);
            r102.writeNoException();
            r102.writeInt(r113);
            return true;
        L30:
            r101.enforceInterface(DESCRIPTOR);
            String r114 = r101.readString();
            if (r101.readInt() == 0) goto L33;
            r108 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r101);
        L33:
            removeDeviceFromStaticExtDatabase(r114, r108);
            r102.writeNoException();
            return true;
        L35:
            r101.enforceInterface(DESCRIPTOR);
            String r115 = r101.readString();
            if (r101.readInt() == 0) goto L38;
            r109 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r101);
        L38:
            addDeviceToStaticExtDatabase(r115, r109);
            r102.writeNoException();
            return true;
        L40:
            r101.enforceInterface(DESCRIPTOR);
            int r116 = r101.readInt();
            if (r101.readInt() == 0) goto L43;
            r110 = (AttributionSource) AttributionSource.CREATOR.createFromParcel(r101);
        L43:
            requestLeConnectionPriority(r116, r110);
            r102.writeNoException();
            return true;
        L45:
            r101.enforceInterface(DESCRIPTOR);
            String r117 = r101.readString();
            if (r101.readInt() == 0) goto L48;
            r111 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r101);
        L48:
            removeDeviceFromDatabase(r117, r111);
            r102.writeNoException();
            return true;
        L50:
            r101.enforceInterface(DESCRIPTOR);
            String r118 = r101.readString();
            if (r101.readInt() == 0) goto L53;
            r104 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r101);
        L53:
            addDeviceToDatabase(r118, r104);
            r102.writeNoException();
            return true;
        L55:
            r101.enforceInterface(DESCRIPTOR);
            unregisterEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L57:
            r101.enforceInterface(DESCRIPTOR);
            registerEventCallback(ICaeBluetoothEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L59:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addDeviceToDatabase(String r100, BluetoothDevice r101) throws RemoteException;

    void addDeviceToStaticExtDatabase(String r100, BluetoothDevice r101) throws RemoteException;

    BdimPredictEvent getBdimEvent(BluetoothDevice r100) throws RemoteException;

    int getProductId(BluetoothDevice r100) throws RemoteException;

    void registerEventCallback(ICaeBluetoothEventCallback r100) throws RemoteException;

    void removeDeviceFromDatabase(String r100, BluetoothDevice r101) throws RemoteException;

    void removeDeviceFromStaticExtDatabase(String r100, BluetoothDevice r101) throws RemoteException;

    void requestLeConnectionPriority(int r100, AttributionSource r101) throws RemoteException;

    void setHARStatusChanged(int r100) throws RemoteException;

    void setLocationState(String r100) throws RemoteException;

    void setModelPredictType(BluetoothDevice r100, String r101) throws RemoteException;

    void unregisterEventCallback(ICaeBluetoothEventCallback r100) throws RemoteException;
}
