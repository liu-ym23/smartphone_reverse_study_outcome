package kq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.SidebarTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b implements c {
    public final ResultCode a;

    @Override // kq5.c
    public final void a(SidebarTreeCtrlView r2, e3 r3) {
        Intrinsics.checkNotNullParameter(r2, "treeCtrlView");
        Intrinsics.checkNotNullParameter(r3, "workspace");
    }

    public abstract String d();

    public abstract void e(WikiRelation r1);

    public abstract void f(String r1, WikiRelation.Tree r2);

    @Override // kq5.c
    public final ResultCode b() {
        return this.a;
    }

    public b(ResultCode r2) {
        Intrinsics.checkNotNullParameter(r2, "resultCode");
        this.a = r2;
    }

    public final void g(TreeNode r3, WikiRelation.Tree r4) {
        Intrinsics.checkNotNullParameter(r4, "parentTree");
        if (r3 == null) goto L11;
        r3.parent_wiki_token = r4.root_token;
        TreeNode r0 = e.d(r4, r3.wiki_token);
        if (r0 == null) goto L7;
        r0.has_child = r3.has_child;
        r0.parent_wiki_token = r3.parent_wiki_token;
    L7:
        e.b(r3, r4, false);
        String r5 = r3.wiki_token;
        if (r4.child_map.get(r5) != null) goto L12;
        r4.child_map.put(r5, new ArrayList());
        return;
    L12:
        return;
    }

    @Override // kq5.c
    public final WikiRelation c(WikiRelation r3, WikiRelation r4, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r5) {
        Intrinsics.checkNotNullParameter(r3, "appendRelation");
        Intrinsics.checkNotNullParameter(r4, "originRelation");
        Intrinsics.checkNotNullParameter(r5, "uiCache");
        tt5.a.h(d(), "handleDecorateRelation start");
        if (r3.isValid() == true) goto L5;
        e(r4);
    L10:
        return r4;
    L5:
        WikiRelation.Tree r6 = r3.tree;
        String r7 = r6.root_token;
        HashMap<String, TreeNode> r0 = r6.nodes;
        if (r0 == null) goto L8;
        TreeNode r1 = r0.get(r7);
    L9:
        WikiRelation.Tree r2 = r4.tree;
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNull(r2);
        f(r7, r2);
        g(r1, r2);
        Intrinsics.checkNotNull(r6);
        e.c(r6, r2);
        goto L10
    L8:
        r1 = null;
        goto L9
    }
}
