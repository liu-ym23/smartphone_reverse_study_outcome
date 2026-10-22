package com.bytedance.ee.bear.list.more.more3;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z<T> implements Consumer {
    public static final z<T> a = null;

    static {
        a = new z();
    }

    public z() {
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        tt5.a.e("V1SpaceFolderMoreProvider", "shortcutUserPermissionFlow err. ", r5, false);
    }
}
