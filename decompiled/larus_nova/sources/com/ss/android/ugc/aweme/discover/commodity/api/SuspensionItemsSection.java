package com.ss.android.ugc.aweme.discover.commodity.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/SuspensionItemsSection;", "Ljava/io/Serializable;", "()V", "ecomSearchPathHintCard", "Lcom/ss/android/ugc/aweme/discover/commodity/api/EcomSearchPathHintCard;", "getEcomSearchPathHintCard", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/EcomSearchPathHintCard;", "logPb", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "getLogPb", "()Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "setLogPb", "(Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;)V", "useServerUpdate", "", "getUseServerUpdate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SuspensionItemsSection implements Serializable {

    @SerializedName("ecom_search_path_hint_card")
    private final EcomSearchPathHintCard ecomSearchPathHintCard;
    private LogPbBean logPb;

    @SerializedName("use_server_update")
    private final Boolean useServerUpdate;

    public SuspensionItemsSection() {
    }

    public final EcomSearchPathHintCard getEcomSearchPathHintCard() {
        return this.ecomSearchPathHintCard;
    }

    public final LogPbBean getLogPb() {
        return this.logPb;
    }

    public final Boolean getUseServerUpdate() {
        return this.useServerUpdate;
    }

    public final void setLogPb(LogPbBean r100) {
        this.logPb = r100;
    }
}
