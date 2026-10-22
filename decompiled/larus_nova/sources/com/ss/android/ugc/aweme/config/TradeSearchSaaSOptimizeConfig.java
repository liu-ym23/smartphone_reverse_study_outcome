package com.ss.android.ugc.aweme.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\tH\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\r8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000f¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/config/TradeSearchSaaSOptimizeConfig;", "Ljava/io/Serializable;", "()V", "asyncPendingConfig", "Lcom/ss/android/ugc/aweme/config/SearchOptimizeAsyncPending;", "getAsyncPendingConfig", "()Lcom/ss/android/ugc/aweme/config/SearchOptimizeAsyncPending;", "containerPerformanceConfig", "", "", "getContainerPerformanceConfig", "()Ljava/util/Map;", "enableLynxAutoThreadSwitch", "", "getEnableLynxAutoThreadSwitch", "()I", "enableLynxSyncFlushOpt", "getEnableLynxSyncFlushOpt", "enablePreloadTemplateBundle", "getEnablePreloadTemplateBundle", "parallelRefreshConfig", "Lcom/ss/android/ugc/aweme/config/ParallelRefreshConfig;", "getParallelRefreshConfig", "()Lcom/ss/android/ugc/aweme/config/ParallelRefreshConfig;", "preloadBeforeRefresh", "Lcom/ss/android/ugc/aweme/config/PreloadBeforeRefreshConfig;", "getPreloadBeforeRefresh", "()Lcom/ss/android/ugc/aweme/config/PreloadBeforeRefreshConfig;", "refreshThreadSize", "getRefreshThreadSize", "hasConfg", "", "toString", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TradeSearchSaaSOptimizeConfig implements Serializable {

    @SerializedName("async_pending")
    private final SearchOptimizeAsyncPending asyncPendingConfig;

    @SerializedName("container_performance_config")
    private final Map<String, String> containerPerformanceConfig;

    @SerializedName("enable_lynx_auto_thread_switch")
    private final int enableLynxAutoThreadSwitch;

    @SerializedName("enable_lynx_sync_flush_opt")
    private final int enableLynxSyncFlushOpt;

    @SerializedName("enable_preload_template_bundle")
    private final int enablePreloadTemplateBundle;

    @SerializedName("parallel_refresh")
    private final ParallelRefreshConfig parallelRefreshConfig;

    @SerializedName("preload_before_refresh")
    private final PreloadBeforeRefreshConfig preloadBeforeRefresh;

    @SerializedName("refresh_thread_size")
    private final int refreshThreadSize;

    public TradeSearchSaaSOptimizeConfig() {
    }

    public final boolean hasConfg() {
        if (this.parallelRefreshConfig == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "SearchOptimizeConfig(preloadBeforeRefresh=" + this.preloadBeforeRefresh + ", parallelRefreshConfig=" + this.parallelRefreshConfig + ", containerPerformanceConfig=" + this.containerPerformanceConfig + ')';
    }

    public final SearchOptimizeAsyncPending getAsyncPendingConfig() {
        return this.asyncPendingConfig;
    }

    public final Map<String, String> getContainerPerformanceConfig() {
        return this.containerPerformanceConfig;
    }

    public final int getEnableLynxAutoThreadSwitch() {
        return this.enableLynxAutoThreadSwitch;
    }

    public final int getEnableLynxSyncFlushOpt() {
        return this.enableLynxSyncFlushOpt;
    }

    public final int getEnablePreloadTemplateBundle() {
        return this.enablePreloadTemplateBundle;
    }

    public final ParallelRefreshConfig getParallelRefreshConfig() {
        return this.parallelRefreshConfig;
    }

    public final PreloadBeforeRefreshConfig getPreloadBeforeRefresh() {
        return this.preloadBeforeRefresh;
    }

    public final int getRefreshThreadSize() {
        return this.refreshThreadSize;
    }
}
