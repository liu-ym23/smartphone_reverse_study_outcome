package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class d {
    public static void a(Intent r100, Uri r101) {
        String r102 = UriProtector.getQueryParameter(r101, "hide_bar");
        boolean r103 = true;
        if (TextUtils.isEmpty(r102) == false) goto L129;
    L12:
        String r104 = UriProtector.getQueryParameter(r101, "hide_nav_bar");
        if (TextUtils.isEmpty(r104) == false) goto L125;
    L22:
        String r105 = UriProtector.getQueryParameter(r101, "hide_status_bar");
        if (TextUtils.isEmpty(r105) == false) goto L131;
    L30:
        String r106 = UriProtector.getQueryParameter(r101, "hide_back_button");
        if (TextUtils.isEmpty(r106) == false) goto L133;
    L40:
        String r107 = UriProtector.getQueryParameter(r101, "hide_back_btn");
        if (TextUtils.isEmpty(r107) == false) goto L121;
    L50:
        String r108 = UriProtector.getQueryParameter(r101, "back_button_color");
        if (TextUtils.isEmpty(r108) == true) goto L53;
        r100.putExtra("back_button_color", r108);
    L53:
        String r109 = UriProtector.getQueryParameter(r101, "back_button_icon");
        if (TextUtils.isEmpty(r109) == true) goto L56;
        r100.putExtra("back_button_icon", r109);
    L56:
        String r110 = UriProtector.getQueryParameter(r101, "back_button_position");
        if (TextUtils.isEmpty(r110) == true) goto L59;
        r100.putExtra("back_button_position", r110);
    L59:
        String r111 = UriProtector.getQueryParameter(r101, AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR);
        if (TextUtils.isEmpty(r111) == true) goto L62;
        r100.putExtra("status_bar_text_color", r111);
    L62:
        String r112 = UriProtector.getQueryParameter(r101, "status_bar_text_color");
        if (TextUtils.isEmpty(r112) == true) goto L65;
        r100.putExtra("status_bar_text_color", r112);
    L65:
        String r113 = UriProtector.getQueryParameter(r101, "status_bar_background");
        if (TextUtils.isEmpty(r113) == true) goto L68;
        r100.putExtra(AppConstants.BUNDLE_STATUS_BAR_BG_COLOR, r113);
    L68:
        String r114 = UriProtector.getQueryParameter(r101, AppConstants.BUNDLE_STATUS_BAR_BG_COLOR);
        if (TextUtils.isEmpty(r114) == true) goto L71;
        r100.putExtra(AppConstants.BUNDLE_STATUS_BAR_BG_COLOR, r114);
    L71:
        String r115 = UriProtector.getQueryParameter(r101, "webview_bg_color");
        if (TextUtils.isEmpty(r115) == true) goto L74;
        r100.putExtra("webview_bg_color", r115);
    L74:
        String r116 = UriProtector.getQueryParameter(r101, "soft_input_mode");
        if (TextUtils.isEmpty(r116) == true) goto L77;
        r100.putExtra("soft_input_mode", r116);
    L77:
        String r117 = UriProtector.getQueryParameter(r101, "page_keep_alive");
        if (TextUtils.isEmpty(r117) == false) goto L127;
    L87:
        String r118 = UriProtector.getQueryParameter(r101, "webview_text_zoom");
        if (TextUtils.isEmpty(r118) == true) goto L90;
        r100.putExtra("webview_text_zoom", r118);
    L90:
        String r119 = UriProtector.getQueryParameter(r101, "disableHistory");
        if (TextUtils.isEmpty(r119) == false) goto L123;
    L100:
        String r120 = UriProtector.getQueryParameter(r101, "title");
        if (TextUtils.isEmpty(r120) == true) goto L103;
        r100.putExtra("title", r120);
    L103:
        String r121 = UriProtector.getQueryParameter(r101, AppConstants.BUNDLE_USE_WEBVIEW_TITLE);
        if (TextUtils.isEmpty(r121) == false) goto L106;
    L108:
        boolean r122 = false;
    L109:
        if (r122 == false) goto L111;
        r100.putExtra(AppConstants.BUNDLE_USE_WEBVIEW_TITLE, r122);
    L111:
        String r123 = UriProtector.getQueryParameter(r101, "hide_more");
        if (TextUtils.isEmpty(r123) == false) goto L114;
    L116:
        r103 = false;
    L117:
        if (r103 == false) goto L119;
        r100.putExtra("hide_more", r103);
    L119:
        r100.putExtra("translucent_navigationbar", r101.getBooleanQueryParameter("translucent_navigationbar", false));
        r100.putExtra("hide_loading", r101.getBooleanQueryParameter("hide_loading", false));
        return;
    L114:
        if ("1".equals(r123) == false) goto L116;
    L106:
        if ("1".equals(r121) == false) goto L108;
        r122 = true;
        goto L109
    L123:
        int r124 = CastIntegerProtector.parseInt(r119);     // Catch: NumberFormatException -> L94
    L96:
        if (r124 <= 0) goto L98;
        boolean r125 = true;
    L99:
        r100.putExtra("disableHistory", r125);
        goto L100
    L98:
        r125 = false;
    L94:
        e = move-exception;
        e.printStackTrace();
        r124 = 0;
        goto L96
    L127:
        int r126 = CastIntegerProtector.parseInt(r117);     // Catch: NumberFormatException -> L81
    L83:
        if (r126 <= 0) goto L85;
        boolean r127 = true;
    L86:
        r100.putExtra("page_keep_alive", r127);
        goto L87
    L85:
        r127 = false;
    L81:
        e = move-exception;
        e.printStackTrace();
        r126 = 0;
        goto L83
    L121:
        int r128 = CastIntegerProtector.parseInt(r107);     // Catch: NumberFormatException -> L44
    L46:
        if (r128 <= 0) goto L48;
        boolean r129 = true;
    L49:
        r100.putExtra("hide_back_button", r129);
        goto L50
    L48:
        r129 = false;
    L44:
        e = move-exception;
        e.printStackTrace();
        r128 = 0;
        goto L46
    L133:
        int r130 = CastIntegerProtector.parseInt(r106);     // Catch: NumberFormatException -> L34
    L36:
        if (r130 <= 0) goto L38;
        boolean r131 = true;
    L39:
        r100.putExtra("hide_back_button", r131);
        goto L40
    L38:
        r131 = false;
    L34:
        e = move-exception;
        e.printStackTrace();
        r130 = 0;
        goto L36
    L131:
        int r132 = CastIntegerProtector.parseInt(r105);     // Catch: NumberFormatException -> L26
    L28:
        if (r132 <= 0) goto L30;
        r100.putExtra("hide_status_bar", true);
    L26:
        e = move-exception;
        e.printStackTrace();
        r132 = 0;
        goto L28
    L125:
        int r133 = CastIntegerProtector.parseInt(r104);     // Catch: NumberFormatException -> L16
    L18:
        if (r133 <= 0) goto L20;
        boolean r134 = true;
    L21:
        r100.putExtra("hide_bar", r134);
        goto L22
    L20:
        r134 = false;
    L16:
        e = move-exception;
        e.printStackTrace();
        r133 = 0;
        goto L18
    L129:
        int r135 = CastIntegerProtector.parseInt(r102);     // Catch: NumberFormatException -> L6
    L8:
        if (r135 <= 0) goto L10;
        boolean r136 = true;
    L11:
        r100.putExtra("hide_bar", r136);
        goto L12
    L10:
        r136 = false;
    L6:
        e = move-exception;
        e.printStackTrace();
        r135 = 0;
        goto L8
    }

    public static Intent b(Context r100, String r101) {
        StringBuilder r102 = new StringBuilder("packageName = ");
        r102.append(r101);
        r102.append(", context is null: ");
        if (r100 != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        a.c("BrowserUtils", r102.toString());
        if (r100 != null) goto L9;
    L20:
        return null;
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        Intent r104 = r100.getPackageManager().getLaunchIntentForPackage(r101);
        if (r104 != null) goto L16;
        a.c("BrowserUtils", "getLaunchIntentForPackage intent is null");
        return null;
    L16:
        if (r104.hasCategory("android.intent.category.LAUNCHER") == true) goto L18;
        r104.addCategory("android.intent.category.LAUNCHER");
    L18:
        r104.setPackage(null);
        r104.addFlags(2097152);
        r104.addFlags(268435456);
        return r104;
    L5:
        r103 = false;
        goto L6
    }
}
