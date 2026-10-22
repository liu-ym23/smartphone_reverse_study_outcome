package si5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<ShareUserInfoResult> {

    /* JADX INFO: renamed from: si5.a$a, reason: collision with other inner class name */
    public static final class C0306a {
    }

    static {
    }

    public a() {
    }

    public final Result parse(String r12) {
        Intrinsics.checkNotNullParameter(r12, "json");
        ShareUserInfoResult r0 = new ShareUserInfoResult();
        r0.setUserInfoList(new ArrayList());
        if (TextUtils.isEmpty(r12) == false) goto L51;
        tt5.a.d("CollaboratorInfoParser", "get json is null!");
    L50:
        return r0;
    L51:
        JSONObject r13 = new JSONObject(r12).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L48
        if (r13 == null) goto L50;
        r0.setHasMore(r13.optBoolean("has_more"));     // Catch: Exception -> L48
        String r3 = r13.optString("last_label");     // Catch: Exception -> L48
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        r0.setLastLabel(r3);     // Catch: Exception -> L48
        JSONArray r4 = r13.optJSONArray("collaborators");     // Catch: Exception -> L48
        if (r4 == null) goto L50;
        int r5 = r4.length() - 1;     // Catch: Exception -> L48
        if (r5 < 0) goto L50;
        int r6 = 0;
    L17:
        UserInfo r7 = new UserInfo();     // Catch: Exception -> L48
        JSONObject r8 = r4.optJSONObject(r6);     // Catch: Exception -> L48
        if (r8 == null) goto L45;
        r7.setPermission(r8.optInt("perm_role"));     // Catch: Exception -> L48
        r7.setExternal(r8.optBoolean("is_external"));     // Catch: Exception -> L48
        r7.setOwner(r8.optBoolean("is_owner"));     // Catch: Exception -> L48
        r7.setPermSource(r8.optString("perm_source"));     // Catch: Exception -> L48
        r7.setCan_modify_perm(r8.optBoolean("can_modify_perm"));     // Catch: Exception -> L48
        r7.setOwnerType(r8.optInt("collaborator_type"));     // Catch: Exception -> L48
        String r9 = r8.optString("avatar_url");     // Catch: Exception -> L48
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        r7.setAvatarUrl(r9);     // Catch: Exception -> L48
        String r10 = r8.optString("collaborator_id");     // Catch: Exception -> L48
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        r7.setId(r10);     // Catch: Exception -> L48
        String r11 = r8.optString("collaborator_name");     // Catch: Exception -> L48
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        r7.setName(r11);     // Catch: Exception -> L48
        String r14 = r8.optString("tenant_name");     // Catch: Exception -> L48
        if (r14 != null) goto L31;
        r14 = "";
    L31:
        r7.setTenantName(r14);     // Catch: Exception -> L48
        String r15 = r8.optString("display_name");     // Catch: Exception -> L48
        if (r15 != null) goto L34;
        r15 = "";
    L34:
        r7.setDisplayName(r15);     // Catch: Exception -> L48
        r7.setBlockStatus(r8.optInt("block_status"));     // Catch: Exception -> L48
        int r16 = r7.getOwnerType();     // Catch: Exception -> L48
        if (r16 != 0) goto L37;
    L39:
        a(r7, r13);     // Catch: Exception -> L48
    L40:
        JSONObject r17 = r8.optJSONObject("display_tag");     // Catch: Exception -> L48
        if (r17 == null) goto L43;
        String r18 = r17.optString("tag_value");     // Catch: Exception -> L48
    L44:
        r7.setOrganizationTagValue(r18);     // Catch: Exception -> L48
        goto L45
    L43:
        r18 = null;
        goto L44
    L37:
        if (r16 == 17) goto L39;
    L45:
        r0.getUserInfoList().add(r7);     // Catch: Exception -> L48
        if (r6 == r5) goto L50;
        r6 = r6 + 1;
    L48:
        e = move-exception;
        tt5.a.e("CollaboratorInfoParser", "parse Collaborator error with:", e, false);
        goto L50
    }

    public static void a(UserInfo r1, JSONObject r2) {
        JSONObject r3 = r2.optJSONObject("entities");
        if (r3 == null) goto L5;
        JSONObject r4 = r3.optJSONObject("users");
    L6:
        if (r4 == null) goto L11;
        JSONObject r5 = r4.optJSONObject(r1.getId());
        if (r5 == null) goto L12;
        r1.setTenantId(r5.optString("tenant_id"));
        r1.setLabel(r5.optString("department_name"));
        r1.setTenant_tag(r5.optString("tenant_tag"));
        r1.setAvatarUrl(r5.optString("avatar_url"));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
