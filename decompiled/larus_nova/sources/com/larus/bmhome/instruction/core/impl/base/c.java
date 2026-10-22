package com.larus.bmhome.instruction.core.impl.base;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aq8.d f311935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f311936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f311937c;

    public c(aq8.d r100, CoroutineScope r101, dq8.g r102, i r103) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "eventSink");
        this.f311935a = r100;
        this.f311936b = r101;
        this.f311937c = r103;
    }
}
