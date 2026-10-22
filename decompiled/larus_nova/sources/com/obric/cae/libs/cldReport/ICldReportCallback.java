package com.obric.cae.libs.cldReport;

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
public interface ICldReportCallback extends IInterface {

    public static class Default implements ICldReportCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportCallback
        public void onStarted(boolean r100, int r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportCallback
        public void onStoped(boolean r100, int r101, String r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICldReportCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportCallback";
        static final int TRANSACTION_onStarted = 1;
        static final int TRANSACTION_onStoped = 2;

        public static class Proxy implements ICldReportCallback {
            public static ICldReportCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.cldReport.ICldReportCallback
            public void onStarted(boolean r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L13
                r102.writeInt(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onStarted(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportCallback
            public void onStoped(boolean r100, int r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L13
                r103.writeInt(r101);     // Catch: Throwable -> L13
                r103.writeString(r102);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onStoped(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICldReportCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICldReportCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICldReportCallback) == false) goto L12;
            return (ICldReportCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICldReportCallback r100) {
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
            boolean r104 = false;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L20;
            r104 = true;
        L20:
            onStarted(r104, r101.readInt());
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L15;
            r104 = true;
        L15:
            onStoped(r104, r101.readInt(), r101.readString());
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onStarted(boolean r100, int r101) throws RemoteException;

    void onStoped(boolean r100, int r101, String r102) throws RemoteException;
}
