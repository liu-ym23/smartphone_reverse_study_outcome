package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.bytedance.android.livesdk.livecommerce.utils.k;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Map a;
    public final /* synthetic */ Function1 b;

    public d(Map r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        this.b.invoke(k.e(k.c(((pk2.f) r3).a), Boolean.TRUE));
    }
}
