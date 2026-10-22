package mq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends mq5.a {

    public static final class a {
    }

    static {
    }

    @Override // mq5.a
    public final String d() {
        return "RelationDecoration-Personal#1";
    }

    @Override // mq5.a
    public final void e(WikiRelation r2) {
        Intrinsics.checkNotNullParameter(r2, "originRelation");
    }

    public b(ResultCode r2) {
        Intrinsics.checkNotNullParameter(r2, "resultCode");
        super(r2);
    }

    @Override // mq5.a
    public final void f(WikiRelation r4, WikiRelation r5, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r6) {
        Intrinsics.checkNotNullParameter(r4, "appendRelation");
        Intrinsics.checkNotNullParameter(r5, "originRelation");
        Intrinsics.checkNotNullParameter(r6, "uiCache");
        WikiRelation.Tree r0 = r5.tree;
        WikiRelation.Tree r1 = r4.tree;
        if (r1 == null) goto L8;
        TreeNode r2 = kq5.e.d(r1, r1.root_token);
        if (r2 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        g(r0, r2, r6);
    L7:
        Intrinsics.checkNotNull(r0);
        kq5.e.e(r1, r0);
    L8:
        SpaceInfo r7 = r4.space;
        if (r7 == null) goto L11;
        r5.space = r7;
    L11:
        SpacePerm r8 = r4.space_perm;
        if (r8 == null) goto L14;
        r5.space_perm = r8;
    L14:
        SpaceUserPerm r9 = r4.user_space_perm;
        if (r9 == null) goto L18;
        r5.user_space_perm = r9;
        return;
    }
}
