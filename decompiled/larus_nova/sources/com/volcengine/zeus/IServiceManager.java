package com.volcengine.zeus;

import android.content.ComponentName;
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

/* JADX INFO: loaded from: classes.dex */
public interface IServiceManager extends IInterface {

    /* JADX INFO: loaded from: classes41.dex */
    public static class Default implements IServiceManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.volcengine.zeus.IServiceManager
        public boolean bindService(Intent r100, ServiceConnection r101, int r102, String r103) throws RemoteException {
            return false;
        }

        @Override // com.volcengine.zeus.IServiceManager
        public ComponentName startService(Intent r100, String r101) throws RemoteException {
            return null;
        }

        @Override // com.volcengine.zeus.IServiceManager
        public boolean stopService(Intent r100, String r101) throws RemoteException {
            return false;
        }

        @Override // com.volcengine.zeus.IServiceManager
        public void unbindService(ServiceConnection r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IServiceManager {
        private static final String DESCRIPTOR = "com.volcengine.zeus.IServiceManager";
        static final int TRANSACTION_bindService = 3;
        static final int TRANSACTION_startService = 1;
        static final int TRANSACTION_stopService = 2;
        static final int TRANSACTION_unbindService = 4;

        /* JADX INFO: loaded from: classes41.dex */
        public static class Proxy implements IServiceManager {
            public static IServiceManager sDefaultImpl;
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

            @Override // com.volcengine.zeus.IServiceManager
            public void unbindService(ServiceConnection r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_volcengine_zeus_IServiceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unbindService(r100);     // Catch: Throwable -> L17
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

            @Override // com.volcengine.zeus.IServiceManager
            public ComponentName startService(Intent r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L21
            L7:
                r102.writeString(r101);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_volcengine_zeus_IServiceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L21
                if (r103.readInt() == 0) goto L18;
                ComponentName r104 = (ComponentName) ComponentName.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L21
            L19:
                r103.recycle();
                r102.recycle();
                return r104;
            L18:
                r104 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ComponentName r105 = Stub.getDefaultImpl().startService(r100, r101);     // Catch: Throwable -> L21
                r103.recycle();
                r102.recycle();
                return r105;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.volcengine.zeus.IServiceManager
            public boolean stopService(Intent r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r104 = true;
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                r102.writeString(r101);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_volcengine_zeus_IServiceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L20
                if (r103.readInt() != 0) goto L18;
                r104 = false;
            L18:
                r103.recycle();
                r102.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r105 = Stub.getDefaultImpl().stopService(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return r105;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.volcengine.zeus.IServiceManager
            public boolean bindService(Intent r100, ServiceConnection r101, int r102, String r110) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                boolean r105 = true;
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L23
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L23
            L7:
                if (r101 == null) goto L9;
                IBinder r106 = r101.asBinder();     // Catch: Throwable -> L23
            L10:
                r103.writeStrongBinder(r106);     // Catch: Throwable -> L23
                r103.writeInt(r102);     // Catch: Throwable -> L23
                r103.writeString(r110);     // Catch: Throwable -> L23
                if (INVOKEINTERFACE_com_volcengine_zeus_IServiceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r103, r104, 0) == false) goto L13;
            L17:
                r104.readException();     // Catch: Throwable -> L23
                if (r104.readInt() != 0) goto L21;
                r105 = false;
            L21:
                r104.recycle();
                r103.recycle();
                return r105;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                boolean r107 = Stub.getDefaultImpl().bindService(r100, r101, r102, r110);     // Catch: Throwable -> L23
                r104.recycle();
                r103.recycle();
                return r107;
            L9:
                r106 = null;
                goto L10
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_volcengine_zeus_IServiceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IServiceManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IServiceManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IServiceManager) == false) goto L12;
            return (IServiceManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IServiceManager r100) {
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
            Intent r104 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L31;
            r104 = (Intent) Intent.CREATOR.createFromParcel(r101);
        L31:
            ComponentName r105 = startService(r104, r101.readString());
            r102.writeNoException();
            if (r105 == null) goto L34;
            r102.writeInt(1);
            r105.writeToParcel(r102, 1);
        L35:
            return true;
        L34:
            r102.writeInt(0);
            goto L35
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L26;
            r104 = (Intent) Intent.CREATOR.createFromParcel(r101);
        L26:
            boolean r106 = stopService(r104, r101.readString());
            r102.writeNoException();
            r102.writeInt(r106 ? 1 : 0);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L21;
            r104 = (Intent) Intent.CREATOR.createFromParcel(r101);
        L21:
            boolean r107 = bindService(r104, ServiceConnection.Stub.asInterface(r101.readStrongBinder()), r101.readInt(), r101.readString());
            r102.writeNoException();
            r102.writeInt(r107 ? 1 : 0);
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            unbindService(ServiceConnection.Stub.asInterface(r101.readStrongBinder()));
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

    boolean bindService(Intent r100, ServiceConnection r101, int r102, String r103) throws RemoteException;

    ComponentName startService(Intent r100, String r101) throws RemoteException;

    boolean stopService(Intent r100, String r101) throws RemoteException;

    void unbindService(ServiceConnection r100) throws RemoteException;
}
