package com.larus.bmhome.chat.api;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class h0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f297207a;

    public /* synthetic */ h0(q0 r100) {
        this.f297207a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        com.larus.bmhome.chat.component.cvs.y r100 = this.f297207a.getProvider().u0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }
}
