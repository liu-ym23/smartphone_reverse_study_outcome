package com.larus.login.impl.multiaccount;

import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import tx9.g2;

/* JADX INFO: loaded from: classes30.dex */
public final class z implements com.larus.common_ui.dialog.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiAccountFragment f358165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q38.b f358166b;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        this.f358165a.getClass();
        if (this.f358166b.l() == false) goto L5;
        String r100 = "enterprise";
    L6:
        g2.f("cancel", r100, this.f358166b.j());
        return;
    L5:
        r100 = WikiSpaceType.PERSONAL;
        goto L6
    }

    public z(MultiAccountFragment r100, q38.b r101) {
        this.f358165a = r100;
        this.f358166b = r101;
    }
}
