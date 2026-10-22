package com.bytedance.ee.bear.middleground.permission;

import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionReportInfo;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f233147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f233148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f233149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f233150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f233151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f233152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f233153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f233154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f233155i;

    static {
        f233147a = "";
        f233148b = "";
        f233150d = "none";
        f233151e = "none";
        f233152f = "";
        f233154h = "";
    }

    @JvmStatic
    public static final void S() {
        JSONObject r110 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r110, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r110.put("click", "back");
        r110.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_select_contact_click", r110);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void Z() {
        JSONObject r110 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r110, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        c("ccm_permission_lock_restore_view", r110);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void m() {
        JSONObject r110 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r110, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r110.put("click", "all_cancel");
        r110.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_cited_doc_authorize_click", r110);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    public static void v() {
        JSONObject r110 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r110, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        c("ccm_permission_no_collaborator_profile_list_view", r110);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void E(PermissionReportInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "reportInfo");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        b(r110, r100);
        c("ccm_permission_performance_permission_sdk_check_dev", r100);
        return;
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void F(PermissionReportInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "reportInfo");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        b(r110, r100);
        c("ccm_permission_performance_permission_sdk_click_dev", r100);
        return;
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void H(boolean r110) {
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L8
        String r100 = f233152f;     // Catch: Exception -> L8
        int r101 = f233153g;     // Catch: Exception -> L8
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r111, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);     // Catch: Exception -> L8
        r111.put("is_compulsory_labeling", String.valueOf(r110));     // Catch: Exception -> L8
        c("scs_file_recommended_label_banner_view", r111);     // Catch: Exception -> L8
        return;
    L5:
        r102 = "none";
    L8:
        e = move-exception;
        tt5.a.e("PermissionAnalyticV2", "doReport()...failed", e, false);
    }

    @JvmStatic
    public static final void K(String r110) {
        Intrinsics.checkNotNullParameter(r110, "click");
        JSONObject r111 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r111, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r111.put("click", r110);
        r111.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_security_demotion_result_click", r111);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void L(boolean r110) {
        JSONObject r111 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r111, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r111.put("if_success", r110);
        c("ccm_permission_security_demotion_result_view", r111);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void O(boolean r110) {
        JSONObject r111 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r111, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        if (r110 == false) goto L9;
        String r112 = "have_default_no_setting";
    L10:
        r111.put("triggle_reason", r112);
        c("ccm_permission_security_docs_banner_view", r111);
        return;
    L9:
        r112 = "no_default_no_setting";
        goto L10
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void Q(String r110) {
        Intrinsics.checkNotNullParameter("click_security_level", "click");
        Intrinsics.checkNotNullParameter("none", PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r110, "isOriginLevel");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r100.put("click", "click_security_level");
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        r100.put("is_original_level", r110);
        c("ccm_permission_security_setting_click", r100);
        return;
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void U(ArrayList<UserInfo> r110) {
        Intrinsics.checkNotNullParameter(r110, "userInfoList");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        JSONArray r104 = new JSONArray();
        Iterator<UserInfo> r111 = r110.iterator();
    L8:
        if (r111.hasNext() == false) goto L10;
        UserInfo r105 = r111.next();
        JSONObject r106 = new JSONObject();
        r106.put("collaborate_type", r105.getOwnerType());
        r106.put("object_uid", du5.b.g(r105.getId()));
        r106.put("list_type", d(f233153g, r105.getPermission()));
        r104.put(r106);
        goto L8
    L10:
        r100.put("user_list", r104.toString());
        c("ccm_permission_select_contact_view", r100);
        return;
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void Y(boolean r110) {
        JSONObject r111 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r111, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        if (r110 == false) goto L9;
        String r112 = "confirm";
    L10:
        r111.put("click", r112);
        r111.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_lock_restore_click", r111);
        return;
    L9:
        r112 = "cancel";
        goto L10
    L5:
        r102 = "none";
        goto L6
    }

    public static void b0(String r110) {
        JSONObject r111 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r111, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        c(r110, r111);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void g(String r110) {
        Intrinsics.checkNotNullParameter(r110, "triggerReason");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r100.put("trigger_reason", r110);
        c("ccm_permission_read_without_edit_view", r100);
        return;
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void l(String r110) {
        Intrinsics.checkNotNullParameter(r110, "click");
        JSONObject r111 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r111, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r111.put("toast_source", "superior_management_set");
        r111.put("click", r110);
        r111.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_automatic_perm_click", r111);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void G(boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "click");
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L9
        String r100 = f233152f;     // Catch: Exception -> L9
        int r101 = f233153g;     // Catch: Exception -> L9
        if (f233149c == false) goto L6;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L7:
        a(r112, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);     // Catch: Exception -> L9
        r112.put("is_compulsory_labeling", String.valueOf(r110));     // Catch: Exception -> L9
        r112.put("click", r111);     // Catch: Exception -> L9
        c("scs_file_recommended_label_banner_click", r112);     // Catch: Exception -> L9
        return;
    L6:
        r102 = "none";
    L9:
        e = move-exception;
        tt5.a.e("PermissionAnalyticV2", "doReport()...failed", e, false);
    }

    @JvmStatic
    public static final void J(boolean r110, boolean r111) {
        JSONObject r112 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r112, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r112.put("is_single_apply", r110);
        r112.put("is_include_own", r111);
        c("ccm_permission_security_demotion_resubmit_view", r112);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void P(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "click");
        Intrinsics.checkNotNullParameter("none", PickerReporterConstants.KEY.TARGET);
        JSONObject r112 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r112, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r112.put("click", r110);
        r112.put(PickerReporterConstants.KEY.TARGET, "none");
        r112.put("is_check_open", r111);
        c("ccm_permission_security_demotion_click", r112);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    public static void V(String r110, String r111) {
        JSONObject r112 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r112, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r112.put("click", r110);
        r112.put(PickerReporterConstants.KEY.TARGET, r111);
        c("ccm_permission_share_click", r112);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    public static void b(PermissionReportInfo r100, JSONObject r101) {
        r101.put("domain", r100.getDomain());
        r101.put("block_type", r100.getBlockType());
        r101.put(WikiFolderPushPlugin.OPT, r100.getOperation());
        r101.put("type", r100.getType());
        r101.put("allow", r100.getAllow());
        r101.put("has_net", r100.getHasNet());
        r101.put("use_cache", r100.getUseCache());
    }

    public static void c(String r100, JSONObject r101) {
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).i(r100, r101);     // Catch: Throwable -> L5
        tt5.a.b("PermissionAnalyticV2", "eventName:" + r100 + ", params : " + r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("PermissionAnalyticV2", "doReport()...failed", th, false);
    }

    public static String d(int r100, int r101) {
        boolean r102 = true;
        if (r100 != sbb.e.f541295f.f541317b) goto L10;
        if (r101 != 1) goto L6;
    L24:
        return "read";
    L6:
        if (r101 != 2) goto L8;
    L18:
        return "edit";
    L8:
        if (r101 != 3) goto L25;
    L12:
        return "full_access";
    L25:
        return "no_permission";
    L10:
        DocUserPermission.Companion.getClass();
        if (DocUserPermission.a.a(r101) == true) goto L12;
        if ((r101 & 4) == 0) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L18;
        if ((r101 & 1) != 0) goto L23;
        r102 = false;
    L23:
        if (r102 == false) goto L25;
    L16:
        r103 = false;
        goto L17
    }

    @JvmStatic
    public static final void j(boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "viewFrom");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r100.put("is_single_apply", r110);
        r100.put("view_from", r111);
        c("ccm_permission_security_resubmit_toast_view", r100);
        return;
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void k(UserInfo r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "userInfo");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        if (r111 != 1) goto L9;
        String r112 = "read";
    L13:
        r100.put("click", r112);
        r100.put("collaborate_type", r110.getOwnerType());
        r100.put("object_uid", du5.b.g(r110.getId()));
        r100.put("list_type", d(f233153g, r110.getPermission()));
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_share_ask_owner_type_click", r100);
        return;
    L9:
        if (r111 == 4) goto L11;
        r112 = "delete";
        goto L13
    L11:
        r112 = "edit";
        goto L13
    L5:
        r103 = "none";
        goto L6
    }

    public static void s(boolean r110, boolean r111) {
        JSONObject r112 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r112, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        String r103 = "true";
        if (r110 == false) goto L9;
        Object r113 = "true";
    L10:
        r112.put("is_owner", r113);
        if (r111 == true) goto L14;
        r103 = "false";
    L14:
        r112.put("is_magic_share", r103);
        c("ccm_dlp_security_banner_hint_view", r112);
        return;
    L9:
        r113 = "false";
        goto L10
    L5:
        r102 = "none";
        goto L6
    }

    public static void t(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "triggerReason");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r100.put("trigger_reason", r110);
        if (r111 == false) goto L9;
        String r112 = "false";
    L10:
        r100.put("result", r112);
        if (r111 == false) goto L13;
        r100.put("intercept_reason", "DLP");
    L13:
        c("ccm_dlp_intercept_result_view", r100);
        return;
    L9:
        r112 = "true";
        goto L10
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void I(String r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "click");
        JSONObject r113 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r113, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r113.put("is_single_apply", r111);
        r113.put("is_include_own", r112);
        r113.put("click", r110);
        c("ccm_permission_security_demotion_resubmit_click", r113);
        return;
    L5:
        r102 = "none";
        goto L6
    }

    public static void M(boolean r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "location");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        if (r110 == false) goto L9;
        String r113 = "confirm";
    L10:
        r100.put("click", r113);
        r100.put("trigger_location", r111);
        if (r112 == false) goto L13;
        String r114 = "true";
    L14:
        r100.put("is_lock_notify", r114);
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_scope_change_click", r100);
        return;
    L13:
        r114 = "false";
        goto L14
    L9:
        r113 = "cancel";
        goto L10
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void N(boolean r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "clickEvent");
        Intrinsics.checkNotNullParameter(r112, PickerReporterConstants.KEY.TARGET);
        JSONObject r113 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r113, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        if (r110 == false) goto L9;
        String r114 = "have_default_no_setting";
    L10:
        r113.put("triggle_reason", r114);
        r113.put("click", r111);
        r113.put(PickerReporterConstants.KEY.TARGET, r112);
        c("ccm_permission_security_docs_banner_click", r113);
        return;
    L9:
        r114 = "no_default_no_setting";
        goto L10
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void f(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "triggerReason");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r100.put("click", e1.REPLY_ACTION_APPLY);
        boolean r104 = false;
        if (r110.length() != 0) goto L9;
        boolean r113 = true;
    L10:
        r100.put("is_add_notes", !r113);
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        r100.put("trigger_reason", r111);
        if (r112 != null) goto L13;
    L14:
        r104 = true;
    L15:
        if (r104 == false) goto L17;
        String r114 = "";
    L18:
        r100.put("minutes_object_token", r114);
        c("ccm_permission_read_without_edit_click", r100);
        return;
    L17:
        r114 = du5.b.g(r112);
        goto L18
    L13:
        if (r112.length() != 0) goto L15;
    L9:
        r113 = false;
        goto L10
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void o(boolean r110, int r111, boolean r112) {
        JSONObject r113 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r113, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        if (r110 == false) goto L9;
        String r114 = "all_cancel";
    L10:
        r113.put("pop_up_type", r114);
        r113.put("cited_doc_num", r111);
        r113.put("is_group_chat", !r112);
        c("ccm_permission_cited_doc_all_authorize_view", r113);
        return;
    L9:
        r114 = "all_authorize";
        goto L10
    L5:
        r102 = "none";
        goto L6
    }

    public static void r(boolean r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "clickEvent");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        String r104 = "true";
        if (r110 == false) goto L9;
        Object r113 = "true";
    L10:
        r100.put("is_owner", r113);
        if (r111 == true) goto L14;
        r104 = "false";
    L14:
        r100.put("is_magic_share", r104);
        r100.put("click", r112);
        c("ccm_dlp_security_banner_hint_click", r100);
        return;
    L9:
        r113 = "false";
        goto L10
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void x(String r110, int r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "triggerType");
        JSONObject r100 = new JSONObject();
        if (f233149c == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r110, r111, r101, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r100.put("trigger_type", r112);
        c("ccm_permission_internet_forbidden_view", r100);
        return;
    L5:
        r101 = "none";
        goto L6
    }

    @JvmStatic
    public static final void T(ArrayList<UserInfo> r110, boolean r111, boolean r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "userInfoList");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r100.put("click", "invite");
        r100.put("is_add_notes", r111);
        r100.put("is_send_notice", r112);
        if (r113 == false) goto L9;
        String r114 = "true";
    L10:
        r100.put("is_allow_child_access", r114);
        JSONArray r115 = new JSONArray();
        Iterator<UserInfo> r116 = r110.iterator();
    L12:
        if (r116.hasNext() == false) goto L14;
        UserInfo r117 = r116.next();
        JSONObject r118 = new JSONObject();
        r118.put("collaborate_type", r117.getOwnerType());
        r118.put("object_uid", du5.b.g(r117.getId()));
        r118.put("list_type", d(f233153g, r117.getPermission()));
        r115.put(r118);
        goto L12
    L14:
        r100.put("user_list", r115.toString());
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_select_contact_click", r100);
        return;
    L9:
        r114 = "false";
        goto L10
    L5:
        r103 = "none";
        goto L6
    }

    @JvmStatic
    public static final void n(boolean r110, boolean r111, int r112, boolean r113) {
        JSONObject r114 = new JSONObject();
        String r100 = f233152f;
        int r101 = f233153g;
        if (f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r114, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        if (r110 == false) goto L9;
        String r115 = "confirm";
    L10:
        r114.put("click", r115);
        if (r111 == false) goto L13;
        String r116 = "all_cancel";
    L14:
        r114.put("pop_up_type", r116);
        r114.put("cited_doc_num", r112);
        r114.put("is_group_chat", !r113);
        c("ccm_permission_cited_doc_all_authorize_click", r114);
        return;
    L13:
        r116 = "all_authorize";
        goto L14
    L9:
        r115 = "cancel";
        goto L10
    L5:
        r102 = "none";
        goto L6
    }

    @JvmStatic
    public static final void w(String r110, int r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "click");
        Intrinsics.checkNotNullParameter(r113, "triggerType");
        JSONObject r114 = new JSONObject();
        if (f233149c == false) goto L5;
        String r100 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r114, r110, r111, r100, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r114.put("click", r112);
        r114.put(PickerReporterConstants.KEY.TARGET, "none");
        r114.put("trigger_type", r113);
        c("ccm_permission_internet_forbidden_click", r114);
        return;
    L5:
        r100 = "none";
        goto L6
    }

    @JvmStatic
    public static final void W(String r110, int r111, String r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "token");
        JSONObject r100 = new JSONObject();
        if (f233149c == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r110, r111, r101, r112, f233150d, f233151e, f233147a, f233148b, r113);
        if (r114 == false) goto L9;
        String r102 = "turn_on";
    L10:
        r100.put("click", r102);
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_share_public_access_click", r100);
        return;
    L9:
        r102 = "maybe_later";
        goto L10
    L5:
        r101 = "none";
        goto L6
    }

    @JvmStatic
    public static final void p(String r110, String r111, Boolean r112, Boolean r113, Integer r210) {
        Intrinsics.checkNotNullParameter(r110, "click");
        Intrinsics.checkNotNullParameter("none", PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r111, "changeType");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r100.put("click", r110);
        r100.put("change_type", r111);
        if (r112 == null) goto L9;
        r112.booleanValue();
        r100.put("is_success", r112.booleanValue());
    L9:
        if (r113 == null) goto L11;
        r113.booleanValue();
        r100.put("is_credential_stuffing", r113.booleanValue());
    L11:
        if (r210 == null) goto L13;
        r210.intValue();
        r100.put("error_code", r210.intValue());
    L13:
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_change_password_click", r100);
        return;
    L5:
        r103 = "none";
        goto L6
    }

    public static /* synthetic */ void q(String r100, String r101, Boolean r102, Boolean r103, int r104) {
        if ((r104 & 8) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 16) == 0) goto L8;
        r103 = null;
    L8:
        p(r100, r101, r102, r103, null);
    }

    @JvmStatic
    public static final void y(String r110, int r111, String r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r114, "from");
        JSONObject r100 = new JSONObject();
        if (f233149c == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r110, r111, r101, r112, f233150d, f233151e, f233147a, f233148b, r113);
        r100.put("from_scene", r114);
        c("ccm_permission_prompt_view", r100);
        return;
    L5:
        r101 = "none";
        goto L6
    }

    public static void A(String r110, int r111, String r112, boolean r113, String r114, String r115) {
        JSONObject r116 = new JSONObject();
        if (f233149c == false) goto L5;
        String r100 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r116, r110, r111, r100, r112, f233150d, f233151e, f233147a, f233148b, r113);
        r116.put("click", r114);
        r116.put(PickerReporterConstants.KEY.TARGET, r115);
        c("ccm_permission_organization_authorize_click", r116);
        return;
    L5:
        r100 = "none";
        goto L6
    }

    @JvmStatic
    public static final void B(boolean r110, String r111, boolean r112, int r113, boolean r114, int r115) {
        Intrinsics.checkNotNullParameter(r111, "openType");
        JSONObject r116 = new JSONObject();     // Catch: JSONException -> L21
        String r100 = f233152f;     // Catch: JSONException -> L21
        int r101 = f233153g;     // Catch: JSONException -> L21
        if (f233149c == false) goto L6;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L7:
        a(r116, r100, r101, r102, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);     // Catch: JSONException -> L21
        int r103 = 1;
        if (r110 == false) goto L10;
        int r104 = 1;
    L11:
        r116.put("is_successful", r104);     // Catch: JSONException -> L21
        r116.put("open_type", r111);     // Catch: JSONException -> L21
        if (r112 == false) goto L14;
        int r105 = 1;
    L15:
        r116.put("is_retry", r105);     // Catch: JSONException -> L21
        r116.put("source", r113);     // Catch: JSONException -> L21
        r116.put("error_code", r115);     // Catch: JSONException -> L21
        if (r114 == true) goto L19;
        r103 = 0;
    L19:
        r116.put("is_minutes", r103);     // Catch: JSONException -> L21
        c("ccm_permission_performance_share_open_finish_dev", r116);     // Catch: JSONException -> L21
        return;
    L14:
        r105 = 0;
        goto L15
    L10:
        r104 = 0;
        goto L11
    L6:
        r102 = "none";
    L21:
        e = move-exception;
        tt5.a.f("PermissionAnalyticV2", e, false);
    }

    public static void a0(String r110, int r111, String r112, boolean r113, String r114, String r115) {
        JSONObject r116 = new JSONObject();
        if (f233149c == false) goto L5;
        String r100 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r116, r110, r111, r100, r112, f233150d, f233151e, f233147a, f233148b, r113);
        r116.put("click", r114);
        r116.put(PickerReporterConstants.KEY.TARGET, r115);
        c("ccm_permission_dynamic_user_group_authorize_click", r116);
        return;
    L5:
        r100 = "none";
        goto L6
    }

    public static void e(String r110, int r111, String r112, boolean r113, String r114, String r115) {
        JSONObject r116 = new JSONObject();
        if (f233149c == false) goto L5;
        String r100 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r116, r110, r111, r100, r112, f233150d, f233151e, f233147a, f233148b, r113);
        r116.put("click", r114);
        r116.put(PickerReporterConstants.KEY.TARGET, r115);
        c("ccm_permission_add_collaborator_click", r116);
        return;
    L5:
        r100 = "none";
        goto L6
    }

    @JvmStatic
    public static final void u(String r110, int r111, String r112, boolean r113, boolean r114, String r115) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r115, "from");
        JSONObject r100 = new JSONObject();
        if (f233149c == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r110, r111, r101, r112, f233150d, f233151e, f233147a, f233148b, r113);
        if (r114 == false) goto L9;
        String r102 = "confirm";
    L10:
        r100.put("click", r102);
        r100.put("from_scene", r115);
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_prompt_click", r100);
        return;
    L9:
        r102 = "cancel";
        goto L10
    L5:
        r101 = "none";
        goto L6
    }

    @JvmStatic
    public static final void R(String r210, String r211, String r212, boolean r213, boolean r214, String r215, String r216) {
        Intrinsics.checkNotNullParameter(r210, "click");
        Intrinsics.checkNotNullParameter(r211, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r212, "securityId");
        Intrinsics.checkNotNullParameter(r215, "view_from");
        Intrinsics.checkNotNullParameter(r216, "security_type");
        JSONObject r110 = new JSONObject();
        String r111 = f233152f;
        int r112 = f233153g;
        if (f233149c == false) goto L5;
        String r100 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r110, r111, r112, r100, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r110.put("click", r210);
        r110.put(PickerReporterConstants.KEY.TARGET, r211);
        if (Intrinsics.areEqual(r212, "") == true) goto L9;
        r110.put("security_id", r212);
    L9:
        r110.put("is_security_demotion", r213);
        r110.put("is_single_apply", r214);
        r110.put("view_from", r215);
        r110.put("security_type", r216);
        c("ccm_permission_security_setting_click", r110);
        return;
    L5:
        r100 = "none";
        goto L6
    }

    @JvmStatic
    public static final void D(String r110, int r111, String r112, boolean r113, boolean r114, String r115, String r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "subType");
        Intrinsics.checkNotNullParameter(r115, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r116, "userPerm");
        Intrinsics.checkNotNullParameter(r117, "publicPerm");
        JSONObject r100 = new JSONObject();
        if (r113 == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r110, r111, r101, r112, r115, "", r116, r117, r114);
        r100.put("click", "back");
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        c("ccm_permission_unable_to_apply_click", r100);
        return;
    L5:
        r101 = "none";
        goto L6
    }

    @JvmStatic
    public static final void X(String r110, int r111, String r112, boolean r113, boolean r114, String r115, String r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "subType");
        Intrinsics.checkNotNullParameter(r115, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r116, "userPerm");
        Intrinsics.checkNotNullParameter(r117, "publicPerm");
        JSONObject r100 = new JSONObject();
        if (r113 == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r110, r111, r101, r112, r115, "", r116, r117, r114);
        c("ccm_permission_unable_to_apply_view", r100);
        return;
    L5:
        r101 = "none";
        goto L6
    }

    @JvmStatic
    public static final void h(String r110, int r111, String r112, boolean r113, boolean r114, String r115, String r116, String r210, String r211) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "subType");
        Intrinsics.checkNotNullParameter(r115, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r116, "userPerm");
        Intrinsics.checkNotNullParameter(r210, "publicPerm");
        Intrinsics.checkNotNullParameter(r211, "triggerReason");
        JSONObject r100 = new JSONObject();
        if (r113 == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r110, r111, r101, r112, r115, "", r116, r210, r114);
        r100.put("click", "back");
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        r100.put("trigger_reason", r211);
        c("ccm_permission_without_permission_click", r100);
        return;
    L5:
        r101 = "none";
        goto L6
    }

    @JvmStatic
    public static final void z(String r110, int r111, String r112, boolean r113, boolean r114, String r115, String r116, String r117, String r210) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "subType");
        Intrinsics.checkNotNullParameter(r115, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r116, "userPerm");
        Intrinsics.checkNotNullParameter(r117, "publicPerm");
        Intrinsics.checkNotNullParameter(r210, "triggerReason");
        JSONObject r100 = new JSONObject();
        if (r113 == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r110, r111, r101, r112, r115, "", r116, r117, r114);
        r100.put("trigger_reason", r210);
        c("ccm_permission_without_permission_view", r100);
        return;
    L5:
        r101 = "none";
        goto L6
    }

    @JvmStatic
    public static final void C(int r110, int r111, int r112, int r113, int r114, int r115, String r116, boolean r117, int r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r116, "openType");
        JSONObject r100 = new JSONObject();
        String r101 = f233152f;
        int r102 = f233153g;
        if (f233149c == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r101, r102, r103, f233154h, f233150d, f233151e, f233147a, f233148b, f233155i);
        r100.put("t1", r110);
        r100.put("t2", r111);
        r100.put("t3", r112);
        r100.put("t4", r113);
        r100.put("first_view_time", r114);
        r100.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r115);
        r100.put("open_type", r116);
        r100.put("is_retry", r117 ? 1 : 0);
        r100.put("source", r210);
        r100.put("is_minutes", r211 ? 1 : 0);
        c("ccm_permission_performance_share_open_time_dev", r100);
        return;
    L5:
        r103 = "none";
        goto L6
    }

    public static void a(JSONObject r100, String r101, int r102, String r103, String r104, String r105, String r106, String r110, String r111, boolean r112) {
        String r107 = sbb.e.c(r102);
        r100.put("file_id", du5.b.g(r101));
        r100.put("file_type", r107);
        r100.put("app_form", r103);
        Object r108 = "none";
        boolean r109 = false;
        if (r102 != sbb.e.f541301l.f541317b) goto L13;
        if (r104 != null) goto L6;
    L9:
        boolean r113 = true;
    L10:
        if (r113 == false) goto L12;
        r104 = "none";
    L12:
        r100.put("sub_file_type", r104);
        goto L13
    L6:
        if (r104.length() == 0) goto L9;
        r113 = false;
    L13:
        if (r112 == false) goto L15;
        r105 = sbb.e.f541303n.getType();
    L26:
        r100.put(EventConstant.Key.MODULE, r105);
        if (r106 != null) goto L29;
    L30:
        r109 = true;
    L31:
        if (r109 == false) goto L33;
        r106 = "none";
    L33:
        r100.put("sub_module", r106);
        if (r102 != sbb.e.f541295f.f541317b) goto L36;
        r100.put("user_permission_folder", r110);
        r100.put("folder_permission", r111);
    L38:
        if (r112 == false) goto L44;
        Object r114 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).f("docCommonParams", "container_id");
        if (r114 == null) goto L43;
        r108 = r114;
    L43:
        r100.put("container_id", r108);
    L45:
        if (r112 == false) goto L47;
        String r115 = "wiki";
    L48:
        r100.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r115);
        return;
    L47:
        r115 = DocumentType.FOLDER_NAME;
        goto L48
    L44:
        r100.put("container_id", "none");
        goto L45
    L36:
        r100.put("user_permission", r110);
        r100.put("file_permission", r111);
        goto L38
    L29:
        if (r106.length() != 0) goto L31;
    L15:
        if (r105 != null) goto L17;
    L22:
        boolean r116 = false;
    L23:
        if (r116 == true) goto L26;
        r105 = r107;
        goto L26
    L17:
        if (r105.length() <= 0) goto L19;
        boolean r117 = true;
    L20:
        if (r117 != true) goto L22;
        r116 = true;
        goto L23
    L19:
        r117 = false;
        goto L20
    }

    @JvmStatic
    public static final void i(String r110, int r111, String r112, boolean r113, boolean r114, String r115, String r210, String r211, int r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "subType");
        Intrinsics.checkNotNullParameter(r115, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r210, "userPerm");
        Intrinsics.checkNotNullParameter(r211, "publicPerm");
        Intrinsics.checkNotNullParameter(r214, "triggerReason");
        JSONObject r100 = new JSONObject();
        if (r113 == false) goto L5;
        String r101 = ThumbGlideUrl.SOURCE_VC;
    L6:
        a(r100, r110, r111, r101, r112, r115, "", r210, r211, r114);
        r100.put("click", "apply_permission");
        if (r212 != 1) goto L9;
    L12:
        String r102 = "read";
    L13:
        r100.put("apply_list", r102);
        if (r213 != null) goto L16;
    L19:
        boolean r103 = true;
    L20:
        r100.put("is_add_notes", !r103);
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        r100.put("trigger_reason", r214);
        c("ccm_permission_without_permission_click", r100);
        return;
    L16:
        if (r213.length() == 0) goto L19;
        r103 = false;
        goto L20
    L9:
        if (r212 != 4) goto L12;
        r102 = "edit";
        goto L13
    L5:
        r101 = "none";
        goto L6
    }
}
