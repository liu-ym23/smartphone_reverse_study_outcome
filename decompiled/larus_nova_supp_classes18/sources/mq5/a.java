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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a implements kq5.c {
    public final ResultCode a;

    /* JADX INFO: renamed from: mq5.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0270a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResultCode.values().length];
            r0[ResultCode.DECO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ResultCode.DEC1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ResultCode.DEC2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public abstract String d();

    public abstract void e(WikiRelation r1);

    public abstract void f(WikiRelation r1, WikiRelation r2, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r3);

    @Override // kq5.c
    public final ResultCode b() {
        return this.a;
    }

    public a(ResultCode r2) {
        Intrinsics.checkNotNullParameter(r2, "resultCode");
        this.a = r2;
    }

    @Override // kq5.c
    public final void a(SidebarTreeCtrlView r4, e3 r5) {
        Intrinsics.checkNotNullParameter(r4, "treeCtrlView");
        Intrinsics.checkNotNullParameter(r5, "workspace");
        ResultCode r0 = this.a;
        int r1 = C0270a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        Map<String, List<String>> r2 = r5.f;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        if (hu5.a.d((List) r3.get(r5.b)) == false) goto L17;
        SidebarEmptyState r6 = SidebarEmptyState.EMPTY;
        int r7 = SidebarTreeCtrlView.y;
        r4.v(r6, true);
        return;
    L17:
        SidebarEmptyState r8 = SidebarEmptyState.OK;
        int r9 = SidebarTreeCtrlView.y;
        r4.v(r8, true);
        return;
    L5:
        if (r1 != 2) goto L7;
        SidebarEmptyState r10 = SidebarEmptyState.EMPTY;
        int r11 = SidebarTreeCtrlView.y;
        r4.v(r10, true);
        return;
    L7:
        if (r1 != 3) goto L12;
        Map<String, List<String>> r12 = r5.f;
        ConcurrentHashMap r13 = (ConcurrentHashMap) r12;
        if (hu5.a.d((List) r13.get(r5.b)) == false) goto L19;
        SidebarEmptyState r14 = SidebarEmptyState.ERROR;
        int r15 = SidebarTreeCtrlView.y;
        r4.v(r14, true);
        return;
    L19:
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kq5.c
    public final WikiRelation c(WikiRelation r3, WikiRelation r4, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r5) {
        Intrinsics.checkNotNullParameter(r3, "appendRelation");
        Intrinsics.checkNotNullParameter(r4, "originRelation");
        Intrinsics.checkNotNullParameter(r5, "uiCache");
        tt5.a.h(d(), "handleDecorateRelation start");
        if (r3.isValid() == true) goto L5;
        e(r4);
    L6:
        return r4;
    L5:
        f(r3, r4, r5);
        goto L6
    }

    public final void g(WikiRelation.Tree r7, TreeNode r8, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r9) {
        Intrinsics.checkNotNullParameter(r7, "parentTree");
        Intrinsics.checkNotNullParameter(r8, "realTreeNode");
        Intrinsics.checkNotNullParameter(r9, "uiCache");
        String r0 = r8.wiki_token;
        String r1 = r7.root_token;
        if (Intrinsics.areEqual(r1, r1) == false) goto L30;
        if (r0 == null) goto L33;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "treeNode");
        String r2 = r8.wiki_token;
        String r3 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.a(r2, r2, 0, "");
        if (r9.a.get(r3) != null) goto L10;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r5 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a(r3, r3, r2);
        r5.e = 0;
        r5.d = true;
        r9.a.put(r3, r5);
    L10:
        if (r9.b.get(r2) != null) goto L12;
        ConcurrentHashMap<String, List<String>> r10 = r9.b;
        ArrayList r4 = new ArrayList();
        r4.add(r3);
        r10.put(r2, r4);
    L12:
        tt5.a.h(d(), "updateRootToken, " + du5.b.i(r7.root_token) + " -> " + du5.b.g(r0));
        r7.root_token = r0;
        List<String> r11 = r7.root_list;
        if (r11 == null) goto L19;
        int r12 = r11.indexOf(r1);
        if (r12 < 0) goto L19;
        List<String> r6 = r7.root_list;
        if (r6 == null) goto L19;
        String r13 = (String) ListProtector.set(r6, r12, r0);
    L19:
        HashMap<String, List<String>> r14 = r7.child_map;
        if (r14 == null) goto L24;
        List<String> r15 = r14.get(r1);
        if (r15 == null) goto L24;
        r7.child_map.put(r0, r15);
        List<String> r16 = r7.child_map.remove(r1);
    L24:
        HashMap<String, TreeNode> r17 = r7.nodes;
        if (r17 == null) goto L31;
        TreeNode r18 = r17.get(r1);
        if (r18 == null) goto L32;
        r8.wiki_node_type = r18.wiki_node_type;
        r8.title = r18.title;
        r7.nodes.put(r0, r8);
        TreeNode r19 = r7.nodes.remove(r1);
        return;
    L32:
        return;
    L31:
        return;
    L33:
        return;
    }
}
