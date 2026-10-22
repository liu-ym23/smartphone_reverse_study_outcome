package com.obric.cae.libs.bluetooth.exporter;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface ICaeBluetoothExporter extends IInterface {

    public static class Default implements ICaeBluetoothExporter {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public int getProductId(BluetoothDevice r100) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public void registerEventCallback(ICaeBluetoothCallbackExporter r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
        public void unregisterEventCallback(ICaeBluetoothCallbackExporter r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeBluetoothExporter {
        private static final String DESCRIPTOR = "com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter";
        static final int TRANSACTION_getDeviceType = 4;
        static final int TRANSACTION_getProductId = 3;
        static final int TRANSACTION_registerEventCallback = 1;
        static final int TRANSACTION_unregisterEventCallback = 2;

        public static class Proxy implements ICaeBluetoothExporter {
            public static ICaeBluetoothExporter sDefaultImpl;
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_exporter_ICaeBluetoothExporter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L21
                if (r102.readInt() == 0) goto L18;
                BtDeviceInfoExtEvent r103 = BtDeviceInfoExtEvent.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L21
            L19:
                r102.recycle();
                r101.recycle();
                return r103;
            L18:
                r103 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                BtDeviceInfoExtEvent r104 = Stub.getDefaultImpl().getDeviceType(r100);     // Catch: Throwable -> L21
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public int getProductId(BluetoothDevice r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_exporter_ICaeBluetoothExporter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L10;
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public void registerEventCallback(ICaeBluetoothCallbackExporter r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_exporter_ICaeBluetoothExporter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
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

            @Override // com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter
            public void unregisterEventCallback(ICaeBluetoothCallbackExporter r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_bluetooth_exporter_ICaeBluetoothExporter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_bluetooth_exporter_ICaeBluetoothExporter$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICaeBluetoothExporter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeBluetoothExporter asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICaeBluetoothExporter) == false) goto L12;
            return (ICaeBluetoothExporter) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICaeBluetoothExporter r100) {
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
            if (r100 == 1598968902) goto L30;
            if (r100 != 1) goto L6;
            r101.enforceInterface(DESCRIPTOR);
            registerEventCallback(ICaeBluetoothCallbackExporter.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L6:
            if (r100 == 2) goto L26;
            BluetoothDevice r104 = null;
            if (r100 != 3) goto L10;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L24;
            r104 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r101);
        L24:
            int r105 = getProductId(r104);
            r102.writeNoException();
            r102.writeInt(r105);
            return true;
        L10:
            if (r100 != 4) goto L12;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L16;
            r104 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(r101);
        L16:
            BtDeviceInfoExtEvent r106 = getDeviceType(r104);
            r102.writeNoException();
            if (r106 == null) goto L19;
            r102.writeInt(1);
            r106.writeToParcel(r102, 1);
        L20:
            return true;
        L19:
            r102.writeInt(0);
            goto L20
        L12:
            return super.onTransact(r100, r101, r102, r103);
        L26:
            r101.enforceInterface(DESCRIPTOR);
            unregisterEventCallback(ICaeBluetoothCallbackExporter.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L30:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r100) throws RemoteException;

    int getProductId(BluetoothDevice r100) throws RemoteException;

    void registerEventCallback(ICaeBluetoothCallbackExporter r100) throws RemoteException;

    void unregisterEventCallback(ICaeBluetoothCallbackExporter r100) throws RemoteException;
}
