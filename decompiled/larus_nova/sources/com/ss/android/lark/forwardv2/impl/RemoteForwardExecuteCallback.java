package com.ss.android.lark.forwardv2.impl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes36.dex */
public interface RemoteForwardExecuteCallback extends IInterface {

    public static class Default implements RemoteForwardExecuteCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
        public void onFailedDialog(String r100, String r101, boolean r102) throws RemoteException {
        }

        @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
        public void onFailedToast(String r100, boolean r101) throws RemoteException {
        }

        @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
        public void onSuccess(int r100, Intent r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements RemoteForwardExecuteCallback {
        private static final String DESCRIPTOR = "com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback";
        static final int TRANSACTION_onFailedDialog = 3;
        static final int TRANSACTION_onFailedToast = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements RemoteForwardExecuteCallback {
            public static RemoteForwardExecuteCallback sDefaultImpl;
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

            @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
            public void onFailedToast(String r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                if (r101 == false) goto L6;
                int r104 = 1;
            L7:
                r102.writeInt(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecuteCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onFailedToast(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = 0;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
            public void onSuccess(int r100, Intent r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecuteCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSuccess(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecuteCallback
            public void onFailedDialog(String r100, String r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r103.writeString(r100);     // Catch: Throwable -> L17
                r103.writeString(r101);     // Catch: Throwable -> L17
                if (r102 == false) goto L6;
                int r105 = 1;
            L7:
                r103.writeInt(r105);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecuteCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onFailedDialog(r100, r101, r102);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L6:
                r105 = 0;
            L17:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecuteCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static RemoteForwardExecuteCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static RemoteForwardExecuteCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof RemoteForwardExecuteCallback) == false) goto L12;
            return (RemoteForwardExecuteCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(RemoteForwardExecuteCallback r100) {
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
            if (r100 == 1) goto L24;
            boolean r104 = false;
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            String r105 = r101.readString();
            if (r101.readInt() == 0) goto L22;
            r104 = true;
        L22:
            onFailedToast(r105, r104);
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            String r106 = r101.readString();
            String r107 = r101.readString();
            if (r101.readInt() == 0) goto L17;
            r104 = true;
        L17:
            onFailedDialog(r106, r107, r104);
            r102.writeNoException();
            return true;
        L9:
            if (r100 != 1598968902) goto L11;
            r102.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        L24:
            r101.enforceInterface(DESCRIPTOR);
            int r108 = r101.readInt();
            if (r101.readInt() == 0) goto L27;
            Intent r109 = (Intent) Intent.CREATOR.createFromParcel(r101);
        L28:
            onSuccess(r108, r109);
            r102.writeNoException();
            return true;
        L27:
            r109 = null;
            goto L28
        }
    }

    void onFailedDialog(String r100, String r101, boolean r102) throws RemoteException;

    void onFailedToast(String r100, boolean r101) throws RemoteException;

    void onSuccess(int r100, Intent r101) throws RemoteException;
}
