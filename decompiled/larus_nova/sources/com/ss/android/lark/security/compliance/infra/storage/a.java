package com.ss.android.lark.security.compliance.infra.storage;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.util.f;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements KVRepo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KVRepo f440472b;

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> boolean a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        return this.f440472b.a(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final String[] b() {
        return this.f440472b.b();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void clear() {
        this.f440472b.clear();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f440472b.contains(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    @Deprecated(message = "not support", replaceWith = @ReplaceWith(expression = "getAllKeys()", imports = {}))
    public final Map<String, ?> getAll() {
        return this.f440472b.getAll();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final List<String> getFilePaths() {
        return this.f440472b.getFilePaths();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final float getFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f440472b.getFloat(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f440472b.getInt(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> List<T> getJSONArray(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f440472b.getJSONArray(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f440472b.getStringSet(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f440472b.putFloat(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f440472b.putInt(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putJSONArray(String r100, List<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f440472b.putJSONArray(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f440472b.putStringSet(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f440472b.remove(r100);
    }

    public a(com.ss.android.lark.storage.kv.repo.a r100) {
        Intrinsics.checkNotNullParameter(r100, "kvRepo");
        this.f440472b = r100;
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        boolean r102 = this.f440472b.getBoolean(r100, r101);
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("ScsDebugKVRepo", "getBoolean key=" + r100 + ", result=" + r102);
        return r102;
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> T getJSONObject(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r102 = (T) this.f440472b.getJSONObject(r100, r101);
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("ScsDebugKVRepo", "getJSONObject key=" + r100 + ", result=" + f.c(r102));
        return r102;
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        long r102 = this.f440472b.getLong(r100, r101);
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("ScsDebugKVRepo", "getLong key=" + r100 + ", result=" + r102);
        return r102;
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r102 = this.f440472b.getString(r100, r101);
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("ScsDebugKVRepo", "getString key=" + r100 + ", result=" + r102);
        return r102;
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = ScsLogger.f440428a;
        ScsLogger.d("ScsDebugKVRepo", "putBoolean key=" + r100 + ", value=" + r101);
        this.f440472b.putBoolean(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putJSONObject(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = ScsLogger.f440428a;
        ScsLogger.d("ScsDebugKVRepo", "putJSONObject key=" + r100 + "， value=" + f.c(r101));
        this.f440472b.putJSONObject(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = ScsLogger.f440428a;
        ScsLogger.d("ScsDebugKVRepo", "putLong key=" + r100 + ", value=" + r101);
        this.f440472b.putLong(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = ScsLogger.f440428a;
        ScsLogger.d("ScsDebugKVRepo", "putString key=" + r100 + ", value=" + r101);
        this.f440472b.putString(r100, r101);
    }
}
