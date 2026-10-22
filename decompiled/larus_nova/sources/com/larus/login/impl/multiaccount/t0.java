package com.larus.login.impl.multiaccount;

import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import tx9.g2;

/* JADX INFO: loaded from: classes30.dex */
public final class t0 implements com.larus.common_ui.dialog.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q38.b f358156a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        if (this.f358156a.l() == false) goto L5;
        String r100 = "enterprise";
    L6:
        g2.e("cancel", r100, this.f358156a.j());
        return;
    L5:
        r100 = WikiSpaceType.PERSONAL;
        goto L6
    }

    public t0(q38.b r100) {
        this.f358156a = r100;
    }
}
