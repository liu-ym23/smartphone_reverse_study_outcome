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
public interface IServerCallback extends IInterface {
    public static final String DESCRIPTOR = "com.obric.matrix.platform.server.IServerCallback";

    public static class Default implements IServerCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.matrix.platform.server.IServerCallback
        public void onResult(int r100, byte[] r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IServerCallback {
        static final int TRANSACTION_onResult = 1;

        public static class Proxy implements IServerCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IServerCallback.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.obric.matrix.platform.server.IServerCallback
            public void onResult(int r100, byte[] r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(IServerCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeInt(r100);     // Catch: Throwable -> L6
                r102.writeByteArray(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_obric_matrix_platform_server_IServerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0);     // Catch: Throwable -> L6
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
            public static boolean INVOKEINTERFACE_com_obric_matrix_platform_server_IServerCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IServerCallback.DESCRIPTOR);
        }

        public static IServerCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IServerCallback.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IServerCallback) == false) goto L12;
            return (IServerCallback) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(IServerCallback.DESCRIPTOR);
        L8:
            if (r100 != 1598968902) goto L11;
            r102.writeString(IServerCallback.DESCRIPTOR);
            return true;
        L11:
            if (r100 != 1) goto L13;
            onResult(r101.readInt(), r101.createByteArray());
            r102.writeNoException();
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onResult(int r100, byte[] r101) throws RemoteException;
}
