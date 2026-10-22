package com.ss.android.lark.dto.chat;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ChatLinkTokenResponse implements Serializable {
    private String displayContent;
    private long expireTime;
    private boolean isUnLimited;
    private String sharedUrl;
    private String token;

    public String getDisplayContent() {
        return this.displayContent;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getSharedUrl() {
        return this.sharedUrl;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isUnLimited() {
        return this.isUnLimited;
    }

    public void setDisplayContent(String r100) {
        this.displayContent = r100;
    }

    public void setExpireTime(long r100) {
        this.expireTime = r100;
    }

    public void setSharedUrl(String r100) {
        this.sharedUrl = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setUnLimited(boolean r100) {
        this.isUnLimited = r100;
    }

    public ChatLinkTokenResponse(String r100, String r101, String r102, long r103) {
        this.isUnLimited = false;
        this.token = r100;
        this.sharedUrl = r101;
        this.displayContent = r102;
        this.expireTime = r103;
    }

    public ChatLinkTokenResponse(String r100, String r101, String r102, long r103, boolean r104) {
        this.token = r100;
        this.sharedUrl = r101;
        this.displayContent = r102;
        this.expireTime = r103;
        this.isUnLimited = r104;
    }
}
