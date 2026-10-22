package com.larus.dora.impl.feedback;

import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes27.dex */
public final class k implements ff7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Unit> f335641a;

    @Override // ff7.e
    public final void onSuccess() {
        pk4.j.d("DoraGFeedbackViewModel", "Device log upload success");
        kotlinx.coroutines.i<Unit> r100 = this.f335641a;
        Result.Companion r101 = Result.Companion;
        r100.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
    }

    public k(kotlinx.coroutines.j r100) {
        this.f335641a = r100;
    }

    @Override // ff7.e
    public final void onFail(String r100) {
        pk4.j.b("DoraGFeedbackViewModel", "Device log upload failed, msg = " + r100);
        kotlinx.coroutines.i<Unit> r101 = this.f335641a;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new IOException("Device log upload failed, msg = " + r100))));
    }
}
