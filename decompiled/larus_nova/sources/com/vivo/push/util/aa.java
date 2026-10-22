package com.vivo.push.util;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes41.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f462533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f462534b;

    public static String a(Context r110) {
        if (TextUtils.isEmpty(f462534b) == false) goto L5;
        Cursor r100 = null;
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L77 Exception -> L79
        if (r101 < 24) goto L16;
        ContentResolver r102 = r110.getContentResolver();     // Catch: Throwable -> L77 Exception -> L79
        Uri r103 = com.vivo.push.x.f462613a;     // Catch: Throwable -> L77 Exception -> L79
        ContentProviderClient r104 = com_vivo_push_util_aa_android_content_ContentResolver_acquireUnstableContentProviderClient(r102, r103);     // Catch: Throwable -> L77 Exception -> L79
        if (r104 != null) goto L112;
        Cursor r105 = null;
    L17:
        if (r105 == null) goto L103;
    L24:
        if (r105 != null) goto L36;
        t.a("PushPackageUtils", "cursor is null");     // Catch: Throwable -> L19 Exception -> L21
        if (r105 != null) goto L115;
    L30:
        if (r104 == null) goto L35;
        if (r101 < 24) goto L35;
        r104.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        t.a("PushPackageUtils", "close", e);
    L35:
        return null;
    L115:
        r105.close();     // Catch: Exception -> L28
    L21:
        e = e;
        String r106 = null;
    L23:
        r100 = r105;
    L81:
        t.a("PushPackageUtils", "getSystemPush", e);     // Catch: Throwable -> L89
        if (r100 == null) goto L84;
        r100.close();     // Catch: Exception -> L73
    L84:
        if (r104 != null) goto L86;
    L88:
        return r106;
    L86:
        if (Build.VERSION.SDK_INT < 24) goto L88;
        r104.close();     // Catch: Exception -> L73
    L89:
        th = th;
    L90:
        if (r100 != null) goto L110;
    L94:
        if (r104 != null) goto L96;
    L100:
        throw th;
    L96:
        if (Build.VERSION.SDK_INT < 24) goto L100;
        r104.close();     // Catch: Exception -> L92
    L92:
        e = move-exception;
        t.a("PushPackageUtils", "close", e);
        goto L100
    L110:
        r100.close();     // Catch: Exception -> L92
        goto L94
    L36:
        boolean r111 = false;
        r106 = null;
    L101:
    L75:
        e = e;
        goto L23
    L38:
        if (r105.moveToNext() == false) goto L46;
        if ("pushPkgName".equals(r105.getString(r105.getColumnIndex("name"))) == true) goto L42;
        if ("pushEnable".equals(r105.getString(r105.getColumnIndex("name"))) == false) goto L101;
        r111 = Boolean.parseBoolean(r105.getString(r105.getColumnIndex("value")));     // Catch: Throwable -> L19 Exception -> L75
        goto L101
    L42:
        r106 = r105.getString(r105.getColumnIndex("value"));     // Catch: Throwable -> L19 Exception -> L75
        goto L101
    L46:
        f462534b = r106;     // Catch: Throwable -> L19 Exception -> L75
        if (TextUtils.isEmpty(r106) == true) goto L108;
        if (r111 == false) goto L106;
        r105.close();     // Catch: Exception -> L73
        if (r104 == null) goto L88;
        if (Build.VERSION.SDK_INT < 24) goto L88;
        r104.close();     // Catch: Exception -> L73
        goto L88
    L106:
        r105.close();     // Catch: Exception -> L64
        if (r104 != null) goto L61;
    L66:
        return null;
    L61:
        if (Build.VERSION.SDK_INT < 24) goto L66;
        r104.close();     // Catch: Exception -> L64
    L64:
        e = move-exception;
        t.a("PushPackageUtils", "close", e);
        goto L66
    L108:
        r105.close();     // Catch: Exception -> L54
        if (r104 != null) goto L51;
    L56:
        return null;
    L51:
        if (Build.VERSION.SDK_INT < 24) goto L56;
        r104.close();     // Catch: Exception -> L54
    L54:
        e = move-exception;
        t.a("PushPackageUtils", "close", e);
        goto L56
    L103:
        r105 = com_vivo_push_util_aa_android_content_ContentResolver_query(r110.getContentResolver(), com.vivo.push.x.f462613a, null, null, null, null);     // Catch: Throwable -> L19 Exception -> L21
    L19:
        th = th;
        r100 = r105;
        goto L90
    L112:
        t.a("PushPackageUtils", "client is null");     // Catch: Exception -> L13 Throwable -> L89
        r105 = r104.query(r103, null, null, null, null);     // Catch: Exception -> L13 Throwable -> L89
    L13:
        e = e;
        r106 = null;
        goto L81
    L16:
        r104 = null;
        r105 = null;
    L73:
        e = move-exception;
        t.a("PushPackageUtils", "close", e);
    L79:
        e = e;
        r106 = null;
        r104 = null;
    L77:
        th = th;
        r104 = null;
        goto L90
    L5:
        return f462534b;
    }

    public static boolean b(Context r100) {
        Boolean r101 = f462533a;
        if (r101 != null) goto L5;
        String r102 = null;
        if (r100 != null) goto L9;
    L14:
        Boolean r103 = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(f(r100, r102)));
        f462533a = r103;
        return r103.booleanValue();
    L9:
        if (TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") == true) goto L14;
        ProviderInfo r104 = r100.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128);
        if (r104 == null) goto L14;
        r102 = r104.packageName;
        goto L14
    L5:
        return r101.booleanValue();
    }

    private static com.vivo.push.model.a c(Context r100) {
        String r101 = a(r100);
        ApplicationInfo r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        com.vivo.push.model.a r103 = new com.vivo.push.model.a(r101);
        PackageInfo r104 = r100.getPackageManager().getPackageInfo(r101, 128);     // Catch: Exception -> L13
        if (r104 == null) goto L9;
        r103.a(r104.versionCode);
        r103.a(r104.versionName);
        r102 = r104.applicationInfo;
    L9:
        if (r102 == null) goto L11;
        r103.a(ah.a(r100, r101));
    L11:
        r103.a(a(r100, r101));
        return r103;
    L13:
        e = move-exception;
        e.printStackTrace();
        t.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e);
        return null;
    }

    public static com.vivo.push.model.a a(Context r110, com.vivo.push.restructure.b.b r111) {
        Context r112 = ContextDelegate.getContext(r110).getApplicationContext();
        com.vivo.push.model.a r100 = c(r112);
        if (r100 == null) goto L6;
        t.d("PushPackageUtils", "get system push info :".concat(String.valueOf(r100)));
        return r100;
    L6:
        List<String> r113 = r111.a(r112);
        com.vivo.push.model.a r101 = e(r112, r112.getPackageName());
        if (r113 != null) goto L9;
    L72:
        if (r101 != null) goto L74;
    L76:
        t.a("PushPackageUtils", "findAllPushPackages error: find no package!");
        r101 = r100;
    L77:
        if (r101 != null) goto L79;
        t.b(r112, "查找最优包为空!");
        t.d("PushPackageUtils", "finSuitablePushPackage is null");
    L83:
        return r101;
    L79:
        if (r101.c() == false) goto L81;
        t.a(r112, "查找最优包为:" + r101.a() + "(" + r101.b() + ", Black)");
        t.d("PushPackageUtils", "finSuitablePushPackage" + r101.a() + "(" + r101.b() + ", Black)");
        goto L83
    L81:
        t.a(r112, "查找最优包为:" + r101.a() + "(" + r101.b() + ")");
        t.d("PushPackageUtils", "finSuitablePushPackage" + r101.a() + "(" + r101.b() + ")");
        goto L83
    L74:
        if (r101.d() == false) goto L76;
        r100 = r101;
        goto L76
    L9:
        if (r113.size() <= 0) goto L72;
        com.vivo.push.model.a r102 = null;
        String r103 = af.b(r112).a("com.vivo.push.cur_pkg", null);
        if (TextUtils.isEmpty(r103) == false) goto L14;
    L20:
        com.vivo.push.model.a r104 = null;
    L21:
        if (r101 != null) goto L23;
    L25:
        r101 = null;
    L26:
        if (r104 != null) goto L29;
        r104 = null;
    L29:
        if (r101 == null) goto L43;
        if (r104 != null) goto L32;
    L44:
        HashMap r105 = new HashMap();
        if (r101 != null) goto L47;
        r101 = null;
    L50:
        int r106 = r113.size();
        int r107 = 0;
    L51:
        if (r107 >= r106) goto L69;
        String r108 = (String) ListProtector.get(r113, r107);
        if (TextUtils.isEmpty(r108) == true) goto L68;
        com.vivo.push.model.a r109 = e(r112, r108);
        if (r109 == null) goto L68;
        r105.put(r108, r109);
        if (r109.d() == false) goto L68;
        if (r109.c() == false) goto L64;
        if (r102 != null) goto L62;
    L63:
        r102 = r109;
        goto L68
    L62:
        if (r109.b() <= r102.b()) goto L68;
    L64:
        if (r101 != null) goto L66;
    L67:
        r101 = r109;
        goto L68
    L66:
        if (r109.b() > r101.b()) goto L67;
    L68:
        r107 = r107 + 1;
        goto L51
    L69:
        if (r101 != null) goto L77;
        t.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
        r101 = r102;
        goto L77
    L47:
        if (r101.c() == false) goto L50;
        r102 = r101;
        r101 = null;
        goto L50
    L32:
        if (r101.c() == false) goto L39;
        if (r104.c() == false) goto L43;
        if (r101.b() <= r104.b()) goto L43;
    L39:
        if (r104.c() == true) goto L44;
        if (r101.b() > r104.b()) goto L44;
    L43:
        r101 = r104;
        goto L44
    L23:
        if (r101.d() == false) goto L25;
    L14:
        if (a(r112, r103, "com.vivo.pushservice.action.METHOD") == false) goto L20;
        r104 = e(r112, r103);
        if (r104 == null) goto L20;
        if (r104.d() == false) goto L20;
        goto L20
    }

    public static int b(Context r100, String r101) {
        if (a(r100, r101, "com.vivo.pushservice.action.RECEIVE") == false) goto L5;
        int r102 = 0;
    L7:
        if (a(r100, r101, "com.vivo.pushclient.action.RECEIVE") == false) goto L10;
        return 1;
    L10:
        return r102;
    L5:
        r102 = -1;
        goto L7
    }

    public static boolean c(Context r100, String r101) {
        return a(r100, r101, "com.vivo.pushclient.action.RECEIVE");
    }

    private static ContentProviderClient com_vivo_push_util_aa_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
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
        f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static boolean d(Context r100, String r101) {
        return a(r100, r101, "com.vivo.pushservice.action.RECEIVE");
    }

    private static com.vivo.push.model.a e(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L24:
        return null;
    L5:
        if (a(r100, r101, "com.vivo.pushservice.action.METHOD") == false) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L24;
        com.vivo.push.model.a r103 = new com.vivo.push.model.a(r101);
        PackageInfo r104 = r100.getPackageManager().getPackageInfo(r101, 128);     // Catch: Exception -> L22
        if (r104 == null) goto L17;
        r103.a(r104.versionCode);     // Catch: Exception -> L22
        r103.a(r104.versionName);     // Catch: Exception -> L22
        ApplicationInfo r105 = r104.applicationInfo;     // Catch: Exception -> L22
    L18:
        if (r105 == null) goto L20;
        r103.a(ah.a(r100, r101));     // Catch: Exception -> L22
    L20:
        r103.a(a(r100, r101));
        return r103;
    L17:
        r105 = null;
    L22:
        e = move-exception;
        t.a("PushPackageUtils", "getPushPackageInfo exception: ", e);
        goto L24
    L7:
        if (a(r100, r101, "com.vivo.pushservice.action.RECEIVE") == true) goto L10;
        r102 = false;
        goto L11
    }

    private static String f(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L17;
        if (r100 == null) goto L17;
        Signature[] r102 = r100.getPackageManager().getPackageInfo(r101, 64).signatures;     // Catch: Exception -> L15
        int r103 = 0;
        byte[] r104 = r102[0].toByteArray();     // Catch: Exception -> L15
        byte[] r105 = MessageDigest.getInstance("SHA256").digest(r104);     // Catch: Exception -> L15
        StringBuffer r106 = new StringBuffer();     // Catch: Exception -> L15
    L8:
        if (r103 >= r105.length) goto L13;
        String r107 = Integer.toHexString(r105[r103] & UByte.MAX_VALUE).toUpperCase(Locale.US);     // Catch: Exception -> L15
        if (r107.length() != 1) goto L12;
        r106.append("0");     // Catch: Exception -> L15
    L12:
        r106.append(r107);     // Catch: Exception -> L15
        r103 = r103 + 1;     // Catch: Exception -> L15
        goto L8
    L13:
        return r106.toString();
    L15:
        e = move-exception;
        t.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e)));
    L17:
        return null;
    }

    public static boolean a(Context r100, String r110) {
        if (TextUtils.isEmpty(r110) == true) goto L30;
        if (r100 == null) goto L30;
        Intent r101 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        r101.setPackage(r110);
        PackageManager r102 = r100.getPackageManager();
        List<ResolveInfo> r103 = r102.queryIntentServices(r101, 576);
        if (r103 != null) goto L9;
    L29:
        t.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        goto L30
    L9:
        if (r103.size() <= 0) goto L29;
        int r104 = r103.size();
        int r105 = 0;
        boolean r106 = false;
    L12:
        if (r105 >= r104) goto L28;
        ResolveInfo r107 = (ResolveInfo) ListProtector.get(r103, r105);
        if (r107 == null) goto L27;
        ServiceInfo r108 = r107.serviceInfo;
        if (r108 == null) goto L27;
        String r109 = r108.name;
        boolean r111 = r108.exported;
        if ("com.vivo.push.sdk.service.PushService".equals(r109) == false) goto L27;
        if (r111 == false) goto L27;
        boolean r112 = r107.serviceInfo.enabled;
        int r113 = r102.getComponentEnabledSetting(new ComponentName(r110, "com.vivo.push.sdk.service.PushService"));
        if (r113 == 1) goto L26;
        if (r113 != 0) goto L25;
        if (r112 == true) goto L26;
    L25:
        r106 = false;
    L26:
        r106 = true;
    L27:
        r105 = r105 + 1;
        goto L12
    L28:
        return r106;
    L30:
        return false;
    }

    private static boolean a(Context r100, String r101, String r102) {
        Intent r103 = new Intent(r102);
        r103.setPackage(r101);
        List<ResolveInfo> r104 = r100.getPackageManager().queryBroadcastReceivers(r103, 576);     // Catch: Exception -> L5
    L6:
        if (r104 != null) goto L8;
    L10:
        return false;
    L8:
        if (r104.size() <= 0) goto L10;
        return true;
    L5:
        r104 = null;
        goto L6
    }

    private static Cursor com_vivo_push_util_aa_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
