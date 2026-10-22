package com.bytedance.android.shopping.card_list.utils;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public c(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        Function0 r3 = this.a;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke();
        return;
    }
}
