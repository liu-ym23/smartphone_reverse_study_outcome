package com.bytedance.android.livesdk.ktvimpl.base;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ i a;

    public k(i r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        i r0 = this.a;
        r0.k((Map) r2);
    }
}
