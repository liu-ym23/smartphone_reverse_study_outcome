package com.obric.capabilitykit.common.execution.fileaccess;

import android.net.Uri;
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
public interface IUriFileSharer extends IInterface {

    public static class Default implements IUriFileSharer {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileSharer
        public int onRequestUriAccess(IUriFileReceiver r100, Uri r101, String r102) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IUriFileSharer {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.execution.fileaccess.IUriFileSharer";
        public static final int TRANSACTION_onRequestUriAccess = 1;

        public static class Proxy implements IUriFileSharer {
            public static IUriFileSharer sDefaultImpl;
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

            @Override // com.obric.capabilitykit.common.execution.fileaccess.IUriFileSharer
            public int onRequestUriAccess(IUriFileReceiver r100, Uri r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                IBinder r105 = r100.asBinder();     // Catch: Throwable -> L20
            L7:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L20
                if (r101 == null) goto L10;
                r103.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L20
            L11:
                r103.writeString(r102);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_execution_fileaccess_IUriFileSharer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L20
                int r106 = r104.readInt();     // Catch: Throwable -> L20
            L16:
                r104.recycle();
                r103.recycle();
                return r106;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                r106 = Stub.getDefaultImpl().onRequestUriAccess(r100, r101, r102);     // Catch: Throwable -> L20
                goto L16
            L10:
                r103.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r105 = null;
            L20:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_execution_fileaccess_IUriFileSharer$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IUriFileSharer asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IUriFileSharer) == false) goto L12;
            return (IUriFileSharer) r101;
        L12:
            return new Proxy(r100);
        }

        public static IUriFileSharer getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IUriFileSharer r100) {
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
            IUriFileReceiver r104 = IUriFileReceiver.Stub.asInterface(r101.readStrongBinder());
            if (r101.readInt() == 0) goto L13;
            Uri r105 = (Uri) Uri.CREATOR.createFromParcel(r101);
        L14:
            int r106 = onRequestUriAccess(r104, r105, r101.readString());
            r102.writeNoException();
            r102.writeInt(r106);
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

    int onRequestUriAccess(IUriFileReceiver r100, Uri r101, String r102) throws RemoteException;
}
