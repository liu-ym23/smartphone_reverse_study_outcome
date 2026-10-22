package com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk;

import android.util.SparseArray;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\bK\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bL¨\u0006M"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/audiosdk/LiveWrappedSAMICoreCallBackEventType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "TTS_Started", "TTS_GetResulted", "TTS_Finished", "TTS_Failed", "TTS_WebSocketStateChanged", "ASR_Started", "ASR_GetResulted", "ASR_Finished", "ASR_Failed", "ASR_WebSocketStateChanged", "VC_Started", "VC_GetResulted", "VC_Finished", "VC_Failed", "VC_WebSocketStateChanged", "VC_Player_Finished", "TTS_Player_Finished", "SA_EngineStart", "SA_EngineStop", "SA_EngineError", "SA_WakeupResult", "SA_SidEnrollResult", "SA_SidLoadResult", "SA_PreWakeupResult", "SA_WakeupTimeout", "SA_SidVerifyFailResult", "SA_WakeupEnd", "TaskStarted", "TaskFinished", "TaskFailed", "GetResulted", "SessionStarted", "SessionFinished", "SessionCanceled", "SessionFailed", "TaskResponse", "ASRResponse", "ASREnded", "ChatResponse", "ChatEnded", "TTSSentenceStart", "TTSResponse", "TTSSentenceEnd", "TTSEnded", "WebSocketStateChanged", "CallDisConnectedWithRetry", "RequestRetried", "ASRInfo", "BSResponse", "BotTriggered", "AudioUploadEnded", "SpeechStarted", "SpeechEnded", "PlayerStarted", "PlayerStopped", "SessionConfResponse", "PostBackAudioConfig", "VadStarted", "VadEnded", "PVadStarted", "PVadEnded", "SpeakerSimilarity", "VuiReset", "VAD_TimeOut", "WakeUp_Succeed", "WakeUp_Failed", "AIS_Data", "AIS_Ability", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedSAMICoreCallBackEventType extends Enum<LiveWrappedSAMICoreCallBackEventType> {
    public static final LiveWrappedSAMICoreCallBackEventType AIS_Ability = null;
    public static final LiveWrappedSAMICoreCallBackEventType AIS_Data = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASREnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASRInfo = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASRResponse = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASR_Failed = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASR_Finished = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASR_GetResulted = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASR_Started = null;
    public static final LiveWrappedSAMICoreCallBackEventType ASR_WebSocketStateChanged = null;
    public static final LiveWrappedSAMICoreCallBackEventType AudioUploadEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType BSResponse = null;
    public static final LiveWrappedSAMICoreCallBackEventType BotTriggered = null;
    public static final LiveWrappedSAMICoreCallBackEventType CallDisConnectedWithRetry = null;
    public static final LiveWrappedSAMICoreCallBackEventType ChatEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType ChatResponse = null;
    public static final a Companion = null;
    public static final LiveWrappedSAMICoreCallBackEventType GetResulted = null;
    public static final LiveWrappedSAMICoreCallBackEventType PVadEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType PVadStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType PlayerStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType PlayerStopped = null;
    public static final LiveWrappedSAMICoreCallBackEventType PostBackAudioConfig = null;
    public static final LiveWrappedSAMICoreCallBackEventType RequestRetried = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_EngineError = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_EngineStart = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_EngineStop = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_PreWakeupResult = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_SidEnrollResult = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_SidLoadResult = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_SidVerifyFailResult = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_WakeupEnd = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_WakeupResult = null;
    public static final LiveWrappedSAMICoreCallBackEventType SA_WakeupTimeout = null;
    public static final LiveWrappedSAMICoreCallBackEventType SessionCanceled = null;
    public static final LiveWrappedSAMICoreCallBackEventType SessionConfResponse = null;
    public static final LiveWrappedSAMICoreCallBackEventType SessionFailed = null;
    public static final LiveWrappedSAMICoreCallBackEventType SessionFinished = null;
    public static final LiveWrappedSAMICoreCallBackEventType SessionStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType SpeakerSimilarity = null;
    public static final LiveWrappedSAMICoreCallBackEventType SpeechEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType SpeechStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTSEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTSResponse = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTSSentenceEnd = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTSSentenceStart = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_Failed = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_Finished = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_GetResulted = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_Player_Finished = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_Started = null;
    public static final LiveWrappedSAMICoreCallBackEventType TTS_WebSocketStateChanged = null;
    public static final LiveWrappedSAMICoreCallBackEventType TaskFailed = null;
    public static final LiveWrappedSAMICoreCallBackEventType TaskFinished = null;
    public static final LiveWrappedSAMICoreCallBackEventType TaskResponse = null;
    public static final LiveWrappedSAMICoreCallBackEventType TaskStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType VAD_TimeOut = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_Failed = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_Finished = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_GetResulted = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_Player_Finished = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_Started = null;
    public static final LiveWrappedSAMICoreCallBackEventType VC_WebSocketStateChanged = null;
    public static final LiveWrappedSAMICoreCallBackEventType VadEnded = null;
    public static final LiveWrappedSAMICoreCallBackEventType VadStarted = null;
    public static final LiveWrappedSAMICoreCallBackEventType VuiReset = null;
    public static final LiveWrappedSAMICoreCallBackEventType WakeUp_Failed = null;
    public static final LiveWrappedSAMICoreCallBackEventType WakeUp_Succeed = null;
    public static final LiveWrappedSAMICoreCallBackEventType WebSocketStateChanged = null;
    public static final /* synthetic */ LiveWrappedSAMICoreCallBackEventType[] a = null;
    public static final SparseArray<LiveWrappedSAMICoreCallBackEventType> b = null;
    private final int value;

    public static LiveWrappedSAMICoreCallBackEventType valueOf(String r1) {
        return (LiveWrappedSAMICoreCallBackEventType) r27.a.a(LiveWrappedSAMICoreCallBackEventType.class, r1);
    }

    public static LiveWrappedSAMICoreCallBackEventType[] values() {
        return (LiveWrappedSAMICoreCallBackEventType[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.LiveWrappedSAMICoreCallBackEventType$a] */
    static {
        int r3 = 0;
        LiveWrappedSAMICoreCallBackEventType r1 = new LiveWrappedSAMICoreCallBackEventType("TTS_Started", 0, 0);
        TTS_Started = r1;
        LiveWrappedSAMICoreCallBackEventType r2 = new LiveWrappedSAMICoreCallBackEventType("TTS_GetResulted", 1, 1);
        TTS_GetResulted = r2;
        LiveWrappedSAMICoreCallBackEventType r4 = new LiveWrappedSAMICoreCallBackEventType("TTS_Finished", 2, 2);
        TTS_Finished = r4;
        LiveWrappedSAMICoreCallBackEventType r5 = new LiveWrappedSAMICoreCallBackEventType("TTS_Failed", 3, 3);
        TTS_Failed = r5;
        LiveWrappedSAMICoreCallBackEventType r6 = new LiveWrappedSAMICoreCallBackEventType("TTS_WebSocketStateChanged", 4, 4);
        TTS_WebSocketStateChanged = r6;
        LiveWrappedSAMICoreCallBackEventType r7 = new LiveWrappedSAMICoreCallBackEventType("ASR_Started", 5, 5);
        ASR_Started = r7;
        LiveWrappedSAMICoreCallBackEventType r8 = new LiveWrappedSAMICoreCallBackEventType("ASR_GetResulted", 6, 6);
        ASR_GetResulted = r8;
        LiveWrappedSAMICoreCallBackEventType r9 = new LiveWrappedSAMICoreCallBackEventType("ASR_Finished", 7, 7);
        ASR_Finished = r9;
        LiveWrappedSAMICoreCallBackEventType r10 = new LiveWrappedSAMICoreCallBackEventType("ASR_Failed", 8, 8);
        ASR_Failed = r10;
        LiveWrappedSAMICoreCallBackEventType r11 = new LiveWrappedSAMICoreCallBackEventType("ASR_WebSocketStateChanged", 9, 9);
        ASR_WebSocketStateChanged = r11;
        LiveWrappedSAMICoreCallBackEventType r12 = new LiveWrappedSAMICoreCallBackEventType("VC_Started", 10, 10);
        VC_Started = r12;
        LiveWrappedSAMICoreCallBackEventType r13 = new LiveWrappedSAMICoreCallBackEventType("VC_GetResulted", 11, 11);
        VC_GetResulted = r13;
        LiveWrappedSAMICoreCallBackEventType r14 = new LiveWrappedSAMICoreCallBackEventType("VC_Finished", 12, 12);
        VC_Finished = r14;
        LiveWrappedSAMICoreCallBackEventType r15 = new LiveWrappedSAMICoreCallBackEventType("VC_Failed", 13, 13);
        VC_Failed = r15;
        LiveWrappedSAMICoreCallBackEventType r16 = new LiveWrappedSAMICoreCallBackEventType("VC_WebSocketStateChanged", 14, 14);
        VC_WebSocketStateChanged = r16;
        LiveWrappedSAMICoreCallBackEventType r17 = new LiveWrappedSAMICoreCallBackEventType("VC_Player_Finished", 15, 15);
        VC_Player_Finished = r17;
        LiveWrappedSAMICoreCallBackEventType r18 = new LiveWrappedSAMICoreCallBackEventType("TTS_Player_Finished", 16, 20);
        TTS_Player_Finished = r18;
        LiveWrappedSAMICoreCallBackEventType r19 = new LiveWrappedSAMICoreCallBackEventType("SA_EngineStart", 17, 50);
        SA_EngineStart = r19;
        LiveWrappedSAMICoreCallBackEventType r20 = new LiveWrappedSAMICoreCallBackEventType("SA_EngineStop", 18, 51);
        SA_EngineStop = r20;
        LiveWrappedSAMICoreCallBackEventType r21 = new LiveWrappedSAMICoreCallBackEventType("SA_EngineError", 19, 52);
        SA_EngineError = r21;
        LiveWrappedSAMICoreCallBackEventType r22 = new LiveWrappedSAMICoreCallBackEventType("SA_WakeupResult", 20, 53);
        SA_WakeupResult = r22;
        LiveWrappedSAMICoreCallBackEventType r23 = new LiveWrappedSAMICoreCallBackEventType("SA_SidEnrollResult", 21, 54);
        SA_SidEnrollResult = r23;
        LiveWrappedSAMICoreCallBackEventType r24 = new LiveWrappedSAMICoreCallBackEventType("SA_SidLoadResult", 22, 55);
        SA_SidLoadResult = r24;
        LiveWrappedSAMICoreCallBackEventType r25 = new LiveWrappedSAMICoreCallBackEventType("SA_PreWakeupResult", 23, 56);
        SA_PreWakeupResult = r25;
        LiveWrappedSAMICoreCallBackEventType r26 = new LiveWrappedSAMICoreCallBackEventType("SA_WakeupTimeout", 24, 57);
        SA_WakeupTimeout = r26;
        LiveWrappedSAMICoreCallBackEventType r27 = new LiveWrappedSAMICoreCallBackEventType("SA_SidVerifyFailResult", 25, 58);
        SA_SidVerifyFailResult = r27;
        LiveWrappedSAMICoreCallBackEventType r28 = new LiveWrappedSAMICoreCallBackEventType("SA_WakeupEnd", 26, 59);
        SA_WakeupEnd = r28;
        LiveWrappedSAMICoreCallBackEventType r29 = new LiveWrappedSAMICoreCallBackEventType("TaskStarted", 27, 200);
        TaskStarted = r29;
        LiveWrappedSAMICoreCallBackEventType r30 = new LiveWrappedSAMICoreCallBackEventType("TaskFinished", 28, 201);
        TaskFinished = r30;
        LiveWrappedSAMICoreCallBackEventType r31 = new LiveWrappedSAMICoreCallBackEventType("TaskFailed", 29, 202);
        TaskFailed = r31;
        LiveWrappedSAMICoreCallBackEventType r32 = new LiveWrappedSAMICoreCallBackEventType("GetResulted", 30, z0.TYPE_BATTLE_INVITE);
        GetResulted = r32;
        LiveWrappedSAMICoreCallBackEventType r33 = new LiveWrappedSAMICoreCallBackEventType("SessionStarted", 31, z0.TYPE_BATTLE_REJECT);
        SessionStarted = r33;
        LiveWrappedSAMICoreCallBackEventType r34 = new LiveWrappedSAMICoreCallBackEventType("SessionFinished", 32, z0.TYPE_BATTLE_CUT_SHORT);
        SessionFinished = r34;
        LiveWrappedSAMICoreCallBackEventType r35 = new LiveWrappedSAMICoreCallBackEventType("SessionCanceled", 33, 206);
        SessionCanceled = r35;
        LiveWrappedSAMICoreCallBackEventType r36 = new LiveWrappedSAMICoreCallBackEventType("SessionFailed", 34, 207);
        SessionFailed = r36;
        LiveWrappedSAMICoreCallBackEventType r37 = new LiveWrappedSAMICoreCallBackEventType("TaskResponse", 35, 208);
        TaskResponse = r37;
        LiveWrappedSAMICoreCallBackEventType r38 = new LiveWrappedSAMICoreCallBackEventType("ASRResponse", 36, 209);
        ASRResponse = r38;
        LiveWrappedSAMICoreCallBackEventType r39 = new LiveWrappedSAMICoreCallBackEventType("ASREnded", 37, 210);
        ASREnded = r39;
        LiveWrappedSAMICoreCallBackEventType r40 = new LiveWrappedSAMICoreCallBackEventType("ChatResponse", 38, 211);
        ChatResponse = r40;
        LiveWrappedSAMICoreCallBackEventType r41 = new LiveWrappedSAMICoreCallBackEventType("ChatEnded", 39, 212);
        ChatEnded = r41;
        LiveWrappedSAMICoreCallBackEventType r42 = new LiveWrappedSAMICoreCallBackEventType("TTSSentenceStart", 40, 213);
        TTSSentenceStart = r42;
        LiveWrappedSAMICoreCallBackEventType r43 = new LiveWrappedSAMICoreCallBackEventType("TTSResponse", 41, 214);
        TTSResponse = r43;
        LiveWrappedSAMICoreCallBackEventType r44 = new LiveWrappedSAMICoreCallBackEventType("TTSSentenceEnd", 42, 215);
        TTSSentenceEnd = r44;
        LiveWrappedSAMICoreCallBackEventType r45 = new LiveWrappedSAMICoreCallBackEventType("TTSEnded", 43, 216);
        TTSEnded = r45;
        LiveWrappedSAMICoreCallBackEventType r46 = new LiveWrappedSAMICoreCallBackEventType("WebSocketStateChanged", 44, 217);
        WebSocketStateChanged = r46;
        LiveWrappedSAMICoreCallBackEventType r47 = new LiveWrappedSAMICoreCallBackEventType("CallDisConnectedWithRetry", 45, 218);
        CallDisConnectedWithRetry = r47;
        LiveWrappedSAMICoreCallBackEventType r48 = new LiveWrappedSAMICoreCallBackEventType("RequestRetried", 46, 219);
        RequestRetried = r48;
        LiveWrappedSAMICoreCallBackEventType r49 = new LiveWrappedSAMICoreCallBackEventType("ASRInfo", 47, 220);
        ASRInfo = r49;
        LiveWrappedSAMICoreCallBackEventType r50 = new LiveWrappedSAMICoreCallBackEventType("BSResponse", 48, 221);
        BSResponse = r50;
        LiveWrappedSAMICoreCallBackEventType r51 = new LiveWrappedSAMICoreCallBackEventType("BotTriggered", 49, 222);
        BotTriggered = r51;
        LiveWrappedSAMICoreCallBackEventType r52 = new LiveWrappedSAMICoreCallBackEventType("AudioUploadEnded", 50, 223);
        AudioUploadEnded = r52;
        LiveWrappedSAMICoreCallBackEventType r53 = new LiveWrappedSAMICoreCallBackEventType("SpeechStarted", 51, 224);
        SpeechStarted = r53;
        LiveWrappedSAMICoreCallBackEventType r54 = new LiveWrappedSAMICoreCallBackEventType("SpeechEnded", 52, 225);
        SpeechEnded = r54;
        LiveWrappedSAMICoreCallBackEventType r55 = new LiveWrappedSAMICoreCallBackEventType("PlayerStarted", 53, 226);
        PlayerStarted = r55;
        LiveWrappedSAMICoreCallBackEventType r56 = new LiveWrappedSAMICoreCallBackEventType("PlayerStopped", 54, 227);
        PlayerStopped = r56;
        LiveWrappedSAMICoreCallBackEventType r57 = new LiveWrappedSAMICoreCallBackEventType("SessionConfResponse", 55, 230);
        SessionConfResponse = r57;
        LiveWrappedSAMICoreCallBackEventType r58 = new LiveWrappedSAMICoreCallBackEventType("PostBackAudioConfig", 56, 231);
        PostBackAudioConfig = r58;
        LiveWrappedSAMICoreCallBackEventType r59 = new LiveWrappedSAMICoreCallBackEventType("VadStarted", 57, 250);
        VadStarted = r59;
        LiveWrappedSAMICoreCallBackEventType r60 = new LiveWrappedSAMICoreCallBackEventType("VadEnded", 58, 251);
        VadEnded = r60;
        LiveWrappedSAMICoreCallBackEventType r61 = new LiveWrappedSAMICoreCallBackEventType("PVadStarted", 59, 252);
        PVadStarted = r61;
        LiveWrappedSAMICoreCallBackEventType r62 = new LiveWrappedSAMICoreCallBackEventType("PVadEnded", 60, 253);
        PVadEnded = r62;
        LiveWrappedSAMICoreCallBackEventType r63 = new LiveWrappedSAMICoreCallBackEventType("SpeakerSimilarity", 61, 254);
        SpeakerSimilarity = r63;
        LiveWrappedSAMICoreCallBackEventType r64 = new LiveWrappedSAMICoreCallBackEventType("VuiReset", 62, MonitorLevel.WARN);
        VuiReset = r64;
        LiveWrappedSAMICoreCallBackEventType r65 = new LiveWrappedSAMICoreCallBackEventType("VAD_TimeOut", 63, 352);
        VAD_TimeOut = r65;
        LiveWrappedSAMICoreCallBackEventType r66 = new LiveWrappedSAMICoreCallBackEventType("WakeUp_Succeed", 64, 353);
        WakeUp_Succeed = r66;
        LiveWrappedSAMICoreCallBackEventType r67 = new LiveWrappedSAMICoreCallBackEventType("WakeUp_Failed", 65, 354);
        WakeUp_Failed = r67;
        LiveWrappedSAMICoreCallBackEventType r68 = new LiveWrappedSAMICoreCallBackEventType("AIS_Data", 66, MonitorLevel.ERROR);
        AIS_Data = r68;
        LiveWrappedSAMICoreCallBackEventType r69 = new LiveWrappedSAMICoreCallBackEventType("AIS_Ability", 67, 401);
        AIS_Ability = r69;
        a = new LiveWrappedSAMICoreCallBackEventType[]{r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69};
        Companion = new a();
        b = new SparseArray();
        LiveWrappedSAMICoreCallBackEventType[] r0 = values();
        int r70 = r0.length;
    L3:
        if (r3 >= r70) goto L5;
        LiveWrappedSAMICoreCallBackEventType r71 = r0[r3];
        b.put(r71.value, r71);
        r3 = r3 + 1;
        goto L3
    }

    public static final /* synthetic */ SparseArray access$getIntToEnumMap$cp() {
        return b;
    }

    public final int getValue() {
        return this.value;
    }

    public LiveWrappedSAMICoreCallBackEventType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
