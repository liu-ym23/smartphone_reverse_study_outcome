package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IPlatformApiIDL extends IInterface {

    /* JADX INFO: loaded from: classes6.dex */
    public static class Default implements IPlatformApiIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
        public List<String> getTasksPackages(int r100, boolean r101, boolean r102, int r103) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
        public boolean moveTaskToDisplay(int r100, int r101, boolean r102) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IPlatformApiIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IPlatformApiIDL";
        static final int TRANSACTION_getTasksPackages = 2;
        static final int TRANSACTION_moveTaskToDisplay = 1;

        public static class Proxy implements IPlatformApiIDL {
            public static IPlatformApiIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
            public boolean moveTaskToDisplay(int r100, int r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r103.writeInt(r100);     // Catch: Throwable -> L20
                r103.writeInt(r101);     // Catch: Throwable -> L20
                boolean r105 = true;
                if (r102 == false) goto L6;
                int r106 = 1;
            L7:
                r103.writeInt(r106);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IPlatformApiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L20
                if (r104.readInt() != 0) goto L18;
                r105 = false;
            L18:
                r104.recycle();
                r103.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r107 = Stub.getDefaultImpl().moveTaskToDisplay(r100, r101, r102);     // Catch: Throwable -> L20
                r104.recycle();
                r103.recycle();
                return r107;
            L6:
                r106 = 0;
            L20:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
            public List<String> getTasksPackages(int r100, boolean r101, boolean r102, int r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r104.writeInt(r100);     // Catch: Throwable -> L21
                int r106 = 1;
                if (r101 == false) goto L6;
                int r107 = 1;
            L7:
                r104.writeInt(r107);     // Catch: Throwable -> L21
                if (r102 == true) goto L11;
                r106 = 0;
            L11:
                r104.writeInt(r106);     // Catch: Throwable -> L21
                r104.writeInt(r103);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IPlatformApiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r104, r105, 0) == false) goto L14;
            L18:
                r105.readException();     // Catch: Throwable -> L21
                ArrayList<String> r108 = r105.createStringArrayList();     // Catch: Throwable -> L21
                r105.recycle();
                r104.recycle();
                return r108;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                List<String> r109 = Stub.getDefaultImpl().getTasksPackages(r100, r101, r102, r103);     // Catch: Throwable -> L21
                r105.recycle();
                r104.recycle();
                return r109;
            L6:
                r107 = 0;
            L21:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IPlatformApiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IPlatformApiIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IPlatformApiIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IPlatformApiIDL) == false) goto L12;
            return (IPlatformApiIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IPlatformApiIDL r100) {
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
            int r105 = r101.readInt();
            int r106 = r101.readInt();
            if (r101.readInt() == 0) goto L24;
            r104 = true;
        L24:
            boolean r107 = moveTaskToDisplay(r105, r106, r104);
            r102.writeNoException();
            r102.writeInt(r107 ? 1 : 0);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            int r108 = r101.readInt();
            if (r101.readInt() == 0) goto L15;
            boolean r109 = true;
        L17:
            if (r101.readInt() == 0) goto L19;
            r104 = true;
        L19:
            List<String> r110 = getTasksPackages(r108, r109, r104, r101.readInt());
            r102.writeNoException();
            r102.writeStringList(r110);
            return true;
        L15:
            r109 = false;
            goto L17
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    List<String> getTasksPackages(int r100, boolean r101, boolean r102, int r103) throws RemoteException;

    boolean moveTaskToDisplay(int r100, int r101, boolean r102) throws RemoteException;
}
