package xp5;

import com.bytedance.ee.bear.contract.route.parcelable.m;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {
    public static final TreeNode a(m r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        TreeNode r101 = new TreeNode();
        r101.space_id = r100.f217172b;
        r101.wiki_token = r100.f217171a;
        r101.obj_token = r100.f217174d;
        r101.obj_type = r100.f217175e;
        r101.title = r100.f217179i;
        r101.parent_wiki_token = r100.f217177g;
        r101.sort_id = r100.f217181k;
        r101.wiki_node_type = r100.f217178h;
        r101.origin_wiki_token = r100.f217176f;
        r101.origin_space_id = r100.f217173c;
        r101.is_star = false;
        r101.has_child = false;
        r101.secret_key_delete = false;
        r101.is_explorer_star = false;
        r101.is_explorer_pin = false;
        r101.origin_is_external = false;
        r101.entity_delete_flag = 0;
        r101.origin_title = r100.f217180j;
        return r101;
    }
}
