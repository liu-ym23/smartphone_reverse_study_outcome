package eac;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.g;
import com.ss.android.lark.log.Log;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements SharedPreferences, SharedPreferences.Editor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f471767a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f471768a = null;

        static {
            f471768a = new b();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        return true;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return this;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        delete(this.f471767a.getContentResolver(), UriProtector.parse(y1c.a.f565680a + "/clean"));
        return this;
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        Cursor r100 = b(this.f471767a.getContentResolver(), UriProtector.parse(y1c.a.f565680a + "/get_all"));     // Catch: Throwable -> L39
        HashMap r101 = new HashMap();
        if (r100 != null) goto L7;
    L38:
        return r101;
    L7:
        if (r100.moveToFirst() == false) goto L38;
        int r102 = r100.getColumnIndex("cursor_name");
        int r103 = r100.getColumnIndex("cursor_type");
        int r104 = r100.getColumnIndex("cursor_value");
    L9:
        String r105 = r100.getString(r102);
        String r106 = r100.getString(r103);
        if (r106.equalsIgnoreCase("string") == false) goto L20;
        String r107 = r100.getString(r104);
        boolean r108 = r107.contains("__COMMA__");
        Object r109 = r107;
        if (r108 == false) goto L35;
        boolean r110 = r107.matches("\\[.*\\]");
        r109 = r107;
        if (r110 == false) goto L35;
        String[] r111 = r107.substring(1, r107.length() - 1).split(", ");
        HashSet r112 = new HashSet();
        int r113 = r111.length;
        int r114 = 0;
    L16:
        if (r114 >= r113) goto L18;
        r112.add(r111[r114].replace("__COMMA__", ", "));
        r114 = r114 + 1;
        goto L16
    L18:
        r109 = r112;
    L35:
        r101.put(r105, r109);
        if (r100.moveToNext() == true) goto L9;
        r100.close();
        goto L38
    L20:
        if (r106.equalsIgnoreCase("boolean") == false) goto L23;
        r109 = r100.getString(r104);
        goto L35
    L23:
        if (r106.equalsIgnoreCase("int") == false) goto L26;
        r109 = Integer.valueOf(r100.getInt(r104));
        goto L35
    L26:
        if (r106.equalsIgnoreCase("long") == false) goto L29;
        r109 = Long.valueOf(r100.getLong(r104));
        goto L35
    L29:
        if (r106.equalsIgnoreCase("float") == false) goto L32;
        r109 = Float.valueOf(r100.getFloat(r104));
        goto L35
    L32:
        if (r106.equalsIgnoreCase("string_set") == false) goto L34;
        r109 = r100.getString(r104);
        goto L35
    L34:
        r109 = null;
    L39:
        th = move-exception;
        throw new RuntimeException(th);
    }

    public b() {
        this.f471767a = g.getContext();
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r100) {
        String r101 = getType(this.f471767a.getContentResolver(), UriProtector.parse(y1c.a.f565680a + "/contain/" + r100));
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.equals("null") == false) goto L8;
        return false;
    L8:
        return Boolean.parseBoolean(r101);
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String r100) {
        delete(this.f471767a.getContentResolver(), UriProtector.parse(y1c.a.f565680a + "/long/" + r100));
        return this;
    }

    public static int a(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, null, null};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240019);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r210.delete(r211, null, null);
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Cursor b(ContentResolver r110, Uri r111) {
        c r100 = new c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }

    private int delete(ContentResolver r100, Uri r101) {
        return a(r100, r101);
    L4:
        e = move-exception;
        Log.e("SPHelper", "delete uri:" + r101, e);
        return -1;
    }

    private String getType(ContentResolver r100, Uri r101) {
        return r100.getType(r101);
    L4:
        return null;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r100, boolean r101) {
        String r102 = getType(this.f471767a.getContentResolver(), UriProtector.parse(y1c.a.f565680a + "/boolean/" + r100));
        if (r102 != null) goto L5;
    L9:
        return r101;
    L5:
        if (r102.equals("null") == true) goto L9;
        return Boolean.parseBoolean(r102);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r100, float r101) {
        String r102 = getType(this.f471767a.getContentResolver(), UriProtector.parse(y1c.a.f565680a + "/float/" + r100));
        if (r102 != null) goto L5;
    L9:
        return r101;
    L5:
        if (r102.equals("null") == true) goto L9;
        return CastFloatProtector.parseFloat(r102);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r100, int r101) {
        String r102 = getType(this.f471767a.getContentResolver(), UriProtector.parse(y1c.a.f565680a + "/int/" + r100));
        if (r102 != null) goto L5;
    L9:
        return r101;
    L5:
        if (r102.equals("null") == true) goto L9;
        return CastIntegerProtector.parseInt(r102);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r100, long r101) {
        String r102 = getType(this.f471767a.getContentResolver(), UriProtector.parse(y1c.a.f565680a + "/long/" + r100));
        if (r102 != null) goto L5;
    L9:
        return r101;
    L5:
        if (r102.equals("null") == true) goto L9;
        return CastLongProtector.parseLong(r102);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r100, String r101) {
        String r102 = getType(this.f471767a.getContentResolver(), UriProtector.parse(y1c.a.f565680a + "/string/" + r100));
        if (r102 != null) goto L5;
    L8:
        return r101;
    L5:
        if (r102.equals("null") == true) goto L8;
        return r102;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        String r102 = getType(this.f471767a.getContentResolver(), UriProtector.parse(y1c.a.f565680a + "/string_set/" + r100));
        if (r102 != null) goto L5;
    L14:
        return r101;
    L5:
        if (r102.equals("null") == true) goto L14;
        if (r102.matches("\\[.*\\]") == true) goto L10;
        return r101;
    L10:
        String[] r103 = r102.substring(1, r102.length() - 1).split(", ");
        HashSet r104 = new HashSet();
        int r105 = r103.length;
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L13;
        r104.add(r103[r106].replace("__COMMA__", ", "));
        r106 = r106 + 1;
        goto L11
    L13:
        return r104;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
        ContentResolver r102 = this.f471767a.getContentResolver();
        Uri r103 = UriProtector.parse(y1c.a.f565680a + "/boolean/" + r100);
        ContentValues r104 = new ContentValues();
        r104.put("value", Boolean.valueOf(r101));
        update(r102, r103, r104);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String r100, float r101) {
        ContentResolver r102 = this.f471767a.getContentResolver();
        Uri r103 = UriProtector.parse(y1c.a.f565680a + "/float/" + r100);
        ContentValues r104 = new ContentValues();
        r104.put("value", Float.valueOf(r101));
        update(r102, r103, r104);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String r100, int r101) {
        ContentResolver r102 = this.f471767a.getContentResolver();
        Uri r103 = UriProtector.parse(y1c.a.f565680a + "/int/" + r100);
        ContentValues r104 = new ContentValues();
        r104.put("value", Integer.valueOf(r101));
        update(r102, r103, r104);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String r100, long r101) {
        ContentResolver r102 = this.f471767a.getContentResolver();
        Uri r103 = UriProtector.parse(y1c.a.f565680a + "/long/" + r100);
        ContentValues r104 = new ContentValues();
        r104.put("value", Long.valueOf(r101));
        update(r102, r103, r104);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String r100, String r101) {
        ContentResolver r102 = this.f471767a.getContentResolver();
        Uri r103 = UriProtector.parse(y1c.a.f565680a + "/string/" + r100);
        ContentValues r104 = new ContentValues();
        r104.put("value", r101);
        update(r102, r103, r104);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
        HashSet r102 = new HashSet();
        Iterator<String> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(r103.next().replace(",", "__COMMA__"));
        goto L4
    L6:
        ContentResolver r104 = this.f471767a.getContentResolver();
        Uri r105 = UriProtector.parse(y1c.a.f565680a + "/string_set/" + r100);
        ContentValues r106 = new ContentValues();
        r106.put("value", r102.toString());
        update(r104, r105, r106);
        return this;
    }

    public static int c(ContentResolver r210, Uri r211, ContentValues r212) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, r212, null, null};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240018);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r112 = r111.length;
        int r104 = 0;
    L8:
        if (r104 >= r112) goto L15;
        f06.a r105 = r111[r104];
        int r113 = r104;
        int r114 = r112;
        f06.a[] r213 = r111;
        d r106 = r105.preInvoke(240018, "android/content/ContentResolver", "update", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Integer) r106.f474983b).intValue();
    L21:
        return r210.update(r211, r212, null, null);
    L14:
        r104 = r113 + 1;
        r112 = r114;
        r111 = r213;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private int update(ContentResolver r100, Uri r101, ContentValues r102) {
        return c(r100, r101, r102);
    L4:
        e = move-exception;
        Log.e("SPHelper", "update uri:" + r101, e);
        return -1;
    }
}
