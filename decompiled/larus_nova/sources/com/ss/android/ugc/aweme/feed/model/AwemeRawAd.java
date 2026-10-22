package com.ss.android.ugc.aweme.feed.model;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.commercialize.model.AdEventData;
import com.ss.android.ugc.aweme.commercialize.model.SearchData;
import com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\"\u0010'\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR$\u00104\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001cR\u0018\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/AwemeRawAd;", "", "Lcom/ss/android/ugc/aweme/commercialize/model/AdEventData;", "adEventData", "Lcom/ss/android/ugc/aweme/commercialize/model/AdEventData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/ss/android/ugc/aweme/commercialize/model/AdEventData;", "setAdEventData", "(Lcom/ss/android/ugc/aweme/commercialize/model/AdEventData;)V", "", "isUseGoodsDetail", "Z", "()Z", "setUseGoodsDetail", "(Z)V", "", "adStyleType", "I", "b", "()I", "setAdStyleType", "(I)V", "", "enterFromMerge", "Ljava/lang/String;", "getEnterFromMerge", "()Ljava/lang/String;", "setEnterFromMerge", "(Ljava/lang/String;)V", "", "creativeId", "Ljava/lang/Long;", "getCreativeId", "()Ljava/lang/Long;", "setCreativeId", "(Ljava/lang/Long;)V", "logExtra", "d", "setLogExtra", "liveAdType", "getLiveAdType", "setLiveAdType", "Lcom/ss/android/ugc/aweme/commercialize/model/SearchData;", "searchAdData", "Lcom/ss/android/ugc/aweme/commercialize/model/SearchData;", "getSearchAdData", "()Lcom/ss/android/ugc/aweme/commercialize/model/SearchData;", "setSearchAdData", "(Lcom/ss/android/ugc/aweme/commercialize/model/SearchData;)V", "liveActionExtra", "getLiveActionExtra", "setLiveActionExtra", "actionExtra", "getActionExtra", "setActionExtra", "Lcom/ss/android/ugc/aweme/feed/model/AwemeAdData;", "adData", "Lcom/ss/android/ugc/aweme/feed/model/AwemeAdData;", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class AwemeRawAd {

    @SerializedName("action_extra")
    private String actionExtra;

    @SerializedName(DynamicPatch.KEY_AD_DATA)
    public AwemeAdData adData;

    @SerializedName("ad_event_data")
    private AdEventData adEventData;

    @SerializedName("ad_style_type")
    private int adStyleType;

    @SerializedName("creative_id")
    private Long creativeId;

    @SerializedName("enter_from_merge")
    private String enterFromMerge;

    @SerializedName("use_goods_detail")
    private boolean isUseGoodsDetail;

    @SerializedName("live_action_extra")
    private String liveActionExtra;

    @SerializedName(LiveCommonConstants.EXTRA_LIVE_AD_TYPE)
    private int liveAdType;

    @SerializedName("log_extra")
    private String logExtra;

    @SerializedName("search_data")
    private SearchData searchAdData;

    public AwemeRawAd() {
    }

    public final String c() {
        Long r100 = this.creativeId;
        if (r100 == null) goto L6;
        String r101 = r100.toString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final AdEventData a() {
        return this.adEventData;
    }

    public final int b() {
        return this.adStyleType;
    }

    public final String d() {
        return this.logExtra;
    }
}
