package com.bytedance.mira.core;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public interface SharedPreferences {

    public interface Editor {
        void apply();

        Editor clear();

        boolean commit();

        Editor putBoolean(String r100, boolean r101);

        Editor putFloat(String r100, float r101);

        Editor putInt(String r100, int r101);

        Editor putLong(String r100, long r101);

        Editor putString(String r100, String r101);

        Editor putStringSet(String r100, Set<String> r101);

        Editor remove(String r100);
    }

    public interface OnSharedPreferenceChangeListener {
        void onSharedPreferenceChanged(SharedPreferences r100, String r101);
    }

    boolean contains(String r100);

    Editor edit();

    Map<String, ?> getAll();

    boolean getBoolean(String r100, boolean r101);

    float getFloat(String r100, float r101);

    int getInt(String r100, int r101);

    long getLong(String r100, long r101);

    String getString(String r100, String r101);

    Set<String> getStringSet(String r100, Set<String> r101);

    void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener r100);

    void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener r100);
}
