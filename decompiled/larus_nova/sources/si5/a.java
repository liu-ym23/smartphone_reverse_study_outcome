package si5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<ShareUserInfoResult> {

    /* JADX INFO: renamed from: si5.a$a, reason: collision with other inner class name */
    public static final class C7617a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r110) {
        Intrinsics.checkNotNullParameter(r110, "json");
        ShareUserInfoResult r100 = new ShareUserInfoResult();
        r100.setUserInfoList(new ArrayList());
        if (TextUtils.isEmpty(r110) == false) goto L51;
        tt5.a.d("CollaboratorInfoParser", "get json is null!");
    L50:
        return r100;
    L51:
        JSONObject r111 = new JSONObject(r110).optJSONObject("data");     // Catch: Exception -> L48
        if (r111 == null) goto L50;
        r100.setHasMore(r111.optBoolean("has_more"));     // Catch: Exception -> L48
        String r101 = r111.optString("last_label");     // Catch: Exception -> L48
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        r100.setLastLabel(r101);     // Catch: Exception -> L48
        JSONArray r102 = r111.optJSONArray("collaborators");     // Catch: Exception -> L48
        if (r102 == null) goto L50;
        int r103 = r102.length() - 1;     // Catch: Exception -> L48
        if (r103 < 0) goto L50;
        int r104 = 0;
    L17:
        UserInfo r105 = new UserInfo();     // Catch: Exception -> L48
        JSONObject r106 = r102.optJSONObject(r104);     // Catch: Exception -> L48
        if (r106 == null) goto L45;
        r105.setPermission(r106.optInt("perm_role"));     // Catch: Exception -> L48
        r105.setExternal(r106.optBoolean("is_external"));     // Catch: Exception -> L48
        r105.setOwner(r106.optBoolean("is_owner"));     // Catch: Exception -> L48
        r105.setPermSource(r106.optString("perm_source"));     // Catch: Exception -> L48
        r105.setCan_modify_perm(r106.optBoolean("can_modify_perm"));     // Catch: Exception -> L48
        r105.setOwnerType(r106.optInt("collaborator_type"));     // Catch: Exception -> L48
        String r107 = r106.optString("avatar_url");     // Catch: Exception -> L48
        if (r107 != null) goto L22;
        r107 = "";
    L22:
        r105.setAvatarUrl(r107);     // Catch: Exception -> L48
        String r108 = r106.optString("collaborator_id");     // Catch: Exception -> L48
        if (r108 != null) goto L25;
        r108 = "";
    L25:
        r105.setId(r108);     // Catch: Exception -> L48
        String r109 = r106.optString("collaborator_name");     // Catch: Exception -> L48
        if (r109 != null) goto L28;
        r109 = "";
    L28:
        r105.setName(r109);     // Catch: Exception -> L48
        String r112 = r106.optString("tenant_name");     // Catch: Exception -> L48
        if (r112 != null) goto L31;
        r112 = "";
    L31:
        r105.setTenantName(r112);     // Catch: Exception -> L48
        String r113 = r106.optString(IGoogleService.ResponseKey.DISPLAY_NAME);     // Catch: Exception -> L48
        if (r113 != null) goto L34;
        r113 = "";
    L34:
        r105.setDisplayName(r113);     // Catch: Exception -> L48
        r105.setBlockStatus(r106.optInt("block_status"));     // Catch: Exception -> L48
        int r114 = r105.getOwnerType();     // Catch: Exception -> L48
        if (r114 != 0) goto L37;
    L39:
        a(r105, r111);     // Catch: Exception -> L48
    L40:
        JSONObject r115 = r106.optJSONObject("display_tag");     // Catch: Exception -> L48
        if (r115 == null) goto L43;
        String r116 = r115.optString("tag_value");     // Catch: Exception -> L48
    L44:
        r105.setOrganizationTagValue(r116);     // Catch: Exception -> L48
        goto L45
    L43:
        r116 = null;
        goto L44
    L37:
        if (r114 == 17) goto L39;
    L45:
        r100.getUserInfoList().add(r105);     // Catch: Exception -> L48
        if (r104 == r103) goto L50;
        r104 = r104 + 1;
    L48:
        e = move-exception;
        tt5.a.e("CollaboratorInfoParser", "parse Collaborator error with:", e, false);
        goto L50
    }

    public static void a(UserInfo r100, JSONObject r101) {
        JSONObject r102 = r101.optJSONObject("entities");
        if (r102 == null) goto L5;
        JSONObject r103 = r102.optJSONObject("users");
    L6:
        if (r103 == null) goto L11;
        JSONObject r104 = r103.optJSONObject(r100.getId());
        if (r104 == null) goto L12;
        r100.setTenantId(r104.optString("tenant_id"));
        r100.setLabel(r104.optString("department_name"));
        r100.setTenant_tag(r104.optString("tenant_tag"));
        r100.setAvatarUrl(r104.optString("avatar_url"));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
