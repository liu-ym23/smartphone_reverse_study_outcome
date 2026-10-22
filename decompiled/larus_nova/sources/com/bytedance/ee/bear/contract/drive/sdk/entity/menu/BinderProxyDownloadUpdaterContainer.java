package com.bytedance.ee.bear.contract.drive.sdk.entity.menu;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes16.dex */
public interface BinderProxyDownloadUpdaterContainer extends IInterface {

    public static abstract class Stub extends Binder implements BinderProxyDownloadUpdaterContainer {
        private static final String DESCRIPTOR = "com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer";
        static final int TRANSACTION_addProxyDownloadUpdater_ERROR = 2;
        static final int TRANSACTION_getBinderProxyDownloadUpdaterArrays = 1;
        static final int TRANSACTION_hideDownloadingView_DECLARED = 6;
        static final int TRANSACTION_onDownloadingProgressChange_DECLARED_INT = 5;
        static final int TRANSACTION_onFailed_DECLARED_DECLARED = 7;
        static final int TRANSACTION_removeProxyDownloadUpdater_ERROR = 3;
        static final int TRANSACTION_showDownloadingView_DECLARED = 4;

        public static class Proxy implements BinderProxyDownloadUpdaterContainer {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public String getBinderProxyDownloadUpdaterArrays() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
                String r102 = r101.readString();     // Catch: Throwable -> L5 RemoteException -> L7
                r101.recycle();
                r100.recycle();
            L13:
                return r102;
            L5:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                r101.recycle();
                r100.recycle();
                r102 = null;
                goto L13
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void addProxyDownloadUpdater(BinderProxyDownloadUpdater r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L9 RemoteException -> L11
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L9 RemoteException -> L11
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r102.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L9:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            L11:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L9
                goto L13
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void hideDownloadingView(String r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r101.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r102.recycle();
                r101.recycle();
                return;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void removeProxyDownloadUpdater(BinderProxyDownloadUpdater r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L9 RemoteException -> L11
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L9 RemoteException -> L11
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r102.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L9:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            L11:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L9
                goto L13
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void showDownloadingView(String r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r101.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r102.recycle();
                r101.recycle();
                return;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void onDownloadingProgressChange(String r100, int r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.writeInt(r101);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, r103, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r103.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r103.recycle();
                r102.recycle();
                return;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void onFailed(String r100, String r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.writeString(r101);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, r103, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r103.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r103.recycle();
                r102.recycle();
                return;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void addProxyDownloadUpdater(BinderProxyDownloadUpdater r100);

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ String getBinderProxyDownloadUpdaterArrays();

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void hideDownloadingView(String r100);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void onDownloadingProgressChange(String r100, int r101);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void onFailed(String r100, String r101);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void removeProxyDownloadUpdater(BinderProxyDownloadUpdater r100);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void showDownloadingView(String r100);

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BinderProxyDownloadUpdaterContainer asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof BinderProxyDownloadUpdaterContainer) == false) goto L12;
            return (BinderProxyDownloadUpdaterContainer) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 == 1598968902) goto L21;
            switch(r100) {
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            onFailed(r101.readString(), r101.readString());
            r102.writeNoException();
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            hideDownloadingView(r101.readString());
            r102.writeNoException();
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            onDownloadingProgressChange(r101.readString(), r101.readInt());
            r102.writeNoException();
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            showDownloadingView(r101.readString());
            r102.writeNoException();
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            removeProxyDownloadUpdater(BinderProxyDownloadUpdater.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            addProxyDownloadUpdater(BinderProxyDownloadUpdater.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            String r104 = getBinderProxyDownloadUpdaterArrays();
            r102.writeNoException();
            r102.writeString(r104);
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L21:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    /* synthetic */ void addProxyDownloadUpdater(BinderProxyDownloadUpdater r100);

    /* synthetic */ String getBinderProxyDownloadUpdaterArrays();

    /* synthetic */ void hideDownloadingView(String r100);

    /* synthetic */ void onDownloadingProgressChange(String r100, int r101);

    /* synthetic */ void onFailed(String r100, String r101);

    /* synthetic */ void removeProxyDownloadUpdater(BinderProxyDownloadUpdater r100);

    /* synthetic */ void showDownloadingView(String r100);
}
