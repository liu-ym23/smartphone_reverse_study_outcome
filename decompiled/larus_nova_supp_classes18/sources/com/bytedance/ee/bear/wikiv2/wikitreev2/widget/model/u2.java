package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u2<V> implements Callable {
    public final /* synthetic */ s2 a;
    public final /* synthetic */ TreeNode b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public u2(s2 r1, TreeNode r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        tt5.a.h(this.a.a.mTAG, "onTreeNodeTokenChanged, del fake children to db. ");
        WikiDatabase.c().d().c(this.b.space_id, CollectionsKt.listOf(this.c));
        tt5.a.h(this.a.a.mTAG, "onTreeNodeTokenChanged, save children to db. ");
        WikiTreeModelV2 r0 = this.a.a;
        Intrinsics.checkNotNull(this.d);
        t1.l(r0, this.d);
        tt5.a.h(this.a.a.mTAG, "onTreeNodeTokenChanged end. ");
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
