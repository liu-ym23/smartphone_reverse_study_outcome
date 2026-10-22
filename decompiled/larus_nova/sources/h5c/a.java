package h5c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import b1c.c;
import com.alibaba.fastjson.JSON;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements g5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f483891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1c.a f483892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Gson f483893c;

    @Override // g5c.a
    public final void cleanSharedPreference() {
        SharedPreferences r100 = this.f483891a;
        if (r100 == null) goto L6;
        r100.edit().clear().apply();
        return;
    }

    @Override // g5c.a
    public final Map<String, ?> getAll() {
        SharedPreferences r100 = this.f483891a;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getAll();
    }

    @Override // g5c.a
    public final void commit(boolean r100) {
        SharedPreferences r101 = this.f483891a;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        r101.edit().apply();
        return;
    L6:
        r101.edit().commit();
        return;
    }

    @Override // g5c.a
    public final boolean contains(String r100) {
        SharedPreferences r101 = this.f483891a;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (this.f483892b == null) goto L10;
        r100 = c.g(r100);
    L10:
        return r101.contains(r100);
    }

    @Override // g5c.a
    public final boolean getBoolean(String r100) {
        return getBoolean(r100, false);
    }

    @Override // g5c.a
    public final int getInt(String r100) {
        return getInt(r100, 0);
    }

    @Override // g5c.a
    public final long getLong(String r100) {
        return getLong(r100, 0);
    }

    @Override // g5c.a
    public final String getString(String r100) {
        return getString(r100, "");
    }

    @Override // g5c.a
    public final boolean remove(String r100) {
        SharedPreferences r101 = this.f483891a;
        if (r101 != null) goto L5;
        return false;
    L5:
        SharedPreferences.Editor r102 = r101.edit();
        if (this.f483892b == null) goto L10;
        r100 = c.g(r100);
    L10:
        return r102.remove(r100).commit();
    }

    public a(SharedPreferences r100, c r101) {
        this.f483891a = r100;
        this.f483893c = new Gson();
        this.f483892b = r101;
    }

    @Override // g5c.a
    public final boolean getBoolean(String r100, boolean r101) {
        if (this.f483892b == null) goto L5;
        String r102 = getString(r100);
        if (TextUtils.isEmpty(r102) == false) goto L12;
        return r101;
    L12:
        return Boolean.parseBoolean(r102);
    L11:
        return r101;
    L5:
        return this.f483891a.getBoolean(r100, r101);
    }

    @Override // g5c.a
    public final float getFloat(String r100, float r101) {
        if (this.f483892b == null) goto L5;
        String r102 = getString(r100);
        if (TextUtils.isEmpty(r102) == false) goto L12;
        return r101;
    L12:
        return CastFloatProtector.parseFloat(r102);
    L11:
        return r101;
    L5:
        return this.f483891a.getFloat(r100, r101);
    }

    @Override // g5c.a
    public final int getInt(String r100, int r101) {
        if (this.f483892b == null) goto L5;
        String r102 = getString(r100);
        if (TextUtils.isEmpty(r102) == false) goto L12;
        return r101;
    L12:
        return CastIntegerProtector.parseInt(r102);
    L11:
        return r101;
    L5:
        return this.f483891a.getInt(r100, r101);
    }

    @Override // g5c.a
    public final <T> List<T> getJSONArray(String r100, Class<T> r101) {
        return JSON.parseArray(getString(r100), r101);
    L4:
        return (List) this.f483893c.fromJson(getString(r100), TypeToken.getParameterized(List.class, new Type[]{r101}).getType());
    L6:
        e = move-exception;
        Log.e("LarkSharedPreferences", e);
        return null;
    }

    @Override // g5c.a
    public final <T> T getJSONObject(String r100, Class<T> r101) {
        return (T) JSON.parseObject(getString(r100), r101);
    L4:
        String r102 = getString(r100);     // Catch: Exception -> L6
        Type r103 = TypeToken.get(r101).getType();     // Catch: Exception -> L6
        return (T) this.f483893c.fromJson(r102, r103);
    L6:
        e = move-exception;
        Log.e("LarkSharedPreferences", e);
        return null;
    }

    @Override // g5c.a
    public final long getLong(String r100, long r101) {
        if (this.f483892b == null) goto L5;
        String r102 = getString(r100);
        if (TextUtils.isEmpty(r102) == false) goto L12;
        return r101;
    L12:
        return CastLongProtector.parseLong(r102);
    L11:
        return r101;
    L5:
        return this.f483891a.getLong(r100, r101);
    }

    @Override // g5c.a
    public final String getString(String r100, String r101) {
        SharedPreferences r102 = this.f483891a;
        if (this.f483892b != null) goto L5;
        String r103 = r100;
    L6:
        String r104 = r102.getString(r103, "");
        if (TextUtils.isEmpty(r104) == false) goto L9;
        return r101;
    L9:
        b1c.a r105 = this.f483892b;
        if (r105 != null) goto L12;
        String r106 = r104;
    L13:
        if (r106 != null) goto L16;
        Log.e("LarkSharedPreferences", "decrypt failed, key:" + r100 + ", value:" + r104);
        return r101;
    L16:
        return r106;
    L12:
        r106 = ((c) r105).a(r104);
        goto L13
    L5:
        r103 = c.g(r100);
        goto L6
    }

    @Override // g5c.a
    public final void putBoolean(String r100, boolean r101) {
        if (this.f483892b != null) goto L6;
        this.f483891a.edit().putBoolean(r100, r101).apply();
        return;
    L6:
        putString(r100, String.valueOf(r101));
    }

    @Override // g5c.a
    public final void putFloat(String r100, float r101) {
        if (this.f483892b != null) goto L6;
        this.f483891a.edit().putFloat(r100, r101).apply();
        return;
    L6:
        putString(r100, String.valueOf(r101));
    }

    @Override // g5c.a
    public final void putInt(String r100, int r101) {
        if (this.f483892b != null) goto L6;
        this.f483891a.edit().putInt(r100, r101).apply();
        return;
    L6:
        putString(r100, String.valueOf(r101));
    }

    @Override // g5c.a
    public final void putJSONArray(String r100, List r101) {
        putString(r100, JSON.toJSONString(r101));     // Catch: Exception -> L4
        return;
    }

    @Override // g5c.a
    public final void putJSONObject(String r100, Object r101) {
        putString(r100, JSON.toJSONString(r101));     // Catch: Exception -> L4
        return;
    }

    @Override // g5c.a
    public final boolean putLong(String r100, long r101) {
        if (this.f483892b != null) goto L6;
        this.f483891a.edit().putLong(r100, r101).apply();
        return true;
    L6:
        putString(r100, String.valueOf(r101));
        return true;
    }

    @Override // g5c.a
    public final void putString(String r100, String r101) {
        SharedPreferences.Editor r102 = this.f483891a.edit();
        if (this.f483892b == null) goto L6;
        r100 = c.g(r100);
    L6:
        b1c.a r103 = this.f483892b;
        if (r103 == null) goto L10;
        r101 = ((c) r103).d(r101);
    L10:
        r102.putString(r100, r101).apply();
    }
}
