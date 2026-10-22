package com.larus.settings.ivy;

import com.bytedance.news.common.settings.SettingsManager;
import com.larus.common.apphost.AppHost;
import com.larus.network.HttpConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f368543a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<String> f368544b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f368545c = null;

    static {
        HttpConst.f359979a.getClass();
        String r110 = HttpConst.f360029z;
        String r111 = HttpConst.A;
        ArrayList<String> r100 = CollectionsKt.arrayListOf(new String[]{"alice-boe", "gracebot.cn", "oceancloudapi.com", "boe-lingo.byteintl.net", "chatwiz.online", "cashier-my4a.pipopay.com", "cashier-my.pipopay.com", "f-p.sgsnssdk.com", r110, r111});
        String r101 = HttpConst.B;
        if (r101 != null) goto L5;
    L8:
        boolean r112 = true;
    L9:
        if (r112 == true) goto L11;
        r100.add(r101);
    L11:
        r100.add("doubao.com");
        if ("".length() != 0) goto L14;
        boolean r113 = true;
    L15:
        if (r113 == true) goto L17;
        r100.add("");
    L17:
        f368543a = r100;
        AppHost.Companion r114 = AppHost.f326268a;
        if (r114.isOversea() == true) goto L28;
        r100 = CollectionsKt.arrayListOf(new String[]{"alice-boe.bytedance.net", "oceancloudapi.com", "gracebot.cn", "doubao.com", "toutiao.com", "app.aisdk.gecko.local", "ots-boe.bytedance.net", "bots.bytedance.net", "bots.byteintl.net", "www.coze.cn", "www.coze.com", "lf-doubao-cdn-tos.bytegecko.com", "activity.doubao.com", "miaoda.feishu.cn", r110, r111});
        if (r101 != null) goto L22;
    L25:
        boolean r102 = true;
    L26:
        if (r102 == true) goto L28;
        r100.add(r101);
        goto L28
    L22:
        if (r101.length() == 0) goto L25;
        r102 = false;
    L28:
        f368544b = r100;
        if (r114.isOversea() == true) goto L31;
        List<String> r103 = CollectionsKt.listOf(new String[]{HttpConst.f359983c, HttpConst.f359985d, "bytedance.com", "toutiao.com"});
    L32:
        f368545c = r103;
        return;
    L31:
        r103 = CollectionsKt.listOf(new String[]{HttpConst.f359983c, HttpConst.f359985d});
        goto L32
    L14:
        r113 = false;
        goto L15
    L5:
        if (r101.length() == 0) goto L8;
        r112 = false;
        goto L9
    }

    public static a a() {
        return ((IHybridSettings) SettingsManager.obtain(IHybridSettings.class)).hybridCommonConfig();
    }
}
