package com.ss.android.lark.storage.kv.repo;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class SharedPreferencesRepo implements KVRepo, d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f441070f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f441071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f441072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f441073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f441074e;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.storage.kv.repo.d
    public final String c() {
        return (String) this.f441073d.getValue();
    }

    public final SharedPreferences d() {
        return (SharedPreferences) this.f441074e.getValue();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final String[] b() {
        return KVRepo.a.a(this);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void clear() {
        d().edit().clear().apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final Map<String, ?> getAll() {
        return d().getAll();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final List<String> getFilePaths() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d().contains(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().edit().remove(r100).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> boolean a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        return contains(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d().getBoolean(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final float getFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d().getFloat(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d().getInt(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> List<T> getJSONArray(String r100, Class<T> r101) {
        return KVRepo.a.b(this, r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> T getJSONObject(String r100, Class<T> r101) {
        return (T) KVRepo.a.c(this, r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d().getLong(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d().getString(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d().getStringSet(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().edit().putBoolean(r100, r101).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().edit().putFloat(r100, r101).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().edit().putInt(r100, r101).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putJSONArray(String r100, List<?> r101) {
        KVRepo.a.d(this, r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putJSONObject(String r100, Object r101) {
        KVRepo.a.e(this, r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().edit().putLong(r100, r101).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().edit().putString(r100, r101).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().edit().putStringSet(r100, r101).apply();
    }

    public SharedPreferencesRepo(final Context r100, String r101, String r102, final com.ss.android.lark.storage.a r103, final String r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parentDir");
        Intrinsics.checkNotNullParameter(r102, "spaceName");
        Intrinsics.checkNotNullParameter(r103, "domain");
        this.f441071b = r101;
        this.f441072c = r102;
        this.f441073d = LazyKt.lazy(new SharedPreferencesRepo$spName$2(this, r103, r104));
        this.f441074e = LazyKt.lazy(new SharedPreferencesRepo$sharedPreferences$2(this, r100));
    }
}
