package com.bytedance.ee.bear.wikiv2.selector;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.list.dto.ObjBizType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements NetService.c<RecentOperationResult> {

    public static final class a {
    }

    static {
    }

    public s() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) {
        RecentOperationResult r100 = new RecentOperationResult();
        r100.data = new RecentOperationResult.Data();
        if (r110 != null) goto L5;
        tt5.a.h("RecentOperationParser", "json is null, return.");
    L76:
        return r100;
    L5:
        JSONObject r101 = new JSONObject(r110).optJSONObject("data");
        if (r101 != null) goto L8;
        tt5.a.h("RecentOperationParser", "dataObj is null, return.");
        goto L76
    L8:
        JSONArray r102 = r101.optJSONArray("nodes");
        if (r102 != null) goto L11;
        tt5.a.h("RecentOperationParser", "nodesObj  is null, return.");
        goto L76
    L11:
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        int r106 = r102.length();
        int r111 = 0;
    L12:
        boolean r112 = true;
        if (r111 >= r106) goto L31;
        JSONObject r113 = r102.optJSONObject(r111);
        if (r113 != null) goto L17;
    L19:
        boolean r114 = false;
    L21:
        if (r114 == false) goto L23;
        String r115 = r113.optString("token");
        r103.add(r115);
        r105.add(r115);
    L30:
        r111 = r111 + 1;
        goto L12
    L23:
        if (r113 != null) goto L25;
    L27:
        r112 = false;
    L28:
        if (r112 == false) goto L30;
        String r116 = r113.optString("token");
        r104.add(r116);
        r105.add(r116);
        goto L30
    L25:
        if (r113.optInt("biz_type") != ObjBizType.SPACE.getType()) goto L27;
    L17:
        if (r113.optInt("biz_type") != ObjBizType.WIKI.getType()) goto L19;
        r114 = true;
        goto L21
    L31:
        ArrayList<RecentOperationResult.a> r107 = new ArrayList();
        LinkedHashMap r108 = new LinkedHashMap();
        JSONObject r109 = r101.optJSONObject("wiki");
        if (r109 == null) goto L34;
        JSONObject r117 = r109.optJSONObject("nodes");
    L35:
        if (r117 != null) goto L37;
        tt5.a.h("RecentOperationParser", "wikiNodesObj  is null");
    L43:
        LinkedHashMap r118 = new LinkedHashMap();
        JSONObject r119 = r101.optJSONObject("space");
        if (r119 != null) goto L46;
        tt5.a.h("RecentOperationParser", "spaceObj is null.");
    L66:
        Iterator r120 = r105.iterator();
    L68:
        if (r120.hasNext() == false) goto L75;
        String r121 = (String) r120.next();
        RecentOperationResult.WikiInfo r122 = (RecentOperationResult.WikiInfo) r108.get(r121);
        if (r122 == null) goto L72;
        r107.add(r122);
    L72:
        RecentOperationResult.FolderInfo r123 = (RecentOperationResult.FolderInfo) r118.get(r121);
        if (r123 == null) goto L68;
        r107.add(r123);
        goto L68
    L75:
        ((RecentOperationResult.Data) r100.data).setRecentList(r107);
        goto L76
    L46:
        JSONObject r124 = r119.optJSONObject("nodes");
        if (r124 != null) goto L49;
        tt5.a.h("RecentOperationParser", "nodesObj is null.");
        goto L66
    L49:
        JSONArray r125 = r119.optJSONArray("paths");
        if (r125 != null) goto L52;
    L65:
        tt5.a.h("RecentOperationParser", "pathsObj is null or empty.");
        goto L66
    L52:
        if (r125.length() == 0) goto L65;
        int r126 = r125.length();
        int r127 = 0;
    L55:
        if (r127 >= r126) goto L66;
        JSONArray r128 = r125.optJSONArray(r127);
        String r129 = r128.optString(r128.length() - 1);
        Intrinsics.checkNotNull(r128);
        if (r128.length() != 1) goto L59;
        String r130 = "";
    L60:
        RecentOperationResult.FolderInfo r131 = a(r129, r124);
        if (r131 == null) goto L64;
        r131.setParentInfo(a(r130, r124));
        r118.put(r129, r131);
    L64:
        r127 = r127 + 1;
        goto L55
    L59:
        r130 = r128.optString(0);
        goto L60
    L37:
        Iterator r132 = r103.iterator();
    L39:
        if (r132.hasNext() == false) goto L43;
        String r133 = (String) r132.next();
        JSONObject r134 = r117.optJSONObject(r133);
        if (r134 == null) goto L39;
        RecentOperationResult.WikiInfo r135 = new RecentOperationResult.WikiInfo();
        r135.setObjToken(r134.optString("obj_token"));
        r135.setObjType(r134.optInt("obj_type"));
        r135.setSpaceId(r134.optString(DocViewModel.EXTRA_SPACE_ID));
        r135.setSpaceName(r134.optString("wiki_space_name"));
        r135.setTitle(r134.optString("title"));
        r135.setWikiToken(r134.optString("wiki_token"));
        r135.setWikiSpaceType(Integer.valueOf(r134.optInt("wiki_space_type")));
        r135.setWikiSpaceCreateUid(r134.optString("wiki_space_create_uid"));
        r135.setIconInfo(r134.optString("icon_info"));
        r108.put(r133, r135);
        goto L39
    L34:
        r117 = null;
        goto L35
    }

    public static RecentOperationResult.FolderInfo a(String r100, JSONObject r101) {
        JSONObject r102 = r101.optJSONObject(r100);
        if (r102 != null) goto L6;
        tt5.a.h("RecentOperationParser", "folderInfoObj is null.");
        return null;
    L6:
        RecentOperationResult.FolderInfo r103 = new RecentOperationResult.FolderInfo();
        r103.setObjToken(r102.optString("obj_token"));
        r103.setToken(r102.optString("node_token"));
        r103.setType(r102.optInt("type"));
        r103.setName(r102.optString("name"));
        r103.setOwnerId(r102.optString("owner_id"));
        r103.setOwnerType(r102.optInt("owner_type"));
        r103.setShareVersion(r102.optInt("share_version"));
        r103.setObjSubType(r102.optLong("obj_sub_type"));
        JSONObject r104 = r102.optJSONObject("extra");
        boolean r105 = false;
        if (r104 != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        r103.setShareFolder(r106);
        JSONObject r107 = r102.optJSONObject("extra");
        if (r107 != null) goto L15;
    L17:
        r103.setExternal(r105);
        r103.setIconInfo(r102.optString("icon_info"));
        return r103;
    L15:
        if (r107.optBoolean("is_external") != true) goto L17;
        r105 = true;
        goto L17
    L9:
        if (r104.optBoolean("is_share_folder") != true) goto L11;
        r106 = true;
        goto L12
    }
}
