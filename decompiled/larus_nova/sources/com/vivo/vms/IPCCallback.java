package com.vivo.vms;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public interface IPCCallback extends IInterface {
    public static final String DESCRIPTOR = "com.vivo.vms.IPCCallback";

    public static class Default implements IPCCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.vivo.vms.IPCCallback
        public void call(Bundle r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IPCCallback {
        static final int TRANSACTION_call = 1;

        public static class Proxy implements IPCCallback {
            public static IPCCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IPCCallback.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.vivo.vms.IPCCallback
            public void call(Bundle r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IPCCallback.DESCRIPTOR);     // Catch: Throwable -> L14
                if (INVOKEINTERFACE_com_vivo_vms_IPCCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L14
                if (r102.readInt() != 0) goto L12;
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L12:
                r100.readFromParcel(r102);     // Catch: Throwable -> L14
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().call(r100);     // Catch: Throwable -> L14
            L14:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_vivo_vms_IPCCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IPCCallback.DESCRIPTOR);
        }

        public static IPCCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IPCCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IPCCallback.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IPCCallback) == false) goto L12;
            return (IPCCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IPCCallback r100) {
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
            if (r100 == 1598968902) goto L9;
            if (r100 != 1) goto L6;
            r101.enforceInterface(IPCCallback.DESCRIPTOR);
            Bundle r104 = new Bundle();
            call(r104);
            r102.writeNoException();
            r102.writeInt(1);
            r104.writeToParcel(r102, 1);
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L9:
            r102.writeString(IPCCallback.DESCRIPTOR);
            return true;
        }
    }

    void call(Bundle r100) throws RemoteException;
}
