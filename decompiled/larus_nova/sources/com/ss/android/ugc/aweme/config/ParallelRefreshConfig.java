package com.ss.android.ugc.aweme.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/config/ParallelRefreshConfig;", "Ljava/io/Serializable;", "()V", "maxParallelCount", "", "getMaxParallelCount", "()I", "preCheckLynxCard", "", "getPreCheckLynxCard", "()Z", "startPosition", "getStartPosition", "timeout", "", "getTimeout", "()J", "toString", "", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ParallelRefreshConfig implements Serializable {

    @SerializedName("max_parallel_count")
    private final int maxParallelCount;

    @SerializedName("pre_check_lynx_card")
    private final boolean preCheckLynxCard;

    @SerializedName("start_position")
    private final int startPosition;

    @SerializedName("time_out")
    private final long timeout;

    public String toString() {
        return "ParallelRefreshConfig(maxParallelCount=" + this.maxParallelCount + ", timeout=" + this.timeout + ", preCheckLynxCard=" + this.preCheckLynxCard + ", startPosition=" + this.startPosition + ')';
    }

    public ParallelRefreshConfig() {
        this.maxParallelCount = 5;
        this.timeout = 100;
    }

    public final int getMaxParallelCount() {
        return this.maxParallelCount;
    }

    public final boolean getPreCheckLynxCard() {
        return this.preCheckLynxCard;
    }

    public final int getStartPosition() {
        return this.startPosition;
    }

    public final long getTimeout() {
        return this.timeout;
    }
}
