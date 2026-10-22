package zg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.m;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import jg5.i;
import jg5.j;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements NetService.c<ShareUserInfoResult> {
    public final String a;

    /* JADX INFO: renamed from: zg5.a$a, reason: collision with other inner class name */
    public static final class C0347a {
    }

    static {
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        this.a = r2;
    }

    public final Result parse(String r13) {
        Intrinsics.checkNotNullParameter(r13, "json");
        ShareUserInfoResult r1 = new ShareUserInfoResult();
        ArrayList<UserInfo> r2 = new ArrayList();
        JSONObject r14 = new JSONObject(r13).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L23
        JSONArray r4 = r14.optJSONArray("members");     // Catch: JSONException -> L23
        r1.setExternal(r14.optBoolean("is_external"));     // Catch: JSONException -> L23
        r1.setTotalNum(r14.optInt("total_num"));     // Catch: JSONException -> L23
        r1.setHasMore(r14.optBoolean("has_more"));     // Catch: JSONException -> L23
        r1.setLastLabel(r14.optString("last_label"));     // Catch: JSONException -> L23
        JSONObject r15 = r14.optJSONObject("parent_doc_info");     // Catch: JSONException -> L23
        if (r15 == null) goto L7;
        UserInfo r7 = new UserInfo();     // Catch: JSONException -> L23
        r7.setIconToken(r15.optString("icon_token", ""));     // Catch: JSONException -> L23
        r7.setOwnerType(UserInfo.OWNER_TYPE_SYNCED_BLOCK);     // Catch: JSONException -> L23
        r2.add(r7);     // Catch: JSONException -> L23
    L7:
        int r16 = r4.length();     // Catch: JSONException -> L23
        int r8 = 0;
    L8:
        if (r8 >= r16) goto L24;
        UserInfo r9 = new UserInfo();     // Catch: JSONException -> L23
        JSONObject r10 = JSONArrayProtectorUtils.getJSONObject(r4, r8);     // Catch: JSONException -> L23
        r9.setId(r10.optString("owner_id"));     // Catch: JSONException -> L23
        r9.setBlockStatus(r10.optInt("block_status"));     // Catch: JSONException -> L23
        r9.setName(r10.optString("owner_name"));     // Catch: JSONException -> L23
        r9.setAvatarUrl(r10.optString("avatar_url"));     // Catch: JSONException -> L23
        r9.setPermission(r10.optInt("permissions"));     // Catch: JSONException -> L23
        r9.setOwner(r10.optBoolean("is_owner"));     // Catch: JSONException -> L23
        r9.setOwnerType(r10.optInt("owner_type"));     // Catch: JSONException -> L23
        r9.setExternal(r10.optBoolean("is_external"));     // Catch: JSONException -> L23
        r9.setHas_tips(r10.optBoolean("has_tips", false));     // Catch: JSONException -> L23
        r9.setCan_modify_perm(r10.optBoolean("can_modify_perm", false));     // Catch: JSONException -> L23
        r9.setPermSource(r10.optString("perm_source", ""));     // Catch: JSONException -> L23
        r9.setWikiDescription(r10.optString("wiki_description", ""));     // Catch: JSONException -> L23
        r9.setTooltipsType(r10.optInt("tooltips_type"));     // Catch: JSONException -> L23
        r9.setIconToken(r10.optString("icon_token", ""));     // Catch: JSONException -> L23
        r9.setCnName(r10.optString("cn_name"));     // Catch: JSONException -> L23
        r9.setEnName(r10.optString("en_name"));     // Catch: JSONException -> L23
        r9.setTenantName(r10.optString("tenant_name"));     // Catch: JSONException -> L23
        r9.setTenantId(r10.optString("tenant_id"));     // Catch: JSONException -> L23
        r9.setTenant_tag(r10.optString("tenant_tag"));     // Catch: JSONException -> L23
        r9.setIs_single_product(r10.optBoolean("is_single_product"));     // Catch: JSONException -> L23
        r9.setDisplayName(r10.optString("display_name"));     // Catch: JSONException -> L23
        int r11 = r9.getOwnerType();     // Catch: JSONException -> L23
        if (r11 != 0) goto L12;
    L17:
        r9.setLabel(r10.optString("department_name"));     // Catch: JSONException -> L23
    L18:
        JSONObject r12 = r10.optJSONObject("display_tag");     // Catch: JSONException -> L23
        if (r12 == null) goto L21;
        r9.setOrganizationTagValue(r12.optString("tag_value"));     // Catch: JSONException -> L23
    L21:
        r2.add(r9);     // Catch: JSONException -> L23
        r8 = r8 + 1;
        goto L8
    L12:
        if (r11 != 2) goto L14;
        r9.setLabel(r10.optString("group_description"));     // Catch: JSONException -> L23
        goto L18
    L14:
        if (r11 == 17) goto L17;
    L24:
        UserInfo r5 = null;
        j r17 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r0 = this.a;
        int r6 = r2.size();
        r17.getClass();
        m.a(new i(r0, r6));
        if (r2.isEmpty() == true) goto L50;
        Iterator<UserInfo> r18 = r2.iterator();
        UserInfo r3 = null;
        UserInfo r19 = null;
        UserInfo r20 = null;
    L29:
        if (r18.hasNext() == false) goto L42;
        UserInfo r21 = r18.next();
        if (r21.getOwnerType() != 23) goto L34;
        r20 = r21;
    L34:
        if (r21.getOwnerType() != 28) goto L37;
        r19 = r21;
    L37:
        if (r21.getOwnerType() != 24) goto L40;
        r3 = r21;
    L40:
        if (r21.isOwner() == false) goto L29;
        r5 = r21;
        goto L29
    L42:
        if (r5 == null) goto L44;
        r2.remove(r5);
        ListProtector.add(r2, 0, r5);
    L44:
        if (r3 == null) goto L46;
        r2.remove(r3);
        ListProtector.add(r2, 0, r3);
    L46:
        if (r19 == null) goto L48;
        r2.remove(r19);
        ListProtector.add(r2, 0, r19);
    L48:
        if (r20 == null) goto L50;
        r2.remove(r20);
        ListProtector.add(r2, 0, r20);
    L50:
        r1.setUserInfoList(r2);
        return r1;
    L23:
        tt5.a.h("UserInfoV2Parser", "new mainObj exception");
        goto L24
    }
}
