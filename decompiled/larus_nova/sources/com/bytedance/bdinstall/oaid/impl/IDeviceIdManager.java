package com.bytedance.bdinstall.oaid.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes8.dex */
public interface IDeviceIdManager extends IInterface {

    public static class Default implements IDeviceIdManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getAAID(String r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getCoolOsVersion() throws RemoteException {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getIMEI(String r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getOAID(String r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getUDID(String r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public String getVAID(String r100) throws RemoteException {
            return null;
        }

        @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
        public boolean isCoolOs() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceIdManager {
        private static final String DESCRIPTOR = "com.coolpad.deviceidsupport.IDeviceIdManager";
        static final int TRANSACTION_getAAID = 4;
        static final int TRANSACTION_getCoolOsVersion = 7;
        static final int TRANSACTION_getIMEI = 5;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_getUDID = 1;
        static final int TRANSACTION_getVAID = 3;
        static final int TRANSACTION_isCoolOs = 6;

        public static class Proxy implements IDeviceIdManager {
            public static IDeviceIdManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getCoolOsVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IDeviceIdManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getCoolOsVersion();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public boolean isCoolOs() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IDeviceIdManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().isCoolOs();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
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

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getAAID(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IDeviceIdManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r104 = Stub.getDefaultImpl().getAAID(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getIMEI(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IDeviceIdManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r104 = Stub.getDefaultImpl().getIMEI(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getOAID(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IDeviceIdManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r104 = Stub.getDefaultImpl().getOAID(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getUDID(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IDeviceIdManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r104 = Stub.getDefaultImpl().getUDID(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.bdinstall.oaid.impl.IDeviceIdManager
            public String getVAID(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IDeviceIdManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r104 = Stub.getDefaultImpl().getVAID(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_bdinstall_oaid_impl_IDeviceIdManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IDeviceIdManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDeviceIdManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDeviceIdManager) == false) goto L12;
            return (IDeviceIdManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IDeviceIdManager r100) {
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
            if (r100 == 1598968902) goto L21;
            switch(r100) {
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            String r104 = getCoolOsVersion();
            r102.writeNoException();
            r102.writeString(r104);
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            boolean r105 = isCoolOs();
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            String r106 = getIMEI(r101.readString());
            r102.writeNoException();
            r102.writeString(r106);
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            String r107 = getAAID(r101.readString());
            r102.writeNoException();
            r102.writeString(r107);
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            String r108 = getVAID(r101.readString());
            r102.writeNoException();
            r102.writeString(r108);
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            String r109 = getOAID(r101.readString());
            r102.writeNoException();
            r102.writeString(r109);
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            String r110 = getUDID(r101.readString());
            r102.writeNoException();
            r102.writeString(r110);
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L21:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getAAID(String r100) throws RemoteException;

    String getCoolOsVersion() throws RemoteException;

    String getIMEI(String r100) throws RemoteException;

    String getOAID(String r100) throws RemoteException;

    String getUDID(String r100) throws RemoteException;

    String getVAID(String r100) throws RemoteException;

    boolean isCoolOs() throws RemoteException;
}
