package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.chat.entity.Channel;

/* JADX INFO: loaded from: classes38.dex */
public class SearchThreadInfo extends SearchBaseInfo {
    private static final long serialVersionUID = -3607544729328532561L;
    private Channel channel;
    private String chatId;
    private long updateTime;

    public SearchThreadInfo() {
        this.type = 8;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public String getChatId() {
        return this.chatId;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setChannel(Channel r100) {
        this.channel = r100;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }
}
