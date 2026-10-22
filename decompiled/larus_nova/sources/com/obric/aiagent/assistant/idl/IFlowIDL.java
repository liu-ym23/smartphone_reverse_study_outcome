package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowAppIntentIDL getAppIntentIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowAppLogIDL getAppLogIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowAppStateIDL getAppStateIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowAssistantStateIDL getAssistantStateIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowCocreationReviewIDL getCocreationReviewIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFileIDL getFileIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowFeedbackIDL getFlowFeedbackIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowNetworkIDL getFlowNetworkIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowPermissionIDL getFlowPermissionIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowFrontierIDL getFrontierIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowMessageIDL getMessageIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowSettingsIDL getSettingsIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowUiIDL getUiIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowIDL
        public IFlowVoiceInteractionIDL getVoiceInteractionIDL() throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IFlowIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowIDL";
        static final int TRANSACTION_getAppIntentIDL = 7;
        static final int TRANSACTION_getAppLogIDL = 2;
        static final int TRANSACTION_getAppStateIDL = 4;
        static final int TRANSACTION_getAssistantStateIDL = 10;
        static final int TRANSACTION_getCocreationReviewIDL = 14;
        static final int TRANSACTION_getFileIDL = 1;
        static final int TRANSACTION_getFlowFeedbackIDL = 13;
        static final int TRANSACTION_getFlowNetworkIDL = 11;
        static final int TRANSACTION_getFlowPermissionIDL = 12;
        static final int TRANSACTION_getFrontierIDL = 3;
        static final int TRANSACTION_getMessageIDL = 9;
        static final int TRANSACTION_getSettingsIDL = 5;
        static final int TRANSACTION_getUiIDL = 6;
        static final int TRANSACTION_getVoiceInteractionIDL = 8;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowIDL {
            public static IFlowIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowAppIntentIDL getAppIntentIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowAppIntentIDL r102 = IFlowAppIntentIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowAppIntentIDL r103 = Stub.getDefaultImpl().getAppIntentIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowAppLogIDL getAppLogIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowAppLogIDL r102 = IFlowAppLogIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowAppLogIDL r103 = Stub.getDefaultImpl().getAppLogIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowAppStateIDL getAppStateIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowAppStateIDL r102 = IFlowAppStateIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowAppStateIDL r103 = Stub.getDefaultImpl().getAppStateIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowAssistantStateIDL getAssistantStateIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowAssistantStateIDL r102 = IFlowAssistantStateIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowAssistantStateIDL r103 = Stub.getDefaultImpl().getAssistantStateIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowCocreationReviewIDL getCocreationReviewIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowCocreationReviewIDL r102 = IFlowCocreationReviewIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowCocreationReviewIDL r103 = Stub.getDefaultImpl().getCocreationReviewIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFileIDL getFileIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFileIDL r102 = IFileIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFileIDL r103 = Stub.getDefaultImpl().getFileIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowFeedbackIDL getFlowFeedbackIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowFeedbackIDL r102 = IFlowFeedbackIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowFeedbackIDL r103 = Stub.getDefaultImpl().getFlowFeedbackIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowNetworkIDL getFlowNetworkIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowNetworkIDL r102 = IFlowNetworkIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowNetworkIDL r103 = Stub.getDefaultImpl().getFlowNetworkIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowPermissionIDL getFlowPermissionIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowPermissionIDL r102 = IFlowPermissionIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowPermissionIDL r103 = Stub.getDefaultImpl().getFlowPermissionIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowFrontierIDL getFrontierIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowFrontierIDL r102 = IFlowFrontierIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowFrontierIDL r103 = Stub.getDefaultImpl().getFrontierIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowMessageIDL getMessageIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowMessageIDL r102 = IFlowMessageIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowMessageIDL r103 = Stub.getDefaultImpl().getMessageIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowSettingsIDL getSettingsIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowSettingsIDL r102 = IFlowSettingsIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowSettingsIDL r103 = Stub.getDefaultImpl().getSettingsIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowUiIDL getUiIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowUiIDL r102 = IFlowUiIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowUiIDL r103 = Stub.getDefaultImpl().getUiIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowIDL
            public IFlowVoiceInteractionIDL getVoiceInteractionIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IFlowVoiceInteractionIDL r102 = IFlowVoiceInteractionIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IFlowVoiceInteractionIDL r103 = Stub.getDefaultImpl().getVoiceInteractionIDL();     // Catch: Throwable -> L13
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFlowIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowIDL) == false) goto L12;
            return (IFlowIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowIDL r100) {
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
            if (r100 == 1598968902) goto L78;
            IBinder r104 = null;
            switch(r100) {
                case 1: goto L73;
                case 2: goto L68;
                case 3: goto L63;
                case 4: goto L58;
                case 5: goto L53;
                case 6: goto L48;
                case 7: goto L43;
                case 8: goto L38;
                case 9: goto L33;
                case 10: goto L28;
                case 11: goto L23;
                case 12: goto L18;
                case 13: goto L13;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            IFlowCocreationReviewIDL r105 = getCocreationReviewIDL();
            r102.writeNoException();
            if (r105 == null) goto L11;
            r104 = r105.asBinder();
        L11:
            r102.writeStrongBinder(r104);
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            IFlowFeedbackIDL r106 = getFlowFeedbackIDL();
            r102.writeNoException();
            if (r106 == null) goto L16;
            r104 = r106.asBinder();
        L16:
            r102.writeStrongBinder(r104);
            return true;
        L18:
            r101.enforceInterface(DESCRIPTOR);
            IFlowPermissionIDL r107 = getFlowPermissionIDL();
            r102.writeNoException();
            if (r107 == null) goto L21;
            r104 = r107.asBinder();
        L21:
            r102.writeStrongBinder(r104);
            return true;
        L23:
            r101.enforceInterface(DESCRIPTOR);
            IFlowNetworkIDL r108 = getFlowNetworkIDL();
            r102.writeNoException();
            if (r108 == null) goto L26;
            r104 = r108.asBinder();
        L26:
            r102.writeStrongBinder(r104);
            return true;
        L28:
            r101.enforceInterface(DESCRIPTOR);
            IFlowAssistantStateIDL r109 = getAssistantStateIDL();
            r102.writeNoException();
            if (r109 == null) goto L31;
            r104 = r109.asBinder();
        L31:
            r102.writeStrongBinder(r104);
            return true;
        L33:
            r101.enforceInterface(DESCRIPTOR);
            IFlowMessageIDL r110 = getMessageIDL();
            r102.writeNoException();
            if (r110 == null) goto L36;
            r104 = r110.asBinder();
        L36:
            r102.writeStrongBinder(r104);
            return true;
        L38:
            r101.enforceInterface(DESCRIPTOR);
            IFlowVoiceInteractionIDL r111 = getVoiceInteractionIDL();
            r102.writeNoException();
            if (r111 == null) goto L41;
            r104 = r111.asBinder();
        L41:
            r102.writeStrongBinder(r104);
            return true;
        L43:
            r101.enforceInterface(DESCRIPTOR);
            IFlowAppIntentIDL r112 = getAppIntentIDL();
            r102.writeNoException();
            if (r112 == null) goto L46;
            r104 = r112.asBinder();
        L46:
            r102.writeStrongBinder(r104);
            return true;
        L48:
            r101.enforceInterface(DESCRIPTOR);
            IFlowUiIDL r113 = getUiIDL();
            r102.writeNoException();
            if (r113 == null) goto L51;
            r104 = r113.asBinder();
        L51:
            r102.writeStrongBinder(r104);
            return true;
        L53:
            r101.enforceInterface(DESCRIPTOR);
            IFlowSettingsIDL r114 = getSettingsIDL();
            r102.writeNoException();
            if (r114 == null) goto L56;
            r104 = r114.asBinder();
        L56:
            r102.writeStrongBinder(r104);
            return true;
        L58:
            r101.enforceInterface(DESCRIPTOR);
            IFlowAppStateIDL r115 = getAppStateIDL();
            r102.writeNoException();
            if (r115 == null) goto L61;
            r104 = r115.asBinder();
        L61:
            r102.writeStrongBinder(r104);
            return true;
        L63:
            r101.enforceInterface(DESCRIPTOR);
            IFlowFrontierIDL r116 = getFrontierIDL();
            r102.writeNoException();
            if (r116 == null) goto L66;
            r104 = r116.asBinder();
        L66:
            r102.writeStrongBinder(r104);
            return true;
        L68:
            r101.enforceInterface(DESCRIPTOR);
            IFlowAppLogIDL r117 = getAppLogIDL();
            r102.writeNoException();
            if (r117 == null) goto L71;
            r104 = r117.asBinder();
        L71:
            r102.writeStrongBinder(r104);
            return true;
        L73:
            r101.enforceInterface(DESCRIPTOR);
            IFileIDL r118 = getFileIDL();
            r102.writeNoException();
            if (r118 == null) goto L76;
            r104 = r118.asBinder();
        L76:
            r102.writeStrongBinder(r104);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L78:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    IFlowAppIntentIDL getAppIntentIDL() throws RemoteException;

    IFlowAppLogIDL getAppLogIDL() throws RemoteException;

    IFlowAppStateIDL getAppStateIDL() throws RemoteException;

    IFlowAssistantStateIDL getAssistantStateIDL() throws RemoteException;

    IFlowCocreationReviewIDL getCocreationReviewIDL() throws RemoteException;

    IFileIDL getFileIDL() throws RemoteException;

    IFlowFeedbackIDL getFlowFeedbackIDL() throws RemoteException;

    IFlowNetworkIDL getFlowNetworkIDL() throws RemoteException;

    IFlowPermissionIDL getFlowPermissionIDL() throws RemoteException;

    IFlowFrontierIDL getFrontierIDL() throws RemoteException;

    IFlowMessageIDL getMessageIDL() throws RemoteException;

    IFlowSettingsIDL getSettingsIDL() throws RemoteException;

    IFlowUiIDL getUiIDL() throws RemoteException;

    IFlowVoiceInteractionIDL getVoiceInteractionIDL() throws RemoteException;
}
