package com.bytedance.ee.bear.list;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class u implements NetService.c<DocumentListInfo> {
    public DocumentListInfo a;
    public final boolean b;

    public void c(DocumentListInfo r1, JSONObject r2) {
    }

    public void g(JSONObject r1) {
    }

    public u() {
        this.b = true;
    }

    public static int b(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return 0;
    L10:
        return new JSONObject(r3).optInt("base_biz_type");
    L7:
        e = move-exception;
        tt5.a.e("DocumentListParser", "parseBaseBizType:", e, false);
        return 0;
    }

    public DocumentListInfo a(String r5) {
        this.a = new DocumentListInfo();
        JSONObject r3 = new JSONObject(r5);     // Catch: JSONException -> L12
        if (r3.optInt("code") != 0) goto L6;
        boolean r6 = true;
    L7:
        if (r6 == true) goto L10;
        tt5.a.h("DocumentListParser", "parse()...error code = " + r3.optInt("code"));     // Catch: JSONException -> L12
        return this.a;
    L10:
        JSONObject r7 = r3.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L12
        c(this.a, r7);     // Catch: JSONException -> L12
        e(this.a, r7);     // Catch: JSONException -> L12
        f(this.a, r7);     // Catch: JSONException -> L12
    L14:
        return this.a;
    L6:
        r6 = false;
    L12:
        tt5.a.d("DocumentListParser", "new mainObj exception");
        goto L14
    }

    public /* bridge */ /* synthetic */ Result parse(String r1) throws NetService.ParseException {
        return a(r1);
    }

    public DocumentListInfo e(DocumentListInfo r10, JSONObject r11) {
        JSONArray r0 = r11.optJSONArray("node_list");
        JSONObject r12 = r11.optJSONObject("entities");
        JSONObject r1 = r12.optJSONObject("nodes");
        JSONObject r13 = r12.optJSONObject("users");
        g(r13);
        int r2 = 0;
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        boolean r5 = false;
    L8:
        if (r5 == false) goto L10;
        return r10;
    L10:
        ArrayList<Document> r6 = new ArrayList();
    L12:
        if (r2 >= r0.length()) goto L25;
        JSONObject r7 = r1.optJSONObject(r0.optString(r2));
        JSONObject r8 = null;
        if (r13 != null) goto L16;
        JSONObject r9 = null;
    L17:
        if (r13 == null) goto L20;
        r8 = r13.optJSONObject(r7.optString("sharer_id"));
    L20:
        Document r14 = d(r7, r9, r8, true);
        if (r14 != null) goto L23;
        tt5.a.h("DocumentListParser", "parseList()...temp is null");
    L24:
        r2 = r2 + 1;
        goto L12
    L23:
        r6.add(r14);
        goto L24
    L16:
        r9 = r13.optJSONObject(r7.optString("owner_id"));
        goto L17
    L25:
        r10.setDocumentList(r6);
        return r10;
    L7:
        tt5.a.h("DocumentListParser", "parseNodes()...null");
        r5 = true;
        goto L8
    }

    public void f(DocumentListInfo r3, JSONObject r4) {
        r3.setHasMore(r4.optBoolean("has_more"));
        r3.setCheckId(r4.optString("check_id"));
        r3.setNextId(r4.optString("next_id"));
        int r0 = r4.optInt("total", hu5.a.c(r3.getDocumentList()));
        if (r0 > 0) goto L5;
    L7:
        r3.setTotal(r0);
        r3.setLastLabel(r4.optString("last_label"));
        return;
    L5:
        if (hu5.a.d(r3.getDocumentList()) == false) goto L7;
        r0 = 0;
        goto L7
    }

    public Document d(JSONObject r10, JSONObject r11, JSONObject r12, boolean r13) {
        if (r10 != null) goto L6;
        tt5.a.h("DocumentListParser", "parseDoc()...null");
        return null;
    L6:
        Document r2 = new Document();
        int r3 = r10.optInt(ResourceData.KEY_TYPE, sbb.e.g.b);
        if (this.b == false) goto L13;
        if (((HashSet) w4.a().a).contains(Integer.valueOf(r3)) == true) goto L13;
        tt5.a.h("DocumentListParser", "parseDoc()...unknown type!!!, type = " + r3);
        return null;
    L13:
        if (r3 != sbb.e.f.b) goto L25;
        int r5 = r10.optInt("owner_type");
        if (this.b == true) goto L17;
    L20:
        r2.L1 = r5;
        int r6 = r10.optInt("share_version");
        if (FolderVersion.isNewShareFolder(r6) == false) goto L24;
        if (r13 == false) goto L24;
        return null;
    L24:
        r2.T = r6;
        goto L25
    L17:
        if (FolderVersion.acceptOwnerType(r5) == true) goto L20;
        tt5.a.h("DocumentListParser", "parseDoc()...unknown ownerType!!!, ownerType = " + r5);
        return null;
    L25:
        r2.b = r3;
        r2.a = r10.optString("name");
        r2.c = r10.optString(ResourceData.KEY_TOKEN);
        r2.d = r10.optString(ResourceData.KEY_OBJ_TOKEN);
        r2.e = r10.optString("owner_id");
        r2.g = r10.optString("edit_uid");
        r2.i = r10.optString("edit_time");
        r2.j = r10.optString("create_time");
        if (r10.has("add_time") == false) goto L28;
        r2.V = r10.optString("add_time");
    L28:
        r2.W = r10.optString("star_time");
        r2.z = r10.optBoolean("is_stared");
        r2.p = r10.optString(ResourceData.KEY_URL);
        r2.F = r10.optString("subtype");
        r2.G = r10.optLong("obj_sub_type", 0);
        r2.q = r10.optString("thumbnail");
        r2.L = r10.optBoolean("is_pined");
        r2.A = r10.optBoolean("is_subscribed");
        r2.L1 = r10.optInt("owner_type");
        r2.M1 = r10.optInt("node_type", 0);
        r2.O = r10.optString("extra");
        r2.b2 = r10.optBoolean("secret_key_delete");
        r2.k1.a = r10.optString("icon_key");
        r2.k1.b = r10.optInt("icon_type", -1);
        r2.k1.c = r10.optString("icon_fsunit");
        r2.T1 = r10.optString("security_name");
        r2.V1 = r10.optInt("security_level");
        r2.h2 = r10.optInt("obj_biz_type");
        r2.p2 = r10.optString("obj_node_token");
        r2.v2 = r10.optInt("delete_flag");
        r2.F2 = r10.optString("icon_info");
        if (TextUtils.isEmpty(r2.O) == false) goto L49;
    L37:
        String r0 = r10.optString("thumbnail_extra");
        if (TextUtils.isEmpty(r0) == false) goto L51;
    L43:
        r2.I2 = r10.optBoolean("is_owner", false);
        if (r11 == null) goto L46;
        String r1 = Locale.CHINESE.getLanguage();
        String r4 = r11.optString("display_name");
        String r7 = r11.optString("cn_name");
        r2.r = ou5.a.d(r1, r4, r7, r7);
        String r8 = Locale.ENGLISH.getLanguage();
        String r9 = r11.optString("display_name");
        String r14 = r11.optString("en_name");
        r2.s = ou5.a.d(r8, r9, r14, r14);
        r2.f = r11.optString("tenant_id");
    L46:
        if (r12 == null) goto L48;
        String r15 = Locale.CHINESE.getLanguage();
        String r16 = r12.optString("display_name");
        String r17 = r12.optString("cn_name");
        r2.X = ou5.a.d(r15, r16, r17, r17);
        String r18 = Locale.ENGLISH.getLanguage();
        String r19 = r12.optString("display_name");
        String r110 = r12.optString("en_name");
        r2.Y = ou5.a.d(r18, r19, r110, r110);
    L48:
        return r2;
    L51:
        JSONObject r20 = new JSONObject(r0);     // Catch: JSONException -> L41
        r2.V0 = r20.optString(ResourceData.KEY_URL);     // Catch: JSONException -> L41
        r2.b1 = r20.optString("secret");     // Catch: JSONException -> L41
        r2.g1 = r20.optString("nonce");     // Catch: JSONException -> L41
        r2.h1 = r20.optInt(ResourceData.KEY_TYPE);     // Catch: JSONException -> L41
    L41:
        e = move-exception;
        tt5.a.e("DocumentListParser", "parseThumbnailExtra:", e, false);
        goto L43
    L49:
        JSONObject r21 = new JSONObject(r2.O);     // Catch: JSONException -> L35
        r2.x = r21.optBoolean("is_external");     // Catch: JSONException -> L35
        r2.F = r21.optString("subtype");     // Catch: JSONException -> L35
        r2.m = r21.optString("space_id");     // Catch: JSONException -> L35
        r2.n = r21.optBoolean("is_share_root");     // Catch: JSONException -> L35
        r2.H = r21.optString("icon");     // Catch: JSONException -> L35
        r2.I = r21.optString("icon_key");     // Catch: JSONException -> L35
        r2.J = r21.optString("icon_nonce");     // Catch: JSONException -> L35
        r2.K = r21.optInt("icon_encrypted_type");     // Catch: JSONException -> L35
        r2.S = r21.optBoolean("copiable");     // Catch: JSONException -> L35
        r2.L0 = r21.optBoolean("is_visited");     // Catch: JSONException -> L35
        r2.p1 = r21.optBoolean("has_perm", true);     // Catch: JSONException -> L35
        r2.x1 = r21.optString("app_id");     // Catch: JSONException -> L35
        r2.y1 = r21.optInt("wiki_subtype");     // Catch: JSONException -> L35
        r2.G1 = r21.optString("wiki_sub_token");     // Catch: JSONException -> L35
        r2.P1 = r21.optBoolean("is_share_folder", false);     // Catch: JSONException -> L35
        r2.Q1 = r21.optBoolean("complaint", false);     // Catch: JSONException -> L35
        r2.S1 = r21.optString("description");     // Catch: JSONException -> L35
        r2.g2 = r21.optInt("template_type");     // Catch: JSONException -> L35
        r2.y = r21.optBoolean("file_risk_tag");     // Catch: JSONException -> L35
        r2.H2 = r21.optBoolean("is_wiki_home_page");     // Catch: JSONException -> L35
        JSONObject r22 = r21.optJSONObject("display_tag");     // Catch: JSONException -> L35
        if (r22 == null) goto L33;
        r2.E2 = r22.optString("tag_value");     // Catch: JSONException -> L35
    L33:
        r2.J2 = r21.optString("doubao_ai_skill_status");     // Catch: JSONException -> L35
        r2.K2 = r21.optString("doubao_conversation_id");     // Catch: JSONException -> L35
        r2.L2 = r21.optString("doubao_code_project_key");     // Catch: JSONException -> L35
        r2.M2 = r21.optInt("base_biz_type");     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        tt5.a.e("DocumentListParser", "parseExtra:", e, false);
        goto L37
    }
}
