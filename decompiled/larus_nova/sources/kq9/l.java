package kq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/platform/model/album/CreationWeakNetworkConfig;", "", "weakNetworkQualityLevel", "", "<init>", "(Ljava/lang/Integer;)V", "getWeakNetworkQualityLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName("weak_network_quality_level")
    private final Integer weakNetworkQualityLevel;

    public l() {
        this(0);
    }

    public final Integer a() {
        return this.weakNetworkQualityLevel;
    }

    public l(int r100) {
        this.weakNetworkQualityLevel = null;
    }
}
