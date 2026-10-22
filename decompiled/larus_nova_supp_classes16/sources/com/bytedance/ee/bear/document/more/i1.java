package com.bytedance.ee.bear.document.more;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i1<T> implements Consumer {
    public static final i1<T> a = null;

    static {
        a = new i1();
    }

    public i1() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "throwable");
        tt5.a.d("OfficeMoreProvider", "updateWikiPerm error: " + r4);
    }
}
