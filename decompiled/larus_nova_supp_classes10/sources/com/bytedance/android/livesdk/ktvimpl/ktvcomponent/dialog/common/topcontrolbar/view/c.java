package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ KtvComponentTopBarControlContainer a;

    public c(KtvComponentTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        KtvComponentTopBarControlContainer r5 = this.a;
        KtvContext.Companion.getClass();
        boolean r0 = KtvContext.a.g().isCurrentUserIsSinger();
        int r1 = KtvComponentTopBarControlContainer.u;
        r5.i(r0);
    }
}
