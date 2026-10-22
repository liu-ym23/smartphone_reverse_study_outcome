package com.larus.login.api;

import com.larus.platform.api.g5;
import com.larus.platform.api.h5;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c0 implements h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Unit> f357007a;

    public c0(kotlinx.coroutines.j r100) {
        this.f357007a = r100;
    }

    @Override // com.larus.platform.api.h5
    public final void a(g5 r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        if (this.f357007a.isActive() == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("DouYinAuthUtil", "awaitUpdateAuthorizeInfo callback success");
        kotlinx.coroutines.i<Unit> r101 = this.f357007a;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
    }

    @Override // com.larus.platform.api.h5
    public final void onFailure(int r100) {
        if (this.f357007a.isActive() == true) goto L5;
        return;
    L5:
        FLogger.f375446a.e("DouYinAuthUtil", "awaitUpdateAuthorizeInfo callback failed, errorCode=" + r100);
        kotlinx.coroutines.i<Unit> r101 = this.f357007a;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new DouYinLoginScopeUpgradeHelper.UpdateAuthorizeInfoFailedException(r100))));
    }
}
