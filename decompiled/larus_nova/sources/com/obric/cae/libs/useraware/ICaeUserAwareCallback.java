package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface ICaeUserAwareCallback extends IInterface {

    public static class Default implements ICaeUserAwareCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onCellInfoChange(CellAwareInfo r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onCellNeighbourInfoChange(List<CellAwareInfo> r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onInSubWayChange(int r100, String r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onUserAwareReportData(String r100, String r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiConnectInfoChanged(WifiStandardData r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiNetworkAvailable(boolean r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
        public void onWifiScanInfoChanged(List<WifiStandardData> r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeUserAwareCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.useraware.ICaeUserAwareCallback";
        static final int TRANSACTION_onCellInfoChange = 4;
        static final int TRANSACTION_onCellNeighbourInfoChange = 5;
        static final int TRANSACTION_onInSubWayChange = 7;
        static final int TRANSACTION_onUserAwareReportData = 6;
        static final int TRANSACTION_onWifiConnectInfoChanged = 2;
        static final int TRANSACTION_onWifiNetworkAvailable = 3;
        static final int TRANSACTION_onWifiScanInfoChanged = 1;

        public static class Proxy implements ICaeUserAwareCallback {
            public static ICaeUserAwareCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onCellInfoChange(CellAwareInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onCellInfoChange(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onCellNeighbourInfoChange(List<CellAwareInfo> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeTypedList(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onCellNeighbourInfoChange(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiConnectInfoChanged(WifiStandardData r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onWifiConnectInfoChanged(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiNetworkAvailable(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onWifiNetworkAvailable(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onWifiScanInfoChanged(List<WifiStandardData> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeTypedList(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onWifiScanInfoChanged(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onInSubWayChange(int r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeInt(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onInSubWayChange(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAwareCallback
            public void onUserAwareReportData(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onUserAwareReportData(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAwareCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICaeUserAwareCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeUserAwareCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICaeUserAwareCallback) == false) goto L12;
            return (ICaeUserAwareCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICaeUserAwareCallback r100) {
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
            if (r100 == 1598968902) goto L32;
            WifiStandardData r104 = null;
            CellAwareInfo r105 = null;
            switch(r100) {
                case 1: goto L30;
                case 2: goto L25;
                case 3: goto L19;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            onInSubWayChange(r101.readInt(), r101.readString());
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            onUserAwareReportData(r101.readString(), r101.readString());
            return true;
        L12:
            r101.enforceInterface(DESCRIPTOR);
            onCellNeighbourInfoChange(r101.createTypedArrayList(CellAwareInfo.CREATOR));
            return true;
        L14:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L17;
            r105 = CellAwareInfo.CREATOR.createFromParcel(r101);
        L17:
            onCellInfoChange(r105);
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L22;
            boolean r106 = true;
        L23:
            onWifiNetworkAvailable(r106);
            return true;
        L22:
            r106 = false;
            goto L23
        L25:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L28;
            r104 = WifiStandardData.CREATOR.createFromParcel(r101);
        L28:
            onWifiConnectInfoChanged(r104);
            return true;
        L30:
            r101.enforceInterface(DESCRIPTOR);
            onWifiScanInfoChanged(r101.createTypedArrayList(WifiStandardData.CREATOR));
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L32:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onCellInfoChange(CellAwareInfo r100) throws RemoteException;

    void onCellNeighbourInfoChange(List<CellAwareInfo> r100) throws RemoteException;

    void onInSubWayChange(int r100, String r101) throws RemoteException;

    void onUserAwareReportData(String r100, String r101) throws RemoteException;

    void onWifiConnectInfoChanged(WifiStandardData r100) throws RemoteException;

    void onWifiNetworkAvailable(boolean r100) throws RemoteException;

    void onWifiScanInfoChanged(List<WifiStandardData> r100) throws RemoteException;
}
