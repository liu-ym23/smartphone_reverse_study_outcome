package com.obric.memorydata.sdk.memory;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface IMemoryService extends IInterface {

    public static class Default implements IMemoryService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public boolean getDialogueMemoryEnableState() throws RemoteException {
            return false;
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void registerMemoryCallback(IMemoryCallback r100) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void saveAssistantChatMemory(String r100, String r101, Bundle r102) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.memory.IMemoryService
        public void syncAssistantChat(String r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMemoryService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.memory.IMemoryService";
        static final int TRANSACTION_getDialogueMemoryEnableState = 3;
        static final int TRANSACTION_registerMemoryCallback = 1;
        static final int TRANSACTION_saveAssistantChatMemory = 2;
        static final int TRANSACTION_syncAssistantChat = 4;

        public static class Proxy implements IMemoryService {
            public static IMemoryService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.memorydata.sdk.memory.IMemoryService
            public boolean getDialogueMemoryEnableState() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_memory_IMemoryService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().getDialogueMemoryEnableState();     // Catch: Throwable -> L15
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

            @Override // com.obric.memorydata.sdk.memory.IMemoryService
            public void registerMemoryCallback(IMemoryCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_memory_IMemoryService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerMemoryCallback(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.memory.IMemoryService
            public void syncAssistantChat(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_memory_IMemoryService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().syncAssistantChat(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.memory.IMemoryService
            public void saveAssistantChatMemory(String r100, String r101, Bundle r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r103.writeString(r100);     // Catch: Throwable -> L16
                r103.writeString(r101);     // Catch: Throwable -> L16
                if (r102 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L16
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_memory_IMemoryService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, null, 1) == false) goto L10;
            L14:
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().saveAssistantChatMemory(r100, r101, r102);     // Catch: Throwable -> L16
                r103.recycle();
                return;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_memory_IMemoryService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IMemoryService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IMemoryService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IMemoryService) == false) goto L12;
            return (IMemoryService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IMemoryService r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            registerMemoryCallback(IMemoryCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            String r104 = r101.readString();
            String r105 = r101.readString();
            if (r101.readInt() == 0) goto L23;
            Bundle r106 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L24:
            saveAssistantChatMemory(r104, r105, r106);
            return true;
        L23:
            r106 = null;
            goto L24
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            boolean r107 = getDialogueMemoryEnableState();
            r102.writeNoException();
            r102.writeInt(r107 ? 1 : 0);
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            syncAssistantChat(r101.readString());
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    boolean getDialogueMemoryEnableState() throws RemoteException;

    void registerMemoryCallback(IMemoryCallback r100) throws RemoteException;

    void saveAssistantChatMemory(String r100, String r101, Bundle r102) throws RemoteException;

    void syncAssistantChat(String r100) throws RemoteException;
}
