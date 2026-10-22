package com.larus.uaigc.chat.markdown.image.component;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class f implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Continuation<Boolean> f371110a;

    public f(SafeContinuation r100) {
        this.f371110a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean r100) {
        Boolean r101 = Boolean.valueOf(r100.booleanValue());
        this.f371110a.resumeWith(Result.m9449constructorimpl(r101));
        return Unit.INSTANCE;
    }
}
