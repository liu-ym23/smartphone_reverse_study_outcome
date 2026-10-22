package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public h(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.invoke(sh6.c.b((sh6.b) r2));
    }
}
