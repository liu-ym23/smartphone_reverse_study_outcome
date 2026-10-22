package com.bytedance.ee.bear.more;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class c {
    public static void a(o r100) {
        JSONObject r101 = r100.f234666a;
        r101.put(EventConstant.Key.MODULE, r100.f234669d);     // Catch: JSONException -> L43
        r101.put("is_owner", String.valueOf(r100.f234667b));     // Catch: JSONException -> L43
        r101.put("user_permission", r100.f234668c);     // Catch: JSONException -> L43
        String r102 = "null";
        if (TextUtils.isEmpty(r100.f234670e) == false) goto L7;
        r101.put("sub_module", "null");     // Catch: JSONException -> L43
    L10:
        if (TextUtils.isEmpty(r100.f234671f) == false) goto L12;
        r101.put("file_id", "null");     // Catch: JSONException -> L43
    L13:
        int r103 = r100.f234672g;     // Catch: JSONException -> L43
        if (r103 != sbb.e.f541294e.f541317b) goto L17;
        r101.put("file_type", "null");     // Catch: JSONException -> L43
    L20:
        if (TextUtils.isEmpty(r100.f234673h) == false) goto L22;
        r101.put("sub_file_type", "null");     // Catch: JSONException -> L43
    L25:
        if (TextUtils.isEmpty(r100.f234674i) == false) goto L27;
        r101.put("container_id", "null");     // Catch: JSONException -> L43
    L30:
        if (TextUtils.isEmpty(r100.f234675j) == false) goto L32;
        r101.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, "null");     // Catch: JSONException -> L43
    L35:
        if (TextUtils.isEmpty(r100.f234676k) == false) goto L37;
        r101.put("shortcut_id", "null");     // Catch: JSONException -> L43
        r101.put("is_shortcut", "false");     // Catch: JSONException -> L43
    L39:
        if (r100.f234677l == false) goto L41;
        r102 = ThumbGlideUrl.SOURCE_VC;
    L41:
        r101.put("app_form", r102);     // Catch: JSONException -> L43
        return;
    L37:
        r101.put("shortcut_id", du5.b.g(r100.f234676k));     // Catch: JSONException -> L43
        r101.put("is_shortcut", "true");     // Catch: JSONException -> L43
        goto L39
    L32:
        r101.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r100.f234675j);     // Catch: JSONException -> L43
        goto L35
    L27:
        r101.put("container_id", du5.b.g(r100.f234674i));     // Catch: JSONException -> L43
        goto L30
    L22:
        r101.put("sub_file_type", r100.f234673h);     // Catch: JSONException -> L43
        goto L25
    L17:
        r101.put("file_type", sbb.e.c(r103));     // Catch: JSONException -> L43
        goto L20
    L12:
        r101.put("file_id", du5.b.g(r100.f234671f));     // Catch: JSONException -> L43
        goto L13
    L7:
        r101.put("sub_module", r100.f234670e);     // Catch: JSONException -> L43
    L43:
        e = move-exception;
        tt5.a.d("MoreAnalytic", "addPublicParams()...error = " + e);
    }

    public static void c(i r210) {
        Bundle r100 = r210.f234563a;
        JSONObject r110 = new JSONObject();
        boolean r111 = false;
        if (r100 != null) goto L58;
    L7:
        boolean r112 = false;
    L8:
        String r101 = null;
        if (r100 != null) goto L11;
        String r113 = null;
    L14:
        if (r100 == null) goto L16;
        r101 = r100.getString("current_sub_view", null);     // Catch: JSONException -> L26
    L16:
        String r114 = r101;
        if (r112 == false) goto L23;
        String r102 = r100.getString(EventConstant.Key.MODULE, "null");     // Catch: JSONException -> L26
        String r103 = r100.getString("sub_module", "null");     // Catch: JSONException -> L26
        String r104 = r100.getString("container_id", "");     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r104) == true) goto L21;
        String r105 = du5.b.g(r104);     // Catch: JSONException -> L26
    L22:
        String r115 = r100.getString(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, "null");     // Catch: JSONException -> L26
        String r116 = r105;
        String r106 = r102;
        String r107 = r103;
    L30:
        a(new o(r110, r210.f234576n, r210.f234577o, r106, r107, r210.f234564b, r210.getType(), r210.f234567e, r116, r115, r210.f234575m, r210.f234574l));     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r114) == true) goto L33;
        r110.put("current_sub_view", r114);     // Catch: JSONException -> L26
    L33:
        r110.put("click", r210.f234568f);     // Catch: JSONException -> L26
        r110.put(PickerReporterConstants.KEY.TARGET, r210.f234569g);     // Catch: JSONException -> L26
        r110.put("view_from", "more");     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r210.f234570h) == true) goto L37;
        r110.put("export_type", r210.f234570h);     // Catch: JSONException -> L26
    L37:
        if (TextUtils.isEmpty(r210.f234571i) == true) goto L40;
        r110.put("convert_type", r210.f234571i);     // Catch: JSONException -> L26
    L40:
        if (TextUtils.isEmpty(r210.f234572j) == true) goto L43;
        r110.put(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, r210.f234572j);     // Catch: JSONException -> L26
    L43:
        if (TextUtils.isEmpty(r210.f234578p) == true) goto L46;
        r110.put("menu_level", r210.f234578p);     // Catch: JSONException -> L26
    L46:
        if (r210.getType() != sbb.e.f541295f.f541317b) goto L48;
        r111 = true;
    L48:
        r110.put("is_folder", String.valueOf(r111));     // Catch: JSONException -> L26
        r110.put("is_shared_folder", String.valueOf(r210.f234566d));     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r113) == false) goto L54;
        if (r112 == false) goto L53;
        r113 = "ccm_space_right_click_menu_click";
        goto L54
    L53:
        r113 = "ccm_space_docs_more_menu_click";
        r110.put("user_main_lang", String.valueOf(r210.f234579q));     // Catch: JSONException -> L26
        r110.put("original_language", String.valueOf(r210.f234580r));     // Catch: JSONException -> L26
        r110.put("user_default_lang", String.valueOf(r210.f234581s));     // Catch: JSONException -> L26
    L54:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).i(r113, r110);     // Catch: JSONException -> L26
        return;
    L26:
        e = move-exception;
        tt5.a.d("MoreAnalytic", "reportSpaceMoreItemClick()...error = " + e);
        return;
    L21:
        r105 = "null";
        goto L22
    L23:
        int r108 = r210.getType();     // Catch: JSONException -> L26
        if (r210.f234573k == false) goto L28;
        String r109 = "wiki";
    L29:
        r106 = r109;
        r107 = "null";
        r116 = r107;
        r115 = r116;
        goto L30
    L28:
        r109 = sbb.e.c(r108);     // Catch: JSONException -> L26
        goto L29
    L11:
        r113 = r100.getString(ReportCardMonitorPlugin.EVENT_NAME, null);     // Catch: JSONException -> L26
        goto L14
    L58:
        if (r100.getInt("more_scene", -1) != 0) goto L7;
        r112 = true;
        goto L8
    }

    public static void b(oj5.c r100, String r101) {
        if (r100 == null) goto L21;
        AccountService$Account r102 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r102 != null) goto L6;
    L9:
        String r103 = "";
    L10:
        boolean r104 = !TextUtils.equals(r103, r100.a());
        HashMap r105 = new HashMap();
        r105.put("source", "innerpage_more");
        r105.put("file_id", du5.b.g(r100.getToken()));
        r105.put("file_type", sbb.e.c(r100.getType()));
        r105.put("action", r101);
        if (TextUtils.isEmpty(r100.getAppId()) == true) goto L14;
        r105.put("appid", r100.getAppId());
    L14:
        if (TextUtils.equals(r101, "rename") == false) goto L17;
        r105.put("file_is_cross_tenant", String.valueOf(r104));
        r105.put("file_tenant_id", du5.b.g(r100.a()));
    L17:
        if (TextUtils.equals(r101, "contact") == false) goto L19;
        String r106 = r100.a();
        String r107 = du5.b.g(r100.d());
        String r108 = du5.b.g(r100.t());
        r105.put("file_is_cross_tenant", String.valueOf(r104));
        r105.put("file_tenant_id", du5.b.g(r106));
        r105.put("create_uid", r107);
        r105.put("owner_id", r108);
        r105.put("is_owner", String.valueOf(r100.isOwner()));
    L19:
        tt5.a.b("MoreAnalytic", "more: reportMoreEvent, params = " + r105);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_content_management", r105);
        return;
    L6:
        if (TextUtils.isEmpty(r102.uid) == true) goto L9;
        r103 = r102.uid;
        goto L10
    }
}
