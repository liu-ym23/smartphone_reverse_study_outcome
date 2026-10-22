package lq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/platform/model/audio/ClientRetryStrategy;", "", "enable", "", "retryTime", "", "maxTimeOutDuration", "<init>", "(ZII)V", "getEnable", "()Z", "getRetryTime", "()I", "getMaxTimeOutDuration", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("time_out_duration")
    private final int maxTimeOutDuration;

    @SerializedName("retry_time")
    private final int retryTime;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.retryTime == r101.retryTime) goto L15;
        return false;
    L15:
        if (this.maxTimeOutDuration == r101.maxTimeOutDuration) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.retryTime) * 31) + this.maxTimeOutDuration;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "ClientRetryStrategy(enable=" + this.enable + ", retryTime=" + this.retryTime + ", maxTimeOutDuration=" + this.maxTimeOutDuration + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.maxTimeOutDuration;
    }

    public final int c() {
        return this.retryTime;
    }

    public h(int r100) {
        this.enable = true;
        this.retryTime = 1;
        this.maxTimeOutDuration = 25000;
    }
}
