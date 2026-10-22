package com.ss.android.ugc.aweme.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/config/SearchOptimizeAsyncPending;", "Ljava/io/Serializable;", "()V", "cardList", "", "", "getCardList", "()Ljava/util/List;", "cardListMode", "", "getCardListMode", "()I", "enable", "", "getEnable", "()Z", "enableTriggerList", "getEnableTriggerList", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchOptimizeAsyncPending implements Serializable {

    @SerializedName("card_list")
    private final List<String> cardList;

    @SerializedName("card_list_mode")
    private final int cardListMode;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_trigger_list")
    private final List<String> enableTriggerList;

    public SearchOptimizeAsyncPending() {
    }

    public final List<String> getCardList() {
        return this.cardList;
    }

    public final int getCardListMode() {
        return this.cardListMode;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> getEnableTriggerList() {
        return this.enableTriggerList;
    }
}
