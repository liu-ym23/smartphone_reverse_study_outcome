package com.mammon.speechaudiosdk.kmp.param.va;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.core.event.a;
import com.mammon.speechaudiosdk.kmp.type.va.SpeechVoiceAssistantSessionRequestType;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\bi\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\b\b\u0002\u0010#\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\u000e\u0012\b\b\u0002\u0010&\u001a\u00020\u000e\u0012\b\b\u0002\u0010'\u001a\u00020\u000e\u0012\b\b\u0002\u0010(\u001a\u00020\t\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010+\u001a\u00020\t\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010-\u001a\u00020\t\u0012\b\b\u0002\u0010.\u001a\u00020\t\u0012\b\b\u0002\u0010/\u001a\u00020\u000e\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00101\u001a\u00020\t¢\u0006\u0004\b2\u00103J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010h\u001a\u00020\tHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u000eHÆ\u0003J\t\u0010m\u001a\u00020\u000eHÆ\u0003J\t\u0010n\u001a\u00020\u000eHÆ\u0003J\t\u0010o\u001a\u00020\u000eHÆ\u0003J\t\u0010p\u001a\u00020\u000eHÆ\u0003J\t\u0010q\u001a\u00020\tHÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010t\u001a\u00020\tHÆ\u0003J\t\u0010u\u001a\u00020\tHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010y\u001a\u00020\tHÆ\u0003J\t\u0010z\u001a\u00020\u001dHÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010~\u001a\u00020\tHÆ\u0003J\t\u0010\u007f\u001a\u00020\tHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\tHÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010*HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\tHÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\tHÆ\u0003JÒ\u0003\u0010\u008e\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\t2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\t2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\u000e2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00101\u001a\u00020\tHÆ\u0001J\u0015\u0010\u008f\u0001\u001a\u00020\u000e2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0091\u0001\u001a\u00020\tHÖ\u0001J\n\u0010\u0092\u0001\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00105R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u00105R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010@R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010@R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010@R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010@R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bE\u0010;R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00105R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00105R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bH\u0010;R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bI\u0010;R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u00105R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00105R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00105R\u0011\u0010\u001b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bM\u0010;R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u00105R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u00105R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00105R\u0011\u0010!\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bS\u0010;R\u0011\u0010\"\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bT\u0010;R\u0011\u0010#\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bU\u0010;R\u0011\u0010$\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bV\u0010;R\u0011\u0010%\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bW\u0010@R\u0011\u0010&\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bX\u0010@R\u0011\u0010'\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010@R\u0011\u0010(\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010;R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0011\u0010+\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b]\u0010;R\u0013\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u00105R\u0011\u0010-\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b_\u0010;R\u0011\u0010.\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b`\u0010;R\u0011\u0010/\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010@R\u0013\u00100\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u00105R\u0011\u00101\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bc\u0010;¨\u0006\u0093\u0001"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionStartSessionParam;", "", DBDefinition.TASK_ID, "", "sessionId", "conversationId", "requestType", "Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionRequestType;", "business", "", "chat", "trace", "extra", "enableAudioInput", "", "enableUploadAudio", "enableTextReading", "enablePlayer", "enableRealtimeVoiceCall", "interruptType", a.VALUE_QUESTION, "reconnectQuestionId", "reconnectStatus", "triggerType", "updateUIContextPayload", "updatePersonalContextPayload", "uploadInfoPayload", "playerStatus", ITTVideoEngineEventSource.KEY_VOLUME, "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "imageId", InteractConst.WAKEUP_WAKEUP_ID, "imageType", "intentMode", "imageStatus", "highQuality", "enableTouch", "enableBurst", "enableAudioRecorder", "audioRecordChannels", "imgData", "", "imgDataLen", "updateAudioConfigPayload", "multimodalStatus", "vuiQueryMode", "enableOneShot", "wakeupWord", "wakeupAudioDurationMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionRequestType;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIZZZI[BILjava/lang/String;IIZLjava/lang/String;I)V", "getTaskId", "()Ljava/lang/String;", "getSessionId", "getConversationId", "getRequestType", "()Lcom/mammon/speechaudiosdk/kmp/type/va/SpeechVoiceAssistantSessionRequestType;", "getBusiness", "()I", "getChat", "getTrace", "getExtra", "getEnableAudioInput", "()Z", "getEnableUploadAudio", "getEnableTextReading", "getEnablePlayer", "getEnableRealtimeVoiceCall", "getInterruptType", "getQuestion", "getReconnectQuestionId", "getReconnectStatus", "getTriggerType", "getUpdateUIContextPayload", "getUpdatePersonalContextPayload", "getUploadInfoPayload", "getPlayerStatus", "getVolume", "()F", "getSceneType", "getImageId", "getWakeupId", "getImageType", "getIntentMode", "getImageStatus", "getHighQuality", "getEnableTouch", "getEnableBurst", "getEnableAudioRecorder", "getAudioRecordChannels", "getImgData", "()[B", "getImgDataLen", "getUpdateAudioConfigPayload", "getMultimodalStatus", "getVuiQueryMode", "getEnableOneShot", "getWakeupWord", "getWakeupAudioDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "copy", "equals", "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionStartSessionParam {
    private final int audioRecordChannels;
    private final int business;
    private final String chat;
    private final String conversationId;
    private final boolean enableAudioInput;
    private final boolean enableAudioRecorder;
    private final boolean enableBurst;
    private final boolean enableOneShot;
    private final boolean enablePlayer;
    private final boolean enableRealtimeVoiceCall;
    private final boolean enableTextReading;
    private final boolean enableTouch;
    private final boolean enableUploadAudio;
    private final String extra;
    private final int highQuality;
    private final String imageId;
    private final int imageStatus;
    private final int imageType;
    private final byte[] imgData;
    private final int imgDataLen;
    private final int intentMode;
    private final int interruptType;
    private final int multimodalStatus;
    private final int playerStatus;
    private final String question;
    private final String reconnectQuestionId;
    private final int reconnectStatus;
    private final SpeechVoiceAssistantSessionRequestType requestType;
    private final String sceneType;
    private final String sessionId;
    private final String taskId;
    private final String trace;
    private final int triggerType;
    private final String updateAudioConfigPayload;
    private final String updatePersonalContextPayload;
    private final String updateUIContextPayload;
    private final String uploadInfoPayload;
    private final float volume;
    private final int vuiQueryMode;
    private final int wakeupAudioDurationMs;
    private final String wakeupId;
    private final String wakeupWord;

    public SpeechVoiceAssistantSessionStartSessionParam() {
        this(null, null, null, null, 0, null, null, null, false, false, false, false, false, 0, null, null, 0, 0, null, null, null, 0, 0.0f, null, null, null, 0, 0, 0, 0, false, false, false, 0, null, 0, null, 0, 0, false, null, 0, -1, 1023, null);
    }

    public static /* synthetic */ SpeechVoiceAssistantSessionStartSessionParam copy$default(SpeechVoiceAssistantSessionStartSessionParam r110, String r111, String r112, String r210, SpeechVoiceAssistantSessionRequestType r211, int r212, String r213, String r214, String r215, boolean r216, boolean r217, boolean r218, boolean r219, boolean r310, int r311, String r312, String r313, int r314, int r315, String r316, String r317, String r318, int r319, float r410, String r411, String r412, String r413, int r414, int r415, int r416, int r417, boolean r418, boolean r419, boolean r510, int r511, byte[] r512, int r513, String r514, int r515, int r516, boolean r517, String r518, int r519, int r610, int r611, Object r612) {
        if ((r610 & 1) == 0) goto L5;
        String r100 = r110.taskId;
    L7:
        if ((r610 & 2) == 0) goto L9;
        String r101 = r110.sessionId;
    L11:
        if ((r610 & 4) == 0) goto L13;
        String r102 = r110.conversationId;
    L15:
        if ((r610 & 8) == 0) goto L17;
        SpeechVoiceAssistantSessionRequestType r103 = r110.requestType;
    L19:
        if ((r610 & 16) == 0) goto L21;
        int r104 = r110.business;
    L23:
        if ((r610 & 32) == 0) goto L25;
        String r105 = r110.chat;
    L27:
        if ((r610 & 64) == 0) goto L29;
        String r106 = r110.trace;
    L31:
        if ((r610 & 128) == 0) goto L33;
        String r113 = r110.extra;
    L35:
        if ((r610 & 256) == 0) goto L37;
        boolean r114 = r110.enableAudioInput;
    L39:
        if ((r610 & 512) == 0) goto L41;
        boolean r115 = r110.enableUploadAudio;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        boolean r116 = r110.enableTextReading;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        boolean r117 = r110.enablePlayer;
    L51:
        if ((r610 & 4096) == 0) goto L53;
        boolean r118 = r110.enableRealtimeVoiceCall;
    L54:
        boolean r320 = r118;
        if ((r610 & 8192) == 0) goto L57;
        int r119 = r110.interruptType;
    L58:
        int r321 = r119;
        if ((r610 & 16384) == 0) goto L61;
        String r120 = r110.question;
    L62:
        String r322 = r120;
        if ((r610 & 32768) == 0) goto L65;
        String r121 = r110.reconnectQuestionId;
    L66:
        String r323 = r121;
        if ((r610 & 65536) == 0) goto L69;
        int r122 = r110.reconnectStatus;
    L70:
        int r324 = r122;
        if ((r610 & 131072) == 0) goto L73;
        int r123 = r110.triggerType;
    L74:
        int r325 = r123;
        if ((r610 & 262144) == 0) goto L77;
        String r124 = r110.updateUIContextPayload;
    L78:
        String r326 = r124;
        if ((r610 & 524288) == 0) goto L81;
        String r125 = r110.updatePersonalContextPayload;
    L82:
        String r327 = r125;
        if ((r610 & 1048576) == 0) goto L85;
        String r126 = r110.uploadInfoPayload;
    L86:
        String r328 = r126;
        if ((r610 & 2097152) == 0) goto L89;
        int r127 = r110.playerStatus;
    L90:
        int r329 = r127;
        if ((r610 & 4194304) == 0) goto L93;
        float r128 = r110.volume;
    L94:
        float r420 = r128;
        if ((r610 & 8388608) == 0) goto L97;
        String r129 = r110.sceneType;
    L98:
        String r421 = r129;
        if ((r610 & 16777216) == 0) goto L101;
        String r130 = r110.imageId;
    L102:
        String r422 = r130;
        if ((r610 & 33554432) == 0) goto L105;
        String r131 = r110.wakeupId;
    L106:
        String r423 = r131;
        if ((r610 & 67108864) == 0) goto L109;
        int r132 = r110.imageType;
    L110:
        int r424 = r132;
        if ((r610 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r133 = r110.intentMode;
    L114:
        int r425 = r133;
        if ((r610 & 268435456) == 0) goto L117;
        int r134 = r110.imageStatus;
    L118:
        int r426 = r134;
        if ((r610 & 536870912) == 0) goto L121;
        int r135 = r110.highQuality;
    L122:
        int r427 = r135;
        if ((r610 & 1073741824) == 0) goto L125;
        boolean r136 = r110.enableTouch;
    L127:
        if ((r610 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r107 = r110.enableBurst;
    L130:
        boolean r428 = r107;
        if ((r611 & 1) == 0) goto L133;
        boolean r108 = r110.enableAudioRecorder;
    L134:
        boolean r520 = r108;
        if ((r611 & 2) == 0) goto L137;
        int r109 = r110.audioRecordChannels;
    L138:
        int r521 = r109;
        if ((r611 & 4) == 0) goto L141;
        byte[] r137 = r110.imgData;
    L142:
        byte[] r522 = r137;
        if ((r611 & 8) == 0) goto L145;
        int r138 = r110.imgDataLen;
    L146:
        int r523 = r138;
        if ((r611 & 16) == 0) goto L149;
        String r139 = r110.updateAudioConfigPayload;
    L150:
        String r524 = r139;
        if ((r611 & 32) == 0) goto L153;
        int r140 = r110.multimodalStatus;
    L154:
        int r525 = r140;
        if ((r611 & 64) == 0) goto L157;
        int r141 = r110.vuiQueryMode;
    L158:
        int r526 = r141;
        if ((r611 & 128) == 0) goto L161;
        boolean r142 = r110.enableOneShot;
    L162:
        boolean r527 = r142;
        if ((r611 & 256) == 0) goto L165;
        String r143 = r110.wakeupWord;
    L167:
        if ((r611 & 512) == 0) goto L169;
        int r144 = r110.wakeupAudioDurationMs;
    L171:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r420, r421, r422, r423, r424, r425, r426, r427, r136, r428, r520, r521, r522, r523, r524, r525, r526, r527, r143, r144);
    L169:
        r144 = r519;
        goto L171
    L165:
        r143 = r518;
        goto L167
    L161:
        r142 = r517;
        goto L162
    L157:
        r141 = r516;
        goto L158
    L153:
        r140 = r515;
        goto L154
    L149:
        r139 = r514;
        goto L150
    L145:
        r138 = r513;
        goto L146
    L141:
        r137 = r512;
        goto L142
    L137:
        r109 = r511;
        goto L138
    L133:
        r108 = r510;
        goto L134
    L129:
        r107 = r419;
        goto L130
    L125:
        r136 = r418;
        goto L127
    L121:
        r135 = r417;
        goto L122
    L117:
        r134 = r416;
        goto L118
    L113:
        r133 = r415;
        goto L114
    L109:
        r132 = r414;
        goto L110
    L105:
        r131 = r413;
        goto L106
    L101:
        r130 = r412;
        goto L102
    L97:
        r129 = r411;
        goto L98
    L93:
        r128 = r410;
        goto L94
    L89:
        r127 = r319;
        goto L90
    L85:
        r126 = r318;
        goto L86
    L81:
        r125 = r317;
        goto L82
    L77:
        r124 = r316;
        goto L78
    L73:
        r123 = r315;
        goto L74
    L69:
        r122 = r314;
        goto L70
    L65:
        r121 = r313;
        goto L66
    L61:
        r120 = r312;
        goto L62
    L57:
        r119 = r311;
        goto L58
    L53:
        r118 = r310;
        goto L54
    L49:
        r117 = r219;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final boolean component10() {
        return this.enableUploadAudio;
    }

    public final boolean component11() {
        return this.enableTextReading;
    }

    public final boolean component12() {
        return this.enablePlayer;
    }

    public final boolean component13() {
        return this.enableRealtimeVoiceCall;
    }

    public final int component14() {
        return this.interruptType;
    }

    public final String component15() {
        return this.question;
    }

    public final String component16() {
        return this.reconnectQuestionId;
    }

    public final int component17() {
        return this.reconnectStatus;
    }

    public final int component18() {
        return this.triggerType;
    }

    public final String component19() {
        return this.updateUIContextPayload;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component20() {
        return this.updatePersonalContextPayload;
    }

    public final String component21() {
        return this.uploadInfoPayload;
    }

    public final int component22() {
        return this.playerStatus;
    }

    public final float component23() {
        return this.volume;
    }

    public final String component24() {
        return this.sceneType;
    }

    public final String component25() {
        return this.imageId;
    }

    public final String component26() {
        return this.wakeupId;
    }

    public final int component27() {
        return this.imageType;
    }

    public final int component28() {
        return this.intentMode;
    }

    public final int component29() {
        return this.imageStatus;
    }

    public final String component3() {
        return this.conversationId;
    }

    public final int component30() {
        return this.highQuality;
    }

    public final boolean component31() {
        return this.enableTouch;
    }

    public final boolean component32() {
        return this.enableBurst;
    }

    public final boolean component33() {
        return this.enableAudioRecorder;
    }

    public final int component34() {
        return this.audioRecordChannels;
    }

    public final byte[] component35() {
        return this.imgData;
    }

    public final int component36() {
        return this.imgDataLen;
    }

    public final String component37() {
        return this.updateAudioConfigPayload;
    }

    public final int component38() {
        return this.multimodalStatus;
    }

    public final int component39() {
        return this.vuiQueryMode;
    }

    public final SpeechVoiceAssistantSessionRequestType component4() {
        return this.requestType;
    }

    public final boolean component40() {
        return this.enableOneShot;
    }

    public final String component41() {
        return this.wakeupWord;
    }

    public final int component42() {
        return this.wakeupAudioDurationMs;
    }

    public final int component5() {
        return this.business;
    }

    public final String component6() {
        return this.chat;
    }

    public final String component7() {
        return this.trace;
    }

    public final String component8() {
        return this.extra;
    }

    public final boolean component9() {
        return this.enableAudioInput;
    }

    public final SpeechVoiceAssistantSessionStartSessionParam copy(String r410, String r411, String r412, SpeechVoiceAssistantSessionRequestType r413, int r414, String r510, String r511, String r512, boolean r513, boolean r514, boolean r515, boolean r516, boolean r517, int r518, String r519, String r610, int r611, int r612, String r613, String r614, String r615, int r616, float r617, String r618, String r619, String r710, int r711, int r712, int r713, int r714, boolean r715, boolean r716, boolean r717, int r718, byte[] r719, int r810, String r811, int r812, int r813, boolean r814, String r815, int r816) {
        return new SpeechVoiceAssistantSessionStartSessionParam(r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechVoiceAssistantSessionStartSessionParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionStartSessionParam r101 = (SpeechVoiceAssistantSessionStartSessionParam) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L18;
        return false;
    L18:
        if (this.requestType == r101.requestType) goto L21;
        return false;
    L21:
        if (this.business == r101.business) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.chat, r101.chat) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.trace, r101.trace) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L33;
        return false;
    L33:
        if (this.enableAudioInput == r101.enableAudioInput) goto L36;
        return false;
    L36:
        if (this.enableUploadAudio == r101.enableUploadAudio) goto L39;
        return false;
    L39:
        if (this.enableTextReading == r101.enableTextReading) goto L42;
        return false;
    L42:
        if (this.enablePlayer == r101.enablePlayer) goto L45;
        return false;
    L45:
        if (this.enableRealtimeVoiceCall == r101.enableRealtimeVoiceCall) goto L48;
        return false;
    L48:
        if (this.interruptType == r101.interruptType) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.question, r101.question) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.reconnectQuestionId, r101.reconnectQuestionId) == true) goto L57;
        return false;
    L57:
        if (this.reconnectStatus == r101.reconnectStatus) goto L60;
        return false;
    L60:
        if (this.triggerType == r101.triggerType) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.updateUIContextPayload, r101.updateUIContextPayload) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.updatePersonalContextPayload, r101.updatePersonalContextPayload) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.uploadInfoPayload, r101.uploadInfoPayload) == true) goto L72;
        return false;
    L72:
        if (this.playerStatus == r101.playerStatus) goto L75;
        return false;
    L75:
        if (Float.compare(this.volume, r101.volume) == 0) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.sceneType, r101.sceneType) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.imageId, r101.imageId) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.wakeupId, r101.wakeupId) == true) goto L87;
        return false;
    L87:
        if (this.imageType == r101.imageType) goto L90;
        return false;
    L90:
        if (this.intentMode == r101.intentMode) goto L93;
        return false;
    L93:
        if (this.imageStatus == r101.imageStatus) goto L96;
        return false;
    L96:
        if (this.highQuality == r101.highQuality) goto L99;
        return false;
    L99:
        if (this.enableTouch == r101.enableTouch) goto L102;
        return false;
    L102:
        if (this.enableBurst == r101.enableBurst) goto L105;
        return false;
    L105:
        if (this.enableAudioRecorder == r101.enableAudioRecorder) goto L108;
        return false;
    L108:
        if (this.audioRecordChannels == r101.audioRecordChannels) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.imgData, r101.imgData) == true) goto L114;
        return false;
    L114:
        if (this.imgDataLen == r101.imgDataLen) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.updateAudioConfigPayload, r101.updateAudioConfigPayload) == true) goto L120;
        return false;
    L120:
        if (this.multimodalStatus == r101.multimodalStatus) goto L123;
        return false;
    L123:
        if (this.vuiQueryMode == r101.vuiQueryMode) goto L126;
        return false;
    L126:
        if (this.enableOneShot == r101.enableOneShot) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.wakeupWord, r101.wakeupWord) == true) goto L132;
        return false;
    L132:
        if (this.wakeupAudioDurationMs == r101.wakeupAudioDurationMs) goto L134;
        return false;
    L134:
        return true;
    }

    public int hashCode() {
        String r100 = this.taskId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.sessionId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.conversationId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        SpeechVoiceAssistantSessionRequestType r110 = this.requestType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.business) * 31;
        String r113 = this.chat;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.trace;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.extra;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        int r122 = 1231;
        if (this.enableAudioInput == false) goto L33;
        int r123 = 1231;
    L34:
        int r124 = (r121 + r123) * 31;
        if (this.enableUploadAudio == false) goto L37;
        int r125 = 1231;
    L38:
        int r126 = (r124 + r125) * 31;
        if (this.enableTextReading == false) goto L41;
        int r127 = 1231;
    L42:
        int r128 = (r126 + r127) * 31;
        if (this.enablePlayer == false) goto L45;
        int r129 = 1231;
    L46:
        int r130 = (r128 + r129) * 31;
        if (this.enableRealtimeVoiceCall == false) goto L49;
        int r131 = 1231;
    L50:
        int r132 = (((r130 + r131) * 31) + this.interruptType) * 31;
        String r133 = this.question;
        if (r133 != null) goto L53;
        int r134 = 0;
    L54:
        int r135 = (r132 + r134) * 31;
        String r136 = this.reconnectQuestionId;
        if (r136 != null) goto L57;
        int r137 = 0;
    L58:
        int r138 = (((((r135 + r137) * 31) + this.reconnectStatus) * 31) + this.triggerType) * 31;
        String r139 = this.updateUIContextPayload;
        if (r139 != null) goto L61;
        int r140 = 0;
    L62:
        int r141 = (r138 + r140) * 31;
        String r142 = this.updatePersonalContextPayload;
        if (r142 != null) goto L65;
        int r143 = 0;
    L66:
        int r144 = (r141 + r143) * 31;
        String r145 = this.uploadInfoPayload;
        if (r145 != null) goto L69;
        int r146 = 0;
    L70:
        int r147 = (((((r144 + r146) * 31) + this.playerStatus) * 31) + Float.floatToIntBits(this.volume)) * 31;
        String r148 = this.sceneType;
        if (r148 != null) goto L73;
        int r149 = 0;
    L74:
        int r150 = (r147 + r149) * 31;
        String r151 = this.imageId;
        if (r151 != null) goto L77;
        int r152 = 0;
    L78:
        int r153 = (r150 + r152) * 31;
        String r154 = this.wakeupId;
        if (r154 != null) goto L81;
        int r155 = 0;
    L82:
        int r156 = (((((((((r153 + r155) * 31) + this.imageType) * 31) + this.intentMode) * 31) + this.imageStatus) * 31) + this.highQuality) * 31;
        if (this.enableTouch == false) goto L85;
        int r157 = 1231;
    L86:
        int r158 = (r156 + r157) * 31;
        if (this.enableBurst == false) goto L89;
        int r159 = 1231;
    L90:
        int r160 = (r158 + r159) * 31;
        if (this.enableAudioRecorder == false) goto L93;
        int r161 = 1231;
    L94:
        int r162 = (((r160 + r161) * 31) + this.audioRecordChannels) * 31;
        byte[] r163 = this.imgData;
        if (r163 != null) goto L97;
        int r164 = 0;
    L98:
        int r165 = (((r162 + r164) * 31) + this.imgDataLen) * 31;
        String r166 = this.updateAudioConfigPayload;
        if (r166 != null) goto L101;
        int r167 = 0;
    L102:
        int r168 = (((((r165 + r167) * 31) + this.multimodalStatus) * 31) + this.vuiQueryMode) * 31;
        if (this.enableOneShot == true) goto L106;
        r122 = 1237;
    L106:
        int r169 = (r168 + r122) * 31;
        String r170 = this.wakeupWord;
        if (r170 == null) goto L111;
        r101 = r170.hashCode();
    L111:
        return ((r169 + r101) * 31) + this.wakeupAudioDurationMs;
    L101:
        r167 = r166.hashCode();
        goto L102
    L97:
        r164 = Arrays.hashCode(r163);
        goto L98
    L93:
        r161 = 1237;
        goto L94
    L89:
        r159 = 1237;
        goto L90
    L85:
        r157 = 1237;
        goto L86
    L81:
        r155 = r154.hashCode();
        goto L82
    L77:
        r152 = r151.hashCode();
        goto L78
    L73:
        r149 = r148.hashCode();
        goto L74
    L69:
        r146 = r145.hashCode();
        goto L70
    L65:
        r143 = r142.hashCode();
        goto L66
    L61:
        r140 = r139.hashCode();
        goto L62
    L57:
        r137 = r136.hashCode();
        goto L58
    L53:
        r134 = r133.hashCode();
        goto L54
    L49:
        r131 = 1237;
        goto L50
    L45:
        r129 = 1237;
        goto L46
    L41:
        r127 = 1237;
        goto L42
    L37:
        r125 = 1237;
        goto L38
    L33:
        r123 = 1237;
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechVoiceAssistantSessionStartSessionParam(taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", conversationId=" + this.conversationId + ", requestType=" + this.requestType + ", business=" + this.business + ", chat=" + this.chat + ", trace=" + this.trace + ", extra=" + this.extra + ", enableAudioInput=" + this.enableAudioInput + ", enableUploadAudio=" + this.enableUploadAudio + ", enableTextReading=" + this.enableTextReading + ", enablePlayer=" + this.enablePlayer + ", enableRealtimeVoiceCall=" + this.enableRealtimeVoiceCall + ", interruptType=" + this.interruptType + ", question=" + this.question + ", reconnectQuestionId=" + this.reconnectQuestionId + ", reconnectStatus=" + this.reconnectStatus + ", triggerType=" + this.triggerType + ", updateUIContextPayload=" + this.updateUIContextPayload + ", updatePersonalContextPayload=" + this.updatePersonalContextPayload + ", uploadInfoPayload=" + this.uploadInfoPayload + ", playerStatus=" + this.playerStatus + ", volume=" + this.volume + ", sceneType=" + this.sceneType + ", imageId=" + this.imageId + ", wakeupId=" + this.wakeupId + ", imageType=" + this.imageType + ", intentMode=" + this.intentMode + ", imageStatus=" + this.imageStatus + ", highQuality=" + this.highQuality + ", enableTouch=" + this.enableTouch + ", enableBurst=" + this.enableBurst + ", enableAudioRecorder=" + this.enableAudioRecorder + ", audioRecordChannels=" + this.audioRecordChannels + ", imgData=" + Arrays.toString(this.imgData) + ", imgDataLen=" + this.imgDataLen + ", updateAudioConfigPayload=" + this.updateAudioConfigPayload + ", multimodalStatus=" + this.multimodalStatus + ", vuiQueryMode=" + this.vuiQueryMode + ", enableOneShot=" + this.enableOneShot + ", wakeupWord=" + this.wakeupWord + ", wakeupAudioDurationMs=" + this.wakeupAudioDurationMs + ')';
    }

    public final int getAudioRecordChannels() {
        return this.audioRecordChannels;
    }

    public final int getBusiness() {
        return this.business;
    }

    public final String getChat() {
        return this.chat;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final boolean getEnableAudioInput() {
        return this.enableAudioInput;
    }

    public final boolean getEnableAudioRecorder() {
        return this.enableAudioRecorder;
    }

    public final boolean getEnableBurst() {
        return this.enableBurst;
    }

    public final boolean getEnableOneShot() {
        return this.enableOneShot;
    }

    public final boolean getEnablePlayer() {
        return this.enablePlayer;
    }

    public final boolean getEnableRealtimeVoiceCall() {
        return this.enableRealtimeVoiceCall;
    }

    public final boolean getEnableTextReading() {
        return this.enableTextReading;
    }

    public final boolean getEnableTouch() {
        return this.enableTouch;
    }

    public final boolean getEnableUploadAudio() {
        return this.enableUploadAudio;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final int getHighQuality() {
        return this.highQuality;
    }

    public final String getImageId() {
        return this.imageId;
    }

    public final int getImageStatus() {
        return this.imageStatus;
    }

    public final int getImageType() {
        return this.imageType;
    }

    public final byte[] getImgData() {
        return this.imgData;
    }

    public final int getImgDataLen() {
        return this.imgDataLen;
    }

    public final int getIntentMode() {
        return this.intentMode;
    }

    public final int getInterruptType() {
        return this.interruptType;
    }

    public final int getMultimodalStatus() {
        return this.multimodalStatus;
    }

    public final int getPlayerStatus() {
        return this.playerStatus;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final String getReconnectQuestionId() {
        return this.reconnectQuestionId;
    }

    public final int getReconnectStatus() {
        return this.reconnectStatus;
    }

    public final SpeechVoiceAssistantSessionRequestType getRequestType() {
        return this.requestType;
    }

    public final String getSceneType() {
        return this.sceneType;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTrace() {
        return this.trace;
    }

    public final int getTriggerType() {
        return this.triggerType;
    }

    public final String getUpdateAudioConfigPayload() {
        return this.updateAudioConfigPayload;
    }

    public final String getUpdatePersonalContextPayload() {
        return this.updatePersonalContextPayload;
    }

    public final String getUpdateUIContextPayload() {
        return this.updateUIContextPayload;
    }

    public final String getUploadInfoPayload() {
        return this.uploadInfoPayload;
    }

    public final float getVolume() {
        return this.volume;
    }

    public final int getVuiQueryMode() {
        return this.vuiQueryMode;
    }

    public final int getWakeupAudioDurationMs() {
        return this.wakeupAudioDurationMs;
    }

    public final String getWakeupId() {
        return this.wakeupId;
    }

    public final String getWakeupWord() {
        return this.wakeupWord;
    }

    public SpeechVoiceAssistantSessionStartSessionParam(String r100, String r101, String r102, SpeechVoiceAssistantSessionRequestType r103, int r104, String r105, String r106, String r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, int r116, String r117, String r118, int r119, int r210, String r211, String r212, String r213, int r214, float r215, String r216, String r217, String r218, int r219, int r310, int r311, int r312, boolean r313, boolean r314, boolean r315, int r316, byte[] r317, int r318, String r319, int r410, int r411, boolean r412, String r413, int r414) {
        this.taskId = r100;
        this.sessionId = r101;
        this.conversationId = r102;
        this.requestType = r103;
        this.business = r104;
        this.chat = r105;
        this.trace = r106;
        this.extra = r110;
        this.enableAudioInput = r111;
        this.enableUploadAudio = r112;
        this.enableTextReading = r113;
        this.enablePlayer = r114;
        this.enableRealtimeVoiceCall = r115;
        this.interruptType = r116;
        this.question = r117;
        this.reconnectQuestionId = r118;
        this.reconnectStatus = r119;
        this.triggerType = r210;
        this.updateUIContextPayload = r211;
        this.updatePersonalContextPayload = r212;
        this.uploadInfoPayload = r213;
        this.playerStatus = r214;
        this.volume = r215;
        this.sceneType = r216;
        this.imageId = r217;
        this.wakeupId = r218;
        this.imageType = r219;
        this.intentMode = r310;
        this.imageStatus = r311;
        this.highQuality = r312;
        this.enableTouch = r313;
        this.enableBurst = r314;
        this.enableAudioRecorder = r315;
        this.audioRecordChannels = r316;
        this.imgData = r317;
        this.imgDataLen = r318;
        this.updateAudioConfigPayload = r319;
        this.multimodalStatus = r410;
        this.vuiQueryMode = r411;
        this.enableOneShot = r412;
        this.wakeupWord = r413;
        this.wakeupAudioDurationMs = r414;
    }

    public /* synthetic */ SpeechVoiceAssistantSessionStartSessionParam(String r410, String r411, String r412, SpeechVoiceAssistantSessionRequestType r413, int r414, String r415, String r416, String r417, boolean r510, boolean r511, boolean r512, boolean r513, boolean r514, int r515, String r516, String r517, int r518, int r519, String r610, String r611, String r612, int r613, float r614, String r615, String r616, String r617, int r618, int r619, int r710, int r711, boolean r712, boolean r713, boolean r714, int r715, byte[] r716, int r717, String r718, int r719, int r810, boolean r811, String r812, int r813, int r814, int r815, DefaultConstructorMarker r816) {
        if ((r814 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r814 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r814 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r814 & 8) == 0) goto L17;
        SpeechVoiceAssistantSessionRequestType r103 = null;
    L19:
        if ((r814 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r814 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r814 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r814 & 128) == 0) goto L33;
        String r111 = null;
    L35:
        if ((r814 & 256) == 0) goto L37;
        boolean r112 = false;
    L39:
        if ((r814 & 512) == 0) goto L41;
        boolean r113 = false;
    L43:
        if ((r814 & 1024) == 0) goto L45;
        boolean r114 = false;
    L47:
        if ((r814 & 2048) == 0) goto L49;
        boolean r115 = false;
    L51:
        if ((r814 & 4096) == 0) goto L53;
        boolean r106 = false;
    L55:
        if ((r814 & 8192) == 0) goto L57;
        int r107 = 0;
    L58:
        int r116 = r107;
        if ((r814 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r814 & 32768) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r814 & 65536) == 0) goto L69;
        int r118 = 0;
    L71:
        if ((r814 & 131072) == 0) goto L73;
        int r119 = 0;
    L75:
        if ((r814 & 262144) == 0) goto L77;
        String r210 = null;
    L79:
        if ((r814 & 524288) == 0) goto L81;
        String r211 = null;
    L83:
        if ((r814 & 1048576) == 0) goto L85;
        String r212 = null;
    L87:
        if ((r814 & 2097152) == 0) goto L89;
        int r213 = 0;
    L91:
        if ((r814 & 4194304) == 0) goto L93;
        float r214 = 0.0f;
    L95:
        if ((r814 & 8388608) == 0) goto L97;
        String r215 = null;
    L99:
        if ((r814 & 16777216) == 0) goto L101;
        String r216 = null;
    L103:
        if ((r814 & 33554432) == 0) goto L105;
        String r217 = null;
    L107:
        if ((r814 & 67108864) == 0) goto L109;
        int r218 = 0;
    L111:
        if ((r814 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r219 = 0;
    L115:
        if ((r814 & 268435456) == 0) goto L117;
        int r310 = 0;
    L119:
        if ((r814 & 536870912) == 0) goto L121;
        int r311 = 0;
    L123:
        if ((r814 & 1073741824) == 0) goto L125;
        boolean r312 = false;
    L127:
        if ((r814 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r109 = false;
    L131:
        if ((r815 & 1) == 0) goto L133;
        boolean r313 = false;
    L135:
        if ((r815 & 2) == 0) goto L137;
        int r314 = 0;
    L139:
        if ((r815 & 4) == 0) goto L141;
        byte[] r315 = null;
    L143:
        if ((r815 & 8) == 0) goto L145;
        int r316 = 0;
    L147:
        if ((r815 & 16) == 0) goto L149;
        String r317 = null;
    L151:
        if ((r815 & 32) == 0) goto L153;
        int r318 = 0;
    L155:
        if ((r815 & 64) == 0) goto L157;
        int r319 = 0;
    L158:
        boolean r817 = r109;
        if ((r815 & 128) == 0) goto L161;
        boolean r120 = false;
    L162:
        boolean r418 = r120;
        if ((r815 & 256) == 0) goto L165;
        String r121 = null;
    L167:
        if ((r815 & 512) == 0) goto L169;
        int r122 = 0;
    L170:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r116, r108, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r817, r313, r314, r315, r316, r317, r318, r319, r418, r121, r122);
        return;
    L169:
        r122 = r813;
        goto L170
    L165:
        r121 = r812;
        goto L167
    L161:
        r120 = r811;
        goto L162
    L157:
        r319 = r810;
        goto L158
    L153:
        r318 = r719;
        goto L155
    L149:
        r317 = r718;
        goto L151
    L145:
        r316 = r717;
        goto L147
    L141:
        r315 = r716;
        goto L143
    L137:
        r314 = r715;
        goto L139
    L133:
        r313 = r714;
        goto L135
    L129:
        r109 = r713;
        goto L131
    L125:
        r312 = r712;
        goto L127
    L121:
        r311 = r711;
        goto L123
    L117:
        r310 = r710;
        goto L119
    L113:
        r219 = r619;
        goto L115
    L109:
        r218 = r618;
        goto L111
    L105:
        r217 = r617;
        goto L107
    L101:
        r216 = r616;
        goto L103
    L97:
        r215 = r615;
        goto L99
    L93:
        r214 = r614;
        goto L95
    L89:
        r213 = r613;
        goto L91
    L85:
        r212 = r612;
        goto L87
    L81:
        r211 = r611;
        goto L83
    L77:
        r210 = r610;
        goto L79
    L73:
        r119 = r519;
        goto L75
    L69:
        r118 = r518;
        goto L71
    L65:
        r117 = r517;
        goto L67
    L61:
        r108 = r516;
        goto L63
    L57:
        r107 = r515;
        goto L58
    L53:
        r106 = r514;
        goto L55
    L49:
        r115 = r513;
        goto L51
    L45:
        r114 = r512;
        goto L47
    L41:
        r113 = r511;
        goto L43
    L37:
        r112 = r510;
        goto L39
    L33:
        r111 = r417;
        goto L35
    L29:
        r110 = r416;
        goto L31
    L25:
        r105 = r415;
        goto L27
    L21:
        r104 = r414;
        goto L23
    L17:
        r103 = r413;
        goto L19
    L13:
        r102 = r412;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }
}
