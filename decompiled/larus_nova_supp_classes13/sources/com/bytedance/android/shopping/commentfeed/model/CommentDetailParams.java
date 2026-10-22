package com.bytedance.android.shopping.commentfeed.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/model/CommentDetailParams;", "Ljava/io/Serializable;", "productId", "", "commentId", "commentCursor", "", "commentEntrance", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getCommentCursor", "()J", "setCommentCursor", "(J)V", "getCommentEntrance", "()Ljava/lang/String;", "setCommentEntrance", "(Ljava/lang/String;)V", "getCommentId", "setCommentId", "getProductId", "setProductId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentDetailParams implements Serializable {
    private long commentCursor;
    private String commentEntrance;
    private String commentId;
    private String productId;

    public CommentDetailParams() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ CommentDetailParams copy$default(CommentDetailParams r3, String r4, String r5, long r6, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.productId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.commentId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.commentCursor;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.commentEntrance;
    L14:
        String r7 = r4;
        return r3.copy(r7, r11, r0, r8);
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.commentId;
    }

    public final long component3() {
        return this.commentCursor;
    }

    public final String component4() {
        return this.commentEntrance;
    }

    public final CommentDetailParams copy(String r8, String r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r8, "productId");
        Intrinsics.checkNotNullParameter(r9, "commentId");
        Intrinsics.checkNotNullParameter(r12, "commentEntrance");
        return new CommentDetailParams(r8, r9, r10, r12);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof CommentDetailParams) == false) goto L14;
        CommentDetailParams r7 = (CommentDetailParams) r6;
        if (Intrinsics.areEqual(this.productId, r7.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commentId, r7.commentId) == true) goto L10;
        return false;
    L10:
        if (this.commentCursor == r7.commentCursor) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commentEntrance, r7.commentEntrance) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.productId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.commentId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.commentCursor;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.commentEntrance;
        if (r9 == null) goto L14;
        r1 = r9.hashCode();
    L14:
        return r8 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CommentDetailParams(productId=" + this.productId + ", commentId=" + this.commentId + ", commentCursor=" + this.commentCursor + ", commentEntrance=" + this.commentEntrance + ")";
    }

    public final long getCommentCursor() {
        return this.commentCursor;
    }

    public final String getCommentEntrance() {
        return this.commentEntrance;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setCommentCursor(long r1) {
        this.commentCursor = r1;
    }

    public final void setCommentEntrance(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.commentEntrance = r2;
    }

    public final void setCommentId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.commentId = r2;
    }

    public final void setProductId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.productId = r2;
    }

    public CommentDetailParams(String r2, String r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r2, "productId");
        Intrinsics.checkNotNullParameter(r3, "commentId");
        Intrinsics.checkNotNullParameter(r6, "commentEntrance");
        this.productId = r2;
        this.commentId = r3;
        this.commentCursor = r4;
        this.commentEntrance = r6;
    }

    public /* synthetic */ CommentDetailParams(String r5, String r6, long r7, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = "";
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r10 & 4) == 0) goto L13;
        r7 = 0;
    L13:
        long r2 = r7;
        if ((r10 & 8) == 0) goto L16;
        String r13 = "";
    L17:
        this(r12, r1, r2, r13);
        return;
    L16:
        r13 = r9;
        goto L17
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
