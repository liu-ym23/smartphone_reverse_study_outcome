package com.obric.capabilitykit.common.execution.fileaccess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface IUriFileReceiver extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IUriFileReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver
        public void onSessionReady(UriFileAccessSession r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUriFileReceiver {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver";
        public static final int TRANSACTION_onSessionReady = 1;

        public static class Proxy implements IUriFileReceiver {
            public static IUriFileReceiver sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver
            public void onSessionReady(UriFileAccessSession r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_execution_fileaccess_IUriFileReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSessionReady(r100);     // Catch: Throwable -> L16
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
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_execution_fileaccess_IUriFileReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IUriFileReceiver asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IUriFileReceiver) == false) goto L12;
            return (IUriFileReceiver) r101;
        L12:
            return new Proxy(r100);
        }

        public static IUriFileReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IUriFileReceiver r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L13;
            UriFileAccessSession r104 = UriFileAccessSession.CREATOR.createFromParcel(r101);
        L14:
            onSessionReady(r104);
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

    void onSessionReady(UriFileAccessSession r100) throws RemoteException;
}
