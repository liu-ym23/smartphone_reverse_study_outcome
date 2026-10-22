package lq9;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.audio.AsrConfigData;
import com.larus.platform.model.audio.TTSConfigData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/platform/model/audio/AudioValue;", "", "<init>", "()V", "asrConfig", "Lcom/larus/platform/model/audio/AsrConfigData;", "getAsrConfig", "()Lcom/larus/platform/model/audio/AsrConfigData;", "setAsrConfig", "(Lcom/larus/platform/model/audio/AsrConfigData;)V", "ttsConfig", "Lcom/larus/platform/model/audio/TTSConfigData;", "getTtsConfig", "()Lcom/larus/platform/model/audio/TTSConfigData;", "setTtsConfig", "(Lcom/larus/platform/model/audio/TTSConfigData;)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("asr_config")
    private AsrConfigData asrConfig;

    @SerializedName("tts_config")
    private TTSConfigData ttsConfig;

    public f() {
        this.asrConfig = new AsrConfigData(null, null, 3, null);
        this.ttsConfig = new TTSConfigData(null, null, 3, null);
    }
}
