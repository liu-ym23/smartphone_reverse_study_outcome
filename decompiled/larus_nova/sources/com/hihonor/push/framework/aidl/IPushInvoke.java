package com.hihonor.push.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public interface IPushInvoke extends IInterface {

    public static class Default implements IPushInvoke {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.push.framework.aidl.IPushInvoke
        public void call(DataBuffer r100, IPushCallback r101) {
        }
    }

    public static abstract class Stub extends Binder implements IPushInvoke {
        private static final String DESCRIPTOR = "com.hihonor.push.framework.aidl.IPushInvoke";
        public static final int TRANSACTION_call = 1;

        public static class Proxy implements IPushInvoke {
            public static IPushInvoke sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.hihonor.push.framework.aidl.IPushInvoke
            public void call(DataBuffer r100, IPushCallback r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L19
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L19
            L7:
                if (r101 == null) goto L9;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L19
            L10:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_hihonor_push_framework_aidl_IPushInvoke$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L19
            L15:
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().call(r100, r101);     // Catch: Throwable -> L19
                goto L15
            L9:
                r104 = null;
                goto L10
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_hihonor_push_framework_aidl_IPushInvoke$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPushInvoke asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IPushInvoke) == false) goto L12;
            return (IPushInvoke) r101;
        L12:
            return new Proxy(r100);
        }

        public static IPushInvoke getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPushInvoke r100) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r100 == null) goto L7;
            Proxy.sDefaultImpl = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L13;
            DataBuffer r104 = DataBuffer.CREATOR.createFromParcel(r101);
        L14:
            call(r104, IPushCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L13:
            r104 = null;
            goto L14
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void call(DataBuffer r100, IPushCallback r101);
}
