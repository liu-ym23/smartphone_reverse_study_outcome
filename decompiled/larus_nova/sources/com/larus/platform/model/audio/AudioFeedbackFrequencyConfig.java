package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006("}, d2 = {"Lcom/larus/platform/model/audio/AudioFeedbackFrequencyConfig;", "", "realtimeCallDurationThreshold", "", "realtimeCallIntervalDays", "realtimeMaxDisplayTimes", "realtimeNoFeedbackTimes", "realtimeNoPopupDays", "ttsIntervalDays", "ttsMaxDisplayTimes", "ttsNoFeedbackTimes", "ttsNoPopupDays", "<init>", "(IIIIIIIII)V", "getRealtimeCallDurationThreshold", "()I", "getRealtimeCallIntervalDays", "getRealtimeMaxDisplayTimes", "getRealtimeNoFeedbackTimes", "getRealtimeNoPopupDays", "getTtsIntervalDays", "getTtsMaxDisplayTimes", "getTtsNoFeedbackTimes", "getTtsNoPopupDays", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioFeedbackFrequencyConfig {

    @SerializedName("realtime_call_duration_threshold")
    private final int realtimeCallDurationThreshold;

    @SerializedName("realtime_call_interval_days")
    private final int realtimeCallIntervalDays;

    @SerializedName("realtime_max_display_times")
    private final int realtimeMaxDisplayTimes;

    @SerializedName("realtime_no_feedback_times")
    private final int realtimeNoFeedbackTimes;

    @SerializedName("realtime_no_popup_days")
    private final int realtimeNoPopupDays;

    @SerializedName("tts_interval_days")
    private final int ttsIntervalDays;

    @SerializedName("tts_max_display_times")
    private final int ttsMaxDisplayTimes;

    @SerializedName("tts_no_feedback_times")
    private final int ttsNoFeedbackTimes;

    @SerializedName("tts_no_popup_days")
    private final int ttsNoPopupDays;

    public AudioFeedbackFrequencyConfig() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, null);
    }

    public static /* synthetic */ AudioFeedbackFrequencyConfig copy$default(AudioFeedbackFrequencyConfig r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.realtimeCallDurationThreshold;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.realtimeCallIntervalDays;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.realtimeMaxDisplayTimes;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = r110.realtimeNoFeedbackTimes;
    L19:
        if ((r210 & 16) == 0) goto L21;
        int r104 = r110.realtimeNoPopupDays;
    L23:
        if ((r210 & 32) == 0) goto L25;
        int r105 = r110.ttsIntervalDays;
    L27:
        if ((r210 & 64) == 0) goto L29;
        int r106 = r110.ttsMaxDisplayTimes;
    L31:
        if ((r210 & 128) == 0) goto L33;
        int r107 = r110.ttsNoFeedbackTimes;
    L35:
        if ((r210 & 256) == 0) goto L37;
        int r108 = r110.ttsNoPopupDays;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.realtimeCallDurationThreshold;
    }

    public final int component2() {
        return this.realtimeCallIntervalDays;
    }

    public final int component3() {
        return this.realtimeMaxDisplayTimes;
    }

    public final int component4() {
        return this.realtimeNoFeedbackTimes;
    }

    public final int component5() {
        return this.realtimeNoPopupDays;
    }

    public final int component6() {
        return this.ttsIntervalDays;
    }

    public final int component7() {
        return this.ttsMaxDisplayTimes;
    }

    public final int component8() {
        return this.ttsNoFeedbackTimes;
    }

    public final int component9() {
        return this.ttsNoPopupDays;
    }

    public final AudioFeedbackFrequencyConfig copy(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r210) {
        return new AudioFeedbackFrequencyConfig(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioFeedbackFrequencyConfig) == true) goto L8;
        return false;
    L8:
        AudioFeedbackFrequencyConfig r101 = (AudioFeedbackFrequencyConfig) r100;
        if (this.realtimeCallDurationThreshold == r101.realtimeCallDurationThreshold) goto L12;
        return false;
    L12:
        if (this.realtimeCallIntervalDays == r101.realtimeCallIntervalDays) goto L15;
        return false;
    L15:
        if (this.realtimeMaxDisplayTimes == r101.realtimeMaxDisplayTimes) goto L18;
        return false;
    L18:
        if (this.realtimeNoFeedbackTimes == r101.realtimeNoFeedbackTimes) goto L21;
        return false;
    L21:
        if (this.realtimeNoPopupDays == r101.realtimeNoPopupDays) goto L24;
        return false;
    L24:
        if (this.ttsIntervalDays == r101.ttsIntervalDays) goto L27;
        return false;
    L27:
        if (this.ttsMaxDisplayTimes == r101.ttsMaxDisplayTimes) goto L30;
        return false;
    L30:
        if (this.ttsNoFeedbackTimes == r101.ttsNoFeedbackTimes) goto L33;
        return false;
    L33:
        if (this.ttsNoPopupDays == r101.ttsNoPopupDays) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((this.realtimeCallDurationThreshold * 31) + this.realtimeCallIntervalDays) * 31) + this.realtimeMaxDisplayTimes) * 31) + this.realtimeNoFeedbackTimes) * 31) + this.realtimeNoPopupDays) * 31) + this.ttsIntervalDays) * 31) + this.ttsMaxDisplayTimes) * 31) + this.ttsNoFeedbackTimes) * 31) + this.ttsNoPopupDays;
    }

    public String toString() {
        return "AudioFeedbackFrequencyConfig(realtimeCallDurationThreshold=" + this.realtimeCallDurationThreshold + ", realtimeCallIntervalDays=" + this.realtimeCallIntervalDays + ", realtimeMaxDisplayTimes=" + this.realtimeMaxDisplayTimes + ", realtimeNoFeedbackTimes=" + this.realtimeNoFeedbackTimes + ", realtimeNoPopupDays=" + this.realtimeNoPopupDays + ", ttsIntervalDays=" + this.ttsIntervalDays + ", ttsMaxDisplayTimes=" + this.ttsMaxDisplayTimes + ", ttsNoFeedbackTimes=" + this.ttsNoFeedbackTimes + ", ttsNoPopupDays=" + this.ttsNoPopupDays + ')';
    }

    public final int getRealtimeCallDurationThreshold() {
        return this.realtimeCallDurationThreshold;
    }

    public final int getRealtimeCallIntervalDays() {
        return this.realtimeCallIntervalDays;
    }

    public final int getRealtimeMaxDisplayTimes() {
        return this.realtimeMaxDisplayTimes;
    }

    public final int getRealtimeNoFeedbackTimes() {
        return this.realtimeNoFeedbackTimes;
    }

    public final int getRealtimeNoPopupDays() {
        return this.realtimeNoPopupDays;
    }

    public final int getTtsIntervalDays() {
        return this.ttsIntervalDays;
    }

    public final int getTtsMaxDisplayTimes() {
        return this.ttsMaxDisplayTimes;
    }

    public final int getTtsNoFeedbackTimes() {
        return this.ttsNoFeedbackTimes;
    }

    public final int getTtsNoPopupDays() {
        return this.ttsNoPopupDays;
    }

    public AudioFeedbackFrequencyConfig(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.realtimeCallDurationThreshold = r100;
        this.realtimeCallIntervalDays = r101;
        this.realtimeMaxDisplayTimes = r102;
        this.realtimeNoFeedbackTimes = r103;
        this.realtimeNoPopupDays = r104;
        this.ttsIntervalDays = r105;
        this.ttsMaxDisplayTimes = r106;
        this.ttsNoFeedbackTimes = r107;
        this.ttsNoPopupDays = r108;
    }

    public /* synthetic */ AudioFeedbackFrequencyConfig(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r210, int r211, DefaultConstructorMarker r212) {
        int r100 = 30;
        if ((r211 & 1) == 0) goto L5;
        int r101 = 30;
    L6:
        int r102 = 3;
        if ((r211 & 2) == 0) goto L9;
        int r103 = 3;
    L10:
        int r104 = 1;
        if ((r211 & 4) == 0) goto L13;
        int r105 = 1;
    L15:
        if ((r211 & 8) == 0) goto L17;
        int r106 = 3;
    L19:
        if ((r211 & 16) == 0) goto L21;
        int r107 = 15;
    L23:
        if ((r211 & 32) == 0) goto L25;
        int r108 = 3;
    L27:
        if ((r211 & 64) != 0) goto L31;
        r104 = r116;
    L31:
        if ((r211 & 128) != 0) goto L35;
        r102 = r117;
    L35:
        if ((r211 & 256) != 0) goto L38;
        r100 = r210;
    L38:
        this(r101, r103, r105, r106, r107, r108, r104, r102, r100);
        return;
    L25:
        r108 = r115;
        goto L27
    L21:
        r107 = r114;
        goto L23
    L17:
        r106 = r113;
        goto L19
    L13:
        r105 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L6
    }
}
