package com.bytedance.locallife.host.route;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Function1<String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<String> f258909a;

    public b(j r100) {
        this.f258909a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String r100) {
        String r101 = r100;
        if (this.f258909a.isActive() == false) goto L6;
        this.f258909a.resumeWith(Result.m9449constructorimpl(r101));
    L6:
        return Unit.INSTANCE;
    }
}
