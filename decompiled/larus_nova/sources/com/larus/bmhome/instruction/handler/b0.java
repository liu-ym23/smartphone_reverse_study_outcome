package com.larus.bmhome.instruction.handler;

import com.larus.bmhome.instruction.w1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b0 extends i {
    public b0(com.larus.bmhome.instruction.p r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionCoreAbility");
        super(r100);
    }

    @Override // com.larus.bmhome.instruction.handler.m
    public final void a(com.larus.bmhome.instruction.n r100) {
        Intrinsics.checkNotNullParameter(r100, "inputData");
        if (r100.f312185c == false) goto L5;
        w1.b("PromptToImageHandler", "PromptToImageHandler  autoSend is not available now");
        return;
    L5:
        com.larus.bmhome.instruction.g r101 = (com.larus.bmhome.instruction.g) this.f312100f.getValue();
        if (r101 == null) goto L10;
        com.larus.bmhome.instruction.g.a.e(r101, null, 4, r100.f312184b, 5, 1);
        return;
    }
}
