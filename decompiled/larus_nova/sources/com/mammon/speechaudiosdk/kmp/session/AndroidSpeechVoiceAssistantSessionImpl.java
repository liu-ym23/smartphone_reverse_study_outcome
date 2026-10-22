package com.mammon.speechaudiosdk.kmp.session;

import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreAsrContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreTtsContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantLoudnessStrategyParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantTextData;
import com.mammon.speechaudiosdk.kmp.bridge.KMPSpeechAudioLoudnessStratergyParam2NativeKt;
import com.mammon.speechaudiosdk.kmp.bridge.NativeSAMICoreBlock2KMPKt;
import com.mammon.speechaudiosdk.kmp.bridge.NativeSAMICoreCallBackEventType2KMPKt;
import com.mammon.speechaudiosdk.kmp.bridge.va.KMPSpeechVoiceAssistantSessionAsrContextParam2NativeKt;
import com.mammon.speechaudiosdk.kmp.bridge.va.KMPSpeechVoiceAssistantSessionContextPama2NativeKt;
import com.mammon.speechaudiosdk.kmp.bridge.va.KMPSpeechVoiceAssistantSessionStartSessionParam2NativeKt;
import com.mammon.speechaudiosdk.kmp.bridge.va.KMPSpeechVoiceAssistantSessionStartTtsParam2NativeKt;
import com.mammon.speechaudiosdk.kmp.bridge.va.KMPSpeechVoiceAssistantSessionTtsContextParam2NativeKt;
import com.mammon.speechaudiosdk.kmp.param.SpeechAudioLoudnessStrategyParam;
import com.mammon.speechaudiosdk.kmp.param.SpeechAudioNetConnectionEventParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionAsrContextParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionAudioParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionBidirectionalTtsParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionContextParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionDownlinkEventParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionStartSessionParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionStartTtsParam;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionTtsContextParam;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTransportType;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionDownlinkEventType;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionUplinkEventType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001%B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/session/AndroidSpeechVoiceAssistantSessionImpl;", "Lcom/mammon/speechaudiosdk/kmp/session/SpeechVoiceAssistantSession;", "kmpListener", "Lcom/mammon/speechaudiosdk/kmp/session/SpeechVoiceAssistantSessionListener;", "<init>", "(Lcom/mammon/speechaudiosdk/kmp/session/SpeechVoiceAssistantSessionListener;)V", "nativeTaskId", "", "nativeSessionId", "nativeSAMICoreImpl", "Lcom/mammon/speechaudiosdk/kmp/session/AndroidSpeechVoiceAssistantSessionImpl$NativeSAMICoreImpl;", "init", "", "sessionContextParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionContextParam;", "start", "stop", "release", "setAsrContextParam", "asrParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAsrContextParam;", "setAsrCompressParam", "compressBitRate", "setTtsContextParam", "ttsParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionTtsContextParam;", "sendUplinkEvent", "event", "Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionUplinkEventType;", "eventParam", "", "sendUplinkAudio", "audioParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAudioParam;", "setLoudnessStrategyParameter", "loudnessStrategyParam", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioLoudnessStrategyParam;", "NativeSAMICoreImpl", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AndroidSpeechVoiceAssistantSessionImpl implements SpeechVoiceAssistantSession {
    private final SpeechVoiceAssistantSessionListener kmpListener;
    private final NativeSAMICoreImpl nativeSAMICoreImpl;
    private String nativeSessionId;
    private String nativeTaskId;

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\tJ\u0014\u0010 \u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010!\u001a\u00020\tH\u0002J\b\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\u0014\u0010$\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010%\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010&\u001a\u00020\tH\u0002J$\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/session/AndroidSpeechVoiceAssistantSessionImpl$NativeSAMICoreImpl;", "", "<init>", "(Lcom/mammon/speechaudiosdk/kmp/session/AndroidSpeechVoiceAssistantSessionImpl;)V", "nativeSamiCore", "Lcom/mammon/audiosdk/SAMICore;", "setSAMICoreListener", "", "createSAMICoreHandle", "", "sessionContextParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionContextParam;", "releaseSAMICoreHandle", "startNetConnection", "stopNetConnection", "setTtsContextParam", "ttsParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionTtsContextParam;", "setAsrContextParam", "asrParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAsrContextParam;", "setAsrCompressParam", "compressBitRate", "sendUplinkAudio", "audioParam", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAudioParam;", "sendUplinkEvent", "event", "Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionUplinkEventType;", "eventParam", "sendStartTask", "sendFinishTask", "sendStartSession", "sendFinishSession", "sendCancelSession", "sendEndAsr", "sendStartTts", "sendBidirectionalTtsText", "sendBidirectionalEndTts", "setVoiceAssistantProperty", "propertyId", "Lcom/mammon/audiosdk/enums/SAMICorePropertyId;", "dataType", "Lcom/mammon/audiosdk/enums/SAMICoreDataType;", "dataObj", "setLoudnessStrategyParameter", "loudnessStrategyParam", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioLoudnessStrategyParam;", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NativeSAMICoreImpl {
        private final SAMICore nativeSamiCore;
        final /* synthetic */ AndroidSpeechVoiceAssistantSessionImpl this$0;

        /* JADX INFO: loaded from: classes32.dex */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r100 = new int[SpeechVoiceAssistantSessionUplinkEventType.values().length];
                r100[SpeechVoiceAssistantSessionUplinkEventType.StartSession.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r100[SpeechVoiceAssistantSessionUplinkEventType.FinishSession.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r100[SpeechVoiceAssistantSessionUplinkEventType.CancelSession.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[SpeechVoiceAssistantSessionUplinkEventType.EndASR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r100[SpeechVoiceAssistantSessionUplinkEventType.StartTTS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r100[SpeechVoiceAssistantSessionUplinkEventType.BidirectionalTTSText.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r100[SpeechVoiceAssistantSessionUplinkEventType.BIDIRECTIONALEndTTS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                $EnumSwitchMapping$0 = r100;
            }
        }

        public static /* synthetic */ void a(AndroidSpeechVoiceAssistantSessionImpl r100, SAMICoreCallBackEventType r101, SAMICoreBlock r102) {
            setSAMICoreListener$lambda$0(r100, r101, r102);
        }

        private final int sendBidirectionalEndTts() {
            SAMICoreVoiceAssistantPropertyParameter r100 = new SAMICoreVoiceAssistantPropertyParameter();
            r100.taskId = AndroidSpeechVoiceAssistantSessionImpl.access$getNativeTaskId$p(this.this$0);
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_BidirectionalTTS_EndTTS, SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param, r100);
        }

        private final int sendCancelSession() {
            SAMICoreVoiceAssistantPropertyParameter r100 = new SAMICoreVoiceAssistantPropertyParameter();
            r100.taskId = AndroidSpeechVoiceAssistantSessionImpl.access$getNativeTaskId$p(this.this$0);
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Cancel_Session, SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param, r100);
        }

        private final int sendEndAsr() {
            SAMICoreVoiceAssistantPropertyParameter r100 = new SAMICoreVoiceAssistantPropertyParameter();
            r100.taskId = AndroidSpeechVoiceAssistantSessionImpl.access$getNativeTaskId$p(this.this$0);
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_End_Asr, SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param, r100);
        }

        private final int sendFinishSession() {
            SAMICoreVoiceAssistantPropertyParameter r100 = new SAMICoreVoiceAssistantPropertyParameter();
            r100.taskId = AndroidSpeechVoiceAssistantSessionImpl.access$getNativeTaskId$p(this.this$0);
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Finish_Session, SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param, r100);
        }

        public final int releaseSAMICoreHandle() {
            return this.nativeSamiCore.SAMICoreDestroyHandle();
        }

        public final int sendFinishTask() {
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Finish_Task, SAMICoreDataType.SAMICoreDataType_Null, null);
        }

        public final int sendStartTask() {
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Task, SAMICoreDataType.SAMICoreDataType_Null, null);
        }

        public final void setSAMICoreListener() {
            SAMICore r100 = this.nativeSamiCore;
            final AndroidSpeechVoiceAssistantSessionImpl r101 = this.this$0;
            r100.setListener(new a(r101));
        }

        public final int startNetConnection() {
            SAMICoreVoiceAssistantPropertyParameter r100 = new SAMICoreVoiceAssistantPropertyParameter();
            r100.enableRealtimeVoiceCall = false;
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Ws_Connect, SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param, r100);
        }

        public final int stopNetConnection() {
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Stop_Ws_Connect, SAMICoreDataType.SAMICoreDataType_Null, null);
        }

        public NativeSAMICoreImpl(AndroidSpeechVoiceAssistantSessionImpl r100) {
            this.this$0 = r100;
            this.nativeSamiCore = new SAMICore();
        }

        private final int sendBidirectionalTtsText(Object r100) {
            if ((r100 instanceof SpeechVoiceAssistantSessionBidirectionalTtsParam) == false) goto L5;
            SpeechVoiceAssistantSessionBidirectionalTtsParam r101 = (SpeechVoiceAssistantSessionBidirectionalTtsParam) r100;
        L6:
            if (r101 != null) goto L9;
            System.out.println("BIDIRECTIONAL_TTS_TEXT param is null");
            return 100001;
        L9:
            SAMICoreVoiceAssistantTextData r102 = new SAMICoreVoiceAssistantTextData();
            AndroidSpeechVoiceAssistantSessionImpl r103 = this.this$0;
            r102.text = r101.getText();
            r102.taskId = AndroidSpeechVoiceAssistantSessionImpl.access$getNativeTaskId$p(r103);
            SAMICoreBlock r104 = new SAMICoreBlock();
            r104.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Text_data;
            r104.audioData = new SAMICoreVoiceAssistantTextData[]{r102};
            r104.numberAudioData = 1;
            return this.nativeSamiCore.SAMICoreProcess(r104, null);
        L5:
            r101 = null;
            goto L6
        }

        private final int sendStartSession(Object r100) {
            if ((r100 instanceof SpeechVoiceAssistantSessionStartSessionParam) == false) goto L5;
            SpeechVoiceAssistantSessionStartSessionParam r101 = (SpeechVoiceAssistantSessionStartSessionParam) r100;
        L6:
            if (r101 != null) goto L9;
            System.out.println("StartSession param is invalid");
            return 100001;
        L9:
            AndroidSpeechVoiceAssistantSessionImpl.access$setNativeTaskId$p(this.this$0, r101.getTaskId());
            AndroidSpeechVoiceAssistantSessionImpl.access$setNativeSessionId$p(this.this$0, r101.getSessionId());
            SAMICoreVoiceAssistantPropertyParameter r102 = KMPSpeechVoiceAssistantSessionStartSessionParam2NativeKt.toNative(r101);
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Session, SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param, r102);
        L5:
            r101 = null;
            goto L6
        }

        private final int sendStartTts(Object r100) {
            if ((r100 instanceof SpeechVoiceAssistantSessionStartTtsParam) == false) goto L5;
            SpeechVoiceAssistantSessionStartTtsParam r101 = (SpeechVoiceAssistantSessionStartTtsParam) r100;
        L6:
            if (r101 != null) goto L9;
            System.out.println("START_TTS param is null");
            return 100001;
        L9:
            SAMICoreVoiceAssistantPropertyParameter r102 = KMPSpeechVoiceAssistantSessionStartTtsParam2NativeKt.toNative(r101);
            if (r102.taskId != null) goto L13;
            r102.taskId = AndroidSpeechVoiceAssistantSessionImpl.access$getNativeTaskId$p(this.this$0);
        L13:
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Tts, SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param, r102);
        L5:
            r101 = null;
            goto L6
        }

        public final int createSAMICoreHandle(SpeechVoiceAssistantSessionContextParam r100) {
            Intrinsics.checkNotNullParameter(r100, "sessionContextParam");
            SAMICoreVoiceAssistantContextCreateParameter r101 = KMPSpeechVoiceAssistantSessionContextPama2NativeKt.toNative(r100);
            return this.nativeSamiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Voice_Assistant_Online, r101);
        }

        public final int sendUplinkAudio(SpeechVoiceAssistantSessionAudioParam r100) {
            Intrinsics.checkNotNullParameter(r100, "audioParam");
            SAMICoreVoiceAssistantAudioData r101 = new SAMICoreVoiceAssistantAudioData();
            AndroidSpeechVoiceAssistantSessionImpl r102 = this.this$0;
            String r103 = r100.getTaskId();
            if (r103 != null) goto L5;
            r103 = AndroidSpeechVoiceAssistantSessionImpl.access$getNativeTaskId$p(r102);
        L5:
            r101.taskId = r103;
            String r104 = r100.getSessionId();
            if (r104 != null) goto L8;
            r104 = AndroidSpeechVoiceAssistantSessionImpl.access$getNativeSessionId$p(r102);
        L8:
            r101.sessionId = r104;
            r101.data = r100.getData();
            r101.refData = r100.getRefData();
            r101.extra = r100.getExtra();
            SAMICoreBlock r105 = new SAMICoreBlock();
            r105.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Audio_data;
            r105.audioData = new SAMICoreVoiceAssistantAudioData[]{r101};
            r105.numberAudioData = 1;
            return this.nativeSamiCore.SAMICoreProcess(r105, null);
        }

        public final int setAsrCompressParam(int r100) {
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Update_Encoder_Bitrate, SAMICoreDataType.SAMICoreDataType_Int, Integer.valueOf(r100));
        }

        public final int setAsrContextParam(SpeechVoiceAssistantSessionAsrContextParam r100) {
            Intrinsics.checkNotNullParameter(r100, "asrParam");
            SAMICoreAsrContextCreateParameter r101 = KMPSpeechVoiceAssistantSessionAsrContextParam2NativeKt.toNative(r100);
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Asr_Param, SAMICoreDataType.SAMICoreDataType_WebSocket_Asr_Context_Param, r101);
        }

        public final int setLoudnessStrategyParameter(SpeechAudioLoudnessStrategyParam r100) {
            Intrinsics.checkNotNullParameter(r100, "loudnessStrategyParam");
            SAMICoreVoiceAssistantLoudnessStrategyParameter r101 = KMPSpeechAudioLoudnessStratergyParam2NativeKt.toNative(r100);
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Loudness_Strategy_Param, SAMICoreDataType.SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param, r101);
        }

        public final int setTtsContextParam(SpeechVoiceAssistantSessionTtsContextParam r100) {
            Intrinsics.checkNotNullParameter(r100, "ttsParam");
            SAMICoreTtsContextCreateParameter r101 = KMPSpeechVoiceAssistantSessionTtsContextParam2NativeKt.toNative(r100);
            return setVoiceAssistantProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Tts_Param, SAMICoreDataType.SAMICoreDataType_WebSocket_Tts_Context_Param, r101);
        }

        public final int sendUplinkEvent(SpeechVoiceAssistantSessionUplinkEventType r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
                case 1: goto L13;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L14:
            return sendBidirectionalEndTts();
        L15:
            return sendBidirectionalTtsText(r101);
        L16:
            return sendStartTts(r101);
        L17:
            return sendEndAsr();
        L18:
            return sendCancelSession();
        L19:
            return sendFinishSession();
        L13:
            return sendStartSession(r101);
        }

        private static final void setSAMICoreListener$lambda$0(AndroidSpeechVoiceAssistantSessionImpl r100, SAMICoreCallBackEventType r101, SAMICoreBlock r102) {
            if (r101 != null) goto L4;
            return;
        L4:
            SAMICoreDataType r103 = r102.dataType;
            if (r103 != SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event) goto L10;
            SpeechAudioNetConnectionEventParam r104 = NativeSAMICoreBlock2KMPKt.toNetConnectionEventKmp(r102);
            SpeechVoiceAssistantSessionListener r105 = AndroidSpeechVoiceAssistantSessionImpl.access$getKmpListener$p(r100);
            if (r105 == null) goto L15;
            r105.onNetConnectionStateChangedEvent(SpeechAudioTransportType.UNKNOWN, r104);
            return;
        L15:
            return;
        L10:
            if (r103 != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L17;
            SpeechVoiceAssistantSessionDownlinkEventType r106 = NativeSAMICoreCallBackEventType2KMPKt.toVoiceAssistantSessionDownlinkEventKmp(r101);
            SpeechVoiceAssistantSessionDownlinkEventParam r107 = NativeSAMICoreBlock2KMPKt.toDownlinkEventKmp(r102);
            SpeechVoiceAssistantSessionListener r108 = AndroidSpeechVoiceAssistantSessionImpl.access$getKmpListener$p(r100);
            if (r108 == null) goto L18;
            r108.onDownlinkEvent(r106, r107);
            return;
        L18:
            return;
        }

        private final int setVoiceAssistantProperty(SAMICorePropertyId r100, SAMICoreDataType r101, Object r102) {
            SAMICoreProperty r103 = new SAMICoreProperty();
            r103.f384359id = r100;
            r103.type = r101;
            if (r102 == null) goto L6;
            r103.dataObjectArray = new Object[]{r102};
            r103.dataArrayLen = 1;
        L6:
            return this.nativeSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r103);
        }

        public static /* synthetic */ int sendStartSession$default(NativeSAMICoreImpl r100, Object r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.sendStartSession(r101);
        }

        public static /* synthetic */ int sendStartTts$default(NativeSAMICoreImpl r100, Object r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.sendStartTts(r101);
        }

        public static /* synthetic */ int setVoiceAssistantProperty$default(NativeSAMICoreImpl r100, SAMICorePropertyId r101, SAMICoreDataType r102, Object r103, int r104, Object r105) {
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            return r100.setVoiceAssistantProperty(r101, r102, r103);
        }
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSession
    public int release() {
        return this.nativeSAMICoreImpl.releaseSAMICoreHandle();
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSession
    public int start() {
        int r100 = this.nativeSAMICoreImpl.startNetConnection();
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return this.nativeSAMICoreImpl.sendStartTask();
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSession
    public int stop() {
        if (this.nativeSAMICoreImpl.sendFinishTask() == 0) goto L6;
        System.out.println("sendFinishTask failed");
    L6:
        return this.nativeSAMICoreImpl.stopNetConnection();
    }

    public AndroidSpeechVoiceAssistantSessionImpl(SpeechVoiceAssistantSessionListener r100) {
        this.kmpListener = r100;
        this.nativeSAMICoreImpl = new NativeSAMICoreImpl(this);
    }

    public static final /* synthetic */ SpeechVoiceAssistantSessionListener access$getKmpListener$p(AndroidSpeechVoiceAssistantSessionImpl r100) {
        return r100.kmpListener;
    }

    public static final /* synthetic */ String access$getNativeSessionId$p(AndroidSpeechVoiceAssistantSessionImpl r100) {
        return r100.nativeSessionId;
    }

    public static final /* synthetic */ String access$getNativeTaskId$p(AndroidSpeechVoiceAssistantSessionImpl r100) {
        return r100.nativeTaskId;
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSession
    public int init(SpeechVoiceAssistantSessionContextParam r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionContextParam");
        this.nativeSAMICoreImpl.setSAMICoreListener();
        return this.nativeSAMICoreImpl.createSAMICoreHandle(r100);
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSession
    public int sendUplinkAudio(SpeechVoiceAssistantSessionAudioParam r100) {
        Intrinsics.checkNotNullParameter(r100, "audioParam");
        return this.nativeSAMICoreImpl.sendUplinkAudio(r100);
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSession
    public int setAsrCompressParam(int r100) {
        return this.nativeSAMICoreImpl.setAsrCompressParam(r100);
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSession
    public int setAsrContextParam(SpeechVoiceAssistantSessionAsrContextParam r100) {
        Intrinsics.checkNotNullParameter(r100, "asrParam");
        return this.nativeSAMICoreImpl.setAsrContextParam(r100);
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSession
    public int setLoudnessStrategyParameter(SpeechAudioLoudnessStrategyParam r100) {
        Intrinsics.checkNotNullParameter(r100, "loudnessStrategyParam");
        return this.nativeSAMICoreImpl.setLoudnessStrategyParameter(r100);
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSession
    public int setTtsContextParam(SpeechVoiceAssistantSessionTtsContextParam r100) {
        Intrinsics.checkNotNullParameter(r100, "ttsParam");
        return this.nativeSAMICoreImpl.setTtsContextParam(r100);
    }

    public static final /* synthetic */ void access$setNativeSessionId$p(AndroidSpeechVoiceAssistantSessionImpl r100, String r101) {
        r100.nativeSessionId = r101;
    }

    public static final /* synthetic */ void access$setNativeTaskId$p(AndroidSpeechVoiceAssistantSessionImpl r100, String r101) {
        r100.nativeTaskId = r101;
    }

    @Override // com.mammon.speechaudiosdk.kmp.session.SpeechVoiceAssistantSession
    public int sendUplinkEvent(SpeechVoiceAssistantSessionUplinkEventType r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.nativeSAMICoreImpl.sendUplinkEvent(r100, r101);
    }
}
