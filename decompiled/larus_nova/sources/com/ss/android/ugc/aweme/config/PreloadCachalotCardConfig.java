package com.ss.android.ugc.aweme.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/config/PreloadCachalotCardConfig;", "Lcom/ss/android/ugc/aweme/config/PreloadCardConfig;", "()V", "cachalotData", "", "getCachalotData", "()Ljava/lang/String;", "toString", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PreloadCachalotCardConfig extends PreloadCardConfig {

    @SerializedName("cachalot_data")
    private final String cachalotData;

    @Override // com.ss.android.ugc.aweme.config.PreloadCardConfig
    public String toString() {
        return "PreloadCardConfig(cachalotData=" + this.cachalotData + ", preloadCount=" + getPreloadCount() + ", firstScreenIndexLimit=" + getFirstScreenIndexLimit() + ')';
    }

    public PreloadCachalotCardConfig() {
    }

    public final String getCachalotData() {
        return this.cachalotData;
    }
}
