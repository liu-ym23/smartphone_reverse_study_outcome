package com.obric.assistant.activation.presentation.contract.ipc;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
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

/* JADX INFO: loaded from: classes32.dex */
public interface IInteractionSessionProxy extends IInterface {

    public static class Default implements IInteractionSessionProxy {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
        public void onHandleAssist(long r100, int r101, int r102, boolean r103, Bundle r104, AssistStructure r105, AssistContent r106) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
        public void onHandleScreenshot(long r100, Bitmap r101) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
        public void onSessionCreated(long r100, VoiceInteractionSessionController r101) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
        public void onSessionDestroyed(long r100) throws RemoteException {
        }

        @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
        public void onShow(long r100, Bundle r101, int r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IInteractionSessionProxy {
        private static final String DESCRIPTOR = "com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy";
        static final int TRANSACTION_onHandleAssist = 2;
        static final int TRANSACTION_onHandleScreenshot = 3;
        static final int TRANSACTION_onSessionCreated = 1;
        static final int TRANSACTION_onSessionDestroyed = 5;
        static final int TRANSACTION_onShow = 4;

        public static class Proxy implements IInteractionSessionProxy {
            public static IInteractionSessionProxy sDefaultImpl;
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

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
            public void onSessionDestroyed(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeLong(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSessionDestroyed(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
            public void onHandleScreenshot(long r100, Bitmap r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeLong(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onHandleScreenshot(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
            public void onSessionCreated(long r100, VoiceInteractionSessionController r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeLong(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L17
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSessionCreated(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = null;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
            public void onShow(long r100, Bundle r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r103.writeLong(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L17
            L7:
                r103.writeInt(r102);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onShow(r100, r101, r102);     // Catch: Throwable -> L17
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
            public void onHandleAssist(long r110, int r111, int r112, boolean r113, Bundle r114, AssistStructure r210, AssistContent r211) throws RemoteException {
                Parcel r115 = Parcel.obtain();
                Parcel r116 = Parcel.obtain();
                r115.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L30
                r115.writeLong(r110);     // Catch: Throwable -> L30
                r115.writeInt(r111);     // Catch: Throwable -> L30
                r115.writeInt(r112);     // Catch: Throwable -> L30
                if (r113 == false) goto L6;
                int r100 = 1;
            L7:
                r115.writeInt(r100);     // Catch: Throwable -> L30
                if (r114 == null) goto L10;
                r115.writeInt(1);     // Catch: Throwable -> L30
                r114.writeToParcel(r115, 0);     // Catch: Throwable -> L30
            L11:
                if (r210 == null) goto L13;
                r115.writeInt(1);     // Catch: Throwable -> L30
                r210.writeToParcel(r115, 0);     // Catch: Throwable -> L30
            L14:
                if (r211 == null) goto L16;
                r115.writeInt(1);     // Catch: Throwable -> L30
                r211.writeToParcel(r115, 0);     // Catch: Throwable -> L30
            L34:
            L28:
                th = th;
            L32:
                r116.recycle();
                r115.recycle();
                throw th;
            L19:
                if (INVOKEINTERFACE_com_obric_assistant_activation_presentation_contract_ipc_IInteractionSessionProxy$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r115, r116, 0) == false) goto L21;
            L25:
                r116.readException();     // Catch: Throwable -> L28
                r116.recycle();
                r115.recycle();
                return;
            L21:
                if (Stub.getDefaultImpl() == null) goto L25;
                Stub.getDefaultImpl().onHandleAssist(r110, r111, r112, r113, r114, r210, r211);     // Catch: Throwable -> L28
                r116.recycle();
                r115.recycle();
                return;
            L16:
                r115.writeInt(0);     // Catch: Throwable -> L30
                goto L34
            L13:
                r115.writeInt(0);     // Catch: Throwable -> L30
                goto L14
            L10:
                r115.writeInt(0);     // Catch: Throwable -> L30
                goto L11
            L6:
                r100 = 0;
            L30:
                th = th;
                goto L32
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInteractionSessionProxy getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IInteractionSessionProxy asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IInteractionSessionProxy) == false) goto L12;
            return (IInteractionSessionProxy) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IInteractionSessionProxy r100) {
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
        public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
            if (r110 == 1) goto L48;
            Bitmap r100 = null;
            Bundle r101 = null;
            if (r110 != 2) goto L7;
            r111.enforceInterface(DESCRIPTOR);
            long r102 = r111.readLong();
            int r103 = r111.readInt();
            int r104 = r111.readInt();
            if (r111.readInt() == 0) goto L33;
            boolean r105 = true;
        L35:
            if (r111.readInt() == 0) goto L37;
            Bundle r106 = (Bundle) Bundle.CREATOR.createFromParcel(r111);
        L39:
            if (r111.readInt() == 0) goto L41;
            AssistStructure r114 = (AssistStructure) AssistStructure.CREATOR.createFromParcel(r111);
        L43:
            if (r111.readInt() == 0) goto L45;
            AssistContent r115 = (AssistContent) AssistContent.CREATOR.createFromParcel(r111);
        L46:
            onHandleAssist(r102, r103, r104, r105, r106, r114, r115);
            r112.writeNoException();
            return true;
        L45:
            r115 = null;
            goto L46
        L41:
            r114 = null;
            goto L43
        L37:
            r106 = null;
            goto L39
        L33:
            r105 = false;
            goto L35
        L7:
            if (r110 != 3) goto L9;
            r111.enforceInterface(DESCRIPTOR);
            long r107 = r111.readLong();
            if (r111.readInt() == 0) goto L28;
            r100 = (Bitmap) Bitmap.CREATOR.createFromParcel(r111);
        L28:
            onHandleScreenshot(r107, r100);
            r112.writeNoException();
            return true;
        L9:
            if (r110 != 4) goto L11;
            r111.enforceInterface(DESCRIPTOR);
            long r108 = r111.readLong();
            if (r111.readInt() == 0) goto L23;
            r101 = (Bundle) Bundle.CREATOR.createFromParcel(r111);
        L23:
            onShow(r108, r101, r111.readInt());
            r112.writeNoException();
            return true;
        L11:
            if (r110 != 5) goto L13;
            r111.enforceInterface(DESCRIPTOR);
            onSessionDestroyed(r111.readLong());
            r112.writeNoException();
            return true;
        L13:
            if (r110 != 1598968902) goto L15;
            r112.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r110, r111, r112, r113);
        L48:
            r111.enforceInterface(DESCRIPTOR);
            onSessionCreated(r111.readLong(), VoiceInteractionSessionController.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            return true;
        }
    }

    void onHandleAssist(long r100, int r101, int r102, boolean r103, Bundle r104, AssistStructure r105, AssistContent r106) throws RemoteException;

    void onHandleScreenshot(long r100, Bitmap r101) throws RemoteException;

    void onSessionCreated(long r100, VoiceInteractionSessionController r101) throws RemoteException;

    void onSessionDestroyed(long r100) throws RemoteException;

    void onShow(long r100, Bundle r101, int r102) throws RemoteException;
}
