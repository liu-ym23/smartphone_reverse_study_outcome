package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ KtvComponentTopBarControlContainer a;

    public m(KtvComponentTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        List r3 = (List) r2;
        KtvComponentTopBarControlContainer r4 = this.a;
        int r0 = KtvComponentTopBarControlContainer.u;
        r4.j();
        KtvComponentTopBarControlContainer r5 = this.a;
        KtvContext.Companion.getClass();
        r5.i(KtvContext.a.g().isCurrentUserIsSinger());
    }
}
