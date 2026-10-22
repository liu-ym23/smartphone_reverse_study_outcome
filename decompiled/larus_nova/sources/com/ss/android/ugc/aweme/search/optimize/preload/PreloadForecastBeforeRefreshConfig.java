package com.ss.android.ugc.aweme.search.optimize.preload;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/preload/PreloadForecastBeforeRefreshConfig;", "Ljava/io/Serializable;", "()V", "enablePendingUiOp", "", "getEnablePendingUiOp", "()Z", "enableSyncReuse", "getEnableSyncReuse", "pressForecastSearchSourceSet", "", "", "getPressForecastSearchSourceSet", "()Ljava/util/Set;", "usePendingJs", "getUsePendingJs", "toString", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PreloadForecastBeforeRefreshConfig implements Serializable {

    @SerializedName("enable_pending_ui_op")
    private final boolean enablePendingUiOp;

    @SerializedName("enable_sync_reuse")
    private final boolean enableSyncReuse;

    @SerializedName("press_forecast_source")
    private final Set<String> pressForecastSearchSourceSet;

    @SerializedName("use_pending_js")
    private final boolean usePendingJs;

    public String toString() {
        return "PreloadBeforeRefreshConfig(usePendingJs=" + this.usePendingJs + ", pressForecastSearchSourceSet=" + this.pressForecastSearchSourceSet + ')';
    }

    public PreloadForecastBeforeRefreshConfig() {
        this.usePendingJs = true;
    }

    public final boolean getEnablePendingUiOp() {
        return this.enablePendingUiOp;
    }

    public final boolean getEnableSyncReuse() {
        return this.enableSyncReuse;
    }

    public final Set<String> getPressForecastSearchSourceSet() {
        return this.pressForecastSearchSourceSet;
    }

    public final boolean getUsePendingJs() {
        return this.usePendingJs;
    }
}
