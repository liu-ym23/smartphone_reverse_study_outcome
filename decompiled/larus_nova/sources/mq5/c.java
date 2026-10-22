package mq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends mq5.a {

    public static final class a {
    }

    static {
    }

    @Override // mq5.a
    public final String d() {
        return "RelationDecoration-Personal#2";
    }

    public c(ResultCode r100) {
        Intrinsics.checkNotNullParameter(r100, "resultCode");
        super(r100);
    }

    @Override // mq5.a
    public final void e(WikiRelation r100) {
        Intrinsics.checkNotNullParameter(r100, "originRelation");
        this.f514880a.isDEC1();
    }

    @Override // mq5.a
    public final void f(WikiRelation r100, WikiRelation r101, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r102) {
        Intrinsics.checkNotNullParameter(r100, "appendRelation");
        Intrinsics.checkNotNullParameter(r101, "originRelation");
        Intrinsics.checkNotNullParameter(r102, "uiCache");
        WikiRelation.Tree r103 = r101.tree;
        WikiRelation.Tree r104 = r100.tree;
        if (r104 == null) goto L8;
        TreeNode r105 = kq5.e.d(r104, r104.root_token);
        if (r105 == null) goto L7;
        Intrinsics.checkNotNull(r103);
        g(r103, r105, r102);
    L7:
        Intrinsics.checkNotNull(r103);
        kq5.e.c(r104, r103);
    L8:
        SpaceInfo r106 = r100.f241731space;
        if (r106 == null) goto L11;
        r101.f241731space = r106;
    L11:
        SpacePerm r107 = r100.space_perm;
        if (r107 == null) goto L14;
        r101.space_perm = r107;
    L14:
        SpaceUserPerm r108 = r100.user_space_perm;
        if (r108 == null) goto L18;
        r101.user_space_perm = r108;
        return;
    }
}
