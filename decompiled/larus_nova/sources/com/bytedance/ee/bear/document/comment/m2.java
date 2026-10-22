package com.bytedance.ee.bear.document.comment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class m2 implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f219332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f219333b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m2) == true) goto L8;
        return false;
    L8:
        m2 r101 = (m2) r100;
        if (Intrinsics.areEqual(this.f219332a, r101.f219332a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f219333b, r101.f219333b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f219332a.hashCode() * 31) + this.f219333b.hashCode();
    }

    public final String toString() {
        return "CommentSwitchCardEvent(commentId=" + this.f219332a + ", commentUUID=" + this.f219333b + ')';
    }

    public m2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r101, "commentUUID");
        this.f219332a = r100;
        this.f219333b = r101;
    }
}
