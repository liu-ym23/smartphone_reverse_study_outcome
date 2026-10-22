package com.bytedance.upc.cache;

import android.app.ActivityManager;
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
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ApiMultiProcessSharedProvider extends ContentProvider {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f272438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Uri f272439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static UriMatcher f272440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f272441h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f272442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f272443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f272444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f272445d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f272446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ContentValues f272447b;

        public final synchronized void a() {
            monitor-enter(this);
            Context r100 = this.f272446a;     // Catch: Throwable -> L7
            String r101 = ApiMultiProcessSharedProvider.f272438e;     // Catch: Throwable -> L7
            b(r100.getContentResolver(), ApiMultiProcessSharedProvider.b(this.f272446a, "key", "type"), this.f272447b);     // Catch: Throwable -> L10
        L5:
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public a(Context r100) {
            this.f272447b = new ContentValues();
            Context r101 = r100.getApplicationContext();
            this.f272446a = r101;
            r101.getApplicationContext().getSharedPreferences("upc_sdk_multi_process_sp", 4);
        }

        public final void c(String r100, Set r101) {
            String r102 = ApiMultiProcessSharedProvider.f272438e;
            StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L10
            Iterator r104 = r101.iterator();     // Catch: Throwable -> L10
        L6:
            if (r104.hasNext() == false) goto L8;
            r103.append((String) r104.next());     // Catch: Throwable -> L10
            r103.append(",");     // Catch: Throwable -> L10
            goto L6
        L8:
            String r105 = r103.toString();     // Catch: Throwable -> L10
            String r106 = r105.substring(0, r105.lastIndexOf(","));     // Catch: Throwable -> L10
        L11:
            this.f272447b.put(r100, r106);
            return;
        L10:
            r106 = "";
            goto L11
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
        public final Context f272448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f272449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SharedPreferences f272450c;

        public b(Context r100) {
            boolean r101 = false;
            this.f272449b = false;
            Boolean r102 = jp7.b.f499995b;
            if (r102 == null) goto L6;
            r101 = r102.booleanValue();
        L71:
            this.f272449b = r101;
            Context r103 = r100.getApplicationContext();
            this.f272448a = r103;
            this.f272450c = r103.getApplicationContext().getSharedPreferences("upc_sdk_multi_process_sp", 4);
            return;
        L6:
            if (TextUtils.isEmpty(jp7.b.f499994a) == false) goto L66;
            if (TextUtils.isEmpty(jp7.b.f499994a) == true) goto L11;
            String r104 = jp7.b.f499994a;
        L64:
            jp7.b.f499994a = r104;
            goto L66
        L11:
            if (Build.VERSION.SDK_INT >= 28) goto L73;
        L16:
            String r105 = null;
        L17:
            jp7.b.f499994a = r105;
            if (TextUtils.isEmpty(r105) == true) goto L75;
            r104 = jp7.b.f499994a;
            goto L64
        L75:
            Method r106 = jp7.b.a(Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L24
            r106.setAccessible(true);     // Catch: Throwable -> L24
            Object r107 = r106.invoke(null, new Object[0]);     // Catch: Throwable -> L24
            if ((r107 instanceof String) == false) goto L26;
            String r108 = (String) r107;     // Catch: Throwable -> L24
        L27:
            jp7.b.f499994a = r108;
            if (TextUtils.isEmpty(r108) == true) goto L79;
            r104 = jp7.b.f499994a;
            goto L64
        L79:
            BufferedReader r109 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L41
            StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L40
        L33:
            int r111 = r109.read();     // Catch: Throwable -> L40
            if (r111 <= 0) goto L36;
            r110.append((char) r111);     // Catch: Throwable -> L40
            goto L33
        L36:
            String r112 = r110.toString();     // Catch: Throwable -> L40
            r109.close();     // Catch: Exception -> L39
        L47:
            jp7.b.f499994a = r112;
            if (TextUtils.isEmpty(r112) == true) goto L50;
            r104 = jp7.b.f499994a;
            goto L64
        L50:
            if (r100 == null) goto L62;
            int r113 = Process.myPid();
            ActivityManager r114 = (ActivityManager) r100.getSystemService("activity");
            if (r114 == null) goto L62;
            List<ActivityManager.RunningAppProcessInfo> r115 = r114.getRunningAppProcesses();
            if (r115 == null) goto L62;
            Iterator<ActivityManager.RunningAppProcessInfo> r116 = r115.iterator();
        L58:
            if (r116.hasNext() == false) goto L62;
            ActivityManager.RunningAppProcessInfo r117 = r116.next();
            if (r117.pid != r113) goto L58;
            r104 = r117.processName;
        L63:
            jp7.b.f499994a = r104;
        L62:
            r104 = null;
        L42:
            if (r109 != null) goto L83;
        L46:
            r112 = null;
            goto L47
        L83:
            r109.close();     // Catch: Exception -> L45
        L41:
            r109 = null;
        L26:
            r108 = null;
        L24:
            th = move-exception;
            th.printStackTrace();
            goto L26
        L73:
            r105 = Application.getProcessName();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
        L66:
            if (TextUtils.isEmpty(jp7.b.f499994a) == false) goto L68;
        L70:
            Boolean r118 = Boolean.valueOf(jp7.b.f499994a.equals(r100.getPackageName()));
            jp7.b.f499995b = r118;
            r101 = r118.booleanValue();
            goto L71
        L68:
            if (jp7.b.f499994a.contains(":") == false) goto L70;
            goto L70
        }

        public final int b(String r100) {
        L18:
            return 0;
        L4:
            if (this.f272449b == true) goto L17;
            Context r101 = this.f272448a;     // Catch: Throwable -> L18
            String r102 = ApiMultiProcessSharedProvider.f272438e;     // Catch: Throwable -> L18
            Cursor r103 = a(r101.getContentResolver(), ApiMultiProcessSharedProvider.b(this.f272448a, r100, "integer"));     // Catch: Throwable -> L18
            if (r103 == null) goto L26;
            if (r103.moveToFirst() == false) goto L12;
            int r104 = r103.getInt(0);     // Catch: Throwable -> L20
        L22:
            r103.close();     // Catch: Exception -> L19 Throwable -> L18
        L15:
            return r104;
        L12:
            r104 = 0;
            goto L22
        L26:
            return 0;
        L17:
            return this.f272450c.getInt(r100, 0);
        }

        public final String c(String r100) {
        L18:
            return "";
        L4:
            if (this.f272449b == true) goto L17;
            Context r101 = this.f272448a;     // Catch: Throwable -> L18
            String r102 = ApiMultiProcessSharedProvider.f272438e;     // Catch: Throwable -> L18
            Cursor r103 = a(r101.getContentResolver(), ApiMultiProcessSharedProvider.b(this.f272448a, r100, "string"));     // Catch: Throwable -> L18
            if (r103 == null) goto L26;
            if (r103.moveToFirst() == false) goto L12;
            String r104 = r103.getString(0);     // Catch: Throwable -> L20
        L21:
            r103.close();     // Catch: Exception -> L19 Throwable -> L18
        L15:
            return r104;
        L12:
            r104 = "";
            goto L21
        L26:
            return "";
        L17:
            return this.f272450c.getString(r100, "");
        }

        public final Set d(String r100) {
        L22:
            return null;
        L3:
            String r101 = "";
            if (this.f272449b == true) goto L14;
            Context r102 = this.f272448a;     // Catch: Throwable -> L22
            String r103 = ApiMultiProcessSharedProvider.f272438e;     // Catch: Throwable -> L22
            Cursor r104 = a(r102.getContentResolver(), ApiMultiProcessSharedProvider.b(this.f272448a, r100, "integer"));     // Catch: Throwable -> L22
            if (r104 != null) goto L29;
        L15:
            String r105 = ApiMultiProcessSharedProvider.f272438e;     // Catch: Throwable -> L22
            if (TextUtils.isEmpty(r101) == true) goto L20;
            return new HashSet(Arrays.asList(r101.split(",")));
        L20:
            return Collections.emptySet();
        L29:
            if (r104.moveToFirst() == false) goto L33;
            r101 = r104.getString(0);     // Catch: Throwable -> L26
        L33:
            r104.close();     // Catch: Exception -> L24 Throwable -> L22
            goto L15
        L14:
            r101 = this.f272450c.getString(r100, "");     // Catch: Throwable -> L22
            goto L15
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
    }

    public final synchronized SharedPreferences c() {
        monitor-enter(this);
        SharedPreferences r100 = this.f272442a;     // Catch: Throwable -> L10
        if (r100 != null) goto L8;
        SharedPreferences r101 = getContext().getApplicationContext().getSharedPreferences("upc_sdk_multi_process_sp", 4);     // Catch: Throwable -> L10
        this.f272442a = r101;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L8:
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean e() {
        if (TextUtils.isEmpty(f272438e) == false) goto L6;
        return true;
    L6:
        if (f272440g == null) goto L10;
        return false;
    L10:
        return true;
    }

    public final void a() {
        if (this.f272444c == true) goto L24;
        Object r100 = this.f272445d;
        monitor-enter(r100);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (this.f272444c == true) goto L19;
        SharedPreferences r101 = c();     // Catch: Throwable -> L21
        if (r101 == null) goto L18;
        Iterator<Map.Entry<String, ?>> r102 = r101.getAll().entrySet().iterator();     // Catch: Throwable -> L21
    L13:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, ?> r103 = r102.next();     // Catch: Throwable -> L21
        String r104 = r103.getKey();     // Catch: Throwable -> L21
        Object r105 = r103.getValue();     // Catch: Throwable -> L21
        if (r104 == null) goto L13;
        if (r105 == null) goto L13;
        ((ConcurrentHashMap) this.f272443b).put(r104, r105);     // Catch: Throwable -> L21
    L18:
        this.f272444c = true;     // Catch: Throwable -> L21
    L19:
        monitor-exit(r100);     // Catch: Throwable -> L21
        return;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (f272440g == null) goto L11;
        return true;
    L11:
        d(getContext());     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public ApiMultiProcessSharedProvider() {
        this.f272443b = new ConcurrentHashMap();
        this.f272444c = false;
        this.f272445d = new Object();
    }

    public static void d(Context r100) throws IllegalStateException {
        if (TextUtils.isEmpty(f272438e) == false) goto L20;
        String r101 = ApiMultiProcessSharedProvider.class.getName();
        boolean r102 = ip7.b.f495310a;
        if (r100 != null) goto L7;
    L17:
        String r103 = null;
    L18:
        f272438e = r103;
        goto L20
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L17;
        ProviderInfo[] r104 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 8).providers;     // Catch: Exception -> L25
        int r105 = r104.length;     // Catch: Exception -> L25
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L16;
        ProviderInfo r107 = r104[r106];     // Catch: Exception -> L25
        if (r101.equals(r107.name) == true) goto L13;
        r106 = r106 + 1;
        goto L10
    L13:
        r103 = r107.authority;     // Catch: Exception -> L25
    L16:
        r103 = r100.getPackageName() + ".UPC.SHARE_PROVIDER_AUTHORITY";
    L20:
        if (TextUtils.isEmpty(f272438e) == true) goto L24;
        boolean r108 = ip7.b.f495310a;
        UriMatcher r109 = new UriMatcher(-1);
        f272440g = r109;
        r109.addURI(f272438e, "*/*", 131072);
        f272439f = UriProtector.parse("content://" + f272438e);
        return;
    L24:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        a();
        return "vnd.android.cursor.item/vnd." + f272438e + ".item";
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r100, ProviderInfo r101) {
        if (r101 == null) goto L4;
        f272438e = r101.authority;
    L4:
        super.attachInfo(r100, r101);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        a();
        if (e() == false) goto L6;
        return null;
    L6:
        if (f272440g.match(r100) != 131072) goto L55;
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L51
        Iterator<Map.Entry<String, Object>> r103 = r101.valueSet().iterator();     // Catch: Exception -> L51
        SharedPreferences.Editor r104 = null;
    L9:
        if (r103.hasNext() == false) goto L44;
        Map.Entry<String, Object> r105 = r103.next();     // Catch: Exception -> L51
        Object r106 = r105.getValue();     // Catch: Exception -> L51
        String r107 = r105.getKey();     // Catch: Exception -> L51
        boolean r108 = true;
        if (r106 != null) goto L13;
        ((ConcurrentHashMap) this.f272443b).remove(r107);     // Catch: Exception -> L51
    L20:
        if (r108 == false) goto L9;
        if (r104 != null) goto L23;
        r104 = c().edit();     // Catch: Exception -> L51
    L23:
        if (r106 != null) goto L26;
        r104.remove(r107);     // Catch: Exception -> L51
        d r109 = null;
    L40:
        if (r109 == null) goto L9;
        r102.add(r109);     // Catch: Exception -> L51
        goto L9
    L26:
        if ((r106 instanceof String) == false) goto L29;
        r104.putString(r107, (String) r106);     // Catch: Exception -> L51
        r109 = new d(this, r107, "string");     // Catch: Exception -> L51
        goto L40
    L29:
        if ((r106 instanceof Boolean) == false) goto L32;
        r104.putBoolean(r107, ((Boolean) r106).booleanValue());     // Catch: Exception -> L51
        r109 = new d(this, r107, "boolean");     // Catch: Exception -> L51
        goto L40
    L32:
        if ((r106 instanceof Long) == false) goto L35;
        r104.putLong(r107, ((Long) r106).longValue());     // Catch: Exception -> L51
        r109 = new d(this, r107, "long");     // Catch: Exception -> L51
        goto L40
    L35:
        if ((r106 instanceof Integer) == false) goto L38;
        r104.putInt(r107, ((Integer) r106).intValue());     // Catch: Exception -> L51
        r109 = new d(this, r107, "integer");     // Catch: Exception -> L51
        goto L40
    L38:
        if ((r106 instanceof Float) == false) goto L43;
        r104.putFloat(r107, ((Float) r106).floatValue());     // Catch: Exception -> L51
        r109 = new d(this, r107, "float");     // Catch: Exception -> L51
        goto L40
    L43:
        throw new IllegalArgumentException("Unsupported type " + r100);     // Catch: Exception -> L51
    L13:
        Object r110 = ((ConcurrentHashMap) this.f272443b).get(r107);     // Catch: Exception -> L51
        if (r110 != null) goto L16;
    L19:
        ((ConcurrentHashMap) this.f272443b).put(r107, r106);     // Catch: Exception -> L51
        goto L20
    L16:
        if (r110.equals(r106) == false) goto L19;
        r108 = false;
        goto L20
    L44:
        if (r104 != null) goto L46;
        return null;
    L46:
        r104.apply();     // Catch: Exception -> L51
        Iterator r111 = r102.iterator();     // Catch: Exception -> L51
    L48:
        if (r111.hasNext() == false) goto L53;
        ((Runnable) r111.next()).run();     // Catch: Exception -> L51
    L53:
        return null;
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L53
    L55:
        throw new IllegalArgumentException("Unsupported uri " + r100);
    }

    public static final synchronized Uri b(Context r100, String r101, String r102) {
        monitor-enter(ApiMultiProcessSharedProvider.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f272439f == null) goto L19;
    L13:
        Uri r103 = f272439f.buildUpon().appendPath(r101).appendPath(r102).build();     // Catch: Throwable -> L16
        monitor-exit(ApiMultiProcessSharedProvider.class);
        return r103;
    L19:
        boolean r104 = ip7.b.f495310a;     // Catch: Exception -> L8 Throwable -> L16
        d(r100);     // Catch: Exception -> L8 Throwable -> L16
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        a();
        if (e() == false) goto L6;
        return 0;
    L6:
        if (f272440g.match(r100) != 131072) goto L9;
        return 0;
    L9:
        throw new IllegalArgumentException("Unsupported uri " + r100);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v8 */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        r100.toString();
        boolean r105 = ip7.b.f495310a;
        a();
        ?? r106 = 0;
        Object r107 = null;
        r107 = null;
        if (e() == false) goto L6;
        return null;
    L6:
        if (f272440g.match(r100) != 131072) goto L60;
        int r108 = 1;
        if ("all".equals((String) ListProtector.get(r100.getPathSegments(), 1)) == false) goto L36;
        Map<String, ?> r109 = c().getAll();     // Catch: Exception -> L61
        MatrixCursor r110 = new MatrixCursor(new String[]{"key_column", "value_column", "type_column"});     // Catch: Exception -> L61
        Iterator<Map.Entry<String, ?>> r111 = r109.entrySet().iterator();     // Catch: Exception -> L35
    L11:
        boolean r112 = r111.hasNext();     // Catch: Exception -> L35
        r106 = r112;
        if (r112 == false) goto L66;
        Map.Entry<String, ?> r113 = r111.next();     // Catch: Exception -> L35
        String r114 = r113.getKey();     // Catch: Exception -> L35
        Object r115 = r113.getValue();     // Catch: Exception -> L35
        MatrixCursor.RowBuilder r116 = r110.newRow();     // Catch: Exception -> L35
        String r117 = "string";
        if ((r115 instanceof String) == true) goto L33;
        if ((r115 instanceof Boolean) == false) goto L25;
        r117 = "boolean";
        if (((Boolean) r115).booleanValue() == false) goto L22;
        int r118 = 1;
    L23:
        r115 = Integer.valueOf(r118);     // Catch: Exception -> L35
        goto L33
    L22:
        r118 = 0;
        goto L23
    L25:
        if ((r115 instanceof Integer) == false) goto L28;
        r117 = "integer";
        goto L33
    L28:
        if ((r115 instanceof Long) == false) goto L31;
        r117 = "long";
        goto L33
    L31:
        if ((r115 instanceof Float) == false) goto L33;
        r117 = "float";
    L33:
        r116.add(r114);     // Catch: Exception -> L35
        r116.add(r115);     // Catch: Exception -> L35
        r116.add(r117);     // Catch: Exception -> L35
    L66:
        return r110;
    L35:
        r106 = r110;
        goto L75
    L36:
        String r119 = (String) ListProtector.get(r100.getPathSegments(), 0);     // Catch: Exception -> L61
        boolean r120 = TextUtils.equals(r119, "current_app_state");     // Catch: Exception -> L61
        boolean r121 = TextUtils.equals(r119, "current_app_foreground");     // Catch: Exception -> L61
        if (((ConcurrentHashMap) this.f272443b).containsKey(r119) == true) goto L41;
        if (r120 == true) goto L41;
        if (r121 == true) goto L41;
        return null;
    L41:
        MatrixCursor r122 = new MatrixCursor(new String[]{r119});     // Catch: Exception -> L61
        if (r120 == true) goto L47;
        if (r121 == true) goto L47;
        r107 = ((ConcurrentHashMap) this.f272443b).get(r119);     // Catch: Exception -> L56
    L56:
        r106 = r122;
    L47:
        MatrixCursor.RowBuilder r123 = r122.newRow();     // Catch: Exception -> L56
        boolean r124 = r107 instanceof Boolean;     // Catch: Exception -> L56
        Object r125 = r107;
        if (r124 == true) goto L50;
    L54:
        r123.add(r125);     // Catch: Exception -> L56
        r110 = r122;
        r106 = r125;
        goto L66
    L50:
        if (((Boolean) r107).booleanValue() == true) goto L53;
        r108 = 0;
    L53:
        r125 = Integer.valueOf(r108);     // Catch: Exception -> L56
    L75:
        return r106;
    L60:
        throw new IllegalArgumentException("Unsupported uri " + r100);
    }
}
