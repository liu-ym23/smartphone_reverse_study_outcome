package com.larus.bmhome.chat.component.bottom.core;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class f5 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoreInputComponent f298498a;

    public /* synthetic */ f5(CoreInputComponent r100) {
        this.f298498a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        CoreInputComponent r100 = this.f298498a;
        int r101 = CoreInputComponent.f298338d3;
        com.larus.asr.e2 r102 = r100.l4().Vl();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.vd();
    }
}
