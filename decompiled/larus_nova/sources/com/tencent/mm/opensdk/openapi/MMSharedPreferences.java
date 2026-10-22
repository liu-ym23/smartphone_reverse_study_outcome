package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.a;
import f06.b;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes40.dex */
class MMSharedPreferences implements SharedPreferences {
    private static final String TAG = "MicroMsg.SDK.SharedPreferences";
    private final String[] columns;

    /* JADX INFO: renamed from: cr, reason: collision with root package name */
    private final ContentResolver f461633cr;
    private REditor editor;
    private final HashMap<String, Object> values;

    public static class REditor implements SharedPreferences.Editor {
        private boolean clear;

        /* JADX INFO: renamed from: cr, reason: collision with root package name */
        private ContentResolver f461634cr;
        private Set<String> remove;
        private Map<String, Object> values;

        public REditor(ContentResolver r100) {
            this.values = new HashMap();
            this.remove = new HashSet();
            this.clear = false;
            this.f461634cr = r100;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.clear = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            this.values.put(r100, Boolean.valueOf(r101));
            this.remove.remove(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r100, float r101) {
            this.values.put(r100, Float.valueOf(r101));
            this.remove.remove(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r100, int r101) {
            this.values.put(r100, Integer.valueOf(r101));
            this.remove.remove(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r100, long r101) {
            this.values.put(r100, Long.valueOf(r101));
            this.remove.remove(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r100, String r101) {
            this.values.put(r100, r101);
            this.remove.remove(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r100) {
            this.remove.add(r100);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            ContentValues r100 = new ContentValues();
            if (this.clear == false) goto L5;
            com_tencent_mm_opensdk_openapi_MMSharedPreferences$REditor_android_content_ContentResolver_delete(this.f461634cr, a.f461636a, null, null);
            this.clear = false;
        L5:
            Iterator<String> r101 = this.remove.iterator();
        L7:
            if (r101.hasNext() == false) goto L9;
            com_tencent_mm_opensdk_openapi_MMSharedPreferences$REditor_android_content_ContentResolver_delete(this.f461634cr, a.f461636a, "key = ?", new String[]{r101.next()});
            goto L7
        L9:
            Iterator<Map.Entry<String, Object>> r102 = this.values.entrySet().iterator();
        L11:
            if (r102.hasNext() == false) goto L40;
            Map.Entry<String, Object> r103 = r102.next();
            Object r104 = r103.getValue();
            if (r104 != null) goto L17;
            String r105 = "unresolve failed, null value";
        L15:
            Log.e("MicroMsg.SDK.PluginProvider.Resolver", r105);
            int r106 = 0;
        L35:
            if (r106 != 0) goto L37;
            boolean r107 = false;
        L38:
            if (r107 == false) goto L11;
            com_tencent_mm_opensdk_openapi_MMSharedPreferences$REditor_android_content_ContentResolver_update(this.f461634cr, a.f461636a, r100, "key = ?", new String[]{r103.getKey()});
            goto L11
        L37:
            r100.put("type", Integer.valueOf(r106));
            r100.put("value", r104.toString());
            r107 = true;
            goto L38
        L17:
            if ((r104 instanceof Integer) == false) goto L20;
            r106 = 1;
            goto L35
        L20:
            if ((r104 instanceof Long) == false) goto L23;
            r106 = 2;
            goto L35
        L23:
            if ((r104 instanceof String) == false) goto L26;
            r106 = 3;
            goto L35
        L26:
            if ((r104 instanceof Boolean) == false) goto L29;
            r106 = 4;
            goto L35
        L29:
            if ((r104 instanceof Float) == false) goto L32;
            r106 = 5;
            goto L35
        L32:
            if ((r104 instanceof Double) == false) goto L34;
            r106 = 6;
            goto L35
        L34:
            r105 = "unresolve failed, unknown type=" + r104.getClass().toString();
            goto L15
        L40:
            return true;
        }

        private static int com_tencent_mm_opensdk_openapi_MMSharedPreferences$REditor_android_content_ContentResolver_delete(ContentResolver r110, Uri r111, String r210, String[] r211) {
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

        private static int com_tencent_mm_opensdk_openapi_MMSharedPreferences$REditor_android_content_ContentResolver_update(ContentResolver r110, Uri r111, ContentValues r210, String r211, String[] r212) {
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
    }

    public MMSharedPreferences(Context r100) {
        this.columns = new String[]{DBDefinition.ID, "key", "type", "value"};
        this.values = new HashMap();
        this.editor = null;
        this.f461633cr = r100.getContentResolver();
    }

    private Object getValue(String r100) {
    L14:
        e = move-exception;
        Log.e(TAG, "getValue exception:" + e.getMessage());
        return null;
    L5:
        Cursor r101 = com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query(this.f461633cr, a.f461636a, this.columns, "key = ?", new String[]{r100}, null);     // Catch: Exception -> L14
        if (r101 != null) goto L8;
        return null;
    L8:
        int r102 = r101.getColumnIndex("type");     // Catch: Exception -> L14
        int r103 = r101.getColumnIndex("value");     // Catch: Exception -> L14
        if (r101.moveToFirst() == false) goto L11;
        Object r104 = com.tencent.mm.opensdk.channel.a.a.a(r101.getInt(r102), r101.getString(r103));     // Catch: Exception -> L14
    L12:
        r101.close();     // Catch: Exception -> L14
        return r104;
    L11:
        r104 = null;
        goto L12
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r100) {
        if (getValue(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        if (this.editor != null) goto L6;
        this.editor = new REditor(this.f461633cr);
    L6:
        return this.editor;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Cursor r100 = com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query(this.f461633cr, a.f461636a, this.columns, null, null, null);     // Catch: Exception -> L12
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.getColumnIndex("key");     // Catch: Exception -> L12
        int r102 = r100.getColumnIndex("type");     // Catch: Exception -> L12
        int r103 = r100.getColumnIndex("value");     // Catch: Exception -> L12
    L8:
        if (r100.moveToNext() == false) goto L10;
        this.values.put(r100.getString(r101), com.tencent.mm.opensdk.channel.a.a.a(r100.getInt(r102), r100.getString(r103)));     // Catch: Exception -> L12
        goto L8
    L10:
        r100.close();     // Catch: Exception -> L12
        return this.values;
    L12:
        e = move-exception;
        Log.e(TAG, "getAll exception:" + e.getMessage());
        return this.values;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r100, boolean r101) {
        Object r102 = getValue(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        if ((r102 instanceof Boolean) == true) goto L7;
        return r101;
    L7:
        return ((Boolean) r102).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r100, float r101) {
        Object r102 = getValue(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        if ((r102 instanceof Float) == true) goto L7;
        return r101;
    L7:
        return ((Float) r102).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r100, int r101) {
        Object r102 = getValue(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        if ((r102 instanceof Integer) == true) goto L7;
        return r101;
    L7:
        return ((Integer) r102).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r100, long r101) {
        Object r102 = getValue(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        if ((r102 instanceof Long) == true) goto L7;
        return r101;
    L7:
        return ((Long) r102).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String r100, String r101) {
        Object r102 = getValue(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        if ((r102 instanceof String) == true) goto L7;
        return r101;
    L7:
        return (String) r102;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String r100, Set<String> r101) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
    }

    private static Cursor com_tencent_mm_opensdk_openapi_MMSharedPreferences_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
