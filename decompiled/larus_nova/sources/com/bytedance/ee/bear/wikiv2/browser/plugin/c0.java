package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TreeNode f240538a;

    public c0(TreeNode r100) {
        this.f240538a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TreeNode r101 = this.f240538a;
        r101.origin_title = ((DocMetaInfo) r100).getTitle();
    }
}
