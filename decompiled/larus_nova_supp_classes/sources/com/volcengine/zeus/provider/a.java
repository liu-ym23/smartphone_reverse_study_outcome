package com.volcengine.zeus.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.g;
import com.volcengine.zeus.log.ZeusLogger;
import f06.b;
import f06.c;
import f06.d;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class a {
    public a() {
    }

    public static Uri a(Uri r1, String r2) {
        if (ContentProviderManager.getInstance().isPluginProvider(r1) == false) goto L6;
        Uri r3 = a(r2, r1);
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#buildProxyUri-->proxyUri=" + r3);
        return r3;
    L6:
        return r1;
    }

    private static Uri a(String r1, Uri r2) {
        return a(r1, r2, null);
    }

    public static Uri a(String r6, Uri r7, String r8) {
        boolean r0 = Zeus.loadOrAwaitLoad(r6, g.c);
        ContentProviderManager r1 = ContentProviderManager.getInstance();
        if (r7 == null) goto L5;
        String r2 = r7.getAuthority();
    L6:
        String r3 = r1.getPluginProcessNameByAuthority(r2);
        String r4 = XmlPullParser.NO_NAMESPACE;
        String r5 = null;
        if (r6 == null) goto L19;
        if (TextUtils.isEmpty(r6) == true) goto L19;
        JSONObject r9 = new JSONObject();
        r9.put(ContentProviderManager.PLUGIN_PROCESS_NAME, r3);     // Catch: Throwable -> L38
        r9.put(ContentProviderManager.PLUGIN_PKG_NAME, r6);     // Catch: Throwable -> L38
        if (r7 == null) goto L15;
        String r10 = r7.toString();     // Catch: Throwable -> L38
    L16:
        r9.put(ContentProviderManager.PROVIDER_URI, r10);     // Catch: Throwable -> L38
        goto L17
    L15:
        r10 = XmlPullParser.NO_NAMESPACE;
    L17:
        r5 = r9.toString();
    L19:
        if (TextUtils.isEmpty(r5) == true) goto L22;
        r4 = Base64.encodeToString(r5.getBytes(), 10);
    L22:
        ContentProviderManager.c r11 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(r3);
        if (r11 != null) goto L36;
        if (r7 == null) goto L27;
        r8 = r7.getAuthority();
    L27:
        if (r0 == true) goto L30;
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "Plugin load failed, skip provider proxy uri building. pluginPkg=" + r6 + ", pluginAuthority=" + r8);
        return Uri.EMPTY;
    L30:
        String r12 = "cannot find systemProviderInfo, processName=" + r3 + ", pluginPkg=" + r6 + ", pluginAuthority=" + r8 + ", pluginUri=" + r7 + ", systemProviderInfoMapKeys=" + String.valueOf(ContentProviderManager.getInstance().getSystemProviderInfoMap().keySet());
        if (GlobalParam.getInstance().isDebug() == true) goto L35;
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, r12);
        return Uri.EMPTY;
    L35:
        throw new IllegalArgumentException(r12);
    L36:
        Uri r13 = UriProtector.parse("content://" + r11.b + File.separator + "proxy?provider_params=" + r4);
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "进程[processName=" + r3 + "] build provider 【 uri:" + r13 + " 】");
        return r13;
    L5:
        r2 = r8;
        goto L6
    }

    private static int com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(ContentResolver r18, Uri r19, Bundle r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240019);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240019, "android/content/ContentResolver", "delete", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.delete(r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static Uri com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(ContentResolver r18, Uri r19, ContentValues r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (Uri) r4.b;
    L21:
        return r18.insert(r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static String a(ContentResolver r2, Uri r3, String r4) {
        if (r2 != null) goto L14;
        return null;
    L14:
        return r2.getType(a(r3, r4));
    L9:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute getType !!!");     // Catch: Throwable -> L11
        return r2.getType(r3);
    L7:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#getType throw exception:", e);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#getType throw exception:", th);
        goto L13
    }

    public static int a(ContentResolver r3, Uri r4, Bundle r5, String r6) {
        if (r3 != null) goto L16;
        return -1;
    L16:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(r3, a(r4, r6), r5);
    L11:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");     // Catch: Throwable -> L13
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(r3, r4, r5);
    L9:
        e = e;
    L10:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
    L15:
        return -1;
    L7:
        e = e;
    L13:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
        goto L15
    }

    private static int com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(ContentResolver r18, Uri r19, String r20, String[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20, r21};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240019);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240019, "android/content/ContentResolver", "delete", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.delete(r19, r20, r21);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static Uri com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(ContentResolver r18, Uri r19, ContentValues r20, Bundle r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20, r21};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r18, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (Uri) r4.b;
    L21:
        return r18.insert(r19, r20, r21);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static int com_volcengine_zeus_provider_a_android_content_ContentResolver_update(ContentResolver r18, Uri r19, ContentValues r20, Bundle r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20, r21};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240018);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240018, "android/content/ContentResolver", "update", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.update(r19, r20, r21);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static Uri a(ContentResolver r2, Uri r3, ContentValues r4, String r5) {
        if (r2 != null) goto L14;
        return null;
    L14:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(r2, a(r3, r5), r4);
    L9:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");     // Catch: Throwable -> L11
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(r2, r3, r4);
    L7:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
    L13:
        return null;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
        goto L13
    }

    public static Uri a(ContentResolver r2, Uri r3, ContentValues r4, Bundle r5, String r6) {
        if (r2 != null) goto L16;
        return null;
    L16:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(r2, a(r3, r6), r4, r5);
    L11:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");     // Catch: Throwable -> L13
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(r2, r3, r4, r5);
    L9:
        e = e;
    L10:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
    L15:
        return null;
    L7:
        e = e;
    L13:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
        goto L15
    }

    public static int b(ContentResolver r3, Uri r4, ContentValues r5, Bundle r6, String r7) {
        if (r3 != null) goto L16;
        return 0;
    L16:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_update(r3, a(r4, r7), r5, r6);
    L11:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");     // Catch: Throwable -> L13
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_update(r3, r4, r5, r6);
    L9:
        e = e;
    L10:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
    L15:
        return 0;
    L7:
        e = e;
    L13:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
        goto L15
    }

    private static Cursor com_volcengine_zeus_provider_a_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, Bundle r16, CancellationSignal r17) {
        c r8 = new c();
        Object[] r9 = {r14, r15, r16, r17};
        b r10 = new b();
        d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }

    private static int com_volcengine_zeus_provider_a_android_content_ContentResolver_update(ContentResolver r18, Uri r19, ContentValues r20, String r21, String[] r22) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20, r21, r22};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240018);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240018, "android/content/ContentResolver", "update", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.update(r19, r20, r21, r22);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static int a(ContentResolver r3, Uri r4, String r5, String[] r6, String r7) {
        if (r3 != null) goto L14;
        return -1;
    L14:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(r3, a(r4, r7), r5, r6);
    L9:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");     // Catch: Throwable -> L11
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(r3, r4, r5, r6);
    L7:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
    L13:
        return -1;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
        goto L13
    }

    public static Bundle a(ContentResolver r6, String r7, String r8, String r9, Bundle r10, String r11) {
        if (r6 != null) goto L5;
        return null;
    L5:
        String r2 = ContentProviderManager.getInstance().getPluginProcessNameByAuthority(r7);
        ContentProviderManager.c r3 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(r2);
        if (r10 != null) goto L24;
        r10 = new Bundle();
    L24:
        if (r3 == null) goto L17;
        r10.putString("provider_params", r7);     // Catch: IncompatibleClassChangeError -> L12 Exception -> L14 IllegalArgumentException -> L19
        r10.putString(ContentProviderManager.PROVIDER_PROXY_URI, a(r11, null, r7).toString());     // Catch: IncompatibleClassChangeError -> L12 Exception -> L14 IllegalArgumentException -> L19
        return r6.call(r3.b, r8, r9, r10);
    L17:
        throw new IllegalArgumentException("systemProviderInfo is null, processName=" + r2);     // Catch: IncompatibleClassChangeError -> L12 Exception -> L14 IllegalArgumentException -> L19
    L19:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");     // Catch: Throwable -> L21
        return r6.call(r7, r8, r9, r10);
    L14:
        e = e;
    L18:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
    L23:
        return null;
    L12:
        e = e;
    L21:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
        goto L23
    }

    private static Cursor com_volcengine_zeus_provider_a_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        c r8 = new c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        b r10 = new b();
        d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }

    public static Bundle a(ContentResolver r5, Uri r6, String r7, String r8, Bundle r9, String r10) {
        if (r5 == null) goto L19;
        if (r6 == null) goto L19;
        Uri r11 = a(r6, r10);     // Catch: IncompatibleClassChangeError -> L11 Exception -> L13 IllegalArgumentException -> L15
        if (r9 != null) goto L9;
        r9 = new Bundle();     // Catch: IncompatibleClassChangeError -> L11 Exception -> L13 IllegalArgumentException -> L15
    L9:
        r9.putString("provider_params", r6.getAuthority());     // Catch: IncompatibleClassChangeError -> L11 Exception -> L13 IllegalArgumentException -> L15
        r9.putString(ContentProviderManager.PROVIDER_PROXY_URI, r11.toString());     // Catch: IncompatibleClassChangeError -> L11 Exception -> L13 IllegalArgumentException -> L15
        return r5.call(r11, r7, r8, r9);
    L15:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");     // Catch: Throwable -> L17
        return r5.call(r6, r7, r8, r9);
    L13:
        e = e;
    L14:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
    L11:
        e = e;
    L17:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
    L19:
        return null;
    }

    public static Cursor a(ContentResolver r2, Uri r3, String[] r4, Bundle r5, CancellationSignal r6, String r7) {
        if (r2 != null) goto L16;
        return null;
    L16:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r2, a(r3, r7), r4, r5, r6);
    L11:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");     // Catch: Throwable -> L13
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r2, r3, r4, r5, r6);
    L9:
        e = e;
    L10:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
    L15:
        return null;
    L7:
        e = e;
    L13:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(4 params) throw exception:", th);
        goto L15
    }

    public static int a(ContentResolver r3, Uri r4, ContentValues r5, String r6, String[] r7, String r8) {
        if (r3 != null) goto L14;
        return 0;
    L14:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_update(r3, a(r4, r8), r5, r6, r7);
    L9:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");     // Catch: Throwable -> L11
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_update(r3, r4, r5, r6, r7);
    L7:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
    L13:
        return 0;
    L11:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
        goto L13
    }

    public static Cursor a(ContentResolver r8, Uri r9, String[] r10, String r11, String[] r12, String r13, String r14) {
        if (r8 != null) goto L15;
        return null;
    L15:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r8, a(r9, r14), r10, r11, r12, r13);
    L10:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");     // Catch: Throwable -> L12
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r8, r9, r10, r11, r12, r13);
    L7:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(5 params) throw exception:", e);
        return null;
    L12:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(5 params) throw exception:", th);
        return null;
    }

    private static Cursor com_volcengine_zeus_provider_a_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18, CancellationSignal r19) {
        c r8 = new c();
        Object[] r9 = {r14, r15, r16, r17, r18, r19};
        b r10 = new b();
        d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18, r19);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }

    public static Cursor a(ContentResolver r10, Uri r11, String[] r12, String r13, String[] r14, String r15, CancellationSignal r16, String r17) {
        if (r10 != null) goto L17;
        return null;
    L17:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r10, a(r11, r17), r12, r13, r14, r15, r16);
    L12:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(6 params) !!!");     // Catch: Throwable -> L14
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r10, r11, r12, r13, r14, r15, r16);
    L10:
        e = e;
    L11:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
    L16:
        return null;
    L8:
        e = e;
    L14:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(6 params) throw exception:", th);
        goto L16
    }
}
