package com.larus.dora.impl.device.settings.unbind;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraUnbindFragment f334941a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        int r100 = j49.a.f497373a;
        j49.a.h();
        ((DoraUnbindViewModel) this.f334941a.f334929h.getValue()).unbind();
    }

    public d(DoraUnbindFragment r100) {
        this.f334941a = r100;
    }
}
