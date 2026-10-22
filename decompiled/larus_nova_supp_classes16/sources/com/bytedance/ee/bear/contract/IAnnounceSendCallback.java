package com.bytedance.ee.bear.contract;

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
public interface IAnnounceSendCallback extends IInterface {

    public static class Default implements IAnnounceSendCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
        public void onAnnounceSendFailed(long r1) throws RemoteException {
        }

        @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
        public void onAnnounceSendSuccess() throws RemoteException {
        }

        @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
        public void onAnnounceSending() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAnnounceSendCallback {
        private static final String DESCRIPTOR = "com.bytedance.ee.bear.contract.IAnnounceSendCallback";
        static final int TRANSACTION_onAnnounceSendFailed = 3;
        static final int TRANSACTION_onAnnounceSendSuccess = 2;
        static final int TRANSACTION_onAnnounceSending = 1;

        public static class Proxy implements IAnnounceSendCallback {
            public static IAnnounceSendCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
            public void onAnnounceSendSuccess() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_ee_bear_contract_IAnnounceSendCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAnnounceSendSuccess();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
            public void onAnnounceSending() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_ee_bear_contract_IAnnounceSendCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAnnounceSending();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.bytedance.ee.bear.contract.IAnnounceSendCallback
            public void onAnnounceSendFailed(long r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeLong(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_ee_bear_contract_IAnnounceSendCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAnnounceSendFailed(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_contract_IAnnounceSendCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r16, int r17, Parcel r18, Parcel r19, int r110) throws RemoteException {
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

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAnnounceSendCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAnnounceSendCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IAnnounceSendCallback) == false) goto L12;
            return (IAnnounceSendCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IAnnounceSendCallback r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            onAnnounceSending();
            r6.writeNoException();
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            onAnnounceSendSuccess();
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            onAnnounceSendFailed(r5.readLong());
            r6.writeNoException();
            return true;
        L9:
            if (r4 != 1598968902) goto L11;
            r6.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void onAnnounceSendFailed(long r1) throws RemoteException;

    void onAnnounceSendSuccess() throws RemoteException;

    void onAnnounceSending() throws RemoteException;
}
