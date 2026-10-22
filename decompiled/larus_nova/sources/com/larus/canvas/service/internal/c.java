package com.larus.canvas.service.internal;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes26.dex */
public abstract class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ny8.d<T> f323833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f323834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f323835c;

    public c(ny8.d<T> r100) {
        this.f323833a = r100;
        this.f323834b = LazyKt.lazy(new a());
        this.f323835c = LazyKt.lazy(new b());
    }
}
