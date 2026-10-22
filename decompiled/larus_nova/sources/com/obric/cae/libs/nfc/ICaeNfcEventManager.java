package com.obric.cae.libs.nfc;

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

/* JADX INFO: loaded from: classes33.dex */
public interface ICaeNfcEventManager extends IInterface {

    public static class Default implements ICaeNfcEventManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getTransitEventAllowedAidTypes() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public int getTransitEventSource() throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean isTransitEventFilterEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void notifyTransitEvent(Bundle r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerDndConfigCallback(ICaeNfcDndConfigCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerTransitEventCallback(ICaeNfcTransitEventCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventAllowedAidTypes(int r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventFilterEnabled(boolean r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public boolean setTransitEventSource(int r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
        public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeNfcEventManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.nfc.ICaeNfcEventManager";
        static final int TRANSACTION_getTransitEventAllowedAidTypes = 19;
        static final int TRANSACTION_getTransitEventSource = 15;
        static final int TRANSACTION_isTransitEventFilterEnabled = 17;
        static final int TRANSACTION_notifyTransitEvent = 13;
        static final int TRANSACTION_registerCloudConfigCallback = 1;
        static final int TRANSACTION_registerDndConfigCallback = 3;
        static final int TRANSACTION_registerForceFwEventCallback = 5;
        static final int TRANSACTION_registerPaymentChangeCallback = 11;
        static final int TRANSACTION_registerTransitEventCallback = 7;
        static final int TRANSACTION_registerVendorNciEventCallback = 9;
        static final int TRANSACTION_setTransitEventAllowedAidTypes = 18;
        static final int TRANSACTION_setTransitEventFilterEnabled = 16;
        static final int TRANSACTION_setTransitEventSource = 14;
        static final int TRANSACTION_unregisterCloudConfigCallback = 2;
        static final int TRANSACTION_unregisterDndConfigCallback = 4;
        static final int TRANSACTION_unregisterForceFwEventCallback = 6;
        static final int TRANSACTION_unregisterPaymentChangeCallback = 12;
        static final int TRANSACTION_unregisterTransitEventCallback = 8;
        static final int TRANSACTION_unregisterVendorNciEventCallback = 10;

        public static class Proxy implements ICaeNfcEventManager {
            public static ICaeNfcEventManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getTransitEventAllowedAidTypes() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getTransitEventAllowedAidTypes();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public int getTransitEventSource() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getTransitEventSource();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean isTransitEventFilterEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().isTransitEventFilterEnabled();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void notifyTransitEvent(Bundle r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyTransitEvent(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCloudConfigCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerDndConfigCallback(ICaeNfcDndConfigCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerDndConfigCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerForceFwEventCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerPaymentChangeCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerTransitEventCallback(ICaeNfcTransitEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerTransitEventCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerVendorNciEventCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventAllowedAidTypes(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeInt(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().setTransitEventAllowedAidTypes(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventFilterEnabled(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().setTransitEventFilterEnabled(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public boolean setTransitEventSource(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeInt(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().setTransitEventSource(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCloudConfigCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterDndConfigCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterForceFwEventCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterPaymentChangeCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterTransitEventCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.nfc.ICaeNfcEventManager
            public void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterVendorNciEventCallback(r100);     // Catch: Throwable -> L17
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
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_nfc_ICaeNfcEventManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICaeNfcEventManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeNfcEventManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICaeNfcEventManager) == false) goto L12;
            return (ICaeNfcEventManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICaeNfcEventManager r100) {
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
            if (r100 == 1598968902) goto L53;
            switch(r100) {
                case 1: goto L51;
                case 2: goto L49;
                case 3: goto L47;
                case 4: goto L45;
                case 5: goto L43;
                case 6: goto L41;
                case 7: goto L39;
                case 8: goto L37;
                case 9: goto L35;
                case 10: goto L33;
                case 11: goto L31;
                case 12: goto L29;
                case 13: goto L23;
                case 14: goto L21;
                case 15: goto L19;
                case 16: goto L13;
                case 17: goto L11;
                case 18: goto L9;
                case 19: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            int r104 = getTransitEventAllowedAidTypes();
            r102.writeNoException();
            r102.writeInt(r104);
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            boolean r105 = setTransitEventAllowedAidTypes(r101.readInt());
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            boolean r106 = isTransitEventFilterEnabled();
            r102.writeNoException();
            r102.writeInt(r106 ? 1 : 0);
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L16;
            boolean r107 = true;
        L17:
            boolean r108 = setTransitEventFilterEnabled(r107);
            r102.writeNoException();
            r102.writeInt(r108 ? 1 : 0);
            return true;
        L16:
            r107 = false;
            goto L17
        L19:
            r101.enforceInterface(DESCRIPTOR);
            int r109 = getTransitEventSource();
            r102.writeNoException();
            r102.writeInt(r109);
            return true;
        L21:
            r101.enforceInterface(DESCRIPTOR);
            boolean r110 = setTransitEventSource(r101.readInt());
            r102.writeNoException();
            r102.writeInt(r110 ? 1 : 0);
            return true;
        L23:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L26;
            Bundle r111 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L27:
            notifyTransitEvent(r111);
            return true;
        L26:
            r111 = null;
            goto L27
        L29:
            r101.enforceInterface(DESCRIPTOR);
            unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L31:
            r101.enforceInterface(DESCRIPTOR);
            registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L33:
            r101.enforceInterface(DESCRIPTOR);
            unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L35:
            r101.enforceInterface(DESCRIPTOR);
            registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L37:
            r101.enforceInterface(DESCRIPTOR);
            unregisterTransitEventCallback(ICaeNfcTransitEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L39:
            r101.enforceInterface(DESCRIPTOR);
            registerTransitEventCallback(ICaeNfcTransitEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L41:
            r101.enforceInterface(DESCRIPTOR);
            unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L43:
            r101.enforceInterface(DESCRIPTOR);
            registerForceFwEventCallback(ICaeNfcForceFwEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L45:
            r101.enforceInterface(DESCRIPTOR);
            unregisterDndConfigCallback(ICaeNfcDndConfigCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L47:
            r101.enforceInterface(DESCRIPTOR);
            registerDndConfigCallback(ICaeNfcDndConfigCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L49:
            r101.enforceInterface(DESCRIPTOR);
            unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L51:
            r101.enforceInterface(DESCRIPTOR);
            registerCloudConfigCallback(ICaeNfcCloudConfigCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L53:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getTransitEventAllowedAidTypes() throws RemoteException;

    int getTransitEventSource() throws RemoteException;

    boolean isTransitEventFilterEnabled() throws RemoteException;

    void notifyTransitEvent(Bundle r100) throws RemoteException;

    void registerCloudConfigCallback(ICaeNfcCloudConfigCallback r100) throws RemoteException;

    void registerDndConfigCallback(ICaeNfcDndConfigCallback r100) throws RemoteException;

    void registerForceFwEventCallback(ICaeNfcForceFwEventCallback r100) throws RemoteException;

    void registerPaymentChangeCallback(ICaeNfcPaymentChangeCallback r100) throws RemoteException;

    void registerTransitEventCallback(ICaeNfcTransitEventCallback r100) throws RemoteException;

    void registerVendorNciEventCallback(ICaeNfcVendorNciEventCallback r100) throws RemoteException;

    boolean setTransitEventAllowedAidTypes(int r100) throws RemoteException;

    boolean setTransitEventFilterEnabled(boolean r100) throws RemoteException;

    boolean setTransitEventSource(int r100) throws RemoteException;

    void unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r100) throws RemoteException;

    void unregisterDndConfigCallback(ICaeNfcDndConfigCallback r100) throws RemoteException;

    void unregisterForceFwEventCallback(ICaeNfcForceFwEventCallback r100) throws RemoteException;

    void unregisterPaymentChangeCallback(ICaeNfcPaymentChangeCallback r100) throws RemoteException;

    void unregisterTransitEventCallback(ICaeNfcTransitEventCallback r100) throws RemoteException;

    void unregisterVendorNciEventCallback(ICaeNfcVendorNciEventCallback r100) throws RemoteException;
}
