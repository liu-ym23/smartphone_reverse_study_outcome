package wh5;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.AuthReason;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPermissionAction;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermissionV2;
import com.larus.bmhome.share.panel.ShareChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements NetService.c<DocUserPermissionV2> {

    public static final class a {
    }

    static {
    }

    public j() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r510) {
    L152:
        e = move-exception;
        tt5.a.d("DocUserPermissionParserV2", "parse: " + e);
        return new DocUserPermissionV2(false, 0, null, null, null, null, 0, com.bytedance.ee.bear.middleground.permission.b.l(), 127, null);
    L4:
        if (r510 != null) goto L6;
        String r100 = "";
    L7:
        JSONObject r101 = new JSONObject(r100).optJSONObject("data");     // Catch: Exception -> L152
        JSONObject r102 = null;
        if (r101 == null) goto L11;
        JSONObject r103 = r101.optJSONObject(SlcCommonAction.KEY_ACTIONS);     // Catch: Exception -> L152
    L13:
        if (r103 == null) goto L15;
        int r104 = r103.optInt("view");     // Catch: Exception -> L152
    L16:
        if (r103 == null) goto L18;
        int r105 = r103.optInt("edit");     // Catch: Exception -> L152
    L19:
        if (r103 == null) goto L21;
        int r110 = r103.optInt("comment");     // Catch: Exception -> L152
    L22:
        if (r103 == null) goto L24;
        int r111 = r103.optInt("manage_collaborator");     // Catch: Exception -> L152
    L25:
        if (r103 == null) goto L27;
        int r112 = r103.optInt("manage_meta");     // Catch: Exception -> L152
    L28:
        if (r103 != null) goto L30;
        int r113 = 0;
    L33:
        if (r103 == null) goto L35;
        int r114 = r103.optInt("copy");     // Catch: Exception -> L152
    L36:
        if (r103 == null) goto L38;
        int r115 = r103.optInt("duplicate");     // Catch: Exception -> L152
    L39:
        if (r103 == null) goto L41;
        int r310 = r103.optInt("manage_history_record");     // Catch: Exception -> L152
    L42:
        if (r103 == null) goto L44;
        int r116 = r103.optInt("export");     // Catch: Exception -> L152
    L45:
        if (r103 == null) goto L47;
        int r117 = r103.optInt("download");     // Catch: Exception -> L152
    L48:
        if (r103 == null) goto L50;
        int r118 = r103.optInt("operate_from_dusbin");     // Catch: Exception -> L152
    L51:
        if (r103 == null) goto L53;
        int r119 = r103.optInt("operate_entity");     // Catch: Exception -> L152
    L54:
        if (r103 == null) goto L56;
        int r210 = r103.optInt("manage_single_page_collaborator");     // Catch: Exception -> L152
    L57:
        if (r103 == null) goto L59;
        int r211 = r103.optInt("manage_single_page_meta");     // Catch: Exception -> L152
    L60:
        if (r103 == null) goto L62;
        int r212 = r103.optInt("invite_full_access");     // Catch: Exception -> L152
    L63:
        if (r103 == null) goto L65;
        int r213 = r103.optInt("invite_can_edit");     // Catch: Exception -> L152
    L66:
        if (r103 == null) goto L68;
        int r214 = r103.optInt("invite_can_view");     // Catch: Exception -> L152
    L69:
        if (r103 == null) goto L71;
        int r215 = r103.optInt("invite_single_page_full_access");     // Catch: Exception -> L152
    L72:
        if (r103 == null) goto L74;
        int r216 = r103.optInt("invite_single_page_can_edit");     // Catch: Exception -> L152
    L75:
        if (r103 == null) goto L77;
        int r217 = r103.optInt("invite_single_page_can_view");     // Catch: Exception -> L152
    L78:
        if (r103 == null) goto L80;
        int r218 = r103.optInt("be_moved");     // Catch: Exception -> L152
    L81:
        if (r103 == null) goto L83;
        int r219 = r103.optInt("move_from");     // Catch: Exception -> L152
    L84:
        if (r103 == null) goto L86;
        int r311 = r103.optInt("move_to");     // Catch: Exception -> L152
    L87:
        if (r103 == null) goto L89;
        int r312 = r103.optInt("print");     // Catch: Exception -> L152
    L90:
        if (r103 == null) goto L92;
        int r313 = r103.optInt(ShareChannel.COLLECT);     // Catch: Exception -> L152
    L93:
        if (r103 == null) goto L95;
        int r314 = r103.optInt("apply_embed");     // Catch: Exception -> L152
    L96:
        if (r103 == null) goto L98;
        int r315 = r103.optInt("visit_secret_level");     // Catch: Exception -> L152
    L99:
        if (r103 == null) goto L101;
        int r316 = r103.optInt("modify_secret_level");     // Catch: Exception -> L152
    L102:
        if (r103 == null) goto L104;
        int r317 = r103.optInt("is_full_access");     // Catch: Exception -> L152
    L105:
        if (r103 == null) goto L107;
        int r318 = r103.optInt("is_single_page_full_access");     // Catch: Exception -> L152
    L108:
        if (r103 == null) goto L110;
        int r319 = r103.optInt("show_collaborator_info");     // Catch: Exception -> L152
    L111:
        if (r103 == null) goto L113;
        int r410 = r103.optInt("preview");     // Catch: Exception -> L152
    L114:
        if (r103 == null) goto L116;
        int r411 = r103.optInt("perceive");     // Catch: Exception -> L152
    L117:
        if (r103 == null) goto L119;
        int r412 = r103.optInt("manage_version");     // Catch: Exception -> L152
    L120:
        if (r103 == null) goto L122;
        int r413 = r103.optInt("share_external");     // Catch: Exception -> L152
    L123:
        if (r103 == null) goto L125;
        int r414 = r103.optInt("share_partner_tenant");     // Catch: Exception -> L152
    L126:
        DocPermissionAction r415 = new DocPermissionAction(r104, r105, r110, r114, r115, r116, r111, r112, r113, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r311, r310, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);     // Catch: Exception -> L152
        if (r101 == null) goto L130;
        r102 = r101.optJSONObject("auth_reasons");     // Catch: Exception -> L152
    L130:
        if (r102 == null) goto L132;
        int r106 = r102.optInt("copy");     // Catch: Exception -> L152
    L133:
        if (r102 == null) goto L135;
        int r107 = r102.optInt("view");     // Catch: Exception -> L152
    L136:
        AuthReason r108 = new AuthReason(r106, r107);     // Catch: Exception -> L152
        if (r101 == null) goto L139;
        boolean r416 = r101.optBoolean("is_owner");     // Catch: Exception -> L152
    L140:
        if (r101 == null) goto L142;
        int r417 = r101.optInt("permission_status_code");     // Catch: Exception -> L152
    L144:
        if (r101 == null) goto L149;
        String r109 = r101.toString();     // Catch: Exception -> L152
        if (r109 == null) goto L149;
        String r511 = r109;
    L150:
        return new DocUserPermissionV2(r416, r417, r415, null, r108, r511, 0, com.bytedance.ee.bear.middleground.permission.b.l());
    L149:
        r511 = "";
        goto L150
    L142:
        r417 = 0;
        goto L144
    L139:
        r416 = false;
        goto L140
    L135:
        r107 = 0;
        goto L136
    L132:
        r106 = 0;
        goto L133
    L125:
        r414 = 0;
        goto L126
    L122:
        r413 = 0;
        goto L123
    L119:
        r412 = 0;
        goto L120
    L116:
        r411 = 0;
        goto L117
    L113:
        r410 = 0;
        goto L114
    L110:
        r319 = 0;
        goto L111
    L107:
        r318 = 0;
        goto L108
    L104:
        r317 = 0;
        goto L105
    L101:
        r316 = 0;
        goto L102
    L98:
        r315 = 0;
        goto L99
    L95:
        r314 = 0;
        goto L96
    L92:
        r313 = 0;
        goto L93
    L89:
        r312 = 0;
        goto L90
    L86:
        r311 = 0;
        goto L87
    L83:
        r219 = 0;
        goto L84
    L80:
        r218 = 0;
        goto L81
    L77:
        r217 = 0;
        goto L78
    L74:
        r216 = 0;
        goto L75
    L71:
        r215 = 0;
        goto L72
    L68:
        r214 = 0;
        goto L69
    L65:
        r213 = 0;
        goto L66
    L62:
        r212 = 0;
        goto L63
    L59:
        r211 = 0;
        goto L60
    L56:
        r210 = 0;
        goto L57
    L53:
        r119 = 0;
        goto L54
    L50:
        r118 = 0;
        goto L51
    L47:
        r117 = 0;
        goto L48
    L44:
        r116 = 0;
        goto L45
    L41:
        r310 = 0;
        goto L42
    L38:
        r115 = 0;
        goto L39
    L35:
        r114 = 0;
        goto L36
    L30:
        r113 = r103.optInt("create_sub_node");     // Catch: Exception -> L152
        goto L33
    L27:
        r112 = 0;
        goto L28
    L24:
        r111 = 0;
        goto L25
    L21:
        r110 = 0;
        goto L22
    L18:
        r105 = 0;
        goto L19
    L15:
        r104 = 0;
        goto L16
    L11:
        r103 = null;
        goto L13
    L6:
        r100 = r510;
        goto L7
    }
}
