package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowFrontierIDL extends IInterface {
    public static final int STATE_CONNECTED = 1;
    public static final int STATE_CONNECTING = 0;
    public static final int STATE_DISCONNECTED = 2;

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowFrontierIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void cacheScreenshot(int r100, Bitmap r101, Map r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void cacheScreenshotFd(int r100, String r101, ParcelFileDescriptor r102, Map r103) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public int getState() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void registerDataListener(int r100, IFlowFrontierDataListenerIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void registerStateListener(int r100, IFlowFrontierStateListenerIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void sendData(int r100, byte[] r101, Map r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void unregisterDataListener(int r100, IFlowFrontierDataListenerIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
        public void unregisterStateListener(int r100, IFlowFrontierStateListenerIDL r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowFrontierIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowFrontierIDL";
        static final int TRANSACTION_cacheScreenshot = 7;
        static final int TRANSACTION_cacheScreenshotFd = 8;
        static final int TRANSACTION_getState = 1;
        static final int TRANSACTION_registerDataListener = 2;
        static final int TRANSACTION_registerStateListener = 4;
        static final int TRANSACTION_sendData = 6;
        static final int TRANSACTION_unregisterDataListener = 3;
        static final int TRANSACTION_unregisterStateListener = 5;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowFrontierIDL {
            public static IFlowFrontierIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public int getState() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getState();     // Catch: Throwable -> L13
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

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void registerDataListener(int r100, IFlowFrontierDataListenerIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeInt(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerDataListener(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void registerStateListener(int r100, IFlowFrontierStateListenerIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeInt(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerStateListener(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void unregisterDataListener(int r100, IFlowFrontierDataListenerIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeInt(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterDataListener(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void unregisterStateListener(int r100, IFlowFrontierStateListenerIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeInt(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterStateListener(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void cacheScreenshot(int r100, Bitmap r101, Map r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r103.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L17
            L7:
                r103.writeMap(r102);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cacheScreenshot(r100, r101, r102);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void sendData(int r100, byte[] r101, Map r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r103.writeInt(r100);     // Catch: Throwable -> L12
                r103.writeByteArray(r101);     // Catch: Throwable -> L12
                r103.writeMap(r102);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r103, null, 1) == false) goto L6;
            L10:
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendData(r100, r101, r102);     // Catch: Throwable -> L12
                r103.recycle();
                return;
            L12:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowFrontierIDL
            public void cacheScreenshotFd(int r100, String r101, ParcelFileDescriptor r102, Map r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r104.writeInt(r100);     // Catch: Throwable -> L16
                r104.writeString(r101);     // Catch: Throwable -> L16
                if (r102 == null) goto L6;
                r104.writeInt(1);     // Catch: Throwable -> L16
                r102.writeToParcel(r104, 0);     // Catch: Throwable -> L16
            L7:
                r104.writeMap(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r104, null, 1) == false) goto L10;
            L14:
                r104.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cacheScreenshotFd(r100, r101, r102, r103);     // Catch: Throwable -> L16
                r104.recycle();
                return;
            L6:
                r104.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowFrontierIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFlowFrontierIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowFrontierIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowFrontierIDL) == false) goto L12;
            return (IFlowFrontierIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowFrontierIDL r100) {
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
            if (r100 == 1598968902) goto L30;
            Bitmap r104 = null;
            ParcelFileDescriptor r105 = null;
            switch(r100) {
                case 1: goto L28;
                case 2: goto L26;
                case 3: goto L24;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L13;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            int r106 = r101.readInt();
            String r107 = r101.readString();
            if (r101.readInt() == 0) goto L11;
            r105 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(r101);
        L11:
            cacheScreenshotFd(r106, r107, r105, r101.readHashMap(getClass().getClassLoader()));
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            int r108 = r101.readInt();
            if (r101.readInt() == 0) goto L16;
            r104 = (Bitmap) Bitmap.CREATOR.createFromParcel(r101);
        L16:
            cacheScreenshot(r108, r104, r101.readHashMap(getClass().getClassLoader()));
            r102.writeNoException();
            return true;
        L18:
            r101.enforceInterface(DESCRIPTOR);
            sendData(r101.readInt(), r101.createByteArray(), r101.readHashMap(getClass().getClassLoader()));
            return true;
        L20:
            r101.enforceInterface(DESCRIPTOR);
            unregisterStateListener(r101.readInt(), IFlowFrontierStateListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L22:
            r101.enforceInterface(DESCRIPTOR);
            registerStateListener(r101.readInt(), IFlowFrontierStateListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L24:
            r101.enforceInterface(DESCRIPTOR);
            unregisterDataListener(r101.readInt(), IFlowFrontierDataListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L26:
            r101.enforceInterface(DESCRIPTOR);
            registerDataListener(r101.readInt(), IFlowFrontierDataListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L28:
            r101.enforceInterface(DESCRIPTOR);
            int r109 = getState();
            r102.writeNoException();
            r102.writeInt(r109);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L30:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void cacheScreenshot(int r100, Bitmap r101, Map r102) throws RemoteException;

    void cacheScreenshotFd(int r100, String r101, ParcelFileDescriptor r102, Map r103) throws RemoteException;

    int getState() throws RemoteException;

    void registerDataListener(int r100, IFlowFrontierDataListenerIDL r101) throws RemoteException;

    void registerStateListener(int r100, IFlowFrontierStateListenerIDL r101) throws RemoteException;

    void sendData(int r100, byte[] r101, Map r102) throws RemoteException;

    void unregisterDataListener(int r100, IFlowFrontierDataListenerIDL r101) throws RemoteException;

    void unregisterStateListener(int r100, IFlowFrontierStateListenerIDL r101) throws RemoteException;
}
