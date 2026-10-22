package n6c;

import android.content.SharedPreferences;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements KVRepo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f518193b;

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void clear() {
        this.f518193b.edit().clear().apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final Map<String, ?> getAll() {
        return this.f518193b.getAll();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final String[] b() {
        return KVRepo.a.a(this);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final List<String> getFilePaths() {
        return CollectionsKt.emptyList();
    }

    public b(SharedPreferences r100) {
        Intrinsics.checkNotNullParameter(r100, "migrationSource");
        this.f518193b = r100;
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518193b.contains(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518193b.edit().remove(r100).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> boolean a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        return this.f518193b.contains(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518193b.getBoolean(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final float getFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518193b.getFloat(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518193b.getInt(r100, r101);
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
        return this.f518193b.getLong(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518193b.getString(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518193b.getStringSet(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518193b.edit().putBoolean(r100, r101).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518193b.edit().putFloat(r100, r101).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518193b.edit().putInt(r100, r101).apply();
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
        this.f518193b.edit().putLong(r100, r101).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518193b.edit().putString(r100, r101).apply();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518193b.edit().putStringSet(r100, r101).apply();
    }
}
