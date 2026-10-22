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
public interface ICldReportManager extends IInterface {
    public static final int CLD_MODULE_TYPE_BT = 1;
    public static final int CLD_MODULE_TYPE_GNSS = 3;
    public static final int CLD_MODULE_TYPE_LOGCAT = 5;
    public static final int CLD_MODULE_TYPE_NETWORK = 2;
    public static final int CLD_MODULE_TYPE_NFC = 4;
    public static final int CLD_MODULE_TYPE_WIFI = 0;

    public static class Default implements ICldReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void reportErrorEvent(int r100, int r101, int r102, int r103, String r104) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void startCollect(ICldReportCallback r100, int r101, int r102, int r103, int r104, String r105, boolean r106) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cldReport.ICldReportManager
        public void stopCollect(ICldReportCallback r100, int r101, int r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICldReportManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cldReport.ICldReportManager";
        static final int TRANSACTION_reportErrorEvent = 1;
        static final int TRANSACTION_startCollect = 2;
        static final int TRANSACTION_stopCollect = 3;

        public static class Proxy implements ICldReportManager {
            public static ICldReportManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void stopCollect(ICldReportCallback r100, int r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r105 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L17
                r103.writeInt(r101);     // Catch: Throwable -> L17
                r103.writeInt(r102);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().stopCollect(r100, r101, r102);     // Catch: Throwable -> L17
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void reportErrorEvent(int r110, int r111, int r112, int r113, String r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r100.writeInt(r110);     // Catch: Throwable -> L13
                r100.writeInt(r111);     // Catch: Throwable -> L13
                r100.writeInt(r112);     // Catch: Throwable -> L13
                r100.writeInt(r113);     // Catch: Throwable -> L13
                r100.writeString(r114);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().reportErrorEvent(r110, r111, r112, r113, r114);     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cldReport.ICldReportManager
            public void startCollect(ICldReportCallback r110, int r111, int r112, int r113, int r114, String r115, boolean r116) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r110 == null) goto L6;
                IBinder r102 = r110.asBinder();     // Catch: Throwable -> L21
            L7:
                r100.writeStrongBinder(r102);     // Catch: Throwable -> L21
                r100.writeInt(r111);     // Catch: Throwable -> L21
                r100.writeInt(r112);     // Catch: Throwable -> L21
                r100.writeInt(r113);     // Catch: Throwable -> L21
                r100.writeInt(r114);     // Catch: Throwable -> L21
                r100.writeString(r115);     // Catch: Throwable -> L21
                r100.writeInt(r116 ? 1 : 0);     // Catch: Throwable -> L21
            L19:
                th = th;
            L23:
                r101.recycle();
                r100.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_obric_cae_libs_cldReport_ICldReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L12;
            L16:
                r101.readException();     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().startCollect(r110, r111, r112, r113, r114, r115, r116);     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r102 = null;
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

        public static ICldReportManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICldReportManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICldReportManager) == false) goto L12;
            return (ICldReportManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICldReportManager r100) {
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
            reportErrorEvent(r111.readInt(), r111.readInt(), r111.readInt(), r111.readInt(), r111.readString());
            r112.writeNoException();
            return true;
        L5:
            if (r110 != 2) goto L7;
            r111.enforceInterface(DESCRIPTOR);
            ICldReportCallback r100 = ICldReportCallback.Stub.asInterface(r111.readStrongBinder());
            int r101 = r111.readInt();
            int r102 = r111.readInt();
            int r103 = r111.readInt();
            int r114 = r111.readInt();
            String r115 = r111.readString();
            if (r111.readInt() == 0) goto L19;
            boolean r116 = true;
        L20:
            startCollect(r100, r101, r102, r103, r114, r115, r116);
            r112.writeNoException();
            return true;
        L19:
            r116 = false;
            goto L20
        L7:
            if (r110 != 3) goto L9;
            r111.enforceInterface(DESCRIPTOR);
            stopCollect(ICldReportCallback.Stub.asInterface(r111.readStrongBinder()), r111.readInt(), r111.readInt());
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

    void reportErrorEvent(int r100, int r101, int r102, int r103, String r104) throws RemoteException;

    void startCollect(ICldReportCallback r100, int r101, int r102, int r103, int r104, String r105, boolean r106) throws RemoteException;

    void stopCollect(ICldReportCallback r100, int r101, int r102) throws RemoteException;
}
