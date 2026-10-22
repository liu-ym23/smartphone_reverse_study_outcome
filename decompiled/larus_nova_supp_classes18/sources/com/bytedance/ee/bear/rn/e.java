package com.bytedance.ee.bear.rn;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final boolean k;
    public final String l;
    public final String m;
    public final Map<Object, Object> n;
    public final String o;
    public final VisibilityBean p;
    public final int q;
    public final SmartReplyDataForInsert r;

    public e() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (this.q == r6.q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        String r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        int r7 = 1231;
        if (this.d == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.e == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r12 = this.f;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.g;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        String r18 = this.h;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        String r21 = this.i;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        String r24 = this.j;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        if (this.k == true) goto L42;
        r7 = 1237;
    L42:
        int r27 = (r26 + r7) * 31;
        String r28 = this.l;
        if (r28 != null) goto L45;
        int r29 = 0;
    L46:
        int r30 = (r27 + r29) * 31;
        String r31 = this.m;
        if (r31 != null) goto L49;
        int r32 = 0;
    L50:
        int r33 = (r30 + r32) * 31;
        Map<Object, Object> r34 = this.n;
        if (r34 != null) goto L53;
        int r35 = 0;
    L54:
        int r36 = (r33 + r35) * 31;
        String r37 = this.o;
        if (r37 != null) goto L57;
        int r38 = 0;
    L58:
        int r39 = (((((r36 + r38) * 31) + this.p.hashCode()) * 31) + this.q) * 31;
        SmartReplyDataForInsert r40 = this.r;
        if (r40 == null) goto L63;
        r1 = r40.hashCode();
    L63:
        return r39 + r1;
    L57:
        r38 = r37.hashCode();
        goto L58
    L53:
        r35 = r34.hashCode();
        goto L54
    L49:
        r32 = r31.hashCode();
        goto L50
    L45:
        r29 = r28.hashCode();
        goto L46
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PublishCommentParams(quote=" + this.a + ", content=" + this.b + ", commentId=" + this.c + ", isAudio=" + this.d + ", whole=" + this.e + ", images=" + this.f + ", tmpCommentId=" + this.g + ", parentType=" + this.h + ", parentToken=" + this.i + ", replyId=" + this.j + ", shouldAuthorize=" + this.k + ", localCommentId=" + this.l + ", position=" + this.m + ", bizParams=" + this.n + ", reply_uuid=" + this.o + ", visibility=" + this.p + ", commentType=" + this.q + ", smartReplyData=" + this.r + ')';
    }

    public e(String r18, String r19, String r20, boolean r21, boolean r22, List r23, String r24, String r25, String r26, String r27, boolean r28, String r29, String r30, Map r31, String r32, VisibilityBean r33, int r34, SmartReplyDataForInsert r35, int r36) {
        String r4 = "";
        if ((r36 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r36 & 4) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r36 & 8) == 0) goto L13;
        boolean r7 = false;
    L15:
        if ((r36 & 16) == 0) goto L17;
        boolean r9 = false;
    L19:
        if ((r36 & 32) == 0) goto L21;
        List r10 = null;
    L23:
        if ((r36 & 64) != 0) goto L27;
        r4 = r24;
    L27:
        if ((r36 & 128) == 0) goto L29;
        String r11 = null;
    L31:
        if ((r36 & 256) == 0) goto L33;
        String r12 = null;
    L35:
        if ((r36 & 512) == 0) goto L37;
        String r13 = null;
    L39:
        if ((r36 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L41;
        boolean r14 = false;
    L43:
        if ((r36 & DocUserPermission.USER_PREVIEW) == 0) goto L45;
        String r15 = null;
    L47:
        if ((r36 & DocUserPermission.USER_PERCEIVE) == 0) goto L49;
        String r6 = null;
    L51:
        if ((r36 & 8192) == 0) goto L53;
        Map r8 = null;
    L54:
        Map r210 = r8;
        if ((r36 & 16384) == 0) goto L57;
        String r16 = null;
    L59:
        if ((r36 & 32768) == 0) goto L61;
        SmartReplyDataForInsert r17 = null;
        int r110 = 0;
        VisibilityBean r37 = new VisibilityBean(0, 1, null);
    L63:
        if ((65536 & r36) != 0) goto L67;
        r110 = r34;
    L67:
        if ((r36 & 131072) != 0) goto L70;
        r17 = r35;
    L70:
        Intrinsics.checkNotNullParameter(r19, "content");
        Intrinsics.checkNotNullParameter(r37, "visibility");
        this.a = r3;
        this.b = r19;
        this.c = r5;
        this.d = r7;
        this.e = r9;
        this.f = r10;
        this.g = r4;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r6;
        this.n = r210;
        this.o = r16;
        this.p = r37;
        this.q = r110;
        this.r = r17;
        return;
    L61:
        r17 = null;
        r110 = 0;
        r37 = r33;
        goto L63
    L57:
        r16 = r32;
        goto L59
    L53:
        r8 = r31;
        goto L54
    L49:
        r6 = r30;
        goto L51
    L45:
        r15 = r29;
        goto L47
    L41:
        r14 = r28;
        goto L43
    L37:
        r13 = r27;
        goto L39
    L33:
        r12 = r26;
        goto L35
    L29:
        r11 = r25;
        goto L31
    L21:
        r10 = r23;
        goto L23
    L17:
        r9 = r22;
        goto L19
    L13:
        r7 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }
}
