package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b \b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001*BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J[\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015¨\u0006+"}, d2 = {"Lcom/larus/platform/model/HandsfreeExperimentConfig;", "", "micClickBehavior", "", "handsfreeAsrEndBehavior", "", "longPressLockEnabled", "", "voiceInputClickEnabled", "cancelIconStyle", "maxAudioDurationMs", "", "foregroundServiceEnabled", "handsfreeLayerDisableGesture", "<init>", "(ILjava/lang/String;ZZIJZZ)V", "getMicClickBehavior", "()I", "getHandsfreeAsrEndBehavior", "()Ljava/lang/String;", "getLongPressLockEnabled", "()Z", "getVoiceInputClickEnabled", "getCancelIconStyle", "getMaxAudioDurationMs", "()J", "getForegroundServiceEnabled", "getHandsfreeLayerDisableGesture", "isHandsfreeSupported", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HandsfreeExperimentConfig {
    public static final String ASR_END_BACKFILL = "backfill";
    public static final String ASR_END_SEND = "send";
    public static final int CANCEL_ICON_CROSS = 1;
    public static final int CANCEL_ICON_TRASH = 0;
    public static final a Companion = null;
    public static final int MIC_CLICK_ENTER_HANDSFREE = 1;
    public static final int MIC_CLICK_SWITCH_VOICE_INPUT = 0;

    @SerializedName("cancel_icon_style")
    private final int cancelIconStyle;

    @SerializedName("foreground_service_enabled")
    private final boolean foregroundServiceEnabled;

    @SerializedName("handsfree_asr_end_behavior")
    private final String handsfreeAsrEndBehavior;

    @SerializedName("handsfree_layer_disable_gesture")
    private final boolean handsfreeLayerDisableGesture;

    @SerializedName("long_press_lock_enabled")
    private final boolean longPressLockEnabled;

    @SerializedName("max_audio_duration_ms")
    private final long maxAudioDurationMs;

    @SerializedName("mic_click_behavior")
    private final int micClickBehavior;

    @SerializedName("voice_input_click_enabled")
    private final boolean voiceInputClickEnabled;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public HandsfreeExperimentConfig() {
        this(0, null, false, false, 0, 0, false, false, 255, null);
    }

    public static /* synthetic */ HandsfreeExperimentConfig copy$default(HandsfreeExperimentConfig r110, int r111, String r112, boolean r113, boolean r114, int r115, long r116, boolean r117, boolean r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.micClickBehavior;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.handsfreeAsrEndBehavior;
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r102 = r110.longPressLockEnabled;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r103 = r110.voiceInputClickEnabled;
    L19:
        if ((r210 & 16) == 0) goto L21;
        int r104 = r110.cancelIconStyle;
    L23:
        if ((r210 & 32) == 0) goto L25;
        long r105 = r110.maxAudioDurationMs;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r106 = r110.foregroundServiceEnabled;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r107 = r110.handsfreeLayerDisableGesture;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
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
        return this.micClickBehavior;
    }

    public final String component2() {
        return this.handsfreeAsrEndBehavior;
    }

    public final boolean component3() {
        return this.longPressLockEnabled;
    }

    public final boolean component4() {
        return this.voiceInputClickEnabled;
    }

    public final int component5() {
        return this.cancelIconStyle;
    }

    public final long component6() {
        return this.maxAudioDurationMs;
    }

    public final boolean component7() {
        return this.foregroundServiceEnabled;
    }

    public final boolean component8() {
        return this.handsfreeLayerDisableGesture;
    }

    public final HandsfreeExperimentConfig copy(int r110, String r111, boolean r112, boolean r113, int r114, long r115, boolean r116, boolean r210) {
        return new HandsfreeExperimentConfig(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HandsfreeExperimentConfig) == true) goto L8;
        return false;
    L8:
        HandsfreeExperimentConfig r101 = (HandsfreeExperimentConfig) r100;
        if (this.micClickBehavior == r101.micClickBehavior) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.handsfreeAsrEndBehavior, r101.handsfreeAsrEndBehavior) == true) goto L15;
        return false;
    L15:
        if (this.longPressLockEnabled == r101.longPressLockEnabled) goto L18;
        return false;
    L18:
        if (this.voiceInputClickEnabled == r101.voiceInputClickEnabled) goto L21;
        return false;
    L21:
        if (this.cancelIconStyle == r101.cancelIconStyle) goto L24;
        return false;
    L24:
        if (this.maxAudioDurationMs == r101.maxAudioDurationMs) goto L27;
        return false;
    L27:
        if (this.foregroundServiceEnabled == r101.foregroundServiceEnabled) goto L30;
        return false;
    L30:
        if (this.handsfreeLayerDisableGesture == r101.handsfreeLayerDisableGesture) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = this.micClickBehavior * 31;
        String r101 = this.handsfreeAsrEndBehavior;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.longPressLockEnabled == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.voiceInputClickEnabled == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (((r106 + r107) * 31) + this.cancelIconStyle) * 31;
        long r109 = this.maxAudioDurationMs;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        if (this.foregroundServiceEnabled == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        if (this.handsfreeLayerDisableGesture == true) goto L23;
        r104 = 1237;
    L23:
        return r112 + r104;
    L17:
        r111 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "HandsfreeExperimentConfig(micClickBehavior=" + this.micClickBehavior + ", handsfreeAsrEndBehavior=" + this.handsfreeAsrEndBehavior + ", longPressLockEnabled=" + this.longPressLockEnabled + ", voiceInputClickEnabled=" + this.voiceInputClickEnabled + ", cancelIconStyle=" + this.cancelIconStyle + ", maxAudioDurationMs=" + this.maxAudioDurationMs + ", foregroundServiceEnabled=" + this.foregroundServiceEnabled + ", handsfreeLayerDisableGesture=" + this.handsfreeLayerDisableGesture + ')';
    }

    public final boolean isHandsfreeSupported() {
        if (this.micClickBehavior != 1) goto L5;
        return true;
    L5:
        if (this.longPressLockEnabled == false) goto L7;
        return true;
    L7:
        if (this.voiceInputClickEnabled == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int getCancelIconStyle() {
        return this.cancelIconStyle;
    }

    public final boolean getForegroundServiceEnabled() {
        return this.foregroundServiceEnabled;
    }

    public final String getHandsfreeAsrEndBehavior() {
        return this.handsfreeAsrEndBehavior;
    }

    public final boolean getHandsfreeLayerDisableGesture() {
        return this.handsfreeLayerDisableGesture;
    }

    public final boolean getLongPressLockEnabled() {
        return this.longPressLockEnabled;
    }

    public final long getMaxAudioDurationMs() {
        return this.maxAudioDurationMs;
    }

    public final int getMicClickBehavior() {
        return this.micClickBehavior;
    }

    public final boolean getVoiceInputClickEnabled() {
        return this.voiceInputClickEnabled;
    }

    public HandsfreeExperimentConfig(int r100, String r101, boolean r102, boolean r103, int r104, long r105, boolean r106, boolean r107) {
        this.micClickBehavior = r100;
        this.handsfreeAsrEndBehavior = r101;
        this.longPressLockEnabled = r102;
        this.voiceInputClickEnabled = r103;
        this.cancelIconStyle = r104;
        this.maxAudioDurationMs = r105;
        this.foregroundServiceEnabled = r106;
        this.handsfreeLayerDisableGesture = r107;
    }

    public /* synthetic */ HandsfreeExperimentConfig(int r110, String r111, boolean r112, boolean r113, int r114, long r115, boolean r116, boolean r117, int r210, DefaultConstructorMarker r211) {
        boolean r100 = false;
        if ((r210 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = "send";
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r210 & 16) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r210 & 32) == 0) goto L25;
        long r106 = 300000;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r107 = true;
    L31:
        if ((r210 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
