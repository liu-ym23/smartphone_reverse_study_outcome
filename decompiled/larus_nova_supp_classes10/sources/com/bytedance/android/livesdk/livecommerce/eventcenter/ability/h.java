package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public h(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        xi2.q r2 = (xi2.q) r1;
        if (r2 != null) goto L5;
        return;
    L5:
        if (((com.bytedance.android.ec.model.g) r2).statusCode != 0) goto L11;
        Function0 r3 = this.a;
        if (r3 == null) goto L12;
        Unit r4 = (Unit) r3.invoke();
        return;
    L12:
        return;
    }
}
