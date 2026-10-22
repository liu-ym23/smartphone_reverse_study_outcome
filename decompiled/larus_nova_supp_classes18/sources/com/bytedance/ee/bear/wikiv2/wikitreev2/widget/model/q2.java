package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q2<V> implements Callable {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ TreeNode b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public q2(WikiTreeModel r1, TreeNode r2, String r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        yq5.f r0 = WikiDatabase.c().d();
        int r1 = i.a;
        r0.m(i.a.a(this.a.workspace, this.b, this.a.userComponentAbility), this.c, this.d, this.e);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
