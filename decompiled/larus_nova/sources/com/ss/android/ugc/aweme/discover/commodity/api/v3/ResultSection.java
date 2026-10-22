package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ResultSection;", "Ljava/io/Serializable;", "()V", "config", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/TabConfig;", "getConfig", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/TabConfig;", "setConfig", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/TabConfig;)V", "tabInfo", "", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ResultSectionConfig;", "getTabInfo", "()Ljava/util/List;", "setTabInfo", "(Ljava/util/List;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResultSection implements Serializable {

    @SerializedName("tab_ui_config")
    private TabConfig config;

    @SerializedName("tab_list")
    private List<ResultSectionConfig> tabInfo;

    public ResultSection() {
    }

    public final TabConfig getConfig() {
        return this.config;
    }

    public final List<ResultSectionConfig> getTabInfo() {
        return this.tabInfo;
    }

    public final void setConfig(TabConfig r100) {
        this.config = r100;
    }

    public final void setTabInfo(List<ResultSectionConfig> r100) {
        this.tabInfo = r100;
    }
}
