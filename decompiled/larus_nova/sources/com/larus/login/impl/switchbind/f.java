package com.larus.login.impl.switchbind;

import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwitchBindFragment f358246a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        FLogger.f375446a.i("SwitchBindFragment", "cancel in dialog");
        int r100 = h.f358249a;
        h.a("cancel", this.f358246a);
    }

    public f(SwitchBindFragment r100) {
        this.f358246a = r100;
    }
}
