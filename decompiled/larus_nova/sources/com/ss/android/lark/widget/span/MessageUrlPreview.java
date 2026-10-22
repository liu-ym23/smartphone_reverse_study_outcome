package com.ss.android.lark.widget.span;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class MessageUrlPreview implements Serializable {
    private int count;
    private String description;
    private boolean isDeleted;
    private String messageId;
    private int offset;
    private int sequenceId;
    private String title;
    private String url;

    public MessageUrlPreview() {
        this.isDeleted = false;
    }

    public int getCount() {
        return this.count;
    }

    public String getDescription() {
        return this.description;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSequenceId() {
        return this.sequenceId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setCount(int r100) {
        this.count = r100;
    }

    public void setDeleted(boolean r100) {
        this.isDeleted = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setOffset(int r100) {
        this.offset = r100;
    }

    public void setSequenceId(int r100) {
        this.sequenceId = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
