package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class PLSharedPreferences {
    private static final String MOVE_TO_DE_RECORDS = "grs_move2DE_records";
    private static final String TAG = "PLSharedPreferences";

    /* JADX INFO: renamed from: sp, reason: collision with root package name */
    private final SharedPreferences f277137sp;

    public void clear() {
        SharedPreferences r100 = this.f277137sp;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.edit().clear().apply();
    }

    public SharedPreferences.Editor edit() {
        SharedPreferences r100 = this.f277137sp;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.edit();
    }

    public Map<String, ?> getAll() {
        SharedPreferences r100 = this.f277137sp;
        if (r100 != null) goto L6;
        return null;
    L6:
        Map<String, ?> r101 = r100.getAll();
        StringBuilder r102 = new StringBuilder("sp size ");
        if (r101 != null) goto L9;
        int r103 = 0;
    L10:
        r102.append(r103);
        Logger.i(TAG, r102.toString());
        return r101;
    L9:
        r103 = r101.size();
        goto L10
    }

    public Map<String, String> getHashMap(String r100) {
        HashMap r101 = new HashMap();
        SharedPreferences r102 = this.f277137sp;
        if (r102 != null) goto L20;
        return r101;
    L20:
        JSONArray r103 = new JSONArray(r102.getString(r100, ""));     // Catch: JSONException -> L17
        int r104 = 0;
    L8:
        if (r104 >= r103.length()) goto L19;
        JSONObject r105 = JSONArrayProtectorUtils.getJSONObject(r103, r104);     // Catch: JSONException -> L17
        JSONArray r106 = r105.names();     // Catch: JSONException -> L17
        if (r106 == null) goto L16;
        int r107 = 0;
    L13:
        if (r107 >= r106.length()) goto L16;
        String r108 = JSONArrayProtectorUtils.getString(r106, r107);     // Catch: JSONException -> L17
        r101.put(r108, JSONObjectProtectorUtils.getString(r105, r108));     // Catch: JSONException -> L17
        r107 = r107 + 1;
    L16:
        r104 = r104 + 1;
    L19:
        return r101;
    L17:
        e = move-exception;
        Logger.w(TAG, "getHashMap parse Json to map error: %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        goto L19
    }

    public String getString(String r100) {
        return getString(r100, "");
    }

    public void remove(String r100) {
        SharedPreferences r101 = this.f277137sp;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.edit().remove(r100).apply();
    }

    public void removeKeyValue(String r100) {
        SharedPreferences r101 = this.f277137sp;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.edit().remove(r100).apply();
    }

    public PLSharedPreferences(Context r100, String r101) {
        this.f277137sp = getSharedPreferences(r100, r101);
    }

    private SharedPreferences getSharedPreferences(Context r100, String r101) {
        if (r100 != null) goto L6;
        Logger.e(TAG, "context is null, must call init method to set context");
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L15;
        Context r102 = r100.createDeviceProtectedStorageContext();
        SharedPreferences r103 = r102.getSharedPreferences(MOVE_TO_DE_RECORDS, 0);
        if (r103.getBoolean(r101, false) == false) goto L10;
    L13:
        r100 = r102;
        goto L15
    L10:
        if (r102.moveSharedPreferencesFrom(r100, r101) == false) goto L15;
        SharedPreferences.Editor r104 = r103.edit();
        r104.putBoolean(r101, true);
        r104.apply();
    L15:
        return r100.getSharedPreferences(r101, 0);
    }

    public long getLong(String r100, long r101) {
        SharedPreferences r102 = this.f277137sp;
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.getLong(r100, r101);
    }

    public String getString(String r100, String r101) {
        SharedPreferences r102 = this.f277137sp;
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.getString(r100, r101);
    }

    public void putHashMap(String r100, Map<String, String> r101) {
        if (this.f277137sp == null) goto L22;
        if (r101 == null) goto L23;
        JSONArray r102 = new JSONArray();
        JSONObject r103 = new JSONObject();
        Iterator<Map.Entry<String, String>> r104 = r101.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        Map.Entry<String, String> r105 = r104.next();
        r103.put(r105.getKey(), r105.getValue());     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        Logger.w(TAG, "putHashMap one object error: %s", new Object[]{StringUtils.anonymizeMessage(e.getMessage())});
        goto L8
    L14:
        r102.put(r103);
        this.f277137sp.edit().putString(r100, r102.toString()).apply();
        return;
    L23:
        return;
    }

    public void putLong(String r100, long r101) {
        SharedPreferences r102 = this.f277137sp;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.edit().putLong(r100, r101).apply();
    }

    public void putString(String r100, String r101) {
        SharedPreferences r102 = this.f277137sp;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.edit().putString(r100, r101).apply();
    }
}
