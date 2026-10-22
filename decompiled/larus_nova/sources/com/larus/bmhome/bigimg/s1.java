package com.larus.bmhome.bigimg;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class s1 implements Function1<String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<String> f296062a;

    public s1(kotlinx.coroutines.j r100) {
        this.f296062a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String r100) {
        String r101 = r100;
        if (this.f296062a.isActive() == false) goto L6;
        this.f296062a.resumeWith(Result.m9449constructorimpl(r101));
    L6:
        return Unit.INSTANCE;
    }
}
