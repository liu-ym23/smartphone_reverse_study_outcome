package com.bytedance.ugc.glue;

import android.content.SharedPreferences;
import ep7.a;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public class UGCSharePrefs {
    private static final String DEFAULT_NAME = "ugc_share_prefs";
    private final String name;
    private SharedPreferences prefs;

    public static UGCSharePrefs get() {
        return new UGCSharePrefs(DEFAULT_NAME);
    }

    private boolean init() {
        SharedPreferences r100 = this.prefs;
        if (r100 != null) goto L5;
        int r101 = a.f473437a;
    L5:
        if (r100 == null) goto L7;
        return true;
    L7:
        return false;
    }

    public Set<? extends Map.Entry<String, ?>> getAll() {
        if (init() == true) goto L7;
        return null;
    L7:
        return this.prefs.getAll().entrySet();
    }

    private UGCSharePrefs(String r100) {
        this.name = r100;
    }

    public static UGCSharePrefs get(String r100) {
        return new UGCSharePrefs(r100);
    }

    public boolean contains(String r100) {
        if (init() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.prefs.contains(r100) == false) goto L7;
        return true;
    }

    public void remove(String r100) {
        if (init() == false) goto L6;
        this.prefs.edit().remove(r100).apply();
        return;
    }

    public boolean getBoolean(String r100, boolean r101) {
        if (init() == true) goto L5;
        return r101;
    L5:
        return UGCTools.parseBoolean(this.prefs.getString(r100, String.valueOf(r101)));
    }

    public int getInt(String r100, int r101) {
        if (init() == true) goto L5;
        return r101;
    L5:
        return UGCTools.parseInt(this.prefs.getString(r100, null), r101);
    }

    public String getString(String r100, String r101) {
        if (init() == true) goto L5;
        return r101;
    L5:
        return this.prefs.getString(r100, r101);
    }

    public <T> void put(String r100, T r101) {
        if (init() == false) goto L8;
        if (r101 != null) goto L6;
        this.prefs.edit().putString(r100, "").apply();
        return;
    L6:
        this.prefs.edit().putString(r100, String.valueOf(r101)).apply();
        return;
    }
}
