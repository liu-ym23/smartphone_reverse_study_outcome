package com.bytedance.ee.bear.more;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static void a(o r5) {
        JSONObject r0 = r5.a;
        r0.put("module", r5.d);     // Catch: JSONException -> L43
        r0.put("is_owner", String.valueOf(r5.b));     // Catch: JSONException -> L43
        r0.put("user_permission", r5.c);     // Catch: JSONException -> L43
        String r3 = "null";
        if (TextUtils.isEmpty(r5.e) == false) goto L7;
        r0.put("sub_module", "null");     // Catch: JSONException -> L43
    L10:
        if (TextUtils.isEmpty(r5.f) == false) goto L12;
        r0.put("file_id", "null");     // Catch: JSONException -> L43
    L13:
        int r1 = r5.g;     // Catch: JSONException -> L43
        if (r1 != sbb.e.e.b) goto L17;
        r0.put("file_type", "null");     // Catch: JSONException -> L43
    L20:
        if (TextUtils.isEmpty(r5.h) == false) goto L22;
        r0.put("sub_file_type", "null");     // Catch: JSONException -> L43
    L25:
        if (TextUtils.isEmpty(r5.i) == false) goto L27;
        r0.put("container_id", "null");     // Catch: JSONException -> L43
    L30:
        if (TextUtils.isEmpty(r5.j) == false) goto L32;
        r0.put("container_type", "null");     // Catch: JSONException -> L43
    L35:
        if (TextUtils.isEmpty(r5.k) == false) goto L37;
        r0.put("shortcut_id", "null");     // Catch: JSONException -> L43
        r0.put("is_shortcut", "false");     // Catch: JSONException -> L43
    L39:
        if (r5.l == false) goto L41;
        r3 = ThumbGlideUrl.SOURCE_VC;
    L41:
        r0.put("app_form", r3);     // Catch: JSONException -> L43
        return;
    L37:
        r0.put("shortcut_id", du5.b.g(r5.k));     // Catch: JSONException -> L43
        r0.put("is_shortcut", "true");     // Catch: JSONException -> L43
        goto L39
    L32:
        r0.put("container_type", r5.j);     // Catch: JSONException -> L43
        goto L35
    L27:
        r0.put("container_id", du5.b.g(r5.i));     // Catch: JSONException -> L43
        goto L30
    L22:
        r0.put("sub_file_type", r5.h);     // Catch: JSONException -> L43
        goto L25
    L17:
        r0.put("file_type", sbb.e.c(r1));     // Catch: JSONException -> L43
        goto L20
    L12:
        r0.put("file_id", du5.b.g(r5.f));     // Catch: JSONException -> L43
        goto L13
    L7:
        r0.put("sub_module", r5.e);     // Catch: JSONException -> L43
    L43:
        e = move-exception;
        tt5.a.d("MoreAnalytic", "addPublicParams()...error = " + e);
    }

    public static void c(i r23) {
        Bundle r1 = r23.a;
        JSONObject r15 = new JSONObject();
        boolean r16 = false;
        if (r1 != null) goto L58;
    L7:
        boolean r18 = false;
    L8:
        String r2 = null;
        if (r1 != null) goto L11;
        String r19 = null;
    L14:
        if (r1 == null) goto L16;
        r2 = r1.getString("current_sub_view", null);     // Catch: JSONException -> L26
    L16:
        String r13 = r2;
        if (r18 == false) goto L23;
        String r4 = r1.getString("module", "null");     // Catch: JSONException -> L26
        String r5 = r1.getString("sub_module", "null");     // Catch: JSONException -> L26
        String r3 = r1.getString("container_id", "");     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r3) == true) goto L21;
        String r6 = du5.b.g(r3);     // Catch: JSONException -> L26
    L22:
        String r12 = r1.getString("container_type", "null");     // Catch: JSONException -> L26
        String r11 = r6;
        String r7 = r4;
        String r8 = r5;
    L30:
        a(new o(r15, r23.n, r23.o, r7, r8, r23.b, r23.getType(), r23.e, r11, r12, r23.m, r23.l));     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r13) == true) goto L33;
        r15.put("current_sub_view", r13);     // Catch: JSONException -> L26
    L33:
        r15.put("click", r23.f);     // Catch: JSONException -> L26
        r15.put("target", r23.g);     // Catch: JSONException -> L26
        r15.put("view_from", "more");     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r23.h) == true) goto L37;
        r15.put("export_type", r23.h);     // Catch: JSONException -> L26
    L37:
        if (TextUtils.isEmpty(r23.i) == true) goto L40;
        r15.put("convert_type", r23.i);     // Catch: JSONException -> L26
    L40:
        if (TextUtils.isEmpty(r23.j) == true) goto L43;
        r15.put("lang", r23.j);     // Catch: JSONException -> L26
    L43:
        if (TextUtils.isEmpty(r23.p) == true) goto L46;
        r15.put("menu_level", r23.p);     // Catch: JSONException -> L26
    L46:
        if (r23.getType() != sbb.e.f.b) goto L48;
        r16 = true;
    L48:
        r15.put("is_folder", String.valueOf(r16));     // Catch: JSONException -> L26
        r15.put("is_shared_folder", String.valueOf(r23.d));     // Catch: JSONException -> L26
        if (TextUtils.isEmpty(r19) == false) goto L54;
        if (r18 == false) goto L53;
        r19 = "ccm_space_right_click_menu_click";
        goto L54
    L53:
        r19 = "ccm_space_docs_more_menu_click";
        r15.put("user_main_lang", String.valueOf(r23.q));     // Catch: JSONException -> L26
        r15.put("original_language", String.valueOf(r23.r));     // Catch: JSONException -> L26
        r15.put("user_default_lang", String.valueOf(r23.s));     // Catch: JSONException -> L26
    L54:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).i(r19, r15);     // Catch: JSONException -> L26
        return;
    L26:
        e = move-exception;
        tt5.a.d("MoreAnalytic", "reportSpaceMoreItemClick()...error = " + e);
        return;
    L21:
        r6 = "null";
        goto L22
    L23:
        int r9 = r23.getType();     // Catch: JSONException -> L26
        if (r23.k == false) goto L28;
        String r10 = DocumentType.WIKI_NAME;
    L29:
        r7 = r10;
        r8 = "null";
        r11 = r8;
        r12 = r11;
        goto L30
    L28:
        r10 = sbb.e.c(r9);     // Catch: JSONException -> L26
        goto L29
    L11:
        r19 = r1.getString("event_name", null);     // Catch: JSONException -> L26
        goto L14
    L58:
        if (r1.getInt("more_scene", -1) != 0) goto L7;
        r18 = true;
        goto L8
    }

    public static void b(oj5.c r6, String r7) {
        if (r6 == null) goto L21;
        AccountService.Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r0 != null) goto L6;
    L9:
        String r1 = "";
    L10:
        boolean r2 = !TextUtils.equals(r1, r6.a());
        HashMap r3 = new HashMap();
        r3.put("source", "innerpage_more");
        r3.put("file_id", du5.b.g(r6.getToken()));
        r3.put("file_type", sbb.e.c(r6.getType()));
        r3.put("action", r7);
        if (TextUtils.isEmpty(r6.getAppId()) == true) goto L14;
        r3.put("appid", r6.getAppId());
    L14:
        if (TextUtils.equals(r7, "rename") == false) goto L17;
        r3.put("file_is_cross_tenant", String.valueOf(r2));
        r3.put("file_tenant_id", du5.b.g(r6.a()));
    L17:
        if (TextUtils.equals(r7, "contact") == false) goto L19;
        String r8 = r6.a();
        String r4 = du5.b.g(r6.d());
        String r5 = du5.b.g(r6.t());
        r3.put("file_is_cross_tenant", String.valueOf(r2));
        r3.put("file_tenant_id", du5.b.g(r8));
        r3.put("create_uid", r4);
        r3.put("owner_id", r5);
        r3.put("is_owner", String.valueOf(r6.isOwner()));
    L19:
        tt5.a.b("MoreAnalytic", "more: reportMoreEvent, params = " + r3);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_content_management", r3);
        return;
    L6:
        if (TextUtils.isEmpty(r0.uid) == true) goto L9;
        r1 = r0.uid;
        goto L10
    }
}
