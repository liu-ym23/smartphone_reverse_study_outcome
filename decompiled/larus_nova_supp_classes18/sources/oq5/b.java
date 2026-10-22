package oq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends kq5.b {

    public static final class a {
    }

    static {
    }

    @Override // kq5.b
    public final String d() {
        return "RelationDecoration-SpaceWiki#2";
    }

    public b(ResultCode r2) {
        Intrinsics.checkNotNullParameter(r2, "resultCode");
        super(r2);
    }

    @Override // kq5.b
    public final void e(WikiRelation r4) {
        Intrinsics.checkNotNullParameter(r4, "originRelation");
        if (this.a.isDEC1() == true) goto L5;
        return;
    L5:
        WikiRelation.Tree r5 = r4.tree;
        if (r5 == null) goto L16;
        VirtualNode r0 = VirtualNode.TITLE_ROOT_SPACE;
        TreeNode r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.b.b(r0);
        String r2 = r0.getRootToken();
        g(r1, r5);
        HashMap<String, TreeNode> r3 = r5.nodes;
        if (r3 == null) goto L12;
        TreeNode r6 = r3.get(r2);
        if (r6 == null) goto L12;
        r6.has_child = false;
    L12:
        HashMap<String, List<String>> r7 = r5.child_map;
        if (r7 == null) goto L17;
        r7.put(r2, new ArrayList());
        return;
    L17:
        return;
    }

    @Override // kq5.b
    public final void f(String r2, WikiRelation.Tree r3) {
        Intrinsics.checkNotNullParameter(r2, "virtualNodeToken");
        Intrinsics.checkNotNullParameter(r3, "parentTree");
        r3.spaceRootToken = r2;
    }
}
