package com.bytedance.lynx.webview.adblock;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.lynx.webview.internal.EventStatistics;
import com.bytedance.lynx.webview.internal.EventType;
import com.bytedance.lynx.webview.internal.Setting;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import l17.k;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile b f265058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile b f265059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile b f265060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile b f265061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile b f265062e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f265063a = null;

        static {
            f265063a = new c();
        }
    }

    public c() {
        k.d(new String[]{"TTAdblockInterceptor"});
        this.f265060c = TTAdblockEngineFactory.a("sys_js_implicit_", Setting.c().g("scc_block_rules_implicit"));
        this.f265061d = TTAdblockEngineFactory.a("sys_ad_whitelist_", Setting.c().g("scc_whitelist_rules"));
        boolean r100 = false;
        boolean r101 = Setting.c().b("sdk_enable_scc_adblock_js", false);
        if (r101 == false) goto L10;
        this.f265059b = TTAdblockEngineFactory.a("sys_js_block_", Setting.c().g("scc_adblock_js_2"));
        EventType r102 = EventType.ADBLOCK_PARSE_RULES_FROM_SETTING;
        if (this.f265059b == null) goto L7;
        boolean r103 = true;
    L8:
        EventStatistics.e(r102, Boolean.valueOf(r103));
        goto L10
    L7:
        r103 = false;
    L10:
        if (Setting.c().b("scc_cs_sys_enable", false) == false) goto L12;
        this.f265062e = TTAdblockEngineFactory.a("sys_cs_whitelist_", Setting.c().g("scc_cs_white_list"));
    L12:
        EventStatistics.a("scc_adblock_js_switch", Boolean.valueOf(r101));
        if (this.f265059b == null) goto L15;
        r100 = true;
    L15:
        EventStatistics.a("scc_parse_setting_rules", Boolean.valueOf(r100));
    }

    public static TTAdblockEngineFactory.ResourceType b(WebResourceRequest r100, String r101) {
        String r102 = r100.getRequestHeaders().get("Resource-Type");
        if (TextUtils.isEmpty(r102) == true) goto L10;
        int r103 = CastIntegerProtector.parseInt(r102);
        if (r103 < TTAdblockEngineFactory.ResourceType.kMainFrame.getValue()) goto L10;
        if (r103 > TTAdblockEngineFactory.ResourceType.kNavigationPreload.getValue()) goto L10;
        return TTAdblockEngineFactory.ResourceType.getType(r103);
    L10:
        Uri r104 = r100.getUrl();
        if (r101 == null) goto L47;
        if (r101.equals(r104.toString()) == true) goto L47;
        TTAdblockEngineFactory.ResourceType r105 = TTAdblockEngineFactory.ResourceType.kSubResource;
        String r106 = r104.getPath();
        if (r106 == null) goto L48;
        String r107 = r106.toLowerCase();
        if (r107.endsWith(EffectConstants.GIF_FILE_SUFFIX) == false) goto L21;
        return TTAdblockEngineFactory.ResourceType.kImage;
    L21:
        if (r107.endsWith(".js") == true) goto L55;
        if (r107.endsWith(".php") == true) goto L55;
        if (r107.endsWith(".jss") == true) goto L55;
        if (r107.endsWith(".css") == false) goto L31;
        return TTAdblockEngineFactory.ResourceType.kStylesheet;
    L31:
        if (r107.endsWith(".html") == false) goto L37;
        if (r101.equals(r104.toString()) == false) goto L52;
        return TTAdblockEngineFactory.ResourceType.kMainFrame;
    L52:
        return TTAdblockEngineFactory.ResourceType.kSubFrame;
    L37:
        if (r107.endsWith(".jpg") == true) goto L54;
        if (r107.endsWith(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == true) goto L54;
        if (r107.endsWith(".jpeg") == true) goto L54;
        if (r107.endsWith(".bmp") == true) goto L54;
        return r105;
    L54:
        return TTAdblockEngineFactory.ResourceType.kImage;
    L55:
        return TTAdblockEngineFactory.ResourceType.kScript;
    L48:
        return r105;
    L47:
        return TTAdblockEngineFactory.ResourceType.kMainFrame;
    }

    public final synchronized boolean a(String r100, String r101) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f265062e != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean r102 = this.f265062e.a(r100, r101, TTAdblockEngineFactory.ResourceType.kMainFrame);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    }
}
