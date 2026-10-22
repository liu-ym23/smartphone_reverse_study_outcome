package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public boolean contentSame2(UnknownBean r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (Objects.equals(Integer.valueOf(this.readStatus), Integer.valueOf(r4.readStatus)) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.avatarUrl, r4.avatarUrl) == false) goto L12;
        return true;
    L12:
        return false;
    }

    /* JADX INFO: renamed from: isSameItem, reason: avoid collision after fix types in other method */
    public boolean isSameItem2(UnknownBean r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return Objects.equals(this.messageId, r2.messageId);
    }

    public void setAtId(String r1) {
        this.atId = r1;
    }

    public void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
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

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean contentSame(UnknownBean r1) {
        return contentSame2(r1);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean isSameItem(UnknownBean r1) {
        return isSameItem2(r1);
    }
}
