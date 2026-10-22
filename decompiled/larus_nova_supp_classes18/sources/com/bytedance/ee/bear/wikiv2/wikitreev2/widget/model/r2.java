package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r2<V> implements Callable {
    public final /* synthetic */ TreeNode a;
    public final /* synthetic */ String b;
    public final /* synthetic */ WikiTreeModel c;
    public final /* synthetic */ String d;

    public r2(TreeNode r1, String r2, WikiTreeModel r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        tt5.a.h("Wiki_WikiTreeRepository", "updateNodeToken, del fake children to db. ");
        WikiDatabase.c().d().c(this.a.space_id, CollectionsKt.listOf(this.b));
        tt5.a.h("Wiki_WikiTreeRepository", "updateNodeToken, save children to db. ");
        t1.l(this.c, this.d);
        tt5.a.h("Wiki_WikiTreeRepository", "updateNodeToken end. ");
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
