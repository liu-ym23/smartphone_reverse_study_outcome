package com.larus.livetutor.impl.rtc;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d0 implements jj9.a<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, String, Unit> f356291a;

    public d0(j0 r100) {
        this.f356291a = r100;
    }

    @Override // jj9.a
    public final void onSuccess(Long r100) {
        long r101 = r100.longValue();
        FLogger.f375446a.i("TutorRTCServiceImpl", "onCallStart onSuccess data = " + r101);
        this.f356291a.invoke(0, null);
    }

    @Override // jj9.a
    public final void onFail(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.e("TutorRTCServiceImpl", "onCallStart onFail error = " + r100 + " msg = " + r101);
        this.f356291a.invoke(Integer.valueOf(r100), r101);
    }
}
