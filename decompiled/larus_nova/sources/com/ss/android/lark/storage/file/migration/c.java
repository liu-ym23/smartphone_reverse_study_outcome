package com.ss.android.lark.storage.file.migration;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements IFileMigration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f440988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f440989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IFileMigration.MigrationStrategy f440990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f440991e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f440992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f440993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f440994c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final IFileMigration.MigrationPriority f440995d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IFileMigration.MigrationStrategy f440996e;

        public final c a() {
            String r100 = this.f440992a;
            ArrayList r101 = (ArrayList) this.f440993b;
            return new c(r100, (String[]) r101.toArray(new String[0]), this.f440994c, this.f440995d, this.f440996e);
        }

        public a() {
            this.f440992a = "";
            this.f440993b = new ArrayList();
            this.f440994c = "";
            this.f440995d = IFileMigration.MigrationPriority.WHEN_WRITE;
            this.f440996e = IFileMigration.MigrationStrategy.AUTO;
        }
    }

    public final int hashCode() {
        return ((String) this.f440991e.getValue()).hashCode();
    }

    public final String toString() {
        return this.f440987a + '-' + ((String) this.f440991e.getValue());
    }

    @Override // com.ss.android.lark.storage.file.migration.IFileMigration
    public final String[] a() {
        return this.f440988b;
    }

    @Override // com.ss.android.lark.storage.file.migration.IFileMigration
    public final String b() {
        return this.f440989c;
    }

    @Override // com.ss.android.lark.storage.file.migration.IFileMigration
    public final IFileMigration.MigrationStrategy getStrategy() {
        return this.f440990d;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(c.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.storage.file.migration.FileMigration");
        if (Intrinsics.areEqual((String) this.f440991e.getValue(), (String) ((c) r100).f440991e.getValue()) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public c(String r100, String[] r101, String r102, IFileMigration.MigrationPriority r103, IFileMigration.MigrationStrategy r104) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "srcPaths");
        Intrinsics.checkNotNullParameter(r102, "destDir");
        Intrinsics.checkNotNullParameter(r103, "priority");
        Intrinsics.checkNotNullParameter(r104, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f440987a = r100;
        this.f440988b = r101;
        this.f440989c = r102;
        this.f440990d = r104;
        this.f440991e = LazyKt.lazy(new FileMigration$lazyUniqueId$2(this));
    }
}
