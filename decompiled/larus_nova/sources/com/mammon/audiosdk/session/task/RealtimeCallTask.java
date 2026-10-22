package com.mammon.audiosdk.session.task;

import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.SAMICoreHostCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.mammon.audiosdk.session.SpeechSessionManager;
import com.mammon.audiosdk.session.callback.ISpeechCallback;
import com.mammon.audiosdk.session.data.ASRParam;
import com.mammon.audiosdk.session.data.AudioConfig;
import com.mammon.audiosdk.session.data.AudioDataParam;
import com.mammon.audiosdk.session.data.EventDataParam;
import com.mammon.audiosdk.session.data.LoudnessStrategyParam;
import com.mammon.audiosdk.session.data.RealtimeCallTaskParam;
import com.mammon.audiosdk.session.data.SpeechReceiverCallbackParam;
import com.mammon.audiosdk.session.data.SpeechSenderCallbackParam;
import com.mammon.audiosdk.session.data.TTSParam;
import com.mammon.audiosdk.session.data.TriggerBotEventParam;
import com.mammon.audiosdk.session.type.ResponseEvent;
import com.mammon.audiosdk.structures.SAMICoreAsrContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreTtsContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantLoudnessStrategyParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class RealtimeCallTask implements ISpeechCallback {
    private static final String TAG = "mammon RealtimeCallTask";
    private RealtimeCallTaskParam mParam;
    private SAMICore mSamiCore;
    private SpeechSessionManager mSessionManager;
    private ISpeechCallback mUserCallback;

    public static class HostCallback implements SAMICoreHostCallBackListener {
        private final ISpeechCallback userCallback;

        public HostCallback(ISpeechCallback r100) {
            this.userCallback = r100;
        }

        @Override // com.mammon.audiosdk.SAMICoreHostCallBackListener
        public void onSendToHost(SAMICoreCallBackEventType r100, SAMICoreBlock r101) {
            if (r101.dataType != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L6;
            SAMICoreServerEvent r102 = (SAMICoreServerEvent) r101.audioData[0];
            SpeechSenderCallbackParam r103 = new SpeechSenderCallbackParam();
            r103.event = r102.event;
            r103.meta = r102.textMsg;
            r103.data = r102.binaryData;
            this.userCallback.onSenderCallback(r103, r101.userContext);
            return;
        }
    }

    public static class SAMICoreCallback implements SAMICoreCallBackListener {
        private final ISpeechCallback userCallback;

        public SAMICoreCallback(ISpeechCallback r100) {
            this.userCallback = r100;
        }

        @Override // com.mammon.audiosdk.SAMICoreCallBackListener
        public void onMessageReceived(SAMICoreCallBackEventType r100, SAMICoreBlock r101) {
            SAMICoreDataType r102 = r101.dataType;
            if (r102 != SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event) goto L8;
            SAMICoreServerEvent r103 = (SAMICoreServerEvent) r101.audioData[0];
            if (this.userCallback == null) goto L13;
            SpeechReceiverCallbackParam r104 = new SpeechReceiverCallbackParam();
            r104.event = r103.event;
            r104.statusCode = r103.statusCode;
            r104.statusText = r103.statusText;
            r104.taskId = r103.taskId;
            r104.messageId = r103.messageId;
            r104.sessionId = r103.sessionId;
            r104.meta = r103.textMsg;
            r104.data = r103.binaryData;
            this.userCallback.onReceiverCallback(r104, r101.userContext);
            return;
        L13:
            return;
        L8:
            if (r102 != SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event) goto L15;
            SAMICoreWebSocketConnectionEvent r105 = (SAMICoreWebSocketConnectionEvent) r101.audioData[0];
            int r106 = r105.state;
            if (r105.textMsg != null) goto L12;
            return;
        L12:
            return;
        }
    }

    private int createSAMICoreHandle() {
        SAMICoreVoiceAssistantContextCreateParameter r100 = new SAMICoreVoiceAssistantContextCreateParameter();
        r100.url = this.mSessionManager.getSessionManagerParam().url;
        r100.connectTimeout = this.mSessionManager.getSessionManagerParam().connectTimeout;
        r100.header = this.mSessionManager.getSessionManagerParam().header;
        int r101 = this.mSessionManager.getSessionManagerParam().transportType;
        if (r101 != 1) goto L5;
        r100.enableFrontier = true;
    L15:
        RealtimeCallTaskParam r102 = this.mParam;
        r100.appKey = r102.appKey;
        String r103 = r102.token;
        r100.token = r103;
        if (r103 == null) goto L18;
        r100.tokenType = SAMICoreTokenType.TOKEN_TO_B;
    L18:
        r100.taskId = r102.sessionId;
        r100.businessInfo = r102.businessInfo;
        int r104 = this.mSamiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Voice_Assistant_Online, r100);
        if (r104 != 0) goto L21;
    L21:
        return r104;
    L5:
        if (r101 != 2) goto L7;
        r100.enableHostTransport = true;
        goto L15
    L7:
        if (r101 != 3) goto L9;
        r100.enableConnectPool = true;
        goto L15
    L9:
        if (r101 != 4) goto L15;
        r100.enableConnectPool = true;
        r100.enableFrontier = true;
        goto L15
    }

    private int destroySAMICoreHandle() {
        this.mSamiCore.SAMICoreDestroyHandle();
        return 0;
    }

    private int init() {
        SAMICoreCallback r100 = new SAMICoreCallback(this.mUserCallback);
        HostCallback r101 = new HostCallback(this.mUserCallback);
        SAMICore r102 = new SAMICore();
        this.mSamiCore = r102;
        r102.setListener(r100);
        this.mSamiCore.setHostCallBackListener(r101);
        this.mSamiCore.setEnableSyncInterface(true);
        int r103 = createSAMICoreHandle();
        if (r103 == 0) goto L6;
        return r103;
    L6:
        return startNetConnect();
    }

    private int setAsrParam() {
        SAMICoreAsrContextCreateParameter r100 = new SAMICoreAsrContextCreateParameter();
        ASRParam r101 = this.mParam.asrParam;
        AudioConfig r102 = r101.audioConfig;
        r100.sampleRate = r102.sampleRate;
        r100.format = r102.format;
        r100.channel = r102.channel;
        r100.language = r101.language;
        r100.model = r101.model;
        SAMICoreProperty r103 = new SAMICoreProperty();
        r103.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Asr_Param;
        r103.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Asr_Context_Param;
        r103.dataObjectArray = new SAMICoreAsrContextCreateParameter[]{r100};
        r103.dataArrayLen = 1;
        int r104 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r103);
        if (r104 != 0) goto L5;
    L5:
        return r104;
    }

    private int setTtsParam() {
        SAMICoreTtsContextCreateParameter r100 = new SAMICoreTtsContextCreateParameter();
        TTSParam r101 = this.mParam.ttsParam;
        r100.speaker = r101.speaker;
        AudioConfig r102 = r101.audioConfig;
        r100.sampleRate = r102.sampleRate;
        r100.format = r102.format;
        SAMICoreProperty r103 = new SAMICoreProperty();
        r103.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Tts_Param;
        r103.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Tts_Context_Param;
        r103.dataObjectArray = new SAMICoreTtsContextCreateParameter[]{r100};
        r103.dataArrayLen = 1;
        int r104 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r103);
        if (r104 != 0) goto L5;
    L5:
        return r104;
    }

    private int startNetConnect() {
        SAMICoreVoiceAssistantPropertyParameter r100 = new SAMICoreVoiceAssistantPropertyParameter();
        r100.enableRealtimeVoiceCall = true;
        SAMICoreProperty r101 = new SAMICoreProperty();
        r101.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Ws_Connect;
        r101.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r101.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r100};
        r101.dataArrayLen = 1;
        if (this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r101) != 0) goto L5;
    L5:
        return 0;
    }

    private int stopNetConnect() {
        SAMICoreProperty r100 = new SAMICoreProperty();
        r100.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Stop_Ws_Connect;
        r100.type = SAMICoreDataType.SAMICoreDataType_Null;
        int r101 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r100);
        if (r101 != 0) goto L5;
    L5:
        return r101;
    }

    public void release() {
        stopNetConnect();
        destroySAMICoreHandle();
        this.mUserCallback = null;
        this.mSamiCore = null;
        this.mParam = null;
        this.mSessionManager = null;
    }

    private int sendFinishSession(Object r100) {
        SAMICoreVoiceAssistantPropertyParameter r101 = new SAMICoreVoiceAssistantPropertyParameter();
        r101.taskId = this.mParam.sessionId;
        SAMICoreProperty r102 = new SAMICoreProperty();
        r102.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Finish_Session;
        r102.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r102.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r101};
        r102.dataArrayLen = 1;
        r102.userContext = r100;
        int r103 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r102);
        if (r103 != 0) goto L5;
    L5:
        return r103;
    }

    private int sendFinishTask(Object r100) {
        SAMICoreProperty r101 = new SAMICoreProperty();
        r101.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Finish_Task;
        r101.type = SAMICoreDataType.SAMICoreDataType_Null;
        r101.userContext = r100;
        int r102 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r101);
        if (r102 != 0) goto L5;
    L5:
        return r102;
    }

    private int sendStartSession(Object r100) {
        SAMICoreVoiceAssistantPropertyParameter r101 = new SAMICoreVoiceAssistantPropertyParameter();
        RealtimeCallTaskParam r102 = this.mParam;
        r101.taskId = r102.sessionId;
        r101.enableAudioInput = true;
        r101.enableTextReading = true;
        r101.enableRealtimeVoiceCall = true;
        r101.requestType = 1;
        r101.interruptType = r102.interruptType;
        r101.business = r102.businessType;
        r101.chat = r102.chat;
        r101.trace = r102.trace;
        r101.sceneType = r102.sceneType;
        r101.extra = r102.extra;
        SAMICoreProperty r103 = new SAMICoreProperty();
        r103.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Session;
        r103.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r103.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r101};
        r103.dataArrayLen = 1;
        r103.userContext = r100;
        int r104 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r103);
        if (r104 != 0) goto L5;
    L5:
        return r104;
    }

    private int sendStartTask(Object r100) {
        SAMICoreProperty r101 = new SAMICoreProperty();
        r101.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Task;
        r101.type = SAMICoreDataType.SAMICoreDataType_Null;
        r101.userContext = r100;
        int r102 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r101);
        if (r102 != 0) goto L5;
    L5:
        return r102;
    }

    public int start(Object r100) {
        int r101 = sendStartTask(r100);
        if (r101 == 0) goto L5;
        return r101;
    L5:
        int r102 = setAsrParam();
        if (r102 == 0) goto L8;
        return r102;
    L8:
        int r103 = setTtsParam();
        if (r103 == 0) goto L12;
        return r103;
    L12:
        return sendStartSession(r100);
    }

    public int stop(Object r100) {
        sendFinishSession(r100);
        sendFinishTask(r100);
        return 0;
    }

    private int processSAMICoreAudioReceived(AudioDataParam r100, Object r101) {
        System.currentTimeMillis();
        SAMICoreServerEvent r102 = new SAMICoreServerEvent();
        r102.event = ResponseEvent.TTSResponse;
        r102.binaryData = r100.data;
        if (r100.payloadParam == null) goto L13;
        JSONObject r103 = new JSONObject();
        String r104 = r100.payloadParam.extra;     // Catch: JSONException -> L10
        if (r104 == null) goto L8;
        r103.put("extra", r104);     // Catch: JSONException -> L10
    L8:
        r102.textMsg = r103.toString();     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        SAMICoreProperty r105 = new SAMICoreProperty();
        r105.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Process_Server_Event;
        r105.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event;
        r105.dataObjectArray = new SAMICoreServerEvent[]{r102};
        r105.dataArrayLen = 1;
        r105.userContext = r101;
        int r106 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r105);
        if (r106 != 0) goto L16;
    L16:
        return r106;
    }

    private int processSAMICoreEventReceived(EventDataParam r100, Object r101) {
        SAMICoreServerEvent r102 = new SAMICoreServerEvent();
        r102.binaryData = r100.data;
        SAMICoreProperty r103 = new SAMICoreProperty();
        r103.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Process_Server_Event;
        r103.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event;
        r103.dataObjectArray = new SAMICoreServerEvent[]{r102};
        r103.dataArrayLen = 1;
        r103.userContext = r101;
        int r104 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r103);
        if (r104 != 0) goto L5;
    L5:
        return r104;
    }

    private int sendAudioData(AudioDataParam r100, Object r101) {
        if (r100 != null) goto L5;
        return 100001;
    L5:
        SAMICoreVoiceAssistantAudioData r102 = new SAMICoreVoiceAssistantAudioData();
        r102.taskId = this.mParam.sessionId;
        r102.data = r100.data;
        r102.refData = r100.refData;
        r102.extra = r100.payloadParam.extra;
        SAMICoreBlock r103 = new SAMICoreBlock();
        r103.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Audio_data;
        r103.audioData = new SAMICoreVoiceAssistantAudioData[]{r102};
        r103.numberAudioData = 1;
        r103.userContext = r101;
        int r104 = this.mSamiCore.SAMICoreProcess(r103, null);
        if (r104 != 0) goto L8;
    L8:
        return r104;
    }

    private int sendSAMICoreEvent(EventDataParam r100, Object r101) {
        if (r100 != null) goto L6;
        return 100001;
    L6:
        if (r100.dataType != 201) goto L14;
        Object r102 = r100.eventParam;
        if (r102 != null) goto L10;
        return 100001;
    L10:
        LoudnessStrategyParam r103 = (LoudnessStrategyParam) r102;
        SAMICoreVoiceAssistantLoudnessStrategyParameter r104 = new SAMICoreVoiceAssistantLoudnessStrategyParameter();
        r104.metaData = r103.metaData;
        r104.loudNormAlgoType = r103.loudNormAlgoType;
        r104.deviceAiData = r103.deviceAiData;
        r104.audioDumpPath = r103.audioDumpPath;
        SAMICoreProperty r105 = new SAMICoreProperty();
        r105.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_LoudnessStrategy_Param;
        r105.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Set_Loudness_Strategy_Param;
        r105.dataObjectArray = new SAMICoreVoiceAssistantLoudnessStrategyParameter[]{r104};
        r105.dataArrayLen = 1;
        int r106 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r105);
        if (r106 != 0) goto L13;
    L13:
        return r106;
    L14:
        SAMICoreVoiceAssistantPropertyParameter r107 = new SAMICoreVoiceAssistantPropertyParameter();
        r107.taskId = this.mParam.sessionId;
        SAMICoreProperty r108 = new SAMICoreProperty();
        r108.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r108.userContext = r101;
        switch(r100.dataType) {
            case 105: goto L21;
            case 106: goto L20;
            case 107: goto L19;
            case 108: goto L18;
            case 109: goto L17;
            default: goto L22;
        };
    L17:
        r108.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Trigger_Bot;
        r107.triggerType = ((TriggerBotEventParam) r100.eventParam).triggerBotType;
        goto L22
    L18:
        r108.f384359id = SAMICorePropertyId.SAMICore_PropertyId_Voice_Assistant_Reconnect_Call;
        goto L22
    L19:
        r108.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Continue_Call;
        goto L22
    L20:
        r108.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Pause_Call;
        goto L22
    L21:
        r108.f384359id = SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Interrupt_Call;
    L22:
        r108.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r107};
        r108.dataArrayLen = 1;
        int r109 = this.mSamiCore.SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant, r108);
        if (r109 != 0) goto L25;
    L25:
        return r109;
    }

    @Override // com.mammon.audiosdk.session.callback.ISpeechCallback
    public void onReceiverCallback(SpeechReceiverCallbackParam r100, Object r101) {
        ISpeechCallback r102 = this.mUserCallback;
        if (r102 == null) goto L6;
        r102.onReceiverCallback(r100, r101);
        return;
    }

    @Override // com.mammon.audiosdk.session.callback.ISpeechCallback
    public void onSenderCallback(SpeechSenderCallbackParam r100, Object r101) {
        ISpeechCallback r102 = this.mUserCallback;
        if (r102 == null) goto L6;
        r102.onSenderCallback(r100, r101);
        return;
    }

    public int processAudioReceived(AudioDataParam r100, Object r101) {
        return processSAMICoreAudioReceived(r100, r101);
    }

    public int processEventReceived(EventDataParam r100, Object r101) {
        return processSAMICoreEventReceived(r100, r101);
    }

    public int reset(RealtimeCallTaskParam r100, Object r101) {
        this.mParam = r100;
        sendFinishSession(r101);
        return sendStartSession(r101);
    }

    public int sendAudio(AudioDataParam r100, Object r101) {
        return sendAudioData(r100, r101);
    }

    public int sendEvent(EventDataParam r100, Object r101) {
        return sendSAMICoreEvent(r100, r101);
    }

    public RealtimeCallTask(RealtimeCallTaskParam r100, ISpeechCallback r101, SpeechSessionManager r102) {
        this.mUserCallback = r101;
        this.mParam = r100;
        this.mSessionManager = r102;
        init();
    }
}
