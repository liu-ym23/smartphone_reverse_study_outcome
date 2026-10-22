package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t<T> implements Consumer {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
    }

    public final void accept(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) sh6.c.b((sh6.b) r2), Boolean.TRUE)) == false) goto L8;
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = KtvComponentOrderSongDataContext.Companion.a();
        if (r3 == null) goto L9;
        r3.getOrderedSongList(false);
        return;
    L9:
        return;
    }
}
