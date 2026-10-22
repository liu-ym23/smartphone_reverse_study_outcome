package com.bytedance.ug.sdk.share.api.entity;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class TokenLogInfoBean implements Serializable {

    @SerializedName("group_id")
    private String mGroupId;

    @SerializedName("group_type")
    private String mGroupType;

    @SerializedName("item_id")
    private String mItemId;

    @SerializedName("log_pb")
    private JsonObject mLogPb;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SHARE_USER_ID)
    private String mShareUserId;

    @SerializedName("tma_share")
    private String mTmaShare;

    @SerializedName("user_id")
    private String mUserId;

    public TokenLogInfoBean() {
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getGroupType() {
        return this.mGroupType;
    }

    public String getItemId() {
        return this.mItemId;
    }

    public JsonObject getLogPb() {
        return this.mLogPb;
    }

    public String getShareUserId() {
        return this.mShareUserId;
    }

    public String getTmaShare() {
        return this.mTmaShare;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setGroupId(String r100) {
        this.mGroupId = r100;
    }

    public void setGroupType(String r100) {
        this.mGroupType = r100;
    }

    public void setItemId(String r100) {
        this.mItemId = r100;
    }

    public void setLogPb(JsonObject r100) {
        this.mLogPb = r100;
    }

    public void setShareUserId(String r100) {
        this.mShareUserId = r100;
    }

    public void setTmaShare(String r100) {
        this.mTmaShare = r100;
    }

    public void setUserId(String r100) {
        this.mUserId = r100;
    }
}
