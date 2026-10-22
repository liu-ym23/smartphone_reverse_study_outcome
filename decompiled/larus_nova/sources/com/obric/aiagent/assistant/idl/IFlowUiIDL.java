package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowUiIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowUiIDL {
        public Default() {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void addCustomBarAction(String r100, String r101, String r102, long r103) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void closeAssistantInputPanel(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void dismissKeyguard() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void finishChatPage() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public String getCurrentDisplayModel() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public String getTaskSkillModelJson() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public int getWindowState() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void handleObricAction(String r100, String r101, IObricActionResultCallbackIDL r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isAssistantRequestFromAIKey() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isAudioMessage(String r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isAuthenticationPass() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isAuthenticationPassV2(String r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public Authentication isAuthenticationPassV3(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isWindowMode() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public boolean isWindowShowing() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void notifyAssistantState(String r100, boolean r101, StateInfo r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void notifyMessageInAutoGui(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void notifyOAutoDied() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void openAssistantInputPanel(String r100, StateInfo r101, boolean r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void openChatActivity(int r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void openRealtimeCall(int r100, IOpenRealTimeCallCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void popWindow() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void processRequiresAuthentication() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r100, boolean r101, Bundle r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r100, Bundle r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r100, Bundle r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void setAssistantInteractionListener(String r100, IAssistantInteractionListenerIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void setAutoIncreaseWindow(boolean r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void shouldDowngradeAuthForDora(int r100, IDowngradeAuthForDoraCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void showToast(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void showWindow() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
        public void suspendDismissKeyguard(String r100, String[] r101, IDismissKeyguardCallbackIDL r102, boolean r103, Bundle r104) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowUiIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowUiIDL";
        static final int TRANSACTION_addCustomBarAction = 1;
        static final int TRANSACTION_closeAssistantInputPanel = 12;
        static final int TRANSACTION_dismissKeyguard = 4;
        static final int TRANSACTION_finishChatPage = 9;
        static final int TRANSACTION_getCurrentDisplayModel = 32;
        static final int TRANSACTION_getTaskSkillModelJson = 31;
        static final int TRANSACTION_getWindowState = 5;
        static final int TRANSACTION_handleObricAction = 2;
        static final int TRANSACTION_isAssistantRequestFromAIKey = 23;
        static final int TRANSACTION_isAudioMessage = 24;
        static final int TRANSACTION_isAuthenticationPass = 15;
        static final int TRANSACTION_isAuthenticationPassV2 = 20;
        static final int TRANSACTION_isAuthenticationPassV3 = 22;
        static final int TRANSACTION_isWindowMode = 28;
        static final int TRANSACTION_isWindowShowing = 30;
        static final int TRANSACTION_notifyAssistantState = 13;
        static final int TRANSACTION_notifyMessageInAutoGui = 7;
        static final int TRANSACTION_notifyOAutoDied = 21;
        static final int TRANSACTION_openAssistantInputPanel = 11;
        static final int TRANSACTION_openChatActivity = 19;
        static final int TRANSACTION_openRealtimeCall = 8;
        static final int TRANSACTION_popWindow = 29;
        static final int TRANSACTION_processRequiresAuthentication = 26;
        static final int TRANSACTION_requestBiometricAuthentication = 17;
        static final int TRANSACTION_requestDeviceCredentialAuthentication = 18;
        static final int TRANSACTION_requestVoicePrintAuthentication = 16;
        static final int TRANSACTION_setAssistantInteractionListener = 14;
        static final int TRANSACTION_setAutoIncreaseWindow = 10;
        static final int TRANSACTION_shouldDowngradeAuthForDora = 25;
        static final int TRANSACTION_showToast = 6;
        static final int TRANSACTION_showWindow = 27;
        static final int TRANSACTION_suspendDismissKeyguard = 3;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowUiIDL {
            public static IFlowUiIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void dismissKeyguard() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().dismissKeyguard();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void finishChatPage() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().finishChatPage();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public String getCurrentDisplayModel() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 32, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getCurrentDisplayModel();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public String getTaskSkillModelJson() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 31, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getTaskSkillModelJson();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public int getWindowState() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getWindowState();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isAssistantRequestFromAIKey() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isAssistantRequestFromAIKey();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isAuthenticationPass() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isAuthenticationPass();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isWindowMode() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isWindowMode();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isWindowShowing() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 30, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isWindowShowing();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void notifyOAutoDied() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyOAutoDied();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void popWindow() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().popWindow();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void processRequiresAuthentication() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().processRequiresAuthentication();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void showWindow() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showWindow();     // Catch: Throwable -> L12
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

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void closeAssistantInputPanel(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().closeAssistantInputPanel(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isAudioMessage(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().isAudioMessage(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public boolean isAuthenticationPassV2(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().isAuthenticationPassV2(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public Authentication isAuthenticationPassV3(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeString(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L17
                if (r102.readInt() == 0) goto L14;
                Authentication r103 = Authentication.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L17
            L15:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Authentication r104 = Stub.getDefaultImpl().isAuthenticationPassV3(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void notifyMessageInAutoGui(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyMessageInAutoGui(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void openChatActivity(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().openChatActivity(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void setAutoIncreaseWindow(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setAutoIncreaseWindow(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void showToast(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showToast(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void openRealtimeCall(int r100, IOpenRealTimeCallCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeInt(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().openRealtimeCall(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L20
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L20
                if (r101 == null) goto L10;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L12:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r102, null, 1) == false) goto L14;
            L18:
                r102.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().requestDeviceCredentialAuthentication(r100, r101);     // Catch: Throwable -> L20
                r102.recycle();
                return;
            L10:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L12
            L6:
                r103 = null;
            L20:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L20
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L20
                if (r101 == null) goto L10;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L12:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r102, null, 1) == false) goto L14;
            L18:
                r102.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().requestVoicePrintAuthentication(r100, r101);     // Catch: Throwable -> L20
                r102.recycle();
                return;
            L10:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L12
            L6:
                r103 = null;
            L20:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void setAssistantInteractionListener(String r100, IAssistantInteractionListenerIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setAssistantInteractionListener(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void shouldDowngradeAuthForDora(int r100, IDowngradeAuthForDoraCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeInt(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().shouldDowngradeAuthForDora(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void handleObricAction(String r100, String r101, IObricActionResultCallbackIDL r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r103.writeString(r100);     // Catch: Throwable -> L16
                r103.writeString(r101);     // Catch: Throwable -> L16
                if (r102 == null) goto L6;
                IBinder r104 = r102.asBinder();     // Catch: Throwable -> L16
            L7:
                r103.writeStrongBinder(r104);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, null, 1) == false) goto L10;
            L14:
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().handleObricAction(r100, r101, r102);     // Catch: Throwable -> L16
                r103.recycle();
                return;
            L6:
                r104 = null;
            L16:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void notifyAssistantState(String r100, boolean r101, StateInfo r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r103.writeString(r100);     // Catch: Throwable -> L20
                if (r101 == false) goto L6;
                int r104 = 1;
            L7:
                r103.writeInt(r104);     // Catch: Throwable -> L20
                if (r102 == null) goto L10;
                r103.writeInt(1);     // Catch: Throwable -> L20
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L20
            L12:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r103, null, 1) == false) goto L14;
            L18:
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().notifyAssistantState(r100, r101, r102);     // Catch: Throwable -> L20
                r103.recycle();
                return;
            L10:
                r103.writeInt(0);     // Catch: Throwable -> L20
                goto L12
            L6:
                r104 = 0;
            L20:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void openAssistantInputPanel(String r100, StateInfo r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L18
                r103.writeString(r100);     // Catch: Throwable -> L18
                int r104 = 0;
                if (r101 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L18
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L18
            L7:
                if (r102 == false) goto L9;
                r104 = 1;
            L9:
                r103.writeInt(r104);     // Catch: Throwable -> L18
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r103, null, 1) == false) goto L12;
            L16:
                r103.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().openAssistantInputPanel(r100, r101, r102);     // Catch: Throwable -> L18
                r103.recycle();
                return;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r100, boolean r101, Bundle r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                if (r100 == null) goto L6;
                IBinder r104 = r100.asBinder();     // Catch: Throwable -> L24
            L7:
                r103.writeStrongBinder(r104);     // Catch: Throwable -> L24
                if (r101 == false) goto L10;
                int r105 = 1;
            L11:
                r103.writeInt(r105);     // Catch: Throwable -> L24
                if (r102 == null) goto L14;
                r103.writeInt(1);     // Catch: Throwable -> L24
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L24
            L16:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r103, null, 1) == false) goto L18;
            L22:
                r103.recycle();
                return;
            L18:
                if (Stub.getDefaultImpl() == null) goto L22;
                Stub.getDefaultImpl().requestBiometricAuthentication(r100, r101, r102);     // Catch: Throwable -> L24
                r103.recycle();
                return;
            L14:
                r103.writeInt(0);     // Catch: Throwable -> L24
                goto L16
            L10:
                r105 = 0;
                goto L11
            L6:
                r104 = null;
            L24:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void addCustomBarAction(String r100, String r110, String r111, long r112) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                r101.writeString(r110);     // Catch: Throwable -> L12
                r101.writeString(r111);     // Catch: Throwable -> L12
                r101.writeLong(r112);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().addCustomBarAction(r100, r110, r111, r112);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.aiagent.assistant.idl.IFlowUiIDL
            public void suspendDismissKeyguard(String r100, String[] r110, IDismissKeyguardCallbackIDL r111, boolean r112, Bundle r113) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                r101.writeString(r100);     // Catch: Throwable -> L24
                r101.writeStringArray(r110);     // Catch: Throwable -> L24
                if (r111 == null) goto L6;
                IBinder r102 = r111.asBinder();     // Catch: Throwable -> L24
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L24
                if (r112 == false) goto L10;
                int r103 = 1;
            L11:
                r101.writeInt(r103);     // Catch: Throwable -> L24
                if (r113 == null) goto L14;
                r101.writeInt(1);     // Catch: Throwable -> L24
                r113.writeToParcel(r101, 0);     // Catch: Throwable -> L24
            L16:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowUiIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L18;
            L22:
                r101.recycle();
                return;
            L18:
                if (Stub.getDefaultImpl() == null) goto L22;
                Stub.getDefaultImpl().suspendDismissKeyguard(r100, r110, r111, r112, r113);     // Catch: Throwable -> L24
                r101.recycle();
                return;
            L14:
                r101.writeInt(0);     // Catch: Throwable -> L24
                goto L16
            L10:
                r103 = 0;
                goto L11
            L6:
                r102 = null;
            L24:
                th = move-exception;
                r101.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowUiIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowUiIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowUiIDL) == false) goto L12;
            return (IFlowUiIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowUiIDL r100) {
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
        public boolean onTransact(int r100, Parcel r110, Parcel r111, int r112) throws RemoteException {
            if (r100 == 1598968902) goto L109;
            boolean r101 = false;
            Bundle r102 = null;
            Bundle r103 = null;
            Bundle r104 = null;
            Bundle r105 = null;
            StateInfo r106 = null;
            StateInfo r107 = null;
            switch(r100) {
                case 1: goto L107;
                case 2: goto L105;
                case 3: goto L96;
                case 4: goto L94;
                case 5: goto L92;
                case 6: goto L90;
                case 7: goto L88;
                case 8: goto L86;
                case 9: goto L84;
                case 10: goto L79;
                case 11: goto L71;
                case 12: goto L69;
                case 13: goto L61;
                case 14: goto L59;
                case 15: goto L57;
                case 16: goto L52;
                case 17: goto L44;
                case 18: goto L39;
                case 19: goto L37;
                case 20: goto L35;
                case 21: goto L33;
                case 22: goto L28;
                case 23: goto L26;
                case 24: goto L24;
                case 25: goto L22;
                case 26: goto L20;
                case 27: goto L18;
                case 28: goto L16;
                case 29: goto L14;
                case 30: goto L12;
                case 31: goto L10;
                case 32: goto L8;
                default: goto L7;
            };
        L8:
            r110.enforceInterface(DESCRIPTOR);
            String r108 = getCurrentDisplayModel();
            r111.writeNoException();
            r111.writeString(r108);
            return true;
        L10:
            r110.enforceInterface(DESCRIPTOR);
            String r109 = getTaskSkillModelJson();
            r111.writeNoException();
            r111.writeString(r109);
            return true;
        L12:
            r110.enforceInterface(DESCRIPTOR);
            boolean r113 = isWindowShowing();
            r111.writeNoException();
            r111.writeInt(r113 ? 1 : 0);
            return true;
        L14:
            r110.enforceInterface(DESCRIPTOR);
            popWindow();
            return true;
        L16:
            r110.enforceInterface(DESCRIPTOR);
            boolean r114 = isWindowMode();
            r111.writeNoException();
            r111.writeInt(r114 ? 1 : 0);
            return true;
        L18:
            r110.enforceInterface(DESCRIPTOR);
            showWindow();
            return true;
        L20:
            r110.enforceInterface(DESCRIPTOR);
            processRequiresAuthentication();
            return true;
        L22:
            r110.enforceInterface(DESCRIPTOR);
            shouldDowngradeAuthForDora(r110.readInt(), IDowngradeAuthForDoraCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L24:
            r110.enforceInterface(DESCRIPTOR);
            boolean r115 = isAudioMessage(r110.readString());
            r111.writeNoException();
            r111.writeInt(r115 ? 1 : 0);
            return true;
        L26:
            r110.enforceInterface(DESCRIPTOR);
            boolean r116 = isAssistantRequestFromAIKey();
            r111.writeNoException();
            r111.writeInt(r116 ? 1 : 0);
            return true;
        L28:
            r110.enforceInterface(DESCRIPTOR);
            Authentication r117 = isAuthenticationPassV3(r110.readString());
            r111.writeNoException();
            if (r117 == null) goto L31;
            r111.writeInt(1);
            r117.writeToParcel(r111, 1);
        L32:
            return true;
        L31:
            r111.writeInt(0);
            goto L32
        L33:
            r110.enforceInterface(DESCRIPTOR);
            notifyOAutoDied();
            return true;
        L35:
            r110.enforceInterface(DESCRIPTOR);
            boolean r118 = isAuthenticationPassV2(r110.readString());
            r111.writeNoException();
            r111.writeInt(r118 ? 1 : 0);
            return true;
        L37:
            r110.enforceInterface(DESCRIPTOR);
            openChatActivity(r110.readInt());
            return true;
        L39:
            r110.enforceInterface(DESCRIPTOR);
            IRequestAuthenticationCallbackIDL r119 = IRequestAuthenticationCallbackIDL.Stub.asInterface(r110.readStrongBinder());
            if (r110.readInt() == 0) goto L42;
            r103 = (Bundle) Bundle.CREATOR.createFromParcel(r110);
        L42:
            requestDeviceCredentialAuthentication(r119, r103);
            return true;
        L44:
            r110.enforceInterface(DESCRIPTOR);
            IRequestAuthenticationCallbackIDL r120 = IRequestAuthenticationCallbackIDL.Stub.asInterface(r110.readStrongBinder());
            if (r110.readInt() == 0) goto L48;
            r101 = true;
        L48:
            if (r110.readInt() == 0) goto L50;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r110);
        L50:
            requestBiometricAuthentication(r120, r101, r104);
            return true;
        L52:
            r110.enforceInterface(DESCRIPTOR);
            IRequestAuthenticationCallbackIDL r121 = IRequestAuthenticationCallbackIDL.Stub.asInterface(r110.readStrongBinder());
            if (r110.readInt() == 0) goto L55;
            r105 = (Bundle) Bundle.CREATOR.createFromParcel(r110);
        L55:
            requestVoicePrintAuthentication(r121, r105);
            return true;
        L57:
            r110.enforceInterface(DESCRIPTOR);
            boolean r122 = isAuthenticationPass();
            r111.writeNoException();
            r111.writeInt(r122 ? 1 : 0);
            return true;
        L59:
            r110.enforceInterface(DESCRIPTOR);
            setAssistantInteractionListener(r110.readString(), IAssistantInteractionListenerIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L61:
            r110.enforceInterface(DESCRIPTOR);
            String r123 = r110.readString();
            if (r110.readInt() == 0) goto L65;
            r101 = true;
        L65:
            if (r110.readInt() == 0) goto L67;
            StateInfo.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            r106 = new StateInfo(r110);
        L67:
            notifyAssistantState(r123, r101, r106);
            return true;
        L69:
            r110.enforceInterface(DESCRIPTOR);
            closeAssistantInputPanel(r110.readString());
            return true;
        L71:
            r110.enforceInterface(DESCRIPTOR);
            String r124 = r110.readString();
            if (r110.readInt() == 0) goto L75;
            StateInfo.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            r107 = new StateInfo(r110);
        L75:
            if (r110.readInt() == 0) goto L77;
            r101 = true;
        L77:
            openAssistantInputPanel(r124, r107, r101);
            return true;
        L79:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L82;
            r101 = true;
        L82:
            setAutoIncreaseWindow(r101);
            return true;
        L84:
            r110.enforceInterface(DESCRIPTOR);
            finishChatPage();
            return true;
        L86:
            r110.enforceInterface(DESCRIPTOR);
            openRealtimeCall(r110.readInt(), IOpenRealTimeCallCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L88:
            r110.enforceInterface(DESCRIPTOR);
            notifyMessageInAutoGui(r110.readString());
            return true;
        L90:
            r110.enforceInterface(DESCRIPTOR);
            showToast(r110.readString());
            return true;
        L92:
            r110.enforceInterface(DESCRIPTOR);
            int r125 = getWindowState();
            r111.writeNoException();
            r111.writeInt(r125);
            return true;
        L94:
            r110.enforceInterface(DESCRIPTOR);
            dismissKeyguard();
            return true;
        L96:
            r110.enforceInterface(DESCRIPTOR);
            String r126 = r110.readString();
            String[] r127 = r110.createStringArray();
            IDismissKeyguardCallbackIDL r128 = IDismissKeyguardCallbackIDL.Stub.asInterface(r110.readStrongBinder());
            if (r110.readInt() == 0) goto L99;
            boolean r129 = true;
        L101:
            if (r110.readInt() == 0) goto L103;
            r102 = (Bundle) Bundle.CREATOR.createFromParcel(r110);
        L103:
            suspendDismissKeyguard(r126, r127, r128, r129, r102);
            return true;
        L99:
            r129 = false;
            goto L101
        L105:
            r110.enforceInterface(DESCRIPTOR);
            handleObricAction(r110.readString(), r110.readString(), IObricActionResultCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L107:
            r110.enforceInterface(DESCRIPTOR);
            addCustomBarAction(r110.readString(), r110.readString(), r110.readString(), r110.readLong());
            return true;
        L7:
            return super.onTransact(r100, r110, r111, r112);
        L109:
            r111.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addCustomBarAction(String r100, String r101, String r102, long r103) throws RemoteException;

    void closeAssistantInputPanel(String r100) throws RemoteException;

    void dismissKeyguard() throws RemoteException;

    void finishChatPage() throws RemoteException;

    String getCurrentDisplayModel() throws RemoteException;

    String getTaskSkillModelJson() throws RemoteException;

    int getWindowState() throws RemoteException;

    void handleObricAction(String r100, String r101, IObricActionResultCallbackIDL r102) throws RemoteException;

    boolean isAssistantRequestFromAIKey() throws RemoteException;

    boolean isAudioMessage(String r100) throws RemoteException;

    boolean isAuthenticationPass() throws RemoteException;

    boolean isAuthenticationPassV2(String r100) throws RemoteException;

    Authentication isAuthenticationPassV3(String r100) throws RemoteException;

    boolean isWindowMode() throws RemoteException;

    boolean isWindowShowing() throws RemoteException;

    void notifyAssistantState(String r100, boolean r101, StateInfo r102) throws RemoteException;

    void notifyMessageInAutoGui(String r100) throws RemoteException;

    void notifyOAutoDied() throws RemoteException;

    void openAssistantInputPanel(String r100, StateInfo r101, boolean r102) throws RemoteException;

    void openChatActivity(int r100) throws RemoteException;

    void openRealtimeCall(int r100, IOpenRealTimeCallCallbackIDL r101) throws RemoteException;

    void popWindow() throws RemoteException;

    void processRequiresAuthentication() throws RemoteException;

    void requestBiometricAuthentication(IRequestAuthenticationCallbackIDL r100, boolean r101, Bundle r102) throws RemoteException;

    void requestDeviceCredentialAuthentication(IRequestAuthenticationCallbackIDL r100, Bundle r101) throws RemoteException;

    void requestVoicePrintAuthentication(IRequestAuthenticationCallbackIDL r100, Bundle r101) throws RemoteException;

    void setAssistantInteractionListener(String r100, IAssistantInteractionListenerIDL r101) throws RemoteException;

    void setAutoIncreaseWindow(boolean r100) throws RemoteException;

    void shouldDowngradeAuthForDora(int r100, IDowngradeAuthForDoraCallbackIDL r101) throws RemoteException;

    void showToast(String r100) throws RemoteException;

    void showWindow() throws RemoteException;

    void suspendDismissKeyguard(String r100, String[] r101, IDismissKeyguardCallbackIDL r102, boolean r103, Bundle r104) throws RemoteException;
}
