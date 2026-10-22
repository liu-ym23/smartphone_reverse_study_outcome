package com.larus.im.internal.trace.manager.definition;

import com.byted.cast.common.ErrorCode;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b6\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:¨\u0006;"}, d2 = {"Lcom/larus/im/internal/trace/manager/definition/AVCommonError;", "", "code", "", "msg", "", "subCode", "subMsg", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getSubCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSubMsg", "Connect_Timeout_Unknown", "Connect_Timeout_Get_Token", "Connect_Timeout_User_Join", "Connect_Timeout_Bot_Join", "Connect_Timeout_Not_Send_Start_Call", "Connect_Timeout_Call_Started_Timeout", "Network_UNAVAILABLE", "Get_TokenFailed", "Get_TokenFailed_Net_Cancel", "Get_TokenFailed_Http_Error", "Get_TokenFailed_Server_Error", "Get_TokenFailed_Resolve_Error", "User_Join_Room_Failed", "User_Join_Room_Failed_Room_Invalid", "User_Join_Room_Failed_Room_Create_Failed", "Bot_Join_Failed", "Start_Call_Failed", "Start_Session_Failed", "Start_Session_Message_NOT_SET", "Bot_Left", "Disconnected", "Disconnected_Room_Related", "Disconnected_RTC_FAILED", "Engine_Occupied", "Server_Limiting", "Timeout", "Client_Interrupt", "Scene_Switched", "Image_Triggered", "Interrupt", "No_Content", "Unexpected_Stage", "Session_End", "Send_Invalid", "Send_Result_Error", "Audio_Render_Error", "Audio_Capture_Error", "Audio_Screen_Capture_Error", "Video_Render_Error", "Video_Capture_Error", "Video_Screen_Capture_Error", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AVCommonError extends Enum<AVCommonError> {
    public static final AVCommonError Audio_Capture_Error = null;
    public static final AVCommonError Audio_Render_Error = null;
    public static final AVCommonError Audio_Screen_Capture_Error = null;
    public static final AVCommonError Bot_Join_Failed = null;
    public static final AVCommonError Bot_Left = null;
    public static final AVCommonError Client_Interrupt = null;
    public static final AVCommonError Connect_Timeout_Bot_Join = null;
    public static final AVCommonError Connect_Timeout_Call_Started_Timeout = null;
    public static final AVCommonError Connect_Timeout_Get_Token = null;
    public static final AVCommonError Connect_Timeout_Not_Send_Start_Call = null;
    public static final AVCommonError Connect_Timeout_Unknown = null;
    public static final AVCommonError Connect_Timeout_User_Join = null;
    public static final AVCommonError Disconnected = null;
    public static final AVCommonError Disconnected_RTC_FAILED = null;
    public static final AVCommonError Disconnected_Room_Related = null;
    public static final AVCommonError Engine_Occupied = null;
    public static final AVCommonError Get_TokenFailed = null;
    public static final AVCommonError Get_TokenFailed_Http_Error = null;
    public static final AVCommonError Get_TokenFailed_Net_Cancel = null;
    public static final AVCommonError Get_TokenFailed_Resolve_Error = null;
    public static final AVCommonError Get_TokenFailed_Server_Error = null;
    public static final AVCommonError Image_Triggered = null;
    public static final AVCommonError Interrupt = null;
    public static final AVCommonError Network_UNAVAILABLE = null;
    public static final AVCommonError No_Content = null;
    public static final AVCommonError Scene_Switched = null;
    public static final AVCommonError Send_Invalid = null;
    public static final AVCommonError Send_Result_Error = null;
    public static final AVCommonError Server_Limiting = null;
    public static final AVCommonError Session_End = null;
    public static final AVCommonError Start_Call_Failed = null;
    public static final AVCommonError Start_Session_Failed = null;
    public static final AVCommonError Start_Session_Message_NOT_SET = null;
    public static final AVCommonError Timeout = null;
    public static final AVCommonError Unexpected_Stage = null;
    public static final AVCommonError User_Join_Room_Failed = null;
    public static final AVCommonError User_Join_Room_Failed_Room_Create_Failed = null;
    public static final AVCommonError User_Join_Room_Failed_Room_Invalid = null;
    public static final AVCommonError Video_Capture_Error = null;
    public static final AVCommonError Video_Render_Error = null;
    public static final AVCommonError Video_Screen_Capture_Error = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AVCommonError[] f350143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350144b = null;
    private final int code;
    private final String msg;
    private final Integer subCode;
    private final String subMsg;

    public static EnumEntries<AVCommonError> getEntries() {
        return f350144b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        AVCommonError r100 = new AVCommonError("Connect_Timeout_Unknown", 0, -1001, "Timeout", -1001001, "unknown");
        Connect_Timeout_Unknown = r100;
        AVCommonError r101 = new AVCommonError("Connect_Timeout_Get_Token", 1, -1001, "Timeout", -1001002, "get token timeout");
        Connect_Timeout_Get_Token = r101;
        AVCommonError r102 = new AVCommonError("Connect_Timeout_User_Join", 2, -1001, "Timeout", -1001003, "user join timeout");
        Connect_Timeout_User_Join = r102;
        AVCommonError r103 = new AVCommonError("Connect_Timeout_Bot_Join", 3, -1001, "Timeout", -1001004, "bot join timeout");
        Connect_Timeout_Bot_Join = r103;
        AVCommonError r104 = new AVCommonError("Connect_Timeout_Not_Send_Start_Call", 4, -1001, "Timeout", -1001005, "not send start call");
        Connect_Timeout_Not_Send_Start_Call = r104;
        AVCommonError r105 = new AVCommonError("Connect_Timeout_Call_Started_Timeout", 5, -1001, "Timeout", -1001006, "call started timeout");
        Connect_Timeout_Call_Started_Timeout = r105;
        AVCommonError r106 = new AVCommonError("Network_UNAVAILABLE", 6, -1002, "Network Unavailable", null, null, 12, null);
        Network_UNAVAILABLE = r106;
        AVCommonError r107 = new AVCommonError("Get_TokenFailed", 7, -1003, "Get Token Failed", null, null, 12, null);
        Get_TokenFailed = r107;
        AVCommonError r110 = new AVCommonError("Get_TokenFailed_Net_Cancel", 8, -1003, "Get Token Failed", -1003001000, "net request cancel");
        Get_TokenFailed_Net_Cancel = r110;
        AVCommonError r108 = new AVCommonError("Get_TokenFailed_Http_Error", 9, -1003, "Get Token Failed", -1003002000, ErrorCode.DLNA_PLAY_ERROR_DDESC_HTTP);
        Get_TokenFailed_Http_Error = r108;
        AVCommonError r109 = new AVCommonError("Get_TokenFailed_Server_Error", 10, -1003, "Get Token Failed", -1003003000, "server error");
        Get_TokenFailed_Server_Error = r109;
        AVCommonError r111 = new AVCommonError("Get_TokenFailed_Resolve_Error", 11, -1003, "Get Token Failed", -1003004000, "resolve error");
        Get_TokenFailed_Resolve_Error = r111;
        AVCommonError r112 = new AVCommonError("User_Join_Room_Failed", 12, -1004, "User Join Room Failed", -10040000, "unknown");
        User_Join_Room_Failed = r112;
        AVCommonError r113 = new AVCommonError("User_Join_Room_Failed_Room_Invalid", 13, -1004, "User Join Room Failed", -10040001, "room invalid");
        User_Join_Room_Failed_Room_Invalid = r113;
        AVCommonError r114 = new AVCommonError("User_Join_Room_Failed_Room_Create_Failed", 14, -1004, "User Join Room Failed", -10040002, "room create failed");
        User_Join_Room_Failed_Room_Create_Failed = r114;
        AVCommonError r115 = new AVCommonError("Bot_Join_Failed", 15, -1005, "Bot Join Failed", -10050000, "unknown");
        Bot_Join_Failed = r115;
        AVCommonError r116 = new AVCommonError("Start_Call_Failed", 16, -1006, "Start Call Failed", -10060000, "unknown");
        Start_Call_Failed = r116;
        AVCommonError r117 = new AVCommonError("Start_Session_Failed", 17, -1007, "Start Session Failed", null, null, 12, null);
        Start_Session_Failed = r117;
        AVCommonError r210 = new AVCommonError("Start_Session_Message_NOT_SET", 18, -1008, "Start Session Failed", -10080001, "message not set");
        Start_Session_Message_NOT_SET = r210;
        AVCommonError r118 = new AVCommonError("Bot_Left", 19, -1009, "Bot Left", null, null, 12, null);
        Bot_Left = r118;
        AVCommonError r119 = new AVCommonError("Disconnected", 20, -1010, "Disconnected", -10100000, "disconnected");
        Disconnected = r119;
        AVCommonError r211 = new AVCommonError("Disconnected_Room_Related", 21, -1010, "Disconnected", -10100001, "room related disconnected");
        Disconnected_Room_Related = r211;
        AVCommonError r212 = new AVCommonError("Disconnected_RTC_FAILED", 22, -1010, "Disconnected", -10100002, "rtc failed");
        Disconnected_RTC_FAILED = r212;
        AVCommonError r213 = new AVCommonError("Engine_Occupied", 23, -1011, "RTC Engine Error", -10110001, "rtc engine occupied");
        Engine_Occupied = r213;
        AVCommonError r214 = new AVCommonError("Server_Limiting", 24, -1012, "Server Limiting", null, null, 12, null);
        Server_Limiting = r214;
        AVCommonError r215 = new AVCommonError("Timeout", 25, -2001, "Timeout", null, null, 12, null);
        Timeout = r215;
        AVCommonError r310 = new AVCommonError("Client_Interrupt", 26, -2002, "User Interrupt", -2002001, "Client Interrupt");
        Client_Interrupt = r310;
        AVCommonError r216 = new AVCommonError("Scene_Switched", 27, -2002, "User Interrupt", -2002002, "Scene Switched");
        Scene_Switched = r216;
        AVCommonError r217 = new AVCommonError("Image_Triggered", 28, -2002, "User Interrupt", -2002003, "Image Triggered");
        Image_Triggered = r217;
        AVCommonError r218 = new AVCommonError("Interrupt", 29, -2003, "Interrupt", null, null, 12, null);
        Interrupt = r218;
        Integer r311 = null;
        String r410 = null;
        int r411 = 12;
        DefaultConstructorMarker r412 = null;
        AVCommonError r219 = new AVCommonError("No_Content", 30, -2004, "No Content", r311, r410, r411, r412);
        No_Content = r219;
        Integer r413 = null;
        int r510 = 12;
        DefaultConstructorMarker r511 = null;
        AVCommonError r312 = new AVCommonError("Unexpected_Stage", 31, -2005, "Unexpected Stage", r413, null, r510, r511);
        Unexpected_Stage = r312;
        AVCommonError r313 = new AVCommonError("Session_End", 32, -2006, "Session End", r311, r410, r411, r412);
        Session_End = r313;
        AVCommonError r314 = new AVCommonError("Send_Invalid", 33, -3000, "Send Invalid", r413, null == true ? 1 : 0, r510, r511);
        Send_Invalid = r314;
        AVCommonError r414 = new AVCommonError("Send_Result_Error", 34, -3001, "Send Result Error", r311, r410, r411, r412);
        Send_Result_Error = r414;
        String r512 = null;
        int r513 = 12;
        DefaultConstructorMarker r514 = null;
        AVCommonError r315 = new AVCommonError("Audio_Render_Error", 35, AVMDLDataLoader.AVMDLErrorIsInvalidRequestInfo, "Audio Render Error", null == true ? 1 : 0, r512, r513, r514);
        Audio_Render_Error = r315;
        Integer r515 = null;
        String r516 = null;
        int r610 = 12;
        DefaultConstructorMarker r611 = null;
        AVCommonError r316 = new AVCommonError("Audio_Capture_Error", 36, -4001, "Audio Capture Error", r515, r516, r610, r611);
        Audio_Capture_Error = r316;
        AVCommonError r317 = new AVCommonError("Audio_Screen_Capture_Error", 37, -4002, "Audio Screen Capture Error", null == true ? 1 : 0, r512, r513, r514);
        Audio_Screen_Capture_Error = r317;
        AVCommonError r318 = new AVCommonError("Video_Render_Error", 38, -4003, "Video Render Error", r515, r516, r610, r611);
        Video_Render_Error = r318;
        AVCommonError r319 = new AVCommonError("Video_Capture_Error", 39, -4004, "Video Capture Error", null == true ? 1 : 0, r512, r513, r514);
        Video_Capture_Error = r319;
        AVCommonError r320 = new AVCommonError("Video_Screen_Capture_Error", 40, -4005, "Video Screen Capture Error", r515, r516, r610, r611);
        Video_Screen_Capture_Error = r320;
        AVCommonError[] r120 = {r100, r101, r102, r103, r104, r105, r106, r107, r110, r108, r109, r111, r112, r113, r114, r115, r116, r117, r210, r118, r119, r211, r212, r213, r214, r215, r310, r216, r217, r218, r219, r312, r313, r314, r414, r315, r316, r317, r318, r319, r320};
        f350143a = r120;
        f350144b = EnumEntriesKt.enumEntries(r120);
    }

    public static AVCommonError[] values() {
        return (AVCommonError[]) f350143a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final Integer getSubCode() {
        return this.subCode;
    }

    public final String getSubMsg() {
        return this.subMsg;
    }

    public static AVCommonError valueOf(String r100) {
        return (AVCommonError) a.a(AVCommonError.class, r100);
    }

    public AVCommonError(String r100, int r101, int r102, String r103, Integer r104, String r105) {
        super(r100, r101);
        this.code = r102;
        this.msg = r103;
        this.subCode = r104;
        this.subMsg = r105;
    }

    public /* synthetic */ AVCommonError(String r110, int r111, int r112, String r113, Integer r114, String r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 4) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r116 & 8) == 0) goto L9;
        String r101 = null;
    L10:
        this(r110, r111, r112, r113, r100, r101);
        return;
    L9:
        r101 = r115;
        goto L10
    L5:
        r100 = r114;
        goto L7
    }
}
