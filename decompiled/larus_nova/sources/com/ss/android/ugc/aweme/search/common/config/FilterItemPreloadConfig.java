package com.ss.android.ugc.aweme.search.common.config;

import com.bytedance.ai.api.navi.AppletNaviType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.CardProtocolType;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/FilterItemPreloadConfig;", "Ljava/io/Serializable;", "()V", CardProtocolType.COMMODITY, "Lcom/ss/android/ugc/aweme/search/common/config/TabFilterItemPreloadConfig;", "getCommodity", "()Lcom/ss/android/ugc/aweme/search/common/config/TabFilterItemPreloadConfig;", "setCommodity", "(Lcom/ss/android/ugc/aweme/search/common/config/TabFilterItemPreloadConfig;)V", AppletNaviType.POI, "getPoi", "setPoi", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterItemPreloadConfig implements Serializable {

    @SerializedName(CardProtocolType.COMMODITY)
    private TabFilterItemPreloadConfig commodity;

    @SerializedName(AppletNaviType.POI)
    private TabFilterItemPreloadConfig poi;

    public FilterItemPreloadConfig() {
    }

    public final TabFilterItemPreloadConfig getCommodity() {
        return this.commodity;
    }

    public final TabFilterItemPreloadConfig getPoi() {
        return this.poi;
    }

    public final void setCommodity(TabFilterItemPreloadConfig r100) {
        this.commodity = r100;
    }

    public final void setPoi(TabFilterItemPreloadConfig r100) {
        this.poi = r100;
    }
}
