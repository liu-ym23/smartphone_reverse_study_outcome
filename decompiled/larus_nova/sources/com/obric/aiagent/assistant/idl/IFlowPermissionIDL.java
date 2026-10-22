package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Permission;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowPermissionIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowPermissionIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public Map isAppletPermissionGranted(String r100, List<String> r101) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public Map isPermissionGranted(List<String> r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public Map isPersonalPermissionGranted(String r100, List<String> r101) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public boolean requestPermission(String r100, String r101) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public void updateAppletPermissions(List<Permission> r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
        public void updatePersonalPermissions(List<Permission> r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowPermissionIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowPermissionIDL";
        static final int TRANSACTION_isAppletPermissionGranted = 3;
        static final int TRANSACTION_isPermissionGranted = 1;
        static final int TRANSACTION_isPersonalPermissionGranted = 5;
        static final int TRANSACTION_requestPermission = 2;
        static final int TRANSACTION_updateAppletPermissions = 4;
        static final int TRANSACTION_updatePersonalPermissions = 6;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowPermissionIDL {
            public static IFlowPermissionIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public Map isPermissionGranted(List<String> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStringList(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                HashMap r103 = r102.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r104 = Stub.getDefaultImpl().isPermissionGranted(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public void updateAppletPermissions(List<Permission> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeTypedList(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateAppletPermissions(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public void updatePersonalPermissions(List<Permission> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeTypedList(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updatePersonalPermissions(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public Map isAppletPermissionGranted(String r100, List<String> r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeStringList(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                HashMap r104 = r103.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r105 = Stub.getDefaultImpl().isAppletPermissionGranted(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public Map isPersonalPermissionGranted(String r100, List<String> r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeStringList(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                HashMap r104 = r103.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r105 = Stub.getDefaultImpl().isPersonalPermissionGranted(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
            public boolean requestPermission(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r102.writeString(r100);     // Catch: Throwable -> L15
                r102.writeString(r101);     // Catch: Throwable -> L15
                boolean r104 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L15
                if (r103.readInt() == 0) goto L13;
                r104 = true;
            L13:
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r105 = Stub.getDefaultImpl().requestPermission(r100, r101);     // Catch: Throwable -> L15
                r103.recycle();
                r102.recycle();
                return r105;
            L15:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowPermissionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFlowPermissionIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowPermissionIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowPermissionIDL) == false) goto L12;
            return (IFlowPermissionIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowPermissionIDL r100) {
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
            if (r100 == 1598968902) goto L19;
            switch(r100) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L13;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            updatePersonalPermissions(r101.createTypedArrayList(Permission.CREATOR));
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            Map r104 = isPersonalPermissionGranted(r101.readString(), r101.createStringArrayList());
            r102.writeNoException();
            r102.writeMap(r104);
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            updateAppletPermissions(r101.createTypedArrayList(Permission.CREATOR));
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            Map r105 = isAppletPermissionGranted(r101.readString(), r101.createStringArrayList());
            r102.writeNoException();
            r102.writeMap(r105);
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            boolean r106 = requestPermission(r101.readString(), r101.readString());
            r102.writeNoException();
            r102.writeInt(r106 ? 1 : 0);
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            Map r107 = isPermissionGranted(r101.createStringArrayList());
            r102.writeNoException();
            r102.writeMap(r107);
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L19:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    Map isAppletPermissionGranted(String r100, List<String> r101) throws RemoteException;

    Map isPermissionGranted(List<String> r100) throws RemoteException;

    Map isPersonalPermissionGranted(String r100, List<String> r101) throws RemoteException;

    boolean requestPermission(String r100, String r101) throws RemoteException;

    void updateAppletPermissions(List<Permission> r100) throws RemoteException;

    void updatePersonalPermissions(List<Permission> r100) throws RemoteException;
}
