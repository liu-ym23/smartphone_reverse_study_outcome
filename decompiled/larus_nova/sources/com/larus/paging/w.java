package com.larus.paging;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;

/* JADX INFO: loaded from: classes29.dex */
public final class w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f363929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0<T> f363930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f<T> f363931c;

    public w() {
        throw null;
    }

    public w(CoroutineScope r100, k0 r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "parent");
        this.f363929a = r100;
        this.f363930b = r101;
        Flow<PageEvent<T>> r102 = r101.f363875a;
        this.f363931c = new f(new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(new MulticastedPagingData$accumulated$1(this, null), r102), new MulticastedPagingData$accumulated$2(this, null)), r100);
    }
}
