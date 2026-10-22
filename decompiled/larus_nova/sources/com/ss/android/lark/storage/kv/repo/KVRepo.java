package com.ss.android.lark.storage.kv.repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public interface KVRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f441062a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f441063a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<Gson> f441064b = null;

        public Companion() {
        }

        static {
            f441063a = new Companion();
            f441064b = LazyKt.lazy(KVRepo$Companion$gson$2.INSTANCE);
        }

        public static final Gson a(Companion r100) {
            r100.getClass();
            return f441064b.getValue();
        }
    }

    public static final class a {
        public static String[] a(KVRepo r100) {
            return (String[]) r100.getAll().keySet().toArray(new String[0]);
        }

        public static <T> List<T> b(KVRepo r100, String r101, Class<T> r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            return (List) Companion.a(KVRepo.f441062a).fromJson(r100.getString(r101, null), TypeToken.getParameterized(List.class, new Type[]{r102}).getType());
        L5:
            e = move-exception;
            com.ss.android.lark.storage.kv.statistics.a r103 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
            com.ss.android.lark.storage.kv.statistics.a.f(r100, r101);
            Log.e("KVRepo", "putJSONObject " + r101 + " failed: " + e.getMessage());
            return null;
        }

        public static <T> T c(KVRepo r100, String r101, Class<T> r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            return (T) Companion.a(KVRepo.f441062a).fromJson(r100.getString(r101, null), r102);
        L5:
            return (T) Companion.a(KVRepo.f441062a).fromJson(r100.getString(r101, null), TypeToken.get(r102).getType());
        L7:
            e = move-exception;
            com.ss.android.lark.storage.kv.statistics.a r103 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
            com.ss.android.lark.storage.kv.statistics.a.f(r100, r101);
            Log.e("KVRepo", "putJSONObject " + r101 + " failed: " + e.getMessage());
            return null;
        }

        public static void d(KVRepo r100, String r101, List<?> r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            r100.putString(r101, Companion.a(KVRepo.f441062a).toJson(r102));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("KVRepo", "putJSONArray " + r101 + " failed: " + e.getMessage());
        }

        public static void e(KVRepo r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            r100.putString(r101, Companion.a(KVRepo.f441062a).toJson(r102));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            Log.e("KVRepo", "putJSONObject " + r101 + " failed: " + e.getMessage());
        }
    }

    static {
        f441062a = Companion.f441063a;
    }

    <T> boolean a(String r100, Class<T> r101);

    String[] b();

    void clear();

    boolean contains(String r100);

    @Deprecated(message = "not support", replaceWith = @ReplaceWith(expression = "getAllKeys()", imports = {}))
    Map<String, ?> getAll();

    boolean getBoolean(String r100, boolean r101);

    List<String> getFilePaths();

    float getFloat(String r100, float r101);

    int getInt(String r100, int r101);

    <T> List<T> getJSONArray(String r100, Class<T> r101);

    <T> T getJSONObject(String r100, Class<T> r101);

    long getLong(String r100, long r101);

    String getString(String r100, String r101);

    Set<String> getStringSet(String r100, Set<String> r101);

    void putBoolean(String r100, boolean r101);

    void putFloat(String r100, float r101);

    void putInt(String r100, int r101);

    void putJSONArray(String r100, List<?> r101);

    void putJSONObject(String r100, Object r101);

    void putLong(String r100, long r101);

    void putString(String r100, String r101);

    void putStringSet(String r100, Set<String> r101);

    void remove(String r100);
}
