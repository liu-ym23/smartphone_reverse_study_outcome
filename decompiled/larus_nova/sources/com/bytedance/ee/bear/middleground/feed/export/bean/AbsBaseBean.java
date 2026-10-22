package com.bytedance.ee.bear.middleground.feed.export.bean;

/* JADX INFO: loaded from: classes18.dex */
public abstract class AbsBaseBean implements MultiBean, c {
    String avatarUrl;
    long createTime;
    boolean lastItem;
    String messageId;
    int readStatus;
    String userId;

    public AbsBaseBean() {
        this.readStatus = 2;
        this.lastItem = false;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.c
    public String getMessageId() {
        return this.messageId;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.c
    public int getReadStatus() {
        return this.readStatus;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isLastItem() {
        return this.lastItem;
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
    }

    public void setLastItem(boolean r100) {
        this.lastItem = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setReadStatus(int r100) {
        this.readStatus = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }
}
