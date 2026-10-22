package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f230503g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f230504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f230505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f230506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f230507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f230508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f230509f;

    public static final class a {
        public static p a(CommentInputRequest r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            String r101 = r100.comment_id;
            if (r101 != null) goto L5;
            String r102 = "";
        L6:
            String r103 = r100.reply_id;
            if (r103 != null) goto L9;
            String r104 = "";
        L10:
            String r105 = r100.local_comment_id;
            if (r105 != null) goto L13;
            String r106 = "";
        L14:
            String r107 = r100.tmpCommentId;
            if (r107 != null) goto L17;
            String r108 = "";
        L18:
            String r109 = r102;
            String r110 = r104;
            String r111 = r106;
            String r112 = r108;
            return new p(r109, r110, r111, r112, r100.type, r100.is_whole);
        L17:
            r108 = r107;
            goto L18
        L13:
            r106 = r105;
            goto L14
        L9:
            r104 = r103;
            goto L10
        L5:
            r102 = r101;
            goto L6
        }

        public static p b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "commentId");
            String r101 = StringsKt.trim(r100).toString();
            if (r101.length() <= 0) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == true) goto L10;
            r101 = null;
        L10:
            if (r101 != null) goto L12;
            return null;
        L12:
            return new p(r101, 62);
        L5:
            r102 = false;
            goto L7
        }
    }

    static {
    }

    public p() {
        this(null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f230504a, r101.f230504a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f230505b, r101.f230505b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f230506c, r101.f230506c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f230507d, r101.f230507d) == true) goto L21;
        return false;
    L21:
        if (this.f230508e == r101.f230508e) goto L24;
        return false;
    L24:
        if (this.f230509f == r101.f230509f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f230504a.hashCode() * 31) + this.f230505b.hashCode()) * 31) + this.f230506c.hashCode()) * 31) + this.f230507d.hashCode()) * 31) + this.f230508e) * 31;
        if (this.f230509f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "CommentVoiceSimpleTarget(commentId=" + this.f230504a + ", replyId=" + this.f230505b + ", localCommentId=" + this.f230506c + ", temporaryCommentId=" + this.f230507d + ", requestType=" + this.f230508e + ", isWhole=" + this.f230509f + ')';
    }

    public /* synthetic */ p(String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r103 = "";
    L18:
        this(r100, r101, r102, r103, 0, false);
        return;
    L17:
        r103 = null;
        goto L18
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public p(String r100, String r101, String r102, String r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r101, "replyId");
        Intrinsics.checkNotNullParameter(r102, "localCommentId");
        Intrinsics.checkNotNullParameter(r103, "temporaryCommentId");
        this.f230504a = r100;
        this.f230505b = r101;
        this.f230506c = r102;
        this.f230507d = r103;
        this.f230508e = r104;
        this.f230509f = r105;
    }
}
