package com.bytedance.ee.bear.wikiv2.wikitreev2;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public final String a;
    public final String b;
    public final TreeNode c;

    public h(String r2, String r3, TreeNode r4) {
        Intrinsics.checkNotNullParameter(r2, "spaceId");
        Intrinsics.checkNotNullParameter(r3, "fakeToken");
        Intrinsics.checkNotNullParameter(r4, "treeNode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
