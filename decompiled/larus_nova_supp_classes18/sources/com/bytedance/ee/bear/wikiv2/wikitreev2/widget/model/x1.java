package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x1<V> implements Callable {
    public final /* synthetic */ e a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ WikiTreeModel d;

    public x1(e r1, ArrayList r2, boolean r3, WikiTreeModel r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        tt5.a.h("Wiki_WikiTreeRepository", "movBatchNodes, update children to db. ");
        List r0 = CollectionsKt.mutableListOf(new String[]{this.a.a});
        r0.addAll(this.b);
        if (this.c == false) goto L5;
        r0.add(this.a.b);
    L5:
        t1.a(this.d, r0);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
