package com.obric.cae.libs.mpflow;

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
public interface ICaeMpflowManager extends IInterface {
    public static final int SMART_NETWORK_FLOW_NET_TYPE_CELLULAR_1 = 0;
    public static final int SMART_NETWORK_FLOW_NET_TYPE_CELLULAR_2 = 1;
    public static final int SMART_NETWORK_FLOW_NET_TYPE_WIFI_1 = 2;
    public static final int SMART_NETWORK_FLOW_NET_TYPE_WIFI_2 = 3;

    public static class Default implements ICaeMpflowManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int bindNetByPid(int r100, int r101, boolean r102) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int bindNetByUid(int r100, int r101, boolean r102) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByPid(int r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public void disconnectSocketByUid(int r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int modifyNetName(int r100, String r101) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int setSocketOptByUid(int r100, int r101, int r102) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByPid(int r100, int r101, boolean r102) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
        public int switchNetByUid(int r100, int r101, boolean r102) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICaeMpflowManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.mpflow.ICaeMpflowManager";
        static final int TRANSACTION_bindNetByPid = 5;
        static final int TRANSACTION_bindNetByUid = 3;
        static final int TRANSACTION_disconnectSocketByPid = 7;
        static final int TRANSACTION_disconnectSocketByUid = 6;
        static final int TRANSACTION_modifyNetName = 1;
        static final int TRANSACTION_setSocketOptByUid = 8;
        static final int TRANSACTION_switchNetByPid = 4;
        static final int TRANSACTION_switchNetByUid = 2;

        public static class Proxy implements ICaeMpflowManager {
            public static ICaeMpflowManager sDefaultImpl;
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

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public void disconnectSocketByPid(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().disconnectSocketByPid(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public void disconnectSocketByUid(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().disconnectSocketByUid(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int modifyNetName(int r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeInt(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                int r104 = r103.readInt();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r105 = Stub.getDefaultImpl().modifyNetName(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int bindNetByPid(int r100, int r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeInt(r100);     // Catch: Throwable -> L13
                r103.writeInt(r101);     // Catch: Throwable -> L13
                r103.writeInt(r102 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                int r105 = r104.readInt();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r105;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r106 = Stub.getDefaultImpl().bindNetByPid(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r106;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int bindNetByUid(int r100, int r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeInt(r100);     // Catch: Throwable -> L13
                r103.writeInt(r101);     // Catch: Throwable -> L13
                r103.writeInt(r102 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                int r105 = r104.readInt();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r105;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r106 = Stub.getDefaultImpl().bindNetByUid(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r106;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int setSocketOptByUid(int r100, int r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeInt(r100);     // Catch: Throwable -> L13
                r103.writeInt(r101);     // Catch: Throwable -> L13
                r103.writeInt(r102);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                int r105 = r104.readInt();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r105;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r106 = Stub.getDefaultImpl().setSocketOptByUid(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r106;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int switchNetByPid(int r100, int r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeInt(r100);     // Catch: Throwable -> L13
                r103.writeInt(r101);     // Catch: Throwable -> L13
                r103.writeInt(r102 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                int r105 = r104.readInt();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r105;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r106 = Stub.getDefaultImpl().switchNetByPid(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r106;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.mpflow.ICaeMpflowManager
            public int switchNetByUid(int r100, int r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeInt(r100);     // Catch: Throwable -> L13
                r103.writeInt(r101);     // Catch: Throwable -> L13
                r103.writeInt(r102 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                int r105 = r104.readInt();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r105;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r106 = Stub.getDefaultImpl().switchNetByUid(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r106;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_mpflow_ICaeMpflowManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICaeMpflowManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeMpflowManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICaeMpflowManager) == false) goto L12;
            return (ICaeMpflowManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICaeMpflowManager r100) {
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
            if (r100 == 1598968902) goto L36;
            boolean r104 = false;
            switch(r100) {
                case 1: goto L34;
                case 2: goto L29;
                case 3: goto L24;
                case 4: goto L19;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            int r105 = setSocketOptByUid(r101.readInt(), r101.readInt(), r101.readInt());
            r102.writeNoException();
            r102.writeInt(r105);
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            disconnectSocketByPid(r101.readInt());
            return true;
        L12:
            r101.enforceInterface(DESCRIPTOR);
            disconnectSocketByUid(r101.readInt());
            return true;
        L14:
            r101.enforceInterface(DESCRIPTOR);
            int r106 = r101.readInt();
            int r107 = r101.readInt();
            if (r101.readInt() == 0) goto L17;
            r104 = true;
        L17:
            int r108 = bindNetByPid(r106, r107, r104);
            r102.writeNoException();
            r102.writeInt(r108);
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            int r109 = r101.readInt();
            int r110 = r101.readInt();
            if (r101.readInt() == 0) goto L22;
            r104 = true;
        L22:
            int r111 = switchNetByPid(r109, r110, r104);
            r102.writeNoException();
            r102.writeInt(r111);
            return true;
        L24:
            r101.enforceInterface(DESCRIPTOR);
            int r112 = r101.readInt();
            int r113 = r101.readInt();
            if (r101.readInt() == 0) goto L27;
            r104 = true;
        L27:
            int r114 = bindNetByUid(r112, r113, r104);
            r102.writeNoException();
            r102.writeInt(r114);
            return true;
        L29:
            r101.enforceInterface(DESCRIPTOR);
            int r115 = r101.readInt();
            int r116 = r101.readInt();
            if (r101.readInt() == 0) goto L32;
            r104 = true;
        L32:
            int r117 = switchNetByUid(r115, r116, r104);
            r102.writeNoException();
            r102.writeInt(r117);
            return true;
        L34:
            r101.enforceInterface(DESCRIPTOR);
            int r118 = modifyNetName(r101.readInt(), r101.readString());
            r102.writeNoException();
            r102.writeInt(r118);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L36:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    int bindNetByPid(int r100, int r101, boolean r102) throws RemoteException;

    int bindNetByUid(int r100, int r101, boolean r102) throws RemoteException;

    void disconnectSocketByPid(int r100) throws RemoteException;

    void disconnectSocketByUid(int r100) throws RemoteException;

    int modifyNetName(int r100, String r101) throws RemoteException;

    int setSocketOptByUid(int r100, int r101, int r102) throws RemoteException;

    int switchNetByPid(int r100, int r101, boolean r102) throws RemoteException;

    int switchNetByUid(int r100, int r101, boolean r102) throws RemoteException;
}
