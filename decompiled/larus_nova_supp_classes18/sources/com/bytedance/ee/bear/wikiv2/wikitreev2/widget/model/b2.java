package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.BiFunction;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b2<T1, T2, R> implements BiFunction {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ Function2<List<TreeNode>, Boolean, Boolean> b;

    /* JADX WARN: Multi-variable type inference failed */
    public b2(WikiTreeModel r1, Function2<? super List<TreeNode>, ? super Boolean, Boolean> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r3, Object r4) {
        up5.b r5 = (up5.b) r3;
        List r6 = (List) r4;
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "children");
        tt5.a.h("Wiki_WikiTreeRepository", "requestWikiTree, load relation from network. ");
        if (r5.b() == true) goto L6;
        e3 r0 = this.a.workspace;
        TreeNode r7 = (TreeNode) r5.a();
        Map<String, TreeNode> r1 = r0.g;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        r2.put(r7.wiki_token, r7);
    L6:
        return (Boolean) this.b.invoke(r6, Boolean.FALSE);
    }
}
