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

/* JADX INFO: loaded from: classes.dex */
public class a {
    public a() {
    }

    public static Uri a(Uri r100, String r101) {
        if (ContentProviderManager.getInstance().isPluginProvider(r100) == false) goto L6;
        Uri r102 = a(r101, r100);
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#buildProxyUri-->proxyUri=" + r102);
        return r102;
    L6:
        return r100;
    }

    private static Uri a(String r100, Uri r101) {
        return a(r100, r101, null);
    }

    public static Uri a(String r100, Uri r101, String r102) {
        boolean r103 = Zeus.loadOrAwaitLoad(r100, g.f462706c);
        ContentProviderManager r104 = ContentProviderManager.getInstance();
        if (r101 == null) goto L5;
        String r105 = r101.getAuthority();
    L6:
        String r106 = r104.getPluginProcessNameByAuthority(r105);
        String r107 = "";
        String r108 = null;
        if (r100 == null) goto L19;
        if (TextUtils.isEmpty(r100) == true) goto L19;
        JSONObject r109 = new JSONObject();
        r109.put("process_name", r106);     // Catch: Throwable -> L38
        r109.put(ContentProviderManager.PLUGIN_PKG_NAME, r100);     // Catch: Throwable -> L38
        if (r101 == null) goto L15;
        String r110 = r101.toString();     // Catch: Throwable -> L38
    L16:
        r109.put("uri", r110);     // Catch: Throwable -> L38
        goto L17
    L15:
        r110 = "";
    L17:
        r108 = r109.toString();
    L19:
        if (TextUtils.isEmpty(r108) == true) goto L22;
        r107 = Base64.encodeToString(r108.getBytes(), 10);
    L22:
        ContentProviderManager.c r111 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(r106);
        if (r111 != null) goto L36;
        if (r101 == null) goto L27;
        r102 = r101.getAuthority();
    L27:
        if (r103 == true) goto L30;
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "Plugin load failed, skip provider proxy uri building. pluginPkg=" + r100 + ", pluginAuthority=" + r102);
        return Uri.EMPTY;
    L30:
        String r112 = "cannot find systemProviderInfo, processName=" + r106 + ", pluginPkg=" + r100 + ", pluginAuthority=" + r102 + ", pluginUri=" + r101 + ", systemProviderInfoMapKeys=" + String.valueOf(ContentProviderManager.getInstance().getSystemProviderInfoMap().keySet());
        if (GlobalParam.getInstance().isDebug() == true) goto L35;
        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, r112);
        return Uri.EMPTY;
    L35:
        throw new IllegalArgumentException(r112);
    L36:
        Uri r113 = UriProtector.parse("content://" + r111.f462826b + File.separator + "proxy?provider_params=" + r107);
        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "进程[processName=" + r106 + "] build provider 【 uri:" + r113 + " 】");
        return r113;
    L5:
        r105 = r102;
        goto L6
    }

    private static int com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(ContentResolver r110, Uri r111, Bundle r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(240019);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.delete(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static Uri com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String a(ContentResolver r100, Uri r101, String r102) {
        if (r100 != null) goto L14;
        return null;
    L14:
        return r100.getType(a(r101, r102));
    L9:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute getType !!!");     // Catch: Throwable -> L11
        return r100.getType(r101);
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

    public static int a(ContentResolver r100, Uri r101, Bundle r102, String r103) {
        if (r100 != null) goto L16;
        return -1;
    L16:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(r100, a(r101, r103), r102);
    L11:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");     // Catch: Throwable -> L13
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(r100, r101, r102);
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

    private static int com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(ContentResolver r110, Uri r111, String r210, String[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(240019);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.delete(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static Uri com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(ContentResolver r110, Uri r111, ContentValues r210, Bundle r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static int com_volcengine_zeus_provider_a_android_content_ContentResolver_update(ContentResolver r110, Uri r111, ContentValues r210, Bundle r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(240018);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240018, "android/content/ContentResolver", "update", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.update(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Uri a(ContentResolver r100, Uri r101, ContentValues r102, String r103) {
        if (r100 != null) goto L14;
        return null;
    L14:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(r100, a(r101, r103), r102);
    L9:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");     // Catch: Throwable -> L11
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(r100, r101, r102);
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

    public static Uri a(ContentResolver r100, Uri r101, ContentValues r102, Bundle r103, String r104) {
        if (r100 != null) goto L16;
        return null;
    L16:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(r100, a(r101, r104), r102, r103);
    L11:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");     // Catch: Throwable -> L13
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_insert(r100, r101, r102, r103);
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

    public static int b(ContentResolver r100, Uri r101, ContentValues r102, Bundle r103, String r104) {
        if (r100 != null) goto L16;
        return 0;
    L16:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_update(r100, a(r101, r104), r102, r103);
    L11:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");     // Catch: Throwable -> L13
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_update(r100, r101, r102, r103);
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

    private static Cursor com_volcengine_zeus_provider_a_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, Bundle r113, CancellationSignal r114) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114};
        b r115 = new b();
        d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }

    private static int com_volcengine_zeus_provider_a_android_content_ContentResolver_update(ContentResolver r110, Uri r111, ContentValues r210, String r211, String[] r212) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211, r212};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(240018);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240018, "android/content/ContentResolver", "update", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.update(r111, r210, r211, r212);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static int a(ContentResolver r100, Uri r101, String r102, String[] r103, String r104) {
        if (r100 != null) goto L14;
        return -1;
    L14:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(r100, a(r101, r104), r102, r103);
    L9:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");     // Catch: Throwable -> L11
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_delete(r100, r101, r102, r103);
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

    public static Bundle a(ContentResolver r100, String r101, String r102, String r103, Bundle r110, String r111) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r104 = ContentProviderManager.getInstance().getPluginProcessNameByAuthority(r101);
        ContentProviderManager.c r105 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(r104);
        if (r110 != null) goto L24;
        r110 = new Bundle();
    L24:
        if (r105 == null) goto L17;
        r110.putString("provider_params", r101);     // Catch: IncompatibleClassChangeError -> L12 Exception -> L14 IllegalArgumentException -> L19
        r110.putString(ContentProviderManager.PROVIDER_PROXY_URI, a(r111, null, r101).toString());     // Catch: IncompatibleClassChangeError -> L12 Exception -> L14 IllegalArgumentException -> L19
        return r100.call(r105.f462826b, r102, r103, r110);
    L17:
        throw new IllegalArgumentException("systemProviderInfo is null, processName=" + r104);     // Catch: IncompatibleClassChangeError -> L12 Exception -> L14 IllegalArgumentException -> L19
    L19:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");     // Catch: Throwable -> L21
        return r100.call(r101, r102, r103, r110);
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

    private static Cursor com_volcengine_zeus_provider_a_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }

    public static Bundle a(ContentResolver r100, Uri r101, String r102, String r103, Bundle r104, String r110) {
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        Uri r111 = a(r101, r110);     // Catch: IncompatibleClassChangeError -> L11 Exception -> L13 IllegalArgumentException -> L15
        if (r104 != null) goto L9;
        r104 = new Bundle();     // Catch: IncompatibleClassChangeError -> L11 Exception -> L13 IllegalArgumentException -> L15
    L9:
        r104.putString("provider_params", r101.getAuthority());     // Catch: IncompatibleClassChangeError -> L11 Exception -> L13 IllegalArgumentException -> L15
        r104.putString(ContentProviderManager.PROVIDER_PROXY_URI, r111.toString());     // Catch: IncompatibleClassChangeError -> L11 Exception -> L13 IllegalArgumentException -> L15
        return r100.call(r111, r102, r103, r104);
    L15:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");     // Catch: Throwable -> L17
        return r100.call(r101, r102, r103, r104);
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

    public static Cursor a(ContentResolver r100, Uri r101, String[] r102, Bundle r103, CancellationSignal r104, String r105) {
        if (r100 != null) goto L16;
        return null;
    L16:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r100, a(r101, r105), r102, r103, r104);
    L11:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");     // Catch: Throwable -> L13
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r100, r101, r102, r103, r104);
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

    public static int a(ContentResolver r100, Uri r101, ContentValues r102, String r103, String[] r104, String r105) {
        if (r100 != null) goto L14;
        return 0;
    L14:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_update(r100, a(r101, r105), r102, r103, r104);
    L9:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");     // Catch: Throwable -> L11
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_update(r100, r101, r102, r103, r104);
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

    public static Cursor a(ContentResolver r100, Uri r101, String[] r110, String r111, String[] r112, String r113, String r114) {
        if (r100 != null) goto L15;
        return null;
    L15:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r100, a(r101, r114), r110, r111, r112, r113);
    L10:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");     // Catch: Throwable -> L12
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r100, r101, r110, r111, r112, r113);
    L7:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(5 params) throw exception:", e);
        return null;
    L12:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(5 params) throw exception:", th);
        return null;
    }

    private static Cursor com_volcengine_zeus_provider_a_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115, CancellationSignal r116) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115, r116};
        b r117 = new b();
        d r118 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r117);
        if (r118.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r117, false);
        return (Cursor) r118.f474983b;
    L6:
        Cursor r119 = r110.query(r111, r112, r113, r114, r115, r116);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r119, r117, true);
        return r119;
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115, CancellationSignal r116, String r117) {
        if (r110 != null) goto L17;
        return null;
    L17:
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r110, a(r111, r117), r112, r113, r114, r115, r116);
    L12:
        ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(6 params) !!!");     // Catch: Throwable -> L14
        return com_volcengine_zeus_provider_a_android_content_ContentResolver_query(r110, r111, r112, r113, r114, r115, r116);
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
