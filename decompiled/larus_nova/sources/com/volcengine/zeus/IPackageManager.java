package com.volcengine.zeus;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public interface IPackageManager extends IInterface {

    /* JADX INFO: loaded from: classes41.dex */
    public static class Default implements IPackageManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.volcengine.zeus.IPackageManager
        public int getInstalledVersion(String r100) throws RemoteException {
            return 0;
        }

        @Override // com.volcengine.zeus.IPackageManager
        public boolean isPluginInstalled(String r100) throws RemoteException {
            return false;
        }

        @Override // com.volcengine.zeus.IPackageManager
        public boolean syncInstallPackage(String r100, String r101) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IPackageManager {
        private static final String DESCRIPTOR = "com.volcengine.zeus.IPackageManager";
        static final int TRANSACTION_getInstalledVersion = 2;
        static final int TRANSACTION_isPluginInstalled = 1;
        static final int TRANSACTION_syncInstallPackage = 3;

        public static class Proxy implements IPackageManager {
            public static IPackageManager sDefaultImpl;
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

            @Override // com.volcengine.zeus.IPackageManager
            public int getInstalledVersion(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_volcengine_zeus_IPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                int r103 = r102.readInt();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r104 = Stub.getDefaultImpl().getInstalledVersion(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.volcengine.zeus.IPackageManager
            public boolean isPluginInstalled(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_volcengine_zeus_IPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().isPluginInstalled(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.volcengine.zeus.IPackageManager
            public boolean syncInstallPackage(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r102.writeString(r100);     // Catch: Throwable -> L15
                r102.writeString(r101);     // Catch: Throwable -> L15
                boolean r104 = false;
                if (INVOKEINTERFACE_com_volcengine_zeus_IPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L15
                if (r103.readInt() == 0) goto L13;
                r104 = true;
            L13:
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r105 = Stub.getDefaultImpl().syncInstallPackage(r100, r101);     // Catch: Throwable -> L15
                r103.recycle();
                r102.recycle();
                return r105;
            L15:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_volcengine_zeus_IPackageManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IPackageManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IPackageManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IPackageManager) == false) goto L12;
            return (IPackageManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IPackageManager r100) {
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
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            boolean r104 = isPluginInstalled(r101.readString());
            r102.writeNoException();
            r102.writeInt(r104 ? 1 : 0);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            int r105 = getInstalledVersion(r101.readString());
            r102.writeNoException();
            r102.writeInt(r105);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            boolean r106 = syncInstallPackage(r101.readString(), r101.readString());
            r102.writeNoException();
            r102.writeInt(r106 ? 1 : 0);
            return true;
        L9:
            if (r100 != 1598968902) goto L11;
            r102.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    int getInstalledVersion(String r100) throws RemoteException;

    boolean isPluginInstalled(String r100) throws RemoteException;

    boolean syncInstallPackage(String r100, String r101) throws RemoteException;
}
