package com.larus.avlink.api.model;

import com.bytedance.android.shopping.buynow.data.model.RequestErrorType;
import com.mammon.audiosdk.session.type.RequestEvent;
import com.mammon.audiosdk.session.type.ResponseEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\bC\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bG¨\u0006H"}, d2 = {"Lcom/larus/avlink/api/model/DoraEvent;", "", "message", "", "type", "", "extra", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getType", "()I", "getExtra", "setExtra", "DoraStart", "RadioEnd", "DoraStop", ResponseEvent.SessionStarted, "FirstASRResponse", "ASRNoContent", ResponseEvent.ASRResponse, ResponseEvent.ASREnded, "TTSText", "FirstTTSResponse", ResponseEvent.TTSEnded, "DoraStopNoTTS", "ChatCommend", "SpeechStart", "SpeechEnd", ResponseEvent.SessionFailed, "SessionStop", "WSDisconnected", "WSReConnect", "TTSPlayStart", "TTSPlayEnd", RequestEvent.StartSession, "TTSDataExhaustion", RequestErrorType.NETWORK_ERROR, "NetworkRecover", "EndAsr", "AppForeground", "RequestLocPermission", "LocPermissionResult", "Unknown", "Cancel_Radio_Data_End", "VuiTTSStart", "VuiTtsBreak", "VuiTtsEnd", "VuiAsrEnd", "VuiDataEnd", "VuiError", "VUIEnd", "VUISilent", "VUIReset", "VUISpeechReady", "TriggerTakeImage", "StartTakeImage", "SendImageEvent", "StartTransmitImage", "CameraCompleteImage", "EndTransmitImage", "CameraCompleteImageFailed", "StartUploadImage", "EndUploadImage", "UploadImageFailed", "OCRStart", "OCREnd", "OCRUploadStart", "OCRUploadFinish", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraEvent extends Enum<DoraEvent> {
    public static final DoraEvent ASREnded = null;
    public static final DoraEvent ASRNoContent = null;
    public static final DoraEvent ASRResponse = null;
    public static final DoraEvent AppForeground = null;
    public static final DoraEvent CameraCompleteImage = null;
    public static final DoraEvent CameraCompleteImageFailed = null;
    public static final DoraEvent Cancel_Radio_Data_End = null;
    public static final DoraEvent ChatCommend = null;
    public static final DoraEvent DoraStart = null;
    public static final DoraEvent DoraStop = null;
    public static final DoraEvent DoraStopNoTTS = null;
    public static final DoraEvent EndAsr = null;
    public static final DoraEvent EndTransmitImage = null;
    public static final DoraEvent EndUploadImage = null;
    public static final DoraEvent FirstASRResponse = null;
    public static final DoraEvent FirstTTSResponse = null;
    public static final DoraEvent LocPermissionResult = null;
    public static final DoraEvent NetworkError = null;
    public static final DoraEvent NetworkRecover = null;
    public static final DoraEvent OCREnd = null;
    public static final DoraEvent OCRStart = null;
    public static final DoraEvent OCRUploadFinish = null;
    public static final DoraEvent OCRUploadStart = null;
    public static final DoraEvent RadioEnd = null;
    public static final DoraEvent RequestLocPermission = null;
    public static final DoraEvent SendImageEvent = null;
    public static final DoraEvent SessionFailed = null;
    public static final DoraEvent SessionStarted = null;
    public static final DoraEvent SessionStop = null;
    public static final DoraEvent SpeechEnd = null;
    public static final DoraEvent SpeechStart = null;
    public static final DoraEvent StartSession = null;
    public static final DoraEvent StartTakeImage = null;
    public static final DoraEvent StartTransmitImage = null;
    public static final DoraEvent StartUploadImage = null;
    public static final DoraEvent TTSDataExhaustion = null;
    public static final DoraEvent TTSEnded = null;
    public static final DoraEvent TTSPlayEnd = null;
    public static final DoraEvent TTSPlayStart = null;
    public static final DoraEvent TTSText = null;
    public static final DoraEvent TriggerTakeImage = null;
    public static final DoraEvent Unknown = null;
    public static final DoraEvent UploadImageFailed = null;
    public static final DoraEvent VUIEnd = null;
    public static final DoraEvent VUIReset = null;
    public static final DoraEvent VUISilent = null;
    public static final DoraEvent VUISpeechReady = null;
    public static final DoraEvent VuiAsrEnd = null;
    public static final DoraEvent VuiDataEnd = null;
    public static final DoraEvent VuiError = null;
    public static final DoraEvent VuiTTSStart = null;
    public static final DoraEvent VuiTtsBreak = null;
    public static final DoraEvent VuiTtsEnd = null;
    public static final DoraEvent WSDisconnected = null;
    public static final DoraEvent WSReConnect = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraEvent[] f291646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291647b = null;
    private String extra;
    private String message;
    private final int type;

    public DoraEvent() {
        throw null;
    }

    public static EnumEntries<DoraEvent> getEntries() {
        return f291647b;
    }

    static {
        DoraEvent r100 = new DoraEvent("DoraStart", 0, "Dora Start", 0, null, 4, null);
        DoraStart = r100;
        DoraEvent r101 = new DoraEvent("RadioEnd", 1, "Radio End", 0, null, 4, null);
        RadioEnd = r101;
        DoraEvent r102 = new DoraEvent("DoraStop", 2, "Radio Stop", 0, null, 4, null);
        DoraStop = r102;
        DoraEvent r103 = new DoraEvent(ResponseEvent.SessionStarted, 3, "Session Started", 2, null, 4, null);
        SessionStarted = r103;
        DoraEvent r104 = new DoraEvent("FirstASRResponse", 4, "First ASRResponse", 2, null, 4, null);
        FirstASRResponse = r104;
        DoraEvent r105 = new DoraEvent("ASRNoContent", 5, "ASR NoContent", 2, null, 4, null);
        ASRNoContent = r105;
        DoraEvent r106 = new DoraEvent(ResponseEvent.ASRResponse, 6, "ASR Response", 2, null, 4, null);
        ASRResponse = r106;
        DoraEvent r107 = new DoraEvent(ResponseEvent.ASREnded, 7, "ASR Ended", 2, null, 4, null);
        ASREnded = r107;
        DoraEvent r108 = new DoraEvent("TTSText", 8, "TTS TEXT", 2, null, 4, null);
        TTSText = r108;
        DoraEvent r110 = new DoraEvent("FirstTTSResponse", 9, "First TTSResponse", 2, null, 4, null);
        FirstTTSResponse = r110;
        DoraEvent r109 = new DoraEvent(ResponseEvent.TTSEnded, 10, "TTS Ended", 2, null, 4, null);
        TTSEnded = r109;
        DoraEvent r111 = new DoraEvent("DoraStopNoTTS", 11, "Dora-stop-", 2, null, 4, null);
        DoraStopNoTTS = r111;
        DoraEvent r112 = new DoraEvent("ChatCommend", 12, "ChatCommend", 2, null, 4, null);
        ChatCommend = r112;
        DoraEvent r113 = new DoraEvent("SpeechStart", 13, "Speech Start", 2, null, 4, null);
        SpeechStart = r113;
        DoraEvent r114 = new DoraEvent("SpeechEnd", 14, "Speech End", 2, null, 4, null);
        SpeechEnd = r114;
        DoraEvent r115 = new DoraEvent(ResponseEvent.SessionFailed, 15, "Session Failed", 2, null, 4, null);
        SessionFailed = r115;
        DoraEvent r116 = new DoraEvent("SessionStop", 16, "Session Stop", 3, null, 4, null);
        SessionStop = r116;
        DoraEvent r117 = new DoraEvent("WSDisconnected", 17, "WS DC State: ", 2, null, 4, null);
        WSDisconnected = r117;
        DoraEvent r210 = new DoraEvent("WSReConnect", 18, "WS DC Retry", 2, null, 4, null);
        WSReConnect = r210;
        DoraEvent r118 = new DoraEvent("TTSPlayStart", 19, "TTS Player Start", 4, null, 4, null);
        TTSPlayStart = r118;
        DoraEvent r119 = new DoraEvent("TTSPlayEnd", 20, "TTS Player End", 4, null, 4, null);
        TTSPlayEnd = r119;
        DoraEvent r211 = new DoraEvent(RequestEvent.StartSession, 21, "Start Session", 3, null, 4, null);
        StartSession = r211;
        DoraEvent r212 = new DoraEvent("TTSDataExhaustion", 22, "TTS Data Exhaustion", 4, null, 4, null);
        TTSDataExhaustion = r212;
        DoraEvent r213 = new DoraEvent(RequestErrorType.NETWORK_ERROR, 23, "Network Error", 1, null, 4, null);
        NetworkError = r213;
        DoraEvent r214 = new DoraEvent("NetworkRecover", 24, "Network Recover", 2, null, 4, null);
        NetworkRecover = r214;
        DoraEvent r215 = new DoraEvent("EndAsr", 25, "End Asr", 3, null, 4, null);
        EndAsr = r215;
        DoraEvent r216 = new DoraEvent("AppForeground", 26, "App Foreground", 4, null, 4, null);
        AppForeground = r216;
        DoraEvent r310 = new DoraEvent("RequestLocPermission", 27, "Request Loc Permission", 4, null, 4, null);
        RequestLocPermission = r310;
        DoraEvent r217 = new DoraEvent("LocPermissionResult", 28, "Loc Permission Granted", 4, null, 4, null);
        LocPermissionResult = r217;
        DoraEvent r218 = new DoraEvent("Unknown", 29, "Unknown", -1, null, 4, null);
        Unknown = r218;
        DoraEvent r219 = new DoraEvent("Cancel_Radio_Data_End", 30, "Cancel_Radio_Data_End", 1, null, 4, null);
        Cancel_Radio_Data_End = r219;
        DoraEvent r311 = new DoraEvent("VuiTTSStart", 31, "TTS Start", 1, null, 4, null);
        VuiTTSStart = r311;
        DoraEvent r312 = new DoraEvent("VuiTtsBreak", 32, "TTS Break", 1, null, 4, null);
        VuiTtsBreak = r312;
        DoraEvent r313 = new DoraEvent("VuiTtsEnd", 33, "TTS end", 1, null, 4, null);
        VuiTtsEnd = r313;
        DoraEvent r314 = new DoraEvent("VuiAsrEnd", 34, "ASR End", 1, null, 4, null);
        VuiAsrEnd = r314;
        DoraEvent r315 = new DoraEvent("VuiDataEnd", 35, "TTS Data End", 1, null, 4, null);
        VuiDataEnd = r315;
        DoraEvent r410 = new DoraEvent("VuiError", 36, "VUI Error", 1, null, 4, null);
        VuiError = r410;
        DoraEvent r316 = new DoraEvent("VUIEnd", 37, "VUI End", 1, null, 4, null);
        VUIEnd = r316;
        DoraEvent r317 = new DoraEvent("VUISilent", 38, "VUI Silent", 1, null, 4, null);
        VUISilent = r317;
        DoraEvent r318 = new DoraEvent("VUIReset", 39, "VUI Reset", 1, null, 4, null);
        VUIReset = r318;
        DoraEvent r319 = new DoraEvent("VUISpeechReady", 40, "VUI Speech Ready", 1, null, 4, null);
        VUISpeechReady = r319;
        DoraEvent r411 = new DoraEvent("TriggerTakeImage", 41, "Trigger Take Image", 1, null, 4, null);
        TriggerTakeImage = r411;
        DoraEvent r412 = new DoraEvent("StartTakeImage", 42, "Start Take Image", 0, null, 4, null);
        StartTakeImage = r412;
        DoraEvent r413 = new DoraEvent("SendImageEvent", 43, "Send Image Event", 0, null, 4, null);
        SendImageEvent = r413;
        DoraEvent r414 = new DoraEvent("StartTransmitImage", 44, "Start Transmit Image", 0, null, 4, null);
        StartTransmitImage = r414;
        DoraEvent r510 = new DoraEvent("CameraCompleteImage", 45, "Camera Complete Image", 0, null, 4, null);
        CameraCompleteImage = r510;
        DoraEvent r415 = new DoraEvent("EndTransmitImage", 46, "End Transmit Image", 0, null, 4, null);
        EndTransmitImage = r415;
        DoraEvent r416 = new DoraEvent("CameraCompleteImageFailed", 47, "Camera Complete Image Failed", 0, null, 4, null);
        CameraCompleteImageFailed = r416;
        DoraEvent r417 = new DoraEvent("StartUploadImage", 48, "Start Upload Image", 3, null, 4, null);
        StartUploadImage = r417;
        DoraEvent r418 = new DoraEvent("EndUploadImage", 49, "End Upload Image", 3, null, 4, null);
        EndUploadImage = r418;
        DoraEvent r419 = new DoraEvent("UploadImageFailed", 50, "Upload Image Failed", 3, null, 4, null);
        UploadImageFailed = r419;
        DoraEvent r511 = new DoraEvent("OCRStart", 51, "OCR Start", 0, null, 4, null);
        OCRStart = r511;
        DoraEvent r512 = new DoraEvent("OCREnd", 52, "OCR End", 0, null, 4, null);
        OCREnd = r512;
        DoraEvent r513 = new DoraEvent("OCRUploadStart", 53, "OCR Upload Start", 3, null, 4, null);
        OCRUploadStart = r513;
        DoraEvent r610 = new DoraEvent("OCRUploadFinish", 54, "OCR Upload Finish", 3, null, 4, null);
        OCRUploadFinish = r610;
        DoraEvent[] r120 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r109, r111, r112, r113, r114, r115, r116, r117, r210, r118, r119, r211, r212, r213, r214, r215, r216, r310, r217, r218, r219, r311, r312, r313, r314, r315, r410, r316, r317, r318, r319, r411, r412, r413, r414, r510, r415, r416, r417, r418, r419, r511, r512, r513, r610};
        f291646a = r120;
        f291647b = EnumEntriesKt.enumEntries(r120);
    }

    public static DoraEvent[] values() {
        return (DoraEvent[]) f291646a.clone();
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getType() {
        return this.type;
    }

    public static DoraEvent valueOf(String r100) {
        return (DoraEvent) a.a(DoraEvent.class, r100);
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.message = r100;
    }

    public DoraEvent(String r100, int r101, String r102, int r103, String r104, int r105, DefaultConstructorMarker r106) {
        if ((r105 & 1) == 0) goto L6;
        r102 = "";
    L6:
        if ((r105 & 4) == 0) goto L8;
        r104 = null;
    L8:
        super(r100, r101);
        this.message = r102;
        this.type = r103;
        this.extra = r104;
    }
}
