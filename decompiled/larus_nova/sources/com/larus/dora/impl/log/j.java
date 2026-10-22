package com.larus.dora.impl.log;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends q {
    @Override // com.larus.dora.impl.log.q, sk4.d
    public final void j(int r100) {
    }

    @Override // com.larus.dora.impl.log.q, sk4.d
    public final void w(int r100, int r101) {
    }

    public j() {
    }

    @Override // com.larus.dora.impl.log.q, sk4.d
    public final void e(int r100, int r101, int r102, int r103, int r104, String r105, String r106) {
        g49.d.d("DoraLogManager", "onVoiceWakeUp, state:" + r100 + ", mode:" + r101 + ", query:" + r102);
        if (r102 != 1) goto L5;
        DoraLogManager.f336056l = false;
        return;
    L5:
        if (r102 != 2) goto L11;
        DoraLogManager.f336056l = true;
        return;
    }
}
