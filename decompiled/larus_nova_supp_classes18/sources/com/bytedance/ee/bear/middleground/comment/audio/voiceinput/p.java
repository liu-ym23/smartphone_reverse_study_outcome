package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p {
    public static final /* synthetic */ int g = 0;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final boolean f;

    public static final class a {
        public static p a(CommentInputRequest r8) {
            Intrinsics.checkNotNullParameter(r8, "request");
            String r1 = r8.comment_id;
            if (r1 != null) goto L5;
            String r3 = "";
        L6:
            String r2 = r8.reply_id;
            if (r2 != null) goto L9;
            String r4 = "";
        L10:
            String r5 = r8.local_comment_id;
            if (r5 != null) goto L13;
            String r6 = "";
        L14:
            String r7 = r8.tmpCommentId;
            if (r7 != null) goto L17;
            String r9 = "";
        L18:
            String r10 = r3;
            String r11 = r4;
            String r12 = r6;
            String r13 = r9;
            return new p(r10, r11, r12, r13, r8.type, r8.is_whole);
        L17:
            r9 = r7;
            goto L18
        L13:
            r6 = r5;
            goto L14
        L9:
            r4 = r2;
            goto L10
        L5:
            r3 = r1;
            goto L6
        }

        public static p b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "commentId");
            String r3 = StringsKt.trim(r2).toString();
            if (r3.length() <= 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r3 = null;
        L10:
            if (r3 != null) goto L12;
            return null;
        L12:
            return new p(r3, 62);
        L5:
            r0 = false;
            goto L7
        }
    }

    static {
    }

    public p() {
        this(null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
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
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "CommentVoiceSimpleTarget(commentId=" + this.a + ", replyId=" + this.b + ", localCommentId=" + this.c + ", temporaryCommentId=" + this.d + ", requestType=" + this.e + ", isWhole=" + this.f + ')';
    }

    public /* synthetic */ p(String r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r11 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r11 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r11 & 8) == 0) goto L17;
        String r6 = "";
    L18:
        this(r3, r4, r5, r6, 0, false);
        return;
    L17:
        r6 = null;
        goto L18
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public p(String r2, String r3, String r4, String r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        Intrinsics.checkNotNullParameter(r4, "localCommentId");
        Intrinsics.checkNotNullParameter(r5, "temporaryCommentId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
