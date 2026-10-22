package com.larus.audio.call.arch;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LLMCallController f289066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f289067b;

    public /* synthetic */ i(LLMCallController r100, long r101) {
        this.f289066a = r100;
        this.f289067b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Boolean.valueOf(this.f289066a.E(this.f289067b));
    }
}
