package com.larus.bmhome.bot;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class p5 implements com.larus.common_ui.dialog.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f296681a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        Function1<Boolean, Unit> r100 = this.f296681a;
        if (r100 == null) goto L6;
        r100.invoke(Boolean.FALSE);
        return;
    }

    public p5(n0 r100) {
        this.f296681a = r100;
    }
}
