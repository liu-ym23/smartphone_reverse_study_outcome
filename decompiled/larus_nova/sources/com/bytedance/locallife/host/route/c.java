package com.bytedance.locallife.host.route;

import com.larus.e_commerce.api.h;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<Boolean> f258910a;

    @Override // com.larus.e_commerce.api.h
    public final void a() {
        Intrinsics.checkNotNullParameter("ecommerce plugin init failed", "reason");
        if (this.f258910a.isActive() == false) goto L6;
        i<Boolean> r100 = this.f258910a;
        Result.Companion r101 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
        return;
    }

    @Override // com.larus.e_commerce.api.h
    public final void onInitSuccess() {
        if (this.f258910a.isActive() == false) goto L6;
        i<Boolean> r100 = this.f258910a;
        Result.Companion r101 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(Boolean.TRUE));
        return;
    }

    public c(j r100) {
        this.f258910a = r100;
    }
}
