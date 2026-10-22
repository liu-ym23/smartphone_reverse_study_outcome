package com.oplus.ocs.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.oplus.ocs.base.common.CapabilityInfo;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public interface IAuthenticationListener extends IInterface {
    public static final String DESCRIPTOR = "com.oplus.ocs.base.IAuthenticationListener";

    public static class Default implements IAuthenticationListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.oplus.ocs.base.IAuthenticationListener
        public void onFail(int r100) throws RemoteException {
        }

        @Override // com.oplus.ocs.base.IAuthenticationListener
        public void onSuccess(CapabilityInfo r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAuthenticationListener {
        static final int TRANSACTION_onFail = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements IAuthenticationListener {
            public static IAuthenticationListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IAuthenticationListener.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.oplus.ocs.base.IAuthenticationListener
            public void onFail(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IAuthenticationListener.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_oplus_ocs_base_IAuthenticationListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onFail(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.oplus.ocs.base.IAuthenticationListener
            public void onSuccess(CapabilityInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IAuthenticationListener.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_oplus_ocs_base_IAuthenticationListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSuccess(r100);     // Catch: Throwable -> L16
                goto L12
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_oplus_ocs_base_IAuthenticationListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IAuthenticationListener.DESCRIPTOR);
        }

        public static IAuthenticationListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAuthenticationListener asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IAuthenticationListener.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAuthenticationListener) == false) goto L12;
            return (IAuthenticationListener) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAuthenticationListener r100) {
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
            if (r100 == 1598968902) goto L17;
            if (r100 != 1) goto L6;
            r101.enforceInterface(IAuthenticationListener.DESCRIPTOR);
            if (r101.readInt() == 0) goto L14;
            CapabilityInfo r104 = CapabilityInfo.CREATOR.createFromParcel(r101);
        L15:
            onSuccess(r104);
            r102.writeNoException();
            return true;
        L14:
            r104 = null;
            goto L15
        L6:
            if (r100 != 2) goto L8;
            r101.enforceInterface(IAuthenticationListener.DESCRIPTOR);
            onFail(r101.readInt());
            r102.writeNoException();
            return true;
        L8:
            return super.onTransact(r100, r101, r102, r103);
        L17:
            r102.writeString(IAuthenticationListener.DESCRIPTOR);
            return true;
        }
    }

    void onFail(int r100) throws RemoteException;

    void onSuccess(CapabilityInfo r100) throws RemoteException;
}
