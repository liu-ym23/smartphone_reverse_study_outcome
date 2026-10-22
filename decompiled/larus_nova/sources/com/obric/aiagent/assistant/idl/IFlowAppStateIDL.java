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
public interface IFlowAppStateIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowAppStateIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
        public String getCurrentActivity() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
        public boolean isAppBackground() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
        public boolean isAppPaused() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
        public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
        public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowAppStateIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowAppStateIDL";
        static final int TRANSACTION_getCurrentActivity = 3;
        static final int TRANSACTION_isAppBackground = 1;
        static final int TRANSACTION_isAppPaused = 2;
        static final int TRANSACTION_registerAppStateListener = 4;
        static final int TRANSACTION_unregisterAppStateListener = 5;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowAppStateIDL {
            public static IFlowAppStateIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
            public String getCurrentActivity() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getCurrentActivity();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
            public boolean isAppBackground() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isAppBackground();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
            public boolean isAppPaused() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isAppPaused();     // Catch: Throwable -> L15
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

            @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
            public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerAppStateListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppStateIDL
            public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterAppStateListener(r100);     // Catch: Throwable -> L16
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
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppStateIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFlowAppStateIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowAppStateIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowAppStateIDL) == false) goto L12;
            return (IFlowAppStateIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowAppStateIDL r100) {
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
            boolean r104 = isAppBackground();
            r102.writeNoException();
            r102.writeInt(r104 ? 1 : 0);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            boolean r105 = isAppPaused();
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            String r106 = getCurrentActivity();
            r102.writeNoException();
            r102.writeString(r106);
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            registerAppStateListener(IFlowOnAppStateChangedListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L11:
            if (r100 != 5) goto L13;
            r101.enforceInterface(DESCRIPTOR);
            unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L13:
            if (r100 != 1598968902) goto L15;
            r102.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    String getCurrentActivity() throws RemoteException;

    boolean isAppBackground() throws RemoteException;

    boolean isAppPaused() throws RemoteException;

    void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r100) throws RemoteException;

    void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r100) throws RemoteException;
}
