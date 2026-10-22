package tt4;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/BaseAppBehaviorPreloadConfig;", "", "<init>", "()V", "recentOpenValidDays", "", "getRecentOpenValidDays", "()J", "startupPreloadDelayMs", "getStartupPreloadDelayMs", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("recent_open_valid_days")
    private final long recentOpenValidDays;

    @SerializedName("startup_preload_delay_ms")
    private final long startupPreloadDelayMs;

    public b() {
        this.recentOpenValidDays = 14;
        this.startupPreloadDelayMs = 5000;
    }

    public final long a() {
        return this.recentOpenValidDays;
    }

    public final long b() {
        return this.startupPreloadDelayMs;
    }
}
