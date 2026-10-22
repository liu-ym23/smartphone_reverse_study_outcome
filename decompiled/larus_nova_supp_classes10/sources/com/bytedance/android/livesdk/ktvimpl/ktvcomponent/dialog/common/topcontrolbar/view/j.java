package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ KtvComponentTopBarControlContainer a;

    public j(KtvComponentTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        KtvComponentTopBarControlContainer r0 = this.a;
        int r1 = KtvComponentTopBarControlContainer.u;
        r0.k();
        this.a.i(((Boolean) r3).booleanValue());
    }
}
