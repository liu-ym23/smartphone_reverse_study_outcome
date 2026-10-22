package com.ss.android.ugc.aweme.discover.model;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR \u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityAdGoodsInfo;", "Ljava/io/Serializable;", "()V", "coverUrl", "", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", "mpUrl", "getMpUrl", "setMpUrl", RuleConditionBean.OPEN_URL_KEY, "getOpenUrl", "setOpenUrl", "price", "", "getPrice", "()Ljava/lang/Integer;", "setPrice", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "promotionId", "getPromotionId", "setPromotionId", "tag", "getTag", "setTag", "title", "getTitle", d.f25925o, "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCommodityAdGoodsInfo implements Serializable {

    @SerializedName("cover_img_url")
    private String coverUrl;

    @SerializedName("mp_url")
    private String mpUrl;

    @SerializedName("open_url")
    private String openUrl;

    @SerializedName("price")
    private Integer price;

    @SerializedName("promotion_id_str")
    private String promotionId;

    @SerializedName("tag")
    private String tag;

    @SerializedName("title")
    private String title;

    public SearchCommodityAdGoodsInfo() {
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getMpUrl() {
        return this.mpUrl;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setCoverUrl(String r100) {
        this.coverUrl = r100;
    }

    public final void setMpUrl(String r100) {
        this.mpUrl = r100;
    }

    public final void setOpenUrl(String r100) {
        this.openUrl = r100;
    }

    public final void setPrice(Integer r100) {
        this.price = r100;
    }

    public final void setPromotionId(String r100) {
        this.promotionId = r100;
    }

    public final void setTag(String r100) {
        this.tag = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
