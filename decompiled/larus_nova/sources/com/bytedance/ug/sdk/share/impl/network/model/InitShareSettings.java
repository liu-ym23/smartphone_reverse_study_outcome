package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class InitShareSettings {

    @SerializedName("android12_token_detect_strategy")
    private List<List<String>> android12TokenDetectStrategy;

    @SerializedName("check_and_sign_channel")
    private List<String> checkAndSignChannelList;

    @SerializedName("album_parse_switch")
    private int mAlbumParseSwitch;

    @SerializedName("hidden_mark_parse_switch")
    private int mHiddenMarkParseSwitch;

    @SerializedName("qrcode_parse_switch")
    private int mQrcodeParseSwitch;

    @SerializedName("token_parse_switch")
    private int mTextTokenParseSwitch;

    @SerializedName("video_hidden_mark_switch")
    private int mVideoHiddenMarkSwitch;

    @SerializedName("video_qrcode_switch")
    private int mVideoQrcodeSwitch;

    @SerializedName("use_timon")
    private int useTimon;

    public InitShareSettings() {
        this.mAlbumParseSwitch = 1;
        this.mQrcodeParseSwitch = 1;
        this.mHiddenMarkParseSwitch = 1;
        this.mTextTokenParseSwitch = 1;
        this.mVideoHiddenMarkSwitch = 1;
        this.mVideoQrcodeSwitch = 1;
        this.useTimon = 0;
    }

    public int getAlbumParseSwitch() {
        return this.mAlbumParseSwitch;
    }

    public List<List<String>> getAndroid12TokenDetectStrategy() {
        return this.android12TokenDetectStrategy;
    }

    public List<String> getCheckAndSignChannelList() {
        return this.checkAndSignChannelList;
    }

    public int getHiddenMarkParseSwitch() {
        return this.mHiddenMarkParseSwitch;
    }

    public int getQrcodeParseSwitch() {
        return this.mQrcodeParseSwitch;
    }

    public int getTextTokenParseSwitch() {
        return this.mTextTokenParseSwitch;
    }

    public int getUseTimon() {
        return this.useTimon;
    }

    public int getVideoHiddenMarkSwitch() {
        return this.mVideoHiddenMarkSwitch;
    }

    public int getVideoQrcodeSwitch() {
        return this.mVideoQrcodeSwitch;
    }

    public void setAlbumParseSwitch(int r100) {
        this.mAlbumParseSwitch = r100;
    }

    public void setAndroid12TokenDetectStrategy(List<List<String>> r100) {
        this.android12TokenDetectStrategy = r100;
    }

    public void setCheckAndSignChannelList(List<String> r100) {
        this.checkAndSignChannelList = r100;
    }

    public void setHiddenMarkParseSwitch(int r100) {
        this.mHiddenMarkParseSwitch = r100;
    }

    public void setQrcodeParseSwitch(int r100) {
        this.mQrcodeParseSwitch = r100;
    }

    public void setTextTokenParseSwitch(int r100) {
        this.mTextTokenParseSwitch = r100;
    }

    public void setUseTimon(int r100) {
        this.useTimon = r100;
    }

    public void setVideoHiddenMarkSwitch(int r100) {
        this.mVideoHiddenMarkSwitch = r100;
    }

    public void setVideoQrcodeSwitch(int r100) {
        this.mVideoQrcodeSwitch = r100;
    }
}
