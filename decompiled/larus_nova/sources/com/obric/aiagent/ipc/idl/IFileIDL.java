package com.obric.aiagent.ipc.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFileIDL extends IInterface {

    /* JADX INFO: loaded from: classes6.dex */
    public static class Default implements IFileIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.ipc.idl.IFileIDL
        public boolean deleteFile(FilePath r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.ipc.idl.IFileIDL
        public List listAllFile(FilePath r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.ipc.idl.IFileIDL
        public List listDir(FilePath r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.ipc.idl.IFileIDL
        public ParcelFileDescriptor openFile(FilePath r100, int r101) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IFileIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.ipc.idl.IFileIDL";
        static final int TRANSACTION_deleteFile = 4;
        static final int TRANSACTION_listAllFile = 3;
        static final int TRANSACTION_listDir = 2;
        static final int TRANSACTION_openFile = 1;

        public static class Proxy implements IFileIDL {
            public static IFileIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.ipc.idl.IFileIDL
            public boolean deleteFile(FilePath r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_ipc_idl_IFileIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L20
                if (r102.readInt() != 0) goto L18;
                r103 = false;
            L18:
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r104 = Stub.getDefaultImpl().deleteFile(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.ipc.idl.IFileIDL
            public List listAllFile(FilePath r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_ipc_idl_IFileIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                ArrayList r103 = r102.readArrayList(getClass().getClassLoader());     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                List r104 = Stub.getDefaultImpl().listAllFile(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.ipc.idl.IFileIDL
            public List listDir(FilePath r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_ipc_idl_IFileIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                ArrayList r103 = r102.readArrayList(getClass().getClassLoader());     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                List r104 = Stub.getDefaultImpl().listDir(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.ipc.idl.IFileIDL
            public ParcelFileDescriptor openFile(FilePath r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L21
            L7:
                r102.writeInt(r101);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_obric_aiagent_ipc_idl_IFileIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L21
                if (r103.readInt() == 0) goto L18;
                ParcelFileDescriptor r104 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L21
            L19:
                r103.recycle();
                r102.recycle();
                return r104;
            L18:
                r104 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                ParcelFileDescriptor r105 = Stub.getDefaultImpl().openFile(r100, r101);     // Catch: Throwable -> L21
                r103.recycle();
                r102.recycle();
                return r105;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_ipc_idl_IFileIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFileIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFileIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFileIDL) == false) goto L12;
            return (IFileIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFileIDL r100) {
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
            FilePath r104 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L34;
            r104 = FilePath.CREATOR.createFromParcel(r101);
        L34:
            ParcelFileDescriptor r105 = openFile(r104, r101.readInt());
            r102.writeNoException();
            if (r105 == null) goto L37;
            r102.writeInt(1);
            r105.writeToParcel(r102, 1);
        L38:
            return true;
        L37:
            r102.writeInt(0);
            goto L38
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L29;
            r104 = FilePath.CREATOR.createFromParcel(r101);
        L29:
            List r106 = listDir(r104);
            r102.writeNoException();
            r102.writeList(r106);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L24;
            r104 = FilePath.CREATOR.createFromParcel(r101);
        L24:
            List r107 = listAllFile(r104);
            r102.writeNoException();
            r102.writeList(r107);
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L19;
            r104 = FilePath.CREATOR.createFromParcel(r101);
        L19:
            boolean r108 = deleteFile(r104);
            r102.writeNoException();
            r102.writeInt(r108 ? 1 : 0);
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    boolean deleteFile(FilePath r100) throws RemoteException;

    List listAllFile(FilePath r100) throws RemoteException;

    List listDir(FilePath r100) throws RemoteException;

    ParcelFileDescriptor openFile(FilePath r100, int r101) throws RemoteException;
}
