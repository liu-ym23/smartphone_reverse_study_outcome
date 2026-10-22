package com.ss.android.lark.forwardv2.impl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes36.dex */
public interface RemoteForwardExecutor extends IInterface {

    public static class Default implements RemoteForwardExecutor {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecutor
        public void onForward(List<ForwardTarget> r100, Bundle r101, RemoteForwardExecuteCallback r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements RemoteForwardExecutor {
        private static final String DESCRIPTOR = "com.ss.android.lark.forwardv2.impl.RemoteForwardExecutor";
        static final int TRANSACTION_onForward = 1;

        public static class Proxy implements RemoteForwardExecutor {
            public static RemoteForwardExecutor sDefaultImpl;
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

            @Override // com.ss.android.lark.forwardv2.impl.RemoteForwardExecutor
            public void onForward(List<ForwardTarget> r100, Bundle r101, RemoteForwardExecuteCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r103.writeTypedList(r100);     // Catch: Throwable -> L20
                if (r101 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L20
            L7:
                if (r102 == null) goto L9;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L20
            L10:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecutor$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L13;
            L17:
                r104.readException();     // Catch: Throwable -> L20
                r104.recycle();
                r103.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onForward(r100, r101, r102);     // Catch: Throwable -> L20
                r104.recycle();
                r103.recycle();
                return;
            L9:
                r105 = null;
                goto L10
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_lark_forwardv2_impl_RemoteForwardExecutor$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static RemoteForwardExecutor getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static RemoteForwardExecutor asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof RemoteForwardExecutor) == false) goto L12;
            return (RemoteForwardExecutor) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(RemoteForwardExecutor r100) {
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
            ArrayList r104 = r101.createTypedArrayList(ForwardTarget.CREATOR);
            if (r101.readInt() == 0) goto L13;
            Bundle r105 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L14:
            onForward(r104, r105, RemoteForwardExecuteCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L13:
            r105 = null;
            goto L14
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onForward(List<ForwardTarget> r100, Bundle r101, RemoteForwardExecuteCallback r102) throws RemoteException;
}
