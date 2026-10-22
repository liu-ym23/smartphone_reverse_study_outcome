package com.bytedance.mt.dataguard.cacheinvalidate;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class CacheInvalidateBean {

    @SerializedName("feedVideoIds")
    public JsonElement feedVideoIdData;

    @SerializedName("imNoticeInfos")
    public JsonElement imNoticeData;

    @SerializedName("liveBannerInfo")
    public JsonElement liveBannerData;

    public CacheInvalidateBean() {
    }
}
