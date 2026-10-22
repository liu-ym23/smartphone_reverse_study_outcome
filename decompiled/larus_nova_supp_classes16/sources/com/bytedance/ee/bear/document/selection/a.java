package com.bytedance.ee.bear.document.selection;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a {
    public static final String[] f = null;
    public final WebView a;
    public final int b;
    public final String c;
    public int d;
    public final LinkedHashMap<MenuItem, Intent> e;

    static {
        f = new String[]{"com.ss.android.article.news", "com.ss.android.article.lite", "com.qihoo.browser", "com.netease.newsreader.activity", "com.UCMobile", "com.hipu.yidian", "com.sina.news", "com.tencent.mtt"};
    }

    public final Boolean c(MenuItem r4) {
        tt5.a.b(this.c, "jsClearSelectionExcludeCursor");
        ap5.a.a(this.a, "javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
        Intent r5 = this.e.get(r4);
        c r0 = (c) this;
        if (r5 != null) goto L15;
    L12:
        boolean r6 = false;
    L14:
        return Boolean.valueOf(r6);
    L15:
    L10:
        e = move-exception;
        iu5.d.a("ProcessTextIntentItemManager", e);
        goto L12
    L5:
        if (r5.getAction().equals("android.intent.action.WEB_SEARCH") == false) goto L7;
        String r1 = "query";
    L8:
        r5.putExtra(r1, r0.g);     // Catch: SecurityException -> L10
        r0.a.getContext().startActivity(r5);     // Catch: SecurityException -> L10
        r6 = true;
        goto L14
    L7:
        r1 = "android.intent.extra.PROCESS_TEXT";
        goto L8
    }

    public a(WebView r2, String r3) {
        this.e = new LinkedHashMap();
        this.a = r2;
        this.b = 6767772;
        this.c = r3;
    }

    public static List b(Context r23, Intent r24, PackageManager r26) {
        ArrayList r0 = new ArrayList();
        List<ResolveInfo> r2 = r26.queryIntentActivities(r24, 0);
        if (r2 != null) goto L5;
    L49:
        return r0;
    L5:
        if (r2.size() <= 0) goto L49;
        Iterator<ResolveInfo> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L49;
        ResolveInfo r4 = r3.next();
        ActivityInfo r5 = r4.activityInfo;
        if (r5.exported == false) goto L45;
        String r6 = r5.permission;
        if (r6 == null) goto L46;
        Boolean r7 = Boolean.TRUE;
        if (Build.VERSION.SDK_INT < 23) goto L41;
        ArrayList r8 = new ArrayList();
        Object[] r16 = {r6};
        f06.b r14 = new f06.b("auto_cert_com_bytedance_ee_bear_document_selection_IntentItemManager_android_content_Context_checkSelfPermission");
        g06.a r9 = (g06.a) ApiHookConfig.b.get(102608);
        if (r9 == null) goto L20;
        f06.a[] r10 = r9.i;
    L21:
        f06.a[] r13 = r10;
        int r12 = r13.length;
        int r11 = 0;
    L23:
        if (r11 >= r12) goto L30;
        f06.a r17 = r13[r11];
        int r19 = r11;
        int r20 = r12;
        f06.a[] r21 = r13;
        f06.b r22 = r14;
        f06.d r18 = r17.preInvoke(102608, "android/content/Context", "checkSelfPermission", r23, r16, "int", r14);     // Catch: Exception -> L50
        if (r18.a == true) goto L32;
        r8.add(r17);     // Catch: Exception -> L50
    L32:
        if (r18.a == false) goto L34;
        int r27 = ((Integer) r18.b).intValue();
    L35:
        if (r27 != 0) goto L37;
        boolean r28 = true;
    L38:
        r7 = Boolean.valueOf(r28);
        goto L41
    L37:
        r28 = false;
        goto L38
    L34:
        r27 = r23.checkSelfPermission(r6);
    L29:
        r11 = r19 + 1;
        r12 = r20;
        r13 = r21;
        r14 = r22;
        goto L23
    L30:
        r18 = new f06.d(false, null);
        goto L32
    L20:
        r10 = ApiHookConfig.d;
    L41:
        if (r7.booleanValue() == true) goto L46;
        if (r4.activityInfo.permission != null) goto L45;
    L46:
        boolean r29 = true;
    L47:
        if (r29 == false) goto L8;
        r0.add(r4);
    L45:
        r29 = false;
        goto L47
    }

    public final void a(Menu r3, ResolveInfo r4, int r5, PackageManager r6) {
        MenuItem r7 = r3.add(this.b, 0, this.d + r5, r4.loadLabel(r6));
        Intent r8 = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", true).addFlags(268435456);
        ActivityInfo r9 = r4.activityInfo;
        Intent r10 = r8.setClassName(r9.packageName, r9.name);
        this.e.put(r7, r10);
    }
}
