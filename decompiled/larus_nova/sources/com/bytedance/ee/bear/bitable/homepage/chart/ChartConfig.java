package com.bytedance.ee.bear.bitable.homepage.chart;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = "bitable_homepage_chart")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartConfig;", "", "<init>", "()V", "chartListCacheTimeoutSeconds", "", "getChartListCacheTimeoutSeconds", "()J", "setChartListCacheTimeoutSeconds", "(J)V", "addedChartCountLimit", "", "getAddedChartCountLimit", "()I", "setAddedChartCountLimit", "(I)V", "enableLynxAsyncRender", "", "getEnableLynxAsyncRender", "()Z", "setEnableLynxAsyncRender", "(Z)V", "setChartItemViewCacheSizeMemoryThresholdGB", "getSetChartItemViewCacheSizeMemoryThresholdGB", "setSetChartItemViewCacheSizeMemoryThresholdGB", "addChartItemViewCacheSize", "getAddChartItemViewCacheSize", "setAddChartItemViewCacheSize", "homeChartItemViewCacheSize", "getHomeChartItemViewCacheSize", "setHomeChartItemViewCacheSize", "fetchChartDataConfig", "Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartConfig$FetchChartDataConfig;", "getFetchChartDataConfig", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartConfig$FetchChartDataConfig;", "setFetchChartDataConfig", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartConfig$FetchChartDataConfig;)V", "FetchChartDataConfig", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChartConfig {

    @SerializedName("add_chart_item_view_cache_size")
    private int addChartItemViewCacheSize;

    @SerializedName("insert_page_check_limit")
    private int addedChartCountLimit;

    @SerializedName("chart_list_cache_timeout_seconds")
    private long chartListCacheTimeoutSeconds;

    @SerializedName("enable_lynx_async_render")
    private boolean enableLynxAsyncRender;

    @SerializedName("fetch_chart_data_config")
    private a fetchChartDataConfig;

    @SerializedName("home_chart_item_view_cache_size")
    private int homeChartItemViewCacheSize;

    @SerializedName("set_chart_item_view_cache_size_memory_threshold_gb")
    private int setChartItemViewCacheSizeMemoryThresholdGB;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartConfig$FetchChartDataConfig;", "", "<init>", "()V", "retryCountLimit", "", "getRetryCountLimit", "()I", "setRetryCountLimit", "(I)V", "retryDelayMillis", "", "getRetryDelayMillis", "()J", "setRetryDelayMillis", "(J)V", "lruCacheMaxSize", "getLruCacheMaxSize", "setLruCacheMaxSize", "prefetchChartSize", "getPrefetchChartSize", "setPrefetchChartSize", "prefetchScrollSpeedThreshold", "getPrefetchScrollSpeedThreshold", "setPrefetchScrollSpeedThreshold", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("lru_cache_max_size")
        private int lruCacheMaxSize;

        @SerializedName("prefetch_chart_size")
        private int prefetchChartSize;

        @SerializedName("prefetch_scroll_speed_threshold")
        private int prefetchScrollSpeedThreshold;

        @SerializedName("retry_count_limit")
        private int retryCountLimit;

        @SerializedName("retry_delay_millis")
        private long retryDelayMillis;

        public a() {
            this.retryCountLimit = 3;
            this.retryDelayMillis = 500;
            this.lruCacheMaxSize = 10000000;
            this.prefetchChartSize = 1;
            this.prefetchScrollSpeedThreshold = 5;
        }

        public final int a() {
            return this.lruCacheMaxSize;
        }

        public final int b() {
            return this.prefetchChartSize;
        }

        public final int c() {
            return this.prefetchScrollSpeedThreshold;
        }

        public final int d() {
            return this.retryCountLimit;
        }

        public final long e() {
            return this.retryDelayMillis;
        }
    }

    public ChartConfig() {
        this.chartListCacheTimeoutSeconds = 259200;
        this.addedChartCountLimit = 20;
        this.setChartItemViewCacheSizeMemoryThresholdGB = 4;
        this.addChartItemViewCacheSize = 5;
        this.homeChartItemViewCacheSize = 5;
        this.fetchChartDataConfig = new a();
    }

    public final int a() {
        return this.addChartItemViewCacheSize;
    }

    public final int b() {
        return this.addedChartCountLimit;
    }

    public final long c() {
        return this.chartListCacheTimeoutSeconds;
    }

    public final boolean d() {
        return this.enableLynxAsyncRender;
    }

    public final a e() {
        return this.fetchChartDataConfig;
    }

    public final int f() {
        return this.homeChartItemViewCacheSize;
    }

    public final int g() {
        return this.setChartItemViewCacheSizeMemoryThresholdGB;
    }
}
