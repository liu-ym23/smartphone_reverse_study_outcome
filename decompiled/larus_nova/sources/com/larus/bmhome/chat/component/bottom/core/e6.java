package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.outerinput.OuterInputEventHandler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class e6 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoreInputComponent f298491a;

    public /* synthetic */ e6(CoreInputComponent r100) {
        this.f298491a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        OuterInputEventHandler r100 = this.f298491a.G1;
        if (r100 == null) goto L6;
        r100.c();
    L6:
        return Unit.INSTANCE;
    }
}
