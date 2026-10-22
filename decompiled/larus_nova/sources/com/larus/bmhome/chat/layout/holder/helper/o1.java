package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.im.callback.IMError;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o1 implements mf9.a<mf9.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<mf9.c> f303675a;

    public o1(kotlinx.coroutines.j r100) {
        this.f303675a = r100;
    }

    @Override // mf9.a
    public final void a(IMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if (this.f303675a.isActive() == false) goto L6;
        kotlinx.coroutines.i<mf9.c> r101 = this.f303675a;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new Exception(r100.getException()))));
        FLogger.f375446a.i("MessageCopyHelper", "getDeepResearchResource onFailure");
        return;
    }

    @Override // mf9.a
    public final void b(mf9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        if (this.f303675a.isActive() == false) goto L6;
        this.f303675a.resumeWith(Result.m9449constructorimpl(r100));
        FLogger.f375446a.i("MessageCopyHelper", "getDeepResearchResource loadFromLocal");
        return;
    }

    @Override // mf9.a
    public final void onSuccess(mf9.c r100) {
        mf9.c r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        if (this.f303675a.isActive() == false) goto L6;
        this.f303675a.resumeWith(Result.m9449constructorimpl(r101));
        FLogger.f375446a.i("MessageCopyHelper", "getDeepResearchResource success");
        return;
    }
}
