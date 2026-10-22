package com.ss.android.lark.download.service;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class DownloadProgress implements Serializable {
    private static final long serialVersionUID = 845768575142564090L;
    private String channelId;
    private String key;
    private String messageId;
    private int progress;
    private String sourceId;
    private FileDownloadState state;

    public DownloadProgress() {
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getProgress() {
        return this.progress;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public FileDownloadState getState() {
        return this.state;
    }

    public void setChannelId(String r100) {
        this.channelId = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setProgress(int r100) {
        this.progress = r100;
    }

    public void setSourceId(String r100) {
        this.sourceId = r100;
    }

    public void setState(FileDownloadState r100) {
        this.state = r100;
    }
}
