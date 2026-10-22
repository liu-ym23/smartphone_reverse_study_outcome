package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        c r4 = this.a;
        KtvContext.Companion.getClass();
        r4.a(KtvContext.a.g().isCurrentUserIsSinger());
    }
}
