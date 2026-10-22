package wh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.setting.DocumentSettingViewModel;
import com.bytedance.ee.bear.middleground.permission.permission.doc.BlockOptions;
import com.bytedance.ee.bear.middleground.permission.permission.doc.BlockOptionsV2;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPublicPermission;
import com.bytedance.ee.bear.middleground.permission.permission.doc.PermType;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements NetService.c<DocPublicPermission> {
    public h() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r510) {
        if (r510 != null) goto L5;
        String r100 = "";
    L6:
        JSONObject r101 = new JSONObject(r100);
        int r102 = i.f559700a;
        JSONObject r103 = r101.optJSONObject("data");
        if (r103 != null) goto L9;
        r103 = new JSONObject();
    L9:
        Intrinsics.checkNotNullParameter(r103, "dataObj");
        JSONObject r104 = r103.optJSONObject("perm_public");     // Catch: Exception -> L41
        if (r104 != null) goto L13;
        r104 = new JSONObject();     // Catch: Exception -> L41
    L13:
        JSONObject r105 = r103.optJSONObject("config_info");     // Catch: Exception -> L41
        JSONObject r106 = r104.optJSONObject("block_options");     // Catch: Exception -> L41
        if (r106 != null) goto L16;
        BlockOptions r110 = new BlockOptions(null, null, null, null, null, null, null, null, null, null, 1023, null);     // Catch: Exception -> L41
    L17:
        BlockOptions r410 = r110;
        if (r106 != null) goto L20;
        BlockOptionsV2 r107 = new BlockOptionsV2(null, null, null, null, null, null, null, null, null, null, 1023, null);     // Catch: Exception -> L41
    L21:
        BlockOptionsV2 r411 = r107;
        JSONObject r108 = r104.optJSONObject(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE);     // Catch: Exception -> L41
        if (r108 != null) goto L25;
        PermType r412 = new PermType(0, 0, 0, 7, null);     // Catch: Exception -> L41
    L26:
        int r210 = r104.optInt("share_external_entity");     // Catch: Exception -> L41
        int r211 = r104.optInt("link_share_entity_v2");     // Catch: Exception -> L41
        int r212 = r104.optInt("search_entity");     // Catch: Exception -> L41
        int r213 = r104.optInt("comment_entity");     // Catch: Exception -> L41
        int r214 = r104.optInt("share_entity");     // Catch: Exception -> L41
        boolean r109 = r104.optBoolean("has_modified_link_share");     // Catch: Exception -> L41
        int r215 = r104.optInt("manage_collaborator_entity");     // Catch: Exception -> L41
        int r216 = r104.optInt("security_entity");     // Catch: Exception -> L41
        int r217 = r104.optInt("copy_entity");     // Catch: Exception -> L41
        int r218 = r104.optInt("show_collaborator_info_entity");     // Catch: Exception -> L41
        int r310 = r104.optInt("external_access_entity");     // Catch: Exception -> L41
        boolean r311 = r104.optBoolean("link_password_switch");     // Catch: Exception -> L41
        String r312 = r104.optString("link_password", "");     // Catch: Exception -> L41
        int r313 = r104.optInt("apply_embed_entity");     // Catch: Exception -> L41
        boolean r314 = r104.optBoolean("leader_copy_switch");     // Catch: Exception -> L41
        boolean r315 = r103.optBoolean("is_owner");     // Catch: Exception -> L41
        int r316 = r103.optInt("owner_perm_type");     // Catch: Exception -> L41
        int r317 = r103.optInt("admin_external_access");     // Catch: Exception -> L41
        boolean r318 = r103.optBoolean("anonymous_verify");     // Catch: Exception -> L41
        boolean r319 = r104.optBoolean("lock_switch");     // Catch: Exception -> L41
        boolean r413 = r103.optBoolean("can_unlock");     // Catch: Exception -> L41
        JSONArray r111 = r103.optJSONArray("partner_tenant_ids");     // Catch: Exception -> L41
        ArrayList r112 = new ArrayList();     // Catch: Exception -> L41
        if (r111 == null) goto L31;
        int r113 = r111.length();     // Catch: Exception -> L41
        int r114 = 0;
    L29:
        if (r114 >= r113) goto L31;
        r112.add(JSONArrayProtectorUtils.getString(r111, r114));     // Catch: Exception -> L41
        r114 = r114 + 1;     // Catch: Exception -> L41
    L31:
        String r115 = r103.toString();     // Catch: Exception -> L41
        if (r115 != null) goto L34;
        String r414 = "";
    L35:
        if (r105 != null) goto L38;
        IDocPublicPermission.ConfigInfo r116 = null;
    L37:
        IDocPublicPermission.ConfigInfo r415 = r116;
        int r117 = r104.optInt("visibility_status");     // Catch: Exception -> L41
        return new DocPublicPermission(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r413, r112, r414, r412, r410, r411, r415, Boolean.valueOf(r109), Integer.valueOf(r117));
    L38:
        r116 = new IDocPublicPermission.ConfigInfo(r105.optInt(IDocPublicPermission.ConfigInfo.CONFIG_LEADER_SEARCH_NUMBER_KEY));     // Catch: Exception -> L41
        goto L37
    L34:
        r414 = r115;
        goto L35
    L25:
        r412 = new PermType(r108.optInt("external_access_switch"), r108.optInt("link_share_entity"), r108.optInt("search_entity"));     // Catch: Exception -> L41
        goto L26
    L20:
        r107 = i.d(r106);     // Catch: Exception -> L41
        goto L21
    L16:
        r110 = i.c(r106);     // Catch: Exception -> L41
    L41:
        e = move-exception;
        tt5.a.e("DocPublicPermissionSupport", "parse: ", e, false);
        return new DocPublicPermission(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, null, 0, false, false, 0, 0, false, false, false, null, null, null, null, null, null, null, null, 268435455, null);
    L5:
        r100 = r510;
        goto L6
    }
}
