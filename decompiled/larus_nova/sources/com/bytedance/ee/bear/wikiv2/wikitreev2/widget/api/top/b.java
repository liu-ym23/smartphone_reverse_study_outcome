package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top;

import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f241720a = 0;

    static {
    }

    @JvmStatic
    public static final SpaceInfo a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        SpaceInfo r101 = new SpaceInfo();
        r101.space_id = r100;
        r101.space_name = "";
        r101.space_icon = "";
        r101.tenant_id = "";
        r101.description = "";
        r101.is_star = false;
        r101.space_type = 3;
        r101.wiki_scope = 0;
        r101.open_sharing = 2;
        r101.owner_perm_type = 1;
        r101.create_uid = "";
        SpaceInfo.SpaceCover r102 = new SpaceInfo.SpaceCover();
        r102.origin = "";
        r102.thumbnail = "";
        r102.key = "";
        r102.is_graph_dark = false;
        r102.color_value = "";
        r101.space_cover = r102;
        return r101;
    }

    @JvmStatic
    public static final TreeNode b(VirtualNode r100) {
        Intrinsics.checkNotNullParameter(r100, "virtualNode");
        TreeNode r101 = new TreeNode();
        r101.space_id = r100.getSpaceId();
        r101.wiki_token = r100.getRootToken();
        r101.obj_token = r100.getRootToken();
        r101.obj_type = e.f541294e.f541317b;
        r101.title = eu5.b.f474075a.getString(r100.getTitle());
        r101.parent_wiki_token = "";
        r101.wiki_node_type = r100.getWikiNodeType();
        r101.origin_wiki_token = r100.getRootToken();
        r101.origin_space_id = r100.getSpaceId();
        r101.is_star = false;
        r101.has_child = false;
        r101.secret_key_delete = false;
        r101.is_explorer_star = false;
        r101.is_explorer_pin = false;
        r101.origin_is_external = false;
        r101.entity_delete_flag = 0;
        r101.origin_title = "";
        r101.perm = WikNodePerm.defaulted();
        return r101;
    }
}
