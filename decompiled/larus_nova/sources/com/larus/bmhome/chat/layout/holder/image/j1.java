package com.larus.bmhome.chat.layout.holder.image;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class j1 implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Continuation<Boolean> f303842a;

    public j1(SafeContinuation r100) {
        this.f303842a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean r100) {
        Boolean r101 = Boolean.valueOf(r100.booleanValue());
        this.f303842a.resumeWith(Result.m9449constructorimpl(r101));
        return Unit.INSTANCE;
    }
}
