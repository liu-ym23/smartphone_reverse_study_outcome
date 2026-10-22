package yq5;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.SpaceEntity;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class s {
    public static final ArrayList<String> a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (TextUtils.isEmpty(r100.f568789l) == false) goto L6;
        return null;
    L6:
        ArrayList<String> r101 = new ArrayList();
        r101.addAll(StringsKt.split$default(r100.f568789l, new String[]{","}, false, 0, 6, null));
        return r101;
    }

    public static final c b(WikiRelation r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        c r101 = new c();
        if (r100.isValid() == true) goto L5;
        return r101;
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<TreeNode> r103 = r100.tree.nodes.values().iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        TreeNode r104 = r103.next();
        Intrinsics.checkNotNull(r104);
        r102.add(c(r104, r100.tree.child_map.get(r104.wiki_token)));
        goto L7
    L9:
        a r105 = new a();
        SpaceInfo r106 = r100.f241731space;
        if (r106 == null) goto L42;
        r105.f568752a = r106.space_id;
        r105.f568753b = r106.space_name;
        r105.f568754c = r106.space_icon;
        r105.f568755d = r106.tenant_id;
        r105.f568756e = r106.description;
        r105.f568757f = r106.is_star;
        r105.f568758g = r106.space_type;
        r105.f568759h = r106.wiki_scope;
        r105.f568760i = r106.open_sharing;
        r105.f568761j = r106.owner_perm_type;
        r105.f568762k = r106.create_uid;
        SpaceInfo.SpaceCover r107 = r106.space_cover;
        if (r107 == null) goto L14;
        r105.f568763l = r107.origin;
        r105.f568764m = r107.thumbnail;
        r105.f568765n = r107.key;
        r105.f568766o = r107.is_graph_dark;
        r105.f568767p = r107.color_value;
    L14:
        WikiHomePageV2 r108 = r106.homePageV2;
        if (yp5.c.i() == false) goto L42;
        String r109 = "";
        if (r108 == null) goto L20;
        String r110 = r108.objToken;
        if (r110 == null) goto L20;
    L21:
        r105.f568773v = r110;
        if (r108 == null) goto L24;
        int r111 = r108.objType;
    L25:
        r105.f568774w = r111;
        if (r108 == null) goto L29;
        String r112 = r108.wikiToken;
        if (r112 == null) goto L29;
    L30:
        r105.f568775x = r112;
        if (r108 == null) goto L34;
        String r113 = r108.url;
        if (r113 == null) goto L34;
    L35:
        r105.f568776y = r113;
        if (r108 == null) goto L41;
        String r114 = r108.title;
        if (r114 == null) goto L41;
        r109 = r114;
    L41:
        r105.f568777z = r109;
    L34:
        r113 = "";
    L29:
        r112 = "";
        goto L30
    L24:
        r111 = 0;
    L20:
        r110 = "";
    L42:
        SpacePerm r115 = r100.space_perm;
        if (r115 == null) goto L45;
        r105.f568772u = r115.canEditFirstLevel;
    L45:
        SpaceUserPerm r116 = r100.user_space_perm;
        if (r116 == null) goto L48;
        r105.f568768q = r116.view_wiki_collaborator;
        r105.f568769r = r116.view_wiki_info;
        r105.f568770s = r116.star_wiki;
        r105.f568771t = r116.view_wiki_general_info;
    L48:
        r101.f568800b = r102;
        r101.f568799a = r105;
        return r101;
    }

    public static final TreeNode f(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        TreeNode r101 = new TreeNode();
        r101.space_id = r100.f568779b;
        r101.wiki_token = r100.f568778a;
        r101.obj_token = r100.f568780c;
        r101.obj_type = r100.f568781d;
        r101.title = r100.f568782e;
        r101.parent_wiki_token = r100.f568783f;
        r101.sort_id = r100.f568784g;
        r101.wiki_node_type = r100.f568785h;
        r101.origin_wiki_token = r100.f568786i;
        r101.origin_space_id = r100.f568787j;
        r101.is_star = r100.f568788k;
        r101.has_child = r100.f568791n;
        r101.secret_key_delete = r100.f568792o;
        r101.is_explorer_star = r100.f568793p;
        r101.origin_is_external = r100.f568794q;
        r101.entity_delete_flag = r100.f568795r;
        r101.iconInfo = r100.f568798u;
        r101.detail_info = WikiDetailInfo.fromJson(r100.f568797t);
    L11:
        e = move-exception;
        tt5.a.d("DBTreeNode", "toTreeNode fail: " + e);
    L13:
        return r101;
    L4:
        if (TextUtils.isEmpty(r100.f568796s) == true) goto L13;
        SpaceEntity r102 = (SpaceEntity) new Gson().fromJson(r100.f568796s, SpaceEntity.class);     // Catch: Exception -> L11
        if (r102 == null) goto L8;
        boolean r103 = true;
    L9:
        r101.isSpaceDocument = r103;     // Catch: Exception -> L11
        r101.spaceDocumentEntity = r102;     // Catch: Exception -> L11
        goto L13
    L8:
        r103 = false;
        goto L9
    }

    public static final b c(TreeNode r110, List<String> r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        b r100 = new b();
        r100.f568779b = r110.space_id;
        r100.f568778a = r110.wiki_token;
        r100.f568780c = r110.obj_token;
        r100.f568781d = r110.obj_type;
        r100.f568782e = r110.title;
        r100.f568783f = r110.parent_wiki_token;
        r100.f568784g = r110.sort_id;
        r100.f568785h = r110.wiki_node_type;
        r100.f568786i = r110.origin_wiki_token;
        r100.f568787j = r110.origin_space_id;
        r100.f568788k = r110.is_star;
        int r101 = r.f568845a;
        if (r111 == null) goto L6;
        String r112 = CollectionsKt.joinToString$default(r111, ",", null, null, 0, null, null, 62, null);
        if (r112 == null) goto L6;
    L7:
        r100.f568789l = r112;
        r100.f568791n = r110.has_child;
        r100.f568792o = r110.secret_key_delete;
        r100.f568793p = r110.is_explorer_star;
        r100.f568794q = r110.origin_is_external;
        r100.f568795r = r110.entity_delete_flag;
        r100.f568798u = r110.iconInfo;
        r100.f568797t = WikiDetailInfo.toJson(r110.detail_info);
    L14:
        e = move-exception;
        tt5.a.d(TreeNode.TAG, "toDbTreeNode fail: " + e);
    L16:
        return r100;
    L9:
        if (r110.spaceDocumentEntity == null) goto L16;
        if (r110.isSpaceDocument == false) goto L16;
        r100.f568796s = new Gson().toJson(r110.spaceDocumentEntity);     // Catch: Exception -> L14
    L6:
        r112 = "";
        goto L7
    }

    public static final WikiRelation d(c r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, WikiFolderPushPlugin.WIKI_TOKEN);
        WikiRelation r100 = new WikiRelation();
        if (hu5.a.d(r110.f568800b) == false) goto L5;
        return r100;
    L5:
        WikiRelation.Tree r101 = new WikiRelation.Tree();
        r101.root_token = "";
        r101.root_list = new ArrayList();
        r101.child_map = new HashMap();
        r101.nodes = new HashMap();
        r101.shared = null;
        Iterator r102 = ((ArrayList) r110.f568800b).iterator();
    L7:
        if (r102.hasNext() == false) goto L21;
        b r103 = (b) r102.next();
        HashMap<String, TreeNode> r104 = r101.nodes;
        String r105 = r103.f568778a;
        Intrinsics.checkNotNull(r103);
        r104.put(r105, f(r103));
        ArrayList<String> r106 = a(r103);
        if (hu5.a.d(r106) == true) goto L12;
        r101.child_map.put(r103.f568778a, r106);
    L12:
        if (2 != r103.f568785h) goto L15;
        r101.root_token = r103.f568778a;
        r101.root_list = a(r103);
    L15:
        if (TextUtils.equals(r103.f568783f, "wikiroot%shared") == false) goto L7;
        if (r101.shared != null) goto L19;
        r101.shared = new ArrayList();
    L19:
        r101.shared.add(r103.f568778a);
        goto L7
    L21:
        if (TextUtils.isEmpty(r101.root_token) == false) goto L23;
    L46:
        boolean r112 = false;
    L47:
        if (r112 == true) goto L49;
        return r100;
    L49:
        SpaceInfo r113 = new SpaceInfo();
        SpacePerm r107 = new SpacePerm();
        SpaceUserPerm r108 = new SpaceUserPerm();
        a r109 = r110.f568799a;
        if (r109 == null) goto L54;
        r113.space_id = r109.f568752a;
        r113.space_name = r109.f568753b;
        r113.space_icon = r109.f568754c;
        r113.tenant_id = r109.f568755d;
        r113.description = r109.f568756e;
        r113.is_star = r109.f568757f;
        r113.space_type = r109.f568758g;
        r113.wiki_scope = r109.f568759h;
        r113.open_sharing = r109.f568760i;
        r113.owner_perm_type = r109.f568761j;
        r113.create_uid = r109.f568762k;
        SpaceInfo.SpaceCover r114 = new SpaceInfo.SpaceCover();
        a r115 = r110.f568799a;
        r114.origin = r115.f568763l;
        r114.thumbnail = r115.f568764m;
        r114.key = r115.f568765n;
        r114.is_graph_dark = r115.f568766o;
        r114.color_value = r115.f568767p;
        r113.space_cover = r114;
        r107.canEditFirstLevel = r115.f568772u;
        r108.view_wiki_info = r115.f568769r;
        r108.view_wiki_collaborator = r115.f568768q;
        r108.star_wiki = r115.f568770s;
        r108.view_wiki_general_info = r115.f568771t;
        if (yp5.c.i() == false) goto L54;
        WikiHomePageV2 r116 = new WikiHomePageV2();
        a r117 = r110.f568799a;
        r116.objToken = r117.f568773v;
        r116.objType = r117.f568774w;
        r116.wikiToken = r117.f568775x;
        r116.url = r117.f568776y;
        r116.title = r117.f568777z;
        r113.homePageV2 = r116;
    L54:
        r100.tree = r101;
        r100.f241731space = r113;
        r100.space_perm = r107;
        r100.user_space_perm = r108;
        r100.fromCache = true;
        return r100;
    L23:
        if (TextUtils.isEmpty(r111) == false) goto L25;
    L27:
        String r118 = r101.root_token;
        if (TextUtils.isEmpty(r111) == true) goto L32;
        TreeNode r119 = r101.nodes.get(r111);
    L30:
        if (r119 == null) goto L32;
        r118 = r119.wiki_token;
        r119 = r101.nodes.get(r119.parent_wiki_token);
    L32:
        TreeNode r120 = r101.nodes.get(r118);
        if (r120 == null) goto L46;
        if (2 == r120.wiki_node_type) goto L40;
        if (TextUtils.equals("wikiroot%shared", r120.wiki_token) == false) goto L46;
    L40:
        if (2 == r120.wiki_node_type) goto L42;
    L45:
        r112 = true;
        goto L47
    L42:
        if (hu5.a.d(r101.child_map.get(r120.wiki_token)) == true) goto L46;
        r101.shared = null;
        r101.child_map.remove("wikiroot%shared");
        goto L45
    L25:
        if (r101.nodes.containsKey(r111) == true) goto L27;
        goto L27
    }

    public static final WikiRelation e(c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.WIKI_TOKEN);
        WikiRelation r102 = new WikiRelation();
        if (hu5.a.d(r100.f568800b) == false) goto L5;
        return r102;
    L5:
        WikiRelation.Tree r103 = new WikiRelation.Tree();
        r103.root_token = "";
        r103.root_list = new ArrayList();
        r103.child_map = new HashMap();
        r103.nodes = new HashMap();
        r103.shared = null;
        Iterator r104 = ((ArrayList) r100.f568800b).iterator();
    L7:
        if (r104.hasNext() == false) goto L21;
        b r105 = (b) r104.next();
        HashMap<String, TreeNode> r106 = r103.nodes;
        String r107 = r105.f568778a;
        Intrinsics.checkNotNull(r105);
        r106.put(r107, f(r105));
        ArrayList<String> r108 = a(r105);
        if (hu5.a.d(r108) == true) goto L12;
        r103.child_map.put(r105.f568778a, r108);
    L12:
        if (Intrinsics.areEqual(r101, r105.f568778a) == false) goto L15;
        r103.root_token = r105.f568778a;
        r103.root_list = a(r105);
    L15:
        if (TextUtils.equals(r105.f568783f, "wikiroot%shared") == false) goto L7;
        if (r103.shared != null) goto L19;
        r103.shared = new ArrayList();
    L19:
        r103.shared.add(r105.f568778a);
        goto L7
    L21:
        if (TextUtils.isEmpty(r103.root_token) == false) goto L23;
    L33:
        return r102;
    L23:
        if (TextUtils.isEmpty(r101) == false) goto L25;
    L27:
        SpaceInfo r109 = new SpaceInfo();
        SpacePerm r110 = new SpacePerm();
        SpaceUserPerm r111 = new SpaceUserPerm();
        a r112 = r100.f568799a;
        if (r112 == null) goto L32;
        r109.space_id = r112.f568752a;
        r109.space_name = r112.f568753b;
        r109.space_icon = r112.f568754c;
        r109.tenant_id = r112.f568755d;
        r109.description = r112.f568756e;
        r109.is_star = r112.f568757f;
        r109.space_type = r112.f568758g;
        r109.wiki_scope = r112.f568759h;
        r109.open_sharing = r112.f568760i;
        r109.owner_perm_type = r112.f568761j;
        r109.create_uid = r112.f568762k;
        SpaceInfo.SpaceCover r113 = new SpaceInfo.SpaceCover();
        a r114 = r100.f568799a;
        r113.origin = r114.f568763l;
        r113.thumbnail = r114.f568764m;
        r113.key = r114.f568765n;
        r113.is_graph_dark = r114.f568766o;
        r113.color_value = r114.f568767p;
        r109.space_cover = r113;
        r110.canEditFirstLevel = r114.f568772u;
        r111.view_wiki_info = r114.f568769r;
        r111.view_wiki_collaborator = r114.f568768q;
        r111.star_wiki = r114.f568770s;
        r111.view_wiki_general_info = r114.f568771t;
        if (yp5.c.i() == false) goto L32;
        WikiHomePageV2 r115 = new WikiHomePageV2();
        a r116 = r100.f568799a;
        r115.objToken = r116.f568773v;
        r115.objType = r116.f568774w;
        r115.wikiToken = r116.f568775x;
        r115.url = r116.f568776y;
        r115.title = r116.f568777z;
        r109.homePageV2 = r115;
    L32:
        r102.tree = r103;
        r102.f241731space = r109;
        r102.space_perm = r110;
        r102.user_space_perm = r111;
        r102.fromCache = true;
        goto L33
    L25:
        if (r103.nodes.containsKey(r101) == true) goto L27;
        goto L27
    }
}
