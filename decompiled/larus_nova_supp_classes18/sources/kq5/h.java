package kq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.SidebarHomeTreeView;
import com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view.SidebarTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ SidebarHomeTreeView a;

    public h(SidebarHomeTreeView r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r6 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) r5;
        Intrinsics.checkNotNullParameter(r6, "node");
        boolean r2 = true;
        boolean r3 = false;
        if (r6.h != (-3)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        String r7 = r6.f;
        SidebarTreeCtrlView r1 = this.a.e;
        Intrinsics.checkNotNull(r7);
        TreeNode r8 = r1.g(r7);
        if (r8 == null) goto L15;
        if (r8.wiki_node_type == (-5)) goto L13;
        r2 = false;
    L13:
        r3 = r2;
    L15:
        return Boolean.valueOf(r3);
    L5:
        r0 = false;
        goto L6
    }
}
