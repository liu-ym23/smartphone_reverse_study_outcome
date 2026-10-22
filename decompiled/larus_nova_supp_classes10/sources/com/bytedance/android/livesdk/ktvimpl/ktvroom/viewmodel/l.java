package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ k a;

    public l(k r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        k r0 = this.a;
        r0.m((List) r2);
    }
}
