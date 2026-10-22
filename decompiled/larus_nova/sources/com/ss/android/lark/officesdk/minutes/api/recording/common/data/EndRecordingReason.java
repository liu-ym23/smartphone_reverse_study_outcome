package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020!j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006\""}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/EndRecordingReason;", "", "<init>", "(Ljava/lang/String;I)V", "DOUBAO_CLICK_STOP", "DOUBAO_USER_LOGOUT", "RECORDING_PAGE_CLICK_STOP", "INTERRUPT_RECORD", "SWITCH_TO_FEISHU_RECORDING", "RTC_AUDIO_RECORD_DATA_FAILURE", "AUDIO_RECORD_DATA_FAILURE", "NO_SPACE", "MM_MEETING_END", "MEETING_PUSH_TERMINATED", "ON_RECORD_STOP", "SHOW_FLOAT_WINDOW_FAILED", "SHOW_FLOAT_WINDOW_DISMISS", "MAX_LIMIT_TIME", "RECORD_FINISH_AUDIO_SAVE_CONTINUE", "HARDWARE_STOP_RECORD", "HARDWARE_DISCONNECT", "HARDWARE_MEETING_CONFLICT", "HARDWARE_FLOAT_CONFLICT", "HARDWARE_CALL_INTERRUPTION_TIMEOUT", "HARDWARE_CALL_INTERRUPTION_IDLE_TIMEOUT", "HARDWARE_INPUT_UNAVAILABLE_TIMEOUT", "HARDWARE_SPEAKER_SWITCHED_IDLE", "GET_OR_CREATE_FINISHED_TOKEN_FAILED", "HISTORY_RECORDING", "RTC_PSDA_CHECK_FAILED", AccountType.OTHERS, "HARDWARE_RESTARTED_BY_GESTURE", "canShowEndWindow", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EndRecordingReason extends Enum<EndRecordingReason> {
    public static final EndRecordingReason AUDIO_RECORD_DATA_FAILURE = null;
    public static final EndRecordingReason DOUBAO_CLICK_STOP = null;
    public static final EndRecordingReason DOUBAO_USER_LOGOUT = null;
    public static final EndRecordingReason GET_OR_CREATE_FINISHED_TOKEN_FAILED = null;
    public static final EndRecordingReason HARDWARE_CALL_INTERRUPTION_IDLE_TIMEOUT = null;
    public static final EndRecordingReason HARDWARE_CALL_INTERRUPTION_TIMEOUT = null;
    public static final EndRecordingReason HARDWARE_DISCONNECT = null;
    public static final EndRecordingReason HARDWARE_FLOAT_CONFLICT = null;
    public static final EndRecordingReason HARDWARE_INPUT_UNAVAILABLE_TIMEOUT = null;
    public static final EndRecordingReason HARDWARE_MEETING_CONFLICT = null;
    public static final EndRecordingReason HARDWARE_RESTARTED_BY_GESTURE = null;
    public static final EndRecordingReason HARDWARE_SPEAKER_SWITCHED_IDLE = null;
    public static final EndRecordingReason HARDWARE_STOP_RECORD = null;
    public static final EndRecordingReason HISTORY_RECORDING = null;
    public static final EndRecordingReason INTERRUPT_RECORD = null;
    public static final EndRecordingReason MAX_LIMIT_TIME = null;
    public static final EndRecordingReason MEETING_PUSH_TERMINATED = null;
    public static final EndRecordingReason MM_MEETING_END = null;
    public static final EndRecordingReason NO_SPACE = null;
    public static final EndRecordingReason ON_RECORD_STOP = null;
    public static final EndRecordingReason OTHERS = null;
    public static final EndRecordingReason RECORDING_PAGE_CLICK_STOP = null;
    public static final EndRecordingReason RECORD_FINISH_AUDIO_SAVE_CONTINUE = null;
    public static final EndRecordingReason RTC_AUDIO_RECORD_DATA_FAILURE = null;
    public static final EndRecordingReason RTC_PSDA_CHECK_FAILED = null;
    public static final EndRecordingReason SHOW_FLOAT_WINDOW_DISMISS = null;
    public static final EndRecordingReason SHOW_FLOAT_WINDOW_FAILED = null;
    public static final EndRecordingReason SWITCH_TO_FEISHU_RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EndRecordingReason[] f433510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433511b = null;

    public static EnumEntries<EndRecordingReason> getEntries() {
        return f433511b;
    }

    static {
        EndRecordingReason r100 = new EndRecordingReason("DOUBAO_CLICK_STOP", 0);
        DOUBAO_CLICK_STOP = r100;
        EndRecordingReason r101 = new EndRecordingReason("DOUBAO_USER_LOGOUT", 1);
        DOUBAO_USER_LOGOUT = r101;
        EndRecordingReason r102 = new EndRecordingReason("RECORDING_PAGE_CLICK_STOP", 2);
        RECORDING_PAGE_CLICK_STOP = r102;
        EndRecordingReason r103 = new EndRecordingReason("INTERRUPT_RECORD", 3);
        INTERRUPT_RECORD = r103;
        EndRecordingReason r104 = new EndRecordingReason("SWITCH_TO_FEISHU_RECORDING", 4);
        SWITCH_TO_FEISHU_RECORDING = r104;
        EndRecordingReason r105 = new EndRecordingReason("RTC_AUDIO_RECORD_DATA_FAILURE", 5);
        RTC_AUDIO_RECORD_DATA_FAILURE = r105;
        EndRecordingReason r110 = new EndRecordingReason("AUDIO_RECORD_DATA_FAILURE", 6);
        AUDIO_RECORD_DATA_FAILURE = r110;
        EndRecordingReason r111 = new EndRecordingReason("NO_SPACE", 7);
        NO_SPACE = r111;
        EndRecordingReason r112 = new EndRecordingReason("MM_MEETING_END", 8);
        MM_MEETING_END = r112;
        EndRecordingReason r113 = new EndRecordingReason("MEETING_PUSH_TERMINATED", 9);
        MEETING_PUSH_TERMINATED = r113;
        EndRecordingReason r114 = new EndRecordingReason("ON_RECORD_STOP", 10);
        ON_RECORD_STOP = r114;
        EndRecordingReason r115 = new EndRecordingReason("SHOW_FLOAT_WINDOW_FAILED", 11);
        SHOW_FLOAT_WINDOW_FAILED = r115;
        EndRecordingReason r106 = new EndRecordingReason("SHOW_FLOAT_WINDOW_DISMISS", 12);
        SHOW_FLOAT_WINDOW_DISMISS = r106;
        EndRecordingReason r107 = new EndRecordingReason("MAX_LIMIT_TIME", 13);
        MAX_LIMIT_TIME = r107;
        EndRecordingReason r108 = new EndRecordingReason("RECORD_FINISH_AUDIO_SAVE_CONTINUE", 14);
        RECORD_FINISH_AUDIO_SAVE_CONTINUE = r108;
        EndRecordingReason r109 = new EndRecordingReason("HARDWARE_STOP_RECORD", 15);
        HARDWARE_STOP_RECORD = r109;
        EndRecordingReason r116 = new EndRecordingReason("HARDWARE_DISCONNECT", 16);
        HARDWARE_DISCONNECT = r116;
        EndRecordingReason r117 = new EndRecordingReason("HARDWARE_MEETING_CONFLICT", 17);
        HARDWARE_MEETING_CONFLICT = r117;
        EndRecordingReason r118 = new EndRecordingReason("HARDWARE_FLOAT_CONFLICT", 18);
        HARDWARE_FLOAT_CONFLICT = r118;
        EndRecordingReason r119 = new EndRecordingReason("HARDWARE_CALL_INTERRUPTION_TIMEOUT", 19);
        HARDWARE_CALL_INTERRUPTION_TIMEOUT = r119;
        EndRecordingReason r120 = new EndRecordingReason("HARDWARE_CALL_INTERRUPTION_IDLE_TIMEOUT", 20);
        HARDWARE_CALL_INTERRUPTION_IDLE_TIMEOUT = r120;
        EndRecordingReason r121 = new EndRecordingReason("HARDWARE_INPUT_UNAVAILABLE_TIMEOUT", 21);
        HARDWARE_INPUT_UNAVAILABLE_TIMEOUT = r121;
        EndRecordingReason r122 = new EndRecordingReason("HARDWARE_SPEAKER_SWITCHED_IDLE", 22);
        HARDWARE_SPEAKER_SWITCHED_IDLE = r122;
        EndRecordingReason r123 = new EndRecordingReason("GET_OR_CREATE_FINISHED_TOKEN_FAILED", 23);
        GET_OR_CREATE_FINISHED_TOKEN_FAILED = r123;
        EndRecordingReason r124 = new EndRecordingReason("HISTORY_RECORDING", 24);
        HISTORY_RECORDING = r124;
        EndRecordingReason r125 = new EndRecordingReason("RTC_PSDA_CHECK_FAILED", 25);
        RTC_PSDA_CHECK_FAILED = r125;
        EndRecordingReason r126 = new EndRecordingReason(AccountType.OTHERS, 26);
        OTHERS = r126;
        EndRecordingReason r127 = new EndRecordingReason("HARDWARE_RESTARTED_BY_GESTURE", 27);
        HARDWARE_RESTARTED_BY_GESTURE = r127;
        EndRecordingReason[] r128 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
        f433510a = r128;
        f433511b = EnumEntriesKt.enumEntries(r128);
    }

    public static EndRecordingReason[] values() {
        return (EndRecordingReason[]) f433510a.clone();
    }

    public final boolean canShowEndWindow() {
        if (this != RECORDING_PAGE_CLICK_STOP) goto L5;
    L18:
        return true;
    L5:
        if (this == DOUBAO_CLICK_STOP) goto L18;
        if (this == MAX_LIMIT_TIME) goto L18;
        if (this == RECORD_FINISH_AUDIO_SAVE_CONTINUE) goto L18;
        if (this == HARDWARE_CALL_INTERRUPTION_TIMEOUT) goto L18;
        if (this == HARDWARE_INPUT_UNAVAILABLE_TIMEOUT) goto L18;
        if (this == HARDWARE_SPEAKER_SWITCHED_IDLE) goto L18;
        return false;
    }

    public static EndRecordingReason valueOf(String r100) {
        return (EndRecordingReason) a.a(EndRecordingReason.class, r100);
    }

    public EndRecordingReason(String r100, int r101) {
        super(r100, r101);
    }
}
