package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ KtvMvControlAreaWidget a;

    public b0(KtvMvControlAreaWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        KtvMvControlAreaWidget r0 = this.a;
        boolean r4 = Intrinsics.areEqual((Boolean) r3, Boolean.TRUE);
        int r1 = KtvMvControlAreaWidget.s;
        r0.Cq(r4);
    }
}
