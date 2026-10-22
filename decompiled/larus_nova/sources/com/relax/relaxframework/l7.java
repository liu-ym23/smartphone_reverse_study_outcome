package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class l7 extends RxElementImpl {
    @Override // com.relax.relaxframework.RxElementImpl
    public final boolean U() {
        return false;
    }

    @Override // com.relax.relaxframework.RxElementImpl
    public final boolean W() {
        return false;
    }

    public l7() {
        int r100 = l5.f405179a;
        RelaxInstance.Companion.getClass();
        RelaxInstance r101 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r101);
        if (r101.rtsPipelineEnabled() == false) goto L5;
        Long r102 = null;
    L6:
        super("wrapper", r102);
        return;
    L5:
        r102 = Long.valueOf(qpa.d.c());
        goto L6
    }
}
