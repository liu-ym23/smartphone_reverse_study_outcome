package com.bytedance.ee.bear.wikiv2.wikitreev2;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TreeNode f241450c;

    public h(String r100, String r101, TreeNode r102) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Intrinsics.checkNotNullParameter(r101, "fakeToken");
        Intrinsics.checkNotNullParameter(r102, "treeNode");
        this.f241448a = r100;
        this.f241449b = r101;
        this.f241450c = r102;
    }
}
