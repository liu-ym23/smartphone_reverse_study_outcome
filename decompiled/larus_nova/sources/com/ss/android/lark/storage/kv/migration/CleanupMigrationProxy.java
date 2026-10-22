package com.ss.android.lark.storage.kv.migration;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.kv.repo.c;
import com.ss.android.lark.storage.kv.repo.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class CleanupMigrationProxy extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f441055d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KVRepo f441056c;

    public static final class a {
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KVRepo f441057a;

        public b(KVRepo r100) {
            Intrinsics.checkNotNullParameter(r100, "migrationSource");
            this.f441057a = r100;
        }

        @Override // com.ss.android.lark.storage.kv.repo.f
        public final c a(KVRepo r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            return new CleanupMigrationProxy(r100, this.f441057a);
        }

        @Override // com.ss.android.lark.storage.kv.repo.g
        public final void b(com.ss.android.lark.storage.a r100) {
            Intrinsics.checkNotNullParameter(r100, "domain");
        }
    }

    static {
    }

    public CleanupMigrationProxy(KVRepo r100, KVRepo r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "migrationSource");
        super(r100);
        this.f441056c = r101;
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final boolean getBoolean(final String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((Boolean) f(r100, Boolean.valueOf(r101), new AnonymousClass1(this, r100, r101), new AnonymousClass2(this, r100, r101), new AnonymousClass3(this, r100))).booleanValue();
    }

    @Override // com.ss.android.lark.storage.kv.repo.c, com.ss.android.lark.storage.kv.repo.KVRepo
    public final String getString(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (String) f(r100, r101, new C121691(this, r100, r101), new C121702(this, r100, r101), new C121713(this, r100));
    }

    public static final /* synthetic */ boolean d(CleanupMigrationProxy r100, String r101, boolean r102) {
        return super.getBoolean(r101, r102);
    }

    public static final /* synthetic */ String e(CleanupMigrationProxy r100, String r101, String r102) {
        return super.getString(r101, r102);
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
    public final <T> T f(String r100, T r101, Function0<? extends T> r102, Function0<? extends T> r103, Function1<? super T, Unit> r104) {
        boolean r105 = contains(r100);
        boolean r106 = this.f441056c.contains(r100);
        if (r105 == false) goto L7;
        T r107 = r102.invoke();
        if (r106 == false) goto L10;
        this.f441056c.remove(r100);
        Log.d("CleanupMigrationProxy", "Cleaned up old data for key: ".concat(r100));
        return r107;
    L10:
        return r107;
    L7:
        if (r106 == false) goto L12;
        T r108 = r103.invoke();
        r104.invoke(r108);
        com.ss.android.lark.storage.kv.statistics.a r109 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        com.ss.android.lark.storage.kv.statistics.a.e(this.f441056c, r100);
        this.f441056c.remove(r100);
        Log.d("CleanupMigrationProxy", "Migrated data for key: ".concat(r100));
        return r108;
    L12:
        return r101;
    }
}
