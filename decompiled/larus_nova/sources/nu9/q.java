package nu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/settings/provider/dora/FeaturesConfig;", "", "<init>", "()V", "videoStreaming", "Lcom/larus/settings/provider/dora/VideoStreamingConfig;", "getVideoStreaming", "()Lcom/larus/settings/provider/dora/VideoStreamingConfig;", "setVideoStreaming", "(Lcom/larus/settings/provider/dora/VideoStreamingConfig;)V", "dataSavingConfig", "Lcom/larus/settings/provider/dora/DoraDataSavingConfig;", "getDataSavingConfig", "()Lcom/larus/settings/provider/dora/DoraDataSavingConfig;", "setDataSavingConfig", "(Lcom/larus/settings/provider/dora/DoraDataSavingConfig;)V", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q {

    @SerializedName("dora_data_saving_config")
    private f dataSavingConfig;

    @SerializedName("video_streaming")
    private b0 videoStreaming;

    public q() {
    }

    public final f a() {
        return this.dataSavingConfig;
    }

    public final b0 b() {
        return this.videoStreaming;
    }

    public final void c(f r100) {
        this.dataSavingConfig = r100;
    }

    public final void d(b0 r100) {
        this.videoStreaming = r100;
    }
}
