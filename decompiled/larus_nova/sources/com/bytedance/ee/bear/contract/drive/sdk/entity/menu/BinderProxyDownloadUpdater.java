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
public interface BinderProxyDownloadUpdater extends IInterface {

    public static abstract class Stub extends Binder implements BinderProxyDownloadUpdater {
        private static final String DESCRIPTOR = "com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater";
        static final int TRANSACTION_hideDownloadingView_DECLARED_DECLARED = 3;
        static final int TRANSACTION_onDownloadingProgressChange_DECLARED_DECLARED_INT = 2;
        static final int TRANSACTION_onFailed_DECLARED_DECLARED_DECLARED = 4;
        static final int TRANSACTION_showDownloadingView_DECLARED_DECLARED = 1;

        public static class Proxy implements BinderProxyDownloadUpdater {
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

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
            public void hideDownloadingView(String r100, String r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.writeString(r101);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdater$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0);     // Catch: Throwable -> L5 RemoteException -> L7
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

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
            public void showDownloadingView(String r100, String r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.writeString(r101);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdater$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0);     // Catch: Throwable -> L5 RemoteException -> L7
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

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
            public void onDownloadingProgressChange(String r100, String r101, int r102) {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r103.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
                r103.writeString(r101);     // Catch: Throwable -> L5 RemoteException -> L7
                r103.writeInt(r102);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdater$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, r104, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r104.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r104.recycle();
                r103.recycle();
                return;
            L5:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                goto L9
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
            public void onFailed(String r100, String r101, String r102) {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r103.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
                r103.writeString(r101);     // Catch: Throwable -> L5 RemoteException -> L7
                r103.writeString(r102);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdater$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, r104, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r104.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r104.recycle();
                r103.recycle();
                return;
            L5:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                goto L9
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdater$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public abstract /* synthetic */ void hideDownloadingView(String r100, String r101);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public abstract /* synthetic */ void onDownloadingProgressChange(String r100, String r101, int r102);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public abstract /* synthetic */ void onFailed(String r100, String r101, String r102);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public abstract /* synthetic */ void showDownloadingView(String r100, String r101);

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BinderProxyDownloadUpdater asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof BinderProxyDownloadUpdater) == false) goto L12;
            return (BinderProxyDownloadUpdater) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            showDownloadingView(r101.readString(), r101.readString());
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            onDownloadingProgressChange(r101.readString(), r101.readString(), r101.readInt());
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            hideDownloadingView(r101.readString(), r101.readString());
            r102.writeNoException();
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            onFailed(r101.readString(), r101.readString(), r101.readString());
            r102.writeNoException();
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    /* synthetic */ void hideDownloadingView(String r100, String r101);

    /* synthetic */ void onDownloadingProgressChange(String r100, String r101, int r102);

    /* synthetic */ void onFailed(String r100, String r101, String r102);

    /* synthetic */ void showDownloadingView(String r100, String r101);
}
