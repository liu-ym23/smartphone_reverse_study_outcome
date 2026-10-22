package lq5;

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
        return "RelationDecoration-CloudDocument#2";
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
        TreeNode r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.b.b(VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT);
        String r1 = r0.wiki_token;
        g(r0, r5);
        HashMap<String, TreeNode> r2 = r5.nodes;
        if (r2 == null) goto L12;
        TreeNode r3 = r2.get(r1);
        if (r3 == null) goto L12;
        r3.has_child = false;
    L12:
        HashMap<String, List<String>> r6 = r5.child_map;
        if (r6 == null) goto L17;
        r6.put(r1, new ArrayList());
        return;
    L17:
        return;
    }

    @Override // kq5.b
    public final void f(String r2, WikiRelation.Tree r3) {
        Intrinsics.checkNotNullParameter(r2, "virtualNodeToken");
        Intrinsics.checkNotNullParameter(r3, "parentTree");
        r3.pinedRootToken = r2;
    }
}
