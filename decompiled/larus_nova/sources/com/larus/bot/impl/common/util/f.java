package com.larus.bot.impl.common.util;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes26.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Flow<T> f317679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f317680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableSharedFlow<T> f317681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 f317682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f317683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a<T> f317684f;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f317685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Job f317686b;

        public a(T r100) {
            this.f317685a = r100;
        }
    }

    public f(MutableSharedFlow r100) {
        Intrinsics.checkNotNullParameter(r100, "upstream");
        this.f317679a = r100;
        this.f317680b = 500;
        MutableSharedFlow<T> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f317681c = r101;
        this.f317682d = new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(new SharedFlowThrottleLatest$downstream$1(this, null), r101);
    }
}
