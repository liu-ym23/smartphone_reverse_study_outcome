package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationInsert;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z1<T, R> implements Function {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IOperationInsert.TreeNodeInsertParams c;

    public z1(WikiTreeModel r1, String r2, IOperationInsert.TreeNodeInsertParams r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r5) {
        TreeNode r6 = (TreeNode) r5;
        Intrinsics.checkNotNullParameter(r6, "newInsertNode");
        WikiTreeModel r0 = this.a;
        String r1 = this.b;
        Intrinsics.checkNotNull(r1);
        IOperationInsert.TreeNodeInsertParams r2 = this.c;
        return t1.b(r0, r1, r6, r2.forceExpand, r2.uid);
    }
}
