package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IAgentAppIntentIDL extends IInterface {

    /* JADX INFO: loaded from: classes6.dex */
    public static class Default implements IAgentAppIntentIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void callPhone(String r100, ContactEntity r101, String r102, String r103) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void callShortLink(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void clearAllOmniTask(Map r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void deleteEntities(AppEntity[] r100, IEntityDeleteCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void deleteRecordings(RecordingEntity[] r100, boolean r101, IRecordingDeleteCallbackIDL r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void drainOmniUploadImagesForFeedback(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void drainOmniUploadImagesForFeedbackWithInfo(String r100, String r101, List<String> r102, String r103, boolean r104) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void drainOmniUploadImagesForFeedbackWithType(String r100, String r101, List<String> r102, String r103) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public List<AppEntity> getAppEntityList(Map r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public List<String> getComplexTaskPanelInfoFromPC(int r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public IntentDebugReport getIntentExecution(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public Map getOmniExtraLog(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public List<String> getOmniJournalPath(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public boolean isAppIntentActive() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public boolean isWifiEnabled() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void jumpToSystemOtaPage() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void notifyCloseAutoGUISwitch() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void notifyLarkSendStausChanged(String r100, int r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void notifyStopAutoAction(String r100, String r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void notifyStopComplexTask(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void notifyUserAgreePrivacy() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void onLoginStateChange(boolean r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public int pauseMusic() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public int playMusic(String r100, MusicEntity[] r101, MusicEntity r102) throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void registerMusicStateListener(IMusicStateListenerIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void replyAskUser(String r100, String r101, String r102, Map r103) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void screenShot(IScreenshotCallbackIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void sendSms(String r100, ContactEntity r101, String r102, String r103) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void setDebugReferImg(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public boolean setWifiEnabled(boolean r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showAlarm(AlarmEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showAlbum(AlbumEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showAuditoryRecording(AuditoryRecordingEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showCallHistory(CallHistoryEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showContact(ContactEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showCountdown(CountdownEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showFile(FileEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showLarkUrl(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showMemory(MemoryEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showMessage(MessageEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showMusicPage() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showNote(NoteEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showPhoto(PhotoEntity[] r100, int r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showProactiveMemory(ProactiveMemoryEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showProxyCallHistory(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showRecording(RecordingEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showSchedule(ScheduleEntity r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void showWeather(String r100, String r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void takeScreenshot(IScreenshotCallbackIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void terminateService() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void turnOnOffAlarm(AlarmEntity r100, boolean r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
        public void unregisterMusicStateListener(IMusicStateListenerIDL r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAgentAppIntentIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentAppIntentIDL";
        static final int TRANSACTION_callPhone = 21;
        static final int TRANSACTION_callShortLink = 33;
        static final int TRANSACTION_clearAllOmniTask = 34;
        static final int TRANSACTION_deleteEntities = 52;
        static final int TRANSACTION_deleteRecordings = 51;
        static final int TRANSACTION_drainOmniUploadImagesForFeedback = 36;
        static final int TRANSACTION_drainOmniUploadImagesForFeedbackWithInfo = 37;
        static final int TRANSACTION_drainOmniUploadImagesForFeedbackWithType = 38;
        static final int TRANSACTION_getAppEntityList = 30;
        static final int TRANSACTION_getComplexTaskPanelInfoFromPC = 24;
        static final int TRANSACTION_getIntentExecution = 16;
        static final int TRANSACTION_getOmniExtraLog = 39;
        static final int TRANSACTION_getOmniJournalPath = 35;
        static final int TRANSACTION_isAppIntentActive = 17;
        static final int TRANSACTION_isWifiEnabled = 48;
        static final int TRANSACTION_jumpToSystemOtaPage = 25;
        static final int TRANSACTION_notifyCloseAutoGUISwitch = 27;
        static final int TRANSACTION_notifyLarkSendStausChanged = 32;
        static final int TRANSACTION_notifyStopAutoAction = 23;
        static final int TRANSACTION_notifyStopComplexTask = 18;
        static final int TRANSACTION_notifyUserAgreePrivacy = 1;
        static final int TRANSACTION_onLoginStateChange = 29;
        static final int TRANSACTION_pauseMusic = 43;
        static final int TRANSACTION_playMusic = 41;
        static final int TRANSACTION_registerMusicStateListener = 44;
        static final int TRANSACTION_replyAskUser = 19;
        static final int TRANSACTION_screenShot = 15;
        static final int TRANSACTION_sendSms = 49;
        static final int TRANSACTION_setDebugReferImg = 26;
        static final int TRANSACTION_setWifiEnabled = 47;
        static final int TRANSACTION_showAlarm = 5;
        static final int TRANSACTION_showAlbum = 8;
        static final int TRANSACTION_showAuditoryRecording = 20;
        static final int TRANSACTION_showCallHistory = 3;
        static final int TRANSACTION_showContact = 4;
        static final int TRANSACTION_showCountdown = 7;
        static final int TRANSACTION_showFile = 10;
        static final int TRANSACTION_showLarkUrl = 31;
        static final int TRANSACTION_showMemory = 14;
        static final int TRANSACTION_showMessage = 12;
        static final int TRANSACTION_showMusicPage = 42;
        static final int TRANSACTION_showNote = 6;
        static final int TRANSACTION_showPhoto = 9;
        static final int TRANSACTION_showProactiveMemory = 22;
        static final int TRANSACTION_showProxyCallHistory = 28;
        static final int TRANSACTION_showRecording = 11;
        static final int TRANSACTION_showSchedule = 13;
        static final int TRANSACTION_showWeather = 50;
        static final int TRANSACTION_takeScreenshot = 46;
        static final int TRANSACTION_terminateService = 2;
        static final int TRANSACTION_turnOnOffAlarm = 40;
        static final int TRANSACTION_unregisterMusicStateListener = 45;

        public static class Proxy implements IAgentAppIntentIDL {
            public static IAgentAppIntentIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public boolean isAppIntentActive() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isAppIntentActive();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public boolean isWifiEnabled() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 48, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isWifiEnabled();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void jumpToSystemOtaPage() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().jumpToSystemOtaPage();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void notifyCloseAutoGUISwitch() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyCloseAutoGUISwitch();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void notifyUserAgreePrivacy() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyUserAgreePrivacy();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public int pauseMusic() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 43, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().pauseMusic();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showMusicPage() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 42, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showMusicPage();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void terminateService() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().terminateService();     // Catch: Throwable -> L12
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

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void callShortLink(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 33, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().callShortLink(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void clearAllOmniTask(Map r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeMap(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 34, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearAllOmniTask(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void drainOmniUploadImagesForFeedback(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 36, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().drainOmniUploadImagesForFeedback(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public List<AppEntity> getAppEntityList(Map r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeMap(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 30, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList r103 = r102.createTypedArrayList(AppEntity.CREATOR);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<AppEntity> r104 = Stub.getDefaultImpl().getAppEntityList(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public List<String> getComplexTaskPanelInfoFromPC(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList<String> r103 = r102.createStringArrayList();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<String> r104 = Stub.getDefaultImpl().getComplexTaskPanelInfoFromPC(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public IntentDebugReport getIntentExecution(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeString(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L17
                if (r102.readInt() == 0) goto L14;
                IntentDebugReport r103 = IntentDebugReport.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L17
            L15:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IntentDebugReport r104 = Stub.getDefaultImpl().getIntentExecution(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public Map getOmniExtraLog(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 39, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                HashMap r103 = r102.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Map r104 = Stub.getDefaultImpl().getOmniExtraLog(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public List<String> getOmniJournalPath(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 35, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList<String> r103 = r102.createStringArrayList();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<String> r104 = Stub.getDefaultImpl().getOmniJournalPath(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void notifyStopComplexTask(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyStopComplexTask(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void onLoginStateChange(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onLoginStateChange(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void registerMusicStateListener(IMusicStateListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 44, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerMusicStateListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void screenShot(IScreenshotCallbackIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().screenShot(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void setDebugReferImg(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setDebugReferImg(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public boolean setWifiEnabled(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == false) goto L6;
                int r104 = 1;
            L7:
                r101.writeInt(r104);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 47, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L20
                if (r102.readInt() != 0) goto L18;
                r103 = false;
            L18:
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r105 = Stub.getDefaultImpl().setWifiEnabled(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r105;
            L6:
                r104 = 0;
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showAlarm(AlarmEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showAlarm(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showAlbum(AlbumEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showAlbum(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showAuditoryRecording(AuditoryRecordingEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showAuditoryRecording(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showCallHistory(CallHistoryEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showCallHistory(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showContact(ContactEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showContact(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showCountdown(CountdownEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showCountdown(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showFile(FileEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showFile(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showLarkUrl(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 31, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showLarkUrl(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showMemory(MemoryEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showMemory(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showMessage(MessageEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showMessage(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showNote(NoteEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showNote(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showProactiveMemory(ProactiveMemoryEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showProactiveMemory(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showProxyCallHistory(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showProxyCallHistory(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showRecording(RecordingEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showRecording(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showSchedule(ScheduleEntity r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().showSchedule(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void takeScreenshot(IScreenshotCallbackIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 46, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().takeScreenshot(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void unregisterMusicStateListener(IMusicStateListenerIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 45, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterMusicStateListener(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void deleteEntities(AppEntity[] r100, IEntityDeleteCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeTypedArray(r100, 0);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 52, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().deleteEntities(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void notifyLarkSendStausChanged(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeInt(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 32, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyLarkSendStausChanged(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void notifyStopAutoAction(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyStopAutoAction(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showPhoto(PhotoEntity[] r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeTypedArray(r100, 0);     // Catch: Throwable -> L12
                r102.writeInt(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showPhoto(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void showWeather(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 50, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().showWeather(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void turnOnOffAlarm(AlarmEntity r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L18
                int r103 = 0;
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L18
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L18
            L7:
                if (r101 == false) goto L9;
                r103 = 1;
            L9:
                r102.writeInt(r103);     // Catch: Throwable -> L18
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 40, r102, null, 1) == false) goto L12;
            L16:
                r102.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().turnOnOffAlarm(r100, r101);     // Catch: Throwable -> L18
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void deleteRecordings(RecordingEntity[] r100, boolean r101, IRecordingDeleteCallbackIDL r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                int r104 = 0;
                r103.writeTypedArray(r100, 0);     // Catch: Throwable -> L19
                if (r101 == false) goto L6;
                r104 = 1;
            L6:
                r103.writeInt(r104);     // Catch: Throwable -> L19
                if (r102 == null) goto L9;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L19
            L10:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 51, r103, null, 1) == false) goto L13;
            L17:
                r103.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().deleteRecordings(r100, r101, r102);     // Catch: Throwable -> L19
                r103.recycle();
                return;
            L9:
                r105 = null;
            L19:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public int playMusic(String r100, MusicEntity[] r101, MusicEntity r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r103.writeString(r100);     // Catch: Throwable -> L17
                r103.writeTypedArray(r101, 0);     // Catch: Throwable -> L17
                if (r102 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L17
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 41, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                int r105 = r104.readInt();     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                int r106 = Stub.getDefaultImpl().playMusic(r100, r101, r102);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return r106;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void callPhone(String r100, ContactEntity r101, String r102, String r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r104.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                r104.writeInt(1);     // Catch: Throwable -> L16
                r101.writeToParcel(r104, 0);     // Catch: Throwable -> L16
            L7:
                r104.writeString(r102);     // Catch: Throwable -> L16
                r104.writeString(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r104, null, 1) == false) goto L10;
            L14:
                r104.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().callPhone(r100, r101, r102, r103);     // Catch: Throwable -> L16
                r104.recycle();
                return;
            L6:
                r104.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void drainOmniUploadImagesForFeedbackWithType(String r100, String r101, List<String> r102, String r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r104.writeString(r100);     // Catch: Throwable -> L12
                r104.writeString(r101);     // Catch: Throwable -> L12
                r104.writeStringList(r102);     // Catch: Throwable -> L12
                r104.writeString(r103);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 38, r104, null, 1) == false) goto L6;
            L10:
                r104.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().drainOmniUploadImagesForFeedbackWithType(r100, r101, r102, r103);     // Catch: Throwable -> L12
                r104.recycle();
                return;
            L12:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void replyAskUser(String r100, String r101, String r102, Map r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r104.writeString(r100);     // Catch: Throwable -> L12
                r104.writeString(r101);     // Catch: Throwable -> L12
                r104.writeString(r102);     // Catch: Throwable -> L12
                r104.writeMap(r103);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r104, null, 1) == false) goto L6;
            L10:
                r104.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().replyAskUser(r100, r101, r102, r103);     // Catch: Throwable -> L12
                r104.recycle();
                return;
            L12:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void sendSms(String r100, ContactEntity r101, String r102, String r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r104.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                r104.writeInt(1);     // Catch: Throwable -> L16
                r101.writeToParcel(r104, 0);     // Catch: Throwable -> L16
            L7:
                r104.writeString(r102);     // Catch: Throwable -> L16
                r104.writeString(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 49, r104, null, 1) == false) goto L10;
            L14:
                r104.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().sendSms(r100, r101, r102, r103);     // Catch: Throwable -> L16
                r104.recycle();
                return;
            L6:
                r104.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
            public void drainOmniUploadImagesForFeedbackWithInfo(String r100, String r110, List<String> r111, String r112, boolean r113) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r101.writeString(r100);     // Catch: Throwable -> L16
                r101.writeString(r110);     // Catch: Throwable -> L16
                r101.writeStringList(r111);     // Catch: Throwable -> L16
                r101.writeString(r112);     // Catch: Throwable -> L16
                if (r113 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 37, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().drainOmniUploadImagesForFeedbackWithInfo(r100, r110, r111, r112, r113);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L16:
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

        public static IAgentAppIntentIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAgentAppIntentIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAgentAppIntentIDL) == false) goto L12;
            return (IAgentAppIntentIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAgentAppIntentIDL r100) {
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
            if (r100 == 1598968902) goto L182;
            boolean r101 = false;
            CallHistoryEntity r102 = null;
            ContactEntity r103 = null;
            MusicEntity r104 = null;
            AlarmEntity r105 = null;
            ProactiveMemoryEntity r106 = null;
            ContactEntity r107 = null;
            AuditoryRecordingEntity r108 = null;
            MemoryEntity r109 = null;
            ScheduleEntity r113 = null;
            MessageEntity r114 = null;
            RecordingEntity r115 = null;
            FileEntity r116 = null;
            AlbumEntity r117 = null;
            CountdownEntity r118 = null;
            NoteEntity r119 = null;
            AlarmEntity r120 = null;
            ContactEntity r121 = null;
            switch(r100) {
                case 1: goto L180;
                case 2: goto L178;
                case 3: goto L173;
                case 4: goto L168;
                case 5: goto L163;
                case 6: goto L158;
                case 7: goto L153;
                case 8: goto L148;
                case 9: goto L146;
                case 10: goto L141;
                case 11: goto L136;
                case 12: goto L131;
                case 13: goto L126;
                case 14: goto L121;
                case 15: goto L119;
                case 16: goto L114;
                case 17: goto L112;
                case 18: goto L110;
                case 19: goto L108;
                case 20: goto L103;
                case 21: goto L98;
                case 22: goto L93;
                case 23: goto L91;
                case 24: goto L89;
                case 25: goto L87;
                case 26: goto L85;
                case 27: goto L83;
                case 28: goto L81;
                case 29: goto L76;
                case 30: goto L74;
                case 31: goto L72;
                case 32: goto L70;
                case 33: goto L68;
                case 34: goto L66;
                case 35: goto L64;
                case 36: goto L62;
                case 37: goto L56;
                case 38: goto L54;
                case 39: goto L52;
                case 40: goto L44;
                case 41: goto L39;
                case 42: goto L37;
                case 43: goto L35;
                case 44: goto L33;
                case 45: goto L31;
                case 46: goto L29;
                case 47: goto L24;
                case 48: goto L22;
                case 49: goto L17;
                case 50: goto L15;
                case 51: goto L10;
                case 52: goto L8;
                default: goto L7;
            };
        L8:
            r110.enforceInterface(DESCRIPTOR);
            deleteEntities((AppEntity[]) r110.createTypedArray(AppEntity.CREATOR), IEntityDeleteCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L10:
            r110.enforceInterface(DESCRIPTOR);
            RecordingEntity[] r122 = (RecordingEntity[]) r110.createTypedArray(RecordingEntity.CREATOR);
            if (r110.readInt() == 0) goto L13;
            r101 = true;
        L13:
            deleteRecordings(r122, r101, IRecordingDeleteCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L15:
            r110.enforceInterface(DESCRIPTOR);
            showWeather(r110.readString(), r110.readString());
            return true;
        L17:
            r110.enforceInterface(DESCRIPTOR);
            String r123 = r110.readString();
            if (r110.readInt() == 0) goto L20;
            r103 = ContactEntity.CREATOR.createFromParcel(r110);
        L20:
            sendSms(r123, r103, r110.readString(), r110.readString());
            return true;
        L22:
            r110.enforceInterface(DESCRIPTOR);
            boolean r124 = isWifiEnabled();
            r111.writeNoException();
            r111.writeInt(r124 ? 1 : 0);
            return true;
        L24:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L27;
            r101 = true;
        L27:
            boolean r125 = setWifiEnabled(r101);
            r111.writeNoException();
            r111.writeInt(r125 ? 1 : 0);
            return true;
        L29:
            r110.enforceInterface(DESCRIPTOR);
            takeScreenshot(IScreenshotCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L31:
            r110.enforceInterface(DESCRIPTOR);
            unregisterMusicStateListener(IMusicStateListenerIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L33:
            r110.enforceInterface(DESCRIPTOR);
            registerMusicStateListener(IMusicStateListenerIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L35:
            r110.enforceInterface(DESCRIPTOR);
            int r126 = pauseMusic();
            r111.writeNoException();
            r111.writeInt(r126);
            return true;
        L37:
            r110.enforceInterface(DESCRIPTOR);
            showMusicPage();
            return true;
        L39:
            r110.enforceInterface(DESCRIPTOR);
            String r127 = r110.readString();
            MusicEntity.CREATOR r128 = MusicEntity.CREATOR;
            MusicEntity[] r129 = (MusicEntity[]) r110.createTypedArray(r128);
            if (r110.readInt() == 0) goto L42;
            r104 = r128.createFromParcel(r110);
        L42:
            int r130 = playMusic(r127, r129, r104);
            r111.writeNoException();
            r111.writeInt(r130);
            return true;
        L44:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L48;
            r105 = AlarmEntity.CREATOR.createFromParcel(r110);
        L48:
            if (r110.readInt() == 0) goto L50;
            r101 = true;
        L50:
            turnOnOffAlarm(r105, r101);
            return true;
        L52:
            r110.enforceInterface(DESCRIPTOR);
            Map r131 = getOmniExtraLog(r110.readString());
            r111.writeNoException();
            r111.writeMap(r131);
            return true;
        L54:
            r110.enforceInterface(DESCRIPTOR);
            drainOmniUploadImagesForFeedbackWithType(r110.readString(), r110.readString(), r110.createStringArrayList(), r110.readString());
            return true;
        L56:
            r110.enforceInterface(DESCRIPTOR);
            String r132 = r110.readString();
            String r133 = r110.readString();
            ArrayList<String> r134 = r110.createStringArrayList();
            String r135 = r110.readString();
            if (r110.readInt() == 0) goto L59;
            boolean r136 = true;
        L60:
            drainOmniUploadImagesForFeedbackWithInfo(r132, r133, r134, r135, r136);
            return true;
        L59:
            r136 = false;
            goto L60
        L62:
            r110.enforceInterface(DESCRIPTOR);
            drainOmniUploadImagesForFeedback(r110.readString());
            return true;
        L64:
            r110.enforceInterface(DESCRIPTOR);
            List<String> r137 = getOmniJournalPath(r110.readString());
            r111.writeNoException();
            r111.writeStringList(r137);
            return true;
        L66:
            r110.enforceInterface(DESCRIPTOR);
            clearAllOmniTask(r110.readHashMap(getClass().getClassLoader()));
            return true;
        L68:
            r110.enforceInterface(DESCRIPTOR);
            callShortLink(r110.readString());
            return true;
        L70:
            r110.enforceInterface(DESCRIPTOR);
            notifyLarkSendStausChanged(r110.readString(), r110.readInt());
            return true;
        L72:
            r110.enforceInterface(DESCRIPTOR);
            showLarkUrl(r110.readString());
            return true;
        L74:
            r110.enforceInterface(DESCRIPTOR);
            List<AppEntity> r138 = getAppEntityList(r110.readHashMap(getClass().getClassLoader()));
            r111.writeNoException();
            r111.writeTypedList(r138);
            return true;
        L76:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L79;
            r101 = true;
        L79:
            onLoginStateChange(r101);
            return true;
        L81:
            r110.enforceInterface(DESCRIPTOR);
            showProxyCallHistory(r110.readString());
            return true;
        L83:
            r110.enforceInterface(DESCRIPTOR);
            notifyCloseAutoGUISwitch();
            return true;
        L85:
            r110.enforceInterface(DESCRIPTOR);
            setDebugReferImg(r110.readString());
            return true;
        L87:
            r110.enforceInterface(DESCRIPTOR);
            jumpToSystemOtaPage();
            return true;
        L89:
            r110.enforceInterface(DESCRIPTOR);
            List<String> r139 = getComplexTaskPanelInfoFromPC(r110.readInt());
            r111.writeNoException();
            r111.writeStringList(r139);
            return true;
        L91:
            r110.enforceInterface(DESCRIPTOR);
            notifyStopAutoAction(r110.readString(), r110.readString());
            return true;
        L93:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L96;
            r106 = ProactiveMemoryEntity.CREATOR.createFromParcel(r110);
        L96:
            showProactiveMemory(r106);
            return true;
        L98:
            r110.enforceInterface(DESCRIPTOR);
            String r140 = r110.readString();
            if (r110.readInt() == 0) goto L101;
            r107 = ContactEntity.CREATOR.createFromParcel(r110);
        L101:
            callPhone(r140, r107, r110.readString(), r110.readString());
            return true;
        L103:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L106;
            r108 = AuditoryRecordingEntity.CREATOR.createFromParcel(r110);
        L106:
            showAuditoryRecording(r108);
            return true;
        L108:
            r110.enforceInterface(DESCRIPTOR);
            replyAskUser(r110.readString(), r110.readString(), r110.readString(), r110.readHashMap(getClass().getClassLoader()));
            return true;
        L110:
            r110.enforceInterface(DESCRIPTOR);
            notifyStopComplexTask(r110.readString());
            return true;
        L112:
            r110.enforceInterface(DESCRIPTOR);
            boolean r141 = isAppIntentActive();
            r111.writeNoException();
            r111.writeInt(r141 ? 1 : 0);
            return true;
        L114:
            r110.enforceInterface(DESCRIPTOR);
            IntentDebugReport r142 = getIntentExecution(r110.readString());
            r111.writeNoException();
            if (r142 == null) goto L117;
            r111.writeInt(1);
            r142.writeToParcel(r111, 1);
        L118:
            return true;
        L117:
            r111.writeInt(0);
            goto L118
        L119:
            r110.enforceInterface(DESCRIPTOR);
            screenShot(IScreenshotCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L121:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L124;
            r109 = MemoryEntity.CREATOR.createFromParcel(r110);
        L124:
            showMemory(r109);
            return true;
        L126:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L129;
            r113 = ScheduleEntity.CREATOR.createFromParcel(r110);
        L129:
            showSchedule(r113);
            return true;
        L131:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L134;
            r114 = MessageEntity.CREATOR.createFromParcel(r110);
        L134:
            showMessage(r114);
            return true;
        L136:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L139;
            r115 = RecordingEntity.CREATOR.createFromParcel(r110);
        L139:
            showRecording(r115);
            return true;
        L141:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L144;
            r116 = FileEntity.CREATOR.createFromParcel(r110);
        L144:
            showFile(r116);
            return true;
        L146:
            r110.enforceInterface(DESCRIPTOR);
            showPhoto((PhotoEntity[]) r110.createTypedArray(PhotoEntity.CREATOR), r110.readInt());
            return true;
        L148:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L151;
            r117 = AlbumEntity.CREATOR.createFromParcel(r110);
        L151:
            showAlbum(r117);
            return true;
        L153:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L156;
            r118 = CountdownEntity.CREATOR.createFromParcel(r110);
        L156:
            showCountdown(r118);
            return true;
        L158:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L161;
            r119 = NoteEntity.CREATOR.createFromParcel(r110);
        L161:
            showNote(r119);
            return true;
        L163:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L166;
            r120 = AlarmEntity.CREATOR.createFromParcel(r110);
        L166:
            showAlarm(r120);
            return true;
        L168:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L171;
            r121 = ContactEntity.CREATOR.createFromParcel(r110);
        L171:
            showContact(r121);
            return true;
        L173:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L176;
            r102 = CallHistoryEntity.CREATOR.createFromParcel(r110);
        L176:
            showCallHistory(r102);
            return true;
        L178:
            r110.enforceInterface(DESCRIPTOR);
            terminateService();
            return true;
        L180:
            r110.enforceInterface(DESCRIPTOR);
            notifyUserAgreePrivacy();
            return true;
        L7:
            return super.onTransact(r100, r110, r111, r112);
        L182:
            r111.writeString(DESCRIPTOR);
            return true;
        }
    }

    void callPhone(String r100, ContactEntity r101, String r102, String r103) throws RemoteException;

    void callShortLink(String r100) throws RemoteException;

    void clearAllOmniTask(Map r100) throws RemoteException;

    void deleteEntities(AppEntity[] r100, IEntityDeleteCallbackIDL r101) throws RemoteException;

    void deleteRecordings(RecordingEntity[] r100, boolean r101, IRecordingDeleteCallbackIDL r102) throws RemoteException;

    void drainOmniUploadImagesForFeedback(String r100) throws RemoteException;

    void drainOmniUploadImagesForFeedbackWithInfo(String r100, String r101, List<String> r102, String r103, boolean r104) throws RemoteException;

    void drainOmniUploadImagesForFeedbackWithType(String r100, String r101, List<String> r102, String r103) throws RemoteException;

    List<AppEntity> getAppEntityList(Map r100) throws RemoteException;

    List<String> getComplexTaskPanelInfoFromPC(int r100) throws RemoteException;

    IntentDebugReport getIntentExecution(String r100) throws RemoteException;

    Map getOmniExtraLog(String r100) throws RemoteException;

    List<String> getOmniJournalPath(String r100) throws RemoteException;

    boolean isAppIntentActive() throws RemoteException;

    boolean isWifiEnabled() throws RemoteException;

    void jumpToSystemOtaPage() throws RemoteException;

    void notifyCloseAutoGUISwitch() throws RemoteException;

    void notifyLarkSendStausChanged(String r100, int r101) throws RemoteException;

    void notifyStopAutoAction(String r100, String r101) throws RemoteException;

    void notifyStopComplexTask(String r100) throws RemoteException;

    void notifyUserAgreePrivacy() throws RemoteException;

    void onLoginStateChange(boolean r100) throws RemoteException;

    int pauseMusic() throws RemoteException;

    int playMusic(String r100, MusicEntity[] r101, MusicEntity r102) throws RemoteException;

    void registerMusicStateListener(IMusicStateListenerIDL r100) throws RemoteException;

    void replyAskUser(String r100, String r101, String r102, Map r103) throws RemoteException;

    void screenShot(IScreenshotCallbackIDL r100) throws RemoteException;

    void sendSms(String r100, ContactEntity r101, String r102, String r103) throws RemoteException;

    void setDebugReferImg(String r100) throws RemoteException;

    boolean setWifiEnabled(boolean r100) throws RemoteException;

    void showAlarm(AlarmEntity r100) throws RemoteException;

    void showAlbum(AlbumEntity r100) throws RemoteException;

    void showAuditoryRecording(AuditoryRecordingEntity r100) throws RemoteException;

    void showCallHistory(CallHistoryEntity r100) throws RemoteException;

    void showContact(ContactEntity r100) throws RemoteException;

    void showCountdown(CountdownEntity r100) throws RemoteException;

    void showFile(FileEntity r100) throws RemoteException;

    void showLarkUrl(String r100) throws RemoteException;

    void showMemory(MemoryEntity r100) throws RemoteException;

    void showMessage(MessageEntity r100) throws RemoteException;

    void showMusicPage() throws RemoteException;

    void showNote(NoteEntity r100) throws RemoteException;

    void showPhoto(PhotoEntity[] r100, int r101) throws RemoteException;

    void showProactiveMemory(ProactiveMemoryEntity r100) throws RemoteException;

    void showProxyCallHistory(String r100) throws RemoteException;

    void showRecording(RecordingEntity r100) throws RemoteException;

    void showSchedule(ScheduleEntity r100) throws RemoteException;

    void showWeather(String r100, String r101) throws RemoteException;

    void takeScreenshot(IScreenshotCallbackIDL r100) throws RemoteException;

    void terminateService() throws RemoteException;

    void turnOnOffAlarm(AlarmEntity r100, boolean r101) throws RemoteException;

    void unregisterMusicStateListener(IMusicStateListenerIDL r100) throws RemoteException;
}
