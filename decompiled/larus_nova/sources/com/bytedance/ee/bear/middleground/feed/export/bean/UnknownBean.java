package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class UnknownBean implements NonProguard, MultiBean, d<UnknownBean>, c {
    private String atId;
    private String avatarUrl;
    private String content;
    private long createTime;
    private String messageId;
    private int readStatus;
    private String userId;

    public UnknownBean() {
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean
    public Class getAdapterType() {
        return getClass();
    }

    public String getAtId() {
        return this.atId;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getContent() {
        return this.content;
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

    /* JADX INFO: renamed from: contentSame, reason: avoid collision after fix types in other method */
    public boolean contentSame2(UnknownBean r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Objects.equals(Integer.valueOf(this.readStatus), Integer.valueOf(r100.readStatus)) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.avatarUrl, r100.avatarUrl) == false) goto L12;
        return true;
    L12:
        return false;
    }

    /* JADX INFO: renamed from: isSameItem, reason: avoid collision after fix types in other method */
    public boolean isSameItem2(UnknownBean r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return Objects.equals(this.messageId, r100.messageId);
    }

    public void setAtId(String r100) {
        this.atId = r100;
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setCreateTime(long r100) {
        this.createTime = r100;
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

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean contentSame(UnknownBean r100) {
        return contentSame2(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean isSameItem(UnknownBean r100) {
        return isSameItem2(r100);
    }
}
