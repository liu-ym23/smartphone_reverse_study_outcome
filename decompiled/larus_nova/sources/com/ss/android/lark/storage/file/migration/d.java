package com.ss.android.lark.storage.file.migration;

import com.ss.android.lark.vfs.VFSPath;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f440997a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<IFileMigration> f440998b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, IFileMigration> f440999c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IFileMigration f441000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f441001b;

        public a(IFileMigration r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "migration");
            Intrinsics.checkNotNullParameter(r101, "targetPath");
            Intrinsics.checkNotNullParameter(r102, "srcPath");
            this.f441000a = r100;
            this.f441001b = r102;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441002a = null;

        static {
            int[] r100 = new int[IFileMigration.MigrationStrategy.values().length];
            r100[IFileMigration.MigrationStrategy.PATH_MAPPING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[IFileMigration.MigrationStrategy.DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[IFileMigration.MigrationStrategy.AUTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f441002a = r100;
        }
    }

    public d() {
    }

    static {
        f440997a = new d();
        f440998b = new ArrayList();
        f440999c = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final synchronized void d(IFileMigration r100) {
        monitor-enter(d.class);
        Intrinsics.checkNotNullParameter(r100, "migration");     // Catch: Throwable -> L9
        List<IFileMigration> r101 = f440998b;     // Catch: Throwable -> L9
        if (((ArrayList) r101).contains(r100) == true) goto L7;
        ((ArrayList) r101).add(r100);     // Catch: Throwable -> L9
        f440999c.put(r100.b(), r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(d.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath a(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        f r101 = (f) r100.getTag("migration_strategy");
        if (r101 == null) goto L9;
        VFSPath r102 = r101.a(r100);
        if (r102 != null) goto L8;
        return r100;
    L8:
        return r102;
    L9:
        return r100;
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath b(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        f r101 = (f) r100.getTag("migration_strategy");
        if (r101 == null) goto L9;
        VFSPath r102 = r101.b(r100);
        if (r102 != null) goto L8;
        return r100;
    L8:
        return r102;
    L9:
        return r100;
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath c(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        f r101 = (f) r100.getTag("migration_strategy");
        if (r101 == null) goto L9;
        VFSPath r102 = r101.c(r100);
        if (r102 != null) goto L8;
        return r100;
    L8:
        return r102;
    L9:
        return r100;
    }
}
