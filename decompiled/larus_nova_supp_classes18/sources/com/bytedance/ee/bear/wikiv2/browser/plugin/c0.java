package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ TreeNode a;

    public c0(TreeNode r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        TreeNode r0 = this.a;
        r0.origin_title = ((DocMetaInfo) r2).getTitle();
    }
}
