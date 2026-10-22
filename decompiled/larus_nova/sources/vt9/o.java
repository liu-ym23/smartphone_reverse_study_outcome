package vt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bë\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0017HÆ\u0003Jò\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020HHÖ\u0001J\t\u0010I\u001a\u00020JHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u0006\u0010\u001bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001bR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b$\u0010\u001bR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b%\u0010\u001bR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b&\u0010\u001bR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b'\u0010\u001bR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b(\u0010\u001bR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b)\u0010\u001bR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b*\u0010\u001bR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b+\u0010\u001bR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b,\u0010\u001bR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b-\u0010\u001bR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006K"}, d2 = {"Lcom/larus/settings/provider/audio/AudioTechConfig;", "", "postStartRealtimeWithChat", "", "enableCancelTtsOnTimeout", "realtimeDelayStartConnect", "isPadForcePortrait", "streamPlayerChunkOptEnable", "streamPlayerTechConfig", "Lcom/larus/platform/model/AudioStreamPlayerTechConfig;", "enableScreenShareOpt", "enableShareScreenToChildThread", "fixRtcFirstAecLoss", "fixSubtitleTtsWaitingEnable", "fixVlmStateEnable", "fixPipVideoModeEnable", "fixVePermissionProblem", "fixAudioLandingEnable", "enableRealtimeSubtitleQueueOpt", "enableFixStreamPlayer", "enableVideoWindowOpt", "enableSmallWindowFix", "realtimeAnimRenderOpt", "Lcom/larus/settings/provider/audio/AudioAnimRenderOpt;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/platform/model/AudioStreamPlayerTechConfig;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/settings/provider/audio/AudioAnimRenderOpt;)V", "getPostStartRealtimeWithChat", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableCancelTtsOnTimeout", "getRealtimeDelayStartConnect", "getStreamPlayerChunkOptEnable", "getStreamPlayerTechConfig", "()Lcom/larus/platform/model/AudioStreamPlayerTechConfig;", "getEnableScreenShareOpt", "getEnableShareScreenToChildThread", "getFixRtcFirstAecLoss", "getFixSubtitleTtsWaitingEnable", "getFixVlmStateEnable", "getFixPipVideoModeEnable", "getFixVePermissionProblem", "getFixAudioLandingEnable", "getEnableRealtimeSubtitleQueueOpt", "getEnableFixStreamPlayer", "getEnableVideoWindowOpt", "getEnableSmallWindowFix", "getRealtimeAnimRenderOpt", "()Lcom/larus/settings/provider/audio/AudioAnimRenderOpt;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/platform/model/AudioStreamPlayerTechConfig;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/settings/provider/audio/AudioAnimRenderOpt;)Lcom/larus/settings/provider/audio/AudioTechConfig;", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    @SerializedName("enable_cancel_tts_on_timeout")
    private final Boolean enableCancelTtsOnTimeout;

    @SerializedName("enable_fix_stream_player")
    private final Boolean enableFixStreamPlayer;

    @SerializedName("enable_realtime_subtitle_queue_opt")
    private final Boolean enableRealtimeSubtitleQueueOpt;

    @SerializedName("enable_screen_share_opt")
    private final Boolean enableScreenShareOpt;

    @SerializedName("enable_share_screen_to_child_thread")
    private final Boolean enableShareScreenToChildThread;

    @SerializedName("enable_small_window_fix")
    private final Boolean enableSmallWindowFix;

    @SerializedName("enable_video_window_opt")
    private final Boolean enableVideoWindowOpt;

    @SerializedName("fix_audio_landing_enable")
    private final Boolean fixAudioLandingEnable;

    @SerializedName("fix_pip_video_mode_enable")
    private final Boolean fixPipVideoModeEnable;

    @SerializedName("fix_rtc_first_aec_loss")
    private final Boolean fixRtcFirstAecLoss;

    @SerializedName("fix_subtitle_tts_waiting_enable")
    private final Boolean fixSubtitleTtsWaitingEnable;

    @SerializedName("fix_ve_permission_problem")
    private final Boolean fixVePermissionProblem;

    @SerializedName("fix_vlm_state_enable")
    private final Boolean fixVlmStateEnable;

    @SerializedName("is_pad_force_portrait")
    private final Boolean isPadForcePortrait;

    @SerializedName("post_start_realtime_with_chat")
    private final Boolean postStartRealtimeWithChat;

    @SerializedName("realtime_anim_render_opt")
    private final f realtimeAnimRenderOpt;

    @SerializedName("realtime_delay_start_connect")
    private final Boolean realtimeDelayStartConnect;

    @SerializedName("stream_player_chunk_opt_enable")
    private final Boolean streamPlayerChunkOptEnable;

    @SerializedName("stream_player_tech_config")
    private final hq9.t streamPlayerTechConfig;

    public o() {
        this(null, null, null, 524287);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.postStartRealtimeWithChat, r101.postStartRealtimeWithChat) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableCancelTtsOnTimeout, r101.enableCancelTtsOnTimeout) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.realtimeDelayStartConnect, r101.realtimeDelayStartConnect) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isPadForcePortrait, r101.isPadForcePortrait) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.streamPlayerChunkOptEnable, r101.streamPlayerChunkOptEnable) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.streamPlayerTechConfig, r101.streamPlayerTechConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.enableScreenShareOpt, r101.enableScreenShareOpt) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.enableShareScreenToChildThread, r101.enableShareScreenToChildThread) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fixRtcFirstAecLoss, r101.fixRtcFirstAecLoss) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.fixSubtitleTtsWaitingEnable, r101.fixSubtitleTtsWaitingEnable) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.fixVlmStateEnable, r101.fixVlmStateEnable) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.fixPipVideoModeEnable, r101.fixPipVideoModeEnable) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.fixVePermissionProblem, r101.fixVePermissionProblem) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.fixAudioLandingEnable, r101.fixAudioLandingEnable) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.enableRealtimeSubtitleQueueOpt, r101.enableRealtimeSubtitleQueueOpt) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.enableFixStreamPlayer, r101.enableFixStreamPlayer) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.enableVideoWindowOpt, r101.enableVideoWindowOpt) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.enableSmallWindowFix, r101.enableSmallWindowFix) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.realtimeAnimRenderOpt, r101.realtimeAnimRenderOpt) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.postStartRealtimeWithChat;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.enableCancelTtsOnTimeout;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.realtimeDelayStartConnect;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isPadForcePortrait;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.streamPlayerChunkOptEnable;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        hq9.t r116 = this.streamPlayerTechConfig;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.enableScreenShareOpt;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.enableShareScreenToChildThread;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.fixRtcFirstAecLoss;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.fixSubtitleTtsWaitingEnable;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.fixVlmStateEnable;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.fixPipVideoModeEnable;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.fixVePermissionProblem;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Boolean r140 = this.fixAudioLandingEnable;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Boolean r143 = this.enableRealtimeSubtitleQueueOpt;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Boolean r146 = this.enableFixStreamPlayer;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.enableVideoWindowOpt;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Boolean r152 = this.enableSmallWindowFix;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        f r155 = this.realtimeAnimRenderOpt;
        if (r155 == null) goto L79;
        r101 = r155.hashCode();
    L79:
        return r154 + r101;
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioTechConfig(postStartRealtimeWithChat=" + this.postStartRealtimeWithChat + ", enableCancelTtsOnTimeout=" + this.enableCancelTtsOnTimeout + ", realtimeDelayStartConnect=" + this.realtimeDelayStartConnect + ", isPadForcePortrait=" + this.isPadForcePortrait + ", streamPlayerChunkOptEnable=" + this.streamPlayerChunkOptEnable + ", streamPlayerTechConfig=" + this.streamPlayerTechConfig + ", enableScreenShareOpt=" + this.enableScreenShareOpt + ", enableShareScreenToChildThread=" + this.enableShareScreenToChildThread + ", fixRtcFirstAecLoss=" + this.fixRtcFirstAecLoss + ", fixSubtitleTtsWaitingEnable=" + this.fixSubtitleTtsWaitingEnable + ", fixVlmStateEnable=" + this.fixVlmStateEnable + ", fixPipVideoModeEnable=" + this.fixPipVideoModeEnable + ", fixVePermissionProblem=" + this.fixVePermissionProblem + ", fixAudioLandingEnable=" + this.fixAudioLandingEnable + ", enableRealtimeSubtitleQueueOpt=" + this.enableRealtimeSubtitleQueueOpt + ", enableFixStreamPlayer=" + this.enableFixStreamPlayer + ", enableVideoWindowOpt=" + this.enableVideoWindowOpt + ", enableSmallWindowFix=" + this.enableSmallWindowFix + ", realtimeAnimRenderOpt=" + this.realtimeAnimRenderOpt + ')';
    }

    public final Boolean a() {
        return this.enableCancelTtsOnTimeout;
    }

    public final Boolean b() {
        return this.enableFixStreamPlayer;
    }

    public final Boolean c() {
        return this.enableRealtimeSubtitleQueueOpt;
    }

    public final Boolean d() {
        return this.enableScreenShareOpt;
    }

    public final Boolean e() {
        return this.enableShareScreenToChildThread;
    }

    public final Boolean f() {
        return this.enableSmallWindowFix;
    }

    public final Boolean g() {
        return this.enableVideoWindowOpt;
    }

    public final Boolean h() {
        return this.fixAudioLandingEnable;
    }

    public final Boolean i() {
        return this.fixPipVideoModeEnable;
    }

    public final Boolean j() {
        return this.fixRtcFirstAecLoss;
    }

    public final Boolean k() {
        return this.fixSubtitleTtsWaitingEnable;
    }

    public final Boolean l() {
        return this.fixVePermissionProblem;
    }

    public final Boolean m() {
        return this.fixVlmStateEnable;
    }

    public final Boolean n() {
        return this.postStartRealtimeWithChat;
    }

    public final f o() {
        return this.realtimeAnimRenderOpt;
    }

    public final Boolean p() {
        return this.realtimeDelayStartConnect;
    }

    public final hq9.t q() {
        return this.streamPlayerTechConfig;
    }

    public o(Boolean r210, Boolean r211, Boolean r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        Boolean r100 = Boolean.FALSE;
    L7:
        if ((r213 & 2) == 0) goto L9;
        Boolean r101 = Boolean.FALSE;
    L11:
        if ((r213 & 4) == 0) goto L13;
        Boolean r102 = Boolean.FALSE;
    L15:
        if ((r213 & 8) == 0) goto L17;
        Boolean r103 = Boolean.TRUE;
    L19:
        if ((r213 & 16) == 0) goto L21;
        Boolean r104 = Boolean.TRUE;
    L23:
        if ((r213 & 32) == 0) goto L25;
        hq9.t r105 = new hq9.t(0);
    L27:
        if ((r213 & 64) == 0) goto L29;
        Boolean r110 = Boolean.TRUE;
    L31:
        if ((r213 & 128) == 0) goto L33;
        Boolean r111 = Boolean.TRUE;
    L35:
        if ((r213 & 256) == 0) goto L37;
        Boolean r112 = Boolean.TRUE;
    L39:
        if ((r213 & 512) == 0) goto L41;
        Boolean r113 = Boolean.TRUE;
    L43:
        if ((r213 & 1024) == 0) goto L45;
        Boolean r114 = Boolean.TRUE;
    L47:
        if ((r213 & 2048) == 0) goto L49;
        Boolean r115 = Boolean.TRUE;
    L51:
        if ((r213 & 4096) == 0) goto L53;
        Boolean r106 = Boolean.TRUE;
    L55:
        if ((r213 & 8192) == 0) goto L57;
        Boolean r107 = Boolean.TRUE;
    L58:
        Boolean r214 = r107;
        if ((r213 & 16384) == 0) goto L61;
        Boolean r108 = Boolean.TRUE;
    L63:
        if ((r213 & 32768) == 0) goto L65;
        Boolean r116 = Boolean.TRUE;
    L67:
        if ((r213 & 65536) == 0) goto L69;
        Boolean r117 = Boolean.TRUE;
    L71:
        if ((r213 & 131072) == 0) goto L73;
        Boolean r118 = Boolean.TRUE;
    L75:
        if ((r213 & 262144) == 0) goto L77;
        f r109 = new f(0);
    L78:
        this.postStartRealtimeWithChat = r100;
        this.enableCancelTtsOnTimeout = r101;
        this.realtimeDelayStartConnect = r102;
        this.isPadForcePortrait = r103;
        this.streamPlayerChunkOptEnable = r104;
        this.streamPlayerTechConfig = r105;
        this.enableScreenShareOpt = r110;
        this.enableShareScreenToChildThread = r111;
        this.fixRtcFirstAecLoss = r112;
        this.fixSubtitleTtsWaitingEnable = r113;
        this.fixVlmStateEnable = r114;
        this.fixPipVideoModeEnable = r115;
        this.fixVePermissionProblem = r106;
        this.fixAudioLandingEnable = r214;
        this.enableRealtimeSubtitleQueueOpt = r108;
        this.enableFixStreamPlayer = r116;
        this.enableVideoWindowOpt = r117;
        this.enableSmallWindowFix = r118;
        this.realtimeAnimRenderOpt = r109;
        return;
    L77:
        r109 = null;
        goto L78
    L73:
        r118 = null;
        goto L75
    L69:
        r117 = null;
        goto L71
    L65:
        r116 = null;
        goto L67
    L61:
        r108 = null;
        goto L63
    L57:
        r107 = null;
        goto L58
    L53:
        r106 = null;
        goto L55
    L49:
        r115 = null;
        goto L51
    L45:
        r114 = null;
        goto L47
    L41:
        r113 = null;
        goto L43
    L37:
        r112 = null;
        goto L39
    L33:
        r111 = null;
        goto L35
    L29:
        r110 = null;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
