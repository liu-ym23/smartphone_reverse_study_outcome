package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class ShareDetail implements Serializable {

    @SerializedName("audio_url")
    private String mAudioUrl;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("extra")
    private String mExtra;

    @SerializedName("hidden_url")
    private String mHiddenImageUrl;

    @SerializedName("image_token_info")
    private TokenInfo mImageTokenInfo;

    @SerializedName("thumb_image_url")
    private String mImageUrl;

    @SerializedName("qrcode_url")
    private String mQrCodeImageUrl;

    @SerializedName("share_url")
    private String mShareUrl;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("token_info")
    private TokenInfo mTokenInfo;

    @SerializedName("video_url")
    private String mVideoUrl;

    public ShareDetail() {
    }

    public String getAudioUrl() {
        return this.mAudioUrl;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public String getHiddenImageUrl() {
        return this.mHiddenImageUrl;
    }

    public TokenInfo getImageTokenInfo() {
        return this.mImageTokenInfo;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getQrCodeImageUrl() {
        return this.mQrCodeImageUrl;
    }

    public String getShareUrl() {
        return this.mShareUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public TokenInfo getTokenInfo() {
        return this.mTokenInfo;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public void setAudioUrl(String r100) {
        this.mAudioUrl = r100;
    }

    public void setDescription(String r100) {
        this.mDescription = r100;
    }

    public void setExtra(String r100) {
        this.mExtra = r100;
    }

    public void setHiddenImageUrl(String r100) {
        this.mHiddenImageUrl = r100;
    }

    public void setImageTokenInfo(TokenInfo r100) {
        this.mImageTokenInfo = r100;
    }

    public void setImageUrl(String r100) {
        this.mImageUrl = r100;
    }

    public void setQrCodeImageUrl(String r100) {
        this.mQrCodeImageUrl = r100;
    }

    public void setShareUrl(String r100) {
        this.mShareUrl = r100;
    }

    public void setTitle(String r100) {
        this.mTitle = r100;
    }

    public void setTokenInfo(TokenInfo r100) {
        this.mTokenInfo = r100;
    }

    public void setVideoUrl(String r100) {
        this.mVideoUrl = r100;
    }
}
