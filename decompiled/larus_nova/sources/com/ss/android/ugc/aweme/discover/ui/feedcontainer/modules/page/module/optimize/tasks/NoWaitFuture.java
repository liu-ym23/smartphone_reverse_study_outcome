package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/tasks/NoWaitFuture;", "V", "Ljava/util/concurrent/Future;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NoWaitFuture<V> implements Future<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future<V> f450736a;

    @Override // java.util.concurrent.Future
    public final V get() {
        return null;
    }

    @Override // java.util.concurrent.Future
    public final V get(long r100, TimeUnit r101) {
        return null;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f450736a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f450736a.isDone();
    }

    public NoWaitFuture(Future<V> r100) {
        Intrinsics.checkNotNullParameter(r100, "future");
        this.f450736a = r100;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r100) {
        return this.f450736a.cancel(r100);
    }
}
