package com.ss.android.lark.dto.chat;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ChatQRCodeTokenResponse implements Serializable {
    private long expireTime;
    private boolean isUnLimited;
    private String token;
    private String url;

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getToken() {
        return this.token;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isUnLimited() {
        return this.isUnLimited;
    }

    public void setExpireTime(long r100) {
        this.expireTime = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setUnLimited(boolean r100) {
        this.isUnLimited = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public ChatQRCodeTokenResponse(String r100, String r101, long r102) {
        this.isUnLimited = false;
        this.token = r100;
        this.url = r101;
        this.expireTime = r102;
    }

    public ChatQRCodeTokenResponse(String r100, String r101, long r102, boolean r103) {
        this.token = r100;
        this.url = r101;
        this.expireTime = r102;
        this.isUnLimited = r103;
    }
}
