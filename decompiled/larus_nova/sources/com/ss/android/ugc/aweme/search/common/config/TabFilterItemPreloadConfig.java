package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/TabFilterItemPreloadConfig;", "Ljava/io/Serializable;", "()V", "config", "Ljava/util/ArrayList;", "Lcom/ss/android/ugc/aweme/search/common/config/FilterItemConfig;", "Lkotlin/collections/ArrayList;", "getConfig", "()Ljava/util/ArrayList;", "setConfig", "(Ljava/util/ArrayList;)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabFilterItemPreloadConfig implements Serializable {

    @SerializedName("config")
    private ArrayList<FilterItemConfig> config;

    @SerializedName("enable")
    private boolean enable;

    public TabFilterItemPreloadConfig() {
    }

    public final ArrayList<FilterItemConfig> getConfig() {
        return this.config;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final void setConfig(ArrayList<FilterItemConfig> r100) {
        this.config = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }
}
