package com.ss.android.ugc.aweme.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016R&\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/config/PreloadBeforeRefreshConfig;", "Ljava/io/Serializable;", "()V", "extra", "", "", "", "getExtra", "()Ljava/util/Map;", "preloadCardConfigs", "", "Lcom/ss/android/ugc/aweme/config/PreloadCardConfig;", "getPreloadCardConfigs", "()Ljava/util/Set;", "usePendingJs", "", "getUsePendingJs", "()Z", "toString", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PreloadBeforeRefreshConfig implements Serializable {

    @SerializedName("extra")
    private final Map<String, Object> extra;

    @SerializedName("preload_cards")
    private final Set<PreloadCardConfig> preloadCardConfigs;

    @SerializedName("use_pending_js")
    private final boolean usePendingJs;

    public String toString() {
        return "PreloadBeforeRefreshConfig(usePendingJs=" + this.usePendingJs + ", preloadCardConfigs=" + this.preloadCardConfigs + ')';
    }

    public PreloadBeforeRefreshConfig() {
        this.usePendingJs = true;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final Set<PreloadCardConfig> getPreloadCardConfigs() {
        return this.preloadCardConfigs;
    }

    public final boolean getUsePendingJs() {
        return this.usePendingJs;
    }
}
