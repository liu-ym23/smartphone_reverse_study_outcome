package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top;

import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final SpaceInfo a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "spaceId");
        SpaceInfo r0 = new SpaceInfo();
        r0.space_id = r3;
        r0.space_name = "";
        r0.space_icon = "";
        r0.tenant_id = "";
        r0.description = "";
        r0.is_star = false;
        r0.space_type = 3;
        r0.wiki_scope = 0;
        r0.open_sharing = 2;
        r0.owner_perm_type = 1;
        r0.create_uid = "";
        SpaceInfo.SpaceCover r2 = new SpaceInfo.SpaceCover();
        r2.origin = "";
        r2.thumbnail = "";
        r2.key = "";
        r2.is_graph_dark = false;
        r2.color_value = "";
        r0.space_cover = r2;
        return r0;
    }

    @JvmStatic
    public static final TreeNode b(VirtualNode r3) {
        Intrinsics.checkNotNullParameter(r3, "virtualNode");
        TreeNode r0 = new TreeNode();
        r0.space_id = r3.getSpaceId();
        r0.wiki_token = r3.getRootToken();
        r0.obj_token = r3.getRootToken();
        r0.obj_type = e.e.b;
        r0.title = eu5.b.a.getString(r3.getTitle());
        r0.parent_wiki_token = "";
        r0.wiki_node_type = r3.getWikiNodeType();
        r0.origin_wiki_token = r3.getRootToken();
        r0.origin_space_id = r3.getSpaceId();
        r0.is_star = false;
        r0.has_child = false;
        r0.secret_key_delete = false;
        r0.is_explorer_star = false;
        r0.is_explorer_pin = false;
        r0.origin_is_external = false;
        r0.entity_delete_flag = 0;
        r0.origin_title = "";
        r0.perm = WikNodePerm.defaulted();
        return r0;
    }
}
