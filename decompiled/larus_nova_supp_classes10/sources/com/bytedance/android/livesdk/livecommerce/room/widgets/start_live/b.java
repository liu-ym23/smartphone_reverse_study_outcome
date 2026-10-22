package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import android.content.Context;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import xi2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Context b;

    public b(Function1 r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        d0 r3 = (d0) r2;
        if (r3 != null) goto L5;
    L9:
        Context r4 = this.b;
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r4, th.a.g(r4, 2131896654));
        return;
    L5:
        if (((com.bytedance.android.ec.model.g) r3).statusCode != 0) goto L9;
        if (r3.a() == null) goto L9;
        this.a.invoke(r3.a());
    }
}
