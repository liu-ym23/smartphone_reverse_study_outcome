package com.ss.android.lark.sp;

import g5c.a;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbstractSharedPreferences implements a {
    private a mBaseSp;

    public AbstractSharedPreferences() {
    }

    public abstract String getSpName();

    @Override // g5c.a
    public void cleanSharedPreference() {
        this.mBaseSp.cleanSharedPreference();
    }

    @Override // g5c.a
    public Map<String, ?> getAll() {
        return this.mBaseSp.getAll();
    }

    @Override // g5c.a
    public void commit(boolean r100) {
        this.mBaseSp.commit(r100);
    }

    @Override // g5c.a
    public boolean contains(String r100) {
        return this.mBaseSp.contains(r100);
    }

    @Override // g5c.a
    public boolean getBoolean(String r100) {
        return this.mBaseSp.getBoolean(r100);
    }

    @Override // g5c.a
    public int getInt(String r100) {
        return this.mBaseSp.getInt(r100);
    }

    @Override // g5c.a
    public long getLong(String r100) {
        return this.mBaseSp.getLong(r100);
    }

    @Override // g5c.a
    public String getString(String r100) {
        return this.mBaseSp.getString(r100);
    }

    @Override // g5c.a
    public boolean remove(String r100) {
        return this.mBaseSp.remove(r100);
    }

    public void setBaseSharedPreferences(a r100) {
        this.mBaseSp = r100;
    }

    @Override // g5c.a
    public boolean getBoolean(String r100, boolean r101) {
        return this.mBaseSp.getBoolean(r100, r101);
    }

    @Override // g5c.a
    public float getFloat(String r100, float r101) {
        return this.mBaseSp.getFloat(r100, r101);
    }

    @Override // g5c.a
    public int getInt(String r100, int r101) {
        return this.mBaseSp.getInt(r100, r101);
    }

    @Override // g5c.a
    public <T> List<T> getJSONArray(String r100, Class<T> r101) {
        return this.mBaseSp.getJSONArray(r100, r101);
    }

    @Override // g5c.a
    public <T> T getJSONObject(String r100, Class<T> r101) {
        return (T) this.mBaseSp.getJSONObject(r100, r101);
    }

    @Override // g5c.a
    public long getLong(String r100, long r101) {
        return this.mBaseSp.getLong(r100, r101);
    }

    @Override // g5c.a
    public String getString(String r100, String r101) {
        return this.mBaseSp.getString(r100, r101);
    }

    @Override // g5c.a
    public void putBoolean(String r100, boolean r101) {
        this.mBaseSp.putBoolean(r100, r101);
    }

    @Override // g5c.a
    public void putFloat(String r100, float r101) {
        this.mBaseSp.putFloat(r100, r101);
    }

    @Override // g5c.a
    public void putInt(String r100, int r101) {
        this.mBaseSp.putInt(r100, r101);
    }

    @Override // g5c.a
    public void putJSONArray(String r100, List r101) {
        this.mBaseSp.putJSONArray(r100, r101);
    }

    @Override // g5c.a
    public void putJSONObject(String r100, Object r101) {
        this.mBaseSp.putJSONObject(r100, r101);
    }

    @Override // g5c.a
    public boolean putLong(String r100, long r101) {
        return this.mBaseSp.putLong(r100, r101);
    }

    @Override // g5c.a
    public void putString(String r100, String r101) {
        this.mBaseSp.putString(r100, r101);
    }
}
