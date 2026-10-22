package com.bytedance.ee.bear.list;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public class u implements NetService.c<DocumentListInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DocumentListInfo f229803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f229804b;

    public void c(DocumentListInfo r100, JSONObject r101) {
    }

    public void g(JSONObject r100) {
    }

    public u() {
        this.f229804b = true;
    }

    public static int b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return 0;
    L10:
        return new JSONObject(r100).optInt("base_biz_type");
    L7:
        e = move-exception;
        tt5.a.e("DocumentListParser", "parseBaseBizType:", e, false);
        return 0;
    }

    public DocumentListInfo a(String r100) {
        this.f229803a = new DocumentListInfo();
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L12
        if (r101.optInt("code") != 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        tt5.a.h("DocumentListParser", "parse()...error code = " + r101.optInt("code"));     // Catch: JSONException -> L12
        return this.f229803a;
    L10:
        JSONObject r103 = r101.optJSONObject("data");     // Catch: JSONException -> L12
        c(this.f229803a, r103);     // Catch: JSONException -> L12
        e(this.f229803a, r103);     // Catch: JSONException -> L12
        f(this.f229803a, r103);     // Catch: JSONException -> L12
    L14:
        return this.f229803a;
    L6:
        r102 = false;
    L12:
        tt5.a.d("DocumentListParser", "new mainObj exception");
        goto L14
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public /* bridge */ /* synthetic */ Result parse(String r100) throws NetService.ParseException {
        return a(r100);
    }

    public DocumentListInfo e(DocumentListInfo r110, JSONObject r111) {
        JSONArray r100 = r111.optJSONArray("node_list");
        JSONObject r112 = r111.optJSONObject("entities");
        JSONObject r101 = r112.optJSONObject("nodes");
        JSONObject r113 = r112.optJSONObject("users");
        g(r113);
        int r102 = 0;
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        return r110;
    L10:
        ArrayList<Document> r104 = new ArrayList();
    L12:
        if (r102 >= r100.length()) goto L25;
        JSONObject r105 = r101.optJSONObject(r100.optString(r102));
        JSONObject r106 = null;
        if (r113 != null) goto L16;
        JSONObject r107 = null;
    L17:
        if (r113 == null) goto L20;
        r106 = r113.optJSONObject(r105.optString("sharer_id"));
    L20:
        Document r108 = d(r105, r107, r106, true);
        if (r108 != null) goto L23;
        tt5.a.h("DocumentListParser", "parseList()...temp is null");
    L24:
        r102 = r102 + 1;
        goto L12
    L23:
        r104.add(r108);
        goto L24
    L16:
        r107 = r113.optJSONObject(r105.optString("owner_id"));
        goto L17
    L25:
        r110.setDocumentList(r104);
        return r110;
    L7:
        tt5.a.h("DocumentListParser", "parseNodes()...null");
        r103 = true;
        goto L8
    }

    public void f(DocumentListInfo r100, JSONObject r101) {
        r100.setHasMore(r101.optBoolean("has_more"));
        r100.setCheckId(r101.optString(ComplianceConstants.ComplianceRequest.CHECK_ID));
        r100.setNextId(r101.optString("next_id"));
        int r102 = r101.optInt("total", hu5.a.c(r100.getDocumentList()));
        if (r102 > 0) goto L5;
    L7:
        r100.setTotal(r102);
        r100.setLastLabel(r101.optString("last_label"));
        return;
    L5:
        if (hu5.a.d(r100.getDocumentList()) == false) goto L7;
        r102 = 0;
        goto L7
    }

    public Document d(JSONObject r110, JSONObject r111, JSONObject r112, boolean r113) {
        if (r110 != null) goto L6;
        tt5.a.h("DocumentListParser", "parseDoc()...null");
        return null;
    L6:
        Document r100 = new Document();
        int r101 = r110.optInt("type", sbb.e.f541296g.f541317b);
        if (this.f229804b == false) goto L13;
        if (((HashSet) w4.a().f229842a).contains(Integer.valueOf(r101)) == true) goto L13;
        tt5.a.h("DocumentListParser", "parseDoc()...unknown type!!!, type = " + r101);
        return null;
    L13:
        if (r101 != sbb.e.f541295f.f541317b) goto L25;
        int r102 = r110.optInt("owner_type");
        if (this.f229804b == true) goto L17;
    L20:
        r100.L1 = r102;
        int r103 = r110.optInt("share_version");
        if (FolderVersion.isNewShareFolder(r103) == false) goto L24;
        if (r113 == false) goto L24;
        return null;
    L24:
        r100.T = r103;
        goto L25
    L17:
        if (FolderVersion.acceptOwnerType(r102) == true) goto L20;
        tt5.a.h("DocumentListParser", "parseDoc()...unknown ownerType!!!, ownerType = " + r102);
        return null;
    L25:
        r100.f227869b = r101;
        r100.f227868a = r110.optString("name");
        r100.f227872c = r110.optString("token");
        r100.f227873d = r110.optString("obj_token");
        r100.f227874e = r110.optString("owner_id");
        r100.f227876g = r110.optString("edit_uid");
        r100.f227882i = r110.optString("edit_time");
        r100.f227883j = r110.optString("create_time");
        if (r110.has("add_time") == false) goto L28;
        r100.V = r110.optString("add_time");
    L28:
        r100.W = r110.optString("star_time");
        r100.f227910z = r110.optBoolean("is_stared");
        r100.f227891p = r110.optString("url");
        r100.F = r110.optString(PushAction$ESubType.KEY_NAME);
        r100.G = r110.optLong("obj_sub_type", 0);
        r100.f227895q = r110.optString(DocCallbackImpl.KEY_THUMBNAIL);
        r100.L = r110.optBoolean("is_pined");
        r100.A = r110.optBoolean("is_subscribed");
        r100.L1 = r110.optInt("owner_type");
        r100.M1 = r110.optInt("node_type", 0);
        r100.O = r110.optString("extra");
        r100.f227871b2 = r110.optBoolean("secret_key_delete");
        r100.f227886k1.f227911a = r110.optString("icon_key");
        r100.f227886k1.f227912b = r110.optInt("icon_type", -1);
        r100.f227886k1.f227913c = r110.optString("icon_fsunit");
        r100.T1 = r110.optString("security_name");
        r100.V1 = r110.optInt("security_level");
        r100.f227881h2 = r110.optInt("obj_biz_type");
        r100.f227894p2 = r110.optString("obj_node_token");
        r100.f227902v2 = r110.optInt("delete_flag");
        r100.F2 = r110.optString("icon_info");
        if (TextUtils.isEmpty(r100.O) == false) goto L49;
    L37:
        String r104 = r110.optString("thumbnail_extra");
        if (TextUtils.isEmpty(r104) == false) goto L51;
    L43:
        r100.I2 = r110.optBoolean("is_owner", false);
        if (r111 == null) goto L46;
        String r105 = Locale.CHINESE.getLanguage();
        String r106 = r111.optString(IGoogleService.ResponseKey.DISPLAY_NAME);
        String r107 = r111.optString("cn_name");
        r100.f227896r = ou5.a.d(r105, r106, r107, r107);
        String r108 = Locale.ENGLISH.getLanguage();
        String r109 = r111.optString(IGoogleService.ResponseKey.DISPLAY_NAME);
        String r114 = r111.optString("en_name");
        r100.f227897s = ou5.a.d(r108, r109, r114, r114);
        r100.f227875f = r111.optString("tenant_id");
    L46:
        if (r112 == null) goto L48;
        String r115 = Locale.CHINESE.getLanguage();
        String r116 = r112.optString(IGoogleService.ResponseKey.DISPLAY_NAME);
        String r117 = r112.optString("cn_name");
        r100.X = ou5.a.d(r115, r116, r117, r117);
        String r118 = Locale.ENGLISH.getLanguage();
        String r119 = r112.optString(IGoogleService.ResponseKey.DISPLAY_NAME);
        String r120 = r112.optString("en_name");
        r100.Y = ou5.a.d(r118, r119, r120, r120);
    L48:
        return r100;
    L51:
        JSONObject r121 = new JSONObject(r104);     // Catch: JSONException -> L41
        r100.V0 = r121.optString("url");     // Catch: JSONException -> L41
        r100.f227870b1 = r121.optString("secret");     // Catch: JSONException -> L41
        r100.f227877g1 = r121.optString("nonce");     // Catch: JSONException -> L41
        r100.f227880h1 = r121.optInt("type");     // Catch: JSONException -> L41
    L41:
        e = move-exception;
        tt5.a.e("DocumentListParser", "parseThumbnailExtra:", e, false);
        goto L43
    L49:
        JSONObject r122 = new JSONObject(r100.O);     // Catch: JSONException -> L35
        r100.f227904x = r122.optBoolean("is_external");     // Catch: JSONException -> L35
        r100.F = r122.optString(PushAction$ESubType.KEY_NAME);     // Catch: JSONException -> L35
        r100.f227888m = r122.optString(DocViewModel.EXTRA_SPACE_ID);     // Catch: JSONException -> L35
        r100.f227889n = r122.optBoolean("is_share_root");     // Catch: JSONException -> L35
        r100.H = r122.optString("icon");     // Catch: JSONException -> L35
        r100.I = r122.optString("icon_key");     // Catch: JSONException -> L35
        r100.f227867J = r122.optString("icon_nonce");     // Catch: JSONException -> L35
        r100.K = r122.optInt("icon_encrypted_type");     // Catch: JSONException -> L35
        r100.S = r122.optBoolean("copiable");     // Catch: JSONException -> L35
        r100.L0 = r122.optBoolean("is_visited");     // Catch: JSONException -> L35
        r100.f227893p1 = r122.optBoolean("has_perm", true);     // Catch: JSONException -> L35
        r100.f227905x1 = r122.optString("app_id");     // Catch: JSONException -> L35
        r100.f227908y1 = r122.optInt("wiki_subtype");     // Catch: JSONException -> L35
        r100.G1 = r122.optString("wiki_sub_token");     // Catch: JSONException -> L35
        r100.P1 = r122.optBoolean("is_share_folder", false);     // Catch: JSONException -> L35
        r100.Q1 = r122.optBoolean("complaint", false);     // Catch: JSONException -> L35
        r100.S1 = r122.optString("description");     // Catch: JSONException -> L35
        r100.f227878g2 = r122.optInt("template_type");     // Catch: JSONException -> L35
        r100.f227907y = r122.optBoolean("file_risk_tag");     // Catch: JSONException -> L35
        r100.H2 = r122.optBoolean("is_wiki_home_page");     // Catch: JSONException -> L35
        JSONObject r123 = r122.optJSONObject("display_tag");     // Catch: JSONException -> L35
        if (r123 == null) goto L33;
        r100.E2 = r123.optString("tag_value");     // Catch: JSONException -> L35
    L33:
        r100.J2 = r122.optString("doubao_ai_skill_status");     // Catch: JSONException -> L35
        r100.K2 = r122.optString("doubao_conversation_id");     // Catch: JSONException -> L35
        r100.L2 = r122.optString("doubao_code_project_key");     // Catch: JSONException -> L35
        r100.M2 = r122.optInt("base_biz_type");     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        tt5.a.e("DocumentListParser", "parseExtra:", e, false);
        goto L37
    }
}
