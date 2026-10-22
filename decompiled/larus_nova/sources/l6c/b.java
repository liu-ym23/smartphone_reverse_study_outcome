package l6c;

import android.text.TextUtils;
import b1c.c;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.suite.component.logger.Log;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements g5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f507758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1c.a f507759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Gson f507760c;

    public static final class a {
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: l6c.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003"}, d2 = {"com/ss/android/lark/storage/kv/keva/legacy/KevaSharedPreferences$getJSONArray$1", "Lcom/google/gson/reflect/TypeToken;", "", "unistore-keva_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C6658b<T> extends TypeToken<List<T>> {
        public C6658b() {
        }
    }

    static {
    }

    @Override // g5c.a
    public final void commit(boolean r100) {
    }

    @Override // g5c.a
    public final void cleanSharedPreference() {
        this.f507758a.clear();
    }

    @Override // g5c.a
    public final Map<String, ?> getAll() {
        HashMap r100 = new HashMap();
        Iterator<String> r101 = this.f507758a.getAll().keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.put(r101.next(), null);
        goto L4
    L6:
        return r100;
    }

    @Override // g5c.a
    public final boolean contains(String r100) {
        Keva r101 = this.f507758a;
        if (this.f507759b == null) goto L7;
        r100 = c.g(r100);
    L7:
        return r101.contains(r100);
    }

    @Override // g5c.a
    public final boolean getBoolean(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return getBoolean(r100, false);
    }

    @Override // g5c.a
    public final int getInt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return getInt(r100, 0);
    }

    @Override // g5c.a
    public final long getLong(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return getLong(r100, 0);
    }

    @Override // g5c.a
    public final String getString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return getString(r100, "");
    }

    @Override // g5c.a
    public final boolean remove(String r100) {
        Keva r101 = this.f507758a;
        if (this.f507759b == null) goto L6;
        r100 = c.g(r100);
    L6:
        r101.erase(r100);
        return true;
    }

    public b(Keva r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "mBasePreference");
        this.f507758a = r100;
        this.f507759b = r101;
        this.f507760c = new Gson();
    }

    @Override // g5c.a
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f507759b == null) goto L5;
        String r102 = getString(r100);
        if (TextUtils.isEmpty(r102) == false) goto L12;
        return r101;
    L12:
        return Boolean.parseBoolean(r102);
    L11:
        return r101;
    L5:
        return this.f507758a.getBoolean(r100, r101);
    }

    @Override // g5c.a
    public final float getFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f507759b == null) goto L5;
        String r102 = getString(r100);
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return r101;
    L15:
        if (r102 == null) goto L25;
        Float r104 = StringsKt.toFloatOrNull(r102);     // Catch: Exception -> L20
        if (r104 == null) goto L26;
        return r104.floatValue();
    L26:
        return r101;
    L20:
        e = move-exception;
        Log.a("toFloat failed, key:" + r100 + ", value:" + r102 + ", e:" + e, null, 12);
        return r101;
    L25:
        return r101;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        return this.f507758a.getFloat(r100, r101);
    }

    @Override // g5c.a
    public final int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f507759b == null) goto L5;
        String r102 = getString(r100);
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return r101;
    L15:
        if (r102 == null) goto L25;
        Integer r104 = StringsKt.toIntOrNull(r102);     // Catch: Exception -> L20
        if (r104 == null) goto L26;
        return r104.intValue();
    L26:
        return r101;
    L20:
        e = move-exception;
        Log.a("toInt failed, key:" + r100 + ", value:" + r102 + ", e:" + e, null, 12);
        return r101;
    L25:
        return r101;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        return this.f507758a.getInt(r100, r101);
    }

    @Override // g5c.a
    public final <T> List<T> getJSONArray(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return (List) this.f507760c.fromJson(getString(r100), new C6658b().getType());
    L5:
        return (List) this.f507760c.fromJson(getString(r100), TypeToken.getParameterized(List.class, new Type[]{r101}).getType());
    L7:
        e = move-exception;
        Log.a(e.getMessage(), e, 8);
        return null;
    }

    @Override // g5c.a
    public final <T> T getJSONObject(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        String r102 = getString(r100);     // Catch: Exception -> L5
        return (T) this.f507760c.fromJson(r102, r101);
    L5:
        String r103 = getString(r100);     // Catch: Exception -> L7
        Type r104 = TypeToken.get(r101).getType();     // Catch: Exception -> L7
        return (T) this.f507760c.fromJson(r103, r104);
    L7:
        e = move-exception;
        Log.a(e.getMessage(), e, 8);
        return null;
    }

    @Override // g5c.a
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f507759b == null) goto L5;
        String r102 = getString(r100);
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return r101;
    L15:
        if (r102 == null) goto L25;
        Long r104 = StringsKt.toLongOrNull(r102);     // Catch: Exception -> L20
        if (r104 == null) goto L26;
        return r104.longValue();
    L26:
        return r101;
    L20:
        e = move-exception;
        Log.a("toLong failed, key:" + r100 + ", value:" + r102 + ", e:" + e, null, 12);
        return r101;
    L25:
        return r101;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        return this.f507758a.getLong(r100, r101);
    }

    @Override // g5c.a
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Keva r102 = this.f507758a;
        if (this.f507759b != null) goto L5;
        String r103 = r100;
    L6:
        String r104 = r102.getString(r103, "");
        if (TextUtils.isEmpty(r104) == false) goto L9;
        return r101;
    L9:
        b1c.a r105 = this.f507759b;
        if (r105 == null) goto L13;
        String r106 = ((c) r105).a(r104);
        if (r106 == null) goto L13;
    L14:
        if (r106 != null) goto L17;
        Log.a("decrypt failed, key:" + r100 + ", value:" + r104, null, 12);
        return r101;
    L17:
        return r106;
    L13:
        r106 = r104;
        goto L14
    L5:
        r103 = c.g(r100);
        goto L6
    }

    @Override // g5c.a
    public final void putBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f507759b != null) goto L6;
        this.f507758a.storeBoolean(r100, r101);
        return;
    L6:
        putString(r100, String.valueOf(r101));
    }

    @Override // g5c.a
    public final void putFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f507759b != null) goto L6;
        this.f507758a.storeFloat(r100, r101);
        return;
    L6:
        putString(r100, String.valueOf(r101));
    }

    @Override // g5c.a
    public final void putInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f507759b != null) goto L6;
        this.f507758a.storeInt(r100, r101);
        return;
    L6:
        putString(r100, String.valueOf(r101));
    }

    @Override // g5c.a
    public final void putJSONArray(String r100, List<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        putString(r100, this.f507760c.toJson(r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.a("putJSONArray failed, key:" + r100, e, 8);
    }

    @Override // g5c.a
    public final void putJSONObject(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        putString(r100, this.f507760c.toJson(r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.a("putJSONObject failed, key:" + r100, e, 8);
    }

    @Override // g5c.a
    public final boolean putLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f507759b != null) goto L6;
        this.f507758a.storeLong(r100, r101);
        return true;
    L6:
        putString(r100, String.valueOf(r101));
        return true;
    }

    @Override // g5c.a
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f507759b == null) goto L6;
        r100 = c.g(r100);
    L6:
        b1c.a r102 = this.f507759b;
        if (r102 == null) goto L12;
        String r103 = ((c) r102).d(r101);
        if (r103 == null) goto L12;
        r101 = r103;
    L12:
        this.f507758a.storeString(r100, r101);
    }
}
