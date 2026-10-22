package com.bytedance.push.settings.storage;

import a87.b;
import a87.d;
import a87.f;
import a87.g;
import a87.k;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import j77.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import q77.a;

/* JADX INFO: loaded from: classes3.dex */
public class MainProcessSettingsProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f267019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Uri f267020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static UriMatcher f267021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f267022d;

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        f267022d = true;
        if (f267021c != null) goto L11;
        b(getContext());     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L11:
        return true;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    public MainProcessSettingsProvider() {
    }

    public static void b(Context r100) throws IllegalStateException {
        if (TextUtils.isEmpty(f267019a) == false) goto L21;
        String r101 = MainProcessSettingsProvider.class.getName();
        int r102 = a.f531973a;
        if (r100 != null) goto L26;
        String r103 = null;
    L19:
        f267019a = r103;
        goto L21
    L26:
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        r103 = r100.getPackageName() + ".push.settings";
        goto L19
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        ProviderInfo[] r104 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 8).providers;     // Catch: Exception -> L16
        int r105 = r104.length;     // Catch: Exception -> L16
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L18;
        ProviderInfo r107 = r104[r106];     // Catch: Exception -> L16
        if (r101.equals(r107.name) == true) goto L13;
        r106 = r106 + 1;
        goto L10
    L13:
        r103 = r107.authority;     // Catch: Exception -> L16
    L21:
        if (TextUtils.isEmpty(f267019a) == true) goto L25;
        UriMatcher r108 = new UriMatcher(-1);
        f267021c = r108;
        r108.addURI(f267019a, "*/*/*/*", 65536);
        f267020b = UriProtector.parse("content://" + f267019a);
        return;
    L25:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return "vnd.android.cursor.item/vnd." + f267019a + ".item";
    }

    public static synchronized Uri a(Context r100, b r101) {
        monitor-enter(MainProcessSettingsProvider.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (f267020b == null) goto L24;
    L13:
        if (r101 != null) goto L17;
        Uri r102 = f267020b;     // Catch: Throwable -> L20
        monitor-exit(MainProcessSettingsProvider.class);
        return r102;
    L17:
        Uri r103 = r101.b(f267020b);     // Catch: Throwable -> L20
        monitor-exit(MainProcessSettingsProvider.class);
        return r103;
    L24:
        b(r100);     // Catch: Exception -> L8 Throwable -> L20
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        return null;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r100, ProviderInfo r101) {
        if (r101 == null) goto L4;
        f267019a = r101.authority;
    L4:
        super.attachInfo(r100, r101);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r110, ContentValues r111) {
        if (TextUtils.isEmpty(f267019a) == false) goto L6;
    L7:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L13;
        return null;
    L13:
        if (f267021c.match(r110) != 65536) goto L69;
        List<String> r101 = r110.getPathSegments();
        if (r101 != null) goto L17;
        return null;
    L17:
        String r102 = (String) ListProtector.get(r101, 0);
        k r103 = i.f497636a.a(getContext(), true, r102, PullConfiguration.PROCESS_NAME_MAIN);     // Catch: Exception -> L65
        int r104 = a.f531973a;     // Catch: Exception -> L65
        SharedPreferences.Editor r105 = r103.edit();     // Catch: Exception -> L65
        ArrayList r106 = new ArrayList();     // Catch: Exception -> L65
        Iterator<Map.Entry<String, Object>> r112 = r111.valueSet().iterator();     // Catch: Exception -> L65
    L20:
        if (r112.hasNext() == false) goto L58;
        Map.Entry<String, Object> r107 = r112.next();     // Catch: Exception -> L65
        Object r108 = r107.getValue();     // Catch: Exception -> L65
        String r109 = r107.getKey();     // Catch: Exception -> L65
        if (r108 == null) goto L23;
        if ((r108 instanceof String) == true) goto L27;
        if ((r108 instanceof Boolean) == true) goto L33;
        if ((r108 instanceof Long) == true) goto L39;
        if ((r108 instanceof Integer) == true) goto L45;
        if ((r108 instanceof Float) == false) goto L57;
        if (r103.a(r109) == ((Float) r108).floatValue()) goto L20;
        r105.putFloat(r109, ((Float) r108).floatValue());     // Catch: Exception -> L65
        String r113 = "float";
    L54:
        if (r113 == null) goto L20;
        r106.add(new d(r102, r109, r113, getContext()));     // Catch: Exception -> L65
        goto L20
    L57:
        throw new IllegalArgumentException("Unsupported type " + r110);     // Catch: Exception -> L65
    L45:
        if (r103.getInt(r109) == ((Integer) r108).intValue()) goto L20;
        r105.putInt(r109, ((Integer) r108).intValue());     // Catch: Exception -> L65
        r113 = "integer";
        goto L54
    L39:
        if (r103.getLong(r109) == ((Long) r108).longValue()) goto L20;
        r105.putLong(r109, ((Long) r108).longValue());     // Catch: Exception -> L65
        r113 = "long";
        goto L54
    L33:
        if (r103.getBoolean(r109) == ((Boolean) r108).booleanValue()) goto L20;
        r105.putBoolean(r109, ((Boolean) r108).booleanValue());     // Catch: Exception -> L65
        r113 = "boolean";
        goto L54
    L27:
        if (TextUtils.equals(r103.getString(r109), (String) r108) == true) goto L20;
        r105.putString(r109, (String) r108);     // Catch: Exception -> L65
        r113 = "string";
        goto L54
    L23:
        r105.remove(r109);     // Catch: Exception -> L65
        r113 = null;
        goto L54
    L58:
        if (r105 != null) goto L60;
        return null;
    L60:
        r105.apply();     // Catch: Exception -> L65
        Iterator r114 = r106.iterator();     // Catch: Exception -> L65
    L62:
        if (r114.hasNext() == false) goto L67;
        ((Runnable) r114.next()).run();     // Catch: Exception -> L65
    L67:
        return null;
    L65:
        e = move-exception;
        e.printStackTrace();
        goto L67
    L69:
        throw new IllegalArgumentException("Unsupported uri " + r110);
    L6:
        if (f267021c == null) goto L7;
        r100 = false;
        goto L10
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        f r103 = (f) ((ConcurrentHashMap) g.f2178a).get(r100);
        if (r103 != null) goto L6;
        return null;
    L6:
        return r103.a(getContext(), r102, PullConfiguration.PROCESS_NAME_MAIN);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        if (TextUtils.isEmpty(f267019a) == false) goto L6;
    L7:
        boolean r105 = true;
    L10:
        if (r105 == false) goto L13;
        return null;
    L13:
        if (f267021c.match(r100) == 65536) goto L15;
        return null;
    L15:
        b r106 = b.a(r100);
        if (r106 != null) goto L18;
        return null;
    L18:
        if (TextUtils.isEmpty(r106.f2155a) == false) goto L20;
        return null;
    L20:
        if (TextUtils.isEmpty(r106.f2156b) == false) goto L22;
        return null;
    L22:
        if (TextUtils.isEmpty(r106.f2158d) == true) goto L60;
        k r107 = i.f497636a.a(getContext(), true, r106.f2155a, PullConfiguration.PROCESS_NAME_MAIN);
        int r108 = a.f531973a;
        String r109 = r106.f2158d;
        r109.getClass();
        byte r110 = -1;
        switch(r109.hashCode()) {
            case -891985903: goto L44;
            case 3327612: goto L40;
            case 64711720: goto L36;
            case 97526364: goto L32;
            case 1958052158: goto L28;
            default: goto L47;
        };
    L47:
        switch(r110) {
            case 0: goto L54;
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            default: goto L49;
        };
    L50:
        Object r111 = Integer.valueOf(r107.getInt(r106.f2156b, CastIntegerProtector.parseInt(r106.f2157c)));
    L55:
        MatrixCursor r112 = new MatrixCursor(new String[]{r106.f2156b});
        r112.newRow().add(r111);
        return r112;
    L51:
        r111 = Float.valueOf(r107.getFloat(r106.f2156b, CastFloatProtector.parseFloat(r106.f2157c)));
        goto L55
    L52:
        r111 = Integer.valueOf(r107.getBoolean(r106.f2156b, Boolean.parseBoolean(r106.f2157c)) ? 1 : 0);
        goto L55
    L53:
        r111 = Long.valueOf(r107.getLong(r106.f2156b, CastLongProtector.parseLong(r106.f2157c)));
        goto L55
    L54:
        r111 = r107.getString(r106.f2156b, r106.f2157c);
        goto L55
    L49:
        throw new IllegalArgumentException("unknown type");
    L28:
        if (r109.equals("integer") == false) goto L47;
        r110 = 4;
        goto L47
    L32:
        if (r109.equals("float") == false) goto L47;
        r110 = 3;
        goto L47
    L36:
        if (r109.equals("boolean") == false) goto L47;
        r110 = 2;
        goto L47
    L40:
        if (r109.equals("long") == false) goto L47;
        r110 = 1;
        goto L47
    L44:
        if (r109.equals("string") == false) goto L47;
        r110 = 0;
        goto L47
    L60:
        return null;
    L6:
        if (f267021c == null) goto L7;
        r105 = false;
        goto L10
    }
}
