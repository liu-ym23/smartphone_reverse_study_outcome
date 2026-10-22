package uu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/provider/home/SideBarStartupOptConfig;", "", "enable", "", "preloadDataDelayMs", "", "attachAfterFirstFeedShow", "<init>", "(ZJZ)V", "getEnable", "()Z", "getPreloadDataDelayMs", "()J", "getAttachAfterFirstFeedShow", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("attach_after_first_feed_show")
    private final boolean attachAfterFirstFeedShow;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("preload_data_delay_ms")
    private final long preloadDataDelayMs;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.preloadDataDelayMs == r101.preloadDataDelayMs) goto L15;
        return false;
    L15:
        if (this.attachAfterFirstFeedShow == r101.attachAfterFirstFeedShow) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        long r102 = this.preloadDataDelayMs;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        if (this.attachAfterFirstFeedShow == true) goto L11;
        r100 = 1237;
    L11:
        return r103 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SideBarStartupOptConfig(enable=" + this.enable + ", preloadDataDelayMs=" + this.preloadDataDelayMs + ", attachAfterFirstFeedShow=" + this.attachAfterFirstFeedShow + ')';
    }

    public final boolean a() {
        return this.attachAfterFirstFeedShow;
    }

    public final boolean b() {
        return this.enable;
    }

    public final long c() {
        return this.preloadDataDelayMs;
    }

    public f(int r100) {
        this.enable = false;
        this.preloadDataDelayMs = 3000;
        this.attachAfterFirstFeedShow = false;
    }
}
