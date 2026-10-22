package com.larus.login.impl.agegate;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: classes30.dex */
public final class w implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AgeGateManager f357357a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        s38.b r100 = this.f357357a.f357297a;
        if (r100 == null) goto L6;
        r100.A(0);
        return;
    }

    public w(AgeGateManager r100) {
        this.f357357a = r100;
    }
}
