package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/PriceCouponInfo;", "Ljava/io/Serializable;", "()V", "icon", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getIcon", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setIcon", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "info", "Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "getInfo", "()Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "setInfo", "(Lcom/ss/android/ugc/aweme/discover/model/CommonText;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceCouponInfo implements Serializable {

    @SerializedName("icon")
    private UrlModel icon;

    @SerializedName("info")
    private CommonText info;

    public PriceCouponInfo() {
    }

    public final UrlModel getIcon() {
        return this.icon;
    }

    public final CommonText getInfo() {
        return this.info;
    }

    public final void setIcon(UrlModel r100) {
        this.icon = r100;
    }

    public final void setInfo(CommonText r100) {
        this.info = r100;
    }
}
