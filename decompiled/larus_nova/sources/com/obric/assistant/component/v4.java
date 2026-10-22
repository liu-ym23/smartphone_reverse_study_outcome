package com.obric.assistant.component;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class v4 implements com.larus.common_ui.dialog.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f388970a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        Function0<Unit> r100 = this.f388970a;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public v4(q4 r100) {
        this.f388970a = r100;
    }
}
