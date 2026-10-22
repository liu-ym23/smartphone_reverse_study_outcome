package com.ss.android.ugc.aweme.feed.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/AwemeAdData;", "", "", "mainTitle", "Ljava/lang/String;", "getMainTitle$trade_search_api_release", "()Ljava/lang/String;", "setMainTitle$trade_search_api_release", "(Ljava/lang/String;)V", "subTitle", "getSubTitle$trade_search_api_release", "setSubTitle$trade_search_api_release", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class AwemeAdData {

    @SerializedName(BdpAppEventConstant.PARAMS_MAIN_TITLE)
    private String mainTitle;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private String subTitle;

    public AwemeAdData() {
    }
}
