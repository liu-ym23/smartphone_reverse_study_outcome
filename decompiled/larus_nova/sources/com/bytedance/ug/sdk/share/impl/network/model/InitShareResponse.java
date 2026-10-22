package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class InitShareResponse implements Serializable {

    @SerializedName("ak_share")
    private String mAppKey;

    @SerializedName("settings")
    private InitShareSettings mInitSettings;

    @SerializedName("panel_list")
    private List<PanelInfo> mPanelList;

    @SerializedName("token_activity_reg")
    private List<TokenRefluxInfo> mTokenActivityRegex;

    @SerializedName("token_pic_reg")
    private List<TokenRefluxInfo> mTokenPicRegex;

    @SerializedName("token_reg")
    private String mTokenRegex;

    @SerializedName("token_strategy")
    private List<Integer> mTokenStrategy;

    @SerializedName("token_video_reg")
    private List<TokenRefluxInfo> mTokenVideoRegex;

    @SerializedName("zlink_list")
    private List<ZlinkInfo> mZlinkInfoList;

    public InitShareResponse() {
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public InitShareSettings getInitSettings() {
        return this.mInitSettings;
    }

    public List<PanelInfo> getPanelList() {
        return this.mPanelList;
    }

    public List<TokenRefluxInfo> getTokenActivityRegex() {
        return this.mTokenActivityRegex;
    }

    public List<TokenRefluxInfo> getTokenPicRegex() {
        return this.mTokenPicRegex;
    }

    public String getTokenRegex() {
        return this.mTokenRegex;
    }

    public List<Integer> getTokenStrategy() {
        return this.mTokenStrategy;
    }

    public List<TokenRefluxInfo> getTokenVideoRegex() {
        return this.mTokenVideoRegex;
    }

    public List<ZlinkInfo> getZlinkInfoList() {
        return this.mZlinkInfoList;
    }

    public void setAppKey(String r100) {
        this.mAppKey = r100;
    }

    public void setInitSettings(InitShareSettings r100) {
        this.mInitSettings = r100;
    }

    public void setPanelList(List<PanelInfo> r100) {
        this.mPanelList = r100;
    }

    public void setTokenActivityRegex(List<TokenRefluxInfo> r100) {
        this.mTokenActivityRegex = r100;
    }

    public void setTokenPicRegex(List<TokenRefluxInfo> r100) {
        this.mTokenPicRegex = r100;
    }

    public void setTokenRegex(String r100) {
        this.mTokenRegex = r100;
    }

    public void setTokenRuleList(List<Integer> r100) {
        this.mTokenStrategy = r100;
    }

    public void setTokenVideoRegex(List<TokenRefluxInfo> r100) {
        this.mTokenVideoRegex = r100;
    }

    public void setZlinkInfoList(List<ZlinkInfo> r100) {
        this.mZlinkInfoList = r100;
    }
}
