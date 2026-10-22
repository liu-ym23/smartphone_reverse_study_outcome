package com.ss.android.lark.integrator.ccm.spacekit;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements Consumer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean[] f427906a;

    public m(boolean[] r100) {
        this.f427906a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Boolean r100) throws Exception {
        Boolean r101 = r100;
        boolean[] r102 = this.f427906a;
        if (r102[0] == false) goto L5;
    L8:
        boolean r103 = true;
    L9:
        r102[0] = r103;
        return;
    L5:
        if (r101.booleanValue() == true) goto L8;
        r103 = false;
        goto L9
    }
}
