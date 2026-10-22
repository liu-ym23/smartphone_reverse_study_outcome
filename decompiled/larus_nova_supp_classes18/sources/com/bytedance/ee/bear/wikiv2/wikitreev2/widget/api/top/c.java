package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top;

import android.text.TextUtils;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpacesResp;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final boolean a(TreeNode r2) {
        if (TextUtils.isEmpty(r2.wiki_token) == false) goto L5;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == true) goto L12;
        tt5.a.k("TopResultExt", "checkInvalid false!");
    L12:
        return r3;
    L5:
        if (TextUtils.isEmpty(r2.space_id) == true) goto L9;
        if (TextUtils.isEmpty(r2.obj_token) == true) goto L9;
        r3 = true;
        goto L10
    }

    public static final Document b(TreeNode r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Document r0 = new Document();
        r0.b = r8.obj_type;
        r0.a = r8.title;
        r0.c = "";
        r0.d = r8.obj_token;
        SpaceEntity r2 = r8.spaceDocumentEntity;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getOwnerId();
    L6:
        r0.e = r4;
        SpaceEntity r5 = r8.spaceDocumentEntity;
        if (r5 == null) goto L9;
        String r6 = r5.getEditUid();
    L10:
        r0.g = r6;
        SpaceEntity r7 = r8.spaceDocumentEntity;
        long r9 = 0;
        if (r7 == null) goto L13;
        long r10 = r7.getEditTime();
    L14:
        r0.i = String.valueOf(r10);
        SpaceEntity r11 = r8.spaceDocumentEntity;
        if (r11 == null) goto L17;
        r9 = r11.getCreateTime();
    L17:
        r0.j = String.valueOf(r9);
        SpaceEntity r12 = r8.spaceDocumentEntity;
        int r13 = 0;
        if (r12 == null) goto L20;
        boolean r14 = r12.isStared();
    L21:
        r0.z = r14;
        SpaceEntity r15 = r8.spaceDocumentEntity;
        if (r15 == null) goto L24;
        String r16 = r15.getUrl();
    L25:
        r0.p = r16;
        if (r8.obj_type != e.l.b) goto L28;
        String r17 = com.bytedance.ee.util.io.a.c(r8.title);
    L29:
        r0.F = r17;
        SpaceEntity r18 = r8.spaceDocumentEntity;
        if (r18 == null) goto L33;
        String r19 = r18.getThumbnail();
        if (r19 == null) goto L33;
    L34:
        r0.q = r19;
        SpaceEntity r20 = r8.spaceDocumentEntity;
        if (r20 == null) goto L37;
        boolean r21 = r20.isPined();
    L38:
        r0.L = r21;
        r0.A = false;
        SpaceEntity r22 = r8.spaceDocumentEntity;
        if (r22 == null) goto L41;
        int r23 = r22.getOwnerType();
    L42:
        r0.L1 = r23;
        r0.M1 = NodeType.ENTITY.getValue();
        SpaceEntity r24 = r8.spaceDocumentEntity;
        if (r24 == null) goto L46;
        String r25 = GsonProtectorUtils.toJson(new Gson(), r24);
        if (r25 == null) goto L46;
    L47:
        r0.O = r25;
        r0.b2 = r8.secret_key_delete;
        r0.T1 = "";
        r0.V1 = 0;
        r0.h2 = 0;
        r0.p2 = r8.obj_token;
        SpaceEntity r1 = r8.spaceDocumentEntity;
        if (r1 == null) goto L50;
        r13 = r1.getDeleteFlag();
    L50:
        r0.v2 = r13;
        h0 r26 = (h0) org.koin.java.a.c(h0.class, null, null, 6);
        if (r26 == null) goto L55;
        AccountService.Account r27 = r26.U5();
        if (r27 == null) goto L55;
        r3 = r27.tenantId;
    L55:
        r0.f = r3;
        r0.O = GsonProtectorUtils.toJson(new Gson(), r8.spaceDocumentEntity.getExtra());
        SpaceEntity r28 = r8.spaceDocumentEntity;
        if (r28 == null) goto L60;
        SpaceEntity.SpaceEntityThumbnailExtra r29 = r28.getThumbnailExtra();
        if (r29 == null) goto L60;
        r0.V0 = r29.getUrl();
        r0.b1 = r29.getSecret();
        r0.g1 = r29.getNonce();
        r0.h1 = r29.getType();
    L60:
        return r0;
    L46:
        r25 = "";
        goto L47
    L41:
        r23 = 0;
        goto L42
    L37:
        r21 = false;
    L33:
        r19 = "";
        goto L34
    L28:
        r17 = "";
        goto L29
    L24:
        r16 = null;
        goto L25
    L20:
        r14 = false;
        goto L21
    L13:
        r10 = 0;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static final WikiRelation c(WikiSpacesResp r17, VirtualNode r18) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "parentVirtualNode");
        WikiRelation r2 = new WikiRelation();
        List<SpaceBean> r0 = r17.b;
        if (r0 != null) goto L5;
    L17:
        return r2;
    L5:
        if (hu5.a.d(r0) == true) goto L17;
        String r4 = r18.getRootToken();
        String r5 = r18.getSpaceId();
        int r6 = r0.size();
        if (r6 <= 40) goto L10;
        r6 = 40;
    L10:
        List<SpaceBean> r1 = r0.subList(0, r6);
        WikiRelation.Tree r7 = new WikiRelation.Tree();
        r2.tree = r7;
        r7.root_token = r4;
        r7.nodes = new HashMap();
        r7.shared = new ArrayList();
        ArrayList r8 = new ArrayList();
        r7.root_list = r8;
        r7.child_map = new HashMap();
        ArrayList r9 = new ArrayList();
        r7.child_map.put(r4, r9);
        int r10 = r1.size();
        int r11 = 0;
    L11:
        if (r11 >= r10) goto L16;
        SpaceBean r13 = (SpaceBean) ListProtector.get(r1, r11);
        String r14 = r13.root_token;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r4, "rootToken");
        Intrinsics.checkNotNullParameter(r5, "spaceId");
        TreeNode r15 = new TreeNode();
        r15.space_id = r13.space_id;
        String r12 = r13.root_token;
        r15.wiki_token = r12;
        r15.obj_token = r12;
        r15.obj_type = e.n.b;
        String r16 = r13.space_name;
        r15.title = r16;
        r15.parent_wiki_token = r4;
        List<SpaceBean> r19 = r1;
        r15.wiki_node_type = -7;
        r15.origin_wiki_token = r12;
        r15.origin_space_id = r5;
        r15.is_star = r13.is_star;
        r15.has_child = true;
        r15.secret_key_delete = false;
        r15.is_explorer_star = false;
        r15.is_explorer_pin = false;
        r15.origin_is_external = true;
        r15.entity_delete_flag = 0;
        r15.origin_title = r16;
        r15.perm = WikNodePerm.defaulted();
        r15.iconInfo = r13.space_icon_info;
        if (a(r15) == false) goto L15;
        r15.sort_id = r11;
        r7.nodes.put(r14, r15);
        r8.add(r14);
        r9.add(r14);
    L15:
        r11 = r11 + 1;
        r1 = r19;
        goto L11
    L16:
        TreeNode r3 = b.b(r18);
        r3.has_child = hu5.a.f(r8);
        r7.nodes.put(r4, r3);
        r2.space = b.a(r5);
        SpacePerm r20 = new SpacePerm();
        r20.canEditFirstLevel = true;
        r2.space_perm = r20;
        SpaceUserPerm r21 = new SpaceUserPerm();
        r21.view_wiki_info = true;
        r21.view_wiki_collaborator = true;
        r21.star_wiki = true;
        r21.view_wiki_general_info = true;
        r2.user_space_perm = r21;
        goto L17
    }

    public static final WikiRelation d(SidebarListInfo r17, VirtualNode r18, VirtualNode r19, Integer r20) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "parentVirtualNode");
        WikiRelation r2 = new WikiRelation();
        ArrayList<String> r4 = r17.getNodeList();
        if (r4 == null) goto L51;
        if (hu5.a.d(r4) == true) goto L51;
        String r5 = r18.getRootToken();
        String r6 = r18.getSpaceId();
        WikiRelation.Tree r7 = new WikiRelation.Tree();
        r2.tree = r7;
        r7.root_token = r5;
        r7.nodes = new HashMap();
        r7.shared = new ArrayList();
        ArrayList r8 = new ArrayList();
        r8.add(r5);
        r7.root_list = r8;
        r7.child_map = new HashMap();
        ArrayList r9 = new ArrayList();
        r7.child_map.put(r5, r9);
        int r10 = r4.size();
        int r12 = 0;
    L9:
        if (r12 >= r10) goto L42;
        String r14 = (String) ListProtector.get(r4, r12);
        if (r20 == null) goto L16;
        if (r9.size() >= r20.intValue()) goto L42;
    L16:
        if (r8.contains(r14) == false) goto L18;
        WikiRelation r16 = r2;
    L41:
        r12 = r12 + 1;
        r2 = r16;
        goto L9
    L18:
        SidebarListInfo.NodeEntities r11 = r17.getEntities();
        TreeNode r15 = null;
        if (r11 == null) goto L23;
        HashMap<String, TreeNode> r13 = r11.getNodes();
        if (r13 == null) goto L23;
        TreeNode r110 = r13.get(r14);
    L24:
        if (r110 != null) goto L26;
    L28:
        r16 = r2;
        SidebarListInfo.NodeEntities r1 = r17.getEntities();
        if (r1 == null) goto L33;
        HashMap<String, SpaceEntity> r3 = r1.getSpace();
        if (r3 == null) goto L33;
        SpaceEntity r21 = r3.get(r14);
    L34:
        if (r21 == null) goto L37;
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Intrinsics.checkNotNullParameter(r5, "rootToken");
        Intrinsics.checkNotNullParameter(r6, "spaceId");
        r15 = new TreeNode();
        r15.space_id = r6;
        r15.wiki_token = r21.getObjToken();
        r15.obj_token = r21.getObjToken();
        r15.obj_type = r21.getType();
        r15.title = r21.getName();
        r15.parent_wiki_token = r5;
        r15.wiki_node_type = -8;
        r15.origin_wiki_token = r21.getObjToken();
        r15.origin_space_id = r6;
        r15.is_star = r21.isStared();
        r15.has_child = false;
        r15.secret_key_delete = r21.getSecretKeyDelete();
        r15.is_explorer_star = false;
        r15.is_explorer_pin = r21.isPined();
        r15.origin_is_external = true;
        r15.entity_delete_flag = 0;
        r15.origin_title = r21.getName();
        r15.perm = WikNodePerm.defaulted();
        r15.isSpaceDocument = true;
        r15.spaceDocumentEntity = r21;
        WikiDetailInfo r111 = new WikiDetailInfo();
        r111.owner_id = r21.getOwnerId();
        r15.detail_info = r111;
        r15.iconInfo = r21.getIcon();
    L37:
        if (r15 == null) goto L41;
        if (a(r15) == false) goto L41;
        r15.sort_id = r12;
        r7.nodes.put(r14, r15);
        r8.add(r14);
        r9.add(r14);
    L33:
        r21 = null;
        goto L34
    L26:
        if (a(r110) == false) goto L28;
        r16 = r2;
        r110.sort_id = r12;
        r110.is_explorer_pin = true;
        r7.nodes.put(r14, r110);
        r8.add(r14);
        r9.add(r14);
    L23:
        r110 = null;
    L42:
        WikiRelation r112 = r2;
        if (r20 == null) goto L48;
        r20.intValue();
        if (r4.size() <= r20.intValue()) goto L48;
        if (r19 == null) goto L48;
        TreeNode r0 = b.b(r19);
        String r22 = r0.wiki_token;
        r0.sort_id = r20.intValue() + 1;
        r7.nodes.put(r22, r0);
        r8.add(r22);
        r9.add(r22);
    L48:
        TreeNode r23 = b.b(r18);
        r23.has_child = hu5.a.f(r8);
        r7.nodes.put(r5, r23);
        r112.space = b.a(r6);
        SpacePerm r24 = new SpacePerm();
        r24.canEditFirstLevel = true;
        r112.space_perm = r24;
        SpaceUserPerm r25 = new SpaceUserPerm();
        r25.view_wiki_info = true;
        r25.view_wiki_collaborator = true;
        r25.star_wiki = true;
        r25.view_wiki_general_info = true;
        r112.user_space_perm = r25;
        return r112;
    L51:
        return r2;
    }
}
