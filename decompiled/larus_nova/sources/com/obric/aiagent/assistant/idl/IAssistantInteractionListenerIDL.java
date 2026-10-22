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
public interface IAssistantInteractionListenerIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IAssistantInteractionListenerIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onAssistantDied() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onAssistantTakeOver() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onPanelCancel() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onPanelHeightChanged(int r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onPanelShow(int r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void onReply(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void requestToShowInputPanel() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
        public void requestToShowInputPanelWithMeta(String r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAssistantInteractionListenerIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL";
        static final int TRANSACTION_onAssistantDied = 7;
        static final int TRANSACTION_onAssistantTakeOver = 1;
        static final int TRANSACTION_onPanelCancel = 3;
        static final int TRANSACTION_onPanelHeightChanged = 5;
        static final int TRANSACTION_onPanelShow = 4;
        static final int TRANSACTION_onReply = 2;
        static final int TRANSACTION_requestToShowInputPanel = 6;
        static final int TRANSACTION_requestToShowInputPanelWithMeta = 8;

        public static class Proxy implements IAssistantInteractionListenerIDL {
            public static IAssistantInteractionListenerIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onAssistantDied() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAssistantInteractionListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAssistantDied();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onAssistantTakeOver() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAssistantInteractionListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAssistantTakeOver();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onPanelCancel() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAssistantInteractionListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelCancel();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void requestToShowInputPanel() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAssistantInteractionListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().requestToShowInputPanel();     // Catch: Throwable -> L12
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

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onPanelHeightChanged(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAssistantInteractionListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelHeightChanged(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onPanelShow(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAssistantInteractionListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelShow(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void onReply(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAssistantInteractionListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onReply(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
            public void requestToShowInputPanelWithMeta(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAssistantInteractionListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().requestToShowInputPanelWithMeta(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAssistantInteractionListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IAssistantInteractionListenerIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAssistantInteractionListenerIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAssistantInteractionListenerIDL) == false) goto L12;
            return (IAssistantInteractionListenerIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAssistantInteractionListenerIDL r100) {
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
            if (r100 == 1598968902) goto L23;
            switch(r100) {
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L11;
                case 7: goto L9;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            requestToShowInputPanelWithMeta(r101.readString());
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            onAssistantDied();
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            requestToShowInputPanel();
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            onPanelHeightChanged(r101.readInt());
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            onPanelShow(r101.readInt());
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            onPanelCancel();
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            onReply(r101.readString());
            return true;
        L21:
            r101.enforceInterface(DESCRIPTOR);
            onAssistantTakeOver();
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L23:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onAssistantDied() throws RemoteException;

    void onAssistantTakeOver() throws RemoteException;

    void onPanelCancel() throws RemoteException;

    void onPanelHeightChanged(int r100) throws RemoteException;

    void onPanelShow(int r100) throws RemoteException;

    void onReply(String r100) throws RemoteException;

    void requestToShowInputPanel() throws RemoteException;

    void requestToShowInputPanelWithMeta(String r100) throws RemoteException;
}
