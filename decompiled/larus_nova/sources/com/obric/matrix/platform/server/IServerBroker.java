package com.obric.matrix.platform.server;

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
public interface IServerBroker extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.server.IServerBroker";

    public static class Default implements IServerBroker {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public byte[] invoke(int r100, byte[] r101) throws RemoteException {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public void invokeAsyn(int r100, byte[] r101, IServerCallback r102) throws RemoteException {
        }

        @Override // com.obric.matrix.platform.server.IServerBroker
        public void registerServerCallback(String r100, IServerCallback r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IServerBroker {
        static final int TRANSACTION_invoke = 1;
        static final int TRANSACTION_invokeAsyn = 2;
        static final int TRANSACTION_registerServerCallback = 3;

        public static class Proxy implements IServerBroker {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IServerBroker.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public byte[] invoke(int r100, byte[] r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(IServerBroker.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeInt(r100);     // Catch: Throwable -> L6
                r102.writeByteArray(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_server_IServerBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0);     // Catch: Throwable -> L6
                r103.readException();     // Catch: Throwable -> L6
                byte[] r104 = r103.createByteArray();     // Catch: Throwable -> L6
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.matrix.platform.server.IServerBroker
            public void registerServerCallback(String r100, IServerCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(IServerBroker.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeString(r100);     // Catch: Throwable -> L6
                r102.writeStrongInterface(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_server_IServerBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0);     // Catch: Throwable -> L6
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

            @Override // com.obric.matrix.platform.server.IServerBroker
            public void invokeAsyn(int r100, byte[] r101, IServerCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(IServerBroker.DESCRIPTOR);     // Catch: Throwable -> L6
                r103.writeInt(r100);     // Catch: Throwable -> L6
                r103.writeByteArray(r101);     // Catch: Throwable -> L6
                r103.writeStrongInterface(r102);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_server_IServerBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, r104, 0);     // Catch: Throwable -> L6
                r104.readException();     // Catch: Throwable -> L6
                r104.recycle();
                r103.recycle();
                return;
            L6:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_matrix_platform_server_IServerBroker$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IServerBroker.DESCRIPTOR);
        }

        public static IServerBroker asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IServerBroker.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IServerBroker) == false) goto L12;
            return (IServerBroker) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(IServerBroker.DESCRIPTOR);
        L8:
            if (r100 != 1598968902) goto L11;
            r102.writeString(IServerBroker.DESCRIPTOR);
            return true;
        L11:
            if (r100 != 1) goto L13;
            byte[] r104 = invoke(r101.readInt(), r101.createByteArray());
            r102.writeNoException();
            r102.writeByteArray(r104);
        L21:
            return true;
        L13:
            if (r100 != 2) goto L15;
            invokeAsyn(r101.readInt(), r101.createByteArray(), IServerCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L21
        L15:
            if (r100 != 3) goto L17;
            registerServerCallback(r101.readString(), IServerCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            goto L21
        L17:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    byte[] invoke(int r100, byte[] r101) throws RemoteException;

    void invokeAsyn(int r100, byte[] r101, IServerCallback r102) throws RemoteException;

    void registerServerCallback(String r100, IServerCallback r101) throws RemoteException;
}
