package com.larus.share.impl.sdk;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes31.dex */
public final class c implements Function1<String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<String> f368735a;

    public c(j r100) {
        this.f368735a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String r100) {
        String r101 = r100;
        if (this.f368735a.isActive() == false) goto L6;
        this.f368735a.resumeWith(Result.m9449constructorimpl(r101));
    L6:
        return Unit.INSTANCE;
    }
}
