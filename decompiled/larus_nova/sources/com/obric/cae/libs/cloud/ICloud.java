package com.obric.cae.libs.cloud;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface ICloud extends IInterface {

    public static class Default implements ICloud {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void postToCloud(String r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void registerCallback(ICloudEventCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void registerCallbackWithType(int r100, ICloudEventCallback r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void unregisterCallback(ICloudEventCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.cloud.ICloud
        public void updateUserConfigData(int r100, String r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICloud {
        private static final String DESCRIPTOR = "com.obric.cae.libs.cloud.ICloud";
        static final int TRANSACTION_postToCloud = 4;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerCallbackWithType = 2;
        static final int TRANSACTION_unregisterCallback = 3;
        static final int TRANSACTION_updateUserConfigData = 5;

        public static class Proxy implements ICloud {
            public static ICloud sDefaultImpl;
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void postToCloud(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_cloud_ICloud$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().postToCloud(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cloud.ICloud
            public void registerCallback(ICloudEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_cloud_ICloud$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void unregisterCallback(ICloudEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_cloud_ICloud$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.cloud.ICloud
            public void registerCallbackWithType(int r100, ICloudEventCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L17
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_cloud_ICloud$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallbackWithType(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = null;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.cloud.ICloud
            public void updateUserConfigData(int r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeInt(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_cloud_ICloud$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateUserConfigData(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_cloud_ICloud$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICloud getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICloud asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICloud) == false) goto L12;
            return (ICloud) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICloud r100) {
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
            if (r100 == 1598968902) goto L25;
            if (r100 != 1) goto L6;
            r101.enforceInterface(DESCRIPTOR);
            registerCallback(ICloudEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L6:
            if (r100 != 2) goto L8;
            r101.enforceInterface(DESCRIPTOR);
            registerCallbackWithType(r101.readInt(), ICloudEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L8:
            if (r100 != 3) goto L10;
            r101.enforceInterface(DESCRIPTOR);
            unregisterCallback(ICloudEventCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L10:
            if (r100 != 4) goto L12;
            r101.enforceInterface(DESCRIPTOR);
            postToCloud(r101.readString());
            r102.writeNoException();
            return true;
        L12:
            if (r100 != 5) goto L14;
            r101.enforceInterface(DESCRIPTOR);
            updateUserConfigData(r101.readInt(), r101.readString());
            r102.writeNoException();
            return true;
        L14:
            return super.onTransact(r100, r101, r102, r103);
        L25:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void postToCloud(String r100) throws RemoteException;

    void registerCallback(ICloudEventCallback r100) throws RemoteException;

    void registerCallbackWithType(int r100, ICloudEventCallback r101) throws RemoteException;

    void unregisterCallback(ICloudEventCallback r100) throws RemoteException;

    void updateUserConfigData(int r100, String r101) throws RemoteException;
}
