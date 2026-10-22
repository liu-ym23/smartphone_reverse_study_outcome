package kq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.SidebarTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResultCode f505592a;

    @Override // kq5.c
    public final void a(SidebarTreeCtrlView r100, e3 r101) {
        Intrinsics.checkNotNullParameter(r100, "treeCtrlView");
        Intrinsics.checkNotNullParameter(r101, "workspace");
    }

    public abstract String d();

    public abstract void e(WikiRelation r100);

    public abstract void f(String r100, WikiRelation.Tree r101);

    @Override // kq5.c
    public final ResultCode b() {
        return this.f505592a;
    }

    public b(ResultCode r100) {
        Intrinsics.checkNotNullParameter(r100, "resultCode");
        this.f505592a = r100;
    }

    public final void g(TreeNode r100, WikiRelation.Tree r101) {
        Intrinsics.checkNotNullParameter(r101, "parentTree");
        if (r100 == null) goto L11;
        r100.parent_wiki_token = r101.root_token;
        TreeNode r102 = e.d(r101, r100.wiki_token);
        if (r102 == null) goto L7;
        r102.has_child = r100.has_child;
        r102.parent_wiki_token = r100.parent_wiki_token;
    L7:
        e.b(r100, r101, false);
        String r103 = r100.wiki_token;
        if (r101.child_map.get(r103) != null) goto L12;
        r101.child_map.put(r103, new ArrayList());
        return;
    L12:
        return;
    }

    @Override // kq5.c
    public final WikiRelation c(WikiRelation r100, WikiRelation r101, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r102) {
        Intrinsics.checkNotNullParameter(r100, "appendRelation");
        Intrinsics.checkNotNullParameter(r101, "originRelation");
        Intrinsics.checkNotNullParameter(r102, "uiCache");
        tt5.a.h(d(), "handleDecorateRelation start");
        if (r100.isValid() == true) goto L5;
        e(r101);
    L10:
        return r101;
    L5:
        WikiRelation.Tree r103 = r100.tree;
        String r104 = r103.root_token;
        HashMap<String, TreeNode> r105 = r103.nodes;
        if (r105 == null) goto L8;
        TreeNode r106 = r105.get(r104);
    L9:
        WikiRelation.Tree r107 = r101.tree;
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNull(r107);
        f(r104, r107);
        g(r106, r107);
        Intrinsics.checkNotNull(r103);
        e.c(r103, r107);
        goto L10
    L8:
        r106 = null;
        goto L9
    }
}
