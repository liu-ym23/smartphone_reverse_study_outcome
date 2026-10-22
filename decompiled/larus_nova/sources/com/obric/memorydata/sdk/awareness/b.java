package com.obric.memorydata.sdk.awareness;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f397104a;

    public /* synthetic */ b(e.a r100) {
        this.f397104a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        e.a r100 = this.f397104a;
        Context r101 = r100.getContext();
        if (r101 == null) goto L5;
        r101.unbindService(r100.f397124b);
        return Unit.INSTANCE;
    L5:
        return null;
    }
}
