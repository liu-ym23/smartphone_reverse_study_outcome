package com.bytedance.salamander.anniex;

import android.net.Uri;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larus.caijing_pay.impl.config.CJHostRouterServiceImpl;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXSL;", "", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public class AnnieXSL {
    public static final a Companion = null;
    private static boolean HDT_DISENABLE_SL;
    private static boolean HDT_ENABLE_SL;
    private static boolean HDT_IOS_DISENABLE_SL;
    private static boolean HDT_IOS_ENABLE_SL;
    private static String SETTINGS_KEY_CARD_BLOCK_LIST;
    private static String SETTINGS_KEY_CARD_WHITE_LIST;
    private static String SETTINGS_KEY_PAGE_BLOCK_LIST;
    private static String SETTINGS_KEY_PAGE_WHITE_LIST;
    private static String SETTINGS_KEY_POPUP_BLOCK_LIST;
    private static String SETTINGS_KEY_POPUP_WHITE_LIST;
    private static String TAG;

    public static final class a {
        public a() {
        }

        public static boolean a(String r110) {
            Intrinsics.checkNotNullParameter(r110, "schema");
            boolean r100 = true;
            if (AnnieXSL.access$getHDT_ENABLE_SL$cp() == false) goto L7;
            return true;
        L7:
            if (AnnieXSL.access$getHDT_DISENABLE_SL$cp() == false) goto L10;
            return false;
        L10:
            if (com.bytedance.rts.foundation.r.c(r110, "sslocal://webview") == false) goto L12;
        L15:
            boolean r101 = true;
        L17:
            if (com.bytedance.rts.foundation.r.c(r110, "aweme://webview") == false) goto L19;
        L22:
            boolean r102 = com.bytedance.rts.foundation.r.c(r110, "sslocal://polaris");     // Catch: Throwable -> L108
            if (r101 == true) goto L28;
            if (r100 == true) goto L28;
            if (r102 == true) goto L28;
            com.bytedance.anniex.bd.foundation.impl.c.f190141a.a(AnnieXSL.access$getTAG$cp(), "非授信 schema 协议: ".concat(r110));     // Catch: Throwable -> L108
            return false;
        L28:
            int r103 = q1.f268304a;     // Catch: Throwable -> L108
            String r104 = null;
            Object r105 = com.bytedance.ies.bullet.service.base.h.t0(AnnieXSL.access$getSETTINGS_KEY_PAGE_WHITE_LIST$cp());     // Catch: Throwable -> L32
        L33:
            ArrayList r106 = (ArrayList) r105;     // Catch: Throwable -> L108
            Object r107 = com.bytedance.ies.bullet.service.base.h.t0(AnnieXSL.access$getSETTINGS_KEY_PAGE_BLOCK_LIST$cp());     // Catch: Throwable -> L36
        L37:
            ArrayList r108 = (ArrayList) r107;     // Catch: Throwable -> L108
            Object r109 = com.bytedance.ies.bullet.service.base.h.t0(AnnieXSL.access$getSETTINGS_KEY_POPUP_WHITE_LIST$cp());     // Catch: Throwable -> L40
        L41:
            ArrayList r111 = (ArrayList) r109;     // Catch: Throwable -> L108
            Object r112 = com.bytedance.ies.bullet.service.base.h.t0(AnnieXSL.access$getSETTINGS_KEY_POPUP_BLOCK_LIST$cp());     // Catch: Throwable -> L44
        L45:
            ArrayList r113 = (ArrayList) r112;     // Catch: Throwable -> L108
            if (r106 != null) goto L48;
            r106 = new ArrayList();     // Catch: Throwable -> L108
        L48:
            if (r108 != null) goto L50;
            r108 = new ArrayList();     // Catch: Throwable -> L108
        L50:
            if (r111 != null) goto L52;
            r111 = new ArrayList();     // Catch: Throwable -> L108
        L52:
            if (r113 != null) goto L54;
            r113 = new ArrayList();     // Catch: Throwable -> L108
        L54:
            b2.f267974c.getClass();     // Catch: Throwable -> L108
            String r114 = b2.b(r110, "type");     // Catch: Throwable -> L108
            String r115 = b2.b(r110, "url");     // Catch: Throwable -> L108
            if (Intrinsics.areEqual(r115, "unknown") == false) goto L58;
            r115 = b2.b(r110, "surl");     // Catch: Throwable -> L108
        L58:
            if (Intrinsics.areEqual(r115, "unknown") == false) goto L61;
            com.bytedance.anniex.bd.foundation.impl.c.f190141a.a(AnnieXSL.access$getTAG$cp(), "主模板解析异常 url: ".concat(r115));     // Catch: Throwable -> L108
            return false;
        L61:
            String r116 = b2.b(r110, CJHostRouterServiceImpl.URI_KEY_MIX_CONTAINER_TYPE);     // Catch: Throwable -> L108
            if (Intrinsics.areEqual(r116, "unknown") == false) goto L64;
            r116 = b2.b(r115, CJHostRouterServiceImpl.URI_KEY_MIX_CONTAINER_TYPE);     // Catch: Throwable -> L108
        L64:
            int r117 = com.bytedance.anniex.bd.foundation.impl.u.f190155c;     // Catch: Throwable -> L108
            com.bytedance.anniex.bd.foundation.impl.u r118 = com.bytedance.anniex.bd.foundation.impl.u.a.a(r110);     // Catch: Throwable -> L108
            if (r118 == null) goto L67;
            String r119 = r118.b();     // Catch: Throwable -> L108
        L68:
            if (r118 == null) goto L74;
            Uri r120 = r118.f190156a;     // Catch: Throwable -> L108
            if (r120 == null) goto L74;
            r104 = r120.getPath();     // Catch: Throwable -> L108
        L74:
            if (Intrinsics.areEqual(r119, "polaris") == false) goto L83;
            if (r104 == null) goto L83;
            if (com.bytedance.rts.foundation.r.c(r104, ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L83;
            if (com.bytedance.rts.foundation.r.c(r104, "lynxview_popup") == true) goto L83;
            AnnieXSL.Companion.getClass();     // Catch: Throwable -> L108
            return b(r115, r116, r106, r108);
        L83:
            if (Intrinsics.areEqual(r119, "webview") == false) goto L85;
        L106:
            AnnieXSL.Companion.getClass();     // Catch: Throwable -> L108
            return b(r115, r116, r106, r108);
        L85:
            if (Intrinsics.areEqual(r119, ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == true) goto L106;
            if (Intrinsics.areEqual(r114, "fullscreen") == true) goto L106;
            if (Intrinsics.areEqual(r119, "polaris") == false) goto L97;
            if (r104 == null) goto L97;
            if (com.bytedance.rts.foundation.r.c(r104, "lynxview_popup") == false) goto L97;
            AnnieXSL.Companion.getClass();     // Catch: Throwable -> L108
            return b(r115, r116, r106, r108);
        L97:
            if (Intrinsics.areEqual(r119, AppConstants.HOST_WEBVIEW_DIALOG) == false) goto L99;
        L104:
            AnnieXSL.Companion.getClass();     // Catch: Throwable -> L108
            return b(r115, r116, r111, r113);
        L99:
            if (Intrinsics.areEqual(r119, "lynxview_popup") == true) goto L104;
            if (Intrinsics.areEqual(r114, "popup") == true) goto L104;
            return false;
        L67:
            r119 = null;
        L44:
            r112 = null;
        L40:
            r109 = null;
        L36:
            r107 = null;
        L32:
            r105 = null;
            goto L33
        L19:
            if (com.bytedance.rts.foundation.r.c(r110, "aweme://lynxview") == true) goto L22;
            r100 = false;
            goto L22
        L12:
            if (com.bytedance.rts.foundation.r.c(r110, "sslocal://lynxview") == true) goto L15;
            r101 = false;
        L108:
            th = move-exception;
            com.bytedance.anniex.bd.foundation.impl.c.f190141a.a(AnnieXSL.access$getTAG$cp(), "error msg:" + th.getMessage());
            return false;
        }

        public static boolean b(String r100, String r101, ArrayList r110, ArrayList r111) {
            if (com.bytedance.rts.foundation.j.d(r111) <= 0) goto L10;
            Iterator r112 = r111.iterator();
            boolean r102 = false;
        L6:
            if (r112.hasNext() == false) goto L11;
            String r103 = (String) r112.next();
            if (com.bytedance.rts.foundation.r.c(r100, r103) == false) goto L6;
            com.bytedance.anniex.bd.foundation.impl.c.f190141a.a(AnnieXSL.access$getTAG$cp(), "URL " + r100 + " 匹配命中黑名单 " + r103 + "，拒绝切换到 SL 模式");
            r102 = true;
        L11:
            if (r102 == false) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(r101, "sl") == false) goto L17;
            return true;
        L17:
            if (com.bytedance.rts.foundation.j.d(r110) <= 0) goto L24;
            Iterator r104 = r110.iterator();
            boolean r113 = false;
        L20:
            if (r104.hasNext() == false) goto L25;
            String r114 = (String) r104.next();
            if (com.bytedance.rts.foundation.r.c(r100, r114) == false) goto L20;
            com.bytedance.anniex.bd.foundation.impl.c.f190141a.a(AnnieXSL.access$getTAG$cp(), "URL " + r100 + " 匹配命中白名单 " + r114 + "，允许切换到 SL 模式");
            r113 = true;
        L25:
            if (r113 == false) goto L27;
            return true;
        L27:
            return false;
        L24:
            r113 = false;
            goto L25
        L10:
            r102 = false;
            goto L11
        }
    }

    static {
        Companion = new a();
        TAG = "AnnieXSL";
        SETTINGS_KEY_PAGE_WHITE_LIST = "anniex_sl_page_white_list";
        SETTINGS_KEY_PAGE_BLOCK_LIST = "anniex_sl_page_block_list";
        SETTINGS_KEY_POPUP_WHITE_LIST = "anniex_sl_popup_white_list";
        SETTINGS_KEY_POPUP_BLOCK_LIST = "anniex_sl_popup_block_list";
        SETTINGS_KEY_CARD_WHITE_LIST = "anniex_sl_card_white_list";
        SETTINGS_KEY_CARD_BLOCK_LIST = "anniex_sl_card_block_list";
    }

    public AnnieXSL() {
    }

    public static final /* synthetic */ boolean access$getHDT_DISENABLE_SL$cp() {
        return HDT_DISENABLE_SL;
    }

    public static final /* synthetic */ boolean access$getHDT_ENABLE_SL$cp() {
        return HDT_ENABLE_SL;
    }

    public static final /* synthetic */ boolean access$getHDT_IOS_DISENABLE_SL$cp() {
        return HDT_IOS_DISENABLE_SL;
    }

    public static final /* synthetic */ boolean access$getHDT_IOS_ENABLE_SL$cp() {
        return HDT_IOS_ENABLE_SL;
    }

    public static final /* synthetic */ String access$getSETTINGS_KEY_PAGE_BLOCK_LIST$cp() {
        return SETTINGS_KEY_PAGE_BLOCK_LIST;
    }

    public static final /* synthetic */ String access$getSETTINGS_KEY_PAGE_WHITE_LIST$cp() {
        return SETTINGS_KEY_PAGE_WHITE_LIST;
    }

    public static final /* synthetic */ String access$getSETTINGS_KEY_POPUP_BLOCK_LIST$cp() {
        return SETTINGS_KEY_POPUP_BLOCK_LIST;
    }

    public static final /* synthetic */ String access$getSETTINGS_KEY_POPUP_WHITE_LIST$cp() {
        return SETTINGS_KEY_POPUP_WHITE_LIST;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public static final /* synthetic */ void access$setHDT_IOS_DISENABLE_SL$cp(boolean r100) {
        HDT_IOS_DISENABLE_SL = r100;
    }

    public static final /* synthetic */ void access$setHDT_IOS_ENABLE_SL$cp(boolean r100) {
        HDT_IOS_ENABLE_SL = r100;
    }
}
