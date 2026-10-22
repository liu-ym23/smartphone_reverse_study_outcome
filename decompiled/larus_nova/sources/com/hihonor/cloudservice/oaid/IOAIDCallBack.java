package com.hihonor.cloudservice.oaid;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public interface IOAIDCallBack extends IInterface {

    public static class Default implements IOAIDCallBack {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
        public void basicTypes(int r100, long r101, boolean r102, float r103, double r104, String r105) throws RemoteException {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
        public void handleResult(int r100, Bundle r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOAIDCallBack {
        private static final String DESCRIPTOR = "com.hihonor.cloudservice.oaid.IOAIDCallBack";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_handleResult = 2;

        public static class Proxy implements IOAIDCallBack {
            public static IOAIDCallBack sDefaultImpl;
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

            @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
            public void handleResult(int r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_hihonor_cloudservice_oaid_IOAIDCallBack$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().handleResult(r100, r101);     // Catch: Throwable -> L17
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
            public static boolean INVOKEINTERFACE_com_hihonor_cloudservice_oaid_IOAIDCallBack$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
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
                if (INVOKEINTERFACE_com_hihonor_cloudservice_oaid_IOAIDCallBack$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L12;
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

        public static IOAIDCallBack getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IOAIDCallBack asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IOAIDCallBack) == false) goto L12;
            return (IOAIDCallBack) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IOAIDCallBack r100) {
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
            int r114 = r111.readInt();
            if (r111.readInt() == 0) goto L15;
            Bundle r115 = (Bundle) Bundle.CREATOR.createFromParcel(r111);
        L16:
            handleResult(r114, r115);
            r112.writeNoException();
            return true;
        L15:
            r115 = null;
            goto L16
        L7:
            if (r110 != 1598968902) goto L9;
            r112.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r110, r111, r112, r113);
        }
    }

    void basicTypes(int r100, long r101, boolean r102, float r103, double r104, String r105) throws RemoteException;

    void handleResult(int r100, Bundle r101) throws RemoteException;
}
