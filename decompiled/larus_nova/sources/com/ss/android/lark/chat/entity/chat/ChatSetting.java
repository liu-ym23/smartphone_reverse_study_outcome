package com.ss.android.lark.chat.entity.chat;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ChatSetting implements Serializable {
    private String chatId;
    private boolean isInBox;
    private boolean isRemind;
    private long updateTime;

    public ChatSetting() {
        this.isRemind = true;
        this.updateTime = 0;
        this.isInBox = false;
    }

    public String getChatId() {
        return this.chatId;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isInBox() {
        return this.isInBox;
    }

    public boolean isRemind() {
        return this.isRemind;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setInBox(boolean r100) {
        this.isInBox = r100;
    }

    public void setRemind(boolean r100) {
        this.isRemind = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public ChatSetting(String r100, boolean r101, long r102) {
        this.isInBox = false;
        this.isRemind = r101;
        this.updateTime = r102;
        this.chatId = r100;
    }

    public ChatSetting(String r100, boolean r101, long r102, boolean r103) {
        this.isRemind = r101;
        this.updateTime = r102;
        this.chatId = r100;
        this.isInBox = r103;
    }
}
