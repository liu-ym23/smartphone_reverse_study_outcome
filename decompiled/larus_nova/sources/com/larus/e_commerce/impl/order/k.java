package com.larus.e_commerce.impl.order;

import com.larus.utils.t0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k implements com.larus.e_commerce.api.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f342451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f342452b;

    @Override // com.larus.e_commerce.api.h
    public final void a() {
        Intrinsics.checkNotNullParameter("ecommerce plugin init failed", "reason");
        final Function1<String, Unit> r100 = this.f342452b;
        t0.e(new j(r100));
    }

    @Override // com.larus.e_commerce.api.h
    public final void onInitSuccess() {
        final Function0<Unit> r100 = this.f342451a;
        t0.e(new i(r100));
    }

    public k(g r100, h r101) {
        this.f342451a = r100;
        this.f342452b = r101;
    }
}
