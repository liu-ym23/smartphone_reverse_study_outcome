package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ KtvComponentTopBarControlContainer a;

    public h(KtvComponentTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        sh6.b r3 = (sh6.b) r2;
        if (ChorusContext.Companion.c() == false) goto L6;
        KtvComponentTopBarControlContainer r4 = this.a;
        int r0 = KtvComponentTopBarControlContainer.u;
        r4.j();
        KtvComponentTopBarControlContainer r5 = this.a;
        KtvContext.Companion.getClass();
        r5.i(KtvContext.a.g().isCurrentUserIsSinger());
        return;
    }
}
