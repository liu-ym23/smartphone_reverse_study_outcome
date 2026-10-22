package com.ss.android.lark.storage.kv.keva;

import com.bytedance.keva.Keva;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.kv.repo.KVRepoConfig;
import com.ss.android.lark.storage.kv.repo.d;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class KevaRepo implements KVRepo, d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f441049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f441050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f441051d;

    @Override // com.ss.android.lark.storage.kv.repo.d
    public final String c() {
        return (String) this.f441050c.getValue();
    }

    public final Keva d() {
        return (Keva) this.f441051d.getValue();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final List<String> getFilePaths() {
        return CollectionsKt.listOf(this.f441049b + '/' + ((String) this.f441050c.getValue()));
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final String[] b() {
        return (String[]) d().getAll().keySet().toArray(new String[0]);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void clear() {
        d().clear();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final Map<String, ?> getAll() {
        return d().getAll();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d().contains(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().erase(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> boolean a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        return d().contains(r100);
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
        d().storeBoolean(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().storeFloat(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().storeInt(r100, r101);
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
        d().storeLong(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().storeString(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        d().storeStringSet(r100, r101);
    }

    public KevaRepo(String r100, final String r101, final com.ss.android.lark.storage.a r102, final String r103, final KVRepoConfig.Mode r104) {
        Intrinsics.checkNotNullParameter(r100, "dirPath");
        Intrinsics.checkNotNullParameter(r101, "spaceName");
        Intrinsics.checkNotNullParameter(r102, "domain");
        Intrinsics.checkNotNullParameter(r104, "mode");
        this.f441049b = r100;
        this.f441050c = LazyKt.lazy(new KevaRepo$repoFullName$2(r101, r102, r103));
        this.f441051d = LazyKt.lazy(new KevaRepo$keva$2(this, r104));
    }
}
