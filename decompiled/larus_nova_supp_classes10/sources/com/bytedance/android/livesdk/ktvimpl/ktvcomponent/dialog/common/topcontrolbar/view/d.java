package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ KtvComponentTopBarControlContainer a;

    public d(KtvComponentTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        KtvComponentTopBarControlContainer r4 = this.a;
        int r0 = KtvComponentTopBarControlContainer.u;
        r4.j();
        KtvComponentTopBarControlContainer r5 = this.a;
        KtvContext.Companion.getClass();
        r5.i(KtvContext.a.g().isCurrentUserIsSinger());
    }
}
