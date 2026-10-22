package com.mammon.speechaudiosdk.kmp.bridge.va;

import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.mammon.speechaudiosdk.kmp.param.va.SpeechVoiceAssistantSessionStartSessionParam;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionRequestType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"toNative", "Lcom/mammon/audiosdk/structures/SAMICoreVoiceAssistantPropertyParameter;", "Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionStartSessionParam;", "toActualBytes", "", "requestedSize", "", "actualSize", "speech_audiosdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KMPSpeechVoiceAssistantSessionStartSessionParam2NativeKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[SpeechVoiceAssistantSessionRequestType.values().length];
            r100[SpeechVoiceAssistantSessionRequestType.MessageASR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SpeechVoiceAssistantSessionRequestType.MessageTTS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SpeechVoiceAssistantSessionRequestType.BidirectionalTTS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final SAMICoreVoiceAssistantPropertyParameter toNative(SpeechVoiceAssistantSessionStartSessionParam r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        SAMICoreVoiceAssistantPropertyParameter r101 = new SAMICoreVoiceAssistantPropertyParameter();
        r101.taskId = r100.getTaskId();
        r101.sessionId = r100.getSessionId();
        r101.conversationId = r100.getConversationId();
        r101.enableAudioInput = r100.getEnableAudioInput();
        r101.enableUploadAudio = r100.getEnableUploadAudio();
        r101.enableTextReading = r100.getEnableTextReading();
        r101.enablePlayer = r100.getEnablePlayer();
        r101.enableRealtimeVoiceCall = r100.getEnableRealtimeVoiceCall();
        r101.interruptType = r100.getInterruptType();
        r101.question = r100.getQuestion();
        r101.chat = r100.getChat();
        r101.reconnectQuestionId = r100.getReconnectQuestionId();
        r101.reconnectStatus = r100.getReconnectStatus();
        r101.business = r100.getBusiness();
        r101.triggerType = r100.getTriggerType();
        r101.extra = r100.getExtra();
        r101.updateUIContextPayload = r100.getUpdateUIContextPayload();
        r101.updatePersonalContextPayload = r100.getUpdatePersonalContextPayload();
        r101.uploadInfoPayload = r100.getUploadInfoPayload();
        r101.trace = r100.getTrace();
        r101.playerStatus = r100.getPlayerStatus();
        r101.volume = r100.getVolume();
        r101.sceneType = r100.getSceneType();
        r101.imageId = r100.getImageId();
        r101.wakeupId = r100.getWakeupId();
        r101.imageType = r100.getImageType();
        r101.intentMode = r100.getIntentMode();
        r101.imageStatus = r100.getImageStatus();
        r101.highQuality = r100.getHighQuality();
        r101.enableTouch = r100.getEnableTouch();
        r101.enableBurst = r100.getEnableBurst();
        r101.enableAudioRecorder = r100.getEnableAudioRecorder();
        r101.audioRecordChannels = r100.getAudioRecordChannels();
        r101.imgData = toActualBytes(r100.getImgData(), r100.getImgDataLen());
        r101.updateAudioConfigPayload = r100.getUpdateAudioConfigPayload();
        r101.multimodalStatus = r100.getMultimodalStatus();
        r101.vuiQueryMode = r100.getVuiQueryMode();
        r101.enableOneShot = r100.getEnableOneShot();
        r101.wakeupWord = r100.getWakeupWord();
        r101.wakeupAudioDurationMs = r100.getWakeupAudioDurationMs();
        SpeechVoiceAssistantSessionRequestType r102 = r100.getRequestType();
        if (r102 == null) goto L14;
        r101.requestType = r102.getValue();
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L7;
        r101.enableAudioInput = true;
        goto L14
    L7:
        if (r103 != 2) goto L9;
        r101.enableTextReading = true;
        goto L14
    L9:
        if (r103 != 3) goto L14;
        r101.enableTextReading = true;
    L14:
        return r101;
    }

    private static final int actualSize(byte[] r100, int r101) {
        int r102 = r100.length;
        if (r101 > 0) goto L5;
        return r102;
    L5:
        return Math.min(r101, r102);
    }

    private static final byte[] toActualBytes(byte[] r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return null;
    L11:
        int r103 = actualSize(r100, r101);
        if (r103 != r100.length) goto L15;
        return r100;
    L15:
        return Arrays.copyOf(r100, r103);
    L8:
        r102 = false;
        goto L9
    }
}
