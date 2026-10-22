package com.ss.android.ugc.aweme.network.experiment;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/ss/android/ugc/aweme/network/experiment/NetworkThreadPoolExperiment$ThreadPoolConfig", "", "", "apiSize", "I", "getApiSize", "()I", "downloadSize", "getDownloadSize", "aweme-network-api_release"}, k = 1, mv = {1, 4, 1})
public final class NetworkThreadPoolExperiment$ThreadPoolConfig {

    @SerializedName("api")
    private final int apiSize;

    @SerializedName("download")
    private final int downloadSize;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof NetworkThreadPoolExperiment$ThreadPoolConfig) == false) goto L10;
        NetworkThreadPoolExperiment$ThreadPoolConfig r101 = (NetworkThreadPoolExperiment$ThreadPoolConfig) r100;
        if (this.apiSize == r101.apiSize) goto L8;
        return false;
    L8:
        if (this.downloadSize == r101.downloadSize) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.apiSize * 31) + this.downloadSize;
    }

    public final String toString() {
        return "ThreadPoolConfig(apiSize=" + this.apiSize + ", downloadSize=" + this.downloadSize + ")";
    }

    public NetworkThreadPoolExperiment$ThreadPoolConfig() {
        this.apiSize = 0;
        this.downloadSize = 0;
    }
}
