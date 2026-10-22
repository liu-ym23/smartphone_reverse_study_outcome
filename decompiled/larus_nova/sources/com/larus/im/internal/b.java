package com.larus.im.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f347508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<T, Pair<Job, Long>> f347509b;

    public b(CoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f347508a = r100;
        this.f347509b = new LinkedHashMap();
    }
}
