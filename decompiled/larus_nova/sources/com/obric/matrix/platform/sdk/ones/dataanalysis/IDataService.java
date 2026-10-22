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
public interface IDataService extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService";

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IDataService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public String getDeviceId() throws RemoteException {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public String getInstallId() throws RemoteException {
            return null;
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public void onEvent(String r100, String r101) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public void registerDeviceInfoListener(IDeviceInfoCallback r100) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
        public void unregisterDeviceInfoListener(IDeviceInfoCallback r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDataService {
        static final int TRANSACTION_getDeviceId = 1;
        static final int TRANSACTION_getInstallId = 2;
        static final int TRANSACTION_onEvent = 5;
        static final int TRANSACTION_registerDeviceInfoListener = 3;
        static final int TRANSACTION_unregisterDeviceInfoListener = 4;

        public static class Proxy implements IDataService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IDataService.DESCRIPTOR;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public String getDeviceId() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(IDataService.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_dataanalysis_IDataService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                String r102 = r101.readString();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public String getInstallId() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(IDataService.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_dataanalysis_IDataService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                String r102 = r101.readString();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
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

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void registerDeviceInfoListener(IDeviceInfoCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IDataService.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeStrongInterface(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_dataanalysis_IDataService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void unregisterDeviceInfoListener(IDeviceInfoCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IDataService.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeStrongInterface(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_dataanalysis_IDataService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService
            public void onEvent(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(IDataService.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeString(r100);     // Catch: Throwable -> L6
                r102.writeString(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_dataanalysis_IDataService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, r103, 0);     // Catch: Throwable -> L6
                r103.readException();     // Catch: Throwable -> L6
                r103.recycle();
                r102.recycle();
                return;
            L6:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_matrix_platform_sdk_ones_dataanalysis_IDataService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IDataService.DESCRIPTOR);
        }

        public static IDataService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IDataService.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDataService) == false) goto L12;
            return (IDataService) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(IDataService.DESCRIPTOR);
        L8:
            if (r100 != 1598968902) goto L11;
            r102.writeString(IDataService.DESCRIPTOR);
            return true;
        L11:
            if (r100 != 1) goto L13;
            String r104 = getDeviceId();
            r102.writeNoException();
            r102.writeString(r104);
        L27:
            return true;
        L13:
            if (r100 != 2) goto L15;
            String r105 = getInstallId();
            r102.writeNoException();
            r102.writeString(r105);
            goto L27
        L15:
            if (r100 != 3) goto L17;
            registerDeviceInfoListener(IDeviceInfoCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L27
        L17:
            if (r100 != 4) goto L19;
            unregisterDeviceInfoListener(IDeviceInfoCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L27
        L19:
            if (r100 != 5) goto L21;
            onEvent(r101.readString(), r101.readString());
            r102.writeNoException();
            goto L27
        L21:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    String getDeviceId() throws RemoteException;

    String getInstallId() throws RemoteException;

    void onEvent(String r100, String r101) throws RemoteException;

    void registerDeviceInfoListener(IDeviceInfoCallback r100) throws RemoteException;

    void unregisterDeviceInfoListener(IDeviceInfoCallback r100) throws RemoteException;
}
