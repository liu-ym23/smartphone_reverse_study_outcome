package com.obric.cae.libs.statusreport;

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
public interface ICaeStatusReportManager extends IInterface {

    public static class Default implements ICaeStatusReportManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public String getCaeVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public LinkLayerQuality getLinkLayerQuality(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public boolean registerLinkLayerQualityChangedListener(String r100, ILinkLayerQualityListener r101) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
        public boolean unregisterLinkLayerQualityChangedListener(String r100, ILinkLayerQualityListener r101) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICaeStatusReportManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.statusreport.ICaeStatusReportManager";
        static final int TRANSACTION_getCaeVersion = 4;
        static final int TRANSACTION_getLinkLayerQuality = 3;
        static final int TRANSACTION_registerLinkLayerQualityChangedListener = 1;
        static final int TRANSACTION_unregisterLinkLayerQualityChangedListener = 2;

        public static class Proxy implements ICaeStatusReportManager {
            public static ICaeStatusReportManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public String getCaeVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ICaeStatusReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getCaeVersion();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
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

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public LinkLayerQuality getLinkLayerQuality(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeString(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ICaeStatusReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L17
                if (r102.readInt() == 0) goto L14;
                LinkLayerQuality r103 = LinkLayerQuality.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L17
            L15:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                LinkLayerQuality r104 = Stub.getDefaultImpl().getLinkLayerQuality(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public boolean registerLinkLayerQualityChangedListener(String r100, ILinkLayerQualityListener r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r102.writeString(r100);     // Catch: Throwable -> L19
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L19
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L19
                boolean r105 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ICaeStatusReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L19
                if (r103.readInt() == 0) goto L17;
                r105 = true;
            L17:
                r103.recycle();
                r102.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r106 = Stub.getDefaultImpl().registerLinkLayerQualityChangedListener(r100, r101);     // Catch: Throwable -> L19
                r103.recycle();
                r102.recycle();
                return r106;
            L6:
                r104 = null;
            L19:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.statusreport.ICaeStatusReportManager
            public boolean unregisterLinkLayerQualityChangedListener(String r100, ILinkLayerQualityListener r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r102.writeString(r100);     // Catch: Throwable -> L19
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L19
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L19
                boolean r105 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ICaeStatusReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L19
                if (r103.readInt() == 0) goto L17;
                r105 = true;
            L17:
                r103.recycle();
                r102.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r106 = Stub.getDefaultImpl().unregisterLinkLayerQualityChangedListener(r100, r101);     // Catch: Throwable -> L19
                r103.recycle();
                r102.recycle();
                return r106;
            L6:
                r104 = null;
            L19:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_statusreport_ICaeStatusReportManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICaeStatusReportManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeStatusReportManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICaeStatusReportManager) == false) goto L12;
            return (ICaeStatusReportManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICaeStatusReportManager r100) {
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
            if (r100 == 1598968902) goto L24;
            if (r100 != 1) goto L6;
            r101.enforceInterface(DESCRIPTOR);
            boolean r104 = registerLinkLayerQualityChangedListener(r101.readString(), ILinkLayerQualityListener.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            r102.writeInt(r104 ? 1 : 0);
            return true;
        L6:
            if (r100 != 2) goto L8;
            r101.enforceInterface(DESCRIPTOR);
            boolean r105 = unregisterLinkLayerQualityChangedListener(r101.readString(), ILinkLayerQualityListener.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L8:
            if (r100 != 3) goto L10;
            r101.enforceInterface(DESCRIPTOR);
            LinkLayerQuality r106 = getLinkLayerQuality(r101.readString());
            r102.writeNoException();
            if (r106 == null) goto L18;
            r102.writeInt(1);
            r106.writeToParcel(r102, 1);
        L19:
            return true;
        L18:
            r102.writeInt(0);
            goto L19
        L10:
            if (r100 != 4) goto L12;
            r101.enforceInterface(DESCRIPTOR);
            String r107 = getCaeVersion();
            r102.writeNoException();
            r102.writeString(r107);
            return true;
        L12:
            return super.onTransact(r100, r101, r102, r103);
        L24:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCaeVersion() throws RemoteException;

    LinkLayerQuality getLinkLayerQuality(String r100) throws RemoteException;

    boolean registerLinkLayerQualityChangedListener(String r100, ILinkLayerQualityListener r101) throws RemoteException;

    boolean unregisterLinkLayerQualityChangedListener(String r100, ILinkLayerQualityListener r101) throws RemoteException;
}
