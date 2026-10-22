package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ KtvComponentTopBarControlContainer a;

    public e(KtvComponentTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        KtvComponentTopBarControlContainer r0 = this.a;
        int r1 = KtvComponentTopBarControlContainer.u;
        r0.l((com.bytedance.android.livesdk.ktvapi.util.e) r3);
        KtvComponentTopBarControlContainer r4 = this.a;
        KtvContext.Companion.getClass();
        r4.i(KtvContext.a.g().isCurrentUserIsSinger());
    }
}
