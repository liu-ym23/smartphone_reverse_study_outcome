package com.bytedance.dorax.kmp;

import com.bytedance.dorax.kmp.callback.DoraXRetCode;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hl4.c f204760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i<Integer> f204761b;

    public final void a(DoraXRetCode r100) {
        Intrinsics.checkNotNullParameter(r100, "code");
        int r101 = ll4.a.f509676a;
        ll4.a.b("DoraNativeInterop", "onResult received for event: " + Reflection.getOrCreateKotlinClass(this.f204760a.getClass()).getSimpleName() + ", code: " + r100.getCode() + ", data size: 0");
        if (this.f204761b.isActive() == false) goto L6;
        i<Integer> r102 = this.f204761b;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(Integer.valueOf(r100.getCode())));
        return;
    }

    public b(hl4.c r100, j r101) {
        this.f204760a = r100;
        this.f204761b = r101;
    }
}
