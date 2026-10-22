package com.bytedance.ee.bear.rn;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> d;
    public final boolean e;
    public final boolean f;
    public final Map<Object, Object> g;
    public final boolean h;
    public final String i;
    public final int j;
    public final boolean k;

    public d() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        int r13 = 1231;
        if (this.e == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.f == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        Map<Object, Object> r18 = this.g;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        if (this.h == false) goto L33;
        int r21 = 1231;
    L34:
        int r22 = (r20 + r21) * 31;
        String r23 = this.i;
        if (r23 == null) goto L38;
        r1 = r23.hashCode();
    L38:
        int r24 = (((r22 + r1) * 31) + this.j) * 31;
        if (this.k == true) goto L43;
        r13 = 1237;
    L43:
        return r24 + r13;
    L33:
        r21 = 1237;
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = 1237;
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "EditCommentParams(commentId=" + this.a + ", replyId=" + this.b + ", content=" + this.c + ", images=" + this.d + ", isAudio=" + this.e + ", whole=" + this.f + ", bizParams=" + this.g + ", shouldAuthorize=" + this.h + ", reply_uuid=" + this.i + ", commentType=" + this.j + ", hasAreaAdded=" + this.k + ')';
    }

    public d(String r4, String r5, String r6, List r7, boolean r8, boolean r9, Map r10, boolean r11, int r12, boolean r13, int r14) {
        if ((r14 & 8) == 0) goto L6;
        r7 = null;
    L6:
        if ((r14 & 16) == 0) goto L9;
        r8 = false;
    L9:
        if ((r14 & 32) == 0) goto L12;
        r9 = false;
    L12:
        if ((r14 & 64) == 0) goto L15;
        r10 = null;
    L15:
        if ((r14 & 128) == 0) goto L18;
        r11 = false;
    L18:
        if ((r14 & 512) == 0) goto L21;
        r12 = 0;
    L21:
        if ((r14 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L23;
        r13 = false;
    L23:
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = null;
        this.j = r12;
        this.k = r13;
    }
}
