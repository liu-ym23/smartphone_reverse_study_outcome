package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.globaldoodle.SearchBackgroundConfig;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/Style;", "Ljava/io/Serializable;", "()V", "aiSearchBackgroundConfig", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchBackgroundConfig;", "getAiSearchBackgroundConfig", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchBackgroundConfig;", "setAiSearchBackgroundConfig", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchBackgroundConfig;)V", "searchBackgroundConfig", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;", "getSearchBackgroundConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;", "setSearchBackgroundConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;)V", "searchBackgroundConfigOverride", "getSearchBackgroundConfigOverride", "setSearchBackgroundConfigOverride", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Style implements Serializable {

    @SerializedName("ai_search_bot_background_config")
    private AiSearchBackgroundConfig aiSearchBackgroundConfig;

    @SerializedName("search_background_config")
    private SearchBackgroundConfig searchBackgroundConfig;

    @SerializedName("search_background_config_override")
    private SearchBackgroundConfig searchBackgroundConfigOverride;

    public Style() {
    }

    public final AiSearchBackgroundConfig getAiSearchBackgroundConfig() {
        return this.aiSearchBackgroundConfig;
    }

    public final SearchBackgroundConfig getSearchBackgroundConfig() {
        return this.searchBackgroundConfig;
    }

    public final SearchBackgroundConfig getSearchBackgroundConfigOverride() {
        return this.searchBackgroundConfigOverride;
    }

    public final void setAiSearchBackgroundConfig(AiSearchBackgroundConfig r100) {
        this.aiSearchBackgroundConfig = r100;
    }

    public final void setSearchBackgroundConfig(SearchBackgroundConfig r100) {
        this.searchBackgroundConfig = r100;
    }

    public final void setSearchBackgroundConfigOverride(SearchBackgroundConfig r100) {
        this.searchBackgroundConfigOverride = r100;
    }
}
