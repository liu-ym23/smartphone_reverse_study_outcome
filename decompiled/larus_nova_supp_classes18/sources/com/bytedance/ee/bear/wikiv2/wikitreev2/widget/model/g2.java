package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Function3;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g2<T1, T2, T3, R> implements Function3 {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ Function2<List<TreeNode>, Boolean, Boolean> b;

    /* JADX WARN: Multi-variable type inference failed */
    public g2(WikiTreeModel r1, Function2<? super List<TreeNode>, ? super Boolean, Boolean> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r2, Object r3, Object r4) {
        up5.b r5 = (up5.b) r2;
        List r6 = (List) r3;
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "children");
        Intrinsics.checkNotNullParameter((SpaceInfo) r4, "spaceInfo");
        tt5.a.h("Wiki_WikiTreeRepository", "requestWikiTree, load relation from network. ");
        if (r5.b() == true) goto L6;
        e3 r7 = this.a.workspace;
        TreeNode r8 = (TreeNode) r5.a();
        Map<String, TreeNode> r9 = r7.g;
        ConcurrentHashMap r10 = (ConcurrentHashMap) r9;
        r10.put(r8.wiki_token, r8);
    L6:
        return (Boolean) this.b.invoke(r6, Boolean.FALSE);
    }
}
