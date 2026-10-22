package com.obric.cae.libs.accel;

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
public interface ICaeAccel extends IInterface {

    public static class Default implements ICaeAccel {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageAccelEnable(String r100, boolean r101) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageAutoDualWlanMode(String r100, int r101) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.accel.ICaeAccel
        public int setPackageFlowSched(String r100, boolean r101) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeAccel {
        private static final String DESCRIPTOR = "com.obric.cae.libs.accel.ICaeAccel";
        static final int TRANSACTION_setPackageAccelEnable = 1;
        static final int TRANSACTION_setPackageAutoDualWlanMode = 3;
        static final int TRANSACTION_setPackageFlowSched = 2;

        public static class Proxy implements ICaeAccel {
            public static ICaeAccel sDefaultImpl;
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

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageAccelEnable(String r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeInt(r101 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_accel_ICaeAccel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                int r104 = r103.readInt();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r105 = Stub.getDefaultImpl().setPackageAccelEnable(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageAutoDualWlanMode(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeInt(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_accel_ICaeAccel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                int r104 = r103.readInt();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r105 = Stub.getDefaultImpl().setPackageAutoDualWlanMode(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.accel.ICaeAccel
            public int setPackageFlowSched(String r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeInt(r101 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_accel_ICaeAccel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                int r104 = r103.readInt();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r105 = Stub.getDefaultImpl().setPackageFlowSched(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_accel_ICaeAccel$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICaeAccel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeAccel asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICaeAccel) == false) goto L12;
            return (ICaeAccel) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICaeAccel r100) {
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
            boolean r104 = false;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            String r105 = r101.readString();
            if (r101.readInt() == 0) goto L24;
            r104 = true;
        L24:
            int r106 = setPackageAccelEnable(r105, r104);
            r102.writeNoException();
            r102.writeInt(r106);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            String r107 = r101.readString();
            if (r101.readInt() == 0) goto L19;
            r104 = true;
        L19:
            int r108 = setPackageFlowSched(r107, r104);
            r102.writeNoException();
            r102.writeInt(r108);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            int r109 = setPackageAutoDualWlanMode(r101.readString(), r101.readInt());
            r102.writeNoException();
            r102.writeInt(r109);
            return true;
        L9:
            if (r100 != 1598968902) goto L11;
            r102.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    int setPackageAccelEnable(String r100, boolean r101) throws RemoteException;

    int setPackageAutoDualWlanMode(String r100, int r101) throws RemoteException;

    int setPackageFlowSched(String r100, boolean r101) throws RemoteException;
}
