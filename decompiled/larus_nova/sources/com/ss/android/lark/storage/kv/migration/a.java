package com.ss.android.lark.storage.kv.migration;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.kv.repo.c;
import com.ss.android.lark.storage.kv.repo.g;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KVRepo f441058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f441059d;

    /* JADX INFO: renamed from: com.ss.android.lark.storage.kv.migration.a$a, reason: collision with other inner class name */
    public static final class C5309a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KVRepo f441060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f441061b;

        @Override // com.ss.android.lark.storage.kv.repo.f
        public final c a(KVRepo r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            return new a(r100, this.f441060a, this.f441061b);
        }

        @Override // com.ss.android.lark.storage.kv.repo.g
        public final void b(com.ss.android.lark.storage.a r100) {
            Intrinsics.checkNotNullParameter(r100, "domain");
        }

        public C5309a(KVRepo r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "migrationSource");
            this.f441060a = r100;
            this.f441061b = r101;
        }
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final Map<String, ?> getAll() {
        return MapsKt.plus(this.f441058c.getAll(), super.getAll());
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final String[] b() {
        return (String[]) ArraysKt.distinct(ArraysKt.plus(super.b(), this.f441058c.b())).toArray(new String[0]);
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final void clear() {
        super.clear();
        this.f441058c.clear();
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (super.contains(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f441058c.contains(r100) == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        super.remove(r100);
        this.f441058c.remove(r100);
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> boolean a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (super.a(r100, r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f441058c.a(r100, r101) == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        boolean r102 = super.getBoolean(r100, r101);
        if (r102 == r101) goto L5;
    L11:
        return r102;
    L5:
        if (super.a(r100, Boolean.TYPE) == true) goto L11;
        r102 = this.f441058c.getBoolean(r100, r101);
        if (r102 == r101) goto L9;
    L10:
        com.ss.android.lark.storage.kv.statistics.a r103 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        com.ss.android.lark.storage.kv.statistics.a.e(this.f441058c, r100);
        super.putBoolean(r100, r102);
        goto L11
    L9:
        if (this.f441058c.contains(r100) == false) goto L11;
        goto L10
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final float getFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        float r102 = super.getFloat(r100, r101);
        boolean r103 = false;
        if (r102 != r101) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
    L16:
        return r102;
    L8:
        if (super.a(r100, Float.TYPE) == true) goto L16;
        r102 = this.f441058c.getFloat(r100, r101);
        if (r102 != r101) goto L12;
        r103 = true;
    L12:
        if (r103 == true) goto L14;
    L15:
        super.putFloat(r100, r102);
        com.ss.android.lark.storage.kv.statistics.a r105 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        com.ss.android.lark.storage.kv.statistics.a.e(this.f441058c, r100);
        goto L16
    L14:
        if (this.f441058c.contains(r100) == false) goto L16;
    L5:
        r104 = false;
        goto L6
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = super.getInt(r100, r101);
        if (r102 == r101) goto L5;
    L11:
        return r102;
    L5:
        if (super.a(r100, Integer.TYPE) == true) goto L11;
        r102 = this.f441058c.getInt(r100, r101);
        if (r102 == r101) goto L9;
    L10:
        super.putInt(r100, r102);
        com.ss.android.lark.storage.kv.statistics.a r103 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        com.ss.android.lark.storage.kv.statistics.a.e(this.f441058c, r100);
        goto L11
    L9:
        if (this.f441058c.contains(r100) == false) goto L11;
        goto L10
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> List<T> getJSONArray(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        List<T> r102 = super.getJSONArray(r100, r101);
        if (r102 == null) goto L5;
    L9:
        return r102;
    L5:
        if (super.contains(r100) == true) goto L9;
        r102 = this.f441058c.getJSONArray(r100, r101);
        if (r102 == null) goto L9;
        super.putJSONArray(r100, r102);
        com.ss.android.lark.storage.kv.statistics.a r103 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        com.ss.android.lark.storage.kv.statistics.a.e(this.f441058c, r100);
        goto L9
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final <T> T getJSONObject(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r102 = (T) super.getJSONObject(r100, r101);
        if (r102 == null) goto L5;
    L9:
        return r102;
    L5:
        if (super.a(r100, String.class) == true) goto L9;
        r102 = (T) this.f441058c.getJSONObject(r100, r101);
        if (r102 == null) goto L9;
        com.ss.android.lark.storage.kv.statistics.a r103 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        com.ss.android.lark.storage.kv.statistics.a.e(this.f441058c, r100);
        super.putJSONObject(r100, r102);
        goto L9
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        long r102 = super.getLong(r100, r101);
        if (r102 == r101) goto L5;
    L11:
        return r102;
    L5:
        if (super.a(r100, Long.TYPE) == true) goto L11;
        r102 = this.f441058c.getLong(r100, r101);
        if (r102 == r101) goto L9;
    L10:
        super.putLong(r100, r102);
        com.ss.android.lark.storage.kv.statistics.a r103 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        com.ss.android.lark.storage.kv.statistics.a.e(this.f441058c, r100);
        goto L11
    L9:
        if (this.f441058c.contains(r100) == false) goto L11;
        goto L10
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r102 = super.getString(r100, r101);
        if (Intrinsics.areEqual(r102, r101) == true) goto L5;
    L11:
        return r102;
    L5:
        if (super.a(r100, String.class) == true) goto L11;
        r102 = this.f441058c.getString(r100, r101);
        if (Intrinsics.areEqual(r102, r101) == true) goto L9;
    L10:
        super.putString(r100, r102);
        com.ss.android.lark.storage.kv.statistics.a r103 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        com.ss.android.lark.storage.kv.statistics.a.e(this.f441058c, r100);
        goto L11
    L9:
        if (this.f441058c.contains(r100) == false) goto L11;
        goto L10
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Set<String> r102 = super.getStringSet(r100, r101);
        if (Intrinsics.areEqual(r102, r101) == true) goto L5;
    L11:
        return r102;
    L5:
        if (super.contains(r100) == true) goto L11;
        r102 = this.f441058c.getStringSet(r100, r101);
        if (Intrinsics.areEqual(r102, r101) == true) goto L9;
    L10:
        super.putStringSet(r100, r102);
        com.ss.android.lark.storage.kv.statistics.a r103 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        com.ss.android.lark.storage.kv.statistics.a.e(this.f441058c, r100);
        goto L11
    L9:
        if (this.f441058c.contains(r100) == false) goto L11;
        goto L10
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        super.putBoolean(r100, r101);
        if (this.f441059d == false) goto L6;
        this.f441058c.putBoolean(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        super.putFloat(r100, r101);
        if (this.f441059d == false) goto L6;
        this.f441058c.putFloat(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        super.putInt(r100, r101);
        if (this.f441059d == false) goto L6;
        this.f441058c.putInt(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putJSONArray(String r100, List<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        super.putJSONArray(r100, r101);
        if (this.f441059d == true) goto L5;
        if (r101 == null) goto L5;
        return;
    L5:
        this.f441058c.putJSONArray(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putJSONObject(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        super.putJSONObject(r100, r101);
        if (this.f441059d == true) goto L5;
        if (r101 == null) goto L5;
        return;
    L5:
        this.f441058c.putJSONObject(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        super.putLong(r100, r101);
        if (this.f441059d == false) goto L6;
        this.f441058c.putLong(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        super.putString(r100, r101);
        if (this.f441059d == true) goto L5;
        if (r101 == null) goto L5;
        return;
    L5:
        this.f441058c.putString(r100, r101);
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final void putStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        super.putStringSet(r100, r101);
        if (this.f441059d == true) goto L5;
        if (r101 == null) goto L5;
        return;
    L5:
        this.f441058c.putStringSet(r100, r101);
    }

    public a(KVRepo r100, KVRepo r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "migrationSource");
        super(r100);
        this.f441058c = r101;
        this.f441059d = r102;
    }
}
