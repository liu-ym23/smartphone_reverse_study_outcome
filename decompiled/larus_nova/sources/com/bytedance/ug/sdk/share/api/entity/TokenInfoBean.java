package com.bytedance.ug.sdk.share.api.entity;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class TokenInfoBean implements Serializable {

    @SerializedName("activity_info")
    private ActivityInfo mActivityInfo;

    @SerializedName("author_info")
    private AuthorInfo mAuthorInfo;

    @SerializedName("button_text")
    private String mButtonText;

    @SerializedName("client_extra")
    private String mClientExtra;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String mDesc;
    private String mFrom;

    @SerializedName("log_info")
    private TokenLogInfoBean mLogInfo;

    @SerializedName(a.KEY_MEDIA_TYPE)
    private int mMediaType;

    @SerializedName("open_url")
    private String mOpenUrl;

    @SerializedName("pic_cnt")
    private int mPicCnt;

    @SerializedName(SocialConstants.PARAM_IMAGE)
    private List<TokenImageInfoBean> mPics;

    @SerializedName("share_user_info")
    private TokenUserInfoBean mShareUserInfo;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("token")
    private String mToken;

    @SerializedName("token_type")
    private int mTokenType;

    @SerializedName("video_duration")
    private int mVideoDuration;

    public TokenInfoBean() {
    }

    public ActivityInfo getActivityInfo() {
        return this.mActivityInfo;
    }

    public AuthorInfo getAuthorInfo() {
        return this.mAuthorInfo;
    }

    public String getButtonText() {
        return this.mButtonText;
    }

    public String getClientExtra() {
        return this.mClientExtra;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public TokenLogInfoBean getLogInfo() {
        return this.mLogInfo;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public String getOpenUrl() {
        return this.mOpenUrl;
    }

    public int getPicCnt() {
        return this.mPicCnt;
    }

    public List<TokenImageInfoBean> getPics() {
        return this.mPics;
    }

    public TokenUserInfoBean getShareUserInfo() {
        return this.mShareUserInfo;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getToken() {
        return this.mToken;
    }

    public int getTokenType() {
        return this.mTokenType;
    }

    public int getVideoDuration() {
        return this.mVideoDuration;
    }

    public void setActivityInfo(ActivityInfo r100) {
        this.mActivityInfo = r100;
    }

    public void setAuthorInfo(AuthorInfo r100) {
        this.mAuthorInfo = r100;
    }

    public void setButtonText(String r100) {
        this.mButtonText = r100;
    }

    public void setClientExtra(String r100) {
        this.mClientExtra = r100;
    }

    public void setDesc(String r100) {
        this.mDesc = r100;
    }

    public void setFrom(String r100) {
        this.mFrom = r100;
    }

    public void setLogInfo(TokenLogInfoBean r100) {
        this.mLogInfo = r100;
    }

    public void setMediaType(int r100) {
        this.mMediaType = r100;
    }

    public void setOpenUrl(String r100) {
        this.mOpenUrl = r100;
    }

    public void setPicCnt(int r100) {
        this.mPicCnt = r100;
    }

    public void setPics(List<TokenImageInfoBean> r100) {
        this.mPics = r100;
    }

    public void setShareUserInfo(TokenUserInfoBean r100) {
        this.mShareUserInfo = r100;
    }

    public void setTitle(String r100) {
        this.mTitle = r100;
    }

    public void setToken(String r100) {
        this.mToken = r100;
    }

    public void setTokenType(int r100) {
        this.mTokenType = r100;
    }

    public void setVideoDuration(int r100) {
        this.mVideoDuration = r100;
    }
}
