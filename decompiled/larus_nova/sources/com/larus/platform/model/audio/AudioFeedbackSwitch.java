package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/audio/AudioFeedbackSwitch;", "", "realtimeCallEnable", "", "realtimeCallLongPressReplyMessageEnable", "ttsEnable", "<init>", "(ZZZ)V", "getRealtimeCallEnable", "()Z", "getRealtimeCallLongPressReplyMessageEnable", "getTtsEnable", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioFeedbackSwitch {

    @SerializedName("realtime_call_enable")
    private final boolean realtimeCallEnable;

    @SerializedName("realtime_call_long_press_reply_message_enable")
    private final boolean realtimeCallLongPressReplyMessageEnable;

    @SerializedName("tts_enable")
    private final boolean ttsEnable;

    public AudioFeedbackSwitch() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ AudioFeedbackSwitch copy$default(AudioFeedbackSwitch r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.realtimeCallEnable;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.realtimeCallLongPressReplyMessageEnable;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.ttsEnable;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.realtimeCallEnable;
    }

    public final boolean component2() {
        return this.realtimeCallLongPressReplyMessageEnable;
    }

    public final boolean component3() {
        return this.ttsEnable;
    }

    public final AudioFeedbackSwitch copy(boolean r100, boolean r101, boolean r102) {
        return new AudioFeedbackSwitch(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioFeedbackSwitch) == true) goto L8;
        return false;
    L8:
        AudioFeedbackSwitch r101 = (AudioFeedbackSwitch) r100;
        if (this.realtimeCallEnable == r101.realtimeCallEnable) goto L12;
        return false;
    L12:
        if (this.realtimeCallLongPressReplyMessageEnable == r101.realtimeCallLongPressReplyMessageEnable) goto L15;
        return false;
    L15:
        if (this.ttsEnable == r101.ttsEnable) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.realtimeCallEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.realtimeCallLongPressReplyMessageEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.ttsEnable == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "AudioFeedbackSwitch(realtimeCallEnable=" + this.realtimeCallEnable + ", realtimeCallLongPressReplyMessageEnable=" + this.realtimeCallLongPressReplyMessageEnable + ", ttsEnable=" + this.ttsEnable + ')';
    }

    public final boolean getRealtimeCallEnable() {
        return this.realtimeCallEnable;
    }

    public final boolean getRealtimeCallLongPressReplyMessageEnable() {
        return this.realtimeCallLongPressReplyMessageEnable;
    }

    public final boolean getTtsEnable() {
        return this.ttsEnable;
    }

    public AudioFeedbackSwitch(boolean r100, boolean r101, boolean r102) {
        this.realtimeCallEnable = r100;
        this.realtimeCallLongPressReplyMessageEnable = r101;
        this.ttsEnable = r102;
    }

    public /* synthetic */ AudioFeedbackSwitch(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
