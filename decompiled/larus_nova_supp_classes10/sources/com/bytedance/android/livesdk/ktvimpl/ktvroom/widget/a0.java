package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ KtvMvControlAreaWidget a;

    public a0(KtvMvControlAreaWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        List r3 = (List) r2;
        KtvMvControlAreaWidget r4 = this.a;
        r4.Eq(com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.e(r4.q));
    }
}
