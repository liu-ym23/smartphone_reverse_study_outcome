package com.bytedance.locallife.dito.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements com.bytedance.locallife.dito.helper.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Long, Unit> f257930a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function1<? super Long, Unit> r100) {
        this.f257930a = r100;
    }

    @Override // com.bytedance.locallife.dito.helper.d
    public final void a(long r100) {
        long r101 = Math.min(Math.max(r100, 0), 5000);
        Function1<Long, Unit> r102 = this.f257930a;
        if (r102 == null) goto L6;
        r102.invoke(Long.valueOf(r101));
        return;
    }
}
