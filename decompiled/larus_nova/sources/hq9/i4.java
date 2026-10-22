package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/SceneBasedCompressionConfig;", "", "highQualityConfig", "Lcom/larus/platform/model/CompressionConfig;", "lowQualityConfig", "<init>", "(Lcom/larus/platform/model/CompressionConfig;Lcom/larus/platform/model/CompressionConfig;)V", "getHighQualityConfig", "()Lcom/larus/platform/model/CompressionConfig;", "getLowQualityConfig", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i4 {

    @SerializedName("normal_quality")
    private final p0 highQualityConfig;

    @SerializedName("low_quality")
    private final p0 lowQualityConfig;

    public i4() {
        this.highQualityConfig = null;
        this.lowQualityConfig = null;
    }

    public final p0 a() {
        return this.highQualityConfig;
    }

    public final p0 b() {
        return this.lowQualityConfig;
    }
}
