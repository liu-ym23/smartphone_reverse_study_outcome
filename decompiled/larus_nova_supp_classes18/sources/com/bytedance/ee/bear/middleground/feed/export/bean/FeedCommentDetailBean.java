package com.bytedance.ee.bear.middleground.feed.export.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FeedCommentDetailBean extends BaseFeedMessageDetailBean implements NonProguard, MultiBean, d<FeedCommentDetailBean>, c {
    public static final int TYPE_AT = 0;
    public static final int TYPE_NEW_COMMENT = 0;
    public static final int TYPE_NEW_REPLY = 0;
    public static final int TYPE_REACTION = 0;
    public static final int TYPE_REOPEN = 0;
    public static final int TYPE_RESOLVE = 0;
    private int commentType;

    @JSONField(name = "create_time")
    private long createTime;
    private boolean lastItem;

    @JSONField(name = "message_id")
    private String messageId;
    private int readStatus;
    private CharSequence titleStr;
    private int type;

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.BaseFeedMessageDetailBean
    public String toString() {
        return super.toString() + "{messageId='" + this.messageId + "', readStatus=" + this.readStatus + '}';
    }

    public FeedCommentDetailBean() {
        this.createTime = 0;
        this.readStatus = 0;
        this.type = 0;
        this.titleStr = "";
        this.lastItem = false;
        this.commentType = 0;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean
    public Class getAdapterType() {
        return getClass();
    }

    public int getCommentType() {
        return this.commentType;
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

    public CharSequence getTitleStr() {
        return this.titleStr;
    }

    public int getType() {
        return this.type;
    }

    public boolean isLastItem() {
        return this.lastItem;
    }

    /* JADX INFO: renamed from: contentSame, reason: avoid collision after fix types in other method */
    public boolean contentSame2(FeedCommentDetailBean r6) {
        if (getExtra() != null) goto L5;
    L7:
        int r0 = 0;
    L9:
        if (r6.getExtra() != null) goto L11;
    L13:
        int r2 = 0;
    L15:
        if (super.equals(r6) == true) goto L17;
        return false;
    L17:
        if (this.readStatus == r6.readStatus) goto L19;
        return false;
    L19:
        if (TextUtils.equals(getContent(), r6.getContent()) == true) goto L21;
        return false;
    L21:
        if (TextUtils.equals(getTitleStr(), r6.getTitleStr()) == false) goto L30;
        if (r0 == r2) goto L24;
        return false;
    L24:
        if (this.lastItem != r6.lastItem) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    L11:
        if (r6.getExtra().getImage_list() == null) goto L13;
        r2 = r6.getExtra().getImage_list().size();
        goto L15
    L5:
        if (getExtra().getImage_list() == null) goto L7;
        r0 = getExtra().getImage_list().size();
        goto L9
    }

    /* JADX INFO: renamed from: isSameItem, reason: avoid collision after fix types in other method */
    public boolean isSameItem2(FeedCommentDetailBean r2) {
        return Objects.equals(getReply_id(), r2.getReply_id());
    }

    public void setCommentType(int r1) {
        this.commentType = r1;
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

    public void setTitleStr(CharSequence r1) {
        this.titleStr = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean contentSame(FeedCommentDetailBean r1) {
        return contentSame2(r1);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean isSameItem(FeedCommentDetailBean r1) {
        return isSameItem2(r1);
    }
}
