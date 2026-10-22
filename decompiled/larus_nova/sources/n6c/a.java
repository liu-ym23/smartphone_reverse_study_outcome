package n6c;

import com.google.gson.Gson;
import com.ss.android.lark.sp.AbstractSharedPreferences;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.transformer.EncryptTransformer;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements KVRepo {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f518191c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g5c.a f518192b;

    /* JADX INFO: renamed from: n6c.a$a, reason: collision with other inner class name */
    public static final class C6903a {
    }

    static {
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void clear() {
        this.f518192b.cleanSharedPreference();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final Map<String, ?> getAll() {
        return this.f518192b.getAll();
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final String[] b() {
        return KVRepo.a.a(this);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final List<String> getFilePaths() {
        return CollectionsKt.emptyList();
    }

    public a(AbstractSharedPreferences r100) {
        Intrinsics.checkNotNullParameter(r100, "sharedPreferences");
        this.f518192b = r100;
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518192b.contains(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518192b.remove(r100);
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
        return this.f518192b.getBoolean(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final float getFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518192b.getFloat(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518192b.getInt(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> List<T> getJSONArray(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518192b.getJSONArray(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> T getJSONObject(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (T) this.f518192b.getJSONObject(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f518192b.getLong(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L7;
        return this.f518192b.getString(r100, r101);
    L7:
        if (this.f518192b.contains(r100) == true) goto L11;
        return null;
    L11:
        return this.f518192b.getString(r100, "");
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r102 = this.f518192b.getString(r100);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        Lazy<Gson> r104 = EncryptTransformer.f441107e;
        return EncryptTransformer.a.a(r100, r102);
    L13:
        return r101;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518192b.putBoolean(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518192b.putFloat(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518192b.putInt(r100, r101);
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
        this.f518192b.putLong(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518192b.putString(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        g5c.a r102 = this.f518192b;
        Lazy<Gson> r103 = EncryptTransformer.f441107e;
        r102.putString(r100, EncryptTransformer.a.b(r100, r101));
    }
}
