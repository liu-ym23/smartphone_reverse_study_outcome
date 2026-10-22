package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 implements NetService.c<VisibleSecretResult> {
    public e0() {
    }

    public final Result parse(String r57) {
        VisibleSecretResult r2 = new VisibleSecretResult();
        ((Result) r2).data = new ArrayList();
        if (r57 != null) goto L34;
    L33:
        return r2;
    L34:
        JSONObject r0 = new JSONObject(r57).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Throwable -> L31
        JSONArray r4 = null;
        if (r0 == null) goto L9;
        String r5 = r0.optString("help_doc_link");     // Catch: Throwable -> L31
    L10:
        r2.setHelpDocLink(r5);     // Catch: Throwable -> L31
        if (r0 == null) goto L13;
        boolean r6 = r0.optBoolean("must_need_downgrade_reason");     // Catch: Throwable -> L31
    L14:
        r2.setMustNeedDowngradeReason(r6);     // Catch: Throwable -> L31
        if (r0 == null) goto L17;
        r4 = r0.optJSONArray("sec_label_list");     // Catch: Throwable -> L31
    L17:
        if (r4 != null) goto L19;
    L29:
        tt5.a.h("VisibleSecretParser", "array is null or empty");     // Catch: Throwable -> L31
        goto L33
    L19:
        if (r4.length() == 0) goto L29;
        int r1 = r4.length();     // Catch: Throwable -> L31
        int r7 = 0;
    L22:
        if (r7 >= r1) goto L28;
        JSONObject r8 = JSONArrayProtectorUtils.getJSONObject(r4, r7);     // Catch: Throwable -> L31
        JSONObject r9 = r8.optJSONObject("permission_control");     // Catch: Throwable -> L31
        if (r9 != null) goto L26;
        PermissionControl r44 = new PermissionControl(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, 4095, null);     // Catch: Throwable -> L31
    L27:
        String r37 = r8.optString(ResourceData.KEY_ID);     // Catch: Throwable -> L31
        boolean r41 = r8.optBoolean("enable_protect");     // Catch: Throwable -> L31
        ((ArrayList) ((Result) r2).data).add(new SecretLevel(r37, r8.optString("name"), r8.optString("description"), r8.optInt("level"), r41, r8.optString("tips"), r8.optString("apply_tips"), r44, false, false, r8.optString("apply_warn_tips"), r8.optString("apply_tips_v2"), r8.optString("search_checkbox_desc"), r8.optString("apply_tips_not_searchable"), Integer.valueOf(r8.optInt("searchable")), Integer.valueOf(r8.optInt("search_box_status")), null, 66304, null));     // Catch: Throwable -> L31
        r7 = r7 + 1;     // Catch: Throwable -> L31
        goto L22
    L26:
        r44 = new PermissionControl(r9.optInt("share_entity"), r9.optInt("security_entity"), r9.optInt("comment_entity"), r9.optInt("link_share_entity"), r9.optBoolean("external_access_switch", true), r9.optInt("share_external_entity"), r9.optInt("manage_collaborator_entity"), r9.optBoolean("link_password_switch"), r9.optInt("copy_entity"), r9.optInt("external_access_entity"), r9.optInt("search_entity", -1), r9.optInt("disable_ai_search_entity", -1));     // Catch: Throwable -> L31
        goto L27
    L28:
        CollectionsKt.sortWith((List) ((Result) r2).data, d0.a);     // Catch: Throwable -> L31
        goto L33
    L13:
        r6 = false;
        goto L14
    L9:
        r5 = null;
    L31:
        th = move-exception;
        tt5.a.f("VisibleSecretParser", th, false);
        goto L33
    }
}
