package com.larus.im.internal.network.link.impl.sami;

import android.os.SystemClock;
import android.util.Base64;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreTtsContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantLoudnessStrategyParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f349499a = null;

    static {
        f349499a = new p();
    }

    public static String d(SAMICore r100) {
        if (r100 != null) goto L6;
        return ", SAMICore: null";
    L6:
        return ", SAMICore: " + r100.getHandle();
    }

    public static void a(String r100, SAMICoreVoiceAssistantPropertyParameter r101) {
        if (com.flow.kmp.common.util.f.a(r100) == false) goto L6;
        r101.sessionId = r100;
        return;
    }

    public static void i(SAMICore r100, ve9.p r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "ttsConfig");
        String r102 = r101.f554515g;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L21:
        fe9.a.f476620a.b("SAMICoreManager", "setLoudnessStrategyParam failed, loudness parameter illegal, audioMetrics = " + r101.f554515g + ", deviceAIData = " + r101.f554516h);
        return;
    L12:
        if (r101.f554517i != 0.0f) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L21;
        fe9.a r105 = fe9.a.f476620a;
        r105.e("SAMICoreManager", "RealtimeCall set target loudness, audioMetrics = " + r101.f554515g + ", deviceAIData = " + r101.f554516h);
        SAMICoreVoiceAssistantLoudnessStrategyParameter r106 = new SAMICoreVoiceAssistantLoudnessStrategyParameter();
        r106.metaData = r101.f554515g;
        r106.deviceAiData = r101.f554516h;
        r106.audioDumpPath = r101.f554519k;
        r106.loudNormAlgoType = r101.f554518j;
        SAMICoreProperty r107 = new SAMICoreProperty();
        r107.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Loudness_Strategy_Param;
        r107.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param;
        r107.dataObjectArray = new SAMICoreVoiceAssistantLoudnessStrategyParameter[]{r106};
        r107.dataArrayLen = 1;
        int r108 = r100.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r107);
        c("setLoudnessStrategyParam", r108, r107);
        if (r108 == 0) goto L23;
        r105.b("SAMICoreManager", "setLoudnessStrategyParam failed ret:" + r108 + r100.getHandle());
        return;
    L23:
        return;
    L14:
        r104 = false;
        goto L15
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public static int k(SAMICore r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "sceneSwitch");
        SAMICoreProperty r102 = new SAMICoreProperty();
        r102.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Translate_Scene_Switch;
        r102.type = SAMICoreDataType.SAMICoreDataType_String;
        r102.dataObjectArray = new String[]{r101};
        r102.dataArrayLen = 1;
        int r103 = r100.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r102);
        fe9.a.f476620a.e("SAMICoreManager", "setTranslateSceneSwitch, sceneSwitch is " + r101 + ", ret: " + r103);
        return r103;
    }

    public static void b(SAMICore r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        SAMICoreVoiceAssistantPropertyParameter r103 = new SAMICoreVoiceAssistantPropertyParameter();
        r103.taskId = r101;
        a(r102, r103);
        SAMICoreProperty r104 = new SAMICoreProperty();
        r104.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Finish_Session;
        r104.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r104.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r103};
        r104.dataArrayLen = 1;
        c("finishSession", r100.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r104), r104);
    }

    public static void c(String r100, int r101, Object r102) {
        if (com.larus.im.internal.delegate.c.f348197a.isTestChannel() == false) goto L5;
        zd9.h.f571481a.getClass();
        String r103 = zd9.h.c(r102);
    L7:
        if (r101 == 0) goto L9;
        fe9.a.f476620a.b("SAMICoreManager", r100 + " ret->" + r101 + ", " + r103);
        return;
    L9:
        fe9.a.f476620a.a("SAMICoreManager", r100 + " ret->" + r101 + ", " + r103);
        return;
    L5:
        r103 = null;
        goto L7
    }

    public static void g(SAMICore r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        SAMICoreVoiceAssistantPropertyParameter r103 = new SAMICoreVoiceAssistantPropertyParameter();
        r103.playerStatus = r102;
        r103.taskId = r101;
        SAMICoreProperty r104 = new SAMICoreProperty();
        r104.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Player_Status;
        r104.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r104.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r103};
        r104.dataArrayLen = 1;
        c("setPlayerStopped", r100.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r104), r104);
    }

    public static int j(SAMICore r100, ve9.f r101, ve9.p r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "connectConfig");
        Intrinsics.checkNotNullParameter(r102, "ttsConfig");
        SAMICoreTtsContextCreateParameter r103 = new SAMICoreTtsContextCreateParameter();
        r103.header = r101.f554458g;
        r103.url = r101.f554456e;
        r103.appKey = r101.f554453b;
        r103.token = "";
        r103.enableNetTransportCompress = r102.f554512d;
        r103.bitRate = r102.f554513e;
        r103.sampleRate = r102.f554514f;
        r103.format = r102.f554509a;
        r103.speaker = r102.f554511c;
        r103.extra = r102.f554520l;
        SAMICoreProperty r104 = new SAMICoreProperty();
        r104.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Tts_Param;
        r104.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Tts_Context_Param;
        r104.dataObjectArray = new SAMICoreTtsContextCreateParameter[]{r103};
        r104.dataArrayLen = 1;
        int r105 = r100.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r104);
        c("setTTSParamProperty", r105, r104);
        return r105;
    }

    public static int e(SAMICore r100, final String r101, byte[] r102, final String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "audioData");
        SAMICoreVoiceAssistantAudioData r103 = new SAMICoreVoiceAssistantAudioData();
        r103.taskId = r101;
        r103.data = r102;
        r103.refData = r102;
        if (r110 == null) goto L5;
        r103.extra = r110;
    L5:
        SAMICoreBlock r104 = new SAMICoreBlock();
        r104.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Audio_data;
        r104.audioData = new SAMICoreVoiceAssistantAudioData[]{r103};
        r104.numberAudioData = 1;
        final int r105 = r100.SAMICoreProcess(r104, null);
        p r106 = f349499a;
        Function0 r107 = new s(r105, r101, r110);
        Intrinsics.checkNotNullParameter(r107, "block");
        long r108 = SystemClock.elapsedRealtime();
        if ((r108 - r106.f349489a) <= 1000) goto L8;
        r107.invoke();
        r106.f349489a = r108;
    L8:
        return r105;
    }

    public static void f(SAMICore r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        SAMICoreVoiceAssistantPropertyParameter r104 = new SAMICoreVoiceAssistantPropertyParameter();
        r104.taskId = r101;
        a(r102, r104);
        SAMICoreProperty r105 = new SAMICoreProperty();
        if (r103 == false) goto L5;
        SAMICorePropertyId r106 = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Mute_Call;
    L6:
        r105.f384359id = r106;
        r105.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r105.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r104};
        r105.dataArrayLen = 1;
        c("sendMuteEvent", r100.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r105), r105);
        return;
    L5:
        r106 = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Unmute_Call;
        goto L6
    }

    public static int h(SAMICore r100, String r101, String r102, byte[] r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "engineVersion");
        Intrinsics.checkNotNullParameter(r103, SpeechEngineDefines.VAD_ENGINE);
        SAMICoreVoiceAssistantPropertyParameter r104 = new SAMICoreVoiceAssistantPropertyParameter();
        r104.taskId = r101;
        JSONObject r105 = new JSONObject();
        r105.put("engine_version", r102);
        r105.put("vad_info", Base64.encodeToString(r103, 2));
        r104.extra = r105.toString();
        final SAMICoreProperty r106 = new SAMICoreProperty();
        r106.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_VAD_Info;
        r106.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r106.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r104};
        r106.dataArrayLen = 1;
        final int r107 = r100.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r106);
        p r108 = f349499a;
        Function0 r109 = new t(r107, r106);
        Intrinsics.checkNotNullParameter(r109, "block");
        long r110 = SystemClock.elapsedRealtime();
        if ((r110 - r108.f349489a) <= 1000) goto L5;
        r109.invoke();
        r108.f349489a = r110;
    L5:
        return r107;
    }

    public static boolean l(SAMICore r100, String r101, ve9.f r102, ve9.o r103, boolean r104, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "connectConfig");
        Intrinsics.checkNotNullParameter(r103, "sessionConfig");
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        JSONObject r105 = new JSONObject();
        r105.put("span_header", r102.f554459h);
        String r106 = r105.toString();
        SAMICoreVoiceAssistantPropertyParameter r107 = new SAMICoreVoiceAssistantPropertyParameter();
        r107.taskId = r101;
        r107.enableAudioInput = true;
        r107.enableRealtimeVoiceCall = true;
        r107.enableTextReading = true;
        r107.enablePlayer = r111;
        r107.requestType = r103.f554490d;
        r107.business = r103.f554487a;
        Integer r112 = r103.f554489c;
        if (r112 == null) goto L5;
        int r113 = r112.intValue();
    L6:
        r107.interruptType = r113;
        ve9.l r114 = r103.f554494h;
        r107.sceneType = r114.f554472a;
        r107.enableTouch = r103.f554497k;
        r107.enableBurst = r103.f554498l;
        d0 r108 = r103.f554488b;
        if (r108 == null) goto L13;
        Pair[] r109 = new Pair[4];
        r109[0] = TuplesKt.to("listen_waiting_time", Integer.valueOf(r114.f554474c));
        if (r103.f554494h.f554473b.length() <= 0) goto L11;
        boolean r115 = true;
    L12:
        r109[1] = TuplesKt.to("is_specified_speaker", Boolean.valueOf(r115));
        r109[2] = TuplesKt.to("need_create_section", Boolean.valueOf(r104));
        r109[3] = TuplesKt.to("enable_server_error_retry", Boolean.valueOf(com.larus.im.internal.delegate.w.q().d("enable_server_error_retry", false)));
        d0 r116 = sf9.a.g(r108, r109);
    L14:
        r107.extra = String.valueOf(r116);
        r107.chat = r103.f554495i;
        r107.wakeupId = r103.f554496j;
        r107.vuiQueryMode = r103.f554501o;
        ve9.k r117 = r103.f554505s;
        boolean r118 = r117.f554469a;
        r107.enableOneShot = r118;
        if (r118 == false) goto L17;
        r107.wakeupWord = r117.f554470b;
        r107.wakeupAudioDurationMs = (int) r117.f554471c;
    L17:
        r107.trace = r106;
        a(r110, r107);
        SAMICoreProperty r119 = new SAMICoreProperty();
        r119.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Session;
        r119.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r119.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r107};
        r119.dataArrayLen = 1;
        int r120 = r100.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r119);
        c("startSession", r120, r119);
        if (r120 == 0) goto L22;
        return false;
    L22:
        return true;
    L11:
        r115 = false;
        goto L12
    L13:
        r116 = null;
        goto L14
    L5:
        r113 = 1;
        goto L6
    }
}
