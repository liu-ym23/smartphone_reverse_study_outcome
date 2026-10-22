package zt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/larus/settings/provider/baidunavi/BaiduNaviConfig;", "", "locatingInterval", "", "iconUrlPrefix", "", "startTimeoutInterval", "<init>", "(JLjava/lang/String;J)V", "getLocatingInterval", "()J", "getIconUrlPrefix", "()Ljava/lang/String;", "getStartTimeoutInterval", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("icon_url_prefix")
    private final String iconUrlPrefix;

    @SerializedName("locating_interval")
    private final long locatingInterval;

    @SerializedName("start_timeout_interval")
    private final long startTimeoutInterval;

    public a() {
        this(0);
    }

    public final String a() {
        return this.iconUrlPrefix;
    }

    public final long b() {
        return this.locatingInterval;
    }

    public final long c() {
        return this.startTimeoutInterval;
    }

    public a(int r100) {
        this.locatingInterval = 1000;
        this.iconUrlPrefix = null;
        this.startTimeoutInterval = 5000;
    }
}
