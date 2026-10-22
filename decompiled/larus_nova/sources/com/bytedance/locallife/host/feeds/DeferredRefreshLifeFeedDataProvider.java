package com.bytedance.locallife.host.feeds;

import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class DeferredRefreshLifeFeedDataProvider implements cy6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cy6.a f258864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f258865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f258866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f258867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Single<cy6.d> f258868e;

    @Override // cy6.a
    public final Single<cy6.d> a() {
        Object r100 = this.f258866c;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f258867d == false) goto L7;
        Single<cy6.d> r101 = this.f258864a.a();     // Catch: Throwable -> L10
        final DeferredRefreshLifeFeedDataProvider$loadMore$1$1 r102 = new DeferredRefreshLifeFeedDataProvider$loadMore$1$1(this);     // Catch: Throwable -> L10
        Single<cy6.d> r103 = r101.map(new a(r102));     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);
        return r103;
    L7:
        r103 = c();     // Catch: Throwable -> L10
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.locallife.host.feeds.c] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.locallife.host.feeds.e] */
    public final Single<cy6.d> c() {
        Single<cy6.d> r100 = this.f258868e;
        if (r100 != null) goto L6;
        Single<cy6.d> r101 = this.f258864a.refresh();
        final DeferredRefreshLifeFeedDataProvider$getOrCreateFirstPageRequestLocked$1 r102 = new DeferredRefreshLifeFeedDataProvider$getOrCreateFirstPageRequestLocked$1(this);
        Single<R> r103 = r101.map(new b(r102));
        final ?? r104 = new c(this);
        Single r105 = r103.doOnSuccess(new d(r104));
        final ?? r106 = new e(this);
        Single<cy6.d> r107 = r105.doOnError(new f(r106)).cache();
        this.f258868e = r107;
        return r107;
    L6:
        return r100;
    }

    @Override // cy6.a
    public final boolean hasMore() {
        return this.f258864a.hasMore();
    }

    @Override // cy6.a
    public final Single<cy6.d> refresh() {
        Object r100 = this.f258866c;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f258867d == false) goto L7;
        Single<cy6.d> r101 = this.f258864a.refresh();     // Catch: Throwable -> L10
        final DeferredRefreshLifeFeedDataProvider$refresh$1$1 r102 = new DeferredRefreshLifeFeedDataProvider$refresh$1$1(this);     // Catch: Throwable -> L10
        Single<cy6.d> r103 = r101.map(new g(r102));     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);
        return r103;
    L7:
        r103 = c();     // Catch: Throwable -> L10
        goto L8
    }

    @Override // cy6.a
    public final void release() {
        this.f258864a.release();
    }

    public DeferredRefreshLifeFeedDataProvider(cy6.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "enterAwemeId");
        this.f258864a = r100;
        this.f258865b = r101;
        this.f258866c = new Object();
    }

    public static final cy6.d b(DeferredRefreshLifeFeedDataProvider r100, cy6.d r101) {
        r100.getClass();
        List<cy6.b> r102 = r101.f465796a;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((cy6.b) r105).f465789a, r100.f258865b) == true) goto L4;
        r103.add(r105);
        goto L4
    L8:
        boolean r106 = r101.f465797b;
        long r107 = r101.f465798c;
        String r108 = r101.f465799d;
        Object r109 = r101.f465800e;
        Intrinsics.checkNotNullParameter(r103, "awemeList");
        return new cy6.d(r103, r106, r107, r108, r109);
    }
}
