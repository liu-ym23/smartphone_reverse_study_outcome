package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u1<V> implements Callable {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ String d;

    public u1(WikiTreeModel r1, String r2, ArrayList r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        tt5.a.h("Wiki_WikiTreeRepository", "delBatchNodes, del children to db. ");
        yq5.f r0 = WikiDatabase.c().d();
        int r1 = i.a;
        String r2 = i.a.b(this.a.workspace, this.b, this.a.userComponentAbility);
        ArrayList r3 = this.c;
        WikiTreeModel r4 = this.a;
        r0.d(r2, r3, t1.g(r4, CollectionsKt.listOf(new String[]{this.d, r4.workspace.a})));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
