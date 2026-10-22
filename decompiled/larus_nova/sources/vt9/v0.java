package vt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0016\u0010\u0015\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u0016\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u0016\u0010\u001b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007R\u0016\u0010\u001d\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R\u0016\u0010\u001f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0016\u0010!\u001a\u00020\"8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\"8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*¨\u00061"}, d2 = {"Lcom/larus/settings/provider/audio/RtcAudioSessionConfig;", "", "<init>", "()V", "enableRtc", "", "getEnableRtc", "()Z", "setEnableRtc", "(Z)V", "enableSAMIProcessor", "getEnableSAMIProcessor", "setEnableSAMIProcessor", "enableRtcAec", "getEnableRtcAec", "newConnV2", "getNewConnV2", "enableTokenPreload", "getEnableTokenPreload", "enableUgcBotQuic", "getEnableUgcBotQuic", "enableMainBotQuic", "getEnableMainBotQuic", "enableMainBotMmt", "getEnableMainBotMmt", "enableUgcBotMmt", "getEnableUgcBotMmt", "enablePseudoConnect", "getEnablePseudoConnect", "enableRtcSpeechAec", "getEnableRtcSpeechAec", "enableMmtSpeechAec", "getEnableMmtSpeechAec", "mmtRecorderPerFrameMs", "", "getMmtRecorderPerFrameMs", "()I", "speechAecAudioType", "getSpeechAecAudioType", "aecModelName", "", "getAecModelName", "()Ljava/lang/String;", "aecModelVersion", "getAecModelVersion", "audioxAecModelName", "getAudioxAecModelName", "audioxAecModelVersion", "getAudioxAecModelVersion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class v0 {

    @SerializedName("aec_model_name")
    private final String aecModelName;

    @SerializedName("aec_model_version")
    private final String aecModelVersion;

    @SerializedName("audiox_aec_model_name")
    private final String audioxAecModelName;

    @SerializedName("audiox_aec_model_version")
    private final String audioxAecModelVersion;

    @SerializedName("enable_main_bot_mmt")
    private final boolean enableMainBotMmt;

    @SerializedName("enable_main_bot_quic")
    private final boolean enableMainBotQuic;

    @SerializedName("enable_mmt_speech_aec")
    private final boolean enableMmtSpeechAec;

    @SerializedName("enable_pseudo_connect")
    private final boolean enablePseudoConnect;

    @SerializedName("enable_rtc")
    private boolean enableRtc;

    @SerializedName("enable_rtc_aec")
    private final boolean enableRtcAec;

    @SerializedName("enable_rtc_speech_aec")
    private final boolean enableRtcSpeechAec;

    @SerializedName("enable_sami_processor")
    private boolean enableSAMIProcessor;

    @SerializedName("enable_token_preload")
    private final boolean enableTokenPreload;

    @SerializedName("enable_ugc_bot_mmt")
    private final boolean enableUgcBotMmt;

    @SerializedName("enable_ugc_bot_quic")
    private final boolean enableUgcBotQuic;

    @SerializedName("mmt_recorder_per_frame_ms")
    private final int mmtRecorderPerFrameMs;

    @SerializedName("enable_new_conn_v2")
    private final boolean newConnV2;

    @SerializedName("speech_aec_audio_type")
    private final int speechAecAudioType;

    public v0() {
        this.enableRtc = true;
        this.enableSAMIProcessor = true;
        this.enableRtcAec = true;
        this.newConnV2 = true;
        this.enableTokenPreload = true;
        this.enableMainBotMmt = true;
        this.enableUgcBotMmt = true;
        this.mmtRecorderPerFrameMs = 20;
        this.audioxAecModelName = "advance_6k_kalman_fp16_res_for_asr_v5.1.model";
        this.audioxAecModelVersion = "1.1.0";
    }

    public final String a() {
        return this.aecModelName;
    }

    public final String b() {
        return this.aecModelVersion;
    }

    public final String c() {
        return this.audioxAecModelName;
    }

    public final String d() {
        return this.audioxAecModelVersion;
    }

    public final boolean e() {
        return this.enableMainBotMmt;
    }

    public final boolean f() {
        return this.enableMainBotQuic;
    }

    public final boolean g() {
        return this.enableMmtSpeechAec;
    }

    public final boolean h() {
        return this.enablePseudoConnect;
    }

    public final boolean i() {
        return this.enableRtc;
    }

    public final boolean j() {
        return this.enableRtcAec;
    }

    public final boolean k() {
        return this.enableRtcSpeechAec;
    }

    public final boolean l() {
        return this.enableSAMIProcessor;
    }

    public final boolean m() {
        return this.enableTokenPreload;
    }

    public final boolean n() {
        return this.enableUgcBotMmt;
    }

    public final boolean o() {
        return this.enableUgcBotQuic;
    }

    public final int p() {
        return this.mmtRecorderPerFrameMs;
    }

    public final boolean q() {
        return this.newConnV2;
    }

    public final int r() {
        return this.speechAecAudioType;
    }
}
