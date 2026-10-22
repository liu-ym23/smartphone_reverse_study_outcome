package com.larus.livetutor.impl.rtc.handler;

import com.larus.livetutor.api.idl.UserAsrEndMsg;
import com.larus.livetutor.impl.repository.viewmodel.b0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class i implements jj9.a<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<UserAsrEndMsg, Unit> f356341a;

    public i(b0 r100) {
        this.f356341a = r100;
    }

    @Override // jj9.a
    public final /* bridge */ /* synthetic */ void onSuccess(Long r100) {
        r100.longValue();
    }

    @Override // jj9.a
    public final void onFail(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Function1<UserAsrEndMsg, Unit> r102 = this.f356341a;
        if (r102 == null) goto L6;
        r102.invoke(null);
        return;
    }
}
