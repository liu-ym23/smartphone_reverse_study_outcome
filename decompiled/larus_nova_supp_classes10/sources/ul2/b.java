package ul2;

import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lul2/b;", "", "", "enableMinimize", "Z", "", "watchDuration", "I", "enableRedPot", "redPotDuration", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("enable_minimize")
    public boolean enableMinimize;

    @SerializedName("enable_red_point")
    public boolean enableRedPot;

    @SerializedName("red_point_show_duration")
    public int redPotDuration;

    @SerializedName("min_watch_duration")
    public int watchDuration;

    public b() {
        this(0);
    }

    public b(int r1) {
        this.enableMinimize = false;
        this.watchDuration = 5;
        this.enableRedPot = true;
        this.redPotDuration = MonitorLevel.WARN;
    }
}
