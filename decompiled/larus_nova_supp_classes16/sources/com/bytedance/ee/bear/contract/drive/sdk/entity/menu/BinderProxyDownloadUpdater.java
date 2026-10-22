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

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
            public void hideDownloadingView(String r4, String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r4);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r5);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdater$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
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

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
            public void showDownloadingView(String r4, String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r4);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r5);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdater$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
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

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
            public void onDownloadingProgressChange(String r4, String r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r4);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r5);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeInt(r6);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdater$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r1.recycle();
                r0.recycle();
                return;
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                goto L9
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
            public void onFailed(String r4, String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r4);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r5);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeString(r6);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdater$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r1.recycle();
                r0.recycle();
                return;
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                goto L9
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_menu_BinderProxyDownloadUpdater$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r16, int r17, Parcel r18, Parcel r19, int r110) throws RemoteException {
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public abstract /* synthetic */ void hideDownloadingView(String r1, String r2);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public abstract /* synthetic */ void onDownloadingProgressChange(String r1, String r2, int r3);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public abstract /* synthetic */ void onFailed(String r1, String r2, String r3);

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BinderProxyDownloadUpdater
        public abstract /* synthetic */ void showDownloadingView(String r1, String r2);

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BinderProxyDownloadUpdater asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof BinderProxyDownloadUpdater) == false) goto L12;
            return (BinderProxyDownloadUpdater) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            showDownloadingView(r5.readString(), r5.readString());
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onDownloadingProgressChange(r5.readString(), r5.readString(), r5.readInt());
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            hideDownloadingView(r5.readString(), r5.readString());
            r6.writeNoException();
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            onFailed(r5.readString(), r5.readString(), r5.readString());
            r6.writeNoException();
            return true;
        L11:
            if (r4 != 1598968902) goto L13;
            r6.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    /* synthetic */ void hideDownloadingView(String r1, String r2);

    /* synthetic */ void onDownloadingProgressChange(String r1, String r2, int r3);

    /* synthetic */ void onFailed(String r1, String r2, String r3);

    /* synthetic */ void showDownloadingView(String r1, String r2);
}
