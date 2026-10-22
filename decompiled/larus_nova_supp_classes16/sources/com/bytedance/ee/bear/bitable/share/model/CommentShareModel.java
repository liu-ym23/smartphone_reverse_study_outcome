package com.bytedance.ee.bear.bitable.share.model;

import com.bytedance.ee.bear.bitable.share.ShareModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public CommentShareModel(String r1, int r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        super(r1, r2, r3, r4, r5, r6);
        this.commentId = r7;
        this.replyId = r8;
    }

    public /* synthetic */ CommentShareModel(String r10, int r11, String r12, String r13, String r14, String r16, String r17, String r18, int r19, DefaultConstructorMarker r110) {
        String r2 = "";
        if ((r19 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r19 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r8 = "";
    L31:
        if ((r19 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) != 0) goto L34;
        r2 = r18;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
