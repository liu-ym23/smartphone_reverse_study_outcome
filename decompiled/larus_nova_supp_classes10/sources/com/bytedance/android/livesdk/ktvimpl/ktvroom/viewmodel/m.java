package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ k a;

    public m(k r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.l((List) sh6.c.b((sh6.b) r2));
    }
}
