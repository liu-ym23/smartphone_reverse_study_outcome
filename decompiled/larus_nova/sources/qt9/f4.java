package qt9;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/provider/SoftRefLruOptConfig;", "", "enable", "", VideoThumbInfo.KEY_INTERVAL, "", URLDispatch.KEY_EPOCH, "<init>", "(ZII)V", "getEnable", "()Z", "getInterval", "()I", "getEpoch", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f4 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName(URLDispatch.KEY_EPOCH)
    private final int epoch;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final int interval;

    public f4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f4) == true) goto L8;
        return false;
    L8:
        f4 r101 = (f4) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.interval == r101.interval) goto L15;
        return false;
    L15:
        if (this.epoch == r101.epoch) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.interval) * 31) + this.epoch;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "SoftRefLruOptConfig(enable=" + this.enable + ", interval=" + this.interval + ", epoch=" + this.epoch + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.epoch;
    }

    public final int c() {
        return this.interval;
    }

    public f4(int r100) {
        this.enable = false;
        this.interval = 0;
        this.epoch = 0;
    }
}
