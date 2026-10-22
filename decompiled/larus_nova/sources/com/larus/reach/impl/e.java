package com.larus.reach.impl;

import com.larus.platform.api.p2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f367194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineDispatcher f367195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableSharedFlow<ns9.p> f367196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f367197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p2 f367198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super byte[], Unit> f367199f;

    public static final class a {
    }

    static {
    }

    private final void registerReceiver() {
        this.f367199f = new d(this);
    }

    public e(CoroutineScope r100, ExecutorCoroutineDispatcher r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "emitDispatcher");
        this.f367194a = r100;
        this.f367195b = r101;
        this.f367196c = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f367197d = new m();
        registerReceiver();
    }
}
