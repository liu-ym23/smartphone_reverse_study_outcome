package oq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends kq5.b {

    public static final class a {
    }

    static {
    }

    @Override // kq5.b
    public final String d() {
        return "RelationDecoration-SpaceWiki#2";
    }

    public b(ResultCode r100) {
        Intrinsics.checkNotNullParameter(r100, "resultCode");
        super(r100);
    }

    @Override // kq5.b
    public final void e(WikiRelation r100) {
        Intrinsics.checkNotNullParameter(r100, "originRelation");
        if (this.f505592a.isDEC1() == true) goto L5;
        return;
    L5:
        WikiRelation.Tree r101 = r100.tree;
        if (r101 == null) goto L16;
        VirtualNode r102 = VirtualNode.TITLE_ROOT_SPACE;
        TreeNode r103 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.b.b(r102);
        String r104 = r102.getRootToken();
        g(r103, r101);
        HashMap<String, TreeNode> r105 = r101.nodes;
        if (r105 == null) goto L12;
        TreeNode r106 = r105.get(r104);
        if (r106 == null) goto L12;
        r106.has_child = false;
    L12:
        HashMap<String, List<String>> r107 = r101.child_map;
        if (r107 == null) goto L17;
        r107.put(r104, new ArrayList());
        return;
    L17:
        return;
    }

    @Override // kq5.b
    public final void f(String r100, WikiRelation.Tree r101) {
        Intrinsics.checkNotNullParameter(r100, "virtualNodeToken");
        Intrinsics.checkNotNullParameter(r101, "parentTree");
        r101.spaceRootToken = r100;
    }
}
