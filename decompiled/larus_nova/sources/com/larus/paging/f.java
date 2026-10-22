package com.larus.paging;

import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SubscribedSharedFlow;

/* JADX INFO: loaded from: classes29.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlattenedPageController<T> f363830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableSharedFlow<IndexedValue<PageEvent<T>>> f363831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SubscribedSharedFlow f363832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Job f363833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kotlinx.coroutines.flow.c1 f363834e;

    public f(FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r110, CoroutineScope r111) {
        Intrinsics.checkNotNullParameter(r110, "src");
        Intrinsics.checkNotNullParameter(r111, "scope");
        this.f363830a = new FlattenedPageController();
        MutableSharedFlow<IndexedValue<PageEvent<T>>> r100 = SharedFlowKt.MutableSharedFlow(1, Integer.MAX_VALUE, BufferOverflow.SUSPEND);
        this.f363831b = r100;
        this.f363832c = new SubscribedSharedFlow(r100, new CachedPageEventFlow$sharedForDownstream$1(this, null));
        Job r112 = BuildersKt.launch$default(r111, null, CoroutineStart.LAZY, new CachedPageEventFlow$job$1(r110, this, null), 1, null);
        r112.invokeOnCompletion(new CachedPageEventFlow$job$2$1(this));
        this.f363833d = r112;
        this.f363834e = new kotlinx.coroutines.flow.c1(new CachedPageEventFlow$downstreamFlow$1(this, null));
    }
}
