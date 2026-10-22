package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class q4 extends RxAttributedElementImpl {
    public q4() {
        int r100 = l5.f405179a;
        RelaxInstance.Companion.getClass();
        RelaxInstance r101 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r101);
        if (r101.rtsPipelineEnabled() == false) goto L5;
        Long r102 = null;
    L6:
        super("anchor", r102);
        return;
    L5:
        r102 = Long.valueOf(qpa.d.c());
        goto L6
    }
}
