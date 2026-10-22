package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class ZlinkInfo {

    @SerializedName("channel")
    private String channel;

    @SerializedName("zlink_url")
    private String zlink;

    public ZlinkInfo() {
    }

    public String getChannel() {
        return this.channel;
    }

    public String getZlink() {
        return this.zlink;
    }

    public void setChannel(String r100) {
        this.channel = r100;
    }

    public void setZlink(String r100) {
        this.zlink = r100;
    }
}
