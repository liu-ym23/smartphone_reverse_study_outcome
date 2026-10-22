package t05;

import com.bytedance.ee.bear.DocFreshInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements NetService.c<DocMetaInfo> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static DocFreshInfo b(JSONObject r19) {
        JSONObject r0 = r19.optJSONObject("fresh_info");
        if (r0 != null) goto L7;
        return new DocFreshInfo(0, 0, null, 0, 0, 0, 63, null);
    L7:
        return new DocFreshInfo(r0.optInt("fresh_status"), r0.optInt("update_time"), r0.optString("operator_id"), r0.optLong("deadline_time"), r0.optInt("feed_back_num"), r0.optInt("may_expire_show_num"));
    }

    public static SecretLevel c(JSONObject r52) {
        JSONObject r0 = r52.optJSONObject("sec_label");
        if (r0 == null) goto L5;
        JSONObject r1 = r0.optJSONObject("permission_control");
        if (r1 != null) goto L9;
        PermissionControl r40 = new PermissionControl(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, 4095, null);
    L10:
        String r33 = r0.optString("id");
        boolean r37 = r0.optBoolean("enable_protect");
        return new SecretLevel(r33, r0.optString("name"), r0.optString("description"), r0.optInt("level"), r37, r0.optString("tips"), r0.optString("apply_tips"), r40, false, false, r0.optString("apply_warn_tips"), r0.optString("apply_tips_v2"), null, null, null, null, null, 127744, null);
    L9:
        r40 = new PermissionControl(r1.optInt("share_entity", -1), r1.optInt("security_entity", -1), r1.optInt("comment_entity", -1), r1.optInt("link_share_entity", -1), r1.optBoolean("external_access_switch"), r1.optInt("share_external_entity", -1), r1.optInt("manage_collaborator_entity", -1), r1.optBoolean("link_password_switch"), 0, 0, r1.optInt("search_entity", -1), r1.optInt("disable_ai_search_entity", -1), 768, null);
        goto L10
    L5:
        return new SecretLevel(null, null, null, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 131071, null);
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r50) {
        JSONObject r2 = new JSONObject(r50).optJSONObject("data");     // Catch: Exception -> L64
        String r3 = r2.optString("create_uid");     // Catch: Exception -> L64
        String r4 = r2.optString("owner_id");     // Catch: Exception -> L64
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L64
        boolean r6 = true;
        if (r3.length() != 0) goto L7;
        boolean r5 = true;
    L8:
        String r8 = "";
        if (r5 == false) goto L17;
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L64
        if (r4.length() != 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        String r12 = "";
    L18:
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L64
        if (r4.length() != 0) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L30;
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L64
        if (r12.length() == 0) goto L27;
        r6 = false;
    L27:
        if (r6 == false) goto L29;
        String r16 = "";
    L31:
        int r10 = r2.optInt("real_sub_type");     // Catch: Exception -> L64
        if (r10 != 0) goto L35;
        r10 = r2.optInt("sub_type");     // Catch: Exception -> L64
    L35:
        int r26 = r10;
        String r11 = r2.optString("title");     // Catch: Exception -> L64
        boolean r13 = r2.optBoolean("title_secure_key_deleted");     // Catch: Exception -> L64
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L64
        String r14 = a(r2.optString("create_user_name"), r2.optJSONObject("create_user_display_name"));     // Catch: Exception -> L64
        String r17 = r2.optString("tenant_id");     // Catch: Exception -> L64
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L64
        String r18 = a(r2.optString("owner_user_name"), r2.optJSONObject("owner_user_display_name"));     // Catch: Exception -> L64
        String r19 = r2.optString("create_time");     // Catch: Exception -> L64
        String r110 = r2.optString("sub_type");     // Catch: Exception -> L64
        boolean r111 = r2.optBoolean("is_pined");     // Catch: Exception -> L64
        boolean r20 = r2.optBoolean("is_stared");     // Catch: Exception -> L64
        String r21 = r2.optString("app_id");     // Catch: Exception -> L64
        String r22 = r2.optString("app_link");     // Catch: Exception -> L64
        boolean r23 = r2.optBoolean("support_mobile");     // Catch: Exception -> L64
        String r24 = r2.optString(CustomHeaderConfig.Menu.Style.ICON_STYLE);     // Catch: Exception -> L64
        int r27 = r2.optInt("type");     // Catch: Exception -> L64
        DocMetaInfo.Companion.getClass();     // Catch: Exception -> L64
        int r28 = r2.optInt("get_sec_label_code", 3);     // Catch: Exception -> L64
        int r29 = r2.optInt("can_set_sec_label", 0);     // Catch: Exception -> L64
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L64
        SecretLevel r210 = c(r2);     // Catch: Exception -> L64
        int r30 = r2.optInt("template_type");     // Catch: Exception -> L64
        int r31 = r2.optInt("sec_label_type", -99999);     // Catch: Exception -> L64
        boolean r32 = r2.optBoolean("is_external");     // Catch: Exception -> L64
        boolean r33 = r2.optBoolean("double_check_default_label");     // Catch: Exception -> L64
        boolean r34 = r2.optBoolean("must_set_label");     // Catch: Exception -> L64
        String r36 = r2.optString("default_label_id");     // Catch: Exception -> L64
        String r37 = r2.optString("server_time");     // Catch: Exception -> L64
        int r38 = r2.optInt("version", 0);     // Catch: Exception -> L64
        String r39 = r2.optString("edit_time");     // Catch: Exception -> L64
        String r310 = r2.optString("obj_id", "");     // Catch: Exception -> L64
        int r40 = r2.optInt("sec_label_banner_status", 0);     // Catch: Exception -> L64
        String r41 = r2.optString("recommend_label_id", "");     // Catch: Exception -> L64
        int r42 = r2.optInt("sec_label_banner_type", 0);     // Catch: Exception -> L64
        DocFreshInfo r43 = b(r2);     // Catch: Exception -> L64
        String r44 = r2.optString("icon_info", "");     // Catch: Exception -> L64
        JSONObject r46 = r2.optJSONObject("extra_fields");     // Catch: Exception -> L64
        if (r46 == null) goto L40;
        JSONObject r47 = r46.optJSONObject("owner_tenant_name");     // Catch: Exception -> L64
        if (r47 == null) goto L40;
        String r48 = a("", r47);     // Catch: Exception -> L64
    L69:
        JSONObject r0 = r2.optJSONObject("extra_fields");     // Catch: Exception -> L51
        if (r0 == null) goto L53;
        JSONObject r1 = r0.optJSONObject("upgrade_info");     // Catch: Exception -> L51
        if (r1 == null) goto L53;
        DocUpgradeInfo r49 = new DocUpgradeInfo(r1.optInt("status"), r1.optString("relate_token"), r1.optString("relate_url"));     // Catch: Exception -> L51
    L54:
        Long r51 = StringsKt.toLongOrNull(r2.optString("note_id", DiagramData$RESULT.FAIL));     // Catch: Exception -> L64
        if (r51 == null) goto L57;
        long r52 = r51.longValue();     // Catch: Exception -> L64
    L58:
        DocMetaInfo r53 = new DocMetaInfo(r11, r13, r12, r14, r17, r16, r18, r19, r110, r111, r20, r21, r22, r23, r24, r27, r26, r28, r29, r210, r30, r31, r32, r33, r34, r36, r37, r38, r39, r310, r40, r41, r42, r43, r44, r48, r49, r52);     // Catch: Exception -> L64
        r53.setCreateSource(r2.optInt("create_source", 0));     // Catch: Exception -> L64
        String r54 = r2.optString("url");     // Catch: Exception -> L64
        if (r54 == null) goto L62;
        r8 = r54;
    L62:
        r53.setUrl(r8);     // Catch: Exception -> L64
        return r53;
    L57:
        r52 = 0;
        goto L58
    L53:
        r49 = null;
    L51:
        e = move-exception;
        tt5.a.f("DocMetaInfoParser", e, false);     // Catch: Exception -> L64
    L40:
        r48 = "";
        goto L69
    L29:
        r16 = r12;
        goto L31
    L30:
        r16 = r4;
        goto L31
    L21:
        r9 = false;
        goto L22
    L16:
        r12 = r4;
        goto L18
    L13:
        r7 = false;
        goto L14
    L17:
        r12 = r3;
        goto L18
    L7:
        r5 = false;
    L64:
        e = move-exception;
        tt5.a.d("DocMetaInfoParser", "parse: " + e);
        return new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
    }

    public static String a(String r3, JSONObject r4) {
        return ou5.a.a(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), DisplayName.parseDisplayName(r4), r3, r3);
    }
}
