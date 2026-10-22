package wh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.permission.doc.AuthReason;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPermissionAction;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermissionV2;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements NetService.c<DocUserPermissionV2> {

    public static final class a {
    }

    static {
    }

    public j() {
    }

    public final Result parse(String r55) {
    L152:
        e = move-exception;
        tt5.a.d("DocUserPermissionParserV2", "parse: " + e);
        return new DocUserPermissionV2(false, 0, null, null, null, null, 0, com.bytedance.ee.bear.middleground.permission.b.l(), 127, null);
    L4:
        if (r55 != null) goto L6;
        String r2 = "";
    L7:
        JSONObject r0 = new JSONObject(r2).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L152
        JSONObject r3 = null;
        if (r0 == null) goto L11;
        JSONObject r4 = r0.optJSONObject("actions");     // Catch: Exception -> L152
    L13:
        if (r4 == null) goto L15;
        int r8 = r4.optInt("view");     // Catch: Exception -> L152
    L16:
        if (r4 == null) goto L18;
        int r9 = r4.optInt("edit");     // Catch: Exception -> L152
    L19:
        if (r4 == null) goto L21;
        int r10 = r4.optInt("comment");     // Catch: Exception -> L152
    L22:
        if (r4 == null) goto L24;
        int r14 = r4.optInt("manage_collaborator");     // Catch: Exception -> L152
    L25:
        if (r4 == null) goto L27;
        int r15 = r4.optInt("manage_meta");     // Catch: Exception -> L152
    L28:
        if (r4 != null) goto L30;
        int r16 = 0;
    L33:
        if (r4 == null) goto L35;
        int r11 = r4.optInt("copy");     // Catch: Exception -> L152
    L36:
        if (r4 == null) goto L38;
        int r12 = r4.optInt("duplicate");     // Catch: Exception -> L152
    L39:
        if (r4 == null) goto L41;
        int r31 = r4.optInt("manage_history_record");     // Catch: Exception -> L152
    L42:
        if (r4 == null) goto L44;
        int r13 = r4.optInt("export");     // Catch: Exception -> L152
    L45:
        if (r4 == null) goto L47;
        int r17 = r4.optInt(OperationName.OPERATION_DOWNLOAD);     // Catch: Exception -> L152
    L48:
        if (r4 == null) goto L50;
        int r18 = r4.optInt("operate_from_dusbin");     // Catch: Exception -> L152
    L51:
        if (r4 == null) goto L53;
        int r19 = r4.optInt("operate_entity");     // Catch: Exception -> L152
    L54:
        if (r4 == null) goto L56;
        int r20 = r4.optInt("manage_single_page_collaborator");     // Catch: Exception -> L152
    L57:
        if (r4 == null) goto L59;
        int r21 = r4.optInt("manage_single_page_meta");     // Catch: Exception -> L152
    L60:
        if (r4 == null) goto L62;
        int r22 = r4.optInt("invite_full_access");     // Catch: Exception -> L152
    L63:
        if (r4 == null) goto L65;
        int r23 = r4.optInt("invite_can_edit");     // Catch: Exception -> L152
    L66:
        if (r4 == null) goto L68;
        int r24 = r4.optInt("invite_can_view");     // Catch: Exception -> L152
    L69:
        if (r4 == null) goto L71;
        int r25 = r4.optInt("invite_single_page_full_access");     // Catch: Exception -> L152
    L72:
        if (r4 == null) goto L74;
        int r26 = r4.optInt("invite_single_page_can_edit");     // Catch: Exception -> L152
    L75:
        if (r4 == null) goto L77;
        int r27 = r4.optInt("invite_single_page_can_view");     // Catch: Exception -> L152
    L78:
        if (r4 == null) goto L80;
        int r28 = r4.optInt("be_moved");     // Catch: Exception -> L152
    L81:
        if (r4 == null) goto L83;
        int r29 = r4.optInt("move_from");     // Catch: Exception -> L152
    L84:
        if (r4 == null) goto L86;
        int r30 = r4.optInt("move_to");     // Catch: Exception -> L152
    L87:
        if (r4 == null) goto L89;
        int r32 = r4.optInt("print");     // Catch: Exception -> L152
    L90:
        if (r4 == null) goto L92;
        int r33 = r4.optInt("collect");     // Catch: Exception -> L152
    L93:
        if (r4 == null) goto L95;
        int r34 = r4.optInt("apply_embed");     // Catch: Exception -> L152
    L96:
        if (r4 == null) goto L98;
        int r35 = r4.optInt("visit_secret_level");     // Catch: Exception -> L152
    L99:
        if (r4 == null) goto L101;
        int r36 = r4.optInt("modify_secret_level");     // Catch: Exception -> L152
    L102:
        if (r4 == null) goto L104;
        int r37 = r4.optInt("is_full_access");     // Catch: Exception -> L152
    L105:
        if (r4 == null) goto L107;
        int r38 = r4.optInt("is_single_page_full_access");     // Catch: Exception -> L152
    L108:
        if (r4 == null) goto L110;
        int r39 = r4.optInt("show_collaborator_info");     // Catch: Exception -> L152
    L111:
        if (r4 == null) goto L113;
        int r40 = r4.optInt("preview");     // Catch: Exception -> L152
    L114:
        if (r4 == null) goto L116;
        int r41 = r4.optInt("perceive");     // Catch: Exception -> L152
    L117:
        if (r4 == null) goto L119;
        int r42 = r4.optInt("manage_version");     // Catch: Exception -> L152
    L120:
        if (r4 == null) goto L122;
        int r43 = r4.optInt("share_external");     // Catch: Exception -> L152
    L123:
        if (r4 == null) goto L125;
        int r44 = r4.optInt("share_partner_tenant");     // Catch: Exception -> L152
    L126:
        DocPermissionAction r48 = new DocPermissionAction(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44);     // Catch: Exception -> L152
        if (r0 == null) goto L130;
        r3 = r0.optJSONObject("auth_reasons");     // Catch: Exception -> L152
    L130:
        if (r3 == null) goto L132;
        int r6 = r3.optInt("copy");     // Catch: Exception -> L152
    L133:
        if (r3 == null) goto L135;
        int r5 = r3.optInt("view");     // Catch: Exception -> L152
    L136:
        AuthReason r7 = new AuthReason(r6, r5);     // Catch: Exception -> L152
        if (r0 == null) goto L139;
        boolean r46 = r0.optBoolean("is_owner");     // Catch: Exception -> L152
    L140:
        if (r0 == null) goto L142;
        int r47 = r0.optInt("permission_status_code");     // Catch: Exception -> L152
    L144:
        if (r0 == null) goto L149;
        String r1 = r0.toString();     // Catch: Exception -> L152
        if (r1 == null) goto L149;
        String r51 = r1;
    L150:
        return new DocUserPermissionV2(r46, r47, r48, null, r7, r51, 0, com.bytedance.ee.bear.middleground.permission.b.l());
    L149:
        r51 = "";
        goto L150
    L142:
        r47 = 0;
        goto L144
    L139:
        r46 = false;
        goto L140
    L135:
        r5 = 0;
        goto L136
    L132:
        r6 = 0;
        goto L133
    L125:
        r44 = 0;
        goto L126
    L122:
        r43 = 0;
        goto L123
    L119:
        r42 = 0;
        goto L120
    L116:
        r41 = 0;
        goto L117
    L113:
        r40 = 0;
        goto L114
    L110:
        r39 = 0;
        goto L111
    L107:
        r38 = 0;
        goto L108
    L104:
        r37 = 0;
        goto L105
    L101:
        r36 = 0;
        goto L102
    L98:
        r35 = 0;
        goto L99
    L95:
        r34 = 0;
        goto L96
    L92:
        r33 = 0;
        goto L93
    L89:
        r32 = 0;
        goto L90
    L86:
        r30 = 0;
        goto L87
    L83:
        r29 = 0;
        goto L84
    L80:
        r28 = 0;
        goto L81
    L77:
        r27 = 0;
        goto L78
    L74:
        r26 = 0;
        goto L75
    L71:
        r25 = 0;
        goto L72
    L68:
        r24 = 0;
        goto L69
    L65:
        r23 = 0;
        goto L66
    L62:
        r22 = 0;
        goto L63
    L59:
        r21 = 0;
        goto L60
    L56:
        r20 = 0;
        goto L57
    L53:
        r19 = 0;
        goto L54
    L50:
        r18 = 0;
        goto L51
    L47:
        r17 = 0;
        goto L48
    L44:
        r13 = 0;
        goto L45
    L41:
        r31 = 0;
        goto L42
    L38:
        r12 = 0;
        goto L39
    L35:
        r11 = 0;
        goto L36
    L30:
        r16 = r4.optInt("create_sub_node");     // Catch: Exception -> L152
        goto L33
    L27:
        r15 = 0;
        goto L28
    L24:
        r14 = 0;
        goto L25
    L21:
        r10 = 0;
        goto L22
    L18:
        r9 = 0;
        goto L19
    L15:
        r8 = 0;
        goto L16
    L11:
        r4 = null;
        goto L13
    L6:
        r2 = r55;
        goto L7
    }
}
