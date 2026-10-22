package com.larus.sheet.operation;

import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements nc5.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<Boolean> f369078a;

    public d(j r100) {
        this.f369078a = r100;
    }

    @Override // nc5.a
    public final void onFailure(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if (this.f369078a.isActive() == false) goto L6;
        i<Boolean> r101 = this.f369078a;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
        return;
    }

    @Override // nc5.a
    public final void onSuccess(Boolean r100) {
        boolean r101 = r100.booleanValue();
        if (this.f369078a.isActive() == false) goto L6;
        Boolean r102 = Boolean.valueOf(r101);
        this.f369078a.resumeWith(Result.m9449constructorimpl(r102));
        return;
    }
}
