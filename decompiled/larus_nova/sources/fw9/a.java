package fw9;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/settings/provider/tick/TickConfig;", "", "enable", "", VideoThumbInfo.KEY_INTERVAL, "", "minInterval", "scale", "", "<init>", "(ZJJF)V", "getEnable", "()Z", "getInterval", "()J", "getMinInterval", "getScale", "()F", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final long interval;

    @SerializedName("min_interval")
    private final long minInterval;

    @SerializedName("scale")
    private final float scale;

    public a() {
        this(0);
    }

    public final boolean a() {
        return this.enable;
    }

    public final long b() {
        return this.interval;
    }

    public final long c() {
        return this.minInterval;
    }

    public final float d() {
        return this.scale;
    }

    public a(int r100) {
        this.enable = false;
        this.interval = 20000;
        this.minInterval = 500;
        this.scale = 1.5f;
    }
}
