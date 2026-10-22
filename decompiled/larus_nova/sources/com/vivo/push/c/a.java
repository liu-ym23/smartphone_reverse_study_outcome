package com.vivo.push.c;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.vivo.push.util.aa;
import com.vivo.push.util.ah;
import com.vivo.push.util.t;
import com.vivo.push.x;
import f06.b;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f462275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, String> f462276b;

    public final int a() {
        int r100 = b(1);
        t.d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(r100)));
        return r100;
    }

    public final int b() {
        int r100 = b(4);
        t.d("CoreConfigManager", "isSupportSyncProfileInfo : ".concat(String.valueOf(r100)));
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.content.ContentProviderClient, android.database.Cursor] */
    private int g() {
        if (this.f462275a != null) goto L7;
        return 8002;
    L7:
        if (this.f462276b.size() <= 0) goto L9;
        return 0;
    L9:
        Cursor r100 = 0;
        r100 = 0;
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L49 Exception -> L51
        if (r101 < 24) goto L16;
        ContentResolver r102 = this.f462275a.getContentResolver();     // Catch: Throwable -> L49 Exception -> L51
        Uri r103 = x.f462613a;     // Catch: Throwable -> L49 Exception -> L51
        ContentProviderClient r104 = com_vivo_push_c_a_android_content_ContentResolver_acquireUnstableContentProviderClient(r102, r103);     // Catch: Throwable -> L49 Exception -> L51
        if (r104 != null) goto L85;
    L17:
        if (r100 != 0) goto L21;
        r100 = com_vivo_push_c_a_android_content_ContentResolver_query(this.f462275a.getContentResolver(), x.f462613a, null, null, null, null);     // Catch: Exception -> L19 Throwable -> L66
    L21:
        if (r100 != 0) goto L35;
        t.a("CoreConfigManager", "cursor is null");     // Catch: Exception -> L19 Throwable -> L66
        if (r100 != 0) goto L86;
    L27:
        if (r104 == null) goto L93;
        if (r101 < 24) goto L94;
        r104.close();     // Catch: Exception -> L25
        return 8008;
    L25:
        e = move-exception;
        t.a("CoreConfigManager", "close err ", e);
        return 8008;
    L94:
        return 8008;
    L93:
        return 8008;
    L86:
        r100.close();     // Catch: Exception -> L25
    L35:
        if (r100.moveToNext() == false) goto L81;
        String r105 = r100.getString(r100.getColumnIndex("name"));     // Catch: Exception -> L19 Throwable -> L66
        String r106 = r100.getString(r100.getColumnIndex("value"));     // Catch: Exception -> L19 Throwable -> L66
        if (TextUtils.isEmpty(r105) == true) goto L35;
        this.f462276b.put(r105, r106);     // Catch: Exception -> L19 Throwable -> L66
        goto L35
    L81:
        r100.close();     // Catch: Exception -> L46
        if (r104 != null) goto L43;
    L48:
        return 0;
    L43:
        if (Build.VERSION.SDK_INT < 24) goto L48;
        r104.close();     // Catch: Exception -> L46
    L46:
        e = move-exception;
        t.a("CoreConfigManager", "close err ", e);
        goto L48
    L85:
        r100 = r104.query(r103, null, null, null, null);     // Catch: Exception -> L19 Throwable -> L66
    L19:
        e = e;
    L53:
        t.a("CoreConfigManager", "provider exception", e);     // Catch: Throwable -> L66
        if (0 != 0) goto L78;
    L58:
        if (r104 != null) goto L60;
        return 8005;
    L60:
        if (Build.VERSION.SDK_INT < 24) goto L97;
        r104.close();     // Catch: Exception -> L56
        return 8005;
    L56:
        e = move-exception;
        t.a("CoreConfigManager", "close err ", e);
        return 8005;
    L97:
        return 8005;
    L78:
        r100.close();     // Catch: Exception -> L56
        goto L58
    L16:
        r104 = null;
    L66:
        th = th;
    L67:
        if (0 != 0) goto L83;
    L71:
        if (0 != 0) goto L73;
    L77:
        throw th;
    L73:
        if (Build.VERSION.SDK_INT < 24) goto L77;
        r100.close();     // Catch: Exception -> L69
    L69:
        e = move-exception;
        t.a("CoreConfigManager", "close err ", e);
        goto L77
    L83:
        r100.close();     // Catch: Exception -> L69
    L51:
        e = e;
        r104 = null;
    L49:
        th = th;
        goto L67
    }

    public final boolean c() {
        int r100 = b(8);
        t.d("CoreConfigManager", "isSupportdeleteRegid : ".concat(String.valueOf(r100)));
        if (r100 != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean d() {
        int r100 = b(16);
        t.d("CoreConfigManager", "isSupportQueryCurrentAppState : ".concat(String.valueOf(r100)));
        if (r100 != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean e() {
        int r100 = b(32);
        t.d("CoreConfigManager", "isSupportCreateNotifyChannel : ".concat(String.valueOf(r100)));
        if (r100 != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean f() {
        int r100 = b(128);
        t.d("CoreConfigManager", "isSupportAliasSubscribeCheck : ".concat(String.valueOf(r100)));
        if (r100 != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public a(Context r100) {
        this.f462276b = new HashMap();
        this.f462275a = r100;
    }

    private int b(int r100) {
        int r101 = g();
        if (r101 == 0) goto L5;
        return r101;
    L5:
        HashMap<String, String> r102 = this.f462276b;
        if (r102 != null) goto L8;
        return 8006;
    L8:
        if (r102.size() == 0) goto L27;
        String r103 = this.f462276b.get("pushSupport");
        if (TextUtils.isEmpty(r103) == false) goto L25;
        return 2;
    L25:
        if ((r100 & CastIntegerProtector.parseInt(r103)) <= 0) goto L17;
        return 0;
    L17:
        return 1;
    L19:
        return 8007;
    L27:
        return 8006;
    }

    public final boolean a(int r110) {
        if (b(r110) != 0) goto L6;
        return true;
    L6:
        if (r110 == 256) goto L13;
        if (r110 == 512) goto L13;
        if (r110 == 4096) goto L13;
        if (r110 == 1024) goto L13;
        if (r110 == 2048) goto L13;
        boolean r100 = false;
    L14:
        if (r100 == true) goto L16;
    L39:
        return false;
    L16:
        if ("com.vivo.pushservice".equals(aa.a(this.f462275a)) == false) goto L39;
        long r101 = ah.a(this.f462275a);
        if (r110 == 256) goto L37;
        if (r110 == 512) goto L33;
        if (r110 == 1024) goto L29;
        if (r110 == 2048) goto L25;
        if (r110 == 4096) goto L33;
    L25:
        if (r101 < 4400) goto L27;
        return true;
    L27:
        return false;
    L29:
        if (r101 < 4200) goto L31;
        return true;
    L31:
        return false;
    L33:
        if (r101 < 4100) goto L35;
        return true;
    L35:
        return false;
    L37:
        if (r101 < 3700) goto L39;
        return true;
    L13:
        r100 = true;
        goto L14
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00b0: MOVE (r4 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:33554608), block:B:57:0x00af */
    public static String a(Context r110, String r111) {
        Cursor r100 = null;
        r100 = null;
        String r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        if (r110 != null) goto L6;
        t.a("CoreConfigManager", "queryFromCoreSdk context is null");     // Catch: Throwable -> L44 Exception -> L46
        return null;
    L6:
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L44 Exception -> L46
        if (r102 < 24) goto L17;
        ContentResolver r103 = r110.getContentResolver();     // Catch: Throwable -> L44 Exception -> L46
        Uri r104 = x.f462618f;     // Catch: Throwable -> L44 Exception -> L46
        ContentProviderClient r105 = com_vivo_push_c_a_android_content_ContentResolver_acquireUnstableContentProviderClient(r103, r104);     // Catch: Throwable -> L44 Exception -> L46
        if (r105 != null) goto L75;
        Cursor r106 = null;
    L18:
        if (r106 == null) goto L72;
    L22:
        if (r106 != null) goto L35;
        t.a("CoreConfigManager", "queryFromCoreSdk cursor is null");     // Catch: Exception -> L20 Throwable -> L56
        if (r106 != null) goto L73;
    L28:
        if (r105 == null) goto L33;
        if (r102 < 24) goto L33;
        r105.close();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        t.a("CoreConfigManager", "queryFromCoreSdk close error", e);
    L33:
        return null;
    L73:
        r106.close();     // Catch: Exception -> L26
        goto L28
    L35:
        if (r106.moveToFirst() == false) goto L37;
        r101 = r106.getString(r106.getColumnIndex("queryAppState"));     // Catch: Exception -> L20 Throwable -> L56
    L37:
        r106.close();     // Catch: Exception -> L42
        if (r105 == null) goto L55;
        if (r102 < 24) goto L55;
        r105.close();     // Catch: Exception -> L42
    L55:
        return r101;
    L72:
        r106 = com_vivo_push_c_a_android_content_ContentResolver_query(r110.getContentResolver(), x.f462618f, null, "queryParameter = ?  ", new String[]{r111}, null);     // Catch: Exception -> L20 Throwable -> L56
    L20:
        e = e;
    L48:
        t.a("CoreConfigManager", "queryFromCoreSdk error ", e);     // Catch: Throwable -> L56
        if (r106 == null) goto L51;
        r106.close();     // Catch: Exception -> L42
    L51:
        if (r105 == null) goto L55;
        if (Build.VERSION.SDK_INT < 24) goto L55;
        r105.close();     // Catch: Exception -> L42
        goto L55
    L75:
        t.a("CoreConfigManager", "queryFromCoreSdk client is null");     // Catch: Throwable -> L12 Exception -> L14
        r106 = r105.query(r104, null, "queryParameter = ?  ", new String[]{r111}, null);     // Catch: Throwable -> L12 Exception -> L14
    L14:
        e = e;
        r106 = null;
    L12:
        th = move-exception;
        Throwable r107 = th;
    L58:
        if (r100 != null) goto L70;
    L62:
        if (r105 != null) goto L64;
        throw r107;
    L64:
        if (Build.VERSION.SDK_INT < 24) goto L78;
        r105.close();     // Catch: Exception -> L60
        throw r107;
    L60:
        e = move-exception;
        t.a("CoreConfigManager", "queryFromCoreSdk close error", e);
        throw r107;
    L78:
        throw r107;
    L70:
        r100.close();     // Catch: Exception -> L60
        goto L62
    L17:
        r105 = null;
        r106 = null;
    L42:
        e = move-exception;
        t.a("CoreConfigManager", "queryFromCoreSdk close error", e);
    L56:
        th = move-exception;
        r107 = th;
        r100 = r8;
    L46:
        e = e;
        r105 = null;
        r106 = null;
    L44:
        th = move-exception;
        r107 = th;
        r105 = null;
        goto L58
    }

    private static ContentProviderClient com_vivo_push_c_a_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        b r112 = new b();
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
        d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
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
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static Cursor com_vivo_push_c_a_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
}
