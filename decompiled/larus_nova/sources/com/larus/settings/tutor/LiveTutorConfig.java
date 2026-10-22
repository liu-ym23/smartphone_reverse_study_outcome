package com.larus.settings.tutor;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bù\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a\u0012\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\bHÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\u0013\u0010L\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aHÆ\u0003J\u0013\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aHÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003Jû\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u0003HÆ\u0001J\u0013\u0010P\u001a\u00020\b2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0005HÖ\u0001J\t\u0010S\u001a\u00020THÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010&R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010&R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0016\u0010\u0016\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0016\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R \u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R \u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00106R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010!¨\u0006U"}, d2 = {"Lcom/larus/settings/tutor/LiveTutorConfig;", "", "feedbackTime", "", "feedbackDayLimit", "", "feedbackCloseCd", "voiceCheckSkipDayLimit", "", "defaultSubtitleState", "isSupportCopyDebugInfo", "uploadALogConfig", "Lcom/larus/settings/tutor/UploadALogConfig;", "backLeaveRoomTimeout", "longWaitingTimeout", "isShowLimitTimeFree", "shortPressTimeout", "longPressTimeout", "longAsrSubmitTimeout", "longBoardGenerateTimeout", "connectingTimeoutMs", "rtcHeartRateIntervalMs", "enableSubtitleFlush", "lottiePlayLevel", "maxBitmapSize", "ttsPitchList", "", "Lcom/larus/settings/tutor/VoiceConfig;", "ttsSpeedList", "liveTutorHeartRateIntervalMs", "<init>", "(JIJZZZLcom/larus/settings/tutor/UploadALogConfig;JJZJJJJJJZIILjava/util/List;Ljava/util/List;J)V", "getFeedbackTime", "()J", "getFeedbackDayLimit", "()I", "getFeedbackCloseCd", "getVoiceCheckSkipDayLimit", "()Z", "getDefaultSubtitleState", "getUploadALogConfig", "()Lcom/larus/settings/tutor/UploadALogConfig;", "getBackLeaveRoomTimeout", "getLongWaitingTimeout", "getShortPressTimeout", "getLongPressTimeout", "getLongAsrSubmitTimeout", "getLongBoardGenerateTimeout", "getConnectingTimeoutMs", "getRtcHeartRateIntervalMs", "getEnableSubtitleFlush", "getLottiePlayLevel", "getMaxBitmapSize", "getTtsPitchList", "()Ljava/util/List;", "getTtsSpeedList", "getLiveTutorHeartRateIntervalMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorConfig {

    @SerializedName("back_leave_room_timeout")
    private final long backLeaveRoomTimeout;

    @SerializedName("connecting_timeout_ms")
    private final long connectingTimeoutMs;

    @SerializedName("default_subtitle_state")
    private final boolean defaultSubtitleState;

    @SerializedName("render_subtitle_no_flush")
    private final boolean enableSubtitleFlush;

    @SerializedName("feedback_close_cd")
    private final long feedbackCloseCd;

    @SerializedName("feedback_day_limit")
    private final int feedbackDayLimit;

    @SerializedName("feedback_time")
    private final long feedbackTime;

    @SerializedName("is_show_limit_time_free")
    private final boolean isShowLimitTimeFree;

    @SerializedName("is_support_copy_debug_info")
    private final boolean isSupportCopyDebugInfo;

    @SerializedName("stay_page_heart_rate_interval_ms")
    private final long liveTutorHeartRateIntervalMs;

    @SerializedName("long_asr_submit_timeout")
    private final long longAsrSubmitTimeout;

    @SerializedName("long_board_generate_timeout")
    private final long longBoardGenerateTimeout;

    @SerializedName("long_press_timeout")
    private final long longPressTimeout;

    @SerializedName("long_waiting_timeout")
    private final long longWaitingTimeout;

    @SerializedName("lottie_play_level")
    private final int lottiePlayLevel;

    @SerializedName("max_bitmap_size")
    private final int maxBitmapSize;

    @SerializedName("rtc_heart_rate_interval_ms")
    private final long rtcHeartRateIntervalMs;

    @SerializedName("short_press_timeout_ms")
    private final long shortPressTimeout;

    @SerializedName("tts_pitch_list")
    private final List<VoiceConfig> ttsPitchList;

    @SerializedName("tts_speed_list")
    private final List<VoiceConfig> ttsSpeedList;

    @SerializedName("upload_alog_config")
    private final UploadALogConfig uploadALogConfig;

    @SerializedName("voice_check_skip_day_limit")
    private final boolean voiceCheckSkipDayLimit;

    public LiveTutorConfig() {
        this(0, 0, 0, false, false, false, null, 0, 0, false, 0, 0, 0, 0, 0, 0, false, 0, 0, null, null, 0, 4194303, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveTutorConfig copy$default(LiveTutorConfig r110, long r111, int r210, long r211, boolean r212, boolean r213, boolean r214, UploadALogConfig r215, long r216, long r217, boolean r310, long r311, long r312, long r313, long r314, long r410, long r411, boolean r412, int r413, int r414, List r415, List r416, long r417, int r510, Object r511) {
        if ((r510 & 1) == 0) goto L5;
        long r100 = r110.feedbackTime;
    L7:
        if ((r510 & 2) == 0) goto L9;
        int r101 = r110.feedbackDayLimit;
    L11:
        if ((r510 & 4) == 0) goto L13;
        long r102 = r110.feedbackCloseCd;
    L15:
        if ((r510 & 8) == 0) goto L17;
        boolean r103 = r110.voiceCheckSkipDayLimit;
    L19:
        if ((r510 & 16) == 0) goto L21;
        boolean r104 = r110.defaultSubtitleState;
    L23:
        if ((r510 & 32) == 0) goto L25;
        boolean r105 = r110.isSupportCopyDebugInfo;
    L27:
        if ((r510 & 64) == 0) goto L29;
        UploadALogConfig r112 = r110.uploadALogConfig;
    L31:
        if ((r510 & 128) == 0) goto L33;
        long r113 = r110.backLeaveRoomTimeout;
    L35:
        if ((r510 & 256) == 0) goto L37;
        long r114 = r110.longWaitingTimeout;
    L39:
        if ((r510 & 512) == 0) goto L41;
        boolean r115 = r110.isShowLimitTimeFree;
    L42:
        boolean r315 = r115;
        long r218 = r114;
        if ((r510 & 1024) == 0) goto L45;
        long r116 = r110.shortPressTimeout;
    L46:
        long r316 = r116;
        if ((r510 & 2048) == 0) goto L49;
        long r117 = r110.longPressTimeout;
    L50:
        long r317 = r117;
        if ((r510 & 4096) == 0) goto L53;
        long r118 = r110.longAsrSubmitTimeout;
    L54:
        long r318 = r118;
        if ((r510 & 8192) == 0) goto L57;
        long r119 = r110.longBoardGenerateTimeout;
    L58:
        long r319 = r119;
        if ((r510 & 16384) == 0) goto L61;
        long r120 = r110.connectingTimeoutMs;
    L62:
        long r418 = r120;
        if ((32768 & r510) == 0) goto L65;
        long r121 = r110.rtcHeartRateIntervalMs;
    L67:
        if ((65536 & r510) == 0) goto L69;
        boolean r122 = r110.enableSubtitleFlush;
    L70:
        boolean r419 = r122;
        if ((r510 & 131072) == 0) goto L73;
        int r123 = r110.lottiePlayLevel;
    L74:
        int r420 = r123;
        if ((r510 & 262144) == 0) goto L77;
        int r124 = r110.maxBitmapSize;
    L78:
        int r421 = r124;
        if ((r510 & 524288) == 0) goto L81;
        List r125 = r110.ttsPitchList;
    L82:
        List r422 = r125;
        if ((r510 & 1048576) == 0) goto L85;
        List r126 = r110.ttsSpeedList;
    L86:
        long r423 = r121;
        if ((r510 & 2097152) == 0) goto L89;
        long r127 = r110.liveTutorHeartRateIntervalMs;
    L91:
        return r110.copy(r100, r101, r102, r103, r104, r105, r112, r113, r218, r315, r316, r317, r318, r319, r418, r423, r419, r420, r421, r422, r126, r127);
    L89:
        r127 = r417;
        goto L91
    L85:
        r126 = r416;
        goto L86
    L81:
        r125 = r415;
        goto L82
    L77:
        r124 = r414;
        goto L78
    L73:
        r123 = r413;
        goto L74
    L69:
        r122 = r412;
        goto L70
    L65:
        r121 = r411;
        goto L67
    L61:
        r120 = r410;
        goto L62
    L57:
        r119 = r314;
        goto L58
    L53:
        r118 = r313;
        goto L54
    L49:
        r117 = r312;
        goto L50
    L45:
        r116 = r311;
        goto L46
    L41:
        r115 = r310;
        goto L42
    L37:
        r114 = r217;
        goto L39
    L33:
        r113 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.feedbackTime;
    }

    public final boolean component10() {
        return this.isShowLimitTimeFree;
    }

    public final long component11() {
        return this.shortPressTimeout;
    }

    public final long component12() {
        return this.longPressTimeout;
    }

    public final long component13() {
        return this.longAsrSubmitTimeout;
    }

    public final long component14() {
        return this.longBoardGenerateTimeout;
    }

    public final long component15() {
        return this.connectingTimeoutMs;
    }

    public final long component16() {
        return this.rtcHeartRateIntervalMs;
    }

    public final boolean component17() {
        return this.enableSubtitleFlush;
    }

    public final int component18() {
        return this.lottiePlayLevel;
    }

    public final int component19() {
        return this.maxBitmapSize;
    }

    public final int component2() {
        return this.feedbackDayLimit;
    }

    public final List<VoiceConfig> component20() {
        return this.ttsPitchList;
    }

    public final List<VoiceConfig> component21() {
        return this.ttsSpeedList;
    }

    public final long component22() {
        return this.liveTutorHeartRateIntervalMs;
    }

    public final long component3() {
        return this.feedbackCloseCd;
    }

    public final boolean component4() {
        return this.voiceCheckSkipDayLimit;
    }

    public final boolean component5() {
        return this.defaultSubtitleState;
    }

    public final boolean component6() {
        return this.isSupportCopyDebugInfo;
    }

    public final UploadALogConfig component7() {
        return this.uploadALogConfig;
    }

    public final long component8() {
        return this.backLeaveRoomTimeout;
    }

    public final long component9() {
        return this.longWaitingTimeout;
    }

    public final LiveTutorConfig copy(long r310, int r311, long r312, boolean r410, boolean r411, boolean r412, UploadALogConfig r413, long r414, long r415, boolean r416, long r510, long r511, long r512, long r513, long r514, long r610, boolean r611, int r612, int r613, List<VoiceConfig> r614, List<VoiceConfig> r615, long r616) {
        return new LiveTutorConfig(r310, r311, r312, r410, r411, r412, r413, r414, r415, r416, r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r615, r616);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveTutorConfig) == true) goto L8;
        return false;
    L8:
        LiveTutorConfig r101 = (LiveTutorConfig) r100;
        if (this.feedbackTime == r101.feedbackTime) goto L12;
        return false;
    L12:
        if (this.feedbackDayLimit == r101.feedbackDayLimit) goto L15;
        return false;
    L15:
        if (this.feedbackCloseCd == r101.feedbackCloseCd) goto L18;
        return false;
    L18:
        if (this.voiceCheckSkipDayLimit == r101.voiceCheckSkipDayLimit) goto L21;
        return false;
    L21:
        if (this.defaultSubtitleState == r101.defaultSubtitleState) goto L24;
        return false;
    L24:
        if (this.isSupportCopyDebugInfo == r101.isSupportCopyDebugInfo) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.uploadALogConfig, r101.uploadALogConfig) == true) goto L30;
        return false;
    L30:
        if (this.backLeaveRoomTimeout == r101.backLeaveRoomTimeout) goto L33;
        return false;
    L33:
        if (this.longWaitingTimeout == r101.longWaitingTimeout) goto L36;
        return false;
    L36:
        if (this.isShowLimitTimeFree == r101.isShowLimitTimeFree) goto L39;
        return false;
    L39:
        if (this.shortPressTimeout == r101.shortPressTimeout) goto L42;
        return false;
    L42:
        if (this.longPressTimeout == r101.longPressTimeout) goto L45;
        return false;
    L45:
        if (this.longAsrSubmitTimeout == r101.longAsrSubmitTimeout) goto L48;
        return false;
    L48:
        if (this.longBoardGenerateTimeout == r101.longBoardGenerateTimeout) goto L51;
        return false;
    L51:
        if (this.connectingTimeoutMs == r101.connectingTimeoutMs) goto L54;
        return false;
    L54:
        if (this.rtcHeartRateIntervalMs == r101.rtcHeartRateIntervalMs) goto L57;
        return false;
    L57:
        if (this.enableSubtitleFlush == r101.enableSubtitleFlush) goto L60;
        return false;
    L60:
        if (this.lottiePlayLevel == r101.lottiePlayLevel) goto L63;
        return false;
    L63:
        if (this.maxBitmapSize == r101.maxBitmapSize) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.ttsPitchList, r101.ttsPitchList) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.ttsSpeedList, r101.ttsSpeedList) == true) goto L72;
        return false;
    L72:
        if (this.liveTutorHeartRateIntervalMs == r101.liveTutorHeartRateIntervalMs) goto L74;
        return false;
    L74:
        return true;
    }

    public int hashCode() {
        long r100 = this.feedbackTime;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.feedbackDayLimit) * 31;
        long r102 = this.feedbackCloseCd;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        int r104 = 1231;
        if (this.voiceCheckSkipDayLimit == false) goto L5;
        int r105 = 1231;
    L6:
        int r106 = (r103 + r105) * 31;
        if (this.defaultSubtitleState == false) goto L9;
        int r107 = 1231;
    L10:
        int r108 = (r106 + r107) * 31;
        if (this.isSupportCopyDebugInfo == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r108 + r109) * 31;
        UploadALogConfig r111 = this.uploadALogConfig;
        int r112 = 0;
        if (r111 != null) goto L17;
        int r113 = 0;
    L18:
        long r114 = this.backLeaveRoomTimeout;
        int r115 = (((r110 + r113) * 31) + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = this.longWaitingTimeout;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        if (this.isShowLimitTimeFree == false) goto L21;
        int r118 = 1231;
    L22:
        long r119 = this.shortPressTimeout;
        int r120 = (((r117 + r118) * 31) + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.longPressTimeout;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = this.longAsrSubmitTimeout;
        int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        long r125 = this.longBoardGenerateTimeout;
        int r126 = (r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31;
        long r127 = this.connectingTimeoutMs;
        int r128 = (r126 + ((int) (r127 ^ (r127 >>> 32)))) * 31;
        long r129 = this.rtcHeartRateIntervalMs;
        int r130 = (r128 + ((int) (r129 ^ (r129 >>> 32)))) * 31;
        if (this.enableSubtitleFlush == true) goto L26;
        r104 = 1237;
    L26:
        int r131 = (((((r130 + r104) * 31) + this.lottiePlayLevel) * 31) + this.maxBitmapSize) * 31;
        List<VoiceConfig> r132 = this.ttsPitchList;
        if (r132 != null) goto L29;
        int r133 = 0;
    L30:
        int r134 = (r131 + r133) * 31;
        List<VoiceConfig> r135 = this.ttsSpeedList;
        if (r135 == null) goto L34;
        r112 = r135.hashCode();
    L34:
        long r136 = this.liveTutorHeartRateIntervalMs;
        return ((r134 + r112) * 31) + ((int) (r136 ^ (r136 >>> 32)));
    L29:
        r133 = r132.hashCode();
        goto L30
    L21:
        r118 = 1237;
        goto L22
    L17:
        r113 = r111.hashCode();
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r107 = 1237;
        goto L10
    L5:
        r105 = 1237;
        goto L6
    }

    public String toString() {
        return "LiveTutorConfig(feedbackTime=" + this.feedbackTime + ", feedbackDayLimit=" + this.feedbackDayLimit + ", feedbackCloseCd=" + this.feedbackCloseCd + ", voiceCheckSkipDayLimit=" + this.voiceCheckSkipDayLimit + ", defaultSubtitleState=" + this.defaultSubtitleState + ", isSupportCopyDebugInfo=" + this.isSupportCopyDebugInfo + ", uploadALogConfig=" + this.uploadALogConfig + ", backLeaveRoomTimeout=" + this.backLeaveRoomTimeout + ", longWaitingTimeout=" + this.longWaitingTimeout + ", isShowLimitTimeFree=" + this.isShowLimitTimeFree + ", shortPressTimeout=" + this.shortPressTimeout + ", longPressTimeout=" + this.longPressTimeout + ", longAsrSubmitTimeout=" + this.longAsrSubmitTimeout + ", longBoardGenerateTimeout=" + this.longBoardGenerateTimeout + ", connectingTimeoutMs=" + this.connectingTimeoutMs + ", rtcHeartRateIntervalMs=" + this.rtcHeartRateIntervalMs + ", enableSubtitleFlush=" + this.enableSubtitleFlush + ", lottiePlayLevel=" + this.lottiePlayLevel + ", maxBitmapSize=" + this.maxBitmapSize + ", ttsPitchList=" + this.ttsPitchList + ", ttsSpeedList=" + this.ttsSpeedList + ", liveTutorHeartRateIntervalMs=" + this.liveTutorHeartRateIntervalMs + ')';
    }

    public final long getBackLeaveRoomTimeout() {
        return this.backLeaveRoomTimeout;
    }

    public final long getConnectingTimeoutMs() {
        return this.connectingTimeoutMs;
    }

    public final boolean getDefaultSubtitleState() {
        return this.defaultSubtitleState;
    }

    public final boolean getEnableSubtitleFlush() {
        return this.enableSubtitleFlush;
    }

    public final long getFeedbackCloseCd() {
        return this.feedbackCloseCd;
    }

    public final int getFeedbackDayLimit() {
        return this.feedbackDayLimit;
    }

    public final long getFeedbackTime() {
        return this.feedbackTime;
    }

    public final long getLiveTutorHeartRateIntervalMs() {
        return this.liveTutorHeartRateIntervalMs;
    }

    public final long getLongAsrSubmitTimeout() {
        return this.longAsrSubmitTimeout;
    }

    public final long getLongBoardGenerateTimeout() {
        return this.longBoardGenerateTimeout;
    }

    public final long getLongPressTimeout() {
        return this.longPressTimeout;
    }

    public final long getLongWaitingTimeout() {
        return this.longWaitingTimeout;
    }

    public final int getLottiePlayLevel() {
        return this.lottiePlayLevel;
    }

    public final int getMaxBitmapSize() {
        return this.maxBitmapSize;
    }

    public final long getRtcHeartRateIntervalMs() {
        return this.rtcHeartRateIntervalMs;
    }

    public final long getShortPressTimeout() {
        return this.shortPressTimeout;
    }

    public final List<VoiceConfig> getTtsPitchList() {
        return this.ttsPitchList;
    }

    public final List<VoiceConfig> getTtsSpeedList() {
        return this.ttsSpeedList;
    }

    public final UploadALogConfig getUploadALogConfig() {
        return this.uploadALogConfig;
    }

    public final boolean getVoiceCheckSkipDayLimit() {
        return this.voiceCheckSkipDayLimit;
    }

    public final boolean isShowLimitTimeFree() {
        return this.isShowLimitTimeFree;
    }

    public final boolean isSupportCopyDebugInfo() {
        return this.isSupportCopyDebugInfo;
    }

    public LiveTutorConfig(long r100, int r101, long r102, boolean r103, boolean r110, boolean r111, UploadALogConfig r112, long r113, long r114, boolean r115, long r116, long r210, long r211, long r212, long r213, long r214, boolean r310, int r311, int r312, List<VoiceConfig> r313, List<VoiceConfig> r314, long r315) {
        this.feedbackTime = r100;
        this.feedbackDayLimit = r101;
        this.feedbackCloseCd = r102;
        this.voiceCheckSkipDayLimit = r103;
        this.defaultSubtitleState = r110;
        this.isSupportCopyDebugInfo = r111;
        this.uploadALogConfig = r112;
        this.backLeaveRoomTimeout = r113;
        this.longWaitingTimeout = r114;
        this.isShowLimitTimeFree = r115;
        this.shortPressTimeout = r116;
        this.longPressTimeout = r210;
        this.longAsrSubmitTimeout = r211;
        this.longBoardGenerateTimeout = r212;
        this.connectingTimeoutMs = r213;
        this.rtcHeartRateIntervalMs = r214;
        this.enableSubtitleFlush = r310;
        this.lottiePlayLevel = r311;
        this.maxBitmapSize = r312;
        this.ttsPitchList = r313;
        this.ttsSpeedList = r314;
        this.liveTutorHeartRateIntervalMs = r315;
    }

    public LiveTutorConfig(long r310, int r311, long r312, boolean r410, boolean r411, boolean r412, UploadALogConfig r413, long r414, long r415, boolean r416, long r510, long r511, long r512, long r513, long r514, long r610, boolean r611, int r612, int r613, List r614, List r615, long r616, int r617, DefaultConstructorMarker r710) {
        if ((r617 & 1) == 0) goto L5;
        long r100 = 60;
    L7:
        if ((r617 & 2) == 0) goto L9;
        int r101 = 1;
    L11:
        if ((r617 & 4) == 0) goto L13;
        long r102 = 172800;
    L14:
        int r103 = 0;
        if ((r617 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r617 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r617 & 32) == 0) goto L25;
        boolean r110 = true;
    L27:
        if ((r617 & 64) == 0) goto L29;
        UploadALogConfig r111 = null;
    L31:
        if ((r617 & 128) == 0) goto L33;
        long r112 = 18000;
    L34:
        long r113 = 15000;
        if ((r617 & 256) == 0) goto L37;
        long r114 = 15000;
    L39:
        if ((r617 & 512) == 0) goto L41;
        boolean r115 = true;
    L43:
        if ((r617 & 1024) == 0) goto L45;
        long r116 = 500;
    L47:
        if ((r617 & 2048) == 0) goto L49;
        long r210 = 120000;
    L51:
        if ((r617 & 4096) == 0) goto L53;
        long r211 = 3000;
    L54:
        long r212 = 10000;
        if ((r617 & 8192) == 0) goto L57;
        long r213 = 10000;
    L59:
        if ((r617 & 16384) != 0) goto L63;
        r113 = r514;
    L63:
        if ((32768 & r617) == 0) goto L65;
        long r214 = 1000;
    L67:
        if ((65536 & r617) == 0) goto L69;
        boolean r106 = true;
    L71:
        if ((r617 & 131072) != 0) goto L75;
        r103 = r612;
    L75:
        if ((r617 & 262144) == 0) goto L77;
        int r313 = 4096;
    L79:
        if ((r617 & 524288) == 0) goto L81;
        List r314 = b.f368559a;
    L83:
        if ((r617 & 1048576) == 0) goto L85;
        List r315 = b.f368560b;
    L87:
        if ((r617 & 2097152) != 0) goto L90;
        r212 = r616;
    L90:
        this(r100, r101, r102, r104, r105, r110, r111, r112, r114, r115, r116, r210, r211, r213, r113, r214, r106, r103, r313, r314, r315, r212);
        return;
    L85:
        r315 = r615;
        goto L87
    L81:
        r314 = r614;
        goto L83
    L77:
        r313 = r613;
        goto L79
    L69:
        r106 = r611;
        goto L71
    L65:
        r214 = r610;
        goto L67
    L57:
        r213 = r513;
        goto L59
    L53:
        r211 = r512;
        goto L54
    L49:
        r210 = r511;
        goto L51
    L45:
        r116 = r510;
        goto L47
    L41:
        r115 = r416;
        goto L43
    L37:
        r114 = r415;
        goto L39
    L33:
        r112 = r414;
        goto L34
    L29:
        r111 = r413;
        goto L31
    L25:
        r110 = r412;
        goto L27
    L21:
        r105 = r411;
        goto L23
    L17:
        r104 = r410;
        goto L19
    L13:
        r102 = r312;
        goto L14
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
