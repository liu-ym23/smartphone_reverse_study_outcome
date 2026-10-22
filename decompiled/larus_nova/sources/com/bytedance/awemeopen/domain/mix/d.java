package com.bytedance.awemeopen.domain.mix;

import com.bytedance.awemeopen.bizmodels.feed.mix.MixStruct;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes44.dex */
public class d extends n14.a {

    @SerializedName("data")
    public a data;

    @SerializedName("log_id")
    public String logId;

    public static class a {

        @SerializedName("mix_info")
        public MixStruct mixInfo;

        public a() {
        }
    }

    public d() {
    }
}
