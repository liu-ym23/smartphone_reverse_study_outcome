package com.larus.bmhome.instruction.handler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c0 extends i {
    public c0(com.larus.bmhome.instruction.p r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionCoreAbility");
        super(r100);
    }

    @Override // com.larus.bmhome.instruction.handler.m
    public final void a(com.larus.bmhome.instruction.n r100) {
        Intrinsics.checkNotNullParameter(r100, "inputData");
        if (r100.f312185c == true) goto L8;
        com.larus.bmhome.instruction.g r101 = (com.larus.bmhome.instruction.g) this.f312100f.getValue();
        if (r101 == null) goto L9;
        com.larus.bmhome.instruction.g.a.e(r101, null, 1, r100.f312184b, 5, 1);
        return;
    L9:
        return;
    }
}
