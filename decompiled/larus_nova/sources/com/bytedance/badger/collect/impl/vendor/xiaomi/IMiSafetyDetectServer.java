package com.bytedance.badger.collect.impl.vendor.xiaomi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes47.dex */
public interface IMiSafetyDetectServer extends IInterface {

    public static class Default implements IMiSafetyDetectServer {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
        public void getRiskAppList(String r100, IMiSafetyDetectCallback r101) throws RemoteException {
        }

        @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
        public void getSimulatedTouchResult(String r100, long r101, IMiSafetyDetectCallback r102) throws RemoteException {
        }

        @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
        public void getTrustDeviceStatusInfo(String r100, String r101, int r102, IMiSafetyDetectCallback r103) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMiSafetyDetectServer {
        private static final String DESCRIPTOR = "com.xiaomi.security.xsof.IMiSafetyDetectServer";
        static final int TRANSACTION_getRiskAppList = 2;
        static final int TRANSACTION_getSimulatedTouchResult = 3;
        static final int TRANSACTION_getTrustDeviceStatusInfo = 1;

        public static class Proxy implements IMiSafetyDetectServer {
            public static IMiSafetyDetectServer sDefaultImpl;
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

            @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
            public void getRiskAppList(String r100, IMiSafetyDetectCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L17
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_badger_collect_impl_vendor_xiaomi_IMiSafetyDetectServer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getRiskAppList(r100, r101);     // Catch: Throwable -> L17
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

            @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
            public void getSimulatedTouchResult(String r100, long r101, IMiSafetyDetectCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r103.writeString(r100);     // Catch: Throwable -> L17
                r103.writeLong(r101);     // Catch: Throwable -> L17
                if (r102 == null) goto L6;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L17
            L7:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_badger_collect_impl_vendor_xiaomi_IMiSafetyDetectServer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getSimulatedTouchResult(r100, r101, r102);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L6:
                r105 = null;
            L17:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.bytedance.badger.collect.impl.vendor.xiaomi.IMiSafetyDetectServer
            public void getTrustDeviceStatusInfo(String r100, String r101, int r102, IMiSafetyDetectCallback r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r104.writeString(r100);     // Catch: Throwable -> L17
                r104.writeString(r101);     // Catch: Throwable -> L17
                r104.writeInt(r102);     // Catch: Throwable -> L17
                if (r103 == null) goto L6;
                IBinder r106 = r103.asBinder();     // Catch: Throwable -> L17
            L7:
                r104.writeStrongBinder(r106);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_badger_collect_impl_vendor_xiaomi_IMiSafetyDetectServer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r104, r105, 0) == false) goto L10;
            L14:
                r105.readException();     // Catch: Throwable -> L17
                r105.recycle();
                r104.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getTrustDeviceStatusInfo(r100, r101, r102, r103);     // Catch: Throwable -> L17
                r105.recycle();
                r104.recycle();
                return;
            L6:
                r106 = null;
            L17:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_badger_collect_impl_vendor_xiaomi_IMiSafetyDetectServer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IMiSafetyDetectServer getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IMiSafetyDetectServer asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IMiSafetyDetectServer) == false) goto L12;
            return (IMiSafetyDetectServer) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IMiSafetyDetectServer r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            getTrustDeviceStatusInfo(r101.readString(), r101.readString(), r101.readInt(), IMiSafetyDetectCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            getRiskAppList(r101.readString(), IMiSafetyDetectCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            getSimulatedTouchResult(r101.readString(), r101.readLong(), IMiSafetyDetectCallback.Stub.asInterface(r101.readStrongBinder()));
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

    void getRiskAppList(String r100, IMiSafetyDetectCallback r101) throws RemoteException;

    void getSimulatedTouchResult(String r100, long r101, IMiSafetyDetectCallback r102) throws RemoteException;

    void getTrustDeviceStatusInfo(String r100, String r101, int r102, IMiSafetyDetectCallback r103) throws RemoteException;
}
