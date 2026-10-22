package com.larus.bmhome.bot;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class o5 implements com.larus.common_ui.dialog.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f296671a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        Function1<Boolean, Unit> r100 = this.f296671a;
        if (r100 == null) goto L6;
        r100.invoke(Boolean.TRUE);
        return;
    }

    public o5(n0 r100) {
        this.f296671a = r100;
    }
}
