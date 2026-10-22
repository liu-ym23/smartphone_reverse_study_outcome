package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class e0 implements NetService.c<VisibleSecretResult> {
    public e0() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r510) {
        VisibleSecretResult r100 = new VisibleSecretResult();
        r100.data = new ArrayList();
        if (r510 != null) goto L34;
    L33:
        return r100;
    L34:
        JSONObject r101 = new JSONObject(r510).optJSONObject("data");     // Catch: Throwable -> L31
        JSONArray r102 = null;
        if (r101 == null) goto L9;
        String r103 = r101.optString("help_doc_link");     // Catch: Throwable -> L31
    L10:
        r100.setHelpDocLink(r103);     // Catch: Throwable -> L31
        if (r101 == null) goto L13;
        boolean r104 = r101.optBoolean("must_need_downgrade_reason");     // Catch: Throwable -> L31
    L14:
        r100.setMustNeedDowngradeReason(r104);     // Catch: Throwable -> L31
        if (r101 == null) goto L17;
        r102 = r101.optJSONArray("sec_label_list");     // Catch: Throwable -> L31
    L17:
        if (r102 != null) goto L19;
    L29:
        tt5.a.h("VisibleSecretParser", "array is null or empty");     // Catch: Throwable -> L31
        goto L33
    L19:
        if (r102.length() == 0) goto L29;
        int r105 = r102.length();     // Catch: Throwable -> L31
        int r106 = 0;
    L22:
        if (r106 >= r105) goto L28;
        JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r102, r106);     // Catch: Throwable -> L31
        JSONObject r108 = r107.optJSONObject("permission_control");     // Catch: Throwable -> L31
        if (r108 != null) goto L26;
        PermissionControl r410 = new PermissionControl(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, UnixStat.PERM_MASK, null);     // Catch: Throwable -> L31
    L27:
        String r310 = r107.optString("id");     // Catch: Throwable -> L31
        boolean r411 = r107.optBoolean("enable_protect");     // Catch: Throwable -> L31
        ((ArrayList) r100.data).add(new SecretLevel(r310, r107.optString("name"), r107.optString("description"), r107.optInt("level"), r411, r107.optString("tips"), r107.optString("apply_tips"), r410, false, false, r107.optString("apply_warn_tips"), r107.optString("apply_tips_v2"), r107.optString("search_checkbox_desc"), r107.optString("apply_tips_not_searchable"), Integer.valueOf(r107.optInt("searchable")), Integer.valueOf(r107.optInt("search_box_status")), null, 66304, null));     // Catch: Throwable -> L31
        r106 = r106 + 1;     // Catch: Throwable -> L31
        goto L22
    L26:
        r410 = new PermissionControl(r108.optInt("share_entity"), r108.optInt("security_entity"), r108.optInt("comment_entity"), r108.optInt("link_share_entity"), r108.optBoolean("external_access_switch", true), r108.optInt("share_external_entity"), r108.optInt("manage_collaborator_entity"), r108.optBoolean("link_password_switch"), r108.optInt("copy_entity"), r108.optInt("external_access_entity"), r108.optInt("search_entity", -1), r108.optInt("disable_ai_search_entity", -1));     // Catch: Throwable -> L31
        goto L27
    L28:
        CollectionsKt.sortWith((List) r100.data, d0.f234036a);     // Catch: Throwable -> L31
        goto L33
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = null;
    L31:
        th = move-exception;
        tt5.a.f("VisibleSecretParser", th, false);
        goto L33
    }
}
