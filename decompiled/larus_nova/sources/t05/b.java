package t05;

import com.bytedance.ee.bear.DocFreshInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements NetService.c<DocMetaInfo> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static DocFreshInfo b(JSONObject r110) {
        JSONObject r100 = r110.optJSONObject("fresh_info");
        if (r100 != null) goto L7;
        return new DocFreshInfo(0, 0, null, 0, 0, 0, 63, null);
    L7:
        return new DocFreshInfo(r100.optInt("fresh_status"), r100.optInt("update_time"), r100.optString("operator_id"), r100.optLong("deadline_time"), r100.optInt("feed_back_num"), r100.optInt("may_expire_show_num"));
    }

    public static SecretLevel c(JSONObject r510) {
        JSONObject r100 = r510.optJSONObject("sec_label");
        if (r100 == null) goto L5;
        JSONObject r101 = r100.optJSONObject("permission_control");
        if (r101 != null) goto L9;
        PermissionControl r410 = new PermissionControl(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, UnixStat.PERM_MASK, null);
    L10:
        String r310 = r100.optString("id");
        boolean r311 = r100.optBoolean("enable_protect");
        return new SecretLevel(r310, r100.optString("name"), r100.optString("description"), r100.optInt("level"), r311, r100.optString("tips"), r100.optString("apply_tips"), r410, false, false, r100.optString("apply_warn_tips"), r100.optString("apply_tips_v2"), null, null, null, null, null, 127744, null);
    L9:
        r410 = new PermissionControl(r101.optInt("share_entity", -1), r101.optInt("security_entity", -1), r101.optInt("comment_entity", -1), r101.optInt("link_share_entity", -1), r101.optBoolean("external_access_switch"), r101.optInt("share_external_entity", -1), r101.optInt("manage_collaborator_entity", -1), r101.optBoolean("link_password_switch"), 0, 0, r101.optInt("search_entity", -1), r101.optInt("disable_ai_search_entity", -1), ISmModel.VERSION_0300, null);
        goto L10
    L5:
        return new SecretLevel(null, null, null, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 131071, null);
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r510) {
        JSONObject r100 = new JSONObject(r510).optJSONObject("data");     // Catch: Exception -> L64
        String r101 = r100.optString("create_uid");     // Catch: Exception -> L64
        String r102 = r100.optString("owner_id");     // Catch: Exception -> L64
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L64
        boolean r103 = true;
        if (r101.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        String r105 = "";
        if (r104 == false) goto L17;
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L64
        if (r102.length() != 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L16;
        String r110 = "";
    L18:
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L64
        if (r102.length() != 0) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L30;
        Intrinsics.checkNotNull(r110);     // Catch: Exception -> L64
        if (r110.length() == 0) goto L27;
        r103 = false;
    L27:
        if (r103 == false) goto L29;
        String r111 = "";
    L31:
        int r108 = r100.optInt("real_sub_type");     // Catch: Exception -> L64
        if (r108 != 0) goto L35;
        r108 = r100.optInt("sub_type");     // Catch: Exception -> L64
    L35:
        int r210 = r108;
        String r112 = r100.optString("title");     // Catch: Exception -> L64
        boolean r113 = r100.optBoolean("title_secure_key_deleted");     // Catch: Exception -> L64
        Intrinsics.checkNotNull(r110);     // Catch: Exception -> L64
        String r114 = a(r100.optString("create_user_name"), r100.optJSONObject("create_user_display_name"));     // Catch: Exception -> L64
        String r115 = r100.optString("tenant_id");     // Catch: Exception -> L64
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L64
        String r116 = a(r100.optString("owner_user_name"), r100.optJSONObject("owner_user_display_name"));     // Catch: Exception -> L64
        String r117 = r100.optString("create_time");     // Catch: Exception -> L64
        String r118 = r100.optString("sub_type");     // Catch: Exception -> L64
        boolean r119 = r100.optBoolean("is_pined");     // Catch: Exception -> L64
        boolean r211 = r100.optBoolean("is_stared");     // Catch: Exception -> L64
        String r212 = r100.optString("app_id");     // Catch: Exception -> L64
        String r213 = r100.optString("app_link");     // Catch: Exception -> L64
        boolean r214 = r100.optBoolean("support_mobile");     // Catch: Exception -> L64
        String r215 = r100.optString("icon");     // Catch: Exception -> L64
        int r216 = r100.optInt("type");     // Catch: Exception -> L64
        DocMetaInfo.Companion.getClass();     // Catch: Exception -> L64
        int r217 = r100.optInt("get_sec_label_code", 3);     // Catch: Exception -> L64
        int r218 = r100.optInt("can_set_sec_label", 0);     // Catch: Exception -> L64
        Intrinsics.checkNotNull(r100);     // Catch: Exception -> L64
        SecretLevel r219 = c(r100);     // Catch: Exception -> L64
        int r310 = r100.optInt("template_type");     // Catch: Exception -> L64
        int r311 = r100.optInt("sec_label_type", DocMetaInfo.DEFAULT_SEC_TYPE);     // Catch: Exception -> L64
        boolean r312 = r100.optBoolean("is_external");     // Catch: Exception -> L64
        boolean r313 = r100.optBoolean("double_check_default_label");     // Catch: Exception -> L64
        boolean r314 = r100.optBoolean("must_set_label");     // Catch: Exception -> L64
        String r315 = r100.optString("default_label_id");     // Catch: Exception -> L64
        String r316 = r100.optString("server_time");     // Catch: Exception -> L64
        int r317 = r100.optInt("version", 0);     // Catch: Exception -> L64
        String r318 = r100.optString("edit_time");     // Catch: Exception -> L64
        String r319 = r100.optString("obj_id", "");     // Catch: Exception -> L64
        int r410 = r100.optInt("sec_label_banner_status", 0);     // Catch: Exception -> L64
        String r411 = r100.optString("recommend_label_id", "");     // Catch: Exception -> L64
        int r412 = r100.optInt("sec_label_banner_type", 0);     // Catch: Exception -> L64
        DocFreshInfo r413 = b(r100);     // Catch: Exception -> L64
        String r414 = r100.optString("icon_info", "");     // Catch: Exception -> L64
        JSONObject r109 = r100.optJSONObject("extra_fields");     // Catch: Exception -> L64
        if (r109 == null) goto L40;
        JSONObject r120 = r109.optJSONObject("owner_tenant_name");     // Catch: Exception -> L64
        if (r120 == null) goto L40;
        String r415 = a("", r120);     // Catch: Exception -> L64
    L69:
        JSONObject r121 = r100.optJSONObject("extra_fields");     // Catch: Exception -> L51
        if (r121 == null) goto L53;
        JSONObject r122 = r121.optJSONObject("upgrade_info");     // Catch: Exception -> L51
        if (r122 == null) goto L53;
        DocUpgradeInfo r416 = new DocUpgradeInfo(r122.optInt("status"), r122.optString("relate_token"), r122.optString("relate_url"));     // Catch: Exception -> L51
    L54:
        Long r123 = StringsKt.toLongOrNull(r100.optString("note_id", "0"));     // Catch: Exception -> L64
        if (r123 == null) goto L57;
        long r124 = r123.longValue();     // Catch: Exception -> L64
    L58:
        DocMetaInfo r125 = new DocMetaInfo(r112, r113, r110, r114, r115, r111, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r210, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r124);     // Catch: Exception -> L64
        r125.setCreateSource(r100.optInt("create_source", 0));     // Catch: Exception -> L64
        String r126 = r100.optString("url");     // Catch: Exception -> L64
        if (r126 == null) goto L62;
        r105 = r126;
    L62:
        r125.setUrl(r105);     // Catch: Exception -> L64
        return r125;
    L57:
        r124 = 0;
        goto L58
    L53:
        r416 = null;
    L51:
        e = move-exception;
        tt5.a.f("DocMetaInfoParser", e, false);     // Catch: Exception -> L64
    L40:
        r415 = "";
        goto L69
    L29:
        r111 = r110;
        goto L31
    L30:
        r111 = r102;
        goto L31
    L21:
        r107 = false;
        goto L22
    L16:
        r110 = r102;
        goto L18
    L13:
        r106 = false;
        goto L14
    L17:
        r110 = r101;
        goto L18
    L7:
        r104 = false;
    L64:
        e = move-exception;
        tt5.a.d("DocMetaInfoParser", "parse: " + e);
        return new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    }

    public static String a(String r100, JSONObject r101) {
        return ou5.a.a(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), DisplayName.parseDisplayName(r101), r100, r100);
    }
}
