package com.bytedance.awemeopen.appserviceimpl.feed.recommend;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes44.dex */
public final class ListenRecFeedService implements w24.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f198113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<List<r14.c>, com.bytedance.awemeopen.domain.feed.recommend.b, Boolean, List<r14.c>> f198114c;

    @Override // k24.a
    public final void x0() {
    }

    @Override // n24.a
    public final void f() {
        ((com.bytedance.awemeopen.domain.feed.recommend.a) this.f198112a.getValue()).getClass();
    }

    public ListenRecFeedService() {
        this.f198112a = LazyKt.lazy(ListenRecFeedService$recFeedDomain$2.INSTANCE);
        this.f198113b = new a();
        this.f198114c = new ListenRecFeedService$filter$1(this);
    }
}
