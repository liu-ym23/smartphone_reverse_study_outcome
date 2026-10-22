package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes8.dex */
public interface IOAIDService extends IInterface {

    public static abstract class Stub extends Binder implements IOAIDService {
        private static final String DESCRIPTOR = "com.hihonor.cloudservice.oaid.IOAIDService";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_isOAIDTrackingLimited = 3;

        public static class Proxy implements IOAIDService {
            public static IOAIDService sDefaultImpl;
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

            @Override // com.bytedance.bdinstall.oaid.impl.IOAIDService
            public void getOAID(IOAIDCallBack r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IOAIDService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getOAID(r100);     // Catch: Throwable -> L17
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

            @Override // com.bytedance.bdinstall.oaid.impl.IOAIDService
            public void isOAIDTrackingLimited(IOAIDCallBack r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IOAIDService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().isOAIDTrackingLimited(r100);     // Catch: Throwable -> L17
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
            public static boolean INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IOAIDService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.bytedance.bdinstall.oaid.impl.IOAIDService
            public void basicTypes(int r110, long r111, boolean r112, float r113, double r114, String r210) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeInt(r110);     // Catch: Throwable -> L21
                r100.writeLong(r111);     // Catch: Throwable -> L21
                if (r112 == false) goto L6;
                int r102 = 1;
            L7:
                r100.writeInt(r102);     // Catch: Throwable -> L21
                r100.writeFloat(r113);     // Catch: Throwable -> L21
                r100.writeDouble(r114);     // Catch: Throwable -> L21
                r100.writeString(r210);     // Catch: Throwable -> L21
            L19:
                th = th;
            L23:
                r101.recycle();
                r100.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IOAIDService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L12;
            L16:
                r101.readException();     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().basicTypes(r110, r111, r112, r113, r114, r210);     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r102 = 0;
            L21:
                th = th;
                goto L23
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOAIDService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IOAIDService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IOAIDService) == false) goto L12;
            return (IOAIDService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IOAIDService r100) {
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
        public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
            if (r110 != 1) goto L5;
            r111.enforceInterface(DESCRIPTOR);
            int r100 = r111.readInt();
            long r101 = r111.readLong();
            if (r111.readInt() == 0) goto L21;
            boolean r102 = true;
        L22:
            basicTypes(r100, r101, r102, r111.readFloat(), r111.readDouble(), r111.readString());
            r112.writeNoException();
            return true;
        L21:
            r102 = false;
            goto L22
        L5:
            if (r110 != 2) goto L7;
            r111.enforceInterface(DESCRIPTOR);
            getOAID(IOAIDCallBack.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            return true;
        L7:
            if (r110 != 3) goto L9;
            r111.enforceInterface(DESCRIPTOR);
            isOAIDTrackingLimited(IOAIDCallBack.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            return true;
        L9:
            if (r110 != 1598968902) goto L11;
            r112.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r110, r111, r112, r113);
        }
    }

    void basicTypes(int r100, long r101, boolean r102, float r103, double r104, String r105) throws RemoteException;

    void getOAID(IOAIDCallBack r100) throws RemoteException;

    void isOAIDTrackingLimited(IOAIDCallBack r100) throws RemoteException;
}
