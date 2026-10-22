package mq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.SidebarEmptyState;
import com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.SidebarTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a implements kq5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResultCode f514880a;

    /* JADX INFO: renamed from: mq5.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6841a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f514881a = null;

        static {
            int[] r100 = new int[ResultCode.values().length];
            r100[ResultCode.DECO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ResultCode.DEC1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ResultCode.DEC2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f514881a = r100;
        }
    }

    public abstract String d();

    public abstract void e(WikiRelation r100);

    public abstract void f(WikiRelation r100, WikiRelation r101, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r102);

    @Override // kq5.c
    public final ResultCode b() {
        return this.f514880a;
    }

    public a(ResultCode r100) {
        Intrinsics.checkNotNullParameter(r100, "resultCode");
        this.f514880a = r100;
    }

    @Override // kq5.c
    public final void a(SidebarTreeCtrlView r100, e3 r101) {
        Intrinsics.checkNotNullParameter(r100, "treeCtrlView");
        Intrinsics.checkNotNullParameter(r101, "workspace");
        ResultCode r102 = this.f514880a;
        int r103 = C6841a.f514881a[r102.ordinal()];
        if (r103 != 1) goto L5;
        Map<String, List<String>> r104 = r101.f241832f;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        if (hu5.a.d((List) r105.get(r101.f241828b)) == false) goto L17;
        SidebarEmptyState r106 = SidebarEmptyState.EMPTY;
        int r107 = SidebarTreeCtrlView.f241263y;
        r100.v(r106, true);
        return;
    L17:
        SidebarEmptyState r108 = SidebarEmptyState.OK;
        int r109 = SidebarTreeCtrlView.f241263y;
        r100.v(r108, true);
        return;
    L5:
        if (r103 != 2) goto L7;
        SidebarEmptyState r110 = SidebarEmptyState.EMPTY;
        int r111 = SidebarTreeCtrlView.f241263y;
        r100.v(r110, true);
        return;
    L7:
        if (r103 != 3) goto L12;
        Map<String, List<String>> r112 = r101.f241832f;
        ConcurrentHashMap r113 = (ConcurrentHashMap) r112;
        if (hu5.a.d((List) r113.get(r101.f241828b)) == false) goto L19;
        SidebarEmptyState r114 = SidebarEmptyState.ERROR;
        int r115 = SidebarTreeCtrlView.f241263y;
        r100.v(r114, true);
        return;
    L19:
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kq5.c
    public final WikiRelation c(WikiRelation r100, WikiRelation r101, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r102) {
        Intrinsics.checkNotNullParameter(r100, "appendRelation");
        Intrinsics.checkNotNullParameter(r101, "originRelation");
        Intrinsics.checkNotNullParameter(r102, "uiCache");
        tt5.a.h(d(), "handleDecorateRelation start");
        if (r100.isValid() == true) goto L5;
        e(r101);
    L6:
        return r101;
    L5:
        f(r100, r101, r102);
        goto L6
    }

    public final void g(WikiRelation.Tree r100, TreeNode r101, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r102) {
        Intrinsics.checkNotNullParameter(r100, "parentTree");
        Intrinsics.checkNotNullParameter(r101, "realTreeNode");
        Intrinsics.checkNotNullParameter(r102, "uiCache");
        String r103 = r101.wiki_token;
        String r104 = r100.root_token;
        if (Intrinsics.areEqual(r104, r104) == false) goto L30;
        if (r103 == null) goto L33;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "treeNode");
        String r105 = r101.wiki_token;
        String r106 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r105, r105, 0, "");
        if (r102.f241740a.get(r106) != null) goto L10;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r107 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a(r106, r106, r105);
        r107.f241736e = 0;
        r107.f241735d = true;
        r102.f241740a.put(r106, r107);
    L10:
        if (r102.f241741b.get(r105) != null) goto L12;
        ConcurrentHashMap<String, List<String>> r108 = r102.f241741b;
        ArrayList r109 = new ArrayList();
        r109.add(r106);
        r108.put(r105, r109);
    L12:
        tt5.a.h(d(), "updateRootToken, " + du5.b.i(r100.root_token) + " -> " + du5.b.g(r103));
        r100.root_token = r103;
        List<String> r110 = r100.root_list;
        if (r110 == null) goto L19;
        int r111 = r110.indexOf(r104);
        if (r111 < 0) goto L19;
        List<String> r112 = r100.root_list;
        if (r112 == null) goto L19;
        String r113 = (String) ListProtector.set(r112, r111, r103);
    L19:
        HashMap<String, List<String>> r114 = r100.child_map;
        if (r114 == null) goto L24;
        List<String> r115 = r114.get(r104);
        if (r115 == null) goto L24;
        r100.child_map.put(r103, r115);
        List<String> r116 = r100.child_map.remove(r104);
    L24:
        HashMap<String, TreeNode> r117 = r100.nodes;
        if (r117 == null) goto L31;
        TreeNode r118 = r117.get(r104);
        if (r118 == null) goto L32;
        r101.wiki_node_type = r118.wiki_node_type;
        r101.title = r118.title;
        r100.nodes.put(r103, r101);
        TreeNode r119 = r100.nodes.remove(r104);
        return;
    L32:
        return;
    L31:
        return;
    L33:
        return;
    }
}
