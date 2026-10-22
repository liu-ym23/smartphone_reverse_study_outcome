package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.l(((Boolean) r2).booleanValue());
    }
}
