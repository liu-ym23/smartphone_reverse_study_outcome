package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class PanelInfo implements Serializable {

    @SerializedName("channel_list")
    private List<String> mChannelList;

    @SerializedName("filtered_channel_list")
    private List<String> mFilteredChannelList;

    @SerializedName("panel_id")
    private String mPanelId;

    @SerializedName("info_share_url")
    private String mShareInfoUrl;

    public PanelInfo() {
    }

    public List<String> getChannelList() {
        return this.mChannelList;
    }

    public List<String> getFilteredChannelList() {
        return this.mFilteredChannelList;
    }

    public String getPanelId() {
        return this.mPanelId;
    }

    public String getShareInfoUrl() {
        return this.mShareInfoUrl;
    }

    public void setChannelList(List<String> r100) {
        this.mChannelList = r100;
    }

    public void setFilteredChannelList(List<String> r100) {
        this.mFilteredChannelList = r100;
    }

    public void setPanelId(String r100) {
        this.mPanelId = r100;
    }

    public void setShareInfoUrl(String r100) {
        this.mShareInfoUrl = r100;
    }
}
