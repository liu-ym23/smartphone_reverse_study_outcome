package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ l a;

    public h(l r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.i.setSelected(((Boolean) r2).booleanValue());
    }
}
