package com.bytedance.ug.sdk.share.api.entity;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class ActivityInfo implements Serializable {

    @SerializedName("act_id")
    private String mActId;

    @SerializedName("client_pop_type")
    private String mClientPopType;

    @SerializedName("domain_id")
    private String mDomainId;

    @SerializedName("id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    private String mTemplateId;

    public ActivityInfo() {
    }

    public String getActId() {
        return this.mActId;
    }

    public String getClientPopType() {
        return this.mClientPopType;
    }

    public String getDomainId() {
        return this.mDomainId;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getTemplateId() {
        return this.mTemplateId;
    }

    public void setActId(String r100) {
        this.mActId = r100;
    }

    public void setClientPopType(String r100) {
        this.mClientPopType = r100;
    }

    public void setDomainId(String r100) {
        this.mDomainId = r100;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public void setTemplateId(String r100) {
        this.mTemplateId = r100;
    }
}
