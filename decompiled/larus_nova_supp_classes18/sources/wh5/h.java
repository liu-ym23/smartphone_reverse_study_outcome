package wh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.BlockOptions;
import com.bytedance.ee.bear.middleground.permission.permission.doc.BlockOptionsV2;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPublicPermission;
import com.bytedance.ee.bear.middleground.permission.permission.doc.PermType;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements NetService.c<DocPublicPermission> {
    public h() {
    }

    public final Result parse(String r50) {
        if (r50 != null) goto L5;
        String r2 = "";
    L6:
        JSONObject r0 = new JSONObject(r2);
        int r3 = i.a;
        JSONObject r1 = r0.optJSONObject(WikiFolderPushPlugin.DATA);
        if (r1 != null) goto L9;
        r1 = new JSONObject();
    L9:
        Intrinsics.checkNotNullParameter(r1, "dataObj");
        JSONObject r4 = r1.optJSONObject("perm_public");     // Catch: Exception -> L41
        if (r4 != null) goto L13;
        r4 = new JSONObject();     // Catch: Exception -> L41
    L13:
        JSONObject r5 = r1.optJSONObject("config_info");     // Catch: Exception -> L41
        JSONObject r6 = r4.optJSONObject("block_options");     // Catch: Exception -> L41
        if (r6 != null) goto L16;
        BlockOptions r19 = new BlockOptions(null, null, null, null, null, null, null, null, null, null, 1023, null);     // Catch: Exception -> L41
    L17:
        BlockOptions r44 = r19;
        if (r6 != null) goto L20;
        BlockOptionsV2 r7 = new BlockOptionsV2(null, null, null, null, null, null, null, null, null, null, 1023, null);     // Catch: Exception -> L41
    L21:
        BlockOptionsV2 r45 = r7;
        JSONObject r8 = r4.optJSONObject("perm_type");     // Catch: Exception -> L41
        if (r8 != null) goto L25;
        PermType r43 = new PermType(0, 0, 0, 7, null);     // Catch: Exception -> L41
    L26:
        int r21 = r4.optInt("share_external_entity");     // Catch: Exception -> L41
        int r22 = r4.optInt("link_share_entity_v2");     // Catch: Exception -> L41
        int r23 = r4.optInt("search_entity");     // Catch: Exception -> L41
        int r24 = r4.optInt("comment_entity");     // Catch: Exception -> L41
        int r25 = r4.optInt("share_entity");     // Catch: Exception -> L41
        boolean r9 = r4.optBoolean("has_modified_link_share");     // Catch: Exception -> L41
        int r26 = r4.optInt("manage_collaborator_entity");     // Catch: Exception -> L41
        int r27 = r4.optInt("security_entity");     // Catch: Exception -> L41
        int r28 = r4.optInt("copy_entity");     // Catch: Exception -> L41
        int r29 = r4.optInt("show_collaborator_info_entity");     // Catch: Exception -> L41
        int r30 = r4.optInt("external_access_entity");     // Catch: Exception -> L41
        boolean r31 = r4.optBoolean("link_password_switch");     // Catch: Exception -> L41
        String r32 = r4.optString("link_password", "");     // Catch: Exception -> L41
        int r33 = r4.optInt("apply_embed_entity");     // Catch: Exception -> L41
        boolean r34 = r4.optBoolean("leader_copy_switch");     // Catch: Exception -> L41
        boolean r35 = r1.optBoolean("is_owner");     // Catch: Exception -> L41
        int r36 = r1.optInt("owner_perm_type");     // Catch: Exception -> L41
        int r37 = r1.optInt("admin_external_access");     // Catch: Exception -> L41
        boolean r38 = r1.optBoolean("anonymous_verify");     // Catch: Exception -> L41
        boolean r39 = r4.optBoolean("lock_switch");     // Catch: Exception -> L41
        boolean r40 = r1.optBoolean("can_unlock");     // Catch: Exception -> L41
        JSONArray r10 = r1.optJSONArray("partner_tenant_ids");     // Catch: Exception -> L41
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L41
        if (r10 == null) goto L31;
        int r12 = r10.length();     // Catch: Exception -> L41
        int r13 = 0;
    L29:
        if (r13 >= r12) goto L31;
        r11.add(JSONArrayProtectorUtils.getString(r10, r13));     // Catch: Exception -> L41
        r13 = r13 + 1;     // Catch: Exception -> L41
    L31:
        String r14 = r1.toString();     // Catch: Exception -> L41
        if (r14 != null) goto L34;
        String r42 = "";
    L35:
        if (r5 != null) goto L38;
        IDocPublicPermission.ConfigInfo r15 = null;
    L37:
        IDocPublicPermission.ConfigInfo r46 = r15;
        int r16 = r4.optInt("visibility_status");     // Catch: Exception -> L41
        return new DocPublicPermission(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r11, r42, r43, r44, r45, r46, Boolean.valueOf(r9), Integer.valueOf(r16));
    L38:
        r15 = new IDocPublicPermission.ConfigInfo(r5.optInt(IDocPublicPermission.ConfigInfo.CONFIG_LEADER_SEARCH_NUMBER_KEY));     // Catch: Exception -> L41
        goto L37
    L34:
        r42 = r14;
        goto L35
    L25:
        r43 = new PermType(r8.optInt("external_access_switch"), r8.optInt("link_share_entity"), r8.optInt("search_entity"));     // Catch: Exception -> L41
        goto L26
    L20:
        r7 = i.d(r6);     // Catch: Exception -> L41
        goto L21
    L16:
        r19 = i.c(r6);     // Catch: Exception -> L41
    L41:
        e = move-exception;
        tt5.a.e("DocPublicPermissionSupport", "parse: ", e, false);
        return new DocPublicPermission(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, null, 0, false, false, 0, 0, false, false, false, null, null, null, null, null, null, null, null, 268435455, null);
    L5:
        r2 = r50;
        goto L6
    }
}
