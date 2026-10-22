package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ TreeNode a;
    public final /* synthetic */ WikiDialogs b;

    public e0(TreeNode r1, WikiDialogs r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        WikNodePerm r5 = (WikNodePerm) r4;
        tt5.a.h(WikiFolderBlockMorePlugin.TAG, "get perm success, update it to moreProvider");
        TreeNode r0 = this.a;
        r0.perm = r5;
        WikiDialogs r1 = this.b;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j.a(r0, new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a());
        Intrinsics.checkNotNull(r5);
        r1.o(r2, r5);
    }
}
