package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface IAssistantInteractionListener extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IAssistantInteractionListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onAssistantDied() {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onAssistantTakeOver() {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onPanelCancel() {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onPanelHeightChanged(int r100) {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onPanelShow(int r100) {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void onReply(String r100) {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void requestToShowInputPanel() {
        }

        @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
        public void requestToShowInputPanelWithMeta(String r100) {
        }
    }

    public static abstract class Stub extends Binder implements IAssistantInteractionListener {
        private static final String DESCRIPTOR = "com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener";
        public static final int TRANSACTION_onAssistantDied = 7;
        public static final int TRANSACTION_onAssistantTakeOver = 1;
        public static final int TRANSACTION_onPanelCancel = 3;
        public static final int TRANSACTION_onPanelHeightChanged = 5;
        public static final int TRANSACTION_onPanelShow = 4;
        public static final int TRANSACTION_onReply = 2;
        public static final int TRANSACTION_requestToShowInputPanel = 6;
        public static final int TRANSACTION_requestToShowInputPanelWithMeta = 8;

        public static class Proxy implements IAssistantInteractionListener {
            public static IAssistantInteractionListener sDefaultImpl;
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

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onAssistantDied() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_IAssistantInteractionListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L12
            L8:
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAssistantDied();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onAssistantTakeOver() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_IAssistantInteractionListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L12
            L8:
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAssistantTakeOver();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onPanelCancel() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_IAssistantInteractionListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L12
            L8:
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelCancel();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onPanelHeightChanged(int r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_IAssistantInteractionListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelHeightChanged(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onPanelShow(int r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_IAssistantInteractionListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPanelShow(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void onReply(String r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_IAssistantInteractionListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onReply(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void requestToShowInputPanel() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_IAssistantInteractionListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L12
            L8:
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().requestToShowInputPanel();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener
            public void requestToShowInputPanelWithMeta(String r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_IAssistantInteractionListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().requestToShowInputPanelWithMeta(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_eventkit_eventstaskmanager_IAssistantInteractionListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IAssistantInteractionListener asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAssistantInteractionListener) == false) goto L12;
            return (IAssistantInteractionListener) r101;
        L12:
            return new Proxy(r100);
        }

        public static IAssistantInteractionListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAssistantInteractionListener r100) {
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
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
            if (r100 == 1598968902) goto L17;
            switch(r100) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            requestToShowInputPanelWithMeta(r101.readString());
        L8:
            r102.writeNoException();
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            onAssistantDied();
            goto L8
        L11:
            r101.enforceInterface(DESCRIPTOR);
            requestToShowInputPanel();
            goto L8
        L12:
            r101.enforceInterface(DESCRIPTOR);
            onPanelHeightChanged(r101.readInt());
            goto L8
        L13:
            r101.enforceInterface(DESCRIPTOR);
            onPanelShow(r101.readInt());
            goto L8
        L14:
            r101.enforceInterface(DESCRIPTOR);
            onPanelCancel();
            goto L8
        L15:
            r101.enforceInterface(DESCRIPTOR);
            onReply(r101.readString());
            goto L8
        L16:
            r101.enforceInterface(DESCRIPTOR);
            onAssistantTakeOver();
            goto L8
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L17:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onAssistantDied();

    void onAssistantTakeOver();

    void onPanelCancel();

    void onPanelHeightChanged(int r100);

    void onPanelShow(int r100);

    void onReply(String r100);

    void requestToShowInputPanel();

    void requestToShowInputPanelWithMeta(String r100);
}
