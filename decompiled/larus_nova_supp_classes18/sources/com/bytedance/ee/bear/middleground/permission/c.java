package com.bytedance.ee.bear.middleground.permission;

import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionReportInfo;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static String a;
    public static String b;
    public static boolean c;
    public static String d;
    public static String e;
    public static String f;
    public static int g;
    public static String h;
    public static boolean i;

    static {
        a = "";
        b = "";
        d = "none";
        e = "none";
        f = "";
        h = "";
    }

    @JvmStatic
    public static final void S() {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r3 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r3, h, d, e, a, b, i);
        r10.put("click", "back");
        r10.put("target", "none");
        c("ccm_permission_select_contact_click", r10);
        return;
    L5:
        r3 = "none";
        goto L6
    }

    @JvmStatic
    public static final void Z() {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);
        c("ccm_permission_lock_restore_view", r10);
        return;
    L5:
        r0 = "none";
        goto L6
    }

    @JvmStatic
    public static final void m() {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r3 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r3, h, d, e, a, b, i);
        r10.put("click", "all_cancel");
        r10.put("target", "none");
        c("ccm_permission_cited_doc_authorize_click", r10);
        return;
    L5:
        r3 = "none";
        goto L6
    }

    public static void v() {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);
        c("ccm_permission_no_collaborator_profile_list_view", r10);
        return;
    L5:
        r0 = "none";
        goto L6
    }

    @JvmStatic
    public static final void E(PermissionReportInfo r11) {
        Intrinsics.checkNotNullParameter(r11, "reportInfo");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r1, h, d, e, a, b, i);
        b(r11, r0);
        c("ccm_permission_performance_permission_sdk_check_dev", r0);
        return;
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void F(PermissionReportInfo r11) {
        Intrinsics.checkNotNullParameter(r11, "reportInfo");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r1, h, d, e, a, b, i);
        b(r11, r0);
        c("ccm_permission_performance_permission_sdk_click_dev", r0);
        return;
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void H(boolean r11) {
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L8
        String r1 = f;     // Catch: Exception -> L8
        int r2 = g;     // Catch: Exception -> L8
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);     // Catch: Exception -> L8
        r10.put("is_compulsory_labeling", String.valueOf(r11));     // Catch: Exception -> L8
        c("scs_file_recommended_label_banner_view", r10);     // Catch: Exception -> L8
        return;
    L5:
        r0 = "none";
    L8:
        e = move-exception;
        tt5.a.e("PermissionAnalyticV2", "doReport()...failed", e, false);
    }

    @JvmStatic
    public static final void K(String r13) {
        Intrinsics.checkNotNullParameter(r13, "click");
        JSONObject r11 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r11, r2, r3, r4, h, d, e, a, b, i);
        r11.put("click", r13);
        r11.put("target", "none");
        c("ccm_permission_security_demotion_result_click", r11);
        return;
    L5:
        r4 = "none";
        goto L6
    }

    @JvmStatic
    public static final void L(boolean r11) {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);
        r10.put("if_success", r11);
        c("ccm_permission_security_demotion_result_view", r10);
        return;
    L5:
        r0 = "none";
        goto L6
    }

    @JvmStatic
    public static final void O(boolean r11) {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);
        if (r11 == false) goto L9;
        String r12 = "have_default_no_setting";
    L10:
        r10.put("triggle_reason", r12);
        c("ccm_permission_security_docs_banner_view", r10);
        return;
    L9:
        r12 = "no_default_no_setting";
        goto L10
    L5:
        r0 = "none";
        goto L6
    }

    @JvmStatic
    public static final void Q(String r15) {
        Intrinsics.checkNotNullParameter("click_security_level", "click");
        Intrinsics.checkNotNullParameter("none", "target");
        Intrinsics.checkNotNullParameter(r15, "isOriginLevel");
        JSONObject r4 = new JSONObject();
        String r6 = f;
        int r7 = g;
        if (c == false) goto L5;
        String r8 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r4, r6, r7, r8, h, d, e, a, b, i);
        r4.put("click", "click_security_level");
        r4.put("target", "none");
        r4.put("is_original_level", r15);
        c("ccm_permission_security_setting_click", r4);
        return;
    L5:
        r8 = "none";
        goto L6
    }

    @JvmStatic
    public static final void U(ArrayList<UserInfo> r11) {
        Intrinsics.checkNotNullParameter(r11, "userInfoList");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r1, h, d, e, a, b, i);
        JSONArray r4 = new JSONArray();
        Iterator<UserInfo> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        UserInfo r5 = r12.next();
        JSONObject r6 = new JSONObject();
        r6.put("collaborate_type", r5.getOwnerType());
        r6.put("object_uid", du5.b.g(r5.getId()));
        r6.put("list_type", d(g, r5.getPermission()));
        r4.put(r6);
        goto L8
    L10:
        r0.put("user_list", r4.toString());
        c("ccm_permission_select_contact_view", r0);
        return;
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void Y(boolean r12) {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r3 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r3, h, d, e, a, b, i);
        if (r12 == false) goto L9;
        String r13 = "confirm";
    L10:
        r10.put("click", r13);
        r10.put("target", "none");
        c("ccm_permission_lock_restore_click", r10);
        return;
    L9:
        r13 = DocFeed$Value$Result.CANCEL;
        goto L10
    L5:
        r3 = "none";
        goto L6
    }

    public static void b0(String r11) {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);
        c(r11, r10);
        return;
    L5:
        r0 = "none";
        goto L6
    }

    @JvmStatic
    public static final void g(String r11) {
        Intrinsics.checkNotNullParameter(r11, "triggerReason");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r1, h, d, e, a, b, i);
        r0.put("trigger_reason", r11);
        c("ccm_permission_read_without_edit_view", r0);
        return;
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void l(String r13) {
        Intrinsics.checkNotNullParameter(r13, "click");
        JSONObject r11 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r11, r2, r3, r4, h, d, e, a, b, i);
        r11.put("toast_source", "superior_management_set");
        r11.put("click", r13);
        r11.put("target", "none");
        c("ccm_permission_automatic_perm_click", r11);
        return;
    L5:
        r4 = "none";
        goto L6
    }

    @JvmStatic
    public static final void G(boolean r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "click");
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L9
        String r2 = f;     // Catch: Exception -> L9
        int r3 = g;     // Catch: Exception -> L9
        if (c == false) goto L6;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L7:
        a(r11, r2, r3, r1, h, d, e, a, b, i);     // Catch: Exception -> L9
        r11.put("is_compulsory_labeling", String.valueOf(r12));     // Catch: Exception -> L9
        r11.put("click", r13);     // Catch: Exception -> L9
        c("scs_file_recommended_label_banner_click", r11);     // Catch: Exception -> L9
        return;
    L6:
        r1 = "none";
    L9:
        e = move-exception;
        tt5.a.e("PermissionAnalyticV2", "doReport()...failed", e, false);
    }

    @JvmStatic
    public static final void J(boolean r11, boolean r12) {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);
        r10.put("is_single_apply", r11);
        r10.put("is_include_own", r12);
        c("ccm_permission_security_demotion_resubmit_view", r10);
        return;
    L5:
        r0 = "none";
        goto L6
    }

    @JvmStatic
    public static final void P(String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "click");
        Intrinsics.checkNotNullParameter("none", "target");
        JSONObject r13 = new JSONObject();
        String r4 = f;
        int r5 = g;
        if (c == false) goto L5;
        String r6 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r13, r4, r5, r6, h, d, e, a, b, i);
        r13.put("click", r14);
        r13.put("target", "none");
        r13.put("is_check_open", r15);
        c("ccm_permission_security_demotion_click", r13);
        return;
    L5:
        r6 = "none";
        goto L6
    }

    public static void V(String r11, String r12) {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);
        r10.put("click", r11);
        r10.put("target", r12);
        c("ccm_permission_share_click", r10);
        return;
    L5:
        r0 = "none";
        goto L6
    }

    public static void b(PermissionReportInfo r2, JSONObject r3) {
        r3.put("domain", r2.getDomain());
        r3.put("block_type", r2.getBlockType());
        r3.put(WikiFolderPushPlugin.OPT, r2.getOperation());
        r3.put(ResourceData.KEY_TYPE, r2.getType());
        r3.put("allow", r2.getAllow());
        r3.put("has_net", r2.getHasNet());
        r3.put("use_cache", r2.getUseCache());
    }

    public static void c(String r5, JSONObject r6) {
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).i(r5, r6);     // Catch: Throwable -> L5
        tt5.a.b("PermissionAnalyticV2", "eventName:" + r5 + ", params : " + r6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("PermissionAnalyticV2", "doReport()...failed", th, false);
    }

    public static String d(int r2, int r3) {
        boolean r1 = true;
        if (r2 != sbb.e.f.b) goto L10;
        if (r3 != 1) goto L6;
    L24:
        return "read";
    L6:
        if (r3 != 2) goto L8;
    L18:
        return "edit";
    L8:
        if (r3 != 3) goto L25;
    L12:
        return "full_access";
    L25:
        return "no_permission";
    L10:
        DocUserPermission.Companion.getClass();
        if (DocUserPermission.a.a(r3) == true) goto L12;
        if ((r3 & 4) == 0) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L18;
        if ((r3 & 1) != 0) goto L23;
        r1 = false;
    L23:
        if (r1 == false) goto L25;
    L16:
        r4 = false;
        goto L17
    }

    @JvmStatic
    public static final void j(boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "viewFrom");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r1, h, d, e, a, b, i);
        r0.put("is_single_apply", r11);
        r0.put("view_from", r12);
        c("ccm_permission_security_resubmit_toast_view", r0);
        return;
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void k(UserInfo r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "userInfo");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r4, h, d, e, a, b, i);
        if (r13 != 1) goto L9;
        String r14 = "read";
    L13:
        r0.put("click", r14);
        r0.put("collaborate_type", r12.getOwnerType());
        r0.put("object_uid", du5.b.g(r12.getId()));
        r0.put("list_type", d(g, r12.getPermission()));
        r0.put("target", "none");
        c("ccm_permission_share_ask_owner_type_click", r0);
        return;
    L9:
        if (r13 == 4) goto L11;
        r14 = "delete";
        goto L13
    L11:
        r14 = "edit";
        goto L13
    L5:
        r4 = "none";
        goto L6
    }

    public static void s(boolean r11, boolean r12) {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);
        String r3 = "true";
        if (r11 == false) goto L9;
        Object r13 = "true";
    L10:
        r10.put("is_owner", r13);
        if (r12 == true) goto L14;
        r3 = "false";
    L14:
        r10.put("is_magic_share", r3);
        c("ccm_dlp_security_banner_hint_view", r10);
        return;
    L9:
        r13 = "false";
        goto L10
    L5:
        r0 = "none";
        goto L6
    }

    public static void t(String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "triggerReason");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r1, h, d, e, a, b, i);
        r0.put("trigger_reason", r11);
        if (r12 == false) goto L9;
        String r13 = "false";
    L10:
        r0.put("result", r13);
        if (r12 == false) goto L13;
        r0.put("intercept_reason", "DLP");
    L13:
        c("ccm_dlp_intercept_result_view", r0);
        return;
    L9:
        r13 = "true";
        goto L10
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void I(String r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "click");
        JSONObject r11 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r11, r2, r3, r1, h, d, e, a, b, i);
        r11.put("is_single_apply", r13);
        r11.put("is_include_own", r14);
        r11.put("click", r12);
        c("ccm_permission_security_demotion_resubmit_click", r11);
        return;
    L5:
        r1 = "none";
        goto L6
    }

    public static void M(boolean r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "location");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r4, h, d, e, a, b, i);
        if (r12 == false) goto L9;
        String r15 = "confirm";
    L10:
        r0.put("click", r15);
        r0.put("trigger_location", r13);
        if (r14 == false) goto L13;
        String r16 = "true";
    L14:
        r0.put("is_lock_notify", r16);
        r0.put("target", "none");
        c("ccm_permission_scope_change_click", r0);
        return;
    L13:
        r16 = "false";
        goto L14
    L9:
        r15 = DocFeed$Value$Result.CANCEL;
        goto L10
    L5:
        r4 = "none";
        goto L6
    }

    @JvmStatic
    public static final void N(boolean r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "clickEvent");
        Intrinsics.checkNotNullParameter(r14, "target");
        JSONObject r11 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r11, r2, r3, r1, h, d, e, a, b, i);
        if (r12 == false) goto L9;
        String r15 = "have_default_no_setting";
    L10:
        r11.put("triggle_reason", r15);
        r11.put("click", r13);
        r11.put("target", r14);
        c("ccm_permission_security_docs_banner_click", r11);
        return;
    L9:
        r15 = "no_default_no_setting";
        goto L10
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void f(String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "triggerReason");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r4, h, d, e, a, b, i);
        r0.put("click", "apply");
        boolean r1 = false;
        if (r12.length() != 0) goto L9;
        boolean r15 = true;
    L10:
        r0.put("is_add_notes", !r15);
        r0.put("target", "none");
        r0.put("trigger_reason", r13);
        if (r14 != null) goto L13;
    L14:
        r1 = true;
    L15:
        if (r1 == false) goto L17;
        String r16 = "";
    L18:
        r0.put("minutes_object_token", r16);
        c("ccm_permission_read_without_edit_click", r0);
        return;
    L17:
        r16 = du5.b.g(r14);
        goto L18
    L13:
        if (r14.length() != 0) goto L15;
    L9:
        r15 = false;
        goto L10
    L5:
        r4 = "none";
        goto L6
    }

    @JvmStatic
    public static final void o(boolean r11, int r12, boolean r13) {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);
        if (r11 == false) goto L9;
        String r14 = "all_cancel";
    L10:
        r10.put("pop_up_type", r14);
        r10.put("cited_doc_num", r12);
        r10.put("is_group_chat", !r13);
        c("ccm_permission_cited_doc_all_authorize_view", r10);
        return;
    L9:
        r14 = "all_authorize";
        goto L10
    L5:
        r0 = "none";
        goto L6
    }

    public static void r(boolean r11, boolean r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "clickEvent");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r1, h, d, e, a, b, i);
        String r4 = "true";
        if (r11 == false) goto L9;
        Object r14 = "true";
    L10:
        r0.put("is_owner", r14);
        if (r12 == true) goto L14;
        r4 = "false";
    L14:
        r0.put("is_magic_share", r4);
        r0.put("click", r13);
        c("ccm_dlp_security_banner_hint_click", r0);
        return;
    L9:
        r14 = "false";
        goto L10
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void x(String r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r13, "triggerType");
        JSONObject r0 = new JSONObject();
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r11, r12, r1, h, d, e, a, b, i);
        r0.put("trigger_type", r13);
        c("ccm_permission_internet_forbidden_view", r0);
        return;
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void T(ArrayList<UserInfo> r12, boolean r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "userInfoList");
        JSONObject r0 = new JSONObject();
        String r2 = f;
        int r3 = g;
        if (c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r2, r3, r4, h, d, e, a, b, i);
        r0.put("click", "invite");
        r0.put("is_add_notes", r13);
        r0.put("is_send_notice", r14);
        if (r15 == false) goto L9;
        String r16 = "true";
    L10:
        r0.put("is_allow_child_access", r16);
        JSONArray r17 = new JSONArray();
        Iterator<UserInfo> r18 = r12.iterator();
    L12:
        if (r18.hasNext() == false) goto L14;
        UserInfo r19 = r18.next();
        JSONObject r110 = new JSONObject();
        r110.put("collaborate_type", r19.getOwnerType());
        r110.put("object_uid", du5.b.g(r19.getId()));
        r110.put("list_type", d(g, r19.getPermission()));
        r17.put(r110);
        goto L12
    L14:
        r0.put("user_list", r17.toString());
        r0.put("target", "none");
        c("ccm_permission_select_contact_click", r0);
        return;
    L9:
        r16 = "false";
        goto L10
    L5:
        r4 = "none";
        goto L6
    }

    @JvmStatic
    public static final void n(boolean r11, boolean r12, int r13, boolean r14) {
        JSONObject r10 = new JSONObject();
        String r1 = f;
        int r2 = g;
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r1, r2, r0, h, d, e, a, b, i);
        if (r11 == false) goto L9;
        String r15 = "confirm";
    L10:
        r10.put("click", r15);
        if (r12 == false) goto L13;
        String r16 = "all_cancel";
    L14:
        r10.put("pop_up_type", r16);
        r10.put("cited_doc_num", r13);
        r10.put("is_group_chat", !r14);
        c("ccm_permission_cited_doc_all_authorize_click", r10);
        return;
    L13:
        r16 = "all_authorize";
        goto L14
    L9:
        r15 = DocFeed$Value$Result.CANCEL;
        goto L10
    L5:
        r0 = "none";
        goto L6
    }

    @JvmStatic
    public static final void w(String r15, int r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r17, "click");
        Intrinsics.checkNotNullParameter(r18, "triggerType");
        JSONObject r13 = new JSONObject();
        if (c == false) goto L5;
        String r6 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r13, r15, r16, r6, h, d, e, a, b, i);
        r13.put("click", r17);
        r13.put("target", "none");
        r13.put("trigger_type", r18);
        c("ccm_permission_internet_forbidden_click", r13);
        return;
    L5:
        r6 = "none";
        goto L6
    }

    @JvmStatic
    public static final void W(String r12, int r13, String r14, boolean r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_TOKEN);
        JSONObject r0 = new JSONObject();
        if (c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r12, r13, r4, r14, d, e, a, b, r15);
        if (r16 == false) goto L9;
        String r1 = "turn_on";
    L10:
        r0.put("click", r1);
        r0.put("target", "none");
        c("ccm_permission_share_public_access_click", r0);
        return;
    L9:
        r1 = "maybe_later";
        goto L10
    L5:
        r4 = "none";
        goto L6
    }

    @JvmStatic
    public static final void p(String r16, String r17, Boolean r18, Boolean r19, Integer r20) {
        Intrinsics.checkNotNullParameter(r16, "click");
        Intrinsics.checkNotNullParameter("none", "target");
        Intrinsics.checkNotNullParameter(r17, "changeType");
        JSONObject r5 = new JSONObject();
        String r7 = f;
        int r8 = g;
        if (c == false) goto L5;
        String r9 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r5, r7, r8, r9, h, d, e, a, b, i);
        r5.put("click", r16);
        r5.put("change_type", r17);
        if (r18 == null) goto L9;
        r18.booleanValue();
        r5.put("is_success", r18.booleanValue());
    L9:
        if (r19 == null) goto L11;
        r19.booleanValue();
        r5.put("is_credential_stuffing", r19.booleanValue());
    L11:
        if (r20 == null) goto L13;
        r20.intValue();
        r5.put("error_code", r20.intValue());
    L13:
        r5.put("target", "none");
        c("ccm_permission_change_password_click", r5);
        return;
    L5:
        r9 = "none";
        goto L6
    }

    public static /* synthetic */ void q(String r2, String r3, Boolean r4, Boolean r5, int r6) {
        if ((r6 & 8) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 16) == 0) goto L8;
        r5 = null;
    L8:
        p(r2, r3, r4, r5, null);
    }

    @JvmStatic
    public static final void y(String r11, int r12, String r13, boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r15, "from");
        JSONObject r0 = new JSONObject();
        if (c == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r11, r12, r1, r13, d, e, a, b, r14);
        r0.put("from_scene", r15);
        c("ccm_permission_prompt_view", r0);
        return;
    L5:
        r1 = "none";
        goto L6
    }

    public static void A(String r11, int r12, String r13, boolean r14, String r15, String r16) {
        JSONObject r10 = new JSONObject();
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r11, r12, r0, r13, d, e, a, b, r14);
        r10.put("click", r15);
        r10.put("target", r16);
        c("ccm_permission_organization_authorize_click", r10);
        return;
    L5:
        r0 = "none";
        goto L6
    }

    @JvmStatic
    public static final void B(boolean r13, String r14, boolean r15, int r16, boolean r17, int r18) {
        Intrinsics.checkNotNullParameter(r14, "openType");
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L21
        String r3 = f;     // Catch: JSONException -> L21
        int r4 = g;     // Catch: JSONException -> L21
        if (c == false) goto L6;
        String r2 = ThumbGlideUrl.SOURCE_VC;
    L7:
        a(r12, r3, r4, r2, h, d, e, a, b, i);     // Catch: JSONException -> L21
        int r5 = 1;
        if (r13 == false) goto L10;
        int r6 = 1;
    L11:
        r12.put("is_successful", r6);     // Catch: JSONException -> L21
        r12.put("open_type", r14);     // Catch: JSONException -> L21
        if (r15 == false) goto L14;
        int r7 = 1;
    L15:
        r12.put("is_retry", r7);     // Catch: JSONException -> L21
        r12.put("source", r16);     // Catch: JSONException -> L21
        r12.put("error_code", r18);     // Catch: JSONException -> L21
        if (r17 == true) goto L19;
        r5 = 0;
    L19:
        r12.put("is_minutes", r5);     // Catch: JSONException -> L21
        c("ccm_permission_performance_share_open_finish_dev", r12);     // Catch: JSONException -> L21
        return;
    L14:
        r7 = 0;
        goto L15
    L10:
        r6 = 0;
        goto L11
    L6:
        r2 = "none";
    L21:
        e = move-exception;
        tt5.a.f("PermissionAnalyticV2", e, false);
    }

    public static void a0(String r11, int r12, String r13, boolean r14, String r15, String r16) {
        JSONObject r10 = new JSONObject();
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r11, r12, r0, r13, d, e, a, b, r14);
        r10.put("click", r15);
        r10.put("target", r16);
        c("ccm_permission_dynamic_user_group_authorize_click", r10);
        return;
    L5:
        r0 = "none";
        goto L6
    }

    public static void e(String r11, int r12, String r13, boolean r14, String r15, String r16) {
        JSONObject r10 = new JSONObject();
        if (c == false) goto L5;
        String r0 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r10, r11, r12, r0, r13, d, e, a, b, r14);
        r10.put("click", r15);
        r10.put("target", r16);
        c("ccm_permission_add_collaborator_click", r10);
        return;
    L5:
        r0 = "none";
        goto L6
    }

    @JvmStatic
    public static final void u(String r13, int r14, String r15, boolean r16, boolean r17, String r18) {
        Intrinsics.checkNotNullParameter(r13, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r18, "from");
        JSONObject r1 = new JSONObject();
        if (c == false) goto L5;
        String r5 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r1, r13, r14, r5, r15, d, e, a, b, r16);
        if (r17 == false) goto L9;
        String r2 = "confirm";
    L10:
        r1.put("click", r2);
        r1.put("from_scene", r18);
        r1.put("target", "none");
        c("ccm_permission_prompt_click", r1);
        return;
    L9:
        r2 = DocFeed$Value$Result.CANCEL;
        goto L10
    L5:
        r5 = "none";
        goto L6
    }

    @JvmStatic
    public static final void R(String r20, String r21, String r22, boolean r23, boolean r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r20, "click");
        Intrinsics.checkNotNullParameter(r21, "target");
        Intrinsics.checkNotNullParameter(r22, "securityId");
        Intrinsics.checkNotNullParameter(r25, "view_from");
        Intrinsics.checkNotNullParameter(r26, "security_type");
        JSONObject r15 = new JSONObject();
        String r10 = f;
        int r11 = g;
        if (c == false) goto L5;
        String r9 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r15, r10, r11, r9, h, d, e, a, b, i);
        r15.put("click", r20);
        r15.put("target", r21);
        if (Intrinsics.areEqual(r22, "") == true) goto L9;
        r15.put("security_id", r22);
    L9:
        r15.put("is_security_demotion", r23);
        r15.put("is_single_apply", r24);
        r15.put("view_from", r25);
        r15.put("security_type", r26);
        c("ccm_permission_security_setting_click", r15);
        return;
    L5:
        r9 = "none";
        goto L6
    }

    @JvmStatic
    public static final void D(String r12, int r13, String r14, boolean r15, boolean r16, String r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r14, "subType");
        Intrinsics.checkNotNullParameter(r17, "module");
        Intrinsics.checkNotNullParameter(r18, "userPerm");
        Intrinsics.checkNotNullParameter(r19, "publicPerm");
        JSONObject r0 = new JSONObject();
        if (r15 == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r12, r13, r4, r14, r17, "", r18, r19, r16);
        r0.put("click", "back");
        r0.put("target", "none");
        c("ccm_permission_unable_to_apply_click", r0);
        return;
    L5:
        r4 = "none";
        goto L6
    }

    @JvmStatic
    public static final void X(String r11, int r12, String r13, boolean r14, boolean r15, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r13, "subType");
        Intrinsics.checkNotNullParameter(r16, "module");
        Intrinsics.checkNotNullParameter(r17, "userPerm");
        Intrinsics.checkNotNullParameter(r18, "publicPerm");
        JSONObject r0 = new JSONObject();
        if (r14 == false) goto L5;
        String r1 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r0, r11, r12, r1, r13, r16, "", r17, r18, r15);
        c("ccm_permission_unable_to_apply_view", r0);
        return;
    L5:
        r1 = "none";
        goto L6
    }

    @JvmStatic
    public static final void h(String r13, int r14, String r15, boolean r16, boolean r17, String r18, String r19, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r13, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r15, "subType");
        Intrinsics.checkNotNullParameter(r18, "module");
        Intrinsics.checkNotNullParameter(r19, "userPerm");
        Intrinsics.checkNotNullParameter(r20, "publicPerm");
        Intrinsics.checkNotNullParameter(r21, "triggerReason");
        JSONObject r1 = new JSONObject();
        if (r16 == false) goto L5;
        String r5 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r1, r13, r14, r5, r15, r18, "", r19, r20, r17);
        r1.put("click", "back");
        r1.put("target", "none");
        r1.put("trigger_reason", r21);
        c("ccm_permission_without_permission_click", r1);
        return;
    L5:
        r5 = "none";
        goto L6
    }

    @JvmStatic
    public static final void z(String r12, int r13, String r14, boolean r15, boolean r16, String r17, String r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r14, "subType");
        Intrinsics.checkNotNullParameter(r17, "module");
        Intrinsics.checkNotNullParameter(r18, "userPerm");
        Intrinsics.checkNotNullParameter(r19, "publicPerm");
        Intrinsics.checkNotNullParameter(r20, "triggerReason");
        JSONObject r1 = new JSONObject();
        if (r15 == false) goto L5;
        String r2 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r1, r12, r13, r2, r14, r17, "", r18, r19, r16);
        r1.put("trigger_reason", r20);
        c("ccm_permission_without_permission_view", r1);
        return;
    L5:
        r2 = "none";
        goto L6
    }

    @JvmStatic
    public static final void C(int r12, int r13, int r14, int r15, int r16, int r17, String r18, boolean r19, int r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r18, "openType");
        JSONObject r1 = new JSONObject();
        String r3 = f;
        int r4 = g;
        if (c == false) goto L5;
        String r2 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r1, r3, r4, r2, h, d, e, a, b, i);
        r1.put("t1", r12);
        r1.put("t2", r13);
        r1.put("t3", r14);
        r1.put("t4", r15);
        r1.put("first_view_time", r16);
        r1.put("cost_time", r17);
        r1.put("open_type", r18);
        r1.put("is_retry", r19 ? 1 : 0);
        r1.put("source", r20);
        r1.put("is_minutes", r21 ? 1 : 0);
        c("ccm_permission_performance_share_open_time_dev", r1);
        return;
    L5:
        r2 = "none";
        goto L6
    }

    public static void a(JSONObject r3, String r4, int r5, String r6, String r7, String r8, String r9, String r10, String r11, boolean r12) {
        String r0 = sbb.e.c(r5);
        r3.put("file_id", du5.b.g(r4));
        r3.put("file_type", r0);
        r3.put("app_form", r6);
        Object r13 = "none";
        boolean r1 = false;
        if (r5 != sbb.e.l.b) goto L13;
        if (r7 != null) goto L6;
    L9:
        boolean r14 = true;
    L10:
        if (r14 == false) goto L12;
        r7 = "none";
    L12:
        r3.put("sub_file_type", r7);
        goto L13
    L6:
        if (r7.length() == 0) goto L9;
        r14 = false;
    L13:
        if (r12 == false) goto L15;
        r8 = sbb.e.n.getType();
    L26:
        r3.put("module", r8);
        if (r9 != null) goto L29;
    L30:
        r1 = true;
    L31:
        if (r1 == false) goto L33;
        r9 = "none";
    L33:
        r3.put("sub_module", r9);
        if (r5 != sbb.e.f.b) goto L36;
        r3.put("user_permission_folder", r10);
        r3.put("folder_permission", r11);
    L38:
        if (r12 == false) goto L44;
        Object r15 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).f("docCommonParams", "container_id");
        if (r15 == null) goto L43;
        r13 = r15;
    L43:
        r3.put("container_id", r13);
    L45:
        if (r12 == false) goto L47;
        String r16 = DocumentType.WIKI_NAME;
    L48:
        r3.put("container_type", r16);
        return;
    L47:
        r16 = DocumentType.FOLDER_NAME;
        goto L48
    L44:
        r3.put("container_id", "none");
        goto L45
    L36:
        r3.put("user_permission", r10);
        r3.put("file_permission", r11);
        goto L38
    L29:
        if (r9.length() != 0) goto L31;
    L15:
        if (r8 != null) goto L17;
    L22:
        boolean r17 = false;
    L23:
        if (r17 == true) goto L26;
        r8 = r0;
        goto L26
    L17:
        if (r8.length() <= 0) goto L19;
        boolean r18 = true;
    L20:
        if (r18 != true) goto L22;
        r17 = true;
        goto L23
    L19:
        r18 = false;
        goto L20
    }

    @JvmStatic
    public static final void i(String r14, int r15, String r16, boolean r17, boolean r18, String r19, String r20, String r21, int r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r14, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r16, "subType");
        Intrinsics.checkNotNullParameter(r19, "module");
        Intrinsics.checkNotNullParameter(r20, "userPerm");
        Intrinsics.checkNotNullParameter(r21, "publicPerm");
        Intrinsics.checkNotNullParameter(r24, "triggerReason");
        JSONObject r2 = new JSONObject();
        if (r17 == false) goto L5;
        String r6 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r2, r14, r15, r6, r16, r19, "", r20, r21, r18);
        r2.put("click", "apply_permission");
        if (r22 != 1) goto L9;
    L12:
        String r0 = "read";
    L13:
        r2.put("apply_list", r0);
        if (r23 != null) goto L16;
    L19:
        boolean r1 = true;
    L20:
        r2.put("is_add_notes", !r1);
        r2.put("target", "none");
        r2.put("trigger_reason", r24);
        c("ccm_permission_without_permission_click", r2);
        return;
    L16:
        if (r23.length() == 0) goto L19;
        r1 = false;
        goto L20
    L9:
        if (r22 != 4) goto L12;
        r0 = "edit";
        goto L13
    L5:
        r6 = "none";
        goto L6
    }
}
