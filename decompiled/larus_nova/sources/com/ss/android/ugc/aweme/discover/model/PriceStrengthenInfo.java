package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/PriceStrengthenInfo;", "Ljava/io/Serializable;", "()V", "priceGrabIcon", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getPriceGrabIcon", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setPriceGrabIcon", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "pricePrefix", "Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "getPricePrefix", "()Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "setPricePrefix", "(Lcom/ss/android/ugc/aweme/discover/model/CommonText;)V", "priceSuffix", "getPriceSuffix", "setPriceSuffix", "priceTag", "getPriceTag", "setPriceTag", "priceTrendBg", "getPriceTrendBg", "setPriceTrendBg", "priceUnderline", "getPriceUnderline", "setPriceUnderline", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceStrengthenInfo implements Serializable {

    @SerializedName("price_grab_icon")
    private UrlModel priceGrabIcon;

    @SerializedName("price_prefix")
    private CommonText pricePrefix;

    @SerializedName("price_suffix")
    private CommonText priceSuffix;

    @SerializedName(BdpAppEventConstant.PARAMS_PRICE_TAG)
    private UrlModel priceTag;

    @SerializedName("price_trend_bg")
    private UrlModel priceTrendBg;

    @SerializedName("price_under_line")
    private CommonText priceUnderline;

    public PriceStrengthenInfo() {
    }

    public final UrlModel getPriceGrabIcon() {
        return this.priceGrabIcon;
    }

    public final CommonText getPricePrefix() {
        return this.pricePrefix;
    }

    public final CommonText getPriceSuffix() {
        return this.priceSuffix;
    }

    public final UrlModel getPriceTag() {
        return this.priceTag;
    }

    public final UrlModel getPriceTrendBg() {
        return this.priceTrendBg;
    }

    public final CommonText getPriceUnderline() {
        return this.priceUnderline;
    }

    public final void setPriceGrabIcon(UrlModel r100) {
        this.priceGrabIcon = r100;
    }

    public final void setPricePrefix(CommonText r100) {
        this.pricePrefix = r100;
    }

    public final void setPriceSuffix(CommonText r100) {
        this.priceSuffix = r100;
    }

    public final void setPriceTag(UrlModel r100) {
        this.priceTag = r100;
    }

    public final void setPriceTrendBg(UrlModel r100) {
        this.priceTrendBg = r100;
    }

    public final void setPriceUnderline(CommonText r100) {
        this.priceUnderline = r100;
    }
}
