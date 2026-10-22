package com.larus.voicecall.impl.tracer;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class c0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceCallTraceLogger f379131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f379132b;

    public /* synthetic */ c0(VoiceCallTraceLogger r100, z r101) {
        this.f379131a = r100;
        this.f379132b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f379131a.d(this.f379132b);
        return Unit.INSTANCE;
    }
}
