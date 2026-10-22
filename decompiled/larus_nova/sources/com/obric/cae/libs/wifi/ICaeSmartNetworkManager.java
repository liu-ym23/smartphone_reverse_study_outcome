package com.obric.cae.libs.wifi;

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
public interface ICaeSmartNetworkManager extends IInterface {

    public static class Default implements ICaeSmartNetworkManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public String getCurrentSecondarySsid() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughput() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public int getLinkThroughputJitter() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public float getLinkThroughputJitterWeight() throws RemoteException {
            return 0.0f;
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void registerSecondaryWifiListener(ISecondaryWifiCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseAll() throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void releaseSecondaryWifi(ISecondaryWifiCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void requestSecondaryWifi(String r100, String r101, String r102, String r103, ISecondaryWifiCallback r104) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
        public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeSmartNetworkManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.wifi.ICaeSmartNetworkManager";
        static final int TRANSACTION_getCurrentSecondarySsid = 11;
        static final int TRANSACTION_getLinkThroughput = 3;
        static final int TRANSACTION_getLinkThroughputJitter = 4;
        static final int TRANSACTION_getLinkThroughputJitterWeight = 5;
        static final int TRANSACTION_registerLinkThroughputListener = 1;
        static final int TRANSACTION_registerSecondaryWifiListener = 8;
        static final int TRANSACTION_releaseAll = 10;
        static final int TRANSACTION_releaseSecondaryWifi = 7;
        static final int TRANSACTION_requestSecondaryWifi = 6;
        static final int TRANSACTION_unregisterLinkThroughputListener = 2;
        static final int TRANSACTION_unregisterSecondaryWifiListener = 9;

        public static class Proxy implements ICaeSmartNetworkManager {
            public static ICaeSmartNetworkManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public String getCurrentSecondarySsid() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getCurrentSecondarySsid();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughput() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getLinkThroughput();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public int getLinkThroughputJitter() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getLinkThroughputJitter();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public float getLinkThroughputJitterWeight() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                float r102 = r101.readFloat();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                float r103 = Stub.getDefaultImpl().getLinkThroughputJitterWeight();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseAll() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().releaseAll();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerLinkThroughputListener(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void registerSecondaryWifiListener(ISecondaryWifiCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerSecondaryWifiListener(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void releaseSecondaryWifi(ISecondaryWifiCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().releaseSecondaryWifi(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterLinkThroughputListener(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void unregisterSecondaryWifiListener(ISecondaryWifiCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterSecondaryWifiListener(r100);     // Catch: Throwable -> L17
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
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.cae.libs.wifi.ICaeSmartNetworkManager
            public void requestSecondaryWifi(String r110, String r111, String r112, String r113, ISecondaryWifiCallback r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r100.writeString(r110);     // Catch: Throwable -> L17
                r100.writeString(r111);     // Catch: Throwable -> L17
                r100.writeString(r112);     // Catch: Throwable -> L17
                r100.writeString(r113);     // Catch: Throwable -> L17
                if (r114 == null) goto L6;
                IBinder r102 = r114.asBinder();     // Catch: Throwable -> L17
            L7:
                r100.writeStrongBinder(r102);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_wifi_ICaeSmartNetworkManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L10;
            L14:
                r101.readException();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestSecondaryWifi(r110, r111, r112, r113, r114);     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return;
            L6:
                r102 = null;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeSmartNetworkManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeSmartNetworkManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICaeSmartNetworkManager) == false) goto L12;
            return (ICaeSmartNetworkManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICaeSmartNetworkManager r100) {
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
        public boolean onTransact(int r100, Parcel r110, Parcel r111, int r112) throws RemoteException {
            if (r100 == 1598968902) goto L29;
            switch(r100) {
                case 1: goto L27;
                case 2: goto L25;
                case 3: goto L23;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L17;
                case 7: goto L15;
                case 8: goto L13;
                case 9: goto L11;
                case 10: goto L9;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r110.enforceInterface(DESCRIPTOR);
            String r101 = getCurrentSecondarySsid();
            r111.writeNoException();
            r111.writeString(r101);
            return true;
        L9:
            r110.enforceInterface(DESCRIPTOR);
            releaseAll();
            r111.writeNoException();
            return true;
        L11:
            r110.enforceInterface(DESCRIPTOR);
            unregisterSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L13:
            r110.enforceInterface(DESCRIPTOR);
            registerSecondaryWifiListener(ISecondaryWifiCallback.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L15:
            r110.enforceInterface(DESCRIPTOR);
            releaseSecondaryWifi(ISecondaryWifiCallback.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L17:
            r110.enforceInterface(DESCRIPTOR);
            requestSecondaryWifi(r110.readString(), r110.readString(), r110.readString(), r110.readString(), ISecondaryWifiCallback.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L19:
            r110.enforceInterface(DESCRIPTOR);
            float r102 = getLinkThroughputJitterWeight();
            r111.writeNoException();
            r111.writeFloat(r102);
            return true;
        L21:
            r110.enforceInterface(DESCRIPTOR);
            int r103 = getLinkThroughputJitter();
            r111.writeNoException();
            r111.writeInt(r103);
            return true;
        L23:
            r110.enforceInterface(DESCRIPTOR);
            int r104 = getLinkThroughput();
            r111.writeNoException();
            r111.writeInt(r104);
            return true;
        L25:
            r110.enforceInterface(DESCRIPTOR);
            unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L27:
            r110.enforceInterface(DESCRIPTOR);
            registerLinkThroughputListener(ICaeWifiLinkThroughputListener.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L6:
            return super.onTransact(r100, r110, r111, r112);
        L29:
            r111.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getCurrentSecondarySsid() throws RemoteException;

    int getLinkThroughput() throws RemoteException;

    int getLinkThroughputJitter() throws RemoteException;

    float getLinkThroughputJitterWeight() throws RemoteException;

    void registerLinkThroughputListener(ICaeWifiLinkThroughputListener r100) throws RemoteException;

    void registerSecondaryWifiListener(ISecondaryWifiCallback r100) throws RemoteException;

    void releaseAll() throws RemoteException;

    void releaseSecondaryWifi(ISecondaryWifiCallback r100) throws RemoteException;

    void requestSecondaryWifi(String r100, String r101, String r102, String r103, ISecondaryWifiCallback r104) throws RemoteException;

    void unregisterLinkThroughputListener(ICaeWifiLinkThroughputListener r100) throws RemoteException;

    void unregisterSecondaryWifiListener(ISecondaryWifiCallback r100) throws RemoteException;
}
