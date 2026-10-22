package xp5;

import com.bytedance.ee.bear.contract.route.parcelable.m;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public static final TreeNode a(m r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        TreeNode r0 = new TreeNode();
        r0.space_id = r3.b;
        r0.wiki_token = r3.a;
        r0.obj_token = r3.d;
        r0.obj_type = r3.e;
        r0.title = r3.i;
        r0.parent_wiki_token = r3.g;
        r0.sort_id = r3.k;
        r0.wiki_node_type = r3.h;
        r0.origin_wiki_token = r3.f;
        r0.origin_space_id = r3.c;
        r0.is_star = false;
        r0.has_child = false;
        r0.secret_key_delete = false;
        r0.is_explorer_star = false;
        r0.is_explorer_pin = false;
        r0.origin_is_external = false;
        r0.entity_delete_flag = 0;
        r0.origin_title = r3.j;
        return r0;
    }
}
