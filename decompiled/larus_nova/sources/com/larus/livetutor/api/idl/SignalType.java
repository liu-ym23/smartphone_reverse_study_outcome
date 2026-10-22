package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\"\b\u0087\u0081\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001$B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006%"}, d2 = {"Lcom/larus/livetutor/api/idl/SignalType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EndCall", "UserInterrupt", "CallStarted", "CallStartFail", "UserAsrEnd", "AnswerStart", "AnswerEnd", "UserAsrStart", "Error", "ClearSubtitle", "UploadData", "BoardMessageAck", "StartControl", "UserAsrTimeoutSubimit", "UserSpeaking", "LiveTutorClientControlMsg", "ModifyTutorUserSettingMsg", "FixedAudioMsg", "InteractiveOptionMsg", "Subtitle", "BoardMessage", "LoadingStart", "LiveTutorStart", "WaitUserAnswer", "LiveTutorRoundEnd", "LiveTutorReplayStart", "LiveTutorModifyTtsSpeedAck", "InteractiveCardMsg", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SignalType extends Enum<SignalType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SignalType[] $VALUES = null;

    @SerializedName("205")
    public static final SignalType AnswerEnd = null;

    @SerializedName("204")
    public static final SignalType AnswerStart = null;

    @SerializedName(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M)
    public static final SignalType BoardMessage = null;

    @SerializedName("502")
    public static final SignalType BoardMessageAck = null;

    @SerializedName("202")
    public static final SignalType CallStartFail = null;

    @SerializedName("201")
    public static final SignalType CallStarted = null;

    @SerializedName("208")
    public static final SignalType ClearSubtitle = null;
    public static final a Companion = null;

    @SerializedName("11")
    public static final SignalType EndCall = null;

    @SerializedName("207")
    public static final SignalType Error = null;

    @SerializedName("508")
    public static final SignalType FixedAudioMsg = null;

    @SerializedName("1009")
    public static final SignalType InteractiveCardMsg = null;

    @SerializedName("509")
    public static final SignalType InteractiveOptionMsg = null;

    @SerializedName("506")
    public static final SignalType LiveTutorClientControlMsg = null;

    @SerializedName("1008")
    public static final SignalType LiveTutorModifyTtsSpeedAck = null;

    @SerializedName("1007")
    public static final SignalType LiveTutorReplayStart = null;

    @SerializedName("1006")
    public static final SignalType LiveTutorRoundEnd = null;

    @SerializedName("1004")
    public static final SignalType LiveTutorStart = null;

    @SerializedName("1003")
    public static final SignalType LoadingStart = null;

    @SerializedName("507")
    public static final SignalType ModifyTutorUserSettingMsg = null;

    @SerializedName("503")
    public static final SignalType StartControl = null;

    @SerializedName(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF)
    public static final SignalType Subtitle = null;

    @SerializedName("501")
    public static final SignalType UploadData = null;

    @SerializedName("203")
    public static final SignalType UserAsrEnd = null;

    @SerializedName("206")
    public static final SignalType UserAsrStart = null;

    @SerializedName("504")
    public static final SignalType UserAsrTimeoutSubimit = null;

    @SerializedName("12")
    public static final SignalType UserInterrupt = null;

    @SerializedName("505")
    public static final SignalType UserSpeaking = null;

    @SerializedName("1005")
    public static final SignalType WaitUserAnswer = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ SignalType[] $values() {
        return new SignalType[]{EndCall, UserInterrupt, CallStarted, CallStartFail, UserAsrEnd, AnswerStart, AnswerEnd, UserAsrStart, Error, ClearSubtitle, UploadData, BoardMessageAck, StartControl, UserAsrTimeoutSubimit, UserSpeaking, LiveTutorClientControlMsg, ModifyTutorUserSettingMsg, FixedAudioMsg, InteractiveOptionMsg, Subtitle, BoardMessage, LoadingStart, LiveTutorStart, WaitUserAnswer, LiveTutorRoundEnd, LiveTutorReplayStart, LiveTutorModifyTtsSpeedAck, InteractiveCardMsg};
    }

    public static EnumEntries<SignalType> getEntries() {
        return $ENTRIES;
    }

    static {
        EndCall = new SignalType("EndCall", 0, 11);
        UserInterrupt = new SignalType("UserInterrupt", 1, 12);
        CallStarted = new SignalType("CallStarted", 2, 201);
        CallStartFail = new SignalType("CallStartFail", 3, 202);
        UserAsrEnd = new SignalType("UserAsrEnd", 4, 203);
        AnswerStart = new SignalType("AnswerStart", 5, 204);
        AnswerEnd = new SignalType("AnswerEnd", 6, 205);
        UserAsrStart = new SignalType("UserAsrStart", 7, 206);
        Error = new SignalType("Error", 8, 207);
        ClearSubtitle = new SignalType("ClearSubtitle", 9, 208);
        UploadData = new SignalType("UploadData", 10, 501);
        BoardMessageAck = new SignalType("BoardMessageAck", 11, 502);
        StartControl = new SignalType("StartControl", 12, 503);
        UserAsrTimeoutSubimit = new SignalType("UserAsrTimeoutSubimit", 13, 504);
        UserSpeaking = new SignalType("UserSpeaking", 14, 505);
        LiveTutorClientControlMsg = new SignalType("LiveTutorClientControlMsg", 15, 506);
        ModifyTutorUserSettingMsg = new SignalType("ModifyTutorUserSettingMsg", 16, 507);
        FixedAudioMsg = new SignalType("FixedAudioMsg", 17, 508);
        InteractiveOptionMsg = new SignalType("InteractiveOptionMsg", 18, 509);
        Subtitle = new SignalType("Subtitle", 19, 1001);
        BoardMessage = new SignalType("BoardMessage", 20, 1002);
        LoadingStart = new SignalType("LoadingStart", 21, 1003);
        LiveTutorStart = new SignalType("LiveTutorStart", 22, 1004);
        WaitUserAnswer = new SignalType("WaitUserAnswer", 23, 1005);
        LiveTutorRoundEnd = new SignalType("LiveTutorRoundEnd", 24, 1006);
        LiveTutorReplayStart = new SignalType("LiveTutorReplayStart", 25, 1007);
        LiveTutorModifyTtsSpeedAck = new SignalType("LiveTutorModifyTtsSpeedAck", 26, 1008);
        InteractiveCardMsg = new SignalType("InteractiveCardMsg", 27, 1009);
        SignalType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static SignalType[] values() {
        return (SignalType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final SignalType findByValue(int r100) {
        Companion.getClass();
        if (r100 == 11) goto L38;
        if (r100 == 12) goto L66;
        switch(r100) {
            case 201: goto L47;
            case 202: goto L46;
            case 203: goto L45;
            case 204: goto L44;
            case 205: goto L43;
            case 206: goto L42;
            case 207: goto L41;
            case 208: goto L40;
            default: goto L7;
        };
    L7:
        switch(r100) {
            case 501: goto L56;
            case 502: goto L55;
            case 503: goto L54;
            case 504: goto L53;
            case 505: goto L52;
            case 506: goto L51;
            case 507: goto L50;
            case 508: goto L49;
            case 509: goto L48;
            default: goto L8;
        };
    L8:
        switch(r100) {
            case 1001: goto L65;
            case 1002: goto L64;
            case 1003: goto L63;
            case 1004: goto L62;
            case 1005: goto L61;
            case 1006: goto L60;
            case 1007: goto L59;
            case 1008: goto L58;
            case 1009: goto L57;
            default: goto L9;
        };
    L9:
        return null;
    L57:
        return InteractiveCardMsg;
    L58:
        return LiveTutorModifyTtsSpeedAck;
    L59:
        return LiveTutorReplayStart;
    L60:
        return LiveTutorRoundEnd;
    L61:
        return WaitUserAnswer;
    L62:
        return LiveTutorStart;
    L63:
        return LoadingStart;
    L64:
        return BoardMessage;
    L65:
        return Subtitle;
    L48:
        return InteractiveOptionMsg;
    L49:
        return FixedAudioMsg;
    L50:
        return ModifyTutorUserSettingMsg;
    L51:
        return LiveTutorClientControlMsg;
    L52:
        return UserSpeaking;
    L53:
        return UserAsrTimeoutSubimit;
    L54:
        return StartControl;
    L55:
        return BoardMessageAck;
    L56:
        return UploadData;
    L40:
        return ClearSubtitle;
    L41:
        return Error;
    L42:
        return UserAsrStart;
    L43:
        return AnswerEnd;
    L44:
        return AnswerStart;
    L45:
        return UserAsrEnd;
    L46:
        return CallStartFail;
    L47:
        return CallStarted;
    L66:
        return UserInterrupt;
    L38:
        return EndCall;
    }

    public static SignalType valueOf(String r100) {
        return (SignalType) r27.a.a(SignalType.class, r100);
    }

    private SignalType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
