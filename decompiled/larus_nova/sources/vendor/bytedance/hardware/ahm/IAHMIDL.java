package vendor.bytedance.hardware.ahm;

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
public interface IAHMIDL extends IInterface {

    /* JADX INFO: loaded from: classes41.dex */
    public static class Default implements IAHMIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // vendor.bytedance.hardware.ahm.IAHMIDL
        public long ipc_ahm_close() throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.hardware.ahm.IAHMIDL
        public long ipc_ahm_open(IAHMCallbackIDL r100) throws RemoteException {
            return 0;
        }

        @Override // vendor.bytedance.hardware.ahm.IAHMIDL
        public long ipc_ahm_open_v2(IAHMCallbackIDL r100, int r101) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IAHMIDL {
        private static final String DESCRIPTOR = "vendor.bytedance.hardware.ahm.IAHMIDL";
        static final int TRANSACTION_ipc_ahm_close = 2;
        static final int TRANSACTION_ipc_ahm_open = 1;
        static final int TRANSACTION_ipc_ahm_open_v2 = 3;

        public static class Proxy implements IAHMIDL {
            public static IAHMIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // vendor.bytedance.hardware.ahm.IAHMIDL
            public long ipc_ahm_close() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_vendor_bytedance_hardware_ahm_IAHMIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                long r102 = r101.readLong();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r103 = Stub.getDefaultImpl().ipc_ahm_close();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // vendor.bytedance.hardware.ahm.IAHMIDL
            public long ipc_ahm_open(IAHMCallbackIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_vendor_bytedance_hardware_ahm_IAHMIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                long r104 = r102.readLong();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                long r105 = Stub.getDefaultImpl().ipc_ahm_open(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r105;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // vendor.bytedance.hardware.ahm.IAHMIDL
            public long ipc_ahm_open_v2(IAHMCallbackIDL r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r104 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L17
                r102.writeInt(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_vendor_bytedance_hardware_ahm_IAHMIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                long r105 = r103.readLong();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                long r106 = Stub.getDefaultImpl().ipc_ahm_open_v2(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r106;
            L6:
                r104 = null;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_vendor_bytedance_hardware_ahm_IAHMIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAHMIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAHMIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAHMIDL) == false) goto L12;
            return (IAHMIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAHMIDL r100) {
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
            long r104 = ipc_ahm_open(IAHMCallbackIDL.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            r102.writeLong(r104);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            long r105 = ipc_ahm_close();
            r102.writeNoException();
            r102.writeLong(r105);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            long r106 = ipc_ahm_open_v2(IAHMCallbackIDL.Stub.asInterface(r101.readStrongBinder()), r101.readInt());
            r102.writeNoException();
            r102.writeLong(r106);
            return true;
        L9:
            if (r100 != 1598968902) goto L11;
            r102.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    long ipc_ahm_close() throws RemoteException;

    long ipc_ahm_open(IAHMCallbackIDL r100) throws RemoteException;

    long ipc_ahm_open_v2(IAHMCallbackIDL r100, int r101) throws RemoteException;
}
