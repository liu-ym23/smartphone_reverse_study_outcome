package com.bytedance.android.livesdk.ktvimpl.ksong.base.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ KtvComponentFeedView a;

    public a(KtvComponentFeedView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        this.a.setVisibility(8);
    }
}
