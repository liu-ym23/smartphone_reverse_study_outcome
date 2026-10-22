package com.bytedance.sdk.open.aweme.authorize.model;

import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class VerifyObject {

    @SerializedName(IDouYin2Service.Extra.VERIFY_OPENID)
    public String verifyOpenId;

    @SerializedName(IDouYin2Service.Extra.VERIFY_SCOPE)
    public String verifyScope;

    @SerializedName(IDouYin2Service.Extra.VERIFY_TIC)
    public String verifyTic;

    public VerifyObject(String r100, String r101, String r102) {
        this.verifyScope = r100;
        this.verifyTic = r101;
        this.verifyOpenId = r102;
    }
}
