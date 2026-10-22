package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IAgentIDL extends IInterface {
    public static final String ACTION_BIND_IPC = "com.obric.aiagent.action.BIND_ASSISTANT_IPC";
    public static final String EXTRA_CLIENT_NAME = "client_name";
    public static final String EXTRA_CLIENT_PKG = "client_pkg";
    public static final String META_PRODUCT = "app.product";
    public static final String META_UPDATEVERSION = "app.updateversioncode";

    /* JADX INFO: loaded from: classes6.dex */
    public static class Default implements IAgentIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentNetworkIDL getAgentNetworkIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentAppIntentIDL getAppIntentIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentAssistantStateIDL getAssistantStateIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IFileIDL getFileIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentMessageIDL getMessageIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IPlatformApiIDL getPlatformApiIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentPrivacyIDL getPrivacyIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentSettingsIDL getSettingsIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentSkillManagerIDL getSkillManagerIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentTaskAppIDL getTaskAppIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public IAgentVoiceInteractionIDL getVoiceInteractionIDL() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentIDL
        public void registerFlowIDL(IFlowIDL r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAgentIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentIDL";
        static final int TRANSACTION_getAgentDMStateManagerIDL = 10;
        static final int TRANSACTION_getAgentNetworkIDL = 8;
        static final int TRANSACTION_getAppIntentIDL = 3;
        static final int TRANSACTION_getAssistantStateIDL = 7;
        static final int TRANSACTION_getFileIDL = 2;
        static final int TRANSACTION_getMessageIDL = 6;
        static final int TRANSACTION_getPlatformApiIDL = 9;
        static final int TRANSACTION_getPrivacyIDL = 11;
        static final int TRANSACTION_getSettingsIDL = 5;
        static final int TRANSACTION_getSkillManagerIDL = 13;
        static final int TRANSACTION_getTaskAppIDL = 12;
        static final int TRANSACTION_getVoiceInteractionIDL = 4;
        static final int TRANSACTION_registerFlowIDL = 1;

        public static class Proxy implements IAgentIDL {
            public static IAgentIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IAgentDMStateManagerIDL r102 = IAgentDMStateManagerIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentDMStateManagerIDL r103 = Stub.getDefaultImpl().getAgentDMStateManagerIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentNetworkIDL getAgentNetworkIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IAgentNetworkIDL r102 = IAgentNetworkIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentNetworkIDL r103 = Stub.getDefaultImpl().getAgentNetworkIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentAppIntentIDL getAppIntentIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IAgentAppIntentIDL r102 = IAgentAppIntentIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentAppIntentIDL r103 = Stub.getDefaultImpl().getAppIntentIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentAssistantStateIDL getAssistantStateIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IAgentAssistantStateIDL r102 = IAgentAssistantStateIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentAssistantStateIDL r103 = Stub.getDefaultImpl().getAssistantStateIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IFileIDL getFileIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L6;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentMessageIDL getMessageIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IAgentMessageIDL r102 = IAgentMessageIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentMessageIDL r103 = Stub.getDefaultImpl().getMessageIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IPlatformApiIDL getPlatformApiIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IPlatformApiIDL r102 = IPlatformApiIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IPlatformApiIDL r103 = Stub.getDefaultImpl().getPlatformApiIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentPrivacyIDL getPrivacyIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IAgentPrivacyIDL r102 = IAgentPrivacyIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentPrivacyIDL r103 = Stub.getDefaultImpl().getPrivacyIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentSettingsIDL getSettingsIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IAgentSettingsIDL r102 = IAgentSettingsIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentSettingsIDL r103 = Stub.getDefaultImpl().getSettingsIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentSkillManagerIDL getSkillManagerIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IAgentSkillManagerIDL r102 = IAgentSkillManagerIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentSkillManagerIDL r103 = Stub.getDefaultImpl().getSkillManagerIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentTaskAppIDL getTaskAppIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IAgentTaskAppIDL r102 = IAgentTaskAppIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentTaskAppIDL r103 = Stub.getDefaultImpl().getTaskAppIDL();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public IAgentVoiceInteractionIDL getVoiceInteractionIDL() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IAgentVoiceInteractionIDL r102 = IAgentVoiceInteractionIDL.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IAgentVoiceInteractionIDL r103 = Stub.getDefaultImpl().getVoiceInteractionIDL();     // Catch: Throwable -> L13
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

            @Override // com.obric.aiagent.assistant.idl.IAgentIDL
            public void registerFlowIDL(IFlowIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerFlowIDL(r100);     // Catch: Throwable -> L16
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
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IAgentIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAgentIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAgentIDL) == false) goto L12;
            return (IAgentIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAgentIDL r100) {
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
            if (r100 == 1598968902) goto L70;
            IBinder r104 = null;
            switch(r100) {
                case 1: goto L68;
                case 2: goto L63;
                case 3: goto L58;
                case 4: goto L53;
                case 5: goto L48;
                case 6: goto L43;
                case 7: goto L38;
                case 8: goto L33;
                case 9: goto L28;
                case 10: goto L23;
                case 11: goto L18;
                case 12: goto L13;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            IAgentSkillManagerIDL r105 = getSkillManagerIDL();
            r102.writeNoException();
            if (r105 == null) goto L11;
            r104 = r105.asBinder();
        L11:
            r102.writeStrongBinder(r104);
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            IAgentTaskAppIDL r106 = getTaskAppIDL();
            r102.writeNoException();
            if (r106 == null) goto L16;
            r104 = r106.asBinder();
        L16:
            r102.writeStrongBinder(r104);
            return true;
        L18:
            r101.enforceInterface(DESCRIPTOR);
            IAgentPrivacyIDL r107 = getPrivacyIDL();
            r102.writeNoException();
            if (r107 == null) goto L21;
            r104 = r107.asBinder();
        L21:
            r102.writeStrongBinder(r104);
            return true;
        L23:
            r101.enforceInterface(DESCRIPTOR);
            IAgentDMStateManagerIDL r108 = getAgentDMStateManagerIDL();
            r102.writeNoException();
            if (r108 == null) goto L26;
            r104 = r108.asBinder();
        L26:
            r102.writeStrongBinder(r104);
            return true;
        L28:
            r101.enforceInterface(DESCRIPTOR);
            IPlatformApiIDL r109 = getPlatformApiIDL();
            r102.writeNoException();
            if (r109 == null) goto L31;
            r104 = r109.asBinder();
        L31:
            r102.writeStrongBinder(r104);
            return true;
        L33:
            r101.enforceInterface(DESCRIPTOR);
            IAgentNetworkIDL r110 = getAgentNetworkIDL();
            r102.writeNoException();
            if (r110 == null) goto L36;
            r104 = r110.asBinder();
        L36:
            r102.writeStrongBinder(r104);
            return true;
        L38:
            r101.enforceInterface(DESCRIPTOR);
            IAgentAssistantStateIDL r111 = getAssistantStateIDL();
            r102.writeNoException();
            if (r111 == null) goto L41;
            r104 = r111.asBinder();
        L41:
            r102.writeStrongBinder(r104);
            return true;
        L43:
            r101.enforceInterface(DESCRIPTOR);
            IAgentMessageIDL r112 = getMessageIDL();
            r102.writeNoException();
            if (r112 == null) goto L46;
            r104 = r112.asBinder();
        L46:
            r102.writeStrongBinder(r104);
            return true;
        L48:
            r101.enforceInterface(DESCRIPTOR);
            IAgentSettingsIDL r113 = getSettingsIDL();
            r102.writeNoException();
            if (r113 == null) goto L51;
            r104 = r113.asBinder();
        L51:
            r102.writeStrongBinder(r104);
            return true;
        L53:
            r101.enforceInterface(DESCRIPTOR);
            IAgentVoiceInteractionIDL r114 = getVoiceInteractionIDL();
            r102.writeNoException();
            if (r114 == null) goto L56;
            r104 = r114.asBinder();
        L56:
            r102.writeStrongBinder(r104);
            return true;
        L58:
            r101.enforceInterface(DESCRIPTOR);
            IAgentAppIntentIDL r115 = getAppIntentIDL();
            r102.writeNoException();
            if (r115 == null) goto L61;
            r104 = r115.asBinder();
        L61:
            r102.writeStrongBinder(r104);
            return true;
        L63:
            r101.enforceInterface(DESCRIPTOR);
            IFileIDL r116 = getFileIDL();
            r102.writeNoException();
            if (r116 == null) goto L66;
            r104 = r116.asBinder();
        L66:
            r102.writeStrongBinder(r104);
            return true;
        L68:
            r101.enforceInterface(DESCRIPTOR);
            registerFlowIDL(IFlowIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L70:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    IAgentDMStateManagerIDL getAgentDMStateManagerIDL() throws RemoteException;

    IAgentNetworkIDL getAgentNetworkIDL() throws RemoteException;

    IAgentAppIntentIDL getAppIntentIDL() throws RemoteException;

    IAgentAssistantStateIDL getAssistantStateIDL() throws RemoteException;

    IFileIDL getFileIDL() throws RemoteException;

    IAgentMessageIDL getMessageIDL() throws RemoteException;

    IPlatformApiIDL getPlatformApiIDL() throws RemoteException;

    IAgentPrivacyIDL getPrivacyIDL() throws RemoteException;

    IAgentSettingsIDL getSettingsIDL() throws RemoteException;

    IAgentSkillManagerIDL getSkillManagerIDL() throws RemoteException;

    IAgentTaskAppIDL getTaskAppIDL() throws RemoteException;

    IAgentVoiceInteractionIDL getVoiceInteractionIDL() throws RemoteException;

    void registerFlowIDL(IFlowIDL r100) throws RemoteException;
}
