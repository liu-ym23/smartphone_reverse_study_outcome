package com.bytedance.bdp.serviceapi.hostimpl.account.model;

/* JADX INFO: loaded from: classes11.dex */
public class BdpUserInfo {
    public String avatarUrl;
    public String country;
    public String gender;
    public boolean isLogin;
    public String language;
    public String nickName;
    public String phoneNum;
    public String secUID;
    public String sessionId;
    public String userId;

    public String toString() {
        return "BdpUserInfo{\navatarUrl='" + this.avatarUrl + "',\nnickName='" + this.nickName + "',\ngender='" + this.gender + "',\nlanguage='" + this.language + "',\ncountry='" + this.country + "',\nisLogin=" + this.isLogin + "',\nuserId='" + this.userId + "',\nsecUID='" + this.secUID + "',\nsessionId='" + this.sessionId + "',\nphoneNum='" + this.phoneNum + "',\n}";
    }

    public BdpUserInfo() {
        this.isLogin = false;
    }
}
