package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/larus/platform/model/AsrValue;", "", "<init>", "()V", "connectPoolStrategy", "Lcom/larus/platform/model/audio/ConnectPoolStrategy;", "getConnectPoolStrategy", "()Lcom/larus/platform/model/audio/ConnectPoolStrategy;", "setConnectPoolStrategy", "(Lcom/larus/platform/model/audio/ConnectPoolStrategy;)V", "clientRetryStrategy", "Lcom/larus/platform/model/audio/ClientRetryStrategy;", "getClientRetryStrategy", "()Lcom/larus/platform/model/audio/ClientRetryStrategy;", "setClientRetryStrategy", "(Lcom/larus/platform/model/audio/ClientRetryStrategy;)V", "asrContextStrategy", "Lcom/larus/platform/model/AsrContextStrategy;", "getAsrContextStrategy", "()Lcom/larus/platform/model/AsrContextStrategy;", "setAsrContextStrategy", "(Lcom/larus/platform/model/AsrContextStrategy;)V", "asrSnrStrategy", "Lcom/larus/platform/model/audio/AsrSnrStrategy;", "getAsrSnrStrategy", "()Lcom/larus/platform/model/audio/AsrSnrStrategy;", "setAsrSnrStrategy", "(Lcom/larus/platform/model/audio/AsrSnrStrategy;)V", "ttsQualityStrategy", "Lcom/larus/platform/model/audio/TTSQualityStrategy;", "getTtsQualityStrategy", "()Lcom/larus/platform/model/audio/TTSQualityStrategy;", "setTtsQualityStrategy", "(Lcom/larus/platform/model/audio/TTSQualityStrategy;)V", "ttsPreVoiceDownloadCount", "", "getTtsPreVoiceDownloadCount", "()I", "setTtsPreVoiceDownloadCount", "(I)V", "ttsMaxTimeoutDuration", "Lcom/larus/platform/model/TtsTimeoutStrategy;", "getTtsMaxTimeoutDuration", "()Lcom/larus/platform/model/TtsTimeoutStrategy;", "setTtsMaxTimeoutDuration", "(Lcom/larus/platform/model/TtsTimeoutStrategy;)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    @SerializedName("asr_context_strategy")
    private n asrContextStrategy;

    @SerializedName("asr_snr_quality")
    private lq9.c asrSnrStrategy;

    @SerializedName("client_retry_strategy")
    private lq9.h clientRetryStrategy;

    @SerializedName("connect_pool_strategy")
    private lq9.i connectPoolStrategy;

    @SerializedName("tts_max_timeout_duration")
    private r4 ttsMaxTimeoutDuration;

    @SerializedName("tts_pre_voice_download_max_count")
    private int ttsPreVoiceDownloadCount;

    @SerializedName("tts_quality_strategy")
    private lq9.i0 ttsQualityStrategy;

    public p() {
        this.connectPoolStrategy = new lq9.i(0);
        this.clientRetryStrategy = new lq9.h(0);
        this.asrContextStrategy = new n(0);
        this.asrSnrStrategy = new lq9.c(0);
        this.ttsQualityStrategy = new lq9.i0(0);
        this.ttsPreVoiceDownloadCount = 10;
        this.ttsMaxTimeoutDuration = new r4(0);
    }

    public final n a() {
        return this.asrContextStrategy;
    }

    public final lq9.c b() {
        return this.asrSnrStrategy;
    }

    public final lq9.h c() {
        return this.clientRetryStrategy;
    }

    public final r4 d() {
        return this.ttsMaxTimeoutDuration;
    }

    public final int e() {
        return this.ttsPreVoiceDownloadCount;
    }

    public final lq9.i0 f() {
        return this.ttsQualityStrategy;
    }
}
