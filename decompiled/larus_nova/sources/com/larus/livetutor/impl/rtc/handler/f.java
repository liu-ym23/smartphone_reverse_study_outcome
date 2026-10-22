package com.larus.livetutor.impl.rtc.handler;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements jj9.a<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f356338a;

    public f(com.larus.livetutor.impl.tutor.controller.u r100) {
        this.f356338a = r100;
    }

    @Override // jj9.a
    public final void onSuccess(Long r100) {
        r100.longValue();
        Function1<Boolean, Unit> r101 = this.f356338a;
        if (r101 == null) goto L6;
        r101.invoke(Boolean.TRUE);
        return;
    }

    @Override // jj9.a
    public final void onFail(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Function1<Boolean, Unit> r102 = this.f356338a;
        if (r102 == null) goto L6;
        r102.invoke(Boolean.FALSE);
        return;
    }
}
