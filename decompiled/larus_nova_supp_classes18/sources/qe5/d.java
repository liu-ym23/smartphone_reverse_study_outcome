package qe5;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.secret.ApprovalDialogCallbacks;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.google.gson.Gson;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class d extends XCoreBridgeMethod {
    public final String a;
    public int b;
    public int c;
    public String d;
    public String e;
    public SecretLevel f;
    public SecretLevel g;
    public SecretApprovalDefModel h;
    public boolean i;
    public boolean j;
    public boolean k;

    public static final class a {
    }

    static {
    }

    public d() {
        this.a = "ccm.permission.secLabelApproval";
        this.b = -1;
        this.c = -1;
        this.d = "";
        this.e = "";
    }

    public static boolean f() {
        jdb.g r0 = e(LarkContext.getApplication());
        if (r0 == null) goto L5;
        boolean r2 = r0.isEnable("ccm.permission.secret_level_searchable_tip");
    L6:
        if (r0 == null) goto L8;
        boolean r1 = r0.isEnable("ccm.permission.secret_level_tip_new");
    L9:
        if (r2 == false) goto L13;
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L8:
        r1 = false;
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    public String getName() {
        return this.a;
    }

    public static jdb.g e(Application r3) {
        if (r3 == null) goto L4;
        com.bytedance.ee.bear.appsetting.c.a.a.getClass();
        UserSession r1 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r3, com.ss.android.lark.passportc.convention.a.class)).b();
        return ((dn4.a) e0c.k.b(((v) e0c.k.a(r3, v.class)).c(r1), dn4.a.class)).a();
    L4:
        return null;
    }

    public void g(XReadableMap r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        this.b = r12.getInt("sceneType");
        String r0 = r12.getString("realToken");
        int r1 = r12.getInt("realType");
        if (r0.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        if (r1 < 0) goto L9;
        this.d = r0;
        this.c = r1;
    L10:
        this.f = h(r12.getMap("originalSecLabel"));
        this.g = h(r12.getMap("targetSecLabel"));
        com.bytedance.ies.xbridge.v r3 = r12.getArray("allSecLabels");
        SecretApprovalDefModel r4 = null;
        if (r3 == null) goto L43;
        int r5 = r3.size();
        int r6 = 0;
    L14:
        if (r6 >= r5) goto L43;
        XReadableMap r7 = r3.getMap(r6);
        if (r7 == null) goto L18;
        Integer r8 = Integer.valueOf(r7.getInt("level"));
    L19:
        SecretLevel r9 = this.f;
        if (r9 == null) goto L22;
        Integer r10 = Integer.valueOf(r9.getLevel());
    L24:
        if (Intrinsics.areEqual(r8, r10) == true) goto L25;
        r6 = r6 + 1;
        goto L14
    L25:
        if (r7 == null) goto L27;
        String r11 = s.f(r7, "apply_tips_v2", "");
    L28:
        if (r7 == null) goto L30;
        String r13 = s.f(r7, "apply_warn_tips", "");
    L31:
        SecretLevel r14 = this.f;
        if (r14 == null) goto L36;
        if (r11 != null) goto L35;
        r11 = "";
    L35:
        r14.setApplyTipsV2(r11);
    L36:
        SecretLevel r15 = this.f;
        if (r15 == null) goto L43;
        if (r13 != null) goto L40;
        r13 = "";
    L40:
        r15.setApplyWarnTips(r13);
        goto L43
    L30:
        r13 = null;
        goto L31
    L27:
        r11 = null;
        goto L28
    L22:
        r10 = null;
        goto L24
    L18:
        r8 = null;
    L43:
        if (f() == false) goto L45;
        this.j = s.b(r12, "secondConfirmation", false);
    L45:
        this.k = s.b(r12, "waitForApprovalResult", false);
        String r16 = r12.getString("secLabelApprovalDef");
        if (TextUtils.isEmpty(r16) == false) goto L62;
        tt5.a.h("ccm-lynx: CCMSecLabelApprovalMethod", "parseSecretApprovalDefModel()...defModelStr is null.");
    L60:
        this.h = r4;
        this.e = s.f(r12, WikiFolderPushPlugin.WIKI_TOKEN, "");
        this.i = s.b(r12, WikiFolderPushPlugin.WIKI_TOKEN, false);
        tt5.a.h("ccm-lynx: CCMSecLabelApprovalMethod", "parseArgs()...objType = " + this.c + ", token = " + du5.b.g(this.d) + ",sceneType = " + this.b + ", originSecLabel = " + this.f + ", targetSecLabel = " + this.g + ", secLabelApprovalDef = " + this.h + ", needReason = " + this.i + "， secondConfirmation = " + this.j + ", waitForApprovalResult = " + this.k);
        return;
    L62:
        SecretApprovalDefModel r17 = (SecretApprovalDefModel) new Gson().fromJson(r16, SecretApprovalDefModel.class);     // Catch: Exception -> L56
    L54:
        Exception e = e;
    L58:
        tt5.a.d("ccm-lynx: CCMSecLabelApprovalMethod", "parseSecretApprovalDefModel()...error = " + e);
    L59:
        r4 = r17;
        goto L60
    L50:
        if (this.j == false) goto L52;
        r17.setSuccess(false);     // Catch: Exception -> L54
    L64:
        goto L59
    L52:
        r17.setSuccess(true);     // Catch: Exception -> L54
    L56:
        e = move-exception;
        e = e;
        r17 = null;
    L9:
        this.d = r12.getString(ResourceData.KEY_TOKEN);
        this.c = r12.getInt(ResourceData.KEY_TYPE);
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public final SecretLevel h(XReadableMap r53) {
        Integer r1 = null;
        if (r53 != null) goto L6;
        tt5.a.h("ccm-lynx: CCMSecLabelApprovalMethod", "parseSecLabel()...params is null.");
        return null;
    L6:
        String r5 = s.f(r53, ResourceData.KEY_ID, "");
        String r6 = s.f(r53, "name", "");
        String r7 = s.f(r53, "description", "");
        int r8 = r53.getInt("level");
        boolean r9 = s.b(r53, "enable_protect", false);
        String r10 = s.f(r53, "tips", "");
        String r11 = s.f(r53, "apply_tips", "");
        if (f() == false) goto L9;
        String r2 = s.f(r53, "apply_tips_v2", "");
        String r16 = r2;
        String r15 = s.f(r53, "apply_warn_tips", "");
    L11:
        if (r53.hasKey("newSearchable") == false) goto L13;
        r1 = Integer.valueOf(s.d(r53, "newSearchable", 0));
    L13:
        Integer r21 = r1;
        String r17 = s.f(r53, "search_checkbox_desc", "");
        String r18 = s.f(r53, "apply_tips_not_searchable", "");
        int r3 = s.d(r53, "searchable", 0);
        int r4 = s.d(r53, "search_box_status", 0);
        XReadableMap r0 = r53.getMap("permission_control");
        if (r0 != null) goto L16;
        PermissionControl r12 = new PermissionControl(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, 4095, null);
    L54:
        return new SecretLevel(r5, r6, r7, r8, r9, r10, r11, r12, false, false, r15, r16, r17, r18, Integer.valueOf(r3), Integer.valueOf(r4), r21, 768, null);
    L16:
        if (r0.hasKey("share_entity") == false) goto L18;
        int r23 = r0.getInt("share_entity");
    L20:
        if (r0.hasKey("security_entity") == false) goto L22;
        int r24 = r0.getInt("security_entity");
    L24:
        if (r0.hasKey("comment_entity") == false) goto L26;
        int r25 = r0.getInt("comment_entity");
    L28:
        if (r0.hasKey("link_share_entity") == false) goto L30;
        int r26 = r0.getInt("link_share_entity");
    L31:
        boolean r27 = s.b(r0, "external_access_switch", false);
        if (r0.hasKey("share_external_entity") == false) goto L34;
        int r28 = r0.getInt("share_external_entity");
    L36:
        if (r0.hasKey("manage_collaborator_entity") == false) goto L38;
        int r29 = r0.getInt("manage_collaborator_entity");
    L39:
        boolean r30 = s.b(r0, "link_password_switch", false);
        if (r0.hasKey("external_access_entity") == false) goto L42;
        int r32 = s.d(r0, "external_access_entity", 0);
    L44:
        if (r0.hasKey("search_entity") == false) goto L46;
        int r33 = r0.getInt("share_entity");
    L48:
        if (r0.hasKey("disable_ai_search_entity") == false) goto L50;
        int r34 = r0.getInt("share_entity");
    L51:
        r12 = new PermissionControl(r23, r24, r25, r26, r27, r28, r29, r30, 0, r32, r33, r34, 256, null);
        goto L54
    L50:
        r34 = -1;
        goto L51
    L46:
        r33 = -1;
        goto L48
    L42:
        r32 = -1;
        goto L44
    L38:
        r29 = -1;
        goto L39
    L34:
        r28 = -1;
        goto L36
    L30:
        r26 = -1;
        goto L31
    L26:
        r25 = -1;
        goto L28
    L22:
        r24 = -1;
        goto L24
    L18:
        r23 = -1;
        goto L20
    L9:
        r15 = "";
        r16 = r15;
        goto L11
    }

    public void handle(XReadableMap r27, XBridgeMethod.Callback r28, XBridgePlatformType r29) {
        Intrinsics.checkNotNullParameter(r27, "params");
        Intrinsics.checkNotNullParameter(r28, "callback");
        Intrinsics.checkNotNullParameter(r29, ResourceData.KEY_TYPE);
        g(r27);
        if (this.f != null) goto L5;
    L131:
        tt5.a.h("ccm-lynx: CCMSecLabelApprovalMethod", "originSecLabel、 targetSecLabel or secLabelApprovalDef is null, return.");
        return;
    L5:
        if (this.g == null) goto L131;
        if (this.h == null) goto L131;
        if (com.bytedance.ee.bear.middleground.permission.b.m() == true) goto L12;
    L16:
        boolean r11 = false;
    L17:
        LinkedHashMap r1 = new LinkedHashMap();
        String r3 = r27.getString("update_permission_info");
        if (r3.length() <= 0) goto L20;
        boolean r4 = true;
    L21:
        String r12 = null;
        if (r4 == false) goto L24;
        String r5 = r3;
    L25:
        if (r5 == null) goto L27;
        r1.put("update_permission_info", r3);
        r1.put("update_permission_type", Integer.valueOf(r27.getInt("update_permission_type")));
        Serializable r0 = (Serializable) r1.put("is_need_edit", Boolean.valueOf(this.j));
    L27:
        if (r11 == false) goto L29;
        r1.put("wait_for_approval_result", Boolean.TRUE);
    L29:
        jdb.g r2 = e(LarkContext.getApplication());
        if (r2 == null) goto L32;
        boolean r6 = r2.isEnable("ccm.permission.l1_l2_access_expand_update_native");
    L33:
        if (r6 == true) goto L35;
    L39:
        if (r11 == false) goto L41;
    L40:
        r1.put("lynx_call_back", new ApprovalDialogCallbacks(r28, r11));
    L41:
        tt5.a.h("ccm-lynx: CCMSecLabelApprovalMethod", "handle, extra params: " + du5.b.h(r1.toString()));
        if ((!r1.isEmpty()) == false) goto L44;
        LinkedHashMap r24 = r1;
    L45:
        if (r11 == false) goto L47;
    L56:
        FragmentActivity r7 = (Context) provideContext(Context.class);
        Fragment r14 = (Fragment) provideContext(Fragment.class);
        cj5.c r13 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        if (r11 == false) goto L76;
        if (r14 != null) goto L60;
    L62:
        boolean r8 = false;
    L63:
        if (r8 == false) goto L76;
        String r15 = this.d;
        int r9 = this.c;
        SecretLevel r10 = this.g;
        if (r10 == null) goto L67;
        String r17 = r10.getId();
    L68:
        SecretLevel r16 = this.g;
        if (r16 == null) goto L71;
        r12 = r16.getName();
    L71:
        String r18 = r12;
        SecretLevel r19 = this.g;
        if (r19 == null) goto L74;
        int r110 = r19.getLevel();
    L75:
        r13.w4(r14, r15, r9, r17, r18, r110, this.e, this.f, this.h, r24, this.g);
        return;
    L74:
        r110 = -1;
        goto L75
    L67:
        r17 = null;
        goto L68
    L60:
        if (r14.isAdded() != true) goto L62;
        r8 = true;
    L76:
        if (r11 == true) goto L78;
    L91:
        if (r11 == false) goto L94;
        tt5.a.k("ccm-lynx: CCMSecLabelApprovalMethod", "handle()...wait for approval result but no available lynx host.");
        XCoreBridgeMethod.onSuccess$default(this, r28, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("actionID", DocFeed$Value$Result.FAIL)}), null, 4, null);
        return;
    L94:
        int r20 = th5.b.l;
        if (th5.b.a.a(this.b) == false) goto L117;
        jg5.j r21 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r111 = this.d;
        int r112 = this.c;
        SecretLevel r22 = this.g;
        if (r22 == null) goto L99;
        String r113 = r22.getId();
    L100:
        SecretLevel r23 = this.g;
        if (r23 == null) goto L103;
        String r114 = r23.getName();
    L104:
        SecretLevel r25 = this.g;
        if (r25 == null) goto L107;
        int r115 = r25.getLevel();
    L108:
        SecretLevel r26 = this.g;
        if (r26 == null) goto L111;
        r12 = r26.getApplyTips();
    L111:
        String r116 = r12;
        String r30 = this.e;
        SecretLevel r31 = this.f;
        SecretApprovalDefModel r32 = this.h;
        SecretLevel r33 = this.g;
        r21.getClass();
        WeakReference<th5.a> r34 = jg5.j.j;
        if (r34 != null) goto L114;
        return;
    L114:
        if (r34.get() == null) goto L136;
        jg5.j.j.get().sJ(r111, r112, r113, r114, r115, r116, r30, r31, r32, r24, r33);
        return;
    L136:
        return;
    L107:
        r115 = -1;
        goto L108
    L103:
        r114 = null;
        goto L104
    L99:
        r113 = null;
        goto L100
    L117:
        if ((r7 instanceof FragmentActivity) == false) goto L138;
        FragmentActivity r117 = r7;
        String r118 = this.d;
        int r35 = this.c;
        SecretLevel r36 = this.g;
        if (r36 == null) goto L121;
        String r119 = r36.getId();
    L122:
        SecretLevel r37 = this.g;
        if (r37 == null) goto L125;
        r12 = r37.getName();
    L125:
        String r120 = r12;
        SecretLevel r38 = this.g;
        if (r38 == null) goto L128;
        int r121 = r38.getLevel();
    L129:
        r13.ad(r117, r118, r35, r119, r120, r121, "", this.e, this.f, this.h, r24, this.g);
        return;
    L128:
        r121 = -1;
        goto L129
    L121:
        r119 = null;
        goto L122
    L138:
        return;
    L78:
        if ((r7 instanceof FragmentActivity) == false) goto L91;
        FragmentActivity r122 = r7;
        String r123 = this.d;
        int r39 = this.c;
        SecretLevel r40 = this.g;
        if (r40 == null) goto L82;
        String r124 = r40.getId();
    L83:
        SecretLevel r41 = this.g;
        if (r41 == null) goto L86;
        r12 = r41.getName();
    L86:
        String r125 = r12;
        SecretLevel r42 = this.g;
        if (r42 == null) goto L89;
        int r126 = r42.getLevel();
    L90:
        r13.ad(r122, r123, r39, r124, r125, r126, "", this.e, this.f, this.h, r24, this.g);
        return;
    L89:
        r126 = -1;
        goto L90
    L82:
        r124 = null;
        goto L83
    L47:
        if (this.j == true) goto L49;
    L55:
        XCoreBridgeMethod.onSuccess$default(this, r28, new LinkedHashMap(), null, 4, null);
        goto L56
    L49:
        if (f() == false) goto L55;
        jdb.g r43 = e(LarkContext.getApplication());
        if (r43 == null) goto L53;
        boolean r44 = r43.isEnable("ccm.permission.l1_l2_access_expand_update_native");
    L54:
        if (r44 == true) goto L56;
    L53:
        r44 = false;
        goto L54
    L44:
        r24 = null;
        goto L45
    L35:
        if (r3.length() <= 0) goto L37;
        boolean r45 = true;
    L38:
        if (r45 == true) goto L40;
    L37:
        r45 = false;
        goto L38
    L32:
        r6 = false;
        goto L33
    L24:
        r5 = null;
        goto L25
    L20:
        r4 = false;
        goto L21
    L12:
        if (this.k == false) goto L16;
        if (this.b != SceneType.PASSWORD_SHARE.getValue()) goto L16;
        r11 = true;
        goto L17
    }
}
