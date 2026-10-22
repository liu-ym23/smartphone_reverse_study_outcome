package com.bytedance.android.shopping.card_list.eventcenter.event;

import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements Action {
    public final /* synthetic */ Function1 a;

    public i(Function1 r1) {
        this.a = r1;
    }

    public final void run() {
        Function1 r0 = this.a;
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r0.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
