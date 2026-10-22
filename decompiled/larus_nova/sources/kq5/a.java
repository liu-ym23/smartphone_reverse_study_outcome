package kq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.SidebarTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yq5.s;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResultCode f505591a;

    @Override // kq5.c
    public final void a(SidebarTreeCtrlView r100, e3 r101) {
        Intrinsics.checkNotNullParameter(r100, "treeCtrlView");
        Intrinsics.checkNotNullParameter(r101, "workspace");
    }

    public abstract String d();

    public abstract void e(String r100, WikiRelation.Tree r101);

    @Override // kq5.c
    public final ResultCode b() {
        return this.f505591a;
    }

    public a(ResultCode r100) {
        Intrinsics.checkNotNullParameter(r100, "resultCode");
        this.f505591a = r100;
    }

    @Override // kq5.c
    public final WikiRelation c(WikiRelation r110, WikiRelation r111, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r112) {
        Intrinsics.checkNotNullParameter(r110, "appendRelation");
        Intrinsics.checkNotNullParameter(r111, "originRelation");
        Intrinsics.checkNotNullParameter(r112, "uiCache");
        tt5.a.h(d(), "handleDecorateRelation start");
        if (r110.isValid() == true) goto L5;
        return r111;
    L5:
        WikiRelation.Tree r100 = r110.tree;
        ArrayList r101 = new ArrayList();
        r101.addAll(r100.root_list);
        Iterator r102 = ((ArrayList) WikiDatabase.c().d().g(r101)).iterator();
    L6:
        TreeNode r103 = null;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r104 = null;
        r104 = null;
        r104 = null;
        r104 = null;
        if (r102.hasNext() == false) goto L39;
        yq5.b r105 = (yq5.b) r102.next();
        Intrinsics.checkNotNull(r105);
        TreeNode r106 = s.f(r105);
        Intrinsics.checkNotNull(r100);
        e.b(r106, r100, false);
        String r107 = r106.wiki_token;
        String r108 = r106.space_id;
        boolean r109 = true;
        if (r107 != null) goto L11;
        r112.getClass();
    L27:
        if (r107 == null) goto L6;
        if (r104 != null) goto L30;
    L32:
        r109 = false;
    L33:
        if (r109 == false) goto L6;
        WikiRelation r113 = s.e(WikiDatabase.c().d().i(r108), r107);
        boolean r114 = r113.isValid();
        tt5.a.h(d(), "syncSecondChildrenNodes, load relation from db. valid: " + r114);
        if (r114 == false) goto L37;
        e.e(r113.tree, r110.tree);
        goto L6
    L37:
        r104.f241735d = false;
        goto L6
    L30:
        if (r104.f241735d != true) goto L32;
    L11:
        List<String> r115 = r112.f241741b.get(r107);
        if (r115 == null) goto L27;
        if (hu5.a.d(r115) == true) goto L27;
        Iterator<T> r116 = r115.iterator();
    L18:
        if (r116.hasNext() == false) goto L27;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r117 = r112.f241740a.get((String) r116.next());
        if (r117 != null) goto L22;
    L24:
        boolean r118 = false;
    L25:
        if (r118 == false) goto L18;
        r104 = r117;
        goto L27
    L22:
        if (r117.f241735d != true) goto L24;
        r118 = true;
        goto L25
    L39:
        WikiRelation.Tree r119 = r110.tree;
        String r120 = r119.root_token;
        HashMap<String, TreeNode> r121 = r119.nodes;
        if (r121 == null) goto L42;
        r103 = r121.get(r120);
    L42:
        WikiRelation.Tree r122 = r111.tree;
        Intrinsics.checkNotNull(r120);
        Intrinsics.checkNotNull(r122);
        e(r120, r122);
        if (r103 == null) goto L47;
        r103.parent_wiki_token = r122.root_token;
        e.b(r103, r122, false);
        String r123 = r103.wiki_token;
        if (r122.child_map.get(r123) != null) goto L47;
        r122.child_map.put(r123, new ArrayList());
    L47:
        Intrinsics.checkNotNull(r119);
        e.e(r119, r122);
        return r111;
    }
}
