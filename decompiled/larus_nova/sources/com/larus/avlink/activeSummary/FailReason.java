package com.larus.avlink.activeSummary;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/activeSummary/FailReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "SUMMARY_REQUEST_FAIL", "ON_NOT_DISTURB", "TIMEOUT", "OVERWRITTEN", "RESPONSE_INVALID", "EXPERIMENT_OR_SWITCH_OFF", "AUDIO_CONFLICTS", "PRIORITY_SWITCH_OFF", "PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED", "PHONE_SPEAKER", "AUDIO_OUTPUT_NOT_DORA", "OTHER_DEVICE_A2DP_OCCUPIED", "DEVICE_UNLOCKED", "HFP_OCCUPIED", "VUI_DISABLED", "WAKE_MODE_SINGLE_ROUND_ON", "WAKE_MODE_MULTI_ROUND_ON", "IM_TTS_IS_PLAYING", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FailReason extends Enum<FailReason> {
    public static final FailReason AUDIO_CONFLICTS = null;
    public static final FailReason AUDIO_OUTPUT_NOT_DORA = null;
    public static final FailReason DEVICE_UNLOCKED = null;
    public static final FailReason EXPERIMENT_OR_SWITCH_OFF = null;
    public static final FailReason HFP_OCCUPIED = null;
    public static final FailReason IM_TTS_IS_PLAYING = null;
    public static final FailReason ON_NOT_DISTURB = null;
    public static final FailReason OTHER_DEVICE_A2DP_OCCUPIED = null;
    public static final FailReason OVERWRITTEN = null;
    public static final FailReason PHONE_SPEAKER = null;
    public static final FailReason PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED = null;
    public static final FailReason PRIORITY_SWITCH_OFF = null;
    public static final FailReason RESPONSE_INVALID = null;
    public static final FailReason SUMMARY_REQUEST_FAIL = null;
    public static final FailReason TIMEOUT = null;
    public static final FailReason UNKNOWN = null;
    public static final FailReason VUI_DISABLED = null;
    public static final FailReason WAKE_MODE_MULTI_ROUND_ON = null;
    public static final FailReason WAKE_MODE_SINGLE_ROUND_ON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FailReason[] f291415a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291416b = null;
    private final String value;

    public static EnumEntries<FailReason> getEntries() {
        return f291416b;
    }

    static {
        FailReason r100 = new FailReason("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        FailReason r101 = new FailReason("SUMMARY_REQUEST_FAIL", 1, "summary_request_fail");
        SUMMARY_REQUEST_FAIL = r101;
        FailReason r102 = new FailReason("ON_NOT_DISTURB", 2, "on_not_disturb");
        ON_NOT_DISTURB = r102;
        FailReason r103 = new FailReason("TIMEOUT", 3, "timeout");
        TIMEOUT = r103;
        FailReason r104 = new FailReason("OVERWRITTEN", 4, "overwritten");
        OVERWRITTEN = r104;
        FailReason r105 = new FailReason("RESPONSE_INVALID", 5, "response_invalid");
        RESPONSE_INVALID = r105;
        FailReason r110 = new FailReason("EXPERIMENT_OR_SWITCH_OFF", 6, "experiment_or_switch_off");
        EXPERIMENT_OR_SWITCH_OFF = r110;
        FailReason r111 = new FailReason("AUDIO_CONFLICTS", 7, "audio_conflicts");
        AUDIO_CONFLICTS = r111;
        FailReason r112 = new FailReason("PRIORITY_SWITCH_OFF", 8, "priority_switch_off");
        PRIORITY_SWITCH_OFF = r112;
        FailReason r113 = new FailReason("PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED", 9, "priority_other_device_a2dp_occupied");
        PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED = r113;
        FailReason r114 = new FailReason("PHONE_SPEAKER", 10, "phone_speaker");
        PHONE_SPEAKER = r114;
        FailReason r106 = new FailReason("AUDIO_OUTPUT_NOT_DORA", 11, "audio_output_not_dora");
        AUDIO_OUTPUT_NOT_DORA = r106;
        FailReason r107 = new FailReason("OTHER_DEVICE_A2DP_OCCUPIED", 12, "other_device_a2dp_occupied");
        OTHER_DEVICE_A2DP_OCCUPIED = r107;
        FailReason r108 = new FailReason("DEVICE_UNLOCKED", 13, "device_unlocked");
        DEVICE_UNLOCKED = r108;
        FailReason r109 = new FailReason("HFP_OCCUPIED", 14, "hfp_occupied");
        HFP_OCCUPIED = r109;
        FailReason r115 = new FailReason("VUI_DISABLED", 15, "vui_disabled");
        VUI_DISABLED = r115;
        FailReason r116 = new FailReason("WAKE_MODE_SINGLE_ROUND_ON", 16, "wake_mode_single_round_on");
        WAKE_MODE_SINGLE_ROUND_ON = r116;
        FailReason r117 = new FailReason("WAKE_MODE_MULTI_ROUND_ON", 17, "wake_mode_multi_round_on");
        WAKE_MODE_MULTI_ROUND_ON = r117;
        FailReason r118 = new FailReason("IM_TTS_IS_PLAYING", 18, "im_tts_is_playing");
        IM_TTS_IS_PLAYING = r118;
        FailReason[] r119 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118};
        f291415a = r119;
        f291416b = EnumEntriesKt.enumEntries(r119);
    }

    public static FailReason[] values() {
        return (FailReason[]) f291415a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static FailReason valueOf(String r100) {
        return (FailReason) r27.a.a(FailReason.class, r100);
    }

    public FailReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
