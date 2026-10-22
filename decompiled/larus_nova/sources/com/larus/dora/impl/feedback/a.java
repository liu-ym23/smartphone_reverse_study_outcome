package com.larus.dora.impl.feedback;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Job f335601a;

    public a(Job r100) {
        this.f335601a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        Job.DefaultImpls.cancel$default(this.f335601a, null, 1, null);
        return Unit.INSTANCE;
    }
}
