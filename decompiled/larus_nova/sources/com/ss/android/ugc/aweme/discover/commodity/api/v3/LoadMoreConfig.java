package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/LoadMoreConfig;", "Ljava/io/Serializable;", "()V", EffectConfiguration.KEY_CURSOR, "", "getCursor", "()I", "setCursor", "(I)V", "ecomSearchPassThrough", "", "getEcomSearchPassThrough", "()Ljava/lang/String;", "setEcomSearchPassThrough", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "loadMorePreloadThreshold", "getLoadMorePreloadThreshold", "setLoadMorePreloadThreshold", "shownCount", "getShownCount", "setShownCount", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMoreConfig implements Serializable {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private int cursor;

    @SerializedName("ecom_search_pass_through")
    private String ecomSearchPassThrough;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("loadmore_preload_threshold")
    private int loadMorePreloadThreshold;

    @SerializedName("shown_count")
    private int shownCount;

    public LoadMoreConfig() {
    }

    public final int getCursor() {
        return this.cursor;
    }

    public final String getEcomSearchPassThrough() {
        return this.ecomSearchPassThrough;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final int getLoadMorePreloadThreshold() {
        return this.loadMorePreloadThreshold;
    }

    public final int getShownCount() {
        return this.shownCount;
    }

    public final void setCursor(int r100) {
        this.cursor = r100;
    }

    public final void setEcomSearchPassThrough(String r100) {
        this.ecomSearchPassThrough = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setLoadMorePreloadThreshold(int r100) {
        this.loadMorePreloadThreshold = r100;
    }

    public final void setShownCount(int r100) {
        this.shownCount = r100;
    }
}
