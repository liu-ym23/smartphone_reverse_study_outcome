package zg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.m;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import jg5.i;
import jg5.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements NetService.c<ShareUserInfoResult> {
    public final String a;

    public b(String r1) {
        this.a = r1;
    }

    public final Result parse(String r17) throws NetService.ParseException {
        ShareUserInfoResult r4 = new ShareUserInfoResult();
        ArrayList<UserInfo> r5 = new ArrayList();
        JSONObject r7 = new JSONObject(r17).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L21
        JSONArray r8 = r7.optJSONArray("members");     // Catch: JSONException -> L21
        r4.setExternal(r7.optBoolean("is_external"));     // Catch: JSONException -> L21
        r4.setTotalNum(r7.optInt("total_num"));     // Catch: JSONException -> L21
        r4.setHasMore(r7.optBoolean("has_more"));     // Catch: JSONException -> L21
        r4.setLastLabel(r7.optString("last_label"));     // Catch: JSONException -> L21
        JSONObject r9 = r7.optJSONObject("entities").optJSONObject("users");     // Catch: JSONException -> L21
        int r10 = r8.length();     // Catch: JSONException -> L21
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L22;
        UserInfo r12 = new UserInfo();     // Catch: JSONException -> L21
        JSONObject r13 = JSONArrayProtectorUtils.getJSONObject(r8, r11);     // Catch: JSONException -> L21
        String r14 = r13.optString("owner_id");     // Catch: JSONException -> L21
        r12.setId(r14);     // Catch: JSONException -> L21
        r12.setBlockStatus(r13.optInt("block_status"));     // Catch: JSONException -> L21
        r12.setName(r13.optString("owner_name"));     // Catch: JSONException -> L21
        r12.setAvatarUrl(r13.optString("avatar_url"));     // Catch: JSONException -> L21
        r12.setPermission(r13.optInt("permissions"));     // Catch: JSONException -> L21
        r12.setOwner(r13.optBoolean("is_owner"));     // Catch: JSONException -> L21
        r12.setOwnerType(r13.optInt("owner_type"));     // Catch: JSONException -> L21
        r12.setExternal(r13.optBoolean("is_external"));     // Catch: JSONException -> L21
        r12.setHas_tips(r13.optBoolean("has_tips", false));     // Catch: JSONException -> L21
        r12.setCan_modify_perm(r13.optBoolean("can_modify_perm", false));     // Catch: JSONException -> L21
        r12.setPermSource(r13.optString("perm_source", ""));     // Catch: JSONException -> L21
        r12.setWikiDescription(r13.optString("wiki_description", ""));     // Catch: JSONException -> L21
        r12.setTooltipsType(r13.optInt("tooltips_type"));     // Catch: JSONException -> L21
        r12.setIconToken(r13.optString("icon_token", ""));     // Catch: JSONException -> L21
        r12.setDepartment(r13.optString("department_name"));     // Catch: JSONException -> L21
        r12.setGroupDescription(r13.optString("group_description"));     // Catch: JSONException -> L21
        int r15 = r12.getOwnerType();     // Catch: JSONException -> L21
        if (r15 != 0) goto L8;
    L13:
        r12.setLabel(r13.optString("department_name"));     // Catch: JSONException -> L21
        JSONObject r16 = r9.optJSONObject(r14);     // Catch: JSONException -> L21
        if (r16 == null) goto L16;
        r12.setCnName(r16.optString("cn_name"));     // Catch: JSONException -> L21
        r12.setEnName(r16.optString("en_name"));     // Catch: JSONException -> L21
        r12.setTenantName(r16.optString("tenant_name"));     // Catch: JSONException -> L21
        r12.setTenantId(r16.optString("tenant_id"));     // Catch: JSONException -> L21
        r12.setTenant_tag(r16.optString("tenant_tag"));     // Catch: JSONException -> L21
        r12.setIs_single_product(r16.optBoolean("is_single_product"));     // Catch: JSONException -> L21
        r12.setDisplayName(r16.optString("display_name"));     // Catch: JSONException -> L21
    L16:
        JSONObject r18 = r13.optJSONObject("display_tag");     // Catch: JSONException -> L21
        if (r18 == null) goto L19;
        r12.setOrganizationTagValue(r18.optString("tag_value"));     // Catch: JSONException -> L21
    L19:
        r5.add(r12);     // Catch: JSONException -> L21
        r11 = r11 + 1;
        goto L4
    L8:
        if (r15 != 2) goto L10;
        r12.setLabel(r13.optString("group_description"));     // Catch: JSONException -> L21
        goto L16
    L10:
        if (r15 == 17) goto L13;
    L22:
        j r0 = ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa();
        String r2 = this.a;
        int r3 = r5.size();
        r0.getClass();
        m.a(new i(r2, r3));
        if (r5.isEmpty() == true) goto L48;
        Iterator<UserInfo> r1 = r5.iterator();
        UserInfo r6 = null;
        UserInfo r19 = null;
        UserInfo r20 = null;
        UserInfo r21 = null;
    L27:
        if (r1.hasNext() == false) goto L40;
        UserInfo r22 = r1.next();
        if (r22.getOwnerType() != 23) goto L32;
        r21 = r22;
    L32:
        if (r22.getOwnerType() != 28) goto L35;
        r20 = r22;
    L35:
        if (r22.getOwnerType() != 24) goto L38;
        r19 = r22;
    L38:
        if (r22.isOwner() == false) goto L27;
        r6 = r22;
        goto L27
    L40:
        if (r6 == null) goto L42;
        r5.remove(r6);
        ListProtector.add(r5, 0, r6);
    L42:
        if (r19 == null) goto L44;
        r5.remove(r19);
        ListProtector.add(r5, 0, r19);
    L44:
        if (r20 == null) goto L46;
        r5.remove(r20);
        ListProtector.add(r5, 0, r20);
    L46:
        if (r21 == null) goto L48;
        r5.remove(r21);
        ListProtector.add(r5, 0, r21);
    L48:
        r4.setUserInfoList(r5);
        return r4;
    L21:
        tt5.a.h("UserInfoV2Parser", "new mainObj exception");
        goto L22
    }
}
