package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s1<V> implements Callable {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ String b;

    public s1(WikiTreeModel r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        tt5.a.h("Wiki_WikiTreeRepository", "addBatchNodes, save children to db. ");
        t1.l(this.a, this.b);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
