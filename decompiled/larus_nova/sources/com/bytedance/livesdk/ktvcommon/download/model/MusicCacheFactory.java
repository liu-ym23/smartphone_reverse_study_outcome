package com.bytedance.livesdk.ktvcommon.download.model;

import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public abstract class MusicCacheFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f255940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.livesdk.ktvcommon.download.api.d f255941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.livesdk.ktvcommon.download.api.c f255942c;

    public static final class a {
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((g) r100).f255984b), Long.valueOf(((g) r101).f255984b));
        }
    }

    static {
    }

    public abstract MusicType getType();

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "directoryPath");
        if (this.f255941b.i(r100) == false) goto L5;
        return;
    L5:
        if (this.f255941b.h(r100) == false) goto L14;
        List<g> r101 = this.f255941b.c(r100);
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.size() <= 100) goto L15;
        final List r102 = CollectionsKt.take(CollectionsKt.sortedWith(r101, new b()), r101.size() - 100);
        this.f255942c.a(new MusicCacheFactory$ensureDirectoryValid$1(this, r102));
        return;
    L15:
        return;
    }

    public final String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        Intrinsics.checkNotNullParameter(r101, "subDir");
        return this.f255940a.f256006a + "/musicPack/" + r100 + '/' + r101 + '/';
    }

    public MusicCacheFactory(p r100, yk6.d r101, yk6.c r102) {
        Intrinsics.checkNotNullParameter(r100, "storageConfig");
        Intrinsics.checkNotNullParameter(r101, "fileOperator");
        Intrinsics.checkNotNullParameter(r102, "fileExecutor");
        this.f255940a = r100;
        this.f255941b = r101;
        this.f255942c = r102;
    }
}
