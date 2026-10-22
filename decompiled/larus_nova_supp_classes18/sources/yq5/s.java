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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s {
    public static final ArrayList<String> a(b r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (TextUtils.isEmpty(r7.l) == false) goto L6;
        return null;
    L6:
        ArrayList<String> r0 = new ArrayList();
        r0.addAll(StringsKt.split$default(r7.l, new String[]{","}, false, 0, 6, null));
        return r0;
    }

    public static final c b(WikiRelation r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        c r0 = new c();
        if (r6.isValid() == true) goto L5;
        return r0;
    L5:
        ArrayList r1 = new ArrayList();
        Iterator<TreeNode> r2 = r6.tree.nodes.values().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        TreeNode r3 = r2.next();
        Intrinsics.checkNotNull(r3);
        r1.add(c(r3, r6.tree.child_map.get(r3.wiki_token)));
        goto L7
    L9:
        a r4 = new a();
        SpaceInfo r5 = r6.space;
        if (r5 == null) goto L42;
        r4.a = r5.space_id;
        r4.b = r5.space_name;
        r4.c = r5.space_icon;
        r4.d = r5.tenant_id;
        r4.e = r5.description;
        r4.f = r5.is_star;
        r4.g = r5.space_type;
        r4.h = r5.wiki_scope;
        r4.i = r5.open_sharing;
        r4.j = r5.owner_perm_type;
        r4.k = r5.create_uid;
        SpaceInfo.SpaceCover r7 = r5.space_cover;
        if (r7 == null) goto L14;
        r4.l = r7.origin;
        r4.m = r7.thumbnail;
        r4.n = r7.key;
        r4.o = r7.is_graph_dark;
        r4.p = r7.color_value;
    L14:
        WikiHomePageV2 r8 = r5.homePageV2;
        if (yp5.c.i() == false) goto L42;
        String r9 = "";
        if (r8 == null) goto L20;
        String r10 = r8.objToken;
        if (r10 == null) goto L20;
    L21:
        r4.v = r10;
        if (r8 == null) goto L24;
        int r11 = r8.objType;
    L25:
        r4.w = r11;
        if (r8 == null) goto L29;
        String r12 = r8.wikiToken;
        if (r12 == null) goto L29;
    L30:
        r4.x = r12;
        if (r8 == null) goto L34;
        String r13 = r8.url;
        if (r13 == null) goto L34;
    L35:
        r4.y = r13;
        if (r8 == null) goto L41;
        String r14 = r8.title;
        if (r14 == null) goto L41;
        r9 = r14;
    L41:
        r4.z = r9;
    L34:
        r13 = "";
    L29:
        r12 = "";
        goto L30
    L24:
        r11 = 0;
    L20:
        r10 = "";
    L42:
        SpacePerm r15 = r6.space_perm;
        if (r15 == null) goto L45;
        r4.u = r15.canEditFirstLevel;
    L45:
        SpaceUserPerm r16 = r6.user_space_perm;
        if (r16 == null) goto L48;
        r4.q = r16.view_wiki_collaborator;
        r4.r = r16.view_wiki_info;
        r4.s = r16.star_wiki;
        r4.t = r16.view_wiki_general_info;
    L48:
        r0.b = r1;
        r0.a = r4;
        return r0;
    }

    public static final TreeNode f(b r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        TreeNode r0 = new TreeNode();
        r0.space_id = r3.b;
        r0.wiki_token = r3.a;
        r0.obj_token = r3.c;
        r0.obj_type = r3.d;
        r0.title = r3.e;
        r0.parent_wiki_token = r3.f;
        r0.sort_id = r3.g;
        r0.wiki_node_type = r3.h;
        r0.origin_wiki_token = r3.i;
        r0.origin_space_id = r3.j;
        r0.is_star = r3.k;
        r0.has_child = r3.n;
        r0.secret_key_delete = r3.o;
        r0.is_explorer_star = r3.p;
        r0.origin_is_external = r3.q;
        r0.entity_delete_flag = r3.r;
        r0.iconInfo = r3.u;
        r0.detail_info = WikiDetailInfo.fromJson(r3.t);
    L11:
        e = move-exception;
        tt5.a.d("DBTreeNode", "toTreeNode fail: " + e);
    L13:
        return r0;
    L4:
        if (TextUtils.isEmpty(r3.s) == true) goto L13;
        SpaceEntity r4 = (SpaceEntity) new Gson().fromJson(r3.s, SpaceEntity.class);     // Catch: Exception -> L11
        if (r4 == null) goto L8;
        boolean r1 = true;
    L9:
        r0.isSpaceDocument = r1;     // Catch: Exception -> L11
        r0.spaceDocumentEntity = r4;     // Catch: Exception -> L11
        goto L13
    L8:
        r1 = false;
        goto L9
    }

    public static final b c(TreeNode r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        b r0 = new b();
        r0.b = r11.space_id;
        r0.a = r11.wiki_token;
        r0.c = r11.obj_token;
        r0.d = r11.obj_type;
        r0.e = r11.title;
        r0.f = r11.parent_wiki_token;
        r0.g = r11.sort_id;
        r0.h = r11.wiki_node_type;
        r0.i = r11.origin_wiki_token;
        r0.j = r11.origin_space_id;
        r0.k = r11.is_star;
        int r1 = r.a;
        if (r12 == null) goto L6;
        String r13 = CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, null, 62, null);
        if (r13 == null) goto L6;
    L7:
        r0.l = r13;
        r0.n = r11.has_child;
        r0.o = r11.secret_key_delete;
        r0.p = r11.is_explorer_star;
        r0.q = r11.origin_is_external;
        r0.r = r11.entity_delete_flag;
        r0.u = r11.iconInfo;
        r0.t = WikiDetailInfo.toJson(r11.detail_info);
    L14:
        e = move-exception;
        tt5.a.d(TreeNode.TAG, "toDbTreeNode fail: " + e);
    L16:
        return r0;
    L9:
        if (r11.spaceDocumentEntity == null) goto L16;
        if (r11.isSpaceDocument == false) goto L16;
        r0.s = new Gson().toJson(r11.spaceDocumentEntity);     // Catch: Exception -> L14
    L6:
        r13 = "";
        goto L7
    }

    public static final WikiRelation d(c r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, WikiFolderPushPlugin.WIKI_TOKEN);
        WikiRelation r0 = new WikiRelation();
        if (hu5.a.d(r10.b) == false) goto L5;
        return r0;
    L5:
        WikiRelation.Tree r1 = new WikiRelation.Tree();
        r1.root_token = "";
        r1.root_list = new ArrayList();
        r1.child_map = new HashMap();
        r1.nodes = new HashMap();
        r1.shared = null;
        Iterator r3 = ((ArrayList) r10.b).iterator();
    L7:
        if (r3.hasNext() == false) goto L21;
        b r4 = (b) r3.next();
        HashMap<String, TreeNode> r7 = r1.nodes;
        String r8 = r4.a;
        Intrinsics.checkNotNull(r4);
        r7.put(r8, f(r4));
        ArrayList<String> r9 = a(r4);
        if (hu5.a.d(r9) == true) goto L12;
        r1.child_map.put(r4.a, r9);
    L12:
        if (2 != r4.h) goto L15;
        r1.root_token = r4.a;
        r1.root_list = a(r4);
    L15:
        if (TextUtils.equals(r4.f, "wikiroot%shared") == false) goto L7;
        if (r1.shared != null) goto L19;
        r1.shared = new ArrayList();
    L19:
        r1.shared.add(r4.a);
        goto L7
    L21:
        if (TextUtils.isEmpty(r1.root_token) == false) goto L23;
    L46:
        boolean r12 = false;
    L47:
        if (r12 == true) goto L49;
        return r0;
    L49:
        SpaceInfo r13 = new SpaceInfo();
        SpacePerm r2 = new SpacePerm();
        SpaceUserPerm r5 = new SpaceUserPerm();
        a r6 = r10.a;
        if (r6 == null) goto L54;
        r13.space_id = r6.a;
        r13.space_name = r6.b;
        r13.space_icon = r6.c;
        r13.tenant_id = r6.d;
        r13.description = r6.e;
        r13.is_star = r6.f;
        r13.space_type = r6.g;
        r13.wiki_scope = r6.h;
        r13.open_sharing = r6.i;
        r13.owner_perm_type = r6.j;
        r13.create_uid = r6.k;
        SpaceInfo.SpaceCover r14 = new SpaceInfo.SpaceCover();
        a r15 = r10.a;
        r14.origin = r15.l;
        r14.thumbnail = r15.m;
        r14.key = r15.n;
        r14.is_graph_dark = r15.o;
        r14.color_value = r15.p;
        r13.space_cover = r14;
        r2.canEditFirstLevel = r15.u;
        r5.view_wiki_info = r15.r;
        r5.view_wiki_collaborator = r15.q;
        r5.star_wiki = r15.s;
        r5.view_wiki_general_info = r15.t;
        if (yp5.c.i() == false) goto L54;
        WikiHomePageV2 r16 = new WikiHomePageV2();
        a r17 = r10.a;
        r16.objToken = r17.v;
        r16.objType = r17.w;
        r16.wikiToken = r17.x;
        r16.url = r17.y;
        r16.title = r17.z;
        r13.homePageV2 = r16;
    L54:
        r0.tree = r1;
        r0.space = r13;
        r0.space_perm = r2;
        r0.user_space_perm = r5;
        r0.fromCache = true;
        return r0;
    L23:
        if (TextUtils.isEmpty(r11) == false) goto L25;
    L27:
        String r18 = r1.root_token;
        if (TextUtils.isEmpty(r11) == true) goto L32;
        TreeNode r19 = r1.nodes.get(r11);
    L30:
        if (r19 == null) goto L32;
        r18 = r19.wiki_token;
        r19 = r1.nodes.get(r19.parent_wiki_token);
    L32:
        TreeNode r110 = r1.nodes.get(r18);
        if (r110 == null) goto L46;
        if (2 == r110.wiki_node_type) goto L40;
        if (TextUtils.equals("wikiroot%shared", r110.wiki_token) == false) goto L46;
    L40:
        if (2 == r110.wiki_node_type) goto L42;
    L45:
        r12 = true;
        goto L47
    L42:
        if (hu5.a.d(r1.child_map.get(r110.wiki_token)) == true) goto L46;
        r1.shared = null;
        r1.child_map.remove("wikiroot%shared");
        goto L45
    L25:
        if (r1.nodes.containsKey(r11) == true) goto L27;
        goto L27
    }

    public static final WikiRelation e(c r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, WikiFolderPushPlugin.WIKI_TOKEN);
        WikiRelation r0 = new WikiRelation();
        if (hu5.a.d(r7.b) == false) goto L5;
        return r0;
    L5:
        WikiRelation.Tree r1 = new WikiRelation.Tree();
        r1.root_token = "";
        r1.root_list = new ArrayList();
        r1.child_map = new HashMap();
        r1.nodes = new HashMap();
        r1.shared = null;
        Iterator r2 = ((ArrayList) r7.b).iterator();
    L7:
        if (r2.hasNext() == false) goto L21;
        b r3 = (b) r2.next();
        HashMap<String, TreeNode> r4 = r1.nodes;
        String r5 = r3.a;
        Intrinsics.checkNotNull(r3);
        r4.put(r5, f(r3));
        ArrayList<String> r6 = a(r3);
        if (hu5.a.d(r6) == true) goto L12;
        r1.child_map.put(r3.a, r6);
    L12:
        if (Intrinsics.areEqual(r8, r3.a) == false) goto L15;
        r1.root_token = r3.a;
        r1.root_list = a(r3);
    L15:
        if (TextUtils.equals(r3.f, "wikiroot%shared") == false) goto L7;
        if (r1.shared != null) goto L19;
        r1.shared = new ArrayList();
    L19:
        r1.shared.add(r3.a);
        goto L7
    L21:
        if (TextUtils.isEmpty(r1.root_token) == false) goto L23;
    L33:
        return r0;
    L23:
        if (TextUtils.isEmpty(r8) == false) goto L25;
    L27:
        SpaceInfo r9 = new SpaceInfo();
        SpacePerm r10 = new SpacePerm();
        SpaceUserPerm r11 = new SpaceUserPerm();
        a r12 = r7.a;
        if (r12 == null) goto L32;
        r9.space_id = r12.a;
        r9.space_name = r12.b;
        r9.space_icon = r12.c;
        r9.tenant_id = r12.d;
        r9.description = r12.e;
        r9.is_star = r12.f;
        r9.space_type = r12.g;
        r9.wiki_scope = r12.h;
        r9.open_sharing = r12.i;
        r9.owner_perm_type = r12.j;
        r9.create_uid = r12.k;
        SpaceInfo.SpaceCover r13 = new SpaceInfo.SpaceCover();
        a r14 = r7.a;
        r13.origin = r14.l;
        r13.thumbnail = r14.m;
        r13.key = r14.n;
        r13.is_graph_dark = r14.o;
        r13.color_value = r14.p;
        r9.space_cover = r13;
        r10.canEditFirstLevel = r14.u;
        r11.view_wiki_info = r14.r;
        r11.view_wiki_collaborator = r14.q;
        r11.star_wiki = r14.s;
        r11.view_wiki_general_info = r14.t;
        if (yp5.c.i() == false) goto L32;
        WikiHomePageV2 r15 = new WikiHomePageV2();
        a r16 = r7.a;
        r15.objToken = r16.v;
        r15.objType = r16.w;
        r15.wikiToken = r16.x;
        r15.url = r16.y;
        r15.title = r16.z;
        r9.homePageV2 = r15;
    L32:
        r0.tree = r1;
        r0.space = r9;
        r0.space_perm = r10;
        r0.user_space_perm = r11;
        r0.fromCache = true;
        goto L33
    L25:
        if (r1.nodes.containsKey(r8) == true) goto L27;
        goto L27
    }
}
