package com.bytedance.timon.foundation.impl;

import android.content.SharedPreferences;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements IStoreRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f270624a;

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final byte[] getBytes(String r100, byte[] r101) {
        return r101;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    @Deprecated(message = "return defValue")
    public final String[] getStringArray(String r100, String[] r101) {
        return r101;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void clear() {
        SharedPreferences r100 = this.f270624a;
        if (r100 == null) goto L6;
        SharedPreferences.Editor r101 = r100.edit();
        r101.clear();
        r101.apply();
        return;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final Map<String, ?> getAll() {
        SharedPreferences r100 = this.f270624a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAll();
    }

    public a(SharedPreferences r100) {
        this.f270624a = r100;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final boolean contains(String r100) {
        SharedPreferences r101 = this.f270624a;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.contains(r100);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void remove(String r100) {
        SharedPreferences r101 = this.f270624a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.remove(r100);
        r102.apply();
        return;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final boolean getBoolean(String r100, boolean r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getBoolean(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final float getFloat(String r100, float r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getFloat(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final int getInt(String r100, int r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getInt(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final long getLong(String r100, long r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getLong(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final String getString(String r100, String r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 == null) goto L8;
        String r103 = r102.getString(r100, r101);
        if (r103 != null) goto L7;
        return r101;
    L7:
        return r103;
    L8:
        return r101;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 == null) goto L8;
        Set<String> r103 = r102.getStringSet(r100, r101);
        if (r103 != null) goto L7;
        return r101;
    L7:
        return r103;
    L8:
        return r101;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putBoolean(String r100, boolean r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 == null) goto L6;
        SharedPreferences.Editor r103 = r102.edit();
        r103.putBoolean(r100, r101);
        r103.apply();
        return;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putBytes(String r100, byte[] r101) {
        throw new UnsupportedOperationException("unsupport save bytes");
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putFloat(String r100, float r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 == null) goto L6;
        SharedPreferences.Editor r103 = r102.edit();
        r103.putFloat(r100, r101);
        r103.apply();
        return;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putInt(String r100, int r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 == null) goto L6;
        SharedPreferences.Editor r103 = r102.edit();
        r103.putInt(r100, r101);
        r103.apply();
        return;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putLong(String r100, long r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 == null) goto L6;
        SharedPreferences.Editor r103 = r102.edit();
        r103.putLong(r100, r101);
        r103.apply();
        return;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putString(String r100, String r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 == null) goto L6;
        SharedPreferences.Editor r103 = r102.edit();
        r103.putString(r100, r101);
        r103.apply();
        return;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    @Deprecated(message = "empty impl")
    public final void putStringArray(String r100, String[] r101) {
        throw new UnsupportedOperationException("unsupport save stringArray");
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putStringSet(String r100, Set<String> r101) {
        SharedPreferences r102 = this.f270624a;
        if (r102 == null) goto L6;
        SharedPreferences.Editor r103 = r102.edit();
        r103.putStringSet(r100, r101);
        r103.apply();
        return;
    }
}
