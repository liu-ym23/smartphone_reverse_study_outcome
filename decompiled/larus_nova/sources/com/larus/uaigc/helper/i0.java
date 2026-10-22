package com.larus.uaigc.helper;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes31.dex */
public final class i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Flow<T> f373023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f373024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableSharedFlow<T> f373025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 f373026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f373027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a<T> f373028f;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f373029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Job f373030b;

        public a(T r100) {
            this.f373029a = r100;
        }
    }

    public i0(MutableSharedFlow r100) {
        Intrinsics.checkNotNullParameter(r100, "upstream");
        this.f373023a = r100;
        this.f373024b = 500;
        MutableSharedFlow<T> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f373025c = r101;
        this.f373026d = new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(new SharedFlowThrottleLatest$downstream$1(this, null), r101);
    }
}
