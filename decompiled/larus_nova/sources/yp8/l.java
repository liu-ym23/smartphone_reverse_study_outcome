package yp8;

import com.larus.bmhome.instruction.core.impl.controller.TranslatorController;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements com.larus.bmhome.instruction.core.impl.base.f {
    @Override // com.larus.bmhome.instruction.core.impl.base.f
    public final String f() {
        return "TranslatorCreator";
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.f
    public final int p() {
        return 5;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.f
    public final com.larus.bmhome.instruction.core.impl.base.e d() {
        return new TranslatorController();
    }

    public l() {
    }
}
