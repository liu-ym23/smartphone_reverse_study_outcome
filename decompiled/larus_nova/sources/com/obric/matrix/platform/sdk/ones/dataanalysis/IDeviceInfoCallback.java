package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public interface IDeviceInfoCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback";

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IDeviceInfoCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback
        public void onDeviceId(String r100) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback
        public void onInstallId(String r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDeviceInfoCallback {
        static final int TRANSACTION_onDeviceId = 1;
        static final int TRANSACTION_onInstallId = 2;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IDeviceInfoCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IDeviceInfoCallback.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback
            public void onDeviceId(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IDeviceInfoCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeString(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_dataanalysis_IDeviceInfoCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDeviceInfoCallback
            public void onInstallId(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IDeviceInfoCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeString(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_dataanalysis_IDeviceInfoCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_dataanalysis_IDeviceInfoCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IDeviceInfoCallback.DESCRIPTOR);
        }

        public static IDeviceInfoCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IDeviceInfoCallback.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDeviceInfoCallback) == false) goto L12;
            return (IDeviceInfoCallback) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(IDeviceInfoCallback.DESCRIPTOR);
        L8:
            if (r100 != 1598968902) goto L11;
            r102.writeString(IDeviceInfoCallback.DESCRIPTOR);
            return true;
        L11:
            if (r100 != 1) goto L13;
            onDeviceId(r101.readString());
            r102.writeNoException();
        L18:
            return true;
        L13:
            if (r100 != 2) goto L15;
            onInstallId(r101.readString());
            r102.writeNoException();
            goto L18
        L15:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onDeviceId(String r100) throws RemoteException;

    void onInstallId(String r100) throws RemoteException;
}
