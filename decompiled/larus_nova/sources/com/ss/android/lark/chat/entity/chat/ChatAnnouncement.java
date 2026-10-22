package com.ss.android.lark.chat.entity.chat;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ChatAnnouncement implements Serializable {
    private static final long serialVersionUID = 9059996248975978048L;
    private String announceUrl;
    private String chatId;
    private String content;
    private String docUrl;
    private String lastEditorId;
    private long updateTime;
    private boolean useOpenDoc;

    public ChatAnnouncement() {
    }

    public String getAnnounceUrl() {
        return this.announceUrl;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getContent() {
        return this.content;
    }

    public String getDocUrl() {
        return this.docUrl;
    }

    public String getLastEditorId() {
        return this.lastEditorId;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isUseOpenDoc() {
        return this.useOpenDoc;
    }

    public void setAnnounceUrl(String r100) {
        this.announceUrl = r100;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setDocUrl(String r100) {
        this.docUrl = r100;
    }

    public void setLastEditorId(String r100) {
        this.lastEditorId = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public void setUseOpenDoc(boolean r100) {
        this.useOpenDoc = r100;
    }
}
