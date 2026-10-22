package com.bytedance.ee.bear.middleground_permission_export.model.doc;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/CommentPermissionInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "commentId", "getCommentId", "setCommentId", "per", "", "getPer", "()I", "setPer", "(I)V", "Companion", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentPermissionInfo implements NonProguard {
    public static final a Companion = null;
    public static final int HAS_COMMENT_PERMISSION = 2;
    public static final int HAS_DOC_PERMISSION = 1;
    public static final int HAS_FULL_PERMISSION = 0;
    public static final int NONE_PERMISSION = 3;
    private String commentId;
    private int per;
    private String userId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CommentPermissionInfo() {
        this.userId = "";
        this.commentId = "";
        this.per = 3;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final int getPer() {
        return this.per;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setCommentId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.commentId = r2;
    }

    public final void setPer(int r1) {
        this.per = r1;
    }

    public final void setUserId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userId = r2;
    }
}
