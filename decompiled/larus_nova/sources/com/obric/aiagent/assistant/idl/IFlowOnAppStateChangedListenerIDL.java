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
public interface IFlowOnAppStateChangedListenerIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowOnAppStateChangedListenerIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
        public void onAllActivityDestroyed() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
        public void onAppBackground() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
        public void onAppForeground() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
        public void onMainBotChatPageResume(boolean r100, boolean r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowOnAppStateChangedListenerIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL";
        static final int TRANSACTION_onAllActivityDestroyed = 3;
        static final int TRANSACTION_onAppBackground = 1;
        static final int TRANSACTION_onAppForeground = 2;
        static final int TRANSACTION_onMainBotChatPageResume = 4;

        public static class Proxy implements IFlowOnAppStateChangedListenerIDL {
            public static IFlowOnAppStateChangedListenerIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
            public void onAllActivityDestroyed() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowOnAppStateChangedListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAllActivityDestroyed();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
            public void onAppBackground() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowOnAppStateChangedListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAppBackground();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
            public void onAppForeground() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowOnAppStateChangedListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAppForeground();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL
            public void onMainBotChatPageResume(boolean r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                int r103 = 0;
                if (r100 == false) goto L6;
                int r104 = 1;
            L7:
                r102.writeInt(r104);     // Catch: Throwable -> L19
                if (r101 == false) goto L10;
                r103 = 1;
            L10:
                r102.writeInt(r103);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowOnAppStateChangedListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r102, null, 1) == false) goto L13;
            L17:
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onMainBotChatPageResume(r100, r101);     // Catch: Throwable -> L19
                r102.recycle();
                return;
            L6:
                r104 = 0;
            L19:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowOnAppStateChangedListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFlowOnAppStateChangedListenerIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowOnAppStateChangedListenerIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowOnAppStateChangedListenerIDL) == false) goto L12;
            return (IFlowOnAppStateChangedListenerIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowOnAppStateChangedListenerIDL r100) {
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
            onAppBackground();
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            onAppForeground();
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            onAllActivityDestroyed();
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            boolean r104 = false;
            if (r101.readInt() == 0) goto L19;
            boolean r105 = true;
        L21:
            if (r101.readInt() == 0) goto L23;
            r104 = true;
        L23:
            onMainBotChatPageResume(r105, r104);
            return true;
        L19:
            r105 = false;
            goto L21
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onAllActivityDestroyed() throws RemoteException;

    void onAppBackground() throws RemoteException;

    void onAppForeground() throws RemoteException;

    void onMainBotChatPageResume(boolean r100, boolean r101) throws RemoteException;
}
