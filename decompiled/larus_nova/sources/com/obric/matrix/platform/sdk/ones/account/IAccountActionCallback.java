package com.obric.matrix.platform.sdk.ones.account;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface IAccountActionCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback";

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IAccountActionCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
        public void onResult(boolean r100, Bundle r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAccountActionCallback {
        static final int TRANSACTION_onResult = 1;

        /* JADX INFO: loaded from: classes33.dex */
        public static class Proxy implements IAccountActionCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IAccountActionCallback.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
            public void onResult(boolean r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(IAccountActionCallback.DESCRIPTOR);     // Catch: Throwable -> L14
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r102.writeInt(r103);     // Catch: Throwable -> L14
                if (r101 == null) goto L10;
                r102.writeInt(1);     // Catch: Throwable -> L14
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L14
            L11:
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountActionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1);     // Catch: Throwable -> L14
                r102.recycle();
                return;
            L10:
                r102.writeInt(0);     // Catch: Throwable -> L14
                goto L11
            L6:
                r103 = 0;
            L14:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_account_IAccountActionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IAccountActionCallback.DESCRIPTOR);
        }

        public static IAccountActionCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IAccountActionCallback.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAccountActionCallback) == false) goto L12;
            return (IAccountActionCallback) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(IAccountActionCallback.DESCRIPTOR);
        L8:
            if (r100 != 1598968902) goto L11;
            r102.writeString(IAccountActionCallback.DESCRIPTOR);
            return true;
        L11:
            if (r100 == 1) goto L15;
            return super.onTransact(r100, r101, r102, r103);
        L15:
            if (r101.readInt() == 0) goto L17;
            boolean r104 = true;
        L18:
            Parcelable.Creator r105 = Bundle.CREATOR;
            if (r101.readInt() == 0) goto L21;
            Object r106 = r105.createFromParcel(r101);
        L22:
            onResult(r104, (Bundle) r106);
            return true;
        L21:
            r106 = null;
            goto L22
        L17:
            r104 = false;
            goto L18
        }
    }

    void onResult(boolean r100, Bundle r101) throws RemoteException;
}
