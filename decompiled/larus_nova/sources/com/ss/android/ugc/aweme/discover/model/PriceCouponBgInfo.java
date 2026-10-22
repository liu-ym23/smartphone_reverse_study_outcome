package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/PriceCouponBgInfo;", "Ljava/io/Serializable;", "()V", "backgroundImage", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getBackgroundImage", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setBackgroundImage", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "iconDoubleColumn", "getIconDoubleColumn", "setIconDoubleColumn", "iconSingleColumn", "getIconSingleColumn", "setIconSingleColumn", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceCouponBgInfo implements Serializable {

    @SerializedName("background_image")
    private UrlModel backgroundImage;

    @SerializedName("icon_double_column")
    private UrlModel iconDoubleColumn;

    @SerializedName("icon_single_column")
    private UrlModel iconSingleColumn;

    public PriceCouponBgInfo() {
    }

    public final UrlModel getBackgroundImage() {
        return this.backgroundImage;
    }

    public final UrlModel getIconDoubleColumn() {
        return this.iconDoubleColumn;
    }

    public final UrlModel getIconSingleColumn() {
        return this.iconSingleColumn;
    }

    public final void setBackgroundImage(UrlModel r100) {
        this.backgroundImage = r100;
    }

    public final void setIconDoubleColumn(UrlModel r100) {
        this.iconDoubleColumn = r100;
    }

    public final void setIconSingleColumn(UrlModel r100) {
        this.iconSingleColumn = r100;
    }
}
