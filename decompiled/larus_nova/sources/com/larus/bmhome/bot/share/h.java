package com.larus.bmhome.bot.share;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class h implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Continuation<Boolean> f296750a;

    public h(SafeContinuation r100) {
        this.f296750a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean r100) {
        Boolean r101 = Boolean.valueOf(r100.booleanValue());
        this.f296750a.resumeWith(Result.m9449constructorimpl(r101));
        return Unit.INSTANCE;
    }
}
