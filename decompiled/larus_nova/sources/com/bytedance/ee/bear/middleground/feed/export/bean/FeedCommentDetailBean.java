package com.bytedance.ee.bear.middleground.feed.export.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
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

    @JSONField(name = MusicAppletPage.KEY_MESSAGE_ID)
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
    public boolean contentSame2(FeedCommentDetailBean r100) {
        if (getExtra() != null) goto L5;
    L7:
        int r101 = 0;
    L9:
        if (r100.getExtra() != null) goto L11;
    L13:
        int r102 = 0;
    L15:
        if (super.equals(r100) == true) goto L17;
        return false;
    L17:
        if (this.readStatus == r100.readStatus) goto L19;
        return false;
    L19:
        if (TextUtils.equals(getContent(), r100.getContent()) == true) goto L21;
        return false;
    L21:
        if (TextUtils.equals(getTitleStr(), r100.getTitleStr()) == false) goto L30;
        if (r101 == r102) goto L24;
        return false;
    L24:
        if (this.lastItem != r100.lastItem) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    L11:
        if (r100.getExtra().getImage_list() == null) goto L13;
        r102 = r100.getExtra().getImage_list().size();
        goto L15
    L5:
        if (getExtra().getImage_list() == null) goto L7;
        r101 = getExtra().getImage_list().size();
        goto L9
    }

    /* JADX INFO: renamed from: isSameItem, reason: avoid collision after fix types in other method */
    public boolean isSameItem2(FeedCommentDetailBean r100) {
        return Objects.equals(getReply_id(), r100.getReply_id());
    }

    public void setCommentType(int r100) {
        this.commentType = r100;
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

    public void setTitleStr(CharSequence r100) {
        this.titleStr = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean contentSame(FeedCommentDetailBean r100) {
        return contentSame2(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean isSameItem(FeedCommentDetailBean r100) {
        return isSameItem2(r100);
    }
}
