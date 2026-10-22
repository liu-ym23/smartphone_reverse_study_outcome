package ls1;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lls1/n;", "", "", "enable", "Z", "getEnable", "()Z", "enableResort", "getEnableResort", "", "", "fastGiftRecommendScene", "Ljava/util/List;", "getFastGiftRecommendScene", "()Ljava/util/List;", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_resort")
    private final boolean enableResort;

    @SerializedName("speedy_gift_scene")
    private final List<String> fastGiftRecommendScene;

    public n() {
        this.enable = true;
        this.enableResort = true;
        this.fastGiftRecommendScene = CollectionsKt.listOf("broadcast_precision");
    }
}
