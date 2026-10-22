package com.bytedance.android.shopping.commentv3.uitree.list;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.shopping.commentv3.base.b {
    public final lc3.b a;

    public final int hashCode() {
        lc3.b r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "CommentListState(componentModel=" + this.a + ")";
    }

    public b(lc3.b r2) {
        Intrinsics.checkNotNullParameter(r2, "componentModel");
        this.a = r2;
    }

    public final boolean equals(Object r1) {
        return super.equals(r1);
    }
}
