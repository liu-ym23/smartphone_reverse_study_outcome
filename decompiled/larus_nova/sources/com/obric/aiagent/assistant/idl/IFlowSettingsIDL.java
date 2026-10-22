package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.OComplexTaskConfig;
import com.obric.aiagent.assistant.idl.bean.OModelConfig;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowSettingsIDL extends IInterface {
    public static final String AUTHENTICATION_TYPE_SCENE_AUTO_GUI_EXECUTE = "AutoGuiExecute";
    public static final String AUTHENTICATION_TYPE_SCENE_CHAT_AND_ONLINE_QA = "ChatAndOnlineQA";
    public static final String AUTHENTICATION_TYPE_SCENE_CHAT_HISTORY_ACCESS = "ChatHistoryAccess";
    public static final String AUTHENTICATION_TYPE_SCENE_GLOBAL_MEMORY_ACCESS = "GlobalMemoryAccess";
    public static final String AUTHENTICATION_TYPE_SCENE_LOCAL_APP_DATA_ACCESS = "LocalAppDataAccess";
    public static final String AUTHENTICATION_TYPE_SCENE_SIMPLE_COMMAND_EXECUTE = "SimpleCommandExecute";

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowSettingsIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public int getAuthenticationTypeOnLockScreen(String r100) throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public Map getAutoExecuteAuthorizationStatusMap() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public int getAutoGuiEnabledScene() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public String getAutoGuiFastModeUseSettings() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean getAutoImageUploadEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public FeatureConfigMap getFeatureConfigMap() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public int getIntentAuthStatus(String r100) throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public int getIntentUploadStrategyForDebug() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean getOAutoUseClipboardEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean getOUseMemoryEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public String getObricCloudConfig(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public OComplexTaskConfig getObricComplexTaskConfig() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public String getObricFlowSettingsJson(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public OModelConfig getObricModelConfig() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public int getObricPowerLockTimeoutInSeconds() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean getPersonalContextEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean getSemanticeScreenShotEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean isLarkKnowledgeAuthorizationEnable() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean isLarkSendConfirmEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean isTtsPlayBackgroundEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public boolean isVoicePrintAuthenticateAutoGuiEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setAutoGuiEnabledScene(int r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setAutoImageUploadEnabled(boolean r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setLarkKnowledgeAuthorizationEnabled(boolean r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setOUseMemoryEnabled(boolean r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setSemanticScreenShotEnabled(boolean r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
        public void setVoicePrintAuthenticateAutoGuiEnabled(boolean r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowSettingsIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowSettingsIDL";
        static final int TRANSACTION_getAuthenticationTypeOnLockScreen = 26;
        static final int TRANSACTION_getAutoExecuteAuthorizationStatusMap = 27;
        static final int TRANSACTION_getAutoGuiEnabledScene = 1;
        static final int TRANSACTION_getAutoGuiFastModeUseSettings = 28;
        static final int TRANSACTION_getAutoImageUploadEnabled = 20;
        static final int TRANSACTION_getFeatureConfigMap = 12;
        static final int TRANSACTION_getIntentAuthStatus = 6;
        static final int TRANSACTION_getIntentUploadStrategyForDebug = 7;
        static final int TRANSACTION_getOAutoUseClipboardEnabled = 25;
        static final int TRANSACTION_getOUseMemoryEnabled = 17;
        static final int TRANSACTION_getObricCloudConfig = 15;
        static final int TRANSACTION_getObricComplexTaskConfig = 9;
        static final int TRANSACTION_getObricFlowSettingsJson = 14;
        static final int TRANSACTION_getObricMemoryDataCollectConfig = 13;
        static final int TRANSACTION_getObricModelConfig = 10;
        static final int TRANSACTION_getObricPowerLockTimeoutInSeconds = 8;
        static final int TRANSACTION_getPersonalContextEnabled = 5;
        static final int TRANSACTION_getSemanticeScreenShotEnabled = 3;
        static final int TRANSACTION_isLarkKnowledgeAuthorizationEnable = 18;
        static final int TRANSACTION_isLarkSendConfirmEnabled = 22;
        static final int TRANSACTION_isTtsPlayBackgroundEnabled = 11;
        static final int TRANSACTION_isVoicePrintAuthenticateAutoGuiEnabled = 24;
        static final int TRANSACTION_setAutoGuiEnabledScene = 2;
        static final int TRANSACTION_setAutoImageUploadEnabled = 21;
        static final int TRANSACTION_setLarkKnowledgeAuthorizationEnabled = 19;
        static final int TRANSACTION_setOUseMemoryEnabled = 16;
        static final int TRANSACTION_setSemanticScreenShotEnabled = 4;
        static final int TRANSACTION_setVoicePrintAuthenticateAutoGuiEnabled = 23;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowSettingsIDL {
            public static IFlowSettingsIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public Map getAutoExecuteAuthorizationStatusMap() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                HashMap r102 = r101.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r103 = Stub.getDefaultImpl().getAutoExecuteAuthorizationStatusMap();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public int getAutoGuiEnabledScene() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getAutoGuiEnabledScene();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public String getAutoGuiFastModeUseSettings() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getAutoGuiFastModeUseSettings();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean getAutoImageUploadEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().getAutoImageUploadEnabled();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public FeatureConfigMap getFeatureConfigMap() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                FeatureConfigMap r102 = FeatureConfigMap.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                FeatureConfigMap r103 = Stub.getDefaultImpl().getFeatureConfigMap();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public int getIntentUploadStrategyForDebug() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getIntentUploadStrategyForDebug();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean getOAutoUseClipboardEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().getOAutoUseClipboardEnabled();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean getOUseMemoryEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().getOUseMemoryEnabled();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public OComplexTaskConfig getObricComplexTaskConfig() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                OComplexTaskConfig r102 = OComplexTaskConfig.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                OComplexTaskConfig r103 = Stub.getDefaultImpl().getObricComplexTaskConfig();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                ObricMemoryDataCollectConfig r102 = ObricMemoryDataCollectConfig.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ObricMemoryDataCollectConfig r103 = Stub.getDefaultImpl().getObricMemoryDataCollectConfig();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public OModelConfig getObricModelConfig() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                OModelConfig r102 = OModelConfig.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                OModelConfig r103 = Stub.getDefaultImpl().getObricModelConfig();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public int getObricPowerLockTimeoutInSeconds() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getObricPowerLockTimeoutInSeconds();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean getPersonalContextEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().getPersonalContextEnabled();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean getSemanticeScreenShotEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().getSemanticeScreenShotEnabled();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean isLarkKnowledgeAuthorizationEnable() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isLarkKnowledgeAuthorizationEnable();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean isLarkSendConfirmEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isLarkSendConfirmEnabled();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean isTtsPlayBackgroundEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isTtsPlayBackgroundEnabled();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public boolean isVoicePrintAuthenticateAutoGuiEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isVoicePrintAuthenticateAutoGuiEnabled();     // Catch: Throwable -> L15
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

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public int getAuthenticationTypeOnLockScreen(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                int r103 = r102.readInt();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r104 = Stub.getDefaultImpl().getAuthenticationTypeOnLockScreen(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public int getIntentAuthStatus(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                int r103 = r102.readInt();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r104 = Stub.getDefaultImpl().getIntentAuthStatus(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public String getObricCloudConfig(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r104 = Stub.getDefaultImpl().getObricCloudConfig(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public String getObricFlowSettingsJson(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r104 = Stub.getDefaultImpl().getObricFlowSettingsJson(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setAutoGuiEnabledScene(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setAutoGuiEnabledScene(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setAutoImageUploadEnabled(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setAutoImageUploadEnabled(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setLarkKnowledgeAuthorizationEnabled(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setLarkKnowledgeAuthorizationEnabled(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setOUseMemoryEnabled(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setOUseMemoryEnabled(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setSemanticScreenShotEnabled(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setSemanticScreenShotEnabled(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowSettingsIDL
            public void setVoicePrintAuthenticateAutoGuiEnabled(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setVoicePrintAuthenticateAutoGuiEnabled(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFlowSettingsIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowSettingsIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowSettingsIDL) == false) goto L12;
            return (IFlowSettingsIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowSettingsIDL r100) {
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
            if (r100 == 1598968902) goto L91;
            boolean r104 = false;
            switch(r100) {
                case 1: goto L89;
                case 2: goto L87;
                case 3: goto L85;
                case 4: goto L80;
                case 5: goto L78;
                case 6: goto L76;
                case 7: goto L74;
                case 8: goto L72;
                case 9: goto L67;
                case 10: goto L62;
                case 11: goto L60;
                case 12: goto L55;
                case 13: goto L50;
                case 14: goto L48;
                case 15: goto L46;
                case 16: goto L41;
                case 17: goto L39;
                case 18: goto L37;
                case 19: goto L32;
                case 20: goto L30;
                case 21: goto L25;
                case 22: goto L23;
                case 23: goto L18;
                case 24: goto L16;
                case 25: goto L14;
                case 26: goto L12;
                case 27: goto L10;
                case 28: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            String r105 = getAutoGuiFastModeUseSettings();
            r102.writeNoException();
            r102.writeString(r105);
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            Map r106 = getAutoExecuteAuthorizationStatusMap();
            r102.writeNoException();
            r102.writeMap(r106);
            return true;
        L12:
            r101.enforceInterface(DESCRIPTOR);
            int r107 = getAuthenticationTypeOnLockScreen(r101.readString());
            r102.writeNoException();
            r102.writeInt(r107);
            return true;
        L14:
            r101.enforceInterface(DESCRIPTOR);
            boolean r108 = getOAutoUseClipboardEnabled();
            r102.writeNoException();
            r102.writeInt(r108 ? 1 : 0);
            return true;
        L16:
            r101.enforceInterface(DESCRIPTOR);
            boolean r109 = isVoicePrintAuthenticateAutoGuiEnabled();
            r102.writeNoException();
            r102.writeInt(r109 ? 1 : 0);
            return true;
        L18:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L21;
            r104 = true;
        L21:
            setVoicePrintAuthenticateAutoGuiEnabled(r104);
            return true;
        L23:
            r101.enforceInterface(DESCRIPTOR);
            boolean r110 = isLarkSendConfirmEnabled();
            r102.writeNoException();
            r102.writeInt(r110 ? 1 : 0);
            return true;
        L25:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L28;
            r104 = true;
        L28:
            setAutoImageUploadEnabled(r104);
            return true;
        L30:
            r101.enforceInterface(DESCRIPTOR);
            boolean r111 = getAutoImageUploadEnabled();
            r102.writeNoException();
            r102.writeInt(r111 ? 1 : 0);
            return true;
        L32:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L35;
            r104 = true;
        L35:
            setLarkKnowledgeAuthorizationEnabled(r104);
            return true;
        L37:
            r101.enforceInterface(DESCRIPTOR);
            boolean r112 = isLarkKnowledgeAuthorizationEnable();
            r102.writeNoException();
            r102.writeInt(r112 ? 1 : 0);
            return true;
        L39:
            r101.enforceInterface(DESCRIPTOR);
            boolean r113 = getOUseMemoryEnabled();
            r102.writeNoException();
            r102.writeInt(r113 ? 1 : 0);
            return true;
        L41:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L44;
            r104 = true;
        L44:
            setOUseMemoryEnabled(r104);
            return true;
        L46:
            r101.enforceInterface(DESCRIPTOR);
            String r114 = getObricCloudConfig(r101.readString());
            r102.writeNoException();
            r102.writeString(r114);
            return true;
        L48:
            r101.enforceInterface(DESCRIPTOR);
            String r115 = getObricFlowSettingsJson(r101.readString());
            r102.writeNoException();
            r102.writeString(r115);
            return true;
        L50:
            r101.enforceInterface(DESCRIPTOR);
            ObricMemoryDataCollectConfig r116 = getObricMemoryDataCollectConfig();
            r102.writeNoException();
            if (r116 == null) goto L53;
            r102.writeInt(1);
            r116.writeToParcel(r102, 1);
        L54:
            return true;
        L53:
            r102.writeInt(0);
            goto L54
        L55:
            r101.enforceInterface(DESCRIPTOR);
            FeatureConfigMap r117 = getFeatureConfigMap();
            r102.writeNoException();
            if (r117 == null) goto L58;
            r102.writeInt(1);
            r117.writeToParcel(r102, 1);
        L59:
            return true;
        L58:
            r102.writeInt(0);
            goto L59
        L60:
            r101.enforceInterface(DESCRIPTOR);
            boolean r118 = isTtsPlayBackgroundEnabled();
            r102.writeNoException();
            r102.writeInt(r118 ? 1 : 0);
            return true;
        L62:
            r101.enforceInterface(DESCRIPTOR);
            OModelConfig r119 = getObricModelConfig();
            r102.writeNoException();
            if (r119 == null) goto L65;
            r102.writeInt(1);
            r119.writeToParcel(r102, 1);
        L66:
            return true;
        L65:
            r102.writeInt(0);
            goto L66
        L67:
            r101.enforceInterface(DESCRIPTOR);
            OComplexTaskConfig r120 = getObricComplexTaskConfig();
            r102.writeNoException();
            if (r120 == null) goto L70;
            r102.writeInt(1);
            r120.writeToParcel(r102, 1);
        L71:
            return true;
        L70:
            r102.writeInt(0);
            goto L71
        L72:
            r101.enforceInterface(DESCRIPTOR);
            int r121 = getObricPowerLockTimeoutInSeconds();
            r102.writeNoException();
            r102.writeInt(r121);
            return true;
        L74:
            r101.enforceInterface(DESCRIPTOR);
            int r122 = getIntentUploadStrategyForDebug();
            r102.writeNoException();
            r102.writeInt(r122);
            return true;
        L76:
            r101.enforceInterface(DESCRIPTOR);
            int r123 = getIntentAuthStatus(r101.readString());
            r102.writeNoException();
            r102.writeInt(r123);
            return true;
        L78:
            r101.enforceInterface(DESCRIPTOR);
            boolean r124 = getPersonalContextEnabled();
            r102.writeNoException();
            r102.writeInt(r124 ? 1 : 0);
            return true;
        L80:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L83;
            r104 = true;
        L83:
            setSemanticScreenShotEnabled(r104);
            return true;
        L85:
            r101.enforceInterface(DESCRIPTOR);
            boolean r125 = getSemanticeScreenShotEnabled();
            r102.writeNoException();
            r102.writeInt(r125 ? 1 : 0);
            return true;
        L87:
            r101.enforceInterface(DESCRIPTOR);
            setAutoGuiEnabledScene(r101.readInt());
            return true;
        L89:
            r101.enforceInterface(DESCRIPTOR);
            int r126 = getAutoGuiEnabledScene();
            r102.writeNoException();
            r102.writeInt(r126);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L91:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getAuthenticationTypeOnLockScreen(String r100) throws RemoteException;

    Map getAutoExecuteAuthorizationStatusMap() throws RemoteException;

    int getAutoGuiEnabledScene() throws RemoteException;

    String getAutoGuiFastModeUseSettings() throws RemoteException;

    boolean getAutoImageUploadEnabled() throws RemoteException;

    FeatureConfigMap getFeatureConfigMap() throws RemoteException;

    int getIntentAuthStatus(String r100) throws RemoteException;

    int getIntentUploadStrategyForDebug() throws RemoteException;

    boolean getOAutoUseClipboardEnabled() throws RemoteException;

    boolean getOUseMemoryEnabled() throws RemoteException;

    String getObricCloudConfig(String r100) throws RemoteException;

    OComplexTaskConfig getObricComplexTaskConfig() throws RemoteException;

    String getObricFlowSettingsJson(String r100) throws RemoteException;

    ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() throws RemoteException;

    OModelConfig getObricModelConfig() throws RemoteException;

    int getObricPowerLockTimeoutInSeconds() throws RemoteException;

    boolean getPersonalContextEnabled() throws RemoteException;

    boolean getSemanticeScreenShotEnabled() throws RemoteException;

    boolean isLarkKnowledgeAuthorizationEnable() throws RemoteException;

    boolean isLarkSendConfirmEnabled() throws RemoteException;

    boolean isTtsPlayBackgroundEnabled() throws RemoteException;

    boolean isVoicePrintAuthenticateAutoGuiEnabled() throws RemoteException;

    void setAutoGuiEnabledScene(int r100) throws RemoteException;

    void setAutoImageUploadEnabled(boolean r100) throws RemoteException;

    void setLarkKnowledgeAuthorizationEnabled(boolean r100) throws RemoteException;

    void setOUseMemoryEnabled(boolean r100) throws RemoteException;

    void setSemanticScreenShotEnabled(boolean r100) throws RemoteException;

    void setVoicePrintAuthenticateAutoGuiEnabled(boolean r100) throws RemoteException;
}
