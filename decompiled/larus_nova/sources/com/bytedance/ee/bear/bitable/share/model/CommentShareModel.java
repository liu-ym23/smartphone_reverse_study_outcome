package com.bytedance.ee.bear.bitable.share.model;

import com.bytedance.ee.bear.bitable.share.ShareModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/model/CommentShareModel;", "Lcom/bytedance/ee/bear/bitable/share/ShareModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "baseToken", "", "shareType", "", "title", "tableId", "viewId", "recordId", "commentId", "replyId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCommentId", "()Ljava/lang/String;", "getReplyId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentShareModel extends ShareModel {
    private final String commentId;
    private final String replyId;

    public CommentShareModel() {
        this(null, 0, null, null, null, null, null, null, 255, null);
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public CommentShareModel(String r100, int r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        super(r100, r101, r102, r103, r104, r105);
        this.commentId = r106;
        this.replyId = r107;
    }

    public /* synthetic */ CommentShareModel(String r110, int r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = "";
        if ((r118 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
