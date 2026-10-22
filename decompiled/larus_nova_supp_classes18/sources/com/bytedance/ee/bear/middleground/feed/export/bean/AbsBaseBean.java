package com.bytedance.ee.bear.middleground.feed.export.bean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public void setLastItem(boolean r1) {
        this.lastItem = r1;
    }

    public void setMessageId(String r1) {
        this.messageId = r1;
    }

    public void setReadStatus(int r1) {
        this.readStatus = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }
}
