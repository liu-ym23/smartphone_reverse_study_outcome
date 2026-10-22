package com.bytedance.ee.bear.document.comment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class w2 implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f219378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f219379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f219380c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w2) == true) goto L8;
        return false;
    L8:
        w2 r101 = (w2) r100;
        if (this.f219378a == r101.f219378a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f219379b, r101.f219379b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f219380c, r101.f219380c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f219378a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f219379b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f219380c;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "SendCommentEvent(isReply=" + this.f219378a + ", commentId=" + this.f219379b + ", localCommentId=" + this.f219380c + ')';
    }

    public w2(boolean r100, String r101, String r102) {
        this.f219378a = r100;
        this.f219379b = r101;
        this.f219380c = r102;
    }
}
