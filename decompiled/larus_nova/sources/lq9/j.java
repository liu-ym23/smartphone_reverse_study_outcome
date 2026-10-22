package lq9;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/audio/ConnectionPoolConfig;", "", DBDefinition.RETRY_COUNT, "", "retryInterval", "pollingIntervalTime", "<init>", "(III)V", "getRetryCount", "()I", "getRetryInterval", "getPollingIntervalTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("pollingIntervalTime")
    private final int pollingIntervalTime;

    @SerializedName(DBDefinition.RETRY_COUNT)
    private final int retryCount;

    @SerializedName("retryInterval")
    private final int retryInterval;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.retryCount == r101.retryCount) goto L12;
        return false;
    L12:
        if (this.retryInterval == r101.retryInterval) goto L15;
        return false;
    L15:
        if (this.pollingIntervalTime == r101.pollingIntervalTime) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.retryCount * 31) + this.retryInterval) * 31) + this.pollingIntervalTime;
    }

    public final String toString() {
        return "ConnectionPoolConfig(retryCount=" + this.retryCount + ", retryInterval=" + this.retryInterval + ", pollingIntervalTime=" + this.pollingIntervalTime + ')';
    }

    public final int a() {
        return this.pollingIntervalTime;
    }

    public final int b() {
        return this.retryCount;
    }

    public final int c() {
        return this.retryInterval;
    }

    public j(int r100) {
        this.retryCount = 5;
        this.retryInterval = 500;
        this.pollingIntervalTime = 300000;
    }
}
