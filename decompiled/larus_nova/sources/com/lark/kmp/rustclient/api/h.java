package com.lark.kmp.rustclient.api;

import com.bytedance.lark.sdk.InvokeResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes24.dex */
public final class h<Resp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f282458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f282459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a<Resp> f282460c;

    public final Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> b(a<Resp> r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        if (this.f282459b >= this.f282458a.size()) goto L7;
        h<Resp> r101 = new h(this.f282458a, this.f282459b + 1, r100);
        return ((g) ListProtector.get(this.f282458a, this.f282459b)).a(r101);
    L7:
        throw new IllegalStateException("Interceptor chain exhausted");
    }

    public final Object a(a<Resp> r100, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, Resp>> r101) {
        if (this.f282459b >= this.f282458a.size()) goto L7;
        h<Resp> r102 = new h(this.f282458a, this.f282459b + 1, r100);
        return ((g) ListProtector.get(this.f282458a, this.f282459b)).b(r102, r101);
    L7:
        throw new IllegalStateException("Interceptor chain exhausted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends g> r100, int r101, a<Resp> r102) {
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        Intrinsics.checkNotNullParameter(r102, "input");
        this.f282458a = r100;
        this.f282459b = r101;
        this.f282460c = r102;
    }
}
