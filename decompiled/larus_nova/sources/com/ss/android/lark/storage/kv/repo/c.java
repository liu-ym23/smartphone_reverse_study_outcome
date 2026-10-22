package com.ss.android.lark.storage.kv.repo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class c implements KVRepo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KVRepo f441079b;

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public String[] b() {
        return c().b();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public void clear() {
        c().clear();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public Map<String, ?> getAll() {
        return c().getAll();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final List<String> getFilePaths() {
        return c().getFilePaths();
    }

    public KVRepo c() {
        return this.f441079b;
    }

    public c(KVRepo r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f441079b = r100;
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return c().contains(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c().remove(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public <T> boolean a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        return c().a(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return c().getBoolean(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public float getFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return c().getFloat(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return c().getInt(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public <T> List<T> getJSONArray(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return c().getJSONArray(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public <T> T getJSONObject(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (T) c().getJSONObject(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return c().getLong(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return c().getString(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public Set<String> getStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return c().getStringSet(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public void putBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c().putBoolean(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public void putFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c().putFloat(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public void putInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c().putInt(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public void putJSONArray(String r100, List<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c().putJSONArray(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public void putJSONObject(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c().putJSONObject(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public void putLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c().putLong(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c().putString(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public void putStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        c().putStringSet(r100, r101);
    }
}
