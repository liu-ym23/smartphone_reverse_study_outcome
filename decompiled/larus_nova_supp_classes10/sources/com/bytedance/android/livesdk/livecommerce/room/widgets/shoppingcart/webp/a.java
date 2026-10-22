package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        b r5 = this.a;
        Function2<? super yk2.a, ? super Boolean, Unit> r0 = r5.b;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke(r5, Boolean.valueOf(r5.c));
    L6:
        if (r5.c == false) goto L9;
        r5.f.playAnimation();
        return;
    }
}
