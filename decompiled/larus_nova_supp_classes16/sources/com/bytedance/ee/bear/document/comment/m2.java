package com.bytedance.ee.bear.document.comment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m2 implements o2 {
    public final String a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m2) == true) goto L8;
        return false;
    L8:
        m2 r6 = (m2) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "CommentSwitchCardEvent(commentId=" + this.a + ", commentUUID=" + this.b + ')';
    }

    public m2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "commentUUID");
        this.a = r2;
        this.b = r3;
    }
}
