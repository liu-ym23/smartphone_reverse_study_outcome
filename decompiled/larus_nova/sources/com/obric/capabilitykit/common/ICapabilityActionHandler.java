package com.obric.capabilitykit.common;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface ICapabilityActionHandler extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements ICapabilityActionHandler {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int getVersion() throws RemoteException {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleAction(String r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleIntentCalling(IntentCalling r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int isTaskRunning(String r100, String r101) throws RemoteException {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean openUriFile(Uri r100, IUriFileReceiver r101, String r102) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopAction(String r100, String r101) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopComplexTask(String r100) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityActionHandler {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityActionHandler";
        public static final int TRANSACTION_getVersion = 1;
        public static final int TRANSACTION_handleAction = 2;
        public static final int TRANSACTION_handleIntentCalling = 3;
        public static final int TRANSACTION_isTaskRunning = 7;
        public static final int TRANSACTION_openUriFile = 4;
        public static final int TRANSACTION_stopAction = 6;
        public static final int TRANSACTION_stopComplexTask = 5;

        public static class Proxy implements ICapabilityActionHandler {
            public static ICapabilityActionHandler sDefaultImpl;
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

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public int getVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L12
                int r102 = r101.readInt();     // Catch: Throwable -> L12
            L8:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r102 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean handleAction(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().handleAction(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean handleIntentCalling(IntentCalling r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L10;
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
                boolean r104 = Stub.getDefaultImpl().handleIntentCalling(r100);     // Catch: Throwable -> L20
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

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public int isTaskRunning(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L12
                int r104 = r103.readInt();     // Catch: Throwable -> L12
            L8:
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r104 = Stub.getDefaultImpl().isTaskRunning(r100, r101);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean openUriFile(Uri r100, IUriFileReceiver r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                boolean r105 = true;
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L23
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L23
            L7:
                if (r101 == null) goto L9;
                IBinder r106 = r101.asBinder();     // Catch: Throwable -> L23
            L10:
                r103.writeStrongBinder(r106);     // Catch: Throwable -> L23
                r103.writeString(r102);     // Catch: Throwable -> L23
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, r104, 0) == false) goto L13;
            L17:
                r104.readException();     // Catch: Throwable -> L23
                if (r104.readInt() != 0) goto L21;
                r105 = false;
            L21:
                r104.recycle();
                r103.recycle();
                return r105;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                boolean r107 = Stub.getDefaultImpl().openUriFile(r100, r101, r102);     // Catch: Throwable -> L23
                r104.recycle();
                r103.recycle();
                return r107;
            L9:
                r106 = null;
                goto L10
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean stopAction(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r102.writeString(r100);     // Catch: Throwable -> L15
                r102.writeString(r101);     // Catch: Throwable -> L15
                boolean r104 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r102, r103, 0) == false) goto L6;
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
                boolean r105 = Stub.getDefaultImpl().stopAction(r100, r101);     // Catch: Throwable -> L15
                r103.recycle();
                r102.recycle();
                return r105;
            L15:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
            public boolean stopComplexTask(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().stopComplexTask(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityActionHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICapabilityActionHandler asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICapabilityActionHandler) == false) goto L12;
            return (ICapabilityActionHandler) r101;
        L12:
            return new Proxy(r100);
        }

        public static ICapabilityActionHandler getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityActionHandler r100) {
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
            if (r100 == 1598968902) goto L23;
            IntentCalling r104 = null;
            Uri r105 = null;
            switch(r100) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L17;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            int r106 = isTaskRunning(r101.readString(), r101.readString());
        L9:
            r102.writeNoException();
            r102.writeInt(r106);
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            r106 = stopAction(r101.readString(), r101.readString());
            goto L9
        L12:
            r101.enforceInterface(DESCRIPTOR);
            r106 = stopComplexTask(r101.readString());
            goto L9
        L13:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L16;
            r105 = (Uri) Uri.CREATOR.createFromParcel(r101);
        L16:
            r106 = openUriFile(r105, IUriFileReceiver.Stub.asInterface(r101.readStrongBinder()), r101.readString());
            goto L9
        L17:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L20;
            r104 = IntentCalling.CREATOR.createFromParcel(r101);
        L20:
            r106 = handleIntentCalling(r104);
            goto L9
        L21:
            r101.enforceInterface(DESCRIPTOR);
            r106 = handleAction(r101.readString());
            goto L9
        L22:
            r101.enforceInterface(DESCRIPTOR);
            r106 = getVersion();
            goto L9
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L23:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getVersion() throws RemoteException;

    boolean handleAction(String r100) throws RemoteException;

    boolean handleIntentCalling(IntentCalling r100) throws RemoteException;

    int isTaskRunning(String r100, String r101) throws RemoteException;

    boolean openUriFile(Uri r100, IUriFileReceiver r101, String r102) throws RemoteException;

    boolean stopAction(String r100, String r101) throws RemoteException;

    boolean stopComplexTask(String r100) throws RemoteException;
}
