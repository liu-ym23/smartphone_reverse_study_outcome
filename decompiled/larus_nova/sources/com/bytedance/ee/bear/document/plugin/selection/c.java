package com.bytedance.ee.bear.document.plugin.selection;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public abstract class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f220921f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f220922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f220923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f220924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f220925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<MenuItem, Intent> f220926e;

    static {
        f220921f = new String[]{AppConstants.TOUTIAO_PKG_NAME, "com.ss.android.article.lite", "com.qihoo.browser", "com.netease.newsreader.activity", "com.UCMobile", "com.hipu.yidian", "com.sina.news", "com.tencent.mtt"};
    }

    public c(ChameleonWebView r100) {
        this.f220926e = new LinkedHashMap();
        this.f220922a = r100;
        this.f220923b = 6767772;
        this.f220924c = "SelectionNewBase";
    }

    public static List b(Context r210, Intent r211, PackageManager r212) {
        ArrayList r100 = new ArrayList();
        List<ResolveInfo> r101 = r212.queryIntentActivities(r211, 0);
        if (r101 != null) goto L5;
    L49:
        return r100;
    L5:
        if (r101.size() <= 0) goto L49;
        Iterator<ResolveInfo> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L49;
        ResolveInfo r103 = r102.next();
        ActivityInfo r104 = r103.activityInfo;
        if (r104.exported == false) goto L45;
        String r105 = r104.permission;
        if (r105 == null) goto L46;
        Boolean r106 = Boolean.TRUE;
        if (Build.VERSION.SDK_INT < 23) goto L41;
        ArrayList r107 = new ArrayList();
        Object[] r110 = {r105};
        f06.b r111 = new f06.b("auto_cert_com_bytedance_ee_bear_document_plugin_selection_IntentItemManager_android_content_Context_checkSelfPermission");
        g06.a r108 = ApiHookConfig.f245611b.get(102608);
        if (r108 == null) goto L20;
        f06.a[] r109 = r108.f479473i;
    L21:
        f06.a[] r112 = r109;
        int r113 = r112.length;
        int r114 = 0;
    L23:
        if (r114 >= r113) goto L30;
        f06.a r115 = r112[r114];
        int r116 = r114;
        int r213 = r113;
        f06.a[] r214 = r112;
        f06.b r215 = r111;
        f06.d r117 = r115.preInvoke(102608, "android/content/Context", "checkSelfPermission", r210, r110, "int", r111);     // Catch: Exception -> L50
        if (r117.f474982a == true) goto L32;
        r107.add(r115);     // Catch: Exception -> L50
    L32:
        if (r117.f474982a == false) goto L34;
        int r118 = ((Integer) r117.f474983b).intValue();
    L35:
        if (r118 != 0) goto L37;
        boolean r119 = true;
    L38:
        r106 = Boolean.valueOf(r119);
        goto L41
    L37:
        r119 = false;
        goto L38
    L34:
        r118 = r210.checkSelfPermission(r105);
    L29:
        r114 = r116 + 1;
        r113 = r213;
        r112 = r214;
        r111 = r215;
        goto L23
    L30:
        r117 = new f06.d(false, null);
        goto L32
    L20:
        r109 = ApiHookConfig.f245613d;
    L41:
        if (r106.booleanValue() == true) goto L46;
        if (r103.activityInfo.permission != null) goto L45;
    L46:
        boolean r120 = true;
    L47:
        if (r120 == false) goto L8;
        r100.add(r103);
    L45:
        r120 = false;
        goto L47
    }

    public final void a(Menu r100, ResolveInfo r101, int r102, PackageManager r103) {
        MenuItem r104 = r100.add(this.f220923b, 0, this.f220925d + r102, r101.loadLabel(r103));
        Intent r105 = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", true).addFlags(268435456);
        ActivityInfo r106 = r101.activityInfo;
        Intent r107 = r105.setClassName(r106.packageName, r106.name);
        this.f220926e.put(r104, r107);
    }
}
