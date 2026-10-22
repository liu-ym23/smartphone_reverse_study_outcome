package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.globaldoodle.SurpriseInsertCouponConfig;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/SearchMarketingInfo;", "Ljava/io/Serializable;", "()V", "couponPitayaData", "", "", "getCouponPitayaData", "()Ljava/util/Map;", "setCouponPitayaData", "(Ljava/util/Map;)V", "insertCouponConfig", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SurpriseInsertCouponConfig;", "getInsertCouponConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SurpriseInsertCouponConfig;", "setInsertCouponConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SurpriseInsertCouponConfig;)V", "pendantToast", "getPendantToast", "()Ljava/lang/String;", "setPendantToast", "(Ljava/lang/String;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchMarketingInfo implements Serializable {

    @SerializedName("coupon_pitaya_data")
    private Map<String, String> couponPitayaData;

    @SerializedName("insert_coupon_config")
    private SurpriseInsertCouponConfig insertCouponConfig;

    @SerializedName("pendant_toast")
    private String pendantToast;

    public SearchMarketingInfo() {
    }

    public final Map<String, String> getCouponPitayaData() {
        return this.couponPitayaData;
    }

    public final SurpriseInsertCouponConfig getInsertCouponConfig() {
        return this.insertCouponConfig;
    }

    public final String getPendantToast() {
        return this.pendantToast;
    }

    public final void setCouponPitayaData(Map<String, String> r100) {
        this.couponPitayaData = r100;
    }

    public final void setInsertCouponConfig(SurpriseInsertCouponConfig r100) {
        this.insertCouponConfig = r100;
    }

    public final void setPendantToast(String r100) {
        this.pendantToast = r100;
    }
}
