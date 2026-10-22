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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a implements c {
    public final ResultCode a;

    @Override // kq5.c
    public final void a(SidebarTreeCtrlView r2, e3 r3) {
        Intrinsics.checkNotNullParameter(r2, "treeCtrlView");
        Intrinsics.checkNotNullParameter(r3, "workspace");
    }

    public abstract String d();

    public abstract void e(String r1, WikiRelation.Tree r2);

    @Override // kq5.c
    public final ResultCode b() {
        return this.a;
    }

    public a(ResultCode r2) {
        Intrinsics.checkNotNullParameter(r2, "resultCode");
        this.a = r2;
    }

    @Override // kq5.c
    public final WikiRelation c(WikiRelation r11, WikiRelation r12, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r13) {
        Intrinsics.checkNotNullParameter(r11, "appendRelation");
        Intrinsics.checkNotNullParameter(r12, "originRelation");
        Intrinsics.checkNotNullParameter(r13, "uiCache");
        tt5.a.h(d(), "handleDecorateRelation start");
        if (r11.isValid() == true) goto L5;
        return r12;
    L5:
        WikiRelation.Tree r0 = r11.tree;
        ArrayList r1 = new ArrayList();
        r1.addAll(r0.root_list);
        Iterator r2 = ((ArrayList) WikiDatabase.c().d().g(r1)).iterator();
    L6:
        TreeNode r4 = null;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        if (r2.hasNext() == false) goto L39;
        yq5.b r3 = (yq5.b) r2.next();
        Intrinsics.checkNotNull(r3);
        TreeNode r6 = s.f(r3);
        Intrinsics.checkNotNull(r0);
        e.b(r6, r0, false);
        String r7 = r6.wiki_token;
        String r8 = r6.space_id;
        boolean r9 = true;
        if (r7 != null) goto L11;
        r13.getClass();
    L27:
        if (r7 == null) goto L6;
        if (r5 != null) goto L30;
    L32:
        r9 = false;
    L33:
        if (r9 == false) goto L6;
        WikiRelation r10 = s.e(WikiDatabase.c().d().i(r8), r7);
        boolean r14 = r10.isValid();
        tt5.a.h(d(), "syncSecondChildrenNodes, load relation from db. valid: " + r14);
        if (r14 == false) goto L37;
        e.e(r10.tree, r11.tree);
        goto L6
    L37:
        r5.d = false;
        goto L6
    L30:
        if (r5.d != true) goto L32;
    L11:
        List<String> r15 = r13.b.get(r7);
        if (r15 == null) goto L27;
        if (hu5.a.d(r15) == true) goto L27;
        Iterator<T> r16 = r15.iterator();
    L18:
        if (r16.hasNext() == false) goto L27;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r17 = r13.a.get((String) r16.next());
        if (r17 != null) goto L22;
    L24:
        boolean r18 = false;
    L25:
        if (r18 == false) goto L18;
        r5 = r17;
        goto L27
    L22:
        if (r17.d != true) goto L24;
        r18 = true;
        goto L25
    L39:
        WikiRelation.Tree r19 = r11.tree;
        String r110 = r19.root_token;
        HashMap<String, TreeNode> r20 = r19.nodes;
        if (r20 == null) goto L42;
        r4 = r20.get(r110);
    L42:
        WikiRelation.Tree r21 = r12.tree;
        Intrinsics.checkNotNull(r110);
        Intrinsics.checkNotNull(r21);
        e(r110, r21);
        if (r4 == null) goto L47;
        r4.parent_wiki_token = r21.root_token;
        e.b(r4, r21, false);
        String r111 = r4.wiki_token;
        if (r21.child_map.get(r111) != null) goto L47;
        r21.child_map.put(r111, new ArrayList());
    L47:
        Intrinsics.checkNotNull(r19);
        e.e(r19, r21);
        return r12;
    }
}
