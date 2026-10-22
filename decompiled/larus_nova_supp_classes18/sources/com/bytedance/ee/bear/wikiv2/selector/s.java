package com.bytedance.ee.bear.wikiv2.selector;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.ObjBizType;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements NetService.c<RecentOperationResult> {

    public static final class a {
    }

    static {
    }

    public s() {
    }

    public final Result parse(String r17) {
        RecentOperationResult r1 = new RecentOperationResult();
        ((Result) r1).data = new RecentOperationResult.Data();
        if (r17 != null) goto L5;
        tt5.a.h("RecentOperationParser", "json is null, return.");
    L76:
        return r1;
    L5:
        JSONObject r0 = new JSONObject(r17).optJSONObject(WikiFolderPushPlugin.DATA);
        if (r0 != null) goto L8;
        tt5.a.h("RecentOperationParser", "dataObj is null, return.");
        goto L76
    L8:
        JSONArray r4 = r0.optJSONArray("nodes");
        if (r4 != null) goto L11;
        tt5.a.h("RecentOperationParser", "nodesObj  is null, return.");
        goto L76
    L11:
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        int r8 = r4.length();
        int r10 = 0;
    L12:
        boolean r11 = true;
        if (r10 >= r8) goto L31;
        JSONObject r12 = r4.optJSONObject(r10);
        if (r12 != null) goto L17;
    L19:
        boolean r14 = false;
    L21:
        if (r14 == false) goto L23;
        String r13 = r12.optString(ResourceData.KEY_TOKEN);
        r5.add(r13);
        r7.add(r13);
    L30:
        r10 = r10 + 1;
        goto L12
    L23:
        if (r12 != null) goto L25;
    L27:
        r11 = false;
    L28:
        if (r11 == false) goto L30;
        String r15 = r12.optString(ResourceData.KEY_TOKEN);
        r6.add(r15);
        r7.add(r15);
        goto L30
    L25:
        if (r12.optInt("biz_type") != ObjBizType.SPACE.getType()) goto L27;
    L17:
        if (r12.optInt("biz_type") != ObjBizType.WIKI.getType()) goto L19;
        r14 = true;
        goto L21
    L31:
        ArrayList<RecentOperationResult.a> r9 = new ArrayList();
        LinkedHashMap r16 = new LinkedHashMap();
        JSONObject r18 = r0.optJSONObject(DocumentType.WIKI_NAME);
        if (r18 == null) goto L34;
        JSONObject r19 = r18.optJSONObject("nodes");
    L35:
        if (r19 != null) goto L37;
        tt5.a.h("RecentOperationParser", "wikiNodesObj  is null");
    L43:
        LinkedHashMap r20 = new LinkedHashMap();
        JSONObject r2 = r0.optJSONObject("space");
        if (r2 != null) goto L46;
        tt5.a.h("RecentOperationParser", "spaceObj is null.");
    L66:
        Iterator r3 = r7.iterator();
    L68:
        if (r3.hasNext() == false) goto L75;
        String r21 = (String) r3.next();
        RecentOperationResult.WikiInfo r22 = (RecentOperationResult.WikiInfo) r16.get(r21);
        if (r22 == null) goto L72;
        r9.add(r22);
    L72:
        RecentOperationResult.FolderInfo r23 = (RecentOperationResult.FolderInfo) r20.get(r21);
        if (r23 == null) goto L68;
        r9.add(r23);
        goto L68
    L75:
        ((RecentOperationResult.Data) ((Result) r1).data).setRecentList(r9);
        goto L76
    L46:
        JSONObject r24 = r2.optJSONObject("nodes");
        if (r24 != null) goto L49;
        tt5.a.h("RecentOperationParser", "nodesObj is null.");
        goto L66
    L49:
        JSONArray r25 = r2.optJSONArray("paths");
        if (r25 != null) goto L52;
    L65:
        tt5.a.h("RecentOperationParser", "pathsObj is null or empty.");
        goto L66
    L52:
        if (r25.length() == 0) goto L65;
        int r26 = r25.length();
        int r27 = 0;
    L55:
        if (r27 >= r26) goto L66;
        JSONArray r110 = r25.optJSONArray(r27);
        String r111 = r110.optString(r110.length() - 1);
        Intrinsics.checkNotNull(r110);
        if (r110.length() != 1) goto L59;
        String r112 = "";
    L60:
        RecentOperationResult.FolderInfo r113 = a(r111, r24);
        if (r113 == null) goto L64;
        r113.setParentInfo(a(r112, r24));
        r20.put(r111, r113);
    L64:
        r27 = r27 + 1;
        goto L55
    L59:
        r112 = r110.optString(0);
        goto L60
    L37:
        Iterator r28 = r5.iterator();
    L39:
        if (r28.hasNext() == false) goto L43;
        String r114 = (String) r28.next();
        JSONObject r115 = r19.optJSONObject(r114);
        if (r115 == null) goto L39;
        RecentOperationResult.WikiInfo r116 = new RecentOperationResult.WikiInfo();
        r116.setObjToken(r115.optString(ResourceData.KEY_OBJ_TOKEN));
        r116.setObjType(r115.optInt("obj_type"));
        r116.setSpaceId(r115.optString("space_id"));
        r116.setSpaceName(r115.optString("wiki_space_name"));
        r116.setTitle(r115.optString("title"));
        r116.setWikiToken(r115.optString("wiki_token"));
        r116.setWikiSpaceType(Integer.valueOf(r115.optInt("wiki_space_type")));
        r116.setWikiSpaceCreateUid(r115.optString("wiki_space_create_uid"));
        r116.setIconInfo(r115.optString("icon_info"));
        r16.put(r114, r116);
        goto L39
    L34:
        r19 = null;
        goto L35
    }

    public static RecentOperationResult.FolderInfo a(String r5, JSONObject r6) {
        JSONObject r7 = r6.optJSONObject(r5);
        if (r7 != null) goto L6;
        tt5.a.h("RecentOperationParser", "folderInfoObj is null.");
        return null;
    L6:
        RecentOperationResult.FolderInfo r8 = new RecentOperationResult.FolderInfo();
        r8.setObjToken(r7.optString(ResourceData.KEY_OBJ_TOKEN));
        r8.setToken(r7.optString("node_token"));
        r8.setType(r7.optInt(ResourceData.KEY_TYPE));
        r8.setName(r7.optString("name"));
        r8.setOwnerId(r7.optString("owner_id"));
        r8.setOwnerType(r7.optInt("owner_type"));
        r8.setShareVersion(r7.optInt("share_version"));
        r8.setObjSubType(r7.optLong("obj_sub_type"));
        JSONObject r1 = r7.optJSONObject("extra");
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        r8.setShareFolder(r3);
        JSONObject r0 = r7.optJSONObject("extra");
        if (r0 != null) goto L15;
    L17:
        r8.setExternal(r2);
        r8.setIconInfo(r7.optString("icon_info"));
        return r8;
    L15:
        if (r0.optBoolean("is_external") != true) goto L17;
        r2 = true;
        goto L17
    L9:
        if (r1.optBoolean("is_share_folder") != true) goto L11;
        r3 = true;
        goto L12
    }
}
