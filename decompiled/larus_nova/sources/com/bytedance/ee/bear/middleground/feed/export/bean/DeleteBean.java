package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class DeleteBean extends AbsBaseBean implements NonProguard, d<DeleteBean> {
    public static final int STATUS_COMMENT_DELETE = 1;
    public static final int STATUS_COMMENT_NOPERM = 3;
    public static final int STATUS_COMMENT_RESOLVED = 2;
    private String commentId;
    private String replyId;
    private String titleStr;
    private int type;
    private boolean whole;

    public DeleteBean() {
        this.type = 1;
        this.titleStr = "";
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean
    public Class getAdapterType() {
        return getClass();
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public String getTitleStr() {
        return this.titleStr;
    }

    public int getType() {
        return this.type;
    }

    public boolean isWhole() {
        return this.whole;
    }

    /* JADX INFO: renamed from: contentSame, reason: avoid collision after fix types in other method */
    public boolean contentSame2(DeleteBean r100) {
        if (Objects.equals(this.avatarUrl, r100.avatarUrl) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.readStatus != r100.readStatus) goto L9;
        if (this.type != r100.type) goto L9;
        return true;
    }

    /* JADX INFO: renamed from: isSameItem, reason: avoid collision after fix types in other method */
    public boolean isSameItem2(DeleteBean r100) {
        return Objects.equals(this.messageId, r100.messageId);
    }

    public void setCommentId(String r100) {
        this.commentId = r100;
    }

    public void setReplyId(String r100) {
        this.replyId = r100;
    }

    public void setTitleStr(String r100) {
        this.titleStr = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setWhole(boolean r100) {
        this.whole = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean contentSame(DeleteBean r100) {
        return contentSame2(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.d
    public /* bridge */ /* synthetic */ boolean isSameItem(DeleteBean r100) {
        return isSameItem2(r100);
    }
}
