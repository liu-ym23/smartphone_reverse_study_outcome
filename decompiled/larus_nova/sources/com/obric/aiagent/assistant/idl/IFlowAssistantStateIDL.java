package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowAssistantStateIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowAssistantStateIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public int getCurrentNightMode() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public boolean isActive() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public boolean isBackgroundIntercepting() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void registerNightModeListener(IFlowNightModeChangeListenerIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
        public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowAssistantStateIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL";
        static final int TRANSACTION_getCurrentNightMode = 9;
        static final int TRANSACTION_isActive = 1;
        static final int TRANSACTION_isBackgroundIntercepting = 6;
        static final int TRANSACTION_registerActiveStateListener = 2;
        static final int TRANSACTION_registerBackgroundInterceptingListener = 7;
        static final int TRANSACTION_registerNightModeListener = 10;
        static final int TRANSACTION_registerTTSStateListener = 4;
        static final int TRANSACTION_unregisterActiveStateListener = 3;
        static final int TRANSACTION_unregisterBackgroundInterceptingListener = 8;
        static final int TRANSACTION_unregisterNightModeListener = 11;
        static final int TRANSACTION_unregisterTTSStateListener = 5;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowAssistantStateIDL {
            public static IFlowAssistantStateIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public int getCurrentNightMode() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getCurrentNightMode();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public boolean isActive() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isActive();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public boolean isBackgroundIntercepting() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isBackgroundIntercepting();     // Catch: Throwable -> L15
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

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerActiveStateListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerBackgroundInterceptingListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void registerNightModeListener(IFlowNightModeChangeListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerNightModeListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerTTSStateListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterActiveStateListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterBackgroundInterceptingListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterNightModeListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAssistantStateIDL
            public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterTTSStateListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAssistantStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFlowAssistantStateIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowAssistantStateIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowAssistantStateIDL) == false) goto L12;
            return (IFlowAssistantStateIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowAssistantStateIDL r100) {
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
            if (r100 == 1598968902) goto L29;
            switch(r100) {
                case 1: goto L27;
                case 2: goto L25;
                case 3: goto L23;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L17;
                case 7: goto L15;
                case 8: goto L13;
                case 9: goto L11;
                case 10: goto L9;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            unregisterNightModeListener(IFlowNightModeChangeListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            registerNightModeListener(IFlowNightModeChangeListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            int r104 = getCurrentNightMode();
            r102.writeNoException();
            r102.writeInt(r104);
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            boolean r105 = isBackgroundIntercepting();
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L21:
            r101.enforceInterface(DESCRIPTOR);
            registerTTSStateListener(IFlowAssistantTTSStateListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L23:
            r101.enforceInterface(DESCRIPTOR);
            unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L25:
            r101.enforceInterface(DESCRIPTOR);
            registerActiveStateListener(IFlowAssistantActiveStateListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L27:
            r101.enforceInterface(DESCRIPTOR);
            boolean r106 = isActive();
            r102.writeNoException();
            r102.writeInt(r106 ? 1 : 0);
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L29:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getCurrentNightMode() throws RemoteException;

    boolean isActive() throws RemoteException;

    boolean isBackgroundIntercepting() throws RemoteException;

    void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r100) throws RemoteException;

    void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r100) throws RemoteException;

    void registerNightModeListener(IFlowNightModeChangeListenerIDL r100) throws RemoteException;

    void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r100) throws RemoteException;

    void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r100) throws RemoteException;

    void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r100) throws RemoteException;

    void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r100) throws RemoteException;

    void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r100) throws RemoteException;
}
