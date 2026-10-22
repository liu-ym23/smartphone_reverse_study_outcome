package com.obric.assistant.component;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class u4 implements com.larus.common_ui.dialog.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f388959a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        Function0<Unit> r100 = this.f388959a;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public u4(p4 r100) {
        this.f388959a = r100;
    }
}
