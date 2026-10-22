package com.ss.android.token;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class AuthTokenMultiProcessSharedProvider extends ContentProvider {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f449618e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Uri f449619f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static UriMatcher f449620g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f449621h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f449622i = "token_shared_preference";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f449623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f449624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f449625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f449626d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f449627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ContentValues f449628b;

        public final synchronized void a() {
            monitor-enter(this);
            tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider apply key called, size = " + this.f449628b.size());     // Catch: Throwable -> L39
            com.bytedance.sdk.account.settings.common.a.a();     // Catch: Throwable -> L39
            if (com.bytedance.sdk.account.settings.common.a.Z == true) goto L7;
        L42:
            SharedPreferences.Editor r100 = this.f449627a.getSharedPreferences(AuthTokenMultiProcessSharedProvider.f449622i, 4).edit();     // Catch: Throwable -> L35
            Iterator<Map.Entry<String, Object>> r101 = this.f449628b.valueSet().iterator();     // Catch: Throwable -> L35
        L12:
            if (r101.hasNext() == false) goto L31;
            Map.Entry<String, Object> r102 = r101.next();     // Catch: Throwable -> L35
            Object r103 = r102.getValue();     // Catch: Throwable -> L35
            String r104 = r102.getKey();     // Catch: Throwable -> L35
            tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider apply key = " + r104 + " value = " + TokenFactory.l(r103));     // Catch: Throwable -> L35
            if (r103 == null) goto L15;
            if ((r103 instanceof String) == true) goto L18;
            if ((r103 instanceof Boolean) == true) goto L21;
            if ((r103 instanceof Long) == true) goto L24;
            if ((r103 instanceof Integer) == true) goto L27;
            if ((r103 instanceof Float) == false) goto L12;
            r100.putFloat(r104, ((Float) r103).floatValue());     // Catch: Throwable -> L35
            goto L12
        L27:
            r100.putInt(r104, ((Integer) r103).intValue());     // Catch: Throwable -> L35
            goto L12
        L24:
            r100.putLong(r104, ((Long) r103).longValue());     // Catch: Throwable -> L35
            goto L12
        L21:
            r100.putBoolean(r104, ((Boolean) r103).booleanValue());     // Catch: Throwable -> L35
            goto L12
        L18:
            r100.putString(r104, (String) r103);     // Catch: Throwable -> L35
            goto L12
        L15:
            r100.remove(r104);     // Catch: Throwable -> L35
            goto L12
        L31:
            boolean r105 = r100.commit();     // Catch: Throwable -> L35
            b(this.f449627a.getContentResolver(), AuthTokenMultiProcessSharedProvider.b(this.f449627a, "key", "type"), this.f449628b);     // Catch: Throwable -> L35
            if (r105 == true) goto L37;
            TTTokenMonitor.h(-1, "commit fail");     // Catch: Throwable -> L35
        L37:
            monitor-exit(this);
            return;
        L35:
            th = move-exception;
            tb7.a.d("AuthTokenMultiProcessShared", "MultiProcessShareProvider apply error = " + Log.getStackTraceString(th));     // Catch: Throwable -> L39
            TTTokenMonitor.h(-2, th.getMessage());     // Catch: Throwable -> L39
            TTTokenMonitor.d(th);     // Catch: Throwable -> L39
            goto L37
        L7:
            if (this.f449628b.size() != 0) goto L42;
            monitor-exit(this);
            return;
        L39:
            th = move-exception;
            throw th;
        }

        public a(Context r100) {
            this.f449628b = new ContentValues();
            this.f449627a = r100.getApplicationContext();
        }

        public final void c(String r100, String r101) {
            this.f449628b.put(r100, r101);
        }

        public static void b(ContentResolver r110, Uri r111, ContentValues r210) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111, r210};
            f06.b r112 = new f06.b();
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
            f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L20;
            Uri r108 = (Uri) r107.f474983b;
            return;
        L20:
            r110.insert(r111, r210);
            return;
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
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f449629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f449630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SharedPreferences f449631c;

        public final a b() {
            return new a(this.f449629a);
        }

        public final long e() {
        L30:
            th = move-exception;
            TTTokenMonitor.d(th);
            return 0;
        L5:
            if (this.f449630b == true) goto L7;
            Cursor r100 = a(this.f449629a.getContentResolver(), AuthTokenMultiProcessSharedProvider.b(this.f449629a, "x-tt-token-timestamp", "long"));     // Catch: Throwable -> L30
            if (r100 == null) goto L42;
        L15:
            th = move-exception;
            TTTokenMonitor.d(th);     // Catch: Throwable -> L24
        L17:
            long r101 = 0;
        L37:
            r100.close();     // Catch: Exception -> L20 Throwable -> L30
        L23:
            return r101;
        L20:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L30
            goto L23
        L24:
            th = move-exception;
            r100.close();     // Catch: Exception -> L27 Throwable -> L30
        L29:
            throw th;     // Catch: Throwable -> L30
        L27:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L30
            goto L29
        L12:
            if (r100.moveToFirst() == false) goto L17;
            r101 = r100.getLong(0);     // Catch: Throwable -> L15
        L42:
            return 0;
        L7:
            return this.f449631c.getLong("x-tt-token-timestamp", 0);
        }

        public final String f(String r100) {
        L38:
            th = move-exception;
            TTTokenMonitor.d(th);
            return "";
        L5:
            if (this.f449630b == false) goto L8;
            String r101 = this.f449631c.getString(r100, "");     // Catch: Throwable -> L38
            tb7.a.a("AuthTokenMultiProcessShared", "mSharedPreferences main getString get key = " + r100 + " value = " + TokenFactory.l(r101));     // Catch: Throwable -> L38
            return r101;
        L8:
            Cursor r102 = a(this.f449629a.getContentResolver(), AuthTokenMultiProcessSharedProvider.b(this.f449629a, r100, "string"));     // Catch: Throwable -> L38
            if (r102 != null) goto L45;
        L29:
            String r103 = "";
        L30:
            tb7.a.a("AuthTokenMultiProcessShared", " MultiProcessShared getString get key = " + r100 + " value = " + TokenFactory.l(r103));     // Catch: Throwable -> L38
            return r103;
        L45:
        L21:
            th = move-exception;
            TTTokenMonitor.d(th);     // Catch: Throwable -> L32
        L49:
            r102.close();     // Catch: Exception -> L25 Throwable -> L38
        L27:
            r103 = "";
        L28:
            if (r103 != null) goto L30;
        L25:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L38
        L32:
            th = move-exception;
            r102.close();     // Catch: Exception -> L35 Throwable -> L38
        L37:
            throw th;     // Catch: Throwable -> L38
        L35:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L38
            goto L37
        L12:
            if (r102.moveToFirst() == false) goto L15;
            r103 = r102.getString(0);     // Catch: Throwable -> L21
        L47:
            r102.close();     // Catch: Exception -> L18 Throwable -> L38
        L18:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L38
            goto L28
        L15:
            r103 = "";
            goto L47
        }

        public static Cursor a(ContentResolver r110, Uri r111) {
            f06.c r100 = new f06.c();
            Object[] r101 = {r111, null, null, null, null};
            f06.b r112 = new f06.b();
            f06.d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
            if (r113.f474982a == false) goto L6;
            r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
            return (Cursor) r113.f474983b;
        L6:
            Cursor r114 = r110.query(r111, null, null, null, null);
            r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
            return r114;
        }

        public final boolean c(String r100, boolean r101) {
        L29:
            th = move-exception;
            TTTokenMonitor.d(th);
            return r101;
        L3:
            if (this.f449630b == true) goto L5;
            Cursor r102 = a(this.f449629a.getContentResolver(), AuthTokenMultiProcessSharedProvider.b(this.f449629a, r100, "boolean"));     // Catch: Throwable -> L29
            if (r102 == null) goto L41;
        L14:
            th = move-exception;
            TTTokenMonitor.d(th);     // Catch: Throwable -> L23
        L16:
            boolean r103 = r101;
        L32:
            r102.close();     // Catch: Exception -> L19 Throwable -> L29
        L22:
            return r103;
        L19:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L29
            goto L22
        L23:
            th = move-exception;
            r102.close();     // Catch: Exception -> L26 Throwable -> L29
        L28:
            throw th;     // Catch: Throwable -> L29
        L26:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L29
            goto L28
        L10:
            if (r102.moveToFirst() == false) goto L16;
            r103 = false;
            if (r102.getInt(0) <= 0) goto L32;
            r103 = true;
            goto L32
        L41:
            return r101;
        L5:
            return this.f449631c.getBoolean(r100, r101);
        }

        public final int d(String r100, int r101) {
        L28:
            th = move-exception;
            TTTokenMonitor.d(th);
            return r101;
        L3:
            if (this.f449630b == true) goto L5;
            Cursor r102 = a(this.f449629a.getContentResolver(), AuthTokenMultiProcessSharedProvider.b(this.f449629a, r100, "integer"));     // Catch: Throwable -> L28
            if (r102 == null) goto L40;
        L13:
            th = move-exception;
            TTTokenMonitor.d(th);     // Catch: Throwable -> L22
        L15:
            int r103 = r101;
        L36:
            r102.close();     // Catch: Exception -> L18 Throwable -> L28
        L21:
            return r103;
        L18:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L28
            goto L21
        L22:
            th = move-exception;
            r102.close();     // Catch: Exception -> L25 Throwable -> L28
        L27:
            throw th;     // Catch: Throwable -> L28
        L25:
            e = move-exception;
            TTTokenMonitor.d(e);     // Catch: Throwable -> L28
            goto L27
        L10:
            if (r102.moveToFirst() == false) goto L15;
            r103 = r102.getInt(0);     // Catch: Throwable -> L13
        L40:
            return r101;
        L5:
            return this.f449631c.getInt(r100, r101);
        }

        public b(Context r100, String r101, boolean r102) {
            this.f449630b = false;
            this.f449630b = r102;
            Context r103 = r100.getApplicationContext();
            this.f449629a = r103;
            AuthTokenMultiProcessSharedProvider.f449622i = r101;
            this.f449631c = r103.getApplicationContext().getSharedPreferences(AuthTokenMultiProcessSharedProvider.f449622i, 4);
            tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShared create");
        }
    }

    public final synchronized SharedPreferences c() {
        monitor-enter(this);
        SharedPreferences r100 = this.f449623a;     // Catch: Throwable -> L10
        if (r100 != null) goto L8;
        SharedPreferences r101 = getContext().getApplicationContext().getSharedPreferences(f449622i, 4);     // Catch: Throwable -> L10
        this.f449623a = r101;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L8:
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean f() {
        if (TextUtils.isEmpty(f449618e) == false) goto L6;
        return true;
    L6:
        if (f449620g == null) goto L10;
        return false;
    L10:
        return true;
    }

    public final void a() {
        if (this.f449625c == true) goto L14;
        Object r100 = this.f449626d;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f449625c == true) goto L9;
        g();     // Catch: Throwable -> L11
        this.f449625c = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (com.ss.android.account.k.f406318b == null) goto L6;
        com.ss.android.account.k.f406318b.isLocalTest();
    L6:
        if (getContext() == null) goto L11;
        if ((getContext().getApplicationContext() instanceof Application) == false) goto L11;
        com.bytedance.sdk.account.utils.d.c((Application) getContext().getApplicationContext());
    L11:
        if (f449620g == null) goto L19;
        return true;
    L19:
        tb7.a.a("AuthTokenMultiProcessSharedProvider", "init form onCreate");     // Catch: Exception -> L14
        e(getContext());     // Catch: Exception -> L14
        return true;
    L14:
        e = move-exception;
        TTTokenMonitor.d(e);
        e.printStackTrace();
        return false;
    }

    public AuthTokenMultiProcessSharedProvider() {
        this.f449624b = new ConcurrentHashMap();
        this.f449625c = false;
        this.f449626d = new Object();
    }

    public final void g() {
        SharedPreferences r100 = c();
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ?>> r101 = r100.getAll().entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L16;
        Map.Entry<String, ?> r102 = r101.next();
        String r103 = r102.getKey();
        Object r104 = r102.getValue();
        if (r104 == null) goto L17;
        if (r103 == null) goto L17;
        ((ConcurrentHashMap) this.f449624b).put(r103, r104);
    L17:
        tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider loadValues key_ = " + r103 + " value_ = " + r104);     // Catch: Exception -> L14
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L14
        r105.put("key_", r103);     // Catch: Exception -> L14
        r105.put("value_", r104);     // Catch: Exception -> L14
        TTTokenMonitor.t("token_sp_error", r105);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L7
    }

    public static void e(Context r100) throws IllegalStateException {
        if (TextUtils.isEmpty(f449618e) == false) goto L6;
        f449618e = d(r100, AuthTokenMultiProcessSharedProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(f449618e) == true) goto L10;
        tb7.a.a("AuthTokenMultiProcessSharedProvider", f449618e);
        UriMatcher r101 = new UriMatcher(-1);
        f449620g = r101;
        r101.addURI(f449618e, "*/*", 65536);
        f449619f = UriProtector.parse("content://" + f449618e);
        return;
    L10:
        throw new IllegalStateException("Must Set AuthTokenMultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        a();
        return "vnd.android.cursor.item/vnd." + f449618e + ".item";
    }

    public static String d(Context r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L23;
        ProviderInfo[] r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 8).providers;     // Catch: Exception -> L13
        int r103 = r102.length;     // Catch: Exception -> L13
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L16;
        ProviderInfo r105 = r102[r104];     // Catch: Exception -> L13
        if (r101.equals(r105.name) == true) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        return r105.authority;
    L16:
        return r100.getPackageName() + ".auth_token.SHARE_PROVIDER_AUTHORITY";
    L13:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L16
    L23:
        return null;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r100, ProviderInfo r101) {
        if (r101 == null) goto L4;
        f449618e = r101.authority;
    L4:
        super.attachInfo(r100, r101);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r110, ContentValues r111) {
        a();
        if (f() == false) goto L6;
        return null;
    L6:
        if (f449620g.match(r110) != 65536) goto L96;
        com.bytedance.sdk.account.settings.common.a.a();     // Catch: Exception -> L92
        int r100 = com.bytedance.sdk.account.settings.common.a.f269379c0;     // Catch: Exception -> L92
        if (r100 > 0) goto L10;
        boolean r101 = true;
    L12:
        if (r100 == 2) goto L14;
        boolean r102 = true;
    L15:
        ArrayList r112 = new ArrayList();     // Catch: Exception -> L92
        Iterator<Map.Entry<String, Object>> r113 = r111.valueSet().iterator();     // Catch: Exception -> L92
        SharedPreferences.Editor r114 = null;
        boolean r115 = false;
    L17:
        if (r113.hasNext() == false) goto L81;
        Map.Entry<String, Object> r116 = r113.next();     // Catch: Exception -> L92
        Object r117 = r116.getValue();     // Catch: Exception -> L92
        String r118 = r116.getKey();     // Catch: Exception -> L92
        tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider reallly insert key = " + r118 + " value = " + TokenFactory.l(r117));     // Catch: Exception -> L92
        if (r118 == null) goto L17;
        if (r117 != null) goto L23;
        ((ConcurrentHashMap) this.f449624b).remove(r118);     // Catch: Exception -> L92
    L30:
        boolean r103 = true;
    L31:
        if (r103 == false) goto L17;
        tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider reallly insert key = " + r118 + " value = " + TokenFactory.l(r117));     // Catch: Exception -> L92
        if (r101 == false) goto L55;
        if (r114 != null) goto L36;
        r114 = c().edit();     // Catch: Exception -> L92
    L36:
        if (r117 != null) goto L39;
        r114.remove(r118);     // Catch: Exception -> L92
        goto L55
    L39:
        if ((r117 instanceof String) == false) goto L42;
        r114.putString(r118, (String) r117);     // Catch: Exception -> L92
        goto L55
    L42:
        if ((r117 instanceof Boolean) == false) goto L45;
        r114.putBoolean(r118, ((Boolean) r117).booleanValue());     // Catch: Exception -> L92
        goto L55
    L45:
        if ((r117 instanceof Long) == false) goto L48;
        r114.putLong(r118, ((Long) r117).longValue());     // Catch: Exception -> L92
        goto L55
    L48:
        if ((r117 instanceof Integer) == false) goto L51;
        r114.putInt(r118, ((Integer) r117).intValue());     // Catch: Exception -> L92
        goto L55
    L51:
        if ((r117 instanceof Float) == false) goto L54;
        r114.putFloat(r118, ((Float) r117).floatValue());     // Catch: Exception -> L92
        goto L55
    L54:
        throw new IllegalArgumentException("Unsupported type " + r110);     // Catch: Exception -> L92
    L55:
        if (r102 == false) goto L80;
        String r104 = "string";
        if (r117 != null) goto L59;
        com.ss.android.token.a r105 = new com.ss.android.token.a(this, r118, "string");     // Catch: Exception -> L92
    L78:
        if (r105 == null) goto L80;
        r112.add(r105);     // Catch: Exception -> L92
        goto L80
    L59:
        if ((r117 instanceof String) == false) goto L62;
    L74:
        if (r104 == null) goto L76;
        r105 = new com.ss.android.token.a(this, r118, r104);     // Catch: Exception -> L92
        goto L78
    L76:
        r105 = null;
        goto L78
    L62:
        if ((r117 instanceof Boolean) == false) goto L65;
        r104 = "boolean";
        goto L74
    L65:
        if ((r117 instanceof Long) == false) goto L68;
        r104 = "long";
        goto L74
    L68:
        if ((r117 instanceof Integer) == false) goto L71;
        r104 = "integer";
        goto L74
    L71:
        if ((r117 instanceof Float) == false) goto L73;
        r104 = "float";
        goto L74
    L73:
        r104 = null;
    L80:
        r115 = true;
        goto L17
    L23:
        Object r106 = ((ConcurrentHashMap) this.f449624b).get(r118);     // Catch: Exception -> L92
        if (r106 != null) goto L26;
    L29:
        ((ConcurrentHashMap) this.f449624b).put(r118, r117);     // Catch: Exception -> L92
        goto L30
    L26:
        if (r106.equals(r117) == false) goto L29;
        r103 = false;
        goto L31
    L81:
        if (r115 == true) goto L83;
        return null;
    L83:
        if (r101 == false) goto L86;
        if (r114 == null) goto L86;
        r114.apply();     // Catch: Exception -> L92
    L86:
        if (r102 == false) goto L94;
        Iterator r107 = r112.iterator();     // Catch: Exception -> L92
    L89:
        if (r107.hasNext() == false) goto L94;
        ((Runnable) r107.next()).run();     // Catch: Exception -> L92
    L94:
        return null;
    L14:
        r102 = false;
        goto L15
    L10:
        r101 = false;
    L92:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L94
    L96:
        throw new IllegalArgumentException("Unsupported uri " + r110);
    }

    public static final synchronized Uri b(Context r100, String r101, String r102) {
        monitor-enter(AuthTokenMultiProcessSharedProvider.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f449619f == null) goto L20;
    L13:
        Uri r103 = f449619f.buildUpon().appendPath(r101).appendPath(r102).build();     // Catch: Throwable -> L16
        monitor-exit(AuthTokenMultiProcessSharedProvider.class);
        return r103;
    L20:
        tb7.a.a("MultiProcessSharedProvider", "init form getContentUri");     // Catch: Exception -> L8 Throwable -> L16
        e(r100);     // Catch: Exception -> L8 Throwable -> L16
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        TTTokenMonitor.d(e);     // Catch: Throwable -> L16
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        a();
        if (f() == false) goto L6;
        return 0;
    L6:
        if (f449620g.match(r100) != 65536) goto L13;
        ((ConcurrentHashMap) this.f449624b).clear();     // Catch: Exception -> L9
        c().edit().clear().commit();     // Catch: Exception -> L9
        getContext().getContentResolver().notifyChange(b(getContext(), "key", "type"), null);     // Catch: Exception -> L9
    L11:
        return 0;
    L9:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L11
    L13:
        throw new IllegalArgumentException("Unsupported uri " + r100);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.database.Cursor] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        a();
        String r105 = null;
        if (f() == false) goto L6;
        return null;
    L6:
        if (f449620g.match(r100) != 65536) goto L56;
        int r106 = 1;
        if ("all".equals((String) ListProtector.get(r100.getPathSegments(), 1)) == false) goto L37;
        Map<String, ?> r107 = c().getAll();     // Catch: Exception -> L52
        MatrixCursor r108 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L52
        Iterator<Map.Entry<String, ?>> r109 = r107.entrySet().iterator();     // Catch: Exception -> L35
    L11:
        if (r109.hasNext() == false) goto L57;
        Map.Entry<String, ?> r110 = r109.next();     // Catch: Exception -> L35
        r105 = r110.getKey();     // Catch: Exception -> L35
        Object r111 = r110.getValue();     // Catch: Exception -> L35
        MatrixCursor.RowBuilder r112 = r108.newRow();     // Catch: Exception -> L35
        String r113 = "string";
        if ((r111 instanceof String) == true) goto L33;
        if ((r111 instanceof Boolean) == false) goto L25;
        r113 = "boolean";
        if (((Boolean) r111).booleanValue() == false) goto L22;
        int r114 = 1;
    L23:
        r111 = Integer.valueOf(r114);     // Catch: Exception -> L35
        goto L33
    L22:
        r114 = 0;
        goto L23
    L25:
        if ((r111 instanceof Integer) == false) goto L28;
        r113 = "integer";
        goto L33
    L28:
        if ((r111 instanceof Long) == false) goto L31;
        r113 = "long";
        goto L33
    L31:
        if ((r111 instanceof Float) == false) goto L33;
        r113 = "float";
    L33:
        r112.add(r105);     // Catch: Exception -> L35
        r112.add(r111);     // Catch: Exception -> L35
        r112.add(r113);     // Catch: Exception -> L35
    L57:
        return r108;
    L35:
        e = e;
        r105 = r108;
    L53:
        TTTokenMonitor.d(e);
        return r105;
    L37:
        String r115 = (String) ListProtector.get(r100.getPathSegments(), 0);     // Catch: Exception -> L52
        if (((ConcurrentHashMap) this.f449624b).containsKey(r115) == true) goto L40;
        return null;
    L40:
        MatrixCursor r116 = new MatrixCursor(new String[]{r115});     // Catch: Exception -> L52
        r105 = ((ConcurrentHashMap) this.f449624b).get(r115);     // Catch: Exception -> L50
        MatrixCursor.RowBuilder r117 = r116.newRow();     // Catch: Exception -> L50
        if ((r105 instanceof Boolean) == true) goto L44;
    L48:
        tb7.a.a("AuthTokenMultiProcessShared", "MultiProcessShareProvider  get key = " + r115 + " value = " + TokenFactory.l(r105));     // Catch: Exception -> L50
        r117.add(r105);     // Catch: Exception -> L50
        r108 = r116;
        goto L57
    L44:
        if (((Boolean) r105).booleanValue() == true) goto L47;
        r106 = 0;
    L47:
        r105 = Integer.valueOf(r106);     // Catch: Exception -> L50
    L50:
        e = e;
        r105 = r116;
    L52:
        e = e;
        goto L53
    L56:
        throw new IllegalArgumentException("Unsupported uri " + r100);
    }
}
