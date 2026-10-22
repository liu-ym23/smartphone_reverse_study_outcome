package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ KtvComponentTopBarControlContainer a;

    public k(KtvComponentTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        UserAttr r3 = (UserAttr) r2;
        KtvComponentTopBarControlContainer r4 = this.a;
        int r0 = KtvComponentTopBarControlContainer.u;
        r4.j();
        KtvComponentTopBarControlContainer r5 = this.a;
        KtvContext.Companion.getClass();
        r5.i(KtvContext.a.g().isCurrentUserIsSinger());
    }
}
