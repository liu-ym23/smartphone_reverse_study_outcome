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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
                String r2 = r1.readString();     // Catch: Throwable -> L5 RemoteException -> L7
                r1.recycle();
                r0.recycle();
            L13:
                return r2;
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                r1.recycle();
                r0.recycle();
                r2 = null;
                goto L13
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void addProxyDownloadUpdater(BinderProxyDownloadUpdater r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r5 == null) goto L6;
                IBinder r6 = r5.asBinder();     // Catch: Throwable -> L9 RemoteException -> L11
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L9 RemoteException -> L11
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r1.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = null;
            L9:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L11:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L9
                goto L13
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void hideDownloadingView(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r5);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r1.recycle();
                r0.recycle();
                return;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void removeProxyDownloadUpdater(BinderProxyDownloadUpdater r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r5 == null) goto L6;
                IBinder r6 = r5.asBinder();     // Catch: Throwable -> L9 RemoteException -> L11
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L9 RemoteException -> L11
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r1.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = null;
            L9:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L11:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L9
                goto L13
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void showDownloadingView(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r5);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r1.recycle();
                r0.recycle();
                return;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void onDownloadingProgressChange(String r4, int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r4);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeInt(r5);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r1.recycle();
                r0.recycle();
                return;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
            public void onFailed(String r4, String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r4);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r5);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r1.recycle();
                r0.recycle();
                return;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdaterContainer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r16, int r17, Parcel r18, Parcel r19, int r110) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r16.transact(r17, r18, r19, r110);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r16.getClass().getName(), r17, r110, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r16 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r9, r1, r17, r110, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r16.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r16.transact(r17, r18, r19, r110);
            }
        }

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void addProxyDownloadUpdater(BinderProxyDownloadUpdater r1);

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ String getBinderProxyDownloadUpdaterArrays();

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void hideDownloadingView(String r1);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void onDownloadingProgressChange(String r1, int r2);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void onFailed(String r1, String r2);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void removeProxyDownloadUpdater(BinderProxyDownloadUpdater r1);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdaterContainer
        public abstract /* synthetic */ void showDownloadingView(String r1);

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BinderProxyDownloadUpdaterContainer asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof BinderProxyDownloadUpdaterContainer) == false) goto L12;
            return (BinderProxyDownloadUpdaterContainer) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 == 1598968902) goto L21;
            switch(r4) {
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
            r5.enforceInterface(DESCRIPTOR);
            onFailed(r5.readString(), r5.readString());
            r6.writeNoException();
            return true;
        L9:
            r5.enforceInterface(DESCRIPTOR);
            hideDownloadingView(r5.readString());
            r6.writeNoException();
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            onDownloadingProgressChange(r5.readString(), r5.readInt());
            r6.writeNoException();
            return true;
        L13:
            r5.enforceInterface(DESCRIPTOR);
            showDownloadingView(r5.readString());
            r6.writeNoException();
            return true;
        L15:
            r5.enforceInterface(DESCRIPTOR);
            removeProxyDownloadUpdater(BinderProxyDownloadUpdater.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L17:
            r5.enforceInterface(DESCRIPTOR);
            addProxyDownloadUpdater(BinderProxyDownloadUpdater.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            return true;
        L19:
            r5.enforceInterface(DESCRIPTOR);
            String r8 = getBinderProxyDownloadUpdaterArrays();
            r6.writeNoException();
            r6.writeString(r8);
            return true;
        L6:
            return super.onTransact(r4, r5, r6, r7);
        L21:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    /* synthetic */ void addProxyDownloadUpdater(BinderProxyDownloadUpdater r1);

    /* synthetic */ String getBinderProxyDownloadUpdaterArrays();

    /* synthetic */ void hideDownloadingView(String r1);

    /* synthetic */ void onDownloadingProgressChange(String r1, int r2);

    /* synthetic */ void onFailed(String r1, String r2);

    /* synthetic */ void removeProxyDownloadUpdater(BinderProxyDownloadUpdater r1);

    /* synthetic */ void showDownloadingView(String r1);
}
